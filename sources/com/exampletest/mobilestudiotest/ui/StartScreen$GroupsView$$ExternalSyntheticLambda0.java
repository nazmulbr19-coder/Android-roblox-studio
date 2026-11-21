package com.exampletest.mobilestudiotest.ui;

import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import com.exampletest.mobilestudiotest.ui.StartScreen;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen$GroupsView;", method = "select$lambda$28", proto = "(Ljava/util/List;Lcom/exampletest/mobilestudiotest/ui/StartScreen;ILcom/exampletest/mobilestudiotest/net/RobloxCloud$Group;Landroid/widget/LinearLayout;Ljava/util/List;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$GroupsView$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ StartScreen f$1;
    public final /* synthetic */ int f$2;
    public final /* synthetic */ RobloxCloud.Group f$3;
    public final /* synthetic */ LinearLayout f$4;
    public final /* synthetic */ List f$5;

    public /* synthetic */ StartScreen$GroupsView$$ExternalSyntheticLambda0(List list, StartScreen startScreen, int i, RobloxCloud.Group group, LinearLayout linearLayout, List list2) {
        this.f$0 = list;
        this.f$1 = startScreen;
        this.f$2 = i;
        this.f$3 = group;
        this.f$4 = linearLayout;
        this.f$5 = list2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        StartScreen.GroupsView.select$lambda$28(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
