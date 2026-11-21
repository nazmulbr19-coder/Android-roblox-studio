package com.google.android.material.search;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.focus.FocusRingDrawable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes.dex */
public class SearchBar extends Toolbar {
    private static final float ADAPTIVE_MAX_WIDTH_PERCENT_AFTER_BREAKPOINT = 0.5f;
    private static final int DEFAULT_SCROLL_FLAGS = 53;
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_SearchBar;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    static final int NO_RES_ID = -1;
    private final boolean adaptiveMaxWidthEnabled;
    private final int adaptiveMaxWidthParentBreakpoint;
    private final int backgroundColor;
    private MaterialShapeDrawable backgroundShape;
    private View centerView;
    private final boolean defaultMarginsEnabled;
    private final Drawable defaultNavigationIcon;
    private boolean defaultScrollFlagsEnabled;
    private int endSiblingViewId;
    private final boolean forceDefaultNavigationOnClickListener;
    private final boolean layoutInflated;
    private final AppBarLayout.LiftOnScrollProgressListener liftColorListener;
    private boolean liftOnScroll;
    private final ColorStateList liftOnScrollColor;
    private int maxWidth;
    private int menuResId;
    private ActionMenuView menuView;
    private ImageButton navIconButton;
    private Integer navigationIconTint;
    private Drawable originalNavigationIconBackground;
    private final TextView placeholderTextView;
    private final SearchBarAnimationHelper searchBarAnimationHelper;
    private int startSiblingViewId;
    private boolean textCentered;
    private final TextView textView;
    private final FrameLayout textViewContainer;
    private final boolean tintNavigationIcon;

    /* renamed from: com.google.android.material.search.SearchBar$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AppBarLayout.LiftOnScrollProgressListener {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.appbar.AppBarLayout.LiftOnScrollProgressListener
        public void onUpdate(float f, int i, float f2) {
            if (SearchBar.access$000(SearchBar.this) != null) {
                SearchBar.access$200(SearchBar.this).setFillColor(ColorStateList.valueOf(MaterialColors.layer(SearchBar.access$100(SearchBar.this), SearchBar.access$000(SearchBar.this).getDefaultColor(), f2)));
            }
        }
    }

    /* loaded from: classes.dex */
    public static abstract class OnLoadAnimationCallback {
        public void onAnimationEnd() {
        }

        public void onAnimationStart() {
        }
    }

    /* loaded from: classes.dex */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        String text;

        /* renamed from: com.google.android.material.search.SearchBar$SavedState$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
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

        public SavedState(Parcel parcel) {
            this(parcel, null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.text = parcel.readString();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeString(this.text);
        }
    }

    /* loaded from: classes.dex */
    public static class ScrollingViewBehavior extends AppBarLayout.ScrollingViewBehavior {
        private boolean initialized;

        public ScrollingViewBehavior() {
            this.initialized = false;
        }

        public ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.initialized = false;
        }

        private void setAppBarLayoutTransparent(AppBarLayout appBarLayout) {
            appBarLayout.setBackgroundColor(0);
            int i = Build.VERSION.SDK_INT;
            appBarLayout.setTargetElevation(0.0f);
        }

        @Override // com.google.android.material.appbar.AppBarLayout.ScrollingViewBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            boolean onDependentViewChanged = super.onDependentViewChanged(coordinatorLayout, view, view2);
            if (!this.initialized && (view2 instanceof AppBarLayout)) {
                this.initialized = true;
                AppBarLayout appBarLayout = (AppBarLayout) view2;
                appBarLayout.setTouchscreenBlocksFocus(false);
                setAppBarLayoutTransparent(appBarLayout);
            }
            return onDependentViewChanged;
        }

        @Override // com.google.android.material.appbar.HeaderScrollingViewBehavior
        protected boolean shouldHeaderOverlapScrollingChild() {
            return true;
        }
    }

    public SearchBar(Context context) {
        this(context, null);
    }

    public SearchBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialSearchBarStyle);
    }

    public SearchBar(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.menuResId = -1;
        this.liftColorListener = new AnonymousClass1();
        Context context2 = getContext();
        validateAttributes(attributeSet);
        this.adaptiveMaxWidthParentBreakpoint = getResources().getDimensionPixelSize(R.dimen.m3_searchbar_parent_width_breakpoint);
        this.defaultNavigationIcon = AppCompatResources.getDrawable(context2, getDefaultNavigationIconResource());
        this.searchBarAnimationHelper = new SearchBarAnimationHelper();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.SearchBar, i, DEF_STYLE_RES, new int[0]);
        ShapeAppearanceModel build = ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES).build();
        this.backgroundColor = obtainStyledAttributes.getColor(R.styleable.SearchBar_backgroundTint, 0);
        this.liftOnScrollColor = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.SearchBar_liftOnScrollColor);
        float dimension = obtainStyledAttributes.getDimension(R.styleable.SearchBar_elevation, 0.0f);
        this.defaultMarginsEnabled = obtainStyledAttributes.getBoolean(R.styleable.SearchBar_defaultMarginsEnabled, true);
        this.defaultScrollFlagsEnabled = obtainStyledAttributes.getBoolean(R.styleable.SearchBar_defaultScrollFlagsEnabled, true);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.SearchBar_hideNavigationIcon, false);
        this.forceDefaultNavigationOnClickListener = obtainStyledAttributes.getBoolean(R.styleable.SearchBar_forceDefaultNavigationOnClickListener, false);
        this.tintNavigationIcon = obtainStyledAttributes.getBoolean(R.styleable.SearchBar_tintNavigationIcon, true);
        if (obtainStyledAttributes.hasValue(R.styleable.SearchBar_navigationIconTint)) {
            this.navigationIconTint = Integer.valueOf(obtainStyledAttributes.getColor(R.styleable.SearchBar_navigationIconTint, -1));
        }
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.SearchBar_android_textAppearance, -1);
        String string = obtainStyledAttributes.getString(R.styleable.SearchBar_android_text);
        String string2 = obtainStyledAttributes.getString(R.styleable.SearchBar_android_hint);
        float dimension2 = obtainStyledAttributes.getDimension(R.styleable.SearchBar_strokeWidth, -1.0f);
        int color = obtainStyledAttributes.getColor(R.styleable.SearchBar_strokeColor, 0);
        this.textCentered = obtainStyledAttributes.getBoolean(R.styleable.SearchBar_textCentered, false);
        this.liftOnScroll = obtainStyledAttributes.getBoolean(R.styleable.SearchBar_liftOnScroll, false);
        this.maxWidth = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SearchBar_android_maxWidth, -1);
        this.adaptiveMaxWidthEnabled = obtainStyledAttributes.getBoolean(R.styleable.SearchBar_adaptiveMaxWidthEnabled, false);
        this.startSiblingViewId = obtainStyledAttributes.getResourceId(R.styleable.SearchBar_startSiblingViewId, -1);
        this.endSiblingViewId = obtainStyledAttributes.getResourceId(R.styleable.SearchBar_endSiblingViewId, -1);
        obtainStyledAttributes.recycle();
        if (!z) {
            initNavigationIcon();
        }
        setClickable(true);
        setFocusable(true);
        LayoutInflater.from(context2).inflate(R.layout.mtrl_search_bar, this);
        this.layoutInflated = true;
        this.textView = (TextView) findViewById(R.id.open_search_bar_text_view);
        this.placeholderTextView = (TextView) findViewById(R.id.open_search_bar_placeholder_text_view);
        this.textViewContainer = (FrameLayout) findViewById(R.id.open_search_bar_text_view_container);
        setElevation(dimension);
        initTextView(resourceId, string, string2);
        initBackground(build, this.backgroundColor, dimension, dimension2, color);
    }

    static /* synthetic */ ColorStateList access$000(SearchBar searchBar) {
        return searchBar.liftOnScrollColor;
    }

    static /* synthetic */ int access$100(SearchBar searchBar) {
        return searchBar.backgroundColor;
    }

    static /* synthetic */ MaterialShapeDrawable access$200(SearchBar searchBar) {
        return searchBar.backgroundShape;
    }

    private void addLiftOnScrollProgressListener() {
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists == null || this.liftOnScrollColor == null) {
            return;
        }
        appBarLayoutParentIfExists.addLiftOnScrollProgressListener(this.liftColorListener);
    }

    private int defaultIfZero(int i, int i2) {
        return i == 0 ? i2 : i;
    }

    private ActionMenuView findOrGetMenuView() {
        if (this.menuView == null) {
            this.menuView = ToolbarUtils.getActionMenuView(this);
        }
        return this.menuView;
    }

    private ImageButton findOrGetNavView() {
        if (this.navIconButton == null) {
            this.navIconButton = ToolbarUtils.getNavigationIconButton(this);
        }
        return this.navIconButton;
    }

    private void initBackground(ShapeAppearanceModel shapeAppearanceModel, int i, float f, float f2, int i2) {
        this.backgroundShape = new MaterialShapeDrawable(shapeAppearanceModel);
        this.backgroundShape.initializeElevationOverlay(getContext());
        this.backgroundShape.setElevation(f);
        if (f2 >= 0.0f) {
            this.backgroundShape.setStroke(f2, i2);
        }
        int color = MaterialColors.getColor(this, androidx.appcompat.R.attr.colorControlHighlight);
        this.backgroundShape.setFillColor(ColorStateList.valueOf(i));
        RippleDrawable rippleDrawable = new RippleDrawable(ColorStateList.valueOf(color), this.backgroundShape, this.backgroundShape);
        FocusRingDrawable.layer(getContext(), rippleDrawable, this.backgroundShape);
        setBackground(rippleDrawable);
    }

    private void initNavigationIcon() {
        setNavigationIcon(getNavigationIcon() == null ? this.defaultNavigationIcon : getNavigationIcon());
        setNavigationIconDecorative(true);
    }

    private void initTextView(int i, String str, String str2) {
        if (i != -1) {
            TextViewCompat.setTextAppearance(this.textView, i);
            TextViewCompat.setTextAppearance(this.placeholderTextView, i);
        }
        setText(str);
        setHint(str2);
        setTextCentered(this.textCentered);
    }

    private void layoutChild(View view, int i, int i2, int i3, int i4) {
        if (getLayoutDirection() == 1) {
            view.layout(getMeasuredWidth() - i3, i2, getMeasuredWidth() - i, i4);
        } else {
            view.layout(i, i2, i3, i4);
        }
    }

    private void layoutTextViewCenterAvoidToolbarViewsAndPadding() {
        int i;
        int measuredWidth = (getMeasuredWidth() / 2) - (this.textViewContainer.getMeasuredWidth() / 2);
        int measuredWidth2 = this.textViewContainer.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (getMeasuredHeight() / 2) - (this.textViewContainer.getMeasuredHeight() / 2);
        int measuredHeight2 = this.textViewContainer.getMeasuredHeight() + measuredHeight;
        boolean z = getLayoutDirection() == 1;
        ActionMenuView findOrGetMenuView = findOrGetMenuView();
        ImageButton findOrGetNavView = findOrGetNavView();
        int measuredWidth3 = (this.textViewContainer.getMeasuredWidth() / 2) - (this.textView.getMeasuredWidth() / 2);
        int i2 = measuredWidth3 + measuredWidth;
        int measuredWidth4 = measuredWidth + this.textView.getMeasuredWidth() + measuredWidth3;
        ActionMenuView actionMenuView = z ? findOrGetMenuView : findOrGetNavView;
        ActionMenuView actionMenuView2 = z ? findOrGetNavView : findOrGetMenuView;
        int i3 = 0;
        if (actionMenuView != null) {
            i = measuredWidth;
            i3 = Math.max(actionMenuView.getRight() - i2, 0);
        } else {
            i = measuredWidth;
        }
        int i4 = i2 + i3;
        int i5 = measuredWidth4 + i3;
        int max = actionMenuView2 != null ? Math.max(i5 - actionMenuView2.getLeft(), 0) : 0;
        int i6 = i4 - max;
        int i7 = i5 - max;
        int max2 = ((i3 - max) + Math.max(Math.max(getPaddingLeft() - i6, getContentInsetLeft() - i6), 0)) - Math.max(Math.max(i7 - (getMeasuredWidth() - getPaddingRight()), i7 - (getMeasuredWidth() - getContentInsetRight())), 0);
        this.textViewContainer.layout(i + max2, measuredHeight, measuredWidth2 + max2, measuredHeight2);
    }

    private void layoutViewInCenter(View view) {
        if (view == null) {
            return;
        }
        int measuredWidth = view.getMeasuredWidth();
        int measuredWidth2 = (getMeasuredWidth() / 2) - (measuredWidth / 2);
        int measuredHeight = view.getMeasuredHeight();
        int measuredHeight2 = (getMeasuredHeight() / 2) - (measuredHeight / 2);
        layoutChild(view, measuredWidth2, measuredHeight2, measuredWidth2 + measuredWidth, measuredHeight2 + measuredHeight);
    }

    private Drawable maybeTintNavigationIcon(Drawable drawable) {
        int color;
        if (!this.tintNavigationIcon || drawable == null) {
            return drawable;
        }
        if (this.navigationIconTint != null) {
            color = this.navigationIconTint.intValue();
        } else {
            color = MaterialColors.getColor(this, drawable == this.defaultNavigationIcon ? R.attr.colorOnSurfaceVariant : R.attr.colorOnSurface);
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        wrap.setTint(color);
        return wrap;
    }

    private void measureCenterView(int i, int i2) {
        if (this.centerView != null) {
            this.centerView.measure(i, i2);
        }
    }

    private void removeLiftOnScrollProgressListener() {
        AppBarLayout appBarLayoutParentIfExists = getAppBarLayoutParentIfExists();
        if (appBarLayoutParentIfExists != null) {
            appBarLayoutParentIfExists.removeLiftOnScrollProgressListener(this.liftColorListener);
        }
    }

    private void setDefaultMargins() {
        if (this.defaultMarginsEnabled && (getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            Resources resources = getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.m3_searchbar_margin_horizontal);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(getDefaultMarginVerticalResource());
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.leftMargin = defaultIfZero(marginLayoutParams.leftMargin, dimensionPixelSize);
            marginLayoutParams.topMargin = defaultIfZero(marginLayoutParams.topMargin, dimensionPixelSize2);
            marginLayoutParams.rightMargin = defaultIfZero(marginLayoutParams.rightMargin, dimensionPixelSize);
            marginLayoutParams.bottomMargin = defaultIfZero(marginLayoutParams.bottomMargin, dimensionPixelSize2);
        }
    }

    private void setHandwritingBoundsInsets() {
        if (Build.VERSION.SDK_INT < 34) {
            return;
        }
        boolean z = getLayoutDirection() == 1;
        int i = 0;
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
        if (navigationIconButton != null && navigationIconButton.isClickable()) {
            i = z ? getWidth() - navigationIconButton.getLeft() : navigationIconButton.getRight();
        }
        int i2 = 0;
        ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(this);
        if (actionMenuView != null) {
            i2 = z ? actionMenuView.getRight() : getWidth() - actionMenuView.getLeft();
        }
        setHandwritingBoundsOffsets(-(z ? i2 : i), 0.0f, -(z ? i : i2), 0.0f);
    }

    private void setNavigationIconDecorative(boolean z) {
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this);
        if (navigationIconButton == null) {
            return;
        }
        navigationIconButton.setClickable(!z);
        navigationIconButton.setFocusable(!z);
        Drawable background = navigationIconButton.getBackground();
        if (background != null) {
            this.originalNavigationIconBackground = background;
        }
        navigationIconButton.setBackgroundDrawable(z ? null : this.originalNavigationIconBackground);
        setHandwritingBoundsInsets();
    }

    private void setOrClearDefaultScrollFlags() {
        if (getLayoutParams() instanceof AppBarLayout.LayoutParams) {
            AppBarLayout.LayoutParams layoutParams = (AppBarLayout.LayoutParams) getLayoutParams();
            if (this.defaultScrollFlagsEnabled) {
                if (layoutParams.getScrollFlags() == 0) {
                    layoutParams.setScrollFlags(53);
                }
            } else if (layoutParams.getScrollFlags() == 53) {
                layoutParams.setScrollFlags(0);
            }
        }
    }

    private void validateAttributes(AttributeSet attributeSet) {
        if (attributeSet == null) {
            return;
        }
        if (attributeSet.getAttributeValue(NAMESPACE_APP, "title") != null) {
            throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
        }
        if (attributeSet.getAttributeValue(NAMESPACE_APP, "subtitle") != null) {
            throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
        }
    }

    public void addCollapseAnimationListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.searchBarAnimationHelper.addCollapseAnimationListener(animatorListenerAdapter);
    }

    public void addExpandAnimationListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.searchBarAnimationHelper.addExpandAnimationListener(animatorListenerAdapter);
    }

    public void addOnLoadAnimationCallback(OnLoadAnimationCallback onLoadAnimationCallback) {
        this.searchBarAnimationHelper.addOnLoadAnimationCallback(onLoadAnimationCallback);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (this.layoutInflated && this.centerView == null && !(view instanceof ActionMenuView)) {
            this.centerView = view;
            this.centerView.setAlpha(0.0f);
        }
        super.addView(view, i, layoutParams);
    }

    public void clearText() {
        this.textView.setText("");
        this.placeholderTextView.setText("");
    }

    public boolean collapse(View view) {
        return collapse(view, null);
    }

    public boolean collapse(View view, AppBarLayout appBarLayout) {
        return collapse(view, appBarLayout, false);
    }

    public boolean collapse(View view, AppBarLayout appBarLayout, boolean z) {
        if ((view.getVisibility() != 0 || isCollapsing()) && !isExpanding()) {
            return false;
        }
        this.searchBarAnimationHelper.startCollapseAnimation(this, view, appBarLayout, z);
        return true;
    }

    public boolean expand(View view) {
        return expand(view, null);
    }

    public boolean expand(View view, AppBarLayout appBarLayout) {
        return expand(view, appBarLayout, false);
    }

    public boolean expand(View view, AppBarLayout appBarLayout, boolean z) {
        if ((view.getVisibility() == 0 || isExpanding()) && !isCollapsing()) {
            return false;
        }
        this.searchBarAnimationHelper.startExpandAnimation(this, view, appBarLayout, z);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AppBarLayout getAppBarLayoutParentIfExists() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof AppBarLayout) {
                return (AppBarLayout) parent;
            }
        }
        return null;
    }

    public View getCenterView() {
        return this.centerView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCompatElevation() {
        return this.backgroundShape != null ? this.backgroundShape.getElevation() : getElevation();
    }

    public float getCornerSize() {
        return this.backgroundShape.getTopLeftCornerResolvedSize();
    }

    protected int getDefaultMarginVerticalResource() {
        return R.dimen.m3_searchbar_margin_vertical;
    }

    protected int getDefaultNavigationIconResource() {
        return R.drawable.ic_search_black_24;
    }

    public int getEndSiblingViewId() {
        return this.endSiblingViewId;
    }

    public CharSequence getHint() {
        return this.textView.getHint();
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMenuResId() {
        return this.menuResId;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public TextView getPlaceholderTextView() {
        return this.placeholderTextView;
    }

    public int getStartSiblingViewId() {
        return this.startSiblingViewId;
    }

    public int getStrokeColor() {
        return this.backgroundShape.getStrokeColor().getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.backgroundShape.getStrokeWidth();
    }

    public CharSequence getText() {
        return this.textView.getText();
    }

    public boolean getTextCentered() {
        return this.textCentered;
    }

    public TextView getTextView() {
        return this.textView;
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void inflateMenu(int i) {
        super.inflateMenu(i);
        this.menuResId = i;
    }

    public boolean isCollapsing() {
        return this.searchBarAnimationHelper.isCollapsing();
    }

    public boolean isDefaultScrollFlagsEnabled() {
        return this.defaultScrollFlagsEnabled;
    }

    public boolean isExpanding() {
        return this.searchBarAnimationHelper.isExpanding();
    }

    public boolean isLiftOnScroll() {
        return this.liftOnScroll;
    }

    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.searchBarAnimationHelper.isOnLoadAnimationFadeInEnabled();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startOnLoadAnimation$0$com-google-android-material-search-SearchBar, reason: not valid java name */
    public /* synthetic */ void m395x9ebe9dc4() {
        this.searchBarAnimationHelper.startOnLoadAnimation(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.backgroundShape);
        setDefaultMargins();
        setOrClearDefaultScrollFlags();
        if (this.liftOnScroll) {
            addLiftOnScrollProgressListener();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeLiftOnScrollProgressListener();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(EditText.class.getCanonicalName());
        accessibilityNodeInfo.setEditable(isEnabled());
        CharSequence text = getText();
        boolean isEmpty = TextUtils.isEmpty(text);
        if (Build.VERSION.SDK_INT >= 26) {
            accessibilityNodeInfo.setHintText(getHint());
            accessibilityNodeInfo.setShowingHintText(isEmpty);
        }
        if (isEmpty) {
            text = getHint();
        }
        accessibilityNodeInfo.setText(text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.centerView != null) {
            layoutViewInCenter(this.centerView);
        }
        setHandwritingBoundsInsets();
        if (this.textView == null || !this.textCentered) {
            return;
        }
        layoutTextViewCenterAvoidToolbarViewsAndPadding();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        if (this.maxWidth >= 0 && size > this.maxWidth) {
            i = View.MeasureSpec.makeMeasureSpec(this.maxWidth, mode);
        } else if (this.adaptiveMaxWidthEnabled && size > this.adaptiveMaxWidthParentBreakpoint) {
            i = View.MeasureSpec.makeMeasureSpec(Math.max(this.adaptiveMaxWidthParentBreakpoint, Math.round(size * 0.5f)), mode);
        }
        super.onMeasure(i, i2);
        measureCenterView(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setText(savedState.text);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        CharSequence text = getText();
        savedState.text = text == null ? null : text.toString();
        return savedState;
    }

    public boolean removeCollapseAnimationListener(AnimatorListenerAdapter animatorListenerAdapter) {
        return this.searchBarAnimationHelper.removeCollapseAnimationListener(animatorListenerAdapter);
    }

    public boolean removeExpandAnimationListener(AnimatorListenerAdapter animatorListenerAdapter) {
        return this.searchBarAnimationHelper.removeExpandAnimationListener(animatorListenerAdapter);
    }

    public boolean removeOnLoadAnimationCallback(OnLoadAnimationCallback onLoadAnimationCallback) {
        return this.searchBarAnimationHelper.removeOnLoadAnimationCallback(onLoadAnimationCallback);
    }

    public void setCenterView(View view) {
        if (this.centerView != null) {
            removeView(this.centerView);
            this.centerView = null;
        }
        if (view != null) {
            addView(view);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean z) {
        this.defaultScrollFlagsEnabled = z;
        setOrClearDefaultScrollFlags();
    }

    @Override // android.view.View
    public void setElevation(float f) {
        super.setElevation(f);
        if (this.backgroundShape != null) {
            this.backgroundShape.setElevation(f);
        }
    }

    public void setEndSiblingViewId(int i) {
        this.endSiblingViewId = i;
    }

    public void setHint(int i) {
        this.textView.setHint(i);
    }

    public void setHint(CharSequence charSequence) {
        this.textView.setHint(charSequence);
    }

    public void setLiftOnScroll(boolean z) {
        this.liftOnScroll = z;
        if (z) {
            addLiftOnScrollProgressListener();
        } else {
            removeLiftOnScrollProgressListener();
        }
    }

    public void setMaxWidth(int i) {
        if (this.maxWidth != i) {
            this.maxWidth = i;
            requestLayout();
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(maybeTintNavigationIcon(drawable));
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationOnClickListener(View.OnClickListener onClickListener) {
        if (this.forceDefaultNavigationOnClickListener) {
            return;
        }
        super.setNavigationOnClickListener(onClickListener);
        setNavigationIconDecorative(onClickListener == null);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean z) {
        this.searchBarAnimationHelper.setOnLoadAnimationFadeInEnabled(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setPlaceholderText(String str) {
        this.placeholderTextView.setText(str);
    }

    public void setStartSiblingViewId(int i) {
        this.startSiblingViewId = i;
    }

    public void setStrokeColor(int i) {
        if (getStrokeColor() != i) {
            this.backgroundShape.setStrokeColor(ColorStateList.valueOf(i));
        }
    }

    public void setStrokeWidth(float f) {
        if (getStrokeWidth() != f) {
            this.backgroundShape.setStrokeWidth(f);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    public void setText(int i) {
        this.textView.setText(i);
        this.placeholderTextView.setText(i);
    }

    public void setText(CharSequence charSequence) {
        this.textView.setText(charSequence);
        this.placeholderTextView.setText(charSequence);
    }

    public void setTextCentered(boolean z) {
        this.textCentered = z;
        if (this.textView == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.textView.getLayoutParams();
        if (z) {
            layoutParams.gravity = 1;
            this.textView.setGravity(1);
        } else {
            layoutParams.gravity = 0;
            this.textView.setGravity(0);
        }
        this.textView.setLayoutParams(layoutParams);
        this.placeholderTextView.setLayoutParams(layoutParams);
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }

    public void startOnLoadAnimation() {
        post(new SearchBar$$ExternalSyntheticLambda0(this));
    }

    public void stopOnLoadAnimation() {
        this.searchBarAnimationHelper.stopOnLoadAnimation(this);
    }
}
