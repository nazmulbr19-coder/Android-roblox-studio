package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "myGames$lambda$96$lambda$95$lambda$94$lambda$92", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/ui/MainActions;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda14 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Studio f$1;
    public final /* synthetic */ MainActions f$2;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda14(Activity activity, Studio studio, MainActions mainActions) {
        this.f$0 = activity;
        this.f$1 = studio;
        this.f$2 = mainActions;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AccountUi.myGames$lambda$96$lambda$95$lambda$94$lambda$92(this.f$0, this.f$1, this.f$2, dialogInterface, i);
    }
}
