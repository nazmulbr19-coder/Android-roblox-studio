package com.exampletest.mobilestudiotest;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "snapRow$lambda$237$lambda$236", proto = "(Lkotlin/jvm/functions/Function1;ZLcom/exampletest/mobilestudiotest/MainActivity;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda78 implements View.OnClickListener {
    public final /* synthetic */ Function1 f$0;
    public final /* synthetic */ boolean f$1;
    public final /* synthetic */ MainActivity f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda78(Function1 function1, boolean z, MainActivity mainActivity) {
        this.f$0 = function1;
        this.f$1 = z;
        this.f$2 = mainActivity;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MainActivity.snapRow$lambda$237$lambda$236(this.f$0, this.f$1, this.f$2, view);
    }
}
