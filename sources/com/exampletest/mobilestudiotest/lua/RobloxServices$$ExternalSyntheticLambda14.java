package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import org.luaj.vm2.LuaThread;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/RobloxServices;", method = "productInfo$lambda$32", proto = "(JLcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lorg/luaj/vm2/LuaThread;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class RobloxServices$$ExternalSyntheticLambda14 implements Runnable {
    public final /* synthetic */ long f$0;
    public final /* synthetic */ LuaRuntime f$1;
    public final /* synthetic */ LuaThread f$2;

    public /* synthetic */ RobloxServices$$ExternalSyntheticLambda14(long j, LuaRuntime luaRuntime, LuaThread luaThread) {
        this.f$0 = j;
        this.f$1 = luaRuntime;
        this.f$2 = luaThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RobloxServices.productInfo$lambda$32(this.f$0, this.f$1, this.f$2);
    }
}
