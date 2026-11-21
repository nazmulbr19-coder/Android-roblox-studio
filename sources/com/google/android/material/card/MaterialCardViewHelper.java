package com.google.android.material.card;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.cardview.R;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.focus.FocusRingDrawable;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.CornerTreatment;
import com.google.android.material.shape.CutCornerTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearance;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.StateListShapeAppearanceModel;

/* loaded from: classes.dex */
class MaterialCardViewHelper {
    private static final float CARD_VIEW_SHADOW_MULTIPLIER = 1.5f;
    private static final int CHECKED_ICON_LAYER_INDEX = 2;
    private static final Drawable CHECKED_ICON_NONE;
    private static final double COS_45 = Math.cos(Math.toRadians(45.0d));
    public static final int DEFAULT_FADE_ANIM_DURATION = 300;
    private static final int DEFAULT_STROKE_VALUE = -1;
    private static final int NOT_SET = -1;
    private final MaterialShapeDrawable bgDrawable;
    private float cardCornerRadius;
    private boolean checkable;
    private Drawable checkedIcon;
    private int checkedIconGravity;
    private int checkedIconMargin;
    private int checkedIconSize;
    private ColorStateList checkedIconTint;
    private LayerDrawable clickableForegroundDrawable;
    private Drawable fgDrawable;
    private final MaterialShapeDrawable foregroundContentDrawable;
    private MaterialShapeDrawable foregroundShapeDrawable;
    private ValueAnimator iconAnimator;
    private final TimeInterpolator iconFadeAnimInterpolator;
    private final int iconFadeInAnimDuration;
    private final int iconFadeOutAnimDuration;
    private final MaterialCardView materialCardView;
    private ColorStateList rippleColor;
    private Drawable rippleDrawable;
    private ShapeAppearance shapeAppearanceModel;
    private ColorStateList strokeColor;
    private int strokeWidth;
    private final Rect userContentPadding = new Rect();
    private boolean isBackgroundOverwritten = false;
    private float checkedAnimationProgress = 0.0f;

    /* renamed from: com.google.android.material.card.MaterialCardViewHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends InsetDrawable {
        AnonymousClass1(Drawable drawable, int i, int i2, int i3, int i4) {
            super(drawable, i, i2, i3, i4);
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumHeight() {
            return -1;
        }

        @Override // android.graphics.drawable.Drawable
        public int getMinimumWidth() {
            return -1;
        }

        @Override // android.graphics.drawable.InsetDrawable, android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
        public boolean getPadding(Rect rect) {
            return false;
        }
    }

    static {
        CHECKED_ICON_NONE = Build.VERSION.SDK_INT <= 28 ? new ColorDrawable() : null;
    }

    public MaterialCardViewHelper(MaterialCardView materialCardView, AttributeSet attributeSet, int i, int i2) {
        this.cardCornerRadius = -1.0f;
        this.materialCardView = materialCardView;
        TypedArray obtainStyledAttributes = materialCardView.getContext().obtainStyledAttributes(attributeSet, R.styleable.CardView, i, R.style.CardView);
        this.bgDrawable = new MaterialShapeDrawable(materialCardView.getContext(), attributeSet, i, i2);
        this.bgDrawable.initializeElevationOverlay(materialCardView.getContext());
        this.bgDrawable.setShadowColor(-12303292);
        ShapeAppearanceModel.Builder builder = this.bgDrawable.getShapeAppearanceModel().toBuilder();
        if (obtainStyledAttributes.hasValue(R.styleable.CardView_cardCornerRadius)) {
            this.cardCornerRadius = obtainStyledAttributes.getDimension(R.styleable.CardView_cardCornerRadius, 0.0f);
            builder.setAllCornerSizes(this.cardCornerRadius);
        }
        this.foregroundContentDrawable = new MaterialShapeDrawable();
        setShapeAppearance(builder.build());
        this.iconFadeAnimInterpolator = MotionUtils.resolveThemeInterpolator(this.materialCardView.getContext(), com.google.android.material.R.attr.motionEasingLinearInterpolator, AnimationUtils.LINEAR_INTERPOLATOR);
        this.iconFadeInAnimDuration = MotionUtils.resolveThemeDuration(this.materialCardView.getContext(), com.google.android.material.R.attr.motionDurationShort2, DEFAULT_FADE_ANIM_DURATION);
        this.iconFadeOutAnimDuration = MotionUtils.resolveThemeDuration(this.materialCardView.getContext(), com.google.android.material.R.attr.motionDurationShort1, DEFAULT_FADE_ANIM_DURATION);
        obtainStyledAttributes.recycle();
    }

    private float calculateActualCornerPadding() {
        float f = 0.0f;
        for (ShapeAppearanceModel shapeAppearanceModel : this.shapeAppearanceModel.getShapeAppearanceModels()) {
            if (shapeAppearanceModel != null) {
                f = Math.max(f, getMaxCornerPadding(shapeAppearanceModel));
            }
        }
        return f;
    }

    private float calculateCornerPaddingForCornerTreatment(CornerTreatment cornerTreatment, float f) {
        if (cornerTreatment instanceof RoundedCornerTreatment) {
            return (float) ((1.0d - COS_45) * f);
        }
        if (cornerTreatment instanceof CutCornerTreatment) {
            return f / 2.0f;
        }
        return 0.0f;
    }

    private float calculateHorizontalBackgroundPadding() {
        return this.materialCardView.getMaxCardElevation() + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private float calculateVerticalBackgroundPadding() {
        return (this.materialCardView.getMaxCardElevation() * CARD_VIEW_SHADOW_MULTIPLIER) + (shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f);
    }

    private boolean canClipToOutline() {
        return this.bgDrawable.isRoundRect();
    }

    private Drawable createForegroundRippleDrawable() {
        this.foregroundShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        return new RippleDrawable(this.rippleColor, null, this.foregroundShapeDrawable);
    }

    private SpringForce createSpringForce(Context context) {
        return MotionUtils.resolveThemeSpringForce(context, com.google.android.material.R.attr.motionSpringFastSpatial, com.google.android.material.R.style.Motion_Material3_Spring_Standard_Fast_Spatial);
    }

    private Drawable getClickableForeground() {
        if (this.rippleDrawable == null) {
            this.rippleDrawable = createForegroundRippleDrawable();
        }
        if (this.clickableForegroundDrawable == null) {
            LayerDrawable layerDrawable = new LayerDrawable(new Drawable[]{this.rippleDrawable, this.foregroundContentDrawable, this.checkedIcon});
            FocusRingDrawable.layer(this.materialCardView.getContext(), layerDrawable, this.foregroundShapeDrawable);
            layerDrawable.setId(2, com.google.android.material.R.id.mtrl_card_checked_layer_id);
            this.clickableForegroundDrawable = layerDrawable;
        }
        return this.clickableForegroundDrawable;
    }

    private float getMaxCornerPadding(ShapeAppearanceModel shapeAppearanceModel) {
        return Math.max(Math.max(calculateCornerPaddingForCornerTreatment(shapeAppearanceModel.getTopLeftCorner(), this.bgDrawable.getTopLeftCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(shapeAppearanceModel.getTopRightCorner(), this.bgDrawable.getTopRightCornerResolvedSize())), Math.max(calculateCornerPaddingForCornerTreatment(shapeAppearanceModel.getBottomRightCorner(), this.bgDrawable.getBottomRightCornerResolvedSize()), calculateCornerPaddingForCornerTreatment(shapeAppearanceModel.getBottomLeftCorner(), this.bgDrawable.getBottomLeftCornerResolvedSize())));
    }

    private float getParentCardViewCalculatedCornerPadding() {
        if (this.materialCardView.getPreventCornerOverlap() && this.materialCardView.getUseCompatPadding()) {
            return (float) ((1.0d - COS_45) * this.materialCardView.getCardViewRadius());
        }
        return 0.0f;
    }

    private Drawable insetDrawable(Drawable drawable) {
        int i;
        int i2;
        if (this.materialCardView.getUseCompatPadding()) {
            i = (int) Math.ceil(calculateVerticalBackgroundPadding());
            i2 = (int) Math.ceil(calculateHorizontalBackgroundPadding());
        } else {
            i = 0;
            i2 = 0;
        }
        return new AnonymousClass1(drawable, i2, i, i2, i);
    }

    private boolean isCheckedIconBottom() {
        return (this.checkedIconGravity & 80) == 80;
    }

    private boolean isCheckedIconEnd() {
        return (this.checkedIconGravity & GravityCompat.END) == 8388613;
    }

    private boolean shouldAddCornerPaddingInsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && !canClipToOutline();
    }

    private boolean shouldAddCornerPaddingOutsideCardBackground() {
        return this.materialCardView.getPreventCornerOverlap() && canClipToOutline() && this.materialCardView.getUseCompatPadding();
    }

    private boolean shouldUseClickableForeground() {
        if (this.materialCardView.isClickable()) {
            return true;
        }
        View view = this.materialCardView;
        while (view.isDuplicateParentStateEnabled() && (view.getParent() instanceof View)) {
            view = (View) view.getParent();
        }
        return view.isClickable();
    }

    private void updateInsetForeground(Drawable drawable) {
        int i = Build.VERSION.SDK_INT;
        if (this.materialCardView.getForeground() instanceof InsetDrawable) {
            ((InsetDrawable) this.materialCardView.getForeground()).setDrawable(drawable);
        } else {
            this.materialCardView.setForeground(insetDrawable(drawable));
        }
    }

    private void updateRippleColor() {
        if (this.rippleDrawable != null) {
            ((RippleDrawable) this.rippleDrawable).setColor(this.rippleColor);
        }
    }

    public void animateCheckedIcon(boolean z) {
        float f = z ? 1.0f : 0.0f;
        float f2 = z ? 1.0f - this.checkedAnimationProgress : this.checkedAnimationProgress;
        if (this.iconAnimator != null) {
            this.iconAnimator.cancel();
            this.iconAnimator = null;
        }
        this.iconAnimator = ValueAnimator.ofFloat(this.checkedAnimationProgress, f);
        this.iconAnimator.addUpdateListener(new MaterialCardViewHelper$$ExternalSyntheticLambda0(this));
        this.iconAnimator.setInterpolator(this.iconFadeAnimInterpolator);
        this.iconAnimator.setDuration(z ? this.iconFadeInAnimDuration * f2 : this.iconFadeOutAnimDuration * f2);
        this.iconAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void forceRippleRedraw() {
        if (this.rippleDrawable != null) {
            Rect bounds = this.rippleDrawable.getBounds();
            int i = bounds.bottom;
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i - 1);
            this.rippleDrawable.setBounds(bounds.left, bounds.top, bounds.right, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialShapeDrawable getBackground() {
        return this.bgDrawable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getCardBackgroundColor() {
        return this.bgDrawable.getFillColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getCardForegroundColor() {
        return this.foregroundContentDrawable.getFillColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCheckedIconGravity() {
        return this.checkedIconGravity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCheckedIconMargin() {
        return this.checkedIconMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCheckedIconSize() {
        return this.checkedIconSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCornerRadius() {
        return this.bgDrawable.getTopLeftCornerResolvedSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getProgress() {
        return this.bgDrawable.getInterpolation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShapeAppearance getShapeAppearance() {
        return this.shapeAppearanceModel;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStrokeColor() {
        if (this.strokeColor == null) {
            return -1;
        }
        return this.strokeColor.getDefaultColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getStrokeColorStateList() {
        return this.strokeColor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getStrokeWidth() {
        return this.strokeWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Rect getUserContentPadding() {
        return this.userContentPadding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isBackgroundOverwritten() {
        return this.isBackgroundOverwritten;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCheckable() {
        return this.checkable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$animateCheckedIcon$0$com-google-android-material-card-MaterialCardViewHelper, reason: not valid java name */
    public /* synthetic */ void m331xa4d79c2b(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        this.checkedIcon.setAlpha((int) (255.0f * floatValue));
        this.checkedAnimationProgress = floatValue;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void loadFromAttributes(TypedArray typedArray) {
        StateListShapeAppearanceModel create;
        this.strokeColor = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_strokeColor);
        if (this.strokeColor == null) {
            this.strokeColor = ColorStateList.valueOf(-1);
        }
        this.strokeWidth = typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_strokeWidth, 0);
        this.checkable = typedArray.getBoolean(com.google.android.material.R.styleable.MaterialCardView_android_checkable, false);
        this.materialCardView.setLongClickable(this.checkable);
        this.checkedIconTint = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIconTint);
        setCheckedIcon(MaterialResources.getDrawable(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_checkedIcon));
        setCheckedIconSize(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconSize, 0));
        setCheckedIconMargin(typedArray.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialCardView_checkedIconMargin, 0));
        this.checkedIconGravity = typedArray.getInteger(com.google.android.material.R.styleable.MaterialCardView_checkedIconGravity, 8388661);
        this.rippleColor = MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_rippleColor);
        if (this.rippleColor == null) {
            this.rippleColor = ColorStateList.valueOf(MaterialColors.getColor(this.materialCardView, androidx.appcompat.R.attr.colorControlHighlight));
        }
        setCardForegroundColor(MaterialResources.getColorStateList(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_cardForegroundColor));
        updateRippleColor();
        updateElevation();
        updateStroke();
        this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        this.fgDrawable = shouldUseClickableForeground() ? getClickableForeground() : this.foregroundContentDrawable;
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
        if (this.cardCornerRadius != -1.0f || (create = StateListShapeAppearanceModel.create(this.materialCardView.getContext(), typedArray, com.google.android.material.R.styleable.MaterialCardView_shapeAppearance)) == null) {
            return;
        }
        SpringForce createSpringForce = createSpringForce(this.materialCardView.getContext());
        this.bgDrawable.setCornerSpringForce(createSpringForce);
        this.foregroundContentDrawable.setCornerSpringForce(createSpringForce);
        if (this.foregroundShapeDrawable != null) {
            this.foregroundShapeDrawable.setCornerSpringForce(createSpringForce);
        }
        setShapeAppearance(create);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recalculateCheckedIconPosition(int i, int i2) {
        int i3;
        int i4;
        if (this.clickableForegroundDrawable != null) {
            int i5 = 0;
            int i6 = 0;
            if (this.materialCardView.getUseCompatPadding()) {
                i5 = (int) Math.ceil(calculateVerticalBackgroundPadding() * 2.0f);
                i6 = (int) Math.ceil(calculateHorizontalBackgroundPadding() * 2.0f);
            }
            int i7 = isCheckedIconEnd() ? ((i - this.checkedIconMargin) - this.checkedIconSize) - i6 : this.checkedIconMargin;
            int i8 = isCheckedIconBottom() ? this.checkedIconMargin : ((i2 - this.checkedIconMargin) - this.checkedIconSize) - i5;
            int i9 = isCheckedIconEnd() ? this.checkedIconMargin : ((i - this.checkedIconMargin) - this.checkedIconSize) - i6;
            int i10 = isCheckedIconBottom() ? ((i2 - this.checkedIconMargin) - this.checkedIconSize) - i5 : this.checkedIconMargin;
            if (this.materialCardView.getLayoutDirection() == 1) {
                i3 = i9;
                i4 = i7;
            } else {
                i3 = i7;
                i4 = i9;
            }
            this.clickableForegroundDrawable.setLayerInset(2, i3, i10, i4, i8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBackgroundOverwritten(boolean z) {
        this.isBackgroundOverwritten = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCardBackgroundColor(ColorStateList colorStateList) {
        this.bgDrawable.setFillColor(colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCardForegroundColor(ColorStateList colorStateList) {
        this.foregroundContentDrawable.setFillColor(colorStateList == null ? ColorStateList.valueOf(0) : colorStateList);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckable(boolean z) {
        this.checkable = z;
    }

    public void setChecked(boolean z) {
        setChecked(z, false);
    }

    public void setChecked(boolean z, boolean z2) {
        if (this.checkedIcon != null) {
            if (z2) {
                animateCheckedIcon(z);
            } else {
                this.checkedIcon.setAlpha(z ? 255 : 0);
                this.checkedAnimationProgress = z ? 1.0f : 0.0f;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckedIcon(Drawable drawable) {
        if (drawable != null) {
            this.checkedIcon = DrawableCompat.wrap(drawable).mutate();
            this.checkedIcon.setTintList(this.checkedIconTint);
            setChecked(this.materialCardView.isChecked());
        } else {
            this.checkedIcon = CHECKED_ICON_NONE;
        }
        if (this.clickableForegroundDrawable != null) {
            this.clickableForegroundDrawable.setDrawableByLayerId(com.google.android.material.R.id.mtrl_card_checked_layer_id, this.checkedIcon);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckedIconGravity(int i) {
        this.checkedIconGravity = i;
        recalculateCheckedIconPosition(this.materialCardView.getMeasuredWidth(), this.materialCardView.getMeasuredHeight());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckedIconMargin(int i) {
        this.checkedIconMargin = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckedIconSize(int i) {
        this.checkedIconSize = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCheckedIconTint(ColorStateList colorStateList) {
        this.checkedIconTint = colorStateList;
        if (this.checkedIcon != null) {
            this.checkedIcon.setTintList(colorStateList);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCornerRadius(float f) {
        this.cardCornerRadius = f;
        setShapeAppearance(this.shapeAppearanceModel.getDefaultShape().withCornerSize(f));
        this.fgDrawable.invalidateSelf();
        if (shouldAddCornerPaddingOutsideCardBackground() || shouldAddCornerPaddingInsideCardBackground()) {
            updateContentPadding();
        }
        if (shouldAddCornerPaddingOutsideCardBackground()) {
            updateInsets();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setProgress(float f) {
        this.bgDrawable.setInterpolation(f);
        if (this.foregroundContentDrawable != null) {
            this.foregroundContentDrawable.setInterpolation(f);
        }
        if (this.foregroundShapeDrawable != null) {
            this.foregroundShapeDrawable.setInterpolation(f);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setRippleColor(ColorStateList colorStateList) {
        this.rippleColor = colorStateList;
        updateRippleColor();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShapeAppearance(ShapeAppearance shapeAppearance) {
        this.shapeAppearanceModel = shapeAppearance;
        this.bgDrawable.setShapeAppearance(shapeAppearance);
        this.foregroundContentDrawable.setShapeAppearance(shapeAppearance);
        if (this.foregroundShapeDrawable != null) {
            this.foregroundShapeDrawable.setShapeAppearance(shapeAppearance);
        }
        this.bgDrawable.setShadowBitmapDrawingEnable(!this.bgDrawable.isRoundRect());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStrokeColor(ColorStateList colorStateList) {
        if (this.strokeColor == colorStateList) {
            return;
        }
        this.strokeColor = colorStateList;
        updateStroke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setStrokeWidth(int i) {
        if (i == this.strokeWidth) {
            return;
        }
        this.strokeWidth = i;
        updateStroke();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setUserContentPadding(int i, int i2, int i3, int i4) {
        this.userContentPadding.set(i, i2, i3, i4);
        updateContentPadding();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateClickable() {
        Drawable drawable = this.fgDrawable;
        this.fgDrawable = shouldUseClickableForeground() ? getClickableForeground() : this.foregroundContentDrawable;
        if (drawable != this.fgDrawable) {
            updateInsetForeground(this.fgDrawable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateContentPadding() {
        int calculateActualCornerPadding = (int) ((shouldAddCornerPaddingInsideCardBackground() || shouldAddCornerPaddingOutsideCardBackground() ? calculateActualCornerPadding() : 0.0f) - getParentCardViewCalculatedCornerPadding());
        this.materialCardView.setAncestorContentPadding(this.userContentPadding.left + calculateActualCornerPadding, this.userContentPadding.top + calculateActualCornerPadding, this.userContentPadding.right + calculateActualCornerPadding, this.userContentPadding.bottom + calculateActualCornerPadding);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateElevation() {
        this.bgDrawable.setElevation(this.materialCardView.getCardElevation());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void updateInsets() {
        if (!isBackgroundOverwritten()) {
            this.materialCardView.setBackgroundInternal(insetDrawable(this.bgDrawable));
        }
        this.materialCardView.setForeground(insetDrawable(this.fgDrawable));
    }

    void updateStroke() {
        this.foregroundContentDrawable.setStroke(this.strokeWidth, this.strokeColor);
    }
}
