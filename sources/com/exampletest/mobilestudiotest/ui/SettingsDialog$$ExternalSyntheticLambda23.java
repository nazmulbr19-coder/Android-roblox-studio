package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "show$lambda$35", proto = "(Landroid/content/Context;Lkotlin/jvm/internal/Ref$ObjectRef;Landroid/view/View;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda23 implements Function1 {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ Ref.ObjectRef f$1;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda23(Context context, Ref.ObjectRef objectRef) {
        this.f$0 = context;
        this.f$1 = objectRef;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return SettingsDialog.show$lambda$35(this.f$0, this.f$1, (View) obj);
    }
}
