package com.exampletest.mobilestudiotest.core;

import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import com.exampletest.mobilestudiotest.model.Instance;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Studio.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/PluginButton;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "pluginName", "", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Ljava/lang/String;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getPluginName", "()Ljava/lang/String;", "getRt", "()Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PluginButton {
    private final Instance inst;
    private final String pluginName;
    private final LuaRuntime rt;

    public PluginButton(Instance inst, String pluginName, LuaRuntime rt) {
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(pluginName, "pluginName");
        Intrinsics.checkNotNullParameter(rt, "rt");
        this.inst = inst;
        this.pluginName = pluginName;
        this.rt = rt;
    }

    public final Instance getInst() {
        return this.inst;
    }

    public final String getPluginName() {
        return this.pluginName;
    }

    public final LuaRuntime getRt() {
        return this.rt;
    }
}
