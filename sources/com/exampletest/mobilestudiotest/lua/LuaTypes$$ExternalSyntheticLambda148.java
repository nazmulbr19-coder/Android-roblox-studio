package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/LuaTypes;", method = "lambda$76$lambda$72", proto = "(Lcom/exampletest/mobilestudiotest/lua/EnumTypeV;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class LuaTypes$$ExternalSyntheticLambda148 implements Function1 {
    public final /* synthetic */ EnumTypeV f$0;

    public /* synthetic */ LuaTypes$$ExternalSyntheticLambda148(EnumTypeV enumTypeV) {
        this.f$0 = enumTypeV;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return LuaTypes.lambda$76$lambda$72(this.f$0, (Varargs) obj);
    }
}
