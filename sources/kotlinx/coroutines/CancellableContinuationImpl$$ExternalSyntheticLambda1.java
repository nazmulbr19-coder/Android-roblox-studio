package kotlinx.coroutines;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/CancellableContinuationImpl;", method = "resume$lambda$13$lambda$12", proto = "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class CancellableContinuationImpl$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ CancellableContinuationImpl$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return CancellableContinuationImpl.resume$lambda$13$lambda$12(this.f$0, (Throwable) obj, obj2, (CoroutineContext) obj3);
    }
}
