package com.github.luben.zstd;

import com.github.luben.zstd.util.Native;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public class ZstdOutputStreamNoFinalizer extends FilterOutputStream {
    private static final int dstSize;
    private final BufferPool bufferPool;
    private boolean closeFrameOnFlush;
    private final byte[] dst;
    private final ByteBuffer dstByteBuffer;
    private long dstPos;
    private boolean frameClosed;
    private boolean frameStarted;
    private boolean isClosed;
    private long srcPos;
    private final long stream;

    static {
        Native.load();
        dstSize = (int) recommendedCOutSize();
    }

    public ZstdOutputStreamNoFinalizer(OutputStream outputStream) throws IOException {
        this(outputStream, NoPool.INSTANCE);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream outputStream, int i) throws IOException {
        this(outputStream, NoPool.INSTANCE);
        Zstd.setCompressionLevel(this.stream, i);
    }

    public ZstdOutputStreamNoFinalizer(OutputStream outputStream, BufferPool bufferPool) throws IOException {
        super(outputStream);
        this.srcPos = 0L;
        this.dstPos = 0L;
        this.isClosed = false;
        this.closeFrameOnFlush = false;
        this.frameClosed = true;
        this.frameStarted = false;
        this.stream = createCStream();
        this.bufferPool = bufferPool;
        this.dstByteBuffer = Zstd.getArrayBackedBuffer(bufferPool, dstSize);
        this.dst = this.dstByteBuffer.array();
    }

    public ZstdOutputStreamNoFinalizer(OutputStream outputStream, BufferPool bufferPool, int i) throws IOException {
        this(outputStream, bufferPool);
        Zstd.setCompressionLevel(this.stream, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0024, code lost:
    
        if (r7.frameClosed == false) goto L15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0026, code lost:
    
        r1 = endStream(r7.stream, r7.dst, com.github.luben.zstd.ZstdOutputStreamNoFinalizer.dstSize);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0035, code lost:
    
        if (com.github.luben.zstd.Zstd.isError(r1) != false) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0037, code lost:
    
        r7.out.write(r7.dst, 0, (int) r7.dstPos);
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0041, code lost:
    
        if (r1 > 0) goto L32;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x004a, code lost:
    
        throw new com.github.luben.zstd.ZstdIOException(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004b, code lost:
    
        if (r8 == false) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x004d, code lost:
    
        r7.out.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0061, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void close(boolean r8) throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.isClosed
            if (r0 == 0) goto L5
            return
        L5:
            r0 = 1
            boolean r1 = r7.frameStarted     // Catch: java.lang.Throwable -> L62
            r2 = 0
            if (r1 != 0) goto L22
            long r3 = r7.stream     // Catch: java.lang.Throwable -> L62
            int r1 = r7.resetCStream(r3)     // Catch: java.lang.Throwable -> L62
            long r3 = (long) r1     // Catch: java.lang.Throwable -> L62
            boolean r3 = com.github.luben.zstd.Zstd.isError(r3)     // Catch: java.lang.Throwable -> L62
            if (r3 != 0) goto L1b
            r7.frameClosed = r2     // Catch: java.lang.Throwable -> L62
            goto L22
        L1b:
            com.github.luben.zstd.ZstdIOException r2 = new com.github.luben.zstd.ZstdIOException     // Catch: java.lang.Throwable -> L62
            long r3 = (long) r1     // Catch: java.lang.Throwable -> L62
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L62
            throw r2     // Catch: java.lang.Throwable -> L62
        L22:
            boolean r1 = r7.frameClosed     // Catch: java.lang.Throwable -> L62
            if (r1 != 0) goto L4b
        L26:
            long r3 = r7.stream     // Catch: java.lang.Throwable -> L62
            byte[] r1 = r7.dst     // Catch: java.lang.Throwable -> L62
            int r5 = com.github.luben.zstd.ZstdOutputStreamNoFinalizer.dstSize     // Catch: java.lang.Throwable -> L62
            int r1 = r7.endStream(r3, r1, r5)     // Catch: java.lang.Throwable -> L62
            long r3 = (long) r1     // Catch: java.lang.Throwable -> L62
            boolean r3 = com.github.luben.zstd.Zstd.isError(r3)     // Catch: java.lang.Throwable -> L62
            if (r3 != 0) goto L44
            java.io.OutputStream r3 = r7.out     // Catch: java.lang.Throwable -> L62
            byte[] r4 = r7.dst     // Catch: java.lang.Throwable -> L62
            long r5 = r7.dstPos     // Catch: java.lang.Throwable -> L62
            int r5 = (int) r5     // Catch: java.lang.Throwable -> L62
            r3.write(r4, r2, r5)     // Catch: java.lang.Throwable -> L62
            if (r1 > 0) goto L26
            goto L4b
        L44:
            com.github.luben.zstd.ZstdIOException r2 = new com.github.luben.zstd.ZstdIOException     // Catch: java.lang.Throwable -> L62
            long r3 = (long) r1     // Catch: java.lang.Throwable -> L62
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L62
            throw r2     // Catch: java.lang.Throwable -> L62
        L4b:
            if (r8 == 0) goto L52
            java.io.OutputStream r1 = r7.out     // Catch: java.lang.Throwable -> L62
            r1.close()     // Catch: java.lang.Throwable -> L62
        L52:
            r7.isClosed = r0
            com.github.luben.zstd.BufferPool r0 = r7.bufferPool
            java.nio.ByteBuffer r1 = r7.dstByteBuffer
            r0.release(r1)
            long r0 = r7.stream
            freeCStream(r0)
            return
        L62:
            r1 = move-exception
            r7.isClosed = r0
            com.github.luben.zstd.BufferPool r0 = r7.bufferPool
            java.nio.ByteBuffer r2 = r7.dstByteBuffer
            r0.release(r2)
            long r2 = r7.stream
            freeCStream(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.luben.zstd.ZstdOutputStreamNoFinalizer.close(boolean):void");
    }

    private native int compressStream(long j, byte[] bArr, int i, byte[] bArr2, int i2);

    private static native long createCStream();

    private native int endStream(long j, byte[] bArr, int i);

    private native int flushStream(long j, byte[] bArr, int i);

    private static native int freeCStream(long j);

    public static native long recommendedCOutSize();

    private native int resetCStream(long j);

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public synchronized void close() throws IOException {
        close(true);
    }

    public synchronized void closeWithoutClosingParentStream() throws IOException {
        close(false);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x001d, code lost:
    
        if (com.github.luben.zstd.Zstd.isError(r0) != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001f, code lost:
    
        r6.out.write(r6.dst, 0, (int) r6.dstPos);
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0029, code lost:
    
        if (r0 > 0) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002b, code lost:
    
        r6.frameClosed = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0053, code lost:
    
        r6.out.flush();
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0035, code lost:
    
        throw new com.github.luben.zstd.ZstdIOException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0036, code lost:
    
        r0 = flushStream(r6.stream, r6.dst, com.github.luben.zstd.ZstdOutputStreamNoFinalizer.dstSize);
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0045, code lost:
    
        if (com.github.luben.zstd.Zstd.isError(r0) != false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0047, code lost:
    
        r6.out.write(r6.dst, 0, (int) r6.dstPos);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0051, code lost:
    
        if (r0 > 0) goto L37;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        throw new com.github.luben.zstd.ZstdIOException(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x000c, code lost:
    
        if (r6.closeFrameOnFlush != false) goto L9;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x000e, code lost:
    
        r0 = endStream(r6.stream, r6.dst, com.github.luben.zstd.ZstdOutputStreamNoFinalizer.dstSize);
     */
    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Flushable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public synchronized void flush() throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.isClosed     // Catch: java.lang.Throwable -> L6c
            if (r0 != 0) goto L62
            boolean r0 = r6.frameClosed     // Catch: java.lang.Throwable -> L6c
            if (r0 != 0) goto L60
            boolean r0 = r6.closeFrameOnFlush     // Catch: java.lang.Throwable -> L6c
            r1 = 0
            if (r0 == 0) goto L36
        Le:
            long r2 = r6.stream     // Catch: java.lang.Throwable -> L6c
            byte[] r0 = r6.dst     // Catch: java.lang.Throwable -> L6c
            int r4 = com.github.luben.zstd.ZstdOutputStreamNoFinalizer.dstSize     // Catch: java.lang.Throwable -> L6c
            int r0 = r6.endStream(r2, r0, r4)     // Catch: java.lang.Throwable -> L6c
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L6c
            boolean r2 = com.github.luben.zstd.Zstd.isError(r2)     // Catch: java.lang.Throwable -> L6c
            if (r2 != 0) goto L2f
            java.io.OutputStream r2 = r6.out     // Catch: java.lang.Throwable -> L6c
            byte[] r3 = r6.dst     // Catch: java.lang.Throwable -> L6c
            long r4 = r6.dstPos     // Catch: java.lang.Throwable -> L6c
            int r4 = (int) r4     // Catch: java.lang.Throwable -> L6c
            r2.write(r3, r1, r4)     // Catch: java.lang.Throwable -> L6c
            if (r0 > 0) goto Le
            r1 = 1
            r6.frameClosed = r1     // Catch: java.lang.Throwable -> L6c
            goto L53
        L2f:
            com.github.luben.zstd.ZstdIOException r1 = new com.github.luben.zstd.ZstdIOException     // Catch: java.lang.Throwable -> L6c
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L6c
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L6c
            throw r1     // Catch: java.lang.Throwable -> L6c
        L36:
            long r2 = r6.stream     // Catch: java.lang.Throwable -> L6c
            byte[] r0 = r6.dst     // Catch: java.lang.Throwable -> L6c
            int r4 = com.github.luben.zstd.ZstdOutputStreamNoFinalizer.dstSize     // Catch: java.lang.Throwable -> L6c
            int r0 = r6.flushStream(r2, r0, r4)     // Catch: java.lang.Throwable -> L6c
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L6c
            boolean r2 = com.github.luben.zstd.Zstd.isError(r2)     // Catch: java.lang.Throwable -> L6c
            if (r2 != 0) goto L59
            java.io.OutputStream r2 = r6.out     // Catch: java.lang.Throwable -> L6c
            byte[] r3 = r6.dst     // Catch: java.lang.Throwable -> L6c
            long r4 = r6.dstPos     // Catch: java.lang.Throwable -> L6c
            int r4 = (int) r4     // Catch: java.lang.Throwable -> L6c
            r2.write(r3, r1, r4)     // Catch: java.lang.Throwable -> L6c
            if (r0 > 0) goto L36
        L53:
            java.io.OutputStream r0 = r6.out     // Catch: java.lang.Throwable -> L6c
            r0.flush()     // Catch: java.lang.Throwable -> L6c
            goto L60
        L59:
            com.github.luben.zstd.ZstdIOException r1 = new com.github.luben.zstd.ZstdIOException     // Catch: java.lang.Throwable -> L6c
            long r2 = (long) r0     // Catch: java.lang.Throwable -> L6c
            r1.<init>(r2)     // Catch: java.lang.Throwable -> L6c
            throw r1     // Catch: java.lang.Throwable -> L6c
        L60:
            monitor-exit(r6)
            return
        L62:
            java.io.IOException r0 = new java.io.IOException     // Catch: java.lang.Throwable -> L6c
            java.lang.String r1 = "StreamClosed"
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L6c
            throw r0     // Catch: java.lang.Throwable -> L6c
        L6a:
            monitor-exit(r6)     // Catch: java.lang.Throwable -> L6c
            throw r0
        L6c:
            r0 = move-exception
            goto L6a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.luben.zstd.ZstdOutputStreamNoFinalizer.flush():void");
    }

    public synchronized ZstdOutputStreamNoFinalizer setChainLog(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionChainLog = Zstd.setCompressionChainLog(this.stream, i);
        if (Zstd.isError(compressionChainLog)) {
            throw new ZstdIOException(compressionChainLog);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setChecksum(boolean z) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionChecksums = Zstd.setCompressionChecksums(this.stream, z);
        if (Zstd.isError(compressionChecksums)) {
            throw new ZstdIOException(compressionChecksums);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setCloseFrameOnFlush(boolean z) {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        this.closeFrameOnFlush = z;
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(ZstdDictCompress zstdDictCompress) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int loadFastDictCompress = Zstd.loadFastDictCompress(this.stream, zstdDictCompress);
        if (Zstd.isError(loadFastDictCompress)) {
            throw new ZstdIOException(loadFastDictCompress);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setDict(byte[] bArr) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int loadDictCompress = Zstd.loadDictCompress(this.stream, bArr, bArr.length);
        if (Zstd.isError(loadDictCompress)) {
            throw new ZstdIOException(loadDictCompress);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setHashLog(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionHashLog = Zstd.setCompressionHashLog(this.stream, i);
        if (Zstd.isError(compressionHashLog)) {
            throw new ZstdIOException(compressionHashLog);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setJobSize(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionJobSize = Zstd.setCompressionJobSize(this.stream, i);
        if (Zstd.isError(compressionJobSize)) {
            throw new ZstdIOException(compressionJobSize);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setLevel(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionLevel = Zstd.setCompressionLevel(this.stream, i);
        if (Zstd.isError(compressionLevel)) {
            throw new ZstdIOException(compressionLevel);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setLong(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionLong = Zstd.setCompressionLong(this.stream, i);
        if (Zstd.isError(compressionLong)) {
            throw new ZstdIOException(compressionLong);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setMinMatch(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionMinMatch = Zstd.setCompressionMinMatch(this.stream, i);
        if (Zstd.isError(compressionMinMatch)) {
            throw new ZstdIOException(compressionMinMatch);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setOverlapLog(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionOverlapLog = Zstd.setCompressionOverlapLog(this.stream, i);
        if (Zstd.isError(compressionOverlapLog)) {
            throw new ZstdIOException(compressionOverlapLog);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setSearchLog(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionSearchLog = Zstd.setCompressionSearchLog(this.stream, i);
        if (Zstd.isError(compressionSearchLog)) {
            throw new ZstdIOException(compressionSearchLog);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setStrategy(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionStrategy = Zstd.setCompressionStrategy(this.stream, i);
        if (Zstd.isError(compressionStrategy)) {
            throw new ZstdIOException(compressionStrategy);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setTargetLength(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionTargetLength = Zstd.setCompressionTargetLength(this.stream, i);
        if (Zstd.isError(compressionTargetLength)) {
            throw new ZstdIOException(compressionTargetLength);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setWindowLog(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionWindowLog = Zstd.setCompressionWindowLog(this.stream, i);
        if (Zstd.isError(compressionWindowLog)) {
            throw new ZstdIOException(compressionWindowLog);
        }
        return this;
    }

    public synchronized ZstdOutputStreamNoFinalizer setWorkers(int i) throws IOException {
        if (!this.frameClosed) {
            throw new IllegalStateException("Change of parameter on initialized stream");
        }
        int compressionWorkers = Zstd.setCompressionWorkers(this.stream, i);
        if (Zstd.isError(compressionWorkers)) {
            throw new ZstdIOException(compressionWorkers);
        }
        return this;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public void write(int i) throws IOException {
        write(new byte[]{(byte) i}, 0, 1);
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream
    public synchronized void write(byte[] bArr, int i, int i2) throws IOException {
        if (this.isClosed) {
            throw new IOException("StreamClosed");
        }
        if (this.frameClosed) {
            int resetCStream = resetCStream(this.stream);
            if (Zstd.isError(resetCStream)) {
                throw new ZstdIOException(resetCStream);
            }
            this.frameClosed = false;
            this.frameStarted = true;
        }
        int i3 = i + i2;
        this.srcPos = i;
        while (this.srcPos < i3) {
            byte[] bArr2 = bArr;
            int compressStream = compressStream(this.stream, this.dst, dstSize, bArr2, i3);
            if (Zstd.isError(compressStream)) {
                throw new ZstdIOException(compressStream);
            }
            if (this.dstPos > 0) {
                this.out.write(this.dst, 0, (int) this.dstPos);
            }
            bArr = bArr2;
        }
    }
}
