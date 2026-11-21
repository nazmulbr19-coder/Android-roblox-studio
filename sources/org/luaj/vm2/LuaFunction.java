package org.luaj.vm2;

/* loaded from: classes10.dex */
public abstract class LuaFunction extends LuaValue {
    public static LuaValue s_metatable;

    @Override // org.luaj.vm2.LuaValue
    public LuaFunction checkfunction() {
        return this;
    }

    public String classnamestub() {
        String name = getClass().getName();
        return name.substring(Math.max(name.lastIndexOf(46), name.lastIndexOf(36)) + 1);
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaValue getmetatable() {
        return s_metatable;
    }

    @Override // org.luaj.vm2.LuaValue
    public boolean isfunction() {
        return true;
    }

    public String name() {
        return classnamestub();
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaFunction optfunction(LuaFunction luaFunction) {
        return this;
    }

    @Override // org.luaj.vm2.LuaValue
    public LuaString strvalue() {
        return valueOf(tojstring());
    }

    @Override // org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return new StringBuffer().append("function: ").append(classnamestub()).toString();
    }

    @Override // org.luaj.vm2.LuaValue
    public int type() {
        return 6;
    }

    @Override // org.luaj.vm2.LuaValue
    public String typename() {
        return "function";
    }
}
