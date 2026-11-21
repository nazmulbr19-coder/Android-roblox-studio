package androidx.dynamicanimation.animation;

import android.view.Choreographer;
import androidx.dynamicanimation.animation.AnimationHandler;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/dynamicanimation/animation/AnimationHandler$FrameCallbackScheduler16;", method = "lambda$postFrameCallback$0", proto = "(Ljava/lang/Runnable;J)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AnimationHandler$FrameCallbackScheduler16$$ExternalSyntheticLambda0 implements Choreographer.FrameCallback {
    public final /* synthetic */ Runnable f$0;

    public /* synthetic */ AnimationHandler$FrameCallbackScheduler16$$ExternalSyntheticLambda0(Runnable runnable) {
        this.f$0 = runnable;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        AnimationHandler.FrameCallbackScheduler16.lambda$postFrameCallback$0(this.f$0, j);
    }
}
