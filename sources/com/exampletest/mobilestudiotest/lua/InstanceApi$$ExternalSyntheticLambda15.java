package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function2;
import org.luaj.vm2.LuaValue;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", method = "_init_$lambda$0", proto = "(Lcom/exampletest/mobilestudiotest/lua/InstanceApi;Lorg/luaj/vm2/LuaValue;Lorg/luaj/vm2/LuaValue;)Lorg/luaj/vm2/LuaValue;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class InstanceApi$$ExternalSyntheticLambda15 implements Function2 {
    public final /* synthetic */ InstanceApi f$0;

    public /* synthetic */ InstanceApi$$ExternalSyntheticLambda15(InstanceApi instanceApi) {
        this.f$0 = instanceApi;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return InstanceApi._init_$lambda$0(this.f$0, (LuaValue) obj, (LuaValue) obj2);
    }
}
