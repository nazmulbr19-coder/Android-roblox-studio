package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/fragment/app/FragmentActivity;", method = "lambda$init$0", proto = "()Landroid/os/Bundle;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentActivity$$ExternalSyntheticLambda0 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ FragmentActivity f$0;

    public /* synthetic */ FragmentActivity$$ExternalSyntheticLambda0(FragmentActivity fragmentActivity) {
        this.f$0 = fragmentActivity;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return this.f$0.m131lambda$init$0$androidxfragmentappFragmentActivity();
    }
}
