package kotlinx.coroutines.channels;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/channels/BufferedChannel;", method = "bindCancellationFun$lambda$89", proto = "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class BufferedChannel$$ExternalSyntheticLambda3 implements Function3 {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ BufferedChannel$$ExternalSyntheticLambda3(Function1 function1, Object obj) {
        this.f$0 = function1;
        this.f$1 = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return BufferedChannel.bindCancellationFun$lambda$89(this.f$0, this.f$1, (Throwable) obj, obj2, (CoroutineContext) obj3);
    }
}
