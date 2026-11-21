package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import android.app.AlertDialog;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AccountUi;", method = "background$lambda$7$lambda$6", proto = "(Landroid/app/Activity;Landroid/app/AlertDialog;Lkotlin/jvm/internal/Ref$BooleanRef;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AccountUi$$ExternalSyntheticLambda74 implements Runnable {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ AlertDialog f$1;
    public final /* synthetic */ Ref.BooleanRef f$2;
    public final /* synthetic */ Object f$3;
    public final /* synthetic */ Function1 f$4;
    public final /* synthetic */ Function1 f$5;

    public /* synthetic */ AccountUi$$ExternalSyntheticLambda74(Activity activity, AlertDialog alertDialog, Ref.BooleanRef booleanRef, Object obj, Function1 function1, Function1 function12) {
        this.f$0 = activity;
        this.f$1 = alertDialog;
        this.f$2 = booleanRef;
        this.f$3 = obj;
        this.f$4 = function1;
        this.f$5 = function12;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AccountUi.background$lambda$7$lambda$6(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
