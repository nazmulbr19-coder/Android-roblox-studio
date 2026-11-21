package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.StartScreen;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "games$lambda$129", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;Lcom/exampletest/mobilestudiotest/ui/StartScreen$Kind;ILandroid/view/View;Landroid/widget/LinearLayout;Landroid/widget/LinearLayout;Ljava/lang/String;ZLjava/util/List;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda7 implements Runnable {
    public final /* synthetic */ StartScreen f$0;
    public final /* synthetic */ StartScreen.Kind f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ View f$3;
    public final /* synthetic */ LinearLayout f$4;
    public final /* synthetic */ LinearLayout f$5;
    public final /* synthetic */ String f$6;
    public final /* synthetic */ boolean f$7;
    public final /* synthetic */ List f$8;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda7(StartScreen startScreen, StartScreen.Kind kind, int i, View view, LinearLayout linearLayout, LinearLayout linearLayout2, String str, boolean z, List list) {
        this.f$0 = startScreen;
        this.f$1 = kind;
        this.f$2 = i;
        this.f$3 = view;
        this.f$4 = linearLayout;
        this.f$5 = linearLayout2;
        this.f$6 = str;
        this.f$7 = z;
        this.f$8 = list;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.games$lambda$129(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, this.f$8);
    }
}
