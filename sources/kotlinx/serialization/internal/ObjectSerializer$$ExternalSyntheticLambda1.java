package kotlinx.serialization.internal;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/internal/ObjectSerializer;", method = "descriptor_delegate$lambda$1$lambda$0", proto = "(Lkotlinx/serialization/internal/ObjectSerializer;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class ObjectSerializer$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ ObjectSerializer f$0;

    public /* synthetic */ ObjectSerializer$$ExternalSyntheticLambda1(ObjectSerializer objectSerializer) {
        this.f$0 = objectSerializer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ObjectSerializer.descriptor_delegate$lambda$1$lambda$0(this.f$0, (ClassSerialDescriptorBuilder) obj);
    }
}
