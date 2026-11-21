package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "insertAsset$lambda$67$lambda$64", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda23 implements Runnable {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ RobloxApi.Item f$1;
    public final /* synthetic */ RobloxApi.Category f$2;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda23(ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category) {
        this.f$0 = toolboxPanel;
        this.f$1 = item;
        this.f$2 = category;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.insertAsset$lambda$67$lambda$64(this.f$0, this.f$1, this.f$2);
    }
}
