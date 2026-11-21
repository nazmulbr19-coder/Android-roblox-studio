package com.google.android.material.overflow;

import android.view.View;
import androidx.appcompat.widget.PopupMenu;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/overflow/OverflowLinearLayout;", method = "lambda$new$0", proto = "(Landroidx/appcompat/widget/PopupMenu;ILandroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class OverflowLinearLayout$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ OverflowLinearLayout f$0;
    public final /* synthetic */ PopupMenu f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ OverflowLinearLayout$$ExternalSyntheticLambda1(OverflowLinearLayout overflowLinearLayout, PopupMenu popupMenu, int i) {
        this.f$0 = overflowLinearLayout;
        this.f$1 = popupMenu;
        this.f$2 = i;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f$0.m391xc4d03947(this.f$1, this.f$2, view);
    }
}
