package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import java.util.Map;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "recentCards$lambda$114$lambda$113", proto = "(ILcom/exampletest/mobilestudiotest/ui/StartScreen;Ljava/util/List;Ljava/util/Map;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda19 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ StartScreen f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ Map f$3;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda19(int i, StartScreen startScreen, List list, Map map) {
        this.f$0 = i;
        this.f$1 = startScreen;
        this.f$2 = list;
        this.f$3 = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.recentCards$lambda$114$lambda$113(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
