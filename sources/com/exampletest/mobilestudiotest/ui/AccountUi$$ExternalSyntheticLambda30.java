package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.app.AlertDialog;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "versionHistory$lambda$128$lambda$127", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/ui/MainActions;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;Landroid/app/AlertDialog$Builder;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda30 implements Function1 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ MainActions f$1;
    public final /* synthetic */ RobloxCloud.Place f$2;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda30(Activity activity, MainActions mainActions, RobloxCloud.Place place) {
        this.f$0 = activity;
        this.f$1 = mainActions;
        this.f$2 = place;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.versionHistory$lambda$128$lambda$127(this.f$0, this.f$1, this.f$2, (AlertDialog.Builder) obj);
    }
}
