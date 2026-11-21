package com.google.android.material.navigationrail;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import androidx.transition.ChangeBounds;
import androidx.transition.Fade;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.navigation.NavigationBarDividerView;
import com.google.android.material.navigation.NavigationBarItemView;
import com.google.android.material.navigation.NavigationBarMenuView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.resources.MaterialResources;

/* loaded from: classes.dex */
public class NavigationRailView extends NavigationBarView {
    static final int COLLAPSED_MAX_ITEM_COUNT = 7;
    private static final TimeInterpolator CUBIC_BEZIER_INTERPOLATOR = new PathInterpolator(0.38f, 1.21f, 0.22f, 1.0f);
    private static final int DEFAULT_HEADER_GRAVITY = 49;
    static final int DEFAULT_MENU_GRAVITY = 49;
    private static final int EXPAND_DURATION = 500;
    private static final int FADE_DURATION = 100;
    static final int NO_ITEM_MINIMUM_HEIGHT = -1;
    private int collapsedIconGravity;
    private int collapsedItemGravity;
    private int collapsedItemMinHeight;
    private int collapsedItemSpacing;
    private NavigationRailFrameLayout contentContainer;
    private final int contentMarginTop;
    private boolean expanded;
    private int expandedIconGravity;
    private int expandedItemGravity;
    private int expandedItemMinHeight;
    private int expandedItemSpacing;
    private final int headerMarginBottom;
    private View headerView;
    private final int maxExpandedWidth;
    private final int minExpandedWidth;
    private Boolean paddingBottomSystemWindowInsets;
    private Boolean paddingStartSystemWindowInsets;
    private Boolean paddingTopSystemWindowInsets;
    private final boolean scrollingEnabled;
    private boolean submenuDividersEnabled;

    /* renamed from: com.google.android.material.navigationrail.NavigationRailView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements ViewUtils.OnApplyWindowInsetsListener {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.displayCutout());
            if (NavigationRailView.access$100(NavigationRailView.this, NavigationRailView.access$000(NavigationRailView.this))) {
                relativePadding.top += insets.top;
            }
            if (NavigationRailView.access$100(NavigationRailView.this, NavigationRailView.access$200(NavigationRailView.this))) {
                relativePadding.bottom += insets.bottom;
            }
            if (NavigationRailView.access$100(NavigationRailView.this, NavigationRailView.access$300(NavigationRailView.this))) {
                if (ViewUtils.isLayoutRtl(view)) {
                    relativePadding.start += Math.max(insets.right, insets2.right);
                } else {
                    relativePadding.start += Math.max(insets.left, insets2.left);
                }
            }
            relativePadding.applyToView(view);
            return windowInsetsCompat;
        }
    }

    public NavigationRailView(Context context) {
        this(context, null);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.navigationRailStyle);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.Widget_MaterialComponents_NavigationRailView);
    }

    public NavigationRailView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.paddingTopSystemWindowInsets = null;
        this.paddingBottomSystemWindowInsets = null;
        this.paddingStartSystemWindowInsets = null;
        this.expanded = false;
        this.collapsedItemMinHeight = -1;
        this.collapsedIconGravity = 0;
        this.collapsedItemGravity = 49;
        Context context2 = getContext();
        this.expandedItemSpacing = getContext().getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_expanded_item_spacing);
        this.expandedItemGravity = NavigationBarView.ITEM_GRAVITY_START_CENTER;
        this.expandedIconGravity = 1;
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.NavigationRailView, i, i2, new int[0]);
        this.contentMarginTop = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_contentMarginTop, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin));
        this.headerMarginBottom = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_headerMarginBottom, getResources().getDimensionPixelSize(R.dimen.mtrl_navigation_rail_margin));
        this.scrollingEnabled = obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_scrollingEnabled, false);
        setSubmenuDividersEnabled(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_submenuDividersEnabled, false));
        addContentContainer();
        int resourceId = obtainTintedStyledAttributes.getResourceId(R.styleable.NavigationRailView_headerLayout, 0);
        if (resourceId != 0) {
            addHeaderView(resourceId);
        }
        setMenuGravity(obtainTintedStyledAttributes.getInt(R.styleable.NavigationRailView_menuGravity, 49));
        int dimensionPixelSize = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_itemMinHeight, -1);
        int dimensionPixelSize2 = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_itemMinHeight, -1);
        dimensionPixelSize = obtainTintedStyledAttributes.hasValue(R.styleable.NavigationRailView_collapsedItemMinHeight) ? obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_collapsedItemMinHeight, -1) : dimensionPixelSize;
        dimensionPixelSize2 = obtainTintedStyledAttributes.hasValue(R.styleable.NavigationRailView_expandedItemMinHeight) ? obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_expandedItemMinHeight, -1) : dimensionPixelSize2;
        setCollapsedItemMinimumHeight(dimensionPixelSize);
        setExpandedItemMinimumHeight(dimensionPixelSize2);
        this.minExpandedWidth = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_expandedMinWidth, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_min_expanded_width));
        this.maxExpandedWidth = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_expandedMaxWidth, context2.getResources().getDimensionPixelSize(R.dimen.m3_navigation_rail_max_expanded_width));
        if (obtainTintedStyledAttributes.hasValue(R.styleable.NavigationRailView_paddingTopSystemWindowInsets)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_paddingTopSystemWindowInsets, false));
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_paddingBottomSystemWindowInsets, false));
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.NavigationRailView_paddingStartSystemWindowInsets)) {
            this.paddingStartSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_paddingStartSystemWindowInsets, false));
        }
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_top_with_large_font);
        int dimensionPixelOffset2 = getResources().getDimensionPixelOffset(R.dimen.m3_navigation_rail_item_padding_bottom_with_large_font);
        float lerp = AnimationUtils.lerp(0.0f, 1.0f, 0.3f, 1.0f, MaterialResources.getFontScale(context2) - 1.0f);
        float lerp2 = AnimationUtils.lerp(getItemPaddingTop(), dimensionPixelOffset, lerp);
        float lerp3 = AnimationUtils.lerp(getItemPaddingBottom(), dimensionPixelOffset2, lerp);
        setItemPaddingTop(Math.round(lerp2));
        setItemPaddingBottom(Math.round(lerp3));
        setCollapsedItemSpacing(obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.NavigationRailView_itemSpacing, 0));
        setExpanded(obtainTintedStyledAttributes.getBoolean(R.styleable.NavigationRailView_expanded, false));
        obtainTintedStyledAttributes.recycle();
        applyWindowInsets();
    }

    static /* synthetic */ Boolean access$000(NavigationRailView navigationRailView) {
        return navigationRailView.paddingTopSystemWindowInsets;
    }

    static /* synthetic */ boolean access$100(NavigationRailView navigationRailView, Boolean bool) {
        return navigationRailView.shouldApplyWindowInsetPadding(bool);
    }

    static /* synthetic */ Boolean access$200(NavigationRailView navigationRailView) {
        return navigationRailView.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ Boolean access$300(NavigationRailView navigationRailView) {
        return navigationRailView.paddingStartSystemWindowInsets;
    }

    private void addContentContainer() {
        View view = (View) getMenuView();
        this.contentContainer = new NavigationRailFrameLayout(getContext());
        this.contentContainer.setPaddingTop(this.contentMarginTop);
        this.contentContainer.setScrollingEnabled(this.scrollingEnabled);
        this.contentContainer.setClipChildren(false);
        this.contentContainer.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        view.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        this.contentContainer.addView(view);
        if (!this.scrollingEnabled) {
            addView(this.contentContainer);
            return;
        }
        ScrollView scrollView = new ScrollView(getContext());
        scrollView.setVerticalScrollBarEnabled(false);
        scrollView.addView(this.contentContainer);
        scrollView.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(scrollView);
    }

    private void applyWindowInsets() {
        ViewUtils.doOnApplyWindowInsets(this, new AnonymousClass1());
    }

    private int getMaxChildWidth() {
        int childCount = getNavigationRailMenuView().getChildCount();
        int i = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getNavigationRailMenuView().getChildAt(i2);
            if (childAt.getVisibility() != 8 && !(childAt instanceof NavigationBarDividerView)) {
                i = Math.max(i, childAt.getMeasuredWidth());
            }
        }
        return i;
    }

    private NavigationRailMenuView getNavigationRailMenuView() {
        return (NavigationRailMenuView) getMenuView();
    }

    private int makeExpandedWidthMeasureSpec(int i, int i2) {
        int min = Math.min(this.minExpandedWidth, View.MeasureSpec.getSize(i));
        if (View.MeasureSpec.getMode(i) == 1073741824) {
            return i;
        }
        int max = Math.max(i2, min);
        if (this.headerView != null) {
            max = Math.max(max, this.headerView.getMeasuredWidth());
        }
        return View.MeasureSpec.makeMeasureSpec(Math.max(getSuggestedMinimumWidth(), Math.min(max, this.maxExpandedWidth)), BasicMeasure.EXACTLY);
    }

    private int makeMinWidthSpec(int i) {
        int suggestedMinimumWidth = getSuggestedMinimumWidth();
        if (View.MeasureSpec.getMode(i) == 1073741824 || suggestedMinimumWidth <= 0) {
            return i;
        }
        return View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i), suggestedMinimumWidth + getPaddingLeft() + getPaddingRight()), BasicMeasure.EXACTLY);
    }

    private void setExpanded(boolean z) {
        if (this.expanded == z) {
            return;
        }
        startTransitionAnimation();
        this.expanded = z;
        int i = this.collapsedIconGravity;
        int i2 = this.collapsedItemSpacing;
        int i3 = this.collapsedItemMinHeight;
        int i4 = this.collapsedItemGravity;
        if (z) {
            i = this.expandedIconGravity;
            i2 = this.expandedItemSpacing;
            i3 = this.expandedItemMinHeight;
            i4 = this.expandedItemGravity;
        }
        getNavigationRailMenuView().setItemGravity(i4);
        super.setItemIconGravity(i);
        getNavigationRailMenuView().setItemSpacing(i2);
        getNavigationRailMenuView().setItemMinimumHeight(i3);
        getNavigationRailMenuView().setExpanded(z);
    }

    private boolean shouldApplyWindowInsetPadding(Boolean bool) {
        return bool != null ? bool.booleanValue() : getFitsSystemWindows();
    }

    private void startTransitionAnimation() {
        if (isLaidOut()) {
            Transition interpolator = new ChangeBounds().setDuration(500L).setInterpolator(CUBIC_BEZIER_INTERPOLATOR);
            Transition duration = new Fade().setDuration(100L);
            Transition duration2 = new Fade().setDuration(100L);
            LabelMoveTransition labelMoveTransition = new LabelMoveTransition();
            Transition duration3 = new Fade().setDuration(100L);
            int childCount = getNavigationRailMenuView().getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = getNavigationRailMenuView().getChildAt(i);
                if (childAt instanceof NavigationBarItemView) {
                    interpolator.excludeTarget((View) ((NavigationBarItemView) childAt).getLabelGroup(), true);
                    interpolator.excludeTarget((View) ((NavigationBarItemView) childAt).getExpandedLabelGroup(), true);
                    if (this.expanded) {
                        duration2.addTarget(((NavigationBarItemView) childAt).getExpandedLabelGroup());
                        duration.addTarget(((NavigationBarItemView) childAt).getLabelGroup());
                    } else {
                        duration2.addTarget(((NavigationBarItemView) childAt).getLabelGroup());
                        duration.addTarget(((NavigationBarItemView) childAt).getExpandedLabelGroup());
                    }
                    labelMoveTransition.addTarget(((NavigationBarItemView) childAt).getExpandedLabelGroup());
                }
                duration3.addTarget(childAt);
            }
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.setOrdering(0);
            transitionSet.addTransition(interpolator).addTransition(duration).addTransition(labelMoveTransition);
            if (!this.expanded) {
                transitionSet.addTransition(duration3);
            }
            TransitionSet transitionSet2 = new TransitionSet();
            transitionSet2.setOrdering(0);
            transitionSet2.addTransition(duration2);
            if (this.expanded) {
                transitionSet2.addTransition(duration3);
            }
            TransitionSet transitionSet3 = new TransitionSet();
            transitionSet3.setOrdering(1);
            transitionSet3.addTransition(transitionSet2).addTransition(transitionSet);
            TransitionManager.beginDelayedTransition((ViewGroup) getParent(), transitionSet3);
        }
    }

    public void addHeaderView(int i) {
        addHeaderView(LayoutInflater.from(getContext()).inflate(i, (ViewGroup) this, false));
    }

    public void addHeaderView(View view) {
        removeHeaderView();
        this.headerView = view;
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 49;
        layoutParams.bottomMargin = this.headerMarginBottom;
        this.contentContainer.addView(view, 0, layoutParams);
    }

    public void collapse() {
        if (this.expanded) {
            setExpanded(false);
            announceForAccessibility(getResources().getString(R.string.nav_rail_collapsed_a11y_label));
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    protected /* bridge */ /* synthetic */ NavigationBarMenuView createNavigationBarMenuView(Context context) {
        return createNavigationBarMenuView(context);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    protected NavigationRailMenuView createNavigationBarMenuView(Context context) {
        return new NavigationRailMenuView(context);
    }

    public void expand() {
        if (this.expanded) {
            return;
        }
        setExpanded(true);
        announceForAccessibility(getResources().getString(R.string.nav_rail_expanded_a11y_label));
    }

    public int getCollapsedItemMinimumHeight() {
        return this.collapsedItemMinHeight;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getCollapsedMaxItemCount() {
        return 7;
    }

    public int getExpandedItemMinimumHeight() {
        return this.expandedItemMinHeight;
    }

    public View getHeaderView() {
        return this.headerView;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getItemGravity() {
        return getNavigationRailMenuView().getItemGravity();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getItemIconGravity() {
        return getNavigationRailMenuView().getItemIconGravity();
    }

    public int getItemMinimumHeight() {
        return getNavigationRailMenuView().getItemMinimumHeight();
    }

    public int getItemSpacing() {
        return getNavigationRailMenuView().getItemSpacing();
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public int getMaxItemCount() {
        return Integer.MAX_VALUE;
    }

    public int getMenuGravity() {
        return getNavigationRailMenuView().getMenuGravity();
    }

    public boolean getSubmenuDividersEnabled() {
        return this.submenuDividersEnabled;
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    protected boolean isSubMenuSupported() {
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMinWidthSpec = makeMinWidthSpec(i);
        if (this.expanded) {
            measureChild(getNavigationRailMenuView(), i, i2);
            if (this.headerView != null) {
                measureChild(this.headerView, i, i2);
            }
            makeMinWidthSpec = makeExpandedWidthMeasureSpec(i, getMaxChildWidth());
            if (getItemActiveIndicatorExpandedWidth() == -1) {
                getNavigationRailMenuView().updateActiveIndicator(View.MeasureSpec.getSize(makeMinWidthSpec));
            }
        }
        super.onMeasure(makeMinWidthSpec, i2);
        if (this.contentContainer.getMeasuredHeight() < getMeasuredHeight()) {
            measureChild(this.contentContainer, makeMinWidthSpec, View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), BasicMeasure.EXACTLY));
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void removeHeaderView() {
        if (this.headerView != null) {
            this.contentContainer.removeView(this.headerView);
            this.headerView = null;
        }
    }

    public void setCollapsedItemMinimumHeight(int i) {
        this.collapsedItemMinHeight = i;
        if (this.expanded) {
            return;
        }
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i);
    }

    public void setCollapsedItemSpacing(int i) {
        this.collapsedItemSpacing = i;
        if (this.expanded) {
            return;
        }
        getNavigationRailMenuView().setItemSpacing(i);
    }

    public void setExpandedItemMinimumHeight(int i) {
        this.expandedItemMinHeight = i;
        if (this.expanded) {
            ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i);
        }
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void setItemGravity(int i) {
        this.collapsedItemGravity = i;
        this.expandedItemGravity = i;
        super.setItemGravity(i);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public void setItemIconGravity(int i) {
        this.collapsedIconGravity = i;
        this.expandedIconGravity = i;
        super.setItemIconGravity(i);
    }

    public void setItemMinimumHeight(int i) {
        this.collapsedItemMinHeight = i;
        this.expandedItemMinHeight = i;
        ((NavigationRailMenuView) getMenuView()).setItemMinimumHeight(i);
    }

    public void setItemSpacing(int i) {
        this.collapsedItemSpacing = i;
        this.expandedItemSpacing = i;
        getNavigationRailMenuView().setItemSpacing(i);
    }

    public void setMenuGravity(int i) {
        getNavigationRailMenuView().setMenuGravity(i);
    }

    public void setSubmenuDividersEnabled(boolean z) {
        if (this.submenuDividersEnabled == z) {
            return;
        }
        this.submenuDividersEnabled = z;
        getNavigationRailMenuView().setSubmenuDividersEnabled(z);
    }

    @Override // com.google.android.material.navigation.NavigationBarView
    public boolean shouldAddMenuView() {
        return true;
    }
}
