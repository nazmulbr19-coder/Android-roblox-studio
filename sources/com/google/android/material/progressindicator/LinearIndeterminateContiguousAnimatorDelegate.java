package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes.dex */
final class LinearIndeterminateContiguousAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final Property<LinearIndeterminateContiguousAnimatorDelegate, Float> ANIMATION_FRACTION = new AnonymousClass2(Float.class, "animationFraction");
    private static final int DURATION_PER_CYCLE_IN_MS = 333;
    private static final int TOTAL_DURATION_IN_MS = 667;
    private float animationFraction;
    private ObjectAnimator animator;
    private final BaseProgressIndicatorSpec baseSpec;
    private boolean dirtyColors;
    private FastOutSlowInInterpolator interpolator;
    private int newIndicatorColorIndex;

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            LinearIndeterminateContiguousAnimatorDelegate.access$002(LinearIndeterminateContiguousAnimatorDelegate.this, (LinearIndeterminateContiguousAnimatorDelegate.access$000(LinearIndeterminateContiguousAnimatorDelegate.this) + 1) % LinearIndeterminateContiguousAnimatorDelegate.access$100(LinearIndeterminateContiguousAnimatorDelegate.this).indicatorColors.length);
            LinearIndeterminateContiguousAnimatorDelegate.access$202(LinearIndeterminateContiguousAnimatorDelegate.this, true);
        }
    }

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateContiguousAnimatorDelegate$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends Property<LinearIndeterminateContiguousAnimatorDelegate, Float> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
            return Float.valueOf(LinearIndeterminateContiguousAnimatorDelegate.access$300(linearIndeterminateContiguousAnimatorDelegate));
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
            return get2(linearIndeterminateContiguousAnimatorDelegate);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate, Float f) {
            linearIndeterminateContiguousAnimatorDelegate.setAnimationFraction(f.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate, Float f) {
            set2(linearIndeterminateContiguousAnimatorDelegate, f);
        }
    }

    public LinearIndeterminateContiguousAnimatorDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(3);
        this.newIndicatorColorIndex = 1;
        this.baseSpec = linearProgressIndicatorSpec;
        this.interpolator = new FastOutSlowInInterpolator();
    }

    static /* synthetic */ int access$000(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
        return linearIndeterminateContiguousAnimatorDelegate.newIndicatorColorIndex;
    }

    static /* synthetic */ int access$002(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate, int i) {
        linearIndeterminateContiguousAnimatorDelegate.newIndicatorColorIndex = i;
        return i;
    }

    static /* synthetic */ BaseProgressIndicatorSpec access$100(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
        return linearIndeterminateContiguousAnimatorDelegate.baseSpec;
    }

    static /* synthetic */ boolean access$202(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate, boolean z) {
        linearIndeterminateContiguousAnimatorDelegate.dirtyColors = z;
        return z;
    }

    static /* synthetic */ float access$300(LinearIndeterminateContiguousAnimatorDelegate linearIndeterminateContiguousAnimatorDelegate) {
        return linearIndeterminateContiguousAnimatorDelegate.getAnimationFraction();
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator == null) {
            this.animator = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator.setDuration(this.baseSpec.indeterminateAnimatorDurationScale * 333.0f);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnonymousClass1());
        }
    }

    private void maybeUpdateSegmentColors() {
        if (!this.dirtyColors || this.activeIndicators.get(1).endFraction >= 1.0f) {
            return;
        }
        this.activeIndicators.get(2).color = this.activeIndicators.get(1).color;
        this.activeIndicators.get(1).color = this.activeIndicators.get(0).color;
        this.activeIndicators.get(0).color = this.baseSpec.indicatorColors[this.newIndicatorColorIndex];
        this.dirtyColors = false;
    }

    private void updateAnimatorsDuration() {
        maybeInitializeAnimators();
        this.animator.setDuration(this.baseSpec.indeterminateAnimatorDurationScale * 333.0f);
    }

    private void updateSegmentPositions(int i) {
        this.activeIndicators.get(0).startFraction = 0.0f;
        float fractionInRange = getFractionInRange(i, 0, TOTAL_DURATION_IN_MS);
        DrawingDelegate.ActiveIndicator activeIndicator = this.activeIndicators.get(0);
        DrawingDelegate.ActiveIndicator activeIndicator2 = this.activeIndicators.get(1);
        float interpolation = this.interpolator.getInterpolation(fractionInRange);
        activeIndicator2.startFraction = interpolation;
        activeIndicator.endFraction = interpolation;
        DrawingDelegate.ActiveIndicator activeIndicator3 = this.activeIndicators.get(1);
        DrawingDelegate.ActiveIndicator activeIndicator4 = this.activeIndicators.get(2);
        float interpolation2 = this.interpolator.getInterpolation(fractionInRange + 0.49925038f);
        activeIndicator4.startFraction = interpolation2;
        activeIndicator3.endFraction = interpolation2;
        this.activeIndicators.get(2).endFraction = 1.0f;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void cancelAnimatorImmediately() {
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
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void resetPropertiesForNewStart() {
        this.dirtyColors = true;
        this.newIndicatorColorIndex = 1;
        for (DrawingDelegate.ActiveIndicator activeIndicator : this.activeIndicators) {
            activeIndicator.color = this.baseSpec.indicatorColors[0];
            activeIndicator.gapSize = this.baseSpec.indicatorTrackGapSize / 2;
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void setAnimationFraction(float f) {
        this.animationFraction = f;
        updateSegmentPositions((int) (this.animationFraction * 333.0f));
        maybeUpdateSegmentColors();
        this.drawable.invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.animator.start();
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void unregisterAnimatorsCompleteCallback() {
    }
}
