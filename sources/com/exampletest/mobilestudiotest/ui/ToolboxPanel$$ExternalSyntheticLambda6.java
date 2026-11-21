package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.DragEvent;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "_init_$lambda$3", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Landroid/content/Context;Landroid/view/View;Landroid/view/DragEvent;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda6 implements View.OnDragListener {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda6(ToolboxPanel toolboxPanel, Context context) {
        this.f$0 = toolboxPanel;
        this.f$1 = context;
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View view, DragEvent dragEvent) {
        return ToolboxPanel._init_$lambda$3(this.f$0, this.f$1, view, dragEvent);
    }
}
