package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "myModels$row$lambda$160", proto = "(Landroid/content/Context;Ljava/io/File;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;ZLjava/lang/String;Landroid/view/View;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda33 implements View.OnLongClickListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ File f$1;
    public final /* synthetic */ ToolboxPanel f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ String f$4;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda33(Context context, File file, ToolboxPanel toolboxPanel, boolean z, String str) {
        this.f$0 = context;
        this.f$1 = file;
        this.f$2 = toolboxPanel;
        this.f$3 = z;
        this.f$4 = str;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return ToolboxPanel.myModels$row$lambda$160(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
