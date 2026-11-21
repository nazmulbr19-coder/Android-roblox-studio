package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/RobloxGlobals;", method = "install$lambda$35$lambda$34", proto = "(Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lorg/luaj/vm2/LuaThread;Lorg/luaj/vm2/Varargs;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class RobloxGlobals$$ExternalSyntheticLambda0 implements Function0 {
    public final /* synthetic */ LuaRuntime f$0;
    public final /* synthetic */ LuaThread f$1;
    public final /* synthetic */ Varargs f$2;

    public /* synthetic */ RobloxGlobals$$ExternalSyntheticLambda0(LuaRuntime luaRuntime, LuaThread luaThread, Varargs varargs) {
        this.f$0 = luaRuntime;
        this.f$1 = luaThread;
        this.f$2 = varargs;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return RobloxGlobals.install$lambda$35$lambda$34(this.f$0, this.f$1, this.f$2);
    }
}
