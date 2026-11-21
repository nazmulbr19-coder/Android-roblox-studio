package kotlin.sequences;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.Collection;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/sequences/SequencesKt___SequencesKt$minus$3;", method = "iterator$lambda$0", proto = "(Ljava/util/Collection;Ljava/lang/Object;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SequencesKt___SequencesKt$minus$3$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ Collection f$0;

    public /* synthetic */ SequencesKt___SequencesKt$minus$3$$ExternalSyntheticLambda0(Collection collection) {
        this.f$0 = collection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(SequencesKt___SequencesKt$minus$3.iterator$lambda$0(this.f$0, obj));
    }
}
