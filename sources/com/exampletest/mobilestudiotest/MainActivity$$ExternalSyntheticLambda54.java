package com.exampletest.mobilestudiotest;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "pickMaterialForSelection$lambda$253", proto = "(Lcom/exampletest/mobilestudiotest/MainActivity;Ljava/util/List;Ljava/util/List;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda54 implements DialogInterface.OnClickListener {
    public final /* synthetic */ MainActivity f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ List f$2;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda54(MainActivity mainActivity, List list, List list2) {
        this.f$0 = mainActivity;
        this.f$1 = list;
        this.f$2 = list2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MainActivity.pickMaterialForSelection$lambda$253(this.f$0, this.f$1, this.f$2, dialogInterface, i);
    }
}
