package org.luaj.vm2.lib.jse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.jse.CoerceJavaToLua;

/* loaded from: classes10.dex */
class JavaClass extends JavaInstance implements CoerceJavaToLua.Coercion {
    Map fields;
    Map innerclasses;
    Map methods;
    static final Map classes = Collections.synchronizedMap(new HashMap());
    static final LuaValue NEW = valueOf("new");

    JavaClass(Class cls) {
        super(cls);
        this.jclass = this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static JavaClass forClass(Class cls) {
        JavaClass javaClass = (JavaClass) classes.get(cls);
        if (javaClass != null) {
            return javaClass;
        }
        Map map = classes;
        JavaClass javaClass2 = new JavaClass(cls);
        map.put(cls, javaClass2);
        return javaClass2;
    }

    @Override // org.luaj.vm2.lib.jse.CoerceJavaToLua.Coercion
    public LuaValue coerce(Object obj) {
        return this;
    }

    public LuaValue getConstructor() {
        return getMethod(NEW);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Field getField(LuaValue luaValue) {
        if (this.fields == null) {
            HashMap hashMap = new HashMap();
            for (Field field : ((Class) this.m_instance).getFields()) {
                if (Modifier.isPublic(field.getModifiers())) {
                    hashMap.put(LuaValue.valueOf(field.getName()), field);
                    try {
                        if (!field.isAccessible()) {
                            field.setAccessible(true);
                        }
                    } catch (SecurityException e) {
                    }
                }
            }
            this.fields = hashMap;
        }
        return (Field) this.fields.get(luaValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Class getInnerClass(LuaValue luaValue) {
        if (this.innerclasses == null) {
            HashMap hashMap = new HashMap();
            for (Class<?> cls : ((Class) this.m_instance).getClasses()) {
                String name = cls.getName();
                hashMap.put(LuaValue.valueOf(name.substring(Math.max(name.lastIndexOf(36), name.lastIndexOf(46)) + 1)), cls);
            }
            this.innerclasses = hashMap;
        }
        return (Class) this.innerclasses.get(luaValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public LuaValue getMethod(LuaValue luaValue) {
        LuaValue luaValue2;
        Object obj;
        if (this.methods == null) {
            HashMap hashMap = new HashMap();
            for (Method method : ((Class) this.m_instance).getMethods()) {
                if (Modifier.isPublic(method.getModifiers())) {
                    String name = method.getName();
                    List list = (List) hashMap.get(name);
                    if (list == null) {
                        list = new ArrayList();
                        hashMap.put(name, list);
                    }
                    list.add(JavaMethod.forMethod(method));
                }
            }
            HashMap hashMap2 = new HashMap();
            Constructor<?>[] constructors = ((Class) this.m_instance).getConstructors();
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < constructors.length; i++) {
                if (Modifier.isPublic(constructors[i].getModifiers())) {
                    arrayList.add(JavaConstructor.forConstructor(constructors[i]));
                }
            }
            switch (arrayList.size()) {
                case 0:
                    break;
                case 1:
                    luaValue2 = NEW;
                    obj = arrayList.get(0);
                    break;
                default:
                    luaValue2 = NEW;
                    obj = JavaConstructor.forConstructors((JavaConstructor[]) arrayList.toArray(new JavaConstructor[arrayList.size()]));
                    break;
            }
            hashMap2.put(luaValue2, obj);
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                List list2 = (List) entry.getValue();
                hashMap2.put(LuaValue.valueOf(str), list2.size() == 1 ? list2.get(0) : JavaMethod.forMethods((JavaMethod[]) list2.toArray(new JavaMethod[list2.size()])));
            }
            this.methods = hashMap2;
        }
        return (LuaValue) this.methods.get(luaValue);
    }
}
