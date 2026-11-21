package com.google.android.material.progressindicator;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import androidx.core.math.MathUtils;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes.dex */
public final class DeterminateDrawable<S extends BaseProgressIndicatorSpec> extends DrawableWithAnimatedVisibilityChange {
    private static final int AMPLITUDE_ANIMATION_DURATION_MS = 500;
    static final float FULL_AMPLITUDE_PROGRESS_MAX = 0.9f;
    static final float FULL_AMPLITUDE_PROGRESS_MIN = 0.1f;
    static final float GAP_RAMP_DOWN_THRESHOLD = 0.01f;
    private static final FloatPropertyCompat<DeterminateDrawable<?>> INDICATOR_LENGTH_IN_LEVEL = new AnonymousClass1("indicatorLevel");
    static final int MAX_DRAWABLE_LEVEL = 10000;
    private static final int PHASE_ANIMATION_DURATION_MS = 1000;
    private static final float SPRING_FORCE_STIFFNESS = 50.0f;
    private final DrawingDelegate.ActiveIndicator activeIndicator;
    private ValueAnimator amplitudeAnimator;
    private TimeInterpolator amplitudeInterpolator;
    private TimeInterpolator amplitudeOffInterpolator;
    private TimeInterpolator amplitudeOnInterpolator;
    private DrawingDelegate<S> drawingDelegate;
    private final ValueAnimator phaseAnimator;
    private boolean skipAnimationOnLevelChange;
    private final SpringAnimation springAnimation;
    private float targetAmplitudeFraction;

    /* renamed from: com.google.android.material.progressindicator.DeterminateDrawable$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends FloatPropertyCompat<DeterminateDrawable<?>> {
        AnonymousClass1(String str) {
            super(str);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(DeterminateDrawable<?> determinateDrawable) {
            return DeterminateDrawable.access$000((DeterminateDrawable) determinateDrawable) * 10000.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(DeterminateDrawable<?> determinateDrawable) {
            return getValue2(determinateDrawable);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(DeterminateDrawable<?> determinateDrawable, float f) {
            DeterminateDrawable.access$100(determinateDrawable, f / 10000.0f);
            DeterminateDrawable.access$200(determinateDrawable, (int) f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(DeterminateDrawable<?> determinateDrawable, float f) {
            setValue2(determinateDrawable, f);
        }
    }

    DeterminateDrawable(Context context, BaseProgressIndicatorSpec baseProgressIndicatorSpec, DrawingDelegate<S> drawingDelegate) {
        super(context, baseProgressIndicatorSpec);
        this.skipAnimationOnLevelChange = false;
        setDrawingDelegate(drawingDelegate);
        this.activeIndicator = new DrawingDelegate.ActiveIndicator();
        this.activeIndicator.isDeterminate = true;
        this.springAnimation = new SpringAnimation(this, (FloatPropertyCompat<DeterminateDrawable<S>>) INDICATOR_LENGTH_IN_LEVEL);
        this.springAnimation.setSpring(new SpringForce().setDampingRatio(1.0f).setStiffness(50.0f));
        this.phaseAnimator = new ValueAnimator();
        this.phaseAnimator.setDuration(1000L);
        this.phaseAnimator.setFloatValues(0.0f, 1.0f);
        this.phaseAnimator.setRepeatCount(-1);
        this.phaseAnimator.addUpdateListener(new DeterminateDrawable$$ExternalSyntheticLambda1(this, baseProgressIndicatorSpec));
        if (baseProgressIndicatorSpec.hasWavyEffect(true) && baseProgressIndicatorSpec.waveSpeed != 0) {
            this.phaseAnimator.start();
        }
        setGrowFraction(1.0f);
    }

    static /* synthetic */ float access$000(DeterminateDrawable determinateDrawable) {
        return determinateDrawable.getIndicatorFraction();
    }

    static /* synthetic */ void access$100(DeterminateDrawable determinateDrawable, float f) {
        determinateDrawable.setIndicatorFraction(f);
    }

    static /* synthetic */ void access$200(DeterminateDrawable determinateDrawable, int i) {
        determinateDrawable.maybeStartAmplitudeAnimator(i);
    }

    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        return createCircularDrawable(context, circularProgressIndicatorSpec, new CircularDrawingDelegate(circularProgressIndicatorSpec));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DeterminateDrawable<CircularProgressIndicatorSpec> createCircularDrawable(Context context, CircularProgressIndicatorSpec circularProgressIndicatorSpec, CircularDrawingDelegate circularDrawingDelegate) {
        return new DeterminateDrawable<>(context, circularProgressIndicatorSpec, circularDrawingDelegate);
    }

    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        return createLinearDrawable(context, linearProgressIndicatorSpec, new LinearDrawingDelegate(linearProgressIndicatorSpec));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static DeterminateDrawable<LinearProgressIndicatorSpec> createLinearDrawable(Context context, LinearProgressIndicatorSpec linearProgressIndicatorSpec, LinearDrawingDelegate linearDrawingDelegate) {
        return new DeterminateDrawable<>(context, linearProgressIndicatorSpec, linearDrawingDelegate);
    }

    private float getAmplitudeFractionFromLevel(int i) {
        return (((float) i) < this.baseSpec.waveAmplitudeRampProgressMin * 10000.0f || ((float) i) > this.baseSpec.waveAmplitudeRampProgressMax * 10000.0f) ? 0.0f : 1.0f;
    }

    private float getIndicatorFraction() {
        return this.activeIndicator.endFraction;
    }

    private void maybeInitializeAmplitudeAnimator() {
        if (this.amplitudeAnimator != null) {
            return;
        }
        this.amplitudeOnInterpolator = MotionUtils.resolveThemeInterpolator(this.context, R.attr.motionEasingStandardInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.amplitudeOffInterpolator = MotionUtils.resolveThemeInterpolator(this.context, R.attr.motionEasingEmphasizedAccelerateInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.amplitudeAnimator = new ValueAnimator();
        this.amplitudeAnimator.setDuration(500L);
        this.amplitudeAnimator.setFloatValues(0.0f, 1.0f);
        this.amplitudeAnimator.setInterpolator(null);
        this.amplitudeAnimator.addUpdateListener(new DeterminateDrawable$$ExternalSyntheticLambda0(this));
    }

    private void maybeStartAmplitudeAnimator(int i) {
        if (this.baseSpec.hasWavyEffect(true)) {
            maybeInitializeAmplitudeAnimator();
            float amplitudeFractionFromLevel = getAmplitudeFractionFromLevel(i);
            if (amplitudeFractionFromLevel == this.targetAmplitudeFraction) {
                if (this.amplitudeAnimator.isRunning()) {
                    return;
                }
                setAmplitudeFraction(amplitudeFractionFromLevel);
                return;
            }
            if (this.amplitudeAnimator.isRunning()) {
                this.amplitudeAnimator.cancel();
            }
            this.targetAmplitudeFraction = amplitudeFractionFromLevel;
            if (this.targetAmplitudeFraction == 1.0f) {
                this.amplitudeInterpolator = this.amplitudeOnInterpolator;
                this.amplitudeAnimator.start();
            } else {
                this.amplitudeInterpolator = this.amplitudeOffInterpolator;
                this.amplitudeAnimator.reverse();
            }
        }
    }

    private void setAmplitudeFraction(float f) {
        this.activeIndicator.amplitudeFraction = f;
        invalidateSelf();
    }

    private void setIndicatorFraction(float f) {
        this.activeIndicator.endFraction = f;
        invalidateSelf();
    }

    private void updateSpringMinVisibleChange() {
        int width = getBounds().width();
        int height = getBounds().height();
        if (width <= 0 || height <= 0) {
            return;
        }
        if (this.drawingDelegate instanceof LinearDrawingDelegate) {
            this.springAnimation.setMinimumVisibleChange(10000.0f / width);
        } else {
            this.springAnimation.setMinimumVisibleChange((float) (10000.0d / (Math.min(height, width) * 3.141592653589793d)));
        }
    }

    public void addSpringAnimationEndListener(DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        this.springAnimation.addEndListener(onAnimationEndListener);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void clearAnimationCallbacks() {
        super.clearAnimationCallbacks();
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (!getBounds().isEmpty() && isVisible() && canvas.getClipBounds(this.clipBounds)) {
            canvas.save();
            this.drawingDelegate.validateSpecAndAdjustCanvas(canvas, getBounds(), getGrowFraction(), isShowing(), isHiding());
            this.activeIndicator.phaseFraction = getPhaseFraction();
            this.paint.setStyle(Paint.Style.FILL);
            this.paint.setAntiAlias(true);
            this.activeIndicator.color = this.baseSpec.indicatorColors[0];
            if (this.baseSpec.indicatorTrackGapSize > 0) {
                this.drawingDelegate.fillTrack(canvas, this.paint, getIndicatorFraction(), 1.0f, this.baseSpec.trackColor, getAlpha(), this.drawingDelegate instanceof LinearDrawingDelegate ? this.baseSpec.indicatorTrackGapSize : (int) ((this.baseSpec.indicatorTrackGapSize * MathUtils.clamp(getIndicatorFraction(), 0.0f, GAP_RAMP_DOWN_THRESHOLD)) / GAP_RAMP_DOWN_THRESHOLD));
            } else {
                this.drawingDelegate.fillTrack(canvas, this.paint, 0.0f, 1.0f, this.baseSpec.trackColor, getAlpha(), 0);
            }
            this.drawingDelegate.fillIndicator(canvas, this.paint, this.activeIndicator, getAlpha());
            this.drawingDelegate.drawStopIndicator(canvas, this.paint, this.baseSpec.indicatorColors[0], getAlpha());
            canvas.restore();
        }
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public DrawingDelegate<S> getDrawingDelegate() {
        return this.drawingDelegate;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.drawingDelegate.getPreferredHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.drawingDelegate.getPreferredWidth();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public SpringForce getSpringForce() {
        return this.springAnimation.getSpring();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean hideNow() {
        return super.hideNow();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isHiding() {
        return super.isHiding();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ boolean isRunning() {
        return super.isRunning();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean isShowing() {
        return super.isShowing();
    }

    @Override // android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        this.springAnimation.skipToEnd();
        setIndicatorFraction(getLevel() / 10000.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$maybeInitializeAmplitudeAnimator$1$com-google-android-material-progressindicator-DeterminateDrawable, reason: not valid java name */
    public /* synthetic */ void m393x5e685e4b(ValueAnimator valueAnimator) {
        this.activeIndicator.amplitudeFraction = this.amplitudeInterpolator.getInterpolation(this.amplitudeAnimator.getAnimatedFraction());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-material-progressindicator-DeterminateDrawable, reason: not valid java name */
    public /* synthetic */ void m394x8c297d3e(BaseProgressIndicatorSpec baseProgressIndicatorSpec, ValueAnimator valueAnimator) {
        if (baseProgressIndicatorSpec.hasWavyEffect(true) && baseProgressIndicatorSpec.waveSpeed != 0 && isVisible()) {
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    protected boolean onLevelChange(int i) {
        float amplitudeFractionFromLevel = getAmplitudeFractionFromLevel(i);
        if (this.skipAnimationOnLevelChange) {
            this.springAnimation.skipToEnd();
            setIndicatorFraction(i / 10000.0f);
            setAmplitudeFraction(amplitudeFractionFromLevel);
            return true;
        }
        updateSpringMinVisibleChange();
        this.springAnimation.setStartValue(getIndicatorFraction() * 10000.0f);
        this.springAnimation.animateToFinalPosition(i);
        return true;
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ void registerAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        super.registerAnimationCallback(animationCallback);
    }

    public void removeSpringAnimationEndListener(DynamicAnimation.OnAnimationEndListener onAnimationEndListener) {
        this.springAnimation.removeEndListener(onAnimationEndListener);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    void setDrawingDelegate(DrawingDelegate<S> drawingDelegate) {
        this.drawingDelegate = drawingDelegate;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnforcedDrawing(boolean z) {
        if (z && !this.phaseAnimator.isRunning()) {
            this.phaseAnimator.start();
        } else {
            if (z || !this.phaseAnimator.isRunning()) {
                return;
            }
            this.phaseAnimator.cancel();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setLevelByFraction(float f) {
        setLevel((int) (10000.0f * f));
    }

    public void setSpringForce(SpringForce springForce) {
        this.springAnimation.setSpring(springForce);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Drawable
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2) {
        return super.setVisible(z, z2);
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public /* bridge */ /* synthetic */ boolean setVisible(boolean z, boolean z2, boolean z3) {
        return super.setVisible(z, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange
    public boolean setVisibleInternal(boolean z, boolean z2, boolean z3) {
        boolean visibleInternal = super.setVisibleInternal(z, z2, z3);
        float systemAnimatorDurationScale = this.animatorDurationScaleProvider.getSystemAnimatorDurationScale(this.context.getContentResolver());
        if (systemAnimatorDurationScale == 0.0f) {
            this.skipAnimationOnLevelChange = true;
        } else {
            this.skipAnimationOnLevelChange = false;
            this.springAnimation.getSpring().setStiffness(50.0f / systemAnimatorDurationScale);
        }
        return visibleInternal;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWaveAmplitudeRampProgressMax(float f) {
        this.baseSpec.waveAmplitudeRampProgressMax = f;
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWaveAmplitudeRampProgressMin(float f) {
        this.baseSpec.waveAmplitudeRampProgressMin = f;
        invalidateSelf();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void start() {
        super.start();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, android.graphics.drawable.Animatable
    public /* bridge */ /* synthetic */ void stop() {
        super.stop();
    }

    @Override // com.google.android.material.progressindicator.DrawableWithAnimatedVisibilityChange, androidx.vectordrawable.graphics.drawable.Animatable2Compat
    public /* bridge */ /* synthetic */ boolean unregisterAnimationCallback(Animatable2Compat.AnimationCallback animationCallback) {
        return super.unregisterAnimationCallback(animationCallback);
    }
}
