package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.Context;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxApi;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "insertAsset$lambda$59", proto = "(Landroid/content/Context;Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda9 implements Function0 {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ ToolboxPanel f$2;
    public final /* synthetic */ RobloxApi.Item f$3;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda9(Context context, Activity activity, ToolboxPanel toolboxPanel, RobloxApi.Item item) {
        this.f$0 = context;
        this.f$1 = activity;
        this.f$2 = toolboxPanel;
        this.f$3 = item;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return ToolboxPanel.insertAsset$lambda$59(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
