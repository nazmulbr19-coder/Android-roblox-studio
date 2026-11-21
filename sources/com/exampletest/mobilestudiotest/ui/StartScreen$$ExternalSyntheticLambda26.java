package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.StartScreen;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "groupGames$lambda$150$lambda$137", proto = "(Ljava/util/List;Lcom/exampletest/mobilestudiotest/ui/StartScreen;ILcom/exampletest/mobilestudiotest/ui/StartScreen$GroupsView;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda26 implements Runnable {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ StartScreen f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ StartScreen.GroupsView f$3;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda26(List list, StartScreen startScreen, int i, StartScreen.GroupsView groupsView) {
        this.f$0 = list;
        this.f$1 = startScreen;
        this.f$2 = i;
        this.f$3 = groupsView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.groupGames$lambda$150$lambda$137(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
