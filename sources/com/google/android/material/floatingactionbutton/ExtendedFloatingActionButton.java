package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Property;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.R;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ExtendedFloatingActionButton extends MaterialButton implements CoordinatorLayout.AttachedBehavior {
    private static final int ANIM_STATE_HIDING = 1;
    private static final int ANIM_STATE_NONE = 0;
    private static final int ANIM_STATE_SHOWING = 2;
    private static final int EXTEND = 3;
    private static final int EXTEND_STRATEGY_AUTO = 0;
    private static final int EXTEND_STRATEGY_MATCH_PARENT = 2;
    private static final int EXTEND_STRATEGY_WRAP_CONTENT = 1;
    private static final int HIDE = 1;
    private static final int SHOW = 0;
    private static final int SHRINK = 2;
    private int animState;
    private boolean animateShowBeforeLayout;
    private boolean animationEnabled;
    private final CoordinatorLayout.Behavior<ExtendedFloatingActionButton> behavior;
    private final AnimatorTracker changeVisibilityTracker;
    private int collapsedSize;
    private final MotionStrategy extendStrategy;
    private final int extendStrategyType;
    private int extendedPaddingEnd;
    private int extendedPaddingStart;
    private final MotionStrategy hideStrategy;
    private boolean isExtended;
    private boolean isTransforming;
    private int originalHeight;
    protected ColorStateList originalTextCsl;
    private int originalWidth;
    private final MotionStrategy showStrategy;
    private final MotionStrategy shrinkStrategy;
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_ExtendedFloatingActionButton_Icon;
    static final Property<View, Float> WIDTH = new AnonymousClass6(Float.class, "width");
    static final Property<View, Float> HEIGHT = new AnonymousClass7(Float.class, "height");
    static final Property<View, Float> PADDING_START = new AnonymousClass8(Float.class, "paddingStart");
    static final Property<View, Float> PADDING_END = new AnonymousClass9(Float.class, "paddingEnd");

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Size {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(getWidth(), getHeight());
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.this.getCollapsedPadding();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getWidth() {
            return ExtendedFloatingActionButton.this.getCollapsedSize();
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Size {
        AnonymousClass2() {
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getHeight() {
            return ExtendedFloatingActionButton.this.getMeasuredHeight();
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-2, -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.access$100(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.access$000(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getWidth() {
            return ((ExtendedFloatingActionButton.this.getMeasuredWidth() - ExtendedFloatingActionButton.this.getPaddingStart()) - ExtendedFloatingActionButton.this.getPaddingEnd()) + ExtendedFloatingActionButton.access$000(ExtendedFloatingActionButton.this) + ExtendedFloatingActionButton.access$100(ExtendedFloatingActionButton.this);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements Size {
        final /* synthetic */ Size val$wrapContentSize;

        AnonymousClass3(Size size) {
            this.val$wrapContentSize = size;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getHeight() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            if (ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this) != -1) {
                return (ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this) == 0 || ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this) == -2) ? this.val$wrapContentSize.getHeight() : ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this);
            }
            if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                return this.val$wrapContentSize.getHeight();
            }
            int i = 0;
            View view = (View) ExtendedFloatingActionButton.this.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && layoutParams.height == -2) {
                return this.val$wrapContentSize.getHeight();
            }
            int paddingTop = 0 + view.getPaddingTop() + view.getPaddingBottom();
            if ((ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) != null) {
                i = 0 + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
            }
            return (view.getHeight() - i) - paddingTop;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(-1, ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this) == 0 ? -2 : ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this));
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.access$100(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.access$000(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getWidth() {
            ViewGroup.MarginLayoutParams marginLayoutParams;
            int i = 0;
            if (!(ExtendedFloatingActionButton.this.getParent() instanceof View)) {
                return this.val$wrapContentSize.getWidth();
            }
            View view = (View) ExtendedFloatingActionButton.this.getParent();
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null && layoutParams.width == -2) {
                return this.val$wrapContentSize.getWidth();
            }
            int paddingLeft = 0 + view.getPaddingLeft() + view.getPaddingRight();
            if ((ExtendedFloatingActionButton.this.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) && (marginLayoutParams = (ViewGroup.MarginLayoutParams) ExtendedFloatingActionButton.this.getLayoutParams()) != null) {
                i = 0 + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
            }
            return (view.getWidth() - i) - paddingLeft;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 implements Size {
        final /* synthetic */ Size val$matchParentSize;
        final /* synthetic */ Size val$wrapContentSize;

        AnonymousClass4(Size size, Size size2) {
            this.val$matchParentSize = size;
            this.val$wrapContentSize = size2;
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getHeight() {
            return ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this) == -1 ? this.val$matchParentSize.getHeight() : (ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this) == 0 || ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this) == -2) ? this.val$wrapContentSize.getHeight() : ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public ViewGroup.LayoutParams getLayoutParams() {
            return new ViewGroup.LayoutParams(ExtendedFloatingActionButton.access$300(ExtendedFloatingActionButton.this) == 0 ? -2 : ExtendedFloatingActionButton.access$300(ExtendedFloatingActionButton.this), ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this) != 0 ? ExtendedFloatingActionButton.access$200(ExtendedFloatingActionButton.this) : -2);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingEnd() {
            return ExtendedFloatingActionButton.access$100(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getPaddingStart() {
            return ExtendedFloatingActionButton.access$000(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton.Size
        public int getWidth() {
            return ExtendedFloatingActionButton.access$300(ExtendedFloatingActionButton.this) == -1 ? this.val$matchParentSize.getWidth() : (ExtendedFloatingActionButton.access$300(ExtendedFloatingActionButton.this) == 0 || ExtendedFloatingActionButton.access$300(ExtendedFloatingActionButton.this) == -2) ? this.val$wrapContentSize.getWidth() : ExtendedFloatingActionButton.access$300(ExtendedFloatingActionButton.this);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 extends AnimatorListenerAdapter {
        private boolean cancelled;
        final /* synthetic */ OnChangedCallback val$callback;
        final /* synthetic */ MotionStrategy val$strategy;

        AnonymousClass5(MotionStrategy motionStrategy, OnChangedCallback onChangedCallback) {
            this.val$strategy = motionStrategy;
            this.val$callback = onChangedCallback;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            this.cancelled = true;
            this.val$strategy.onAnimationCancel();
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$strategy.onAnimationEnd();
            if (this.cancelled) {
                return;
            }
            this.val$strategy.onChange(this.val$callback);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.val$strategy.onAnimationStart(animator);
            this.cancelled = false;
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$6, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 extends Property<View, Float> {
        AnonymousClass6(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(View view) {
            return Float.valueOf(view.getLayoutParams().width);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(View view) {
            return get2(view);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, Float f) {
            view.getLayoutParams().width = f.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Float f) {
            set2(view, f);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$7, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass7 extends Property<View, Float> {
        AnonymousClass7(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(View view) {
            return Float.valueOf(view.getLayoutParams().height);
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(View view) {
            return get2(view);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, Float f) {
            view.getLayoutParams().height = f.intValue();
            view.requestLayout();
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Float f) {
            set2(view, f);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$8, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass8 extends Property<View, Float> {
        AnonymousClass8(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(View view) {
            return Float.valueOf(view.getPaddingStart());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(View view) {
            return get2(view);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, Float f) {
            view.setPaddingRelative(f.intValue(), view.getPaddingTop(), view.getPaddingEnd(), view.getPaddingBottom());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Float f) {
            set2(view, f);
        }
    }

    /* renamed from: com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton$9, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass9 extends Property<View, Float> {
        AnonymousClass9(Class cls, String str) {
            super(cls, str);
        }

        /* renamed from: get, reason: avoid collision after fix types in other method */
        public Float get2(View view) {
            return Float.valueOf(view.getPaddingEnd());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(View view) {
            return get2(view);
        }

        /* renamed from: set, reason: avoid collision after fix types in other method */
        public void set2(View view, Float f) {
            view.setPaddingRelative(view.getPaddingStart(), view.getPaddingTop(), f.intValue(), view.getPaddingBottom());
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ void set(View view, Float f) {
            set2(view, f);
        }
    }

    /* loaded from: classes.dex */
    class ChangeSizeStrategy extends BaseMotionStrategy {
        private final boolean extending;
        private final Size size;

        ChangeSizeStrategy(AnimatorTracker animatorTracker, Size size, boolean z) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
            this.size = size;
            this.extending = z;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public AnimatorSet createAnimator() {
            MotionSpec currentMotionSpec = getCurrentMotionSpec();
            if (currentMotionSpec.hasPropertyValues("width")) {
                PropertyValuesHolder[] propertyValues = currentMotionSpec.getPropertyValues("width");
                propertyValues[0].setFloatValues(ExtendedFloatingActionButton.this.getWidth(), this.size.getWidth());
                currentMotionSpec.setPropertyValues("width", propertyValues);
            }
            if (currentMotionSpec.hasPropertyValues("height")) {
                PropertyValuesHolder[] propertyValues2 = currentMotionSpec.getPropertyValues("height");
                propertyValues2[0].setFloatValues(ExtendedFloatingActionButton.this.getHeight(), this.size.getHeight());
                currentMotionSpec.setPropertyValues("height", propertyValues2);
            }
            if (currentMotionSpec.hasPropertyValues("paddingStart")) {
                PropertyValuesHolder[] propertyValues3 = currentMotionSpec.getPropertyValues("paddingStart");
                propertyValues3[0].setFloatValues(ExtendedFloatingActionButton.this.getPaddingStart(), this.size.getPaddingStart());
                currentMotionSpec.setPropertyValues("paddingStart", propertyValues3);
            }
            if (currentMotionSpec.hasPropertyValues("paddingEnd")) {
                PropertyValuesHolder[] propertyValues4 = currentMotionSpec.getPropertyValues("paddingEnd");
                propertyValues4[0].setFloatValues(ExtendedFloatingActionButton.this.getPaddingEnd(), this.size.getPaddingEnd());
                currentMotionSpec.setPropertyValues("paddingEnd", propertyValues4);
            }
            if (currentMotionSpec.hasPropertyValues("labelOpacity")) {
                PropertyValuesHolder[] propertyValues5 = currentMotionSpec.getPropertyValues("labelOpacity");
                int alpha = Color.alpha(ExtendedFloatingActionButton.this.getCurrentOriginalTextColor());
                propertyValues5[0].setFloatValues(alpha != 0 ? Color.alpha(ExtendedFloatingActionButton.this.getCurrentTextColor()) / alpha : 0.0f, this.extending ? 1.0f : 0.0f);
                currentMotionSpec.setPropertyValues("labelOpacity", propertyValues5);
            }
            return super.createAnimator(currentMotionSpec);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return this.extending ? R.animator.mtrl_extended_fab_change_size_expand_motion_spec : R.animator.mtrl_extended_fab_change_size_collapse_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$702(ExtendedFloatingActionButton.this, false);
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(false);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.width = this.size.getLayoutParams().width;
            layoutParams.height = this.size.getLayoutParams().height;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.access$502(ExtendedFloatingActionButton.this, this.extending);
            ExtendedFloatingActionButton.access$702(ExtendedFloatingActionButton.this, true);
            ExtendedFloatingActionButton.this.setHorizontallyScrolling(true);
            ExtendedFloatingActionButton.access$600(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(OnChangedCallback onChangedCallback) {
            if (onChangedCallback == null) {
                return;
            }
            if (this.extending) {
                onChangedCallback.onExtended(ExtendedFloatingActionButton.this);
            } else {
                onChangedCallback.onShrunken(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            ExtendedFloatingActionButton.access$502(ExtendedFloatingActionButton.this, this.extending);
            ViewGroup.LayoutParams layoutParams = ExtendedFloatingActionButton.this.getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            if (!this.extending) {
                ExtendedFloatingActionButton.access$302(ExtendedFloatingActionButton.this, layoutParams.width);
                ExtendedFloatingActionButton.access$202(ExtendedFloatingActionButton.this, layoutParams.height);
            }
            layoutParams.width = this.size.getLayoutParams().width;
            layoutParams.height = this.size.getLayoutParams().height;
            if (this.extending) {
                ExtendedFloatingActionButton.this.silentlyUpdateTextColor(ExtendedFloatingActionButton.this.originalTextCsl);
            } else if (ExtendedFloatingActionButton.this.getText() != null && ExtendedFloatingActionButton.this.getText() != "") {
                ExtendedFloatingActionButton.this.silentlyUpdateTextColor(ColorStateList.valueOf(0));
            }
            ExtendedFloatingActionButton.this.setPaddingRelative(this.size.getPaddingStart(), ExtendedFloatingActionButton.this.getPaddingTop(), this.size.getPaddingEnd(), ExtendedFloatingActionButton.this.getPaddingBottom());
            ExtendedFloatingActionButton.this.requestLayout();
            ExtendedFloatingActionButton.access$600(ExtendedFloatingActionButton.this);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return this.extending == ExtendedFloatingActionButton.access$500(ExtendedFloatingActionButton.this) || ExtendedFloatingActionButton.this.getIcon() == null || TextUtils.isEmpty(ExtendedFloatingActionButton.this.getText());
        }
    }

    /* loaded from: classes.dex */
    protected static class ExtendedFloatingActionButtonBehavior<T extends ExtendedFloatingActionButton> extends CoordinatorLayout.Behavior<T> {
        private static final boolean AUTO_HIDE_DEFAULT = false;
        private static final boolean AUTO_SHRINK_DEFAULT = true;
        private boolean autoHideEnabled;
        private boolean autoShrinkEnabled;
        private OnChangedCallback internalAutoHideCallback;
        private OnChangedCallback internalAutoShrinkCallback;
        private Rect tmpRect;

        public ExtendedFloatingActionButtonBehavior() {
            this.autoHideEnabled = false;
            this.autoShrinkEnabled = true;
        }

        public ExtendedFloatingActionButtonBehavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ExtendedFloatingActionButton_Behavior_Layout);
            this.autoHideEnabled = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoHide, false);
            this.autoShrinkEnabled = obtainStyledAttributes.getBoolean(R.styleable.ExtendedFloatingActionButton_Behavior_Layout_behavior_autoShrink, true);
            obtainStyledAttributes.recycle();
        }

        private static boolean isBottomSheet(View view) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams instanceof CoordinatorLayout.LayoutParams) {
                return ((CoordinatorLayout.LayoutParams) layoutParams).getBehavior() instanceof BottomSheetBehavior;
            }
            return false;
        }

        private boolean shouldUpdateVisibility(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            return (this.autoHideEnabled || this.autoShrinkEnabled) && ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).getAnchorId() == view.getId();
        }

        private boolean updateFabVisibilityForAppBarLayout(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(appBarLayout, extendedFloatingActionButton)) {
                return false;
            }
            if (this.tmpRect == null) {
                this.tmpRect = new Rect();
            }
            Rect rect = this.tmpRect;
            DescendantOffsetUtils.getDescendantRect(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        private boolean updateFabVisibilityForBottomSheet(View view, ExtendedFloatingActionButton extendedFloatingActionButton) {
            if (!shouldUpdateVisibility(view, extendedFloatingActionButton)) {
                return false;
            }
            if (view.getTop() < (extendedFloatingActionButton.getHeight() / 2) + ((CoordinatorLayout.LayoutParams) extendedFloatingActionButton.getLayoutParams()).topMargin) {
                shrinkOrHide(extendedFloatingActionButton);
                return true;
            }
            extendOrShow(extendedFloatingActionButton);
            return true;
        }

        protected void extendOrShow(ExtendedFloatingActionButton extendedFloatingActionButton) {
            ExtendedFloatingActionButton.access$400(extendedFloatingActionButton, this.autoShrinkEnabled ? 3 : 0, this.autoShrinkEnabled ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, View view, Rect rect) {
            return getInsetDodgeRect(coordinatorLayout, (ExtendedFloatingActionButton) view, rect);
        }

        public boolean getInsetDodgeRect(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, Rect rect) {
            return super.getInsetDodgeRect(coordinatorLayout, (CoordinatorLayout) extendedFloatingActionButton, rect);
        }

        public boolean isAutoHideEnabled() {
            return this.autoHideEnabled;
        }

        public boolean isAutoShrinkEnabled() {
            return this.autoShrinkEnabled;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public void onAttachedToLayoutParams(CoordinatorLayout.LayoutParams layoutParams) {
            if (layoutParams.dodgeInsetEdges == 0) {
                layoutParams.dodgeInsetEdges = 80;
            }
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
            return onDependentViewChanged(coordinatorLayout, (ExtendedFloatingActionButton) view, view2);
        }

        public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, View view) {
            if (view instanceof AppBarLayout) {
                updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton);
                return false;
            }
            if (!isBottomSheet(view)) {
                return false;
            }
            updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton);
            return false;
        }

        @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int i) {
            return onLayoutChild(coordinatorLayout, (ExtendedFloatingActionButton) view, i);
        }

        public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
            List<View> dependencies = coordinatorLayout.getDependencies(extendedFloatingActionButton);
            int size = dependencies.size();
            for (int i2 = 0; i2 < size; i2++) {
                View view = dependencies.get(i2);
                if (!(view instanceof AppBarLayout)) {
                    if (isBottomSheet(view) && updateFabVisibilityForBottomSheet(view, extendedFloatingActionButton)) {
                        break;
                    }
                } else {
                    if (updateFabVisibilityForAppBarLayout(coordinatorLayout, (AppBarLayout) view, extendedFloatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.onLayoutChild(extendedFloatingActionButton, i);
            return true;
        }

        public void setAutoHideEnabled(boolean z) {
            this.autoHideEnabled = z;
        }

        public void setAutoShrinkEnabled(boolean z) {
            this.autoShrinkEnabled = z;
        }

        void setInternalAutoHideCallback(OnChangedCallback onChangedCallback) {
            this.internalAutoHideCallback = onChangedCallback;
        }

        void setInternalAutoShrinkCallback(OnChangedCallback onChangedCallback) {
            this.internalAutoShrinkCallback = onChangedCallback;
        }

        protected void shrinkOrHide(ExtendedFloatingActionButton extendedFloatingActionButton) {
            ExtendedFloatingActionButton.access$400(extendedFloatingActionButton, this.autoShrinkEnabled ? 2 : 1, this.autoShrinkEnabled ? this.internalAutoShrinkCallback : this.internalAutoHideCallback);
        }
    }

    /* loaded from: classes.dex */
    class HideStrategy extends BaseMotionStrategy {
        private boolean isCancelled;

        public HideStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return R.animator.mtrl_extended_fab_hide_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationCancel() {
            super.onAnimationCancel();
            this.isCancelled = true;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$802(ExtendedFloatingActionButton.this, 0);
            if (this.isCancelled) {
                return;
            }
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            this.isCancelled = false;
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.access$802(ExtendedFloatingActionButton.this, 1);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onHidden(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            ExtendedFloatingActionButton.this.setVisibility(8);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.access$1000(ExtendedFloatingActionButton.this);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class OnChangedCallback {
        public void onExtended(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onHidden(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShown(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }

        public void onShrunken(ExtendedFloatingActionButton extendedFloatingActionButton) {
        }
    }

    /* loaded from: classes.dex */
    class ShowStrategy extends BaseMotionStrategy {
        public ShowStrategy(AnimatorTracker animatorTracker) {
            super(ExtendedFloatingActionButton.this, animatorTracker);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public int getDefaultMotionSpecResource() {
            return R.animator.mtrl_extended_fab_show_motion_spec;
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationEnd() {
            super.onAnimationEnd();
            ExtendedFloatingActionButton.access$802(ExtendedFloatingActionButton.this, 0);
        }

        @Override // com.google.android.material.floatingactionbutton.BaseMotionStrategy, com.google.android.material.floatingactionbutton.MotionStrategy
        public void onAnimationStart(Animator animator) {
            super.onAnimationStart(animator);
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.access$802(ExtendedFloatingActionButton.this, 2);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void onChange(OnChangedCallback onChangedCallback) {
            if (onChangedCallback != null) {
                onChangedCallback.onShown(ExtendedFloatingActionButton.this);
            }
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public void performNow() {
            ExtendedFloatingActionButton.this.setVisibility(0);
            ExtendedFloatingActionButton.this.setAlpha(1.0f);
            ExtendedFloatingActionButton.this.setScaleY(1.0f);
            ExtendedFloatingActionButton.this.setScaleX(1.0f);
        }

        @Override // com.google.android.material.floatingactionbutton.MotionStrategy
        public boolean shouldCancel() {
            return ExtendedFloatingActionButton.access$900(ExtendedFloatingActionButton.this);
        }
    }

    /* loaded from: classes.dex */
    interface Size {
        int getHeight();

        ViewGroup.LayoutParams getLayoutParams();

        int getPaddingEnd();

        int getPaddingStart();

        int getWidth();
    }

    public ExtendedFloatingActionButton(Context context) {
        this(context, null);
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.extendedFloatingActionButtonStyle);
    }

    public ExtendedFloatingActionButton(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.animState = 0;
        this.animationEnabled = true;
        this.changeVisibilityTracker = new AnimatorTracker();
        this.showStrategy = new ShowStrategy(this.changeVisibilityTracker);
        this.hideStrategy = new HideStrategy(this.changeVisibilityTracker);
        this.isExtended = true;
        this.isTransforming = false;
        this.animateShowBeforeLayout = false;
        Context context2 = getContext();
        this.behavior = new ExtendedFloatingActionButtonBehavior(context2, attributeSet);
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.ExtendedFloatingActionButton, i, DEF_STYLE_RES, new int[0]);
        MotionSpec createFromAttribute = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R.styleable.ExtendedFloatingActionButton_showMotionSpec);
        MotionSpec createFromAttribute2 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R.styleable.ExtendedFloatingActionButton_hideMotionSpec);
        MotionSpec createFromAttribute3 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R.styleable.ExtendedFloatingActionButton_extendMotionSpec);
        MotionSpec createFromAttribute4 = MotionSpec.createFromAttribute(context2, obtainStyledAttributes, R.styleable.ExtendedFloatingActionButton_shrinkMotionSpec);
        this.collapsedSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.ExtendedFloatingActionButton_collapsedSize, -1);
        this.extendStrategyType = obtainStyledAttributes.getInt(R.styleable.ExtendedFloatingActionButton_extendStrategy, 1);
        this.extendedPaddingStart = getPaddingStart();
        this.extendedPaddingEnd = getPaddingEnd();
        AnimatorTracker animatorTracker = new AnimatorTracker();
        this.extendStrategy = new ChangeSizeStrategy(animatorTracker, getSizeFromExtendStrategyType(this.extendStrategyType), true);
        this.shrinkStrategy = new ChangeSizeStrategy(animatorTracker, new AnonymousClass1(), false);
        this.showStrategy.setMotionSpec(createFromAttribute);
        this.hideStrategy.setMotionSpec(createFromAttribute2);
        this.extendStrategy.setMotionSpec(createFromAttribute3);
        this.shrinkStrategy.setMotionSpec(createFromAttribute4);
        obtainStyledAttributes.recycle();
        setShapeAppearanceModel(ShapeAppearanceModel.builder(context2, attributeSet, i, DEF_STYLE_RES, ShapeAppearanceModel.PILL).build());
        saveOriginalTextCsl();
    }

    static /* synthetic */ int access$000(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.extendedPaddingStart;
    }

    static /* synthetic */ int access$100(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.extendedPaddingEnd;
    }

    static /* synthetic */ boolean access$1000(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.isOrWillBeHidden();
    }

    static /* synthetic */ int access$200(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.originalHeight;
    }

    static /* synthetic */ int access$202(ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
        extendedFloatingActionButton.originalHeight = i;
        return i;
    }

    static /* synthetic */ int access$300(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.originalWidth;
    }

    static /* synthetic */ int access$302(ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
        extendedFloatingActionButton.originalWidth = i;
        return i;
    }

    static /* synthetic */ void access$400(ExtendedFloatingActionButton extendedFloatingActionButton, int i, OnChangedCallback onChangedCallback) {
        extendedFloatingActionButton.performMotion(i, onChangedCallback);
    }

    static /* synthetic */ boolean access$500(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.isExtended;
    }

    static /* synthetic */ boolean access$502(ExtendedFloatingActionButton extendedFloatingActionButton, boolean z) {
        extendedFloatingActionButton.isExtended = z;
        return z;
    }

    static /* synthetic */ void access$600(ExtendedFloatingActionButton extendedFloatingActionButton) {
        extendedFloatingActionButton.updateTooltip();
    }

    static /* synthetic */ boolean access$702(ExtendedFloatingActionButton extendedFloatingActionButton, boolean z) {
        extendedFloatingActionButton.isTransforming = z;
        return z;
    }

    static /* synthetic */ int access$802(ExtendedFloatingActionButton extendedFloatingActionButton, int i) {
        extendedFloatingActionButton.animState = i;
        return i;
    }

    static /* synthetic */ boolean access$900(ExtendedFloatingActionButton extendedFloatingActionButton) {
        return extendedFloatingActionButton.isOrWillBeShown();
    }

    private Size getSizeFromExtendStrategyType(int i) {
        AnonymousClass2 anonymousClass2 = new AnonymousClass2();
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(anonymousClass2);
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(anonymousClass3, anonymousClass2);
        switch (i) {
            case 1:
                return anonymousClass2;
            case 2:
                return anonymousClass3;
            default:
                return anonymousClass4;
        }
    }

    private boolean isOrWillBeHidden() {
        return getVisibility() == 0 ? this.animState == 1 : this.animState != 2;
    }

    private boolean isOrWillBeShown() {
        return getVisibility() != 0 ? this.animState == 2 : this.animState != 1;
    }

    private void performMotion(int i, OnChangedCallback onChangedCallback) {
        MotionStrategy motionStrategy;
        switch (i) {
            case 0:
                motionStrategy = this.showStrategy;
                break;
            case 1:
                motionStrategy = this.hideStrategy;
                break;
            case 2:
                motionStrategy = this.shrinkStrategy;
                break;
            case 3:
                motionStrategy = this.extendStrategy;
                break;
            default:
                throw new IllegalStateException("Unknown strategy type: " + i);
        }
        if (motionStrategy.shouldCancel()) {
            return;
        }
        if (!shouldAnimateVisibilityChange()) {
            motionStrategy.performNow();
            motionStrategy.onChange(onChangedCallback);
            return;
        }
        if (i == 2) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                this.originalWidth = layoutParams.width;
                this.originalHeight = layoutParams.height;
            } else {
                this.originalWidth = getWidth();
                this.originalHeight = getHeight();
            }
        }
        measure(0, 0);
        AnimatorSet createAnimator = motionStrategy.createAnimator();
        createAnimator.addListener(new AnonymousClass5(motionStrategy, onChangedCallback));
        Iterator<Animator.AnimatorListener> it = motionStrategy.getListeners().iterator();
        while (it.hasNext()) {
            createAnimator.addListener(it.next());
        }
        createAnimator.start();
    }

    private void saveOriginalTextCsl() {
        this.originalTextCsl = getTextColors();
    }

    private boolean shouldAnimateVisibilityChange() {
        return this.animationEnabled && (isLaidOut() || (!isOrWillBeShown() && this.animateShowBeforeLayout)) && !isInEditMode();
    }

    private void updateTooltip() {
        CharSequence charSequence;
        if (Build.VERSION.SDK_INT < 26) {
            return;
        }
        if (this.isExtended || !isClickable()) {
            charSequence = null;
        } else {
            CharSequence text = getText();
            charSequence = TextUtils.isEmpty(text) ? getContentDescription() : text;
        }
        if (TextUtils.equals(getTooltipText(), charSequence)) {
            return;
        }
        setTooltipText(charSequence);
    }

    public void addOnExtendAnimationListener(Animator.AnimatorListener animatorListener) {
        this.extendStrategy.addAnimationListener(animatorListener);
    }

    public void addOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        this.hideStrategy.addAnimationListener(animatorListener);
    }

    public void addOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        this.showStrategy.addAnimationListener(animatorListener);
    }

    public void addOnShrinkAnimationListener(Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.addAnimationListener(animatorListener);
    }

    public void extend() {
        performMotion(3, null);
    }

    public void extend(OnChangedCallback onChangedCallback) {
        performMotion(3, onChangedCallback);
    }

    @Override // android.widget.Button, android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "com.google.android.material.floatingactionbutton.FloatingActionButton";
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.AttachedBehavior
    public CoordinatorLayout.Behavior<ExtendedFloatingActionButton> getBehavior() {
        return this.behavior;
    }

    int getCollapsedPadding() {
        return (getCollapsedSize() - getIconSize()) / 2;
    }

    public int getCollapsedSize() {
        return this.collapsedSize < 0 ? (Math.min(getPaddingStart(), getPaddingEnd()) * 2) + getIconSize() : this.collapsedSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentOriginalTextColor() {
        return this.originalTextCsl.getColorForState(getDrawableState(), 0);
    }

    public MotionSpec getExtendMotionSpec() {
        return this.extendStrategy.getMotionSpec();
    }

    public MotionSpec getHideMotionSpec() {
        return this.hideStrategy.getMotionSpec();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ColorStateList getOriginalTextColor() {
        return this.originalTextCsl;
    }

    public MotionSpec getShowMotionSpec() {
        return this.showStrategy.getMotionSpec();
    }

    public MotionSpec getShrinkMotionSpec() {
        return this.shrinkStrategy.getMotionSpec();
    }

    public void hide() {
        performMotion(1, null);
    }

    public void hide(OnChangedCallback onChangedCallback) {
        performMotion(1, onChangedCallback);
    }

    public boolean isAnimationEnabled() {
        return this.animationEnabled;
    }

    public final boolean isExtended() {
        return this.isExtended;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!this.isExtended || !TextUtils.isEmpty(getText()) || getIcon() == null) {
            updateTooltip();
        } else {
            this.isExtended = false;
            this.shrinkStrategy.performNow();
        }
    }

    public void removeOnExtendAnimationListener(Animator.AnimatorListener animatorListener) {
        this.extendStrategy.removeAnimationListener(animatorListener);
    }

    public void removeOnHideAnimationListener(Animator.AnimatorListener animatorListener) {
        this.hideStrategy.removeAnimationListener(animatorListener);
    }

    public void removeOnShowAnimationListener(Animator.AnimatorListener animatorListener) {
        this.showStrategy.removeAnimationListener(animatorListener);
    }

    public void removeOnShrinkAnimationListener(Animator.AnimatorListener animatorListener) {
        this.shrinkStrategy.removeAnimationListener(animatorListener);
    }

    public void setAnimateShowBeforeLayout(boolean z) {
        this.animateShowBeforeLayout = z;
    }

    public void setAnimationEnabled(boolean z) {
        this.animationEnabled = z;
    }

    @Override // android.view.View
    public void setClickable(boolean z) {
        super.setClickable(z);
        updateTooltip();
    }

    public void setCollapsedSize(int i) {
        this.collapsedSize = i;
    }

    @Override // android.view.View
    public void setContentDescription(CharSequence charSequence) {
        super.setContentDescription(charSequence);
        updateTooltip();
    }

    public void setExtendMotionSpec(MotionSpec motionSpec) {
        this.extendStrategy.setMotionSpec(motionSpec);
    }

    public void setExtendMotionSpecResource(int i) {
        setExtendMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setExtended(boolean z) {
        if (this.isExtended == z) {
            return;
        }
        MotionStrategy motionStrategy = z ? this.extendStrategy : this.shrinkStrategy;
        if (motionStrategy.shouldCancel()) {
            return;
        }
        motionStrategy.performNow();
    }

    public void setHideMotionSpec(MotionSpec motionSpec) {
        this.hideStrategy.setMotionSpec(motionSpec);
    }

    public void setHideMotionSpecResource(int i) {
        setHideMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    @Override // android.widget.TextView, android.view.View
    public void setPadding(int i, int i2, int i3, int i4) {
        super.setPadding(i, i2, i3, i4);
        if (!this.isExtended || this.isTransforming) {
            return;
        }
        this.extendedPaddingStart = getPaddingStart();
        this.extendedPaddingEnd = getPaddingEnd();
    }

    @Override // android.widget.TextView, android.view.View
    public void setPaddingRelative(int i, int i2, int i3, int i4) {
        super.setPaddingRelative(i, i2, i3, i4);
        if (!this.isExtended || this.isTransforming) {
            return;
        }
        this.extendedPaddingStart = i;
        this.extendedPaddingEnd = i3;
    }

    public void setShowMotionSpec(MotionSpec motionSpec) {
        this.showStrategy.setMotionSpec(motionSpec);
    }

    public void setShowMotionSpecResource(int i) {
        setShowMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    public void setShrinkMotionSpec(MotionSpec motionSpec) {
        this.shrinkStrategy.setMotionSpec(motionSpec);
    }

    public void setShrinkMotionSpecResource(int i) {
        setShrinkMotionSpec(MotionSpec.createFromResource(getContext(), i));
    }

    @Override // com.google.android.material.button.MaterialButton, android.widget.TextView
    public void setText(CharSequence charSequence, TextView.BufferType bufferType) {
        super.setText(charSequence, bufferType);
        updateTooltip();
    }

    @Override // android.widget.TextView
    public void setTextColor(int i) {
        super.setTextColor(i);
        saveOriginalTextCsl();
    }

    @Override // android.widget.TextView
    public void setTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
        saveOriginalTextCsl();
    }

    public void show() {
        performMotion(0, null);
    }

    public void show(OnChangedCallback onChangedCallback) {
        performMotion(0, onChangedCallback);
    }

    public void shrink() {
        performMotion(2, null);
    }

    public void shrink(OnChangedCallback onChangedCallback) {
        performMotion(2, onChangedCallback);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void silentlyUpdateTextColor(ColorStateList colorStateList) {
        super.setTextColor(colorStateList);
    }
}
