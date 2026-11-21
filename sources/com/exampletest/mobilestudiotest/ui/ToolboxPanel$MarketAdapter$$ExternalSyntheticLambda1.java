package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import com.exampletest.mobilestudiotest.ui.ToolboxPanel;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel$MarketAdapter;", method = "onBindViewHolder$lambda$13", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;Landroid/view/View;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$MarketAdapter$$ExternalSyntheticLambda1 implements View.OnLongClickListener {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ RobloxApi.Item f$1;

    public /* synthetic */ ToolboxPanel$MarketAdapter$$ExternalSyntheticLambda1(ToolboxPanel toolboxPanel, RobloxApi.Item item) {
        this.f$0 = toolboxPanel;
        this.f$1 = item;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return ToolboxPanel.MarketAdapter.onBindViewHolder$lambda$13(this.f$0, this.f$1, view);
    }
}
