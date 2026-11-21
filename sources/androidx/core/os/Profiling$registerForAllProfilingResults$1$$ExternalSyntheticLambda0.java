package androidx.core.os;

import android.os.ProfilingResult;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.function.Consumer;
import kotlinx.coroutines.channels.ProducerScope;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/os/Profiling$registerForAllProfilingResults$1;", method = "invokeSuspend$lambda$0", proto = "(Lkotlinx/coroutines/channels/ProducerScope;Landroid/os/ProfilingResult;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Profiling$registerForAllProfilingResults$1$$ExternalSyntheticLambda0 implements Consumer {
    public final /* synthetic */ ProducerScope f$0;

    public /* synthetic */ Profiling$registerForAllProfilingResults$1$$ExternalSyntheticLambda0(ProducerScope producerScope) {
        this.f$0 = producerScope;
    }

    @Override // java.util.function.Consumer
    public final void accept(Object obj) {
        Profiling$registerForAllProfilingResults$1.invokeSuspend$lambda$0(this.f$0, (ProfilingResult) obj);
    }
}
