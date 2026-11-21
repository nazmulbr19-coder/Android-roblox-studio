package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.HashMap;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "customAvatar$lambda$74", proto = "(Ljava/util/HashMap;Landroid/widget/EditText;Landroid/widget/EditText;Landroid/widget/EditText;Landroid/widget/EditText;Landroid/widget/EditText;Landroid/app/Activity;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda70 implements DialogInterface.OnClickListener {
    public final /* synthetic */ HashMap f$0;
    public final /* synthetic */ EditText f$1;
    public final /* synthetic */ EditText f$2;
    public final /* synthetic */ EditText f$3;
    public final /* synthetic */ EditText f$4;
    public final /* synthetic */ EditText f$5;
    public final /* synthetic */ Activity f$6;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda70(HashMap hashMap, EditText editText, EditText editText2, EditText editText3, EditText editText4, EditText editText5, Activity activity) {
        this.f$0 = hashMap;
        this.f$1 = editText;
        this.f$2 = editText2;
        this.f$3 = editText3;
        this.f$4 = editText4;
        this.f$5 = editText5;
        this.f$6 = activity;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AccountUi.customAvatar$lambda$74(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, dialogInterface, i);
    }
}
