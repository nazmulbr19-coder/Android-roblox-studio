package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "versionHistory$lambda$118", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;)Ljava/util/List;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda49 implements Function0 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ RobloxCloud.Place f$1;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda49(Activity activity, RobloxCloud.Place place) {
        this.f$0 = activity;
        this.f$1 = place;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.versionHistory$lambda$118(this.f$0, this.f$1);
    }
}
