package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.app.AlertDialog;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "myGames$lambda$96$lambda$95$lambda$94", proto = "(Lkotlin/jvm/functions/Function2;Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/ui/MainActions;Landroid/app/AlertDialog$Builder;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda20 implements Function1 {
    public final /* synthetic */ Function2 f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ Studio f$2;
    public final /* synthetic */ MainActions f$3;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda20(Function2 function2, Activity activity, Studio studio, MainActions mainActions) {
        this.f$0 = function2;
        this.f$1 = activity;
        this.f$2 = studio;
        this.f$3 = mainActions;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.myGames$lambda$96$lambda$95$lambda$94(this.f$0, this.f$1, this.f$2, this.f$3, (AlertDialog.Builder) obj);
    }
}
