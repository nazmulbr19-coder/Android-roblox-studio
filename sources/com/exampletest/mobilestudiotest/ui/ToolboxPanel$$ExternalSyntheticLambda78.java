package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "showDetails$lambda$101", proto = "(Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Landroid/content/Context;Landroid/widget/LinearLayout;Landroid/widget/ImageView;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda78 implements Runnable {
    public final /* synthetic */ RobloxApi.Item f$0;
    public final /* synthetic */ ToolboxPanel f$1;
    public final /* synthetic */ Context f$2;
    public final /* synthetic */ LinearLayout f$3;
    public final /* synthetic */ ImageView f$4;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda78(RobloxApi.Item item, ToolboxPanel toolboxPanel, Context context, LinearLayout linearLayout, ImageView imageView) {
        this.f$0 = item;
        this.f$1 = toolboxPanel;
        this.f$2 = context;
        this.f$3 = linearLayout;
        this.f$4 = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.showDetails$lambda$101(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
