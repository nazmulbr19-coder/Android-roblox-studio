package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", method = "animationTrack$lambda$33", proto = "(Lkotlin/jvm/internal/Ref$FloatRef;Lcom/exampletest/mobilestudiotest/engine/PlaySession$ScriptTrack;Lcom/exampletest/mobilestudiotest/engine/PlaySession;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class InstanceApi$$ExternalSyntheticLambda5 implements Function1 {
    public final /* synthetic */ Ref.FloatRef f$0;
    public final /* synthetic */ PlaySession.ScriptTrack f$1;
    public final /* synthetic */ PlaySession f$2;

    public /* synthetic */ InstanceApi$$ExternalSyntheticLambda5(Ref.FloatRef floatRef, PlaySession.ScriptTrack scriptTrack, PlaySession playSession) {
        this.f$0 = floatRef;
        this.f$1 = scriptTrack;
        this.f$2 = playSession;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return InstanceApi.animationTrack$lambda$33(this.f$0, this.f$1, this.f$2, (Varargs) obj);
    }
}
