package com.exampletest.mobilestudiotest.ui;

import android.content.DialogInterface;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.ArrayList;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AvatarUi;", method = "rigBuilder$lambda$88", proto = "(Ljava/util/ArrayList;Landroid/content/DialogInterface;I)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AvatarUi$$ExternalSyntheticLambda27 implements DialogInterface.OnClickListener {
    public final /* synthetic */ ArrayList f$0;

    public /* synthetic */ AvatarUi$$ExternalSyntheticLambda27(ArrayList arrayList) {
        this.f$0 = arrayList;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        AvatarUi.rigBuilder$lambda$88(this.f$0, dialogInterface, i);
    }
}
