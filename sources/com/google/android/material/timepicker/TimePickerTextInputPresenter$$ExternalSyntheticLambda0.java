package com.google.android.material.timepicker;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.google.android.material.button.MaterialButtonToggleGroup;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/timepicker/TimePickerTextInputPresenter;", method = "lambda$setupPeriodToggle$1", proto = "(Lcom/google/android/material/button/MaterialButtonToggleGroup;IZ)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class TimePickerTextInputPresenter$$ExternalSyntheticLambda0 implements MaterialButtonToggleGroup.OnButtonCheckedListener {
    public final /* synthetic */ TimePickerTextInputPresenter f$0;

    public /* synthetic */ TimePickerTextInputPresenter$$ExternalSyntheticLambda0(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        this.f$0 = timePickerTextInputPresenter;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public final void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        this.f$0.m450xe359ee16(materialButtonToggleGroup, i, z);
    }
}
