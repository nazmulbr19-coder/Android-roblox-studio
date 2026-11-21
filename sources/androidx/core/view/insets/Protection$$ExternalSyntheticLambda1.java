package androidx.core.view.insets;

import android.animation.ValueAnimator;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/view/insets/Protection;", method = "lambda$animateAlpha$0", proto = "(Landroid/animation/ValueAnimator;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Protection$$ExternalSyntheticLambda1 implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ Protection f$0;

    public /* synthetic */ Protection$$ExternalSyntheticLambda1(Protection protection) {
        this.f$0 = protection;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.f$0.m105lambda$animateAlpha$0$androidxcoreviewinsetsProtection(valueAnimator);
    }
}
