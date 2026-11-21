package androidx.savedstate.internal;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/savedstate/internal/SavedStateRegistryImpl;", method = "performAttach$lambda$12", proto = "(Landroidx/savedstate/internal/SavedStateRegistryImpl;Landroidx/lifecycle/LifecycleOwner;Landroidx/lifecycle/Lifecycle$Event;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SavedStateRegistryImpl$$ExternalSyntheticLambda0 implements LifecycleEventObserver {
    public final /* synthetic */ SavedStateRegistryImpl f$0;

    public /* synthetic */ SavedStateRegistryImpl$$ExternalSyntheticLambda0(SavedStateRegistryImpl savedStateRegistryImpl) {
        this.f$0 = savedStateRegistryImpl;
    }

    @Override // androidx.lifecycle.LifecycleEventObserver
    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
        SavedStateRegistryImpl.performAttach$lambda$12(this.f$0, lifecycleOwner, event);
    }
}
