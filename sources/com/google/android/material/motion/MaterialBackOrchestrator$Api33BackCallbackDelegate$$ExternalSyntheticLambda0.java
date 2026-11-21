package com.google.android.material.motion;

import android.window.OnBackInvokedCallback;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/motion/MaterialBackHandler;", method = "handleBackInvoked", proto = "()V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda0 implements OnBackInvokedCallback {
    public final /* synthetic */ MaterialBackHandler f$0;

    public /* synthetic */ MaterialBackOrchestrator$Api33BackCallbackDelegate$$ExternalSyntheticLambda0(MaterialBackHandler materialBackHandler) {
        this.f$0 = materialBackHandler;
    }

    public final void onBackInvoked() {
        this.f$0.handleBackInvoked();
    }
}
