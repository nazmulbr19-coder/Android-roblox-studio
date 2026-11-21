package com.github.luben.zstd;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ZstdDictTrainer {
    private final int allocatedSize;
    private final int dictSize;
    private long filledSize;
    private final List<Integer> sampleSizes = new ArrayList();
    private final ByteBuffer trainingSamples;

    public ZstdDictTrainer(int i, int i2) {
        this.trainingSamples = ByteBuffer.allocateDirect(i);
        this.allocatedSize = i;
        this.dictSize = i2;
    }

    private int[] copyToIntArray(List<Integer> list) {
        int[] iArr = new int[list.size()];
        int i = 0;
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            iArr[i] = it.next().intValue();
            i++;
        }
        return iArr;
    }

    public synchronized boolean addSample(byte[] bArr) {
        if (this.filledSize + bArr.length > this.allocatedSize) {
            return false;
        }
        this.trainingSamples.put(bArr);
        this.sampleSizes.add(Integer.valueOf(bArr.length));
        this.filledSize += bArr.length;
        return true;
    }

    public byte[] trainSamples() throws ZstdException {
        return trainSamples(false);
    }

    public byte[] trainSamples(boolean z) throws ZstdException {
        ByteBuffer trainSamplesDirect = trainSamplesDirect(z);
        byte[] bArr = new byte[trainSamplesDirect.remaining()];
        trainSamplesDirect.get(bArr);
        return bArr;
    }

    public ByteBuffer trainSamplesDirect() throws ZstdException {
        return trainSamplesDirect(false);
    }

    public synchronized ByteBuffer trainSamplesDirect(boolean z) throws ZstdException {
        ByteBuffer allocateDirect;
        allocateDirect = ByteBuffer.allocateDirect(this.dictSize);
        long trainFromBufferDirect = Zstd.trainFromBufferDirect(this.trainingSamples, copyToIntArray(this.sampleSizes), allocateDirect, z);
        if (Zstd.isError(trainFromBufferDirect)) {
            allocateDirect.limit(0);
            throw new ZstdException(trainFromBufferDirect);
        }
        allocateDirect.limit(Long.valueOf(trainFromBufferDirect).intValue());
        return allocateDirect;
    }
}
