package com.exampletest.mobilestudiotest.core;

import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import com.exampletest.mobilestudiotest.model.Instance;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Studio.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/PluginWidget;", "", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Instance;Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;)V", "getInst", "()Lcom/exampletest/mobilestudiotest/model/Instance;", "getRt", "()Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PluginWidget {
    private final Instance inst;
    private final LuaRuntime rt;

    public PluginWidget(Instance inst, LuaRuntime rt) {
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(rt, "rt");
        this.inst = inst;
        this.rt = rt;
    }

    public final Instance getInst() {
        return this.inst;
    }

    public final LuaRuntime getRt() {
        return this.rt;
    }
}
