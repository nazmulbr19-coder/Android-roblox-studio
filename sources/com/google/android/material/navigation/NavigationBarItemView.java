package com.google.android.material.navigation;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.focus.FocusRingDrawable;
import com.google.android.material.internal.BaselineLayout;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;

/* loaded from: classes.dex */
public abstract class NavigationBarItemView extends FrameLayout implements NavigationBarMenuItemView {
    private static final int INVALID_ITEM_POSITION = -1;
    private ValueAnimator activeIndicatorAnimator;
    private int activeIndicatorDesiredHeight;
    private int activeIndicatorDesiredWidth;
    private boolean activeIndicatorEnabled;
    private int activeIndicatorExpandedDesiredHeight;
    private int activeIndicatorExpandedDesiredWidth;
    private int activeIndicatorExpandedMarginHorizontal;
    private int activeIndicatorLabelPadding;
    private int activeIndicatorMarginHorizontal;
    private float activeIndicatorProgress;
    private boolean activeIndicatorResizeable;
    private ActiveIndicatorTransform activeIndicatorTransform;
    private final View activeIndicatorView;
    private BadgeDrawable badgeDrawable;
    private int badgeFixedEdge;
    private boolean boldText;
    private final LinearLayout contentContainer;
    private BaselineLayout currentLabelGroup;
    private boolean expanded;
    private BaselineLayout expandedLabelGroup;
    private float expandedLabelScaleDownFactor;
    private float expandedLabelScaleUpFactor;
    private float expandedLabelShiftAmountY;
    private TextView expandedLargeLabel;
    private TextView expandedSmallLabel;
    private int horizontalTextAppearanceActive;
    private int horizontalTextAppearanceInactive;
    private final ImageView icon;
    private final FrameLayout iconContainer;
    private int iconLabelHorizontalSpacing;
    private ColorStateList iconTint;
    private boolean initialized;
    private final LinearLayout innerContentContainer;
    private boolean isShifting;
    private Rect itemActiveIndicatorExpandedPadding;
    Drawable itemBackground;
    private MenuItemImpl itemData;
    private int itemGravity;
    private int itemIconGravity;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private int itemPosition;
    private ColorStateList itemRippleColor;
    private final BaselineLayout labelGroup;
    private int labelVisibilityMode;
    private final TextView largeLabel;
    private boolean measurePaddingFromBaseline;
    private boolean onlyShowWhenExpanded;
    private Drawable originalIconDrawable;
    private float scaleDownFactor;
    private boolean scaleLabelSizeWithFont;
    private float scaleUpFactor;
    private float shiftAmountY;
    private final TextView smallLabel;
    private int textAppearanceActive;
    private int textAppearanceInactive;
    private ColorStateList textColor;
    private Drawable wrappedIconDrawable;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_LABELED_TRANSFORM = new ActiveIndicatorTransform(null);
    private static final ActiveIndicatorTransform ACTIVE_INDICATOR_UNLABELED_TRANSFORM = new ActiveIndicatorUnlabeledTransform(null);

    /* renamed from: com.google.android.material.navigation.NavigationBarItemView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ int val$width;

        AnonymousClass1(int i) {
            this.val$width = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            NavigationBarItemView.this.updateActiveIndicatorLayoutParams(this.val$width);
        }
    }

    /* renamed from: com.google.android.material.navigation.NavigationBarItemView$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements ValueAnimator.AnimatorUpdateListener {
        final /* synthetic */ float val$newProgress;

        AnonymousClass2(float f) {
            this.val$newProgress = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            NavigationBarItemView.access$200(NavigationBarItemView.this, ((Float) valueAnimator.getAnimatedValue()).floatValue(), this.val$newProgress);
        }
    }

    /* loaded from: classes.dex */
    private static class ActiveIndicatorTransform {
        private static final float ALPHA_FRACTION = 0.2f;
        private static final float SCALE_X_HIDDEN = 0.4f;
        private static final float SCALE_X_SHOWN = 1.0f;

        private ActiveIndicatorTransform() {
        }

        /* synthetic */ ActiveIndicatorTransform(AnonymousClass1 anonymousClass1) {
            this();
        }

        protected float calculateAlpha(float f, float f2) {
            return AnimationUtils.lerp(0.0f, 1.0f, f2 == 0.0f ? 0.8f : 0.0f, f2 == 0.0f ? 1.0f : 0.2f, f);
        }

        protected float calculateScaleX(float f) {
            return AnimationUtils.lerp(SCALE_X_HIDDEN, 1.0f, f);
        }

        protected float calculateScaleY(float f) {
            return 1.0f;
        }

        public void updateForProgress(float f, float f2, View view) {
            view.setScaleX(calculateScaleX(f));
            view.setScaleY(calculateScaleY(f));
            view.setAlpha(calculateAlpha(f, f2));
        }
    }

    /* loaded from: classes.dex */
    private static class ActiveIndicatorUnlabeledTransform extends ActiveIndicatorTransform {
        private ActiveIndicatorUnlabeledTransform() {
            super(null);
        }

        /* synthetic */ ActiveIndicatorUnlabeledTransform(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.material.navigation.NavigationBarItemView.ActiveIndicatorTransform
        protected float calculateScaleY(float f) {
            return calculateScaleX(f);
        }
    }

    public NavigationBarItemView(Context context) {
        super(context);
        this.initialized = false;
        this.itemPosition = -1;
        this.textAppearanceActive = 0;
        this.textAppearanceInactive = 0;
        this.horizontalTextAppearanceActive = 0;
        this.horizontalTextAppearanceInactive = 0;
        this.boldText = false;
        this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        this.activeIndicatorProgress = 0.0f;
        this.activeIndicatorEnabled = false;
        this.activeIndicatorDesiredWidth = 0;
        this.activeIndicatorDesiredHeight = 0;
        this.activeIndicatorExpandedDesiredWidth = -2;
        this.activeIndicatorExpandedDesiredHeight = 0;
        this.activeIndicatorResizeable = false;
        this.activeIndicatorMarginHorizontal = 0;
        this.activeIndicatorExpandedMarginHorizontal = 0;
        this.badgeFixedEdge = 0;
        this.itemGravity = 49;
        this.expanded = false;
        this.onlyShowWhenExpanded = false;
        this.measurePaddingFromBaseline = false;
        this.scaleLabelSizeWithFont = false;
        this.itemActiveIndicatorExpandedPadding = new Rect();
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        this.contentContainer = (LinearLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_content_container);
        this.innerContentContainer = (LinearLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_inner_content_container);
        this.activeIndicatorView = findViewById(com.google.android.material.R.id.navigation_bar_item_active_indicator_view);
        this.iconContainer = (FrameLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_container);
        this.icon = (ImageView) findViewById(com.google.android.material.R.id.navigation_bar_item_icon_view);
        this.labelGroup = (BaselineLayout) findViewById(com.google.android.material.R.id.navigation_bar_item_labels_group);
        this.smallLabel = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_small_label_view);
        this.largeLabel = (TextView) findViewById(com.google.android.material.R.id.navigation_bar_item_large_label_view);
        initializeDefaultExpandedLabelGroupViews();
        this.currentLabelGroup = this.labelGroup;
        setBackgroundResource(getItemBackgroundResId());
        this.itemPaddingTop = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        this.itemPaddingBottom = this.labelGroup.getPaddingBottom();
        this.activeIndicatorLabelPadding = 0;
        this.iconLabelHorizontalSpacing = 0;
        this.smallLabel.setImportantForAccessibility(2);
        this.largeLabel.setImportantForAccessibility(2);
        this.expandedSmallLabel.setImportantForAccessibility(2);
        this.expandedLargeLabel.setImportantForAccessibility(2);
        setFocusable(true);
        calculateTextScaleFactors();
        this.activeIndicatorExpandedDesiredHeight = getResources().getDimensionPixelSize(com.google.android.material.R.dimen.m3_navigation_item_expanded_active_indicator_height_default);
        this.innerContentContainer.addOnLayoutChangeListener(new NavigationBarItemView$$ExternalSyntheticLambda0(this));
    }

    static /* synthetic */ void access$200(NavigationBarItemView navigationBarItemView, float f, float f2) {
        navigationBarItemView.setActiveIndicatorProgress(f, f2);
    }

    private void addDefaultExpandedLabelGroupViews() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        this.innerContentContainer.addView(this.expandedLabelGroup, layoutParams);
        setExpandedLabelGroupMargins();
    }

    private void calculateTextScaleFactors() {
        float textSize = this.smallLabel.getTextSize();
        float textSize2 = this.largeLabel.getTextSize();
        this.shiftAmountY = textSize - textSize2;
        this.scaleUpFactor = (textSize2 * 1.0f) / textSize;
        this.scaleDownFactor = (textSize * 1.0f) / textSize2;
        float textSize3 = this.expandedSmallLabel.getTextSize();
        float textSize4 = this.expandedLargeLabel.getTextSize();
        this.expandedLabelShiftAmountY = textSize3 - textSize4;
        this.expandedLabelScaleUpFactor = (textSize4 * 1.0f) / textSize3;
        this.expandedLabelScaleDownFactor = (1.0f * textSize3) / textSize4;
    }

    private Drawable createItemBackgroundCompat(ColorStateList colorStateList) {
        return FocusRingDrawable.wrap(getContext(), new RippleDrawable(RippleUtils.convertToRippleDrawableColor(colorStateList), null, null));
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i = 0;
        for (int i2 = 0; i2 < indexOfChild; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i++;
            }
        }
        return i;
    }

    private int getSuggestedIconWidth() {
        int minimumWidth = this.badgeDrawable == null ? 0 : this.badgeDrawable.getMinimumWidth() - this.badgeDrawable.getHorizontalOffset();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.iconContainer.getLayoutParams();
        return Math.max(minimumWidth, layoutParams.leftMargin) + this.icon.getMeasuredWidth() + Math.max(minimumWidth, layoutParams.rightMargin);
    }

    private boolean hasBadge() {
        return this.badgeDrawable != null;
    }

    private void initializeDefaultExpandedLabelGroupViews() {
        float dimension = getResources().getDimension(com.google.android.material.R.dimen.default_navigation_text_size);
        float dimension2 = getResources().getDimension(com.google.android.material.R.dimen.default_navigation_active_text_size);
        this.expandedLabelGroup = new BaselineLayout(getContext());
        this.expandedLabelGroup.setVisibility(8);
        this.expandedLabelGroup.setDuplicateParentStateEnabled(true);
        this.expandedLabelGroup.setMeasurePaddingFromBaseline(this.measurePaddingFromBaseline);
        this.expandedSmallLabel = new TextView(getContext());
        this.expandedSmallLabel.setMaxLines(1);
        this.expandedSmallLabel.setEllipsize(TextUtils.TruncateAt.END);
        this.expandedSmallLabel.setDuplicateParentStateEnabled(true);
        this.expandedSmallLabel.setIncludeFontPadding(false);
        this.expandedSmallLabel.setGravity(16);
        this.expandedSmallLabel.setTextSize(dimension);
        this.expandedLargeLabel = new TextView(getContext());
        this.expandedLargeLabel.setMaxLines(1);
        this.expandedLargeLabel.setEllipsize(TextUtils.TruncateAt.END);
        this.expandedLargeLabel.setDuplicateParentStateEnabled(true);
        this.expandedLargeLabel.setVisibility(4);
        this.expandedLargeLabel.setIncludeFontPadding(false);
        this.expandedLargeLabel.setGravity(16);
        this.expandedLargeLabel.setTextSize(dimension2);
        this.expandedLabelGroup.addView(this.expandedSmallLabel);
        this.expandedLabelGroup.addView(this.expandedLargeLabel);
    }

    private boolean isActiveIndicatorResizeableAndUnlabeled() {
        return this.activeIndicatorResizeable && this.labelVisibilityMode == 2;
    }

    private void maybeAnimateActiveIndicatorToProgress(float f) {
        if (!this.activeIndicatorEnabled || !this.initialized || !isAttachedToWindow()) {
            setActiveIndicatorProgress(f, f);
            return;
        }
        if (this.activeIndicatorAnimator != null) {
            this.activeIndicatorAnimator.cancel();
            this.activeIndicatorAnimator = null;
        }
        this.activeIndicatorAnimator = ValueAnimator.ofFloat(this.activeIndicatorProgress, f);
        this.activeIndicatorAnimator.addUpdateListener(new AnonymousClass2(f));
        this.activeIndicatorAnimator.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), com.google.android.material.R.attr.motionEasingEmphasizedInterpolator, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        this.activeIndicatorAnimator.setDuration(MotionUtils.resolveThemeDuration(getContext(), com.google.android.material.R.attr.motionDurationLong2, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
        this.activeIndicatorAnimator.start();
    }

    private void refreshChecked() {
        if (this.itemData != null) {
            setChecked(this.itemData.isChecked());
        }
    }

    private void refreshItemBackground() {
        RippleDrawable rippleDrawable = null;
        Drawable drawable = this.itemBackground;
        boolean z = true;
        if (this.itemRippleColor != null) {
            Drawable activeIndicatorDrawable = getActiveIndicatorDrawable();
            if (this.activeIndicatorEnabled && activeIndicatorDrawable != null) {
                z = false;
                RippleDrawable rippleDrawable2 = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.itemRippleColor), null, activeIndicatorDrawable);
                FocusRingDrawable.layer(getContext(), rippleDrawable2, activeIndicatorDrawable instanceof MaterialShapeDrawable ? (MaterialShapeDrawable) activeIndicatorDrawable : null);
                rippleDrawable = rippleDrawable2;
            } else if (drawable == null) {
                drawable = createItemBackgroundCompat(this.itemRippleColor);
            }
        }
        this.iconContainer.setPadding(0, 0, 0, 0);
        this.iconContainer.setForeground(rippleDrawable);
        setBackground(drawable);
        if (Build.VERSION.SDK_INT >= 26) {
            setDefaultFocusHighlightEnabled(z);
        }
    }

    private void setActiveIndicatorProgress(float f, float f2) {
        this.activeIndicatorTransform.updateForProgress(f, f2, this.activeIndicatorView);
        this.activeIndicatorProgress = f;
    }

    private void setExpandedLabelGroupMargins() {
        int i = this.icon.getLayoutParams().width > 0 ? this.iconLabelHorizontalSpacing : 0;
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.expandedLabelGroup.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.rightMargin = getLayoutDirection() == 1 ? i : 0;
            layoutParams.leftMargin = getLayoutDirection() != 1 ? i : 0;
        }
    }

    private void setLabelPivots(TextView textView) {
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
    }

    private void setLayoutConfigurationIconAndLabel(View view, View view2, float f, float f2) {
        setViewMarginAndGravity(this.contentContainer, this.itemIconGravity == 0 ? (int) (this.itemPaddingTop + f2) : 0, 0, this.itemGravity);
        setViewMarginAndGravity(this.innerContentContainer, this.itemIconGravity == 0 ? 0 : this.itemActiveIndicatorExpandedPadding.top, this.itemIconGravity == 0 ? 0 : this.itemActiveIndicatorExpandedPadding.bottom, this.itemIconGravity == 0 ? 17 : NavigationBarView.ITEM_GRAVITY_START_CENTER);
        updateViewPaddingBottom(this.labelGroup, this.itemPaddingBottom);
        this.currentLabelGroup.setVisibility(0);
        setViewScaleValues(view, 1.0f, 1.0f, 0);
        setViewScaleValues(view2, f, f, 4);
    }

    private void setLayoutConfigurationIconOnly() {
        setViewMarginAndGravity(this.contentContainer, this.itemPaddingTop, this.itemPaddingTop, this.itemIconGravity == 0 ? 17 : this.itemGravity);
        setViewMarginAndGravity(this.innerContentContainer, 0, 0, 17);
        updateViewPaddingBottom(this.labelGroup, 0);
        this.currentLabelGroup.setVisibility(8);
    }

    private void setTextAppearanceForLabel(TextView textView, int i) {
        if (this.scaleLabelSizeWithFont) {
            TextViewCompat.setTextAppearance(textView, i);
        } else {
            setTextAppearanceWithoutFontScaling(textView, i);
        }
    }

    private static void setTextAppearanceWithoutFontScaling(TextView textView, int i) {
        TextViewCompat.setTextAppearance(textView, i);
        int unscaledTextSize = MaterialResources.getUnscaledTextSize(textView.getContext(), i, 0);
        if (unscaledTextSize != 0) {
            textView.setTextSize(0, unscaledTextSize);
        }
    }

    private static void setViewMarginAndGravity(View view, int i, int i2, int i3) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i;
        layoutParams.bottomMargin = i2;
        layoutParams.gravity = i3;
        view.setLayoutParams(layoutParams);
    }

    private static void setViewScaleValues(View view, float f, float f2, int i) {
        view.setScaleX(f);
        view.setScaleY(f2);
        view.setVisibility(i);
    }

    private void tryAttachBadgeToAnchor(View view) {
        if (hasBadge() && view != null) {
            setClipChildren(false);
            setClipToPadding(false);
            BadgeUtils.attachBadgeDrawable(this.badgeDrawable, view);
        }
    }

    private void tryRemoveBadgeFromAnchor(View view) {
        if (hasBadge()) {
            if (view != null) {
                setClipChildren(true);
                setClipToPadding(true);
                BadgeUtils.detachBadgeDrawable(this.badgeDrawable, view);
            }
            this.badgeDrawable = null;
        }
    }

    private void tryUpdateBadgeBounds(View view) {
        if (hasBadge()) {
            BadgeUtils.setBadgeDrawableBounds(this.badgeDrawable, view, null);
        }
    }

    private void updateActiveIndicatorTransform() {
        if (isActiveIndicatorResizeableAndUnlabeled()) {
            this.activeIndicatorTransform = ACTIVE_INDICATOR_UNLABELED_TRANSFORM;
        } else {
            this.activeIndicatorTransform = ACTIVE_INDICATOR_LABELED_TRANSFORM;
        }
    }

    private void updateActiveLabelBoldness() {
        this.largeLabel.setTypeface(this.largeLabel.getTypeface(), this.boldText ? 1 : 0);
        this.expandedLargeLabel.setTypeface(this.expandedLargeLabel.getTypeface(), this.boldText ? 1 : 0);
    }

    private void updateActiveLabelTextAppearance(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        setTextAppearanceForLabel(textView, i);
        calculateTextScaleFactors();
        textView.setMinimumHeight(MaterialResources.getUnscaledLineHeight(textView.getContext(), i, 0));
        if (this.textColor != null) {
            textView.setTextColor(this.textColor);
        }
        updateActiveLabelBoldness();
    }

    private void updateInactiveLabelTextAppearance(TextView textView, int i) {
        if (textView == null) {
            return;
        }
        setTextAppearanceForLabel(textView, i);
        calculateTextScaleFactors();
        textView.setMinimumHeight(MaterialResources.getUnscaledLineHeight(textView.getContext(), i, 0));
        if (this.textColor != null) {
            textView.setTextColor(this.textColor);
        }
    }

    private void updateItemIconGravity() {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        this.badgeFixedEdge = 0;
        int i6 = 0;
        int i7 = 8;
        this.currentLabelGroup = this.labelGroup;
        if (this.itemIconGravity == 1) {
            if (this.expandedLabelGroup.getParent() == null) {
                addDefaultExpandedLabelGroupViews();
            }
            i = this.itemActiveIndicatorExpandedPadding.left;
            i2 = this.itemActiveIndicatorExpandedPadding.right;
            i3 = this.itemActiveIndicatorExpandedPadding.top;
            i4 = this.itemActiveIndicatorExpandedPadding.bottom;
            this.badgeFixedEdge = 1;
            i5 = this.activeIndicatorExpandedMarginHorizontal;
            i6 = 8;
            i7 = 0;
            this.currentLabelGroup = this.expandedLabelGroup;
        }
        this.labelGroup.setVisibility(i6);
        this.expandedLabelGroup.setVisibility(i7);
        ((FrameLayout.LayoutParams) this.contentContainer.getLayoutParams()).gravity = this.itemGravity;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.innerContentContainer.getLayoutParams();
        layoutParams.leftMargin = i;
        layoutParams.rightMargin = i2;
        layoutParams.topMargin = i3;
        layoutParams.bottomMargin = i4;
        setPadding(i5, 0, i5, 0);
        updateActiveIndicatorLayoutParams(getWidth());
    }

    private static void updateViewPaddingBottom(View view, int i) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i);
    }

    private void updateVisibility() {
        if (this.itemData != null) {
            setVisibility((!this.itemData.isVisible() || (!this.expanded && this.onlyShowWhenExpanded)) ? 8 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clear() {
        removeBadge();
        this.itemData = null;
        this.activeIndicatorProgress = 0.0f;
        this.initialized = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.activeIndicatorEnabled) {
            this.iconContainer.dispatchTouchEvent(motionEvent);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public Drawable getActiveIndicatorDrawable() {
        return this.activeIndicatorView.getBackground();
    }

    public BadgeDrawable getBadge() {
        return this.badgeDrawable;
    }

    public BaselineLayout getExpandedLabelGroup() {
        return this.expandedLabelGroup;
    }

    protected int getItemBackgroundResId() {
        return com.google.android.material.R.drawable.mtrl_navigation_bar_item_background;
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    protected int getItemDefaultMarginResId() {
        return com.google.android.material.R.dimen.mtrl_navigation_bar_item_default_margin;
    }

    protected abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.itemPosition;
    }

    public BaselineLayout getLabelGroup() {
        return this.labelGroup;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumHeight() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.contentContainer.getLayoutParams();
        return this.contentContainer.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    protected int getSuggestedMinimumWidth() {
        if (this.itemIconGravity == 1) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.innerContentContainer.getLayoutParams();
            return this.innerContentContainer.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.labelGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), layoutParams2.leftMargin + this.labelGroup.getMeasuredWidth() + layoutParams2.rightMargin);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void initialize(MenuItemImpl menuItemImpl, int i) {
        this.itemData = menuItemImpl;
        setCheckable(menuItemImpl.isCheckable());
        setChecked(menuItemImpl.isChecked());
        setEnabled(menuItemImpl.isEnabled());
        setIcon(menuItemImpl.getIcon());
        setTitle(menuItemImpl.getTitle());
        setId(menuItemImpl.getItemId());
        if (!TextUtils.isEmpty(menuItemImpl.getContentDescription())) {
            setContentDescription(menuItemImpl.getContentDescription());
        }
        CharSequence tooltipText = !TextUtils.isEmpty(menuItemImpl.getTooltipText()) ? menuItemImpl.getTooltipText() : menuItemImpl.getTitle();
        int i2 = Build.VERSION.SDK_INT;
        TooltipCompat.setTooltipText(this, tooltipText);
        updateVisibility();
        this.initialized = true;
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuItemView
    public boolean isExpanded() {
        return this.expanded;
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuItemView
    public boolean isOnlyVisibleWhenExpanded() {
        return this.onlyShowWhenExpanded;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-material-navigation-NavigationBarItemView, reason: not valid java name */
    public /* synthetic */ void m389xe6e25373(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        if (this.icon.getVisibility() == 0) {
            tryUpdateBadgeBounds(this.icon);
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.innerContentContainer.getLayoutParams();
        int i9 = (i3 - i) + layoutParams.rightMargin + layoutParams.leftMargin;
        int i10 = (i4 - i2) + layoutParams.topMargin + layoutParams.bottomMargin;
        if (this.itemIconGravity == 1 && this.activeIndicatorExpandedDesiredWidth == -2) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.activeIndicatorView.getLayoutParams();
            boolean z = false;
            if (this.activeIndicatorExpandedDesiredWidth == -2 && this.activeIndicatorView.getMeasuredWidth() != i9) {
                layoutParams2.width = Math.max(i9, Math.min(this.activeIndicatorDesiredWidth, getMeasuredWidth() - (this.activeIndicatorMarginHorizontal * 2)));
                z = true;
            }
            if (this.activeIndicatorView.getMeasuredHeight() < i10) {
                layoutParams2.height = i10;
                z = true;
            }
            if (z) {
                this.activeIndicatorView.setLayoutParams(layoutParams2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i + 1);
        if (this.itemData != null && this.itemData.isCheckable() && this.itemData.isChecked()) {
            mergeDrawableStates(onCreateDrawableState, CHECKED_STATE_SET);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        if (this.badgeDrawable != null && this.badgeDrawable.isVisible()) {
            CharSequence title = this.itemData.getTitle();
            if (!TextUtils.isEmpty(this.itemData.getContentDescription())) {
                title = this.itemData.getContentDescription();
            }
            accessibilityNodeInfo.setContentDescription(((Object) title) + ", " + ((Object) this.badgeDrawable.getContentDescription()));
        }
        AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
        wrap.setCollectionItemInfo(AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(0, 1, getItemVisiblePosition(), 1, false, isSelected()));
        if (isSelected()) {
            wrap.setClickable(false);
            wrap.removeAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK);
        }
        wrap.setRoleDescription(getResources().getString(com.google.android.material.R.string.item_view_role_description));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        post(new AnonymousClass1(i));
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean prefersCondensedTitle() {
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeBadge() {
        tryRemoveBadgeFromAnchor(this.icon);
    }

    public void setActiveIndicatorDrawable(Drawable drawable) {
        this.activeIndicatorView.setBackground(drawable);
        refreshItemBackground();
    }

    public void setActiveIndicatorEnabled(boolean z) {
        this.activeIndicatorEnabled = z;
        refreshItemBackground();
        this.activeIndicatorView.setVisibility(z ? 0 : 8);
        requestLayout();
    }

    public void setActiveIndicatorExpandedHeight(int i) {
        this.activeIndicatorExpandedDesiredHeight = i;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorExpandedMarginHorizontal(int i) {
        this.activeIndicatorExpandedMarginHorizontal = i;
        if (this.itemIconGravity == 1) {
            setPadding(i, 0, i, 0);
        }
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorExpandedPadding(Rect rect) {
        this.itemActiveIndicatorExpandedPadding = rect;
    }

    public void setActiveIndicatorExpandedWidth(int i) {
        this.activeIndicatorExpandedDesiredWidth = i;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorHeight(int i) {
        this.activeIndicatorDesiredHeight = i;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorLabelPadding(int i) {
        if (this.activeIndicatorLabelPadding != i) {
            this.activeIndicatorLabelPadding = i;
            ((LinearLayout.LayoutParams) this.labelGroup.getLayoutParams()).topMargin = i;
            if (this.expandedLabelGroup.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.expandedLabelGroup.getLayoutParams();
                layoutParams.rightMargin = getLayoutDirection() == 1 ? i : 0;
                layoutParams.leftMargin = getLayoutDirection() != 1 ? i : 0;
                requestLayout();
            }
        }
    }

    public void setActiveIndicatorMarginHorizontal(int i) {
        this.activeIndicatorMarginHorizontal = i;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    public void setActiveIndicatorResizeable(boolean z) {
        this.activeIndicatorResizeable = z;
    }

    public void setActiveIndicatorWidth(int i) {
        this.activeIndicatorDesiredWidth = i;
        updateActiveIndicatorLayoutParams(getWidth());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setBadge(BadgeDrawable badgeDrawable) {
        if (this.badgeDrawable == badgeDrawable) {
            return;
        }
        if (hasBadge() && this.icon != null) {
            Log.w("NavigationBar", "Multiple badges shouldn't be attached to one item.");
            tryRemoveBadgeFromAnchor(this.icon);
        }
        this.badgeDrawable = badgeDrawable;
        badgeDrawable.setBadgeFixedEdge(this.badgeFixedEdge);
        if (this.icon != null) {
            tryAttachBadgeToAnchor(this.icon);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setCheckable(boolean z) {
        refreshDrawableState();
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setChecked(boolean z) {
        setLabelPivots(this.largeLabel);
        setLabelPivots(this.smallLabel);
        setLabelPivots(this.expandedLargeLabel);
        setLabelPivots(this.expandedSmallLabel);
        maybeAnimateActiveIndicatorToProgress(z ? 1.0f : 0.0f);
        TextView textView = this.largeLabel;
        TextView textView2 = this.smallLabel;
        float f = this.shiftAmountY;
        float f2 = this.scaleUpFactor;
        float f3 = this.scaleDownFactor;
        if (this.itemIconGravity == 1) {
            textView = this.expandedLargeLabel;
            textView2 = this.expandedSmallLabel;
            f = this.expandedLabelShiftAmountY;
            f2 = this.expandedLabelScaleUpFactor;
            f3 = this.expandedLabelScaleDownFactor;
        }
        switch (this.labelVisibilityMode) {
            case -1:
                if (!this.isShifting) {
                    if (!z) {
                        setLayoutConfigurationIconAndLabel(textView2, textView, f3, 0.0f);
                        break;
                    } else {
                        setLayoutConfigurationIconAndLabel(textView, textView2, f2, f);
                        break;
                    }
                } else if (!z) {
                    setLayoutConfigurationIconOnly();
                    break;
                } else {
                    setLayoutConfigurationIconAndLabel(textView, textView2, f2, 0.0f);
                    break;
                }
            case 0:
                if (!z) {
                    setLayoutConfigurationIconOnly();
                    break;
                } else {
                    setLayoutConfigurationIconAndLabel(textView, textView2, f2, 0.0f);
                    break;
                }
            case 1:
                if (!z) {
                    setLayoutConfigurationIconAndLabel(textView2, textView, f3, 0.0f);
                    break;
                } else {
                    setLayoutConfigurationIconAndLabel(textView, textView2, f2, f);
                    break;
                }
            case 2:
                setLayoutConfigurationIconOnly();
                break;
        }
        refreshDrawableState();
        setSelected(z);
    }

    @Override // android.view.View, androidx.appcompat.view.menu.MenuView.ItemView
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        this.smallLabel.setEnabled(z);
        this.largeLabel.setEnabled(z);
        this.expandedSmallLabel.setEnabled(z);
        this.expandedLargeLabel.setEnabled(z);
        this.icon.setEnabled(z);
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuItemView
    public void setExpanded(boolean z) {
        this.expanded = z;
        updateVisibility();
    }

    public void setHorizontalTextAppearanceActive(int i) {
        this.horizontalTextAppearanceActive = i;
        updateActiveLabelTextAppearance(this.expandedLargeLabel, this.horizontalTextAppearanceActive != 0 ? this.horizontalTextAppearanceActive : this.textAppearanceActive);
    }

    public void setHorizontalTextAppearanceInactive(int i) {
        this.horizontalTextAppearanceInactive = i;
        updateInactiveLabelTextAppearance(this.expandedSmallLabel, this.horizontalTextAppearanceInactive != 0 ? this.horizontalTextAppearanceInactive : this.textAppearanceInactive);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setIcon(Drawable drawable) {
        if (drawable == this.originalIconDrawable) {
            return;
        }
        this.originalIconDrawable = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            drawable = DrawableCompat.wrap(constantState == null ? drawable : constantState.newDrawable()).mutate();
            this.wrappedIconDrawable = drawable;
            if (this.iconTint != null) {
                this.wrappedIconDrawable.setTintList(this.iconTint);
            }
        }
        this.icon.setImageDrawable(drawable);
    }

    public void setIconLabelHorizontalSpacing(int i) {
        if (this.iconLabelHorizontalSpacing != i) {
            this.iconLabelHorizontalSpacing = i;
            setExpandedLabelGroupMargins();
            requestLayout();
        }
    }

    public void setIconSize(int i) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.icon.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        this.icon.setLayoutParams(layoutParams);
        setExpandedLabelGroupMargins();
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.iconTint = colorStateList;
        if (this.itemData == null || this.wrappedIconDrawable == null) {
            return;
        }
        this.wrappedIconDrawable.setTintList(this.iconTint);
        this.wrappedIconDrawable.invalidateSelf();
    }

    public void setItemBackground(int i) {
        setItemBackground(i == 0 ? null : getContext().getDrawable(i));
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        this.itemBackground = drawable;
        refreshItemBackground();
    }

    public void setItemGravity(int i) {
        this.itemGravity = i;
        requestLayout();
    }

    public void setItemIconGravity(int i) {
        if (this.itemIconGravity != i) {
            this.itemIconGravity = i;
            updateItemIconGravity();
            refreshItemBackground();
        }
    }

    public void setItemPaddingBottom(int i) {
        if (this.itemPaddingBottom != i) {
            this.itemPaddingBottom = i;
            refreshChecked();
        }
    }

    public void setItemPaddingTop(int i) {
        if (this.itemPaddingTop != i) {
            this.itemPaddingTop = i;
            refreshChecked();
        }
    }

    public void setItemPosition(int i) {
        this.itemPosition = i;
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.itemRippleColor = colorStateList;
        refreshItemBackground();
    }

    public void setLabelFontScalingEnabled(boolean z) {
        this.scaleLabelSizeWithFont = z;
        setTextAppearanceActive(this.textAppearanceActive);
        setTextAppearanceInactive(this.textAppearanceInactive);
        setHorizontalTextAppearanceActive(this.horizontalTextAppearanceActive);
        setHorizontalTextAppearanceInactive(this.horizontalTextAppearanceInactive);
    }

    public void setLabelMaxLines(int i) {
        this.smallLabel.setMaxLines(i);
        this.largeLabel.setMaxLines(i);
        this.expandedSmallLabel.setMaxLines(i);
        this.expandedLargeLabel.setMaxLines(i);
        if (Build.VERSION.SDK_INT > 34) {
            this.smallLabel.setGravity(17);
            this.largeLabel.setGravity(17);
        } else if (i > 1) {
            this.smallLabel.setEllipsize(null);
            this.largeLabel.setEllipsize(null);
            this.smallLabel.setGravity(17);
            this.largeLabel.setGravity(17);
        } else {
            this.smallLabel.setGravity(16);
            this.largeLabel.setGravity(16);
        }
        requestLayout();
    }

    public void setLabelVisibilityMode(int i) {
        if (this.labelVisibilityMode != i) {
            this.labelVisibilityMode = i;
            updateActiveIndicatorTransform();
            updateActiveIndicatorLayoutParams(getWidth());
            refreshChecked();
        }
    }

    public void setMeasureBottomPaddingFromLabelBaseline(boolean z) {
        this.measurePaddingFromBaseline = z;
        this.labelGroup.setMeasurePaddingFromBaseline(z);
        this.smallLabel.setIncludeFontPadding(z);
        this.largeLabel.setIncludeFontPadding(z);
        this.expandedLabelGroup.setMeasurePaddingFromBaseline(z);
        this.expandedSmallLabel.setIncludeFontPadding(z);
        this.expandedLargeLabel.setIncludeFontPadding(z);
        requestLayout();
    }

    @Override // com.google.android.material.navigation.NavigationBarMenuItemView
    public void setOnlyShowWhenExpanded(boolean z) {
        this.onlyShowWhenExpanded = z;
        updateVisibility();
    }

    public void setShifting(boolean z) {
        if (this.isShifting != z) {
            this.isShifting = z;
            refreshChecked();
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setShortcut(boolean z, char c) {
    }

    public void setTextAppearanceActive(int i) {
        this.textAppearanceActive = i;
        updateActiveLabelTextAppearance(this.largeLabel, this.textAppearanceActive);
    }

    public void setTextAppearanceActiveBoldEnabled(boolean z) {
        this.boldText = z;
        setTextAppearanceActive(this.textAppearanceActive);
        setHorizontalTextAppearanceActive(this.horizontalTextAppearanceActive);
        updateActiveLabelBoldness();
    }

    public void setTextAppearanceInactive(int i) {
        this.textAppearanceInactive = i;
        updateInactiveLabelTextAppearance(this.smallLabel, this.textAppearanceInactive);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.textColor = colorStateList;
        if (colorStateList != null) {
            this.smallLabel.setTextColor(colorStateList);
            this.largeLabel.setTextColor(colorStateList);
            this.expandedSmallLabel.setTextColor(colorStateList);
            this.expandedLargeLabel.setTextColor(colorStateList);
        }
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public void setTitle(CharSequence charSequence) {
        this.smallLabel.setText(charSequence);
        this.largeLabel.setText(charSequence);
        this.expandedSmallLabel.setText(charSequence);
        this.expandedLargeLabel.setText(charSequence);
        if (this.itemData == null || TextUtils.isEmpty(this.itemData.getContentDescription())) {
            setContentDescription(charSequence);
        }
        CharSequence tooltipText = (this.itemData == null || TextUtils.isEmpty(this.itemData.getTooltipText())) ? charSequence : this.itemData.getTooltipText();
        int i = Build.VERSION.SDK_INT;
        TooltipCompat.setTooltipText(this, tooltipText);
    }

    @Override // androidx.appcompat.view.menu.MenuView.ItemView
    public boolean showsIcon() {
        return true;
    }

    public void updateActiveIndicatorLayoutParams(int i) {
        if (i > 0 || getVisibility() != 0) {
            int min = Math.min(this.activeIndicatorDesiredWidth, i - (this.activeIndicatorMarginHorizontal * 2));
            int i2 = this.activeIndicatorDesiredHeight;
            if (this.itemIconGravity == 1) {
                int i3 = i - (this.activeIndicatorExpandedMarginHorizontal * 2);
                min = this.activeIndicatorExpandedDesiredWidth == -1 ? i3 : this.activeIndicatorExpandedDesiredWidth == -2 ? this.contentContainer.getMeasuredWidth() : Math.min(this.activeIndicatorExpandedDesiredWidth, i3);
                i2 = Math.max(this.activeIndicatorExpandedDesiredHeight, this.innerContentContainer.getMeasuredHeight());
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.activeIndicatorView.getLayoutParams();
            layoutParams.height = isActiveIndicatorResizeableAndUnlabeled() ? min : i2;
            layoutParams.width = Math.max(0, min);
            this.activeIndicatorView.setLayoutParams(layoutParams);
        }
    }
}
