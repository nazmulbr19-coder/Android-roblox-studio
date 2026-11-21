package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.File;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "installedPlugins$lambda$169$lambda$168", proto = "(Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Ljava/io/File;ZLandroid/content/Context;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda34 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ToolboxPanel f$0;
    public final /* synthetic */ File f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Context f$3;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda34(ToolboxPanel toolboxPanel, File file, boolean z, Context context) {
        this.f$0 = toolboxPanel;
        this.f$1 = file;
        this.f$2 = z;
        this.f$3 = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        ToolboxPanel.installedPlugins$lambda$169$lambda$168(this.f$0, this.f$1, this.f$2, this.f$3, dialogInterface, i);
    }
}
