package androidx.core.os;

import android.os.ProfilingManager;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.function.Consumer;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/os/Profiling$registerForAllProfilingResults$1;", method = "invokeSuspend$lambda$2", proto = "(Landroid/os/ProfilingManager;Ljava/util/function/Consumer;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Profiling$registerForAllProfilingResults$1$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ ProfilingManager f$0;
    public final /* synthetic */ Consumer f$1;

    public /* synthetic */ Profiling$registerForAllProfilingResults$1$$ExternalSyntheticLambda2(ProfilingManager profilingManager, Consumer consumer) {
        this.f$0 = profilingManager;
        this.f$1 = consumer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Profiling$registerForAllProfilingResults$1.invokeSuspend$lambda$2(this.f$0, this.f$1);
    }
}
