package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "paidDialog$lambda$70", proto = "(ZLcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ ToolboxPanel f$1;
    public final /* synthetic */ RobloxApi.Item f$2;
    public final /* synthetic */ RobloxApi.Category f$3;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda3(boolean z, ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category) {
        this.f$0 = z;
        this.f$1 = toolboxPanel;
        this.f$2 = item;
        this.f$3 = category;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ToolboxPanel.paidDialog$lambda$70(this.f$0, this.f$1, this.f$2, this.f$3, dialogInterface, i);
    }
}
