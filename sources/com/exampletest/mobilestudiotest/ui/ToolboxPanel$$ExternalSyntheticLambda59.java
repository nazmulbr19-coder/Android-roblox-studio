package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "myModels$row$lambda$160$lambda$159", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Ljava/io/File;Landroid/content/Context;ZLjava/lang/String;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda59 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ File f$1;
    public final /* synthetic */ Context f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ String f$4;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda59(ToolboxPanel toolboxPanel, File file, Context context, boolean z, String str) {
        this.f$0 = toolboxPanel;
        this.f$1 = file;
        this.f$2 = context;
        this.f$3 = z;
        this.f$4 = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ToolboxPanel.myModels$row$lambda$160$lambda$159(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, dialogInterface, i);
    }
}
