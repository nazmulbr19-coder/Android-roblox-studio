package com.exampletest.mobilestudiotest.net;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/net/WebPermissions;", method = "allow$lambda$4", proto = "(Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/lang/String;)Ljava/util/concurrent/CountDownLatch;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes6.dex */
public final /* synthetic */ class WebPermissions$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ Ref.BooleanRef f$0;

    public /* synthetic */ WebPermissions$$ExternalSyntheticLambda0(Ref.BooleanRef booleanRef) {
        this.f$0 = booleanRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return WebPermissions.allow$lambda$4(this.f$0, (String) obj);
    }
}
