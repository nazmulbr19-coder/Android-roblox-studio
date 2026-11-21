package androidx.core.app;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import androidx.core.app.PendingIntentCompat;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/app/PendingIntentCompat$GatedCallback;", method = "onSendFinished", proto = "(Landroid/app/PendingIntent;Landroid/content/Intent;ILjava/lang/String;Landroid/os/Bundle;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0 implements PendingIntent.OnFinished {
    public final /* synthetic */ PendingIntentCompat.GatedCallback f$0;

    public /* synthetic */ PendingIntentCompat$GatedCallback$$ExternalSyntheticLambda0(PendingIntentCompat.GatedCallback gatedCallback) {
        this.f$0 = gatedCallback;
    }

    @Override // android.app.PendingIntent.OnFinished
    public final void onSendFinished(PendingIntent pendingIntent, Intent intent, int i, String str, Bundle bundle) {
        PendingIntentCompat.GatedCallback.m57$r8$lambda$_JLK_p2qvpYOAwGjpaXu2HJ864(this.f$0, pendingIntent, intent, i, str, bundle);
    }
}
