package org.luaj.vm2.lib;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.io.IOException;
import java.io.InputStream;
import org.luaj.vm2.Globals;
import org.luaj.vm2.Lua;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: classes10.dex */
public class BaseLib extends TwoArgFunction implements ResourceFinder {
    Globals globals;

    /* loaded from: classes10.dex */
    private static class StringInputStream extends InputStream {
        byte[] bytes;
        final LuaValue func;
        int offset;
        int remaining = 0;

        StringInputStream(LuaValue luaValue) {
            this.func = luaValue;
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.remaining <= 0) {
                LuaValue call = this.func.call();
                if (call.isnil()) {
                    return -1;
                }
                LuaString strvalue = call.strvalue();
                this.bytes = strvalue.m_bytes;
                this.offset = strvalue.m_offset;
                this.remaining = strvalue.m_length;
                if (this.remaining <= 0) {
                    return -1;
                }
            }
            this.remaining--;
            byte[] bArr = this.bytes;
            int i = this.offset;
            this.offset = i + 1;
            return bArr[i];
        }
    }

    /* loaded from: classes10.dex */
    static final class _assert extends VarArgFunction {
        _assert() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            if (!varargs.arg1().toboolean()) {
                error(varargs.narg() > 1 ? varargs.optjstring(2, "assertion failed!") : "assertion failed!");
            }
            return varargs;
        }
    }

    /* loaded from: classes10.dex */
    static final class collectgarbage extends VarArgFunction {
        collectgarbage() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            String optjstring = varargs.optjstring(1, "collect");
            if ("collect".equals(optjstring)) {
                System.gc();
                return ZERO;
            }
            if ("count".equals(optjstring)) {
                Runtime runtime = Runtime.getRuntime();
                return varargsOf(valueOf((runtime.totalMemory() - runtime.freeMemory()) / 1024.0d), valueOf(r0 % 1024));
            }
            if ("step".equals(optjstring)) {
                System.gc();
                return LuaValue.TRUE;
            }
            argerror("gc op");
            return NIL;
        }
    }

    /* loaded from: classes10.dex */
    final class dofile extends VarArgFunction {
        dofile() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            varargs.argcheck(varargs.isstring(1) || varargs.isnil(1), 1, "filename must be string or nil");
            Varargs loadStream = (varargs.isstring(1) ? varargs.tojstring(1) : null) == null ? BaseLib.this.loadStream(BaseLib.this.globals.STDIN, "=stdin", "bt", BaseLib.this.globals) : BaseLib.this.loadFile(varargs.checkjstring(1), "bt", BaseLib.this.globals);
            return loadStream.isnil(1) ? error(loadStream.tojstring(2)) : loadStream.arg1().invoke();
        }
    }

    /* loaded from: classes10.dex */
    static final class error extends TwoArgFunction {
        error() {
        }

        @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            if (luaValue.isnil()) {
                throw new LuaError(null, luaValue2.optint(1));
            }
            if (luaValue.isstring()) {
                throw new LuaError(luaValue.tojstring(), luaValue2.optint(1));
            }
            throw new LuaError(luaValue);
        }
    }

    /* loaded from: classes10.dex */
    static final class getmetatable extends LibFunction {
        getmetatable() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return argerror(1, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            LuaValue luaValue2 = luaValue.getmetatable();
            return luaValue2 != null ? luaValue2.rawget(METATABLE).optvalue(luaValue2) : NIL;
        }
    }

    /* loaded from: classes10.dex */
    static final class inext extends VarArgFunction {
        inext() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargs.checktable(1).inext(varargs.arg(2));
        }
    }

    /* loaded from: classes10.dex */
    static final class ipairs extends VarArgFunction {
        inext inext = new inext();

        ipairs() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargsOf(this.inext, varargs.checktable(1), ZERO);
        }
    }

    /* loaded from: classes10.dex */
    final class load extends VarArgFunction {
        load() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaValue arg1 = varargs.arg1();
            varargs.argcheck(arg1.isstring() || arg1.isfunction(), 1, "ld must be string or function");
            return BaseLib.this.loadStream(arg1.isstring() ? arg1.strvalue().toInputStream() : new StringInputStream(arg1.checkfunction()), varargs.optjstring(2, arg1.isstring() ? arg1.tojstring() : "=(load)"), varargs.optjstring(3, "bt"), varargs.optvalue(4, BaseLib.this.globals));
        }
    }

    /* loaded from: classes10.dex */
    final class loadfile extends VarArgFunction {
        loadfile() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            varargs.argcheck(varargs.isstring(1) || varargs.isnil(1), 1, "filename must be string or nil");
            String str = varargs.isstring(1) ? varargs.tojstring(1) : null;
            String optjstring = varargs.optjstring(2, "bt");
            LuaValue optvalue = varargs.optvalue(3, BaseLib.this.globals);
            return str == null ? BaseLib.this.loadStream(BaseLib.this.globals.STDIN, "=stdin", optjstring, optvalue) : BaseLib.this.loadFile(str, optjstring, optvalue);
        }
    }

    /* loaded from: classes10.dex */
    static final class next extends VarArgFunction {
        next() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargs.checktable(1).next(varargs.arg(2));
        }
    }

    /* loaded from: classes10.dex */
    static final class pairs extends VarArgFunction {
        final next next;

        pairs(next nextVar) {
            this.next = nextVar;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            return varargsOf(this.next, varargs.checktable(1), NIL);
        }
    }

    /* loaded from: classes10.dex */
    final class pcall extends VarArgFunction {
        pcall() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaValue checkvalue = varargs.checkvalue(1);
            if (BaseLib.this.globals != null && BaseLib.this.globals.debuglib != null) {
                BaseLib.this.globals.debuglib.onCall(this);
            }
            try {
                try {
                    try {
                        Varargs varargsOf = varargsOf(TRUE, checkvalue.invoke(varargs.subargs(2)));
                        if (BaseLib.this.globals != null && BaseLib.this.globals.debuglib != null) {
                            BaseLib.this.globals.debuglib.onReturn();
                        }
                        return varargsOf;
                    } catch (Exception e) {
                        String message = e.getMessage();
                        LuaBoolean luaBoolean = FALSE;
                        if (message == null) {
                            message = e.toString();
                        }
                        Varargs varargsOf2 = varargsOf(luaBoolean, valueOf(message));
                        if (BaseLib.this.globals != null && BaseLib.this.globals.debuglib != null) {
                            BaseLib.this.globals.debuglib.onReturn();
                        }
                        return varargsOf2;
                    }
                } catch (LuaError e2) {
                    LuaValue messageObject = e2.getMessageObject();
                    LuaBoolean luaBoolean2 = FALSE;
                    if (messageObject == null) {
                        messageObject = NIL;
                    }
                    Varargs varargsOf3 = varargsOf(luaBoolean2, messageObject);
                    if (BaseLib.this.globals != null && BaseLib.this.globals.debuglib != null) {
                        BaseLib.this.globals.debuglib.onReturn();
                    }
                    return varargsOf3;
                }
            } catch (Throwable th) {
                if (BaseLib.this.globals != null && BaseLib.this.globals.debuglib != null) {
                    BaseLib.this.globals.debuglib.onReturn();
                }
                throw th;
            }
        }
    }

    /* loaded from: classes10.dex */
    final class print extends VarArgFunction {
        final BaseLib baselib;

        print(BaseLib baseLib) {
            this.baselib = baseLib;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaValue luaValue = BaseLib.this.globals.get("tostring");
            int narg = varargs.narg();
            for (int i = 1; i <= narg; i++) {
                if (i > 1) {
                    BaseLib.this.globals.STDOUT.print('\t');
                }
                BaseLib.this.globals.STDOUT.print(luaValue.call(varargs.arg(i)).strvalue().tojstring());
            }
            BaseLib.this.globals.STDOUT.println();
            return NONE;
        }
    }

    /* loaded from: classes10.dex */
    static final class rawequal extends LibFunction {
        rawequal() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return argerror(1, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return argerror(2, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            return valueOf(luaValue.raweq(luaValue2));
        }
    }

    /* loaded from: classes10.dex */
    static final class rawget extends LibFunction {
        rawget() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call() {
            return argerror(1, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return argerror(2, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            return luaValue.checktable().rawget(luaValue2);
        }
    }

    /* loaded from: classes10.dex */
    static final class rawlen extends LibFunction {
        rawlen() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(luaValue.rawlen());
        }
    }

    /* loaded from: classes10.dex */
    static final class rawset extends LibFunction {
        rawset() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return argerror(2, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            return argerror(3, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
            LuaTable checktable = luaValue.checktable();
            checktable.rawset(luaValue2.checknotnil(), luaValue3);
            return checktable;
        }
    }

    /* loaded from: classes10.dex */
    static final class select extends VarArgFunction {
        select() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            int narg = varargs.narg() - 1;
            if (varargs.arg1().equals(valueOf("#"))) {
                return valueOf(narg);
            }
            int checkint = varargs.checkint(1);
            if (checkint == 0 || checkint < (-narg)) {
                argerror(1, "index out of range");
            }
            return varargs.subargs(checkint < 0 ? narg + checkint + 2 : checkint + 1);
        }
    }

    /* loaded from: classes10.dex */
    static final class setmetatable extends LibFunction {
        setmetatable() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return argerror(2, "value");
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            LuaValue luaValue3 = luaValue.checktable().getmetatable();
            if (luaValue3 != null && !luaValue3.rawget(METATABLE).isnil()) {
                error("cannot change a protected metatable");
            }
            return luaValue.setmetatable(luaValue2.isnil() ? null : luaValue2.checktable());
        }
    }

    /* loaded from: classes10.dex */
    static final class tonumber extends LibFunction {
        tonumber() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return luaValue.tonumber();
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
            if (luaValue2.isnil()) {
                return luaValue.tonumber();
            }
            int checkint = luaValue2.checkint();
            if (checkint < 2 || checkint > 36) {
                argerror(2, "base out of range");
            }
            return luaValue.checkstring().tonumber(checkint);
        }
    }

    /* loaded from: classes10.dex */
    static final class tostring extends LibFunction {
        tostring() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            LuaValue metatag = luaValue.metatag(TOSTRING);
            if (!metatag.isnil()) {
                return metatag.call(luaValue);
            }
            LuaValue luaValue2 = luaValue.tostring();
            return !luaValue2.isnil() ? luaValue2 : valueOf(luaValue.tojstring());
        }
    }

    /* loaded from: classes10.dex */
    static final class type extends LibFunction {
        type() {
        }

        @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            return valueOf(luaValue.typename());
        }
    }

    /* loaded from: classes10.dex */
    final class xpcall extends VarArgFunction {
        xpcall() {
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0045, code lost:
        
            if (r5.this$0.globals.debuglib != null) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0089, code lost:
        
            r5.this$0.globals.debuglib.onReturn();
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0069, code lost:
        
            if (r5.this$0.globals.debuglib != null) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:43:0x0087, code lost:
        
            if (r5.this$0.globals.debuglib != null) goto L33;
         */
        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public org.luaj.vm2.Varargs invoke(org.luaj.vm2.Varargs r6) {
            /*
                r5 = this;
                org.luaj.vm2.lib.BaseLib r0 = org.luaj.vm2.lib.BaseLib.this
                org.luaj.vm2.Globals r0 = r0.globals
                org.luaj.vm2.LuaThread r0 = r0.running
                org.luaj.vm2.LuaValue r1 = r0.errorfunc
                r2 = 2
                org.luaj.vm2.LuaValue r2 = r6.checkvalue(r2)
                r0.errorfunc = r2
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                if (r2 == 0) goto L26
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.lib.DebugLib r2 = r2.debuglib     // Catch: java.lang.Throwable -> Lae
                if (r2 == 0) goto L26
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.lib.DebugLib r2 = r2.debuglib     // Catch: java.lang.Throwable -> Lae
                r2.onCall(r5)     // Catch: java.lang.Throwable -> Lae
            L26:
                org.luaj.vm2.LuaBoolean r2 = org.luaj.vm2.lib.BaseLib.xpcall.TRUE     // Catch: java.lang.Exception -> L48 org.luaj.vm2.LuaError -> L6c java.lang.Throwable -> L95
                org.luaj.vm2.LuaValue r3 = r6.arg1()     // Catch: java.lang.Exception -> L48 org.luaj.vm2.LuaError -> L6c java.lang.Throwable -> L95
                r4 = 3
                org.luaj.vm2.Varargs r6 = r6.subargs(r4)     // Catch: java.lang.Exception -> L48 org.luaj.vm2.LuaError -> L6c java.lang.Throwable -> L95
                org.luaj.vm2.Varargs r6 = r3.invoke(r6)     // Catch: java.lang.Exception -> L48 org.luaj.vm2.LuaError -> L6c java.lang.Throwable -> L95
                org.luaj.vm2.Varargs r6 = varargsOf(r2, r6)     // Catch: java.lang.Exception -> L48 org.luaj.vm2.LuaError -> L6c java.lang.Throwable -> L95
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                if (r2 == 0) goto L92
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.lib.DebugLib r2 = r2.debuglib     // Catch: java.lang.Throwable -> Lae
                if (r2 == 0) goto L92
                goto L89
            L48:
                r6 = move-exception
                java.lang.String r2 = r6.getMessage()     // Catch: java.lang.Throwable -> L95
                org.luaj.vm2.LuaBoolean r3 = org.luaj.vm2.lib.BaseLib.xpcall.FALSE     // Catch: java.lang.Throwable -> L95
                if (r2 != 0) goto L55
                java.lang.String r2 = r6.toString()     // Catch: java.lang.Throwable -> L95
            L55:
                org.luaj.vm2.LuaString r6 = valueOf(r2)     // Catch: java.lang.Throwable -> L95
                org.luaj.vm2.Varargs r6 = varargsOf(r3, r6)     // Catch: java.lang.Throwable -> L95
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                if (r2 == 0) goto L92
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.lib.DebugLib r2 = r2.debuglib     // Catch: java.lang.Throwable -> Lae
                if (r2 == 0) goto L92
                goto L89
            L6c:
                r6 = move-exception
                org.luaj.vm2.LuaValue r6 = r6.getMessageObject()     // Catch: java.lang.Throwable -> L95
                org.luaj.vm2.LuaBoolean r2 = org.luaj.vm2.lib.BaseLib.xpcall.FALSE     // Catch: java.lang.Throwable -> L95
                if (r6 != 0) goto L77
                org.luaj.vm2.LuaValue r6 = org.luaj.vm2.lib.BaseLib.xpcall.NIL     // Catch: java.lang.Throwable -> L95
            L77:
                org.luaj.vm2.Varargs r6 = varargsOf(r2, r6)     // Catch: java.lang.Throwable -> L95
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                if (r2 == 0) goto L92
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.lib.DebugLib r2 = r2.debuglib     // Catch: java.lang.Throwable -> Lae
                if (r2 == 0) goto L92
            L89:
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.lib.DebugLib r2 = r2.debuglib     // Catch: java.lang.Throwable -> Lae
                r2.onReturn()     // Catch: java.lang.Throwable -> Lae
            L92:
                r0.errorfunc = r1
                return r6
            L95:
                r6 = move-exception
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                if (r2 == 0) goto Lad
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.lib.DebugLib r2 = r2.debuglib     // Catch: java.lang.Throwable -> Lae
                if (r2 == 0) goto Lad
                org.luaj.vm2.lib.BaseLib r2 = org.luaj.vm2.lib.BaseLib.this     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.Globals r2 = r2.globals     // Catch: java.lang.Throwable -> Lae
                org.luaj.vm2.lib.DebugLib r2 = r2.debuglib     // Catch: java.lang.Throwable -> Lae
                r2.onReturn()     // Catch: java.lang.Throwable -> Lae
            Lad:
                throw r6     // Catch: java.lang.Throwable -> Lae
            Lae:
                r6 = move-exception
                r0.errorfunc = r1
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.lib.BaseLib.xpcall.invoke(org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        this.globals = luaValue2.checkglobals();
        this.globals.finder = this;
        this.globals.baselib = this;
        luaValue2.set("_G", luaValue2);
        luaValue2.set("_VERSION", Lua._VERSION);
        luaValue2.set("assert", new _assert());
        luaValue2.set("collectgarbage", new collectgarbage());
        luaValue2.set("dofile", new dofile());
        luaValue2.set("error", new error());
        luaValue2.set("getmetatable", new getmetatable());
        luaValue2.set("load", new load());
        luaValue2.set("loadfile", new loadfile());
        luaValue2.set("pcall", new pcall());
        luaValue2.set("print", new print(this));
        luaValue2.set("rawequal", new rawequal());
        luaValue2.set("rawget", new rawget());
        luaValue2.set("rawlen", new rawlen());
        luaValue2.set("rawset", new rawset());
        luaValue2.set("select", new select());
        luaValue2.set("setmetatable", new setmetatable());
        luaValue2.set("tonumber", new tonumber());
        luaValue2.set("tostring", new tostring());
        luaValue2.set(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, new type());
        luaValue2.set("xpcall", new xpcall());
        next nextVar = new next();
        luaValue2.set("next", nextVar);
        luaValue2.set("pairs", new pairs(nextVar));
        luaValue2.set("ipairs", new ipairs());
        return luaValue2;
    }

    @Override // org.luaj.vm2.lib.ResourceFinder
    public InputStream findResource(String str) {
        Class<?> cls = getClass();
        if (!str.startsWith("/")) {
            str = new StringBuffer().append("/").append(str).toString();
        }
        return cls.getResourceAsStream(str);
    }

    public Varargs loadFile(String str, String str2, LuaValue luaValue) {
        InputStream findResource = this.globals.finder.findResource(str);
        if (findResource == null) {
            return varargsOf(NIL, valueOf(new StringBuffer().append("cannot open ").append(str).append(": No such file or directory").toString()));
        }
        try {
            return loadStream(findResource, new StringBuffer().append("@").append(str).toString(), str2, luaValue);
        } finally {
            try {
                findResource.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public Varargs loadStream(InputStream inputStream, String str, String str2, LuaValue luaValue) {
        try {
            return inputStream == null ? varargsOf(NIL, valueOf(new StringBuffer().append("not found: ").append(str).toString())) : this.globals.load(inputStream, str, str2, luaValue);
        } catch (Exception e) {
            return varargsOf(NIL, valueOf(e.getMessage()));
        }
    }
}
