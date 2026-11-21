package com.google.android.material.progressindicator;

import android.animation.ValueAnimator;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/progressindicator/DeterminateDrawable;", method = "lambda$new$0", proto = "(Lcom/google/android/material/progressindicator/BaseProgressIndicatorSpec;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class DeterminateDrawable$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DeterminateDrawable f$0;
    public final /* synthetic */ BaseProgressIndicatorSpec f$1;

    public /* synthetic */ DeterminateDrawable$$ExternalSyntheticLambda1(DeterminateDrawable determinateDrawable, BaseProgressIndicatorSpec baseProgressIndicatorSpec) {
        this.f$0 = determinateDrawable;
        this.f$1 = baseProgressIndicatorSpec;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m394x8c297d3e(this.f$1, valueAnimator);
    }
}
