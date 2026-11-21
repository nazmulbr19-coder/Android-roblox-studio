package org.luaj.vm2.lib.jse;

import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

/* loaded from: classes10.dex */
public class LuajavaLib extends VarArgFunction {
    static final int BINDCLASS = 1;
    static final int CREATEPROXY = 4;
    static final int INIT = 0;
    static final int LOADLIB = 5;
    static final int METHOD_MODIFIERS_VARARGS = 128;
    static final String[] NAMES = {"bindClass", "newInstance", "new", "createProxy", "loadLib"};
    static final int NEW = 3;
    static final int NEWINSTANCE = 2;
    static /* synthetic */ Class class$java$lang$Class;

    /* loaded from: classes10.dex */
    private static final class ProxyInvocationHandler implements InvocationHandler {
        private final LuaValue lobj;

        private ProxyInvocationHandler(LuaValue luaValue) {
            this.lobj = luaValue;
        }

        /* synthetic */ ProxyInvocationHandler(LuaValue luaValue, AnonymousClass1 anonymousClass1) {
            this(luaValue);
        }

        @Override // java.lang.reflect.InvocationHandler
        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            LuaValue[] luaValueArr;
            LuaValue luaValue = this.lobj.get(method.getName());
            if (luaValue.isnil()) {
                return null;
            }
            int i = 0;
            boolean z = (method.getModifiers() & 128) != 0;
            int length = objArr != null ? objArr.length : 0;
            if (z) {
                int i2 = length - 1;
                Object obj2 = objArr[i2];
                int length2 = Array.getLength(obj2);
                luaValueArr = new LuaValue[i2 + length2];
                for (int i3 = 0; i3 < i2; i3++) {
                    luaValueArr[i3] = CoerceJavaToLua.coerce(objArr[i3]);
                }
                while (i < length2) {
                    luaValueArr[i + i2] = CoerceJavaToLua.coerce(Array.get(obj2, i));
                    i++;
                }
            } else {
                luaValueArr = new LuaValue[length];
                while (i < length) {
                    luaValueArr[i] = CoerceJavaToLua.coerce(objArr[i]);
                    i++;
                }
            }
            return CoerceLuaToJava.coerce(luaValue.invoke(luaValueArr).arg1(), method.getReturnType());
        }
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    protected Class classForName(String str) throws ClassNotFoundException {
        return Class.forName(str, true, ClassLoader.getSystemClassLoader());
    }

    @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public Varargs invoke(Varargs varargs) {
        Class cls;
        Class cls2;
        try {
            int i = 0;
            switch (this.opcode) {
                case 0:
                    LuaValue arg = varargs.arg(2);
                    LuaTable luaTable = new LuaTable();
                    bind(luaTable, getClass(), NAMES, 1);
                    arg.set("luajava", luaTable);
                    arg.get("package").get("loaded").set("luajava", luaTable);
                    return luaTable;
                case 1:
                    return JavaClass.forClass(classForName(varargs.checkjstring(1)));
                case 2:
                case 3:
                    LuaValue checkvalue = varargs.checkvalue(1);
                    if (this.opcode == 2) {
                        cls2 = classForName(checkvalue.tojstring());
                    } else {
                        if (class$java$lang$Class == null) {
                            cls = class$("java.lang.Class");
                            class$java$lang$Class = cls;
                        } else {
                            cls = class$java$lang$Class;
                        }
                        cls2 = (Class) checkvalue.checkuserdata(cls);
                    }
                    return JavaClass.forClass(cls2).getConstructor().invoke(varargs.subargs(2));
                case 4:
                    int narg = varargs.narg() - 1;
                    if (narg <= 0) {
                        throw new LuaError("no interfaces");
                    }
                    LuaTable checktable = varargs.checktable(narg + 1);
                    Class[] clsArr = new Class[narg];
                    while (i < narg) {
                        int i2 = i + 1;
                        clsArr[i] = classForName(varargs.checkjstring(i2));
                        i = i2;
                    }
                    return LuaValue.userdataOf(Proxy.newProxyInstance(getClass().getClassLoader(), clsArr, new ProxyInvocationHandler(checktable, null)));
                case 5:
                    String checkjstring = varargs.checkjstring(1);
                    String checkjstring2 = varargs.checkjstring(2);
                    Class classForName = classForName(checkjstring);
                    Object invoke = classForName.getMethod(checkjstring2, new Class[0]).invoke(classForName, new Object[0]);
                    return invoke instanceof LuaValue ? (LuaValue) invoke : NIL;
                default:
                    throw new LuaError(new StringBuffer().append("not yet supported: ").append(this).toString());
            }
        } catch (InvocationTargetException e) {
            throw new LuaError(e.getTargetException());
        } catch (LuaError e2) {
            throw e2;
        } catch (Exception e3) {
            throw new LuaError(e3);
        }
    }
}
