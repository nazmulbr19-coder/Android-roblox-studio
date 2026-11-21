package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "imgListener$lambda$3$lambda$2", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;Ljava/lang/String;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda2 implements Runnable {
    public final /* synthetic */ StartScreen f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda2(StartScreen startScreen, String str) {
        this.f$0 = startScreen;
        this.f$1 = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.imgListener$lambda$3$lambda$2(this.f$0, this.f$1);
    }
}
