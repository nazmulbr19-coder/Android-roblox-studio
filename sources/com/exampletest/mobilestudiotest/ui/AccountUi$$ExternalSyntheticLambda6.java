package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "customAvatar$lambda$81$lambda$80$lambda$79", proto = "(Ljava/util/List;Landroid/app/Activity;Lorg/json/JSONObject;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda6 implements Function1 {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ Activity f$1;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda6(List list, Activity activity) {
        this.f$0 = list;
        this.f$1 = activity;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.customAvatar$lambda$81$lambda$80$lambda$79(this.f$0, this.f$1, (JSONObject) obj);
    }
}
