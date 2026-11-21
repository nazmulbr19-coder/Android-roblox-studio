package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.io.Closeable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ZstdDirectBufferDecompressingStream implements Closeable {
    private boolean finalize = true;
    private ZstdDirectBufferDecompressingStreamNoFinalizer inner;

    /* renamed from: com.github.luben.zstd.ZstdDirectBufferDecompressingStream$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ZstdDirectBufferDecompressingStreamNoFinalizer {
        AnonymousClass1(ByteBuffer byteBuffer) {
            super(byteBuffer);
        }

        @Override // com.github.luben.zstd.BaseZstdBufferDecompressingStreamNoFinalizer
        protected ByteBuffer refill(ByteBuffer byteBuffer) {
            return ZstdDirectBufferDecompressingStream.this.refill(byteBuffer);
        }
    }

    static {
        Native.load();
    }

    public ZstdDirectBufferDecompressingStream(ByteBuffer byteBuffer) {
        this.inner = new AnonymousClass1(byteBuffer);
    }

    public static int recommendedTargetBufferSize() {
        return ZstdDirectBufferDecompressingStreamNoFinalizer.recommendedTargetBufferSize();
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

    public synchronized ZstdDirectBufferDecompressingStream setDict(ZstdDictDecompress zstdDictDecompress) throws IOException {
        this.inner.setDict(zstdDictDecompress);
        return this;
    }

    public synchronized ZstdDirectBufferDecompressingStream setDict(byte[] bArr) throws IOException {
        this.inner.setDict(bArr);
        return this;
    }

    public void setFinalize(boolean z) {
        this.finalize = z;
    }

    public ZstdDirectBufferDecompressingStream setLongMax(int i) throws IOException {
        this.inner.setLongMax(i);
        return this;
    }
}
