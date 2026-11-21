package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "openPlace$lambda$113", proto = "(Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;Ljava/lang/Integer;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;Lcom/exampletest/mobilestudiotest/ui/MainActions;Landroid/app/Activity;Lkotlin/Pair;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda88 implements Function1 {
    public final /* synthetic */ RobloxCloud.Place f$0;
    public final /* synthetic */ Integer f$1;
    public final /* synthetic */ RobloxCloud.Game f$2;
    public final /* synthetic */ MainActions f$3;
    public final /* synthetic */ Activity f$4;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda88(RobloxCloud.Place place, Integer num, RobloxCloud.Game game, MainActions mainActions, Activity activity) {
        this.f$0 = place;
        this.f$1 = num;
        this.f$2 = game;
        this.f$3 = mainActions;
        this.f$4 = activity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.openPlace$lambda$113(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Pair) obj);
    }
}
