package kotlinx.serialization.descriptors;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", method = "_hashCode_delegate$lambda$1", proto = "(Lkotlinx/serialization/descriptors/SerialDescriptorImpl;)I")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class SerialDescriptorImpl$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ SerialDescriptorImpl f$0;

    public /* synthetic */ SerialDescriptorImpl$$ExternalSyntheticLambda0(SerialDescriptorImpl serialDescriptorImpl) {
        this.f$0 = serialDescriptorImpl;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Integer.valueOf(SerialDescriptorImpl._hashCode_delegate$lambda$1(this.f$0));
    }
}
