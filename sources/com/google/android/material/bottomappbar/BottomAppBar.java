package com.google.android.material.bottomappbar;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.TransformationCallback;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class BottomAppBar extends Toolbar implements CoordinatorLayout.AttachedBehavior {
    private static final int FAB_ALIGNMENT_ANIM_DURATION_DEFAULT = 300;
    private static final float FAB_ALIGNMENT_ANIM_EASING_MIDPOINT = 0.2f;
    public static final int FAB_ALIGNMENT_MODE_CENTER = 0;
    public static final int FAB_ALIGNMENT_MODE_END = 1;
    public static final int FAB_ANCHOR_MODE_CRADLE = 1;
    public static final int FAB_ANCHOR_MODE_EMBED = 0;
    public static final int FAB_ANIMATION_MODE_SCALE = 0;
    public static final int FAB_ANIMATION_MODE_SLIDE = 1;
    public static final int MENU_ALIGNMENT_MODE_AUTO = 0;
    public static final int MENU_ALIGNMENT_MODE_START = 1;
    private static final int NO_FAB_END_MARGIN = -1;
    private static final int NO_MENU_RES_ID = 0;
    private int animatingModeChangeCounter;
    private ArrayList<AnimationListener> animationListeners;
    private Behavior behavior;
    private int bottomInset;
    private int fabAlignmentMode;
    private int fabAlignmentModeEndMargin;
    private int fabAnchorMode;
    AnimatorListenerAdapter fabAnimationListener;
    private int fabAnimationMode;
    private boolean fabAttached;
    private final int fabOffsetEndMode;
    TransformationCallback<FloatingActionButton> fabTransformationCallback;
    private boolean hideOnScroll;
    private int leftInset;
    private final MaterialShapeDrawable materialShapeDrawable;
    private int menuAlignmentMode;
    private boolean menuAnimatingWithFabAlignmentMode;
    private Animator menuAnimator;
    private Animator modeAnimator;
    private Integer navigationIconTint;
    private final boolean paddingBottomSystemWindowInsets;
    private final boolean paddingLeftSystemWindowInsets;
    private final boolean paddingRightSystemWindowInsets;
    private int pendingMenuResId;
    private final boolean removeEmbeddedFabElevation;
    private int rightInset;
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_BottomAppBar;
    private static final int FAB_ALIGNMENT_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int FAB_ALIGNMENT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (BottomAppBar.access$000(BottomAppBar.this)) {
                return;
            }
            BottomAppBar.access$300(BottomAppBar.this, BottomAppBar.access$100(BottomAppBar.this), BottomAppBar.access$200(BottomAppBar.this));
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements TransformationCallback<FloatingActionButton> {
        AnonymousClass2() {
        }

        @Override // com.google.android.material.animation.TransformationCallback
        public /* bridge */ /* synthetic */ void onScaleChanged(FloatingActionButton floatingActionButton) {
            onScaleChanged2(floatingActionButton);
        }

        /* renamed from: onScaleChanged, reason: avoid collision after fix types in other method */
        public void onScaleChanged2(FloatingActionButton floatingActionButton) {
            BottomAppBar.access$500(BottomAppBar.this).setInterpolation((floatingActionButton.getVisibility() == 0 && BottomAppBar.access$400(BottomAppBar.this) == 1) ? floatingActionButton.getScaleY() : 0.0f);
        }

        @Override // com.google.android.material.animation.TransformationCallback
        public /* bridge */ /* synthetic */ void onTranslationChanged(FloatingActionButton floatingActionButton) {
            onTranslationChanged2(floatingActionButton);
        }

        /* renamed from: onTranslationChanged, reason: avoid collision after fix types in other method */
        public void onTranslationChanged2(FloatingActionButton floatingActionButton) {
            if (BottomAppBar.access$400(BottomAppBar.this) != 1) {
                return;
            }
            float translationX = floatingActionButton.getTranslationX();
            if (BottomAppBar.access$600(BottomAppBar.this).getHorizontalOffset() != translationX) {
                BottomAppBar.access$600(BottomAppBar.this).setHorizontalOffset(translationX);
                BottomAppBar.access$500(BottomAppBar.this).invalidateSelf();
            }
            float max = Math.max(0.0f, -floatingActionButton.getTranslationY());
            if (BottomAppBar.access$600(BottomAppBar.this).getCradleVerticalOffset() != max) {
                BottomAppBar.access$600(BottomAppBar.this).setCradleVerticalOffset(max);
                BottomAppBar.access$500(BottomAppBar.this).invalidateSelf();
            }
            BottomAppBar.access$500(BottomAppBar.this).setInterpolation(floatingActionButton.getVisibility() == 0 ? floatingActionButton.getScaleY() : 0.0f);
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements ViewUtils.OnApplyWindowInsetsListener {
        AnonymousClass3() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            boolean z = false;
            boolean z2 = false;
            if (BottomAppBar.access$700(BottomAppBar.this)) {
                BottomAppBar.access$802(BottomAppBar.this, windowInsetsCompat.getSystemWindowInsetBottom());
            }
            if (BottomAppBar.access$900(BottomAppBar.this)) {
                z = BottomAppBar.access$1000(BottomAppBar.this) != windowInsetsCompat.getSystemWindowInsetLeft();
                BottomAppBar.access$1002(BottomAppBar.this, windowInsetsCompat.getSystemWindowInsetLeft());
            }
            if (BottomAppBar.access$1100(BottomAppBar.this)) {
                z2 = BottomAppBar.access$1200(BottomAppBar.this) != windowInsetsCompat.getSystemWindowInsetRight();
                BottomAppBar.access$1202(BottomAppBar.this, windowInsetsCompat.getSystemWindowInsetRight());
            }
            if (z || z2) {
                BottomAppBar.access$1300(BottomAppBar.this);
                BottomAppBar.access$1400(BottomAppBar.this);
                BottomAppBar.access$1500(BottomAppBar.this);
            }
            return windowInsetsCompat;
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends AnimatorListenerAdapter {
        AnonymousClass4() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.access$1700(BottomAppBar.this);
            BottomAppBar.access$1802(BottomAppBar.this, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.access$1600(BottomAppBar.this);
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 extends FloatingActionButton.OnVisibilityChangedListener {
        final /* synthetic */ int val$targetMode;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$5$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 extends FloatingActionButton.OnVisibilityChangedListener {
            AnonymousClass1() {
            }

            @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
            public void onShown(FloatingActionButton floatingActionButton) {
                BottomAppBar.access$1700(BottomAppBar.this);
            }
        }

        AnonymousClass5(int i) {
            this.val$targetMode = i;
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.OnVisibilityChangedListener
        public void onHidden(FloatingActionButton floatingActionButton) {
            floatingActionButton.setTranslationX(BottomAppBar.access$1900(BottomAppBar.this, this.val$targetMode));
            floatingActionButton.show(new AnonymousClass1());
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$6, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 extends AnimatorListenerAdapter {
        AnonymousClass6() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            BottomAppBar.access$1700(BottomAppBar.this);
            BottomAppBar.access$002(BottomAppBar.this, false);
            BottomAppBar.access$2002(BottomAppBar.this, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.access$1600(BottomAppBar.this);
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$7, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass7 extends AnimatorListenerAdapter {
        public boolean cancelled;
        final /* synthetic */ ActionMenuView val$actionMenuView;
        final /* synthetic */ boolean val$targetAttached;
        final /* synthetic */ int val$targetMode;

        AnonymousClass7(ActionMenuView actionMenuView, int i, boolean z) {
            this.val$actionMenuView = actionMenuView;
            this.val$targetMode = i;
            this.val$targetAttached = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.cancelled = true;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.cancelled) {
                return;
            }
            boolean z = BottomAppBar.access$2100(BottomAppBar.this) != 0;
            BottomAppBar.this.replaceMenu(BottomAppBar.access$2100(BottomAppBar.this));
            BottomAppBar.access$2200(BottomAppBar.this, this.val$actionMenuView, this.val$targetMode, this.val$targetAttached, z);
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$8, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass8 implements Runnable {
        final /* synthetic */ ActionMenuView val$actionMenuView;
        final /* synthetic */ int val$fabAlignmentMode;
        final /* synthetic */ boolean val$fabAttached;

        AnonymousClass8(ActionMenuView actionMenuView, int i, boolean z) {
            this.val$actionMenuView = actionMenuView;
            this.val$fabAlignmentMode = i;
            this.val$fabAttached = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.val$actionMenuView.setTranslationX(BottomAppBar.this.getActionMenuViewTranslationX(this.val$actionMenuView, this.val$fabAlignmentMode, this.val$fabAttached));
        }
    }

    /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$9, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass9 extends AnimatorListenerAdapter {
        AnonymousClass9() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            BottomAppBar.this.fabAnimationListener.onAnimationStart(animator);
            FloatingActionButton access$2300 = BottomAppBar.access$2300(BottomAppBar.this);
            if (access$2300 != null) {
                access$2300.setTranslationX(BottomAppBar.access$2400(BottomAppBar.this));
            }
        }
    }

    /* loaded from: classes.dex */
    interface AnimationListener {
        void onAnimationEnd(BottomAppBar bottomAppBar);

        void onAnimationStart(BottomAppBar bottomAppBar);
    }

    /* loaded from: classes.dex */
    public static class Behavior extends HideBottomViewOnScrollBehavior<BottomAppBar> {
        private final Rect fabContentRect;
        private final View.OnLayoutChangeListener fabLayoutListener;
        private int originalBottomMargin;
        private WeakReference<BottomAppBar> viewRef;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$Behavior$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements View.OnLayoutChangeListener {
            AnonymousClass1() {
            }

            @Override // android.view.View.OnLayoutChangeListener
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                BottomAppBar bottomAppBar = (BottomAppBar) Behavior.access$2500(Behavior.this).get();
                if (bottomAppBar == null || !((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton))) {
                    view.removeOnLayoutChangeListener(this);
                    return;
                }
                int height = view.getHeight();
                if (view instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) view;
                    floatingActionButton.getMeasuredContentRect(Behavior.access$2600(Behavior.this));
                    height = Behavior.access$2600(Behavior.this).height();
                    bottomAppBar.setFabDiameter(height);
                    bottomAppBar.setFabCornerSize(floatingActionButton.getShapeAppearanceModel().getTopLeftCornerSize().getCornerSize(new RectF(Behavior.access$2600(Behavior.this))));
                }
                CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
                if (Behavior.access$2700(Behavior.this) == 0) {
                    if (BottomAppBar.access$400(bottomAppBar) == 1) {
                        layoutParams.bottomMargin = BottomAppBar.access$2800(bottomAppBar) + (bottomAppBar.getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fab_bottom_margin) - ((view.getMeasuredHeight() - height) / 2));
                    }
                    layoutParams.leftMargin = BottomAppBar.access$2900(bottomAppBar);
                    layoutParams.rightMargin = BottomAppBar.access$3000(bottomAppBar);
                    if (ViewUtils.isLayoutRtl(view)) {
                        layoutParams.leftMargin += BottomAppBar.access$3100(bottomAppBar);
                    } else {
                        layoutParams.rightMargin += BottomAppBar.access$3100(bottomAppBar);
                    }
                }
                BottomAppBar.access$1400(bottomAppBar);
            }
        }

        public Behavior() {
            this.fabLayoutListener = new AnonymousClass1();
            this.fabContentRect = new Rect();
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.fabLayoutListener = new AnonymousClass1();
            this.fabContentRect = new Rect();
        }

        static /* synthetic */ WeakReference access$2500(Behavior behavior) {
            return behavior.viewRef;
        }

        static /* synthetic */ Rect access$2600(Behavior behavior) {
            return behavior.fabContentRect;
        }

        static /* synthetic */ int access$2700(Behavior behavior) {
            return behavior.originalBottomMargin;
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return onLayoutChild(coordinatorLayout, (BottomAppBar) view, i);
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int i) {
            this.viewRef = new WeakReference<>(bottomAppBar);
            View access$3200 = BottomAppBar.access$3200(bottomAppBar);
            if (access$3200 != null && !access$3200.isLaidOut()) {
                BottomAppBar.access$3300(bottomAppBar, access$3200);
                this.originalBottomMargin = ((CoordinatorLayout.LayoutParams) access$3200.getLayoutParams()).bottomMargin;
                if (access$3200 instanceof FloatingActionButton) {
                    FloatingActionButton floatingActionButton = (FloatingActionButton) access$3200;
                    if (BottomAppBar.access$400(bottomAppBar) == 0 && BottomAppBar.access$3400(bottomAppBar)) {
                        floatingActionButton.setElevation(0.0f);
                        floatingActionButton.setCompatElevation(0.0f);
                    }
                    if (floatingActionButton.getShowMotionSpec() == null) {
                        floatingActionButton.setShowMotionSpecResource(R.animator.mtrl_fab_show_motion_spec);
                    }
                    if (floatingActionButton.getHideMotionSpec() == null) {
                        floatingActionButton.setHideMotionSpecResource(R.animator.mtrl_fab_hide_motion_spec);
                    }
                    BottomAppBar.access$3500(bottomAppBar, floatingActionButton);
                }
                access$3200.addOnLayoutChangeListener(this.fabLayoutListener);
                BottomAppBar.access$1400(bottomAppBar);
            }
            coordinatorLayout.onLayoutChild(bottomAppBar, i);
            return super.onLayoutChild(coordinatorLayout, (CoordinatorLayout) bottomAppBar, i);
        }

        @Override // com.google.android.material.behavior.HideBottomViewOnScrollBehavior, androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int i, int i2) {
            return onStartNestedScroll(coordinatorLayout, (BottomAppBar) view, view2, view3, i, i2);
        }

        public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int i, int i2) {
            return bottomAppBar.getHideOnScroll() && super.onStartNestedScroll(coordinatorLayout, (CoordinatorLayout) bottomAppBar, view, view2, i, i2);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FabAlignmentMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FabAnchorMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface FabAnimationMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface MenuAlignmentMode {
    }

    /* loaded from: classes.dex */
    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new AnonymousClass1();
        int fabAlignmentMode;
        boolean fabAttached;

        /* renamed from: com.google.android.material.bottomappbar.BottomAppBar$SavedState$1, reason: invalid class name */
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
            this.fabAlignmentMode = parcel.readInt();
            this.fabAttached = parcel.readInt() != 0;
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.fabAlignmentMode);
            parcel.writeInt(this.fabAttached ? 1 : 0);
        }
    }

    public BottomAppBar(Context context) {
        this(context, null);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.bottomAppBarStyle);
    }

    public BottomAppBar(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.materialShapeDrawable = new MaterialShapeDrawable();
        this.animatingModeChangeCounter = 0;
        this.pendingMenuResId = 0;
        this.menuAnimatingWithFabAlignmentMode = false;
        this.fabAttached = true;
        this.fabAnimationListener = new AnonymousClass1();
        this.fabTransformationCallback = new AnonymousClass2();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.BottomAppBar, i, DEF_STYLE_RES, new int[0]);
        ColorStateList colorStateList = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.BottomAppBar_backgroundTint);
        if (obtainStyledAttributes.hasValue(R.styleable.BottomAppBar_navigationIconTint)) {
            setNavigationIconTint(obtainStyledAttributes.getColor(R.styleable.BottomAppBar_navigationIconTint, -1));
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.BottomAppBar_elevation, 0);
        float dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleMargin, 0);
        float dimensionPixelOffset2 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleRoundedCornerRadius, 0);
        float dimensionPixelOffset3 = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabCradleVerticalOffset, 0);
        this.fabAlignmentMode = obtainStyledAttributes.getInt(R.styleable.BottomAppBar_fabAlignmentMode, 0);
        this.fabAnimationMode = obtainStyledAttributes.getInt(R.styleable.BottomAppBar_fabAnimationMode, 0);
        this.fabAnchorMode = obtainStyledAttributes.getInt(R.styleable.BottomAppBar_fabAnchorMode, 1);
        this.removeEmbeddedFabElevation = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_removeEmbeddedFabElevation, true);
        this.menuAlignmentMode = obtainStyledAttributes.getInt(R.styleable.BottomAppBar_menuAlignmentMode, 0);
        this.hideOnScroll = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_hideOnScroll, false);
        this.paddingBottomSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_paddingBottomSystemWindowInsets, false);
        this.paddingLeftSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_paddingLeftSystemWindowInsets, false);
        this.paddingRightSystemWindowInsets = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_paddingRightSystemWindowInsets, false);
        this.fabAlignmentModeEndMargin = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.BottomAppBar_fabAlignmentModeEndMargin, -1);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.BottomAppBar_addElevationShadow, true);
        obtainStyledAttributes.recycle();
        this.fabOffsetEndMode = getResources().getDimensionPixelOffset(R.dimen.mtrl_bottomappbar_fabOffsetEndMode);
        this.materialShapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setTopEdge(new BottomAppBarTopEdgeTreatment(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset3)).build());
        if (z) {
            this.materialShapeDrawable.setShadowCompatibilityMode(2);
        } else {
            this.materialShapeDrawable.setShadowCompatibilityMode(1);
            if (Build.VERSION.SDK_INT >= 28) {
                setOutlineAmbientShadowColor(0);
                setOutlineSpotShadowColor(0);
            }
        }
        this.materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
        this.materialShapeDrawable.initializeElevationOverlay(context2);
        this.materialShapeDrawable.setTintList(colorStateList);
        setElevation(dimensionPixelSize);
        setBackground(this.materialShapeDrawable);
        ViewUtils.doOnApplyWindowInsets(this, attributeSet, i, DEF_STYLE_RES, new AnonymousClass3());
    }

    static /* synthetic */ boolean access$000(BottomAppBar bottomAppBar) {
        return bottomAppBar.menuAnimatingWithFabAlignmentMode;
    }

    static /* synthetic */ boolean access$002(BottomAppBar bottomAppBar, boolean z) {
        bottomAppBar.menuAnimatingWithFabAlignmentMode = z;
        return z;
    }

    static /* synthetic */ int access$100(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAlignmentMode;
    }

    static /* synthetic */ int access$1000(BottomAppBar bottomAppBar) {
        return bottomAppBar.leftInset;
    }

    static /* synthetic */ int access$1002(BottomAppBar bottomAppBar, int i) {
        bottomAppBar.leftInset = i;
        return i;
    }

    static /* synthetic */ boolean access$1100(BottomAppBar bottomAppBar) {
        return bottomAppBar.paddingRightSystemWindowInsets;
    }

    static /* synthetic */ int access$1200(BottomAppBar bottomAppBar) {
        return bottomAppBar.rightInset;
    }

    static /* synthetic */ int access$1202(BottomAppBar bottomAppBar, int i) {
        bottomAppBar.rightInset = i;
        return i;
    }

    static /* synthetic */ void access$1300(BottomAppBar bottomAppBar) {
        bottomAppBar.cancelAnimations();
    }

    static /* synthetic */ void access$1400(BottomAppBar bottomAppBar) {
        bottomAppBar.setCutoutStateAndTranslateFab();
    }

    static /* synthetic */ void access$1500(BottomAppBar bottomAppBar) {
        bottomAppBar.setActionMenuViewPosition();
    }

    static /* synthetic */ void access$1600(BottomAppBar bottomAppBar) {
        bottomAppBar.dispatchAnimationStart();
    }

    static /* synthetic */ void access$1700(BottomAppBar bottomAppBar) {
        bottomAppBar.dispatchAnimationEnd();
    }

    static /* synthetic */ Animator access$1802(BottomAppBar bottomAppBar, Animator animator) {
        bottomAppBar.modeAnimator = animator;
        return animator;
    }

    static /* synthetic */ float access$1900(BottomAppBar bottomAppBar, int i) {
        return bottomAppBar.getFabTranslationX(i);
    }

    static /* synthetic */ boolean access$200(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAttached;
    }

    static /* synthetic */ Animator access$2002(BottomAppBar bottomAppBar, Animator animator) {
        bottomAppBar.menuAnimator = animator;
        return animator;
    }

    static /* synthetic */ int access$2100(BottomAppBar bottomAppBar) {
        return bottomAppBar.pendingMenuResId;
    }

    static /* synthetic */ void access$2200(BottomAppBar bottomAppBar, ActionMenuView actionMenuView, int i, boolean z, boolean z2) {
        bottomAppBar.translateActionMenuView(actionMenuView, i, z, z2);
    }

    static /* synthetic */ FloatingActionButton access$2300(BottomAppBar bottomAppBar) {
        return bottomAppBar.findDependentFab();
    }

    static /* synthetic */ float access$2400(BottomAppBar bottomAppBar) {
        return bottomAppBar.getFabTranslationX();
    }

    static /* synthetic */ int access$2800(BottomAppBar bottomAppBar) {
        return bottomAppBar.getBottomInset();
    }

    static /* synthetic */ int access$2900(BottomAppBar bottomAppBar) {
        return bottomAppBar.getLeftInset();
    }

    static /* synthetic */ void access$300(BottomAppBar bottomAppBar, int i, boolean z) {
        bottomAppBar.maybeAnimateMenuView(i, z);
    }

    static /* synthetic */ int access$3000(BottomAppBar bottomAppBar) {
        return bottomAppBar.getRightInset();
    }

    static /* synthetic */ int access$3100(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabOffsetEndMode;
    }

    static /* synthetic */ View access$3200(BottomAppBar bottomAppBar) {
        return bottomAppBar.findDependentView();
    }

    static /* synthetic */ void access$3300(BottomAppBar bottomAppBar, View view) {
        updateFabAnchorGravity(bottomAppBar, view);
    }

    static /* synthetic */ boolean access$3400(BottomAppBar bottomAppBar) {
        return bottomAppBar.removeEmbeddedFabElevation;
    }

    static /* synthetic */ void access$3500(BottomAppBar bottomAppBar, FloatingActionButton floatingActionButton) {
        bottomAppBar.addFabAnimationListeners(floatingActionButton);
    }

    static /* synthetic */ int access$400(BottomAppBar bottomAppBar) {
        return bottomAppBar.fabAnchorMode;
    }

    static /* synthetic */ MaterialShapeDrawable access$500(BottomAppBar bottomAppBar) {
        return bottomAppBar.materialShapeDrawable;
    }

    static /* synthetic */ BottomAppBarTopEdgeTreatment access$600(BottomAppBar bottomAppBar) {
        return bottomAppBar.getTopEdgeTreatment();
    }

    static /* synthetic */ boolean access$700(BottomAppBar bottomAppBar) {
        return bottomAppBar.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ int access$802(BottomAppBar bottomAppBar, int i) {
        bottomAppBar.bottomInset = i;
        return i;
    }

    static /* synthetic */ boolean access$900(BottomAppBar bottomAppBar) {
        return bottomAppBar.paddingLeftSystemWindowInsets;
    }

    private void addFabAnimationListeners(FloatingActionButton floatingActionButton) {
        floatingActionButton.addOnHideAnimationListener(this.fabAnimationListener);
        floatingActionButton.addOnShowAnimationListener(new AnonymousClass9());
        floatingActionButton.addTransformationCallback(this.fabTransformationCallback);
    }

    private void cancelAnimations() {
        if (this.menuAnimator != null) {
            this.menuAnimator.cancel();
        }
        if (this.modeAnimator != null) {
            this.modeAnimator.cancel();
        }
    }

    private void createFabTranslationXAnimation(int i, List<Animator> list) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(findDependentFab(), "translationX", getFabTranslationX(i));
        ofFloat.setDuration(getFabAlignmentAnimationDuration());
        list.add(ofFloat);
    }

    private void createMenuViewTranslationAnimation(int i, boolean z, List<Animator> list) {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null) {
            return;
        }
        float fabAlignmentAnimationDuration = getFabAlignmentAnimationDuration();
        Animator ofFloat = ObjectAnimator.ofFloat(actionMenuView, "alpha", 1.0f);
        ofFloat.setDuration(0.8f * fabAlignmentAnimationDuration);
        if (Math.abs(actionMenuView.getTranslationX() - getActionMenuViewTranslationX(actionMenuView, i, z)) <= 1.0f) {
            if (actionMenuView.getAlpha() < 1.0f) {
                list.add(ofFloat);
            }
        } else {
            ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(actionMenuView, "alpha", 0.0f);
            ofFloat2.setDuration(0.2f * fabAlignmentAnimationDuration);
            ofFloat2.addListener(new AnonymousClass7(actionMenuView, i, z));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playSequentially(ofFloat2, ofFloat);
            list.add(animatorSet);
        }
    }

    private void dispatchAnimationEnd() {
        int i = this.animatingModeChangeCounter - 1;
        this.animatingModeChangeCounter = i;
        if (i != 0 || this.animationListeners == null) {
            return;
        }
        Iterator<AnimationListener> it = this.animationListeners.iterator();
        while (it.hasNext()) {
            it.next().onAnimationEnd(this);
        }
    }

    private void dispatchAnimationStart() {
        int i = this.animatingModeChangeCounter;
        this.animatingModeChangeCounter = i + 1;
        if (i != 0 || this.animationListeners == null) {
            return;
        }
        Iterator<AnimationListener> it = this.animationListeners.iterator();
        while (it.hasNext()) {
            it.next().onAnimationStart(this);
        }
    }

    private FloatingActionButton findDependentFab() {
        View findDependentView = findDependentView();
        if (findDependentView instanceof FloatingActionButton) {
            return (FloatingActionButton) findDependentView;
        }
        return null;
    }

    private View findDependentView() {
        if (!(getParent() instanceof CoordinatorLayout)) {
            return null;
        }
        for (View view : ((CoordinatorLayout) getParent()).getDependents(this)) {
            if ((view instanceof FloatingActionButton) || (view instanceof ExtendedFloatingActionButton)) {
                return view;
            }
        }
        return null;
    }

    private ActionMenuView getActionMenuView() {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    private int getBottomInset() {
        return this.bottomInset;
    }

    private int getFabAlignmentAnimationDuration() {
        return MotionUtils.resolveThemeDuration(getContext(), FAB_ALIGNMENT_ANIM_DURATION_ATTR, 300);
    }

    private float getFabTranslationX() {
        return getFabTranslationX(this.fabAlignmentMode);
    }

    private float getFabTranslationX(int i) {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        if (i != 1) {
            return 0.0f;
        }
        View findDependentView = findDependentView();
        int i2 = isLayoutRtl ? this.leftInset : this.rightInset;
        return ((getMeasuredWidth() / 2) - ((this.fabAlignmentModeEndMargin == -1 || findDependentView == null) ? i2 + this.fabOffsetEndMode : i2 + ((findDependentView.getMeasuredWidth() / 2) + this.fabAlignmentModeEndMargin))) * (isLayoutRtl ? -1 : 1);
    }

    private float getFabTranslationY() {
        if (this.fabAnchorMode == 1) {
            return -getTopEdgeTreatment().getCradleVerticalOffset();
        }
        return findDependentView() != null ? (-((getMeasuredHeight() + getBottomInset()) - r0.getMeasuredHeight())) / 2 : 0;
    }

    private int getLeftInset() {
        return this.leftInset;
    }

    private int getRightInset() {
        return this.rightInset;
    }

    private BottomAppBarTopEdgeTreatment getTopEdgeTreatment() {
        return (BottomAppBarTopEdgeTreatment) this.materialShapeDrawable.getShapeAppearanceModel().getTopEdge();
    }

    private boolean isFabVisibleOrWillBeShown() {
        FloatingActionButton findDependentFab = findDependentFab();
        return findDependentFab != null && findDependentFab.isOrWillBeShown();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$onLayout$0(View view) {
        view.requestLayout();
    }

    private void maybeAnimateMenuView(int i, boolean z) {
        if (!isLaidOut()) {
            this.menuAnimatingWithFabAlignmentMode = false;
            replaceMenu(this.pendingMenuResId);
            return;
        }
        if (this.menuAnimator != null) {
            this.menuAnimator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (!isFabVisibleOrWillBeShown()) {
            i = 0;
            z = false;
        }
        createMenuViewTranslationAnimation(i, z, arrayList);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        this.menuAnimator = animatorSet;
        this.menuAnimator.addListener(new AnonymousClass6());
        this.menuAnimator.start();
    }

    private void maybeAnimateModeChange(int i) {
        if (this.fabAlignmentMode == i || !isLaidOut()) {
            return;
        }
        if (this.modeAnimator != null) {
            this.modeAnimator.cancel();
        }
        ArrayList arrayList = new ArrayList();
        if (this.fabAnimationMode == 1) {
            createFabTranslationXAnimation(i, arrayList);
        } else {
            createFabDefaultXAnimation(i, arrayList);
        }
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(arrayList);
        animatorSet.setInterpolator(MotionUtils.resolveThemeInterpolator(getContext(), FAB_ALIGNMENT_ANIM_EASING_ATTR, AnimationUtils.LINEAR_INTERPOLATOR));
        this.modeAnimator = animatorSet;
        this.modeAnimator.addListener(new AnonymousClass4());
        this.modeAnimator.start();
    }

    private Drawable maybeTintNavigationIcon(Drawable drawable) {
        if (drawable == null || this.navigationIconTint == null) {
            return drawable;
        }
        Drawable wrap = DrawableCompat.wrap(drawable.mutate());
        wrap.setTint(this.navigationIconTint.intValue());
        return wrap;
    }

    private void setActionMenuViewPosition() {
        ActionMenuView actionMenuView = getActionMenuView();
        if (actionMenuView == null || this.menuAnimator != null) {
            return;
        }
        actionMenuView.setAlpha(1.0f);
        if (isFabVisibleOrWillBeShown()) {
            translateActionMenuView(actionMenuView, this.fabAlignmentMode, this.fabAttached);
        } else {
            translateActionMenuView(actionMenuView, 0, false);
        }
    }

    private void setCutoutStateAndTranslateFab() {
        getTopEdgeTreatment().setHorizontalOffset(getFabTranslationX());
        this.materialShapeDrawable.setInterpolation((this.fabAttached && isFabVisibleOrWillBeShown() && this.fabAnchorMode == 1) ? 1.0f : 0.0f);
        View findDependentView = findDependentView();
        if (findDependentView != null) {
            findDependentView.setTranslationY(getFabTranslationY());
            findDependentView.setTranslationX(getFabTranslationX());
        }
    }

    private void translateActionMenuView(ActionMenuView actionMenuView, int i, boolean z) {
        translateActionMenuView(actionMenuView, i, z, false);
    }

    private void translateActionMenuView(ActionMenuView actionMenuView, int i, boolean z, boolean z2) {
        AnonymousClass8 anonymousClass8 = new AnonymousClass8(actionMenuView, i, z);
        if (z2) {
            actionMenuView.post(anonymousClass8);
        } else {
            anonymousClass8.run();
        }
    }

    private static void updateFabAnchorGravity(BottomAppBar bottomAppBar, View view) {
        CoordinatorLayout.LayoutParams layoutParams = (CoordinatorLayout.LayoutParams) view.getLayoutParams();
        layoutParams.anchorGravity = 17;
        if (bottomAppBar.fabAnchorMode == 1) {
            layoutParams.anchorGravity |= 48;
        }
        if (bottomAppBar.fabAnchorMode == 0) {
            layoutParams.anchorGravity |= 80;
        }
    }

    void addAnimationListener(AnimationListener animationListener) {
        if (this.animationListeners == null) {
            this.animationListeners = new ArrayList<>();
        }
        this.animationListeners.add(animationListener);
    }

    public void addOnScrollStateChangedListener(HideBottomViewOnScrollBehavior.OnScrollStateChangedListener onScrollStateChangedListener) {
        getBehavior().addOnScrollStateChangedListener(onScrollStateChangedListener);
    }

    public void clearOnScrollStateChangedListeners() {
        getBehavior().clearOnScrollStateChangedListeners();
    }

    protected void createFabDefaultXAnimation(int i, List<Animator> list) {
        FloatingActionButton findDependentFab = findDependentFab();
        if (findDependentFab == null || findDependentFab.isOrWillBeHidden()) {
            return;
        }
        dispatchAnimationStart();
        findDependentFab.hide(new AnonymousClass5(i));
    }

    protected int getActionMenuViewTranslationX(ActionMenuView actionMenuView, int i, boolean z) {
        if (this.menuAlignmentMode != 1 && (i != 1 || !z)) {
            return 0;
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        int measuredWidth = isLayoutRtl ? getMeasuredWidth() : 0;
        for (int i2 = 0; i2 < getChildCount(); i2++) {
            View childAt = getChildAt(i2);
            if ((childAt.getLayoutParams() instanceof Toolbar.LayoutParams) && (((Toolbar.LayoutParams) childAt.getLayoutParams()).gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK) == 8388611) {
                measuredWidth = isLayoutRtl ? Math.min(measuredWidth, childAt.getLeft()) : Math.max(measuredWidth, childAt.getRight());
            }
        }
        int right = isLayoutRtl ? actionMenuView.getRight() : actionMenuView.getLeft();
        int i3 = isLayoutRtl ? this.rightInset : -this.leftInset;
        int i4 = 0;
        if (getNavigationIcon() == null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_bottomappbar_horizontal_padding);
            i4 = isLayoutRtl ? dimensionPixelOffset : -dimensionPixelOffset;
        }
        return measuredWidth - ((right + i3) + i4);
    }

    public ColorStateList getBackgroundTint() {
        return this.materialShapeDrawable.getTintList();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public /* bridge */ /* synthetic */ CoordinatorLayout.Behavior getBehavior() {
        return getBehavior();
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public Behavior getBehavior() {
        if (this.behavior == null) {
            this.behavior = new Behavior();
        }
        return this.behavior;
    }

    public float getCradleVerticalOffset() {
        return getTopEdgeTreatment().getCradleVerticalOffset();
    }

    public int getFabAlignmentMode() {
        return this.fabAlignmentMode;
    }

    public int getFabAlignmentModeEndMargin() {
        return this.fabAlignmentModeEndMargin;
    }

    public int getFabAnchorMode() {
        return this.fabAnchorMode;
    }

    public int getFabAnimationMode() {
        return this.fabAnimationMode;
    }

    public float getFabCradleMargin() {
        return getTopEdgeTreatment().getFabCradleMargin();
    }

    public float getFabCradleRoundedCornerRadius() {
        return getTopEdgeTreatment().getFabCradleRoundedCornerRadius();
    }

    public boolean getHideOnScroll() {
        return this.hideOnScroll;
    }

    public int getMenuAlignmentMode() {
        return this.menuAlignmentMode;
    }

    public boolean isScrolledDown() {
        return getBehavior().isScrolledDown();
    }

    public boolean isScrolledUp() {
        return getBehavior().isScrolledUp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(this, this.materialShapeDrawable);
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).setClipChildren(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            cancelAnimations();
            setCutoutStateAndTranslateFab();
            View findDependentView = findDependentView();
            if (findDependentView != null && findDependentView.isLaidOut()) {
                findDependentView.post(new BottomAppBar$$ExternalSyntheticLambda0(findDependentView));
            }
        }
        setActionMenuViewPosition();
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
        this.fabAlignmentMode = savedState.fabAlignmentMode;
        this.fabAttached = savedState.fabAttached;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.Toolbar, android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.fabAlignmentMode = this.fabAlignmentMode;
        savedState.fabAttached = this.fabAttached;
        return savedState;
    }

    public void performHide() {
        performHide(true);
    }

    public void performHide(boolean z) {
        getBehavior().slideDown(this, z);
    }

    public void performShow() {
        performShow(true);
    }

    public void performShow(boolean z) {
        getBehavior().slideUp(this, z);
    }

    void removeAnimationListener(AnimationListener animationListener) {
        if (this.animationListeners == null) {
            return;
        }
        this.animationListeners.remove(animationListener);
    }

    public void removeOnScrollStateChangedListener(HideBottomViewOnScrollBehavior.OnScrollStateChangedListener onScrollStateChangedListener) {
        getBehavior().removeOnScrollStateChangedListener(onScrollStateChangedListener);
    }

    public void replaceMenu(int i) {
        if (i != 0) {
            this.pendingMenuResId = 0;
            getMenu().clear();
            inflateMenu(i);
        }
    }

    public void setBackgroundTint(ColorStateList colorStateList) {
        this.materialShapeDrawable.setTintList(colorStateList);
    }

    public void setCradleVerticalOffset(float f) {
        if (f != getCradleVerticalOffset()) {
            getTopEdgeTreatment().setCradleVerticalOffset(f);
            this.materialShapeDrawable.invalidateSelf();
            setCutoutStateAndTranslateFab();
        }
    }

    @Override // android.view.View
    public void setElevation(float f) {
        this.materialShapeDrawable.setElevation(f);
        getBehavior().setAdditionalHiddenOffsetY(this, this.materialShapeDrawable.getShadowRadius() - this.materialShapeDrawable.getShadowOffsetY());
    }

    public void setFabAlignmentMode(int i) {
        setFabAlignmentModeAndReplaceMenu(i, 0);
    }

    public void setFabAlignmentModeAndReplaceMenu(int i, int i2) {
        this.pendingMenuResId = i2;
        this.menuAnimatingWithFabAlignmentMode = true;
        maybeAnimateMenuView(i, this.fabAttached);
        maybeAnimateModeChange(i);
        this.fabAlignmentMode = i;
    }

    public void setFabAlignmentModeEndMargin(int i) {
        if (this.fabAlignmentModeEndMargin != i) {
            this.fabAlignmentModeEndMargin = i;
            setCutoutStateAndTranslateFab();
        }
    }

    public void setFabAnchorMode(int i) {
        this.fabAnchorMode = i;
        setCutoutStateAndTranslateFab();
        View findDependentView = findDependentView();
        if (findDependentView != null) {
            updateFabAnchorGravity(this, findDependentView);
            findDependentView.requestLayout();
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabAnimationMode(int i) {
        this.fabAnimationMode = i;
    }

    void setFabCornerSize(float f) {
        if (f != getTopEdgeTreatment().getFabCornerRadius()) {
            getTopEdgeTreatment().setFabCornerSize(f);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleMargin(float f) {
        if (f != getFabCradleMargin()) {
            getTopEdgeTreatment().setFabCradleMargin(f);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    public void setFabCradleRoundedCornerRadius(float f) {
        if (f != getFabCradleRoundedCornerRadius()) {
            getTopEdgeTreatment().setFabCradleRoundedCornerRadius(f);
            this.materialShapeDrawable.invalidateSelf();
        }
    }

    boolean setFabDiameter(int i) {
        if (i == getTopEdgeTreatment().getFabDiameter()) {
            return false;
        }
        getTopEdgeTreatment().setFabDiameter(i);
        this.materialShapeDrawable.invalidateSelf();
        return true;
    }

    public void setHideOnScroll(boolean z) {
        this.hideOnScroll = z;
    }

    public void setMenuAlignmentMode(int i) {
        if (this.menuAlignmentMode != i) {
            this.menuAlignmentMode = i;
            ActionMenuView actionMenuView = getActionMenuView();
            if (actionMenuView != null) {
                translateActionMenuView(actionMenuView, this.fabAlignmentMode, isFabVisibleOrWillBeShown());
            }
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setNavigationIcon(Drawable drawable) {
        super.setNavigationIcon(maybeTintNavigationIcon(drawable));
    }

    public void setNavigationIconTint(int i) {
        this.navigationIconTint = Integer.valueOf(i);
        Drawable navigationIcon = getNavigationIcon();
        if (navigationIcon != null) {
            setNavigationIcon(navigationIcon);
        }
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setSubtitle(CharSequence charSequence) {
    }

    @Override // androidx.appcompat.widget.Toolbar
    public void setTitle(CharSequence charSequence) {
    }
}
