package com.google.android.material.datepicker;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/google/android/material/datepicker/DateFormatTextWatcher;", method = "lambda$createRangeErrorCallback$1", proto = "(J)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes.dex */
public final /* synthetic */ class DateFormatTextWatcher$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ DateFormatTextWatcher f$0;
    public final /* synthetic */ long f$1;

    public /* synthetic */ DateFormatTextWatcher$$ExternalSyntheticLambda1(DateFormatTextWatcher dateFormatTextWatcher, long j) {
        this.f$0 = dateFormatTextWatcher;
        this.f$1 = j;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f$0.m380x14d77527(this.f$1);
    }
}
