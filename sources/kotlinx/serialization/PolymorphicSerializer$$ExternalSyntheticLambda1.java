package kotlinx.serialization;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/PolymorphicSerializer;", method = "descriptor_delegate$lambda$1", proto = "(Lkotlinx/serialization/PolymorphicSerializer;)Lkotlinx/serialization/descriptors/SerialDescriptor;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class PolymorphicSerializer$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ PolymorphicSerializer f$0;

    public /* synthetic */ PolymorphicSerializer$$ExternalSyntheticLambda1(PolymorphicSerializer polymorphicSerializer) {
        this.f$0 = polymorphicSerializer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return PolymorphicSerializer.descriptor_delegate$lambda$1(this.f$0);
    }
}
