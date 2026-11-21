package kotlinx.serialization.internal;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/internal/MapEntrySerializer;", method = "descriptor$lambda$0", proto = "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class MapEntrySerializer$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ KSerializer f$0;
    public final /* synthetic */ KSerializer f$1;

    public /* synthetic */ MapEntrySerializer$$ExternalSyntheticLambda0(KSerializer kSerializer, KSerializer kSerializer2) {
        this.f$0 = kSerializer;
        this.f$1 = kSerializer2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return MapEntrySerializer.descriptor$lambda$0(this.f$0, this.f$1, (ClassSerialDescriptorBuilder) obj);
    }
}
