package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ZstdDirectBufferCompressingStream implements Closeable, Flushable {
    private boolean finalize;
    ZstdDirectBufferCompressingStreamNoFinalizer inner;

    /* renamed from: com.github.luben.zstd.ZstdDirectBufferCompressingStream$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ZstdDirectBufferCompressingStreamNoFinalizer {
        AnonymousClass1(ByteBuffer byteBuffer, int i) throws IOException {
            super(byteBuffer, i);
        }

        @Override // com.github.luben.zstd.ZstdDirectBufferCompressingStreamNoFinalizer
        protected ByteBuffer flushBuffer(ByteBuffer byteBuffer) throws IOException {
            return ZstdDirectBufferCompressingStream.this.flushBuffer(byteBuffer);
        }
    }

    static {
        Native.load();
    }

    public ZstdDirectBufferCompressingStream(ByteBuffer byteBuffer, int i) throws IOException {
        this.inner = new AnonymousClass1(byteBuffer, i);
    }

    public static int recommendedOutputBufferSize() {
        return ZstdDirectBufferCompressingStreamNoFinalizer.recommendedOutputBufferSize();
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        this.inner.close();
    }

    public synchronized void compress(ByteBuffer byteBuffer) throws IOException {
        this.inner.compress(byteBuffer);
    }

    protected void finalize() throws Throwable {
        if (this.finalize) {
            close();
        }
    }

    @Override // java.io.Flushable
    public synchronized void flush() throws IOException {
        this.inner.flush();
    }

    protected ByteBuffer flushBuffer(ByteBuffer byteBuffer) throws IOException {
        return byteBuffer;
    }

    public synchronized ZstdDirectBufferCompressingStream setDict(ZstdDictCompress zstdDictCompress) throws IOException {
        this.inner.setDict(zstdDictCompress);
        return this;
    }

    public synchronized ZstdDirectBufferCompressingStream setDict(byte[] bArr) throws IOException {
        this.inner.setDict(bArr);
        return this;
    }

    public void setFinalize(boolean z) {
        this.finalize = z;
    }
}
