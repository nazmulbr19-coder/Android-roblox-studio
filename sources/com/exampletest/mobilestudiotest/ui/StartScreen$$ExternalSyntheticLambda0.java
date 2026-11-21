package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Recents;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/StartScreen;", method = "recentCards$lambda$110$lambda$109$lambda$108", proto = "(Lcom/exampletest/mobilestudiotest/ui/StartScreen;Lcom/exampletest/mobilestudiotest/core/Recents$Entry;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class StartScreen$$ExternalSyntheticLambda0 implements DialogInterface.OnClickListener {
    public final /* synthetic */ StartScreen f$0;
    public final /* synthetic */ Recents.Entry f$1;

    public /* synthetic */ StartScreen$$ExternalSyntheticLambda0(StartScreen startScreen, Recents.Entry entry) {
        this.f$0 = startScreen;
        this.f$1 = entry;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        StartScreen.recentCards$lambda$110$lambda$109$lambda$108(this.f$0, this.f$1, dialogInterface, i);
    }
}
