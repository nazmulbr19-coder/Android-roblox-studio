package com.google.android.material.navigation;

import android.animation.ValueAnimator;
import androidx.drawerlayout.widget.DrawerLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/navigation/DrawerLayoutUtils;", method = "lambda$getScrimCloseAnimatorUpdateListener$0", proto = "(Landroidx/drawerlayout/widget/DrawerLayout;Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class DrawerLayoutUtils$$ExternalSyntheticLambda0 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DrawerLayout f$0;

    public /* synthetic */ DrawerLayoutUtils$$ExternalSyntheticLambda0(DrawerLayout drawerLayout) {
        this.f$0 = drawerLayout;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        DrawerLayoutUtils.lambda$getScrimCloseAnimatorUpdateListener$0(this.f$0, valueAnimator);
    }
}
