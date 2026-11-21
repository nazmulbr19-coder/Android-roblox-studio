package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "heading$lambda$43$lambda$42", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;Ljava/lang/String;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda11 implements View.OnClickListener {
    public final /* synthetic */ StartScreen f$0;
    public final /* synthetic */ String f$1;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda11(StartScreen startScreen, String str) {
        this.f$0 = startScreen;
        this.f$1 = str;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StartScreen.heading$lambda$43$lambda$42(this.f$0, this.f$1, view);
    }
}
