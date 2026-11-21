package com.google.android.material.chip;

import android.widget.CompoundButton;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/chip/Chip;", method = "lambda$new$0", proto = "(Landroid/widget/CompoundButton;Z)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class Chip$$ExternalSyntheticLambda0 implements CompoundButton.OnCheckedChangeListener {
    public final /* synthetic */ Chip f$0;

    public /* synthetic */ Chip$$ExternalSyntheticLambda0(Chip chip) {
        this.f$0 = chip;
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        this.f$0.m334lambda$new$0$comgoogleandroidmaterialchipChip(compoundButton, z);
    }
}
