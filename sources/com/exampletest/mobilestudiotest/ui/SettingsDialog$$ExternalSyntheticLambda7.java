package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "editTheme$refresh$lambda$71$lambda$70", proto = "(Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/lang/String;Landroid/widget/LinearLayout;Landroid/content/Context;Ljava/lang/Object;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ LinearLayout f$2;
    public final /* synthetic */ Context f$3;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda7(Ref.ObjectRef objectRef, String str, LinearLayout linearLayout, Context context) {
        this.f$0 = objectRef;
        this.f$1 = str;
        this.f$2 = linearLayout;
        this.f$3 = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return SettingsDialog.editTheme$refresh$lambda$71$lambda$70(this.f$0, this.f$1, this.f$2, this.f$3, obj);
    }
}
