package com.exampletest.mobilestudiotest.ui;

import android.view.View;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.ui.DockLayout;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/DockLayout;", method = "decorateHeader$lambda$34", proto = "(Lcom/exampletest/mobilestudiotest/ui/DockLayout;Lcom/exampletest/mobilestudiotest/ui/DockLayout$Panel;Landroid/view/View;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class DockLayout$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ DockLayout f$0;
    public final /* synthetic */ DockLayout.Panel f$1;

    public /* synthetic */ DockLayout$$ExternalSyntheticLambda7(DockLayout dockLayout, DockLayout.Panel panel) {
        this.f$0 = dockLayout;
        this.f$1 = panel;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return DockLayout.decorateHeader$lambda$34(this.f$0, this.f$1, (View) obj);
    }
}
