package com.google.android.material.progressindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.Property;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
abstract class DrawableWithAnimatedVisibilityChange extends Drawable implements Animatable2Compat {
    private static final boolean DEFAULT_DRAWABLE_RESTART = false;
    private static final float DEFAULT_MOCK_PHASE_FRACTION = -1.0f;
    private static final int GROW_DURATION = 500;
    private static final Property<DrawableWithAnimatedVisibilityChange, Float> GROW_FRACTION = new AnonymousClass3(Float.class, "growFraction");
    private List<Animatable2Compat.AnimationCallback> animationCallbacks;
    final BaseProgressIndicatorSpec baseSpec;
    final Context context;
    private float growFraction;
    private ValueAnimator hideAnimator;
    private boolean ignoreCallbacks;
    private Animatable2Compat.AnimationCallback internalAnimationCallback;
    private float mockGrowFraction;
    private boolean mockHideAnimationRunning;
    private boolean mockShowAnimationRunning;
    private ValueAnimator showAnimator;
    private int totalAlpha;
    private float mockPhaseFraction = DEFAULT_MOCK_PHASE_FRACTION;
    final Paint paint = new Paint();
    Rect clipBounds = new Rect();
    AnimatorDurationScaleProvider animatorDurationScaleProvider = new AnimatorDurationScaleProvider();

    /* renamed from: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            DrawableWithAnimatedVisibilityChange.access$000(DrawableWithAnimatedVisibilityChange.this);
        }
    }

    /* renamed from: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            DrawableWithAnimatedVisibilityChange.access$101(DrawableWithAnimatedVisibilityChange.this, false, false);
            DrawableWithAnimatedVisibilityChange.access$200(DrawableWithAnimatedVisibilityChange.this);
        }
    }

    /* renamed from: com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends Property<DrawableWithAnimatedVisibilityChange, Float> {
        AnonymousClass3(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return Float.valueOf(drawableWithAnimatedVisibilityChange.getGrowFraction());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
            return get2(drawableWithAnimatedVisibilityChange);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f) {
            drawableWithAnimatedVisibilityChange.setGrowFraction(f.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, Float f) {
            set2(drawableWithAnimatedVisibilityChange, f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawableWithAnimatedVisibilityChange(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.context = context;
        this.baseSpec = baseProgressIndicatorSpec;
        setAlpha(255);
    }

    static /* synthetic */ void access$000(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
        drawableWithAnimatedVisibilityChange.dispatchAnimationStart();
    }

    static /* synthetic */ boolean access$101(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange, boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    static /* synthetic */ void access$200(DrawableWithAnimatedVisibilityChange drawableWithAnimatedVisibilityChange) {
        drawableWithAnimatedVisibilityChange.dispatchAnimationEnd();
    }

    private void cancelAnimatorsWithoutCallbacks(ValueAnimator... valueAnimatorArr) {
        boolean z = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.cancel();
        }
        this.ignoreCallbacks = z;
    }

    private void dispatchAnimationEnd() {
        if (this.internalAnimationCallback != null) {
            this.internalAnimationCallback.onAnimationEnd(this);
        }
        if (this.animationCallbacks == null || this.ignoreCallbacks) {
            return;
        }
        Iterator<Animatable2Compat.AnimationCallback> it = this.animationCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this);
        }
    }

    private void dispatchAnimationStart() {
        if (this.internalAnimationCallback != null) {
            this.internalAnimationCallback.onAnimationStart(this);
        }
        if (this.animationCallbacks == null || this.ignoreCallbacks) {
            return;
        }
        Iterator<Animatable2Compat.AnimationCallback> it = this.animationCallbacks.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this);
        }
    }

    private void endAnimatorsWithoutCallbacks(ValueAnimator... valueAnimatorArr) {
        boolean z = this.ignoreCallbacks;
        this.ignoreCallbacks = true;
        for (ValueAnimator valueAnimator : valueAnimatorArr) {
            valueAnimator.end();
        }
        this.ignoreCallbacks = z;
    }

    private boolean isDeterminateDrawable() {
        return this instanceof DeterminateDrawable;
    }

    private void maybeInitializeAnimators() {
        if (this.showAnimator == null) {
            this.showAnimator = ObjectAnimator.ofFloat(this, GROW_FRACTION, 0.0f, 1.0f);
            this.showAnimator.setDuration(500L);
            this.showAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            setShowAnimator(this.showAnimator);
        }
        if (this.hideAnimator == null) {
            this.hideAnimator = ObjectAnimator.ofFloat(this, GROW_FRACTION, 1.0f, 0.0f);
            this.hideAnimator.setDuration(500L);
            this.hideAnimator.setInterpolator(AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
            setHideAnimator(this.hideAnimator);
        }
    }

    private void setHideAnimator(ValueAnimator valueAnimator) {
        if (this.hideAnimator != null && this.hideAnimator.isRunning()) {
            throw new IllegalArgumentException("Cannot set hideAnimator while the current hideAnimator is running.");
        }
        this.hideAnimator = valueAnimator;
        valueAnimator.addListener(new AnonymousClass2());
    }

    private void setShowAnimator(ValueAnimator valueAnimator) {
        if (this.showAnimator != null && this.showAnimator.isRunning()) {
            throw new IllegalArgumentException("Cannot set showAnimator while the current showAnimator is running.");
        }
        this.showAnimator = valueAnimator;
        valueAnimator.addListener(new AnonymousClass1());
    }

    public void clearAnimationCallbacks() {
        this.animationCallbacks.clear();
        this.animationCallbacks = null;
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.totalAlpha;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getGrowFraction() {
        if (this.baseSpec.isShowAnimationEnabled() || this.baseSpec.isHideAnimationEnabled()) {
            return (this.mockHideAnimationRunning || this.mockShowAnimationRunning) ? this.mockGrowFraction : this.growFraction;
        }
        return 1.0f;
    }

    ValueAnimator getHideAnimator() {
        return this.hideAnimator;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getPhaseFraction() {
        if (this.mockPhaseFraction > 0.0f) {
            return this.mockPhaseFraction;
        }
        if (!this.baseSpec.hasWavyEffect(isDeterminateDrawable()) || this.baseSpec.waveSpeed == 0) {
            return 0.0f;
        }
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (systemAnimatorDurationScale <= 0.0f) {
            return 0.0f;
        }
        int i = (int) ((((isDeterminateDrawable() ? this.baseSpec.wavelengthDeterminate : this.baseSpec.wavelengthIndeterminate) * 1000.0f) / this.baseSpec.waveSpeed) * systemAnimatorDurationScale);
        float uptimeMillis = ((float) (SystemClock.uptimeMillis() % i)) / i;
        return uptimeMillis < 0.0f ? (uptimeMillis % 1.0f) + 1.0f : uptimeMillis;
    }

    public boolean hideNow() {
        return setVisible(false, false, false);
    }

    public boolean isHiding() {
        return (this.hideAnimator != null && this.hideAnimator.isRunning()) || this.mockHideAnimationRunning;
    }

    public boolean isRunning() {
        return isShowing() || isHiding();
    }

    public boolean isShowing() {
        return (this.showAnimator != null && this.showAnimator.isRunning()) || this.mockShowAnimationRunning;
    }

    public void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (this.animationCallbacks == null) {
            this.animationCallbacks = new ArrayList();
        }
        if (this.animationCallbacks.contains(animationCallback)) {
            return;
        }
        this.animationCallbacks.add(animationCallback);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.totalAlpha = i;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setGrowFraction(float f) {
        if (this.growFraction != f) {
            this.growFraction = f;
            invalidateSelf();
        }
    }

    void setInternalAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        this.internalAnimationCallback = animationCallback;
    }

    void setMockHideAnimationRunning(boolean z, float f) {
        this.mockHideAnimationRunning = z;
        this.mockGrowFraction = f;
    }

    void setMockPhaseFraction(float f) {
        this.mockPhaseFraction = f;
    }

    void setMockShowAnimationRunning(boolean z, float f) {
        this.mockShowAnimationRunning = z;
        this.mockGrowFraction = f;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        return setVisible(z, z2, true);
    }

    public boolean setVisible(boolean z, boolean z2, boolean z3) {
        return setVisibleInternal(z, z2, z3 && this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver()) > 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        maybeInitializeAnimators();
        if (!isVisible() && !z) {
            return false;
        }
        ValueAnimator valueAnimator = z ? this.showAnimator : this.hideAnimator;
        ValueAnimator valueAnimator2 = z ? this.hideAnimator : this.showAnimator;
        if (!z3) {
            if (valueAnimator2.isRunning()) {
                cancelAnimatorsWithoutCallbacks(valueAnimator2);
            }
            if (valueAnimator.isRunning()) {
                valueAnimator.end();
            } else {
                endAnimatorsWithoutCallbacks(valueAnimator);
            }
            return super.setVisible(z, false);
        }
        if (valueAnimator.isRunning()) {
            return false;
        }
        boolean z4 = !z || super.setVisible(z, false);
        BaseProgressIndicatorSpec baseProgressIndicatorSpec = this.baseSpec;
        if (!(z ? baseProgressIndicatorSpec.isShowAnimationEnabled() : baseProgressIndicatorSpec.isHideAnimationEnabled())) {
            endAnimatorsWithoutCallbacks(valueAnimator);
            return z4;
        }
        if (z2 || !valueAnimator.isPaused()) {
            valueAnimator.start();
        } else {
            valueAnimator.resume();
        }
        return z4;
    }

    public void start() {
        setVisibleInternal(true, true, false);
    }

    public void stop() {
        setVisibleInternal(false, true, false);
    }

    public boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        if (this.animationCallbacks == null || !this.animationCallbacks.contains(animationCallback)) {
            return false;
        }
        this.animationCallbacks.remove(animationCallback);
        if (!this.animationCallbacks.isEmpty()) {
            return true;
        }
        this.animationCallbacks = null;
        return true;
    }
}
