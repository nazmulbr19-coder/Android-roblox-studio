package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Instance;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/PropertiesPanel;", method = "rebuild$lambda$9$lambda$4", proto = "(Ljava/lang/Long;Lcom/exampletest/mobilestudiotest/model/Instance;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class PropertiesPanel$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ Long f$0;
    public final /* synthetic */ Instance f$1;

    public /* synthetic */ PropertiesPanel$$ExternalSyntheticLambda2(Long l, Instance instance) {
        this.f$0 = l;
        this.f$1 = instance;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return PropertiesPanel.rebuild$lambda$9$lambda$4(this.f$0, this.f$1);
    }
}
