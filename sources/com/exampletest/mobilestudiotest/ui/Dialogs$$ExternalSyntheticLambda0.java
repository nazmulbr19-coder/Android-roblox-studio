package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/Dialogs;", method = "prompt$lambda$47", proto = "(Lkotlin/jvm/functions/Function1;Landroid/widget/EditText;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class Dialogs$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ EditText f$1;

    public /* synthetic */ Dialogs$$ExternalSyntheticLambda0(Function1 function1, EditText editText) {
        this.f$0 = function1;
        this.f$1 = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialogs.prompt$lambda$47(this.f$0, this.f$1, dialogInterface, i);
    }
}
