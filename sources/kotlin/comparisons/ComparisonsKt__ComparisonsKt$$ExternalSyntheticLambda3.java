package kotlin.comparisons;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.Comparator;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/comparisons/ComparisonsKt__ComparisonsKt;", method = "compareBy$lambda$0$ComparisonsKt__ComparisonsKt", proto = "([Lkotlin/jvm/functions/Function1;Ljava/lang/Object;Ljava/lang/Object;)I")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda3 implements Comparator {
    public final /* synthetic */ Function1[] f$0;

    public /* synthetic */ ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda3(Function1[] function1Arr) {
        this.f$0 = function1Arr;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.$r8$lambda$W8AWSBCuy65sMGWfMo6pJ3RDjRw(this.f$0, obj, obj2);
    }
}
