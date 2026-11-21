package com.google.android.material.sidesheet;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/sidesheet/SideSheetBehavior;", method = "lambda$getCoplanarFinishAnimatorUpdateListener$1", proto = "(Landroid/view/ViewGroup$MarginLayoutParams;ILandroid/view/View;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SideSheetBehavior$$ExternalSyntheticLambda2 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ SideSheetBehavior f$0;
    public final /* synthetic */ ViewGroup.MarginLayoutParams f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ View f$3;

    public /* synthetic */ SideSheetBehavior$$ExternalSyntheticLambda2(SideSheetBehavior sideSheetBehavior, ViewGroup.MarginLayoutParams marginLayoutParams, int i, View view) {
        this.f$0 = sideSheetBehavior;
        this.f$1 = marginLayoutParams;
        this.f$2 = i;
        this.f$3 = view;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m418xc3af8fb4(this.f$1, this.f$2, this.f$3, valueAnimator);
    }
}
