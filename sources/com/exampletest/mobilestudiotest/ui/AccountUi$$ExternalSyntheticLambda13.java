package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.widget.EditText;
import android.widget.Spinner;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "createNewGame$lambda$161$lambda$160$lambda$159", proto = "(Landroid/widget/EditText;Ljava/util/List;Landroid/widget/Spinner;Landroid/app/Activity;Landroid/widget/EditText;Lcom/exampletest/mobilestudiotest/core/Studio;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda13 implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ Spinner f$2;
    public final /* synthetic */ Activity f$3;
    public final /* synthetic */ EditText f$4;
    public final /* synthetic */ Studio f$5;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda13(EditText editText, List list, Spinner spinner, Activity activity, EditText editText2, Studio studio) {
        this.f$0 = editText;
        this.f$1 = list;
        this.f$2 = spinner;
        this.f$3 = activity;
        this.f$4 = editText2;
        this.f$5 = studio;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AccountUi.createNewGame$lambda$161$lambda$160$lambda$159(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, dialogInterface, i);
    }
}
