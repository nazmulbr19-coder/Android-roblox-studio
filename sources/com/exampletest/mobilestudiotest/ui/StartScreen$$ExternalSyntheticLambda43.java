package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "home$lambda$77", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;ILandroid/widget/LinearLayout;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda43 implements Runnable {
    public final /* synthetic */ StartScreen f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ LinearLayout f$2;
    public final /* synthetic */ View f$3;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda43(StartScreen startScreen, int i, LinearLayout linearLayout, View view) {
        this.f$0 = startScreen;
        this.f$1 = i;
        this.f$2 = linearLayout;
        this.f$3 = view;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.home$lambda$77(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
