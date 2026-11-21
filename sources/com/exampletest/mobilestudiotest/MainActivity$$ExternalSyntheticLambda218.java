package com.exampletest.mobilestudiotest;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.CloudPlace;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "openPlaceBytes$lambda$329", proto = "([BLcom/exampletest/mobilestudiotest/MainActivity;Ljava/lang/String;Lcom/exampletest/mobilestudiotest/net/CloudPlace;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda218 implements Runnable {
    public final /* synthetic */ byte[] f$0;
    public final /* synthetic */ MainActivity f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ CloudPlace f$3;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda218(byte[] bArr, MainActivity mainActivity, String str, CloudPlace cloudPlace) {
        this.f$0 = bArr;
        this.f$1 = mainActivity;
        this.f$2 = str;
        this.f$3 = cloudPlace;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainActivity.openPlaceBytes$lambda$329(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
