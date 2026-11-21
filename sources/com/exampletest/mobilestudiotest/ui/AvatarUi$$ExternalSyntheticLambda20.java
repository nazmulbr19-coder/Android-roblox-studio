package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AvatarUi;", method = "playtestAvatar$lambda$21", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/core/Studio;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AvatarUi$$ExternalSyntheticLambda20 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Studio f$1;

    public /* synthetic */ AvatarUi$$ExternalSyntheticLambda20(Activity activity, Studio studio) {
        this.f$0 = activity;
        this.f$1 = studio;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AvatarUi.playtestAvatar$lambda$21(this.f$0, this.f$1, dialogInterface, i);
    }
}
