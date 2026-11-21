package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/profileinstaller/ProfileInstaller;", method = "lambda$diagnostic$1", proto = "(Landroidx/profileinstaller/ProfileInstaller$DiagnosticsCallback;ILjava/lang/Object;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ProfileInstaller$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ Object f$2;

    public /* synthetic */ ProfileInstaller$$ExternalSyntheticLambda1(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i, Object obj) {
        this.f$0 = diagnosticsCallback;
        this.f$1 = i;
        this.f$2 = obj;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProfileInstaller.lambda$diagnostic$1(this.f$0, this.f$1, this.f$2);
    }
}
