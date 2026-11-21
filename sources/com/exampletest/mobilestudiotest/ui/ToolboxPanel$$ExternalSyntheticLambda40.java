package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import java.util.ArrayList;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "buildMarket$lambda$41$lambda$40", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Price;Ljava/util/ArrayList;Landroid/content/Context;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda40 implements View.OnClickListener {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ RobloxApi.Price f$1;
    public final /* synthetic */ ArrayList f$2;
    public final /* synthetic */ Context f$3;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda40(ToolboxPanel toolboxPanel, RobloxApi.Price price, ArrayList arrayList, Context context) {
        this.f$0 = toolboxPanel;
        this.f$1 = price;
        this.f$2 = arrayList;
        this.f$3 = context;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ToolboxPanel.buildMarket$lambda$41$lambda$40(this.f$0, this.f$1, this.f$2, this.f$3, view);
    }
}
