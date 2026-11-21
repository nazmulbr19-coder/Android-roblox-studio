package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.ui.ViewportView;
import java.util.Set;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ViewportView$TouchLayer;", method = "updatePartDrag$lambda$85$lambda$83", proto = "(Ljava/util/Set;Lcom/exampletest/mobilestudiotest/model/Instance;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ViewportView$TouchLayer$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ Set f$0;

    public /* synthetic */ ViewportView$TouchLayer$$ExternalSyntheticLambda7(Set set) {
        this.f$0 = set;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(ViewportView.TouchLayer.updatePartDrag$lambda$85$lambda$83(this.f$0, (Instance) obj));
    }
}
