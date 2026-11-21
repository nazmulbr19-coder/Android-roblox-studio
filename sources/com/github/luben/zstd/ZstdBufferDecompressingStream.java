package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ZstdBufferDecompressingStream implements Closeable {
    private boolean finalize = true;
    private final ZstdBufferDecompressingStreamNoFinalizer inner;

    /* renamed from: com.github.luben.zstd.ZstdBufferDecompressingStream$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ZstdBufferDecompressingStreamNoFinalizer {
        AnonymousClass1(ByteBuffer byteBuffer) {
            super(byteBuffer);
        }

        @Override // com.github.luben.zstd.BaseZstdBufferDecompressingStreamNoFinalizer
        protected ByteBuffer refill(ByteBuffer byteBuffer) {
            return ZstdBufferDecompressingStream.this.refill(byteBuffer);
        }
    }

    static {
        Native.load();
    }

    public ZstdBufferDecompressingStream(ByteBuffer byteBuffer) {
        this.inner = new AnonymousClass1(byteBuffer);
    }

    public static int recommendedTargetBufferSize() {
        return ZstdBufferDecompressingStreamNoFinalizer.recommendedTargetBufferSize();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.inner.close();
    }

    protected void finalize() throws Throwable {
        if (this.finalize) {
            close();
        }
    }

    public synchronized boolean hasRemaining() {
        return this.inner.hasRemaining();
    }

    public synchronized int read(ByteBuffer byteBuffer) throws IOException {
        return this.inner.read(byteBuffer);
    }

    protected ByteBuffer refill(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    public synchronized ZstdBufferDecompressingStream setDict(ZstdDictDecompress zstdDictDecompress) throws IOException {
        this.inner.setDict(zstdDictDecompress);
        return this;
    }

    public synchronized ZstdBufferDecompressingStream setDict(byte[] bArr) throws IOException {
        this.inner.setDict(bArr);
        return this;
    }

    public void setFinalize(boolean z) {
        this.finalize = z;
    }

    public ZstdBufferDecompressingStream setLongMax(int i) throws IOException {
        this.inner.setLongMax(i);
        return this;
    }
}
