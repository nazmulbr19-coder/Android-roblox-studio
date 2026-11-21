package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.PropertiesPanel;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel;", method = "edit$lambda$13", proto = "(Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel;Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel$Row;Ljava/lang/Object;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class PropertiesPanel$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ PropertiesPanel f$0;
    public final /* synthetic */ PropertiesPanel.Row f$1;

    public /* synthetic */ PropertiesPanel$$ExternalSyntheticLambda0(PropertiesPanel propertiesPanel, PropertiesPanel.Row row) {
        this.f$0 = propertiesPanel;
        this.f$1 = row;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return PropertiesPanel.edit$lambda$13(this.f$0, this.f$1, obj);
    }
}
