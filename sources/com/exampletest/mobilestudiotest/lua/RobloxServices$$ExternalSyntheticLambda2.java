package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import org.luaj.vm2.LuaThread;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/RobloxServices;", method = "http$lambda$58$lambda$57", proto = "(Lkotlin/jvm/internal/Ref$ObjectRef;Ljava/lang/String;Lkotlin/jvm/internal/Ref$IntRef;Lkotlin/jvm/internal/Ref$ObjectRef;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lorg/luaj/vm2/LuaThread;)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class RobloxServices$$ExternalSyntheticLambda2 implements Function0 {
    public final /* synthetic */ Ref.ObjectRef f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ Ref.IntRef f$2;
    public final /* synthetic */ Ref.ObjectRef f$3;
    public final /* synthetic */ LuaRuntime f$4;
    public final /* synthetic */ LuaThread f$5;

    public /* synthetic */ RobloxServices$$ExternalSyntheticLambda2(Ref.ObjectRef objectRef, String str, Ref.IntRef intRef, Ref.ObjectRef objectRef2, LuaRuntime luaRuntime, LuaThread luaThread) {
        this.f$0 = objectRef;
        this.f$1 = str;
        this.f$2 = intRef;
        this.f$3 = objectRef2;
        this.f$4 = luaRuntime;
        this.f$5 = luaThread;
    }

    @Override // kotlin.jvm.functions.Function0
    public final Object invoke() {
        return RobloxServices.http$lambda$58$lambda$57(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
