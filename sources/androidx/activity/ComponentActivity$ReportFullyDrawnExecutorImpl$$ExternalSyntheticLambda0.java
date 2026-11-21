package androidx.activity;

import androidx.activity.ComponentActivity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutorImpl;", method = "execute$lambda$0", proto = "(Landroidx/activity/ComponentActivity$ReportFullyDrawnExecutorImpl;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ComponentActivity$ReportFullyDrawnExecutorImpl$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ ComponentActivity.ReportFullyDrawnExecutorImpl f$0;

    public /* synthetic */ ComponentActivity$ReportFullyDrawnExecutorImpl$$ExternalSyntheticLambda0(ComponentActivity.ReportFullyDrawnExecutorImpl reportFullyDrawnExecutorImpl) {
        this.f$0 = reportFullyDrawnExecutorImpl;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ComponentActivity.ReportFullyDrawnExecutorImpl.execute$lambda$0(this.f$0);
    }
}
