package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", method = "_init_$lambda$0", proto = "(Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class LuaRuntime$$ExternalSyntheticLambda2 implements Function1 {
    public final /* synthetic */ LuaRuntime f$0;

    public /* synthetic */ LuaRuntime$$ExternalSyntheticLambda2(LuaRuntime luaRuntime) {
        this.f$0 = luaRuntime;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return LuaRuntime._init_$lambda$0(this.f$0, (Varargs) obj);
    }
}
