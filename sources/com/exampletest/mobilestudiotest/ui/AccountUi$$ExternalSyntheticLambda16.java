package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "listDialog$lambda$83", proto = "(Lcom/exampletest/mobilestudiotest/ui/AccountUi$listDialog$adapter$1;Ljava/lang/String;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda16 implements Function1 {
    public final /* synthetic */ AccountUi$listDialog$adapter$1 f$0;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda16(AccountUi$listDialog$adapter$1 accountUi$listDialog$adapter$1) {
        this.f$0 = accountUi$listDialog$adapter$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.listDialog$lambda$83(this.f$0, (String) obj);
    }
}
