package kotlinx.serialization;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.functions.Function2;
import kotlin.reflect.KClass;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/SerializersCacheKt;", method = "PARAMETRIZED_SERIALIZERS_CACHE$lambda$3", proto = "(Lkotlin/reflect/KClass;Ljava/util/List;)Lkotlinx/serialization/KSerializer;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class SerializersCacheKt$$ExternalSyntheticLambda2 implements Function2 {
    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE$lambda$3((KClass) obj, (List) obj2);
    }
}
