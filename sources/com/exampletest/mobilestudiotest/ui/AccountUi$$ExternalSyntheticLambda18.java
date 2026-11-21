package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.ArrayList;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "listDialog$lambda$87", proto = "(Ljava/util/ArrayList;Landroid/content/DialogInterface;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda18 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ ArrayList f$0;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda18(ArrayList arrayList) {
        this.f$0 = arrayList;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        AccountUi.listDialog$lambda$87(this.f$0, dialogInterface);
    }
}
