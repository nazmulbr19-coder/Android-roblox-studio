package kotlinx.serialization.descriptors;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/descriptors/SerialDescriptorImpl;", method = "toString$lambda$3", proto = "(Lkotlinx/serialization/descriptors/SerialDescriptorImpl;I)Ljava/lang/CharSequence;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class SerialDescriptorImpl$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ SerialDescriptorImpl f$0;

    public /* synthetic */ SerialDescriptorImpl$$ExternalSyntheticLambda1(SerialDescriptorImpl serialDescriptorImpl) {
        this.f$0 = serialDescriptorImpl;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return SerialDescriptorImpl.toString$lambda$3(this.f$0, ((Integer) obj).intValue());
    }
}
