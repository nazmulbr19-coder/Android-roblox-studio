package com.google.android.material.sidesheet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.activity.BackEventCompat;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import androidx.customview.view.AbsSavedState;
import androidx.customview.widget.ViewDragHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class SideSheetBehavior<V extends View> extends CoordinatorLayout.Behavior<V> implements Sheet<SideSheetCallback> {
    private static final int DEFAULT_ACCESSIBILITY_PANE_TITLE = R.string.side_sheet_accessibility_pane_title;
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_SideSheet;
    private static final float HIDE_FRICTION = 0.1f;
    private static final float HIDE_THRESHOLD = 0.5f;
    private static final int NO_MAX_SIZE = -1;
    static final int SIGNIFICANT_VEL_THRESHOLD = 500;
    private ColorStateList backgroundTint;
    private final Set<SideSheetCallback> callbacks;
    private int childWidth;
    private int coplanarSiblingViewId;
    private WeakReference<View> coplanarSiblingViewRef;
    private final ViewDragHelper.Callback dragCallback;
    private boolean draggable;
    private float elevation;
    private float hideFriction;
    private boolean ignoreEvents;
    private int initialX;
    private int innerMargin;
    private int lastStableState;
    private MaterialShapeDrawable materialShapeDrawable;
    private float maximumVelocity;
    private int parentInnerEdge;
    private int parentWidth;
    private ShapeAppearanceModel shapeAppearanceModel;
    private SheetDelegate sheetDelegate;
    private MaterialSideContainerBackHelper sideContainerBackHelper;
    private int state;
    private final SideSheetBehavior<V>.StateSettlingTracker stateSettlingTracker;
    private VelocityTracker velocityTracker;
    private ViewDragHelper viewDragHelper;
    private WeakReference<V> viewRef;

    /* renamed from: com.google.android.material.sidesheet.SideSheetBehavior$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ViewDragHelper.Callback {
        AnonymousClass1() {
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionHorizontal(View view, int i, int i2) {
            return MathUtils.clamp(i, SideSheetBehavior.access$200(SideSheetBehavior.this).getMinViewPositionHorizontal(), SideSheetBehavior.access$200(SideSheetBehavior.this).getMaxViewPositionHorizontal());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int clampViewPositionVertical(View view, int i, int i2) {
            return view.getTop();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public int getViewHorizontalDragRange(View view) {
            return SideSheetBehavior.access$700(SideSheetBehavior.this) + SideSheetBehavior.this.getInnerMargin();
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewDragStateChanged(int i) {
            if (i == 1 && SideSheetBehavior.access$400(SideSheetBehavior.this)) {
                SideSheetBehavior.this.setStateInternal(1);
            }
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewPositionChanged(View view, int i, int i2, int i3, int i4) {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            View coplanarSiblingView = SideSheetBehavior.this.getCoplanarSiblingView();
            if (coplanarSiblingView != null && (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) != null) {
                SideSheetBehavior.access$200(SideSheetBehavior.this).updateCoplanarSiblingLayoutParams(marginLayoutParams, view.getLeft(), view.getRight());
                coplanarSiblingView.setLayoutParams(marginLayoutParams);
            }
            SideSheetBehavior.access$300(SideSheetBehavior.this, view, i);
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public void onViewReleased(View view, float f, float f2) {
            SideSheetBehavior.access$600(SideSheetBehavior.this, view, SideSheetBehavior.access$500(SideSheetBehavior.this, view, f, f2), SideSheetBehavior.this.shouldSkipSmoothAnimation());
        }

        @Override // androidx.customview.widget.ViewDragHelper.Callback
        public boolean tryCaptureView(View view, int i) {
            return (SideSheetBehavior.access$000(SideSheetBehavior.this) == 1 || SideSheetBehavior.access$100(SideSheetBehavior.this) == null || SideSheetBehavior.access$100(SideSheetBehavior.this).get() != view) ? false : true;
        }
    }

    /* renamed from: com.google.android.material.sidesheet.SideSheetBehavior$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SideSheetBehavior.this.setStateInternal(5);
            if (SideSheetBehavior.access$100(SideSheetBehavior.this) == null || SideSheetBehavior.access$100(SideSheetBehavior.this).get() == null) {
                return;
            }
            ((View) SideSheetBehavior.access$100(SideSheetBehavior.this).get()).requestLayout();
        }
    }

    /* loaded from: classes.dex */
    protected static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        final int state;

        /* renamed from: com.google.android.material.sidesheet.SideSheetBehavior$SavedState$1, reason: invalid class name */
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
        }

        public SavedState(Parcelable parcelable, SideSheetBehavior<?> sideSheetBehavior) {
            super(parcelable);
            this.state = SideSheetBehavior.access$000(sideSheetBehavior);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.state);
        }
    }

    /* loaded from: classes.dex */
    class StateSettlingTracker {
        private final Runnable continueSettlingRunnable = new SideSheetBehavior$StateSettlingTracker$$ExternalSyntheticLambda0(this);
        private boolean isContinueSettlingRunnablePosted;
        private int targetState;

        StateSettlingTracker() {
        }

        void continueSettlingToState(int i) {
            if (SideSheetBehavior.access$100(SideSheetBehavior.this) == null || SideSheetBehavior.access$100(SideSheetBehavior.this).get() == null) {
                return;
            }
            this.targetState = i;
            if (this.isContinueSettlingRunnablePosted) {
                return;
            }
            ((View) SideSheetBehavior.access$100(SideSheetBehavior.this).get()).postOnAnimation(this.continueSettlingRunnable);
            this.isContinueSettlingRunnablePosted = true;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$new$0$com-google-android-material-sidesheet-SideSheetBehavior$StateSettlingTracker, reason: not valid java name */
        public /* synthetic */ void m420xe5f914a3() {
            this.isContinueSettlingRunnablePosted = false;
            if (SideSheetBehavior.access$800(SideSheetBehavior.this) != null && SideSheetBehavior.access$800(SideSheetBehavior.this).continueSettling(true)) {
                continueSettlingToState(this.targetState);
            } else if (SideSheetBehavior.access$000(SideSheetBehavior.this) == 2) {
                SideSheetBehavior.this.setStateInternal(this.targetState);
            }
        }
    }

    public SideSheetBehavior() {
        this.stateSettlingTracker = new StateSettlingTracker();
        this.draggable = true;
        this.state = 5;
        this.lastStableState = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new AnonymousClass1();
    }

    public SideSheetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.stateSettlingTracker = new StateSettlingTracker();
        this.draggable = true;
        this.state = 5;
        this.lastStableState = 5;
        this.hideFriction = 0.1f;
        this.coplanarSiblingViewId = -1;
        this.callbacks = new LinkedHashSet();
        this.dragCallback = new AnonymousClass1();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SideSheetBehavior_Layout);
        if (obtainStyledAttributes.hasValue(R.styleable.SideSheetBehavior_Layout_backgroundTint)) {
            this.backgroundTint = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.SideSheetBehavior_Layout_backgroundTint);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SideSheetBehavior_Layout_shapeAppearance)) {
            this.shapeAppearanceModel = ShapeAppearanceModel.builder(context, attributeSet, 0, DEF_STYLE_RES).build();
        }
        if (obtainStyledAttributes.hasValue(R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId)) {
            setCoplanarSiblingViewId(obtainStyledAttributes.getResourceId(R.styleable.SideSheetBehavior_Layout_coplanarSiblingViewId, -1));
        }
        createMaterialShapeDrawableIfNeeded(context);
        this.elevation = obtainStyledAttributes.getDimension(R.styleable.SideSheetBehavior_Layout_android_elevation, -1.0f);
        setDraggable(obtainStyledAttributes.getBoolean(R.styleable.SideSheetBehavior_Layout_behavior_draggable, true));
        obtainStyledAttributes.recycle();
        this.maximumVelocity = ViewConfiguration.get(context).getScaledMaximumFlingVelocity();
    }

    static /* synthetic */ int access$000(SideSheetBehavior sideSheetBehavior) {
        return sideSheetBehavior.state;
    }

    static /* synthetic */ WeakReference access$100(SideSheetBehavior sideSheetBehavior) {
        return sideSheetBehavior.viewRef;
    }

    static /* synthetic */ SheetDelegate access$200(SideSheetBehavior sideSheetBehavior) {
        return sideSheetBehavior.sheetDelegate;
    }

    static /* synthetic */ void access$300(SideSheetBehavior sideSheetBehavior, View view, int i) {
        sideSheetBehavior.dispatchOnSlide(view, i);
    }

    static /* synthetic */ boolean access$400(SideSheetBehavior sideSheetBehavior) {
        return sideSheetBehavior.draggable;
    }

    static /* synthetic */ int access$500(SideSheetBehavior sideSheetBehavior, View view, float f, float f2) {
        return sideSheetBehavior.calculateTargetStateOnViewReleased(view, f, f2);
    }

    static /* synthetic */ void access$600(SideSheetBehavior sideSheetBehavior, View view, int i, boolean z) {
        sideSheetBehavior.startSettling(view, i, z);
    }

    static /* synthetic */ int access$700(SideSheetBehavior sideSheetBehavior) {
        return sideSheetBehavior.childWidth;
    }

    static /* synthetic */ ViewDragHelper access$800(SideSheetBehavior sideSheetBehavior) {
        return sideSheetBehavior.viewDragHelper;
    }

    private int calculateCurrentOffset(int i, V v) {
        switch (this.state) {
            case 1:
            case 2:
                return i - this.sheetDelegate.getOuterEdge(v);
            case 3:
                return 0;
            case 4:
            default:
                throw new IllegalStateException("Unexpected value: " + this.state);
            case 5:
                return this.sheetDelegate.getHiddenOffset();
        }
    }

    private float calculateDragDistance(float f, float f2) {
        return Math.abs(f - f2);
    }

    private int calculateTargetStateOnViewReleased(View view, float f, float f2) {
        if (isExpandingOutwards(f)) {
            return 3;
        }
        if (shouldHide(view, f)) {
            return (this.sheetDelegate.isSwipeSignificant(f, f2) || this.sheetDelegate.isReleasedCloseToInnerEdge(view)) ? 5 : 3;
        }
        if (f != 0.0f && SheetUtils.isSwipeMostlyHorizontal(f, f2)) {
            return 5;
        }
        int left = view.getLeft();
        return Math.abs(left - getExpandedOffset()) < Math.abs(left - this.sheetDelegate.getHiddenOffset()) ? 3 : 5;
    }

    private void clearCoplanarSiblingView() {
        if (this.coplanarSiblingViewRef != null) {
            this.coplanarSiblingViewRef.clear();
        }
        this.coplanarSiblingViewRef = null;
    }

    private AccessibilityViewCommand createAccessibilityViewCommandForState(int i) {
        return new SideSheetBehavior$$ExternalSyntheticLambda1(this, i);
    }

    private void createMaterialShapeDrawableIfNeeded(Context context) {
        if (this.shapeAppearanceModel == null) {
            return;
        }
        this.materialShapeDrawable = new MaterialShapeDrawable(this.shapeAppearanceModel);
        this.materialShapeDrawable.initializeElevationOverlay(context);
        if (this.backgroundTint != null) {
            this.materialShapeDrawable.setFillColor(this.backgroundTint);
            return;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(android.R.attr.colorBackground, typedValue, true);
        this.materialShapeDrawable.setTint(typedValue.data);
    }

    private void dispatchOnSlide(View view, int i) {
        if (this.callbacks.isEmpty()) {
            return;
        }
        float calculateSlideOffset = this.sheetDelegate.calculateSlideOffset(i);
        Iterator<SideSheetCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onSlide(view, calculateSlideOffset);
        }
    }

    private void ensureAccessibilityPaneTitleIsSet(View view) {
        if (ViewCompat.getAccessibilityPaneTitle(view) == null) {
            ViewCompat.setAccessibilityPaneTitle(view, view.getResources().getString(DEFAULT_ACCESSIBILITY_PANE_TITLE));
        }
    }

    public static <V extends View> SideSheetBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof SideSheetBehavior) {
            return (SideSheetBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with SideSheetBehavior");
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

    private ValueAnimator.AnimatorUpdateListener getCoplanarFinishAnimatorUpdateListener() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        View coplanarSiblingView = getCoplanarSiblingView();
        if (coplanarSiblingView == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) == null) {
            return null;
        }
        return new SideSheetBehavior$$ExternalSyntheticLambda2(this, marginLayoutParams, this.sheetDelegate.getCoplanarSiblingAdjacentMargin(marginLayoutParams), coplanarSiblingView);
    }

    private int getGravityFromSheetEdge() {
        return (this.sheetDelegate == null || this.sheetDelegate.getSheetEdge() == 0) ? 5 : 3;
    }

    private CoordinatorLayout.LayoutParams getViewLayoutParams() {
        V v;
        if (this.viewRef == null || (v = this.viewRef.get()) == null || !(v.getLayoutParams() instanceof CoordinatorLayout.LayoutParams)) {
            return null;
        }
        return (CoordinatorLayout.LayoutParams) v.getLayoutParams();
    }

    private boolean hasLeftMargin() {
        CoordinatorLayout.LayoutParams viewLayoutParams = getViewLayoutParams();
        return viewLayoutParams != null && viewLayoutParams.leftMargin > 0;
    }

    private boolean hasRightMargin() {
        CoordinatorLayout.LayoutParams viewLayoutParams = getViewLayoutParams();
        return viewLayoutParams != null && viewLayoutParams.rightMargin > 0;
    }

    private boolean isDraggedFarEnough(MotionEvent motionEvent) {
        return shouldHandleDraggingWithHelper() && calculateDragDistance((float) this.initialX, motionEvent.getX()) > ((float) this.viewDragHelper.getTouchSlop());
    }

    private boolean isExpandingOutwards(float f) {
        return this.sheetDelegate.isExpandingOutwards(f);
    }

    private boolean isLayingOut(V v) {
        ViewParent parent = v.getParent();
        return parent != null && parent.isLayoutRequested() && v.isAttachedToWindow();
    }

    private boolean isSettling(View view, int i, boolean z) {
        int outerEdgeOffsetForState = getOuterEdgeOffsetForState(i);
        ViewDragHelper viewDragHelper = getViewDragHelper();
        return viewDragHelper != null && (!z ? !viewDragHelper.smoothSlideViewTo(view, outerEdgeOffsetForState, view.getTop()) : !viewDragHelper.settleCapturedViewAt(outerEdgeOffsetForState, view.getTop()));
    }

    private void maybeAssignCoplanarSiblingViewBasedId(CoordinatorLayout coordinatorLayout) {
        View findViewById;
        if (this.coplanarSiblingViewRef != null || this.coplanarSiblingViewId == -1 || (findViewById = coordinatorLayout.findViewById(this.coplanarSiblingViewId)) == null) {
            return;
        }
        this.coplanarSiblingViewRef = new WeakReference<>(findViewById);
    }

    private void replaceAccessibilityActionForState(V v, AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat, int i) {
        ViewCompat.replaceAccessibilityAction(v, accessibilityActionCompat, null, createAccessibilityViewCommandForState(i));
    }

    private void resetVelocity() {
        if (this.velocityTracker != null) {
            this.velocityTracker.recycle();
            this.velocityTracker = null;
        }
    }

    private void runAfterLayout(V v, Runnable runnable) {
        if (isLayingOut(v)) {
            v.post(runnable);
        } else {
            runnable.run();
        }
    }

    private void setSheetEdge(int i) {
        if (this.sheetDelegate == null || this.sheetDelegate.getSheetEdge() != i) {
            if (i == 0) {
                this.sheetDelegate = new RightSheetDelegate(this);
                if (this.shapeAppearanceModel == null || hasRightMargin()) {
                    return;
                }
                ShapeAppearanceModel.Builder builder = this.shapeAppearanceModel.toBuilder();
                builder.setTopRightCornerSize(0.0f).setBottomRightCornerSize(0.0f);
                updateMaterialShapeDrawable(builder.build());
                return;
            }
            if (i != 1) {
                throw new IllegalArgumentException("Invalid sheet edge position value: " + i + ". Must be 0 or 1.");
            }
            this.sheetDelegate = new LeftSheetDelegate(this);
            if (this.shapeAppearanceModel == null || hasLeftMargin()) {
                return;
            }
            ShapeAppearanceModel.Builder builder2 = this.shapeAppearanceModel.toBuilder();
            builder2.setTopLeftCornerSize(0.0f).setBottomLeftCornerSize(0.0f);
            updateMaterialShapeDrawable(builder2.build());
        }
    }

    private void setSheetEdge(V v, int i) {
        setSheetEdge(Gravity.getAbsoluteGravity(((CoordinatorLayout.LayoutParams) v.getLayoutParams()).gravity, i) == 3 ? 1 : 0);
    }

    private boolean shouldHandleDraggingWithHelper() {
        return this.viewDragHelper != null && (this.draggable || this.state == 1);
    }

    private boolean shouldInterceptTouchEvent(V v) {
        return (v.isShown() || ViewCompat.getAccessibilityPaneTitle(v) != null) && this.draggable;
    }

    private void startSettling(View view, int i, boolean z) {
        if (!isSettling(view, i, z)) {
            setStateInternal(i);
        } else {
            setStateInternal(2);
            this.stateSettlingTracker.continueSettlingToState(i);
        }
    }

    private void updateAccessibilityActions() {
        V v;
        if (this.viewRef == null || (v = this.viewRef.get()) == null) {
            return;
        }
        ViewCompat.removeAccessibilityAction(v, 262144);
        ViewCompat.removeAccessibilityAction(v, 1048576);
        if (this.state != 5) {
            replaceAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_DISMISS, 5);
        }
        if (this.state != 3) {
            replaceAccessibilityActionForState(v, AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_EXPAND, 3);
        }
    }

    private void updateCoplanarSiblingBackProgress() {
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (this.viewRef == null || this.viewRef.get() == null) {
            return;
        }
        V v = this.viewRef.get();
        View coplanarSiblingView = getCoplanarSiblingView();
        if (coplanarSiblingView == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) coplanarSiblingView.getLayoutParams()) == null) {
            return;
        }
        this.sheetDelegate.updateCoplanarSiblingAdjacentMargin(marginLayoutParams, (int) ((this.childWidth * v.getScaleX()) + this.innerMargin));
        coplanarSiblingView.requestLayout();
    }

    private void updateMaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        if (this.materialShapeDrawable != null) {
            this.materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
    }

    private void updateSheetVisibility(View view) {
        int i = this.state == 5 ? 4 : 0;
        if (view.getVisibility() != i) {
            view.setVisibility(i);
        }
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public /* bridge */ /* synthetic */ void addCallback(SideSheetCallback sideSheetCallback) {
        addCallback2(sideSheetCallback);
    }

    /* renamed from: addCallback, reason: avoid collision after fix types in other method */
    public void addCallback2(SideSheetCallback sideSheetCallback) {
        this.callbacks.add(sideSheetCallback);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void cancelBackProgress() {
        if (this.sideContainerBackHelper == null) {
            return;
        }
        this.sideContainerBackHelper.cancelBackProgress();
    }

    public void expand() {
        setState(3);
    }

    MaterialSideContainerBackHelper getBackHelper() {
        return this.sideContainerBackHelper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getChildWidth() {
        return this.childWidth;
    }

    public View getCoplanarSiblingView() {
        if (this.coplanarSiblingViewRef != null) {
            return this.coplanarSiblingViewRef.get();
        }
        return null;
    }

    public int getExpandedOffset() {
        return this.sheetDelegate.getExpandedOffset();
    }

    public float getHideFriction() {
        return this.hideFriction;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getHideThreshold() {
        return 0.5f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getInnerMargin() {
        return this.innerMargin;
    }

    public int getLastStableState() {
        return this.lastStableState;
    }

    int getOuterEdgeOffsetForState(int i) {
        switch (i) {
            case 3:
                return getExpandedOffset();
            case 4:
            default:
                throw new IllegalArgumentException("Invalid state to get outer edge offset: " + i);
            case 5:
                return this.sheetDelegate.getHiddenOffset();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getParentInnerEdge() {
        return this.parentInnerEdge;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getParentWidth() {
        return this.parentWidth;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getSignificantVelocityThreshold() {
        return SIGNIFICANT_VEL_THRESHOLD;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public int getState() {
        return this.state;
    }

    ViewDragHelper getViewDragHelper() {
        return this.viewDragHelper;
    }

    float getXVelocity() {
        if (this.velocityTracker == null) {
            return 0.0f;
        }
        this.velocityTracker.computeCurrentVelocity(1000, this.maximumVelocity);
        return this.velocityTracker.getXVelocity();
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void handleBackInvoked() {
        if (this.sideContainerBackHelper == null) {
            return;
        }
        BackEventCompat onHandleBackInvoked = this.sideContainerBackHelper.onHandleBackInvoked();
        if (onHandleBackInvoked == null || Build.VERSION.SDK_INT < 34) {
            setState(5);
        } else {
            this.sideContainerBackHelper.finishBackProgress(onHandleBackInvoked, getGravityFromSheetEdge(), new AnonymousClass2(), getCoplanarFinishAnimatorUpdateListener());
        }
    }

    public void hide() {
        setState(5);
    }

    public boolean isDraggable() {
        return this.draggable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$createAccessibilityViewCommandForState$2$com-google-android-material-sidesheet-SideSheetBehavior, reason: not valid java name */
    public /* synthetic */ boolean m417x564aa398(int i, View view, AccessibilityViewCommand.CommandArguments commandArguments) {
        setState(i);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$getCoplanarFinishAnimatorUpdateListener$1$com-google-android-material-sidesheet-SideSheetBehavior, reason: not valid java name */
    public /* synthetic */ void m418xc3af8fb4(ViewGroup.MarginLayoutParams marginLayoutParams, int i, View view, ValueAnimator valueAnimator) {
        this.sheetDelegate.updateCoplanarSiblingAdjacentMargin(marginLayoutParams, AnimationUtils.lerp(i, 0, valueAnimator.getAnimatedFraction()));
        view.requestLayout();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setState$0$com-google-android-material-sidesheet-SideSheetBehavior, reason: not valid java name */
    public /* synthetic */ void m419xc0f1d0a9(int i) {
        V v = this.viewRef != null ? this.viewRef.get() : null;
        if (v != null) {
            startSettling(v, i, false);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
        super.onAttachedToLayoutParams(layoutParams);
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onDetachedFromLayoutParams() {
        super.onDetachedFromLayoutParams();
        this.viewRef = null;
        this.viewDragHelper = null;
        this.sideContainerBackHelper = null;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (!shouldInterceptTouchEvent(v)) {
            this.ignoreEvents = true;
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            resetVelocity();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        switch (actionMasked) {
            case 0:
                this.initialX = (int) motionEvent.getX();
                break;
            case 1:
            case 3:
                if (this.ignoreEvents) {
                    this.ignoreEvents = false;
                    return false;
                }
                break;
        }
        return (this.ignoreEvents || this.viewDragHelper == null || !this.viewDragHelper.shouldInterceptTouchEvent(motionEvent)) ? false : true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        if (coordinatorLayout.getFitsSystemWindows() && !v.getFitsSystemWindows()) {
            v.setFitsSystemWindows(true);
        }
        if (this.viewRef == null) {
            this.viewRef = new WeakReference<>(v);
            this.sideContainerBackHelper = new MaterialSideContainerBackHelper(v);
            if (this.materialShapeDrawable != null) {
                v.setBackground(this.materialShapeDrawable);
                this.materialShapeDrawable.setElevation(this.elevation == -1.0f ? v.getElevation() : this.elevation);
            } else if (this.backgroundTint != null) {
                ViewCompat.setBackgroundTintList(v, this.backgroundTint);
            }
            updateSheetVisibility(v);
            updateAccessibilityActions();
            if (v.getImportantForAccessibility() == 0) {
                v.setImportantForAccessibility(1);
            }
            ensureAccessibilityPaneTitleIsSet(v);
        }
        setSheetEdge(v, i);
        if (this.viewDragHelper == null) {
            this.viewDragHelper = ViewDragHelper.create(coordinatorLayout, this.dragCallback);
        }
        int outerEdge = this.sheetDelegate.getOuterEdge(v);
        coordinatorLayout.onLayoutChild(v, i);
        this.parentWidth = coordinatorLayout.getWidth();
        this.parentInnerEdge = this.sheetDelegate.getParentInnerEdge(coordinatorLayout);
        this.childWidth = v.getWidth();
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        this.innerMargin = marginLayoutParams != null ? this.sheetDelegate.calculateInnerMargin(marginLayoutParams) : 0;
        ViewCompat.offsetLeftAndRight(v, calculateCurrentOffset(outerEdge, v));
        maybeAssignCoplanarSiblingViewBasedId(coordinatorLayout);
        for (SideSheetCallback sideSheetCallback : this.callbacks) {
            if (sideSheetCallback instanceof SideSheetCallback) {
                sideSheetCallback.onLayout(v);
            }
        }
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3, int i4) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        v.measure(getChildMeasureSpec(i, coordinatorLayout.getPaddingLeft() + coordinatorLayout.getPaddingRight() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + i2, -1, marginLayoutParams.width), getChildMeasureSpec(i3, coordinatorLayout.getPaddingTop() + coordinatorLayout.getPaddingBottom() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin + i4, -1, marginLayoutParams.height));
        return true;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onRestoreInstanceState(CoordinatorLayout coordinatorLayout, V v, Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        if (savedState.getSuperState() != null) {
            super.onRestoreInstanceState(coordinatorLayout, v, savedState.getSuperState());
        }
        this.state = (savedState.state == 1 || savedState.state == 2) ? 5 : savedState.state;
        this.lastStableState = this.state;
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public Parcelable onSaveInstanceState(CoordinatorLayout coordinatorLayout, V v) {
        return new SavedState(super.onSaveInstanceState(coordinatorLayout, v), (SideSheetBehavior<?>) this);
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
            resetVelocity();
        }
        if (this.velocityTracker == null) {
            this.velocityTracker = VelocityTracker.obtain();
        }
        this.velocityTracker.addMovement(motionEvent);
        if (shouldHandleDraggingWithHelper() && actionMasked == 2 && !this.ignoreEvents && isDraggedFarEnough(motionEvent)) {
            this.viewDragHelper.captureChildView(v, motionEvent.getPointerId(motionEvent.getActionIndex()));
        }
        return !this.ignoreEvents;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public /* bridge */ /* synthetic */ void removeCallback(SideSheetCallback sideSheetCallback) {
        removeCallback2(sideSheetCallback);
    }

    /* renamed from: removeCallback, reason: avoid collision after fix types in other method */
    public void removeCallback2(SideSheetCallback sideSheetCallback) {
        this.callbacks.remove(sideSheetCallback);
    }

    public void setCoplanarSiblingView(View view) {
        this.coplanarSiblingViewId = -1;
        if (view == null) {
            clearCoplanarSiblingView();
            return;
        }
        this.coplanarSiblingViewRef = new WeakReference<>(view);
        if (this.viewRef != null) {
            V v = this.viewRef.get();
            if (v.isLaidOut()) {
                v.requestLayout();
            }
        }
    }

    public void setCoplanarSiblingViewId(int i) {
        this.coplanarSiblingViewId = i;
        clearCoplanarSiblingView();
        if (this.viewRef != null) {
            V v = this.viewRef.get();
            if (i == -1 || !v.isLaidOut()) {
                return;
            }
            v.requestLayout();
        }
    }

    public void setDraggable(boolean z) {
        this.draggable = z;
    }

    public void setHideFriction(float f) {
        this.hideFriction = f;
    }

    @Override // com.google.android.material.sidesheet.Sheet
    public void setState(int i) {
        if (i == 1 || i == 2) {
            throw new IllegalArgumentException("STATE_" + (i == 1 ? "DRAGGING" : "SETTLING") + " should not be set externally.");
        }
        if (this.viewRef == null || this.viewRef.get() == null) {
            setStateInternal(i);
        } else {
            runAfterLayout(this.viewRef.get(), new SideSheetBehavior$$ExternalSyntheticLambda0(this, i));
        }
    }

    void setStateInternal(int i) {
        V v;
        if (this.state == i) {
            return;
        }
        this.state = i;
        if (i == 3 || i == 5) {
            this.lastStableState = i;
        }
        if (this.viewRef == null || (v = this.viewRef.get()) == null) {
            return;
        }
        updateSheetVisibility(v);
        Iterator<SideSheetCallback> it = this.callbacks.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(v, i);
        }
        updateAccessibilityActions();
    }

    boolean shouldHide(View view, float f) {
        return this.sheetDelegate.shouldHide(view, f);
    }

    public boolean shouldSkipSmoothAnimation() {
        return true;
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void startBackProgress(BackEventCompat backEventCompat) {
        if (this.sideContainerBackHelper == null) {
            return;
        }
        this.sideContainerBackHelper.startBackProgress(backEventCompat);
    }

    @Override // com.google.android.material.motion.MaterialBackHandler
    public void updateBackProgress(BackEventCompat backEventCompat) {
        if (this.sideContainerBackHelper == null) {
            return;
        }
        this.sideContainerBackHelper.updateBackProgress(backEventCompat, getGravityFromSheetEdge());
        updateCoplanarSiblingBackProgress();
    }
}
