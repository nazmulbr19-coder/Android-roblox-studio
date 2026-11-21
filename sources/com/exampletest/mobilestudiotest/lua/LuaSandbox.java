package com.exampletest.mobilestudiotest.lua;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

/* compiled from: LuaSandbox.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/LuaSandbox;", "", "<init>", "()V", "ESC", "Lorg/luaj/vm2/LuaString;", "kotlin.jvm.PlatformType", "lockDown", "", "g", "Lorg/luaj/vm2/Globals;", "isBytecode", "", "v", "Lorg/luaj/vm2/LuaValue;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuaSandbox {
    public static final LuaSandbox INSTANCE = new LuaSandbox();
    private static final LuaString ESC = LuaString.valueOf("\u001bLua");

    private LuaSandbox() {
    }

    public final boolean isBytecode(LuaValue v) {
        Intrinsics.checkNotNullParameter(v, "v");
        if (!v.isstring()) {
            return false;
        }
        LuaString checkstring = v.checkstring();
        return (checkstring.length() >= 1 && checkstring.luaByte(0) == 27) || (checkstring.length() >= ESC.length() && checkstring.substring(0, ESC.length()).raweq(ESC));
    }

    public final void lockDown(Globals g) {
        Intrinsics.checkNotNullParameter(g, "g");
        Iterator it = CollectionsKt.listOf((Object[]) new String[]{"package", "require", "luajava", "io", "dofile", "loadfile", "module"}).iterator();
        while (it.hasNext()) {
            g.set((String) it.next(), LuaValue.NIL);
        }
        LuaValue luaValue = g.get("os");
        LuaTable luaTable = new LuaTable();
        if (luaValue.istable()) {
            for (String str : CollectionsKt.listOf((Object[]) new String[]{"time", "clock", "date", "difftime"})) {
                luaTable.set(str, luaValue.get(str));
            }
        }
        g.set("os", luaTable);
        LuaValue luaValue2 = g.get(TypedValues.Custom.S_STRING);
        if (luaValue2.istable()) {
            luaValue2.set("dump", LuaValue.NIL);
        }
        LuaValue luaValue3 = LuaString.s_metatable;
        LuaValue luaValue4 = luaValue3 != null ? luaValue3.get(LuaValue.INDEX) : null;
        if (luaValue4 != null && luaValue4.istable()) {
            luaValue4.set("dump", LuaValue.NIL);
        }
        g.set("load", new LuaSandbox$lockDown$1(g.get("load")));
    }
}
