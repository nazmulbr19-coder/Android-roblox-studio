package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Instance;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;", method = "showContextMenu$lambda$37", proto = "(Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;Lcom/exampletest/mobilestudiotest/model/Instance;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ExplorerPanel$$ExternalSyntheticLambda20 implements Function0 {
    public final /* synthetic */ ExplorerPanel f$0;
    public final /* synthetic */ Instance f$1;

    public /* synthetic */ ExplorerPanel$$ExternalSyntheticLambda20(ExplorerPanel explorerPanel, Instance instance) {
        this.f$0 = explorerPanel;
        this.f$1 = instance;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return ExplorerPanel.showContextMenu$lambda$37(this.f$0, this.f$1);
    }
}
