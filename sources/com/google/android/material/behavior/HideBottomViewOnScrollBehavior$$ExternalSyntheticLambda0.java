package com.google.android.material.behavior;

import android.view.View;
import android.view.accessibility.AccessibilityManager;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/behavior/HideBottomViewOnScrollBehavior;", method = "lambda$disableIfTouchExplorationEnabled$0", proto = "(Landroid/view/View;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class HideBottomViewOnScrollBehavior$$ExternalSyntheticLambda0 implements AccessibilityManager.TouchExplorationStateChangeListener {
    public final /* synthetic */ HideBottomViewOnScrollBehavior f$0;
    public final /* synthetic */ View f$1;

    public /* synthetic */ HideBottomViewOnScrollBehavior$$ExternalSyntheticLambda0(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, View view) {
        this.f$0 = hideBottomViewOnScrollBehavior;
        this.f$1 = view;
    }

    @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
    public final void onTouchExplorationStateChanged(boolean z) {
        this.f$0.m319x79d795e8(this.f$1, z);
    }
}
