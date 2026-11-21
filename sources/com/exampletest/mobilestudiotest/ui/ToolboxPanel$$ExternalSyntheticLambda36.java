package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "buildMarket$lambda$25", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Landroid/widget/EditText;Landroid/view/View;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda36 implements Function1 {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ EditText f$1;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda36(ToolboxPanel toolboxPanel, EditText editText) {
        this.f$0 = toolboxPanel;
        this.f$1 = editText;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ToolboxPanel.buildMarket$lambda$25(this.f$0, this.f$1, (View) obj);
    }
}
