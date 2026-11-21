package org.luaj.vm2;

/* loaded from: classes10.dex */
public class Prototype {
    public int[] code;
    public int is_vararg;
    public LuaValue[] k;
    public int lastlinedefined;
    public int linedefined;
    public int[] lineinfo;
    public LocVars[] locvars;
    public int maxstacksize;
    public int numparams;
    public Prototype[] p;
    public LuaString source;
    public Upvaldesc[] upvalues;
    private static final Upvaldesc[] NOUPVALUES = new Upvaldesc[0];
    private static final Prototype[] NOSUBPROTOS = new Prototype[0];

    public Prototype() {
        this.p = NOSUBPROTOS;
        this.upvalues = NOUPVALUES;
    }

    public Prototype(int i) {
        this.p = NOSUBPROTOS;
        this.upvalues = new Upvaldesc[i];
    }

    public LuaString getlocalname(int i, int i2) {
        for (int i3 = 0; i3 < this.locvars.length && this.locvars[i3].startpc <= i2; i3++) {
            if (i2 < this.locvars[i3].endpc && i - 1 == 0) {
                return this.locvars[i3].varname;
            }
        }
        return null;
    }

    public String shortsource() {
        String str = this.source.tojstring();
        return (str.startsWith("@") || str.startsWith("=")) ? str.substring(1) : str.startsWith("\u001b") ? LoadState.SOURCE_BINARY_STRING : str;
    }

    public String toString() {
        return new StringBuffer().append(this.source).append(":").append(this.linedefined).append("-").append(this.lastlinedefined).toString();
    }
}
