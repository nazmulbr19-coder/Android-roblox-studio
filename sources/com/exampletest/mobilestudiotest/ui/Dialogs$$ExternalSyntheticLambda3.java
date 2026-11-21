package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/Dialogs;", method = "colorPicker$lambda$44", proto = "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/internal/Ref$IntRef;Lkotlin/jvm/internal/Ref$IntRef;Lkotlin/jvm/internal/Ref$IntRef;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class Dialogs$$ExternalSyntheticLambda3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ Ref.IntRef f$1;
    public final /* synthetic */ Ref.IntRef f$2;
    public final /* synthetic */ Ref.IntRef f$3;

    public /* synthetic */ Dialogs$$ExternalSyntheticLambda3(Function1 function1, Ref.IntRef intRef, Ref.IntRef intRef2, Ref.IntRef intRef3) {
        this.f$0 = function1;
        this.f$1 = intRef;
        this.f$2 = intRef2;
        this.f$3 = intRef3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Dialogs.colorPicker$lambda$44(this.f$0, this.f$1, this.f$2, this.f$3, dialogInterface, i);
    }
}
