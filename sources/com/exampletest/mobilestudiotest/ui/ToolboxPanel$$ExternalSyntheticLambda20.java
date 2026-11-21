package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.ToolboxPanel;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "robloxInventory$lambda$195", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;ILcom/exampletest/mobilestudiotest/ui/ToolboxPanel$InvCat;Ljava/lang/String;Landroid/view/View;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda20 implements Function1 {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ ToolboxPanel.InvCat f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda20(ToolboxPanel toolboxPanel, int i, ToolboxPanel.InvCat invCat, String str) {
        this.f$0 = toolboxPanel;
        this.f$1 = i;
        this.f$2 = invCat;
        this.f$3 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ToolboxPanel.robloxInventory$lambda$195(this.f$0, this.f$1, this.f$2, this.f$3, (View) obj);
    }
}
