package com.exampletest.mobilestudiotest.lua;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* compiled from: RobloxServices.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0002J\u0016\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J\u0012\u0010\u000f\u001a\u00020\u00072\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001H\u0002¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/Json;", "", "<init>", "()V", "encode", "", "v", "Lorg/luaj/vm2/LuaValue;", "toJson", "depth", "", "decode", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "s", "fromJson", "o", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Json {
    public static final Json INSTANCE = new Json();

    private Json() {
    }

    private final LuaValue fromJson(Object o) {
        if (o == null || Intrinsics.areEqual(o, JSONObject.NULL)) {
            LuaValue NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
            return NIL;
        }
        if (o instanceof Boolean) {
            LuaBoolean valueOf = LuaValue.valueOf(((Boolean) o).booleanValue());
            Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
            return valueOf;
        }
        if (o instanceof Integer) {
            LuaInteger valueOf2 = LuaValue.valueOf(((Number) o).intValue());
            Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
            return valueOf2;
        }
        if (o instanceof Long) {
            LuaNumber valueOf3 = LuaValue.valueOf(((Number) o).longValue());
            Intrinsics.checkNotNullExpressionValue(valueOf3, "valueOf(...)");
            return valueOf3;
        }
        if (o instanceof Number) {
            LuaNumber valueOf4 = LuaValue.valueOf(((Number) o).doubleValue());
            Intrinsics.checkNotNullExpressionValue(valueOf4, "valueOf(...)");
            return valueOf4;
        }
        if (o instanceof String) {
            LuaString valueOf5 = LuaValue.valueOf((String) o);
            Intrinsics.checkNotNullExpressionValue(valueOf5, "valueOf(...)");
            return valueOf5;
        }
        if (o instanceof JSONArray) {
            LuaTable luaTable = new LuaTable();
            int length = ((JSONArray) o).length();
            for (int i = 0; i < length; i++) {
                luaTable.set(i + 1, INSTANCE.fromJson(((JSONArray) o).opt(i)));
            }
            return luaTable;
        }
        if (!(o instanceof JSONObject)) {
            LuaString valueOf6 = LuaValue.valueOf(o.toString());
            Intrinsics.checkNotNullExpressionValue(valueOf6, "valueOf(...)");
            return valueOf6;
        }
        LuaTable luaTable2 = new LuaTable();
        Iterator<String> keys = ((JSONObject) o).keys();
        Intrinsics.checkNotNullExpressionValue(keys, "keys(...)");
        while (keys.hasNext()) {
            String next = keys.next();
            luaTable2.set(next, INSTANCE.fromJson(((JSONObject) o).opt(next)));
        }
        return luaTable2;
    }

    private final Object toJson(LuaValue v, int depth) {
        if (depth > 100) {
            throw new LuaError("Cannot convert recursive table to JSON");
        }
        if (v.isnil()) {
            return JSONObject.NULL;
        }
        if (v.isboolean()) {
            return Boolean.valueOf(v.toboolean());
        }
        if (v.isnumber()) {
            double d = v.todouble();
            return (!((d > Math.floor(d) ? 1 : (d == Math.floor(d) ? 0 : -1)) == 0) || Math.abs(d) >= 1.0E15d) ? Double.valueOf(d) : Long.valueOf((long) d);
        }
        if (v.isstring()) {
            return v.tojstring();
        }
        if (!v.istable()) {
            return JSONObject.NULL;
        }
        int length = v.length();
        int i = 0;
        LuaValue luaValue = LuaValue.NIL;
        while (true) {
            luaValue = v.next(luaValue).arg1();
            if (luaValue.isnil()) {
                break;
            }
            i++;
        }
        if (length > 0 && length == i) {
            JSONArray jSONArray = new JSONArray();
            int i2 = 1;
            if (1 <= length) {
                while (true) {
                    Json json = INSTANCE;
                    LuaValue luaValue2 = v.get(i2);
                    Intrinsics.checkNotNullExpressionValue(luaValue2, "get(...)");
                    jSONArray.put(json.toJson(luaValue2, depth + 1));
                    if (i2 == length) {
                        break;
                    }
                    i2++;
                }
            }
            return jSONArray;
        }
        if (i == 0) {
            return new JSONArray();
        }
        JSONObject jSONObject = new JSONObject();
        LuaValue luaValue3 = LuaValue.NIL;
        while (true) {
            Varargs next = v.next(luaValue3);
            luaValue3 = next.arg1();
            if (luaValue3.isnil()) {
                return jSONObject;
            }
            String str = luaValue3.tojstring();
            Json json2 = INSTANCE;
            LuaValue arg = next.arg(2);
            Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
            jSONObject.put(str, json2.toJson(arg, depth + 1));
        }
    }

    public final LuaValue decode(LuaRuntime rt, String s) {
        LuaNumber valueOf;
        Object jSONArray;
        Intrinsics.checkNotNullParameter(rt, "rt");
        Intrinsics.checkNotNullParameter(s, "s");
        String obj = StringsKt.trim((CharSequence) s).toString();
        if (StringsKt.startsWith$default(obj, "{", false, 2, (Object) null)) {
            jSONArray = new JSONObject(obj);
        } else {
            if (!StringsKt.startsWith$default(obj, "[", false, 2, (Object) null)) {
                if (Intrinsics.areEqual(obj, "null")) {
                    LuaValue NIL = LuaValue.NIL;
                    Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
                    return NIL;
                }
                if (Intrinsics.areEqual(obj, "true")) {
                    LuaBoolean TRUE = LuaValue.TRUE;
                    Intrinsics.checkNotNullExpressionValue(TRUE, "TRUE");
                    return TRUE;
                }
                if (Intrinsics.areEqual(obj, "false")) {
                    LuaBoolean FALSE = LuaValue.FALSE;
                    Intrinsics.checkNotNullExpressionValue(FALSE, "FALSE");
                    return FALSE;
                }
                if (StringsKt.startsWith$default(obj, "\"", false, 2, (Object) null)) {
                    LuaString valueOf2 = LuaValue.valueOf(new JSONArray("[" + obj + "]").getString(0));
                    Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
                    return valueOf2;
                }
                Double doubleOrNull = StringsKt.toDoubleOrNull(obj);
                if (doubleOrNull == null || (valueOf = LuaValue.valueOf(doubleOrNull.doubleValue())) == null) {
                    throw new LuaError("Can't parse JSON");
                }
                return valueOf;
            }
            jSONArray = new JSONArray(obj);
        }
        return fromJson(jSONArray);
    }

    public final String encode(LuaValue v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return String.valueOf(toJson(v, 0));
    }
}
