package androidx.activity;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/ComponentActivity;", method = "onBackPressedDispatcher_delegate$lambda$0$0", proto = "(Landroidx/activity/ComponentActivity;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$$ExternalSyntheticLambda9 implements Runnable {
    public final /* synthetic */ ComponentActivity f$0;

    public /* synthetic */ ComponentActivity$$ExternalSyntheticLambda9(ComponentActivity componentActivity) {
        this.f$0 = componentActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentActivity.$r8$lambda$vCwjfXDiSGcirCy4I008VOiJ_lw(this.f$0);
    }
}
