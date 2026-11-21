package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* loaded from: classes.dex */
public class ZstdDecompressCtx extends AutoCloseBase {
    private ZstdDictDecompress decompression_dict = null;
    private long nativePtr;

    static {
        Native.load();
    }

    public ZstdDecompressCtx() {
        this.nativePtr = 0L;
        this.nativePtr = init();
        if (0 == this.nativePtr) {
            throw new IllegalStateException("ZSTD_createDeCompressCtx failed");
        }
        storeFence();
    }

    private static native long decompressByteArray0(long j, byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4);

    private static native long decompressDirectByteBuffer0(long j, ByteBuffer byteBuffer, int i, int i2, ByteBuffer byteBuffer2, int i3, int i4);

    private static native long decompressDirectByteBufferStream0(long j, ByteBuffer byteBuffer, int i, int i2, ByteBuffer byteBuffer2, int i3, int i4);

    private void ensureOpen() {
        if (this.nativePtr == 0) {
            throw new IllegalStateException("Decompression context is closed");
        }
    }

    private static native void free(long j);

    private static native long init();

    private static native long loadDDict0(long j, byte[] bArr);

    private static native long loadDDictFast0(long j, ZstdDictDecompress zstdDictDecompress);

    private static native void reset0(long j);

    @Override // com.github.luben.zstd.AutoCloseBase, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    public int decompress(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws ZstdException {
        int decompressDirectByteBuffer = decompressDirectByteBuffer(byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position(), byteBuffer2, byteBuffer2.position(), byteBuffer2.limit() - byteBuffer2.position());
        byteBuffer2.position(byteBuffer2.limit());
        byteBuffer.position(byteBuffer.position() + decompressDirectByteBuffer);
        return decompressDirectByteBuffer;
    }

    public int decompress(byte[] bArr, byte[] bArr2) {
        return decompressByteArray(bArr, 0, bArr.length, bArr2, 0, bArr2.length);
    }

    public ByteBuffer decompress(ByteBuffer byteBuffer, int i) throws ZstdException {
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(i);
        decompressDirectByteBuffer(allocateDirect, 0, i, byteBuffer, byteBuffer.position(), byteBuffer.limit() - byteBuffer.position());
        byteBuffer.position(byteBuffer.limit());
        return allocateDirect;
    }

    public byte[] decompress(byte[] bArr, int i) throws ZstdException {
        if (i < 0) {
            throw new ZstdException(Zstd.errGeneric(), "Original size should not be negative");
        }
        byte[] bArr2 = new byte[i];
        int decompress = decompress(bArr2, bArr);
        return decompress != i ? Arrays.copyOfRange(bArr2, 0, decompress) : bArr2;
    }

    public int decompressByteArray(byte[] bArr, int i, int i2, byte[] bArr2, int i3, int i4) {
        Throwable th;
        ensureOpen();
        acquireSharedLock();
        try {
            try {
                long decompressByteArray0 = decompressByteArray0(this.nativePtr, bArr, i, i2, bArr2, i3, i4);
                if (Zstd.isError(decompressByteArray0)) {
                    throw new ZstdException(decompressByteArray0);
                }
                if (decompressByteArray0 > 2147483647L) {
                    throw new ZstdException(Zstd.errGeneric(), "Output size is greater than MAX_INT");
                }
                int i5 = (int) decompressByteArray0;
                releaseSharedLock();
                return i5;
            } catch (Throwable th2) {
                th = th2;
                releaseSharedLock();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public int decompressDirectByteBuffer(ByteBuffer byteBuffer, int i, int i2, ByteBuffer byteBuffer2, int i3, int i4) {
        Throwable th;
        ensureOpen();
        if (!byteBuffer2.isDirect()) {
            throw new IllegalArgumentException("srcBuff must be a direct buffer");
        }
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("dstBuff must be a direct buffer");
        }
        acquireSharedLock();
        try {
            try {
                long decompressDirectByteBuffer0 = decompressDirectByteBuffer0(this.nativePtr, byteBuffer, i, i2, byteBuffer2, i3, i4);
                if (Zstd.isError(decompressDirectByteBuffer0)) {
                    throw new ZstdException(decompressDirectByteBuffer0);
                }
                if (decompressDirectByteBuffer0 > 2147483647L) {
                    throw new ZstdException(Zstd.errGeneric(), "Output size is greater than MAX_INT");
                }
                int i5 = (int) decompressDirectByteBuffer0;
                releaseSharedLock();
                return i5;
            } catch (Throwable th2) {
                th = th2;
                releaseSharedLock();
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    public boolean decompressDirectByteBufferStream(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        ensureOpen();
        long decompressDirectByteBufferStream0 = decompressDirectByteBufferStream0(this.nativePtr, byteBuffer, byteBuffer.position(), byteBuffer.limit(), byteBuffer2, byteBuffer2.position(), byteBuffer2.limit());
        if ((2147483648L & decompressDirectByteBufferStream0) != 0) {
            long j = 255 & decompressDirectByteBufferStream0;
            throw new ZstdException(j, Zstd.getErrorName(j));
        }
        byteBuffer2.position((int) (2147483647L & decompressDirectByteBufferStream0));
        byteBuffer.position(((int) (decompressDirectByteBufferStream0 >>> 32)) & Integer.MAX_VALUE);
        return (decompressDirectByteBufferStream0 >>> 63) == 1;
    }

    @Override // com.github.luben.zstd.AutoCloseBase
    void doClose() {
        if (this.nativePtr != 0) {
            free(this.nativePtr);
            this.nativePtr = 0L;
        }
    }

    public ZstdDecompressCtx loadDict(ZstdDictDecompress zstdDictDecompress) {
        ensureOpen();
        acquireSharedLock();
        zstdDictDecompress.acquireSharedLock();
        try {
            long loadDDictFast0 = loadDDictFast0(this.nativePtr, zstdDictDecompress);
            if (Zstd.isError(loadDDictFast0)) {
                throw new ZstdException(loadDDictFast0);
            }
            this.decompression_dict = zstdDictDecompress;
            return this;
        } finally {
            zstdDictDecompress.releaseSharedLock();
            releaseSharedLock();
        }
    }

    public ZstdDecompressCtx loadDict(byte[] bArr) {
        ensureOpen();
        acquireSharedLock();
        try {
            long loadDDict0 = loadDDict0(this.nativePtr, bArr);
            if (Zstd.isError(loadDDict0)) {
                throw new ZstdException(loadDDict0);
            }
            this.decompression_dict = null;
            return this;
        } finally {
            releaseSharedLock();
        }
    }

    public void reset() {
        ensureOpen();
        reset0(this.nativePtr);
    }

    public ZstdDecompressCtx setMagicless(boolean z) {
        ensureOpen();
        acquireSharedLock();
        Zstd.setDecompressionMagicless(this.nativePtr, z);
        releaseSharedLock();
        return this;
    }
}
