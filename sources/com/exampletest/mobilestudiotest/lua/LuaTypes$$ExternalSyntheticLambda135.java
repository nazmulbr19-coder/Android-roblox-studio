package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/LuaTypes;", method = "lambda$68$lambda$67", proto = "(Lcom/exampletest/mobilestudiotest/lua/EnumItemV;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class LuaTypes$$ExternalSyntheticLambda135 implements Function1 {
    public final /* synthetic */ EnumItemV f$0;

    public /* synthetic */ LuaTypes$$ExternalSyntheticLambda135(EnumItemV enumItemV) {
        this.f$0 = enumItemV;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return LuaTypes.lambda$68$lambda$67(this.f$0, (Varargs) obj);
    }
}
