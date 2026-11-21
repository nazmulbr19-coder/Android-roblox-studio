package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import android.widget.TextView;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/PlayHud;", method = "settingsPage$selector$arrow$lambda$64$lambda$63", proto = "(Lkotlin/jvm/internal/Ref$IntRef;ILjava/util/List;Landroid/widget/TextView;Lkotlin/jvm/functions/Function1;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class PlayHud$$ExternalSyntheticLambda18 implements View.OnClickListener {
    public final /* synthetic */ Ref.IntRef f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ TextView f$3;
    public final /* synthetic */ Function1 f$4;

    public /* synthetic */ PlayHud$$ExternalSyntheticLambda18(Ref.IntRef intRef, int i, List list, TextView textView, Function1 function1) {
        this.f$0 = intRef;
        this.f$1 = i;
        this.f$2 = list;
        this.f$3 = textView;
        this.f$4 = function1;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PlayHud.settingsPage$selector$arrow$lambda$64$lambda$63(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, view);
    }
}
