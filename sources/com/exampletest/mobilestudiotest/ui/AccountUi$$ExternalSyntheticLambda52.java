package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "currentPlaceHistory$lambda$168", proto = "(Lcom/exampletest/mobilestudiotest/net/CloudPlace;Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/ui/MainActions;Lcom/exampletest/mobilestudiotest/core/Studio;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda52 implements Function0 {
    public final /* synthetic */ CloudPlace f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ MainActions f$2;
    public final /* synthetic */ Studio f$3;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda52(CloudPlace cloudPlace, Activity activity, MainActions mainActions, Studio studio) {
        this.f$0 = cloudPlace;
        this.f$1 = activity;
        this.f$2 = mainActions;
        this.f$3 = studio;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.currentPlaceHistory$lambda$168(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
