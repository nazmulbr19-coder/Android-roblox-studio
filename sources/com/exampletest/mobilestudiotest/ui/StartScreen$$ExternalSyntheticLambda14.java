package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "card$lambda$62$lambda$61", proto = "(Lkotlin/jvm/functions/Function0;Landroid/view/View;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda14 implements View.OnLongClickListener {
    public final /* synthetic */ Function0 f$0;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda14(Function0 function0) {
        this.f$0 = function0;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        return StartScreen.card$lambda$62$lambda$61(this.f$0, view);
    }
}
