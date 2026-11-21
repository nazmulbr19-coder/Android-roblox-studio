package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.ui.ToolboxPanel;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel$MarketAdapter;", method = "onBindViewHolder$lambda$12", proto = "(Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$MarketAdapter$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ RobloxApi.Item f$0;
    public final /* synthetic */ ToolboxPanel f$1;

    public /* synthetic */ ToolboxPanel$MarketAdapter$$ExternalSyntheticLambda0(RobloxApi.Item item, ToolboxPanel toolboxPanel) {
        this.f$0 = item;
        this.f$1 = toolboxPanel;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ToolboxPanel.MarketAdapter.onBindViewHolder$lambda$12(this.f$0, this.f$1, view);
    }
}
