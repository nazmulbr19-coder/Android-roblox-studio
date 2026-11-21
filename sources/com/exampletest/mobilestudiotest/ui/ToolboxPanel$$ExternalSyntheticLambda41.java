package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ToolboxPanel;", method = "buildMarket$lambda$43", proto = "(Landroidx/recyclerview/widget/GridLayoutManager;Landroid/content/Context;Landroid/view/View;IIIIIIII)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ToolboxPanel$$ExternalSyntheticLambda41 implements View.OnLayoutChangeListener {
    public final /* synthetic */ GridLayoutManager f$0;
    public final /* synthetic */ Context f$1;

    public /* synthetic */ ToolboxPanel$$ExternalSyntheticLambda41(GridLayoutManager gridLayoutManager, Context context) {
        this.f$0 = gridLayoutManager;
        this.f$1 = context;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        ToolboxPanel.buildMarket$lambda$43(this.f$0, this.f$1, view, i, i2, i3, i4, i5, i6, i7, i8);
    }
}
