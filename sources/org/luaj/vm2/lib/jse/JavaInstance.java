package org.luaj.vm2.lib.jse;

import java.lang.reflect.Field;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;

/* loaded from: classes10.dex */
class JavaInstance extends LuaUserdata {
    JavaClass jclass;

    /* JADX INFO: Access modifiers changed from: package-private */
    public JavaInstance(Object obj) {
        super(obj);
    }

    @Override // org.luaj.vm2.LuaUserdata, org.luaj.vm2.LuaValue
    public LuaValue get(LuaValue luaValue) {
        if (this.jclass == null) {
            this.jclass = JavaClass.forClass(this.m_instance.getClass());
        }
        Field field = this.jclass.getField(luaValue);
        if (field != null) {
            try {
                return CoerceJavaToLua.coerce(field.get(this.m_instance));
            } catch (Exception e) {
                throw new LuaError(e);
            }
        }
        LuaValue method = this.jclass.getMethod(luaValue);
        if (method != null) {
            return method;
        }
        Class innerClass = this.jclass.getInnerClass(luaValue);
        return innerClass != null ? JavaClass.forClass(innerClass) : super.get(luaValue);
    }

    @Override // org.luaj.vm2.LuaUserdata, org.luaj.vm2.LuaValue
    public void set(LuaValue luaValue, LuaValue luaValue2) {
        if (this.jclass == null) {
            this.jclass = JavaClass.forClass(this.m_instance.getClass());
        }
        Field field = this.jclass.getField(luaValue);
        if (field == null) {
            super.set(luaValue, luaValue2);
            return;
        }
        try {
            field.set(this.m_instance, CoerceLuaToJava.coerce(luaValue2, field.getType()));
        } catch (Exception e) {
            throw new LuaError(e);
        }
    }
}
