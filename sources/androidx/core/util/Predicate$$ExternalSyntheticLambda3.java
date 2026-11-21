package androidx.core.util;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/util/Predicate;", method = "lambda$and$0", proto = "(Landroidx/core/util/Predicate;Ljava/lang/Object;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Predicate$$ExternalSyntheticLambda3 implements Predicate {
    public final /* synthetic */ Predicate f$0;
    public final /* synthetic */ Predicate f$1;

    public /* synthetic */ Predicate$$ExternalSyntheticLambda3(Predicate predicate, Predicate predicate2) {
        this.f$0 = predicate;
        this.f$1 = predicate2;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return Predicate.lambda$and$0(this.f$0, this.f$1, obj);
    }
}
