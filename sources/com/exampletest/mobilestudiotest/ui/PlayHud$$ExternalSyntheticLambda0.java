package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import android.widget.FrameLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.ArrayList;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/PlayHud;", method = "openMenu$lambda$26$lambda$25$lambda$24", proto = "(ILjava/util/ArrayList;Landroid/widget/FrameLayout;Lcom/exampletest/mobilestudiotest/ui/PlayHud;Landroid/view/View;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class PlayHud$$ExternalSyntheticLambda0 implements View.OnClickListener {
    public final /* synthetic */ int f$0;
    public final /* synthetic */ ArrayList f$1;
    public final /* synthetic */ FrameLayout f$2;
    public final /* synthetic */ PlayHud f$3;

    public /* synthetic */ PlayHud$$ExternalSyntheticLambda0(int i, ArrayList arrayList, FrameLayout frameLayout, PlayHud playHud) {
        this.f$0 = i;
        this.f$1 = arrayList;
        this.f$2 = frameLayout;
        this.f$3 = playHud;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        PlayHud.openMenu$lambda$26$lambda$25$lambda$24(this.f$0, this.f$1, this.f$2, this.f$3, view);
    }
}
