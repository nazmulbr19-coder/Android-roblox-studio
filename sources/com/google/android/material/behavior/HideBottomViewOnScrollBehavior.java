package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
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

@Deprecated
/* loaded from: classes.dex */
public class HideBottomViewOnScrollBehavior<V extends View> extends CoordinatorLayout.Behavior<V> {
    private static final int DEFAULT_ENTER_ANIMATION_DURATION_MS = 225;
    private static final int DEFAULT_EXIT_ANIMATION_DURATION_MS = 175;
    public static final int STATE_SCROLLED_DOWN = 1;
    public static final int STATE_SCROLLED_UP = 2;
    private AccessibilityManager accessibilityManager;
    private int additionalHiddenOffsetY;
    private ViewPropertyAnimator currentAnimator;
    private int currentState;
    private boolean disableOnTouchExploration;
    private int enterAnimDuration;
    private TimeInterpolator enterAnimInterpolator;
    private int exitAnimDuration;
    private TimeInterpolator exitAnimInterpolator;
    private int height;
    private final LinkedHashSet<OnScrollStateChangedListener> onScrollStateChangedListeners;
    private int savedImportantForAccessibility;
    private int savedVisibility;
    private AccessibilityManager.TouchExplorationStateChangeListener touchExplorationListener;
    private static final int ENTER_ANIM_DURATION_ATTR = R.attr.motionDurationLong2;
    private static final int EXIT_ANIM_DURATION_ATTR = R.attr.motionDurationMedium4;
    private static final int ENTER_EXIT_ANIM_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;

    /* renamed from: com.google.android.material.behavior.HideBottomViewOnScrollBehavior$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements View.OnAttachStateChangeListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewAttachedToWindow(View view) {
        }

        @Override // android.view.View.OnAttachStateChangeListener
        public void onViewDetachedFromWindow(View view) {
            if (HideBottomViewOnScrollBehavior.access$000(HideBottomViewOnScrollBehavior.this) == null || HideBottomViewOnScrollBehavior.access$100(HideBottomViewOnScrollBehavior.this) == null) {
                return;
            }
            HideBottomViewOnScrollBehavior.access$100(HideBottomViewOnScrollBehavior.this).removeTouchExplorationStateChangeListener(HideBottomViewOnScrollBehavior.access$000(HideBottomViewOnScrollBehavior.this));
            HideBottomViewOnScrollBehavior.access$002(HideBottomViewOnScrollBehavior.this, null);
        }
    }

    /* renamed from: com.google.android.material.behavior.HideBottomViewOnScrollBehavior$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ View val$child;

        AnonymousClass2(View view) {
            this.val$child = view;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            HideBottomViewOnScrollBehavior.access$202(HideBottomViewOnScrollBehavior.this, null);
            if (HideBottomViewOnScrollBehavior.access$300(HideBottomViewOnScrollBehavior.this) == 1 && this.val$child.getVisibility() == 0) {
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

    public HideBottomViewOnScrollBehavior() {
        this.onScrollStateChangedListeners = new LinkedHashSet<>();
        this.height = 0;
        this.disableOnTouchExploration = true;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
        this.savedImportantForAccessibility = 0;
        this.savedVisibility = 0;
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.onScrollStateChangedListeners = new LinkedHashSet<>();
        this.height = 0;
        this.disableOnTouchExploration = true;
        this.currentState = 2;
        this.additionalHiddenOffsetY = 0;
        this.savedImportantForAccessibility = 0;
        this.savedVisibility = 0;
    }

    static /* synthetic */ AccessibilityManager.TouchExplorationStateChangeListener access$000(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        return hideBottomViewOnScrollBehavior.touchExplorationListener;
    }

    static /* synthetic */ AccessibilityManager.TouchExplorationStateChangeListener access$002(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener) {
        hideBottomViewOnScrollBehavior.touchExplorationListener = touchExplorationStateChangeListener;
        return touchExplorationStateChangeListener;
    }

    static /* synthetic */ AccessibilityManager access$100(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        return hideBottomViewOnScrollBehavior.accessibilityManager;
    }

    static /* synthetic */ ViewPropertyAnimator access$202(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, ViewPropertyAnimator viewPropertyAnimator) {
        hideBottomViewOnScrollBehavior.currentAnimator = viewPropertyAnimator;
        return viewPropertyAnimator;
    }

    static /* synthetic */ int access$300(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        return hideBottomViewOnScrollBehavior.currentState;
    }

    private void animateChildTo(V v, int i, long j, TimeInterpolator timeInterpolator) {
        this.currentAnimator = v.animate().translationY(i).setInterpolator(timeInterpolator).setDuration(j).setListener(new AnonymousClass2(v));
    }

    private void disableIfTouchExplorationEnabled(V v) {
        if (this.accessibilityManager == null) {
            this.accessibilityManager = (AccessibilityManager) ContextCompat.getSystemService(v.getContext(), AccessibilityManager.class);
        }
        if (this.accessibilityManager == null || this.touchExplorationListener != null) {
            return;
        }
        this.touchExplorationListener = new HideBottomViewOnScrollBehavior$$ExternalSyntheticLambda0(this, v);
        this.accessibilityManager.addTouchExplorationStateChangeListener(this.touchExplorationListener);
        v.addOnAttachStateChangeListener(new AnonymousClass1());
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

    public boolean isScrolledDown() {
        return this.currentState == 1;
    }

    public boolean isScrolledUp() {
        return this.currentState == 2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$disableIfTouchExplorationEnabled$0$com-google-android-material-behavior-HideBottomViewOnScrollBehavior, reason: not valid java name */
    public /* synthetic */ void m319x79d795e8(View view, boolean z) {
        if (z && isScrolledDown()) {
            slideUp(view);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, V v, int i) {
        this.height = v.getMeasuredHeight() + ((ViewGroup.MarginLayoutParams) v.getLayoutParams()).bottomMargin;
        this.enterAnimDuration = MotionUtils.resolveThemeDuration(v.getContext(), ENTER_ANIM_DURATION_ATTR, DEFAULT_ENTER_ANIMATION_DURATION_MS);
        this.exitAnimDuration = MotionUtils.resolveThemeDuration(v.getContext(), EXIT_ANIM_DURATION_ATTR, DEFAULT_EXIT_ANIMATION_DURATION_MS);
        this.enterAnimInterpolator = MotionUtils.resolveThemeInterpolator(v.getContext(), ENTER_EXIT_ANIM_EASING_ATTR, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.exitAnimInterpolator = MotionUtils.resolveThemeInterpolator(v.getContext(), ENTER_EXIT_ANIM_EASING_ATTR, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        disableIfTouchExplorationEnabled(v);
        return super.onLayoutChild(coordinatorLayout, v, i);
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public void onNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, int i, int i2, int i3, int i4, int i5, int[] iArr) {
        if (i2 > 0) {
            slideDown(v);
        } else if (i2 < 0) {
            slideUp(v);
        }
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, V v, View view, View view2, int i, int i2) {
        return i == 2;
    }

    public void removeOnScrollStateChangedListener(OnScrollStateChangedListener onScrollStateChangedListener) {
        this.onScrollStateChangedListeners.remove(onScrollStateChangedListener);
    }

    public void setAdditionalHiddenOffsetY(V v, int i) {
        this.additionalHiddenOffsetY = i;
        if (this.currentState == 1) {
            v.setTranslationY(this.height + this.additionalHiddenOffsetY);
        }
    }

    public void slideDown(V v) {
        slideDown(v, true);
    }

    public void slideDown(V v, boolean z) {
        if (isScrolledDown()) {
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
        int i = this.height + this.additionalHiddenOffsetY;
        if (z) {
            animateChildTo(v, i, this.exitAnimDuration, this.exitAnimInterpolator);
            return;
        }
        v.setTranslationY(i);
        if (v.getVisibility() == 0) {
            v.setVisibility(4);
        }
    }

    public void slideUp(V v) {
        slideUp(v, true);
    }

    public void slideUp(V v, boolean z) {
        if (isScrolledUp()) {
            return;
        }
        updateCurrentState(v, 2);
        if (this.currentAnimator != null) {
            this.currentAnimator.cancel();
            v.clearAnimation();
        }
        if (z) {
            animateChildTo(v, 0, this.enterAnimDuration, this.enterAnimInterpolator);
        } else {
            v.setTranslationY(0);
        }
    }
}
