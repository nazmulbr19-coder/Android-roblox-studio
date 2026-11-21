package androidx.transition;

import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.transition.Transition;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/transition/Transition$SeekController;", method = "lambda$ensureAnimation$0", proto = "(Landroidx/dynamicanimation/animation/DynamicAnimation;ZFF)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Transition$SeekController$$ExternalSyntheticLambda0 implements DynamicAnimation.OnAnimationEndListener {
    public final /* synthetic */ Transition.SeekController f$0;

    public /* synthetic */ Transition$SeekController$$ExternalSyntheticLambda0(Transition.SeekController seekController) {
        this.f$0 = seekController;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        this.f$0.m310x76b2d240(dynamicAnimation, z, f, f2);
    }
}
