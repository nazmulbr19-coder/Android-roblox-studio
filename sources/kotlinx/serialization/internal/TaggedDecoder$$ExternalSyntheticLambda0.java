package kotlinx.serialization.internal;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;
import kotlinx.serialization.DeserializationStrategy;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlinx/serialization/internal/TaggedDecoder;", method = "decodeSerializableElement$lambda$1", proto = "(Lkotlinx/serialization/internal/TaggedDecoder;Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes10.dex */
public final /* synthetic */ class TaggedDecoder$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ TaggedDecoder f$0;
    public final /* synthetic */ DeserializationStrategy f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ TaggedDecoder$$ExternalSyntheticLambda0(TaggedDecoder taggedDecoder, DeserializationStrategy deserializationStrategy, Object obj) {
        this.f$0 = taggedDecoder;
        this.f$1 = deserializationStrategy;
        this.f$2 = obj;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return TaggedDecoder.decodeSerializableElement$lambda$1(this.f$0, this.f$1, this.f$2);
    }
}
