package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.engine.PlaySession;
import com.exampletest.mobilestudiotest.model.Instance;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", method = "animationTrack$lambda$40", proto = "(Lcom/exampletest/mobilestudiotest/engine/PlaySession$ScriptTrack;Lkotlin/jvm/internal/Ref$BooleanRef;Lkotlin/jvm/internal/Ref$FloatRef;Lkotlin/jvm/internal/Ref$ObjectRef;Lcom/exampletest/mobilestudiotest/lua/InstanceApi;Lkotlin/jvm/internal/Ref$ObjectRef;Lcom/exampletest/mobilestudiotest/model/Instance;Lorg/luaj/vm2/LuaTable;Lorg/luaj/vm2/LuaValue;Lorg/luaj/vm2/LuaValue;)Lorg/luaj/vm2/LuaValue;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class InstanceApi$$ExternalSyntheticLambda10 implements Function2 {
    public final /* synthetic */ PlaySession.ScriptTrack f$0;
    public final /* synthetic */ Ref.BooleanRef f$1;
    public final /* synthetic */ Ref.FloatRef f$2;
    public final /* synthetic */ Ref.ObjectRef f$3;
    public final /* synthetic */ InstanceApi f$4;
    public final /* synthetic */ Ref.ObjectRef f$5;
    public final /* synthetic */ Instance f$6;
    public final /* synthetic */ LuaTable f$7;

    public /* synthetic */ InstanceApi$$ExternalSyntheticLambda10(PlaySession.ScriptTrack scriptTrack, Ref.BooleanRef booleanRef, Ref.FloatRef floatRef, Ref.ObjectRef objectRef, InstanceApi instanceApi, Ref.ObjectRef objectRef2, Instance instance, LuaTable luaTable) {
        this.f$0 = scriptTrack;
        this.f$1 = booleanRef;
        this.f$2 = floatRef;
        this.f$3 = objectRef;
        this.f$4 = instanceApi;
        this.f$5 = objectRef2;
        this.f$6 = instance;
        this.f$7 = luaTable;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(Object obj, Object obj2) {
        return InstanceApi.animationTrack$lambda$40(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5, this.f$6, this.f$7, (LuaValue) obj, (LuaValue) obj2);
    }
}
