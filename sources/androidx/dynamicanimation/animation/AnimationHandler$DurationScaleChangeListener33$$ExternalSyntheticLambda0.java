package androidx.dynamicanimation.animation;

import android.animation.ValueAnimator$DurationScaleChangeListener;
import androidx.dynamicanimation.animation.AnimationHandler;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/dynamicanimation/animation/AnimationHandler$DurationScaleChangeListener33;", method = "lambda$register$0", proto = "(F)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AnimationHandler$DurationScaleChangeListener33$$ExternalSyntheticLambda0 implements ValueAnimator$DurationScaleChangeListener {
    public final /* synthetic */ AnimationHandler.DurationScaleChangeListener33 f$0;

    public /* synthetic */ AnimationHandler$DurationScaleChangeListener33$$ExternalSyntheticLambda0(AnimationHandler.DurationScaleChangeListener33 durationScaleChangeListener33) {
        this.f$0 = durationScaleChangeListener33;
    }

    public final void onChanged(float f) {
        this.f$0.m129xb804c881(f);
    }
}
