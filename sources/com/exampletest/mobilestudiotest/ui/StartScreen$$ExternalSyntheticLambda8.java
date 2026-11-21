package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "greeting$lambda$90", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;Landroid/view/View;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ StartScreen f$0;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda8(StartScreen startScreen) {
        this.f$0 = startScreen;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return StartScreen.greeting$lambda$90(this.f$0, (View) obj);
    }
}
