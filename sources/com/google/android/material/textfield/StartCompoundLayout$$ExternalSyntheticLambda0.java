package com.google.android.material.textfield;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.internal.CheckableImageButton;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/textfield/StartCompoundLayout;", method = "lambda$new$0", proto = "(Landroid/view/View;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class StartCompoundLayout$$ExternalSyntheticLambda0 implements CheckableImageButton.OnFocusableChangedListener {
    public final /* synthetic */ StartCompoundLayout f$0;

    public /* synthetic */ StartCompoundLayout$$ExternalSyntheticLambda0(StartCompoundLayout startCompoundLayout) {
        this.f$0 = startCompoundLayout;
    }

    @Override // com.google.android.material.internal.CheckableImageButton.OnFocusableChangedListener
    public final void onFocusableChanged(View view, boolean z) {
        this.f$0.m441xfae35022(view, z);
    }
}
