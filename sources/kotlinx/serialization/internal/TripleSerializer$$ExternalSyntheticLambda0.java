package kotlinx.serialization.internal;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/internal/TripleSerializer;", method = "descriptor$lambda$0", proto = "(Lkotlinx/serialization/internal/TripleSerializer;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class TripleSerializer$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ TripleSerializer f$0;

    public /* synthetic */ TripleSerializer$$ExternalSyntheticLambda0(TripleSerializer tripleSerializer) {
        this.f$0 = tripleSerializer;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return TripleSerializer.descriptor$lambda$0(this.f$0, (ClassSerialDescriptorBuilder) obj);
    }
}
