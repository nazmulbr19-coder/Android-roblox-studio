package org.luaj.vm2.lib;

import androidx.core.app.NotificationCompat;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: classes10.dex */
public class CoroutineLib extends TwoArgFunction {
    static int coroutine_count = 0;
    Globals globals;

    /* loaded from: classes10.dex */
    final class create extends LibFunction {
        create() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return new LuaThread(CoroutineLib.this.globals, luaValue.checkfunction());
        }
    }

    /* loaded from: classes10.dex */
    final class resume extends VarArgFunction {
        resume() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargs.checkthread(1).resume(varargs.subargs(2));
        }
    }

    /* loaded from: classes10.dex */
    final class running extends VarArgFunction {
        running() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaThread luaThread = CoroutineLib.this.globals.running;
            return varargsOf(luaThread, valueOf(luaThread.isMainThread()));
        }
    }

    /* loaded from: classes10.dex */
    static final class status extends LibFunction {
        status() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(luaValue.checkthread().getStatus());
        }
    }

    /* loaded from: classes10.dex */
    final class wrap extends LibFunction {
        wrap() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return new wrapper(new LuaThread(CoroutineLib.this.globals, luaValue.checkfunction()));
        }
    }

    /* loaded from: classes10.dex */
    final class wrapper extends VarArgFunction {
        final LuaThread luathread;

        wrapper(LuaThread luaThread) {
            this.luathread = luaThread;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            Varargs resume = this.luathread.resume(varargs);
            return resume.arg1().toboolean() ? resume.subargs(2) : error(resume.arg(2).tojstring());
        }
    }

    /* loaded from: classes10.dex */
    final class yield extends VarArgFunction {
        yield() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return CoroutineLib.this.globals.yield(varargs);
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        this.globals = luaValue2.checkglobals();
        LuaTable luaTable = new LuaTable();
        luaTable.set("create", new create());
        luaTable.set("resume", new resume());
        luaTable.set("running", new running());
        luaTable.set(NotificationCompat.CATEGORY_STATUS, new status());
        luaTable.set("yield", new yield());
        luaTable.set("wrap", new wrap());
        luaValue2.set("coroutine", luaTable);
        luaValue2.get("package").get("loaded").set("coroutine", luaTable);
        return luaTable;
    }
}
