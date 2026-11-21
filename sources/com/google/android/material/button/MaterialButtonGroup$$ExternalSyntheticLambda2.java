package com.google.android.material.button;

import android.view.MenuItem;
import android.widget.Button;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/button/MaterialButtonGroup;", method = "lambda$addMenuItemForButton$2", proto = "(Landroid/widget/Button;Landroid/view/MenuItem;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class MaterialButtonGroup$$ExternalSyntheticLambda2 implements MenuItem.OnMenuItemClickListener {
    public final /* synthetic */ Button f$0;

    public /* synthetic */ MaterialButtonGroup$$ExternalSyntheticLambda2(Button button) {
        this.f$0 = button;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return MaterialButtonGroup.lambda$addMenuItemForButton$2(this.f$0, menuItem);
    }
}
