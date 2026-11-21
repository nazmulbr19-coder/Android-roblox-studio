package kotlinx.serialization.modules;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.modules.SerializersModuleCollector;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/modules/SerializersModuleCollector$DefaultImpls;", method = "contextual$lambda$0", proto = "(Lkotlinx/serialization/KSerializer;Ljava/util/List;)Lkotlinx/serialization/KSerializer;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class SerializersModuleCollector$DefaultImpls$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ KSerializer f$0;

    public /* synthetic */ SerializersModuleCollector$DefaultImpls$$ExternalSyntheticLambda0(KSerializer kSerializer) {
        this.f$0 = kSerializer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return SerializersModuleCollector.DefaultImpls.contextual$lambda$0(this.f$0, (List) obj);
    }
}
