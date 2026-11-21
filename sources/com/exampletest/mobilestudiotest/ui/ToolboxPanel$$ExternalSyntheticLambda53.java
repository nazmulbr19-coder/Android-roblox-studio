package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "showDetails$lambda$101$lambda$100", proto = "(Ljava/util/List;Landroid/content/Context;Landroid/widget/LinearLayout;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Landroid/widget/ImageView;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda53 implements Runnable {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ LinearLayout f$2;
    public final /* synthetic */ ToolboxPanel f$3;
    public final /* synthetic */ ImageView f$4;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda53(List list, Context context, LinearLayout linearLayout, ToolboxPanel toolboxPanel, ImageView imageView) {
        this.f$0 = list;
        this.f$1 = context;
        this.f$2 = linearLayout;
        this.f$3 = toolboxPanel;
        this.f$4 = imageView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ToolboxPanel.showDetails$lambda$101$lambda$100(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
