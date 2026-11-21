package com.google.android.material.search;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.appbar.AppBarLayout;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/search/SearchBarAnimationHelper;", method = "lambda$startExpandAnimation$0", proto = "(Lcom/google/android/material/search/SearchBar;Landroid/view/View;Lcom/google/android/material/appbar/AppBarLayout;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SearchBarAnimationHelper$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ SearchBarAnimationHelper f$0;
    public final /* synthetic */ SearchBar f$1;
    public final /* synthetic */ View f$2;
    public final /* synthetic */ AppBarLayout f$3;
    public final /* synthetic */ boolean f$4;

    public /* synthetic */ SearchBarAnimationHelper$$ExternalSyntheticLambda3(SearchBarAnimationHelper searchBarAnimationHelper, SearchBar searchBar, View view, AppBarLayout appBarLayout, boolean z) {
        this.f$0 = searchBarAnimationHelper;
        this.f$1 = searchBar;
        this.f$2 = view;
        this.f$3 = appBarLayout;
        this.f$4 = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m396x1b96b119(this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
