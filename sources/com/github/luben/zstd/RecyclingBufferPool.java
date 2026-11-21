package com.github.luben.zstd;

import java.lang.ref.SoftReference;
import java.nio.ByteBuffer;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes.dex */
public class RecyclingBufferPool implements BufferPool {
    public static final BufferPool INSTANCE = new RecyclingBufferPool();
    private static final int buffSize = Math.max(Math.max((int) ZstdOutputStreamNoFinalizer.recommendedCOutSize(), (int) ZstdInputStreamNoFinalizer.recommendedDInSize()), (int) ZstdInputStreamNoFinalizer.recommendedDOutSize());
    private final ConcurrentLinkedQueue<SoftReference<ByteBuffer>> pool = new ConcurrentLinkedQueue<>();

    private RecyclingBufferPool() {
    }

    @Override // com.github.luben.zstd.BufferPool
    public ByteBuffer get(int i) {
        ByteBuffer byteBuffer;
        if (i > buffSize) {
            throw new RuntimeException("Unsupported buffer size: " + i + ". Supported buffer sizes: " + buffSize + " or smaller.");
        }
        do {
            SoftReference<ByteBuffer> poll = this.pool.poll();
            if (poll == null) {
                return ByteBuffer.allocate(buffSize);
            }
            byteBuffer = poll.get();
        } while (byteBuffer == null);
        return byteBuffer;
    }

    @Override // com.github.luben.zstd.BufferPool
    public void release(ByteBuffer byteBuffer) {
        if (byteBuffer.capacity() >= buffSize) {
            byteBuffer.clear();
            this.pool.add(new SoftReference<>(byteBuffer));
        }
    }
}
