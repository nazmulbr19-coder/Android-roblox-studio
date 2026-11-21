package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.AuthRequiredException;
import com.exampletest.mobilestudiotest.net.RobloxApi;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "insertMesh$lambda$89$lambda$88", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/AuthRequiredException;Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda27 implements Runnable {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ AuthRequiredException f$1;
    public final /* synthetic */ Activity f$2;
    public final /* synthetic */ RobloxApi.Item f$3;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda27(ToolboxPanel toolboxPanel, AuthRequiredException authRequiredException, Activity activity, RobloxApi.Item item) {
        this.f$0 = toolboxPanel;
        this.f$1 = authRequiredException;
        this.f$2 = activity;
        this.f$3 = item;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.insertMesh$lambda$89$lambda$88(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
