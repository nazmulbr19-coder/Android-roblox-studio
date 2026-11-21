package com.google.android.material.button;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Layout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inspector.InspectionCompanion;
import android.view.inspector.PropertyMapper;
import android.view.inspector.PropertyReader;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.customview.view.AbsSavedState;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearance;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.shape.StateListShapeAppearanceModel;
import com.google.android.material.shape.StateListSizeChange;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 32;
    public static final int ICON_GRAVITY_TOP = 16;
    private static final String LOG_TAG = "MaterialButton";
    private static final float OPTICAL_CENTER_RATIO = 0.11f;
    private static final int UNSET = Integer.MIN_VALUE;
    private String accessibilityClassName;
    int allowedWidthDecrease;
    private boolean broadcasting;
    private boolean checked;
    private float displayedWidthDecrease;
    private float displayedWidthIncrease;
    private Drawable icon;
    private int iconGravity;
    private int iconLeft;
    private int iconPadding;
    private int iconSize;
    private ColorStateList iconTint;
    private PorterDuff.Mode iconTintMode;
    private int iconTop;
    private boolean isInHorizontalButtonGroup;
    private final MaterialButtonHelper materialButtonHelper;
    private final LinkedHashSet<OnCheckedChangeListener> onCheckedChangeListeners;
    private OnPressedChangeListener onPressedChangeListenerInternal;
    private boolean opticalCenterEnabled;
    private int opticalCenterShift;
    private int orientation;
    private LinearLayout.LayoutParams originalLayoutParams;
    private int originalPaddingEnd;
    private int originalPaddingStart;
    private float originalWidth;
    private Drawable secondaryIcon;
    private int secondaryIconGravity;
    private int secondaryIconLeft;
    private ColorStateList secondaryIconTint;
    private PorterDuff.Mode secondaryIconTintMode;
    private int secondaryIconTop;
    StateListSizeChange sizeChange;
    private boolean stopNullSecondaryIconUpdate;
    private WidthChangeDirection widthChangeDirection;
    int widthChangeMax;
    private SpringAnimation widthIncreaseSpringAnimation;
    private static final int[] CHECKABLE_STATE_SET = {R.attr.state_checkable};
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int DEF_STYLE_RES = com.google.android.material.R.style.Widget_MaterialComponents_Button;
    private static final int MATERIAL_SIZE_OVERLAY_ATTR = com.google.android.material.R.attr.materialSizeOverlay;
    private static final FloatPropertyCompat<MaterialButton> WIDTH_INCREASE = new AnonymousClass1("widthIncrease");

    /* renamed from: com.google.android.material.button.MaterialButton$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends FloatPropertyCompat<MaterialButton> {
        AnonymousClass1(String str) {
            super(str);
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(MaterialButton materialButton) {
            return MaterialButton.access$000(materialButton);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(MaterialButton materialButton) {
            return getValue2(materialButton);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(MaterialButton materialButton, float f) {
            MaterialButton.access$100(materialButton, f);
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(MaterialButton materialButton, float f) {
            setValue2(materialButton, f);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface IconGravity {
    }

    /* loaded from: classes.dex */
    public final class InspectionCompanion implements android.view.inspector.InspectionCompanion<MaterialButton> {
        private int mIconPaddingId;
        private boolean mPropertiesMapped = false;

        public void mapProperties(PropertyMapper propertyMapper) {
            this.mIconPaddingId = propertyMapper.mapInt("iconPadding", com.google.android.material.R.attr.iconPadding);
            this.mPropertiesMapped = true;
        }

        public void readProperties(MaterialButton materialButton, PropertyReader propertyReader) {
            if (!this.mPropertiesMapped) {
                throw new InspectionCompanion.UninitializedPropertyMapException();
            }
            propertyReader.readInt(this.mIconPaddingId, materialButton.getIconPadding());
        }

        public /* bridge */ /* synthetic */ void readProperties(Object obj, PropertyReader propertyReader) {
            readProperties((MaterialButton) obj, propertyReader);
        }
    }

    /* loaded from: classes.dex */
    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton materialButton, boolean z);
    }

    /* loaded from: classes.dex */
    interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton materialButton, boolean z);
    }

    /* loaded from: classes.dex */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        boolean checked;

        /* renamed from: com.google.android.material.button.MaterialButton$SavedState$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, null);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            @Override // android.os.Parcelable.ClassLoaderCreator
            public /* bridge */ /* synthetic */ SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return createFromParcel(parcel, classLoader);
            }

            @Override // android.os.Parcelable.Creator
            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return newArray(i);
            }
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            if (classLoader == null) {
                getClass().getClassLoader();
            }
            readFromParcel(parcel);
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        private void readFromParcel(Parcel parcel) {
            this.checked = parcel.readInt() == 1;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.checked ? 1 : 0);
        }
    }

    /* loaded from: classes.dex */
    enum WidthChangeDirection {
        NONE,
        START,
        END,
        BOTH
    }

    public MaterialButton(Context context) {
        this(context, null);
    }

    public MaterialButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.materialButtonStyle);
    }

    public MaterialButton(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES, new int[]{MATERIAL_SIZE_OVERLAY_ATTR}), attributeSet, i);
        this.onCheckedChangeListeners = new LinkedHashSet<>();
        this.checked = false;
        this.broadcasting = false;
        this.orientation = Integer.MIN_VALUE;
        this.originalWidth = -2.14748365E9f;
        this.originalPaddingStart = Integer.MIN_VALUE;
        this.originalPaddingEnd = Integer.MIN_VALUE;
        this.allowedWidthDecrease = Integer.MIN_VALUE;
        this.widthChangeDirection = WidthChangeDirection.BOTH;
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, com.google.android.material.R.styleable.MaterialButton, i, DEF_STYLE_RES, new int[0]);
        this.iconPadding = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList(getContext(), obtainStyledAttributes, com.google.android.material.R.styleable.MaterialButton_iconTint);
        this.icon = MaterialResources.getDrawable(getContext(), obtainStyledAttributes, com.google.android.material.R.styleable.MaterialButton_icon);
        this.iconGravity = obtainStyledAttributes.getInteger(com.google.android.material.R.styleable.MaterialButton_iconGravity, 1);
        this.iconSize = obtainStyledAttributes.getDimensionPixelSize(com.google.android.material.R.styleable.MaterialButton_iconSize, 0);
        this.secondaryIconTintMode = ViewUtils.parseTintMode(obtainStyledAttributes.getInt(com.google.android.material.R.styleable.MaterialButton_secondaryIconTintMode, -1), PorterDuff.Mode.SRC_IN);
        this.secondaryIconTint = obtainStyledAttributes.hasValue(com.google.android.material.R.styleable.MaterialButton_secondaryIconTint) ? MaterialResources.getColorStateList(getContext(), obtainStyledAttributes, com.google.android.material.R.styleable.MaterialButton_secondaryIconTint) : this.iconTint;
        this.secondaryIconGravity = obtainStyledAttributes.getInteger(com.google.android.material.R.styleable.MaterialButton_secondaryIconGravity, 3);
        this.secondaryIcon = MaterialResources.getDrawable(getContext(), obtainStyledAttributes, com.google.android.material.R.styleable.MaterialButton_secondaryIcon);
        this.stopNullSecondaryIconUpdate = this.secondaryIcon == null;
        StateListShapeAppearanceModel create = StateListShapeAppearanceModel.create(context2, obtainStyledAttributes, com.google.android.material.R.styleable.MaterialButton_shapeAppearance);
        ShapeAppearance build = create != null ? create : ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES).build();
        boolean z = obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.MaterialButton_opticalCenterEnabled, false);
        this.materialButtonHelper = new MaterialButtonHelper(this, build);
        this.materialButtonHelper.loadFromAttributes(obtainStyledAttributes);
        setCheckedInternal(obtainStyledAttributes.getBoolean(com.google.android.material.R.styleable.MaterialButton_android_checked, false));
        if (build instanceof StateListShapeAppearanceModel) {
            this.materialButtonHelper.setCornerSpringForce(createSpringForce());
        }
        setOpticalCenterEnabled(z);
        obtainStyledAttributes.recycle();
        setCompoundDrawablePadding(this.iconPadding);
        updateIcon(this.icon != null);
        updateSecondaryIcon(this.secondaryIcon != null);
    }

    static /* synthetic */ float access$000(MaterialButton materialButton) {
        return materialButton.getDisplayedWidthIncrease();
    }

    static /* synthetic */ void access$100(MaterialButton materialButton, float f) {
        materialButton.setDisplayedWidthIncrease(f);
    }

    private boolean areIconsGravitySameAlignment() {
        return (isIconStart() && isSecondaryIconStart()) || (isIconEnd() && isSecondaryIconEnd()) || (isIconTop() && isSecondaryIconTop());
    }

    private int calculateEffectiveWidthChangeMax() {
        switch (this.widthChangeDirection.ordinal()) {
            case 1:
            case 2:
                return this.widthChangeMax / 2;
            case 3:
                return this.widthChangeMax;
            default:
                return 0;
        }
    }

    private boolean canUpdateWithoutTextAlignment(int i) {
        Layout.Alignment actualTextAlignment = getActualTextAlignment();
        if (i == 1 || i == 3) {
            return true;
        }
        if (i == 2 && actualTextAlignment == Layout.Alignment.ALIGN_NORMAL) {
            return true;
        }
        return i == 4 && actualTextAlignment == Layout.Alignment.ALIGN_OPPOSITE;
    }

    private SpringForce createSpringForce() {
        return MotionUtils.resolveThemeSpringForce(getContext(), com.google.android.material.R.attr.motionSpringFastSpatial, com.google.android.material.R.style.Motion_Material3_Spring_Standard_Fast_Spatial);
    }

    private Layout.Alignment getActualTextAlignment() {
        switch (getTextAlignment()) {
            case 1:
                return getGravityTextAlignment();
            case 2:
            case 5:
            default:
                return Layout.Alignment.ALIGN_NORMAL;
            case 3:
            case 6:
                return Layout.Alignment.ALIGN_OPPOSITE;
            case 4:
                return Layout.Alignment.ALIGN_CENTER;
        }
    }

    private float getDisplayedWidthIncrease() {
        return this.displayedWidthIncrease;
    }

    private Layout.Alignment getGravityTextAlignment() {
        switch (getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) {
            case 1:
                return Layout.Alignment.ALIGN_CENTER;
            case 5:
            case GravityCompat.END /* 8388613 */:
                return Layout.Alignment.ALIGN_OPPOSITE;
            default:
                return Layout.Alignment.ALIGN_NORMAL;
        }
    }

    private int getIconLeft(int i, int i2) {
        int i3 = 0;
        if (this.icon != null) {
            i3 = this.iconSize == 0 ? this.icon.getIntrinsicWidth() : this.iconSize;
        }
        int i4 = 0;
        if (this.secondaryIcon != null) {
            i4 = this.iconSize == 0 ? this.secondaryIcon.getIntrinsicWidth() : this.iconSize;
        }
        int textLayoutWidth = (((((i - getTextLayoutWidth()) - getPaddingEnd()) - i3) - i4) - this.iconPadding) - getPaddingStart();
        int i5 = getActualTextAlignment() == Layout.Alignment.ALIGN_CENTER ? textLayoutWidth / 2 : textLayoutWidth;
        return isLayoutRTL() != (i2 == 4) ? -i5 : i5;
    }

    private int getIconTop(int i, int i2) {
        return Math.max(0, (((((i - getTextHeight()) - getPaddingTop()) - i2) - this.iconPadding) - getPaddingBottom()) / 2);
    }

    private int getOpticalCenterShift() {
        MaterialShapeDrawable materialShapeDrawable;
        if (this.opticalCenterEnabled && this.isInHorizontalButtonGroup && (materialShapeDrawable = this.materialButtonHelper.getMaterialShapeDrawable()) != null) {
            return (int) (materialShapeDrawable.getCornerSizeDiffX() * OPTICAL_CENTER_RATIO);
        }
        return 0;
    }

    private int getTextHeight() {
        if (getLineCount() > 1) {
            return getLayout().getHeight();
        }
        TextPaint paint = getPaint();
        String obj = getText().toString();
        if (getTransformationMethod() != null) {
            obj = getTransformationMethod().getTransformation(obj, this).toString();
        }
        Rect rect = new Rect();
        paint.getTextBounds(obj, 0, obj.length(), rect);
        return Math.min(rect.height(), getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        float f = 0.0f;
        int lineCount = getLineCount();
        for (int i = 0; i < lineCount; i++) {
            f = Math.max(f, getLayout().getLineWidth(i));
        }
        return (int) Math.ceil(f);
    }

    private Drawable getUpdatedIconFor(int i) {
        switch (i) {
            case 0:
                if (this.secondaryIcon == null || !isSecondaryIconStart()) {
                    return null;
                }
                return this.secondaryIcon;
            case 1:
                if (this.secondaryIcon == null || !isSecondaryIconTop()) {
                    return null;
                }
                return this.secondaryIcon;
            case 2:
                if (this.secondaryIcon == null || !isSecondaryIconEnd()) {
                    return null;
                }
                return this.secondaryIcon;
            default:
                return null;
        }
    }

    private Drawable getUpdatedSecondaryIconFor(int i) {
        switch (i) {
            case 0:
                if (this.icon == null || !isIconStart()) {
                    return null;
                }
                return this.icon;
            case 1:
                if (this.icon == null || !isIconEnd()) {
                    return null;
                }
                return this.icon;
            case 2:
                if (this.icon == null || !isIconEnd()) {
                    return null;
                }
                return this.icon;
            default:
                return null;
        }
    }

    private void initializeSizeAnimation() {
        this.widthIncreaseSpringAnimation = new SpringAnimation(this, WIDTH_INCREASE);
        this.widthIncreaseSpringAnimation.setSpring(createSpringForce());
    }

    private boolean isIconEnd() {
        return this.iconGravity == 3 || this.iconGravity == 4;
    }

    private boolean isIconStart() {
        return this.iconGravity == 1 || this.iconGravity == 2;
    }

    private boolean isIconTop() {
        return this.iconGravity == 16 || this.iconGravity == 32;
    }

    private boolean isInHorizontalButtonGroup() {
        return (getParent() instanceof MaterialButtonGroup) && ((MaterialButtonGroup) getParent()).getOrientation() == 0;
    }

    private boolean isLayoutRTL() {
        return getLayoutDirection() == 1;
    }

    private boolean isSecondaryIconEnd() {
        return this.secondaryIconGravity == 3 || this.secondaryIconGravity == 4;
    }

    private boolean isSecondaryIconStart() {
        return this.secondaryIconGravity == 1 || this.secondaryIconGravity == 2;
    }

    private boolean isSecondaryIconTop() {
        return this.secondaryIconGravity == 16 || this.secondaryIconGravity == 32;
    }

    private boolean isUsingOriginalBackground() {
        return (this.materialButtonHelper == null || this.materialButtonHelper.isBackgroundOverwritten()) ? false : true;
    }

    private void maybeAnimateSize(boolean z) {
        if (this.sizeChange == null) {
            return;
        }
        if (this.widthIncreaseSpringAnimation == null) {
            initializeSizeAnimation();
        }
        if (this.isInHorizontalButtonGroup) {
            this.widthIncreaseSpringAnimation.animateToFinalPosition(Math.min(calculateEffectiveWidthChangeMax(), this.sizeChange.getSizeChangeForState(getDrawableState()).widthChange.getChange(getWidth())));
            if (z) {
                this.widthIncreaseSpringAnimation.skipToEnd();
            }
        }
    }

    private boolean maybeRunAfterWidthAnimation(Runnable runnable) {
        if (this.widthIncreaseSpringAnimation == null || !this.widthIncreaseSpringAnimation.isRunning()) {
            return false;
        }
        post(new MaterialButton$$ExternalSyntheticLambda1(this, runnable));
        return true;
    }

    private void setCheckedInternal(boolean z) {
        if (!isCheckable() || this.checked == z) {
            return;
        }
        this.checked = z;
        refreshDrawableState();
        if (getParent() instanceof MaterialButtonToggleGroup) {
            ((MaterialButtonToggleGroup) getParent()).onButtonCheckedStateChanged(this, this.checked);
        }
        if (this.broadcasting) {
            return;
        }
        this.broadcasting = true;
        Iterator<OnCheckedChangeListener> it = this.onCheckedChangeListeners.iterator();
        while (it.hasNext()) {
            it.next().onCheckedChanged(this, this.checked);
        }
        this.broadcasting = false;
    }

    private void setDisplayedWidthIncrease(float f) {
        if (this.displayedWidthIncrease != f) {
            this.displayedWidthIncrease = f;
            updatePaddingsAndSizeForWidthAnimation();
            invalidate();
            if (getParent() instanceof MaterialButtonGroup) {
                ((MaterialButtonGroup) getParent()).onButtonWidthChanged(this, (int) this.displayedWidthIncrease);
            }
        }
    }

    private void updateIcon(boolean z) {
        if (this.icon != null) {
            this.icon = DrawableCompat.wrap(this.icon).mutate();
            this.icon.setTintList(this.iconTint);
            if (this.iconTintMode != null) {
                this.icon.setTintMode(this.iconTintMode);
            }
            this.icon.setBounds(this.iconLeft, this.iconTop, this.iconLeft + (this.iconSize != 0 ? this.iconSize : this.icon.getIntrinsicWidth()), this.iconTop + (this.iconSize != 0 ? this.iconSize : this.icon.getIntrinsicHeight()));
            this.icon.setVisible(true, z);
        }
        validateIconGravity();
        if (this.icon == null && this.secondaryIcon != null && areIconsGravitySameAlignment()) {
            return;
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = (isIconStart() && compoundDrawablesRelative[0] != this.icon) || (isIconEnd() && compoundDrawablesRelative[2] != this.icon) || (isIconTop() && compoundDrawablesRelative[1] != this.icon);
        if (z || z2) {
            if (isIconStart()) {
                setCompoundDrawablesRelative(this.icon, getUpdatedIconFor(1), getUpdatedIconFor(2), null);
            } else if (isIconEnd()) {
                setCompoundDrawablesRelative(getUpdatedIconFor(0), getUpdatedIconFor(1), this.icon, null);
            } else if (isIconTop()) {
                setCompoundDrawablesRelative(getUpdatedIconFor(0), this.icon, getUpdatedIconFor(2), null);
            }
        }
    }

    private void updateIconPosition(int i, int i2) {
        if (this.icon == null || getLayout() == null) {
            return;
        }
        if (isIconStart() || isIconEnd()) {
            this.iconTop = 0;
            if (canUpdateWithoutTextAlignment(this.iconGravity)) {
                this.iconLeft = 0;
                updateIcon(false);
                return;
            }
            int iconLeft = getIconLeft(i, this.iconGravity);
            if (this.iconLeft != iconLeft) {
                this.iconLeft = iconLeft;
                updateIcon(false);
                return;
            }
            return;
        }
        if (isIconTop()) {
            this.iconLeft = 0;
            if (this.iconGravity == 16) {
                this.iconTop = 0;
                updateIcon(false);
                return;
            }
            int iconTop = getIconTop(i2, this.iconSize == 0 ? this.icon.getIntrinsicHeight() : this.iconSize);
            if (this.iconTop != iconTop) {
                this.iconTop = iconTop;
                updateIcon(false);
            }
        }
    }

    private void updatePaddingsAndSizeForWidthAnimation() {
        int i = (int) (this.displayedWidthIncrease - this.displayedWidthDecrease);
        int i2 = (i / 2) + (isLayoutRTL() ? -this.opticalCenterShift : this.opticalCenterShift);
        if (getLayoutParams() != null) {
            getLayoutParams().width = (int) (this.originalWidth + i);
        }
        setPaddingRelative(this.originalPaddingStart + i2, getPaddingTop(), (this.originalPaddingEnd + i) - i2, getPaddingBottom());
    }

    private void updateSecondaryIcon(boolean z) {
        if (this.secondaryIcon != null) {
            this.secondaryIcon = DrawableCompat.wrap(this.secondaryIcon).mutate();
            this.secondaryIcon.setTintList(this.secondaryIconTint);
            if (this.secondaryIconTintMode != null) {
                this.secondaryIcon.setTintMode(this.secondaryIconTintMode);
            }
            this.secondaryIcon.setBounds(this.secondaryIconLeft, this.secondaryIconTop, this.secondaryIconLeft + (this.iconSize != 0 ? this.iconSize : this.secondaryIcon.getIntrinsicWidth()), this.secondaryIconTop + (this.iconSize != 0 ? this.iconSize : this.secondaryIcon.getIntrinsicHeight()));
            this.secondaryIcon.setVisible(true, z);
        }
        validateSecondaryIconGravity();
        if (this.secondaryIcon == null) {
            if (this.stopNullSecondaryIconUpdate) {
                return;
            }
            if (this.icon != null && areIconsGravitySameAlignment()) {
                return;
            }
        }
        Drawable[] compoundDrawablesRelative = getCompoundDrawablesRelative();
        boolean z2 = (isSecondaryIconStart() && compoundDrawablesRelative[0] != this.secondaryIcon) || (isSecondaryIconEnd() && compoundDrawablesRelative[2] != this.secondaryIcon) || (isSecondaryIconTop() && compoundDrawablesRelative[1] != this.secondaryIcon);
        if (z || z2) {
            if (isSecondaryIconStart()) {
                setCompoundDrawablesRelative(this.secondaryIcon, getUpdatedSecondaryIconFor(1), getUpdatedSecondaryIconFor(2), null);
            } else if (isSecondaryIconEnd()) {
                setCompoundDrawablesRelative(getUpdatedSecondaryIconFor(0), getUpdatedSecondaryIconFor(1), this.secondaryIcon, null);
            } else if (isSecondaryIconTop()) {
                setCompoundDrawablesRelative(getUpdatedSecondaryIconFor(0), this.secondaryIcon, getUpdatedSecondaryIconFor(2), null);
            }
        }
    }

    private void updateSecondaryIconPosition(int i, int i2) {
        if (this.secondaryIcon == null || getLayout() == null) {
            return;
        }
        if (isSecondaryIconStart() || isSecondaryIconEnd()) {
            this.secondaryIconTop = 0;
            if (canUpdateWithoutTextAlignment(this.secondaryIconGravity)) {
                this.secondaryIconLeft = 0;
                updateSecondaryIcon(false);
                return;
            }
            int iconLeft = getIconLeft(i, this.secondaryIconGravity);
            if (this.secondaryIconLeft != iconLeft) {
                this.secondaryIconLeft = iconLeft;
                updateSecondaryIcon(false);
                return;
            }
            return;
        }
        if (isSecondaryIconTop()) {
            this.secondaryIconLeft = 0;
            if (this.secondaryIconGravity == 16) {
                this.secondaryIconTop = 0;
                updateSecondaryIcon(false);
                return;
            }
            int iconTop = getIconTop(i2, this.iconSize == 0 ? this.secondaryIcon.getIntrinsicHeight() : this.iconSize);
            if (this.secondaryIconTop != iconTop) {
                this.secondaryIconTop = iconTop;
                updateSecondaryIcon(false);
            }
        }
    }

    private void validateIconGravity() {
        if (this.icon != null && this.secondaryIcon != null && areIconsGravitySameAlignment()) {
            throw new IllegalArgumentException("iconGravity cannot have the same alignment as secondaryIconGravity");
        }
    }

    private void validateSecondaryIconGravity() {
        if (this.secondaryIcon != null && this.icon != null && areIconsGravitySameAlignment()) {
            throw new IllegalArgumentException("secondaryIconGravity cannot have the same alignment as iconGravity");
        }
    }

    public void addOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.add(onCheckedChangeListener);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    String getA11yClassName() {
        if (TextUtils.isEmpty(this.accessibilityClassName)) {
            return (isCheckable() ? CompoundButton.class : Button.class).getName();
        }
        return this.accessibilityClassName;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getAllowedWidthDecrease() {
        return this.allowedWidthDecrease;
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return getSupportBackgroundTintList();
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getCornerRadius();
        }
        return 0;
    }

    public SpringForce getCornerSpringForce() {
        return this.materialButtonHelper.getCornerSpringForce();
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff.Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public int getInsetBottom() {
        return this.materialButtonHelper.getInsetBottom();
    }

    public int getInsetLeft() {
        return this.materialButtonHelper.getInsetLeft();
    }

    public int getInsetRight() {
        return this.materialButtonHelper.getInsetRight();
    }

    public int getInsetTop() {
        return this.materialButtonHelper.getInsetTop();
    }

    public ColorStateList getRippleColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getRippleColor();
        }
        return null;
    }

    public Drawable getSecondaryIcon() {
        return this.secondaryIcon;
    }

    public int getSecondaryIconGravity() {
        return this.secondaryIconGravity;
    }

    public ColorStateList getSecondaryIconTint() {
        return this.secondaryIconTint;
    }

    public PorterDuff.Mode getSecondaryIconTintMode() {
        return this.secondaryIconTintMode;
    }

    public ShapeAppearance getShapeAppearance() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getShapeAppearance();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearance from a MaterialButton which has an overwritten background.");
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getShapeAppearanceModel();
        }
        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeColor();
        }
        return null;
    }

    public int getStrokeWidth() {
        if (isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeWidth();
        }
        return 0;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public ColorStateList getSupportBackgroundTintList() {
        return isUsingOriginalBackground() ? this.materialButtonHelper.getSupportBackgroundTintList() : super.getSupportBackgroundTintList();
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return isUsingOriginalBackground() ? this.materialButtonHelper.getSupportBackgroundTintMode() : super.getSupportBackgroundTintMode();
    }

    public boolean isCheckable() {
        return this.materialButtonHelper != null && this.materialButtonHelper.isCheckable();
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.checked;
    }

    public boolean isOpticalCenterEnabled() {
        return this.opticalCenterEnabled;
    }

    public boolean isToggleCheckedStateOnClick() {
        return this.materialButtonHelper.isToggleCheckedStateOnClick();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$maybeRunAfterWidthAnimation$0$com-google-android-material-button-MaterialButton, reason: not valid java name */
    public /* synthetic */ void m322x69e9bdf6(Runnable runnable) {
        runnable.run();
        recoverOriginalLayoutParams();
        requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setIcon$2$com-google-android-material-button-MaterialButton, reason: not valid java name */
    public /* synthetic */ void m323x85a2f9c(Drawable drawable) {
        setIcon(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setIconSize$1$com-google-android-material-button-MaterialButton, reason: not valid java name */
    public /* synthetic */ void m324xc9d1887c(int i) {
        setIconSize(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOpticalCenterEnabled$4$com-google-android-material-button-MaterialButton, reason: not valid java name */
    public /* synthetic */ void m325x6fa58539(float f) {
        int i = (int) (OPTICAL_CENTER_RATIO * f);
        if (this.opticalCenterShift != i) {
            this.opticalCenterShift = i;
            updatePaddingsAndSizeForWidthAnimation();
            invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setOpticalCenterEnabled$5$com-google-android-material-button-MaterialButton, reason: not valid java name */
    public /* synthetic */ void m326xb330a2fa() {
        this.opticalCenterShift = getOpticalCenterShift();
        updatePaddingsAndSizeForWidthAnimation();
        invalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setSecondaryIcon$3$com-google-android-material-button-MaterialButton, reason: not valid java name */
    public /* synthetic */ void m327x11712a47(Drawable drawable) {
        setIcon(drawable);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isUsingOriginalBackground()) {
            MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialButtonHelper.getMaterialShapeDrawable());
        }
    }

    @Override // android.widget.TextView, android.view.View
    protected int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 2);
        if (isCheckable()) {
            mergeDrawableStates(onCreateDrawableState, CHECKABLE_STATE_SET);
        }
        if (isChecked()) {
            mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(getA11yClassName());
        accessibilityEvent.setChecked(isChecked());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(getA11yClassName());
        accessibilityNodeInfo.setCheckable(isCheckable());
        accessibilityNodeInfo.setChecked(isChecked());
        accessibilityNodeInfo.setClickable(isClickable());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int iconPadding;
        super.onLayout(z, i, i2, i3, i4);
        int i5 = Build.VERSION.SDK_INT;
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        updateSecondaryIconPosition(getMeasuredWidth(), getMeasuredHeight());
        int i6 = getResources().getConfiguration().orientation;
        if (this.orientation != i6) {
            this.orientation = i6;
            this.originalWidth = -2.14748365E9f;
        }
        if (this.originalWidth == -2.14748365E9f) {
            this.originalWidth = getMeasuredWidth();
            if (this.originalLayoutParams == null && (getParent() instanceof MaterialButtonGroup) && ((MaterialButtonGroup) getParent()).getButtonSizeChange() != null) {
                this.originalLayoutParams = (LinearLayout.LayoutParams) getLayoutParams();
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(this.originalLayoutParams);
                layoutParams.width = (int) this.originalWidth;
                setLayoutParams(layoutParams);
            }
        }
        if (this.allowedWidthDecrease == Integer.MIN_VALUE) {
            if (this.icon == null) {
                iconPadding = 0;
            } else {
                iconPadding = getIconPadding() + (this.iconSize == 0 ? this.icon.getIntrinsicWidth() : this.iconSize);
            }
            this.allowedWidthDecrease = (getMeasuredWidth() - getTextLayoutWidth()) - iconPadding;
        }
        if (this.originalPaddingStart == Integer.MIN_VALUE) {
            this.originalPaddingStart = getPaddingStart();
        }
        if (this.originalPaddingEnd == Integer.MIN_VALUE) {
            this.originalPaddingEnd = getPaddingEnd();
        }
        this.isInHorizontalButtonGroup = isInHorizontalButtonGroup();
    }

    @Override // android.widget.TextView, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setChecked(savedState.checked);
    }

    @Override // android.widget.TextView, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.checked = this.checked;
        return savedState;
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        updateSecondaryIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // android.view.View
    public boolean performClick() {
        boolean z = false;
        if (isEnabled() && this.materialButtonHelper.isToggleCheckedStateOnClick()) {
            toggle();
            z = true;
        }
        boolean performClick = super.performClick();
        if (z && !performClick) {
            playSoundEffect(0);
        }
        return performClick;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void recoverOriginalLayoutParams() {
        if (this.originalLayoutParams != null) {
            setLayoutParams(this.originalLayoutParams);
            this.originalLayoutParams = null;
            this.originalWidth = -2.14748365E9f;
        }
    }

    @Override // android.view.View
    public void refreshDrawableState() {
        super.refreshDrawableState();
        if (this.icon != null) {
            if (this.icon.setState(getDrawableState())) {
                invalidate();
            }
        }
    }

    public void removeOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListeners.remove(onCheckedChangeListener);
    }

    public void setA11yClassName(String str) {
        this.accessibilityClassName = str;
    }

    @Override // android.view.View
    public void setBackground(Drawable drawable) {
        setBackgroundDrawable(drawable);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setBackgroundColor(i);
        } else {
            super.setBackgroundColor(i);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        if (!isUsingOriginalBackground()) {
            super.setBackgroundDrawable(drawable);
        } else {
            if (drawable == getBackground()) {
                getBackground().setState(drawable.getState());
                return;
            }
            Log.w(LOG_TAG, "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
            this.materialButtonHelper.setBackgroundOverwritten();
            super.setBackgroundDrawable(drawable);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.view.View
    public void setBackgroundResource(int i) {
        setBackgroundDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        setSupportBackgroundTintList(colorStateList);
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        setSupportBackgroundTintMode(mode);
    }

    public void setCheckable(boolean z) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setCheckable(z);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        setCheckedInternal(z);
    }

    @Override // android.widget.TextView
    public void setCompoundDrawablePadding(int i) {
        if (getCompoundDrawablePadding() != i) {
            this.originalWidth = -2.14748365E9f;
        }
        super.setCompoundDrawablePadding(i);
    }

    public void setCornerRadius(int i) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setCornerRadius(i);
        }
    }

    public void setCornerRadiusResource(int i) {
        if (isUsingOriginalBackground()) {
            setCornerRadius(getResources().getDimensionPixelSize(i));
        }
    }

    public void setCornerSpringForce(SpringForce springForce) {
        this.materialButtonHelper.setCornerSpringForce(springForce);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDisplayedWidthDecrease(int i) {
        this.displayedWidthDecrease = Math.min(i, this.allowedWidthDecrease);
        updatePaddingsAndSizeForWidthAnimation();
        invalidate();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.getMaterialShapeDrawable().setElevation(f);
        }
    }

    public void setIcon(Drawable drawable) {
        if (this.icon == drawable || maybeRunAfterWidthAnimation(new MaterialButton$$ExternalSyntheticLambda2(this, drawable))) {
            return;
        }
        this.originalWidth = -2.14748365E9f;
        this.icon = drawable;
        updateIcon(true);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setIconGravity(int i) {
        if (this.iconGravity != i) {
            validateIconGravity();
            this.iconGravity = i;
            updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setIconPadding(int i) {
        if (this.iconPadding != i) {
            this.iconPadding = i;
            setCompoundDrawablePadding(i);
        }
    }

    public void setIconResource(int i) {
        setIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setIconSize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("iconSize cannot be less than 0");
        }
        if (this.iconSize == i || maybeRunAfterWidthAnimation(new MaterialButton$$ExternalSyntheticLambda3(this, i))) {
            return;
        }
        this.originalWidth = -2.14748365E9f;
        this.iconSize = i;
        updateIcon(true);
        updateSecondaryIcon(true);
    }

    public void setIconTint(ColorStateList colorStateList) {
        if (this.iconTint != colorStateList) {
            this.iconTint = colorStateList;
            updateIcon(false);
        }
    }

    public void setIconTintMode(PorterDuff.Mode mode) {
        if (this.iconTintMode != mode) {
            this.iconTintMode = mode;
            updateIcon(false);
        }
    }

    public void setIconTintResource(int i) {
        setIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setInsetBottom(int i) {
        this.materialButtonHelper.setInsetBottom(i);
    }

    public void setInsetLeft(int i) {
        this.materialButtonHelper.setInsetLeft(i);
    }

    public void setInsetRight(int i) {
        this.materialButtonHelper.setInsetRight(i);
    }

    public void setInsetTop(int i) {
        this.materialButtonHelper.setInsetTop(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInternalBackground(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPressedChangeListenerInternal(OnPressedChangeListener onPressedChangeListener) {
        this.onPressedChangeListenerInternal = onPressedChangeListener;
    }

    public void setOpticalCenterEnabled(boolean z) {
        if (this.opticalCenterEnabled != z) {
            this.opticalCenterEnabled = z;
            if (z) {
                this.materialButtonHelper.setCornerSizeChangeListener(new MaterialButton$$ExternalSyntheticLambda4(this));
            } else {
                this.materialButtonHelper.setCornerSizeChangeListener(null);
            }
            post(new MaterialButton$$ExternalSyntheticLambda5(this));
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        if (this.onPressedChangeListenerInternal != null) {
            this.onPressedChangeListenerInternal.onPressedChanged(this, z);
        }
        super.setPressed(z);
        maybeAnimateSize(false);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setRippleColor(colorStateList);
        }
    }

    public void setRippleColorResource(int i) {
        if (isUsingOriginalBackground()) {
            setRippleColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setSecondaryIcon(Drawable drawable) {
        if (this.secondaryIcon == drawable || maybeRunAfterWidthAnimation(new MaterialButton$$ExternalSyntheticLambda0(this, drawable))) {
            return;
        }
        this.originalWidth = -2.14748365E9f;
        this.secondaryIcon = drawable;
        this.stopNullSecondaryIconUpdate = false;
        updateSecondaryIcon(true);
        updateSecondaryIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    public void setSecondaryIconGravity(int i) {
        if (this.secondaryIconGravity != i) {
            validateSecondaryIconGravity();
            this.secondaryIconGravity = i;
            updateSecondaryIconPosition(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public void setSecondaryIconResource(int i) {
        setSecondaryIcon(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setSecondaryIconTint(ColorStateList colorStateList) {
        if (this.secondaryIconTint != colorStateList) {
            this.secondaryIconTint = colorStateList;
            updateSecondaryIcon(false);
        }
    }

    public void setSecondaryIconTintMode(PorterDuff.Mode mode) {
        if (this.secondaryIconTintMode != mode) {
            this.secondaryIconTintMode = mode;
            updateSecondaryIcon(false);
        }
    }

    public void setSecondaryIconTintResource(int i) {
        setSecondaryIconTint(AppCompatResources.getColorStateList(getContext(), i));
    }

    public void setShapeAppearance(ShapeAppearance shapeAppearance) {
        if (!isUsingOriginalBackground()) {
            throw new IllegalStateException("Attempted to set ShapeAppearance on a MaterialButton which has an overwritten background.");
        }
        if (this.materialButtonHelper.getCornerSpringForce() == null && shapeAppearance.isStateful()) {
            this.materialButtonHelper.setCornerSpringForce(createSpringForce());
        }
        this.materialButtonHelper.setShapeAppearance(shapeAppearance);
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        if (!isUsingOriginalBackground()) {
            throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
        }
        this.materialButtonHelper.setShapeAppearance(shapeAppearanceModel);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setShouldDrawSurfaceColorStroke(boolean z) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setShouldDrawSurfaceColorStroke(z);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSizeChange(StateListSizeChange stateListSizeChange) {
        if (this.sizeChange != stateListSizeChange) {
            this.sizeChange = stateListSizeChange;
            maybeAnimateSize(true);
        }
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeColor(colorStateList);
        }
    }

    public void setStrokeColorResource(int i) {
        if (isUsingOriginalBackground()) {
            setStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setStrokeWidth(int i) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeWidth(i);
        }
    }

    public void setStrokeWidthResource(int i) {
        if (isUsingOriginalBackground()) {
            setStrokeWidth(getResources().getDimensionPixelSize(i));
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintList(colorStateList);
        } else {
            super.setSupportBackgroundTintList(colorStateList);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatButton, androidx.core.view.TintableBackgroundView
    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        if (isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintMode(mode);
        } else {
            super.setSupportBackgroundTintMode(mode);
        }
    }

    @Override // android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        this.originalWidth = -2.14748365E9f;
        super.setText(charSequence, bufferType);
    }

    @Override // android.view.View
    public void setTextAlignment(int i) {
        super.setTextAlignment(i);
        updateIconPosition(getMeasuredWidth(), getMeasuredHeight());
        updateSecondaryIconPosition(getMeasuredWidth(), getMeasuredHeight());
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void setTextAppearance(Context context, int i) {
        this.originalWidth = -2.14748365E9f;
        super.setTextAppearance(context, i);
    }

    @Override // androidx.appcompat.widget.AppCompatButton, android.widget.TextView
    public void setTextSize(int i, float f) {
        this.originalWidth = -2.14748365E9f;
        super.setTextSize(i, f);
    }

    public void setToggleCheckedStateOnClick(boolean z) {
        this.materialButtonHelper.setToggleCheckedStateOnClick(z);
    }

    @Override // android.widget.TextView
    public void setWidth(int i) {
        this.originalWidth = -2.14748365E9f;
        super.setWidth(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWidthChangeDirection(WidthChangeDirection widthChangeDirection) {
        if (this.widthChangeDirection != widthChangeDirection) {
            this.widthChangeDirection = widthChangeDirection;
            maybeAnimateSize(true);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setWidthChangeMax(int i) {
        if (this.widthChangeMax != i) {
            this.widthChangeMax = i;
            maybeAnimateSize(true);
        }
    }

    @Override // android.widget.Checkable
    public void toggle() {
        setChecked(!this.checked);
    }
}
