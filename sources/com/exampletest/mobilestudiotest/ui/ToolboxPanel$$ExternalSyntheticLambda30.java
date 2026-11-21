package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "insertFile$lambda$217", proto = "(Ljava/io/File;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda30 implements Runnable {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ ToolboxPanel f$1;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda30(File file, ToolboxPanel toolboxPanel) {
        this.f$0 = file;
        this.f$1 = toolboxPanel;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.insertFile$lambda$217(this.f$0, this.f$1);
    }
}
