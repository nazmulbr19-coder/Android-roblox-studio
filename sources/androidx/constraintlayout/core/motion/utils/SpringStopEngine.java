package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class SpringStopEngine implements StopEngine {
    private static final double UNSET = Double.MAX_VALUE;
    private float mLastTime;
    private double mLastVelocity;
    private float mMass;
    private float mPos;
    private double mStiffness;
    private float mStopThreshold;
    private double mTargetPos;
    private float mV;
    double mDamping = 0.5d;
    private boolean mInitialized = false;
    private int mBoundaryMode = 0;

    private void compute(double d) {
        if (d <= 0.0d) {
            return;
        }
        double d2 = this.mStiffness;
        double d3 = this.mDamping;
        int sqrt = (int) ((9.0d / ((Math.sqrt(this.mStiffness / this.mMass) * d) * 4.0d)) + 1.0d);
        double d4 = d / sqrt;
        int i = 0;
        while (i < sqrt) {
            double d5 = this.mV + ((((((-d2) * (this.mPos - this.mTargetPos)) - (this.mV * d3)) / this.mMass) * d4) / 2.0d);
            double d6 = d2;
            double d7 = d3;
            double d8 = ((((-((this.mPos + ((d4 * d5) / 2.0d)) - this.mTargetPos)) * d6) - (d5 * d7)) / this.mMass) * d4;
            this.mV += (float) d8;
            this.mPos += (float) ((this.mV + (d8 / 2.0d)) * d4);
            if (this.mBoundaryMode > 0) {
                if (this.mPos < 0.0f && (this.mBoundaryMode & 1) == 1) {
                    this.mPos = -this.mPos;
                    this.mV = -this.mV;
                }
                if (this.mPos > 1.0f && (this.mBoundaryMode & 2) == 2) {
                    this.mPos = 2.0f - this.mPos;
                    this.mV = -this.mV;
                }
            }
            i++;
            d3 = d7;
            d2 = d6;
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        return null;
    }

    public float getAcceleration() {
        return ((float) (((-this.mStiffness) * (this.mPos - this.mTargetPos)) - (this.mV * this.mDamping))) / this.mMass;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        compute(f - this.mLastTime);
        this.mLastTime = f;
        if (isStopped()) {
            this.mPos = (float) this.mTargetPos;
        }
        return this.mPos;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        return this.mV;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        double d = this.mPos - this.mTargetPos;
        double d2 = this.mStiffness;
        double d3 = this.mV;
        return Math.sqrt((((d3 * d3) * ((double) this.mMass)) + ((d2 * d) * d)) / d2) <= ((double) this.mStopThreshold);
    }

    void log(String str) {
        StackTraceElement stackTraceElement = new Throwable().getStackTrace()[1];
        System.out.println((".(" + stackTraceElement.getFileName() + ":" + stackTraceElement.getLineNumber() + ") " + stackTraceElement.getMethodName() + "() ") + str);
    }

    public void springConfig(float f, float f2, float f3, float f4, float f5, float f6, float f7, int i) {
        this.mTargetPos = f2;
        this.mDamping = f6;
        this.mInitialized = false;
        this.mPos = f;
        this.mLastVelocity = f3;
        this.mStiffness = f5;
        this.mMass = f4;
        this.mStopThreshold = f7;
        this.mBoundaryMode = i;
        this.mLastTime = 0.0f;
    }
}
