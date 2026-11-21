package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import org.json.JSONObject;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "customAvatar$lambda$81$lambda$80$lambda$79$lambda$78", proto = "(Landroid/app/Activity;Lorg/json/JSONObject;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda102 implements Runnable {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ JSONObject f$1;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda102(Activity activity, JSONObject jSONObject) {
        this.f$0 = activity;
        this.f$1 = jSONObject;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AccountUi.customAvatar$lambda$81$lambda$80$lambda$79$lambda$78(this.f$0, this.f$1);
    }
}
