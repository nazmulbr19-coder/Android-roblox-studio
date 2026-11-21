package org.luaj.vm2;

import androidx.constraintlayout.core.motion.utils.TypedValues;

/* loaded from: classes10.dex */
public final class LuaBoolean extends LuaValue {
    public static LuaValue s_metatable;
    public final boolean v;
    static final LuaBoolean _TRUE = new LuaBoolean(true);
    static final LuaBoolean _FALSE = new LuaBoolean(false);

    LuaBoolean(boolean z) {
        this.v = z;
    }

    public boolean booleanValue() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean checkboolean() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return s_metatable;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isboolean() {
        return true;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue not() {
        return this.v ? FALSE : LuaValue.TRUE;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean optboolean(boolean z) {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean toboolean() {
        return this.v;
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return this.v ? "true" : "false";
    }

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 1;
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return TypedValues.Custom.S_BOOLEAN;
    }
}
