package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.File;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "myModels$row$lambda$160$lambda$159$lambda$157", proto = "(Ljava/io/File;Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;ZLjava/lang/String;Ljava/lang/String;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda49 implements Function1 {
    public final /* synthetic */ File f$0;
    public final /* synthetic */ ToolboxPanel f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda49(File file, ToolboxPanel toolboxPanel, boolean z, String str) {
        this.f$0 = file;
        this.f$1 = toolboxPanel;
        this.f$2 = z;
        this.f$3 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return ToolboxPanel.myModels$row$lambda$160$lambda$159$lambda$157(this.f$0, this.f$1, this.f$2, this.f$3, (String) obj);
    }
}
