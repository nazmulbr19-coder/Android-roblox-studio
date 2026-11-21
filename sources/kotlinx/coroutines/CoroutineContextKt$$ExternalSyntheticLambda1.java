package kotlinx.coroutines;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/coroutines/CoroutineContextKt;", method = "foldCopies$lambda$1", proto = "(Lkotlin/jvm/internal/Ref$ObjectRef;ZLkotlin/coroutines/CoroutineContext;Lkotlin/coroutines/CoroutineContext$Element;)Lkotlin/coroutines/CoroutineContext;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class CoroutineContextKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ CoroutineContextKt$$ExternalSyntheticLambda1(Ref.ObjectRef objectRef, boolean z) {
        this.f$0 = objectRef;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return CoroutineContextKt.foldCopies$lambda$1(this.f$0, this.f$1, (CoroutineContext) obj, (CoroutineContext.Element) obj2);
    }
}
