package androidx.transition;

import java.util.Arrays;

/* loaded from: classes.dex */
class VelocityTracker1D {
    private static final int ASSUME_POINTER_MOVE_STOPPED_MILLIS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final int HORIZON_MILLIS = 100;
    private long[] mTimeSamples = new long[20];
    private float[] mDataSamples = new float[20];
    private int mIndex = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public VelocityTracker1D() {
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
    }

    private float kineticEnergyToVelocity(float f) {
        return (float) (Math.signum(f) * Math.sqrt(Math.abs(f) * 2.0f));
    }

    public void addDataPoint(long j, float f) {
        this.mIndex = (this.mIndex + 1) % 20;
        this.mTimeSamples[this.mIndex] = j;
        this.mDataSamples[this.mIndex] = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float calculateVelocity() {
        char c;
        int i;
        int i2 = 0;
        int i3 = this.mIndex;
        float f = 0.0f;
        if (i3 == 0 && this.mTimeSamples[i3] == Long.MIN_VALUE) {
            return 0.0f;
        }
        long j = this.mTimeSamples[i3];
        long j2 = j;
        do {
            long j3 = this.mTimeSamples[i3];
            c = 20;
            if (j3 != Long.MIN_VALUE) {
                float f2 = (float) (j - j3);
                float abs = (float) Math.abs(j3 - j2);
                j2 = j3;
                if (f2 > 100.0f || abs > 40.0f) {
                    break;
                }
                i3 = (i3 == 0 ? 20 : i3) - 1;
                i2++;
            } else {
                break;
            }
        } while (i2 < 20);
        if (i2 < 2) {
            return 0.0f;
        }
        float f3 = 1000.0f;
        if (i2 == 2) {
            int i4 = this.mIndex == 0 ? 19 : this.mIndex - 1;
            float f4 = (float) (this.mTimeSamples[this.mIndex] - this.mTimeSamples[i4]);
            if (f4 == 0.0f) {
                return 0.0f;
            }
            return ((this.mDataSamples[this.mIndex] - this.mDataSamples[i4]) / f4) * 1000.0f;
        }
        float f5 = 0.0f;
        int i5 = (((this.mIndex - i2) + 20) + 1) % 20;
        int i6 = ((this.mIndex + 1) + 20) % 20;
        long j4 = this.mTimeSamples[i5];
        float f6 = this.mDataSamples[i5];
        int i7 = (i5 + 1) % 20;
        while (i7 != i6) {
            long j5 = this.mTimeSamples[i7];
            float f7 = f3;
            long j6 = j5 - j4;
            char c2 = c;
            if (((float) j6) == f) {
                i = i2;
            } else {
                float f8 = this.mDataSamples[i7];
                float f9 = (f8 - f6) / ((float) j6);
                f5 += (f9 - kineticEnergyToVelocity(f5)) * Math.abs(f9);
                i = i2;
                if (i7 == i5 + 1) {
                    f5 *= 0.5f;
                }
                j4 = j5;
                f6 = f8;
            }
            i7 = (i7 + 1) % 20;
            f3 = f7;
            c = c2;
            i2 = i;
            f = 0.0f;
        }
        return kineticEnergyToVelocity(f5) * f3;
    }

    public void resetTracking() {
        this.mIndex = 0;
        Arrays.fill(this.mTimeSamples, Long.MIN_VALUE);
        Arrays.fill(this.mDataSamples, 0.0f);
    }
}
