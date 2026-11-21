package com.exampletest.mobilestudiotest;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.DataModel;
import com.exampletest.mobilestudiotest.net.CloudPlace;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "openPlaceBytes$lambda$329$lambda$327", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Lcom/exampletest/mobilestudiotest/model/DataModel;Ljava/lang/String;Lcom/exampletest/mobilestudiotest/net/CloudPlace;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda70 implements Runnable {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ DataModel f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ CloudPlace f$3;
    public final /* synthetic */ int f$4;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda70(MainActivity mainActivity, DataModel dataModel, String str, CloudPlace cloudPlace, int i) {
        this.f$0 = mainActivity;
        this.f$1 = dataModel;
        this.f$2 = str;
        this.f$3 = cloudPlace;
        this.f$4 = i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        MainActivity.openPlaceBytes$lambda$329$lambda$327(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
