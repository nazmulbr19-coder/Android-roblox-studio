package kotlinx.coroutines.android;

import android.view.Choreographer;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/android/HandlerDispatcherKt;", method = "postFrameCallback$lambda$6", proto = "(Lkotlinx/coroutines/CancellableContinuation;J)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class HandlerDispatcherKt$$ExternalSyntheticLambda0 implements Choreographer.FrameCallback {
    public final /* synthetic */ CancellableContinuation f$0;

    public /* synthetic */ HandlerDispatcherKt$$ExternalSyntheticLambda0(CancellableContinuation cancellableContinuation) {
        this.f$0 = cancellableContinuation;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        HandlerDispatcherKt.postFrameCallback$lambda$6(this.f$0, j);
    }
}
