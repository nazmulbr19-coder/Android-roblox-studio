package org.luaj.vm2.lib.jse;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;

/* loaded from: classes10.dex */
public class CoerceLuaToJava {
    static /* synthetic */ Class array$B;
    static /* synthetic */ Class class$java$lang$Boolean;
    static /* synthetic */ Class class$java$lang$Byte;
    static /* synthetic */ Class class$java$lang$Character;
    static /* synthetic */ Class class$java$lang$Double;
    static /* synthetic */ Class class$java$lang$Float;
    static /* synthetic */ Class class$java$lang$Integer;
    static /* synthetic */ Class class$java$lang$Long;
    static /* synthetic */ Class class$java$lang$Short;
    static /* synthetic */ Class class$java$lang$String;
    static int SCORE_NULL_VALUE = 16;
    static int SCORE_WRONG_TYPE = 256;
    static int SCORE_UNCOERCIBLE = 65536;
    static final Map COERCIONS = Collections.synchronizedMap(new HashMap());

    /* loaded from: classes10.dex */
    static final class ArrayCoercion implements Coercion {
        final Coercion componentCoercion;
        final Class componentType;

        public ArrayCoercion(Class cls) {
            this.componentType = cls;
            this.componentCoercion = CoerceLuaToJava.getCoercion(cls);
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public Object coerce(LuaValue luaValue) {
            Object obj = null;
            switch (luaValue.type()) {
                case 5:
                    int length = luaValue.length();
                    obj = Array.newInstance((Class<?>) this.componentType, length);
                    int i = 0;
                    while (i < length) {
                        int i2 = i + 1;
                        Array.set(obj, i, this.componentCoercion.coerce(luaValue.get(i2)));
                        i = i2;
                    }
                case 0:
                    return obj;
                case 7:
                    return luaValue.touserdata();
                default:
                    return null;
            }
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public int score(LuaValue luaValue) {
            switch (luaValue.type()) {
                case 0:
                    return CoerceLuaToJava.SCORE_NULL_VALUE;
                case 5:
                    if (luaValue.length() == 0) {
                        return 0;
                    }
                    return this.componentCoercion.score(luaValue.get(1));
                case 7:
                    return CoerceLuaToJava.inheritanceLevels(this.componentType, luaValue.touserdata().getClass().getComponentType());
                default:
                    return CoerceLuaToJava.SCORE_UNCOERCIBLE;
            }
        }

        public String toString() {
            return new StringBuffer().append("ArrayCoercion(").append(this.componentType.getName()).append(")").toString();
        }
    }

    /* loaded from: classes10.dex */
    static final class BoolCoercion implements Coercion {
        BoolCoercion() {
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public Object coerce(LuaValue luaValue) {
            return luaValue.toboolean() ? Boolean.TRUE : Boolean.FALSE;
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public int score(LuaValue luaValue) {
            switch (luaValue.type()) {
                case 1:
                    return 0;
                default:
                    return 1;
            }
        }

        public String toString() {
            return "BoolCoercion()";
        }
    }

    /* loaded from: classes10.dex */
    interface Coercion {
        Object coerce(LuaValue luaValue);

        int score(LuaValue luaValue);
    }

    /* loaded from: classes10.dex */
    static final class NumericCoercion implements Coercion {
        static final int TARGET_TYPE_BYTE = 0;
        static final int TARGET_TYPE_CHAR = 1;
        static final int TARGET_TYPE_DOUBLE = 6;
        static final int TARGET_TYPE_FLOAT = 5;
        static final int TARGET_TYPE_INT = 3;
        static final int TARGET_TYPE_LONG = 4;
        static final int TARGET_TYPE_SHORT = 2;
        static final String[] TYPE_NAMES = {"byte", "char", "short", "int", "long", TypedValues.Custom.S_FLOAT, "double"};
        final int targetType;

        NumericCoercion(int i) {
            this.targetType = i;
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public Object coerce(LuaValue luaValue) {
            switch (this.targetType) {
                case 0:
                    return new Byte((byte) luaValue.toint());
                case 1:
                    return new Character((char) luaValue.toint());
                case 2:
                    return new Short((short) luaValue.toint());
                case 3:
                    return new Integer(luaValue.toint());
                case 4:
                    return new Long((long) luaValue.todouble());
                case 5:
                    return new Float((float) luaValue.todouble());
                case 6:
                    return new Double(luaValue.todouble());
                default:
                    return null;
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x0035, code lost:
        
            if (r9 != ((short) r9)) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0040, code lost:
        
            if (r9 == ((short) r9)) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x0089, code lost:
        
            r1 = org.luaj.vm2.lib.jse.CoerceLuaToJava.SCORE_WRONG_TYPE;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x004b, code lost:
        
            if (r9 == ((char) r9)) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x0053, code lost:
        
            if (r9 == ((byte) r9)) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:44:0x0070, code lost:
        
            if (r4 != ((float) r4)) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x007c, code lost:
        
            if (r9.todouble() == ((float) r3)) goto L54;
         */
        /* JADX WARN: Code restructure failed: missing block: B:48:0x0087, code lost:
        
            if (r9.todouble() != ((long) r3)) goto L53;
         */
        /* JADX WARN: Code restructure failed: missing block: B:4:0x0010, code lost:
        
            if (r9.isnil() != false) goto L58;
         */
        /* JADX WARN: Failed to find 'out' block for switch in B:40:0x005e. Please report as an issue. */
        /* JADX WARN: Failed to find 'out' block for switch in B:8:0x001f. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:35:0x008d  */
        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public int score(org.luaj.vm2.LuaValue r9) {
            /*
                r8 = this;
                int r0 = r9.type()
                r1 = 0
                r2 = 4
                if (r0 != r2) goto L14
                org.luaj.vm2.LuaValue r9 = r9.tonumber()
                boolean r0 = r9.isnil()
                if (r0 == 0) goto L15
                goto L90
            L14:
                r2 = r1
            L15:
                boolean r0 = r9.isint()
                r3 = 1
                if (r0 == 0) goto L56
                int r0 = r8.targetType
                r4 = 2
                switch(r0) {
                    case 0: goto L4e;
                    case 1: goto L43;
                    case 2: goto L38;
                    case 3: goto L28;
                    case 4: goto L26;
                    case 5: goto L26;
                    case 6: goto L24;
                    default: goto L22;
                }
            L22:
                goto L8d
            L24:
                int r2 = r2 + r4
                return r2
            L26:
                int r2 = r2 + r3
                return r2
            L28:
                int r9 = r9.toint()
                byte r0 = (byte) r9
                if (r9 != r0) goto L31
                r1 = r4
                goto L8b
            L31:
                char r0 = (char) r9
                if (r9 == r0) goto L72
                short r0 = (short) r9
                if (r9 != r0) goto L8b
                goto L72
            L38:
                int r9 = r9.toint()
                byte r0 = (byte) r9
                if (r9 == r0) goto L72
                short r0 = (short) r9
                if (r9 != r0) goto L89
                goto L8b
            L43:
                int r9 = r9.toint()
                byte r0 = (byte) r9
                if (r9 == r0) goto L72
                char r0 = (char) r9
                if (r9 != r0) goto L89
                goto L8b
            L4e:
                int r9 = r9.toint()
                byte r0 = (byte) r9
                if (r9 != r0) goto L89
                goto L8b
            L56:
                boolean r0 = r9.isnumber()
                if (r0 == 0) goto L90
                int r0 = r8.targetType
                switch(r0) {
                    case 0: goto L8d;
                    case 1: goto L8d;
                    case 2: goto L8d;
                    case 3: goto L8d;
                    case 4: goto L7f;
                    case 5: goto L74;
                    case 6: goto L62;
                    default: goto L61;
                }
            L61:
                goto L8d
            L62:
                double r4 = r9.todouble()
                long r6 = (long) r4
                double r6 = (double) r6
                int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r9 == 0) goto L72
                float r9 = (float) r4
                double r6 = (double) r9
                int r9 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r9 != 0) goto L8b
            L72:
                r1 = r3
                goto L8b
            L74:
                double r3 = r9.todouble()
                float r9 = (float) r3
                double r5 = (double) r9
                int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r9 != 0) goto L89
                goto L8b
            L7f:
                double r3 = r9.todouble()
                long r5 = (long) r3
                double r5 = (double) r5
                int r9 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
                if (r9 == 0) goto L8b
            L89:
                int r1 = org.luaj.vm2.lib.jse.CoerceLuaToJava.SCORE_WRONG_TYPE
            L8b:
                int r2 = r2 + r1
                return r2
            L8d:
                int r9 = org.luaj.vm2.lib.jse.CoerceLuaToJava.SCORE_WRONG_TYPE
                return r9
            L90:
                int r9 = org.luaj.vm2.lib.jse.CoerceLuaToJava.SCORE_UNCOERCIBLE
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: org.luaj.vm2.lib.jse.CoerceLuaToJava.NumericCoercion.score(org.luaj.vm2.LuaValue):int");
        }

        public String toString() {
            return new StringBuffer().append("NumericCoercion(").append(TYPE_NAMES[this.targetType]).append(")").toString();
        }
    }

    /* loaded from: classes10.dex */
    static final class ObjectCoercion implements Coercion {
        final Class targetType;

        ObjectCoercion(Class cls) {
            this.targetType = cls;
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public Object coerce(LuaValue luaValue) {
            switch (luaValue.type()) {
                case 0:
                    return null;
                case 1:
                    return luaValue.toboolean() ? Boolean.TRUE : Boolean.FALSE;
                case 2:
                case 5:
                case 6:
                default:
                    return luaValue;
                case 3:
                    return luaValue.isint() ? new Integer(luaValue.toint()) : new Double(luaValue.todouble());
                case 4:
                    return luaValue.tojstring();
                case 7:
                    return luaValue.optuserdata(this.targetType, (Object) null);
            }
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public int score(LuaValue luaValue) {
            Class cls;
            Class cls2;
            Class cls3;
            Class cls4;
            Object obj;
            switch (luaValue.type()) {
                case 0:
                    return CoerceLuaToJava.SCORE_NULL_VALUE;
                case 1:
                    cls = this.targetType;
                    if (CoerceLuaToJava.class$java$lang$Boolean != null) {
                        cls2 = CoerceLuaToJava.class$java$lang$Boolean;
                        break;
                    } else {
                        cls2 = CoerceLuaToJava.class$("java.lang.Boolean");
                        CoerceLuaToJava.class$java$lang$Boolean = cls2;
                        break;
                    }
                case 2:
                case 5:
                case 6:
                default:
                    cls4 = this.targetType;
                    obj = luaValue;
                    return CoerceLuaToJava.inheritanceLevels(cls4, obj.getClass());
                case 3:
                    Class cls5 = this.targetType;
                    if (luaValue.isint()) {
                        if (CoerceLuaToJava.class$java$lang$Integer == null) {
                            cls3 = CoerceLuaToJava.class$("java.lang.Integer");
                            CoerceLuaToJava.class$java$lang$Integer = cls3;
                        } else {
                            cls3 = CoerceLuaToJava.class$java$lang$Integer;
                        }
                    } else if (CoerceLuaToJava.class$java$lang$Double == null) {
                        cls3 = CoerceLuaToJava.class$("java.lang.Double");
                        CoerceLuaToJava.class$java$lang$Double = cls3;
                    } else {
                        cls3 = CoerceLuaToJava.class$java$lang$Double;
                    }
                    return CoerceLuaToJava.inheritanceLevels(cls5, cls3);
                case 4:
                    cls = this.targetType;
                    if (CoerceLuaToJava.class$java$lang$String != null) {
                        cls2 = CoerceLuaToJava.class$java$lang$String;
                        break;
                    } else {
                        cls2 = CoerceLuaToJava.class$("java.lang.String");
                        CoerceLuaToJava.class$java$lang$String = cls2;
                        break;
                    }
                case 7:
                    cls4 = this.targetType;
                    obj = luaValue.touserdata();
                    return CoerceLuaToJava.inheritanceLevels(cls4, obj.getClass());
            }
            return CoerceLuaToJava.inheritanceLevels(cls, cls2);
        }

        public String toString() {
            return new StringBuffer().append("ObjectCoercion(").append(this.targetType.getName()).append(")").toString();
        }
    }

    /* loaded from: classes10.dex */
    static final class StringCoercion implements Coercion {
        public static final int TARGET_TYPE_BYTES = 1;
        public static final int TARGET_TYPE_STRING = 0;
        final int targetType;

        public StringCoercion(int i) {
            this.targetType = i;
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public Object coerce(LuaValue luaValue) {
            if (luaValue.isnil()) {
                return null;
            }
            if (this.targetType == 0) {
                return luaValue.tojstring();
            }
            LuaString checkstring = luaValue.checkstring();
            int i = checkstring.m_length;
            byte[] bArr = new byte[i];
            checkstring.copyInto(0, bArr, 0, i);
            return bArr;
        }

        @Override // org.luaj.vm2.lib.jse.CoerceLuaToJava.Coercion
        public int score(LuaValue luaValue) {
            switch (luaValue.type()) {
                case 0:
                    return CoerceLuaToJava.SCORE_NULL_VALUE;
                case 4:
                    if (luaValue.checkstring().isValidUtf8()) {
                        return this.targetType != 0 ? 1 : 0;
                    }
                    if (this.targetType != 1) {
                        return CoerceLuaToJava.SCORE_WRONG_TYPE;
                    }
                    return 0;
                default:
                    return this.targetType == 0 ? CoerceLuaToJava.SCORE_WRONG_TYPE : CoerceLuaToJava.SCORE_UNCOERCIBLE;
            }
        }

        public String toString() {
            return new StringBuffer().append("StringCoercion(").append(this.targetType == 0 ? "String" : "byte[]").append(")").toString();
        }
    }

    static {
        Class cls;
        Class cls2;
        Class cls3;
        Class cls4;
        Class cls5;
        Class cls6;
        Class cls7;
        Class cls8;
        Class cls9;
        Class cls10;
        BoolCoercion boolCoercion = new BoolCoercion();
        NumericCoercion numericCoercion = new NumericCoercion(0);
        NumericCoercion numericCoercion2 = new NumericCoercion(1);
        NumericCoercion numericCoercion3 = new NumericCoercion(2);
        NumericCoercion numericCoercion4 = new NumericCoercion(3);
        NumericCoercion numericCoercion5 = new NumericCoercion(4);
        NumericCoercion numericCoercion6 = new NumericCoercion(5);
        NumericCoercion numericCoercion7 = new NumericCoercion(6);
        StringCoercion stringCoercion = new StringCoercion(0);
        StringCoercion stringCoercion2 = new StringCoercion(1);
        COERCIONS.put(Boolean.TYPE, boolCoercion);
        Map map = COERCIONS;
        if (class$java$lang$Boolean == null) {
            cls = class$("java.lang.Boolean");
            class$java$lang$Boolean = cls;
        } else {
            cls = class$java$lang$Boolean;
        }
        map.put(cls, boolCoercion);
        COERCIONS.put(Byte.TYPE, numericCoercion);
        Map map2 = COERCIONS;
        if (class$java$lang$Byte == null) {
            cls2 = class$("java.lang.Byte");
            class$java$lang$Byte = cls2;
        } else {
            cls2 = class$java$lang$Byte;
        }
        map2.put(cls2, numericCoercion);
        COERCIONS.put(Character.TYPE, numericCoercion2);
        Map map3 = COERCIONS;
        if (class$java$lang$Character == null) {
            cls3 = class$("java.lang.Character");
            class$java$lang$Character = cls3;
        } else {
            cls3 = class$java$lang$Character;
        }
        map3.put(cls3, numericCoercion2);
        COERCIONS.put(Short.TYPE, numericCoercion3);
        Map map4 = COERCIONS;
        if (class$java$lang$Short == null) {
            cls4 = class$("java.lang.Short");
            class$java$lang$Short = cls4;
        } else {
            cls4 = class$java$lang$Short;
        }
        map4.put(cls4, numericCoercion3);
        COERCIONS.put(Integer.TYPE, numericCoercion4);
        Map map5 = COERCIONS;
        if (class$java$lang$Integer == null) {
            cls5 = class$("java.lang.Integer");
            class$java$lang$Integer = cls5;
        } else {
            cls5 = class$java$lang$Integer;
        }
        map5.put(cls5, numericCoercion4);
        COERCIONS.put(Long.TYPE, numericCoercion5);
        Map map6 = COERCIONS;
        if (class$java$lang$Long == null) {
            cls6 = class$("java.lang.Long");
            class$java$lang$Long = cls6;
        } else {
            cls6 = class$java$lang$Long;
        }
        map6.put(cls6, numericCoercion5);
        COERCIONS.put(Float.TYPE, numericCoercion6);
        Map map7 = COERCIONS;
        if (class$java$lang$Float == null) {
            cls7 = class$("java.lang.Float");
            class$java$lang$Float = cls7;
        } else {
            cls7 = class$java$lang$Float;
        }
        map7.put(cls7, numericCoercion6);
        COERCIONS.put(Double.TYPE, numericCoercion7);
        Map map8 = COERCIONS;
        if (class$java$lang$Double == null) {
            cls8 = class$("java.lang.Double");
            class$java$lang$Double = cls8;
        } else {
            cls8 = class$java$lang$Double;
        }
        map8.put(cls8, numericCoercion7);
        Map map9 = COERCIONS;
        if (class$java$lang$String == null) {
            cls9 = class$("java.lang.String");
            class$java$lang$String = cls9;
        } else {
            cls9 = class$java$lang$String;
        }
        map9.put(cls9, stringCoercion);
        Map map10 = COERCIONS;
        if (array$B == null) {
            cls10 = class$("[B");
            array$B = cls10;
        } else {
            cls10 = array$B;
        }
        map10.put(cls10, stringCoercion2);
    }

    static /* synthetic */ Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    public static Object coerce(LuaValue luaValue, Class cls) {
        return getCoercion(cls).coerce(luaValue);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Coercion getCoercion(Class cls) {
        Coercion objectCoercion;
        Coercion coercion = (Coercion) COERCIONS.get(cls);
        if (coercion != null) {
            return coercion;
        }
        if (cls.isArray()) {
            cls.getComponentType();
            objectCoercion = new ArrayCoercion(cls.getComponentType());
        } else {
            objectCoercion = new ObjectCoercion(cls);
        }
        COERCIONS.put(cls, objectCoercion);
        return objectCoercion;
    }

    static final int inheritanceLevels(Class cls, Class cls2) {
        if (cls2 == null) {
            return SCORE_UNCOERCIBLE;
        }
        if (cls == cls2) {
            return 0;
        }
        int min = Math.min(SCORE_UNCOERCIBLE, inheritanceLevels(cls, cls2.getSuperclass()) + 1);
        for (Class<?> cls3 : cls2.getInterfaces()) {
            min = Math.min(min, inheritanceLevels(cls, cls3) + 1);
        }
        return min;
    }
}
