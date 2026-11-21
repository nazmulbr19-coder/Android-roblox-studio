package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "gameCard$lambda$119", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda37 implements Function0 {
    public final /* synthetic */ StartScreen f$0;
    public final /* synthetic */ RobloxCloud.Game f$1;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda37(StartScreen startScreen, RobloxCloud.Game game) {
        this.f$0 = startScreen;
        this.f$1 = game;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return StartScreen.gameCard$lambda$119(this.f$0, this.f$1);
    }
}
