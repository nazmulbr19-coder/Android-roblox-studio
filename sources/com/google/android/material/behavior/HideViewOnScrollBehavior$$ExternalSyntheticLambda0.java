package com.google.android.material.behavior;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/behavior/HideViewOnScrollBehavior;", method = "lambda$disableIfTouchExplorationEnabled$0", proto = "(Landroid/view/View;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class HideViewOnScrollBehavior$$ExternalSyntheticLambda0 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final /* synthetic */ HideViewOnScrollBehavior f$0;
    public final /* synthetic */ View f$1;

    public /* synthetic */ HideViewOnScrollBehavior$$ExternalSyntheticLambda0(HideViewOnScrollBehavior hideViewOnScrollBehavior, View view) {
        this.f$0 = hideViewOnScrollBehavior;
        this.f$1 = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        this.f$0.m320xa484d69d(this.f$1, z);
    }
}
