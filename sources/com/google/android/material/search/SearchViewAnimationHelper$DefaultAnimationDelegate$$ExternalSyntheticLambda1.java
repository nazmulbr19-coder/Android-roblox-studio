package com.google.android.material.search;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.search.SearchViewAnimationHelper;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/search/SearchViewAnimationHelper$DefaultAnimationDelegate;", method = "lambda$getRootViewAnimator$0", proto = "(F[FLandroid/graphics/Rect;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SearchViewAnimationHelper$DefaultAnimationDelegate$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SearchViewAnimationHelper.DefaultAnimationDelegate f$0;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ float[] f$2;
    public final /* synthetic */ Rect f$3;

    public /* synthetic */ SearchViewAnimationHelper$DefaultAnimationDelegate$$ExternalSyntheticLambda1(SearchViewAnimationHelper.DefaultAnimationDelegate defaultAnimationDelegate, float f, float[] fArr, Rect rect) {
        this.f$0 = defaultAnimationDelegate;
        this.f$1 = f;
        this.f$2 = fArr;
        this.f$3 = rect;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m415x8b5d297b(this.f$1, this.f$2, this.f$3, valueAnimator);
    }
}
