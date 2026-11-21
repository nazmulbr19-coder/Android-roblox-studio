package kotlinx.serialization.internal;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/internal/EnumSerializer;", method = "descriptor_delegate$lambda$0", proto = "(Lkotlinx/serialization/internal/EnumSerializer;Ljava/lang/String;)Lkotlinx/serialization/descriptors/SerialDescriptor;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class EnumSerializer$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ EnumSerializer f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ EnumSerializer$$ExternalSyntheticLambda0(EnumSerializer enumSerializer, String str) {
        this.f$0 = enumSerializer;
        this.f$1 = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return EnumSerializer.descriptor_delegate$lambda$0(this.f$0, this.f$1);
    }
}
