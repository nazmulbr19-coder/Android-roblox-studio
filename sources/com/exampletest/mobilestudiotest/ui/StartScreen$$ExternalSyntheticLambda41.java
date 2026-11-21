package com.exampletest.mobilestudiotest.ui;

import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import com.exampletest.mobilestudiotest.ui.StartScreen;
import kotlin.Pair;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "groupGames$lambda$150", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$User;Lkotlin/Pair;JILcom/exampletest/mobilestudiotest/ui/StartScreen$GroupsView;Landroid/widget/LinearLayout;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda41 implements Runnable {
    public final /* synthetic */ StartScreen f$0;
    public final /* synthetic */ RobloxCloud.User f$1;
    public final /* synthetic */ Pair f$2;
    public final /* synthetic */ long f$3;
    public final /* synthetic */ int f$4;
    public final /* synthetic */ StartScreen.GroupsView f$5;
    public final /* synthetic */ LinearLayout f$6;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda41(StartScreen startScreen, RobloxCloud.User user, Pair pair, long j, int i, StartScreen.GroupsView groupsView, LinearLayout linearLayout) {
        this.f$0 = startScreen;
        this.f$1 = user;
        this.f$2 = pair;
        this.f$3 = j;
        this.f$4 = i;
        this.f$5 = groupsView;
        this.f$6 = linearLayout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.groupGames$lambda$150(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6);
    }
}
