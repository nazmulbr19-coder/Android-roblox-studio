package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/OutputPanel;", method = "schedule$lambda$7", proto = "(Lcom/exampletest/mobilestudiotest/ui/OutputPanel;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class OutputPanel$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ OutputPanel f$0;

    public /* synthetic */ OutputPanel$$ExternalSyntheticLambda0(OutputPanel outputPanel) {
        this.f$0 = outputPanel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        OutputPanel.schedule$lambda$7(this.f$0);
    }
}
