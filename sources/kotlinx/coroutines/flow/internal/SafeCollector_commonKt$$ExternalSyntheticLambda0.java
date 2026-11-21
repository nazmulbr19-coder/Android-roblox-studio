package kotlinx.coroutines.flow.internal;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/flow/internal/SafeCollector_commonKt;", method = "checkContext$lambda$0", proto = "(Lkotlinx/coroutines/flow/internal/SafeCollector;ILkotlin/coroutines/CoroutineContext$Element;)I")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class SafeCollector_commonKt$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ SafeCollector f$0;

    public /* synthetic */ SafeCollector_commonKt$$ExternalSyntheticLambda0(SafeCollector safeCollector) {
        this.f$0 = safeCollector;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return Integer.valueOf(SafeCollector_commonKt.checkContext$lambda$0(this.f$0, ((Integer) obj).intValue(), (CoroutineContext.Element) obj2));
    }
}
