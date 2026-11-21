package com.exampletest.mobilestudiotest;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "stack$lambda$72", proto = "(Lkotlin/jvm/functions/Function0;Landroid/view/View;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda106 implements Function1 {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda106(Function0 function0) {
        this.f$0 = function0;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return MainActivity.stack$lambda$72(this.f$0, (View) obj);
    }
}
