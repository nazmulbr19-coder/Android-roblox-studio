package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.LuaThread;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/PluginApi;", method = "menu$lambda$26$lambda$25$lambda$24", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;Ljava/util/List;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lorg/luaj/vm2/LuaThread;I)Lkotlin/Unit;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class PluginApi$$ExternalSyntheticLambda13 implements Function1 {
    public final /* synthetic */ Studio f$0;
    public final /* synthetic */ List f$1;
    public final /* synthetic */ LuaRuntime f$2;
    public final /* synthetic */ LuaThread f$3;

    public /* synthetic */ PluginApi$$ExternalSyntheticLambda13(Studio studio, List list, LuaRuntime luaRuntime, LuaThread luaThread) {
        this.f$0 = studio;
        this.f$1 = list;
        this.f$2 = luaRuntime;
        this.f$3 = luaThread;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return PluginApi.menu$lambda$26$lambda$25$lambda$24(this.f$0, this.f$1, this.f$2, this.f$3, ((Integer) obj).intValue());
    }
}
