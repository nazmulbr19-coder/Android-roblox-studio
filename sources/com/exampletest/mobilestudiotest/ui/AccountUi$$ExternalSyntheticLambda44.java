package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "createNewGame$lambda$161$lambda$160$lambda$159$lambda$157", proto = "(Landroid/app/Activity;Ljava/lang/String;JLandroid/widget/EditText;)Lkotlin/Pair;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda44 implements Function0 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ long f$2;
    public final /* synthetic */ EditText f$3;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda44(Activity activity, String str, long j, EditText editText) {
        this.f$0 = activity;
        this.f$1 = str;
        this.f$2 = j;
        this.f$3 = editText;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.createNewGame$lambda$161$lambda$160$lambda$159$lambda$157(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
