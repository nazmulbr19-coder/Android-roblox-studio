package kotlin.text;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/text/MatcherMatchResult$groups$1;", method = "iterator$lambda$0", proto = "(Lkotlin/text/MatcherMatchResult$groups$1;I)Lkotlin/text/MatchGroup;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class MatcherMatchResult$groups$1$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ MatcherMatchResult$groups$1 f$0;

    public /* synthetic */ MatcherMatchResult$groups$1$$ExternalSyntheticLambda0(MatcherMatchResult$groups$1 matcherMatchResult$groups$1) {
        this.f$0 = matcherMatchResult$groups$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return MatcherMatchResult$groups$1.iterator$lambda$0(this.f$0, ((Integer) obj).intValue());
    }
}
