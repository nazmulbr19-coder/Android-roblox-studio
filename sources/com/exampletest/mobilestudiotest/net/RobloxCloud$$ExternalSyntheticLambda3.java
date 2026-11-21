package com.exampletest.mobilestudiotest.net;

import android.content.Context;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import java.util.concurrent.Callable;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/net/RobloxCloud;", method = "games$lambda$24$lambda$23", proto = "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Group;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$GroupList;)Ljava/util/List;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes6.dex */
public final /* synthetic */ class RobloxCloud$$ExternalSyntheticLambda3 implements Callable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ RobloxCloud.Group f$1;
    public final /* synthetic */ RobloxCloud.GroupList f$2;

    public /* synthetic */ RobloxCloud$$ExternalSyntheticLambda3(Context context, RobloxCloud.Group group, RobloxCloud.GroupList groupList) {
        this.f$0 = context;
        this.f$1 = group;
        this.f$2 = groupList;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return RobloxCloud.games$lambda$24$lambda$23(this.f$0, this.f$1, this.f$2);
    }
}
