package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.StartScreen;
import java.util.List;
import kotlin.Pair;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "groupGames$lambda$150$lambda$144$lambda$143", proto = "(ILcom/exampletest/mobilestudiotest/ui/StartScreen;Lkotlin/Pair;Lcom/exampletest/mobilestudiotest/ui/StartScreen$GroupsView;Ljava/util/List;Ljava/util/List;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda12 implements Runnable {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ StartScreen f$1;
    public final /* synthetic */ Pair f$2;
    public final /* synthetic */ StartScreen.GroupsView f$3;
    public final /* synthetic */ List f$4;
    public final /* synthetic */ List f$5;
    public final /* synthetic */ int f$6;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda12(int i, StartScreen startScreen, Pair pair, StartScreen.GroupsView groupsView, List list, List list2, int i2) {
        this.f$0 = i;
        this.f$1 = startScreen;
        this.f$2 = pair;
        this.f$3 = groupsView;
        this.f$4 = list;
        this.f$5 = list2;
        this.f$6 = i2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.groupGames$lambda$150$lambda$144$lambda$143(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}
