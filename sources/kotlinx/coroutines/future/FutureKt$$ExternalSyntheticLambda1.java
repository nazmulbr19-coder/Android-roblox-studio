package kotlinx.coroutines.future;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CompletableDeferred;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/future/FutureKt;", method = "asDeferred$lambda$5", proto = "(Lkotlinx/coroutines/CompletableDeferred;Ljava/lang/Object;Ljava/lang/Throwable;)Ljava/lang/Object;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class FutureKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ CompletableDeferred f$0;

    public /* synthetic */ FutureKt$$ExternalSyntheticLambda1(CompletableDeferred completableDeferred) {
        this.f$0 = completableDeferred;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return FutureKt.asDeferred$lambda$5(this.f$0, obj, (Throwable) obj2);
    }
}
