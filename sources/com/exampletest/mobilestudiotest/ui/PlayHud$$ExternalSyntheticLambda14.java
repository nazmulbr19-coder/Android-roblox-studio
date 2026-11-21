package com.exampletest.mobilestudiotest.ui;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/ui/PlayHud;", method = "settingsPage$lambda$73", proto = "(Lcom/exampletest/mobilestudiotest/ui/PlayHud;F)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes5.dex */
public final /* synthetic */ class PlayHud$$ExternalSyntheticLambda14 implements Function1 {
    public final /* synthetic */ PlayHud f$0;

    public /* synthetic */ PlayHud$$ExternalSyntheticLambda14(PlayHud playHud) {
        this.f$0 = playHud;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return PlayHud.settingsPage$lambda$73(this.f$0, ((Float) obj).floatValue());
    }
}
