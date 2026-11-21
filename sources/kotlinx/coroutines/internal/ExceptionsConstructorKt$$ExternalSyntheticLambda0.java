package kotlinx.coroutines.internal;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/internal/ExceptionsConstructorKt;", method = "safeCtor$lambda$9", proto = "(Lkotlin/jvm/functions/Function1;Ljava/lang/Throwable;)Ljava/lang/Throwable;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class ExceptionsConstructorKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ ExceptionsConstructorKt$$ExternalSyntheticLambda0(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ExceptionsConstructorKt.safeCtor$lambda$9(this.f$0, (Throwable) obj);
    }
}
