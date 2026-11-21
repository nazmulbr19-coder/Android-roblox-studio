package androidx.core.view;

import android.view.MotionEvent;

/* loaded from: classes.dex */
class VelocityTrackerFallback {
    private static final long ASSUME_POINTER_STOPPED_MS = 40;
    private static final int HISTORY_SIZE = 20;
    private static final long RANGE_MS = 100;
    private final float[] mMovements = new float[20];
    private final long[] mEventTimes = new long[20];
    private float mLastComputedVelocity = 0.0f;
    private int mDataPointsBufferSize = 0;
    private int mDataPointsBufferLastUsedIndex = 0;

    private void clear() {
        this.mDataPointsBufferSize = 0;
        this.mLastComputedVelocity = 0.0f;
    }

    private float getCurrentVelocity() {
        if (this.mDataPointsBufferSize < 2) {
            return 0.0f;
        }
        int i = ((this.mDataPointsBufferLastUsedIndex + 20) - (this.mDataPointsBufferSize - 1)) % 20;
        long j = this.mEventTimes[this.mDataPointsBufferLastUsedIndex];
        while (j - this.mEventTimes[i] > RANGE_MS) {
            this.mDataPointsBufferSize--;
            i = (i + 1) % 20;
        }
        if (this.mDataPointsBufferSize < 2) {
            return 0.0f;
        }
        if (this.mDataPointsBufferSize == 2) {
            int i2 = (i + 1) % 20;
            if (this.mEventTimes[i] == this.mEventTimes[i2]) {
                return 0.0f;
            }
            return this.mMovements[i2] / ((float) (this.mEventTimes[i2] - this.mEventTimes[i]));
        }
        float f = 0.0f;
        int i3 = 0;
        for (int i4 = 0; i4 < this.mDataPointsBufferSize - 1; i4++) {
            int i5 = i4 + i;
            long j2 = this.mEventTimes[i5 % 20];
            int i6 = (i5 + 1) % 20;
            if (this.mEventTimes[i6] != j2) {
                i3++;
                float kineticEnergyToVelocity = kineticEnergyToVelocity(f);
                float f2 = this.mMovements[i6] / ((float) (this.mEventTimes[i6] - j2));
                f += (f2 - kineticEnergyToVelocity) * Math.abs(f2);
                if (i3 == 1) {
                    f *= 0.5f;
                }
            }
        }
        return kineticEnergyToVelocity(f);
    }

    private static float kineticEnergyToVelocity(float f) {
        return (f < 0.0f ? -1.0f : 1.0f) * ((float) Math.sqrt(Math.abs(f) * 2.0f));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addMovement(MotionEvent motionEvent) {
        long eventTime = motionEvent.getEventTime();
        if (this.mDataPointsBufferSize != 0 && eventTime - this.mEventTimes[this.mDataPointsBufferLastUsedIndex] > ASSUME_POINTER_STOPPED_MS) {
            clear();
        }
        this.mDataPointsBufferLastUsedIndex = (this.mDataPointsBufferLastUsedIndex + 1) % 20;
        if (this.mDataPointsBufferSize != 20) {
            this.mDataPointsBufferSize++;
        }
        this.mMovements[this.mDataPointsBufferLastUsedIndex] = motionEvent.getAxisValue(26);
        this.mEventTimes[this.mDataPointsBufferLastUsedIndex] = eventTime;
    }

    void computeCurrentVelocity(int i) {
        computeCurrentVelocity(i, Float.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void computeCurrentVelocity(int i, float f) {
        this.mLastComputedVelocity = getCurrentVelocity() * i;
        if (this.mLastComputedVelocity < (-Math.abs(f))) {
            this.mLastComputedVelocity = -Math.abs(f);
        } else if (this.mLastComputedVelocity > Math.abs(f)) {
            this.mLastComputedVelocity = Math.abs(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getAxisVelocity(int i) {
        if (i != 26) {
            return 0.0f;
        }
        return this.mLastComputedVelocity;
    }
}
