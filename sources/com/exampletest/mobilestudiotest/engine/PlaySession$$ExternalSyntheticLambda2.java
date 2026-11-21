package com.exampletest.mobilestudiotest.engine;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function2;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/engine/PlaySession;", method = "mouseValue$lambda$151", proto = "(Lcom/exampletest/mobilestudiotest/engine/PlaySession;Lorg/luaj/vm2/LuaTable;Lorg/luaj/vm2/LuaValue;Lorg/luaj/vm2/LuaValue;)Lorg/luaj/vm2/LuaValue;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes7.dex */
public final /* synthetic */ class PlaySession$$ExternalSyntheticLambda2 implements Function2 {
    public final /* synthetic */ PlaySession f$0;
    public final /* synthetic */ LuaTable f$1;

    public /* synthetic */ PlaySession$$ExternalSyntheticLambda2(PlaySession playSession, LuaTable luaTable) {
        this.f$0 = playSession;
        this.f$1 = luaTable;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return PlaySession.mouseValue$lambda$151(this.f$0, this.f$1, (LuaValue) obj, (LuaValue) obj2);
    }
}
