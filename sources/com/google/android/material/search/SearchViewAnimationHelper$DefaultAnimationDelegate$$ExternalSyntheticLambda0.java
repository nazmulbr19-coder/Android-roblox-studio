package com.google.android.material.search;

import android.animation.ValueAnimator;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.search.SearchViewAnimationHelper;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/search/SearchViewAnimationHelper$DefaultAnimationDelegate;", method = "lambda$addTextFadeAnimatorIfNeeded$2", proto = "(Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SearchViewAnimationHelper$DefaultAnimationDelegate$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SearchViewAnimationHelper.DefaultAnimationDelegate f$0;

    public /* synthetic */ SearchViewAnimationHelper$DefaultAnimationDelegate$$ExternalSyntheticLambda0(SearchViewAnimationHelper.DefaultAnimationDelegate defaultAnimationDelegate) {
        this.f$0 = defaultAnimationDelegate;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m414x8539623c(valueAnimator);
    }
}
