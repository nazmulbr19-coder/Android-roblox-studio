package kotlin.text;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/text/StringsKt__StringsKt;", method = "splitToSequence$lambda$20$StringsKt__StringsKt", proto = "(Ljava/lang/CharSequence;Lkotlin/ranges/IntRange;)Ljava/lang/String;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class StringsKt__StringsKt$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ CharSequence f$0;

    public /* synthetic */ StringsKt__StringsKt$$ExternalSyntheticLambda0(CharSequence charSequence) {
        this.f$0 = charSequence;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return StringsKt__StringsKt.m1760$r8$lambda$omNPivlTjTSpoVPpZkGlRi0Hnk(this.f$0, (IntRange) obj);
    }
}
