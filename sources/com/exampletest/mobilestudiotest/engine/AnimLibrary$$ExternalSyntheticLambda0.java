package com.exampletest.mobilestudiotest.engine;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/engine/AnimLibrary;", method = "get$lambda$4", proto = "(J)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class AnimLibrary$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ long f$0;

    public /* synthetic */ AnimLibrary$$ExternalSyntheticLambda0(long j) {
        this.f$0 = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnimLibrary.get$lambda$4(this.f$0);
    }
}
