package com.exampletest.mobilestudiotest.core;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Instance;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/core/PluginManager;", method = "load$lambda$14", proto = "(Lcom/exampletest/mobilestudiotest/core/PluginManager;Lcom/exampletest/mobilestudiotest/model/Instance;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class PluginManager$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ PluginManager f$0;
    public final /* synthetic */ Instance f$1;

    public /* synthetic */ PluginManager$$ExternalSyntheticLambda1(PluginManager pluginManager, Instance instance) {
        this.f$0 = pluginManager;
        this.f$1 = instance;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PluginManager.load$lambda$14(this.f$0, this.f$1);
    }
}
