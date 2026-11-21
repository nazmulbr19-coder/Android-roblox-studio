package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import java.util.List;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "loadMore$lambda$57$lambda$55", proto = "(ILcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Ljava/util/Map;Ljava/util/List;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Page;Ljava/lang/String;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda76 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ ToolboxPanel f$1;
    public final /* synthetic */ Map f$2;
    public final /* synthetic */ List f$3;
    public final /* synthetic */ RobloxApi.Page f$4;
    public final /* synthetic */ String f$5;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda76(int i, ToolboxPanel toolboxPanel, Map map, List list, RobloxApi.Page page, String str) {
        this.f$0 = i;
        this.f$1 = toolboxPanel;
        this.f$2 = map;
        this.f$3 = list;
        this.f$4 = page;
        this.f$5 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.loadMore$lambda$57$lambda$55(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
