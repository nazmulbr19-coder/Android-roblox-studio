package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import android.widget.TextView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "choice$lambda$59$lambda$58", proto = "(Lkotlin/jvm/internal/Ref$IntRef;Landroid/widget/TextView;Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda6 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Ref.IntRef f$0;
    public final /* synthetic */ TextView f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ Function1 f$3;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda6(Ref.IntRef intRef, TextView textView, List list, Function1 function1) {
        this.f$0 = intRef;
        this.f$1 = textView;
        this.f$2 = list;
        this.f$3 = function1;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SettingsDialog.choice$lambda$59$lambda$58(this.f$0, this.f$1, this.f$2, this.f$3, dialogInterface, i);
    }
}
