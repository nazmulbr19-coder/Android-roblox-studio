package com.google.android.material.search;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/search/SearchViewAnimationHelper;", method = "hide", proto = "()Landroid/animation/AnimatorSet;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SearchView$$ExternalSyntheticLambda12 implements Runnable {
    public final /* synthetic */ SearchViewAnimationHelper f$0;

    public /* synthetic */ SearchView$$ExternalSyntheticLambda12(SearchViewAnimationHelper searchViewAnimationHelper) {
        this.f$0 = searchViewAnimationHelper;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.hide();
    }
}
