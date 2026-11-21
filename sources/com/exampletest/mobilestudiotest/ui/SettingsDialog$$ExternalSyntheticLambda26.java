package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "show$lambda$43", proto = "(Lkotlin/jvm/internal/Ref$BooleanRef;Lcom/exampletest/mobilestudiotest/ui/MainActions;Landroid/content/DialogInterface;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda26 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ Ref.BooleanRef f$0;
    public final /* synthetic */ MainActions f$1;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda26(Ref.BooleanRef booleanRef, MainActions mainActions) {
        this.f$0 = booleanRef;
        this.f$1 = mainActions;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        SettingsDialog.show$lambda$43(this.f$0, this.f$1, dialogInterface);
    }
}
