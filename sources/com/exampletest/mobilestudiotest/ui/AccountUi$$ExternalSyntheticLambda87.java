package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "openPlace$lambda$110", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;Ljava/lang/Integer;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;)Lkotlin/Pair;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda87 implements Function0 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ RobloxCloud.Place f$1;
    public final /* synthetic */ Integer f$2;
    public final /* synthetic */ RobloxCloud.Game f$3;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda87(Activity activity, RobloxCloud.Place place, Integer num, RobloxCloud.Game game) {
        this.f$0 = activity;
        this.f$1 = place;
        this.f$2 = num;
        this.f$3 = game;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.openPlace$lambda$110(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
