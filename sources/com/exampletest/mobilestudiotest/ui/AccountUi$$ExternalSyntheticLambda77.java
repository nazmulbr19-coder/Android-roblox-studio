package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "publish$lambda$137", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/net/CloudPlace;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda77 implements Function0 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Studio f$1;
    public final /* synthetic */ CloudPlace f$2;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda77(Activity activity, Studio studio, CloudPlace cloudPlace) {
        this.f$0 = activity;
        this.f$1 = studio;
        this.f$2 = cloudPlace;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.publish$lambda$137(this.f$0, this.f$1, this.f$2);
    }
}
