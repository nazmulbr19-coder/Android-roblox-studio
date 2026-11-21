package com.google.android.material.datepicker;

import android.view.View;
import android.widget.EditText;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/datepicker/DateSelector;", method = "lambda$showKeyboardWithAutoHideBehavior$0", proto = "([Landroid/widget/EditText;Landroid/view/View;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class DateSelector$$ExternalSyntheticLambda0 implements View.OnFocusChangeListener {
    public final /* synthetic */ EditText[] f$0;

    public /* synthetic */ DateSelector$$ExternalSyntheticLambda0(EditText[] editTextArr) {
        this.f$0 = editTextArr;
    }

    @Override // android.view.View.OnFocusChangeListener
    public final void onFocusChange(View view, boolean z) {
        DateSelector.lambda$showKeyboardWithAutoHideBehavior$0(this.f$0, view, z);
    }
}
