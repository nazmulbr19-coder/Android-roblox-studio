package androidx.core.content;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/core/content/UnusedAppRestrictionsBackportServiceConnection;", method = "disconnectFromService", proto = "()V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class PackageManagerCompat$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ UnusedAppRestrictionsBackportServiceConnection f$0;

    public /* synthetic */ PackageManagerCompat$$ExternalSyntheticLambda0(UnusedAppRestrictionsBackportServiceConnection unusedAppRestrictionsBackportServiceConnection) {
        this.f$0 = unusedAppRestrictionsBackportServiceConnection;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.disconnectFromService();
    }
}
