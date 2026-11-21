package com.google.android.material.card;

import android.animation.ValueAnimator;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/card/MaterialCardViewHelper;", method = "lambda$animateCheckedIcon$0", proto = "(Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class MaterialCardViewHelper$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ MaterialCardViewHelper f$0;

    public /* synthetic */ MaterialCardViewHelper$$ExternalSyntheticLambda0(MaterialCardViewHelper materialCardViewHelper) {
        this.f$0 = materialCardViewHelper;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m331xa4d79c2b(valueAnimator);
    }
}
