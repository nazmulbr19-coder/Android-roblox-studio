package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "upload$lambda$176$lambda$170", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/net/CloudPlace;ZLandroid/app/Activity;Lkotlin/jvm/functions/Function0;Lkotlin/Pair;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda9 implements Function1 {
    public final /* synthetic */ Studio f$0;
    public final /* synthetic */ CloudPlace f$1;
    public final /* synthetic */ boolean f$2;
    public final /* synthetic */ Activity f$3;
    public final /* synthetic */ Function0 f$4;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda9(Studio studio, CloudPlace cloudPlace, boolean z, Activity activity, Function0 function0) {
        this.f$0 = studio;
        this.f$1 = cloudPlace;
        this.f$2 = z;
        this.f$3 = activity;
        this.f$4 = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.upload$lambda$176$lambda$170(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Pair) obj);
    }
}
