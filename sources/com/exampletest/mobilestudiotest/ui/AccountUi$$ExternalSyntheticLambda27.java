package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "versionHistory$lambda$128$lambda$124$lambda$123$lambda$120", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/ui/MainActions;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Version;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda27 implements Function0 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ MainActions f$1;
    public final /* synthetic */ RobloxCloud.Place f$2;
    public final /* synthetic */ RobloxCloud.Version f$3;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda27(Activity activity, MainActions mainActions, RobloxCloud.Place place, RobloxCloud.Version version) {
        this.f$0 = activity;
        this.f$1 = mainActions;
        this.f$2 = place;
        this.f$3 = version;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.versionHistory$lambda$128$lambda$124$lambda$123$lambda$120(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
