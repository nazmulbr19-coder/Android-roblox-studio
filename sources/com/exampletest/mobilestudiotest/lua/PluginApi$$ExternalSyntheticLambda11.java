package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.model.Instance;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/PluginApi;", method = "call$lambda$2$lambda$1", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/model/Instance;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class PluginApi$$ExternalSyntheticLambda11 implements Runnable {
    public final /* synthetic */ Studio f$0;
    public final /* synthetic */ Instance f$1;

    public /* synthetic */ PluginApi$$ExternalSyntheticLambda11(Studio studio, Instance instance) {
        this.f$0 = studio;
        this.f$1 = instance;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PluginApi.call$lambda$2$lambda$1(this.f$0, this.f$1);
    }
}
