package kotlinx.coroutines.sync;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/sync/MutexImpl;", method = "onSelectCancellationUnlockConstructor$lambda$1$lambda$0", proto = "(Lkotlinx/coroutines/sync/MutexImpl;Ljava/lang/Object;Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class MutexImpl$$ExternalSyntheticLambda1 implements Function3 {
    public final /* synthetic */ MutexImpl f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ MutexImpl$$ExternalSyntheticLambda1(MutexImpl mutexImpl, Object obj) {
        this.f$0 = mutexImpl;
        this.f$1 = obj;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return MutexImpl.onSelectCancellationUnlockConstructor$lambda$1$lambda$0(this.f$0, this.f$1, (Throwable) obj, obj2, (CoroutineContext) obj3);
    }
}
