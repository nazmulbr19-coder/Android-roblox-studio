package androidx.lifecycle;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/lifecycle/ComputableLiveData;", method = "refreshRunnable$lambda$0", proto = "(Landroidx/lifecycle/ComputableLiveData;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ComputableLiveData$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ComputableLiveData f$0;

    public /* synthetic */ ComputableLiveData$$ExternalSyntheticLambda0(ComputableLiveData computableLiveData) {
        this.f$0 = computableLiveData;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComputableLiveData.refreshRunnable$lambda$0(this.f$0);
    }
}
