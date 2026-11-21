package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "signIn$check$lambda$60", proto = "(Landroid/app/Activity;Lkotlin/jvm/functions/Function0;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$User;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda57 implements Function1 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Function0 f$1;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda57(Activity activity, Function0 function0) {
        this.f$0 = activity;
        this.f$1 = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.signIn$check$lambda$60(this.f$0, this.f$1, (RobloxCloud.User) obj);
    }
}
