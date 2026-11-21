package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.LuaThread;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", method = "cancel$lambda$13", proto = "(Lorg/luaj/vm2/LuaThread;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime$Waiting;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class LuaRuntime$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ LuaThread f$0;

    public /* synthetic */ LuaRuntime$$ExternalSyntheticLambda7(LuaThread luaThread) {
        this.f$0 = luaThread;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(LuaRuntime.cancel$lambda$13(this.f$0, (LuaRuntime.Waiting) obj));
    }
}
