package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.net.CloudPlace;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AvatarUi;", method = "syncFromCloud$lambda$81", proto = "(Landroid/content/Context;Lcom/exampletest/mobilestudiotest/net/CloudPlace;Lcom/exampletest/mobilestudiotest/core/Studio;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AvatarUi$$ExternalSyntheticLambda4 implements Runnable {
    public final /* synthetic */ Context f$0;
    public final /* synthetic */ CloudPlace f$1;
    public final /* synthetic */ Studio f$2;

    public /* synthetic */ AvatarUi$$ExternalSyntheticLambda4(Context context, CloudPlace cloudPlace, Studio studio) {
        this.f$0 = context;
        this.f$1 = cloudPlace;
        this.f$2 = studio;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AvatarUi.syncFromCloud$lambda$81(this.f$0, this.f$1, this.f$2);
    }
}
