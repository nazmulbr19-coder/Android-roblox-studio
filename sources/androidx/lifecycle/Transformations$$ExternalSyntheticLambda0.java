package androidx.lifecycle;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/lifecycle/Transformations;", method = "switchMap$lambda$0", proto = "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/Ref$ObjectRef;Landroidx/lifecycle/MediatorLiveData;Ljava/lang/Object;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Transformations$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ Ref.ObjectRef f$1;
    public final /* synthetic */ MediatorLiveData f$2;

    public /* synthetic */ Transformations$$ExternalSyntheticLambda0(Function1 function1, Ref.ObjectRef objectRef, MediatorLiveData mediatorLiveData) {
        this.f$0 = function1;
        this.f$1 = objectRef;
        this.f$2 = mediatorLiveData;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Transformations.switchMap$lambda$0(this.f$0, this.f$1, this.f$2, obj);
    }
}
