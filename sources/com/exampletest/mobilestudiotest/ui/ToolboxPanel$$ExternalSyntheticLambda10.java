package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "insertAsset$lambda$60", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;Z)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda10 implements Function0 {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ RobloxApi.Item f$1;
    public final /* synthetic */ RobloxApi.Category f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda10(ToolboxPanel toolboxPanel, RobloxApi.Item item, RobloxApi.Category category, boolean z) {
        this.f$0 = toolboxPanel;
        this.f$1 = item;
        this.f$2 = category;
        this.f$3 = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return ToolboxPanel.insertAsset$lambda$60(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
