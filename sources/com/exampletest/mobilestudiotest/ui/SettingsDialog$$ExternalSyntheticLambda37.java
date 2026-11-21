package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "editTheme$refresh$lambda$71", proto = "(Landroid/content/Context;Ljava/lang/String;ILkotlin/jvm/internal/Ref$ObjectRef;Landroid/widget/LinearLayout;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda37 implements View.OnClickListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ Ref.ObjectRef f$3;
    public final /* synthetic */ LinearLayout f$4;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda37(Context context, String str, int i, Ref.ObjectRef objectRef, LinearLayout linearLayout) {
        this.f$0 = context;
        this.f$1 = str;
        this.f$2 = i;
        this.f$3 = objectRef;
        this.f$4 = linearLayout;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SettingsDialog.editTheme$refresh$lambda$71(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
