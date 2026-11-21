package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.lua.LuauTranspiler;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$Parser;", method = "exprStatement$lambda$2", proto = "(Lcom/exampletest/mobilestudiotest/lua/LuauTranspiler$Parser;I)Ljava/lang/CharSequence;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class LuauTranspiler$Parser$$ExternalSyntheticLambda0 implements Function1 {
    public final /* synthetic */ LuauTranspiler.Parser f$0;

    public /* synthetic */ LuauTranspiler$Parser$$ExternalSyntheticLambda0(LuauTranspiler.Parser parser) {
        this.f$0 = parser;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return LuauTranspiler.Parser.exprStatement$lambda$2(this.f$0, ((Integer) obj).intValue());
    }
}
