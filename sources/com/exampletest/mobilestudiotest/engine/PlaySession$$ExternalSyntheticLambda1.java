package com.exampletest.mobilestudiotest.engine;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.model.Instance;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/engine/PlaySession;", method = "bubble$lambda$157", proto = "(Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/engine/PlaySession;Lcom/exampletest/mobilestudiotest/engine/PlaySession$Bubble;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class PlaySession$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ Instance f$0;
    public final /* synthetic */ PlaySession f$1;

    public /* synthetic */ PlaySession$$ExternalSyntheticLambda1(Instance instance, PlaySession playSession) {
        this.f$0 = instance;
        this.f$1 = playSession;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(PlaySession.bubble$lambda$157(this.f$0, this.f$1, (PlaySession.Bubble) obj));
    }
}
