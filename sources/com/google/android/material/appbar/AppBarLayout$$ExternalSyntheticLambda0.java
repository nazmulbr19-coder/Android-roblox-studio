package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.shape.MaterialShapeDrawable;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/appbar/AppBarLayout;", method = "lambda$initializeLiftOnScrollWithColor$0", proto = "(Landroid/content/res/ColorStateList;Lcom/google/android/material/shape/MaterialShapeDrawable;Ljava/lang/Integer;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AppBarLayout$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AppBarLayout f$0;
    public final /* synthetic */ ColorStateList f$1;
    public final /* synthetic */ MaterialShapeDrawable f$2;
    public final /* synthetic */ Integer f$3;

    public /* synthetic */ AppBarLayout$$ExternalSyntheticLambda0(AppBarLayout appBarLayout, ColorStateList colorStateList, MaterialShapeDrawable materialShapeDrawable, Integer num) {
        this.f$0 = appBarLayout;
        this.f$1 = colorStateList;
        this.f$2 = materialShapeDrawable;
        this.f$3 = num;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m317x91f594d8(this.f$1, this.f$2, this.f$3, valueAnimator);
    }
}
