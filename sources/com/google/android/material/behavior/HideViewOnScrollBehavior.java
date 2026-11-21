package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import android.view.accessibility.AccessibilityManager;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.motion.MotionUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

/* loaded from: classes.dex */
public class HideViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int DEFAULT_ENTER_ANIMATION_DURATION_MS = 225;
    private static final int DEFAULT_EXIT_ANIMATION_DURATION_MS = 175;
    public static final int EDGE_BOTTOM = 1;
    public static final int EDGE_LEFT = 2;
    public static final int EDGE_RIGHT = 0;
    public static final int STATE_SCROLLED_IN = 2;
    public static final int STATE_SCROLLED_OUT = 1;
    private AccessibilityManager accessibilityManager;
    private int additionalHiddenOffset;
    private ViewPropertyAnimator currentAnimator;
    private int currentState;
    private boolean disableOnTouchExploration;
    private int enterAnimDuration;
    private TimeInterpolator enterAnimInterpolator;
    private int exitAnimDuration;
    private TimeInterpolator exitAnimInterpolator;
    private HideViewOnScrollDelegate hideOnScrollViewDelegate;
    private final LinkedHashSet<OnScrollStateChangedListener> onScrollStateChangedListeners;
    private int savedImportantForAccessibility;
    private int savedVisibility;
    private int size;
    private AccessibilityManager.TouchExplorationStateChangeListener touchExplorationListener;
    private boolean viewEdgeOverride;
    private static final int ENTER_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int EXIT_ANIM_DURATION_ATTR = R.attr.motionDurationMedium4;
    private static final int ENTER_EXIT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: com.google.android.material.behavior.HideViewOnScrollBehavior$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (HideViewOnScrollBehavior.access$000(HideViewOnScrollBehavior.this) == null || HideViewOnScrollBehavior.access$100(HideViewOnScrollBehavior.this) == null) {
                return;
            }
            HideViewOnScrollBehavior.access$100(HideViewOnScrollBehavior.this).removeTouchExplorationStateChangeListener(HideViewOnScrollBehavior.access$000(HideViewOnScrollBehavior.this));
            HideViewOnScrollBehavior.access$002(HideViewOnScrollBehavior.this, null);
        }
    }

    /* renamed from: com.google.android.material.behavior.HideViewOnScrollBehavior$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ View val$child;

        AnonymousClass2(View view) {
            this.val$child = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideViewOnScrollBehavior.access$202(HideViewOnScrollBehavior.this, null);
            if (HideViewOnScrollBehavior.access$300(HideViewOnScrollBehavior.this) == 1 && this.val$child.getVisibility() == 0) {
                this.val$child.setVisibility(4);
            }
        }
    }

    /* loaded from: classes.dex */
    public interface OnScrollStateChangedListener {
        void onStateChanged(View view, int i);
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface ScrollState {
    }

    public HideViewOnScrollBehavior() {
        this.disableOnTouchExploration = true;
        this.onScrollStateChangedListeners = new LinkedHashSet<>();
        this.size = 0;
        this.currentState = 2;
        this.additionalHiddenOffset = 0;
        this.savedImportantForAccessibility = 0;
        this.savedVisibility = 0;
        this.viewEdgeOverride = false;
    }

    public HideViewOnScrollBehavior(int i) {
        this();
        setViewEdge(i);
    }

    public HideViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.disableOnTouchExploration = true;
        this.onScrollStateChangedListeners = new LinkedHashSet<>();
        this.size = 0;
        this.currentState = 2;
        this.additionalHiddenOffset = 0;
        this.savedImportantForAccessibility = 0;
        this.savedVisibility = 0;
        this.viewEdgeOverride = false;
    }

    static /* synthetic */ AccessibilityManager.TouchExplorationStateChangeListener access$000(HideViewOnScrollBehavior hideViewOnScrollBehavior) {
        return hideViewOnScrollBehavior.touchExplorationListener;
    }

    static /* synthetic */ AccessibilityManager.TouchExplorationStateChangeListener access$002(HideViewOnScrollBehavior hideViewOnScrollBehavior, AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        hideViewOnScrollBehavior.touchExplorationListener = touchExplorationStateChangeListener;
        return touchExplorationStateChangeListener;
    }

    static /* synthetic */ AccessibilityManager access$100(HideViewOnScrollBehavior hideViewOnScrollBehavior) {
        return hideViewOnScrollBehavior.accessibilityManager;
    }

    static /* synthetic */ ViewPropertyAnimator access$202(HideViewOnScrollBehavior hideViewOnScrollBehavior, ViewPropertyAnimator viewPropertyAnimator) {
        hideViewOnScrollBehavior.currentAnimator = viewPropertyAnimator;
        return viewPropertyAnimator;
    }

    static /* synthetic */ int access$300(HideViewOnScrollBehavior hideViewOnScrollBehavior) {
        return hideViewOnScrollBehavior.currentState;
    }

    private void animateChildTo(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.currentAnimator = this.hideOnScrollViewDelegate.getViewTranslationAnimator(v, i).setInterpolator(timeInterpolator).setDuration(j).setListener(new AnonymousClass2(v));
    }

    private void disableIfTouchExplorationEnabled(V v) {
        if (this.accessibilityManager == null) {
            this.accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(v.getContext(), AccessibilityManager.class);
        }
        if (this.accessibilityManager == null || this.touchExplorationListener != null) {
            return;
        }
        this.touchExplorationListener = new HideViewOnScrollBehavior$$ExternalSyntheticLambda0(this, v);
        this.accessibilityManager.addTouchExplorationStateChangeListener(this.touchExplorationListener);
        v.addOnAttachStateChangeListener(new AnonymousClass1());
    }

    public static <V extends View> HideViewOnScrollBehavior<V> from(V v) {
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        if (!(layoutParams instanceof CoordinatorLayout.LayoutParams)) {
            throw new IllegalArgumentException("The view is not a child of CoordinatorLayout");
        }
        CoordinatorLayout.Behavior behavior = ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior();
        if (behavior instanceof HideViewOnScrollBehavior) {
            return (HideViewOnScrollBehavior) behavior;
        }
        throw new IllegalArgumentException("The view is not associated with HideViewOnScrollBehavior");
    }

    private boolean isGravityBottom(int i) {
        return i == 80 || i == 81;
    }

    private boolean isGravityLeft(int i) {
        return i == 3 || i == 19;
    }

    private void setViewEdge(V v, int i) {
        if (this.viewEdgeOverride) {
            return;
        }
        int i2 = ((CoordinatorLayout.LayoutParams) v.getLayoutParams()).gravity;
        if (isGravityBottom(i2)) {
            setViewEdgeInternal(1);
        } else {
            setViewEdgeInternal(isGravityLeft(Gravity.getAbsoluteGravity(i2, i)) ? 2 : 0);
        }
    }

    private void setViewEdgeInternal(int i) {
        if (this.hideOnScrollViewDelegate == null || this.hideOnScrollViewDelegate.getViewEdge() != i) {
            switch (i) {
                case 0:
                    this.hideOnScrollViewDelegate = new HideRightViewOnScrollDelegate();
                    return;
                case 1:
                    this.hideOnScrollViewDelegate = new HideBottomViewOnScrollDelegate();
                    return;
                case 2:
                    this.hideOnScrollViewDelegate = new HideLeftViewOnScrollDelegate();
                    return;
                default:
                    throw new IllegalArgumentException("Invalid view edge position value: " + i + ". Must be 0, 1 or 2.");
            }
        }
    }

    private void updateCurrentState(V v, int i) {
        this.currentState = i;
        updateViewPropertiesForState(v, this.currentState);
        Iterator<OnScrollStateChangedListener> it = this.onScrollStateChangedListeners.iterator();
        while (it.hasNext()) {
            it.next().onStateChanged(v, this.currentState);
        }
    }

    private void updateViewPropertiesForState(V v, int i) {
        if (i == 1) {
            if (v.hasFocus()) {
                v.clearFocus();
            }
            if (v.getImportantForAccessibility() != 4) {
                this.savedImportantForAccessibility = v.getImportantForAccessibility();
            }
            if (v.getVisibility() != 4) {
                this.savedVisibility = v.getVisibility();
            }
            v.setImportantForAccessibility(4);
            return;
        }
        if (i == 2) {
            if (v.getImportantForAccessibility() == 4) {
                v.setImportantForAccessibility(this.savedImportantForAccessibility);
            }
            if (v.getVisibility() == 4) {
                v.setVisibility(this.savedVisibility);
            }
        }
    }

    public void addOnScrollStateChangedListener(OnScrollStateChangedListener onScrollStateChangedListener) {
        this.onScrollStateChangedListeners.add(onScrollStateChangedListener);
    }

    public void clearOnScrollStateChangedListeners() {
        this.onScrollStateChangedListeners.clear();
    }

    public void disableOnTouchExploration(boolean z) {
        this.disableOnTouchExploration = z;
    }

    public boolean isDisabledOnTouchExploration() {
        return this.disableOnTouchExploration;
    }

    public boolean isScrolledIn() {
        return this.currentState == 2;
    }

    public boolean isScrolledOut() {
        return this.currentState == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$disableIfTouchExplorationEnabled$0$com-google-android-material-behavior-HideViewOnScrollBehavior, reason: not valid java name */
    public /* synthetic */ void m320xa484d69d(View view, boolean z) {
        if (this.disableOnTouchExploration && z && isScrolledOut()) {
            slideIn(view);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        disableIfTouchExplorationEnabled(v);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) v.getLayoutParams();
        setViewEdge(v, i);
        this.size = this.hideOnScrollViewDelegate.getSize(v, marginLayoutParams);
        this.enterAnimDuration = MotionUtils.resolveThemeDuration(v.getContext(), ENTER_ANIM_DURATION_ATTR, DEFAULT_ENTER_ANIMATION_DURATION_MS);
        this.exitAnimDuration = MotionUtils.resolveThemeDuration(v.getContext(), EXIT_ANIM_DURATION_ATTR, DEFAULT_EXIT_ANIMATION_DURATION_MS);
        this.enterAnimInterpolator = MotionUtils.resolveThemeInterpolator(v.getContext(), ENTER_EXIT_ANIM_EASING_ATTR, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = MotionUtils.resolveThemeInterpolator(v.getContext(), ENTER_EXIT_ANIM_EASING_ATTR, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        return super.onLayoutChild(coordinatorLayout, v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            slideOut(v);
        } else if (i2 < 0) {
            slideIn(v);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        return i == 2;
    }

    public void removeOnScrollStateChangedListener(OnScrollStateChangedListener onScrollStateChangedListener) {
        this.onScrollStateChangedListeners.remove(onScrollStateChangedListener);
    }

    public void setAdditionalHiddenOffset(V v, int i) {
        this.additionalHiddenOffset = i;
        if (this.currentState == 1) {
            this.hideOnScrollViewDelegate.setAdditionalHiddenOffset(v, this.size, this.additionalHiddenOffset);
        }
    }

    public void setViewEdge(int i) {
        this.viewEdgeOverride = true;
        setViewEdgeInternal(i);
    }

    public void slideIn(V v) {
        slideIn(v, true);
    }

    public void slideIn(V v, boolean z) {
        if (isScrolledIn()) {
            return;
        }
        updateCurrentState(v, 2);
        if (this.currentAnimator != null) {
            this.currentAnimator.cancel();
            v.clearAnimation();
        }
        int targetTranslation = this.hideOnScrollViewDelegate.getTargetTranslation();
        if (z) {
            animateChildTo(v, targetTranslation, this.enterAnimDuration, this.enterAnimInterpolator);
        } else {
            this.hideOnScrollViewDelegate.setViewTranslation(v, targetTranslation);
        }
    }

    public void slideOut(V v) {
        slideOut(v, true);
    }

    public void slideOut(V v, boolean z) {
        if (isScrolledOut()) {
            return;
        }
        if (this.disableOnTouchExploration && this.accessibilityManager != null && this.accessibilityManager.isTouchExplorationEnabled()) {
            return;
        }
        if (this.currentAnimator != null) {
            this.currentAnimator.cancel();
            v.clearAnimation();
        }
        updateCurrentState(v, 1);
        int i = this.size + this.additionalHiddenOffset;
        if (z) {
            animateChildTo(v, i, this.exitAnimDuration, this.exitAnimInterpolator);
            return;
        }
        this.hideOnScrollViewDelegate.setViewTranslation(v, i);
        if (v.getVisibility() == 0) {
            v.setVisibility(4);
        }
    }
}
