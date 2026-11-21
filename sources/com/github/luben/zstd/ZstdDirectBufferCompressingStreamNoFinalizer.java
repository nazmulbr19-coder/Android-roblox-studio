package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ZstdDirectBufferCompressingStreamNoFinalizer implements Closeable, Flushable {
    private int level;
    private final long stream;
    private ByteBuffer target;
    private int consumed = 0;
    private int produced = 0;
    private boolean closed = false;
    private boolean initialized = false;
    private byte[] dict = null;
    private ZstdDictCompress fastDict = null;

    static {
        Native.load();
    }

    public ZstdDirectBufferCompressingStreamNoFinalizer(ByteBuffer byteBuffer, int i) throws IOException {
        this.level = Zstd.defaultCompressionLevel();
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Target buffer should be a direct buffer");
        }
        this.target = byteBuffer;
        this.level = i;
        this.stream = createCStream();
    }

    private native long compressDirectByteBuffer(long j, ByteBuffer byteBuffer, int i, int i2, ByteBuffer byteBuffer2, int i3, int i4);

    private static native long createCStream();

    private native long endStream(long j, ByteBuffer byteBuffer, int i, int i2);

    private native long flushStream(long j, ByteBuffer byteBuffer, int i, int i2);

    private static native long freeCStream(long j);

    private native long initCStream(long j, int i);

    private native long initCStreamWithDict(long j, byte[] bArr, int i, int i2);

    private native long initCStreamWithFastDict(long j, ZstdDictCompress zstdDictCompress);

    private static native long recommendedCOutSize();

    public static int recommendedOutputBufferSize() {
        return (int) recommendedCOutSize();
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0042, code lost:
    
        if (r10.target.isDirect() == false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
    
        if (r5 <= 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0050, code lost:
    
        if (r10.target.hasRemaining() != false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0059, code lost:
    
        throw new java.io.IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x005c, code lost:
    
        if (r5 > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0066, code lost:
    
        throw new java.lang.IllegalArgumentException("Target buffer should be a direct buffer");
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006c, code lost:
    
        throw new com.github.luben.zstd.ZstdIOException(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:?, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0009, code lost:
    
        if (r10.initialized != false) goto L7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x000b, code lost:
    
        r5 = endStream(r10.stream, r10.target, r10.target.position(), r10.target.remaining());
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0024, code lost:
    
        if (com.github.luben.zstd.Zstd.isError(r5) != false) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0026, code lost:
    
        r10.target.position(r10.target.position() + r10.produced);
        r10.target = flushBuffer(r10.target);
     */
    @Override // java.io.Closeable, java.lang.AutoCloseable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void close() throws java.io.IOException {
        /*
            r10 = this;
            boolean r0 = r10.closed
            if (r0 != 0) goto L86
            r1 = 0
            r2 = 0
            r3 = 1
            boolean r0 = r10.initialized     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L6d
        Lb:
            long r5 = r10.stream     // Catch: java.lang.Throwable -> L79
            java.nio.ByteBuffer r7 = r10.target     // Catch: java.lang.Throwable -> L79
            java.nio.ByteBuffer r0 = r10.target     // Catch: java.lang.Throwable -> L79
            int r8 = r0.position()     // Catch: java.lang.Throwable -> L79
            java.nio.ByteBuffer r0 = r10.target     // Catch: java.lang.Throwable -> L79
            int r9 = r0.remaining()     // Catch: java.lang.Throwable -> L79
            r4 = r10
            long r5 = r4.endStream(r5, r7, r8, r9)     // Catch: java.lang.Throwable -> L79
            boolean r0 = com.github.luben.zstd.Zstd.isError(r5)     // Catch: java.lang.Throwable -> L79
            if (r0 != 0) goto L67
            java.nio.ByteBuffer r0 = r10.target     // Catch: java.lang.Throwable -> L79
            java.nio.ByteBuffer r4 = r10.target     // Catch: java.lang.Throwable -> L79
            int r4 = r4.position()     // Catch: java.lang.Throwable -> L79
            int r7 = r10.produced     // Catch: java.lang.Throwable -> L79
            int r4 = r4 + r7
            r0.position(r4)     // Catch: java.lang.Throwable -> L79
            java.nio.ByteBuffer r0 = r10.target     // Catch: java.lang.Throwable -> L79
            java.nio.ByteBuffer r0 = r10.flushBuffer(r0)     // Catch: java.lang.Throwable -> L79
            r10.target = r0     // Catch: java.lang.Throwable -> L79
            java.nio.ByteBuffer r0 = r10.target     // Catch: java.lang.Throwable -> L79
            boolean r0 = r0.isDirect()     // Catch: java.lang.Throwable -> L79
            if (r0 == 0) goto L5f
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 <= 0) goto L5a
            java.nio.ByteBuffer r0 = r10.target     // Catch: java.lang.Throwable -> L79
            boolean r0 = r0.hasRemaining()     // Catch: java.lang.Throwable -> L79
            if (r0 != 0) goto L5a
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L79
            java.lang.String r4 = "The target buffer has no more space, even after flushing, and there are still bytes to compress"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L79
            throw r0     // Catch: java.lang.Throwable -> L79
        L5a:
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 > 0) goto Lb
            goto L6d
        L5f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch: java.lang.Throwable -> L79
            java.lang.String r4 = "Target buffer should be a direct buffer"
            r0.<init>(r4)     // Catch: java.lang.Throwable -> L79
            throw r0     // Catch: java.lang.Throwable -> L79
        L67:
            com.github.luben.zstd.ZstdIOException r0 = new com.github.luben.zstd.ZstdIOException     // Catch: java.lang.Throwable -> L79
            r0.<init>(r5)     // Catch: java.lang.Throwable -> L79
            throw r0     // Catch: java.lang.Throwable -> L79
        L6d:
            long r4 = r10.stream
            freeCStream(r4)
            r10.closed = r3
            r10.initialized = r2
            r10.target = r1
            goto L86
        L79:
            r0 = move-exception
            long r4 = r10.stream
            freeCStream(r4)
            r10.closed = r3
            r10.initialized = r2
            r10.target = r1
            throw r0
        L86:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.luben.zstd.ZstdDirectBufferCompressingStreamNoFinalizer.close():void");
    }

    public void compress(ByteBuffer byteBuffer) throws IOException {
        long initCStreamWithDict;
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("Source buffer should be a direct buffer");
        }
        if (this.closed) {
            throw new IOException("Stream closed");
        }
        if (!this.initialized) {
            ZstdDictCompress zstdDictCompress = this.fastDict;
            if (zstdDictCompress != null) {
                zstdDictCompress.acquireSharedLock();
                try {
                    initCStreamWithDict = initCStreamWithFastDict(this.stream, zstdDictCompress);
                } finally {
                    zstdDictCompress.releaseSharedLock();
                }
            } else {
                initCStreamWithDict = this.dict != null ? initCStreamWithDict(this.stream, this.dict, this.dict.length, this.level) : initCStream(this.stream, this.level);
            }
            if (Zstd.isError(initCStreamWithDict)) {
                throw new ZstdIOException(initCStreamWithDict);
            }
            this.initialized = true;
        }
        while (byteBuffer.hasRemaining()) {
            if (!this.target.hasRemaining()) {
                this.target = flushBuffer(this.target);
                if (!this.target.isDirect()) {
                    throw new IllegalArgumentException("Target buffer should be a direct buffer");
                }
                if (!this.target.hasRemaining()) {
                    throw new IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
                }
            }
            ByteBuffer byteBuffer2 = byteBuffer;
            long compressDirectByteBuffer = compressDirectByteBuffer(this.stream, this.target, this.target.position(), this.target.remaining(), byteBuffer2, byteBuffer.position(), byteBuffer.remaining());
            if (Zstd.isError(compressDirectByteBuffer)) {
                throw new ZstdIOException(compressDirectByteBuffer);
            }
            this.target.position(this.target.position() + this.produced);
            byteBuffer2.position(byteBuffer2.position() + this.consumed);
            byteBuffer = byteBuffer2;
        }
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        long flushStream;
        if (this.closed) {
            throw new IOException("Already closed");
        }
        if (!this.initialized) {
            return;
        }
        do {
            flushStream = flushStream(this.stream, this.target, this.target.position(), this.target.remaining());
            if (Zstd.isError(flushStream)) {
                throw new ZstdIOException(flushStream);
            }
            this.target.position(this.target.position() + this.produced);
            this.target = flushBuffer(this.target);
            if (!this.target.isDirect()) {
                throw new IllegalArgumentException("Target buffer should be a direct buffer");
            }
            if (flushStream > 0 && !this.target.hasRemaining()) {
                throw new IOException("The target buffer has no more space, even after flushing, and there are still bytes to compress");
            }
        } while (flushStream > 0);
    }

    protected ByteBuffer flushBuffer(ByteBuffer byteBuffer) throws IOException {
        return byteBuffer;
    }

    public ZstdDirectBufferCompressingStreamNoFinalizer setDict(ZstdDictCompress zstdDictCompress) {
        if (this.initialized) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        this.dict = null;
        this.fastDict = zstdDictCompress;
        return this;
    }

    public ZstdDirectBufferCompressingStreamNoFinalizer setDict(byte[] bArr) {
        if (this.initialized) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        this.dict = bArr;
        this.fastDict = null;
        return this;
    }
}
