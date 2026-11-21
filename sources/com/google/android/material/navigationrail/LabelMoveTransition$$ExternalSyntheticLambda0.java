package com.google.android.material.navigationrail;

import android.animation.ValueAnimator;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/navigationrail/LabelMoveTransition;", method = "lambda$createAnimator$0", proto = "(Landroid/view/View;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class LabelMoveTransition$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ View f$0;

    public /* synthetic */ LabelMoveTransition$$ExternalSyntheticLambda0(View view) {
        this.f$0 = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        LabelMoveTransition.lambda$createAnimator$0(this.f$0, valueAnimator);
    }
}
