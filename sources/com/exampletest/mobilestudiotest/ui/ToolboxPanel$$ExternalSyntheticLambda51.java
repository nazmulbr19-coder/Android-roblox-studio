package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.ToolboxPanel;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "loadInventory$lambda$210", proto = "(Landroid/content/Context;Ljava/lang/String;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel$InvCat;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda51 implements Runnable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ ToolboxPanel.InvCat f$2;
    public final /* synthetic */ ToolboxPanel f$3;
    public final /* synthetic */ int f$4;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda51(Context context, String str, ToolboxPanel.InvCat invCat, ToolboxPanel toolboxPanel, int i) {
        this.f$0 = context;
        this.f$1 = str;
        this.f$2 = invCat;
        this.f$3 = toolboxPanel;
        this.f$4 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.loadInventory$lambda$210(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
