package com.google.android.material.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.badge.BadgeState;
import com.google.android.material.internal.ParcelableSparseArray;
import com.google.android.material.internal.ToolbarUtils;

/* loaded from: classes.dex */
public class BadgeUtils {
    private static final String LOG_TAG = "BadgeUtils";

    /* renamed from: com.google.android.material.badge.BadgeUtils$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ BadgeDrawable val$badgeDrawable;
        final /* synthetic */ FrameLayout val$customBadgeParent;
        final /* synthetic */ int val$menuItemId;
        final /* synthetic */ Toolbar val$toolbar;

        AnonymousClass1(Toolbar toolbar, int i, BadgeDrawable badgeDrawable, FrameLayout frameLayout) {
            this.val$toolbar = toolbar;
            this.val$menuItemId = i;
            this.val$badgeDrawable = badgeDrawable;
            this.val$customBadgeParent = frameLayout;
        }

        @Override // java.lang.Runnable
        public void run() {
            ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(this.val$toolbar, this.val$menuItemId);
            if (actionMenuItemView != null) {
                BadgeUtils.setToolbarOffset(this.val$badgeDrawable, this.val$toolbar.getResources());
                BadgeUtils.attachBadgeDrawable(this.val$badgeDrawable, actionMenuItemView, this.val$customBadgeParent);
                BadgeUtils.access$000(this.val$badgeDrawable, actionMenuItemView);
            }
        }
    }

    /* renamed from: com.google.android.material.badge.BadgeUtils$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AccessibilityDelegateCompat {
        final /* synthetic */ BadgeDrawable val$badgeDrawable;
        final /* synthetic */ View val$view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(View.AccessibilityDelegate accessibilityDelegate, View view, BadgeDrawable badgeDrawable) {
            super(accessibilityDelegate);
            this.val$view = view;
            this.val$badgeDrawable = badgeDrawable;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(BadgeUtils.access$100(this.val$view, this.val$badgeDrawable));
        }
    }

    /* renamed from: com.google.android.material.badge.BadgeUtils$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends AccessibilityDelegateCompat {
        final /* synthetic */ BadgeDrawable val$badgeDrawable;
        final /* synthetic */ View val$view;

        AnonymousClass3(View view, BadgeDrawable badgeDrawable) {
            this.val$view = view;
            this.val$badgeDrawable = badgeDrawable;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(BadgeUtils.access$100(this.val$view, this.val$badgeDrawable));
        }
    }

    /* renamed from: com.google.android.material.badge.BadgeUtils$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends AccessibilityDelegateCompat {
        final /* synthetic */ View val$view;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(View.AccessibilityDelegate accessibilityDelegate, View view) {
            super(accessibilityDelegate);
            this.val$view = view;
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(this.val$view.getContentDescription());
        }
    }

    private BadgeUtils() {
    }

    static /* synthetic */ void access$000(BadgeDrawable badgeDrawable, View view) {
        attachBadgeContentDescription(badgeDrawable, view);
    }

    static /* synthetic */ CharSequence access$100(View view, BadgeDrawable badgeDrawable) {
        return getBadgeAnchorContentDescription(view, badgeDrawable);
    }

    private static void attachBadgeContentDescription(BadgeDrawable badgeDrawable, View view) {
        if (Build.VERSION.SDK_INT < 29 || !ViewCompat.hasAccessibilityDelegate(view)) {
            ViewCompat.setAccessibilityDelegate(view, new AnonymousClass3(view, badgeDrawable));
        } else {
            ViewCompat.setAccessibilityDelegate(view, new AnonymousClass2(view.getAccessibilityDelegate(), view, badgeDrawable));
        }
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, View view) {
        attachBadgeDrawable(badgeDrawable, view, (FrameLayout) null);
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        setBadgeDrawableBounds(badgeDrawable, view, frameLayout);
        if (badgeDrawable.getCustomBadgeParent() != null) {
            badgeDrawable.getCustomBadgeParent().setForeground(badgeDrawable);
        } else {
            view.getOverlay().add(badgeDrawable);
        }
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, Toolbar toolbar, int i) {
        attachBadgeDrawable(badgeDrawable, toolbar, i, null);
    }

    public static void attachBadgeDrawable(BadgeDrawable badgeDrawable, Toolbar toolbar, int i, FrameLayout frameLayout) {
        toolbar.post(new AnonymousClass1(toolbar, i, badgeDrawable, frameLayout));
    }

    public static SparseArray<BadgeDrawable> createBadgeDrawablesFromSavedStates(Context context, ParcelableSparseArray parcelableSparseArray) {
        SparseArray<BadgeDrawable> sparseArray = new SparseArray<>(parcelableSparseArray.size());
        for (int i = 0; i < parcelableSparseArray.size(); i++) {
            int keyAt = parcelableSparseArray.keyAt(i);
            BadgeState.State state = (BadgeState.State) parcelableSparseArray.valueAt(i);
            BadgeDrawable badgeDrawable = null;
            if (state != null) {
                badgeDrawable = BadgeDrawable.createFromSavedState(context, state);
            }
            sparseArray.put(keyAt, badgeDrawable);
        }
        return sparseArray;
    }

    public static ParcelableSparseArray createParcelableBadgeStates(SparseArray<BadgeDrawable> sparseArray) {
        ParcelableSparseArray parcelableSparseArray = new ParcelableSparseArray();
        for (int i = 0; i < sparseArray.size(); i++) {
            int keyAt = sparseArray.keyAt(i);
            BadgeDrawable valueAt = sparseArray.valueAt(i);
            parcelableSparseArray.put(keyAt, valueAt != null ? valueAt.getSavedState() : null);
        }
        return parcelableSparseArray;
    }

    private static void detachBadgeContentDescription(View view) {
        if (Build.VERSION.SDK_INT < 29 || !ViewCompat.hasAccessibilityDelegate(view)) {
            ViewCompat.setAccessibilityDelegate(view, null);
        } else {
            ViewCompat.setAccessibilityDelegate(view, new AnonymousClass4(view.getAccessibilityDelegate(), view));
        }
    }

    public static void detachBadgeDrawable(BadgeDrawable badgeDrawable, View view) {
        if (badgeDrawable == null) {
            return;
        }
        if (badgeDrawable.getCustomBadgeParent() != null) {
            badgeDrawable.getCustomBadgeParent().setForeground(null);
        } else {
            view.getOverlay().remove(badgeDrawable);
        }
    }

    public static void detachBadgeDrawable(BadgeDrawable badgeDrawable, Toolbar toolbar, int i) {
        if (badgeDrawable == null) {
            return;
        }
        ActionMenuItemView actionMenuItemView = ToolbarUtils.getActionMenuItemView(toolbar, i);
        if (actionMenuItemView == null) {
            Log.w(LOG_TAG, "Trying to remove badge from a null menuItemView: " + i);
            return;
        }
        removeToolbarOffset(badgeDrawable);
        detachBadgeDrawable(badgeDrawable, actionMenuItemView);
        detachBadgeContentDescription(actionMenuItemView);
    }

    private static CharSequence getBadgeAnchorContentDescription(View view, BadgeDrawable badgeDrawable) {
        CharSequence contentDescription = badgeDrawable.getContentDescription();
        return contentDescription != null ? contentDescription : view.getContentDescription();
    }

    static void removeToolbarOffset(BadgeDrawable badgeDrawable) {
        badgeDrawable.setAdditionalHorizontalOffset(0);
        badgeDrawable.setAdditionalVerticalOffset(0);
    }

    public static void setBadgeDrawableBounds(BadgeDrawable badgeDrawable, View view, FrameLayout frameLayout) {
        Rect rect = new Rect();
        view.getDrawingRect(rect);
        badgeDrawable.setBounds(rect);
        badgeDrawable.updateBadgeCoordinates(view, frameLayout);
    }

    static void setToolbarOffset(BadgeDrawable badgeDrawable, Resources resources) {
        badgeDrawable.setAdditionalHorizontalOffset(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_horizontal_offset));
        badgeDrawable.setAdditionalVerticalOffset(resources.getDimensionPixelOffset(R.dimen.mtrl_badge_toolbar_action_menu_item_vertical_offset));
    }

    public static void updateBadgeBounds(Rect rect, float f, float f2, float f3, float f4) {
        rect.set((int) (f - f3), (int) (f2 - f4), (int) (f + f3), (int) (f2 + f4));
    }
}
