package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "robloxInventory$lambda$188$lambda$187", proto = "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/net/RobloxApi$InvItem;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Landroid/view/View;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda19 implements View.OnLongClickListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ RobloxApi.InvItem f$1;
    public final /* synthetic */ ToolboxPanel f$2;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda19(Context context, RobloxApi.InvItem invItem, ToolboxPanel toolboxPanel) {
        this.f$0 = context;
        this.f$1 = invItem;
        this.f$2 = toolboxPanel;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return ToolboxPanel.robloxInventory$lambda$188$lambda$187(this.f$0, this.f$1, this.f$2, view);
    }
}
