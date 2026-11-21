package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.math.MathUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes.dex */
final class CircularIndeterminateRetreatAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final int CONSTANT_ROTATION_DEGREES = 1080;
    private static final int DELAY_GROW_ACTIVE_IN_MS = 0;
    private static final int DELAY_SHRINK_ACTIVE_IN_MS = 3000;
    private static final int DURATION_GROW_ACTIVE_IN_MS = 3000;
    private static final int DURATION_SHRINK_ACTIVE_IN_MS = 3000;
    private static final int DURATION_SPIN_IN_MS = 500;
    private static final int DURATION_TO_COMPLETE_END_IN_MS = 500;
    private static final int DURATION_TO_FADE_IN_MS = 100;
    private static final int SPIN_ROTATION_DEGREES = 90;
    private static final float START_FRACTION = 0.0f;
    private static final int TOTAL_DURATION_IN_MS = 6000;
    private float animationFraction;
    private ObjectAnimator animator;
    Animatable2Compat.AnimationCallback animatorCompleteCallback;
    private final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private float completeEndFraction;
    private int indicatorColorIndexOffset;
    private final TimeInterpolator standardInterpolator;
    private static final TimeInterpolator DEFAULT_INTERPOLATOR = AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
    private static final int[] DELAY_SPINS_IN_MS = {0, 1500, PathInterpolatorCompat.MAX_NUM_POINTS, 4500};
    private static final float[] END_FRACTION_RANGE = {0.1f, 0.87f};
    private static final Property<CircularIndeterminateRetreatAnimatorDelegate, Float> ANIMATION_FRACTION = new AnonymousClass3(Float.class, "animationFraction");
    private static final Property<CircularIndeterminateRetreatAnimatorDelegate, Float> COMPLETE_END_FRACTION = new AnonymousClass4(Float.class, "completeEndFraction");

    /* renamed from: com.google.android.material.progressindicator.CircularIndeterminateRetreatAnimatorDelegate$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            CircularIndeterminateRetreatAnimatorDelegate.access$002(CircularIndeterminateRetreatAnimatorDelegate.this, (CircularIndeterminateRetreatAnimatorDelegate.access$000(CircularIndeterminateRetreatAnimatorDelegate.this) + CircularIndeterminateRetreatAnimatorDelegate.access$100().length) % CircularIndeterminateRetreatAnimatorDelegate.access$200(CircularIndeterminateRetreatAnimatorDelegate.this).indicatorColors.length);
        }
    }

    /* renamed from: com.google.android.material.progressindicator.CircularIndeterminateRetreatAnimatorDelegate$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            CircularIndeterminateRetreatAnimatorDelegate.this.cancelAnimatorImmediately();
            if (CircularIndeterminateRetreatAnimatorDelegate.this.animatorCompleteCallback != null) {
                CircularIndeterminateRetreatAnimatorDelegate.this.animatorCompleteCallback.onAnimationEnd(CircularIndeterminateRetreatAnimatorDelegate.this.drawable);
            }
        }
    }

    /* renamed from: com.google.android.material.progressindicator.CircularIndeterminateRetreatAnimatorDelegate$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends Property<CircularIndeterminateRetreatAnimatorDelegate, Float> {
        AnonymousClass3(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
            return Float.valueOf(CircularIndeterminateRetreatAnimatorDelegate.access$300(circularIndeterminateRetreatAnimatorDelegate));
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
            return get2(circularIndeterminateRetreatAnimatorDelegate);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate, Float f) {
            circularIndeterminateRetreatAnimatorDelegate.setAnimationFraction(f.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate, Float f) {
            set2(circularIndeterminateRetreatAnimatorDelegate, f);
        }
    }

    /* renamed from: com.google.android.material.progressindicator.CircularIndeterminateRetreatAnimatorDelegate$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends Property<CircularIndeterminateRetreatAnimatorDelegate, Float> {
        AnonymousClass4(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
            return Float.valueOf(CircularIndeterminateRetreatAnimatorDelegate.access$400(circularIndeterminateRetreatAnimatorDelegate));
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
            return get2(circularIndeterminateRetreatAnimatorDelegate);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate, Float f) {
            CircularIndeterminateRetreatAnimatorDelegate.access$500(circularIndeterminateRetreatAnimatorDelegate, f.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate, Float f) {
            set2(circularIndeterminateRetreatAnimatorDelegate, f);
        }
    }

    public CircularIndeterminateRetreatAnimatorDelegate(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(1);
        this.indicatorColorIndexOffset = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = circularProgressIndicatorSpec;
        this.standardInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingStandardInterpolator, DEFAULT_INTERPOLATOR);
    }

    static /* synthetic */ int access$000(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
        return circularIndeterminateRetreatAnimatorDelegate.indicatorColorIndexOffset;
    }

    static /* synthetic */ int access$002(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate, int i) {
        circularIndeterminateRetreatAnimatorDelegate.indicatorColorIndexOffset = i;
        return i;
    }

    static /* synthetic */ int[] access$100() {
        return DELAY_SPINS_IN_MS;
    }

    static /* synthetic */ BaseProgressIndicatorSpec access$200(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
        return circularIndeterminateRetreatAnimatorDelegate.baseSpec;
    }

    static /* synthetic */ float access$300(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
        return circularIndeterminateRetreatAnimatorDelegate.getAnimationFraction();
    }

    static /* synthetic */ float access$400(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate) {
        return circularIndeterminateRetreatAnimatorDelegate.getCompleteEndFraction();
    }

    static /* synthetic */ void access$500(CircularIndeterminateRetreatAnimatorDelegate circularIndeterminateRetreatAnimatorDelegate, float f) {
        circularIndeterminateRetreatAnimatorDelegate.setCompleteEndFraction(f);
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private float getCompleteEndFraction() {
        return this.completeEndFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator == null) {
            this.animator = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator.setDuration(this.baseSpec.indeterminateAnimatorDurationScale * 6000.0f);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnonymousClass1());
        }
        if (this.completeEndAnimator == null) {
            this.completeEndAnimator = ObjectAnimator.ofFloat(this, COMPLETE_END_FRACTION, 0.0f, 1.0f);
            this.completeEndAnimator.setDuration(this.baseSpec.indeterminateAnimatorDurationScale * 500.0f);
            this.completeEndAnimator.addListener(new AnonymousClass2());
        }
    }

    private void maybeUpdateSegmentColors(int i) {
        for (int i2 = 0; i2 < DELAY_SPINS_IN_MS.length; i2++) {
            float fractionInRange = getFractionInRange(i, DELAY_SPINS_IN_MS[i2], 100);
            if (fractionInRange >= 0.0f && fractionInRange <= 1.0f) {
                int length = (this.indicatorColorIndexOffset + i2) % this.baseSpec.indicatorColors.length;
                int length2 = (length + 1) % this.baseSpec.indicatorColors.length;
                int i3 = this.baseSpec.indicatorColors[length];
                int i4 = this.baseSpec.indicatorColors[length2];
                float interpolation = this.standardInterpolator.getInterpolation(fractionInRange);
                this.activeIndicators.get(0).color = ArgbEvaluatorCompat.getInstance().evaluate2(interpolation, Integer.valueOf(i3), Integer.valueOf(i4)).intValue();
                return;
            }
        }
    }

    private void setCompleteEndFraction(float f) {
        this.completeEndFraction = f;
    }

    private void updateAnimatorsDuration() {
        maybeInitializeAnimators();
        this.animator.setDuration(this.baseSpec.indeterminateAnimatorDurationScale * 6000.0f);
        this.completeEndAnimator.setDuration(this.baseSpec.indeterminateAnimatorDurationScale * 500.0f);
    }

    private void updateSegmentPositions(int i) {
        DrawingDelegate.ActiveIndicator activeIndicator = this.activeIndicators.get(0);
        float f = this.animationFraction * 1080.0f;
        float f2 = 0.0f;
        for (int i2 : DELAY_SPINS_IN_MS) {
            f2 += this.standardInterpolator.getInterpolation(getFractionInRange(i, i2, 500)) * 90.0f;
        }
        activeIndicator.rotationDegree = f + f2;
        float interpolation = this.standardInterpolator.getInterpolation(getFractionInRange(i, 0, PathInterpolatorCompat.MAX_NUM_POINTS)) - this.standardInterpolator.getInterpolation(getFractionInRange(i, PathInterpolatorCompat.MAX_NUM_POINTS, PathInterpolatorCompat.MAX_NUM_POINTS));
        activeIndicator.startFraction = 0.0f;
        activeIndicator.endFraction = MathUtils.lerp(END_FRACTION_RANGE[0], END_FRACTION_RANGE[1], interpolation);
        if (this.completeEndFraction > 0.0f) {
            activeIndicator.endFraction *= 1.0f - this.completeEndFraction;
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void cancelAnimatorImmediately() {
        if (this.animator != null) {
            this.animator.cancel();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void invalidateSpecValues() {
        updateAnimatorsDuration();
        resetPropertiesForNewStart();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void registerAnimatorsCompleteCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.animatorCompleteCallback = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void requestCancelAnimatorAfterCurrentCycle() {
        if (this.completeEndAnimator == null || this.completeEndAnimator.isRunning()) {
            return;
        }
        if (this.drawable.isVisible()) {
            this.completeEndAnimator.start();
        } else {
            cancelAnimatorImmediately();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void resetPropertiesForNewStart() {
        this.indicatorColorIndexOffset = 0;
        this.activeIndicators.get(0).color = this.baseSpec.indicatorColors[0];
        this.completeEndFraction = 0.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void setAnimationFraction(float f) {
        this.animationFraction = f;
        int i = (int) (this.animationFraction * 6000.0f);
        updateSegmentPositions(i);
        maybeUpdateSegmentColors(i);
        this.drawable.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void unregisterAnimatorsCompleteCallback() {
        this.animatorCompleteCallback = null;
    }
}
