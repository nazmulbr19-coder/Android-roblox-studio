package kotlin.collections;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/collections/AbstractCollection;", method = "toString$lambda$2", proto = "(Lkotlin/collections/AbstractCollection;Ljava/lang/Object;)Ljava/lang/CharSequence;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class AbstractCollection$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ AbstractCollection f$0;

    public /* synthetic */ AbstractCollection$$ExternalSyntheticLambda0(AbstractCollection abstractCollection) {
        this.f$0 = abstractCollection;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AbstractCollection.toString$lambda$2(this.f$0, obj);
    }
}
