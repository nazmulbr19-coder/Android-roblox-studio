package com.exampletest.mobilestudiotest;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "showPluginMenu$lambda$22", proto = "(Lkotlin/jvm/internal/Ref$BooleanRef;Lkotlin/jvm/functions/Function1;Landroid/content/DialogInterface;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda3 implements DialogInterface.OnDismissListener {
    public final /* synthetic */ Ref.BooleanRef f$0;
    public final /* synthetic */ Function1 f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda3(Ref.BooleanRef booleanRef, Function1 function1) {
        this.f$0 = booleanRef;
        this.f$1 = function1;
    }

    @Override // android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        MainActivity.showPluginMenu$lambda$22(this.f$0, this.f$1, dialogInterface);
    }
}
