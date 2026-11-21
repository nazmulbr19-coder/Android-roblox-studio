package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "editTheme$lambda$83", proto = "(Ljava/lang/String;Lcom/exampletest/mobilestudiotest/ui/MainActions;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda5 implements DialogInterface.OnClickListener {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ MainActions f$1;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda5(String str, MainActions mainActions) {
        this.f$0 = str;
        this.f$1 = mainActions;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SettingsDialog.editTheme$lambda$83(this.f$0, this.f$1, dialogInterface, i);
    }
}
