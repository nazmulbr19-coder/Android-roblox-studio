package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "buildNav$item$lambda$26$lambda$25", proto = "(Lkotlin/jvm/functions/Function0;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda18 implements View.OnClickListener {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda18(Function0 function0) {
        this.f$0 = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StartScreen.buildNav$item$lambda$26$lambda$25(this.f$0, view);
    }
}
