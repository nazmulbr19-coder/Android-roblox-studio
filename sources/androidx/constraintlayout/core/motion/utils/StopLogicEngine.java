package androidx.constraintlayout.core.motion.utils;

/* loaded from: classes.dex */
public class StopLogicEngine implements StopEngine {
    private static final float EPSILON = 1.0E-5f;
    private boolean mBackwards = false;
    private boolean mDone = false;
    private float mLastPosition;
    private float mLastTime;
    private int mNumberOfStages;
    private float mStage1Duration;
    private float mStage1EndPosition;
    private float mStage1Velocity;
    private float mStage2Duration;
    private float mStage2EndPosition;
    private float mStage2Velocity;
    private float mStage3Duration;
    private float mStage3EndPosition;
    private float mStage3Velocity;
    private float mStartPosition;
    private String mType;

    /* loaded from: classes.dex */
    public static class Decelerate implements StopEngine {
        private float mAcceleration;
        private float mDestination;
        private boolean mDone = false;
        private float mDuration;
        private float mInitialPos;
        private float mInitialVelocity;
        private float mLastVelocity;

        public void config(float f, float f2, float f3) {
            this.mDone = false;
            this.mDestination = f2;
            this.mInitialVelocity = f3;
            this.mInitialPos = f;
            this.mDuration = (this.mDestination - f) / (f3 / 2.0f);
            this.mAcceleration = (-f3) / this.mDuration;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public String debug(String str, float f) {
            return this.mDuration + " " + this.mLastVelocity;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getInterpolation(float f) {
            if (f > this.mDuration) {
                this.mDone = true;
                return this.mDestination;
            }
            getVelocity(f);
            return this.mInitialPos + ((this.mInitialVelocity + ((this.mAcceleration * f) / 2.0f)) * f);
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getVelocity() {
            return this.mLastVelocity;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public float getVelocity(float f) {
            if (f > this.mDuration) {
                return 0.0f;
            }
            float f2 = this.mInitialVelocity + (this.mAcceleration * f);
            this.mLastVelocity = f2;
            return f2;
        }

        @Override // androidx.constraintlayout.core.motion.utils.StopEngine
        public boolean isStopped() {
            return this.mDone;
        }
    }

    private float calcY(float f) {
        this.mDone = false;
        if (f <= this.mStage1Duration) {
            return (this.mStage1Velocity * f) + ((((this.mStage2Velocity - this.mStage1Velocity) * f) * f) / (this.mStage1Duration * 2.0f));
        }
        if (this.mNumberOfStages == 1) {
            return this.mStage1EndPosition;
        }
        float f2 = f - this.mStage1Duration;
        if (f2 < this.mStage2Duration) {
            return this.mStage1EndPosition + (this.mStage2Velocity * f2) + ((((this.mStage3Velocity - this.mStage2Velocity) * f2) * f2) / (this.mStage2Duration * 2.0f));
        }
        if (this.mNumberOfStages == 2) {
            return this.mStage2EndPosition;
        }
        float f3 = f2 - this.mStage2Duration;
        if (f3 <= this.mStage3Duration) {
            return (this.mStage2EndPosition + (this.mStage3Velocity * f3)) - (((this.mStage3Velocity * f3) * f3) / (this.mStage3Duration * 2.0f));
        }
        this.mDone = true;
        return this.mStage3EndPosition;
    }

    private void setup(float f, float f2, float f3, float f4, float f5) {
        this.mDone = false;
        this.mStage3EndPosition = f2;
        if (f == 0.0f) {
            f = 1.0E-4f;
        }
        float f6 = f / f3;
        float f7 = (f6 * f) / 2.0f;
        if (f < 0.0f) {
            float sqrt = (float) Math.sqrt(f3 * (f2 - ((((-f) / f3) * f) / 2.0f)));
            if (sqrt < f4) {
                this.mType = "backward accelerate, decelerate";
                this.mNumberOfStages = 2;
                this.mStage1Velocity = f;
                this.mStage2Velocity = sqrt;
                this.mStage3Velocity = 0.0f;
                this.mStage1Duration = (sqrt - f) / f3;
                this.mStage2Duration = sqrt / f3;
                this.mStage1EndPosition = ((f + sqrt) * this.mStage1Duration) / 2.0f;
                this.mStage2EndPosition = f2;
                this.mStage3EndPosition = f2;
                return;
            }
            this.mType = "backward accelerate cruse decelerate";
            this.mNumberOfStages = 3;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f4;
            this.mStage3Velocity = f4;
            this.mStage1Duration = (f4 - f) / f3;
            this.mStage3Duration = f4 / f3;
            float f8 = ((f + f4) * this.mStage1Duration) / 2.0f;
            float f9 = (this.mStage3Duration * f4) / 2.0f;
            this.mStage2Duration = ((f2 - f8) - f9) / f4;
            this.mStage1EndPosition = f8;
            this.mStage2EndPosition = f2 - f9;
            this.mStage3EndPosition = f2;
            return;
        }
        if (f7 >= f2) {
            this.mType = "hard stop";
            this.mNumberOfStages = 1;
            this.mStage1Velocity = f;
            this.mStage2Velocity = 0.0f;
            this.mStage1EndPosition = f2;
            this.mStage1Duration = (2.0f * f2) / f;
            return;
        }
        float f10 = f2 - f7;
        float f11 = f10 / f;
        if (f11 + f6 < f5) {
            this.mType = "cruse decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = f;
            this.mStage3Velocity = 0.0f;
            this.mStage1EndPosition = f10;
            this.mStage2EndPosition = f2;
            this.mStage1Duration = f11;
            this.mStage2Duration = f / f3;
            return;
        }
        float sqrt2 = (float) Math.sqrt((f3 * f2) + ((f * f) / 2.0f));
        this.mStage1Duration = (sqrt2 - f) / f3;
        this.mStage2Duration = sqrt2 / f3;
        if (sqrt2 < f4) {
            this.mType = "accelerate decelerate";
            this.mNumberOfStages = 2;
            this.mStage1Velocity = f;
            this.mStage2Velocity = sqrt2;
            this.mStage3Velocity = 0.0f;
            this.mStage1Duration = (sqrt2 - f) / f3;
            this.mStage2Duration = sqrt2 / f3;
            this.mStage1EndPosition = ((f + sqrt2) * this.mStage1Duration) / 2.0f;
            this.mStage2EndPosition = f2;
            return;
        }
        this.mType = "accelerate cruse decelerate";
        this.mNumberOfStages = 3;
        this.mStage1Velocity = f;
        this.mStage2Velocity = f4;
        this.mStage3Velocity = f4;
        this.mStage1Duration = (f4 - f) / f3;
        this.mStage3Duration = f4 / f3;
        float f12 = ((f + f4) * this.mStage1Duration) / 2.0f;
        float f13 = (this.mStage3Duration * f4) / 2.0f;
        this.mStage2Duration = ((f2 - f12) - f13) / f4;
        this.mStage1EndPosition = f12;
        this.mStage2EndPosition = f2 - f13;
        this.mStage3EndPosition = f2;
    }

    public void config(float f, float f2, float f3, float f4, float f5, float f6) {
        this.mDone = false;
        this.mStartPosition = f;
        this.mBackwards = f > f2;
        if (this.mBackwards) {
            setup(-f3, f - f2, f5, f6, f4);
        } else {
            setup(f3, f2 - f, f5, f6, f4);
        }
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public String debug(String str, float f) {
        String str2 = ((str + " ===== " + this.mType + "\n") + str + (this.mBackwards ? "backwards" : "forward ") + " time = " + f + "  stages " + this.mNumberOfStages + "\n") + str + " dur " + this.mStage1Duration + " vel " + this.mStage1Velocity + " pos " + this.mStage1EndPosition + "\n";
        if (this.mNumberOfStages > 1) {
            str2 = str2 + str + " dur " + this.mStage2Duration + " vel " + this.mStage2Velocity + " pos " + this.mStage2EndPosition + "\n";
        }
        if (this.mNumberOfStages > 2) {
            str2 = str2 + str + " dur " + this.mStage3Duration + " vel " + this.mStage3Velocity + " pos " + this.mStage3EndPosition + "\n";
        }
        if (f <= this.mStage1Duration) {
            return str2 + str + "stage 0\n";
        }
        if (this.mNumberOfStages == 1) {
            return str2 + str + "end stage 0\n";
        }
        float f2 = f - this.mStage1Duration;
        return f2 < this.mStage2Duration ? str2 + str + " stage 1\n" : this.mNumberOfStages == 2 ? str2 + str + "end stage 1\n" : f2 - this.mStage2Duration < this.mStage3Duration ? str2 + str + " stage 2\n" : str2 + str + " end stage 2\n";
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getInterpolation(float f) {
        float calcY = calcY(f);
        this.mLastPosition = calcY;
        this.mLastTime = f;
        return this.mBackwards ? this.mStartPosition - calcY : this.mStartPosition + calcY;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity() {
        return this.mBackwards ? -getVelocity(this.mLastTime) : getVelocity(this.mLastTime);
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public float getVelocity(float f) {
        if (f <= this.mStage1Duration) {
            return this.mStage1Velocity + (((this.mStage2Velocity - this.mStage1Velocity) * f) / this.mStage1Duration);
        }
        if (this.mNumberOfStages == 1) {
            return 0.0f;
        }
        float f2 = f - this.mStage1Duration;
        if (f2 < this.mStage2Duration) {
            return this.mStage2Velocity + (((this.mStage3Velocity - this.mStage2Velocity) * f2) / this.mStage2Duration);
        }
        if (this.mNumberOfStages == 2) {
            return 0.0f;
        }
        float f3 = f2 - this.mStage2Duration;
        if (f3 < this.mStage3Duration) {
            return this.mStage3Velocity - ((this.mStage3Velocity * f3) / this.mStage3Duration);
        }
        return 0.0f;
    }

    @Override // androidx.constraintlayout.core.motion.utils.StopEngine
    public boolean isStopped() {
        return getVelocity() < EPSILON && Math.abs(this.mStage3EndPosition - this.mLastPosition) < EPSILON;
    }
}
