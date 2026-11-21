package com.exampletest.mobilestudiotest.engine;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/engine/PlaySession;", method = "mouseValue$lambda$151$lambda$150", proto = "(Lcom/exampletest/mobilestudiotest/engine/PlaySession;Lorg/luaj/vm2/LuaTable;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class PlaySession$$ExternalSyntheticLambda6 implements Function1 {
    public final /* synthetic */ PlaySession f$0;
    public final /* synthetic */ LuaTable f$1;

    public /* synthetic */ PlaySession$$ExternalSyntheticLambda6(PlaySession playSession, LuaTable luaTable) {
        this.f$0 = playSession;
        this.f$1 = luaTable;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return PlaySession.mouseValue$lambda$151$lambda$150(this.f$0, this.f$1, (Varargs) obj);
    }
}
