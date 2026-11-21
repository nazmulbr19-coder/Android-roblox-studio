package androidx.lifecycle;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/lifecycle/LifecycleKt$eventFlow$1;", method = "invokeSuspend$lambda$1", proto = "(Landroidx/lifecycle/Lifecycle;Landroidx/lifecycle/LifecycleEventObserver;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class LifecycleKt$eventFlow$1$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ Lifecycle f$0;
    public final /* synthetic */ LifecycleEventObserver f$1;

    public /* synthetic */ LifecycleKt$eventFlow$1$$ExternalSyntheticLambda1(Lifecycle lifecycle, LifecycleEventObserver lifecycleEventObserver) {
        this.f$0 = lifecycle;
        this.f$1 = lifecycleEventObserver;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return LifecycleKt$eventFlow$1.invokeSuspend$lambda$1(this.f$0, this.f$1);
    }
}
