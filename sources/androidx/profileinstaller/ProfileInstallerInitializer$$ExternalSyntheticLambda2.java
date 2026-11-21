package androidx.profileinstaller;

import android.content.Context;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/profileinstaller/ProfileInstallerInitializer;", method = "lambda$writeInBackground$2", proto = "(Landroid/content/Context;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ProfileInstallerInitializer$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ Context f$0;

    public /* synthetic */ ProfileInstallerInitializer$$ExternalSyntheticLambda2(Context context) {
        this.f$0 = context;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProfileInstallerInitializer.lambda$writeInBackground$2(this.f$0);
    }
}
