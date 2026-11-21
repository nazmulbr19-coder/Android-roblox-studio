package com.google.android.material.button;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/button/MaterialButton;", method = "lambda$maybeRunAfterWidthAnimation$0", proto = "(Ljava/lang/Runnable;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class MaterialButton$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ MaterialButton f$0;
    public final /* synthetic */ Runnable f$1;

    public /* synthetic */ MaterialButton$$ExternalSyntheticLambda1(MaterialButton materialButton, Runnable runnable) {
        this.f$0 = materialButton;
        this.f$1 = runnable;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m322x69e9bdf6(this.f$1);
    }
}
