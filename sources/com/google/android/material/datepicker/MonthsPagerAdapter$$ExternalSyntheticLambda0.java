package com.google.android.material.datepicker;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/datepicker/MonthsPagerAdapter;", method = "lambda$setInitialKeyboardFocus$0", proto = "(Lcom/google/android/material/datepicker/MaterialCalendarGridView;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class MonthsPagerAdapter$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ MonthsPagerAdapter f$0;
    public final /* synthetic */ MaterialCalendarGridView f$1;
    public final /* synthetic */ int f$2;

    public /* synthetic */ MonthsPagerAdapter$$ExternalSyntheticLambda0(MonthsPagerAdapter monthsPagerAdapter, MaterialCalendarGridView materialCalendarGridView, int i) {
        this.f$0 = monthsPagerAdapter;
        this.f$1 = materialCalendarGridView;
        this.f$2 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m384x7f109e0a(this.f$1, this.f$2);
    }
}
