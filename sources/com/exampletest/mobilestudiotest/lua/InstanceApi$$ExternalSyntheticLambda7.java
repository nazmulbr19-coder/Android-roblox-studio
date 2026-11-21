package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", method = "animationTrack$lambda$36", proto = "(Lcom/exampletest/mobilestudiotest/lua/InstanceApi;Lorg/luaj/vm2/LuaTable;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class InstanceApi$$ExternalSyntheticLambda7 implements Function1 {
    public final /* synthetic */ InstanceApi f$0;
    public final /* synthetic */ LuaTable f$1;

    public /* synthetic */ InstanceApi$$ExternalSyntheticLambda7(InstanceApi instanceApi, LuaTable luaTable) {
        this.f$0 = instanceApi;
        this.f$1 = luaTable;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return InstanceApi.animationTrack$lambda$36(this.f$0, this.f$1, (Varargs) obj);
    }
}
