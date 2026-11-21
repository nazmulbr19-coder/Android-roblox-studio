package androidx.lifecycle;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/lifecycle/DispatchQueue;", method = "dispatchAndEnqueue$lambda$0$0", proto = "(Landroidx/lifecycle/DispatchQueue;Ljava/lang/Runnable;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class DispatchQueue$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ DispatchQueue f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ DispatchQueue$$ExternalSyntheticLambda0(DispatchQueue dispatchQueue, Runnable runnable) {
        this.f$0 = dispatchQueue;
        this.f$1 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DispatchQueue.$r8$lambda$1m74FjPo0LeIWI_UKtXYmw1U0fs(this.f$0, this.f$1);
    }
}
