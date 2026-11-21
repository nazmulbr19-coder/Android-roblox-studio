package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationCoordinator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.FadeThroughUpdateListener;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.search.SearchView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
class SearchViewAnimationHelper {
    private static final float CONTENT_FROM_SCALE = 0.95f;
    private static final int DEFAULT_DURATION_MS = 100;
    private static final TimeInterpolator DEFAULT_INTERPOLATOR = AnimationUtils.LINEAR_INTERPOLATOR;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS = 42;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_ALPHA_DURATION_MS = 83;
    private static final long HIDE_CONTENT_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_SCALE_DURATION_MS = 250;
    private static final long HIDE_DURATION_MS = 250;
    private static final long HIDE_TRANSLATE_DURATION_MS = 300;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_DURATION_MS = 50;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 250;
    private static final long SHOW_CONTENT_ALPHA_DURATION_MS = 150;
    private static final long SHOW_CONTENT_ALPHA_START_DELAY_MS = 75;
    private static final long SHOW_CONTENT_SCALE_DURATION_MS = 300;
    private static final long SHOW_DURATION_MS = 300;
    private static final long SHOW_SCRIM_ALPHA_DURATION_MS = 100;
    private static final long SHOW_TRANSLATE_DURATION_MS = 350;
    private static final long SHOW_TRANSLATE_KEYBOARD_START_DELAY_MS = 150;
    AnimationCoordinator activeCoordinator;
    AnimatorSet activeTranslateAnimatorSet;
    final AnimationDelegate animationDelegate;
    private final MaterialMainContainerBackHelper backHelper;
    private AnimatorSet backProgressAnimatorSet;
    private final View backgroundView;
    private final ImageButton clearButton;
    private final TouchObserverFrameLayout contentContainer;
    private final Context context;
    private final View divider;
    private final TextView dummyTextView;
    private final Toolbar dummyToolbar;
    private final int durationShort1;
    private final int durationShort2;
    private final EditText editText;
    private final FrameLayout headerContainer;
    private final ClippableRoundedCornerLayout rootView;
    private final View scrim;
    private SearchBar searchBar;
    private final TextView searchPrefix;
    private final SearchView searchView;
    private final TimeInterpolator standardAccelerateInterpolator;
    private final TimeInterpolator standardDecelerateInterpolator;
    private final Toolbar toolbar;
    private final FrameLayout toolbarContainer;

    /* renamed from: com.google.android.material.search.SearchViewAnimationHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements AnimationCoordinator.Listener {
        final /* synthetic */ AnimationCoordinator val$coordinator;
        final /* synthetic */ boolean val$show;

        AnonymousClass1(boolean z, AnimationCoordinator animationCoordinator) {
            this.val$show = z;
            this.val$coordinator = animationCoordinator;
        }

        @Override // com.google.android.material.animation.AnimationCoordinator.Listener
        public void onAnimationsEnd() {
            SearchViewAnimationHelper.this.animationDelegate.onAnimationEnd(this.val$show);
            if (!SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).isAdjustNothingSoftInputMode()) {
                SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).requestFocusAndShowKeyboardIfNeeded();
            }
            SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).setTransitionState(SearchView.TransitionState.SHOWN);
            if (SearchViewAnimationHelper.this.activeCoordinator == this.val$coordinator) {
                SearchViewAnimationHelper.this.activeCoordinator = null;
            }
        }

        @Override // com.google.android.material.animation.AnimationCoordinator.Listener
        public void onAnimationsStart() {
            SearchViewAnimationHelper.this.animationDelegate.onAnimationStart(this.val$show);
            SearchViewAnimationHelper.access$200(SearchViewAnimationHelper.this).setVisibility(0);
            SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).stopOnLoadAnimation();
        }
    }

    /* renamed from: com.google.android.material.search.SearchViewAnimationHelper$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements AnimationCoordinator.Listener {
        final /* synthetic */ AnimationCoordinator val$coordinator;
        final /* synthetic */ boolean val$show;

        AnonymousClass2(boolean z, AnimationCoordinator animationCoordinator) {
            this.val$show = z;
            this.val$coordinator = animationCoordinator;
        }

        @Override // com.google.android.material.animation.AnimationCoordinator.Listener
        public void onAnimationsEnd() {
            SearchViewAnimationHelper.this.animationDelegate.onAnimationEnd(this.val$show);
            SearchViewAnimationHelper.access$200(SearchViewAnimationHelper.this).setVisibility(8);
            if (!SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).isAdjustNothingSoftInputMode()) {
                SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).clearFocus();
            }
            SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).setTransitionState(SearchView.TransitionState.HIDDEN);
            if (SearchViewAnimationHelper.this.activeCoordinator == this.val$coordinator) {
                SearchViewAnimationHelper.this.activeCoordinator = null;
            }
        }

        @Override // com.google.android.material.animation.AnimationCoordinator.Listener
        public void onAnimationsStart() {
            SearchViewAnimationHelper.this.animationDelegate.onAnimationStart(this.val$show);
            SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).setTransitionState(SearchView.TransitionState.HIDING);
        }
    }

    /* renamed from: com.google.android.material.search.SearchViewAnimationHelper$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimatorSet val$animatorSet;

        AnonymousClass3(AnimatorSet animatorSet) {
            this.val$animatorSet = animatorSet;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (!SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).isAdjustNothingSoftInputMode()) {
                SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).requestFocusAndShowKeyboardIfNeeded();
            }
            SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).setTransitionState(SearchView.TransitionState.SHOWN);
            if (SearchViewAnimationHelper.this.activeTranslateAnimatorSet == this.val$animatorSet) {
                SearchViewAnimationHelper.this.activeTranslateAnimatorSet = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SearchViewAnimationHelper.access$200(SearchViewAnimationHelper.this).setVisibility(0);
            SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).setTransitionState(SearchView.TransitionState.SHOWING);
        }
    }

    /* renamed from: com.google.android.material.search.SearchViewAnimationHelper$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends AnimatorListenerAdapter {
        final /* synthetic */ AnimatorSet val$animatorSet;

        AnonymousClass4(AnimatorSet animatorSet) {
            this.val$animatorSet = animatorSet;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SearchViewAnimationHelper.access$200(SearchViewAnimationHelper.this).setVisibility(8);
            if (!SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).isAdjustNothingSoftInputMode()) {
                SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).clearFocus();
            }
            SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).setTransitionState(SearchView.TransitionState.HIDDEN);
            if (SearchViewAnimationHelper.this.activeTranslateAnimatorSet == this.val$animatorSet) {
                SearchViewAnimationHelper.this.activeTranslateAnimatorSet = null;
            }
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).setTransitionState(SearchView.TransitionState.HIDING);
        }
    }

    /* loaded from: classes.dex */
    private interface AnimationDelegate {
        AnimatorSet getExpandCollapseAnimatorSet(boolean z);

        List<SpringAnimation> getExpandCollapseSpringAnimations(boolean z);

        void onAnimationEnd(boolean z);

        void onAnimationStart(boolean z);

        void setUpDummyToolbarIfNeeded();

        void startButtonsTranslationAnimation();
    }

    /* loaded from: classes.dex */
    class ContainedAnimationDelegate implements AnimationDelegate {

        /* renamed from: com.google.android.material.search.SearchViewAnimationHelper$ContainedAnimationDelegate$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 extends FloatPropertyCompat<View> {
            AnonymousClass1(String str) {
                super(str);
            }

            /* renamed from: getValue, reason: avoid collision after fix types in other method */
            public float getValue2(View view) {
                return view.getWidth();
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public /* bridge */ /* synthetic */ float getValue(View view) {
                return getValue2(view);
            }

            /* renamed from: setValue, reason: avoid collision after fix types in other method */
            public void setValue2(View view, float f) {
                ContainedAnimationDelegate.access$2800(ContainedAnimationDelegate.this, view, (int) f);
            }

            @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
            public /* bridge */ /* synthetic */ void setValue(View view, float f) {
                setValue2(view, f);
            }
        }

        ContainedAnimationDelegate() {
        }

        static /* synthetic */ void access$2800(ContainedAnimationDelegate containedAnimationDelegate, View view, int i) {
            containedAnimationDelegate.setWidth(view, i);
        }

        private ValueAnimator getAlphaValueAnimator(boolean z) {
            float[] fArr = {1.0f, 0.0f};
            if (!z) {
                return ValueAnimator.ofFloat(fArr);
            }
            // fill-array-data instruction
            fArr[0] = 0.0f;
            fArr[1] = 1.0f;
            return ValueAnimator.ofFloat(fArr);
        }

        private Animator getBackgroundAlphaAnimator(boolean z) {
            ValueAnimator alphaValueAnimator = getAlphaValueAnimator(z);
            alphaValueAnimator.setDuration(SearchViewAnimationHelper.access$2400(SearchViewAnimationHelper.this));
            alphaValueAnimator.setStartDelay(z ? 0L : SearchViewAnimationHelper.access$2500(SearchViewAnimationHelper.this));
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            alphaValueAnimator.setInterpolator(z ? SearchViewAnimationHelper.access$2600(searchViewAnimationHelper) : SearchViewAnimationHelper.access$2700(searchViewAnimationHelper));
            alphaValueAnimator.addUpdateListener(new SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda2(this));
            return alphaValueAnimator;
        }

        private Animator getContentAlphaAnimator(boolean z) {
            ValueAnimator alphaValueAnimator = getAlphaValueAnimator(z);
            alphaValueAnimator.setDuration(SearchViewAnimationHelper.access$2400(SearchViewAnimationHelper.this));
            alphaValueAnimator.setStartDelay(z ? SearchViewAnimationHelper.access$2500(SearchViewAnimationHelper.this) : 0L);
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            alphaValueAnimator.setInterpolator(z ? SearchViewAnimationHelper.access$2700(searchViewAnimationHelper) : SearchViewAnimationHelper.access$2600(searchViewAnimationHelper));
            alphaValueAnimator.addUpdateListener(MultiViewUpdateListener.alphaListener(SearchViewAnimationHelper.access$1800(SearchViewAnimationHelper.this)));
            return alphaValueAnimator;
        }

        private SpringAnimation getDummyTextTranslationXSpringAnimation(boolean z) {
            return getTextTranslationXSpringAnimation(z, SearchViewAnimationHelper.access$2200(SearchViewAnimationHelper.this));
        }

        private Animator getDummyTextViewWidthAnimator(boolean z) {
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            TextView textView = z ? SearchViewAnimationHelper.access$600(searchViewAnimationHelper).getTextView() : SearchViewAnimationHelper.access$300(searchViewAnimationHelper);
            SearchViewAnimationHelper searchViewAnimationHelper2 = SearchViewAnimationHelper.this;
            ValueAnimator ofInt = ValueAnimator.ofInt(textView.getWidth(), (z ? SearchViewAnimationHelper.access$300(searchViewAnimationHelper2) : SearchViewAnimationHelper.access$600(searchViewAnimationHelper2).getTextView()).getWidth());
            ofInt.setDuration(SearchViewAnimationHelper.access$2400(SearchViewAnimationHelper.this));
            SearchViewAnimationHelper searchViewAnimationHelper3 = SearchViewAnimationHelper.this;
            ofInt.setInterpolator(z ? SearchViewAnimationHelper.access$2600(searchViewAnimationHelper3) : SearchViewAnimationHelper.access$2700(searchViewAnimationHelper3));
            ofInt.addUpdateListener(new SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda3(this));
            return ofInt;
        }

        private SpringAnimation getDummyToolbarTranslationXSpringAnimation(boolean z) {
            return getToolbarTranslationXSpringAnimation(z, SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this));
        }

        private SpringAnimation getDummyToolbarWidthSpringAnimation(boolean z) {
            return getToolbarWidthSpringAnimation(z, SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this));
        }

        private SpringAnimation getEditTextTranslationXSpringAnimation(boolean z) {
            return getTextTranslationXSpringAnimation(z, SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this));
        }

        private Animator getSearchBarSiblingsTranslationAnimator(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            AppBarLayout appBarLayoutParentIfExists = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getAppBarLayoutParentIfExists();
            if (SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this) == null || appBarLayoutParentIfExists == null) {
                return animatorSet;
            }
            View startSiblingView = getStartSiblingView(appBarLayoutParentIfExists);
            View endSiblingView = getEndSiblingView(appBarLayoutParentIfExists);
            boolean isLayoutRtl = ViewUtils.isLayoutRtl(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this));
            int width = appBarLayoutParentIfExists.getWidth();
            if (startSiblingView != null) {
                Rect calculateOffsetRectFromBounds = ViewUtils.calculateOffsetRectFromBounds(appBarLayoutParentIfExists, startSiblingView);
                animatorSet.playTogether(getSiblingTranslationAnimator(startSiblingView, z, isLayoutRtl ? width - calculateOffsetRectFromBounds.left : -calculateOffsetRectFromBounds.right));
                animatorSet.playTogether(getSiblingAlphaAnimator(startSiblingView, z));
            }
            if (endSiblingView != null) {
                Rect calculateOffsetRectFromBounds2 = ViewUtils.calculateOffsetRectFromBounds(appBarLayoutParentIfExists, endSiblingView);
                animatorSet.playTogether(getSiblingTranslationAnimator(endSiblingView, z, isLayoutRtl ? -calculateOffsetRectFromBounds2.right : width - calculateOffsetRectFromBounds2.left));
                animatorSet.playTogether(getSiblingAlphaAnimator(endSiblingView, z));
            }
            animatorSet.setDuration(SearchViewAnimationHelper.access$2400(SearchViewAnimationHelper.this));
            animatorSet.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
            return animatorSet;
        }

        private Animator getSiblingAlphaAnimator(View view, boolean z) {
            ValueAnimator alphaValueAnimator = getAlphaValueAnimator(!z);
            alphaValueAnimator.addUpdateListener(MultiViewUpdateListener.alphaListener(view));
            return alphaValueAnimator;
        }

        private Animator getSiblingTranslationAnimator(View view, boolean z, float f) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(z ? 0.0f : f, z ? f : 0.0f);
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(view));
            return ofFloat;
        }

        private SpringAnimation getSpringAnimation(View view, FloatPropertyCompat<View> floatPropertyCompat, float f, float f2) {
            SpringAnimation springAnimation = new SpringAnimation(view, floatPropertyCompat);
            springAnimation.setSpring(MotionUtils.resolveThemeSpringForce(SearchViewAnimationHelper.access$2900(SearchViewAnimationHelper.this), R.attr.motionSpringFastSpatial, R.style.Motion_Material3_Spring_Standard_Default_Spatial));
            springAnimation.setStartValue(f);
            springAnimation.getSpring().setFinalPosition(f2);
            return springAnimation;
        }

        private SpringAnimation getTextTranslationXSpringAnimation(boolean z, View view) {
            TextView placeholderTextView = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getPlaceholderTextView();
            if (TextUtils.isEmpty(placeholderTextView.getText()) || z) {
                placeholderTextView = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getTextView();
            }
            float access$2100 = SearchViewAnimationHelper.access$2100(SearchViewAnimationHelper.this, placeholderTextView, view) - getToolbarTranslationX(SearchViewAnimationHelper.access$1400(SearchViewAnimationHelper.this));
            if (ViewUtils.isLayoutRtl(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this))) {
                access$2100 += placeholderTextView.getWidth() - view.getWidth();
            }
            return getSpringAnimation(view, SpringAnimation.TRANSLATION_X, z ? access$2100 : 0.0f, z ? 0.0f : access$2100);
        }

        private View getToolbarActionMenuView() {
            ViewParent parent = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getParent();
            if (parent instanceof Toolbar) {
                return ToolbarUtils.getActionMenuView((Toolbar) parent);
            }
            return null;
        }

        private Animator getToolbarAlphaAnimator(boolean z) {
            ValueAnimator alphaValueAnimator = getAlphaValueAnimator(z);
            alphaValueAnimator.setDuration(SearchViewAnimationHelper.access$2400(SearchViewAnimationHelper.this));
            SearchViewAnimationHelper searchViewAnimationHelper = SearchViewAnimationHelper.this;
            alphaValueAnimator.setInterpolator(z ? SearchViewAnimationHelper.access$2600(searchViewAnimationHelper) : SearchViewAnimationHelper.access$2700(searchViewAnimationHelper));
            alphaValueAnimator.addUpdateListener(new SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda1(this));
            return alphaValueAnimator;
        }

        private SpringAnimation getToolbarContainerTranslationYSpringAnimation(boolean z) {
            int toolbarTranslationY = getToolbarTranslationY();
            return getSpringAnimation(SearchViewAnimationHelper.access$1900(SearchViewAnimationHelper.this), SpringAnimation.TRANSLATION_Y, z ? toolbarTranslationY : 0, z ? 0 : toolbarTranslationY);
        }

        private View getToolbarNavigationIconButton() {
            ViewParent parent = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getParent();
            if (parent instanceof Toolbar) {
                return ToolbarUtils.getNavigationIconButton((Toolbar) parent);
            }
            return null;
        }

        private int getToolbarTranslationX(Toolbar toolbar) {
            int access$1600 = SearchViewAnimationHelper.access$1600(SearchViewAnimationHelper.this, SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this));
            int paddingStart = SearchViewAnimationHelper.access$1900(SearchViewAnimationHelper.this).getPaddingStart();
            int marginStart = ((ViewGroup.MarginLayoutParams) toolbar.getLayoutParams()).getMarginStart();
            return ViewUtils.isLayoutRtl(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this)) ? (SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getWidth() + access$1600) - ((SearchViewAnimationHelper.access$1900(SearchViewAnimationHelper.this).getWidth() - paddingStart) - marginStart) : (access$1600 - paddingStart) - marginStart;
        }

        private SpringAnimation getToolbarTranslationXSpringAnimation(boolean z) {
            return getToolbarTranslationXSpringAnimation(z, SearchViewAnimationHelper.access$1400(SearchViewAnimationHelper.this));
        }

        private SpringAnimation getToolbarTranslationXSpringAnimation(boolean z, Toolbar toolbar) {
            int toolbarTranslationX = getToolbarTranslationX(toolbar);
            return getSpringAnimation(toolbar, SpringAnimation.TRANSLATION_X, z ? toolbarTranslationX : 0, z ? 0 : toolbarTranslationX);
        }

        private int getToolbarTranslationY() {
            return SearchViewAnimationHelper.access$2000(SearchViewAnimationHelper.this, SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this)) - SearchViewAnimationHelper.access$2000(SearchViewAnimationHelper.this, SearchViewAnimationHelper.access$1400(SearchViewAnimationHelper.this));
        }

        private int getToolbarWidth() {
            int width = SearchViewAnimationHelper.access$1900(SearchViewAnimationHelper.this).getWidth();
            int paddingStart = SearchViewAnimationHelper.access$1900(SearchViewAnimationHelper.this).getPaddingStart() + SearchViewAnimationHelper.access$1900(SearchViewAnimationHelper.this).getPaddingEnd();
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) SearchViewAnimationHelper.access$1400(SearchViewAnimationHelper.this).getLayoutParams();
            return (width - paddingStart) - (marginLayoutParams.getMarginStart() + marginLayoutParams.getMarginEnd());
        }

        private SpringAnimation getToolbarWidthSpringAnimation(boolean z) {
            return getToolbarWidthSpringAnimation(z, SearchViewAnimationHelper.access$1400(SearchViewAnimationHelper.this));
        }

        private SpringAnimation getToolbarWidthSpringAnimation(boolean z, Toolbar toolbar) {
            int width = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getWidth();
            int toolbarWidth = getToolbarWidth();
            SpringAnimation springAnimation = getSpringAnimation(toolbar, getWidthViewProperty(), z ? width : toolbarWidth, z ? toolbarWidth : width);
            springAnimation.addEndListener(new SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda0(this, z, toolbar));
            return springAnimation;
        }

        private FloatPropertyCompat<View> getWidthViewProperty() {
            return new AnonymousClass1("width");
        }

        private void setUpDummyTextViewIfNeeded() {
            TextView textView = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getTextView();
            SearchViewAnimationHelper.access$2200(SearchViewAnimationHelper.this).setText(textView.getText());
            SearchViewAnimationHelper.access$2200(SearchViewAnimationHelper.this).setHint(textView.getHint());
            SearchViewAnimationHelper.access$2200(SearchViewAnimationHelper.this).setVisibility(0);
        }

        private void setWidth(View view, int i) {
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = i;
            view.setLayoutParams(layoutParams);
        }

        View getEndSiblingView(AppBarLayout appBarLayout) {
            int endSiblingViewId = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getEndSiblingViewId();
            return endSiblingViewId != -1 ? appBarLayout.findViewById(endSiblingViewId) : getToolbarActionMenuView();
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public AnimatorSet getExpandCollapseAnimatorSet(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(getBackgroundAlphaAnimator(z), getContentAlphaAnimator(z), getToolbarAlphaAnimator(z), getDummyTextViewWidthAnimator(z), SearchViewAnimationHelper.access$900(SearchViewAnimationHelper.this, z), getSearchBarSiblingsTranslationAnimator(z));
            return animatorSet;
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public List<SpringAnimation> getExpandCollapseSpringAnimations(boolean z) {
            return Arrays.asList(getToolbarWidthSpringAnimation(z), getToolbarTranslationXSpringAnimation(z), getDummyToolbarWidthSpringAnimation(z), getDummyToolbarTranslationXSpringAnimation(z), getToolbarContainerTranslationYSpringAnimation(z), getEditTextTranslationXSpringAnimation(z), getDummyTextTranslationXSpringAnimation(z));
        }

        View getStartSiblingView(AppBarLayout appBarLayout) {
            int startSiblingViewId = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getStartSiblingViewId();
            return startSiblingViewId != -1 ? appBarLayout.findViewById(startSiblingViewId) : getToolbarNavigationIconButton();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getBackgroundAlphaAnimator$0$com-google-android-material-search-SearchViewAnimationHelper$ContainedAnimationDelegate, reason: not valid java name */
        public /* synthetic */ void m409xdc9a02e0(ValueAnimator valueAnimator) {
            SearchViewAnimationHelper.access$2300(SearchViewAnimationHelper.this, ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getDummyTextViewWidthAnimator$2$com-google-android-material-search-SearchViewAnimationHelper$ContainedAnimationDelegate, reason: not valid java name */
        public /* synthetic */ void m410x67b2b750(ValueAnimator valueAnimator) {
            setWidth(SearchViewAnimationHelper.access$2200(SearchViewAnimationHelper.this), ((Integer) valueAnimator.getAnimatedValue()).intValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getToolbarAlphaAnimator$1$com-google-android-material-search-SearchViewAnimationHelper$ContainedAnimationDelegate, reason: not valid java name */
        public /* synthetic */ void m411x2edc5246(ValueAnimator valueAnimator) {
            SearchViewAnimationHelper.access$1400(SearchViewAnimationHelper.this).setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getToolbarWidthSpringAnimation$3$com-google-android-material-search-SearchViewAnimationHelper$ContainedAnimationDelegate, reason: not valid java name */
        public /* synthetic */ void m412xf6aa07b8(boolean z, Toolbar toolbar, DynamicAnimation dynamicAnimation, boolean z2, float f, float f2) {
            if (z) {
                setWidth(toolbar, -1);
            }
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void onAnimationEnd(boolean z) {
            if (z) {
                SearchViewAnimationHelper.access$2300(SearchViewAnimationHelper.this, 1.0f);
                SearchViewAnimationHelper.access$1800(SearchViewAnimationHelper.this).setAlpha(1.0f);
            } else {
                SearchViewAnimationHelper.access$2300(SearchViewAnimationHelper.this, 0.0f);
                SearchViewAnimationHelper.access$1800(SearchViewAnimationHelper.this).setAlpha(0.0f);
                SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).setVisibility(0);
            }
            SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this).setVisibility(4);
            setWidth(SearchViewAnimationHelper.access$2200(SearchViewAnimationHelper.this), -2);
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void onAnimationStart(boolean z) {
            if (z) {
                SearchViewAnimationHelper.access$2300(SearchViewAnimationHelper.this, 0.0f);
                SearchViewAnimationHelper.access$1400(SearchViewAnimationHelper.this).setAlpha(0.0f);
                SearchViewAnimationHelper.access$1800(SearchViewAnimationHelper.this).setAlpha(0.0f);
                SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).setVisibility(4);
            } else {
                SearchViewAnimationHelper.access$2300(SearchViewAnimationHelper.this, 1.0f);
                SearchViewAnimationHelper.access$1800(SearchViewAnimationHelper.this).setAlpha(1.0f);
            }
            SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this).setVisibility(0);
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void setUpDummyToolbarIfNeeded() {
            setUpDummyTextViewIfNeeded();
            if (SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getBackground() != null && SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getBackground().getConstantState() != null) {
                SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this).setBackground(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getBackground().getConstantState().newDrawable());
            }
            Menu menu = SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this).getMenu();
            if (menu != null) {
                menu.clear();
            }
            if (SearchViewAnimationHelper.access$500(SearchViewAnimationHelper.this)) {
                SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this).inflateMenu(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getMenuResId());
                SearchViewAnimationHelper.access$700(SearchViewAnimationHelper.this, SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this));
            }
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void startButtonsTranslationAnimation() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class DefaultAnimationDelegate implements AnimationDelegate {
        private DefaultAnimationDelegate() {
        }

        /* synthetic */ DefaultAnimationDelegate(SearchViewAnimationHelper searchViewAnimationHelper, AnonymousClass1 anonymousClass1) {
            this();
        }

        private void addActionMenuViewAnimatorIfNeeded(AnimatorSet animatorSet) {
            ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(SearchViewAnimationHelper.access$1400(SearchViewAnimationHelper.this));
            if (actionMenuView == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(SearchViewAnimationHelper.access$2100(SearchViewAnimationHelper.this, ToolbarUtils.getActionMenuView(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this)), actionMenuView), 0.0f);
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(actionMenuView));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(getFromTranslationY(), 0.0f);
            ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(actionMenuView));
            animatorSet.playTogether(ofFloat, ofFloat2);
        }

        private void addBackButtonTranslationAnimatorIfNeeded(AnimatorSet animatorSet) {
            ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(SearchViewAnimationHelper.access$1400(SearchViewAnimationHelper.this));
            if (navigationIconButton == null) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(SearchViewAnimationHelper.access$2100(SearchViewAnimationHelper.this, ToolbarUtils.getNavigationIconButton(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this)), navigationIconButton), 0.0f);
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(navigationIconButton));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(getFromTranslationY(), 0.0f);
            ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(navigationIconButton));
            animatorSet.playTogether(ofFloat, ofFloat2);
        }

        private void addEditTextClipAnimator(AnimatorSet animatorSet) {
            if (SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this) == null || !TextUtils.equals(SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).getText(), SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getText())) {
                return;
            }
            Rect rect = new Rect(0, 0, SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).getWidth(), SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).getHeight());
            ValueAnimator ofInt = ValueAnimator.ofInt(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getTextView().getWidth(), SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).getWidth());
            ofInt.addUpdateListener(new SearchViewAnimationHelper$DefaultAnimationDelegate$$ExternalSyntheticLambda2(this, rect));
            animatorSet.playTogether(ofInt);
        }

        private void addTextFadeAnimatorIfNeeded(AnimatorSet animatorSet) {
            if (SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this) == null || TextUtils.equals(SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).getText(), SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getText())) {
                return;
            }
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new SearchViewAnimationHelper$DefaultAnimationDelegate$$ExternalSyntheticLambda0(this));
            animatorSet.playTogether(ofFloat);
        }

        private Animator getActionMenuViewsAlphaAnimator(boolean z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(z ? 300L : 250L);
            ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            if (SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).isMenuItemsAnimated()) {
                ofFloat.addUpdateListener(new FadeThroughUpdateListener(ToolbarUtils.getActionMenuView(SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this)), ToolbarUtils.getActionMenuView(SearchViewAnimationHelper.access$1400(SearchViewAnimationHelper.this))));
            }
            return ofFloat;
        }

        private AnimatorSet getButtonsTranslationAnimator(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            addBackButtonTranslationAnimatorIfNeeded(animatorSet);
            addActionMenuViewAnimatorIfNeeded(animatorSet);
            animatorSet.setDuration(z ? 300L : 250L);
            animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            return animatorSet;
        }

        private Animator getContentAlphaAnimator(boolean z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(z ? 150L : SearchViewAnimationHelper.HIDE_CONTENT_ALPHA_DURATION_MS);
            ofFloat.setStartDelay(z ? 75L : 0L);
            ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.LINEAR_INTERPOLATOR));
            ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(SearchViewAnimationHelper.access$1700(SearchViewAnimationHelper.this), SearchViewAnimationHelper.access$1800(SearchViewAnimationHelper.this)));
            return ofFloat;
        }

        private Animator getContentAnimator(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(getContentAlphaAnimator(z), getDividerAnimator(z), getContentScaleAnimator(z));
            return animatorSet;
        }

        private Animator getContentScaleAnimator(boolean z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(SearchViewAnimationHelper.CONTENT_FROM_SCALE, 1.0f);
            ofFloat.setDuration(z ? 300L : 250L);
            ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            ofFloat.addUpdateListener(MultiViewUpdateListener.scaleListener(SearchViewAnimationHelper.access$1800(SearchViewAnimationHelper.this)));
            return ofFloat;
        }

        private Animator getDividerAnimator(boolean z) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat((SearchViewAnimationHelper.access$1800(SearchViewAnimationHelper.this).getHeight() * 0.050000012f) / 2.0f, 0.0f);
            ofFloat.setDuration(z ? 300L : 250L);
            ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationYListener(SearchViewAnimationHelper.access$1700(SearchViewAnimationHelper.this)));
            return ofFloat;
        }

        private Animator getDummyToolbarAnimator(boolean z) {
            return getTranslationAnimator(z, SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this), getFromTranslationXEnd(SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this)) - (SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getPaddingEnd() - SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this).getPaddingEnd()), getFromTranslationY());
        }

        private Animator getEditTextAnimator(boolean z) {
            return getTranslationAnimatorForText(z, SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this));
        }

        private int getFromTranslationXEnd(View view) {
            int marginEnd = ((ViewGroup.MarginLayoutParams) view.getLayoutParams()).getMarginEnd();
            int access$1600 = SearchViewAnimationHelper.access$1600(SearchViewAnimationHelper.this, SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this));
            return ViewUtils.isLayoutRtl(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this)) ? access$1600 - marginEnd : ((SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getWidth() + access$1600) + marginEnd) - SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this).getWidth();
        }

        private int getFromTranslationY() {
            return (SearchViewAnimationHelper.access$2000(SearchViewAnimationHelper.this, SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this)) + (SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getHeight() / 2)) - (SearchViewAnimationHelper.access$1900(SearchViewAnimationHelper.this).getTop() + (SearchViewAnimationHelper.access$1900(SearchViewAnimationHelper.this).getHeight() / 2));
        }

        private Animator getHeaderContainerAnimator(boolean z) {
            return getTranslationAnimator(z, SearchViewAnimationHelper.access$1300(SearchViewAnimationHelper.this), getFromTranslationXEnd(SearchViewAnimationHelper.access$1300(SearchViewAnimationHelper.this)), getFromTranslationY());
        }

        private Animator getRootViewAnimator(boolean z) {
            Rect initialHideToClipBounds = SearchViewAnimationHelper.access$1100(SearchViewAnimationHelper.this).getInitialHideToClipBounds();
            Rect initialHideFromClipBounds = SearchViewAnimationHelper.access$1100(SearchViewAnimationHelper.this).getInitialHideFromClipBounds();
            Rect calculateRectFromBounds = initialHideToClipBounds != null ? initialHideToClipBounds : ViewUtils.calculateRectFromBounds(SearchViewAnimationHelper.access$100(SearchViewAnimationHelper.this));
            Rect calculateOffsetRectFromBounds = initialHideFromClipBounds != null ? initialHideFromClipBounds : ViewUtils.calculateOffsetRectFromBounds(SearchViewAnimationHelper.access$200(SearchViewAnimationHelper.this), SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this));
            Rect rect = new Rect(calculateOffsetRectFromBounds);
            float cornerSize = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getCornerSize();
            float[] maxCornerRadii = maxCornerRadii(SearchViewAnimationHelper.access$200(SearchViewAnimationHelper.this).getCornerRadii(), SearchViewAnimationHelper.access$1100(SearchViewAnimationHelper.this).getExpandedCornerRadii());
            ValueAnimator ofObject = ValueAnimator.ofObject(new RectEvaluator(rect), calculateOffsetRectFromBounds, calculateRectFromBounds);
            ofObject.addUpdateListener(new SearchViewAnimationHelper$DefaultAnimationDelegate$$ExternalSyntheticLambda1(this, cornerSize, maxCornerRadii, rect));
            ofObject.setDuration(z ? 300L : 250L);
            ofObject.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            return ofObject;
        }

        private Animator getScrimAlphaAnimator(boolean z) {
            TimeInterpolator timeInterpolator = z ? AnimationUtils.LINEAR_INTERPOLATOR : AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(z ? 300L : 250L);
            ofFloat.setStartDelay(z ? SearchViewAnimationHelper.SHOW_SCRIM_ALPHA_DURATION_MS : 0L);
            ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, timeInterpolator));
            ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(SearchViewAnimationHelper.access$1200(SearchViewAnimationHelper.this)));
            return ofFloat;
        }

        private Animator getSearchPrefixAnimator(boolean z) {
            return getTranslationAnimatorForText(z, SearchViewAnimationHelper.access$1500(SearchViewAnimationHelper.this));
        }

        private AnimatorSet getTextAnimator(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            addTextFadeAnimatorIfNeeded(animatorSet);
            addEditTextClipAnimator(animatorSet);
            animatorSet.setDuration(z ? 300L : 250L);
            animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.LINEAR_INTERPOLATOR));
            return animatorSet;
        }

        private Animator getTranslationAnimator(boolean z, View view, int i, int i2) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(i, 0.0f);
            ofFloat.addUpdateListener(MultiViewUpdateListener.translationXListener(view));
            ValueAnimator ofFloat2 = ValueAnimator.ofFloat(i2, 0.0f);
            ofFloat2.addUpdateListener(MultiViewUpdateListener.translationYListener(view));
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.playTogether(ofFloat, ofFloat2);
            animatorSet.setDuration(z ? 300L : 250L);
            animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            return animatorSet;
        }

        private Animator getTranslationAnimatorForText(boolean z, View view) {
            TextView placeholderTextView = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getPlaceholderTextView();
            if (TextUtils.isEmpty(placeholderTextView.getText()) || z) {
                placeholderTextView = SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getTextView();
            }
            int access$1600 = SearchViewAnimationHelper.access$1600(SearchViewAnimationHelper.this, placeholderTextView) - SearchViewAnimationHelper.access$1600(SearchViewAnimationHelper.this, view);
            if (ViewUtils.isLayoutRtl(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this))) {
                access$1600 += placeholderTextView.getWidth() - view.getWidth();
            }
            return getTranslationAnimator(z, view, access$1600, getFromTranslationY());
        }

        private float[] lerpCornerRadii(float f, float[] fArr, float f2) {
            return new float[]{AnimationUtils.lerp(f, fArr[0], f2), AnimationUtils.lerp(f, fArr[1], f2), AnimationUtils.lerp(f, fArr[2], f2), AnimationUtils.lerp(f, fArr[3], f2), AnimationUtils.lerp(f, fArr[4], f2), AnimationUtils.lerp(f, fArr[5], f2), AnimationUtils.lerp(f, fArr[6], f2), AnimationUtils.lerp(f, fArr[7], f2)};
        }

        private float[] maxCornerRadii(float[] fArr, float[] fArr2) {
            return new float[]{Math.max(fArr[0], fArr2[0]), Math.max(fArr[1], fArr2[1]), Math.max(fArr[2], fArr2[2]), Math.max(fArr[3], fArr2[3]), Math.max(fArr[4], fArr2[4]), Math.max(fArr[5], fArr2[5]), Math.max(fArr[6], fArr2[6]), Math.max(fArr[7], fArr2[7])};
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public AnimatorSet getExpandCollapseAnimatorSet(boolean z) {
            AnimatorSet animatorSet = new AnimatorSet();
            if (SearchViewAnimationHelper.access$800(SearchViewAnimationHelper.this) == null) {
                animatorSet.playTogether(getButtonsTranslationAnimator(z));
            }
            animatorSet.playTogether(getScrimAlphaAnimator(z), getRootViewAnimator(z), SearchViewAnimationHelper.access$900(SearchViewAnimationHelper.this, z), getContentAnimator(z), getHeaderContainerAnimator(z), getDummyToolbarAnimator(z), getActionMenuViewsAlphaAnimator(z), getEditTextAnimator(z), getSearchPrefixAnimator(z), getTextAnimator(z));
            return animatorSet;
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public List<SpringAnimation> getExpandCollapseSpringAnimations(boolean z) {
            return new ArrayList();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$addEditTextClipAnimator$1$com-google-android-material-search-SearchViewAnimationHelper$DefaultAnimationDelegate, reason: not valid java name */
        public /* synthetic */ void m413xb169caa7(Rect rect, ValueAnimator valueAnimator) {
            rect.right = ((Integer) valueAnimator.getAnimatedValue()).intValue();
            SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).setClipBounds(rect);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$addTextFadeAnimatorIfNeeded$2$com-google-android-material-search-SearchViewAnimationHelper$DefaultAnimationDelegate, reason: not valid java name */
        public /* synthetic */ void m414x8539623c(ValueAnimator valueAnimator) {
            SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getTextView().setAlpha(1.0f - ((Float) valueAnimator.getAnimatedValue()).floatValue());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* renamed from: lambda$getRootViewAnimator$0$com-google-android-material-search-SearchViewAnimationHelper$DefaultAnimationDelegate, reason: not valid java name */
        public /* synthetic */ void m415x8b5d297b(float f, float[] fArr, Rect rect, ValueAnimator valueAnimator) {
            SearchViewAnimationHelper.access$200(SearchViewAnimationHelper.this).updateClipBoundsAndCornerRadii(rect, lerpCornerRadii(f, fArr, valueAnimator.getAnimatedFraction()));
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void onAnimationEnd(boolean z) {
            SearchViewAnimationHelper.access$1000(SearchViewAnimationHelper.this, z ? 1.0f : 0.0f);
            SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).setAlpha(1.0f);
            if (SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this) != null) {
                SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getTextView().setAlpha(1.0f);
            }
            SearchViewAnimationHelper.access$300(SearchViewAnimationHelper.this).setClipBounds(null);
            SearchViewAnimationHelper.access$200(SearchViewAnimationHelper.this).resetClipBoundsAndCornerRadii();
            if (z) {
                return;
            }
            SearchViewAnimationHelper.access$1100(SearchViewAnimationHelper.this).clearExpandedCornerRadii();
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void onAnimationStart(boolean z) {
            SearchViewAnimationHelper.access$1000(SearchViewAnimationHelper.this, z ? 0.0f : 1.0f);
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void setUpDummyToolbarIfNeeded() {
            Menu menu = SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this).getMenu();
            if (menu != null) {
                menu.clear();
            }
            if (!SearchViewAnimationHelper.access$500(SearchViewAnimationHelper.this)) {
                SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this).setVisibility(8);
                return;
            }
            SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this).inflateMenu(SearchViewAnimationHelper.access$600(SearchViewAnimationHelper.this).getMenuResId());
            SearchViewAnimationHelper.access$700(SearchViewAnimationHelper.this, SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this));
            SearchViewAnimationHelper.access$400(SearchViewAnimationHelper.this).setVisibility(0);
        }

        @Override // com.google.android.material.search.SearchViewAnimationHelper.AnimationDelegate
        public void startButtonsTranslationAnimation() {
            getButtonsTranslationAnimator(false).start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SearchViewAnimationHelper(Context context, SearchView searchView, boolean z) {
        this.context = context;
        this.searchView = searchView;
        this.scrim = searchView.scrim;
        this.backgroundView = searchView.backgroundView;
        this.rootView = searchView.rootView;
        this.headerContainer = searchView.headerContainer;
        this.toolbarContainer = searchView.toolbarContainer;
        this.toolbar = searchView.toolbar;
        this.dummyToolbar = searchView.dummyToolbar;
        this.searchPrefix = searchView.searchPrefix;
        this.dummyTextView = searchView.dummyTextView;
        this.editText = searchView.editText;
        this.clearButton = searchView.clearButton;
        this.divider = searchView.divider;
        this.contentContainer = searchView.contentContainer;
        this.backHelper = new MaterialMainContainerBackHelper(this.rootView);
        this.standardAccelerateInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingStandardAccelerateInterpolator, DEFAULT_INTERPOLATOR);
        this.standardDecelerateInterpolator = MotionUtils.resolveThemeInterpolator(context, R.attr.motionEasingStandardDecelerateInterpolator, DEFAULT_INTERPOLATOR);
        this.durationShort1 = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationShort1, 100);
        this.durationShort2 = MotionUtils.resolveThemeDuration(context, R.attr.motionDurationShort2, 100);
        this.animationDelegate = z ? new ContainedAnimationDelegate() : new DefaultAnimationDelegate(this, null);
    }

    static /* synthetic */ SearchView access$100(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.searchView;
    }

    static /* synthetic */ void access$1000(SearchViewAnimationHelper searchViewAnimationHelper, float f) {
        searchViewAnimationHelper.setContentViewsAlpha(f);
    }

    static /* synthetic */ MaterialMainContainerBackHelper access$1100(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.backHelper;
    }

    static /* synthetic */ View access$1200(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.scrim;
    }

    static /* synthetic */ FrameLayout access$1300(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.headerContainer;
    }

    static /* synthetic */ Toolbar access$1400(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.toolbar;
    }

    static /* synthetic */ TextView access$1500(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.searchPrefix;
    }

    static /* synthetic */ int access$1600(SearchViewAnimationHelper searchViewAnimationHelper, View view) {
        return searchViewAnimationHelper.getViewLeftFromSearchViewParent(view);
    }

    static /* synthetic */ View access$1700(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.divider;
    }

    static /* synthetic */ TouchObserverFrameLayout access$1800(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.contentContainer;
    }

    static /* synthetic */ FrameLayout access$1900(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.toolbarContainer;
    }

    static /* synthetic */ ClippableRoundedCornerLayout access$200(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.rootView;
    }

    static /* synthetic */ int access$2000(SearchViewAnimationHelper searchViewAnimationHelper, View view) {
        return searchViewAnimationHelper.getViewTopFromSearchViewParent(view);
    }

    static /* synthetic */ int access$2100(SearchViewAnimationHelper searchViewAnimationHelper, View view, View view2) {
        return searchViewAnimationHelper.getTranslationXBetweenViews(view, view2);
    }

    static /* synthetic */ TextView access$2200(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.dummyTextView;
    }

    static /* synthetic */ void access$2300(SearchViewAnimationHelper searchViewAnimationHelper, float f) {
        searchViewAnimationHelper.setBackgroundAlpha(f);
    }

    static /* synthetic */ int access$2400(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.durationShort2;
    }

    static /* synthetic */ int access$2500(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.durationShort1;
    }

    static /* synthetic */ TimeInterpolator access$2600(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.standardDecelerateInterpolator;
    }

    static /* synthetic */ TimeInterpolator access$2700(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.standardAccelerateInterpolator;
    }

    static /* synthetic */ Context access$2900(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.context;
    }

    static /* synthetic */ EditText access$300(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.editText;
    }

    static /* synthetic */ Toolbar access$400(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.dummyToolbar;
    }

    static /* synthetic */ boolean access$500(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.shouldInflateDummyToolbar();
    }

    static /* synthetic */ SearchBar access$600(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.searchBar;
    }

    static /* synthetic */ void access$700(SearchViewAnimationHelper searchViewAnimationHelper, Toolbar toolbar) {
        searchViewAnimationHelper.setMenuItemsNotClickable(toolbar);
    }

    static /* synthetic */ AnimatorSet access$800(SearchViewAnimationHelper searchViewAnimationHelper) {
        return searchViewAnimationHelper.backProgressAnimatorSet;
    }

    static /* synthetic */ Animator access$900(SearchViewAnimationHelper searchViewAnimationHelper, boolean z) {
        return searchViewAnimationHelper.getClearButtonAnimator(z);
    }

    private void addBackButtonAnimatorIfNeeded(AnimatorSet animatorSet, ImageButton imageButton) {
        if (this.searchBar == null || this.searchBar.getNavigationIcon() != null) {
            return;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new SearchViewAnimationHelper$$ExternalSyntheticLambda5(imageButton));
        animatorSet.playTogether(ofFloat);
    }

    private void addBackButtonProgressAnimatorIfNeeded(AnimatorSet animatorSet) {
        ImageButton navigationIconButton = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if (navigationIconButton == null) {
            return;
        }
        Drawable unwrap = DrawableCompat.unwrap(navigationIconButton.getDrawable());
        if (!this.searchView.isAnimatedNavigationIcon()) {
            setFullDrawableProgressIfNeeded(unwrap);
            return;
        }
        addDrawerArrowDrawableAnimatorIfNeeded(animatorSet, unwrap);
        addFadeThroughDrawableAnimatorIfNeeded(animatorSet, unwrap);
        addBackButtonAnimatorIfNeeded(animatorSet, navigationIconButton);
    }

    private void addDrawerArrowDrawableAnimatorIfNeeded(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof DrawerArrowDrawable) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new SearchViewAnimationHelper$$ExternalSyntheticLambda0((DrawerArrowDrawable) drawable));
            animatorSet.playTogether(ofFloat);
        }
    }

    private void addFadeThroughDrawableAnimatorIfNeeded(AnimatorSet animatorSet, Drawable drawable) {
        if (drawable instanceof FadeThroughDrawable) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.addUpdateListener(new SearchViewAnimationHelper$$ExternalSyntheticLambda2((FadeThroughDrawable) drawable));
            animatorSet.playTogether(ofFloat);
        }
    }

    private AnimatorSet getButtonsProgressAnimator(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        addBackButtonProgressAnimatorIfNeeded(animatorSet);
        animatorSet.setDuration(z ? 300L : 250L);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return animatorSet;
    }

    private Animator getClearButtonAnimator(boolean z) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.setDuration(z ? SHOW_CLEAR_BUTTON_ALPHA_DURATION_MS : HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS);
        ofFloat.setStartDelay(z ? 250L : 0L);
        ofFloat.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.LINEAR_INTERPOLATOR));
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(this.clearButton));
        return ofFloat;
    }

    private AnimatorSet getExpandCollapseAnimatorSet(boolean z) {
        AnimatorSet expandCollapseAnimatorSet = this.animationDelegate.getExpandCollapseAnimatorSet(z);
        if (this.backProgressAnimatorSet == null) {
            expandCollapseAnimatorSet.playTogether(getButtonsProgressAnimator(z));
        }
        return expandCollapseAnimatorSet;
    }

    private List<SpringAnimation> getExpandCollapseSpringAnimations(boolean z) {
        return this.animationDelegate.getExpandCollapseSpringAnimations(z);
    }

    private AnimatorSet getTranslateAnimatorSet(boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(getTranslationYAnimator());
        addBackButtonProgressAnimatorIfNeeded(animatorSet);
        animatorSet.setInterpolator(ReversableAnimatedValueInterpolator.of(z, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        animatorSet.setDuration(z ? SHOW_TRANSLATE_DURATION_MS : 300L);
        return animatorSet;
    }

    private int getTranslationXBetweenViews(View view, View view2) {
        if (view != null) {
            return getViewLeftFromSearchViewParent(view) - getViewLeftFromSearchViewParent(view2);
        }
        int marginStart = ((ViewGroup.MarginLayoutParams) view2.getLayoutParams()).getMarginStart();
        int paddingStart = this.searchBar.getPaddingStart();
        int viewLeftFromSearchViewParent = getViewLeftFromSearchViewParent(this.searchBar);
        return ViewUtils.isLayoutRtl(this.searchBar) ? (((this.searchBar.getWidth() + viewLeftFromSearchViewParent) + marginStart) - paddingStart) - this.searchView.getRight() : (viewLeftFromSearchViewParent - marginStart) + paddingStart;
    }

    private Animator getTranslationYAnimator() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.rootView.getHeight(), 0.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.translationYListener(this.rootView));
        return ofFloat;
    }

    private int getViewLeftFromSearchViewParent(View view) {
        int left = view.getLeft();
        for (ViewParent parent = view.getParent(); (parent instanceof View) && parent != this.searchView.getParent(); parent = parent.getParent()) {
            left += ((View) parent).getLeft();
        }
        return left;
    }

    private int getViewTopFromSearchViewParent(View view) {
        int top = view.getTop();
        for (ViewParent parent = view.getParent(); (parent instanceof View) && parent != this.searchView.getParent(); parent = parent.getParent()) {
            top += ((View) parent).getTop();
        }
        return top;
    }

    private boolean hasVisibleMenuItems(Menu menu) {
        if (menu == null) {
            return false;
        }
        for (int i = 0; i < menu.size(); i++) {
            if (menu.getItem(i).isVisible()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$addBackButtonAnimatorIfNeeded$2(ImageButton imageButton, ValueAnimator valueAnimator) {
        imageButton.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$addDrawerArrowDrawableAnimatorIfNeeded$3(DrawerArrowDrawable drawerArrowDrawable, ValueAnimator valueAnimator) {
        drawerArrowDrawable.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$addFadeThroughDrawableAnimatorIfNeeded$4(FadeThroughDrawable fadeThroughDrawable, ValueAnimator valueAnimator) {
        fadeThroughDrawable.setProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    private void setActionMenuViewAlphaIfNeeded(float f) {
        ActionMenuView actionMenuView;
        if (!this.searchView.isMenuItemsAnimated() || (actionMenuView = ToolbarUtils.getActionMenuView(this.toolbar)) == null) {
            return;
        }
        actionMenuView.setAlpha(f);
    }

    private void setBackgroundAlpha(float f) {
        this.backgroundView.getBackground().mutate().setAlpha((int) (255.0f * f));
    }

    private void setContentViewsAlpha(float f) {
        this.clearButton.setAlpha(f);
        this.divider.setAlpha(f);
        this.contentContainer.setAlpha(f);
        setActionMenuViewAlphaIfNeeded(f);
    }

    private void setFullDrawableProgressIfNeeded(Drawable drawable) {
        if (drawable instanceof DrawerArrowDrawable) {
            ((DrawerArrowDrawable) drawable).setProgress(1.0f);
        }
        if (drawable instanceof FadeThroughDrawable) {
            ((FadeThroughDrawable) drawable).setProgress(1.0f);
        }
    }

    private void setMenuItemsNotClickable(Toolbar toolbar) {
        ActionMenuView actionMenuView = ToolbarUtils.getActionMenuView(toolbar);
        if (actionMenuView != null) {
            for (int i = 0; i < actionMenuView.getChildCount(); i++) {
                View childAt = actionMenuView.getChildAt(i);
                childAt.setClickable(false);
                childAt.setFocusable(false);
                childAt.setFocusableInTouchMode(false);
            }
        }
    }

    private boolean shouldInflateDummyToolbar() {
        return this.searchBar.getMenuResId() != -1 && this.searchView.isMenuItemsAnimated() && hasVisibleMenuItems(this.searchBar.getMenu());
    }

    private AnimatorSet startHideAnimationCollapse() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            this.editText.clearFocus();
        }
        AnimationCoordinator animationCoordinator = new AnimationCoordinator();
        AnimatorSet expandCollapseAnimatorSet = getExpandCollapseAnimatorSet(false);
        animationCoordinator.addAnimator(expandCollapseAnimatorSet);
        Iterator<SpringAnimation> it = getExpandCollapseSpringAnimations(false).iterator();
        while (it.hasNext()) {
            animationCoordinator.addDynamicAnimation(it.next());
        }
        animationCoordinator.addListener(new AnonymousClass2(false, animationCoordinator));
        animationCoordinator.start();
        this.activeCoordinator = animationCoordinator;
        return expandCollapseAnimatorSet;
    }

    private AnimatorSet startHideAnimationTranslate() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            this.editText.clearFocus();
        }
        AnimatorSet translateAnimatorSet = getTranslateAnimatorSet(false);
        translateAnimatorSet.addListener(new AnonymousClass4(translateAnimatorSet));
        translateAnimatorSet.start();
        this.activeTranslateAnimatorSet = translateAnimatorSet;
        return translateAnimatorSet;
    }

    private void startShowAnimationExpand() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            this.searchView.requestFocusAndShowKeyboardIfNeeded();
        }
        this.searchView.setTransitionState(SearchView.TransitionState.SHOWING);
        this.animationDelegate.setUpDummyToolbarIfNeeded();
        this.editText.setText(this.searchBar.getText());
        this.editText.setSelection(this.editText.getText().length());
        this.rootView.setVisibility(4);
        this.rootView.post(new SearchViewAnimationHelper$$ExternalSyntheticLambda1(this));
    }

    private void startShowAnimationTranslate() {
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            SearchView searchView = this.searchView;
            SearchView searchView2 = this.searchView;
            Objects.requireNonNull(searchView2);
            searchView.postDelayed(new SearchViewAnimationHelper$$ExternalSyntheticLambda3(searchView2), 150L);
        }
        this.rootView.setVisibility(4);
        this.rootView.post(new SearchViewAnimationHelper$$ExternalSyntheticLambda4(this));
    }

    public void cancelBackProgress() {
        this.backHelper.cancelBackProgress(this.searchBar);
        if (this.backProgressAnimatorSet != null) {
            this.backProgressAnimatorSet.reverse();
        }
        this.backProgressAnimatorSet = null;
    }

    void cancelPendingAnimations() {
        if (this.activeCoordinator != null) {
            this.activeCoordinator.clear();
            this.activeCoordinator = null;
        }
        if (this.activeTranslateAnimatorSet != null) {
            this.activeTranslateAnimatorSet.cancel();
            this.activeTranslateAnimatorSet = null;
        }
    }

    public void finishBackProgress() {
        this.backHelper.finishBackProgress(hide().getTotalDuration(), this.searchBar);
        if (this.backProgressAnimatorSet != null) {
            this.animationDelegate.startButtonsTranslationAnimation();
            this.backProgressAnimatorSet.resume();
        }
        this.backProgressAnimatorSet = null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialMainContainerBackHelper getBackHelper() {
        return this.backHelper;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public AnimatorSet hide() {
        cancelPendingAnimations();
        return this.searchBar != null ? startHideAnimationCollapse() : startHideAnimationTranslate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startShowAnimationExpand$0$com-google-android-material-search-SearchViewAnimationHelper, reason: not valid java name */
    public /* synthetic */ void m407x94743afc() {
        AnimationCoordinator animationCoordinator = new AnimationCoordinator();
        animationCoordinator.addAnimator(getExpandCollapseAnimatorSet(true));
        Iterator<SpringAnimation> it = getExpandCollapseSpringAnimations(true).iterator();
        while (it.hasNext()) {
            animationCoordinator.addDynamicAnimation(it.next());
        }
        animationCoordinator.addListener(new AnonymousClass1(true, animationCoordinator));
        animationCoordinator.start();
        this.activeCoordinator = animationCoordinator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startShowAnimationTranslate$1$com-google-android-material-search-SearchViewAnimationHelper, reason: not valid java name */
    public /* synthetic */ void m408x4df249eb() {
        this.rootView.setTranslationY(this.rootView.getHeight());
        AnimatorSet translateAnimatorSet = getTranslateAnimatorSet(true);
        translateAnimatorSet.addListener(new AnonymousClass3(translateAnimatorSet));
        translateAnimatorSet.start();
        this.activeTranslateAnimatorSet = translateAnimatorSet;
    }

    public BackEventCompat onHandleBackInvoked() {
        return this.backHelper.onHandleBackInvoked();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSearchBar(SearchBar searchBar) {
        this.searchBar = searchBar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void show() {
        cancelPendingAnimations();
        if (this.searchBar != null) {
            startShowAnimationExpand();
        } else {
            startShowAnimationTranslate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startBackProgress(BackEventCompat backEventCompat) {
        this.backHelper.startBackProgress(backEventCompat, this.searchBar);
    }

    public void updateBackProgress(BackEventCompat backEventCompat) {
        if (backEventCompat.getProgress() <= 0.0f) {
            return;
        }
        this.backHelper.updateBackProgress(backEventCompat, this.searchBar, this.searchBar.getCornerSize());
        if (this.backProgressAnimatorSet != null) {
            this.backProgressAnimatorSet.setCurrentPlayTime(backEventCompat.getProgress() * ((float) this.backProgressAnimatorSet.getDuration()));
            return;
        }
        if (this.searchView.isAdjustNothingSoftInputMode()) {
            this.editText.clearFocus();
        }
        if (this.searchView.isAnimatedNavigationIcon()) {
            this.backProgressAnimatorSet = getButtonsProgressAnimator(false);
            this.backProgressAnimatorSet.start();
            this.backProgressAnimatorSet.pause();
        }
    }
}
