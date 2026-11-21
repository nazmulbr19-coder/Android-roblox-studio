package com.exampletest.mobilestudiotest;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "buildRibbon$lambda$225", proto = "(Ljava/util/List;Lcom/exampletest/mobilestudiotest/MainActivity;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda205 implements Function0 {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ MainActivity f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda205(List list, MainActivity mainActivity) {
        this.f$0 = list;
        this.f$1 = mainActivity;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return MainActivity.buildRibbon$lambda$225(this.f$0, this.f$1);
    }
}
