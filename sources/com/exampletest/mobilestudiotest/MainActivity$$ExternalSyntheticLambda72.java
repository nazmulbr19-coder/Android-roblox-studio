package com.exampletest.mobilestudiotest;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "confirmDiscard$lambda$298", proto = "(Lcom/exampletest/mobilestudiotest/net/CloudPlace;Lcom/exampletest/mobilestudiotest/MainActivity;Lkotlin/jvm/functions/Function0;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda72 implements DialogInterface.OnClickListener {
    public final /* synthetic */ CloudPlace f$0;
    public final /* synthetic */ MainActivity f$1;
    public final /* synthetic */ Function0 f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda72(CloudPlace cloudPlace, MainActivity mainActivity, Function0 function0) {
        this.f$0 = cloudPlace;
        this.f$1 = mainActivity;
        this.f$2 = function0;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MainActivity.confirmDiscard$lambda$298(this.f$0, this.f$1, this.f$2, dialogInterface, i);
    }
}
