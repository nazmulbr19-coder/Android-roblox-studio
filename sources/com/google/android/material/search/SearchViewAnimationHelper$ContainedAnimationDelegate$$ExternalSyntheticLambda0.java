package com.google.android.material.search;

import androidx.appcompat.widget.Toolbar;
import androidx.dynamicanimation.animation.DynamicAnimation;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.search.SearchViewAnimationHelper;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/search/SearchViewAnimationHelper$ContainedAnimationDelegate;", method = "lambda$getToolbarWidthSpringAnimation$3", proto = "(ZLandroidx/appcompat/widget/Toolbar;Landroidx/dynamicanimation/animation/DynamicAnimation;ZFF)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda0 implements DynamicAnimation.OnAnimationEndListener {
    public final /* synthetic */ SearchViewAnimationHelper.ContainedAnimationDelegate f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ Toolbar f$2;

    public /* synthetic */ SearchViewAnimationHelper$ContainedAnimationDelegate$$ExternalSyntheticLambda0(SearchViewAnimationHelper.ContainedAnimationDelegate containedAnimationDelegate, boolean z, Toolbar toolbar) {
        this.f$0 = containedAnimationDelegate;
        this.f$1 = z;
        this.f$2 = toolbar;
    }

    @Override // androidx.dynamicanimation.animation.DynamicAnimation.OnAnimationEndListener
    public final void onAnimationEnd(DynamicAnimation dynamicAnimation, boolean z, float f, float f2) {
        this.f$0.m412xf6aa07b8(this.f$1, this.f$2, dynamicAnimation, z, f, f2);
    }
}
