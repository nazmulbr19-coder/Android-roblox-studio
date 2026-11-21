package kotlin.text;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/text/StringsKt__StringsKt;", method = "rangesDelimitedBy$lambda$14$StringsKt__StringsKt", proto = "([CZLjava/lang/CharSequence;I)Lkotlin/Pair;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class StringsKt__StringsKt$$ExternalSyntheticLambda1 implements Function2 {
    public final /* synthetic */ char[] f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ StringsKt__StringsKt$$ExternalSyntheticLambda1(char[] cArr, boolean z) {
        this.f$0 = cArr;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return StringsKt__StringsKt.$r8$lambda$khMEFDjIj766SCh5THQNoen7fI8(this.f$0, this.f$1, (CharSequence) obj, ((Integer) obj2).intValue());
    }
}
