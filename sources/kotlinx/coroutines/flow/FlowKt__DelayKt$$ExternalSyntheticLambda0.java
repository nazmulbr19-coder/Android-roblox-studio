package kotlinx.coroutines.flow;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/flow/FlowKt__DelayKt;", method = "debounce$lambda$2$FlowKt__DelayKt", proto = "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)J")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class FlowKt__DelayKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ FlowKt__DelayKt$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Long.valueOf(FlowKt__DelayKt.$r8$lambda$lHgEoaIjdv0Q0nae16lyucRVvig(this.f$0, obj));
    }
}
