package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import android.widget.ImageView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "showDetails$lambda$101$lambda$100$lambda$98$lambda$97", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Landroid/widget/ImageView;JLandroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda48 implements View.OnClickListener {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ ImageView f$1;
    public final /* synthetic */ long f$2;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda48(ToolboxPanel toolboxPanel, ImageView imageView, long j) {
        this.f$0 = toolboxPanel;
        this.f$1 = imageView;
        this.f$2 = j;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        ToolboxPanel.showDetails$lambda$101$lambda$100$lambda$98$lambda$97(this.f$0, this.f$1, this.f$2, view);
    }
}
