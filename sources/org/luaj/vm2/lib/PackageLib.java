package org.luaj.vm2.lib;

import java.io.IOException;
import java.io.InputStream;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* loaded from: classes10.dex */
public class PackageLib extends TwoArgFunction {
    public static String DEFAULT_LUA_PATH;
    private static final String FILE_SEP;
    private static final LuaString _LOADED;
    private static final LuaString _LOADLIB;
    private static final LuaString _PATH;
    private static final LuaString _PRELOAD;
    private static final LuaString _SEARCHERS;
    private static final LuaString _SEARCHPATH;
    private static final LuaString _SENTINEL;
    Globals globals;
    public java_searcher java_searcher;
    public lua_searcher lua_searcher;
    LuaTable package_;
    public preload_searcher preload_searcher;

    /* loaded from: classes10.dex */
    public class java_searcher extends VarArgFunction {
        public java_searcher() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            StringBuffer append;
            String classname = PackageLib.toClassname(varargs.checkjstring(1));
            try {
                LuaValue luaValue = (LuaValue) Class.forName(classname).newInstance();
                if (luaValue.isfunction()) {
                    ((LuaFunction) luaValue).initupvalue1(PackageLib.this.globals);
                }
                return varargsOf(luaValue, PackageLib.this.globals);
            } catch (ClassNotFoundException e) {
                append = new StringBuffer().append("\n\tno class '").append(classname).append("'");
                return valueOf(append.toString());
            } catch (Exception e2) {
                append = new StringBuffer().append("\n\tjava load failed on '").append(classname).append("', ").append(e2);
                return valueOf(append.toString());
            }
        }
    }

    /* loaded from: classes10.dex */
    public static class loadlib extends VarArgFunction {
        public Varargs loadlib(Varargs varargs) {
            varargs.checkstring(1);
            return varargsOf(NIL, valueOf("dynamic libraries not enabled"), valueOf("absent"));
        }
    }

    /* loaded from: classes10.dex */
    public class lua_searcher extends VarArgFunction {
        public lua_searcher() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            LuaValue luaValue = PackageLib.this.package_.get(PackageLib.access$400());
            if (!luaValue.isstring()) {
                return valueOf("package.path is not a string");
            }
            Varargs invoke = PackageLib.this.package_.get(PackageLib.access$500()).invoke(varargsOf(checkstring, luaValue));
            if (!invoke.isstring(1)) {
                return invoke.arg(2).tostring();
            }
            LuaString strvalue = invoke.arg1().strvalue();
            LuaValue loadfile = PackageLib.this.globals.loadfile(strvalue.tojstring());
            return loadfile.arg1().isfunction() ? LuaValue.varargsOf(loadfile.arg1(), strvalue) : varargsOf(NIL, valueOf(new StringBuffer().append("'").append(strvalue).append("': ").append(loadfile.arg(2).tojstring()).toString()));
        }
    }

    /* loaded from: classes10.dex */
    public class preload_searcher extends VarArgFunction {
        public preload_searcher() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            LuaString checkstring = varargs.checkstring(1);
            LuaValue luaValue = PackageLib.this.package_.get(PackageLib.access$300()).get(checkstring);
            return luaValue.isnil() ? valueOf(new StringBuffer().append("\n\tno field package.preload['").append(checkstring).append("']").toString()) : luaValue;
        }
    }

    /* loaded from: classes10.dex */
    public class require extends OneArgFunction {
        public require() {
        }

        @Override // org.luaj.vm2.lib.OneArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public LuaValue call(LuaValue luaValue) {
            Varargs invoke;
            LuaString checkstring = luaValue.checkstring();
            LuaValue luaValue2 = PackageLib.this.package_.get(PackageLib.access$000());
            LuaValue luaValue3 = luaValue2.get(checkstring);
            if (luaValue3.toboolean()) {
                if (luaValue3 == PackageLib.access$100()) {
                    error(new StringBuffer().append("loop or previous error loading module '").append(checkstring).append("'").toString());
                }
                return luaValue3;
            }
            LuaTable checktable = PackageLib.this.package_.get(PackageLib.access$200()).checktable();
            StringBuffer stringBuffer = new StringBuffer();
            int i = 1;
            while (true) {
                LuaValue luaValue4 = checktable.get(i);
                if (luaValue4.isnil()) {
                    error(new StringBuffer().append("module '").append(checkstring).append("' not found: ").append(checkstring).append((Object) stringBuffer).toString());
                }
                invoke = luaValue4.invoke(checkstring);
                if (invoke.isfunction(1)) {
                    break;
                }
                if (invoke.isstring(1)) {
                    stringBuffer.append(invoke.tojstring(1));
                }
                i++;
            }
            luaValue2.set(checkstring, PackageLib.access$100());
            LuaValue call = invoke.arg1().call(checkstring, invoke.arg(2));
            if (call.isnil()) {
                call = luaValue2.get(checkstring);
                if (call == PackageLib.access$100()) {
                    call = LuaValue.TRUE;
                }
                return call;
            }
            luaValue2.set(checkstring, call);
            return call;
        }
    }

    /* loaded from: classes10.dex */
    public class searchpath extends VarArgFunction {
        public searchpath() {
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            String checkjstring = varargs.checkjstring(1);
            String checkjstring2 = varargs.checkjstring(2);
            String optjstring = varargs.optjstring(3, ".");
            String optjstring2 = varargs.optjstring(4, PackageLib.access$600());
            int length = checkjstring2.length();
            String replace = checkjstring.replace(optjstring.charAt(0), optjstring2.charAt(0));
            int i = -1;
            StringBuffer stringBuffer = null;
            while (i < length) {
                int i2 = i + 1;
                int indexOf = checkjstring2.indexOf(59, i2);
                if (indexOf < 0) {
                    indexOf = checkjstring2.length();
                }
                String substring = checkjstring2.substring(i2, indexOf);
                int indexOf2 = substring.indexOf(63);
                if (indexOf2 >= 0) {
                    substring = new StringBuffer().append(substring.substring(0, indexOf2)).append(replace).append(substring.substring(indexOf2 + 1)).toString();
                }
                InputStream findResource = PackageLib.this.globals.finder.findResource(substring);
                if (findResource != null) {
                    try {
                        findResource.close();
                    } catch (IOException e) {
                    }
                    return valueOf(substring);
                }
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer();
                }
                stringBuffer.append(new StringBuffer().append("\n\t").append(substring).toString());
                i = indexOf;
            }
            return varargsOf(NIL, valueOf(stringBuffer.toString()));
        }
    }

    static {
        try {
            DEFAULT_LUA_PATH = System.getProperty("luaj.package.path");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        if (DEFAULT_LUA_PATH == null) {
            DEFAULT_LUA_PATH = "?.lua";
        }
        _LOADED = valueOf("loaded");
        _LOADLIB = valueOf("loadlib");
        _PRELOAD = valueOf("preload");
        _PATH = valueOf("path");
        _SEARCHPATH = valueOf("searchpath");
        _SEARCHERS = valueOf("searchers");
        _SENTINEL = valueOf("\u0001");
        FILE_SEP = System.getProperty("file.separator");
    }

    static /* synthetic */ LuaString access$000() {
        return _LOADED;
    }

    static /* synthetic */ LuaString access$100() {
        return _SENTINEL;
    }

    static /* synthetic */ LuaString access$200() {
        return _SEARCHERS;
    }

    static /* synthetic */ LuaString access$300() {
        return _PRELOAD;
    }

    static /* synthetic */ LuaString access$400() {
        return _PATH;
    }

    static /* synthetic */ LuaString access$500() {
        return _SEARCHPATH;
    }

    static /* synthetic */ String access$600() {
        return FILE_SEP;
    }

    private static final boolean isClassnamePart(char c) {
        if ((c >= 'a' && c <= 'z') || ((c >= 'A' && c <= 'Z') || (c >= '0' && c <= '9'))) {
            return true;
        }
        switch (c) {
            case '$':
            case '.':
            case '_':
                return true;
            default:
                return false;
        }
    }

    public static final String toClassname(String str) {
        int length = str.length();
        int i = str.endsWith(".lua") ? length - 4 : length;
        for (int i2 = 0; i2 < i; i2++) {
            char charAt = str.charAt(i2);
            if (!isClassnamePart(charAt) || charAt == '/' || charAt == '\\') {
                StringBuffer stringBuffer = new StringBuffer(i);
                for (int i3 = 0; i3 < i; i3++) {
                    char charAt2 = str.charAt(i3);
                    if (!isClassnamePart(charAt2)) {
                        charAt2 = (charAt2 == '/' || charAt2 == '\\') ? '.' : '_';
                    }
                    stringBuffer.append(charAt2);
                }
                return stringBuffer.toString();
            }
        }
        return length != i ? str.substring(0, i) : str;
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        this.globals = luaValue2.checkglobals();
        this.globals.set("require", new require());
        this.package_ = new LuaTable();
        this.package_.set(_LOADED, new LuaTable());
        this.package_.set(_PRELOAD, new LuaTable());
        this.package_.set(_PATH, LuaValue.valueOf(DEFAULT_LUA_PATH));
        this.package_.set(_LOADLIB, new loadlib());
        this.package_.set(_SEARCHPATH, new searchpath());
        LuaValue luaTable = new LuaTable();
        preload_searcher preload_searcherVar = new preload_searcher();
        this.preload_searcher = preload_searcherVar;
        luaTable.set(1, preload_searcherVar);
        lua_searcher lua_searcherVar = new lua_searcher();
        this.lua_searcher = lua_searcherVar;
        luaTable.set(2, lua_searcherVar);
        java_searcher java_searcherVar = new java_searcher();
        this.java_searcher = java_searcherVar;
        luaTable.set(3, java_searcherVar);
        this.package_.set(_SEARCHERS, luaTable);
        this.package_.get(_LOADED).set("package", this.package_);
        luaValue2.set("package", this.package_);
        this.globals.package_ = this;
        return luaValue2;
    }

    public void setIsLoaded(String str, LuaTable luaTable) {
        this.package_.get(_LOADED).set(str, luaTable);
    }

    public void setLuaPath(String str) {
        this.package_.set(_PATH, LuaValue.valueOf(str));
    }

    @Override // org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaFunction, org.luaj.vm2.LuaValue, org.luaj.vm2.Varargs
    public String tojstring() {
        return "package";
    }
}
