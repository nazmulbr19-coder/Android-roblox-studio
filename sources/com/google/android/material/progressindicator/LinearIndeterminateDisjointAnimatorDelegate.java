package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.Property;
import android.view.animation.Interpolator;
import androidx.core.math.MathUtils;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimationUtilsCompat;
import com.google.android.material.R;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.Iterator;

/* loaded from: classes.dex */
final class LinearIndeterminateDisjointAnimatorDelegate extends IndeterminateAnimatorDelegate<ObjectAnimator> {
    private static final int TOTAL_DURATION_IN_MS = 1800;
    private float animationFraction;
    private ObjectAnimator animator;
    Animatable2Compat.AnimationCallback animatorCompleteCallback;
    private final BaseProgressIndicatorSpec baseSpec;
    private ObjectAnimator completeEndAnimator;
    private boolean dirtyColors;
    private int indicatorColorIndex;
    private final Interpolator[] interpolatorArray;
    private static final int[] DURATION_TO_MOVE_SEGMENT_ENDS = {533, 567, 850, 750};
    private static final int[] DELAY_TO_MOVE_SEGMENT_ENDS = {1267, 1000, 333, 0};
    private static final Property<LinearIndeterminateDisjointAnimatorDelegate, Float> ANIMATION_FRACTION = new AnonymousClass3(Float.class, "animationFraction");

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            LinearIndeterminateDisjointAnimatorDelegate.access$002(LinearIndeterminateDisjointAnimatorDelegate.this, (LinearIndeterminateDisjointAnimatorDelegate.access$000(LinearIndeterminateDisjointAnimatorDelegate.this) + 1) % LinearIndeterminateDisjointAnimatorDelegate.access$100(LinearIndeterminateDisjointAnimatorDelegate.this).indicatorColors.length);
            LinearIndeterminateDisjointAnimatorDelegate.access$202(LinearIndeterminateDisjointAnimatorDelegate.this, true);
        }
    }

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            LinearIndeterminateDisjointAnimatorDelegate.this.cancelAnimatorImmediately();
            if (LinearIndeterminateDisjointAnimatorDelegate.this.animatorCompleteCallback != null) {
                LinearIndeterminateDisjointAnimatorDelegate.this.animatorCompleteCallback.onAnimationEnd(LinearIndeterminateDisjointAnimatorDelegate.this.drawable);
            }
        }
    }

    /* renamed from: com.google.android.material.progressindicator.LinearIndeterminateDisjointAnimatorDelegate$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends Property<LinearIndeterminateDisjointAnimatorDelegate, Float> {
        AnonymousClass3(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
            return Float.valueOf(LinearIndeterminateDisjointAnimatorDelegate.access$300(linearIndeterminateDisjointAnimatorDelegate));
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
            return get2(linearIndeterminateDisjointAnimatorDelegate);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, Float f) {
            linearIndeterminateDisjointAnimatorDelegate.setAnimationFraction(f.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, Float f) {
            set2(linearIndeterminateDisjointAnimatorDelegate, f);
        }
    }

    public LinearIndeterminateDisjointAnimatorDelegate(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(2);
        this.indicatorColorIndex = 0;
        this.animatorCompleteCallback = null;
        this.baseSpec = linearProgressIndicatorSpec;
        this.interpolatorArray = new Interpolator[]{AnimationUtilsCompat.loadInterpolator(context, R.anim.linear_indeterminate_line1_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.anim.linear_indeterminate_line1_tail_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.anim.linear_indeterminate_line2_head_interpolator), AnimationUtilsCompat.loadInterpolator(context, R.anim.linear_indeterminate_line2_tail_interpolator)};
    }

    static /* synthetic */ int access$000(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
        return linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex;
    }

    static /* synthetic */ int access$002(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, int i) {
        linearIndeterminateDisjointAnimatorDelegate.indicatorColorIndex = i;
        return i;
    }

    static /* synthetic */ BaseProgressIndicatorSpec access$100(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
        return linearIndeterminateDisjointAnimatorDelegate.baseSpec;
    }

    static /* synthetic */ boolean access$202(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate, boolean z) {
        linearIndeterminateDisjointAnimatorDelegate.dirtyColors = z;
        return z;
    }

    static /* synthetic */ float access$300(LinearIndeterminateDisjointAnimatorDelegate linearIndeterminateDisjointAnimatorDelegate) {
        return linearIndeterminateDisjointAnimatorDelegate.getAnimationFraction();
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private void maybeInitializeAnimators() {
        if (this.animator == null) {
            this.animator = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator.setDuration(this.baseSpec.indeterminateAnimatorDurationScale * 1800.0f);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnonymousClass1());
        }
        if (this.completeEndAnimator == null) {
            this.completeEndAnimator = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 1.0f);
            this.completeEndAnimator.setDuration(this.baseSpec.indeterminateAnimatorDurationScale * 1800.0f);
            this.completeEndAnimator.setInterpolator(null);
            this.completeEndAnimator.addListener(new AnonymousClass2());
        }
    }

    private void maybeUpdateSegmentColors() {
        if (this.dirtyColors) {
            Iterator<DrawingDelegate.ActiveIndicator> it = this.activeIndicators.iterator();
            while (it.hasNext()) {
                it.next().color = this.baseSpec.indicatorColors[this.indicatorColorIndex];
            }
            this.dirtyColors = false;
        }
    }

    private void updateAnimatorsDuration() {
        maybeInitializeAnimators();
        this.animator.setDuration(this.baseSpec.indeterminateAnimatorDurationScale * 1800.0f);
        this.completeEndAnimator.setDuration(this.baseSpec.indeterminateAnimatorDurationScale * 1800.0f);
    }

    private void updateSegmentPositions(int i) {
        for (int i2 = 0; i2 < this.activeIndicators.size(); i2++) {
            DrawingDelegate.ActiveIndicator activeIndicator = this.activeIndicators.get(i2);
            activeIndicator.startFraction = MathUtils.clamp(this.interpolatorArray[i2 * 2].getInterpolation(getFractionInRange(i, DELAY_TO_MOVE_SEGMENT_ENDS[i2 * 2], DURATION_TO_MOVE_SEGMENT_ENDS[i2 * 2])), 0.0f, 1.0f);
            activeIndicator.endFraction = MathUtils.clamp(this.interpolatorArray[(i2 * 2) + 1].getInterpolation(getFractionInRange(i, DELAY_TO_MOVE_SEGMENT_ENDS[(i2 * 2) + 1], DURATION_TO_MOVE_SEGMENT_ENDS[(i2 * 2) + 1])), 0.0f, 1.0f);
        }
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
        this.animatorCompleteCallback = animationCallback;
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    public void requestCancelAnimatorAfterCurrentCycle() {
        if (this.completeEndAnimator == null || this.completeEndAnimator.isRunning()) {
            return;
        }
        cancelAnimatorImmediately();
        if (this.drawable.isVisible()) {
            this.completeEndAnimator.setFloatValues(this.animationFraction, 1.0f);
            this.completeEndAnimator.setDuration((1.0f - this.animationFraction) * 1800.0f);
            this.completeEndAnimator.start();
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void resetPropertiesForNewStart() {
        this.indicatorColorIndex = 0;
        Iterator<DrawingDelegate.ActiveIndicator> it = this.activeIndicators.iterator();
        while (it.hasNext()) {
            it.next().color = this.baseSpec.indicatorColors[0];
        }
    }

    @Override // com.google.android.material.progressindicator.IndeterminateAnimatorDelegate
    void setAnimationFraction(float f) {
        this.animationFraction = f;
        updateSegmentPositions((int) (this.animationFraction * 1800.0f));
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
        this.animatorCompleteCallback = null;
    }
}
