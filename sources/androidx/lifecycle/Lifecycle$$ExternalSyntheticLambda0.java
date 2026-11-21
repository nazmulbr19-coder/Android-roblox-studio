package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlinx.coroutines.flow.MutableStateFlow;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/lifecycle/Lifecycle;", method = "_get_currentStateFlow_$lambda$0", proto = "(Lkotlinx/coroutines/flow/MutableStateFlow;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Lifecycle$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ MutableStateFlow f$0;

    public /* synthetic */ Lifecycle$$ExternalSyntheticLambda0(MutableStateFlow mutableStateFlow) {
        this.f$0 = mutableStateFlow;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        Lifecycle._get_currentStateFlow_$lambda$0(this.f$0, lifecycleOwner, event);
    }
}
