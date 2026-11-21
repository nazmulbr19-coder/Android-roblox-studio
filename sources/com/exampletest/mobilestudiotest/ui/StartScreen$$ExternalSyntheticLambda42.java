package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.PlaceFactory;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "home$lambda$74", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;Lcom/exampletest/mobilestudiotest/core/PlaceFactory$Template;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda42 implements Function0 {
    public final /* synthetic */ StartScreen f$0;
    public final /* synthetic */ PlaceFactory.Template f$1;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda42(StartScreen startScreen, PlaceFactory.Template template) {
        this.f$0 = startScreen;
        this.f$1 = template;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return StartScreen.home$lambda$74(this.f$0, this.f$1);
    }
}
