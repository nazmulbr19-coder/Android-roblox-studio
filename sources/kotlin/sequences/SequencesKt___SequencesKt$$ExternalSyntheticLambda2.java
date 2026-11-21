package kotlin.sequences;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.collections.IndexedValue;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/sequences/SequencesKt___SequencesKt;", method = "filterIndexed$lambda$2$SequencesKt___SequencesKt", proto = "(Lkotlin/jvm/functions/Function2;Lkotlin/collections/IndexedValue;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SequencesKt___SequencesKt$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ SequencesKt___SequencesKt$$ExternalSyntheticLambda2(Function2 function2) {
        this.f$0 = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(SequencesKt___SequencesKt.$r8$lambda$D85A6w3UV_XZiKdx65CzOrGg_GM(this.f$0, (IndexedValue) obj));
    }
}
