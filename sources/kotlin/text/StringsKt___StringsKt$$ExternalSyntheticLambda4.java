package kotlin.text;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/text/StringsKt___StringsKt;", method = "windowedSequence$lambda$25$StringsKt___StringsKt", proto = "(ILjava/lang/CharSequence;Lkotlin/jvm/functions/Function1;I)Ljava/lang/Object;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class StringsKt___StringsKt$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ CharSequence f$1;
    public final /* synthetic */ Function1 f$2;

    public /* synthetic */ StringsKt___StringsKt$$ExternalSyntheticLambda4(int i, CharSequence charSequence, Function1 function1) {
        this.f$0 = i;
        this.f$1 = charSequence;
        this.f$2 = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return StringsKt___StringsKt.$r8$lambda$oReEvkBVk37EYcav8mOOaXfOBr0(this.f$0, this.f$1, this.f$2, ((Integer) obj).intValue());
    }
}
