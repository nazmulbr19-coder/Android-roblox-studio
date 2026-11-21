package kotlin.sequences;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/sequences/SequencesKt___SequencesKt$minus$1;", method = "iterator$lambda$0", proto = "(Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/lang/Object;Ljava/lang/Object;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SequencesKt___SequencesKt$minus$1$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ Ref.BooleanRef f$0;
    public final /* synthetic */ Object f$1;

    public /* synthetic */ SequencesKt___SequencesKt$minus$1$$ExternalSyntheticLambda0(Ref.BooleanRef booleanRef, Object obj) {
        this.f$0 = booleanRef;
        this.f$1 = obj;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(SequencesKt___SequencesKt$minus$1.iterator$lambda$0(this.f$0, this.f$1, obj));
    }
}
