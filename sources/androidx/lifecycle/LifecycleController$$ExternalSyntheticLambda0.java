package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlinx.coroutines.Job;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/lifecycle/LifecycleController;", method = "observer$lambda$0", proto = "(Landroidx/lifecycle/LifecycleController;Lkotlinx/coroutines/Job;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class LifecycleController$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ LifecycleController f$0;
    public final /* synthetic */ Job f$1;

    public /* synthetic */ LifecycleController$$ExternalSyntheticLambda0(LifecycleController lifecycleController, Job job) {
        this.f$0 = lifecycleController;
        this.f$1 = job;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        LifecycleController.observer$lambda$0(this.f$0, this.f$1, lifecycleOwner, event);
    }
}
