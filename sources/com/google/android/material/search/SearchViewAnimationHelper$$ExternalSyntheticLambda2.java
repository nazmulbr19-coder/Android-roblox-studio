package com.google.android.material.search;

import android.animation.ValueAnimator;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.internal.FadeThroughDrawable;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/search/SearchViewAnimationHelper;", method = "lambda$addFadeThroughDrawableAnimatorIfNeeded$4", proto = "(Lcom/google/android/material/internal/FadeThroughDrawable;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SearchViewAnimationHelper$$ExternalSyntheticLambda2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FadeThroughDrawable f$0;

    public /* synthetic */ SearchViewAnimationHelper$$ExternalSyntheticLambda2(FadeThroughDrawable fadeThroughDrawable) {
        this.f$0 = fadeThroughDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        SearchViewAnimationHelper.lambda$addFadeThroughDrawableAnimatorIfNeeded$4(this.f$0, valueAnimator);
    }
}
