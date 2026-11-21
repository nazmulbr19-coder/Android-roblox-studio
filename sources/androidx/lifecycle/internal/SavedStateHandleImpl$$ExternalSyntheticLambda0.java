package androidx.lifecycle.internal;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/lifecycle/internal/SavedStateHandleImpl;", method = "savedStateProvider$lambda$0", proto = "(Landroidx/lifecycle/internal/SavedStateHandleImpl;)Landroid/os/Bundle;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SavedStateHandleImpl$$ExternalSyntheticLambda0 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ SavedStateHandleImpl f$0;

    public /* synthetic */ SavedStateHandleImpl$$ExternalSyntheticLambda0(SavedStateHandleImpl savedStateHandleImpl) {
        this.f$0 = savedStateHandleImpl;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return SavedStateHandleImpl.savedStateProvider$lambda$0(this.f$0);
    }
}
