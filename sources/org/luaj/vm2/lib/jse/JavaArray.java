package org.luaj.vm2.lib.jse;

import java.lang.reflect.Array;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.OneArgFunction;

/* loaded from: classes10.dex */
class JavaArray extends LuaUserdata {
    static final LuaValue LENGTH = valueOf("length");
    static final LuaTable array_metatable = new LuaTable();

    /* loaded from: classes10.dex */
    private static final class LenFunction extends OneArgFunction {
        private LenFunction() {
        }

        /* synthetic */ LenFunction(AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return LuaValue.valueOf(Array.getLength(((LuaUserdata) luaValue).m_instance));
        }
    }

    static {
        array_metatable.rawset(LuaValue.LEN, new LenFunction(null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public JavaArray(Object obj) {
        super(obj);
        setmetatable(array_metatable);
    }

    @Override // org.luaj.vm2.LuaUserdata, org.luaj.vm2.LuaValue
    public LuaValue get(LuaValue luaValue) {
        if (luaValue.equals(LENGTH)) {
            return valueOf(Array.getLength(this.m_instance));
        }
        if (!luaValue.isint()) {
            return super.get(luaValue);
        }
        int i = luaValue.toint() - 1;
        return (i < 0 || i >= Array.getLength(this.m_instance)) ? NIL : CoerceJavaToLua.coerce(Array.get(this.m_instance, luaValue.toint() - 1));
    }

    @Override // org.luaj.vm2.LuaUserdata, org.luaj.vm2.LuaValue
    public void set(LuaValue luaValue, LuaValue luaValue2) {
        if (!luaValue.isint()) {
            super.set(luaValue, luaValue2);
            return;
        }
        int i = luaValue.toint() - 1;
        if (i >= 0 && i < Array.getLength(this.m_instance)) {
            Array.set(this.m_instance, i, CoerceLuaToJava.coerce(luaValue2, this.m_instance.getClass().getComponentType()));
        } else if (this.m_metatable == null || !settable(this, luaValue, luaValue2)) {
            error("array index out of bounds");
        }
    }
}
