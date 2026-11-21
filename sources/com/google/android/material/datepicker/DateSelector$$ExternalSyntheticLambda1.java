package com.google.android.material.datepicker;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/datepicker/DateSelector;", method = "lambda$showKeyboardWithAutoHideBehavior$1", proto = "(Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class DateSelector$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ View f$0;

    public /* synthetic */ DateSelector$$ExternalSyntheticLambda1(View view) {
        this.f$0 = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        DateSelector.lambda$showKeyboardWithAutoHideBehavior$1(this.f$0);
    }
}
