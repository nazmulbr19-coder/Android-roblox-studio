package kotlinx.serialization;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/SealedClassSerializer;", method = "descriptor_delegate$lambda$3$lambda$2$lambda$1", proto = "(Lkotlinx/serialization/SealedClassSerializer;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class SealedClassSerializer$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ SealedClassSerializer f$0;

    public /* synthetic */ SealedClassSerializer$$ExternalSyntheticLambda2(SealedClassSerializer sealedClassSerializer) {
        this.f$0 = sealedClassSerializer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return SealedClassSerializer.descriptor_delegate$lambda$3$lambda$2$lambda$1(this.f$0, (ClassSerialDescriptorBuilder) obj);
    }
}
