package com.exampletest.mobilestudiotest.net;

import android.content.Context;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.concurrent.CountDownLatch;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/net/WebPermissions;", method = "allow$lambda$6", proto = "(Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/CountDownLatch;Ljava/lang/Boolean;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes6.dex */
public final /* synthetic */ class WebPermissions$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ CountDownLatch f$2;

    public /* synthetic */ WebPermissions$$ExternalSyntheticLambda2(Context context, String str, CountDownLatch countDownLatch) {
        this.f$0 = context;
        this.f$1 = str;
        this.f$2 = countDownLatch;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return WebPermissions.allow$lambda$6(this.f$0, this.f$1, this.f$2, (Boolean) obj);
    }
}
