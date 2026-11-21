package com.exampletest.mobilestudiotest.core;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/core/PluginManager;", method = "loadAll$lambda$11", proto = "(ILcom/exampletest/mobilestudiotest/core/PluginManager;Ljava/util/List;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class PluginManager$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ PluginManager f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ PluginManager$$ExternalSyntheticLambda2(int i, PluginManager pluginManager, List list) {
        this.f$0 = i;
        this.f$1 = pluginManager;
        this.f$2 = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PluginManager.loadAll$lambda$11(this.f$0, this.f$1, this.f$2);
    }
}
