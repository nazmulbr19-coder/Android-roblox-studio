package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.net.CloudPlace;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "upload$lambda$176$lambda$175$lambda$174", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/net/CloudPlace;Lcom/exampletest/mobilestudiotest/core/Studio;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda22 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ CloudPlace f$1;
    public final /* synthetic */ Studio f$2;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda22(Activity activity, CloudPlace cloudPlace, Studio studio) {
        this.f$0 = activity;
        this.f$1 = cloudPlace;
        this.f$2 = studio;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AccountUi.upload$lambda$176$lambda$175$lambda$174(this.f$0, this.f$1, this.f$2, dialogInterface, i);
    }
}
