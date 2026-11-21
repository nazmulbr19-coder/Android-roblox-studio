package com.exampletest.mobilestudiotest.net;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.function.Function;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/net/WebPermissions;", method = "allow$lambda$5", proto = "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Ljava/util/concurrent/CountDownLatch;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes6.dex */
public final /* synthetic */ class WebPermissions$$ExternalSyntheticLambda1 implements Function {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ WebPermissions$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // java.util.function.Function
    public final Object apply(Object obj) {
        return WebPermissions.allow$lambda$5(this.f$0, obj);
    }
}
