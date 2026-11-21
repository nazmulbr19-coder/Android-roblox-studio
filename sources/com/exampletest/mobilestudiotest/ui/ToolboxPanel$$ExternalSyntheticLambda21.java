package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.format.RbxDocument;
import com.exampletest.mobilestudiotest.net.RobloxApi;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "insertAsset$lambda$67$lambda$61", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;[BLcom/exampletest/mobilestudiotest/format/RbxDocument;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda21 implements Runnable {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ RobloxApi.Item f$1;
    public final /* synthetic */ byte[] f$2;
    public final /* synthetic */ RbxDocument f$3;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda21(ToolboxPanel toolboxPanel, RobloxApi.Item item, byte[] bArr, RbxDocument rbxDocument) {
        this.f$0 = toolboxPanel;
        this.f$1 = item;
        this.f$2 = bArr;
        this.f$3 = rbxDocument;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.insertAsset$lambda$67$lambda$61(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
