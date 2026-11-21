package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.net.CloudPlace;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AvatarUi;", method = "gameSettings$lambda$77$lambda$74", proto = "(Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/net/CloudPlace;Lcom/exampletest/mobilestudiotest/net/RobloxCloud$AvatarSettings;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AvatarUi$$ExternalSyntheticLambda9 implements Function0 {
    public final /* synthetic */ Activity f$0;
    public final /* synthetic */ CloudPlace f$1;
    public final /* synthetic */ RobloxCloud.AvatarSettings f$2;

    public /* synthetic */ AvatarUi$$ExternalSyntheticLambda9(Activity activity, CloudPlace cloudPlace, RobloxCloud.AvatarSettings avatarSettings) {
        this.f$0 = activity;
        this.f$1 = cloudPlace;
        this.f$2 = avatarSettings;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AvatarUi.gameSettings$lambda$77$lambda$74(this.f$0, this.f$1, this.f$2);
    }
}
