package com.exampletest.mobilestudiotest.ui;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.ArrayList;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/ExplorerPanel;", method = "showContextMenu$lambda$50", proto = "(Ljava/util/ArrayList;Landroid/view/MenuItem;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class ExplorerPanel$$ExternalSyntheticLambda15 implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ ArrayList f$0;

    public /* synthetic */ ExplorerPanel$$ExternalSyntheticLambda15(ArrayList arrayList) {
        this.f$0 = arrayList;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return ExplorerPanel.showContextMenu$lambda$50(this.f$0, menuItem);
    }
}
