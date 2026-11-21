package kotlinx.coroutines.debug;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import sun.misc.Signal;
import sun.misc.SignalHandler;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/debug/AgentPremain;", method = "installSignalHandler$lambda$1", proto = "(Lsun/misc/Signal;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class AgentPremain$$ExternalSyntheticLambda0 implements SignalHandler {
    public final void handle(Signal signal) {
        AgentPremain.installSignalHandler$lambda$1(signal);
    }
}
