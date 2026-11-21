package com.exampletest.mobilestudiotest.core;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/core/Studio;", method = "pruneSelection$lambda$63", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class Studio$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ Studio f$0;

    public /* synthetic */ Studio$$ExternalSyntheticLambda4(Studio studio) {
        this.f$0 = studio;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Studio.pruneSelection$lambda$63(this.f$0);
    }
}
