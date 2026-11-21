package com.exampletest.mobilestudiotest.engine;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.model.Instance;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/engine/PlaySession;", method = "aimMouse$lambda$137", proto = "(Lcom/exampletest/mobilestudiotest/engine/PlaySession;Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/model/Instance;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class PlaySession$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ PlaySession f$0;
    public final /* synthetic */ Instance f$1;

    public /* synthetic */ PlaySession$$ExternalSyntheticLambda0(PlaySession playSession, Instance instance) {
        this.f$0 = playSession;
        this.f$1 = instance;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(PlaySession.aimMouse$lambda$137(this.f$0, this.f$1, (Instance) obj));
    }
}
