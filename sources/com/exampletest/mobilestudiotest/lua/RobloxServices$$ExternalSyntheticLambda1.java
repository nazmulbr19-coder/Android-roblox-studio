package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;
import org.luaj.vm2.LuaThread;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/RobloxServices;", method = "productInfo$lambda$32$lambda$31", proto = "(Ljava/lang/String;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lorg/luaj/vm2/LuaThread;J)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class RobloxServices$$ExternalSyntheticLambda1 implements Function0 {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ LuaRuntime f$1;
    public final /* synthetic */ LuaThread f$2;
    public final /* synthetic */ long f$3;

    public /* synthetic */ RobloxServices$$ExternalSyntheticLambda1(String str, LuaRuntime luaRuntime, LuaThread luaThread, long j) {
        this.f$0 = str;
        this.f$1 = luaRuntime;
        this.f$2 = luaThread;
        this.f$3 = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return RobloxServices.productInfo$lambda$32$lambda$31(this.f$0, this.f$1, this.f$2, this.f$3);
    }
}
