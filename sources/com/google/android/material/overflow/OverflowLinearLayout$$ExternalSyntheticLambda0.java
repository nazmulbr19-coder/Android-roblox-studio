package com.google.android.material.overflow;

import android.view.MenuItem;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/overflow/OverflowLinearLayout;", method = "lambda$handleOverflowButtonClick$1", proto = "(Landroid/view/View;Landroid/view/MenuItem;Landroid/view/MenuItem;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class OverflowLinearLayout$$ExternalSyntheticLambda0 implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ MenuItem f$1;

    public /* synthetic */ OverflowLinearLayout$$ExternalSyntheticLambda0(View view, MenuItem menuItem) {
        this.f$0 = view;
        this.f$1 = menuItem;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return OverflowLinearLayout.lambda$handleOverflowButtonClick$1(this.f$0, this.f$1, menuItem);
    }
}
