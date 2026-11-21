package com.exampletest.mobilestudiotest;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "handleIntent$lambda$24$lambda$23", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Ljava/lang/String;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda168 implements Function0 {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda168(MainActivity mainActivity, String str) {
        this.f$0 = mainActivity;
        this.f$1 = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return MainActivity.handleIntent$lambda$24$lambda$23(this.f$0, this.f$1);
    }
}
