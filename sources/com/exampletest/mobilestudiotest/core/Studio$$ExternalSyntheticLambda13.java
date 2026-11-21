package com.exampletest.mobilestudiotest.core;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import kotlin.jvm.functions.Function0;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/core/Studio;", method = "startPlay$lambda$28$lambda$27", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;Lcom/exampletest/mobilestudiotest/engine/PlaySession;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class Studio$$ExternalSyntheticLambda13 implements Function0 {
    public final /* synthetic */ Studio f$0;
    public final /* synthetic */ PlaySession f$1;

    public /* synthetic */ Studio$$ExternalSyntheticLambda13(Studio studio, PlaySession playSession) {
        this.f$0 = studio;
        this.f$1 = playSession;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return Studio.startPlay$lambda$28$lambda$27(this.f$0, this.f$1);
    }
}
