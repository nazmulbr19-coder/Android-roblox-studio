package com.google.android.material.slider;

import android.animation.ValueAnimator;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/slider/BaseSlider;", method = "lambda$createLabelAnimator$1", proto = "(Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class BaseSlider$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BaseSlider f$0;

    public /* synthetic */ BaseSlider$$ExternalSyntheticLambda0(BaseSlider baseSlider) {
        this.f$0 = baseSlider;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m422x2eeddb89(valueAnimator);
    }
}
