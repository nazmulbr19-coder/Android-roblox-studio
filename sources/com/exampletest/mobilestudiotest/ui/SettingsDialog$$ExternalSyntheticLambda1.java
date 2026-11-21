package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "pickFlySpeed$lambda$88", proto = "(Lkotlin/jvm/functions/Function0;Landroid/content/Context;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda1 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda1(Function0 function0, Context context) {
        this.f$0 = function0;
        this.f$1 = context;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SettingsDialog.pickFlySpeed$lambda$88(this.f$0, this.f$1, dialogInterface, i);
    }
}
