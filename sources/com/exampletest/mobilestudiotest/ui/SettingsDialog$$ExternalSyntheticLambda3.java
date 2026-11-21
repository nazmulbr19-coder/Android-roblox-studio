package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Theme;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "editTheme$lambda$73", proto = "(Lkotlin/jvm/internal/Ref$ObjectRef;Lcom/exampletest/mobilestudiotest/core/Theme;Landroid/widget/EditText;Landroid/widget/LinearLayout;Landroid/content/Context;Landroid/view/View;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda3 implements Function1 {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ Theme f$1;
    public final /* synthetic */ EditText f$2;
    public final /* synthetic */ LinearLayout f$3;
    public final /* synthetic */ Context f$4;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda3(Ref.ObjectRef objectRef, Theme theme, EditText editText, LinearLayout linearLayout, Context context) {
        this.f$0 = objectRef;
        this.f$1 = theme;
        this.f$2 = editText;
        this.f$3 = linearLayout;
        this.f$4 = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return SettingsDialog.editTheme$lambda$73(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (View) obj);
    }
}
