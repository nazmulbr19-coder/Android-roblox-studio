package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "upload$lambda$176$lambda$175$lambda$172", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/net/CloudPlace;ZLkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda21 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Studio f$1;
    public final /* synthetic */ CloudPlace f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ Function0 f$4;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda21(Activity activity, Studio studio, CloudPlace cloudPlace, boolean z, Function0 function0) {
        this.f$0 = activity;
        this.f$1 = studio;
        this.f$2 = cloudPlace;
        this.f$3 = z;
        this.f$4 = function0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AccountUi.upload$lambda$176$lambda$175$lambda$172(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, dialogInterface, i);
    }
}
