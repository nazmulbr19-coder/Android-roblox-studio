package com.google.android.material.motion;

import android.animation.ValueAnimator;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.internal.ClippableRoundedCornerLayout;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/motion/MaterialMainContainerBackHelper;", method = "lambda$createCornerAnimator$1", proto = "(Lcom/google/android/material/internal/ClippableRoundedCornerLayout;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class MaterialMainContainerBackHelper$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ClippableRoundedCornerLayout f$0;

    public /* synthetic */ MaterialMainContainerBackHelper$$ExternalSyntheticLambda1(ClippableRoundedCornerLayout clippableRoundedCornerLayout) {
        this.f$0 = clippableRoundedCornerLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        MaterialMainContainerBackHelper.lambda$createCornerAnimator$1(this.f$0, valueAnimator);
    }
}
