package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import java.util.List;
import org.luaj.vm2.LuaThread;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/PluginApi;", method = "menu$lambda$26$lambda$25", proto = "(Lcom/exampletest/mobilestudiotest/core/Studio;Ljava/lang/String;Ljava/util/List;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Lorg/luaj/vm2/LuaThread;Ljava/util/List;)V")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class PluginApi$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ Studio f$0;
    public final /* synthetic */ String f$1;
    public final /* synthetic */ List f$2;
    public final /* synthetic */ LuaRuntime f$3;
    public final /* synthetic */ LuaThread f$4;
    public final /* synthetic */ List f$5;

    public /* synthetic */ PluginApi$$ExternalSyntheticLambda1(Studio studio, String str, List list, LuaRuntime luaRuntime, LuaThread luaThread, List list2) {
        this.f$0 = studio;
        this.f$1 = str;
        this.f$2 = list;
        this.f$3 = luaRuntime;
        this.f$4 = luaThread;
        this.f$5 = list2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        PluginApi.menu$lambda$26$lambda$25(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4, this.f$5);
    }
}
