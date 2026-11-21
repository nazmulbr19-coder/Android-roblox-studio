package kotlin.coroutines;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/coroutines/CombinedContext;", method = "writeReplace$lambda$3", proto = "([Lkotlin/coroutines/CoroutineContext;Lkotlin/jvm/internal/Ref$IntRef;Lkotlin/Unit;Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class CombinedContext$$ExternalSyntheticLambda0 implements Function2 {
    public final /* synthetic */ CoroutineContext[] f$0;
    public final /* synthetic */ Ref.IntRef f$1;

    public /* synthetic */ CombinedContext$$ExternalSyntheticLambda0(CoroutineContext[] coroutineContextArr, Ref.IntRef intRef) {
        this.f$0 = coroutineContextArr;
        this.f$1 = intRef;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return CombinedContext.writeReplace$lambda$3(this.f$0, this.f$1, (Unit) obj, (CoroutineContext.Element) obj2);
    }
}
