package com.exampletest.mobilestudiotest;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "pickColorForSelection$lambda$248", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Ljava/util/List;Ljava/lang/Object;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda121 implements Function1 {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda121(MainActivity mainActivity, List list) {
        this.f$0 = mainActivity;
        this.f$1 = list;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return MainActivity.pickColorForSelection$lambda$248(this.f$0, this.f$1, obj);
    }
}
