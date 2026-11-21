package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.File;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "installedPlugins$lambda$169", proto = "(ZLandroid/content/Context;Ljava/io/File;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;Landroid/view/View;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda60 implements Function1 {
    public final /* synthetic */ boolean f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ File f$2;
    public final /* synthetic */ ToolboxPanel f$3;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda60(boolean z, Context context, File file, ToolboxPanel toolboxPanel) {
        this.f$0 = z;
        this.f$1 = context;
        this.f$2 = file;
        this.f$3 = toolboxPanel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ToolboxPanel.installedPlugins$lambda$169(this.f$0, this.f$1, this.f$2, this.f$3, (View) obj);
    }
}
