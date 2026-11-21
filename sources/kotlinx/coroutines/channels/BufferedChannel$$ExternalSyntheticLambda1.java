package kotlinx.coroutines.channels;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/channels/BufferedChannel;", method = "onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55", proto = "(Ljava/lang/Object;Lkotlinx/coroutines/channels/BufferedChannel;Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class BufferedChannel$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ Object f$0;
    public final /* synthetic */ BufferedChannel f$1;
    public final /* synthetic */ SelectInstance f$2;

    public /* synthetic */ BufferedChannel$$ExternalSyntheticLambda1(Object obj, BufferedChannel bufferedChannel, SelectInstance selectInstance) {
        this.f$0 = obj;
        this.f$1 = bufferedChannel;
        this.f$2 = selectInstance;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return BufferedChannel.onUndeliveredElementReceiveCancellationConstructor$lambda$57$lambda$56$lambda$55(this.f$0, this.f$1, this.f$2, (Throwable) obj, obj2, (CoroutineContext) obj3);
    }
}
