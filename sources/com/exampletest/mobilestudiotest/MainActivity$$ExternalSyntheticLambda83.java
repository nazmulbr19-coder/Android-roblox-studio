package com.exampletest.mobilestudiotest;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.List;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/MainActivity;", method = "pickSurfaceForSelection$lambda$261$lambda$260", proto = "(Ljava/util/List;ILcom/exampletest/mobilestudiotest/MainActivity;Ljava/util/List;Ljava/util/List;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class MainActivity$$ExternalSyntheticLambda83 implements DialogInterface.OnClickListener {
    public final /* synthetic */ List f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ MainActivity f$2;
    public final /* synthetic */ List f$3;
    public final /* synthetic */ List f$4;

    public /* synthetic */ MainActivity$$ExternalSyntheticLambda83(List list, int i, MainActivity mainActivity, List list2, List list3) {
        this.f$0 = list;
        this.f$1 = i;
        this.f$2 = mainActivity;
        this.f$3 = list2;
        this.f$4 = list3;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        MainActivity.pickSurfaceForSelection$lambda$261$lambda$260(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, dialogInterface, i);
    }
}
