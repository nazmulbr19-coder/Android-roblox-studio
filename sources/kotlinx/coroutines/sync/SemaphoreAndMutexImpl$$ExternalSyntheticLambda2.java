package kotlinx.coroutines.sync;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function3;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", method = "onCancellationRelease$lambda$2", proto = "(Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;Ljava/lang/Throwable;Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class SemaphoreAndMutexImpl$$ExternalSyntheticLambda2 implements Function3 {
    public final /* synthetic */ SemaphoreAndMutexImpl f$0;

    public /* synthetic */ SemaphoreAndMutexImpl$$ExternalSyntheticLambda2(SemaphoreAndMutexImpl semaphoreAndMutexImpl) {
        this.f$0 = semaphoreAndMutexImpl;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return SemaphoreAndMutexImpl.onCancellationRelease$lambda$2(this.f$0, (Throwable) obj, (Unit) obj2, (CoroutineContext) obj3);
    }
}
