package org.luaj.vm2;

/* loaded from: classes10.dex */
public class Upvaldesc {
    public final short idx;
    public final boolean instack;
    public LuaString name;

    public Upvaldesc(LuaString luaString, boolean z, int i) {
        this.name = luaString;
        this.instack = z;
        this.idx = (short) i;
    }

    public String toString() {
        return new StringBuffer().append((int) this.idx).append(this.instack ? " instack " : " closed ").append(String.valueOf(this.name)).toString();
    }
}
