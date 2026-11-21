package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import com.exampletest.mobilestudiotest.net.RobloxCloud;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AvatarUi;", method = "syncFromCloud$lambda$81$lambda$80", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/net/CloudPlace;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$AvatarSettings;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AvatarUi$$ExternalSyntheticLambda13 implements Runnable {
    public final /* synthetic */ Studio f$0;
    public final /* synthetic */ CloudPlace f$1;
    public final /* synthetic */ RobloxCloud.AvatarSettings f$2;

    public /* synthetic */ AvatarUi$$ExternalSyntheticLambda13(Studio studio, CloudPlace cloudPlace, RobloxCloud.AvatarSettings avatarSettings) {
        this.f$0 = studio;
        this.f$1 = cloudPlace;
        this.f$2 = avatarSettings;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AvatarUi.syncFromCloud$lambda$81$lambda$80(this.f$0, this.f$1, this.f$2);
    }
}
