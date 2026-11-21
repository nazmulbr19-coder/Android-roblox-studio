package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "showDetails$lambda$111", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda81 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ RobloxApi.Item f$1;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda81(ToolboxPanel toolboxPanel, RobloxApi.Item item) {
        this.f$0 = toolboxPanel;
        this.f$1 = item;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ToolboxPanel.showDetails$lambda$111(this.f$0, this.f$1, dialogInterface, i);
    }
}
