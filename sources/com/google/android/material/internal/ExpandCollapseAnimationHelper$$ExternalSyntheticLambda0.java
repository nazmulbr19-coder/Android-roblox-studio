package com.google.android.material.internal;

import android.animation.ValueAnimator;
import android.graphics.Rect;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/internal/ExpandCollapseAnimationHelper;", method = "lambda$getExpandCollapseAnimator$0", proto = "(Landroid/graphics/Rect;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ExpandCollapseAnimationHelper$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ ExpandCollapseAnimationHelper f$0;
    public final /* synthetic */ Rect f$1;

    public /* synthetic */ ExpandCollapseAnimationHelper$$ExternalSyntheticLambda0(ExpandCollapseAnimationHelper expandCollapseAnimationHelper, Rect rect) {
        this.f$0 = expandCollapseAnimationHelper;
        this.f$1 = rect;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m386xeb41e2ac(this.f$1, valueAnimator);
    }
}
