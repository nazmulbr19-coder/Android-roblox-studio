package com.google.android.material.floatingactionbutton;

import android.animation.ValueAnimator;
import android.graphics.Matrix;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/floatingactionbutton/FloatingActionButtonImpl;", method = "lambda$createDefaultAnimator$0", proto = "(FFFFFFFLandroid/graphics/Matrix;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FloatingActionButtonImpl$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FloatingActionButtonImpl f$0;
    public final /* synthetic */ float f$1;
    public final /* synthetic */ float f$2;
    public final /* synthetic */ float f$3;
    public final /* synthetic */ float f$4;
    public final /* synthetic */ float f$5;
    public final /* synthetic */ float f$6;
    public final /* synthetic */ float f$7;
    public final /* synthetic */ Matrix f$8;

    public /* synthetic */ FloatingActionButtonImpl$$ExternalSyntheticLambda0(FloatingActionButtonImpl floatingActionButtonImpl, float f, float f2, float f3, float f4, float f5, float f6, float f7, Matrix matrix) {
        this.f$0 = floatingActionButtonImpl;
        this.f$1 = f;
        this.f$2 = f2;
        this.f$3 = f3;
        this.f$4 = f4;
        this.f$5 = f5;
        this.f$6 = f6;
        this.f$7 = f7;
        this.f$8 = matrix;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m385x7a82a444(this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8, valueAnimator);
    }
}
