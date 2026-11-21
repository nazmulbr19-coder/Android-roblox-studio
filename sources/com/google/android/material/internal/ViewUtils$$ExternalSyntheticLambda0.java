package com.google.android.material.internal;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/internal/ViewUtils;", method = "lambda$requestFocusAndShowKeyboard$0", proto = "(Landroid/view/View;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class ViewUtils$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ View f$0;
    public final /* synthetic */ boolean f$1;

    public /* synthetic */ ViewUtils$$ExternalSyntheticLambda0(View view, boolean z) {
        this.f$0 = view;
        this.f$1 = z;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ViewUtils.lambda$requestFocusAndShowKeyboard$0(this.f$0, this.f$1);
    }
}
