package androidx.activity;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/ComponentActivity;", method = "onBackPressedDispatcher_delegate$lambda$0$1$0", proto = "(Landroidx/activity/ComponentActivity;Landroidx/activity/OnBackPressedDispatcher;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda10 implements Runnable {
    public final /* synthetic */ ComponentActivity f$0;
    public final /* synthetic */ OnBackPressedDispatcher f$1;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda10(ComponentActivity componentActivity, OnBackPressedDispatcher onBackPressedDispatcher) {
        this.f$0 = componentActivity;
        this.f$1 = onBackPressedDispatcher;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentActivity.m0$r8$lambda$7IJBVrN0sHyidCAZufWEJFc7yY(this.f$0, this.f$1);
    }
}
