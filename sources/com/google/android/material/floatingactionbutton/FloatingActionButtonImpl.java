package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.FloatEvaluator;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.core.content.ContextCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.focus.FocusRingDrawable;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes.dex */
class FloatingActionButtonImpl {
    static final int ANIM_STATE_HIDING = 1;
    static final int ANIM_STATE_NONE = 0;
    static final int ANIM_STATE_SHOWING = 2;
    static final long ELEVATION_ANIM_DELAY = 100;
    static final long ELEVATION_ANIM_DURATION = 100;
    private static final float HIDE_ICON_SCALE = 0.4f;
    private static final float HIDE_OPACITY = 0.0f;
    private static final float HIDE_SCALE = 0.4f;
    static final float SHADOW_MULTIPLIER = 1.5f;
    private static final float SHOW_ICON_SCALE = 1.0f;
    private static final float SHOW_OPACITY = 1.0f;
    private static final float SHOW_SCALE = 1.0f;
    private static final float SPEC_HIDE_ICON_SCALE = 0.0f;
    private static final float SPEC_HIDE_SCALE = 0.0f;
    BorderDrawable borderDrawable;
    Drawable contentBackground;
    private Animator currentAnimator;
    float elevation;
    boolean ensureMinTouchTargetSize;
    private ArrayList<Animator.AnimatorListener> hideListeners;
    private MotionSpec hideMotionSpec;
    float hoveredFocusedTranslationZ;
    private int maxImageSize;
    int minTouchTargetSize;
    private ViewTreeObserver.OnPreDrawListener preDrawListener;
    float pressedTranslationZ;
    Drawable rippleDrawable;
    final ShadowViewDelegate shadowViewDelegate;
    ShapeAppearanceModel shapeAppearance;
    MaterialShapeDrawable shapeDrawable;
    private ArrayList<Animator.AnimatorListener> showListeners;
    private MotionSpec showMotionSpec;
    private StateListAnimator stateListAnimator;
    private ArrayList<InternalTransformationCallback> transformationCallbacks;
    final FloatingActionButton view;
    static final TimeInterpolator ELEVATION_ANIM_INTERPOLATOR = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
    private static final int SHOW_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int SHOW_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final int HIDE_ANIM_DURATION_ATTR = R.attr.motionDurationMedium1;
    private static final int HIDE_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;
    static final int[] PRESSED_ENABLED_STATE_SET = {android.R.attr.state_pressed, android.R.attr.state_enabled};
    static final int[] HOVERED_FOCUSED_ENABLED_STATE_SET = {android.R.attr.state_hovered, android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] FOCUSED_ENABLED_STATE_SET = {android.R.attr.state_focused, android.R.attr.state_enabled};
    static final int[] HOVERED_ENABLED_STATE_SET = {android.R.attr.state_hovered, android.R.attr.state_enabled};
    static final int[] ENABLED_STATE_SET = {android.R.attr.state_enabled};
    static final int[] EMPTY_STATE_SET = new int[0];
    boolean shadowPaddingEnabled = true;
    private float imageMatrixScale = 1.0f;
    private int animState = 0;
    private final Rect tmpRect = new Rect();
    private final RectF tmpRectF1 = new RectF();
    private final RectF tmpRectF2 = new RectF();
    private final Matrix tmpMatrix = new Matrix();

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        private boolean cancelled;
        final /* synthetic */ boolean val$fromUser;
        final /* synthetic */ InternalVisibilityChangedListener val$listener;

        AnonymousClass1(boolean z, InternalVisibilityChangedListener internalVisibilityChangedListener) {
            this.val$fromUser = z;
            this.val$listener = internalVisibilityChangedListener;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.cancelled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.access$002(FloatingActionButtonImpl.this, 0);
            FloatingActionButtonImpl.access$102(FloatingActionButtonImpl.this, null);
            if (this.cancelled) {
                return;
            }
            FloatingActionButtonImpl.this.view.internalSetVisibility(this.val$fromUser ? 8 : 4, this.val$fromUser);
            if (this.val$listener != null) {
                this.val$listener.onHidden();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FloatingActionButtonImpl.this.view.internalSetVisibility(0, this.val$fromUser);
            FloatingActionButtonImpl.access$002(FloatingActionButtonImpl.this, 1);
            FloatingActionButtonImpl.access$102(FloatingActionButtonImpl.this, animator);
            this.cancelled = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ boolean val$fromUser;
        final /* synthetic */ InternalVisibilityChangedListener val$listener;

        AnonymousClass2(boolean z, InternalVisibilityChangedListener internalVisibilityChangedListener) {
            this.val$fromUser = z;
            this.val$listener = internalVisibilityChangedListener;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            FloatingActionButtonImpl.access$002(FloatingActionButtonImpl.this, 0);
            FloatingActionButtonImpl.access$102(FloatingActionButtonImpl.this, null);
            if (this.val$listener != null) {
                this.val$listener.onShown();
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            FloatingActionButtonImpl.this.view.internalSetVisibility(0, this.val$fromUser);
            FloatingActionButtonImpl.access$002(FloatingActionButtonImpl.this, 2);
            FloatingActionButtonImpl.access$102(FloatingActionButtonImpl.this, animator);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends MatrixEvaluator {
        AnonymousClass3() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.material.animation.MatrixEvaluator
        public Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            FloatingActionButtonImpl.access$202(FloatingActionButtonImpl.this, f);
            return super.evaluate2(f, matrix, matrix2);
        }

        @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Matrix evaluate(float f, Matrix matrix, Matrix matrix2) {
            return evaluate(f, matrix, matrix2);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.FloatingActionButtonImpl$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 implements TypeEvaluator<Float> {
        final FloatEvaluator floatEvaluator = new FloatEvaluator();

        AnonymousClass4() {
        }

        /* renamed from: evaluate, reason: avoid collision after fix types in other method */
        public Float evaluate2(float f, Float f2, Float f3) {
            float floatValue = this.floatEvaluator.evaluate(f, (Number) f2, (Number) f3).floatValue();
            return Float.valueOf(floatValue < 0.1f ? 0.0f : floatValue);
        }

        @Override // android.animation.TypeEvaluator
        public /* bridge */ /* synthetic */ Float evaluate(float f, Float f2, Float f3) {
            return evaluate2(f, f2, f3);
        }
    }

    /* loaded from: classes.dex */
    static class AlwaysStatefulMaterialShapeDrawable extends MaterialShapeDrawable {
        AlwaysStatefulMaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    /* loaded from: classes.dex */
    interface InternalTransformationCallback {
        void onScaleChanged();

        void onTranslationChanged();
    }

    /* loaded from: classes.dex */
    interface InternalVisibilityChangedListener {
        void onHidden();

        void onShown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FloatingActionButtonImpl(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.view = floatingActionButton;
        this.shadowViewDelegate = shadowViewDelegate;
    }

    static /* synthetic */ int access$002(FloatingActionButtonImpl floatingActionButtonImpl, int i) {
        floatingActionButtonImpl.animState = i;
        return i;
    }

    static /* synthetic */ Animator access$102(FloatingActionButtonImpl floatingActionButtonImpl, Animator animator) {
        floatingActionButtonImpl.currentAnimator = animator;
        return animator;
    }

    static /* synthetic */ float access$202(FloatingActionButtonImpl floatingActionButtonImpl, float f) {
        floatingActionButtonImpl.imageMatrixScale = f;
        return f;
    }

    private void calculateImageMatrixFromScale(float f, Matrix matrix) {
        matrix.reset();
        if (this.view.getDrawable() == null || this.maxImageSize == 0) {
            return;
        }
        RectF rectF = this.tmpRectF1;
        RectF rectF2 = this.tmpRectF2;
        rectF.set(0.0f, 0.0f, r0.getIntrinsicWidth(), r0.getIntrinsicHeight());
        rectF2.set(0.0f, 0.0f, this.maxImageSize, this.maxImageSize);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        matrix.postScale(f, f, this.maxImageSize / 2.0f, this.maxImageSize / 2.0f);
    }

    private AnimatorSet createAnimator(MotionSpec motionSpec, float f, float f2, float f3) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.ALPHA, f);
        motionSpec.getTiming("opacity").apply(ofFloat);
        arrayList.add(ofFloat);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.SCALE_X, f2);
        motionSpec.getTiming("scale").apply(ofFloat2);
        workAroundOreoBug(ofFloat2);
        arrayList.add(ofFloat2);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.SCALE_Y, f2);
        motionSpec.getTiming("scale").apply(ofFloat3);
        workAroundOreoBug(ofFloat3);
        arrayList.add(ofFloat3);
        calculateImageMatrixFromScale(f3, this.tmpMatrix);
        ObjectAnimator ofObject = ObjectAnimator.ofObject(this.view, new ImageMatrixProperty(), new AnonymousClass3(), new Matrix(this.tmpMatrix));
        motionSpec.getTiming("iconScale").apply(ofObject);
        arrayList.add(ofObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    private AnimatorSet createDefaultAnimator(float f, float f2, float f3, int i, int i2) {
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new FloatingActionButtonImpl$$ExternalSyntheticLambda0(this, this.view.getAlpha(), f, this.view.getScaleX(), f2, this.view.getScaleY(), this.imageMatrixScale, f3, new Matrix(this.tmpMatrix)));
        arrayList.add(ofFloat);
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        animatorSet.setDuration(MotionUtils.resolveThemeDuration(this.view.getContext(), i, this.view.getContext().getResources().getInteger(R.integer.material_motion_duration_long_1)));
        animatorSet.setInterpolator(MotionUtils.resolveThemeInterpolator(this.view.getContext(), i2, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    private StateListAnimator createDefaultStateListAnimator(float f, float f2, float f3) {
        StateListAnimator stateListAnimator = new StateListAnimator();
        stateListAnimator.addState(PRESSED_ENABLED_STATE_SET, createElevationAnimator(f, f3));
        stateListAnimator.addState(HOVERED_FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
        stateListAnimator.addState(FOCUSED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
        stateListAnimator.addState(HOVERED_ENABLED_STATE_SET, createElevationAnimator(f, f2));
        AnimatorSet animatorSet = new AnimatorSet();
        ArrayList arrayList = new ArrayList();
        arrayList.add(ObjectAnimator.ofFloat(this.view, "elevation", f).setDuration(0L));
        int i = Build.VERSION.SDK_INT;
        if (Build.VERSION.SDK_INT <= 24) {
            arrayList.add(ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, this.view.getTranslationZ()).setDuration(100L));
        }
        arrayList.add(ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
        animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
        animatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        stateListAnimator.addState(ENABLED_STATE_SET, animatorSet);
        stateListAnimator.addState(EMPTY_STATE_SET, createElevationAnimator(0.0f, 0.0f));
        return stateListAnimator;
    }

    private Animator createElevationAnimator(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.view, "elevation", f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.view, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(ELEVATION_ANIM_INTERPOLATOR);
        return animatorSet;
    }

    private boolean shouldAnimateVisibilityChange() {
        return this.view.isLaidOut() && !this.view.isInEditMode();
    }

    private void workAroundOreoBug(ObjectAnimator objectAnimator) {
        if (Build.VERSION.SDK_INT != 26) {
            return;
        }
        objectAnimator.setEvaluator(new AnonymousClass4());
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        if (this.hideListeners == null) {
            this.hideListeners = new ArrayList<>();
        }
        this.hideListeners.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        if (this.showListeners == null) {
            this.showListeners = new ArrayList<>();
        }
        this.showListeners.add(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addTransformationCallback(InternalTransformationCallback internalTransformationCallback) {
        if (this.transformationCallbacks == null) {
            this.transformationCallbacks = new ArrayList<>();
        }
        this.transformationCallbacks.add(internalTransformationCallback);
    }

    BorderDrawable createBorderDrawable(int i, ColorStateList colorStateList) {
        Context context = this.view.getContext();
        BorderDrawable borderDrawable = new BorderDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
        borderDrawable.setGradientColors(ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color), ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color), ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color));
        borderDrawable.setBorderWidth(i);
        borderDrawable.setBorderTint(colorStateList);
        return borderDrawable;
    }

    MaterialShapeDrawable createShapeDrawable() {
        return new AlwaysStatefulMaterialShapeDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.shapeAppearance));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final Drawable getContentBackground() {
        return this.contentBackground;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getElevation() {
        return this.view.getElevation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getHoveredFocusedTranslationZ() {
        return this.hoveredFocusedTranslationZ;
    }

    void getPadding(Rect rect) {
        if (this.shadowViewDelegate.isCompatPaddingEnabled()) {
            int touchTargetPadding = getTouchTargetPadding();
            int max = Math.max(touchTargetPadding, (int) Math.ceil(this.shadowPaddingEnabled ? getElevation() + this.pressedTranslationZ : 0.0f));
            int max2 = Math.max(touchTargetPadding, (int) Math.ceil(SHADOW_MULTIPLIER * r1));
            rect.set(max, max2, max, max2);
            return;
        }
        if (!ignoreExpandBoundsForA11y()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.minTouchTargetSize - this.view.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getPressedTranslationZ() {
        return this.pressedTranslationZ;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final ShapeAppearanceModel getShapeAppearance() {
        return this.shapeAppearance;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getTouchTargetPadding() {
        if (this.ensureMinTouchTargetSize) {
            return Math.max((this.minTouchTargetSize - this.view.getSizeDimension()) / 2, 0);
        }
        return 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void hide(InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z) {
        if (isOrWillBeHidden()) {
            return;
        }
        if (this.currentAnimator != null) {
            this.currentAnimator.cancel();
        }
        if (!shouldAnimateVisibilityChange()) {
            this.view.internalSetVisibility(z ? 8 : 4, z);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onHidden();
                return;
            }
            return;
        }
        AnimatorSet createAnimator = this.hideMotionSpec != null ? createAnimator(this.hideMotionSpec, 0.0f, 0.0f, 0.0f) : createDefaultAnimator(0.0f, 0.4f, 0.4f, HIDE_ANIM_DURATION_ATTR, HIDE_ANIM_EASING_ATTR);
        createAnimator.addListener(new AnonymousClass1(z, internalVisibilityChangedListener));
        if (this.hideListeners != null) {
            Iterator<Animator.AnimatorListener> it = this.hideListeners.iterator();
            while (it.hasNext()) {
                createAnimator.addListener(it.next());
            }
        }
        createAnimator.start();
    }

    final boolean ignoreExpandBoundsForA11y() {
        return this.ensureMinTouchTargetSize && this.view.getSizeDimension() < this.minTouchTargetSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initializeBackgroundDrawable(ColorStateList colorStateList, PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable drawable;
        this.shapeDrawable = createShapeDrawable();
        this.shapeDrawable.setTintList(colorStateList);
        if (mode != null) {
            this.shapeDrawable.setTintMode(mode);
        }
        this.shapeDrawable.initializeElevationOverlay(this.view.getContext());
        if (i > 0) {
            this.borderDrawable = createBorderDrawable(i, colorStateList);
            drawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.borderDrawable), (Drawable) Preconditions.checkNotNull(this.shapeDrawable)});
        } else {
            this.borderDrawable = null;
            drawable = this.shapeDrawable;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), drawable, null);
        this.rippleDrawable = rippleDrawable;
        FocusRingDrawable.layer(this.view.getContext(), rippleDrawable, this.shapeDrawable);
        this.contentBackground = rippleDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOrWillBeHidden() {
        return this.view.getVisibility() == 0 ? this.animState == 1 : this.animState != 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOrWillBeShown() {
        return this.view.getVisibility() != 0 ? this.animState == 2 : this.animState != 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$createDefaultAnimator$0$com-google-android-material-floatingactionbutton-FloatingActionButtonImpl, reason: not valid java name */
    public /* synthetic */ void m385x7a82a444(float f, float f2, float f3, float f4, float f5, float f6, float f7, Matrix matrix, ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.view.setAlpha(AnimationUtils.lerp(f, f2, 0.0f, 0.2f, floatValue));
        this.view.setScaleX(AnimationUtils.lerp(f3, f4, floatValue));
        this.view.setScaleY(AnimationUtils.lerp(f5, f4, floatValue));
        this.imageMatrixScale = AnimationUtils.lerp(f6, f7, floatValue);
        calculateImageMatrixFromScale(AnimationUtils.lerp(f6, f7, floatValue), matrix);
        this.view.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onAttachedToWindow() {
        if (this.shapeDrawable != null) {
            MaterialShapeUtils.setParentAbsoluteElevation(this.view, this.shapeDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onCompatShadowChanged() {
        updatePadding();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onDetachedFromWindow() {
        ViewTreeObserver viewTreeObserver = this.view.getViewTreeObserver();
        if (this.preDrawListener != null) {
            viewTreeObserver.removeOnPreDrawListener(this.preDrawListener);
            this.preDrawListener = null;
        }
    }

    void onDrawableStateChangedForLollipop() {
        if (!this.view.isEnabled()) {
            this.view.setElevation(0.0f);
            this.view.setTranslationZ(0.0f);
            return;
        }
        this.view.setElevation(this.elevation);
        if (this.view.isPressed()) {
            this.view.setTranslationZ(this.pressedTranslationZ);
        } else if (this.view.isFocused() || this.view.isHovered()) {
            this.view.setTranslationZ(this.hoveredFocusedTranslationZ);
        } else {
            this.view.setTranslationZ(0.0f);
        }
    }

    void onElevationsChanged(float f, float f2, float f3) {
        int i = Build.VERSION.SDK_INT;
        if (this.view.getStateListAnimator() == this.stateListAnimator) {
            this.stateListAnimator = createDefaultStateListAnimator(f, f2, f3);
            this.view.setStateListAnimator(this.stateListAnimator);
        }
        if (shouldAddPadding()) {
            updatePadding();
        }
    }

    void onPaddingUpdated(Rect rect) {
        Preconditions.checkNotNull(this.contentBackground, "Didn't initialize content background");
        if (!shouldAddPadding()) {
            this.shadowViewDelegate.setBackgroundDrawable(this.contentBackground);
        } else {
            this.shadowViewDelegate.setBackgroundDrawable(new InsetDrawable(this.contentBackground, rect.left, rect.top, rect.right, rect.bottom));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onScaleChanged() {
        if (this.transformationCallbacks != null) {
            Iterator<InternalTransformationCallback> it = this.transformationCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onScaleChanged();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onTranslationChanged() {
        if (this.transformationCallbacks != null) {
            Iterator<InternalTransformationCallback> it = this.transformationCallbacks.iterator();
            while (it.hasNext()) {
                it.next().onTranslationChanged();
            }
        }
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        if (this.hideListeners == null) {
            return;
        }
        this.hideListeners.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        if (this.showListeners == null) {
            return;
        }
        this.showListeners.remove(animatorListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeTransformationCallback(InternalTransformationCallback internalTransformationCallback) {
        if (this.transformationCallbacks == null) {
            return;
        }
        this.transformationCallbacks.remove(internalTransformationCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.shapeDrawable != null) {
            this.shapeDrawable.setTintList(colorStateList);
        }
        if (this.borderDrawable != null) {
            this.borderDrawable.setBorderTint(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.shapeDrawable != null) {
            this.shapeDrawable.setTintMode(mode);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setElevation(float f) {
        if (this.elevation != f) {
            this.elevation = f;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setEnsureMinTouchTargetSize(boolean z) {
        this.ensureMinTouchTargetSize = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideMotionSpec = motionSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setHoveredFocusedTranslationZ(float f) {
        if (this.hoveredFocusedTranslationZ != f) {
            this.hoveredFocusedTranslationZ = f;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    final void setImageMatrixScale(float f) {
        this.imageMatrixScale = f;
        Matrix matrix = this.tmpMatrix;
        calculateImageMatrixFromScale(f, matrix);
        this.view.setImageMatrix(matrix);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setMaxImageSize(int i) {
        if (this.maxImageSize != i) {
            this.maxImageSize = i;
            updateImageMatrixScale();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setMinTouchTargetSize(int i) {
        this.minTouchTargetSize = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setPressedTranslationZ(float f) {
        if (this.pressedTranslationZ != f) {
            this.pressedTranslationZ = f;
            onElevationsChanged(this.elevation, this.hoveredFocusedTranslationZ, this.pressedTranslationZ);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRippleColor(ColorStateList colorStateList) {
        if (this.rippleDrawable instanceof RippleDrawable) {
            ((RippleDrawable) this.rippleDrawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else if (this.rippleDrawable != null) {
            this.rippleDrawable.setTintList(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShadowPaddingEnabled(boolean z) {
        this.shadowPaddingEnabled = z;
        updatePadding();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.shapeAppearance = shapeAppearanceModel;
        if (this.shapeDrawable != null) {
            this.shapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (this.rippleDrawable instanceof Shapeable) {
            ((Shapeable) this.rippleDrawable).setShapeAppearanceModel(shapeAppearanceModel);
        }
        if (this.borderDrawable != null) {
            this.borderDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void setShowMotionSpec(MotionSpec motionSpec) {
        this.showMotionSpec = motionSpec;
    }

    boolean shouldAddPadding() {
        return this.shadowViewDelegate.isCompatPaddingEnabled() || ignoreExpandBoundsForA11y();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void show(InternalVisibilityChangedListener internalVisibilityChangedListener, boolean z) {
        if (isOrWillBeShown()) {
            return;
        }
        if (this.currentAnimator != null) {
            this.currentAnimator.cancel();
        }
        boolean z2 = this.showMotionSpec == null;
        if (!shouldAnimateVisibilityChange()) {
            this.view.internalSetVisibility(0, z);
            this.view.setAlpha(1.0f);
            this.view.setScaleY(1.0f);
            this.view.setScaleX(1.0f);
            setImageMatrixScale(1.0f);
            if (internalVisibilityChangedListener != null) {
                internalVisibilityChangedListener.onShown();
                return;
            }
            return;
        }
        if (this.view.getVisibility() != 0) {
            this.view.setAlpha(0.0f);
            this.view.setScaleY(z2 ? 0.4f : 0.0f);
            this.view.setScaleX(z2 ? 0.4f : 0.0f);
            setImageMatrixScale(z2 ? 0.4f : 0.0f);
        }
        AnimatorSet createAnimator = this.showMotionSpec != null ? createAnimator(this.showMotionSpec, 1.0f, 1.0f, 1.0f) : createDefaultAnimator(1.0f, 1.0f, 1.0f, SHOW_ANIM_DURATION_ATTR, SHOW_ANIM_EASING_ATTR);
        createAnimator.addListener(new AnonymousClass2(z, internalVisibilityChangedListener));
        if (this.showListeners != null) {
            Iterator<Animator.AnimatorListener> it = this.showListeners.iterator();
            while (it.hasNext()) {
                createAnimator.addListener(it.next());
            }
        }
        createAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void updateImageMatrixScale() {
        setImageMatrixScale(this.imageMatrixScale);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void updatePadding() {
        Rect rect = this.tmpRect;
        getPadding(rect);
        onPaddingUpdated(rect);
        this.shadowViewDelegate.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateShapeElevation(float f) {
        if (this.shapeDrawable != null) {
            this.shapeDrawable.setElevation(f);
        }
    }
}
