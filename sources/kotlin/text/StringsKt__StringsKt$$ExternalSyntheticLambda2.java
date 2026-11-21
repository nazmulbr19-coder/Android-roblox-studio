package kotlin.text;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/text/StringsKt__StringsKt;", method = "rangesDelimitedBy$lambda$16$StringsKt__StringsKt", proto = "(Ljava/util/List;ZLjava/lang/CharSequence;I)Lkotlin/Pair;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class StringsKt__StringsKt$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ StringsKt__StringsKt$$ExternalSyntheticLambda2(List list, boolean z) {
        this.f$0 = list;
        this.f$1 = z;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return StringsKt__StringsKt.$r8$lambda$47p96K3L7I8wwKaOktkrnu8Fn3c(this.f$0, this.f$1, (CharSequence) obj, ((Integer) obj2).intValue());
    }
}
