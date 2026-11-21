package androidx.dynamicanimation.animation;

import androidx.dynamicanimation.animation.DynamicAnimation;

/* loaded from: classes.dex */
public final class FlingAnimation extends DynamicAnimation<FlingAnimation> {
    private final DragForce mFlingForce;

    /* loaded from: classes.dex */
    static final class DragForce implements Force {
        private static final float DEFAULT_FRICTION = -4.2f;
        private static final float VELOCITY_THRESHOLD_MULTIPLIER = 62.5f;
        private float mFriction = DEFAULT_FRICTION;
        private final DynamicAnimation.MassState mMassState = new DynamicAnimation.MassState();
        private float mVelocityThreshold;

        DragForce() {
        }

        @Override // androidx.dynamicanimation.animation.Force
        public float getAcceleration(float f, float f2) {
            return this.mFriction * f2;
        }

        float getFrictionScalar() {
            return this.mFriction / DEFAULT_FRICTION;
        }

        @Override // androidx.dynamicanimation.animation.Force
        public boolean isAtEquilibrium(float f, float f2) {
            return Math.abs(f2) < this.mVelocityThreshold;
        }

        void setFrictionScalar(float f) {
            this.mFriction = DEFAULT_FRICTION * f;
        }

        void setValueThreshold(float f) {
            this.mVelocityThreshold = VELOCITY_THRESHOLD_MULTIPLIER * f;
        }

        DynamicAnimation.MassState updateValueAndVelocity(float f, float f2, long j) {
            this.mMassState.mVelocity = (float) (f2 * Math.exp((((float) j) / 1000.0f) * this.mFriction));
            this.mMassState.mValue = ((this.mMassState.mVelocity - f2) / this.mFriction) + f;
            if (isAtEquilibrium(this.mMassState.mValue, this.mMassState.mVelocity)) {
                this.mMassState.mVelocity = 0.0f;
            }
            return this.mMassState;
        }
    }

    public FlingAnimation(FloatValueHolder floatValueHolder) {
        super(floatValueHolder);
        this.mFlingForce = new DragForce();
        this.mFlingForce.setValueThreshold(getValueThreshold());
    }

    public <K> FlingAnimation(K k, FloatPropertyCompat<K> floatPropertyCompat) {
        super(k, floatPropertyCompat);
        this.mFlingForce = new DragForce();
        this.mFlingForce.setValueThreshold(getValueThreshold());
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    float getAcceleration(float f, float f2) {
        return this.mFlingForce.getAcceleration(f, f2);
    }

    public float getFriction() {
        return this.mFlingForce.getFrictionScalar();
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean isAtEquilibrium(float f, float f2) {
        return f >= this.mMaxValue || f <= this.mMinValue || this.mFlingForce.isAtEquilibrium(f, f2);
    }

    public FlingAnimation setFriction(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Friction must be positive");
        }
        this.mFlingForce.setFrictionScalar(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ FlingAnimation setMaxValue(float f) {
        return setMaxValue2(f);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    /* renamed from: setMaxValue, reason: avoid collision after fix types in other method */
    public FlingAnimation setMaxValue2(float f) {
        super.setMaxValue(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ FlingAnimation setMinValue(float f) {
        return setMinValue2(f);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    /* renamed from: setMinValue, reason: avoid collision after fix types in other method */
    public FlingAnimation setMinValue2(float f) {
        super.setMinValue(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    public /* bridge */ /* synthetic */ FlingAnimation setStartVelocity(float f) {
        return setStartVelocity2(f);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    /* renamed from: setStartVelocity, reason: avoid collision after fix types in other method */
    public FlingAnimation setStartVelocity2(float f) {
        super.setStartVelocity(f);
        return this;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    void setValueThreshold(float f) {
        this.mFlingForce.setValueThreshold(f);
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation
    boolean updateValueAndVelocity(long j) {
        DynamicAnimation.MassState updateValueAndVelocity = this.mFlingForce.updateValueAndVelocity(this.mValue, this.mVelocity, j);
        this.mValue = updateValueAndVelocity.mValue;
        this.mVelocity = updateValueAndVelocity.mVelocity;
        if (this.mValue < this.mMinValue) {
            this.mValue = this.mMinValue;
            return true;
        }
        if (this.mValue <= this.mMaxValue) {
            return isAtEquilibrium(this.mValue, this.mVelocity);
        }
        this.mValue = this.mMaxValue;
        return true;
    }
}
