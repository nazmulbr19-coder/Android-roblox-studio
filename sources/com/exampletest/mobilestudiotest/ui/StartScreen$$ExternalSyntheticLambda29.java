package com.exampletest.mobilestudiotest.ui;

import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.StartScreen;
import kotlin.Pair;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "groupGames$lambda$150$lambda$149", proto = "(ILcom/exampletest/mobilestudiotest/ui/StartScreen;Lcom/exampletest/mobilestudiotest/ui/StartScreen$GroupsView;Lkotlin/Pair;Landroid/widget/LinearLayout;Ljava/lang/Exception;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda29 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ StartScreen f$1;
    public final /* synthetic */ StartScreen.GroupsView f$2;
    public final /* synthetic */ Pair f$3;
    public final /* synthetic */ LinearLayout f$4;
    public final /* synthetic */ Exception f$5;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda29(int i, StartScreen startScreen, StartScreen.GroupsView groupsView, Pair pair, LinearLayout linearLayout, Exception exc) {
        this.f$0 = i;
        this.f$1 = startScreen;
        this.f$2 = groupsView;
        this.f$3 = pair;
        this.f$4 = linearLayout;
        this.f$5 = exc;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.groupGames$lambda$150$lambda$149(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
