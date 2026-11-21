package org.luaj.vm2.lib.jse;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

/* loaded from: classes10.dex */
class JavaConstructor extends JavaMember {
    static final Map constructors = Collections.synchronizedMap(new HashMap());
    final Constructor constructor;

    /* loaded from: classes10.dex */
    static class Overload extends VarArgFunction {
        final JavaConstructor[] constructors;

        public Overload(JavaConstructor[] javaConstructorArr) {
            this.constructors = javaConstructorArr;
        }

        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            int i = CoerceLuaToJava.SCORE_UNCOERCIBLE;
            JavaConstructor javaConstructor = null;
            for (int i2 = 0; i2 < this.constructors.length; i2++) {
                int score = this.constructors[i2].score(varargs);
                if (score < i) {
                    javaConstructor = this.constructors[i2];
                    if (score == 0) {
                        break;
                    }
                    i = score;
                }
            }
            if (javaConstructor == null) {
                LuaValue.error("no coercible public method");
            }
            return javaConstructor.invoke(varargs);
        }
    }

    private JavaConstructor(Constructor constructor) {
        super(constructor.getParameterTypes(), constructor.getModifiers());
        this.constructor = constructor;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JavaConstructor forConstructor(Constructor constructor) {
        JavaConstructor javaConstructor = (JavaConstructor) constructors.get(constructor);
        if (javaConstructor != null) {
            return javaConstructor;
        }
        Map map = constructors;
        JavaConstructor javaConstructor2 = new JavaConstructor(constructor);
        map.put(constructor, javaConstructor2);
        return javaConstructor2;
    }

    public static LuaValue forConstructors(JavaConstructor[] javaConstructorArr) {
        return new Overload(javaConstructorArr);
    }

    @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public Varargs invoke(Varargs varargs) {
        try {
            return CoerceJavaToLua.coerce(this.constructor.newInstance(convertArgs(varargs)));
        } catch (InvocationTargetException e) {
            throw new LuaError(e.getTargetException());
        } catch (Exception e2) {
            return LuaValue.error(new StringBuffer().append("coercion error ").append(e2).toString());
        }
    }
}
