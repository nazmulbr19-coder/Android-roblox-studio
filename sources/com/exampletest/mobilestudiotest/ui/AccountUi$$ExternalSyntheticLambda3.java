package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "advanced$lambda$54", proto = "(Landroid/app/Activity;Landroid/widget/EditText;Landroid/widget/EditText;Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda3 implements DialogInterface.OnClickListener {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ EditText f$1;
    public final /* synthetic */ EditText f$2;
    public final /* synthetic */ Function0 f$3;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda3(Activity activity, EditText editText, EditText editText2, Function0 function0) {
        this.f$0 = activity;
        this.f$1 = editText;
        this.f$2 = editText2;
        this.f$3 = function0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AccountUi.advanced$lambda$54(this.f$0, this.f$1, this.f$2, this.f$3, dialogInterface, i);
    }
}
