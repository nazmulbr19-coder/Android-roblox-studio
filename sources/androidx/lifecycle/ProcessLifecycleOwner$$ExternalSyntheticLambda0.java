package androidx.lifecycle;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/lifecycle/ProcessLifecycleOwner;", method = "delayedPauseRunnable$lambda$0", proto = "(Landroidx/lifecycle/ProcessLifecycleOwner;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ProcessLifecycleOwner$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ProcessLifecycleOwner f$0;

    public /* synthetic */ ProcessLifecycleOwner$$ExternalSyntheticLambda0(ProcessLifecycleOwner processLifecycleOwner) {
        this.f$0 = processLifecycleOwner;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ProcessLifecycleOwner.delayedPauseRunnable$lambda$0(this.f$0);
    }
}
