package org.luaj.vm2;

/* loaded from: classes10.dex */
public class LocVars {
    public int endpc;
    public int startpc;
    public LuaString varname;

    public LocVars(LuaString luaString, int i, int i2) {
        this.varname = luaString;
        this.startpc = i;
        this.endpc = i2;
    }

    public String tojstring() {
        return new StringBuffer().append(this.varname).append(" ").append(this.startpc).append("-").append(this.endpc).toString();
    }
}
