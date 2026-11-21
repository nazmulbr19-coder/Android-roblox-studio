package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "publishAs$lambda$147", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/ui/MainActions;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda95 implements Function0 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Studio f$1;
    public final /* synthetic */ MainActions f$2;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda95(Activity activity, Studio studio, MainActions mainActions) {
        this.f$0 = activity;
        this.f$1 = studio;
        this.f$2 = mainActions;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.publishAs$lambda$147(this.f$0, this.f$1, this.f$2);
    }
}
