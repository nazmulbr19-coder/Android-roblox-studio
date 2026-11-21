package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Locale;

/* loaded from: classes.dex */
public class BadgeDrawable extends Drawable implements TextDrawableHelper.TextDrawableDelegate {
    public static final int BADGE_CONTENT_NOT_TRUNCATED = -2;
    public static final int BADGE_FIXED_EDGE_END = 1;
    public static final int BADGE_FIXED_EDGE_START = 0;
    static final int BADGE_RADIUS_NOT_SPECIFIED = -1;

    @Deprecated
    public static final int BOTTOM_END = 8388693;

    @Deprecated
    public static final int BOTTOM_START = 8388691;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    static final String DEFAULT_EXCEED_MAX_BADGE_TEXT_SUFFIX = "…";
    private static final int DEFAULT_STYLE = R.style.Widget_MaterialComponents_Badge;
    private static final int DEFAULT_THEME_ATTR = R.attr.badgeStyle;
    private static final float FONT_SCALE_THRESHOLD = 0.3f;
    static final int OFFSET_ALIGNMENT_MODE_EDGE = 0;
    static final int OFFSET_ALIGNMENT_MODE_LEGACY = 1;
    private static final String TAG = "Badge";
    public static final int TOP_END = 8388661;
    public static final int TOP_START = 8388659;
    private WeakReference<View> anchorViewRef;
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private final WeakReference<Context> contextRef;
    private float cornerRadius;
    private WeakReference<FrameLayout> customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    private final MaterialShapeDrawable shapeDrawable;
    private final BadgeState state;
    private final TextDrawableHelper textDrawableHelper;

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface BadgeGravity {
    }

    private BadgeDrawable(Context context, int i, int i2, int i3, BadgeState.State state) {
        this.contextRef = new WeakReference<>(context);
        ThemeEnforcement.checkMaterialTheme(context);
        this.badgeBounds = new Rect();
        this.textDrawableHelper = new TextDrawableHelper(this);
        this.textDrawableHelper.getTextPaint().setTextAlign(Paint.Align.CENTER);
        this.state = new BadgeState(context, i, i2, i3, state);
        this.shapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context, hasBadgeContent() ? this.state.getBadgeWithTextShapeAppearanceResId() : this.state.getBadgeShapeAppearanceResId(), hasBadgeContent() ? this.state.getBadgeWithTextShapeAppearanceOverlayResId() : this.state.getBadgeShapeAppearanceOverlayResId()).build());
        restoreState();
    }

    private void autoAdjustWithinGrandparentBounds(View view) {
        FrameLayout customBadgeParent = getCustomBadgeParent();
        ViewParent parent = customBadgeParent == null ? view.getParent() : customBadgeParent;
        if ((parent instanceof View) && (parent.getParent() instanceof View)) {
            autoAdjustWithinViewBounds(view, (View) parent.getParent());
        }
    }

    private void autoAdjustWithinViewBounds(View view, View view2) {
        float f;
        float f2;
        ViewParent viewParent;
        FrameLayout customBadgeParent = getCustomBadgeParent();
        if (customBadgeParent == null) {
            f = view.getY();
            f2 = view.getX();
            viewParent = view.getParent();
        } else {
            f = 0.0f;
            f2 = 0.0f;
            viewParent = customBadgeParent;
        }
        ViewParent viewParent2 = viewParent;
        while ((viewParent2 instanceof View) && viewParent2 != view2) {
            ViewParent parent = viewParent2.getParent();
            if (!(parent instanceof ViewGroup) || ((ViewGroup) parent).getClipChildren()) {
                break;
            }
            View view3 = (View) viewParent2;
            f += view3.getY();
            f2 += view3.getX();
            viewParent2 = viewParent2.getParent();
        }
        if (viewParent2 instanceof View) {
            float topCutOff = getTopCutOff(f);
            float leftCutOff = getLeftCutOff(f2);
            float bottomCutOff = getBottomCutOff(((View) viewParent2).getHeight(), f);
            float rightCutoff = getRightCutoff(((View) viewParent2).getWidth(), f2);
            if (topCutOff < 0.0f) {
                this.badgeCenterY += Math.abs(topCutOff);
            }
            if (leftCutOff < 0.0f) {
                this.badgeCenterX += Math.abs(leftCutOff);
            }
            if (bottomCutOff > 0.0f) {
                this.badgeCenterY -= Math.abs(bottomCutOff);
            }
            if (rightCutoff > 0.0f) {
                this.badgeCenterX -= Math.abs(rightCutoff);
            }
        }
    }

    private void calculateCenterAndBounds(Rect rect, View view) {
        this.cornerRadius = hasBadgeContent() ? this.state.badgeWithTextRadius : this.state.badgeRadius;
        if (this.cornerRadius != -1.0f) {
            this.halfBadgeWidth = this.cornerRadius;
            this.halfBadgeHeight = this.cornerRadius;
        } else {
            this.halfBadgeWidth = Math.round((hasBadgeContent() ? this.state.badgeWithTextWidth : this.state.badgeWidth) / 2.0f);
            this.halfBadgeHeight = Math.round((hasBadgeContent() ? this.state.badgeWithTextHeight : this.state.badgeHeight) / 2.0f);
        }
        if (hasBadgeContent()) {
            String badgeContent = getBadgeContent();
            this.halfBadgeWidth = Math.max(this.halfBadgeWidth, (this.textDrawableHelper.getTextWidth(badgeContent) / 2.0f) + this.state.getBadgeHorizontalPadding());
            this.halfBadgeHeight = Math.max(this.halfBadgeHeight, (this.textDrawableHelper.getTextHeight(badgeContent) / 2.0f) + this.state.getBadgeVerticalPadding());
            this.halfBadgeWidth = Math.max(this.halfBadgeWidth, this.halfBadgeHeight);
        }
        int totalVerticalOffsetForState = getTotalVerticalOffsetForState();
        switch (this.state.getBadgeGravity()) {
            case 8388691:
            case 8388693:
                this.badgeCenterY = rect.bottom - totalVerticalOffsetForState;
                break;
            case 8388692:
            default:
                this.badgeCenterY = rect.top + totalVerticalOffsetForState;
                break;
        }
        int totalHorizontalOffsetForState = getTotalHorizontalOffsetForState();
        switch (this.state.getBadgeGravity()) {
            case 8388659:
            case 8388691:
                this.badgeCenterX = this.state.badgeFixedEdge == 0 ? view.getLayoutDirection() == 0 ? (rect.left + this.halfBadgeWidth) - ((this.halfBadgeHeight * 2.0f) - totalHorizontalOffsetForState) : (rect.right - this.halfBadgeWidth) + ((this.halfBadgeHeight * 2.0f) - totalHorizontalOffsetForState) : view.getLayoutDirection() == 0 ? totalHorizontalOffsetForState + (rect.left - this.halfBadgeWidth) : (rect.right + this.halfBadgeWidth) - totalHorizontalOffsetForState;
                break;
            default:
                this.badgeCenterX = this.state.badgeFixedEdge == 0 ? view.getLayoutDirection() == 0 ? (rect.right + this.halfBadgeWidth) - totalHorizontalOffsetForState : (rect.left - this.halfBadgeWidth) + totalHorizontalOffsetForState : view.getLayoutDirection() == 0 ? (rect.right - this.halfBadgeWidth) + ((this.halfBadgeHeight * 2.0f) - totalHorizontalOffsetForState) : (rect.left + this.halfBadgeWidth) - ((this.halfBadgeHeight * 2.0f) - totalHorizontalOffsetForState);
                break;
        }
        if (this.state.isAutoAdjustedToGrandparentBounds()) {
            autoAdjustWithinGrandparentBounds(view);
        } else {
            autoAdjustWithinViewBounds(view, null);
        }
    }

    public static BadgeDrawable create(Context context) {
        return new BadgeDrawable(context, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    public static BadgeDrawable createFromResource(Context context, int i) {
        return new BadgeDrawable(context, i, DEFAULT_THEME_ATTR, DEFAULT_STYLE, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BadgeDrawable createFromSavedState(Context context, BadgeState.State state) {
        return new BadgeDrawable(context, 0, DEFAULT_THEME_ATTR, DEFAULT_STYLE, state);
    }

    private void drawBadgeContent(Canvas canvas) {
        String badgeContent = getBadgeContent();
        if (badgeContent != null) {
            Rect rect = new Rect();
            this.textDrawableHelper.getTextPaint().getTextBounds(badgeContent, 0, badgeContent.length(), rect);
            float exactCenterY = this.badgeCenterY - rect.exactCenterY();
            canvas.drawText(badgeContent, this.badgeCenterX, rect.bottom <= 0 ? (int) exactCenterY : Math.round(exactCenterY), this.textDrawableHelper.getTextPaint());
        }
    }

    private String getBadgeContent() {
        if (hasText()) {
            return getTextBadgeText();
        }
        if (hasNumber()) {
            return getNumberBadgeText();
        }
        return null;
    }

    private float getBottomCutOff(float f, float f2) {
        return ((this.badgeCenterY + this.halfBadgeHeight) - f) + f2;
    }

    private CharSequence getEmptyContentDescription() {
        return this.state.getContentDescriptionNumberless();
    }

    private float getLeftCutOff(float f) {
        return (this.badgeCenterX - this.halfBadgeWidth) + f;
    }

    private String getNumberBadgeText() {
        if (this.maxBadgeNumber == -2 || getNumber() <= this.maxBadgeNumber) {
            return NumberFormat.getInstance(this.state.getNumberLocale()).format(getNumber());
        }
        Context context = this.contextRef.get();
        return context == null ? "" : String.format(this.state.getNumberLocale(), context.getString(R.string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.maxBadgeNumber), DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX);
    }

    private String getNumberContentDescription() {
        Context context;
        if (this.state.getContentDescriptionQuantityStrings() == 0 || (context = this.contextRef.get()) == null) {
            return null;
        }
        return (this.maxBadgeNumber == -2 || getNumber() <= this.maxBadgeNumber) ? context.getResources().getQuantityString(this.state.getContentDescriptionQuantityStrings(), getNumber(), Integer.valueOf(getNumber())) : context.getString(this.state.getContentDescriptionExceedsMaxBadgeNumberStringResource(), Integer.valueOf(this.maxBadgeNumber));
    }

    private float getRightCutoff(float f, float f2) {
        return ((this.badgeCenterX + this.halfBadgeWidth) - f) + f2;
    }

    private String getTextBadgeText() {
        String text = getText();
        int maxCharacterCount = getMaxCharacterCount();
        if (maxCharacterCount == -2 || text == null || text.length() <= maxCharacterCount) {
            return text;
        }
        Context context = this.contextRef.get();
        if (context == null) {
            return "";
        }
        return String.format(context.getString(R.string.m3_exceed_max_badge_text_suffix), text.substring(0, maxCharacterCount - 1), DEFAULT_EXCEED_MAX_BADGE_TEXT_SUFFIX);
    }

    private CharSequence getTextContentDescription() {
        CharSequence contentDescriptionForText = this.state.getContentDescriptionForText();
        return contentDescriptionForText != null ? contentDescriptionForText : getText();
    }

    private float getTopCutOff(float f) {
        return (this.badgeCenterY - this.halfBadgeHeight) + f;
    }

    private int getTotalHorizontalOffsetForState() {
        int horizontalOffsetWithText = hasBadgeContent() ? this.state.getHorizontalOffsetWithText() : this.state.getHorizontalOffsetWithoutText();
        if (this.state.offsetAlignmentMode == 1) {
            horizontalOffsetWithText += hasBadgeContent() ? this.state.horizontalInsetWithText : this.state.horizontalInset;
        }
        return this.state.getAdditionalHorizontalOffset() + horizontalOffsetWithText;
    }

    private int getTotalVerticalOffsetForState() {
        int verticalOffsetWithoutText = this.state.getVerticalOffsetWithoutText();
        if (hasBadgeContent()) {
            verticalOffsetWithoutText = this.state.getVerticalOffsetWithText();
            Context context = this.contextRef.get();
            if (context != null) {
                verticalOffsetWithoutText = AnimationUtils.lerp(verticalOffsetWithoutText, verticalOffsetWithoutText - this.state.getLargeFontVerticalOffsetAdjustment(), AnimationUtils.lerp(0.0f, 1.0f, FONT_SCALE_THRESHOLD, 1.0f, MaterialResources.getFontScale(context) - 1.0f));
            }
        }
        if (this.state.offsetAlignmentMode == 0) {
            verticalOffsetWithoutText -= Math.round(this.halfBadgeHeight);
        }
        return this.state.getAdditionalVerticalOffset() + verticalOffsetWithoutText;
    }

    private boolean hasBadgeContent() {
        return hasText() || hasNumber();
    }

    private void onAlphaUpdated() {
        this.textDrawableHelper.getTextPaint().setAlpha(getAlpha());
        invalidateSelf();
    }

    private void onBackgroundColorUpdated() {
        ColorStateList valueOf = ColorStateList.valueOf(this.state.getBackgroundColor());
        if (this.shapeDrawable.getFillColor() != valueOf) {
            this.shapeDrawable.setFillColor(valueOf);
            invalidateSelf();
        }
    }

    private void onBadgeContentUpdated() {
        this.textDrawableHelper.setTextSizeDirty(true);
        onBadgeShapeAppearanceUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onBadgeGravityUpdated() {
        if (this.anchorViewRef == null || this.anchorViewRef.get() == null) {
            return;
        }
        updateBadgeCoordinates(this.anchorViewRef.get(), this.customBadgeParentRef != null ? this.customBadgeParentRef.get() : null);
    }

    private void onBadgeShapeAppearanceUpdated() {
        Context context = this.contextRef.get();
        if (context == null) {
            return;
        }
        this.shapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder(context, hasBadgeContent() ? this.state.getBadgeWithTextShapeAppearanceResId() : this.state.getBadgeShapeAppearanceResId(), hasBadgeContent() ? this.state.getBadgeWithTextShapeAppearanceOverlayResId() : this.state.getBadgeShapeAppearanceOverlayResId()).build());
        invalidateSelf();
    }

    private void onBadgeTextAppearanceUpdated() {
        TextAppearance textAppearance;
        Context context = this.contextRef.get();
        if (context == null || this.textDrawableHelper.getTextAppearance() == (textAppearance = new TextAppearance(context, this.state.getTextAppearanceResId()))) {
            return;
        }
        this.textDrawableHelper.setTextAppearance(textAppearance, context);
        onBadgeTextColorUpdated();
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onBadgeTextColorUpdated() {
        this.textDrawableHelper.getTextPaint().setColor(this.state.getBadgeTextColor());
        invalidateSelf();
    }

    private void onMaxBadgeLengthUpdated() {
        updateMaxBadgeNumber();
        this.textDrawableHelper.setTextSizeDirty(true);
        updateCenterAndBounds();
        invalidateSelf();
    }

    private void onNumberUpdated() {
        if (hasText()) {
            return;
        }
        onBadgeContentUpdated();
    }

    private void onTextUpdated() {
        onBadgeContentUpdated();
    }

    private void onVisibilityUpdated() {
        setVisible(this.state.isVisible(), false);
    }

    private void restoreState() {
        onBadgeShapeAppearanceUpdated();
        onBadgeTextAppearanceUpdated();
        onMaxBadgeLengthUpdated();
        onBadgeContentUpdated();
        onAlphaUpdated();
        onBackgroundColorUpdated();
        onBadgeTextColorUpdated();
        onBadgeGravityUpdated();
        updateCenterAndBounds();
        onVisibilityUpdated();
    }

    private static void updateAnchorParentToNotClip(View view) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        viewGroup.setClipChildren(false);
        viewGroup.setClipToPadding(false);
    }

    private void updateCenterAndBounds() {
        Context context = this.contextRef.get();
        View view = this.anchorViewRef != null ? this.anchorViewRef.get() : null;
        if (context == null || view == null) {
            return;
        }
        Rect rect = new Rect();
        rect.set(this.badgeBounds);
        Rect rect2 = new Rect();
        view.getDrawingRect(rect2);
        FrameLayout frameLayout = this.customBadgeParentRef != null ? this.customBadgeParentRef.get() : null;
        if (frameLayout != null) {
            frameLayout.offsetDescendantRectToMyCoords(view, rect2);
        }
        calculateCenterAndBounds(rect2, view);
        BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
        if (this.cornerRadius != -1.0f) {
            this.shapeDrawable.setCornerSize(this.cornerRadius);
        }
        if (rect.equals(this.badgeBounds)) {
            return;
        }
        this.shapeDrawable.setBounds(this.badgeBounds);
    }

    private void updateMaxBadgeNumber() {
        if (getMaxCharacterCount() != -2) {
            this.maxBadgeNumber = ((int) Math.pow(10.0d, getMaxCharacterCount() - 1.0d)) - 1;
        } else {
            this.maxBadgeNumber = getMaxNumber();
        }
    }

    public void clearNumber() {
        if (this.state.hasNumber()) {
            this.state.clearNumber();
            onNumberUpdated();
        }
    }

    public void clearText() {
        if (this.state.hasText()) {
            this.state.clearText();
            onTextUpdated();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (getBounds().isEmpty() || getAlpha() == 0 || !isVisible()) {
            return;
        }
        this.shapeDrawable.draw(canvas);
        if (hasBadgeContent()) {
            drawBadgeContent(canvas);
        }
    }

    int getAdditionalHorizontalOffset() {
        return this.state.getAdditionalHorizontalOffset();
    }

    int getAdditionalVerticalOffset() {
        return this.state.getAdditionalVerticalOffset();
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.state.getAlpha();
    }

    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    public int getBadgeGravity() {
        return this.state.getBadgeGravity();
    }

    public Locale getBadgeNumberLocale() {
        return this.state.getNumberLocale();
    }

    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    public CharSequence getContentDescription() {
        if (isVisible()) {
            return hasText() ? getTextContentDescription() : hasNumber() ? getNumberContentDescription() : getEmptyContentDescription();
        }
        return null;
    }

    public FrameLayout getCustomBadgeParent() {
        if (this.customBadgeParentRef != null) {
            return this.customBadgeParentRef.get();
        }
        return null;
    }

    public int getHorizontalOffset() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    public int getHorizontalOffsetWithText() {
        return this.state.getHorizontalOffsetWithText();
    }

    public int getHorizontalOffsetWithoutText() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    public int getHorizontalPadding() {
        return this.state.getBadgeHorizontalPadding();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public int getLargeFontVerticalOffsetAdjustment() {
        return this.state.getLargeFontVerticalOffsetAdjustment();
    }

    public int getMaxCharacterCount() {
        return this.state.getMaxCharacterCount();
    }

    public int getMaxNumber() {
        return this.state.getMaxNumber();
    }

    public int getNumber() {
        if (this.state.hasNumber()) {
            return this.state.getNumber();
        }
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BadgeState.State getSavedState() {
        return this.state.getOverridingState();
    }

    public String getText() {
        return this.state.getText();
    }

    public int getVerticalOffset() {
        return this.state.getVerticalOffsetWithoutText();
    }

    public int getVerticalOffsetWithText() {
        return this.state.getVerticalOffsetWithText();
    }

    public int getVerticalOffsetWithoutText() {
        return this.state.getVerticalOffsetWithoutText();
    }

    public int getVerticalPadding() {
        return this.state.getBadgeVerticalPadding();
    }

    public boolean hasNumber() {
        return !this.state.hasText() && this.state.hasNumber();
    }

    public boolean hasText() {
        return this.state.hasText();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return false;
    }

    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        return super.onStateChange(iArr);
    }

    @Override // com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public void onTextSizeChange() {
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAdditionalHorizontalOffset(int i) {
        this.state.setAdditionalHorizontalOffset(i);
        updateCenterAndBounds();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAdditionalVerticalOffset(int i) {
        this.state.setAdditionalVerticalOffset(i);
        updateCenterAndBounds();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.state.setAlpha(i);
        onAlphaUpdated();
    }

    @Deprecated
    public void setAutoAdjustToWithinGrandparentBounds(boolean z) {
        if (this.state.isAutoAdjustedToGrandparentBounds() == z) {
            return;
        }
        this.state.setAutoAdjustToGrandparentBounds(z);
        if (this.anchorViewRef == null || this.anchorViewRef.get() == null) {
            return;
        }
        autoAdjustWithinGrandparentBounds(this.anchorViewRef.get());
    }

    public void setBackgroundColor(int i) {
        this.state.setBackgroundColor(i);
        onBackgroundColorUpdated();
    }

    public void setBadgeFixedEdge(int i) {
        if (this.state.badgeFixedEdge != i) {
            this.state.badgeFixedEdge = i;
            updateCenterAndBounds();
        }
    }

    public void setBadgeGravity(int i) {
        if (i == 8388691 || i == 8388693) {
            Log.w(TAG, "Bottom badge gravities are deprecated; please use a top gravity instead.");
        }
        if (this.state.getBadgeGravity() != i) {
            this.state.setBadgeGravity(i);
            onBadgeGravityUpdated();
        }
    }

    public void setBadgeNumberLocale(Locale locale) {
        if (locale.equals(this.state.getNumberLocale())) {
            return;
        }
        this.state.setNumberLocale(locale);
        invalidateSelf();
    }

    public void setBadgeTextColor(int i) {
        if (this.textDrawableHelper.getTextPaint().getColor() != i) {
            this.state.setBadgeTextColor(i);
            onBadgeTextColorUpdated();
        }
    }

    public void setBadgeWithTextShapeAppearance(int i) {
        this.state.setBadgeWithTextShapeAppearanceResId(i);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithTextShapeAppearanceOverlay(int i) {
        this.state.setBadgeWithTextShapeAppearanceOverlayResId(i);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearance(int i) {
        this.state.setBadgeShapeAppearanceResId(i);
        onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearanceOverlay(int i) {
        this.state.setBadgeShapeAppearanceOverlayResId(i);
        onBadgeShapeAppearanceUpdated();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(int i) {
        this.state.setContentDescriptionExceedsMaxBadgeNumberStringResource(i);
    }

    public void setContentDescriptionForText(CharSequence charSequence) {
        this.state.setContentDescriptionForText(charSequence);
    }

    public void setContentDescriptionNumberless(CharSequence charSequence) {
        this.state.setContentDescriptionNumberless(charSequence);
    }

    public void setContentDescriptionQuantityStringsResource(int i) {
        this.state.setContentDescriptionQuantityStringsResource(i);
    }

    public void setHorizontalOffset(int i) {
        setHorizontalOffsetWithoutText(i);
        setHorizontalOffsetWithText(i);
    }

    public void setHorizontalOffsetWithText(int i) {
        this.state.setHorizontalOffsetWithText(i);
        updateCenterAndBounds();
    }

    public void setHorizontalOffsetWithoutText(int i) {
        this.state.setHorizontalOffsetWithoutText(i);
        updateCenterAndBounds();
    }

    public void setHorizontalPadding(int i) {
        if (i != this.state.getBadgeHorizontalPadding()) {
            this.state.setBadgeHorizontalPadding(i);
            updateCenterAndBounds();
        }
    }

    public void setLargeFontVerticalOffsetAdjustment(int i) {
        this.state.setLargeFontVerticalOffsetAdjustment(i);
        updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int i) {
        if (this.state.getMaxCharacterCount() != i) {
            this.state.setMaxCharacterCount(i);
            onMaxBadgeLengthUpdated();
        }
    }

    public void setMaxNumber(int i) {
        if (this.state.getMaxNumber() != i) {
            this.state.setMaxNumber(i);
            onMaxBadgeLengthUpdated();
        }
    }

    public void setNumber(int i) {
        int max = Math.max(0, i);
        if (this.state.getNumber() != max) {
            this.state.setNumber(max);
            onNumberUpdated();
        }
    }

    public void setText(String str) {
        if (TextUtils.equals(this.state.getText(), str)) {
            return;
        }
        this.state.setText(str);
        onTextUpdated();
    }

    public void setTextAppearance(int i) {
        this.state.setTextAppearanceResId(i);
        onBadgeTextAppearanceUpdated();
    }

    public void setVerticalOffset(int i) {
        setVerticalOffsetWithoutText(i);
        setVerticalOffsetWithText(i);
    }

    public void setVerticalOffsetWithText(int i) {
        this.state.setVerticalOffsetWithText(i);
        updateCenterAndBounds();
    }

    public void setVerticalOffsetWithoutText(int i) {
        this.state.setVerticalOffsetWithoutText(i);
        updateCenterAndBounds();
    }

    public void setVerticalPadding(int i) {
        if (i != this.state.getBadgeVerticalPadding()) {
            this.state.setBadgeVerticalPadding(i);
            updateCenterAndBounds();
        }
    }

    public void setVisible(boolean z) {
        this.state.setVisible(z);
        onVisibilityUpdated();
    }

    public void updateBadgeCoordinates(View view) {
        updateBadgeCoordinates(view, (FrameLayout) null);
    }

    @Deprecated
    public void updateBadgeCoordinates(View view, ViewGroup viewGroup) {
        if (!(viewGroup instanceof FrameLayout)) {
            throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
        }
        updateBadgeCoordinates(view, (FrameLayout) viewGroup);
    }

    public void updateBadgeCoordinates(View view, FrameLayout frameLayout) {
        this.anchorViewRef = new WeakReference<>(view);
        this.customBadgeParentRef = new WeakReference<>(frameLayout);
        updateAnchorParentToNotClip(view);
        updateCenterAndBounds();
        invalidateSelf();
    }
}
