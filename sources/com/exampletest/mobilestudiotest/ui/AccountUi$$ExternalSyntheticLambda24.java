package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "places$lambda$97", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;)Ljava/util/List;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda24 implements Function0 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ RobloxCloud.Game f$1;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda24(Activity activity, RobloxCloud.Game game) {
        this.f$0 = activity;
        this.f$1 = game;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.places$lambda$97(this.f$0, this.f$1);
    }
}
