package kotlinx.coroutines.future;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.concurrent.CompletableFuture;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.Deferred;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/future/FutureKt;", method = "asCompletableFuture$lambda$1", proto = "(Ljava/util/concurrent/CompletableFuture;Lkotlinx/coroutines/Deferred;Ljava/lang/Throwable;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class FutureKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ CompletableFuture f$0;
    public final /* synthetic */ Deferred f$1;

    public /* synthetic */ FutureKt$$ExternalSyntheticLambda0(CompletableFuture completableFuture, Deferred deferred) {
        this.f$0 = completableFuture;
        this.f$1 = deferred;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return FutureKt.asCompletableFuture$lambda$1(this.f$0, this.f$1, (Throwable) obj);
    }
}
