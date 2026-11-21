package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.util.HashMap;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/RobloxServices;", method = "dataStore$lambda$46", proto = "(Ljava/util/HashMap;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class RobloxServices$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ HashMap f$0;
    public final /* synthetic */ LuaRuntime f$1;

    public /* synthetic */ RobloxServices$$ExternalSyntheticLambda8(HashMap hashMap, LuaRuntime luaRuntime) {
        this.f$0 = hashMap;
        this.f$1 = luaRuntime;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return RobloxServices.dataStore$lambda$46(this.f$0, this.f$1, (Varargs) obj);
    }
}
