package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/Dialogs;", method = "confirm$lambda$45", proto = "(Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class Dialogs$$ExternalSyntheticLambda16 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ Dialogs$$ExternalSyntheticLambda16(Function0 function0) {
        this.f$0 = function0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialogs.confirm$lambda$45(this.f$0, dialogInterface, i);
    }
}
