package org.luaj.vm2;

/* loaded from: classes10.dex */
public class TailcallVarargs extends Varargs {
    private Varargs args;
    private LuaValue func;
    private Varargs result;

    public TailcallVarargs(LuaValue luaValue, LuaValue luaValue2, Varargs varargs) {
        this.func = luaValue.get(luaValue2);
        this.args = LuaValue.varargsOf(luaValue, varargs);
    }

    public TailcallVarargs(LuaValue luaValue, Varargs varargs) {
        this.func = luaValue;
        this.args = varargs;
    }

    @Override // org.luaj.vm2.Varargs
    public LuaValue arg(int i) {
        if (this.result == null) {
            eval();
        }
        return this.result.arg(i);
    }

    @Override // org.luaj.vm2.Varargs
    public LuaValue arg1() {
        if (this.result == null) {
            eval();
        }
        return this.result.arg1();
    }

    @Override // org.luaj.vm2.Varargs
    public Varargs eval() {
        Varargs varargs;
        while (this.result == null) {
            Varargs onInvoke = this.func.onInvoke(this.args);
            if (onInvoke.isTailcall()) {
                TailcallVarargs tailcallVarargs = (TailcallVarargs) onInvoke;
                this.func = tailcallVarargs.func;
                varargs = tailcallVarargs.args;
            } else {
                this.result = onInvoke;
                varargs = null;
                this.func = null;
            }
            this.args = varargs;
        }
        return this.result;
    }

    @Override // org.luaj.vm2.Varargs
    public boolean isTailcall() {
        return true;
    }

    @Override // org.luaj.vm2.Varargs
    public int narg() {
        if (this.result == null) {
            eval();
        }
        return this.result.narg();
    }

    @Override // org.luaj.vm2.Varargs
    public Varargs subargs(int i) {
        if (this.result == null) {
            eval();
        }
        return this.result.subargs(i);
    }
}
