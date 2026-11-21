package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.search.SearchBar;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/* loaded from: classes.dex */
class SearchBarAnimationHelper {
    private static final long COLLAPSE_DURATION_MS = 250;
    private static final long COLLAPSE_FADE_IN_CHILDREN_DURATION_MS = 100;
    private static final long EXPAND_DURATION_MS = 300;
    private static final long EXPAND_FADE_OUT_CHILDREN_DURATION_MS = 75;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_DURATION_MS = 250;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_IN_START_DELAY_MS = 500;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_OUT_START_DELAY_MS = 750;
    private static final long ON_LOAD_ANIM_SECONDARY_DURATION_MS = 250;
    private static final long ON_LOAD_ANIM_SECONDARY_START_DELAY_MS = 250;
    private boolean collapsing;
    private Animator defaultCenterViewAnimator;
    private boolean expanding;
    private Animator secondaryViewAnimator;
    private final Set<SearchBar.OnLoadAnimationCallback> onLoadAnimationCallbacks = new LinkedHashSet();
    private final Set<AnimatorListenerAdapter> expandAnimationListeners = new LinkedHashSet();
    private final Set<AnimatorListenerAdapter> collapseAnimationListeners = new LinkedHashSet();
    private boolean onLoadAnimationFadeInEnabled = true;
    private Animator runningExpandOrCollapseAnimator = null;

    /* renamed from: com.google.android.material.search.SearchBarAnimationHelper$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SearchBarAnimationHelper.access$000(SearchBarAnimationHelper.this, new SearchBarAnimationHelper$1$$ExternalSyntheticLambda0());
        }
    }

    /* renamed from: com.google.android.material.search.SearchBarAnimationHelper$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        final /* synthetic */ View val$centerView;
        final /* synthetic */ Animator val$secondaryViewAnimator;

        AnonymousClass2(View view, Animator animator) {
            this.val$centerView = view;
            this.val$secondaryViewAnimator = animator;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$centerView.setVisibility(8);
            this.val$secondaryViewAnimator.start();
        }
    }

    /* renamed from: com.google.android.material.search.SearchBarAnimationHelper$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends AnimatorListenerAdapter {
        AnonymousClass3() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SearchBarAnimationHelper.access$202(SearchBarAnimationHelper.this, null);
        }
    }

    /* renamed from: com.google.android.material.search.SearchBarAnimationHelper$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends AnimatorListenerAdapter {
        final /* synthetic */ SearchBar val$searchBar;

        AnonymousClass4(SearchBar searchBar) {
            this.val$searchBar = searchBar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SearchBarAnimationHelper.access$102(SearchBarAnimationHelper.this, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.val$searchBar.setVisibility(4);
        }
    }

    /* renamed from: com.google.android.material.search.SearchBarAnimationHelper$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 extends AnimatorListenerAdapter {
        AnonymousClass5() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SearchBarAnimationHelper.access$202(SearchBarAnimationHelper.this, null);
        }
    }

    /* renamed from: com.google.android.material.search.SearchBarAnimationHelper$6, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 extends AnimatorListenerAdapter {
        final /* synthetic */ SearchBar val$searchBar;

        AnonymousClass6(SearchBar searchBar) {
            this.val$searchBar = searchBar;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.val$searchBar.setVisibility(0);
            SearchBarAnimationHelper.access$302(SearchBarAnimationHelper.this, false);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            this.val$searchBar.stopOnLoadAnimation();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public interface OnLoadAnimationInvocation {
        void invoke(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback);
    }

    public static /* synthetic */ void $r8$lambda$1r7Y4hRSo4F1Esrbw5SdK9GHD3Q(Animator animator) {
        animator.start();
    }

    static /* synthetic */ void access$000(SearchBarAnimationHelper searchBarAnimationHelper, OnLoadAnimationInvocation onLoadAnimationInvocation) {
        searchBarAnimationHelper.dispatchOnLoadAnimation(onLoadAnimationInvocation);
    }

    static /* synthetic */ boolean access$102(SearchBarAnimationHelper searchBarAnimationHelper, boolean z) {
        searchBarAnimationHelper.expanding = z;
        return z;
    }

    static /* synthetic */ Animator access$202(SearchBarAnimationHelper searchBarAnimationHelper, Animator animator) {
        searchBarAnimationHelper.runningExpandOrCollapseAnimator = animator;
        return animator;
    }

    static /* synthetic */ boolean access$302(SearchBarAnimationHelper searchBarAnimationHelper, boolean z) {
        searchBarAnimationHelper.collapsing = z;
        return z;
    }

    private void dispatchOnLoadAnimation(OnLoadAnimationInvocation onLoadAnimationInvocation) {
        Iterator<SearchBar.OnLoadAnimationCallback> it = this.onLoadAnimationCallbacks.iterator();
        while (it.hasNext()) {
            onLoadAnimationInvocation.invoke(it.next());
        }
    }

    private Animator getCollapseAnimator(SearchBar searchBar, View view, AppBarLayout appBarLayout) {
        return getExpandCollapseAnimationHelper(searchBar, view, appBarLayout).setDuration(250L).addListener(new AnonymousClass6(searchBar)).getCollapseAnimator();
    }

    private Animator getDefaultCenterViewAnimator(View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(view));
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(this.onLoadAnimationFadeInEnabled ? 250L : 0L);
        ofFloat.setStartDelay(this.onLoadAnimationFadeInEnabled ? ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_IN_START_DELAY_MS : 0L);
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat2.addUpdateListener(MultiViewUpdateListener.alphaListener(view));
        ofFloat2.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat2.setDuration(250L);
        ofFloat2.setStartDelay(ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_OUT_START_DELAY_MS);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(ofFloat, ofFloat2);
        return animatorSet;
    }

    private List<View> getEndAnchoredViews(View view) {
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(view);
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                View childAt = viewGroup.getChildAt(i);
                if ((!isLayoutRtl && (childAt instanceof ActionMenuView)) || (isLayoutRtl && !(childAt instanceof ActionMenuView))) {
                    arrayList.add(childAt);
                }
            }
        }
        return arrayList;
    }

    private Animator getExpandAnimator(SearchBar searchBar, View view, AppBarLayout appBarLayout) {
        return getExpandCollapseAnimationHelper(searchBar, view, appBarLayout).setDuration(EXPAND_DURATION_MS).addListener(new AnonymousClass4(searchBar)).getExpandAnimator();
    }

    private ExpandCollapseAnimationHelper getExpandCollapseAnimationHelper(SearchBar searchBar, View view, AppBarLayout appBarLayout) {
        return new ExpandCollapseAnimationHelper(searchBar, view).setAdditionalUpdateListener(getExpandedViewBackgroundUpdateListener(searchBar, view)).setCollapsedViewOffsetY(appBarLayout != null ? appBarLayout.getTop() : 0).addEndAnchoredViews(getEndAnchoredViews(view));
    }

    private ValueAnimator.AnimatorUpdateListener getExpandedViewBackgroundUpdateListener(SearchBar searchBar, View view) {
        MaterialShapeDrawable createWithElevationOverlay = MaterialShapeDrawable.createWithElevationOverlay(view.getContext());
        createWithElevationOverlay.setCornerSize(searchBar.getCornerSize());
        createWithElevationOverlay.setElevation(searchBar.getElevation());
        return new SearchBarAnimationHelper$$ExternalSyntheticLambda4(createWithElevationOverlay, view);
    }

    private List<View> getFadeChildren(SearchBar searchBar) {
        List<View> children = ViewUtils.getChildren(searchBar);
        if (searchBar.getCenterView() != null) {
            children.remove(searchBar.getCenterView());
        }
        return children;
    }

    private Animator getFadeInChildrenAnimator(SearchBar searchBar) {
        List<View> fadeChildren = getFadeChildren(searchBar);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(fadeChildren));
        ofFloat.setDuration(COLLAPSE_FADE_IN_CHILDREN_DURATION_MS);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return ofFloat;
    }

    private Animator getFadeOutChildrenAnimator(SearchBar searchBar, View view) {
        List<View> fadeChildren = getFadeChildren(searchBar);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(fadeChildren));
        ofFloat.addUpdateListener(new SearchBarAnimationHelper$$ExternalSyntheticLambda0(view));
        ofFloat.setDuration(75L);
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return ofFloat;
    }

    private Animator getSecondaryActionMenuItemAnimator(View view) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(view));
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(250L);
        return ofFloat;
    }

    private Animator getSecondaryViewAnimator(TextView textView, View view) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setStartDelay(250L);
        animatorSet.play(getTextViewAnimator(textView));
        if (view != null) {
            animatorSet.play(getSecondaryActionMenuItemAnimator(view));
        }
        return animatorSet;
    }

    private Animator getTextViewAnimator(TextView textView) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(MultiViewUpdateListener.alphaListener(textView));
        ofFloat.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        ofFloat.setDuration(250L);
        return ofFloat;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getExpandedViewBackgroundUpdateListener$1(MaterialShapeDrawable materialShapeDrawable, View view, ValueAnimator valueAnimator) {
        materialShapeDrawable.setInterpolation(1.0f - valueAnimator.getAnimatedFraction());
        view.setBackground(materialShapeDrawable);
        view.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void lambda$getFadeOutChildrenAnimator$2(View view, ValueAnimator valueAnimator) {
        view.setAlpha(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addCollapseAnimationListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.collapseAnimationListeners.add(animatorListenerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addExpandAnimationListener(AnimatorListenerAdapter animatorListenerAdapter) {
        this.expandAnimationListeners.add(animatorListenerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void addOnLoadAnimationCallback(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback) {
        this.onLoadAnimationCallbacks.add(onLoadAnimationCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isCollapsing() {
        return this.collapsing;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isExpanding() {
        return this.expanding;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.onLoadAnimationFadeInEnabled;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$startExpandAnimation$0$com-google-android-material-search-SearchBarAnimationHelper, reason: not valid java name */
    public /* synthetic */ void m396x1b96b119(SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(getFadeOutChildrenAnimator(searchBar, view), getExpandAnimator(searchBar, view, appBarLayout));
        animatorSet.addListener(new AnonymousClass3());
        Iterator<AnimatorListenerAdapter> it = this.expandAnimationListeners.iterator();
        while (it.hasNext()) {
            animatorSet.addListener(it.next());
        }
        if (z) {
            animatorSet.setDuration(0L);
        }
        animatorSet.start();
        this.runningExpandOrCollapseAnimator = animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeCollapseAnimationListener(AnimatorListenerAdapter animatorListenerAdapter) {
        return this.collapseAnimationListeners.remove(animatorListenerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeExpandAnimationListener(AnimatorListenerAdapter animatorListenerAdapter) {
        return this.expandAnimationListeners.remove(animatorListenerAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean removeOnLoadAnimationCallback(SearchBar.OnLoadAnimationCallback onLoadAnimationCallback) {
        return this.onLoadAnimationCallbacks.remove(onLoadAnimationCallback);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnLoadAnimationFadeInEnabled(boolean z) {
        this.onLoadAnimationFadeInEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startCollapseAnimation(SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z) {
        if (isExpanding() && this.runningExpandOrCollapseAnimator != null) {
            this.runningExpandOrCollapseAnimator.cancel();
        }
        this.collapsing = true;
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(getCollapseAnimator(searchBar, view, appBarLayout), getFadeInChildrenAnimator(searchBar));
        animatorSet.addListener(new AnonymousClass5());
        Iterator<AnimatorListenerAdapter> it = this.collapseAnimationListeners.iterator();
        while (it.hasNext()) {
            animatorSet.addListener(it.next());
        }
        if (z) {
            animatorSet.setDuration(0L);
        }
        animatorSet.start();
        this.runningExpandOrCollapseAnimator = animatorSet;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void startExpandAnimation(SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z) {
        if (isCollapsing() && this.runningExpandOrCollapseAnimator != null) {
            this.runningExpandOrCollapseAnimator.cancel();
        }
        this.expanding = true;
        view.setVisibility(4);
        view.post(new SearchBarAnimationHelper$$ExternalSyntheticLambda3(this, searchBar, view, appBarLayout, z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void startOnLoadAnimation(SearchBar searchBar) {
        dispatchOnLoadAnimation(new SearchBarAnimationHelper$$ExternalSyntheticLambda1());
        TextView textView = searchBar.getTextView();
        View centerView = searchBar.getCenterView();
        View secondaryActionMenuItemView = ToolbarUtils.getSecondaryActionMenuItemView(searchBar);
        Animator secondaryViewAnimator = getSecondaryViewAnimator(textView, secondaryActionMenuItemView);
        secondaryViewAnimator.addListener(new AnonymousClass1());
        this.secondaryViewAnimator = secondaryViewAnimator;
        textView.setAlpha(0.0f);
        if (secondaryActionMenuItemView != null) {
            secondaryActionMenuItemView.setAlpha(0.0f);
        }
        if (centerView instanceof AnimatableView) {
            Objects.requireNonNull(secondaryViewAnimator);
            ((AnimatableView) centerView).startAnimation(new SearchBarAnimationHelper$$ExternalSyntheticLambda2(secondaryViewAnimator));
        } else {
            if (centerView == 0) {
                secondaryViewAnimator.start();
                return;
            }
            centerView.setAlpha(0.0f);
            centerView.setVisibility(0);
            Animator defaultCenterViewAnimator = getDefaultCenterViewAnimator(centerView);
            this.defaultCenterViewAnimator = defaultCenterViewAnimator;
            defaultCenterViewAnimator.addListener(new AnonymousClass2(centerView, secondaryViewAnimator));
            defaultCenterViewAnimator.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public void stopOnLoadAnimation(SearchBar searchBar) {
        if (this.secondaryViewAnimator != null) {
            this.secondaryViewAnimator.end();
        }
        if (this.defaultCenterViewAnimator != null) {
            this.defaultCenterViewAnimator.end();
        }
        View centerView = searchBar.getCenterView();
        if (centerView instanceof AnimatableView) {
            ((AnimatableView) centerView).stopAnimation();
        }
        if (centerView != 0) {
            centerView.setAlpha(0.0f);
        }
    }
}
