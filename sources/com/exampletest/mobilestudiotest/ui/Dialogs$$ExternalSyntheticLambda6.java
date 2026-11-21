package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/Dialogs;", method = "editValue$lambda$32", proto = "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class Dialogs$$ExternalSyntheticLambda6 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ Dialogs$$ExternalSyntheticLambda6(Function1 function1, Function0 function0) {
        this.f$0 = function1;
        this.f$1 = function0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialogs.editValue$lambda$32(this.f$0, this.f$1, dialogInterface, i);
    }
}
