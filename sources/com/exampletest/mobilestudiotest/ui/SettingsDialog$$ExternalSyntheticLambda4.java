package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "editTheme$lambda$81", proto = "(Landroid/widget/EditText;Landroid/content/Context;Lkotlin/jvm/internal/Ref$ObjectRef;Lcom/exampletest/mobilestudiotest/ui/MainActions;Ljava/lang/String;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda4 implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText f$0;
    public final /* synthetic */ Context f$1;
    public final /* synthetic */ Ref.ObjectRef f$2;
    public final /* synthetic */ MainActions f$3;
    public final /* synthetic */ String f$4;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda4(EditText editText, Context context, Ref.ObjectRef objectRef, MainActions mainActions, String str) {
        this.f$0 = editText;
        this.f$1 = context;
        this.f$2 = objectRef;
        this.f$3 = mainActions;
        this.f$4 = str;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        SettingsDialog.editTheme$lambda$81(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, dialogInterface, i);
    }
}
