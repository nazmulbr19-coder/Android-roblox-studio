package kotlinx.serialization.internal;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/internal/EnumDescriptor;", method = "elementDescriptors_delegate$lambda$0", proto = "(ILjava/lang/String;Lkotlinx/serialization/internal/EnumDescriptor;)[Lkotlinx/serialization/descriptors/SerialDescriptor;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class EnumDescriptor$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ EnumDescriptor f$2;

    public /* synthetic */ EnumDescriptor$$ExternalSyntheticLambda0(int i, String str, EnumDescriptor enumDescriptor) {
        this.f$0 = i;
        this.f$1 = str;
        this.f$2 = enumDescriptor;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return EnumDescriptor.elementDescriptors_delegate$lambda$0(this.f$0, this.f$1, this.f$2);
    }
}
