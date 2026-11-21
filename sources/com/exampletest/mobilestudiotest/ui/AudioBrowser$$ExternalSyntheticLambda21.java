package com.exampletest.mobilestudiotest.ui;

import android.view.MenuItem;
import android.widget.PopupMenu;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AudioBrowser;", method = "menu$lambda$22", proto = "(Lkotlin/jvm/functions/Function1;Landroid/view/MenuItem;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AudioBrowser$$ExternalSyntheticLambda21 implements PopupMenu.OnMenuItemClickListener {
    public final /* synthetic */ Function1 f$0;

    public /* synthetic */ AudioBrowser$$ExternalSyntheticLambda21(Function1 function1) {
        this.f$0 = function1;
    }

    @Override // android.widget.PopupMenu.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return AudioBrowser.menu$lambda$22(this.f$0, menuItem);
    }
}
