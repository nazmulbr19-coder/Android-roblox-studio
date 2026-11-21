package com.exampletest.mobilestudiotest.net;

import android.content.Context;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/net/RobloxCloud;", method = "games$lambda$21", proto = "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$User;)Ljava/util/List;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes6.dex */
public final /* synthetic */ class RobloxCloud$$ExternalSyntheticLambda2 implements Callable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ RobloxCloud.User f$1;

    public /* synthetic */ RobloxCloud$$ExternalSyntheticLambda2(Context context, RobloxCloud.User user) {
        this.f$0 = context;
        this.f$1 = user;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return RobloxCloud.games$lambda$21(this.f$0, this.f$1);
    }
}
