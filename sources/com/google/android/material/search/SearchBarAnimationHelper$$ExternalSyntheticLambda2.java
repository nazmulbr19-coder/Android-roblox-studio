package com.google.android.material.search;

import android.animation.Animator;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.animation.AnimatableView;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Landroid/animation/Animator;", method = "start", proto = "()V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SearchBarAnimationHelper$$ExternalSyntheticLambda2 implements AnimatableView.Listener {
    public final /* synthetic */ Animator f$0;

    public /* synthetic */ SearchBarAnimationHelper$$ExternalSyntheticLambda2(Animator animator) {
        this.f$0 = animator;
    }

    @Override // com.google.android.material.animation.AnimatableView.Listener
    public final void onAnimationEnd() {
        SearchBarAnimationHelper.$r8$lambda$1r7Y4hRSo4F1Esrbw5SdK9GHD3Q(this.f$0);
    }
}
