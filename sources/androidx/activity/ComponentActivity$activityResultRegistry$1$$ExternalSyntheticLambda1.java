package androidx.activity;

import android.content.IntentSender;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/ComponentActivity$activityResultRegistry$1;", method = "onLaunch$lambda$1", proto = "(Landroidx/activity/ComponentActivity$activityResultRegistry$1;ILandroid/content/IntentSender$SendIntentException;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$activityResultRegistry$1$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ComponentActivity$activityResultRegistry$1 f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ IntentSender.SendIntentException f$2;

    public /* synthetic */ ComponentActivity$activityResultRegistry$1$$ExternalSyntheticLambda1(ComponentActivity$activityResultRegistry$1 componentActivity$activityResultRegistry$1, int i, IntentSender.SendIntentException sendIntentException) {
        this.f$0 = componentActivity$activityResultRegistry$1;
        this.f$1 = i;
        this.f$2 = sendIntentException;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentActivity$activityResultRegistry$1.onLaunch$lambda$1(this.f$0, this.f$1, this.f$2);
    }
}
