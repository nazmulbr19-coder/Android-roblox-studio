package com.exampletest.mobilestudiotest;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "pickPartShape$lambda$227", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Ljava/util/List;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda14 implements DialogInterface.OnClickListener {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ List f$1;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda14(MainActivity mainActivity, List list) {
        this.f$0 = mainActivity;
        this.f$1 = list;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MainActivity.pickPartShape$lambda$227(this.f$0, this.f$1, dialogInterface, i);
    }
}
