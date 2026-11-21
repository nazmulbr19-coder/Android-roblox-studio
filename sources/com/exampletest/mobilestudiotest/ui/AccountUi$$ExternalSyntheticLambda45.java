package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "createNewGame$lambda$161$lambda$160$lambda$159$lambda$158", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/core/Studio;Lkotlin/Pair;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda45 implements Function1 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Studio f$1;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda45(Activity activity, Studio studio) {
        this.f$0 = activity;
        this.f$1 = studio;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.createNewGame$lambda$161$lambda$160$lambda$159$lambda$158(this.f$0, this.f$1, (Pair) obj);
    }
}
