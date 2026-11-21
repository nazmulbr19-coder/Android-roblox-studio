package kotlin.sequences;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/sequences/SequencesKt___SequencesKt;", method = "onEachIndexed$lambda$15$SequencesKt___SequencesKt", proto = "(Lkotlin/jvm/functions/Function2;ILjava/lang/Object;)Ljava/lang/Object;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SequencesKt___SequencesKt$$ExternalSyntheticLambda8 implements Function2 {
    public final /* synthetic */ Function2 f$0;

    public /* synthetic */ SequencesKt___SequencesKt$$ExternalSyntheticLambda8(Function2 function2) {
        this.f$0 = function2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return SequencesKt___SequencesKt.$r8$lambda$VVXoILx4Eja6b5jwLZrM9ZhA_fk(this.f$0, ((Integer) obj).intValue(), obj2);
    }
}
