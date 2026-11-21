package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.ToolboxPanel;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "loadInventory$lambda$210$lambda$209", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Ljava/lang/Object;Ljava/lang/String;ILcom/exampletest/mobilestudiotest/ui/ToolboxPanel$InvCat;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda12 implements Runnable {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ Object f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ int f$3;
    public final /* synthetic */ ToolboxPanel.InvCat f$4;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda12(ToolboxPanel toolboxPanel, Object obj, String str, int i, ToolboxPanel.InvCat invCat) {
        this.f$0 = toolboxPanel;
        this.f$1 = obj;
        this.f$2 = str;
        this.f$3 = i;
        this.f$4 = invCat;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.loadInventory$lambda$210$lambda$209(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
