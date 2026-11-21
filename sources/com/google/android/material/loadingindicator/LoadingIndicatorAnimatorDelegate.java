package com.google.android.material.loadingindicator;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Property;
import androidx.core.math.MathUtils;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.animation.ArgbEvaluatorCompat;
import com.google.android.material.loadingindicator.LoadingIndicatorDrawingDelegate;

/* loaded from: classes.dex */
class LoadingIndicatorAnimatorDelegate {
    private static final int CONSTANT_ROTATION_PER_SHAPE_DEGREES = 50;
    private static final int DURATION_PER_SHAPE_IN_MS = 650;
    private static final int EXTRA_ROTATION_PER_SHAPE_DEGREES = 90;
    private static final float SPRING_DAMPING_RATIO = 0.6f;
    private static final float SPRING_STIFFNESS = 200.0f;
    private float animationFraction;
    private ObjectAnimator animator;
    LoadingIndicatorDrawable drawable;
    LoadingIndicatorDrawingDelegate.IndicatorState indicatorState = new LoadingIndicatorDrawingDelegate.IndicatorState();
    private float morphFactor;
    private int morphFactorTarget;
    LoadingIndicatorSpec specs;
    private SpringAnimation springAnimation;
    private static final Property<LoadingIndicatorAnimatorDelegate, Float> ANIMATION_FRACTION = new AnonymousClass2(Float.class, "animationFraction");
    private static final FloatPropertyCompat<LoadingIndicatorAnimatorDelegate> MORPH_FACTOR = new AnonymousClass3("morphFactor");

    /* renamed from: com.google.android.material.loadingindicator.LoadingIndicatorAnimatorDelegate$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            super.onAnimationRepeat(animator);
            LoadingIndicatorAnimatorDelegate.access$100(LoadingIndicatorAnimatorDelegate.this).animateToFinalPosition(LoadingIndicatorAnimatorDelegate.access$004(LoadingIndicatorAnimatorDelegate.this));
        }
    }

    /* renamed from: com.google.android.material.loadingindicator.LoadingIndicatorAnimatorDelegate$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends Property<LoadingIndicatorAnimatorDelegate, Float> {
        AnonymousClass2(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
            return Float.valueOf(LoadingIndicatorAnimatorDelegate.access$200(loadingIndicatorAnimatorDelegate));
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
            return get2(loadingIndicatorAnimatorDelegate);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate, Float f) {
            loadingIndicatorAnimatorDelegate.setAnimationFraction(f.floatValue());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate, Float f) {
            set2(loadingIndicatorAnimatorDelegate, f);
        }
    }

    /* renamed from: com.google.android.material.loadingindicator.LoadingIndicatorAnimatorDelegate$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends FloatPropertyCompat<LoadingIndicatorAnimatorDelegate> {
        AnonymousClass3(String str) {
            super(str);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
            return LoadingIndicatorAnimatorDelegate.access$300(loadingIndicatorAnimatorDelegate);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
            return getValue2(loadingIndicatorAnimatorDelegate);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate, float f) {
            loadingIndicatorAnimatorDelegate.setMorphFactor(f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate, float f) {
            setValue2(loadingIndicatorAnimatorDelegate, f);
        }
    }

    public LoadingIndicatorAnimatorDelegate(LoadingIndicatorSpec loadingIndicatorSpec) {
        this.specs = loadingIndicatorSpec;
    }

    static /* synthetic */ int access$004(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
        int i = loadingIndicatorAnimatorDelegate.morphFactorTarget + 1;
        loadingIndicatorAnimatorDelegate.morphFactorTarget = i;
        return i;
    }

    static /* synthetic */ SpringAnimation access$100(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
        return loadingIndicatorAnimatorDelegate.springAnimation;
    }

    static /* synthetic */ float access$200(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
        return loadingIndicatorAnimatorDelegate.getAnimationFraction();
    }

    static /* synthetic */ float access$300(LoadingIndicatorAnimatorDelegate loadingIndicatorAnimatorDelegate) {
        return loadingIndicatorAnimatorDelegate.getMorphFactor();
    }

    private float getAnimationFraction() {
        return this.animationFraction;
    }

    private float getMorphFactor() {
        return this.morphFactor;
    }

    private void maybeInitializeAnimators() {
        if (this.springAnimation == null) {
            this.springAnimation = new SpringAnimation(this, MORPH_FACTOR).setSpring(new SpringForce().setStiffness(200.0f).setDampingRatio(SPRING_DAMPING_RATIO)).setMinimumVisibleChange(0.01f);
        }
        if (this.animator == null) {
            this.animator = ObjectAnimator.ofFloat(this, ANIMATION_FRACTION, 0.0f, 1.0f);
            this.animator.setDuration(650L);
            this.animator.setInterpolator(null);
            this.animator.setRepeatCount(-1);
            this.animator.addListener(new AnonymousClass1());
        }
    }

    private void updateIndicatorRotation(int i) {
        float f = this.morphFactorTarget - 1;
        float f2 = this.morphFactor - f;
        float f3 = i / 650.0f;
        if (f3 == 1.0f) {
            f3 = 0.0f;
        }
        this.indicatorState.rotationDegree = 140.0f * f;
        this.indicatorState.rotationDegree += 50.0f * f3;
        this.indicatorState.rotationDegree += 90.0f * f2;
        this.indicatorState.rotationDegree %= 360.0f;
    }

    private void updateIndicatorShapeAndColor() {
        this.indicatorState.morphFraction = this.morphFactor;
        int length = (this.morphFactorTarget - 1) % this.specs.indicatorColors.length;
        int length2 = (length + 1) % this.specs.indicatorColors.length;
        this.indicatorState.color = ArgbEvaluatorCompat.getInstance().evaluate2(MathUtils.clamp(this.morphFactor - (this.morphFactorTarget - 1), 0.0f, 1.0f), Integer.valueOf(this.specs.indicatorColors[length]), Integer.valueOf(this.specs.indicatorColors[length2])).intValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void cancelAnimatorImmediately() {
        if (this.animator != null) {
            this.animator.cancel();
        }
        if (this.springAnimation != null) {
            this.springAnimation.skipToEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void invalidateSpecValues() {
        resetPropertiesForNewStart();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void registerDrawable(LoadingIndicatorDrawable loadingIndicatorDrawable) {
        this.drawable = loadingIndicatorDrawable;
    }

    void resetPropertiesForNewStart() {
        this.morphFactorTarget = 1;
        setMorphFactor(0.0f);
        this.indicatorState.color = this.specs.indicatorColors[0];
    }

    void setAnimationFraction(float f) {
        this.animationFraction = f;
        updateIndicatorRotation((int) (this.animationFraction * 650.0f));
        if (this.drawable != null) {
            this.drawable.invalidateSelf();
        }
    }

    void setMorphFactor(float f) {
        this.morphFactor = f;
        updateIndicatorShapeAndColor();
        if (this.drawable != null) {
            this.drawable.invalidateSelf();
        }
    }

    void setMorphFactorTarget(int i) {
        this.morphFactorTarget = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startAnimator() {
        maybeInitializeAnimators();
        resetPropertiesForNewStart();
        this.springAnimation.animateToFinalPosition(this.morphFactorTarget);
        this.animator.start();
    }
}
