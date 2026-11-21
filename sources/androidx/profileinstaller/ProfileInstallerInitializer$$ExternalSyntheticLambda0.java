package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/profileinstaller/ProfileInstallerInitializer;", method = "lambda$create$0", proto = "(Landroid/content/Context;J)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ProfileInstallerInitializer$$ExternalSyntheticLambda0 implements Choreographer.FrameCallback {
    public final /* synthetic */ ProfileInstallerInitializer f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ ProfileInstallerInitializer$$ExternalSyntheticLambda0(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f$0 = profileInstallerInitializer;
        this.f$1 = context;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.f$0.m179x451635a(this.f$1, j);
    }
}
