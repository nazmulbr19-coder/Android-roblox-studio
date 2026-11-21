package org.luaj.vm2.compiler;

import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Prototype;

/* loaded from: classes10.dex */
public class LuaC extends Constants implements Globals.Compiler, Globals.Loader {
    public static final LuaC instance = new LuaC();

    /* loaded from: classes10.dex */
    static class CompileState {
        int nCcalls = 0;
        private Hashtable strings = new Hashtable();

        protected CompileState() {
        }

        static /* synthetic */ Prototype access$000(CompileState compileState, InputStream inputStream, String str) throws IOException {
            return compileState.luaY_parser(inputStream, str);
        }

        private Prototype luaY_parser(InputStream inputStream, String str) throws IOException {
            LexState lexState = new LexState(this, inputStream);
            FuncState funcState = new FuncState();
            lexState.fs = funcState;
            lexState.setinput(this, inputStream.read(), inputStream, LuaValue.valueOf(str));
            funcState.f = new Prototype();
            funcState.f.source = LuaValue.valueOf(str);
            lexState.mainfunc(funcState);
            boolean z = true;
            LuaC._assert(funcState.prev == null);
            if (lexState.dyd != null && (lexState.dyd.n_actvar != 0 || lexState.dyd.n_gt != 0 || lexState.dyd.n_label != 0)) {
                z = false;
            }
            LuaC._assert(z);
            return funcState.f;
        }

        public LuaString cachedLuaString(LuaString luaString) {
            LuaString luaString2 = (LuaString) this.strings.get(luaString);
            if (luaString2 != null) {
                return luaString2;
            }
            this.strings.put(luaString, luaString);
            return luaString;
        }

        public LuaString newTString(String str) {
            return cachedLuaString(LuaString.valueOf(str));
        }

        public LuaString newTString(LuaString luaString) {
            return cachedLuaString(luaString);
        }

        public String pushfstring(String str) {
            return str;
        }
    }

    protected LuaC() {
    }

    public static void install(Globals globals) {
        globals.compiler = instance;
        globals.loader = instance;
    }

    @Override // org.luaj.vm2.Globals.Compiler
    public Prototype compile(InputStream inputStream, String str) throws IOException {
        return CompileState.access$000(new CompileState(), inputStream, str);
    }

    @Override // org.luaj.vm2.Globals.Loader
    public LuaFunction load(Prototype prototype, String str, LuaValue luaValue) throws IOException {
        return new LuaClosure(prototype, luaValue);
    }

    public LuaValue load(InputStream inputStream, String str, Globals globals) throws IOException {
        return new LuaClosure(compile(inputStream, str), globals);
    }
}
