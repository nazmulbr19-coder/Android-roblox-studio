package kotlin.collections;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.Map;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/collections/AbstractMap;", method = "toString$lambda$2", proto = "(Lkotlin/collections/AbstractMap;Ljava/util/Map$Entry;)Ljava/lang/CharSequence;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AbstractMap$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ AbstractMap f$0;

    public /* synthetic */ AbstractMap$$ExternalSyntheticLambda0(AbstractMap abstractMap) {
        this.f$0 = abstractMap;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AbstractMap.toString$lambda$2(this.f$0, (Map.Entry) obj);
    }
}
