package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "versionHistory$lambda$128$lambda$124$lambda$123", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Version;Lcom/exampletest/mobilestudiotest/ui/MainActions;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda29 implements Function0 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ RobloxCloud.Place f$1;
    public final /* synthetic */ RobloxCloud.Version f$2;
    public final /* synthetic */ MainActions f$3;
    public final /* synthetic */ RobloxCloud.Game f$4;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda29(Activity activity, RobloxCloud.Place place, RobloxCloud.Version version, MainActions mainActions, RobloxCloud.Game game) {
        this.f$0 = activity;
        this.f$1 = place;
        this.f$2 = version;
        this.f$3 = mainActions;
        this.f$4 = game;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.versionHistory$lambda$128$lambda$124$lambda$123(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
