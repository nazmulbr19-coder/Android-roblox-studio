package androidx.constraintlayout.core.state;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/constraintlayout/core/state/Transition;", method = "lambda$getInterpolator$0", proto = "(Ljava/lang/String;F)F")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Transition$$ExternalSyntheticLambda0 implements Interpolator {
    public final /* synthetic */ String f$0;

    public /* synthetic */ Transition$$ExternalSyntheticLambda0(String str) {
        this.f$0 = str;
    }

    @Override // androidx.constraintlayout.core.state.Interpolator
    public final float getInterpolation(float f) {
        return Transition.lambda$getInterpolator$0(this.f$0, f);
    }
}
