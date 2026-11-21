package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "currentPlaceHistory$lambda$168$lambda$167", proto = "(Ljava/util/List;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda108 implements DialogInterface.OnClickListener {
    public final /* synthetic */ List f$0;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda108(List list) {
        this.f$0 = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AccountUi.currentPlaceHistory$lambda$168$lambda$167(this.f$0, dialogInterface, i);
    }
}
