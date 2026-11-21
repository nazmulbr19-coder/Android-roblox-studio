package kotlin.streams.jdk8;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.function.Supplier;
import kotlin.sequences.Sequence;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/streams/jdk8/StreamsKt;", method = "asStream$lambda$4", proto = "(Lkotlin/sequences/Sequence;)Ljava/util/Spliterator;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class StreamsKt$$ExternalSyntheticLambda0 implements Supplier {
    public final /* synthetic */ Sequence f$0;

    public /* synthetic */ StreamsKt$$ExternalSyntheticLambda0(Sequence sequence) {
        this.f$0 = sequence;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        return StreamsKt.asStream$lambda$4(this.f$0);
    }
}
