package com.exampletest.mobilestudiotest;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "iconListener$lambda$2$lambda$1", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda57 implements Runnable {
    public final /* synthetic */ MainActivity f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda57(MainActivity mainActivity) {
        this.f$0 = mainActivity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainActivity.iconListener$lambda$2$lambda$1(this.f$0);
    }
}
