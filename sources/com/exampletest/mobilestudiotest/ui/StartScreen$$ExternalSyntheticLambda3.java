package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "gameCard$lambda$119$lambda$118", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda3 implements Function2 {
    public final /* synthetic */ StartScreen f$0;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda3(StartScreen startScreen) {
        this.f$0 = startScreen;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return StartScreen.gameCard$lambda$119$lambda$118(this.f$0, (RobloxCloud.Game) obj, (RobloxCloud.Place) obj2);
    }
}
