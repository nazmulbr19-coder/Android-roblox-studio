package com.exampletest.mobilestudiotest.ui;

import android.widget.LinearLayout;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.DockLayout;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/DockLayout;", method = "rebuild$fill$lambda$25$lambda$23", proto = "(Lcom/exampletest/mobilestudiotest/ui/DockLayout;Landroid/widget/LinearLayout;Lcom/exampletest/mobilestudiotest/ui/DockLayout$Panel;Lcom/exampletest/mobilestudiotest/ui/DockLayout$Panel;ZF)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class DockLayout$$ExternalSyntheticLambda10 implements Function1 {
    public final /* synthetic */ DockLayout f$0;
    public final /* synthetic */ LinearLayout f$1;
    public final /* synthetic */ DockLayout.Panel f$2;
    public final /* synthetic */ DockLayout.Panel f$3;
    public final /* synthetic */ boolean f$4;

    public /* synthetic */ DockLayout$$ExternalSyntheticLambda10(DockLayout dockLayout, LinearLayout linearLayout, DockLayout.Panel panel, DockLayout.Panel panel2, boolean z) {
        this.f$0 = dockLayout;
        this.f$1 = linearLayout;
        this.f$2 = panel;
        this.f$3 = panel2;
        this.f$4 = z;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return DockLayout.rebuild$fill$lambda$25$lambda$23(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, ((Float) obj).floatValue());
    }
}
