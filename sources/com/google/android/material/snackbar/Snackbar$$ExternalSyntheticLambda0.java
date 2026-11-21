package com.google.android.material.snackbar;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/snackbar/Snackbar;", method = "lambda$setAction$0", proto = "(Landroid/view/View$OnClickListener;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Snackbar$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ Snackbar f$0;
    public final /* synthetic */ View.OnClickListener f$1;

    public /* synthetic */ Snackbar$$ExternalSyntheticLambda0(Snackbar snackbar, View.OnClickListener onClickListener) {
        this.f$0 = snackbar;
        this.f$1 = onClickListener;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.f$0.m424lambda$setAction$0$comgoogleandroidmaterialsnackbarSnackbar(this.f$1, view);
    }
}
