package kotlinx.coroutines.sync;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.sync.MutexImpl;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;", method = "resume$lambda$6", proto = "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/sync/MutexImpl$CancellableContinuationWithOwner;Ljava/lang/Throwable;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class MutexImpl$CancellableContinuationWithOwner$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ MutexImpl f$0;
    public final /* synthetic */ MutexImpl.CancellableContinuationWithOwner f$1;

    public /* synthetic */ MutexImpl$CancellableContinuationWithOwner$$ExternalSyntheticLambda1(MutexImpl mutexImpl, MutexImpl.CancellableContinuationWithOwner cancellableContinuationWithOwner) {
        this.f$0 = mutexImpl;
        this.f$1 = cancellableContinuationWithOwner;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return MutexImpl.CancellableContinuationWithOwner.resume$lambda$6(this.f$0, this.f$1, (Throwable) obj);
    }
}
