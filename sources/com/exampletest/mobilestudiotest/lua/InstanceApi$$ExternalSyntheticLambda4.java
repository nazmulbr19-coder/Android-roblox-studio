package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", method = "animationTrack$lambda$31", proto = "(Lcom/exampletest/mobilestudiotest/engine/PlaySession$ScriptTrack;Lcom/exampletest/mobilestudiotest/engine/PlaySession;Lkotlin/jvm/internal/Ref$BooleanRef;Lcom/exampletest/mobilestudiotest/lua/InstanceApi;Lorg/luaj/vm2/LuaTable;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class InstanceApi$$ExternalSyntheticLambda4 implements Function1 {
    public final /* synthetic */ PlaySession.ScriptTrack f$0;
    public final /* synthetic */ PlaySession f$1;
    public final /* synthetic */ Ref.BooleanRef f$2;
    public final /* synthetic */ InstanceApi f$3;
    public final /* synthetic */ LuaTable f$4;

    public /* synthetic */ InstanceApi$$ExternalSyntheticLambda4(PlaySession.ScriptTrack scriptTrack, PlaySession playSession, Ref.BooleanRef booleanRef, InstanceApi instanceApi, LuaTable luaTable) {
        this.f$0 = scriptTrack;
        this.f$1 = playSession;
        this.f$2 = booleanRef;
        this.f$3 = instanceApi;
        this.f$4 = luaTable;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return InstanceApi.animationTrack$lambda$31(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, (Varargs) obj);
    }
}
