package com.exampletest.mobilestudiotest.ui;

import android.app.Activity;
import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.engine.Avatar;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/AvatarUi;", method = "rigBuilder$lambda$85", proto = "(Lcom/exampletest/mobilestudiotest/engine/Avatar$Spec;Landroid/app/Activity;Lcom/exampletest/mobilestudiotest/core/Studio;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class AvatarUi$$ExternalSyntheticLambda25 implements Function0 {
    public final /* synthetic */ Avatar.Spec f$0;
    public final /* synthetic */ Activity f$1;
    public final /* synthetic */ Studio f$2;

    public /* synthetic */ AvatarUi$$ExternalSyntheticLambda25(Avatar.Spec spec, Activity activity, Studio studio) {
        this.f$0 = spec;
        this.f$1 = activity;
        this.f$2 = studio;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return AvatarUi.rigBuilder$lambda$85(this.f$0, this.f$1, this.f$2);
    }
}
