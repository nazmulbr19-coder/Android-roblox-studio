package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.UByte;

/* loaded from: classes.dex */
public class ZstdInputStreamNoFinalizer extends FilterInputStream {
    private static final int srcBuffSize;
    private final BufferPool bufferPool;
    private long dstPos;
    private boolean frameFinished;
    private boolean isClosed;
    private boolean isContinuous;
    private boolean needRead;
    private final byte[] src;
    private final ByteBuffer srcByteBuffer;
    private long srcPos;
    private long srcSize;
    private final long stream;

    static {
        Native.load();
        srcBuffSize = (int) recommendedDInSize();
    }

    public ZstdInputStreamNoFinalizer(InputStream inputStream) throws IOException {
        this(inputStream, NoPool.INSTANCE);
    }

    public ZstdInputStreamNoFinalizer(InputStream inputStream, BufferPool bufferPool) throws IOException {
        super(inputStream);
        this.dstPos = 0L;
        this.srcPos = 0L;
        this.srcSize = 0L;
        this.needRead = true;
        this.isContinuous = false;
        this.frameFinished = true;
        this.isClosed = false;
        this.bufferPool = bufferPool;
        this.srcByteBuffer = Zstd.getArrayBackedBuffer(bufferPool, srcBuffSize);
        this.src = this.srcByteBuffer.array();
        synchronized (this) {
            this.stream = createDStream();
            initDStream(this.stream);
        }
    }

    private static native long createDStream();

    private native int decompressStream(long j, byte[] bArr, int i, byte[] bArr2, int i2);

    private static native int freeDStream(long j);

    private native int initDStream(long j);

    public static native long recommendedDInSize();

    public static native long recommendedDOutSize();

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int available() throws IOException {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (!this.needRead) {
            return 1;
        }
        return this.in.available();
    }

    @Override // java.io.FilterInputStream, java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        if (this.isClosed) {
            return;
        }
        this.isClosed = true;
        this.bufferPool.release(this.srcByteBuffer);
        freeDStream(this.stream);
        this.in.close();
    }

    public synchronized boolean getContinuous() {
        return this.isContinuous;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read() throws IOException {
        byte[] bArr = new byte[1];
        int i = 0;
        while (i == 0) {
            i = readInternal(bArr, 0, 1);
        }
        if (i != 1) {
            return -1;
        }
        return bArr[0] & UByte.MAX_VALUE;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized int read(byte[] bArr, int i, int i2) throws IOException {
        if (i >= 0) {
            if (i2 <= bArr.length - i) {
                if (i2 == 0) {
                    return 0;
                }
                int i3 = 0;
                while (i3 == 0) {
                    i3 = readInternal(bArr, i, i2);
                }
                return i3;
            }
        }
        throw new IndexOutOfBoundsException("Requested length " + i2 + " from offset " + i + " in buffer of size " + bArr.length);
    }

    int readInternal(byte[] bArr, int i, int i2) throws IOException {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (i < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException("Requested length " + i2 + " from offset " + i + " in buffer of size " + bArr.length);
        }
        int i3 = i + i2;
        this.dstPos = i;
        long j = -1;
        while (this.dstPos < i3 && j < this.dstPos) {
            if (this.needRead && (this.in.available() > 0 || this.dstPos == i)) {
                this.srcSize = this.in.read(this.src, 0, srcBuffSize);
                this.srcPos = 0L;
                if (this.srcSize < 0) {
                    this.srcSize = 0L;
                    if (this.frameFinished) {
                        return -1;
                    }
                    if (!this.isContinuous) {
                        throw new ZstdIOException(Zstd.errCorruptionDetected(), "Truncated source");
                    }
                    this.srcSize = (int) (this.dstPos - i);
                    if (this.srcSize > 0) {
                        return (int) this.srcSize;
                    }
                    return -1;
                }
                this.frameFinished = false;
            }
            long j2 = this.dstPos;
            byte[] bArr2 = bArr;
            int decompressStream = decompressStream(this.stream, bArr2, i3, this.src, (int) this.srcSize);
            if (Zstd.isError(decompressStream)) {
                throw new ZstdIOException(decompressStream);
            }
            if (decompressStream == 0) {
                this.frameFinished = true;
                this.needRead = this.srcPos == this.srcSize;
                return (int) (this.dstPos - i);
            }
            if (this.dstPos < i3) {
                r8 = true;
            }
            this.needRead = r8;
            bArr = bArr2;
            j = j2;
        }
        return (int) (this.dstPos - i);
    }

    public synchronized ZstdInputStreamNoFinalizer setContinuous(boolean z) {
        this.isContinuous = z;
        return this;
    }

    public synchronized ZstdInputStreamNoFinalizer setDict(ZstdDictDecompress zstdDictDecompress) throws IOException {
        zstdDictDecompress.acquireSharedLock();
        try {
            int loadFastDictDecompress = Zstd.loadFastDictDecompress(this.stream, zstdDictDecompress);
            if (Zstd.isError(loadFastDictDecompress)) {
                throw new ZstdIOException(loadFastDictDecompress);
            }
        } finally {
            zstdDictDecompress.releaseSharedLock();
        }
        return this;
    }

    public synchronized ZstdInputStreamNoFinalizer setDict(byte[] bArr) throws IOException {
        int loadDictDecompress = Zstd.loadDictDecompress(this.stream, bArr, bArr.length);
        if (Zstd.isError(loadDictDecompress)) {
            throw new ZstdIOException(loadDictDecompress);
        }
        return this;
    }

    public synchronized ZstdInputStreamNoFinalizer setLongMax(int i) throws IOException {
        int decompressionLongMax = Zstd.setDecompressionLongMax(this.stream, i);
        if (Zstd.isError(decompressionLongMax)) {
            throw new ZstdIOException(decompressionLongMax);
        }
        return this;
    }

    public synchronized ZstdInputStreamNoFinalizer setRefMultipleDDicts(boolean z) throws IOException {
        int refMultipleDDicts = Zstd.setRefMultipleDDicts(this.stream, z);
        if (Zstd.isError(refMultipleDDicts)) {
            throw new ZstdIOException(refMultipleDDicts);
        }
        return this;
    }

    @Override // java.io.FilterInputStream, java.io.InputStream
    public synchronized long skip(long j) throws IOException {
        if (this.isClosed) {
            throw new IOException("Stream closed");
        }
        if (j <= 0) {
            return 0L;
        }
        int recommendedDOutSize = (int) recommendedDOutSize();
        if (recommendedDOutSize > j) {
            recommendedDOutSize = (int) j;
        }
        ByteBuffer arrayBackedBuffer = Zstd.getArrayBackedBuffer(this.bufferPool, recommendedDOutSize);
        long j2 = j;
        try {
            byte[] array = arrayBackedBuffer.array();
            while (j2 > 0) {
                try {
                    int read = read(array, 0, (int) Math.min(recommendedDOutSize, j2));
                    if (read < 0) {
                        break;
                    }
                    j2 -= read;
                } catch (Throwable th) {
                    th = th;
                    this.bufferPool.release(arrayBackedBuffer);
                    throw th;
                }
            }
            this.bufferPool.release(arrayBackedBuffer);
            return j - j2;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}
