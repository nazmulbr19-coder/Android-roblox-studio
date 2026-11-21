package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import com.exampletest.mobilestudiotest.ui.StartScreen;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen$GroupsView;", method = "drawChips$lambda$15$lambda$14", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen$GroupsView;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Group;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$GroupsView$$ExternalSyntheticLambda2 implements View.OnClickListener {
    public final /* synthetic */ StartScreen.GroupsView f$0;
    public final /* synthetic */ RobloxCloud.Group f$1;

    public /* synthetic */ StartScreen$GroupsView$$ExternalSyntheticLambda2(StartScreen.GroupsView groupsView, RobloxCloud.Group group) {
        this.f$0 = groupsView;
        this.f$1 = group;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        StartScreen.GroupsView.drawChips$lambda$15$lambda$14(this.f$0, this.f$1, view);
    }
}
