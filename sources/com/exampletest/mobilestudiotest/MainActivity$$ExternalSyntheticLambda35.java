package com.exampletest.mobilestudiotest;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "showFileMenu$lambda$295", proto = "(Ljava/util/List;Landroid/view/MenuItem;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda35 implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ List f$0;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda35(List list) {
        this.f$0 = list;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return MainActivity.showFileMenu$lambda$295(this.f$0, menuItem);
    }
}
