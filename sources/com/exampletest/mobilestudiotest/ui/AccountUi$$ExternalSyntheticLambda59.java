package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.Accounts;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "show$lambda$26", proto = "(Lkotlin/jvm/internal/Ref$ObjectRef;Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/net/Accounts$Account;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda59 implements Function0 {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ Accounts.Account f$2;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda59(Ref.ObjectRef objectRef, Activity activity, Accounts.Account account) {
        this.f$0 = objectRef;
        this.f$1 = activity;
        this.f$2 = account;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AccountUi.show$lambda$26(this.f$0, this.f$1, this.f$2);
    }
}
