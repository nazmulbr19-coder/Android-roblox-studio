package kotlinx.serialization;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/SealedClassSerializer;", method = "descriptor_delegate$lambda$3", proto = "(Ljava/lang/String;Lkotlinx/serialization/SealedClassSerializer;)Lkotlinx/serialization/descriptors/SerialDescriptor;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class SealedClassSerializer$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ SealedClassSerializer f$1;

    public /* synthetic */ SealedClassSerializer$$ExternalSyntheticLambda0(String str, SealedClassSerializer sealedClassSerializer) {
        this.f$0 = str;
        this.f$1 = sealedClassSerializer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return SealedClassSerializer.descriptor_delegate$lambda$3(this.f$0, this.f$1);
    }
}
