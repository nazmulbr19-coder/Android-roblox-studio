package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "background$lambda$4", proto = "(Lkotlin/jvm/internal/Ref$BooleanRef;Landroid/content/DialogInterface;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda85 implements DialogInterface.OnCancelListener {
    public final /* synthetic */ Ref.BooleanRef f$0;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda85(Ref.BooleanRef booleanRef) {
        this.f$0 = booleanRef;
    }

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        AccountUi.background$lambda$4(this.f$0, dialogInterface);
    }
}
