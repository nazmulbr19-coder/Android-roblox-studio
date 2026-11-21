package com.google.android.material.button;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.button.MaterialButton;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/button/MaterialSplitButton;", method = "lambda$addView$0", proto = "(Lcom/google/android/material/button/MaterialButton;Lcom/google/android/material/button/MaterialButton;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class MaterialSplitButton$$ExternalSyntheticLambda0 implements MaterialButton.OnCheckedChangeListener {
    public final /* synthetic */ MaterialSplitButton f$0;
    public final /* synthetic */ MaterialButton f$1;

    public /* synthetic */ MaterialSplitButton$$ExternalSyntheticLambda0(MaterialSplitButton materialSplitButton, MaterialButton materialButton) {
        this.f$0 = materialSplitButton;
        this.f$1 = materialButton;
    }

    @Override // com.google.android.material.button.MaterialButton.OnCheckedChangeListener
    public final void onCheckedChanged(MaterialButton materialButton, boolean z) {
        this.f$0.m330xf376ee79(this.f$1, materialButton, z);
    }
}
