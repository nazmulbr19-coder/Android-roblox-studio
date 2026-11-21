package androidx.lifecycle;

import androidx.arch.core.util.Function;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/lifecycle/Transformations;", method = "map$lambda$1", proto = "(Landroidx/lifecycle/MediatorLiveData;Landroidx/arch/core/util/Function;Ljava/lang/Object;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Transformations$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ MediatorLiveData f$0;
    public final /* synthetic */ Function f$1;

    public /* synthetic */ Transformations$$ExternalSyntheticLambda4(MediatorLiveData mediatorLiveData, Function function) {
        this.f$0 = mediatorLiveData;
        this.f$1 = function;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Transformations.map$lambda$1(this.f$0, this.f$1, obj);
    }
}
