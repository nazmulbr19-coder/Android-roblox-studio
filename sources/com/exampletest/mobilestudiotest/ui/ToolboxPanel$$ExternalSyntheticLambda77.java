package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "loadMore$lambda$57$lambda$56", proto = "(ILcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Ljava/lang/Exception;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda77 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ ToolboxPanel f$1;
    public final /* synthetic */ Exception f$2;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda77(int i, ToolboxPanel toolboxPanel, Exception exc) {
        this.f$0 = i;
        this.f$1 = toolboxPanel;
        this.f$2 = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.loadMore$lambda$57$lambda$56(this.f$0, this.f$1, this.f$2);
    }
}
