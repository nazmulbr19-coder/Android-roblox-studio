package kotlin.text;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/text/Regex;", method = "findAll$lambda$1", proto = "(Lkotlin/text/Regex;Ljava/lang/CharSequence;I)Lkotlin/text/MatchResult;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Regex$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ Regex f$0;
    public final /* synthetic */ CharSequence f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ Regex$$ExternalSyntheticLambda0(Regex regex, CharSequence charSequence, int i) {
        this.f$0 = regex;
        this.f$1 = charSequence;
        this.f$2 = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Regex.findAll$lambda$1(this.f$0, this.f$1, this.f$2);
    }
}
