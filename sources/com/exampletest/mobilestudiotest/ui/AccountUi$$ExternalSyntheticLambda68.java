package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "downloadPlace$lambda$117", proto = "(Lcom/exampletest/mobilestudiotest/ui/MainActions;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;Ljava/lang/Integer;[B)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda68 implements Function1 {
    public final /* synthetic */ MainActions f$0;
    public final /* synthetic */ RobloxCloud.Place f$1;
    public final /* synthetic */ Integer f$2;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda68(MainActions mainActions, RobloxCloud.Place place, Integer num) {
        this.f$0 = mainActions;
        this.f$1 = place;
        this.f$2 = num;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return AccountUi.downloadPlace$lambda$117(this.f$0, this.f$1, this.f$2, (byte[]) obj);
    }
}
