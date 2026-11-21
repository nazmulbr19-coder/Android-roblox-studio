package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.PropertiesPanel;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel$Adapter;", method = "onBindViewHolder$lambda$8", proto = "(Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel;Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel$Row;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class PropertiesPanel$Adapter$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ PropertiesPanel f$0;
    public final /* synthetic */ PropertiesPanel.Row f$1;

    public /* synthetic */ PropertiesPanel$Adapter$$ExternalSyntheticLambda1(PropertiesPanel propertiesPanel, PropertiesPanel.Row row) {
        this.f$0 = propertiesPanel;
        this.f$1 = row;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PropertiesPanel.Adapter.onBindViewHolder$lambda$8(this.f$0, this.f$1, view);
    }
}
