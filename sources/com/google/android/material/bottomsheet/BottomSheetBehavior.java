package com.google.android.material.bottomsheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.RoundedCorner;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowInsets;
import androidx.activity.BackEventCompat;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.core.view.insets.GradientProtection;
import androidx.core.view.insets.Protection;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBottomContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class BottomSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements MaterialBackHandler {
    private static final int CORNER_ANIMATION_DURATION = 500;
    static final int DEFAULT_SIGNIFICANT_VEL_THRESHOLD = 500;
    private static final int DEF_STYLE_RES = R.style.Widget_Design_BottomSheet_Modal;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int INVALID_POSITION = -1;
    private static final int NO_MAX_SIZE = -1;
    public static final int PEEK_HEIGHT_AUTO = -1;
    public static final int SAVE_ALL = -1;
    public static final int SAVE_FIT_TO_CONTENTS = 2;
    public static final int SAVE_HIDEABLE = 4;
    public static final int SAVE_NONE = 0;
    public static final int SAVE_PEEK_HEIGHT = 1;
    public static final int SAVE_SKIP_COLLAPSED = 8;
    public static final int STATE_COLLAPSED = 4;
    public static final int STATE_DRAGGING = 1;
    public static final int STATE_EXPANDED = 3;
    public static final int STATE_HALF_EXPANDED = 6;
    public static final int STATE_HIDDEN = 5;
    public static final int STATE_SETTLING = 2;
    private static final String TAG = "BottomSheetBehavior";
    static final int VIEW_INDEX_ACCESSIBILITY_DELEGATE_VIEW = 1;
    static final int VIEW_INDEX_BOTTOM_SHEET = 0;
    WeakReference<View> accessibilityDelegateViewRef;
    int activePointerId;
    private boolean autoExpandOnRequestChildRectangleOffscreen;
    private ColorStateList backgroundTint;
    MaterialBottomContainerBackHelper bottomContainerBackHelper;
    private final ArrayList<BottomSheetCallback> callbacks;
    private int childHeight;
    final SparseIntArray collapseActionIds;
    int collapsedOffset;
    private WeakReference<View> currentTouchedScrollChildRef;
    private final ViewDragHelper.Callback dragCallback;
    WeakReference<View> dragHandleViewRef;
    private boolean draggable;
    private boolean draggableOnNestedScroll;
    private boolean draggableOnNestedScrollLastDragIgnored;
    float elevation;
    final SparseIntArray expandActionIds;
    final SparseIntArray expandHalfwayActionIds;
    private boolean expandedCornersRemoved;
    int expandedOffset;
    private boolean fitToContents;
    int fitToContentsOffset;
    private int gestureInsetBottom;
    private boolean gestureInsetBottomIgnored;
    int halfExpandedOffset;
    float halfExpandedRatio;
    private float hideFriction;
    boolean hideable;
    private boolean ignoreEvents;
    private Map<View, Integer> importantForAccessibilityMap;
    private int initialY;
    private int insetBottom;
    private int insetTop;
    private ValueAnimator interpolatorAnimator;
    private int lastNestedScrollDy;
    int lastStableState;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private MaterialShapeDrawable materialShapeDrawable;
    private int maxHeight;
    private int maxWidth;
    private float maximumVelocity;
    private boolean multipleScrollingChildrenSupported;
    private boolean nestedScrolled;
    final List<WeakReference<View>> nestedScrollingChildrenRef;
    private boolean paddingBottomSystemWindowInsets;
    private boolean paddingLeftSystemWindowInsets;
    private boolean paddingRightSystemWindowInsets;
    private boolean paddingTopSystemWindowInsets;
    int parentHeight;
    int parentWidth;
    private int peekHeight;
    private boolean peekHeightAuto;
    private int peekHeightGestureInsetBuffer;
    private int peekHeightMin;
    private int saveFlags;
    private ShapeAppearanceModel shapeAppearanceModelDefault;
    private final Rect sheetRect;
    private boolean shouldRemoveExpandedCorners;
    private int significantVelocityThreshold;
    private boolean skipCollapsed;
    int state;
    private final BottomSheetBehavior<V>.StateSettlingTracker stateSettlingTracker;
    boolean touchingScrollingChild;
    private boolean updateImportantForAccessibilityOnSiblings;
    private VelocityTracker velocityTracker;
    ViewDragHelper viewDragHelper;
    WeakReference<V> viewRef;

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ View val$child;
        final /* synthetic */ int val$finalState;

        AnonymousClass1(View view, int i) {
            this.val$child = view;
            this.val$finalState = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            BottomSheetBehavior.access$100(BottomSheetBehavior.this, this.val$child, this.val$finalState, false);
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomSheetBehavior.this.setStateInternal(5);
            if (BottomSheetBehavior.this.viewRef == null || BottomSheetBehavior.this.viewRef.get() == null) {
                return;
            }
            BottomSheetBehavior.this.viewRef.get().requestLayout();
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements ValueAnimator.AnimatorUpdateListener {
        AnonymousClass3() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (BottomSheetBehavior.access$200(BottomSheetBehavior.this) != null) {
                BottomSheetBehavior.access$200(BottomSheetBehavior.this).setInterpolation(floatValue);
            }
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 implements ViewUtils.OnApplyWindowInsetsListener {
        final /* synthetic */ boolean val$shouldHandleGestureInsets;

        AnonymousClass4(boolean z) {
            this.val$shouldHandleGestureInsets = z;
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars());
            Insets insets2 = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.mandatorySystemGestures());
            BottomSheetBehavior.access$302(BottomSheetBehavior.this, insets.top);
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(view);
            int paddingBottom = view.getPaddingBottom();
            int paddingLeft = view.getPaddingLeft();
            int paddingRight = view.getPaddingRight();
            if (BottomSheetBehavior.access$400(BottomSheetBehavior.this)) {
                BottomSheetBehavior.access$502(BottomSheetBehavior.this, windowInsetsCompat.getSystemWindowInsetBottom());
                paddingBottom = relativePadding.bottom + BottomSheetBehavior.access$500(BottomSheetBehavior.this);
            }
            if (BottomSheetBehavior.access$600(BottomSheetBehavior.this)) {
                paddingLeft = insets.left + (isLayoutRtl ? relativePadding.end : relativePadding.start);
            }
            if (BottomSheetBehavior.access$700(BottomSheetBehavior.this)) {
                paddingRight = insets.right + (isLayoutRtl ? relativePadding.start : relativePadding.end);
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
            boolean z = false;
            if (BottomSheetBehavior.access$800(BottomSheetBehavior.this) && marginLayoutParams.leftMargin != insets.left) {
                marginLayoutParams.leftMargin = insets.left;
                z = true;
            }
            if (BottomSheetBehavior.access$900(BottomSheetBehavior.this) && marginLayoutParams.rightMargin != insets.right) {
                marginLayoutParams.rightMargin = insets.right;
                z = true;
            }
            if (BottomSheetBehavior.access$1000(BottomSheetBehavior.this) && marginLayoutParams.topMargin != insets.top) {
                marginLayoutParams.topMargin = insets.top;
                z = true;
            }
            if (z) {
                view.setLayoutParams(marginLayoutParams);
            }
            view.setPadding(paddingLeft, view.getPaddingTop(), paddingRight, paddingBottom);
            if (this.val$shouldHandleGestureInsets) {
                BottomSheetBehavior.access$1102(BottomSheetBehavior.this, insets2.bottom);
            }
            if (BottomSheetBehavior.access$400(BottomSheetBehavior.this) || this.val$shouldHandleGestureInsets) {
                BottomSheetBehavior.access$1200(BottomSheetBehavior.this, false);
            }
            return windowInsetsCompat;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 extends ViewDragHelper.Callback {
        private long viewCapturedMillis;

        AnonymousClass5() {
        }

        private boolean releasedLow(View view) {
            return view.getTop() > (BottomSheetBehavior.this.parentHeight + BottomSheetBehavior.this.getExpandedOffset()) / 2;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return view.getLeft();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return MathUtils.clamp(i, BottomSheetBehavior.this.getExpandedOffset(), getViewVerticalDragRange(view));
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewVerticalDragRange(View view) {
            return BottomSheetBehavior.access$1900(BottomSheetBehavior.this) ? BottomSheetBehavior.this.parentHeight : BottomSheetBehavior.this.collapsedOffset;
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (i == 1 && BottomSheetBehavior.access$1600(BottomSheetBehavior.this)) {
                BottomSheetBehavior.this.setStateInternal(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            BottomSheetBehavior.this.dispatchOnSlide(i2);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            int i;
            if (f2 < 0.0f) {
                if (BottomSheetBehavior.access$1700(BottomSheetBehavior.this)) {
                    i = 3;
                } else {
                    int top = view.getTop();
                    long uptimeMillis = SystemClock.uptimeMillis() - this.viewCapturedMillis;
                    if (BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging()) {
                        i = BottomSheetBehavior.this.shouldExpandOnUpwardDrag(uptimeMillis, (((float) top) * 100.0f) / ((float) BottomSheetBehavior.this.parentHeight)) ? 3 : 4;
                    } else {
                        i = top > BottomSheetBehavior.this.halfExpandedOffset ? 6 : 3;
                    }
                }
            } else if (BottomSheetBehavior.this.hideable && BottomSheetBehavior.this.shouldHide(view, f2)) {
                i = ((Math.abs(f) >= Math.abs(f2) || f2 <= ((float) BottomSheetBehavior.access$1800(BottomSheetBehavior.this))) && !releasedLow(view)) ? BottomSheetBehavior.access$1700(BottomSheetBehavior.this) ? 3 : Math.abs(view.getTop() - BottomSheetBehavior.this.getExpandedOffset()) < Math.abs(view.getTop() - BottomSheetBehavior.this.halfExpandedOffset) ? 3 : 6 : 5;
            } else if (f2 == 0.0f || Math.abs(f) > Math.abs(f2)) {
                int top2 = view.getTop();
                i = BottomSheetBehavior.access$1700(BottomSheetBehavior.this) ? Math.abs(top2 - BottomSheetBehavior.this.fitToContentsOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset) ? 3 : 4 : top2 < BottomSheetBehavior.this.halfExpandedOffset ? top2 < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset) ? 3 : BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging() ? 4 : 6 : Math.abs(top2 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top2 - BottomSheetBehavior.this.collapsedOffset) ? BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging() ? 4 : 6 : 4;
            } else if (BottomSheetBehavior.access$1700(BottomSheetBehavior.this)) {
                i = 4;
            } else {
                int top3 = view.getTop();
                i = Math.abs(top3 - BottomSheetBehavior.this.halfExpandedOffset) < Math.abs(top3 - BottomSheetBehavior.this.collapsedOffset) ? BottomSheetBehavior.this.shouldSkipHalfExpandedStateWhenDragging() ? 4 : 6 : 4;
            }
            BottomSheetBehavior.access$100(BottomSheetBehavior.this, view, i, BottomSheetBehavior.this.shouldSkipSmoothAnimation());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            if (BottomSheetBehavior.this.state == 1 || BottomSheetBehavior.this.touchingScrollingChild) {
                return false;
            }
            if (BottomSheetBehavior.this.state == 3 && BottomSheetBehavior.this.activePointerId == i) {
                View access$1500 = BottomSheetBehavior.access$1300(BottomSheetBehavior.this) ? BottomSheetBehavior.access$1400(BottomSheetBehavior.this) != null ? (View) BottomSheetBehavior.access$1400(BottomSheetBehavior.this).get() : null : BottomSheetBehavior.access$1500(BottomSheetBehavior.this);
                if (access$1500 != null && access$1500.canScrollVertically(-1)) {
                    return false;
                }
            }
            this.viewCapturedMillis = SystemClock.uptimeMillis();
            return BottomSheetBehavior.this.viewRef != null && BottomSheetBehavior.this.viewRef.get() == view;
        }
    }

    /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$6, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 implements AccessibilityViewCommand {
        final /* synthetic */ int val$state;

        AnonymousClass6(int i) {
            this.val$state = i;
        }

        @Override // androidx.core.view.accessibility.AccessibilityViewCommand
        public boolean perform(View view, AccessibilityViewCommand.CommandArguments commandArguments) {
            BottomSheetBehavior.this.setState(this.val$state);
            return true;
        }
    }

    /* loaded from: classes.dex */
    public static abstract class BottomSheetCallback {
        void onLayout(View view) {
        }

        public abstract void onSlide(View view, float f);

        public abstract void onStateChanged(View view, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface SaveFlags {
    }

    /* loaded from: classes.dex */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        boolean fitToContents;
        boolean hideable;
        int peekHeight;
        boolean skipCollapsed;
        final int state;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$SavedState$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Parcelable.ClassLoaderCreator<SavedState> {
            AnonymousClass1() {
            }

            @Override // android.os.Parcelable.Creator
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
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
            this(parcel, (ClassLoader) null);
        }

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.state = parcel.readInt();
            this.peekHeight = parcel.readInt();
            this.fitToContents = parcel.readInt() == 1;
            this.hideable = parcel.readInt() == 1;
            this.skipCollapsed = parcel.readInt() == 1;
        }

        @Deprecated
        public SavedState(Parcelable parcelable, int i) {
            super(parcelable);
            this.state = i;
        }

        public SavedState(Parcelable parcelable, BottomSheetBehavior<?> bottomSheetBehavior) {
            super(parcelable);
            this.state = bottomSheetBehavior.state;
            this.peekHeight = BottomSheetBehavior.access$2200(bottomSheetBehavior);
            this.fitToContents = BottomSheetBehavior.access$1700(bottomSheetBehavior);
            this.hideable = bottomSheetBehavior.hideable;
            this.skipCollapsed = BottomSheetBehavior.access$2300(bottomSheetBehavior);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
            parcel.writeInt(this.peekHeight);
            parcel.writeInt(this.fitToContents ? 1 : 0);
            parcel.writeInt(this.hideable ? 1 : 0);
            parcel.writeInt(this.skipCollapsed ? 1 : 0);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface StableState {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface State {
    }

    /* loaded from: classes.dex */
    private class StateSettlingTracker {
        private final Runnable continueSettlingRunnable;
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;

        /* renamed from: com.google.android.material.bottomsheet.BottomSheetBehavior$StateSettlingTracker$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Runnable {
            AnonymousClass1() {
            }

            @Override // java.lang.Runnable
            public void run() {
                StateSettlingTracker.access$2002(StateSettlingTracker.this, false);
                if (BottomSheetBehavior.this.viewDragHelper != null && BottomSheetBehavior.this.viewDragHelper.continueSettling(true)) {
                    StateSettlingTracker.this.continueSettlingToState(StateSettlingTracker.access$2100(StateSettlingTracker.this));
                } else if (BottomSheetBehavior.this.state == 2) {
                    BottomSheetBehavior.this.setStateInternal(StateSettlingTracker.access$2100(StateSettlingTracker.this));
                }
            }
        }

        private StateSettlingTracker() {
            this.continueSettlingRunnable = new AnonymousClass1();
        }

        /* synthetic */ StateSettlingTracker(BottomSheetBehavior bottomSheetBehavior, AnonymousClass1 anonymousClass1) {
            this();
        }

        static /* synthetic */ boolean access$2002(StateSettlingTracker stateSettlingTracker, boolean z) {
            stateSettlingTracker.isContinueSettlingRunnablePosted = z;
            return z;
        }

        static /* synthetic */ int access$2100(StateSettlingTracker stateSettlingTracker) {
            return stateSettlingTracker.targetState;
        }

        void continueSettlingToState(int i) {
            if (BottomSheetBehavior.this.viewRef == null || BottomSheetBehavior.this.viewRef.get() == null) {
                return;
            }
            this.targetState = i;
            if (this.isContinueSettlingRunnablePosted) {
                return;
            }
            BottomSheetBehavior.this.viewRef.get().postOnAnimation(this.continueSettlingRunnable);
            this.isContinueSettlingRunnablePosted = true;
        }
    }

    public BottomSheetBehavior() {
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.draggableOnNestedScroll = true;
        this.autoExpandOnRequestChildRectangleOffscreen = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.nestedScrollingChildrenRef = new ArrayList();
        this.callbacks = new ArrayList<>();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.expandActionIds = new SparseIntArray();
        this.collapseActionIds = new SparseIntArray();
        this.sheetRect = new Rect();
        this.dragCallback = new AnonymousClass5();
    }

    public BottomSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.saveFlags = 0;
        this.fitToContents = true;
        this.updateImportantForAccessibilityOnSiblings = false;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.stateSettlingTracker = new StateSettlingTracker(this, null);
        this.halfExpandedRatio = 0.5f;
        this.elevation = -1.0f;
        this.draggable = true;
        this.draggableOnNestedScroll = true;
        this.autoExpandOnRequestChildRectangleOffscreen = true;
        this.state = 4;
        this.lastStableState = 4;
        this.hideFriction = 0.1f;
        this.nestedScrollingChildrenRef = new ArrayList();
        this.callbacks = new ArrayList<>();
        this.initialY = -1;
        this.expandHalfwayActionIds = new SparseIntArray();
        this.expandActionIds = new SparseIntArray();
        this.collapseActionIds = new SparseIntArray();
        this.sheetRect = new Rect();
        this.dragCallback = new AnonymousClass5();
        this.peekHeightGestureInsetBuffer = context.getResources().getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BottomSheetBehavior_Layout);
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_backgroundTint)) {
            this.backgroundTint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.BottomSheetBehavior_Layout_backgroundTint);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModelDefault = ShapeAppearanceModel.builder(context, attributeSet, R.attr.bottomSheetStyle, DEF_STYLE_RES).build();
        }
        createMaterialShapeDrawableIfNeeded(context);
        createShapeValueAnimator();
        this.elevation = obtainStyledAttributes.getDimension(R.styleable.BottomSheetBehavior_Layout_android_elevation, -1.0f);
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxWidth)) {
            setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxWidth, -1));
        }
        if (obtainStyledAttributes.hasValue(R.styleable.BottomSheetBehavior_Layout_android_maxHeight)) {
            setMaxHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_android_maxHeight, -1));
        }
        TypedValue peekValue = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight);
        if (peekValue == null || peekValue.data != -1) {
            setPeekHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomSheetBehavior_Layout_behavior_peekHeight, -1));
        } else {
            setPeekHeight(peekValue.data);
        }
        setHideable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_hideable, false));
        setGestureInsetBottomIgnored(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_gestureInsetBottomIgnored, false));
        setFitToContents(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_fitToContents, true));
        setSkipCollapsed(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_skipCollapsed, false));
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggable, true));
        setDraggableOnNestedScroll(obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_draggableOnNestedScroll, true));
        setSaveFlags(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_saveFlags, 0));
        setHalfExpandedRatio(obtainStyledAttributes.getFloat(R.styleable.BottomSheetBehavior_Layout_behavior_halfExpandedRatio, 0.5f));
        TypedValue peekValue2 = obtainStyledAttributes.peekValue(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset);
        if (peekValue2 == null || peekValue2.type != 16) {
            setExpandedOffset(obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomSheetBehavior_Layout_behavior_expandedOffset, 0));
        } else {
            setExpandedOffset(peekValue2.data);
        }
        setSignificantVelocityThreshold(obtainStyledAttributes.getInt(R.styleable.BottomSheetBehavior_Layout_behavior_significantVelocityThreshold, 500));
        this.multipleScrollingChildrenSupported = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_multipleScrollingChildrenSupported, false);
        this.autoExpandOnRequestChildRectangleOffscreen = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_behavior_autoExpandOnRequestChildRectangleOffscreen, true);
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingRightSystemWindowInsets, false);
        this.paddingTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_paddingTopSystemWindowInsets, true);
        this.marginLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginLeftSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginRightSystemWindowInsets, false);
        this.marginTopSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_marginTopSystemWindowInsets, false);
        this.shouldRemoveExpandedCorners = obtainStyledAttributes.getBoolean(R.styleable.BottomSheetBehavior_Layout_shouldRemoveExpandedCorners, true);
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    static /* synthetic */ void access$100(BottomSheetBehavior bottomSheetBehavior, View view, int i, boolean z) {
        bottomSheetBehavior.startSettling(view, i, z);
    }

    static /* synthetic */ boolean access$1000(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.marginTopSystemWindowInsets;
    }

    static /* synthetic */ int access$1102(BottomSheetBehavior bottomSheetBehavior, int i) {
        bottomSheetBehavior.gestureInsetBottom = i;
        return i;
    }

    static /* synthetic */ void access$1200(BottomSheetBehavior bottomSheetBehavior, boolean z) {
        bottomSheetBehavior.updatePeekHeight(z);
    }

    static /* synthetic */ boolean access$1300(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.multipleScrollingChildrenSupported;
    }

    static /* synthetic */ WeakReference access$1400(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.currentTouchedScrollChildRef;
    }

    static /* synthetic */ View access$1500(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.getSingleScrollingChildOrNull();
    }

    static /* synthetic */ boolean access$1600(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.draggable;
    }

    static /* synthetic */ boolean access$1700(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.fitToContents;
    }

    static /* synthetic */ int access$1800(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.significantVelocityThreshold;
    }

    static /* synthetic */ boolean access$1900(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.canBeHiddenByDragging();
    }

    static /* synthetic */ MaterialShapeDrawable access$200(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.materialShapeDrawable;
    }

    static /* synthetic */ int access$2200(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.peekHeight;
    }

    static /* synthetic */ boolean access$2300(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.skipCollapsed;
    }

    static /* synthetic */ int access$302(BottomSheetBehavior bottomSheetBehavior, int i) {
        bottomSheetBehavior.insetTop = i;
        return i;
    }

    static /* synthetic */ boolean access$400(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ int access$500(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.insetBottom;
    }

    static /* synthetic */ int access$502(BottomSheetBehavior bottomSheetBehavior, int i) {
        bottomSheetBehavior.insetBottom = i;
        return i;
    }

    static /* synthetic */ boolean access$600(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.paddingLeftSystemWindowInsets;
    }

    static /* synthetic */ boolean access$700(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.paddingRightSystemWindowInsets;
    }

    static /* synthetic */ boolean access$800(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.marginLeftSystemWindowInsets;
    }

    static /* synthetic */ boolean access$900(BottomSheetBehavior bottomSheetBehavior) {
        return bottomSheetBehavior.marginRightSystemWindowInsets;
    }

    private int addAccessibilityActionForState(View view, int i, int i2) {
        return ViewCompat.addAccessibilityAction(view, view.getResources().getString(i), createAccessibilityViewCommandForState(i2));
    }

    private void calculateCollapsedOffset() {
        int calculatePeekHeight = calculatePeekHeight();
        if (this.fitToContents) {
            this.collapsedOffset = Math.max(this.parentHeight - calculatePeekHeight, this.fitToContentsOffset);
        } else {
            this.collapsedOffset = this.parentHeight - calculatePeekHeight;
        }
    }

    private float calculateCornerInterpolation(float f, RoundedCorner roundedCorner) {
        if (roundedCorner != null) {
            float radius = roundedCorner.getRadius();
            if (radius > 0.0f && f > 0.0f) {
                return radius / f;
            }
        }
        return 0.0f;
    }

    private void calculateHalfExpandedOffset() {
        this.halfExpandedOffset = (int) (this.parentHeight * (1.0f - this.halfExpandedRatio));
    }

    private float calculateInterpolationWithCornersRemoved() {
        WindowInsets rootWindowInsets;
        if (this.materialShapeDrawable == null || this.viewRef == null || this.viewRef.get() == null || Build.VERSION.SDK_INT < 31) {
            return 0.0f;
        }
        V v = this.viewRef.get();
        if (!isAtTopOfScreen() || (rootWindowInsets = v.getRootWindowInsets()) == null) {
            return 0.0f;
        }
        return Math.max(calculateCornerInterpolation(this.materialShapeDrawable.getTopLeftCornerResolvedSize(), rootWindowInsets.getRoundedCorner(0)), calculateCornerInterpolation(this.materialShapeDrawable.getTopRightCornerResolvedSize(), rootWindowInsets.getRoundedCorner(1)));
    }

    private int calculatePeekHeight() {
        return this.peekHeightAuto ? Math.min(Math.max(this.peekHeightMin, this.parentHeight - ((this.parentWidth * 9) / 16)), this.childHeight) + this.insetBottom : (this.gestureInsetBottomIgnored || this.paddingBottomSystemWindowInsets || this.gestureInsetBottom <= 0) ? this.peekHeight + this.insetBottom : Math.max(this.peekHeight, this.gestureInsetBottom + this.peekHeightGestureInsetBuffer);
    }

    private float calculateSlideOffsetWithTop(int i) {
        return (i > this.collapsedOffset || this.collapsedOffset == getExpandedOffset()) ? (this.collapsedOffset - i) / (this.parentHeight - this.collapsedOffset) : (this.collapsedOffset - i) / (this.collapsedOffset - getExpandedOffset());
    }

    private boolean canBeHiddenByDragging() {
        return isHideable() && isHideableWhenDragging();
    }

    private void clearAccessibilityAction(View view, int i) {
        if (view == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(view, 1048576);
        ViewCompat.removeAccessibilityAction(view, 524288);
        ViewCompat.removeAccessibilityAction(view, 262144);
        int i2 = this.expandActionIds.get(i, -1);
        if (i2 != -1) {
            ViewCompat.removeAccessibilityAction(view, i2);
            this.expandActionIds.delete(i);
        }
        int i3 = this.expandHalfwayActionIds.get(i, -1);
        if (i3 != -1) {
            ViewCompat.removeAccessibilityAction(view, i3);
            this.expandHalfwayActionIds.delete(i);
        }
        int i4 = this.collapseActionIds.get(i, -1);
        if (i4 != -1) {
            ViewCompat.removeAccessibilityAction(view, i4);
            this.collapseActionIds.delete(i);
        }
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(int i) {
        return new AnonymousClass6(i);
    }

    private void createMaterialShapeDrawableIfNeeded(Context context) {
        if (this.shapeAppearanceModelDefault == null) {
            return;
        }
        this.materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModelDefault);
        this.materialShapeDrawable.initializeElevationOverlay(context);
        if (this.backgroundTint != null) {
            this.materialShapeDrawable.setFillColor(this.backgroundTint);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
        this.materialShapeDrawable.setTint(typedValue.data);
    }

    private void createShapeValueAnimator() {
        this.interpolatorAnimator = ValueAnimator.ofFloat(calculateInterpolationWithCornersRemoved(), 1.0f);
        this.interpolatorAnimator.setDuration(500L);
        this.interpolatorAnimator.addUpdateListener(new AnonymousClass3());
    }

    private View findScrollingChildContainingCoordinates(CoordinatorLayout coordinatorLayout, int i, int i2) {
        if (this.nestedScrollingChildrenRef.isEmpty()) {
            return null;
        }
        Iterator<WeakReference<View>> it = this.nestedScrollingChildrenRef.iterator();
        while (it.hasNext()) {
            View view = it.next().get();
            if (view != null && coordinatorLayout.isPointInChildBounds(view, i, i2)) {
                return view;
            }
        }
        return null;
    }

    public static <V extends View> BottomSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof BottomSheetBehavior) {
            return (BottomSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with BottomSheetBehavior");
    }

    private int getChildMeasureSpec(int i, int i2, int i3, int i4) {
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i, i2, i4);
        if (i3 == -1) {
            return childMeasureSpec;
        }
        int mode = View.MeasureSpec.getMode(childMeasureSpec);
        int size = View.MeasureSpec.getSize(childMeasureSpec);
        switch (mode) {
            case BasicMeasure.EXACTLY /* 1073741824 */:
                return View.MeasureSpec.makeMeasureSpec(Math.min(size, i3), BasicMeasure.EXACTLY);
            default:
                return View.MeasureSpec.makeMeasureSpec(size == 0 ? i3 : Math.min(size, i3), Integer.MIN_VALUE);
        }
    }

    public static Protection getDefaultBottomGradientProtection(Context context) {
        Integer colorOrNull = MaterialColors.getColorOrNull(context, R.attr.colorSurfaceContainerLow);
        if (colorOrNull == null) {
            colorOrNull = Integer.valueOf(MaterialColors.getColor(context, R.attr.colorSurface, BottomSheetBehavior.class.getSimpleName()));
        }
        return new GradientProtection(8, colorOrNull.intValue());
    }

    private View getSingleScrollingChildOrNull() {
        if (this.nestedScrollingChildrenRef.isEmpty()) {
            return null;
        }
        return this.nestedScrollingChildrenRef.get(0).get();
    }

    private int getTopOffsetForState(int i) {
        switch (i) {
            case 3:
                return getExpandedOffset();
            case 4:
                return this.collapsedOffset;
            case 5:
                return this.parentHeight;
            case 6:
                return this.halfExpandedOffset;
            default:
                throw new IllegalArgumentException("Invalid state to get top offset: " + i);
        }
    }

    private float getYVelocity() {
        if (this.velocityTracker == null) {
            return 0.0f;
        }
        this.velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getYVelocity(this.activePointerId);
    }

    private boolean hasScrollingChild() {
        Iterator<WeakReference<View>> it = this.nestedScrollingChildrenRef.iterator();
        while (it.hasNext()) {
            if (it.next().get() != null) {
                return true;
            }
        }
        return false;
    }

    private boolean isAtTopOfScreen() {
        if (this.viewRef == null || this.viewRef.get() == null) {
            return false;
        }
        int[] iArr = new int[2];
        this.viewRef.get().getLocationOnScreen(iArr);
        return iArr[1] == 0;
    }

    private boolean isExpandedAndShouldRemoveCorners() {
        return this.state == 3 && (this.shouldRemoveExpandedCorners || isAtTopOfScreen());
    }

    private boolean isLayouting(V v) {
        ViewParent parent = v.getParent();
        return parent != null && parent.isLayoutRequested() && v.isAttachedToWindow();
    }

    private boolean isTouchingDragHandle(CoordinatorLayout coordinatorLayout, int i, int i2) {
        View view = this.dragHandleViewRef != null ? this.dragHandleViewRef.get() : null;
        return view != null && coordinatorLayout.isPointInChildBounds(view, i, i2);
    }

    private boolean isTouchingScrollingChild(CoordinatorLayout coordinatorLayout, MotionEvent motionEvent) {
        if (this.multipleScrollingChildrenSupported) {
            return (this.currentTouchedScrollChildRef == null || this.currentTouchedScrollChildRef.get() == null) ? false : true;
        }
        View singleScrollingChildOrNull = getSingleScrollingChildOrNull();
        return singleScrollingChildOrNull != null && coordinatorLayout.isPointInChildBounds(singleScrollingChildOrNull, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    private boolean isViewScrollingChild(View view) {
        Iterator<WeakReference<View>> it = this.nestedScrollingChildrenRef.iterator();
        while (it.hasNext()) {
            if (it.next().get() == view) {
                return true;
            }
        }
        return false;
    }

    private void replaceAccessibilityActionForState(View view, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i) {
        ViewCompat.replaceAccessibilityAction(view, accessibilityActionCompat, null, createAccessibilityViewCommandForState(i));
    }

    private void reset() {
        this.activePointerId = -1;
        this.initialY = -1;
        this.currentTouchedScrollChildRef = null;
        if (this.velocityTracker != null) {
            this.velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void restoreOptionalState(SavedState savedState) {
        if (this.saveFlags == 0) {
            return;
        }
        if (this.saveFlags == -1 || (this.saveFlags & 1) == 1) {
            this.peekHeight = savedState.peekHeight;
        }
        if (this.saveFlags == -1 || (this.saveFlags & 2) == 2) {
            this.fitToContents = savedState.fitToContents;
        }
        if (this.saveFlags == -1 || (this.saveFlags & 4) == 4) {
            this.hideable = savedState.hideable;
        }
        if (this.saveFlags == -1 || (this.saveFlags & 8) == 8) {
            this.skipCollapsed = savedState.skipCollapsed;
        }
    }

    private void runAfterLayout(V v, Runnable runnable) {
        if (isLayouting(v)) {
            v.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void setWindowInsetsListener(View view) {
        boolean z = (Build.VERSION.SDK_INT < 29 || isGestureInsetBottomIgnored() || this.peekHeightAuto) ? false : true;
        if (this.paddingBottomSystemWindowInsets || this.paddingLeftSystemWindowInsets || this.paddingRightSystemWindowInsets || this.marginLeftSystemWindowInsets || this.marginRightSystemWindowInsets || this.marginTopSystemWindowInsets || z) {
            ViewUtils.doOnApplyWindowInsets(view, new AnonymousClass4(z));
        }
    }

    private boolean shouldHandleDraggingWithHelper() {
        return this.viewDragHelper != null && (this.draggable || this.state == 1);
    }

    private void startSettling(View view, int i, boolean z) {
        int topOffsetForState = getTopOffsetForState(i);
        if (!(this.viewDragHelper != null && (!z ? !this.viewDragHelper.smoothSlideViewTo(view, view.getLeft(), topOffsetForState) : !this.viewDragHelper.settleCapturedViewAt(view.getLeft(), topOffsetForState)))) {
            setStateInternal(i);
            return;
        }
        setStateInternal(2);
        updateDrawableForTargetState(i, true);
        this.stateSettlingTracker.continueSettlingToState(i);
    }

    private void updateAccessibilityActions() {
        if (this.viewRef != null) {
            updateAccessibilityActions(this.viewRef.get(), 0);
        }
        if (this.accessibilityDelegateViewRef != null) {
            updateAccessibilityActions(this.accessibilityDelegateViewRef.get(), 1);
        }
    }

    private void updateAccessibilityActions(View view, int i) {
        if (view == null) {
            return;
        }
        clearAccessibilityAction(view, i);
        if (!this.fitToContents && this.state != 6) {
            this.expandHalfwayActionIds.put(i, addAccessibilityActionForState(view, R.string.bottomsheet_action_expand_halfway, 6));
        }
        if (this.hideable && isHideableWhenDragging() && this.state != 5) {
            replaceAccessibilityActionForState(view, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        switch (this.state) {
            case 3:
                if (canCollapse()) {
                    this.collapseActionIds.put(i, addAccessibilityActionForState(view, R.string.bottomsheet_action_collapse, 4));
                    return;
                }
                return;
            case 4:
                this.expandActionIds.put(i, addAccessibilityActionForState(view, R.string.bottomsheet_action_expand, 3));
                return;
            case 5:
            default:
                return;
            case 6:
                if (canCollapse()) {
                    this.collapseActionIds.put(i, addAccessibilityActionForState(view, R.string.bottomsheet_action_collapse, 4));
                }
                this.expandActionIds.put(i, addAccessibilityActionForState(view, R.string.bottomsheet_action_expand, 3));
                return;
        }
    }

    private void updateDrawableForTargetState(int i, boolean z) {
        boolean isExpandedAndShouldRemoveCorners;
        if (i == 2 || this.expandedCornersRemoved == (isExpandedAndShouldRemoveCorners = isExpandedAndShouldRemoveCorners()) || this.materialShapeDrawable == null) {
            return;
        }
        this.expandedCornersRemoved = isExpandedAndShouldRemoveCorners;
        if (!z || this.interpolatorAnimator == null) {
            if (this.interpolatorAnimator != null && this.interpolatorAnimator.isRunning()) {
                this.interpolatorAnimator.cancel();
            }
            this.materialShapeDrawable.setInterpolation(this.expandedCornersRemoved ? calculateInterpolationWithCornersRemoved() : 1.0f);
            return;
        }
        if (this.interpolatorAnimator.isRunning()) {
            this.interpolatorAnimator.reverse();
        } else {
            this.interpolatorAnimator.setFloatValues(this.materialShapeDrawable.getInterpolation(), isExpandedAndShouldRemoveCorners ? calculateInterpolationWithCornersRemoved() : 1.0f);
            this.interpolatorAnimator.start();
        }
    }

    private void updateImportantForAccessibility(boolean z) {
        if (this.viewRef == null) {
            return;
        }
        ViewParent parent = this.viewRef.get().getParent();
        if (parent instanceof CoordinatorLayout) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) parent;
            int childCount = coordinatorLayout.getChildCount();
            if (z) {
                if (this.importantForAccessibilityMap != null) {
                    return;
                } else {
                    this.importantForAccessibilityMap = new HashMap(childCount);
                }
            }
            for (int i = 0; i < childCount; i++) {
                View childAt = coordinatorLayout.getChildAt(i);
                if (childAt != this.viewRef.get()) {
                    if (z) {
                        this.importantForAccessibilityMap.put(childAt, Integer.valueOf(childAt.getImportantForAccessibility()));
                        if (this.updateImportantForAccessibilityOnSiblings) {
                            childAt.setImportantForAccessibility(4);
                        }
                    } else if (this.updateImportantForAccessibilityOnSiblings && this.importantForAccessibilityMap != null && this.importantForAccessibilityMap.containsKey(childAt)) {
                        childAt.setImportantForAccessibility(this.importantForAccessibilityMap.get(childAt).intValue());
                    }
                }
            }
            if (!z) {
                this.importantForAccessibilityMap = null;
            } else if (this.updateImportantForAccessibilityOnSiblings) {
                this.viewRef.get().sendAccessibilityEvent(8);
            }
        }
    }

    private void updatePeekHeight(boolean z) {
        V v;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
            if (this.state != 4 || (v = this.viewRef.get()) == null) {
                return;
            }
            if (z) {
                setState(4);
            } else {
                v.requestLayout();
            }
        }
    }

    public void addBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        if (this.callbacks.contains(bottomSheetCallback)) {
            return;
        }
        this.callbacks.add(bottomSheetCallback);
    }

    public float calculateSlideOffset() {
        if (this.viewRef == null || this.viewRef.get() == null) {
            return -1.0f;
        }
        return calculateSlideOffsetWithTop(this.viewRef.get().getTop());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean canCollapse() {
        return (this.skipCollapsed && this.hideable) ? false : true;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void cancelBackProgress() {
        if (this.bottomContainerBackHelper == null) {
            return;
        }
        this.bottomContainerBackHelper.cancelBackProgress();
    }

    public void disableShapeAnimations() {
        this.interpolatorAnimator = null;
    }

    void dispatchOnSlide(int i) {
        V v = this.viewRef.get();
        if (v == null || this.callbacks.isEmpty()) {
            return;
        }
        float calculateSlideOffsetWithTop = calculateSlideOffsetWithTop(i);
        for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
            this.callbacks.get(i2).onSlide(v, calculateSlideOffsetWithTop);
        }
    }

    View findScrollingChild(View view) {
        if (view.getVisibility() != 0) {
            return null;
        }
        if (view.isNestedScrollingEnabled()) {
            return view;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View findScrollingChild = findScrollingChild(viewGroup.getChildAt(i));
                if (findScrollingChild != null) {
                    return findScrollingChild;
                }
            }
        }
        return null;
    }

    MaterialBottomContainerBackHelper getBackHelper() {
        return this.bottomContainerBackHelper;
    }

    public int getExpandedOffset() {
        if (this.fitToContents) {
            return this.fitToContentsOffset;
        }
        return Math.max(this.expandedOffset, this.paddingTopSystemWindowInsets ? 0 : this.insetTop);
    }

    public float getHalfExpandedRatio() {
        return this.halfExpandedRatio;
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    public int getLastStableState() {
        return this.lastStableState;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialShapeDrawable getMaterialShapeDrawable() {
        return this.materialShapeDrawable;
    }

    public int getMaxHeight() {
        return this.maxHeight;
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getPeekHeight() {
        if (this.peekHeightAuto) {
            return -1;
        }
        return this.peekHeight;
    }

    int getPeekHeightMin() {
        return this.peekHeightMin;
    }

    public int getSaveFlags() {
        return this.saveFlags;
    }

    public int getSignificantVelocityThreshold() {
        return this.significantVelocityThreshold;
    }

    public boolean getSkipCollapsed() {
        return this.skipCollapsed;
    }

    public int getState() {
        return this.state;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void handleBackInvoked() {
        if (this.bottomContainerBackHelper == null) {
            return;
        }
        BackEventCompat onHandleBackInvoked = this.bottomContainerBackHelper.onHandleBackInvoked();
        if (onHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
            setState(this.hideable ? 5 : 4);
        } else if (this.hideable) {
            this.bottomContainerBackHelper.finishBackProgressNotPersistent(onHandleBackInvoked, new AnonymousClass2());
        } else {
            this.bottomContainerBackHelper.finishBackProgressPersistent(onHandleBackInvoked, null);
            setState(4);
        }
    }

    public boolean isAutoExpandOnRequestChildRectangleOffscreen() {
        return this.autoExpandOnRequestChildRectangleOffscreen;
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    public boolean isDraggableOnNestedScroll() {
        return this.draggableOnNestedScroll;
    }

    public boolean isFitToContents() {
        return this.fitToContents;
    }

    public boolean isGestureInsetBottomIgnored() {
        return this.gestureInsetBottomIgnored;
    }

    public boolean isHideable() {
        return this.hideable;
    }

    public boolean isHideableWhenDragging() {
        return true;
    }

    public boolean isNestedScrollingCheckEnabled() {
        return true;
    }

    public boolean isShouldRemoveExpandedCorners() {
        return this.shouldRemoveExpandedCorners;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.bottomContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown() || !this.draggable) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                int x = (int) motionEvent.getX();
                this.initialY = (int) motionEvent.getY();
                this.currentTouchedScrollChildRef = new WeakReference<>(findScrollingChildContainingCoordinates(coordinatorLayout, (int) motionEvent.getX(), (int) motionEvent.getY()));
                if (this.state != 2 && this.currentTouchedScrollChildRef.get() != null) {
                    this.activePointerId = motionEvent.getPointerId(motionEvent.getActionIndex());
                    if (!isTouchingDragHandle(coordinatorLayout, x, this.initialY)) {
                        this.touchingScrollingChild = true;
                    }
                }
                this.ignoreEvents = this.activePointerId == -1 && !coordinatorLayout.isPointInChildBounds(v, x, this.initialY);
                break;
            case 1:
            case 3:
                this.touchingScrollingChild = false;
                this.currentTouchedScrollChildRef = null;
                this.activePointerId = -1;
                if (this.ignoreEvents) {
                    this.ignoreEvents = false;
                    return false;
                }
                break;
        }
        if (this.ignoreEvents || this.viewDragHelper == null || !this.viewDragHelper.shouldInterceptTouchEvent(motionEvent)) {
            return (actionMasked != 2 || !hasScrollingChild() || this.ignoreEvents || this.state == 1 || isTouchingScrollingChild(coordinatorLayout, motionEvent) || this.viewDragHelper == null || this.initialY == -1 || Math.abs(((float) this.initialY) - motionEvent.getY()) <= ((float) this.viewDragHelper.getTouchSlop())) ? false : true;
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (coordinatorLayout.getFitsSystemWindows() && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.peekHeightMin = coordinatorLayout.getResources().getDimensionPixelSize(R.dimen.design_bottom_sheet_peek_height_min);
            setWindowInsetsListener(v);
            ViewCompat.setWindowInsetsAnimationCallback(v, new InsetsAnimationCallback(v));
            this.viewRef = new WeakReference<>(v);
            this.bottomContainerBackHelper = new MaterialBottomContainerBackHelper(v);
            if (this.materialShapeDrawable != null) {
                v.setBackground(this.materialShapeDrawable);
                this.materialShapeDrawable.setElevation(this.elevation == -1.0f ? v.getElevation() : this.elevation);
            } else if (this.backgroundTint != null) {
                ViewCompat.setBackgroundTintList(v, this.backgroundTint);
            }
            updateAccessibilityActions();
            if (v.getImportantForAccessibility() == 0) {
                v.setImportantForAccessibility(1);
            }
        }
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int top = v.getTop();
        coordinatorLayout.onLayoutChild(v, i);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentHeight = coordinatorLayout.getHeight();
        this.childHeight = v.getHeight();
        if (this.parentHeight - this.childHeight < this.insetTop) {
            if (this.paddingTopSystemWindowInsets) {
                this.childHeight = this.maxHeight == -1 ? this.parentHeight : Math.min(this.parentHeight, this.maxHeight);
            } else {
                int i2 = this.parentHeight - this.insetTop;
                this.childHeight = this.maxHeight == -1 ? i2 : Math.min(i2, this.maxHeight);
            }
        }
        this.fitToContentsOffset = Math.max(0, this.parentHeight - this.childHeight);
        calculateHalfExpandedOffset();
        calculateCollapsedOffset();
        if (this.state == 3) {
            ViewCompat.offsetTopAndBottom(v, getExpandedOffset());
        } else if (this.state == 6) {
            ViewCompat.offsetTopAndBottom(v, this.halfExpandedOffset);
        } else if (this.hideable && this.state == 5) {
            ViewCompat.offsetTopAndBottom(v, this.parentHeight);
        } else if (this.state == 4) {
            ViewCompat.offsetTopAndBottom(v, this.collapsedOffset);
        } else if (this.state == 1 || this.state == 2) {
            ViewCompat.offsetTopAndBottom(v, top - v.getTop());
        }
        updateDrawableForTargetState(this.state, false);
        this.nestedScrollingChildrenRef.clear();
        if (this.multipleScrollingChildrenSupported) {
            populateScrollingChildren(v);
        } else {
            this.nestedScrollingChildrenRef.add(new WeakReference<>(findScrollingChild(v)));
        }
        for (int i3 = 0; i3 < this.callbacks.size(); i3++) {
            this.callbacks.get(i3).onLayout(v);
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        v.measure(getChildMeasureSpec(i, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, this.maxWidth, marginLayoutParams.width), getChildMeasureSpec(i3, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, this.maxHeight, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onNestedPreFling(CoordinatorLayout coordinatorLayout, V v, View view, float f, float f2) {
        if (isNestedScrollingCheckEnabled() && hasScrollingChild() && isViewScrollingChild(view)) {
            return !(this.state == 3 || this.draggableOnNestedScrollLastDragIgnored) || super.onNestedPreFling(coordinatorLayout, v, view, f, f2);
        }
        return false;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedPreScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1) {
            return;
        }
        boolean isViewScrollingChild = isViewScrollingChild(view);
        if (!isNestedScrollingCheckEnabled() || isViewScrollingChild) {
            int top = v.getTop();
            int i4 = top - i2;
            if (i2 > 0) {
                if (!this.nestedScrolled && !this.draggableOnNestedScroll && isViewScrollingChild && view.canScrollVertically(1)) {
                    this.draggableOnNestedScrollLastDragIgnored = true;
                    return;
                }
                if (i4 < getExpandedOffset()) {
                    iArr[1] = top - getExpandedOffset();
                    ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                    setStateInternal(3);
                } else {
                    if (!this.draggable) {
                        return;
                    }
                    iArr[1] = i2;
                    ViewCompat.offsetTopAndBottom(v, -i2);
                    setStateInternal(1);
                }
            } else if (i2 < 0) {
                boolean canScrollVertically = view.canScrollVertically(-1);
                if (!this.nestedScrolled && !this.draggableOnNestedScroll && isViewScrollingChild && canScrollVertically) {
                    this.draggableOnNestedScrollLastDragIgnored = true;
                    return;
                }
                if (!canScrollVertically) {
                    if (i4 > this.collapsedOffset && !canBeHiddenByDragging()) {
                        iArr[1] = top - this.collapsedOffset;
                        ViewCompat.offsetTopAndBottom(v, -iArr[1]);
                        setStateInternal(4);
                    } else {
                        if (!this.draggable) {
                            return;
                        }
                        iArr[1] = i2;
                        ViewCompat.offsetTopAndBottom(v, -i2);
                        setStateInternal(1);
                    }
                }
            }
            dispatchOnSlide(v.getTop());
            this.lastNestedScrollDy = i2;
            this.nestedScrolled = true;
            this.draggableOnNestedScrollLastDragIgnored = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, V v, Rect rect, boolean z) {
        if (!this.autoExpandOnRequestChildRectangleOffscreen || v.isInTouchMode()) {
            return false;
        }
        if (this.state != 4 && this.state != 6) {
            return false;
        }
        if (v.getLocalVisibleRect(this.sheetRect)) {
            WindowInsetsCompat rootWindowInsets = ViewCompat.getRootWindowInsets(v);
            if (rootWindowInsets != null) {
                this.sheetRect.bottom -= rootWindowInsets.getInsets(WindowInsetsCompat.Type.systemBars()).bottom;
            }
            if (rect.top >= this.sheetRect.top && rect.bottom <= this.sheetRect.bottom) {
                return false;
            }
        }
        setState(3);
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        restoreOptionalState(savedState);
        if (savedState.state == 1 || savedState.state == 2) {
            this.state = 4;
            this.lastStableState = this.state;
        } else {
            this.state = savedState.state;
            this.lastStableState = this.state;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (BottomSheetBehavior<?>) this);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        this.lastNestedScrollDy = 0;
        this.nestedScrolled = false;
        return (i & 2) != 0;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onStopNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i) {
        int i2;
        if (v.getTop() == getExpandedOffset()) {
            setStateInternal(3);
            return;
        }
        if (!isNestedScrollingCheckEnabled() || (isViewScrollingChild(view) && this.nestedScrolled)) {
            if (this.lastNestedScrollDy > 0) {
                i2 = this.fitToContents ? 3 : v.getTop() > this.halfExpandedOffset ? 6 : 3;
            } else if (this.hideable && shouldHide(v, getYVelocity())) {
                i2 = 5;
            } else if (this.lastNestedScrollDy == 0) {
                int top = v.getTop();
                i2 = this.fitToContents ? Math.abs(top - this.fitToContentsOffset) < Math.abs(top - this.collapsedOffset) ? 3 : 4 : top < this.halfExpandedOffset ? top < Math.abs(top - this.collapsedOffset) ? 3 : shouldSkipHalfExpandedStateWhenDragging() ? 4 : 6 : Math.abs(top - this.halfExpandedOffset) < Math.abs(top - this.collapsedOffset) ? 6 : 4;
            } else if (this.fitToContents) {
                i2 = 4;
            } else {
                int top2 = v.getTop();
                i2 = Math.abs(top2 - this.halfExpandedOffset) < Math.abs(top2 - this.collapsedOffset) ? 6 : 4;
            }
            startSettling(v, i2, false);
            this.nestedScrolled = false;
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!v.isShown()) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (this.state == 1 && actionMasked == 0) {
            return true;
        }
        if (shouldHandleDraggingWithHelper()) {
            this.viewDragHelper.processTouchEvent(motionEvent);
        }
        if (actionMasked == 0) {
            reset();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents && Math.abs(this.initialY - motionEvent.getY()) > this.viewDragHelper.getTouchSlop()) {
            this.viewDragHelper.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    void populateScrollingChildren(View view) {
        if (view.getVisibility() != 0) {
            return;
        }
        if (view.isNestedScrollingEnabled()) {
            this.nestedScrollingChildrenRef.add(new WeakReference<>(view));
            return;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                populateScrollingChildren(viewGroup.getChildAt(i));
            }
        }
    }

    public void removeBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        this.callbacks.remove(bottomSheetCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setAccessibilityDelegateView(View view) {
        if (view != null || this.accessibilityDelegateViewRef == null) {
            this.accessibilityDelegateViewRef = new WeakReference<>(view);
            updateAccessibilityActions(view, 1);
        } else {
            clearAccessibilityAction(this.accessibilityDelegateViewRef.get(), 1);
            this.accessibilityDelegateViewRef = null;
        }
    }

    public void setAutoExpandOnRequestChildRectangleOffscreen(boolean z) {
        this.autoExpandOnRequestChildRectangleOffscreen = z;
    }

    @Deprecated
    public void setBottomSheetCallback(BottomSheetCallback bottomSheetCallback) {
        Log.w(TAG, "BottomSheetBehavior now supports multiple callbacks. `setBottomSheetCallback()` removes all existing callbacks, including ones set internally by library authors, which may result in unintended behavior. This may change in the future. Please use `addBottomSheetCallback()` and `removeBottomSheetCallback()` instead to set your own callbacks.");
        this.callbacks.clear();
        if (bottomSheetCallback != null) {
            this.callbacks.add(bottomSheetCallback);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDragHandleView(BottomSheetDragHandleView bottomSheetDragHandleView) {
        this.dragHandleViewRef = bottomSheetDragHandleView != null ? new WeakReference<>(bottomSheetDragHandleView) : null;
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
    }

    public void setDraggableOnNestedScroll(boolean z) {
        this.draggableOnNestedScroll = z;
    }

    public void setExpandedOffset(int i) {
        if (i < 0) {
            throw new IllegalArgumentException("offset must be greater than or equal to 0");
        }
        this.expandedOffset = i;
        updateDrawableForTargetState(this.state, true);
    }

    public void setFitToContents(boolean z) {
        if (this.fitToContents == z) {
            return;
        }
        this.fitToContents = z;
        if (this.viewRef != null) {
            calculateCollapsedOffset();
        }
        setStateInternal((this.fitToContents && this.state == 6) ? 3 : this.state);
        updateDrawableForTargetState(this.state, true);
        updateAccessibilityActions();
    }

    public void setGestureInsetBottomIgnored(boolean z) {
        this.gestureInsetBottomIgnored = z;
    }

    public void setHalfExpandedRatio(float f) {
        if (f <= 0.0f || f >= 1.0f) {
            throw new IllegalArgumentException("ratio must be a float value between 0 and 1");
        }
        this.halfExpandedRatio = f;
        if (this.viewRef != null) {
            calculateHalfExpandedOffset();
        }
    }

    public void setHideFriction(float f) {
        this.hideFriction = f;
    }

    public void setHideable(boolean z) {
        if (this.hideable != z) {
            this.hideable = z;
            if (!z && this.state == 5) {
                setState(4);
            }
            updateAccessibilityActions();
        }
    }

    public void setHideableInternal(boolean z) {
        this.hideable = z;
    }

    public void setMaxHeight(int i) {
        this.maxHeight = i;
    }

    public void setMaxWidth(int i) {
        this.maxWidth = i;
    }

    public void setPeekHeight(int i) {
        setPeekHeight(i, false);
    }

    public final void setPeekHeight(int i, boolean z) {
        boolean z2 = false;
        if (i == -1) {
            if (!this.peekHeightAuto) {
                this.peekHeightAuto = true;
                z2 = true;
            }
        } else if (this.peekHeightAuto || this.peekHeight != i) {
            this.peekHeightAuto = false;
            this.peekHeight = Math.max(0, i);
            z2 = true;
        }
        if (z2) {
            updatePeekHeight(z);
        }
    }

    public void setSaveFlags(int i) {
        this.saveFlags = i;
    }

    public void setShouldRemoveExpandedCorners(boolean z) {
        if (this.shouldRemoveExpandedCorners != z) {
            this.shouldRemoveExpandedCorners = z;
            updateDrawableForTargetState(getState(), true);
        }
    }

    public void setSignificantVelocityThreshold(int i) {
        this.significantVelocityThreshold = i;
    }

    public void setSkipCollapsed(boolean z) {
        this.skipCollapsed = z;
    }

    public void setState(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException("STATE_" + (i == 1 ? "DRAGGING" : "SETTLING") + " should not be set externally.");
        }
        if (!this.hideable && i == 5) {
            Log.w(TAG, "Cannot set state: " + i);
            return;
        }
        int i2 = (i == 6 && this.fitToContents && getTopOffsetForState(i) <= this.fitToContentsOffset) ? 3 : i;
        if (this.viewRef == null || this.viewRef.get() == null) {
            setStateInternal(i);
        } else {
            V v = this.viewRef.get();
            runAfterLayout(v, new AnonymousClass1(v, i2));
        }
    }

    void setStateInternal(int i) {
        V v;
        if (this.state == i) {
            return;
        }
        this.state = i;
        if (i == 4 || i == 3 || i == 6 || (this.hideable && i == 5)) {
            this.lastStableState = i;
        }
        if (this.viewRef == null || (v = this.viewRef.get()) == null) {
            return;
        }
        if (i == 3) {
            updateImportantForAccessibility(true);
        } else if (i == 6 || i == 5 || i == 4) {
            updateImportantForAccessibility(false);
        }
        updateDrawableForTargetState(i, true);
        for (int i2 = 0; i2 < this.callbacks.size(); i2++) {
            this.callbacks.get(i2).onStateChanged(v, i);
        }
        updateAccessibilityActions();
    }

    public void setUpdateImportantForAccessibilityOnSiblings(boolean z) {
        this.updateImportantForAccessibilityOnSiblings = z;
    }

    public boolean shouldExpandOnUpwardDrag(long j, float f) {
        return false;
    }

    boolean shouldHide(View view, float f) {
        if (this.skipCollapsed) {
            return true;
        }
        if (isHideableWhenDragging() && view.getTop() >= this.collapsedOffset) {
            return Math.abs((((float) view.getTop()) + (this.hideFriction * f)) - ((float) this.collapsedOffset)) / ((float) calculatePeekHeight()) > 0.5f;
        }
        return false;
    }

    public boolean shouldSkipHalfExpandedStateWhenDragging() {
        return false;
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void startBackProgress(BackEventCompat backEventCompat) {
        if (this.bottomContainerBackHelper == null) {
            return;
        }
        this.bottomContainerBackHelper.startBackProgress(backEventCompat);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void updateBackProgress(BackEventCompat backEventCompat) {
        if (this.bottomContainerBackHelper == null) {
            return;
        }
        this.bottomContainerBackHelper.updateBackProgress(backEventCompat);
    }
}
