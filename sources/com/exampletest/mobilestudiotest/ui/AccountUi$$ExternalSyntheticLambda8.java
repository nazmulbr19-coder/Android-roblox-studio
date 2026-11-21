package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "upload$lambda$176$lambda$169", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/net/CloudPlace;Z)Lkotlin/Pair;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda8 implements Function0 {
    public final /* synthetic */ Studio f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ CloudPlace f$2;
    public final /* synthetic */ boolean f$3;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda8(Studio studio, Activity activity, CloudPlace cloudPlace, boolean z) {
        this.f$0 = studio;
        this.f$1 = activity;
        this.f$2 = cloudPlace;
        this.f$3 = z;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.upload$lambda$176$lambda$169(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
