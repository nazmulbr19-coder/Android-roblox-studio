package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.ui.ToolboxPanel;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "robloxInventory$lambda$188$lambda$186", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$InvItem;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel$InvCat;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda18 implements View.OnClickListener {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ RobloxApi.InvItem f$1;
    public final /* synthetic */ ToolboxPanel.InvCat f$2;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda18(ToolboxPanel toolboxPanel, RobloxApi.InvItem invItem, ToolboxPanel.InvCat invCat) {
        this.f$0 = toolboxPanel;
        this.f$1 = invItem;
        this.f$2 = invCat;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ToolboxPanel.robloxInventory$lambda$188$lambda$186(this.f$0, this.f$1, this.f$2, view);
    }
}
