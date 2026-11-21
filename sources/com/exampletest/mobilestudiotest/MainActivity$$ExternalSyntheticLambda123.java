package com.exampletest.mobilestudiotest;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "rebuildScriptTabs$tab$lambda$267$lambda$266", proto = "(Lkotlin/jvm/functions/Function0;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda123 implements View.OnClickListener {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda123(Function0 function0) {
        this.f$0 = function0;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        MainActivity.rebuildScriptTabs$tab$lambda$267$lambda$266(this.f$0, view);
    }
}
