package com.google.android.material.search;

import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.WindowInsetsCompat;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/search/SearchView;", method = "lambda$setUpDividerInsetListener$7", proto = "(Landroid/view/ViewGroup$MarginLayoutParams;IILandroid/view/View;Landroidx/core/view/WindowInsetsCompat;)Landroidx/core/view/WindowInsetsCompat;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class SearchView$$ExternalSyntheticLambda1 implements OnApplyWindowInsetsListener {
    public final /* synthetic */ ViewGroup.MarginLayoutParams f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ SearchView$$ExternalSyntheticLambda1(ViewGroup.MarginLayoutParams marginLayoutParams, int i, int i2) {
        this.f$0 = marginLayoutParams;
        this.f$1 = i;
        this.f$2 = i2;
    }

    @Override // androidx.core.view.OnApplyWindowInsetsListener
    public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
        return SearchView.lambda$setUpDividerInsetListener$7(this.f$0, this.f$1, this.f$2, view, windowInsetsCompat);
    }
}
