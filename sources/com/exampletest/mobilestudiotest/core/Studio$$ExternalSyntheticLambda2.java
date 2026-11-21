package com.exampletest.mobilestudiotest.core;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/core/Studio;", method = "toast$lambda$10", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;Ljava/lang/String;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class Studio$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ Studio f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ Studio$$ExternalSyntheticLambda2(Studio studio, String str) {
        this.f$0 = studio;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Studio.toast$lambda$10(this.f$0, this.f$1);
    }
}
