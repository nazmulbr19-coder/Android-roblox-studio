package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.Accounts;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "show$lambda$26$lambda$25", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/net/Accounts$Account;Ljava/lang/Throwable;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda93 implements Function1 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ Accounts.Account f$1;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda93(Activity activity, Accounts.Account account) {
        this.f$0 = activity;
        this.f$1 = account;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(AccountUi.show$lambda$26$lambda$25(this.f$0, this.f$1, (Throwable) obj));
    }
}
