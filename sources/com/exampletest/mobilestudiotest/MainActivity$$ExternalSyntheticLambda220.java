package com.exampletest.mobilestudiotest;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "webAsker$lambda$33$lambda$32", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda220 implements Runnable {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ Function1 f$3;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda220(MainActivity mainActivity, String str, String str2, Function1 function1) {
        this.f$0 = mainActivity;
        this.f$1 = str;
        this.f$2 = str2;
        this.f$3 = function1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainActivity.webAsker$lambda$33$lambda$32(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
