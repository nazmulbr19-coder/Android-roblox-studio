package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.format.RbxDocument;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "insertFile$lambda$217$lambda$216", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/format/RbxDocument;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ RbxDocument f$1;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda1(ToolboxPanel toolboxPanel, RbxDocument rbxDocument) {
        this.f$0 = toolboxPanel;
        this.f$1 = rbxDocument;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.insertFile$lambda$217$lambda$216(this.f$0, this.f$1);
    }
}
