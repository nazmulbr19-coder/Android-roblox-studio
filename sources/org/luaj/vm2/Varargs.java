package org.luaj.vm2;

/* loaded from: classes10.dex */
public abstract class Varargs {

    /* loaded from: classes10.dex */
    static final class ArrayPartVarargs extends Varargs {
        private final int length;
        private final Varargs more;
        private final int offset;
        private final LuaValue[] v;

        ArrayPartVarargs(LuaValue[] luaValueArr, int i, int i2) {
            this.v = luaValueArr;
            this.offset = i;
            this.length = i2;
            this.more = LuaValue.NONE;
        }

        public ArrayPartVarargs(LuaValue[] luaValueArr, int i, int i2, Varargs varargs) {
            this.v = luaValueArr;
            this.offset = i;
            this.length = i2;
            this.more = varargs;
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            return i < 1 ? LuaValue.NIL : i <= this.length ? this.v[(this.offset + i) - 1] : this.more.arg(i - this.length);
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return this.length > 0 ? this.v[this.offset] : this.more.arg1();
        }

        @Override // org.luaj.vm2.Varargs
        void copyto(LuaValue[] luaValueArr, int i, int i2) {
            int min = Math.min(this.length, i2);
            System.arraycopy(this.v, this.offset, luaValueArr, i, min);
            this.more.copyto(luaValueArr, i + min, i2 - min);
        }

        @Override // org.luaj.vm2.Varargs
        public int narg() {
            return this.length + this.more.narg();
        }

        @Override // org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            if (i <= 0) {
                LuaValue.argerror(1, "start must be > 0");
            }
            return i == 1 ? this : i > this.length ? this.more.subargs(i - this.length) : LuaValue.varargsOf(this.v, (this.offset + i) - 1, this.length - (i - 1), this.more);
        }
    }

    /* loaded from: classes10.dex */
    static final class ArrayVarargs extends Varargs {
        private final Varargs r;
        private final LuaValue[] v;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ArrayVarargs(LuaValue[] luaValueArr, Varargs varargs) {
            this.v = luaValueArr;
            this.r = varargs;
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            return i < 1 ? LuaValue.NIL : i <= this.v.length ? this.v[i - 1] : this.r.arg(i - this.v.length);
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return this.v.length > 0 ? this.v[0] : this.r.arg1();
        }

        @Override // org.luaj.vm2.Varargs
        void copyto(LuaValue[] luaValueArr, int i, int i2) {
            int min = Math.min(this.v.length, i2);
            System.arraycopy(this.v, 0, luaValueArr, i, min);
            this.r.copyto(luaValueArr, i + min, i2 - min);
        }

        @Override // org.luaj.vm2.Varargs
        public int narg() {
            return this.v.length + this.r.narg();
        }

        @Override // org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            if (i <= 0) {
                LuaValue.argerror(1, "start must be > 0");
            }
            if (i == 1) {
                return this;
            }
            if (i > this.v.length) {
                return this.r.subargs(i - this.v.length);
            }
            int i2 = i - 1;
            return LuaValue.varargsOf(this.v, i2, this.v.length - i2, this.r);
        }
    }

    /* loaded from: classes10.dex */
    static final class PairVarargs extends Varargs {
        private final LuaValue v1;
        private final Varargs v2;

        /* JADX INFO: Access modifiers changed from: package-private */
        public PairVarargs(LuaValue luaValue, Varargs varargs) {
            this.v1 = luaValue;
            this.v2 = varargs;
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            return i == 1 ? this.v1 : this.v2.arg(i - 1);
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return this.v1;
        }

        @Override // org.luaj.vm2.Varargs
        public int narg() {
            return this.v2.narg() + 1;
        }

        @Override // org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            return i == 1 ? this : i == 2 ? this.v2 : i > 2 ? this.v2.subargs(i - 1) : LuaValue.argerror(1, "start must be > 0");
        }
    }

    /* loaded from: classes10.dex */
    static class SubVarargs extends Varargs {
        private final int end;
        private final int start;
        private final Varargs v;

        public SubVarargs(Varargs varargs, int i, int i2) {
            this.v = varargs;
            this.start = i;
            this.end = i2;
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg(int i) {
            int i2 = i + (this.start - 1);
            return (i2 < this.start || i2 > this.end) ? LuaValue.NIL : this.v.arg(i2);
        }

        @Override // org.luaj.vm2.Varargs
        public LuaValue arg1() {
            return this.v.arg(this.start);
        }

        @Override // org.luaj.vm2.Varargs
        public int narg() {
            return (this.end + 1) - this.start;
        }

        @Override // org.luaj.vm2.Varargs
        public Varargs subargs(int i) {
            if (i == 1) {
                return this;
            }
            int i2 = (this.start + i) - 1;
            return i > 0 ? i2 >= this.end ? LuaValue.NONE : i2 == this.end ? this.v.arg(this.end) : i2 == this.end - 1 ? new PairVarargs(this.v.arg(this.end - 1), this.v.arg(this.end)) : new SubVarargs(this.v, i2, this.end) : new SubVarargs(this.v, i2, this.end);
        }
    }

    public abstract LuaValue arg(int i);

    public abstract LuaValue arg1();

    public void argcheck(boolean z, int i, String str) {
        if (z) {
            return;
        }
        LuaValue.argerror(i, str);
    }

    public boolean checkboolean(int i) {
        return arg(i).checkboolean();
    }

    public LuaClosure checkclosure(int i) {
        return arg(i).checkclosure();
    }

    public double checkdouble(int i) {
        return arg(i).checknumber().todouble();
    }

    public LuaFunction checkfunction(int i) {
        return arg(i).checkfunction();
    }

    public int checkint(int i) {
        return arg(i).checknumber().toint();
    }

    public LuaInteger checkinteger(int i) {
        return arg(i).checkinteger();
    }

    public String checkjstring(int i) {
        return arg(i).checkjstring();
    }

    public long checklong(int i) {
        return arg(i).checknumber().tolong();
    }

    public LuaValue checknotnil(int i) {
        return arg(i).checknotnil();
    }

    public LuaNumber checknumber(int i) {
        return arg(i).checknumber();
    }

    public LuaString checkstring(int i) {
        return arg(i).checkstring();
    }

    public LuaTable checktable(int i) {
        return arg(i).checktable();
    }

    public LuaThread checkthread(int i) {
        return arg(i).checkthread();
    }

    public Object checkuserdata(int i) {
        return arg(i).checkuserdata();
    }

    public Object checkuserdata(int i, Class cls) {
        return arg(i).checkuserdata(cls);
    }

    public LuaValue checkvalue(int i) {
        return i <= narg() ? arg(i) : LuaValue.argerror(i, "value expected");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void copyto(LuaValue[] luaValueArr, int i, int i2) {
        int i3 = 0;
        while (i3 < i2) {
            int i4 = i + i3;
            i3++;
            luaValueArr[i4] = arg(i3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Varargs dealias() {
        int narg = narg();
        switch (narg) {
            case 0:
                return LuaValue.NONE;
            case 1:
                return arg1();
            case 2:
                return new PairVarargs(arg1(), arg(2));
            default:
                LuaValue[] luaValueArr = new LuaValue[narg];
                copyto(luaValueArr, 0, narg);
                return new ArrayVarargs(luaValueArr, LuaValue.NONE);
        }
    }

    public Varargs eval() {
        return this;
    }

    public boolean isTailcall() {
        return false;
    }

    public boolean isfunction(int i) {
        return arg(i).isfunction();
    }

    public boolean isnil(int i) {
        return arg(i).isnil();
    }

    public boolean isnoneornil(int i) {
        return i > narg() || arg(i).isnil();
    }

    public boolean isnumber(int i) {
        return arg(i).isnumber();
    }

    public boolean isstring(int i) {
        return arg(i).isstring();
    }

    public boolean istable(int i) {
        return arg(i).istable();
    }

    public boolean isthread(int i) {
        return arg(i).isthread();
    }

    public boolean isuserdata(int i) {
        return arg(i).isuserdata();
    }

    public boolean isvalue(int i) {
        return i > 0 && i <= narg();
    }

    public abstract int narg();

    public boolean optboolean(int i, boolean z) {
        return arg(i).optboolean(z);
    }

    public LuaClosure optclosure(int i, LuaClosure luaClosure) {
        return arg(i).optclosure(luaClosure);
    }

    public double optdouble(int i, double d) {
        return arg(i).optdouble(d);
    }

    public LuaFunction optfunction(int i, LuaFunction luaFunction) {
        return arg(i).optfunction(luaFunction);
    }

    public int optint(int i, int i2) {
        return arg(i).optint(i2);
    }

    public LuaInteger optinteger(int i, LuaInteger luaInteger) {
        return arg(i).optinteger(luaInteger);
    }

    public String optjstring(int i, String str) {
        return arg(i).optjstring(str);
    }

    public long optlong(int i, long j) {
        return arg(i).optlong(j);
    }

    public LuaNumber optnumber(int i, LuaNumber luaNumber) {
        return arg(i).optnumber(luaNumber);
    }

    public LuaString optstring(int i, LuaString luaString) {
        return arg(i).optstring(luaString);
    }

    public LuaTable opttable(int i, LuaTable luaTable) {
        return arg(i).opttable(luaTable);
    }

    public LuaThread optthread(int i, LuaThread luaThread) {
        return arg(i).optthread(luaThread);
    }

    public Object optuserdata(int i, Class cls, Object obj) {
        return arg(i).optuserdata(cls, obj);
    }

    public Object optuserdata(int i, Object obj) {
        return arg(i).optuserdata(obj);
    }

    public LuaValue optvalue(int i, LuaValue luaValue) {
        return (i <= 0 || i > narg()) ? luaValue : arg(i);
    }

    public abstract Varargs subargs(int i);

    public String toString() {
        return tojstring();
    }

    public boolean toboolean(int i) {
        return arg(i).toboolean();
    }

    public byte tobyte(int i) {
        return arg(i).tobyte();
    }

    public char tochar(int i) {
        return arg(i).tochar();
    }

    public double todouble(int i) {
        return arg(i).todouble();
    }

    public float tofloat(int i) {
        return arg(i).tofloat();
    }

    public int toint(int i) {
        return arg(i).toint();
    }

    public String tojstring() {
        Buffer buffer = new Buffer();
        buffer.append("(");
        int narg = narg();
        for (int i = 1; i <= narg; i++) {
            if (i > 1) {
                buffer.append(",");
            }
            buffer.append(arg(i).tojstring());
        }
        buffer.append(")");
        return buffer.tojstring();
    }

    public String tojstring(int i) {
        return arg(i).tojstring();
    }

    public long tolong(int i) {
        return arg(i).tolong();
    }

    public short toshort(int i) {
        return arg(i).toshort();
    }

    public Object touserdata(int i) {
        return arg(i).touserdata();
    }

    public Object touserdata(int i, Class cls) {
        return arg(i).touserdata(cls);
    }

    public int type(int i) {
        return arg(i).type();
    }
}
