package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "loadMore$lambda$57", proto = "(Ljava/lang/String;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Price;Ljava/lang/String;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda44 implements Runnable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ RobloxApi.Category f$1;
    public final /* synthetic */ RobloxApi.Price f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ ToolboxPanel f$4;
    public final /* synthetic */ int f$5;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda44(String str, RobloxApi.Category category, RobloxApi.Price price, String str2, ToolboxPanel toolboxPanel, int i) {
        this.f$0 = str;
        this.f$1 = category;
        this.f$2 = price;
        this.f$3 = str2;
        this.f$4 = toolboxPanel;
        this.f$5 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.loadMore$lambda$57(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
