package com.google.android.material.bottomsheet;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes.dex */
public class BottomSheetDragHandleView extends AppCompatImageView implements AccessibilityManager.AccessibilityStateChangeListener {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_BottomSheet_DragHandle;
    private final AccessibilityManager accessibilityManager;
    private BottomSheetBehavior<?> bottomSheetBehavior;
    private final BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    private final String clickToCollapseActionLabel;
    private boolean clickToExpand;
    private final String clickToExpandActionLabel;
    private final String clickToHalfExpandActionLabel;
    private final GestureDetector gestureDetector;
    private final GestureDetector.OnGestureListener gestureListener;
    private boolean hasClickListener;
    private boolean hasTouchListener;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDragHandleView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends BottomSheetBehavior.BottomSheetCallback {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onSlide(View view, float f) {
        }

        @Override // com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
        public void onStateChanged(View view, int i) {
            BottomSheetDragHandleView.access$000(BottomSheetDragHandleView.this, i);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDragHandleView$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends GestureDetector.SimpleOnGestureListener {
        AnonymousClass2() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            if (BottomSheetDragHandleView.access$200(BottomSheetDragHandleView.this) == null || !BottomSheetDragHandleView.access$200(BottomSheetDragHandleView.this).isHideable()) {
                return super.onDoubleTap(motionEvent);
            }
            BottomSheetDragHandleView.access$200(BottomSheetDragHandleView.this).setState(5);
            return true;
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            return BottomSheetDragHandleView.this.isClickable();
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            int i = Build.VERSION.SDK_INT;
            BottomSheetDragHandleView.this.performLongClick(motionEvent.getX(), motionEvent.getY());
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            return BottomSheetDragHandleView.access$100(BottomSheetDragHandleView.this);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetDragHandleView$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends AccessibilityDelegateCompat {
        AnonymousClass3() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            if (BottomSheetDragHandleView.access$300(BottomSheetDragHandleView.this)) {
                CharSequence contentDescription = BottomSheetDragHandleView.this.getContentDescription();
                String str = null;
                switch (BottomSheetDragHandleView.access$200(BottomSheetDragHandleView.this).getState()) {
                    case 3:
                        str = BottomSheetDragHandleView.this.getResources().getString(R.string.bottomsheet_state_expanded);
                        break;
                    case 4:
                        str = BottomSheetDragHandleView.this.getResources().getString(R.string.bottomsheet_state_collapsed);
                        break;
                    case 6:
                        str = BottomSheetDragHandleView.this.getResources().getString(R.string.bottomsheet_state_half_expanded);
                        break;
                }
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                accessibilityNodeInfoCompat.setContentDescription(TextUtils.isEmpty(contentDescription) ? str : str + ". " + ((Object) contentDescription));
            }
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            super.onPopulateAccessibilityEvent(view, accessibilityEvent);
            if (accessibilityEvent.getEventType() == 1) {
                BottomSheetDragHandleView.access$100(BottomSheetDragHandleView.this);
            }
        }
    }

    public BottomSheetDragHandleView(Context context) {
        this(context, null);
    }

    public BottomSheetDragHandleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomSheetDragHandleStyle);
    }

    public BottomSheetDragHandleView(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.hasTouchListener = false;
        this.hasClickListener = false;
        this.clickToExpandActionLabel = getResources().getString(R.string.bottomsheet_action_expand_description);
        this.clickToHalfExpandActionLabel = getResources().getString(R.string.bottomsheet_action_half_expand_description);
        this.clickToCollapseActionLabel = getResources().getString(R.string.bottomsheet_action_collapse_description);
        this.bottomSheetCallback = new AnonymousClass1();
        this.gestureListener = new AnonymousClass2();
        Context context2 = getContext();
        if (Build.VERSION.SDK_INT >= 26) {
            setTooltipText(getResources().getString(R.string.bottomsheet_drag_handle_content_description));
        }
        this.gestureDetector = new GestureDetector(context2, this.gestureListener, new Handler(Looper.getMainLooper()));
        this.accessibilityManager = (AccessibilityManager) context2.getSystemService("accessibility");
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass3());
    }

    static /* synthetic */ void access$000(BottomSheetDragHandleView bottomSheetDragHandleView, int i) {
        bottomSheetDragHandleView.onBottomSheetStateChanged(i);
    }

    static /* synthetic */ boolean access$100(BottomSheetDragHandleView bottomSheetDragHandleView) {
        return bottomSheetDragHandleView.expandOrCollapseBottomSheetIfPossible();
    }

    static /* synthetic */ BottomSheetBehavior access$200(BottomSheetDragHandleView bottomSheetDragHandleView) {
        return bottomSheetDragHandleView.bottomSheetBehavior;
    }

    static /* synthetic */ boolean access$300(BottomSheetDragHandleView bottomSheetDragHandleView) {
        return bottomSheetDragHandleView.hasAttachedBehavior();
    }

    private boolean expandOrCollapseBottomSheetIfPossible() {
        if (!hasAttachedBehavior()) {
            return false;
        }
        int nextState = getNextState();
        if (nextState == -1) {
            return true;
        }
        this.bottomSheetBehavior.setState(nextState);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v0, types: [android.view.View] */
    private BottomSheetBehavior<?> findParentBottomSheetBehavior() {
        BottomSheetDragHandleView bottomSheetDragHandleView = this;
        while (true) {
            ?? parentView = getParentView(bottomSheetDragHandleView);
            bottomSheetDragHandleView = parentView;
            if (parentView == 0) {
                return null;
            }
            ViewGroup.LayoutParams layoutParams = bottomSheetDragHandleView.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
                if (behavior instanceof BottomSheetBehavior) {
                    return (BottomSheetBehavior) behavior;
                }
            }
        }
    }

    private int getNextState() {
        if (!hasAttachedBehavior()) {
            return -1;
        }
        boolean z = (this.bottomSheetBehavior.isFitToContents() || this.bottomSheetBehavior.shouldSkipHalfExpandedStateWhenDragging()) ? false : true;
        switch (this.bottomSheetBehavior.getState()) {
            case 3:
                if (z) {
                    return 6;
                }
                return this.bottomSheetBehavior.canCollapse() ? 4 : -1;
            case 4:
                return z ? 6 : 3;
            case 5:
            default:
                return -1;
            case 6:
                if (this.clickToExpand) {
                    return 3;
                }
                return this.bottomSheetBehavior.canCollapse() ? 4 : -1;
        }
    }

    private static View getParentView(View view) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            return (View) parent;
        }
        return null;
    }

    private boolean hasAttachedBehavior() {
        return this.bottomSheetBehavior != null;
    }

    private void onBottomSheetStateChanged(int i) {
        if (i == 4) {
            this.clickToExpand = true;
        } else if (i == 3) {
            this.clickToExpand = false;
        }
        String str = null;
        switch (getNextState()) {
            case 3:
                str = this.clickToExpandActionLabel;
                break;
            case 4:
                str = this.clickToCollapseActionLabel;
                break;
            case 6:
                str = this.clickToHalfExpandActionLabel;
                break;
        }
        ViewCompat.replaceAccessibilityAction(this, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLICK, str, new BottomSheetDragHandleView$$ExternalSyntheticLambda0(this));
    }

    private void setBottomSheetBehavior(BottomSheetBehavior<?> bottomSheetBehavior) {
        if (this.bottomSheetBehavior != null) {
            this.bottomSheetBehavior.removeBottomSheetCallback(this.bottomSheetCallback);
            this.bottomSheetBehavior.setAccessibilityDelegateView(null);
            this.bottomSheetBehavior.setDragHandleView(null);
        }
        this.bottomSheetBehavior = bottomSheetBehavior;
        if (this.bottomSheetBehavior != null) {
            this.bottomSheetBehavior.setAccessibilityDelegateView(this);
            this.bottomSheetBehavior.setDragHandleView(this);
            onBottomSheetStateChanged(this.bottomSheetBehavior.getState());
            this.bottomSheetBehavior.addBottomSheetCallback(this.bottomSheetCallback);
        }
        setClickable(hasAttachedBehavior());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onBottomSheetStateChanged$0$com-google-android-material-bottomsheet-BottomSheetDragHandleView, reason: not valid java name */
    public /* synthetic */ boolean m321xa7b4c95f(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        return expandOrCollapseBottomSheetIfPossible();
    }

    @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
    public void onAccessibilityStateChanged(boolean z) {
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        setBottomSheetBehavior(findParentBottomSheetBehavior());
        if (this.accessibilityManager != null) {
            this.accessibilityManager.addAccessibilityStateChangeListener(this);
            onAccessibilityStateChanged(this.accessibilityManager.isEnabled());
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        if (this.accessibilityManager != null) {
            this.accessibilityManager.removeAccessibilityStateChangeListener(this);
        }
        setBottomSheetBehavior(null);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        switch (i) {
            case 23:
            case 66:
                return this.hasClickListener ? performClick() : expandOrCollapseBottomSheetIfPossible();
            default:
                return super.onKeyDown(i, keyEvent);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return (this.hasClickListener || this.hasTouchListener) ? super.onTouchEvent(motionEvent) : this.gestureDetector.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.hasClickListener = onClickListener != null;
        super.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.hasTouchListener = onTouchListener != null;
        super.setOnTouchListener(onTouchListener);
    }
}
