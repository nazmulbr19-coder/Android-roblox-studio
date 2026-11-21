package com.github.luben.zstd;

import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class BaseZstdBufferDecompressingStreamNoFinalizer implements Closeable {
    private int consumed;
    private int produced;
    protected ByteBuffer source;
    protected long stream;
    protected boolean closed = false;
    private boolean finishedFrame = false;
    private boolean streamEnd = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    public BaseZstdBufferDecompressingStreamNoFinalizer(ByteBuffer byteBuffer) {
        this.source = byteBuffer;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        try {
            freeDStream(this.stream);
        } finally {
            this.closed = true;
            this.source = null;
        }
    }

    abstract long createDStream();

    abstract long decompressStream(long j, ByteBuffer byteBuffer, int i, int i2, ByteBuffer byteBuffer2, int i3, int i4);

    abstract long freeDStream(long j);

    public boolean hasRemaining() {
        return !this.streamEnd && (this.source.hasRemaining() || !this.finishedFrame);
    }

    abstract long initDStream(long j);

    public abstract int read(ByteBuffer byteBuffer) throws IOException;

    /* JADX INFO: Access modifiers changed from: package-private */
    public int readInternal(ByteBuffer byteBuffer, boolean z) throws IOException {
        if (this.closed) {
            throw new IOException("Stream closed");
        }
        if (this.streamEnd) {
            return 0;
        }
        long decompressStream = decompressStream(this.stream, byteBuffer, byteBuffer.position(), byteBuffer.remaining(), this.source, this.source.position(), this.source.remaining());
        if (Zstd.isError(decompressStream)) {
            throw new ZstdIOException(decompressStream);
        }
        this.source.position(this.source.position() + this.consumed);
        byteBuffer.position(byteBuffer.position() + this.produced);
        if (!this.source.hasRemaining()) {
            this.source = refill(this.source);
            if (!z && this.source.isDirect()) {
                throw new IllegalArgumentException("Source buffer should be a non-direct buffer");
            }
            if (z && !this.source.isDirect()) {
                throw new IllegalArgumentException("Source buffer should be a direct buffer");
            }
        }
        this.finishedFrame = decompressStream == 0;
        if (this.finishedFrame) {
            this.streamEnd = !this.source.hasRemaining();
        }
        return this.produced;
    }

    protected ByteBuffer refill(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    public BaseZstdBufferDecompressingStreamNoFinalizer setDict(ZstdDictDecompress zstdDictDecompress) throws IOException {
        zstdDictDecompress.acquireSharedLock();
        try {
            long loadFastDictDecompress = Zstd.loadFastDictDecompress(this.stream, zstdDictDecompress);
            if (Zstd.isError(loadFastDictDecompress)) {
                throw new ZstdIOException(loadFastDictDecompress);
            }
            return this;
        } finally {
            zstdDictDecompress.releaseSharedLock();
        }
    }

    public BaseZstdBufferDecompressingStreamNoFinalizer setDict(byte[] bArr) throws IOException {
        long loadDictDecompress = Zstd.loadDictDecompress(this.stream, bArr, bArr.length);
        if (Zstd.isError(loadDictDecompress)) {
            throw new ZstdIOException(loadDictDecompress);
        }
        return this;
    }

    public BaseZstdBufferDecompressingStreamNoFinalizer setLongMax(int i) throws IOException {
        long decompressionLongMax = Zstd.setDecompressionLongMax(this.stream, i);
        if (Zstd.isError(decompressionLongMax)) {
            throw new ZstdIOException(decompressionLongMax);
        }
        return this;
    }
}
