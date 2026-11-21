package com.exampletest.mobilestudiotest.ui;

import android.view.DragEvent;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;", method = "_init_$lambda$4", proto = "(Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;Landroid/view/View;Landroid/view/DragEvent;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ExplorerPanel$$ExternalSyntheticLambda6 implements View.OnDragListener {
    public final /* synthetic */ ExplorerPanel f$0;

    public /* synthetic */ ExplorerPanel$$ExternalSyntheticLambda6(ExplorerPanel explorerPanel) {
        this.f$0 = explorerPanel;
    }

    @Override // android.view.View.OnDragListener
    public final boolean onDrag(View view, DragEvent dragEvent) {
        return ExplorerPanel._init_$lambda$4(this.f$0, view, dragEvent);
    }
}
