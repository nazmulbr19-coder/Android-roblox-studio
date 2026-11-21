package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", method = "animationTrack$lambda$39", proto = "(Lcom/exampletest/mobilestudiotest/engine/PlaySession$ScriptTrack;Lcom/exampletest/mobilestudiotest/engine/PlaySession;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class InstanceApi$$ExternalSyntheticLambda9 implements Function1 {
    public final /* synthetic */ PlaySession.ScriptTrack f$0;
    public final /* synthetic */ PlaySession f$1;

    public /* synthetic */ InstanceApi$$ExternalSyntheticLambda9(PlaySession.ScriptTrack scriptTrack, PlaySession playSession) {
        this.f$0 = scriptTrack;
        this.f$1 = playSession;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return InstanceApi.animationTrack$lambda$39(this.f$0, this.f$1, (Varargs) obj);
    }
}
