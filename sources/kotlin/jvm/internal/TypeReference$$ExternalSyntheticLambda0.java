package kotlin.jvm.internal;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KTypeProjection;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/jvm/internal/TypeReference;", method = "asString$lambda$0", proto = "(Lkotlin/jvm/internal/TypeReference;Lkotlin/reflect/KTypeProjection;)Ljava/lang/CharSequence;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class TypeReference$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ TypeReference f$0;

    public /* synthetic */ TypeReference$$ExternalSyntheticLambda0(TypeReference typeReference) {
        this.f$0 = typeReference;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return TypeReference.asString$lambda$0(this.f$0, (KTypeProjection) obj);
    }
}
