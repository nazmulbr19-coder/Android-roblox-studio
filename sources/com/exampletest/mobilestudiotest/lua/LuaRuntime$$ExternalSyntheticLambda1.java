package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function1;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", method = "playTween$lambda$23", proto = "(Lcom/exampletest/mobilestudiotest/lua/Tween;Lcom/exampletest/mobilestudiotest/lua/Tween;)Z")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class LuaRuntime$$ExternalSyntheticLambda1 implements Function1 {
    public final /* synthetic */ Tween f$0;

    public /* synthetic */ LuaRuntime$$ExternalSyntheticLambda1(Tween tween) {
        this.f$0 = tween;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return Boolean.valueOf(LuaRuntime.playTween$lambda$23(this.f$0, (Tween) obj));
    }
}
