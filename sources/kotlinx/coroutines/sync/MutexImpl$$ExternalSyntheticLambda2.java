package kotlinx.coroutines.sync;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/sync/MutexImpl;", method = "onSelectCancellationUnlockConstructor$lambda$1", proto = "(Lkotlinx/coroutines/sync/MutexImpl;Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/jvm/functions/Function3;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class MutexImpl$$ExternalSyntheticLambda2 implements Function3 {
    public final /* synthetic */ MutexImpl f$0;

    public /* synthetic */ MutexImpl$$ExternalSyntheticLambda2(MutexImpl mutexImpl) {
        this.f$0 = mutexImpl;
    }

    @Override // kotlin.jvm.functions.Function3
    public final Object invoke(Object obj, Object obj2, Object obj3) {
        return MutexImpl.onSelectCancellationUnlockConstructor$lambda$1(this.f$0, (SelectInstance) obj, obj2, obj3);
    }
}
