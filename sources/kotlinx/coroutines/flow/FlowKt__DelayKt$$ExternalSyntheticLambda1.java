package kotlinx.coroutines.flow;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/flow/FlowKt__DelayKt;", method = "debounce$lambda$1$FlowKt__DelayKt", proto = "(JLjava/lang/Object;)J")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class FlowKt__DelayKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ long f$0;

    public /* synthetic */ FlowKt__DelayKt$$ExternalSyntheticLambda1(long j) {
        this.f$0 = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Long.valueOf(FlowKt__DelayKt.m1985$r8$lambda$dHPYgGi525O8NWs4DzjenbjXIg(this.f$0, obj));
    }
}
