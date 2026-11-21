package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ZstdDictCompress extends SharedDictBase {
    private int level;
    private long nativePtr;
    private ByteBuffer sharedDict;

    static {
        Native.load();
    }

    public ZstdDictCompress(ByteBuffer byteBuffer, int i) {
        this(byteBuffer, i, false);
    }

    public ZstdDictCompress(ByteBuffer byteBuffer, int i, boolean z) {
        this.nativePtr = 0L;
        this.sharedDict = null;
        this.level = Zstd.defaultCompressionLevel();
        this.level = i;
        int limit = byteBuffer.limit() - byteBuffer.position();
        if (!byteBuffer.isDirect()) {
            throw new IllegalArgumentException("dict must be a direct buffer");
        }
        if (limit < 0) {
            throw new IllegalArgumentException("dict cannot be empty.");
        }
        initDirect(byteBuffer, byteBuffer.position(), limit, i, z ? 1 : 0);
        if (this.nativePtr == 0) {
            throw new IllegalStateException("ZSTD_createCDict failed");
        }
        if (z) {
            this.sharedDict = byteBuffer;
        }
        storeFence();
    }

    public ZstdDictCompress(byte[] bArr, int i) {
        this(bArr, 0, bArr.length, i);
    }

    public ZstdDictCompress(byte[] bArr, int i, int i2, int i3) {
        this.nativePtr = 0L;
        this.sharedDict = null;
        this.level = Zstd.defaultCompressionLevel();
        this.level = i3;
        if (bArr.length - i < 0) {
            throw new IllegalArgumentException("Dictionary buffer is to short");
        }
        init(bArr, i, i2, i3);
        if (0 == this.nativePtr) {
            throw new IllegalStateException("ZSTD_createCDict failed");
        }
        storeFence();
    }

    private native void free();

    private native void init(byte[] bArr, int i, int i2, int i3);

    private native void initDirect(ByteBuffer byteBuffer, int i, int i2, int i3, int i4);

    @Override // com.github.luben.zstd.AutoCloseBase, java.io.Closeable, java.lang.AutoCloseable
    public /* bridge */ /* synthetic */ void close() {
        super.close();
    }

    @Override // com.github.luben.zstd.AutoCloseBase
    void doClose() {
        if (this.nativePtr != 0) {
            free();
            this.nativePtr = 0L;
            this.sharedDict = null;
        }
    }

    public ByteBuffer getByReferenceBuffer() {
        return this.sharedDict;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int level() {
        return this.level;
    }
}
