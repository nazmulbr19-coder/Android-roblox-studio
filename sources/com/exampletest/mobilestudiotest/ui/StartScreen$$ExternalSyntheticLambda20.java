package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "home$lambda$77$lambda$76", proto = "(ILcom/exampletest/mobilestudiotest/ui/StartScreen;Landroid/widget/LinearLayout;Landroid/view/View;Ljava/util/List;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda20 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ StartScreen f$1;
    public final /* synthetic */ LinearLayout f$2;
    public final /* synthetic */ View f$3;
    public final /* synthetic */ List f$4;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda20(int i, StartScreen startScreen, LinearLayout linearLayout, View view, List list) {
        this.f$0 = i;
        this.f$1 = startScreen;
        this.f$2 = linearLayout;
        this.f$3 = view;
        this.f$4 = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.home$lambda$77$lambda$76(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
