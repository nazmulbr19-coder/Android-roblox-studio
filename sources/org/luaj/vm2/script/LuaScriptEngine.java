package org.luaj.vm2.script;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.StringReader;
import javax.script.AbstractScriptEngine;
import javax.script.Bindings;
import javax.script.Compilable;
import javax.script.CompiledScript;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptException;
import javax.script.SimpleBindings;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.ThreeArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

/* loaded from: classes10.dex */
public class LuaScriptEngine extends AbstractScriptEngine implements ScriptEngine, Compilable {
    private static final String __ARGV__ = "arg";
    private static final String __ENGINE_VERSION__ = "Luaj-jse 3.0.1";
    private static final String __FILENAME__ = "?";
    private static final String __LANGUAGE_VERSION__ = "5.2";
    private static final String __LANGUAGE__ = "lua";
    private static final String __NAME__ = "Luaj";
    private static final String __SHORT_NAME__ = "Luaj";
    private static final ScriptEngineFactory myFactory = new LuaScriptEngineFactory();
    private LuajContext context = new LuajContext();

    /* loaded from: classes10.dex */
    static class BindingsMetatable extends LuaTable {

        /* renamed from: org.luaj.vm2.script.LuaScriptEngine$BindingsMetatable$1, reason: invalid class name */
        /* loaded from: classes10.dex */
        class AnonymousClass1 extends TwoArgFunction {
            final /* synthetic */ Bindings val$bindings;

            AnonymousClass1(Bindings bindings) {
                this.val$bindings = bindings;
            }

            @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
            public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
                return luaValue2.isstring() ? LuaScriptEngine.access$200(this.val$bindings.get(luaValue2.tojstring())) : rawget(luaValue2);
            }
        }

        /* renamed from: org.luaj.vm2.script.LuaScriptEngine$BindingsMetatable$2, reason: invalid class name */
        /* loaded from: classes10.dex */
        class AnonymousClass2 extends ThreeArgFunction {
            final /* synthetic */ Bindings val$bindings;

            AnonymousClass2(Bindings bindings) {
                this.val$bindings = bindings;
            }

            @Override // org.luaj.vm2.lib.ThreeArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
            public LuaValue call(LuaValue luaValue, LuaValue luaValue2, LuaValue luaValue3) {
                if (luaValue2.isstring()) {
                    String str = luaValue2.tojstring();
                    Object access$300 = LuaScriptEngine.access$300(luaValue3);
                    if (access$300 == null) {
                        this.val$bindings.remove(str);
                    } else {
                        this.val$bindings.put(str, access$300);
                    }
                } else {
                    rawset(luaValue2, luaValue3);
                }
                return LuaValue.NONE;
            }
        }

        BindingsMetatable(Bindings bindings) {
            rawset(LuaValue.INDEX, new AnonymousClass1(bindings));
            rawset(LuaValue.NEWINDEX, new AnonymousClass2(bindings));
        }
    }

    /* loaded from: classes10.dex */
    class LuajCompiledScript extends CompiledScript {
        final Globals compiling_globals;
        final LuaFunction function;

        LuajCompiledScript(LuaFunction luaFunction, Globals globals) {
            this.function = luaFunction;
            this.compiling_globals = globals;
        }

        public Object eval() throws ScriptException {
            return eval(LuaScriptEngine.this.getContext());
        }

        public Object eval(Bindings bindings) throws ScriptException {
            return eval(((LuajContext) LuaScriptEngine.this.getContext()).globals, bindings);
        }

        public Object eval(ScriptContext scriptContext) throws ScriptException {
            return eval(((LuajContext) scriptContext).globals, scriptContext.getBindings(100));
        }

        Object eval(Globals globals, Bindings bindings) throws ScriptException {
            LuaValue luaValue;
            globals.setmetatable(new BindingsMetatable(bindings));
            LuaFunction luaFunction = this.function;
            if (luaFunction.isclosure()) {
                luaValue = new LuaClosure(luaFunction.checkclosure().p, globals);
            } else {
                try {
                    luaValue = (LuaFunction) luaFunction.getClass().newInstance();
                    luaValue.initupvalue1(globals);
                } catch (Exception e) {
                    throw new ScriptException(e);
                }
            }
            return LuaScriptEngine.access$100(luaValue.invoke(LuaValue.NONE));
        }

        public ScriptEngine getEngine() {
            return LuaScriptEngine.this;
        }
    }

    /* loaded from: classes10.dex */
    private final class Utf8Encoder extends InputStream {
        private final int[] buf;
        private int n;
        private final Reader r;

        private Utf8Encoder(Reader reader) {
            this.buf = new int[2];
            this.r = reader;
        }

        /* synthetic */ Utf8Encoder(LuaScriptEngine luaScriptEngine, Reader reader, AnonymousClass1 anonymousClass1) {
            this(reader);
        }

        @Override // java.io.InputStream
        public int read() throws IOException {
            if (this.n > 0) {
                int[] iArr = this.buf;
                int i = this.n - 1;
                this.n = i;
                return iArr[i];
            }
            int read = this.r.read();
            if (read < 128) {
                return read;
            }
            this.n = 0;
            if (read < 2048) {
                int[] iArr2 = this.buf;
                int i2 = this.n;
                this.n = i2 + 1;
                iArr2[i2] = (read & 63) | 128;
                return ((read >> 6) & 31) | 192;
            }
            int[] iArr3 = this.buf;
            int i3 = this.n;
            this.n = i3 + 1;
            iArr3[i3] = (read & 63) | 128;
            int[] iArr4 = this.buf;
            int i4 = this.n;
            this.n = i4 + 1;
            iArr4[i4] = ((read >> 6) & 63) | 128;
            return ((read >> 12) & 15) | 224;
        }
    }

    public LuaScriptEngine() {
        this.context.setBindings(createBindings(), 100);
        setContext(this.context);
        put("javax.script.language_version", __LANGUAGE_VERSION__);
        put("javax.script.language", __LANGUAGE__);
        put("javax.script.engine", "Luaj");
        put("javax.script.engine_version", "Luaj-jse 3.0.1");
        put("javax.script.argv", "arg");
        put("javax.script.filename", __FILENAME__);
        put("javax.script.name", "Luaj");
        put("THREADING", null);
    }

    static /* synthetic */ Object access$100(Varargs varargs) {
        return toJava(varargs);
    }

    static /* synthetic */ LuaValue access$200(Object obj) {
        return toLua(obj);
    }

    static /* synthetic */ Object access$300(LuaValue luaValue) {
        return toJava(luaValue);
    }

    private static Object toJava(LuaValue luaValue) {
        switch (luaValue.type()) {
            case 0:
                return null;
            case 3:
                return luaValue.isinttype() ? new Integer(luaValue.toint()) : new Double(luaValue.todouble());
            case 4:
                return luaValue.tojstring();
            case 7:
                return luaValue.checkuserdata(Object.class);
            default:
                return luaValue;
        }
    }

    private static Object toJava(Varargs varargs) {
        int narg = varargs.narg();
        switch (narg) {
            case 0:
                return null;
            case 1:
                return toJava(varargs.arg1());
            default:
                Object[] objArr = new Object[narg];
                int i = 0;
                while (i < narg) {
                    int i2 = i + 1;
                    objArr[i] = toJava(varargs.arg(i2));
                    i = i2;
                }
                return objArr;
        }
    }

    private static LuaValue toLua(Object obj) {
        return obj == null ? LuaValue.NIL : obj instanceof LuaValue ? (LuaValue) obj : CoerceJavaToLua.coerce(obj);
    }

    public CompiledScript compile(Reader reader) throws ScriptException {
        try {
            Utf8Encoder utf8Encoder = new Utf8Encoder(this, reader, null);
            try {
                try {
                    Globals globals = this.context.globals;
                    return new LuajCompiledScript(globals.load(reader, "script").checkfunction(), globals);
                } catch (LuaError e) {
                    throw new ScriptException(e.getMessage());
                }
            } finally {
                utf8Encoder.close();
            }
        } catch (Exception e2) {
            throw new ScriptException("eval threw " + e2.toString());
        }
    }

    public CompiledScript compile(String str) throws ScriptException {
        return compile(new StringReader(str));
    }

    public Bindings createBindings() {
        return new SimpleBindings();
    }

    public Object eval(Reader reader, Bindings bindings) throws ScriptException {
        return ((LuajCompiledScript) compile(reader)).eval(this.context.globals, bindings);
    }

    public Object eval(Reader reader, ScriptContext scriptContext) throws ScriptException {
        return compile(reader).eval(scriptContext);
    }

    public Object eval(String str, Bindings bindings) throws ScriptException {
        return eval(new StringReader(str), bindings);
    }

    public Object eval(String str, ScriptContext scriptContext) throws ScriptException {
        return eval(new StringReader(str), scriptContext);
    }

    public ScriptEngineFactory getFactory() {
        return myFactory;
    }

    protected ScriptContext getScriptContext(Bindings bindings) {
        throw new IllegalStateException("LuajScriptEngine should not be allocating contexts.");
    }
}
