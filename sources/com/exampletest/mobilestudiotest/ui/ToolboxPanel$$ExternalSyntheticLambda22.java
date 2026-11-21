package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.AuthRequiredException;
import com.exampletest.mobilestudiotest.net.RobloxApi;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "insertAsset$lambda$67$lambda$63", proto = "(Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;Lcom/exampletest/mobilestudiotest/net/AuthRequiredException;Landroid/app/Activity;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda22 implements Runnable {
    public final /* synthetic */ RobloxApi.Item f$0;
    public final /* synthetic */ ToolboxPanel f$1;
    public final /* synthetic */ RobloxApi.Category f$2;
    public final /* synthetic */ AuthRequiredException f$3;
    public final /* synthetic */ Activity f$4;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda22(RobloxApi.Item item, ToolboxPanel toolboxPanel, RobloxApi.Category category, AuthRequiredException authRequiredException, Activity activity) {
        this.f$0 = item;
        this.f$1 = toolboxPanel;
        this.f$2 = category;
        this.f$3 = authRequiredException;
        this.f$4 = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.insertAsset$lambda$67$lambda$63(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
