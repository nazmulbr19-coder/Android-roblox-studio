package kotlinx.serialization.internal;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/internal/ObjectSerializer;", method = "descriptor_delegate$lambda$1", proto = "(Ljava/lang/String;Lkotlinx/serialization/internal/ObjectSerializer;)Lkotlinx/serialization/descriptors/SerialDescriptor;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class ObjectSerializer$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ ObjectSerializer f$1;

    public /* synthetic */ ObjectSerializer$$ExternalSyntheticLambda0(String str, ObjectSerializer objectSerializer) {
        this.f$0 = str;
        this.f$1 = objectSerializer;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return ObjectSerializer.descriptor_delegate$lambda$1(this.f$0, this.f$1);
    }
}
