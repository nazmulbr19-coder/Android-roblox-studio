package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

/* loaded from: classes.dex */
public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int DEFAULT_COLLAPSED_MAX_COUNT = 7;
    private static final int NO_PADDING = -1;
    private static final int NO_SELECTED_ITEM = -1;
    private final SparseArray<BadgeDrawable> badgeDrawables;
    private NavigationBarMenuItemView[] buttons;
    private MenuItem checkedItem;
    private int collapsedMaxItemCount;
    private boolean dividersEnabled;
    private boolean expanded;
    private int horizontalItemTextAppearanceActive;
    private int horizontalItemTextAppearanceInactive;
    private int iconLabelHorizontalSpacing;
    private ColorStateList itemActiveIndicatorColor;
    private boolean itemActiveIndicatorEnabled;
    private int itemActiveIndicatorExpandedHeight;
    private int itemActiveIndicatorExpandedMarginHorizontal;
    private final Rect itemActiveIndicatorExpandedPadding;
    private int itemActiveIndicatorExpandedWidth;
    private int itemActiveIndicatorHeight;
    private int itemActiveIndicatorLabelPadding;
    private int itemActiveIndicatorMarginHorizontal;
    private boolean itemActiveIndicatorResizeable;
    private ShapeAppearanceModel itemActiveIndicatorShapeAppearance;
    private int itemActiveIndicatorWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    private int itemGravity;
    private int itemIconGravity;
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private Pools.Pool<NavigationBarItemView> itemPool;
    private int itemPoolSize;
    private ColorStateList itemRippleColor;
    private int itemTextAppearanceActive;
    private boolean itemTextAppearanceActiveBoldEnabled;
    private int itemTextAppearanceInactive;
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelMaxLines;
    private int labelVisibilityMode;
    private boolean measurePaddingFromLabelBaseline;
    private NavigationBarMenuBuilder menu;
    private final View.OnClickListener onClickListener;
    private final SparseArray<View.OnTouchListener> onTouchListeners;
    private NavigationBarPresenter presenter;
    private boolean scaleLabelWithFont;
    private int selectedItemId;
    private int selectedItemPosition;
    private final TransitionSet set;
    private static final int[] CHECKED_STATE_SET = {R.attr.state_checked};
    private static final int[] DISABLED_STATE_SET = {-16842910};

    /* renamed from: com.google.android.material.navigation.NavigationBarMenuView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MenuItemImpl itemData = ((NavigationBarItemView) view).getItemData();
            boolean performItemAction = NavigationBarMenuView.access$100(NavigationBarMenuView.this).performItemAction(itemData, NavigationBarMenuView.access$000(NavigationBarMenuView.this), 0);
            if (itemData == null || !itemData.isCheckable()) {
                return;
            }
            if (!performItemAction || itemData.isChecked()) {
                NavigationBarMenuView.this.setCheckedItem(itemData);
            }
        }
    }

    public NavigationBarMenuView(Context context) {
        super(context);
        this.onTouchListeners = new SparseArray<>();
        this.selectedItemId = -1;
        this.selectedItemPosition = -1;
        this.badgeDrawables = new SparseArray<>();
        this.itemPaddingTop = -1;
        this.itemPaddingBottom = -1;
        this.itemActiveIndicatorLabelPadding = -1;
        this.iconLabelHorizontalSpacing = -1;
        this.itemGravity = 49;
        this.itemActiveIndicatorResizeable = false;
        this.labelMaxLines = 1;
        this.itemPoolSize = 0;
        this.checkedItem = null;
        this.collapsedMaxItemCount = 7;
        this.dividersEnabled = false;
        this.itemActiveIndicatorExpandedPadding = new Rect();
        this.itemTextColorDefault = createDefaultColorStateList(R.attr.textColorSecondary);
        if (isInEditMode()) {
            this.set = null;
        } else {
            this.set = new AutoTransition();
            this.set.setOrdering(0);
            this.set.excludeTarget(TextView.class, true);
            this.set.setDuration(MotionUtils.resolveThemeDuration(getContext(), com.google.android.material.R.attr.motionDurationMedium4, getResources().getInteger(com.google.android.material.R.integer.material_motion_duration_long_1)));
            this.set.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), com.google.android.material.R.attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            this.set.addTransition(new TextScale());
        }
        this.onClickListener = new AnonymousClass1();
        setImportantForAccessibility(1);
    }

    static /* synthetic */ NavigationBarPresenter access$000(NavigationBarMenuView navigationBarMenuView) {
        return navigationBarMenuView.presenter;
    }

    static /* synthetic */ NavigationBarMenuBuilder access$100(NavigationBarMenuView navigationBarMenuView) {
        return navigationBarMenuView.menu;
    }

    private Drawable createItemActiveIndicatorDrawable() {
        if (this.itemActiveIndicatorShapeAppearance == null || this.itemActiveIndicatorColor == null) {
            return null;
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
        materialShapeDrawable.setFillColor(this.itemActiveIndicatorColor);
        return materialShapeDrawable;
    }

    private NavigationBarItemView createMenuItem(int i, MenuItemImpl menuItemImpl, boolean z, boolean z2) {
        this.presenter.setUpdateSuspended(true);
        menuItemImpl.setCheckable(true);
        this.presenter.setUpdateSuspended(false);
        NavigationBarItemView newItem = getNewItem();
        newItem.setShifting(z);
        newItem.setLabelMaxLines(this.labelMaxLines);
        newItem.setIconTintList(this.itemIconTint);
        newItem.setIconSize(this.itemIconSize);
        newItem.setTextColor(this.itemTextColorDefault);
        newItem.setTextAppearanceInactive(this.itemTextAppearanceInactive);
        newItem.setTextAppearanceActive(this.itemTextAppearanceActive);
        newItem.setHorizontalTextAppearanceInactive(this.horizontalItemTextAppearanceInactive);
        newItem.setHorizontalTextAppearanceActive(this.horizontalItemTextAppearanceActive);
        newItem.setTextAppearanceActiveBoldEnabled(this.itemTextAppearanceActiveBoldEnabled);
        newItem.setTextColor(this.itemTextColorFromUser);
        if (this.itemPaddingTop != -1) {
            newItem.setItemPaddingTop(this.itemPaddingTop);
        }
        if (this.itemPaddingBottom != -1) {
            newItem.setItemPaddingBottom(this.itemPaddingBottom);
        }
        newItem.setMeasureBottomPaddingFromLabelBaseline(this.measurePaddingFromLabelBaseline);
        newItem.setLabelFontScalingEnabled(this.scaleLabelWithFont);
        if (this.itemActiveIndicatorLabelPadding != -1) {
            newItem.setActiveIndicatorLabelPadding(this.itemActiveIndicatorLabelPadding);
        }
        if (this.iconLabelHorizontalSpacing != -1) {
            newItem.setIconLabelHorizontalSpacing(this.iconLabelHorizontalSpacing);
        }
        newItem.setActiveIndicatorWidth(this.itemActiveIndicatorWidth);
        newItem.setActiveIndicatorHeight(this.itemActiveIndicatorHeight);
        newItem.setActiveIndicatorExpandedWidth(this.itemActiveIndicatorExpandedWidth);
        newItem.setActiveIndicatorExpandedHeight(this.itemActiveIndicatorExpandedHeight);
        newItem.setActiveIndicatorMarginHorizontal(this.itemActiveIndicatorMarginHorizontal);
        newItem.setItemGravity(this.itemGravity);
        newItem.setActiveIndicatorExpandedPadding(this.itemActiveIndicatorExpandedPadding);
        newItem.setActiveIndicatorExpandedMarginHorizontal(this.itemActiveIndicatorExpandedMarginHorizontal);
        newItem.setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
        newItem.setActiveIndicatorResizeable(this.itemActiveIndicatorResizeable);
        newItem.setActiveIndicatorEnabled(this.itemActiveIndicatorEnabled);
        if (this.itemBackground != null) {
            newItem.setItemBackground(this.itemBackground);
        } else {
            newItem.setItemBackground(this.itemBackgroundRes);
        }
        newItem.setItemRippleColor(this.itemRippleColor);
        newItem.setLabelVisibilityMode(this.labelVisibilityMode);
        newItem.setItemIconGravity(this.itemIconGravity);
        newItem.setOnlyShowWhenExpanded(z2);
        newItem.setExpanded(this.expanded);
        newItem.initialize(menuItemImpl, 0);
        newItem.setItemPosition(i);
        int itemId = menuItemImpl.getItemId();
        newItem.setOnTouchListener(this.onTouchListeners.get(itemId));
        newItem.setOnClickListener(this.onClickListener);
        if (this.selectedItemId != 0 && itemId == this.selectedItemId) {
            this.selectedItemPosition = i;
        }
        setBadgeIfNeeded(newItem);
        return newItem;
    }

    private int getCollapsedVisibleItemCount() {
        return Math.min(this.collapsedMaxItemCount, this.menu.getVisibleMainContentItemCount());
    }

    private NavigationBarItemView getNewItem() {
        NavigationBarItemView acquire = this.itemPool != null ? this.itemPool.acquire() : null;
        return acquire == null ? createNavigationBarItemView(getContext()) : acquire;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x0069, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private boolean isMenuStructureSame() {
        /*
            r5 = this;
            com.google.android.material.navigation.NavigationBarMenuItemView[] r0 = r5.buttons
            r1 = 0
            if (r0 == 0) goto L6e
            com.google.android.material.navigation.NavigationBarMenuBuilder r0 = r5.menu
            if (r0 == 0) goto L6e
            com.google.android.material.navigation.NavigationBarMenuBuilder r0 = r5.menu
            int r0 = r0.size()
            com.google.android.material.navigation.NavigationBarMenuItemView[] r2 = r5.buttons
            int r2 = r2.length
            if (r0 != r2) goto L6e
            r0 = 0
        L15:
            com.google.android.material.navigation.NavigationBarMenuItemView[] r2 = r5.buttons
            int r2 = r2.length
            r3 = 1
            if (r0 >= r2) goto L6d
            com.google.android.material.navigation.NavigationBarMenuBuilder r2 = r5.menu
            android.view.MenuItem r2 = r2.getItemAt(r0)
            boolean r2 = r2 instanceof com.google.android.material.navigation.DividerMenuItem
            if (r2 == 0) goto L2e
            com.google.android.material.navigation.NavigationBarMenuItemView[] r2 = r5.buttons
            r2 = r2[r0]
            boolean r2 = r2 instanceof com.google.android.material.navigation.NavigationBarDividerView
            if (r2 != 0) goto L2e
            return r1
        L2e:
            com.google.android.material.navigation.NavigationBarMenuBuilder r2 = r5.menu
            android.view.MenuItem r2 = r2.getItemAt(r0)
            boolean r2 = r2.hasSubMenu()
            if (r2 == 0) goto L44
            com.google.android.material.navigation.NavigationBarMenuItemView[] r2 = r5.buttons
            r2 = r2[r0]
            boolean r2 = r2 instanceof com.google.android.material.navigation.NavigationBarSubheaderView
            if (r2 != 0) goto L44
            r2 = r3
            goto L45
        L44:
            r2 = r1
        L45:
            com.google.android.material.navigation.NavigationBarMenuBuilder r4 = r5.menu
            android.view.MenuItem r4 = r4.getItemAt(r0)
            boolean r4 = r4.hasSubMenu()
            if (r4 != 0) goto L5a
            com.google.android.material.navigation.NavigationBarMenuItemView[] r4 = r5.buttons
            r4 = r4[r0]
            boolean r4 = r4 instanceof com.google.android.material.navigation.NavigationBarItemView
            if (r4 != 0) goto L5a
            goto L5b
        L5a:
            r3 = r1
        L5b:
            com.google.android.material.navigation.NavigationBarMenuBuilder r4 = r5.menu
            android.view.MenuItem r4 = r4.getItemAt(r0)
            boolean r4 = r4 instanceof com.google.android.material.navigation.DividerMenuItem
            if (r4 != 0) goto L6a
            if (r2 != 0) goto L69
            if (r3 == 0) goto L6a
        L69:
            return r1
        L6a:
            int r0 = r0 + 1
            goto L15
        L6d:
            return r3
        L6e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationBarMenuView.isMenuStructureSame():boolean");
    }

    private boolean isValidId(int i) {
        return i != -1;
    }

    private void releaseItemPool() {
        if (this.buttons == null || this.itemPool == null) {
            return;
        }
        for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
            if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                this.itemPool.release((NavigationBarItemView) navigationBarMenuItemView);
                ((NavigationBarItemView) navigationBarMenuItemView).clear();
            }
        }
    }

    private void removeUnusedBadges() {
        HashSet hashSet = new HashSet();
        for (int i = 0; i < this.menu.size(); i++) {
            hashSet.add(Integer.valueOf(this.menu.getItemAt(i).getItemId()));
        }
        for (int i2 = 0; i2 < this.badgeDrawables.size(); i2++) {
            int keyAt = this.badgeDrawables.keyAt(i2);
            if (!hashSet.contains(Integer.valueOf(keyAt))) {
                this.badgeDrawables.delete(keyAt);
            }
        }
    }

    private void setBadgeIfNeeded(NavigationBarItemView navigationBarItemView) {
        BadgeDrawable badgeDrawable;
        int id = navigationBarItemView.getId();
        if (isValidId(id) && (badgeDrawable = this.badgeDrawables.get(id)) != null) {
            navigationBarItemView.setBadge(badgeDrawable);
        }
    }

    private void validateMenuItemId(int i) {
        if (!isValidId(i)) {
            throw new IllegalArgumentException(i + " is not a valid view id");
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10, types: [com.google.android.material.navigation.NavigationBarMenuItemView, com.google.android.material.navigation.NavigationBarDividerView] */
    /* JADX WARN: Type inference failed for: r9v8, types: [com.google.android.material.navigation.NavigationBarMenuItemView, com.google.android.material.navigation.NavigationBarSubheaderView] */
    public void buildMenuView() {
        NavigationBarItemView navigationBarItemView;
        removeAllViews();
        releaseItemPool();
        this.presenter.setUpdateSuspended(true);
        this.menu.refreshItems();
        this.presenter.setUpdateSuspended(false);
        int contentItemCount = this.menu.getContentItemCount();
        if (contentItemCount == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            this.itemPool = null;
            return;
        }
        if (this.itemPool == null || this.itemPoolSize != contentItemCount) {
            this.itemPoolSize = contentItemCount;
            this.itemPool = new Pools.SynchronizedPool(contentItemCount);
        }
        removeUnusedBadges();
        int size = this.menu.size();
        this.buttons = new NavigationBarMenuItemView[size];
        int i = 0;
        int i2 = 0;
        boolean isShifting = isShifting(this.labelVisibilityMode, getCurrentVisibleContentItemCount());
        for (int i3 = 0; i3 < size; i3++) {
            MenuItem itemAt = this.menu.getItemAt(i3);
            if (itemAt instanceof DividerMenuItem) {
                ?? navigationBarDividerView = new NavigationBarDividerView(getContext());
                navigationBarDividerView.setOnlyShowWhenExpanded(true);
                ((NavigationBarDividerView) navigationBarDividerView).setDividersEnabled(this.dividersEnabled);
                navigationBarItemView = navigationBarDividerView;
            } else if (itemAt.hasSubMenu()) {
                if (i2 > 0) {
                    throw new IllegalArgumentException("Only one layer of submenu is supported; a submenu inside a submenu is not supported by the Navigation Bar.");
                }
                ?? navigationBarSubheaderView = new NavigationBarSubheaderView(getContext());
                ((NavigationBarSubheaderView) navigationBarSubheaderView).setTextAppearance(this.horizontalItemTextAppearanceActive != 0 ? this.horizontalItemTextAppearanceActive : this.itemTextAppearanceActive);
                ((NavigationBarSubheaderView) navigationBarSubheaderView).setTextColor(this.itemTextColorFromUser);
                navigationBarSubheaderView.setOnlyShowWhenExpanded(true);
                navigationBarSubheaderView.initialize((MenuItemImpl) itemAt, 0);
                i2 = itemAt.getSubMenu().size();
                navigationBarItemView = navigationBarSubheaderView;
            } else if (i2 > 0) {
                i2--;
                navigationBarItemView = createMenuItem(i3, (MenuItemImpl) itemAt, isShifting, true);
            } else {
                MenuItemImpl menuItemImpl = (MenuItemImpl) itemAt;
                boolean z = i >= this.collapsedMaxItemCount;
                i++;
                navigationBarItemView = createMenuItem(i3, menuItemImpl, isShifting, z);
            }
            if (!(itemAt instanceof DividerMenuItem) && itemAt.isCheckable() && this.selectedItemPosition == -1) {
                this.selectedItemPosition = i3;
            }
            this.buttons[i3] = navigationBarItemView;
            addView(navigationBarItemView);
        }
        this.selectedItemPosition = Math.min(size - 1, this.selectedItemPosition);
        setCheckedItem(this.buttons[this.selectedItemPosition].getItemData());
    }

    public ColorStateList createDefaultColorStateList(int i) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i, typedValue, true)) {
            return null;
        }
        ColorStateList colorStateList = AppCompatResources.getColorStateList(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(androidx.appcompat.R.attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i2 = typedValue.data;
        int defaultColor = colorStateList.getDefaultColor();
        return new ColorStateList(new int[][]{DISABLED_STATE_SET, CHECKED_STATE_SET, EMPTY_STATE_SET}, new int[]{colorStateList.getColorForState(DISABLED_STATE_SET, defaultColor), i2, defaultColor});
    }

    protected abstract NavigationBarItemView createNavigationBarItemView(Context context);

    public NavigationBarItemView findItemView(int i) {
        validateMenuItemId(i);
        if (this.buttons == null) {
            return null;
        }
        for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
            if ((navigationBarMenuItemView instanceof NavigationBarItemView) && ((NavigationBarItemView) navigationBarMenuItemView).getId() == i) {
                return (NavigationBarItemView) navigationBarMenuItemView;
            }
        }
        return null;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.itemActiveIndicatorLabelPadding;
    }

    public BadgeDrawable getBadge(int i) {
        return this.badgeDrawables.get(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SparseArray<BadgeDrawable> getBadgeDrawables() {
        return this.badgeDrawables;
    }

    public int getCurrentVisibleContentItemCount() {
        return this.expanded ? this.menu.getVisibleContentItemCount() : getCollapsedVisibleItemCount();
    }

    public int getHorizontalItemTextAppearanceActive() {
        return this.horizontalItemTextAppearanceActive;
    }

    public int getHorizontalItemTextAppearanceInactive() {
        return this.horizontalItemTextAppearanceInactive;
    }

    public int getIconLabelHorizontalSpacing() {
        return this.iconLabelHorizontalSpacing;
    }

    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.itemActiveIndicatorColor;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.itemActiveIndicatorEnabled;
    }

    public int getItemActiveIndicatorExpandedHeight() {
        return this.itemActiveIndicatorExpandedHeight;
    }

    public int getItemActiveIndicatorExpandedMarginHorizontal() {
        return this.itemActiveIndicatorExpandedMarginHorizontal;
    }

    public int getItemActiveIndicatorExpandedWidth() {
        return this.itemActiveIndicatorExpandedWidth;
    }

    public int getItemActiveIndicatorHeight() {
        return this.itemActiveIndicatorHeight;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.itemActiveIndicatorMarginHorizontal;
    }

    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    public Drawable getItemBackground() {
        if (this.buttons != null && this.buttons.length > 0) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    return ((NavigationBarItemView) navigationBarMenuItemView).getBackground();
                }
            }
        }
        return this.itemBackground;
    }

    @Deprecated
    public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    public int getItemGravity() {
        return this.itemGravity;
    }

    public int getItemIconGravity() {
        return this.itemIconGravity;
    }

    public int getItemIconSize() {
        return this.itemIconSize;
    }

    public int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    public int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelMaxLines() {
        return this.labelMaxLines;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    protected NavigationBarMenuBuilder getMenu() {
        return this.menu;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public BadgeDrawable getOrCreateBadge(int i) {
        validateMenuItemId(i);
        BadgeDrawable badgeDrawable = this.badgeDrawables.get(i);
        if (badgeDrawable == null) {
            badgeDrawable = BadgeDrawable.create(getContext());
            this.badgeDrawables.put(i, badgeDrawable);
        }
        NavigationBarItemView findItemView = findItemView(i);
        if (findItemView != null) {
            findItemView.setBadge(badgeDrawable);
        }
        return badgeDrawable;
    }

    public boolean getScaleLabelTextWithFont() {
        return this.scaleLabelWithFont;
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public int getWindowAnimations() {
        return 0;
    }

    @Override // androidx.appcompat.view.menu.MenuView
    public void initialize(MenuBuilder menuBuilder) {
        this.menu = new NavigationBarMenuBuilder(menuBuilder);
    }

    public boolean isExpanded() {
        return this.expanded;
    }

    protected boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isShifting(int i, int i2) {
        return i == -1 ? i2 > 3 : i == 0;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, getCurrentVisibleContentItemCount(), false, 1));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeBadge(int i) {
        validateMenuItemId(i);
        NavigationBarItemView findItemView = findItemView(i);
        if (findItemView != null) {
            findItemView.removeBadge();
        }
        this.badgeDrawables.put(i, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void restoreBadgeDrawables(SparseArray<BadgeDrawable> sparseArray) {
        BadgeDrawable badgeDrawable;
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            if (this.badgeDrawables.indexOfKey(keyAt) < 0) {
                this.badgeDrawables.append(keyAt, sparseArray.get(keyAt));
            }
        }
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if ((navigationBarMenuItemView instanceof NavigationBarItemView) && (badgeDrawable = this.badgeDrawables.get(((NavigationBarItemView) navigationBarMenuItemView).getId())) != null) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setBadge(badgeDrawable);
                }
            }
        }
    }

    public void setActiveIndicatorLabelPadding(int i) {
        this.itemActiveIndicatorLabelPadding = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorLabelPadding(i);
                }
            }
        }
    }

    public void setCheckedItem(MenuItem menuItem) {
        if (this.checkedItem == menuItem || !menuItem.isCheckable()) {
            return;
        }
        if (this.checkedItem != null && this.checkedItem.isChecked()) {
            this.checkedItem.setChecked(false);
        }
        menuItem.setChecked(true);
        this.checkedItem = menuItem;
    }

    public void setCollapsedMaxItemCount(int i) {
        this.collapsedMaxItemCount = i;
    }

    public void setExpanded(boolean z) {
        this.expanded = z;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                navigationBarMenuItemView.setExpanded(z);
            }
        }
    }

    public void setHorizontalItemTextAppearanceActive(int i) {
        this.horizontalItemTextAppearanceActive = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setHorizontalTextAppearanceActive(i);
                }
            }
        }
    }

    public void setHorizontalItemTextAppearanceInactive(int i) {
        this.horizontalItemTextAppearanceInactive = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setHorizontalTextAppearanceInactive(i);
                }
            }
        }
    }

    public void setIconLabelHorizontalSpacing(int i) {
        this.iconLabelHorizontalSpacing = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setIconLabelHorizontalSpacing(i);
                }
            }
        }
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.itemIconTint = colorStateList;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setIconTintList(colorStateList);
                }
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList colorStateList) {
        this.itemActiveIndicatorColor = colorStateList;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
                }
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean z) {
        this.itemActiveIndicatorEnabled = z;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorEnabled(z);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedHeight(int i) {
        this.itemActiveIndicatorExpandedHeight = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorExpandedHeight(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedMarginHorizontal(int i) {
        this.itemActiveIndicatorExpandedMarginHorizontal = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorExpandedMarginHorizontal(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedPadding(int i, int i2, int i3, int i4) {
        this.itemActiveIndicatorExpandedPadding.left = i;
        this.itemActiveIndicatorExpandedPadding.top = i2;
        this.itemActiveIndicatorExpandedPadding.right = i3;
        this.itemActiveIndicatorExpandedPadding.bottom = i4;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorExpandedPadding(this.itemActiveIndicatorExpandedPadding);
                }
            }
        }
    }

    public void setItemActiveIndicatorExpandedWidth(int i) {
        this.itemActiveIndicatorExpandedWidth = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorExpandedWidth(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorHeight(int i) {
        this.itemActiveIndicatorHeight = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorHeight(i);
                }
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int i) {
        this.itemActiveIndicatorMarginHorizontal = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorMarginHorizontal(i);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemActiveIndicatorResizeable(boolean z) {
        this.itemActiveIndicatorResizeable = z;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorResizeable(z);
                }
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.itemActiveIndicatorShapeAppearance = shapeAppearanceModel;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorDrawable(createItemActiveIndicatorDrawable());
                }
            }
        }
    }

    public void setItemActiveIndicatorWidth(int i) {
        this.itemActiveIndicatorWidth = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setActiveIndicatorWidth(i);
                }
            }
        }
    }

    public void setItemBackground(Drawable drawable) {
        this.itemBackground = drawable;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemBackground(drawable);
                }
            }
        }
    }

    public void setItemBackgroundRes(int i) {
        this.itemBackgroundRes = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemBackground(i);
                }
            }
        }
    }

    public void setItemGravity(int i) {
        this.itemGravity = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemGravity(i);
                }
            }
        }
    }

    public void setItemIconGravity(int i) {
        this.itemIconGravity = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemIconGravity(i);
                }
            }
        }
    }

    public void setItemIconSize(int i) {
        this.itemIconSize = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setIconSize(i);
                }
            }
        }
    }

    public void setItemOnTouchListener(int i, View.OnTouchListener onTouchListener) {
        if (onTouchListener == null) {
            this.onTouchListeners.remove(i);
        } else {
            this.onTouchListeners.put(i, onTouchListener);
        }
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if ((navigationBarMenuItemView instanceof NavigationBarItemView) && navigationBarMenuItemView.getItemData() != null && navigationBarMenuItemView.getItemData().getItemId() == i) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setOnTouchListener(onTouchListener);
                }
            }
        }
    }

    public void setItemPaddingBottom(int i) {
        this.itemPaddingBottom = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemPaddingBottom(this.itemPaddingBottom);
                }
            }
        }
    }

    public void setItemPaddingTop(int i) {
        this.itemPaddingTop = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemPaddingTop(i);
                }
            }
        }
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        this.itemRippleColor = colorStateList;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setItemRippleColor(colorStateList);
                }
            }
        }
    }

    public void setItemTextAppearanceActive(int i) {
        this.itemTextAppearanceActive = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setTextAppearanceActive(i);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean z) {
        this.itemTextAppearanceActiveBoldEnabled = z;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setTextAppearanceActiveBoldEnabled(z);
                }
            }
        }
    }

    public void setItemTextAppearanceInactive(int i) {
        this.itemTextAppearanceInactive = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setTextAppearanceInactive(i);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.itemTextColorFromUser = colorStateList;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setTextColor(colorStateList);
                }
            }
        }
    }

    public void setLabelFontScalingEnabled(boolean z) {
        this.scaleLabelWithFont = z;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setLabelFontScalingEnabled(z);
                }
            }
        }
    }

    public void setLabelMaxLines(int i) {
        this.labelMaxLines = i;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setLabelMaxLines(i);
                }
            }
        }
    }

    public void setLabelVisibilityMode(int i) {
        this.labelVisibilityMode = i;
    }

    public void setMeasurePaddingFromLabelBaseline(boolean z) {
        this.measurePaddingFromLabelBaseline = z;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).setMeasureBottomPaddingFromLabelBaseline(z);
                }
            }
        }
    }

    public void setPresenter(NavigationBarPresenter navigationBarPresenter) {
        this.presenter = navigationBarPresenter;
    }

    public void setSubmenuDividersEnabled(boolean z) {
        if (this.dividersEnabled == z) {
            return;
        }
        this.dividersEnabled = z;
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarDividerView) {
                    ((NavigationBarDividerView) navigationBarMenuItemView).setDividersEnabled(z);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void tryRestoreSelectedItemId(int i) {
        int size = this.menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem itemAt = this.menu.getItemAt(i2);
            if (i == itemAt.getItemId()) {
                this.selectedItemId = i;
                this.selectedItemPosition = i2;
                setCheckedItem(itemAt);
                return;
            }
        }
    }

    public void updateActiveIndicator(int i) {
        if (this.buttons != null) {
            for (NavigationBarMenuItemView navigationBarMenuItemView : this.buttons) {
                if (navigationBarMenuItemView instanceof NavigationBarItemView) {
                    ((NavigationBarItemView) navigationBarMenuItemView).updateActiveIndicatorLayoutParams(i);
                }
            }
        }
    }

    public void updateMenuView() {
        if (this.menu == null || this.buttons == null) {
            return;
        }
        this.presenter.setUpdateSuspended(true);
        this.menu.refreshItems();
        this.presenter.setUpdateSuspended(false);
        if (!isMenuStructureSame()) {
            buildMenuView();
            return;
        }
        int i = this.selectedItemId;
        int size = this.menu.size();
        for (int i2 = 0; i2 < size; i2++) {
            MenuItem itemAt = this.menu.getItemAt(i2);
            if (itemAt.isChecked()) {
                setCheckedItem(itemAt);
                this.selectedItemId = itemAt.getItemId();
                this.selectedItemPosition = i2;
            }
        }
        if (i != this.selectedItemId && this.set != null) {
            TransitionManager.beginDelayedTransition(this, this.set);
        }
        boolean isShifting = isShifting(this.labelVisibilityMode, getCurrentVisibleContentItemCount());
        for (int i3 = 0; i3 < size; i3++) {
            this.presenter.setUpdateSuspended(true);
            this.buttons[i3].setExpanded(this.expanded);
            if (this.buttons[i3] instanceof NavigationBarItemView) {
                NavigationBarItemView navigationBarItemView = (NavigationBarItemView) this.buttons[i3];
                navigationBarItemView.setLabelVisibilityMode(this.labelVisibilityMode);
                navigationBarItemView.setItemIconGravity(this.itemIconGravity);
                navigationBarItemView.setItemGravity(this.itemGravity);
                navigationBarItemView.setShifting(isShifting);
            }
            if (this.menu.getItemAt(i3) instanceof MenuItemImpl) {
                this.buttons[i3].initialize((MenuItemImpl) this.menu.getItemAt(i3), 0);
            }
            this.presenter.setUpdateSuspended(false);
        }
    }
}
