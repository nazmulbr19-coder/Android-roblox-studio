package com.exampletest.mobilestudiotest.lua;

import com.android.tools.r8.annotations.LambdaMethod;
import com.android.tools.r8.annotations.SynthesizedClassV2;
import com.exampletest.mobilestudiotest.core.Studio;
import java.util.ArrayList;
import kotlin.jvm.functions.Function1;
import org.luaj.vm2.Varargs;

/* compiled from: D8$$SyntheticClass */
@LambdaMethod(holder = "Lcom/exampletest/mobilestudiotest/lua/PluginApi;", method = "menu$lambda$26", proto = "(Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;Ljava/util/ArrayList;Lcom/exampletest/mobilestudiotest/core/Studio;Ljava/lang/String;Lorg/luaj/vm2/Varargs;)Lorg/luaj/vm2/Varargs;")
@SynthesizedClassV2(apiLevel = -2, kind = 28, versionHash = "64bbee9deb17f2433a2f464e7880a82f306bf117c38a5da5e35bd2560d29022a")
/* loaded from: classes4.dex */
public final /* synthetic */ class PluginApi$$ExternalSyntheticLambda8 implements Function1 {
    public final /* synthetic */ LuaRuntime f$0;
    public final /* synthetic */ ArrayList f$1;
    public final /* synthetic */ Studio f$2;
    public final /* synthetic */ String f$3;

    public /* synthetic */ PluginApi$$ExternalSyntheticLambda8(LuaRuntime luaRuntime, ArrayList arrayList, Studio studio, String str) {
        this.f$0 = luaRuntime;
        this.f$1 = arrayList;
        this.f$2 = studio;
        this.f$3 = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        return PluginApi.menu$lambda$26(this.f$0, this.f$1, this.f$2, this.f$3, (Varargs) obj);
    }
}
