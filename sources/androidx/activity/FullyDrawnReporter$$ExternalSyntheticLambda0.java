package androidx.activity;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/FullyDrawnReporter;", method = "reportRunnable$lambda$0", proto = "(Landroidx/activity/FullyDrawnReporter;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class FullyDrawnReporter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ FullyDrawnReporter f$0;

    public /* synthetic */ FullyDrawnReporter$$ExternalSyntheticLambda0(FullyDrawnReporter fullyDrawnReporter) {
        this.f$0 = fullyDrawnReporter;
    }

    @Override // java.lang.Runnable
    public final void run() {
        FullyDrawnReporter.reportRunnable$lambda$0(this.f$0);
    }
}
