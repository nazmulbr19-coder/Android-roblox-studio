package com.google.android.material.navigation;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.motion.MaterialBackOrchestrator;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/motion/MaterialBackOrchestrator;", method = "startListeningForBackCallbacksWithPriorityOverlay", proto = "()V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class NavigationView$1$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ MaterialBackOrchestrator f$0;

    public /* synthetic */ NavigationView$1$$ExternalSyntheticLambda0(MaterialBackOrchestrator materialBackOrchestrator) {
        this.f$0 = materialBackOrchestrator;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.startListeningForBackCallbacksWithPriorityOverlay();
    }
}
