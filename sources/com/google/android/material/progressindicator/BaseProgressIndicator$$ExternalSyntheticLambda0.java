package com.google.android.material.progressindicator;

import androidx.dynamicanimation.animation.DynamicAnimation;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/progressindicator/BaseProgressIndicator;", method = "lambda$new$0", proto = "(Landroidx/dynamicanimation/animation/DynamicAnimation;ZFF)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class BaseProgressIndicator$$ExternalSyntheticLambda0 implements DynamicAnimation.OnAnimationEndListener {
    public final /* synthetic */ BaseProgressIndicator f$0;

    public /* synthetic */ BaseProgressIndicator$$ExternalSyntheticLambda0(BaseProgressIndicator baseProgressIndicator) {
        this.f$0 = baseProgressIndicator;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        this.f$0.m392x4b14d911(dynamicAnimation, z, f, f2);
    }
}
