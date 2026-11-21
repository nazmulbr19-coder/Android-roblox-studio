package androidx.core.util;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/util/Predicate;", method = "lambda$isEqual$4", proto = "(Ljava/lang/Object;Ljava/lang/Object;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Predicate$$ExternalSyntheticLambda2 implements Predicate {
    public final /* synthetic */ Object f$0;

    public /* synthetic */ Predicate$$ExternalSyntheticLambda2(Object obj) {
        this.f$0 = obj;
    }

    @Override // androidx.core.util.Predicate
    public final boolean test(Object obj) {
        return Predicate.lambda$isEqual$4(this.f$0, obj);
    }
}
