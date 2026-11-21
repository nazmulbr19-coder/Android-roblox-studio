package androidx.activity;

import android.os.Bundle;
import androidx.savedstate.SavedStateRegistry;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/ComponentActivity;", method = "_init_$lambda$3", proto = "(Landroidx/activity/ComponentActivity;)Landroid/os/Bundle;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda5 implements SavedStateRegistry.SavedStateProvider {
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda5(ComponentActivity componentActivity) {
        this.f$0 = componentActivity;
    }

    @Override // androidx.savedstate.SavedStateRegistry.SavedStateProvider
    public final Bundle saveState() {
        return ComponentActivity._init_$lambda$3(this.f$0);
    }
}
