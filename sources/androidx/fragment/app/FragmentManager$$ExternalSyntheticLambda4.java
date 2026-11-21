package androidx.fragment.app;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/fragment/app/FragmentManager;", method = "lambda$attachController$4", proto = "()Landroid/os/Bundle;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FragmentManager$$ExternalSyntheticLambda4 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ FragmentManager f$0;

    public /* synthetic */ FragmentManager$$ExternalSyntheticLambda4(FragmentManager fragmentManager) {
        this.f$0 = fragmentManager;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return this.f$0.m135lambda$attachController$4$androidxfragmentappFragmentManager();
    }
}
