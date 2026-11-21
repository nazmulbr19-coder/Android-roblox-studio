package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.HashMap;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "customAvatar$lambda$70", proto = "(Landroid/app/Activity;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Landroid/view/View;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda69 implements View.OnClickListener {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ HashMap f$2;
    public final /* synthetic */ String f$3;
    public final /* synthetic */ View f$4;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda69(Activity activity, String str, HashMap hashMap, String str2, View view) {
        this.f$0 = activity;
        this.f$1 = str;
        this.f$2 = hashMap;
        this.f$3 = str2;
        this.f$4 = view;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        AccountUi.customAvatar$lambda$70(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
