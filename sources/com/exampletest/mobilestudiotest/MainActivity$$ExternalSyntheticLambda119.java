package com.exampletest.mobilestudiotest;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "writeTo$lambda$333$lambda$332", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Ljava/lang/Exception;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda119 implements Runnable {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ Exception f$1;
    public final /* synthetic */ boolean f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda119(MainActivity mainActivity, Exception exc, boolean z) {
        this.f$0 = mainActivity;
        this.f$1 = exc;
        this.f$2 = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainActivity.writeTo$lambda$333$lambda$332(this.f$0, this.f$1, this.f$2);
    }
}
