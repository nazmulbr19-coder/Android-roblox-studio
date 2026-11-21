package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.ExplorerPanel;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel$Adapter;", method = "onBindViewHolder$lambda$7", proto = "(Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel$Row;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ExplorerPanel$Adapter$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ ExplorerPanel f$0;
    public final /* synthetic */ ExplorerPanel.Row f$1;

    public /* synthetic */ ExplorerPanel$Adapter$$ExternalSyntheticLambda1(ExplorerPanel explorerPanel, ExplorerPanel.Row row) {
        this.f$0 = explorerPanel;
        this.f$1 = row;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ExplorerPanel.Adapter.onBindViewHolder$lambda$7(this.f$0, this.f$1, view);
    }
}
