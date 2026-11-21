package com.google.android.material.search;

import android.animation.ValueAnimator;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.search.SearchViewAnimationHelper;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/search/SearchViewAnimationHelper$ContainedAnimationDelegate;", method = "lambda$getToolbarAlphaAnimator$1", proto = "(Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SearchViewAnimationHelper.ContainedAnimationDelegate f$0;

    public /* synthetic */ SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda1(SearchViewAnimationHelper.ContainedAnimationDelegate containedAnimationDelegate) {
        this.f$0 = containedAnimationDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m411x2edc5246(valueAnimator);
    }
}
