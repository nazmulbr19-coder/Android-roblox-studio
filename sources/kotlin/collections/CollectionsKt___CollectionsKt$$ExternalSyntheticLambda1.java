package kotlin.collections;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lkotlin/collections/CollectionsKt___CollectionsKt;", method = "elementAt$lambda$0$CollectionsKt___CollectionsKt", proto = "(II)Ljava/lang/Object;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class CollectionsKt___CollectionsKt$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ int f$0;

    public /* synthetic */ CollectionsKt___CollectionsKt$$ExternalSyntheticLambda1(int i) {
        this.f$0 = i;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return CollectionsKt___CollectionsKt.$r8$lambda$BxIWqBmJzcr8XhZUTf0HOKSqQtU(this.f$0, ((Integer) obj).intValue());
    }
}
