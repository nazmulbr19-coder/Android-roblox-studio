package com.google.android.material.listitem;

import android.R;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import androidx.core.view.GravityCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public class ListItemLayout extends FrameLayout {
    private static final int DEFAULT_SIGNIFICANT_VEL_THRESHOLD = 500;
    public static final int POSITION_FIRST = 0;
    public static final int POSITION_LAST = 2;
    public static final int POSITION_MIDDLE = 1;
    public static final int POSITION_SINGLE = 3;
    private static final int SETTLING_DURATION = 350;
    private RevealableListItem activeSwipeToRevealLayout;
    private View contentView;
    private GestureDetector gestureDetector;
    private int lastStableSwipeState;
    private boolean originalClipToPadding;
    private int originalContentViewLeft;
    private int[] positionState;
    private int revealViewOffset;
    private final StateSettlingTracker stateSettlingTracker;
    private View.AccessibilityDelegate swipeAccessibilityDelegate;
    private int swipeState;
    private View swipeToRevealLayoutLeft;
    private View swipeToRevealLayoutRight;
    private ViewDragHelper viewDragHelper;
    private static final int[] FIRST_STATE_SET = {R.attr.state_first};
    private static final int[] MIDDLE_STATE_SET = {R.attr.state_middle};
    private static final int[] LAST_STATE_SET = {R.attr.state_last};
    private static final int[] SINGLE_STATE_SET = {R.attr.state_single};
    private static final TimeInterpolator CUBIC_BEZIER_INTERPOLATOR = new PathInterpolator(0.42f, 1.67f, 0.21f, 0.9f);

    /* renamed from: com.google.android.material.listitem.ListItemLayout$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ViewDragHelper.Callback {
        AnonymousClass1() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        private int calculateMaxSwipeDistance(RevealableListItem revealableListItem) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) ((View) revealableListItem).getLayoutParams();
            if (revealableListItem.getPrimaryActionSwipeMode() == 0) {
                return revealableListItem.getIntrinsicWidth() + marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd();
            }
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) ListItemLayout.access$400(ListItemLayout.this).getLayoutParams();
            return ListItemLayout.access$400(ListItemLayout.this).getMeasuredWidth() + (ListItemUtils.isRightAligned((View) revealableListItem) ? marginLayoutParams2.leftMargin : marginLayoutParams2.rightMargin);
        }

        private int calculateTargetSwipeState(int i, RevealableListItem revealableListItem, float f, int i2) {
            if (ListItemLayout.access$1300(ListItemLayout.this, i)) {
                return calculateTargetSwipeStateForRevealLayout(i2, i == 3 ? f : -f, revealableListItem, ListItemLayout.access$1400(ListItemLayout.this, i), ListItemLayout.access$1500(ListItemLayout.this, i));
            }
            return 3;
        }

        private int calculateTargetSwipeStateForRevealLayout(int i, float f, RevealableListItem revealableListItem, int i2, int i3) {
            boolean z = revealableListItem.getPrimaryActionSwipeMode() != 0;
            boolean z2 = revealableListItem.getPrimaryActionSwipeMode() == 2;
            if (f > 500.0f) {
                if (z) {
                    return (ListItemLayout.access$1600(ListItemLayout.this) != 3 || z2) ? 5 : 4;
                }
                return 4;
            }
            if (f < -500.0f) {
                return (z2 || ListItemLayout.access$1600(ListItemLayout.this) != 5) ? 3 : 4;
            }
            if (z && Math.abs(i - i3) < Math.abs(i - i2)) {
                return 5;
            }
            if (Math.abs(i - ((z && z2) ? i3 : i2)) < Math.abs(i - ListItemLayout.access$1700(ListItemLayout.this))) {
                return (z && z2) ? 5 : 4;
            }
            return 3;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            if (!(ListItemLayout.access$400(ListItemLayout.this) instanceof SwipeableListItem) || !ListItemLayout.access$500(ListItemLayout.this)) {
                return 0;
            }
            SwipeableListItem swipeableListItem = (SwipeableListItem) ListItemLayout.access$400(ListItemLayout.this);
            int access$600 = ListItemLayout.access$600(ListItemLayout.this);
            int access$6002 = ListItemLayout.access$600(ListItemLayout.this);
            if (ListItemLayout.access$700(ListItemLayout.this) instanceof RevealableListItem) {
                access$600 = ListItemLayout.access$600(ListItemLayout.this) - (swipeableListItem.getSwipeMaxOvershoot() + calculateMaxSwipeDistance((RevealableListItem) ListItemLayout.access$700(ListItemLayout.this)));
            }
            if (ListItemLayout.access$800(ListItemLayout.this) instanceof RevealableListItem) {
                access$6002 = ListItemLayout.access$600(ListItemLayout.this) + swipeableListItem.getSwipeMaxOvershoot() + calculateMaxSwipeDistance((RevealableListItem) ListItemLayout.access$800(ListItemLayout.this));
            }
            return Math.max(access$600, Math.min(i, access$6002));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            if (!(ListItemLayout.access$400(ListItemLayout.this) instanceof SwipeableListItem)) {
                return 0;
            }
            SwipeableListItem swipeableListItem = (SwipeableListItem) ListItemLayout.access$400(ListItemLayout.this);
            int intrinsicWidth = ListItemLayout.access$800(ListItemLayout.this) instanceof RevealableListItem ? 0 + ((RevealableListItem) ListItemLayout.access$800(ListItemLayout.this)).getIntrinsicWidth() + swipeableListItem.getSwipeMaxOvershoot() : 0;
            return ListItemLayout.access$700(ListItemLayout.this) instanceof RevealableListItem ? intrinsicWidth + ((RevealableListItem) ListItemLayout.access$700(ListItemLayout.this)).getIntrinsicWidth() + swipeableListItem.getSwipeMaxOvershoot() : intrinsicWidth;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            if (ListItemLayout.access$100(ListItemLayout.this) != null && (ListItemLayout.access$400(ListItemLayout.this) instanceof SwipeableListItem) && ListItemLayout.access$500(ListItemLayout.this)) {
                super.onViewPositionChanged(view, i, i2, i3, i4);
                ListItemLayout.access$900(ListItemLayout.this, i);
                if (ListItemLayout.access$100(ListItemLayout.this).getViewDragState() != 1 || ListItemLayout.access$1000(ListItemLayout.this) == null) {
                    return;
                }
                ListItemLayout.access$300(ListItemLayout.this, 1, ListItemLayout.access$1100(ListItemLayout.this, (View) ListItemLayout.access$1000(ListItemLayout.this)));
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int left;
            if ((ListItemLayout.access$400(ListItemLayout.this) instanceof SwipeableListItem) && ListItemLayout.access$500(ListItemLayout.this) && (left = view.getLeft()) != ListItemLayout.access$600(ListItemLayout.this)) {
                int i = left > ListItemLayout.access$600(ListItemLayout.this) ? 3 : 5;
                RevealableListItem revealableListItem = i == 3 ? (RevealableListItem) ListItemLayout.access$800(ListItemLayout.this) : (RevealableListItem) ListItemLayout.access$700(ListItemLayout.this);
                if (revealableListItem == null) {
                    return;
                }
                ListItemLayout.access$1200(ListItemLayout.this, ListItemLayout.access$400(ListItemLayout.this), calculateTargetSwipeState(i, revealableListItem, f, left), i);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            if ((!(ListItemLayout.access$400(ListItemLayout.this) instanceof SwipeableListItem) || ((SwipeableListItem) ListItemLayout.access$400(ListItemLayout.this)).isSwipeEnabled()) && ListItemLayout.access$500(ListItemLayout.this) && ListItemLayout.access$400(ListItemLayout.this) != null) {
                ListItemLayout.access$100(ListItemLayout.this).captureChildView(ListItemLayout.access$400(ListItemLayout.this), i);
            }
            return false;
        }
    }

    /* renamed from: com.google.android.material.listitem.ListItemLayout$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends GestureDetector.SimpleOnGestureListener {
        AnonymousClass2() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (ListItemLayout.this.getParent() == null) {
                return false;
            }
            ListItemLayout.this.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    }

    /* renamed from: com.google.android.material.listitem.ListItemLayout$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends View.AccessibilityDelegate {
        AnonymousClass3() {
        }

        private void addSwipeAccessibilityActions(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                for (int i = 0; i < viewGroup.getChildCount(); i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (shouldAddAccessibilityAction(childAt)) {
                        accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(getAccessibilityActionId(childAt), childAt.getContentDescription()));
                    }
                }
            }
        }

        private int getAccessibilityActionId(View view) {
            return view.getId();
        }

        private boolean performRevealViewAction(View view, int i) {
            if (!(view instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                View childAt = viewGroup.getChildAt(i2);
                if (getAccessibilityActionId(childAt) == i) {
                    return childAt.performClick();
                }
            }
            return false;
        }

        private boolean shouldAddAccessibilityAction(View view) {
            return view.isClickable() && view.getContentDescription() != null && view.isEnabled() && view.getVisibility() == 0;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            AccessibilityNodeInfoCompat wrap = AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo);
            addSwipeAccessibilityActions(ListItemLayout.access$800(ListItemLayout.this), wrap);
            addSwipeAccessibilityActions(ListItemLayout.access$700(ListItemLayout.this), wrap);
        }

        @Override // android.view.View.AccessibilityDelegate
        public boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (performRevealViewAction(ListItemLayout.access$800(ListItemLayout.this), i) || performRevealViewAction(ListItemLayout.access$700(ListItemLayout.this), i)) {
                return true;
            }
            return super.performAccessibilityAction(view, i, bundle);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Position {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        private boolean isContinueSettlingRunnablePosted;
        private int targetRevealGravity;
        private int targetSwipeState;

        private StateSettlingTracker() {
            this.continueSettlingRunnable = new ListItemLayout$StateSettlingTracker$$ExternalSyntheticLambda0(this);
        }

        /* synthetic */ StateSettlingTracker(ListItemLayout listItemLayout, AnonymousClass1 anonymousClass1) {
            this();
        }

        static /* synthetic */ void access$1800(StateSettlingTracker stateSettlingTracker, int i, int i2) {
            stateSettlingTracker.continueSettlingToState(i, i2);
        }

        private void continueSettlingToState(int i, int i2) {
            this.targetSwipeState = i;
            this.targetRevealGravity = i2;
            if (this.isContinueSettlingRunnablePosted) {
                return;
            }
            ListItemLayout.this.post(this.continueSettlingRunnable);
            this.isContinueSettlingRunnablePosted = true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$new$0$com-google-android-material-listitem-ListItemLayout$StateSettlingTracker, reason: not valid java name */
        public /* synthetic */ void m388x75cf24c1() {
            this.isContinueSettlingRunnablePosted = false;
            if (ListItemLayout.access$100(ListItemLayout.this) != null && ListItemLayout.access$100(ListItemLayout.this).continueSettling(true)) {
                continueSettlingToState(this.targetSwipeState, this.targetRevealGravity);
            } else if (ListItemLayout.access$200(ListItemLayout.this) == 2) {
                ListItemLayout.access$300(ListItemLayout.this, this.targetSwipeState, this.targetRevealGravity);
            }
        }
    }

    public ListItemLayout(Context context) {
        this(context, null);
    }

    public ListItemLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R.attr.listItemLayoutStyle);
    }

    public ListItemLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, com.google.android.material.R.style.Widget_Material3_ListItemLayout);
    }

    public ListItemLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.swipeState = 3;
        this.lastStableSwipeState = 3;
        this.stateSettlingTracker = new StateSettlingTracker(this, null);
        getContext();
    }

    static /* synthetic */ ViewDragHelper access$100(ListItemLayout listItemLayout) {
        return listItemLayout.viewDragHelper;
    }

    static /* synthetic */ RevealableListItem access$1000(ListItemLayout listItemLayout) {
        return listItemLayout.activeSwipeToRevealLayout;
    }

    static /* synthetic */ int access$1100(ListItemLayout listItemLayout, View view) {
        return listItemLayout.getAbsoluteRevealGravity(view);
    }

    static /* synthetic */ void access$1200(ListItemLayout listItemLayout, View view, int i, int i2) {
        listItemLayout.startSettling(view, i, i2);
    }

    static /* synthetic */ boolean access$1300(ListItemLayout listItemLayout, int i) {
        return listItemLayout.swipeToRevealLayoutExistsForGravity(i);
    }

    static /* synthetic */ int access$1400(ListItemLayout listItemLayout, int i) {
        return listItemLayout.getSwipeRevealViewRevealedOffset(i);
    }

    static /* synthetic */ int access$1500(ListItemLayout listItemLayout, int i) {
        return listItemLayout.getSwipeToActionOffset(i);
    }

    static /* synthetic */ int access$1600(ListItemLayout listItemLayout) {
        return listItemLayout.lastStableSwipeState;
    }

    static /* synthetic */ int access$1700(ListItemLayout listItemLayout) {
        return listItemLayout.getSwipeViewClosedOffset();
    }

    static /* synthetic */ int access$200(ListItemLayout listItemLayout) {
        return listItemLayout.swipeState;
    }

    static /* synthetic */ void access$300(ListItemLayout listItemLayout, int i, int i2) {
        listItemLayout.setSwipeStateInternal(i, i2);
    }

    static /* synthetic */ View access$400(ListItemLayout listItemLayout) {
        return listItemLayout.contentView;
    }

    static /* synthetic */ boolean access$500(ListItemLayout listItemLayout) {
        return listItemLayout.swipeToRevealLayoutExists();
    }

    static /* synthetic */ int access$600(ListItemLayout listItemLayout) {
        return listItemLayout.originalContentViewLeft;
    }

    static /* synthetic */ View access$700(ListItemLayout listItemLayout) {
        return listItemLayout.swipeToRevealLayoutRight;
    }

    static /* synthetic */ View access$800(ListItemLayout listItemLayout) {
        return listItemLayout.swipeToRevealLayoutLeft;
    }

    static /* synthetic */ void access$900(ListItemLayout listItemLayout, int i) {
        listItemLayout.updateSwipeProgress(i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T extends View & RevealableListItem> T castToView(RevealableListItem revealableListItem) {
        return (T) ((View) revealableListItem);
    }

    private GestureDetector createGestureDetector() {
        return new GestureDetector(getContext(), new AnonymousClass2());
    }

    private View.AccessibilityDelegate createSwipeAccessibilityDelegate() {
        return new AnonymousClass3();
    }

    private ViewDragHelper createViewDragHelper() {
        return ViewDragHelper.create(this, new AnonymousClass1());
    }

    private boolean ensureSwipeToRevealSetupIfNeeded() {
        if (!swipeToRevealLayoutExists() || this.contentView == null) {
            return false;
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = createViewDragHelper();
        }
        if (this.gestureDetector == null) {
            this.gestureDetector = createGestureDetector();
        }
        if (this.swipeAccessibilityDelegate == null) {
            this.swipeAccessibilityDelegate = createSwipeAccessibilityDelegate();
            this.contentView.setAccessibilityDelegate(this.swipeAccessibilityDelegate);
        }
        if (!getClipToPadding()) {
            return true;
        }
        this.originalClipToPadding = getClipToPadding();
        setClipToPadding(false);
        return true;
    }

    private int getAbsoluteHorizontalGravity(int i) {
        int absoluteGravity = GravityCompat.getAbsoluteGravity(i, getLayoutDirection()) & 7;
        if (absoluteGravity == 3) {
            return 3;
        }
        return (absoluteGravity != 5 && getLayoutDirection() == 1) ? 3 : 5;
    }

    private int getAbsoluteRevealGravity(View view) {
        return ListItemUtils.isRightAligned(view) ? 5 : 3;
    }

    private int getOffsetForSwipeState(int i, int i2) {
        if (!swipeToRevealLayoutExistsForGravity(i2)) {
            throw new IllegalArgumentException("No RevealableListItem with gravity " + i2);
        }
        switch (i) {
            case 3:
                return getSwipeViewClosedOffset();
            case 4:
                return getSwipeRevealViewRevealedOffset(i2);
            case 5:
                return getSwipeToActionOffset(i2);
            default:
                throw new IllegalArgumentException("Invalid state to get swipe offset: " + i);
        }
    }

    private int getSwipeRevealViewRevealedOffset(int i) {
        View view = isRevealGravityLeft(i) ? this.swipeToRevealLayoutLeft : this.swipeToRevealLayoutRight;
        if (view == null) {
            return 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return this.originalContentViewLeft + ((isRevealGravityLeft(i) ? 1 : -1) * (((RevealableListItem) view).getIntrinsicWidth() + layoutParams.leftMargin + layoutParams.rightMargin));
    }

    private int getSwipeToActionOffset(int i) {
        if (this.contentView == null) {
            return 0;
        }
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.contentView.getLayoutParams();
        return this.originalContentViewLeft + ((isRevealGravityLeft(i) ? 1 : -1) * (this.contentView.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin));
    }

    private int getSwipeViewClosedOffset() {
        return this.originalContentViewLeft;
    }

    private boolean isRevealGravityLeft(int i) {
        return getAbsoluteHorizontalGravity(i) == 3;
    }

    private void layoutRevealView(View view, int i, int i2) {
        int i3;
        int measuredWidth;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        if (ListItemUtils.isRightAligned(view)) {
            measuredWidth = i2 - layoutParams.rightMargin;
            i3 = measuredWidth - view.getMeasuredWidth();
        } else {
            i3 = i + layoutParams.leftMargin;
            measuredWidth = view.getMeasuredWidth() + i3;
        }
        view.layout(i3, view.getTop(), measuredWidth, view.getBottom());
    }

    private void maybeSwapRevealLayoutsForGravity() {
        boolean z = this.swipeToRevealLayoutLeft != null && ListItemUtils.isRightAligned(this.swipeToRevealLayoutLeft);
        boolean z2 = (this.swipeToRevealLayoutRight == null || ListItemUtils.isRightAligned(this.swipeToRevealLayoutRight)) ? false : true;
        if (z && z2) {
            View view = this.swipeToRevealLayoutLeft;
            this.swipeToRevealLayoutLeft = this.swipeToRevealLayoutRight;
            this.swipeToRevealLayoutRight = view;
            this.revealViewOffset *= -1;
            return;
        }
        if (z) {
            if (this.swipeToRevealLayoutRight != null) {
                throw new IllegalStateException("Cannot have more than one RevealableListItem with the same absolute gravity.");
            }
            this.swipeToRevealLayoutRight = this.swipeToRevealLayoutLeft;
            this.swipeToRevealLayoutLeft = null;
            this.revealViewOffset *= -1;
            return;
        }
        if (z2) {
            if (this.swipeToRevealLayoutLeft != null) {
                throw new IllegalStateException("Cannot have more than one RevealableListItem with the same absolute gravity.");
            }
            this.swipeToRevealLayoutLeft = this.swipeToRevealLayoutRight;
            this.swipeToRevealLayoutRight = null;
            this.revealViewOffset *= -1;
        }
    }

    private void setSwipeStateInternal(int i, int i2) {
        int absoluteHorizontalGravity = getAbsoluteHorizontalGravity(i2);
        if (i == this.swipeState && (this.activeSwipeToRevealLayout == null || getAbsoluteRevealGravity((View) this.activeSwipeToRevealLayout) == absoluteHorizontalGravity)) {
            return;
        }
        if (i == 3 || swipeToRevealLayoutExistsForGravity(absoluteHorizontalGravity)) {
            if (i == 5 && (this.activeSwipeToRevealLayout == null || this.activeSwipeToRevealLayout.getPrimaryActionSwipeMode() == 0)) {
                return;
            }
            this.activeSwipeToRevealLayout = isRevealGravityLeft(absoluteHorizontalGravity) ? (RevealableListItem) this.swipeToRevealLayoutLeft : (RevealableListItem) this.swipeToRevealLayoutRight;
            this.swipeState = i;
            if (i != 1 && i != 2) {
                this.lastStableSwipeState = i;
            }
            int i3 = absoluteHorizontalGravity;
            if (this.activeSwipeToRevealLayout != null) {
                i3 = ((FrameLayout.LayoutParams) ((View) this.activeSwipeToRevealLayout).getLayoutParams()).gravity;
            }
            ((SwipeableListItem) this.contentView).onSwipeStateChanged(i, castToView(this.activeSwipeToRevealLayout), i3 == -1 ? GravityCompat.END : i3);
        }
    }

    private void startSettling(View view, int i, int i2) {
        if (this.viewDragHelper == null) {
            return;
        }
        int offsetForSwipeState = getOffsetForSwipeState(i, i2);
        if (!(i == 4 ? this.viewDragHelper.smoothSlideViewTo(view, offsetForSwipeState, view.getTop(), SETTLING_DURATION, (Interpolator) CUBIC_BEZIER_INTERPOLATOR) : this.viewDragHelper.smoothSlideViewTo(view, offsetForSwipeState, view.getTop()))) {
            setSwipeStateInternal(i, i2);
        } else {
            setSwipeStateInternal(2, i2);
            StateSettlingTracker.access$1800(this.stateSettlingTracker, i, i2);
        }
    }

    private boolean swipeToRevealLayoutExists() {
        return (this.swipeToRevealLayoutLeft instanceof RevealableListItem) || (this.swipeToRevealLayoutRight instanceof RevealableListItem);
    }

    private boolean swipeToRevealLayoutExistsForGravity(int i) {
        maybeSwapRevealLayoutsForGravity();
        return isRevealGravityLeft(i) ? this.swipeToRevealLayoutLeft instanceof RevealableListItem : this.swipeToRevealLayoutRight instanceof RevealableListItem;
    }

    private void updateAlphaFade(int i, int i2) {
        int swipeViewClosedOffset = i2 == i ? (getSwipeViewClosedOffset() + i) / 2 : (i + i2) / 2;
        this.contentView.setAlpha(AnimationUtils.lerp(1.0f, 0.0f, (this.revealViewOffset - swipeViewClosedOffset) / (i - swipeViewClosedOffset)));
    }

    private void updateSwipeProgress(int i) {
        if ((this.contentView instanceof SwipeableListItem) && swipeToRevealLayoutExists()) {
            this.revealViewOffset = i - this.originalContentViewLeft;
            boolean z = this.revealViewOffset > 0;
            boolean z2 = this.revealViewOffset < 0;
            if (z && (this.swipeToRevealLayoutLeft instanceof RevealableListItem)) {
                this.activeSwipeToRevealLayout = (RevealableListItem) this.swipeToRevealLayoutLeft;
            } else if (z2 && (this.swipeToRevealLayoutRight instanceof RevealableListItem)) {
                this.activeSwipeToRevealLayout = (RevealableListItem) this.swipeToRevealLayoutRight;
            }
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.contentView.getLayoutParams();
            if (this.swipeToRevealLayoutLeft instanceof RevealableListItem) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.swipeToRevealLayoutLeft.getLayoutParams();
                ((RevealableListItem) this.swipeToRevealLayoutLeft).setRevealedWidth(z ? Math.max(0, ((Math.abs(this.originalContentViewLeft - this.contentView.getLeft()) - layoutParams.leftMargin) - layoutParams2.getMarginStart()) - layoutParams2.getMarginEnd()) : 0);
            }
            if (this.swipeToRevealLayoutRight instanceof RevealableListItem) {
                FrameLayout.LayoutParams layoutParams3 = (FrameLayout.LayoutParams) this.swipeToRevealLayoutRight.getLayoutParams();
                ((RevealableListItem) this.swipeToRevealLayoutRight).setRevealedWidth(z2 ? Math.max(0, ((Math.abs(this.originalContentViewLeft - this.contentView.getLeft()) - layoutParams.rightMargin) - layoutParams3.getMarginStart()) - layoutParams3.getMarginEnd()) : 0);
            }
            ((SwipeableListItem) this.contentView).onSwipe(this.revealViewOffset);
            if (z2 && (this.swipeToRevealLayoutRight instanceof RevealableListItem)) {
                updateAlphaFade(getSwipeToActionOffset(5), getSwipeRevealViewRevealedOffset(5));
            } else if (z && (this.swipeToRevealLayoutLeft instanceof RevealableListItem)) {
                updateAlphaFade(getSwipeToActionOffset(3), getSwipeRevealViewRevealedOffset(3));
            } else {
                this.contentView.setAlpha(1.0f);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        if (!(view instanceof RevealableListItem)) {
            if (this.contentView != null && (view instanceof SwipeableListItem)) {
                throw new UnsupportedOperationException("Only one SwipeableListItem view is allowed in a ListItemLayout.");
            }
            if (view instanceof SwipeableListItem) {
                this.contentView = view;
                return;
            }
            return;
        }
        if (ListItemUtils.isRightAligned(view)) {
            if (this.swipeToRevealLayoutRight != null) {
                throw new UnsupportedOperationException("Only one RevealableListItem with end gravity is supported.");
            }
            this.swipeToRevealLayoutRight = view;
        } else {
            if (this.swipeToRevealLayoutLeft != null) {
                throw new UnsupportedOperationException("Only one RevealableListItem with start gravity is supported.");
            }
            this.swipeToRevealLayoutLeft = view;
        }
        ((RevealableListItem) view).setRevealedWidth(0);
        view.setElevation(getElevation() - 1.0f);
    }

    public int getSwipeState() {
        return this.swipeState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setSwipeState$0$com-google-android-material-listitem-ListItemLayout, reason: not valid java name */
    public /* synthetic */ void m387x6b76121b(boolean z, int i, int i2) {
        if (z) {
            startSettling(this.contentView, i, i2);
            return;
        }
        if (this.viewDragHelper != null) {
            this.viewDragHelper.abort();
        }
        int offsetForSwipeState = getOffsetForSwipeState(i, i2);
        this.contentView.offsetLeftAndRight(offsetForSwipeState - this.contentView.getLeft());
        updateSwipeProgress(offsetForSwipeState);
        setSwipeStateInternal(i, i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected int[] onCreateDrawableState(int i) {
        return this.positionState == null ? super.onCreateDrawableState(i) : mergeDrawableStates(super.onCreateDrawableState(i + 1), this.positionState);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!ensureSwipeToRevealSetupIfNeeded()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 3 || actionMasked == 1) {
            this.viewDragHelper.cancel();
            return false;
        }
        this.gestureDetector.onTouchEvent(motionEvent);
        return this.viewDragHelper.shouldInterceptTouchEvent(motionEvent);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        maybeSwapRevealLayoutsForGravity();
        if (this.contentView != null && swipeToRevealLayoutExists() && ensureSwipeToRevealSetupIfNeeded()) {
            this.originalContentViewLeft = this.contentView.getLeft();
            int right = this.contentView.getRight();
            this.contentView.offsetLeftAndRight(this.revealViewOffset);
            if (this.swipeToRevealLayoutLeft != null) {
                layoutRevealView(this.swipeToRevealLayoutLeft, this.originalContentViewLeft, right);
            }
            if (this.swipeToRevealLayoutRight != null) {
                layoutRevealView(this.swipeToRevealLayoutRight, this.originalContentViewLeft, right);
            }
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (ensureSwipeToRevealSetupIfNeeded()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
            this.gestureDetector.onTouchEvent(motionEvent);
            if (this.viewDragHelper.getViewDragState() == 1) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view == this.swipeToRevealLayoutLeft) {
            this.swipeToRevealLayoutLeft = null;
        } else if (view == this.swipeToRevealLayoutRight) {
            this.swipeToRevealLayoutRight = null;
        } else if (this.contentView == view) {
            this.contentView = null;
        }
        if (!swipeToRevealLayoutExists() || this.contentView == null) {
            this.viewDragHelper = null;
            this.gestureDetector = null;
            this.swipeAccessibilityDelegate = null;
            setClipToPadding(this.originalClipToPadding);
        }
    }

    public void setSwipeState(int i, int i2) {
        setSwipeState(i, i2, true);
    }

    public void setSwipeState(int i, int i2, boolean z) {
        if (i != 3 && i != 4 && i != 5) {
            throw new IllegalArgumentException("Invalid swipe state: " + i);
        }
        if (!(this.contentView instanceof SwipeableListItem) || !swipeToRevealLayoutExists()) {
            throw new IllegalArgumentException("ListItemLayout must have a SwipeableListItem child and a RevealableListItem child to be swiped.");
        }
        if (i != 3 && !swipeToRevealLayoutExistsForGravity(i2)) {
            throw new IllegalArgumentException("No RevealableListItem is defined for the given gravity: " + i2);
        }
        ListItemLayout$$ExternalSyntheticLambda0 listItemLayout$$ExternalSyntheticLambda0 = new ListItemLayout$$ExternalSyntheticLambda0(this, z, i, i2);
        if (isLaidOut()) {
            listItemLayout$$ExternalSyntheticLambda0.run();
        } else {
            post(listItemLayout$$ExternalSyntheticLambda0);
        }
    }

    public <T extends View & RevealableListItem> void setSwipeState(int i, T t) {
        setSwipeState(i, (int) t, true);
    }

    public <T extends View & RevealableListItem> void setSwipeState(int i, T t, boolean z) {
        if (t != this.swipeToRevealLayoutLeft && t != this.swipeToRevealLayoutRight) {
            throw new IllegalArgumentException("revealView must be a child of ListItemLayout.");
        }
        setSwipeState(i, ((FrameLayout.LayoutParams) t.getLayoutParams()).gravity, z);
    }

    public void updateAppearance(int i) {
        switch (i) {
            case 0:
                this.positionState = FIRST_STATE_SET;
                break;
            case 1:
                this.positionState = MIDDLE_STATE_SET;
                break;
            case 2:
                this.positionState = LAST_STATE_SET;
                break;
            case 3:
                this.positionState = SINGLE_STATE_SET;
                break;
        }
        refreshDrawableState();
    }

    public void updateAppearance(int i, int i2) {
        if (i < 0 || i2 < 0) {
            this.positionState = null;
        } else if (i2 == 1) {
            this.positionState = SINGLE_STATE_SET;
        } else if (i == 0) {
            this.positionState = FIRST_STATE_SET;
        } else if (i == i2 - 1) {
            this.positionState = LAST_STATE_SET;
        } else {
            this.positionState = MIDDLE_STATE_SET;
        }
        refreshDrawableState();
    }
}
