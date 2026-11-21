package com.google.android.material.button;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.Comparator;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/button/MaterialButtonGroup;", method = "lambda$new$0", proto = "(Lcom/google/android/material/button/MaterialButton;Lcom/google/android/material/button/MaterialButton;)I")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class MaterialButtonGroup$$ExternalSyntheticLambda1 implements Comparator {
    public final /* synthetic */ MaterialButtonGroup f$0;

    public /* synthetic */ MaterialButtonGroup$$ExternalSyntheticLambda1(MaterialButtonGroup materialButtonGroup) {
        this.f$0 = materialButtonGroup;
    }

    @Override // java.util.Comparator
    public final int compare(Object obj, Object obj2) {
        return this.f$0.m329xa7af0300((MaterialButton) obj, (MaterialButton) obj2);
    }
}
