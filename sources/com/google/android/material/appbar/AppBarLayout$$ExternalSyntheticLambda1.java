package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/appbar/AppBarLayout;", method = "lambda$initializeLiftOnScrollWithElevation$1", proto = "(Lcom/google/android/material/shape/MaterialShapeDrawable;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AppBarLayout$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AppBarLayout f$0;
    public final /* synthetic */ MaterialShapeDrawable f$1;

    public /* synthetic */ AppBarLayout$$ExternalSyntheticLambda1(AppBarLayout appBarLayout, MaterialShapeDrawable materialShapeDrawable) {
        this.f$0 = appBarLayout;
        this.f$1 = materialShapeDrawable;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m318x84b6053(this.f$1, valueAnimator);
    }
}
