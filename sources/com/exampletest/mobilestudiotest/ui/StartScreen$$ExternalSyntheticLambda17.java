package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.StartScreen;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "groupGames$lambda$150$lambda$137$lambda$136", proto = "(ILcom/exampletest/mobilestudiotest/ui/StartScreen;Lcom/exampletest/mobilestudiotest/ui/StartScreen$GroupsView;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda17 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ StartScreen f$1;
    public final /* synthetic */ StartScreen.GroupsView f$2;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda17(int i, StartScreen startScreen, StartScreen.GroupsView groupsView) {
        this.f$0 = i;
        this.f$1 = startScreen;
        this.f$2 = groupsView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.groupGames$lambda$150$lambda$137$lambda$136(this.f$0, this.f$1, this.f$2);
    }
}
