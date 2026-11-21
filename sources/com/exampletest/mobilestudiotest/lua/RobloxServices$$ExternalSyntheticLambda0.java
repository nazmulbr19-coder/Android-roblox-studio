package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.HashMap;
import org.luaj.vm2.LuaThread;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/RobloxServices;", method = "http$lambda$58", proto = "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;Lorg/luaj/vm2/LuaThread;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class RobloxServices$$ExternalSyntheticLambda0 implements Runnable {
    public final /* synthetic */ String f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ String f$2;
    public final /* synthetic */ LuaRuntime f$3;
    public final /* synthetic */ String f$4;
    public final /* synthetic */ HashMap f$5;
    public final /* synthetic */ String f$6;
    public final /* synthetic */ LuaThread f$7;

    public /* synthetic */ RobloxServices$$ExternalSyntheticLambda0(String str, String str2, String str3, LuaRuntime luaRuntime, String str4, HashMap hashMap, String str5, LuaThread luaThread) {
        this.f$0 = str;
        this.f$1 = str2;
        this.f$2 = str3;
        this.f$3 = luaRuntime;
        this.f$4 = str4;
        this.f$5 = hashMap;
        this.f$6 = str5;
        this.f$7 = luaThread;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RobloxServices.http$lambda$58(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7);
    }
}
