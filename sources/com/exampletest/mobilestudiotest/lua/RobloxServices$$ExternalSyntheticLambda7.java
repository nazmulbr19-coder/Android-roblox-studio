package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function2;
import org.luaj.vm2.LuaValue;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/RobloxServices;", method = "tweenValue$lambda$39", proto = "(Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lcom/exampletest/mobilestudiotest/lua/Tween;Lorg/luaj/vm2/LuaValue;Lorg/luaj/vm2/LuaValue;)Lorg/luaj/vm2/LuaValue;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class RobloxServices$$ExternalSyntheticLambda7 implements Function2 {
    public final /* synthetic */ LuaRuntime f$0;
    public final /* synthetic */ Tween f$1;

    public /* synthetic */ RobloxServices$$ExternalSyntheticLambda7(LuaRuntime luaRuntime, Tween tween) {
        this.f$0 = luaRuntime;
        this.f$1 = tween;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return RobloxServices.tweenValue$lambda$39(this.f$0, this.f$1, (LuaValue) obj, (LuaValue) obj2);
    }
}
