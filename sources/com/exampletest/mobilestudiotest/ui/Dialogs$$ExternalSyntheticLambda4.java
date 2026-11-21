package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/Dialogs;", method = "editValue$lambda$5", proto = "(Lkotlin/jvm/functions/Function1;Ljava/util/List;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class Dialogs$$ExternalSyntheticLambda4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ Dialogs$$ExternalSyntheticLambda4(Function1 function1, List list) {
        this.f$0 = function1;
        this.f$1 = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialogs.editValue$lambda$5(this.f$0, this.f$1, dialogInterface, i);
    }
}
