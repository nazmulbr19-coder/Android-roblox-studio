package kotlin.comparisons;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/comparisons/ComparisonsKt__ComparisonsKt;", method = "then$lambda$1$ComparisonsKt__ComparisonsKt", proto = "(Ljava/util/Comparator;Ljava/util/Comparator;Ljava/lang/Object;Ljava/lang/Object;)I")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda2 implements Comparator {
    public final /* synthetic */ Comparator f$0;
    public final /* synthetic */ Comparator f$1;

    public /* synthetic */ ComparisonsKt__ComparisonsKt$$ExternalSyntheticLambda2(Comparator comparator, Comparator comparator2) {
        this.f$0 = comparator;
        this.f$1 = comparator2;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return ComparisonsKt__ComparisonsKt.$r8$lambda$fFv4wzBXuBoGFl05zSxqQb7pKRU(this.f$0, this.f$1, obj, obj2);
    }
}
