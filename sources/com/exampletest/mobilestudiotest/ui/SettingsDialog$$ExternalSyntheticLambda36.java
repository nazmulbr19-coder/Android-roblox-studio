package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/SettingsDialog;", method = "choice$lambda$59", proto = "(Landroid/content/Context;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/internal/Ref$IntRef;Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class SettingsDialog$$ExternalSyntheticLambda36 implements View.OnClickListener {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ Ref.IntRef f$3;
    public final /* synthetic */ TextView f$4;
    public final /* synthetic */ Function1 f$5;

    public /* synthetic */ SettingsDialog$$ExternalSyntheticLambda36(Context context, String str, List list, Ref.IntRef intRef, TextView textView, Function1 function1) {
        this.f$0 = context;
        this.f$1 = str;
        this.f$2 = list;
        this.f$3 = intRef;
        this.f$4 = textView;
        this.f$5 = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        SettingsDialog.choice$lambda$59(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, view);
    }
}
