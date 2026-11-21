package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/Ui;", method = "button$lambda$4$lambda$3", proto = "(Lkotlin/jvm/functions/Function1;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class Ui$$ExternalSyntheticLambda1 implements View.OnClickListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ Ui$$ExternalSyntheticLambda1(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Ui.button$lambda$4$lambda$3(this.f$0, view);
    }
}
