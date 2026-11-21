package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/RobloxServices;", method = "call$lambda$15", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class RobloxServices$$ExternalSyntheticLambda24 implements Runnable {
    public final /* synthetic */ Studio f$0;

    public /* synthetic */ RobloxServices$$ExternalSyntheticLambda24(Studio studio) {
        this.f$0 = studio;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RobloxServices.call$lambda$15(this.f$0);
    }
}
