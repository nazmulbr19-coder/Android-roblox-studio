package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.Context;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "insertAsset$lambda$67", proto = "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;Landroid/app/Activity;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda11 implements Runnable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ RobloxApi.Item f$1;
    public final /* synthetic */ ToolboxPanel f$2;
    public final /* synthetic */ RobloxApi.Category f$3;
    public final /* synthetic */ Activity f$4;
    public final /* synthetic */ boolean f$5;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda11(Context context, RobloxApi.Item item, ToolboxPanel toolboxPanel, RobloxApi.Category category, Activity activity, boolean z) {
        this.f$0 = context;
        this.f$1 = item;
        this.f$2 = toolboxPanel;
        this.f$3 = category;
        this.f$4 = activity;
        this.f$5 = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.insertAsset$lambda$67(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
