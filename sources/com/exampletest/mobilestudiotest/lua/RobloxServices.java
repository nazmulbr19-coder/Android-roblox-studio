package com.exampletest.mobilestudiotest.lua;

import androidx.core.app.NotificationCompat;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.net.Http;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.Charsets;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* compiled from: RobloxServices.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J.\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005J \u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\rH\u0002J \u0010\u0014\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0015\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\tH\u0002J\u0018\u0010\u001a\u001a\u00020\u00192\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0002J(\u0010\u001b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0002¨\u0006\u001d"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/RobloxServices;", "", "<init>", "()V", NotificationCompat.CATEGORY_CALL, "Lorg/luaj/vm2/Varargs;", "api", "Lcom/exampletest/mobilestudiotest/lua/InstanceApi;", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "name", "", "a", "productInfo", "Lorg/luaj/vm2/LuaValue;", "id", "", "infoType", "awaitCallback", "tweenValue", "tw", "Lcom/exampletest/mobilestudiotest/lua/Tween;", "pathObject", "Lorg/luaj/vm2/LuaTable;", "dataStore", "http", "svc", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RobloxServices {
    public static final RobloxServices INSTANCE = new RobloxServices();

    private RobloxServices() {
    }

    private final LuaValue awaitCallback(LuaRuntime rt, Instance inst, String name) {
        LuaValue luaValue;
        LuaValue luaValue2;
        HashMap<String, LuaValue> hashMap = rt.getCallbacks().get(inst);
        if (hashMap != null && (luaValue2 = hashMap.get(name)) != null) {
            return luaValue2;
        }
        if (rt.currentCoroutine() == null) {
            throw new LuaError(name + " callback is not set");
        }
        double d = 0.0d;
        while (d < 30.0d) {
            rt.yieldFor(0.05d);
            d += 0.05d;
            HashMap<String, LuaValue> hashMap2 = rt.getCallbacks().get(inst);
            if (hashMap2 != null && (luaValue = hashMap2.get(name)) != null) {
                return luaValue;
            }
            if (inst.getDestroyed()) {
                break;
            }
            if (d > 5.0d && d < 5.06d) {
                OutputLog.INSTANCE.warn("Waiting for " + inst.fullName() + "." + name + " to be set…");
            }
        }
        throw new LuaError(name + " callback is not set");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void call$lambda$14(Studio studio) {
        studio.getUndo().undo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void call$lambda$15(Studio studio) {
        studio.getUndo().redo();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs call$lambda$18(String str, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaString valueOf = LuaValue.valueOf(str);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs call$lambda$24$lambda$23(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs call$lambda$27$lambda$25(Varargs a2x) {
        Intrinsics.checkNotNullParameter(a2x, "a2x");
        LuaValue arg = a2x.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        return arg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs call$lambda$27$lambda$26(Varargs a2x) {
        Intrinsics.checkNotNullParameter(a2x, "a2x");
        LuaValue arg = a2x.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        return arg;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit call$lambda$3(Instance instance) {
        if (!instance.getDestroyed()) {
            instance.destroy();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void call$lambda$7(Studio studio) {
        studio.stopPlay();
    }

    private final LuaTable dataStore(LuaRuntime rt, String name) {
        HashMap<String, String> hashMap;
        HashMap<String, HashMap<String, String>> dataStores = rt.getStudio().getDataStores();
        HashMap<String, String> hashMap2 = dataStores.get(name);
        if (hashMap2 == null) {
            hashMap = new HashMap<>();
            dataStores.put(name, hashMap);
        } else {
            hashMap = hashMap2;
        }
        HashMap<String, String> hashMap3 = hashMap;
        LuaTable luaTable = new LuaTable();
        luaTable.set("GetAsync", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda8(hashMap3, rt)));
        luaTable.set("SetAsync", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda9(hashMap3)));
        luaTable.set("RemoveAsync", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda10(hashMap3, rt)));
        luaTable.set("IncrementAsync", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda11(hashMap3, rt)));
        luaTable.set("UpdateAsync", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda12(hashMap3, rt)));
        luaTable.set("GetSortedAsync", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda13(hashMap3, rt)));
        return luaTable;
    }

    private static final LuaValue dataStore$get(HashMap<String, String> hashMap, LuaRuntime luaRuntime, String str) {
        LuaValue decode;
        String str2 = hashMap.get(str);
        if (str2 != null && (decode = Json.INSTANCE.decode(luaRuntime, str2)) != null) {
            return decode;
        }
        LuaValue NIL = LuaValue.NIL;
        Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
        return NIL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs dataStore$lambda$46(HashMap hashMap, LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        String str = a.arg(2).tojstring();
        Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
        return dataStore$get(hashMap, luaRuntime, str);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs dataStore$lambda$47(HashMap hashMap, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        String str = a.arg(2).tojstring();
        Json json = Json.INSTANCE;
        LuaValue arg = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        hashMap.put(str, json.encode(arg));
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs dataStore$lambda$48(HashMap hashMap, LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        String str = a.arg(2).tojstring();
        Intrinsics.checkNotNull(str);
        LuaValue dataStore$get = dataStore$get(hashMap, luaRuntime, str);
        hashMap.remove(str);
        return dataStore$get;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs dataStore$lambda$49(HashMap hashMap, LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        String str = a.arg(2).tojstring();
        Intrinsics.checkNotNull(str);
        double optdouble = dataStore$get(hashMap, luaRuntime, str).optdouble(0.0d) + a.arg(3).optdouble(1.0d);
        Json json = Json.INSTANCE;
        LuaNumber valueOf = LuaValue.valueOf(optdouble);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        hashMap.put(str, json.encode(valueOf));
        LuaNumber valueOf2 = LuaValue.valueOf(optdouble);
        Intrinsics.checkNotNullExpressionValue(valueOf2, "valueOf(...)");
        return valueOf2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs dataStore$lambda$50(HashMap hashMap, LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        String str = a.arg(2).tojstring();
        LuaValue arg = a.arg(3);
        Intrinsics.checkNotNull(str);
        LuaValue call = arg.call(dataStore$get(hashMap, luaRuntime, str));
        if (!call.isnil()) {
            Json json = Json.INSTANCE;
            Intrinsics.checkNotNull(call);
            hashMap.put(str, json.encode(call));
        }
        Intrinsics.checkNotNull(call);
        return call;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs dataStore$lambda$54(HashMap hashMap, LuaRuntime luaRuntime, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        LuaTable luaTable = new LuaTable();
        LuaTable luaTable2 = new LuaTable();
        Set<Map.Entry> entrySet = hashMap.entrySet();
        Intrinsics.checkNotNullExpressionValue(entrySet, "<get-entries>(...)");
        for (Map.Entry entry : entrySet) {
            Intrinsics.checkNotNull(entry);
            Object key = entry.getKey();
            Intrinsics.checkNotNullExpressionValue(key, "component1(...)");
            Object value = entry.getValue();
            Intrinsics.checkNotNullExpressionValue(value, "component2(...)");
            LuaTable luaTable3 = new LuaTable();
            luaTable3.set("key", (String) key);
            luaTable3.set("value", Json.INSTANCE.decode(luaRuntime, (String) value));
            luaTable2.insert(0, luaTable3);
        }
        luaTable.set("GetCurrentPage", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda15(luaTable2)));
        luaTable.set("AdvanceToNextPageAsync", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda16()));
        luaTable.set("IsFinished", LuaValue.TRUE);
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs dataStore$lambda$54$lambda$52(LuaTable luaTable, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs dataStore$lambda$54$lambda$53(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    private final Varargs http(LuaRuntime rt, Instance svc, String name, Varargs a) {
        String str;
        String str2;
        String str3;
        String str4;
        if (!Intrinsics.areEqual(svc.get("HttpEnabled"), (Object) true)) {
            throw new LuaError("Http requests are not enabled. Enable via game settings (set HttpService.HttpEnabled = true)");
        }
        LuaThread currentCoroutine = rt.currentCoroutine();
        if (currentCoroutine == null) {
            throw new LuaError("HTTP requests must be made from a yieldable thread");
        }
        LuaValue arg = a.arg(2);
        HashMap hashMap = new HashMap();
        if (Intrinsics.areEqual(name, "RequestAsync")) {
            String checkjstring = arg.get("Url").checkjstring();
            Intrinsics.checkNotNullExpressionValue(checkjstring, "checkjstring(...)");
            String optjstring = arg.get("Method").optjstring("GET");
            Intrinsics.checkNotNullExpressionValue(optjstring, "optjstring(...)");
            str = arg.get("Body").isnil() ? null : arg.get("Body").tojstring();
            LuaValue luaValue = arg.get("Headers");
            if (luaValue.istable()) {
                LuaValue luaValue2 = LuaValue.NIL;
                while (true) {
                    Varargs next = luaValue.next(luaValue2);
                    luaValue2 = next.arg1();
                    if (luaValue2.isnil()) {
                        break;
                    }
                    hashMap.put(luaValue2.tojstring(), next.arg(2).tojstring());
                }
            }
            str2 = optjstring;
            str3 = checkjstring;
            str4 = str;
        } else {
            String checkjstring2 = arg.checkjstring();
            Intrinsics.checkNotNullExpressionValue(checkjstring2, "checkjstring(...)");
            String str5 = Intrinsics.areEqual(name, "PostAsync") ? "POST" : "GET";
            str = Intrinsics.areEqual(name, "PostAsync") ? a.arg(3).tojstring() : null;
            if (Intrinsics.areEqual(name, "PostAsync")) {
                hashMap.put("Content-Type", "application/json");
            }
            str2 = str5;
            str3 = checkjstring2;
            str4 = str;
        }
        new Thread(new RobloxServices$$ExternalSyntheticLambda0(str3, str2, str4, rt, rt.getPlay() != null ? "A script in this game" : "A plugin", hashMap, name, currentCoroutine)).start();
        Varargs yield = rt.getGlobals().yield(LuaValue.NONE);
        if (!yield.arg1().toboolean()) {
            throw new LuaError(yield.arg(2).tojstring());
        }
        LuaValue arg2 = yield.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        return arg2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:10:0x004e, code lost:
    
        throw new java.io.IOException("Only http and https URLs are supported");
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x018f, code lost:
    
        if (r1.element < 400) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0191, code lost:
    
        r1 = r12.getErrorStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x019a, code lost:
    
        if (r1 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x019c, code lost:
    
        r13 = new java.io.InputStreamReader(r1, kotlin.text.Charsets.UTF_8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x01a7, code lost:
    
        if ((r13 instanceof java.io.BufferedReader) == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x01a9, code lost:
    
        r13 = (java.io.BufferedReader) r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x01b4, code lost:
    
        r1 = kotlin.io.TextStreamsKt.readText(r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x01ba, code lost:
    
        if (r1 == null) goto L87;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x01bc, code lost:
    
        r1 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x01bf, code lost:
    
        r6.element = r1;
        r12.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01ac, code lost:
    
        r13 = new java.io.BufferedReader(r13, 8192);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01bd, code lost:
    
        r1 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0196, code lost:
    
        r1 = r12.getInputStream();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void http$lambda$58(java.lang.String r25, java.lang.String r26, java.lang.String r27, com.exampletest.mobilestudiotest.lua.LuaRuntime r28, java.lang.String r29, java.util.HashMap r30, java.lang.String r31, org.luaj.vm2.LuaThread r32) {
        /*
            Method dump skipped, instructions count: 547
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.RobloxServices.http$lambda$58(java.lang.String, java.lang.String, java.lang.String, com.exampletest.mobilestudiotest.lua.LuaRuntime, java.lang.String, java.util.HashMap, java.lang.String, org.luaj.vm2.LuaThread):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit http$lambda$58$lambda$57(Ref.ObjectRef objectRef, String str, Ref.IntRef intRef, Ref.ObjectRef objectRef2, LuaRuntime luaRuntime, LuaThread luaThread) {
        Varargs varargsOf;
        if (objectRef.element != 0) {
            varargsOf = LuaValue.varargsOf(LuaValue.FALSE, LuaValue.valueOf("HttpError: " + objectRef.element));
            Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
        } else {
            if (Intrinsics.areEqual(str, "RequestAsync")) {
                LuaTable luaTable = new LuaTable();
                luaTable.set("Success", LuaValue.valueOf(200 <= intRef.element && intRef.element < 300));
                luaTable.set("StatusCode", intRef.element);
                luaTable.set("StatusMessage", "");
                luaTable.set("Body", (String) objectRef2.element);
                luaTable.set("Headers", new LuaTable());
                varargsOf = LuaValue.varargsOf(LuaValue.TRUE, luaTable);
                Intrinsics.checkNotNull(varargsOf);
            } else {
                if (200 <= intRef.element && intRef.element < 300) {
                    varargsOf = LuaValue.varargsOf(LuaValue.TRUE, LuaValue.valueOf((String) objectRef2.element));
                    Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
                } else {
                    varargsOf = LuaValue.varargsOf(LuaValue.FALSE, LuaValue.valueOf("HTTP " + intRef.element));
                    Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
                }
            }
        }
        luaRuntime.resume(luaThread, varargsOf);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [java.util.List, T] */
    private final LuaTable pathObject(LuaRuntime rt) {
        LuaTable luaTable = new LuaTable();
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = CollectionsKt.emptyList();
        luaTable.set("Status", LuaTypes.INSTANCE.wrap(new EnumItemV("PathStatus", "Success", 0)));
        luaTable.set("ComputeAsync", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda17(objectRef)));
        luaTable.set("GetWaypoints", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda18(objectRef)));
        luaTable.set("Destroy", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda19()));
        LuaTable luaTable2 = new LuaTable();
        luaTable2.set(LuaValue.INDEX, LuaTypesKt.fn2(new RobloxServices$$ExternalSyntheticLambda20(rt, luaTable)));
        luaTable.setmetatable(luaTable2);
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.util.List, T] */
    public static final Varargs pathObject$lambda$40(Ref.ObjectRef objectRef, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        Vector3[] vector3Arr = new Vector3[2];
        LuaValue arg = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Vector3)) {
            obj = null;
        }
        Vector3 vector3 = (Vector3) obj;
        if (vector3 == null) {
            throw new LuaError("Vector3 expected, got " + LuaTypes.INSTANCE.typeOf(arg));
        }
        vector3Arr[0] = vector3;
        LuaValue arg2 = a.arg(3);
        Intrinsics.checkNotNullExpressionValue(arg2, "arg(...)");
        Object obj2 = arg2.isuserdata() ? arg2.touserdata() : null;
        Vector3 vector32 = (Vector3) (obj2 instanceof Vector3 ? obj2 : null);
        if (vector32 == null) {
            throw new LuaError("Vector3 expected, got " + LuaTypes.INSTANCE.typeOf(arg2));
        }
        vector3Arr[1] = vector32;
        objectRef.element = CollectionsKt.listOf((Object[]) vector3Arr);
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs pathObject$lambda$41(Ref.ObjectRef objectRef, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        LuaTable luaTable = new LuaTable();
        for (Vector3 vector3 : (List) objectRef.element) {
            LuaTable luaTable2 = new LuaTable();
            luaTable2.set("Position", LuaTypes.INSTANCE.wrap(vector3));
            luaTable2.set("Action", LuaTypes.INSTANCE.wrap(new EnumItemV("PathWaypointAction", "Walk", 0)));
            luaTable.insert(0, luaTable2);
        }
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs pathObject$lambda$42(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue pathObject$lambda$43(LuaRuntime luaRuntime, LuaTable luaTable, LuaValue luaValue, LuaValue k) {
        Intrinsics.checkNotNullParameter(luaValue, "<unused var>");
        Intrinsics.checkNotNullParameter(k, "k");
        if (!Intrinsics.areEqual(k.tojstring(), "Blocked") && !Intrinsics.areEqual(k.tojstring(), "Unblocked")) {
            LuaValue NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
            return NIL;
        }
        InstanceApi api = luaRuntime.getApi();
        String str = k.tojstring();
        Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
        return api.signal(luaTable, str);
    }

    private final LuaValue productInfo(LuaRuntime rt, long id, String infoType) {
        LuaThread currentCoroutine = rt.currentCoroutine();
        if (currentCoroutine == null) {
            return productInfo$placeholder(id);
        }
        if (!Intrinsics.areEqual(infoType, "Asset") || id <= 0) {
            return productInfo$placeholder(id);
        }
        new Thread(new RobloxServices$$ExternalSyntheticLambda14(id, rt, currentCoroutine)).start();
        LuaValue arg1 = rt.getGlobals().yield(LuaValue.NONE).arg1();
        Intrinsics.checkNotNullExpressionValue(arg1, "arg1(...)");
        return arg1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void productInfo$lambda$32(long j, LuaRuntime luaRuntime, LuaThread luaThread) {
        String str;
        try {
            str = new String(Http.get$default(Http.INSTANCE, "https://economy.roblox.com/v2/assets/" + j + "/details", null, 0, 6, null), Charsets.UTF_8);
        } catch (Exception e) {
            str = null;
        }
        luaRuntime.getMainQueue().add(new RobloxServices$$ExternalSyntheticLambda1(str, luaRuntime, luaThread, j));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit productInfo$lambda$32$lambda$31(String str, LuaRuntime luaRuntime, LuaThread luaThread, long j) {
        LuaValue luaValue = null;
        if (str != null) {
            try {
                luaValue = Json.INSTANCE.decode(luaRuntime, str);
            } catch (Exception e) {
            }
        }
        luaRuntime.resume(luaThread, (luaValue == null || !luaValue.istable()) ? productInfo$placeholder(j) : luaValue);
        return Unit.INSTANCE;
    }

    private static final LuaTable productInfo$placeholder(long j) {
        LuaTable luaTable = new LuaTable();
        luaTable.set("Name", "Product");
        luaTable.set("Description", "");
        luaTable.set("PriceInRobux", 0);
        luaTable.set("AssetId", j);
        luaTable.set("IsForSale", LuaValue.FALSE);
        return luaTable;
    }

    private final LuaValue tweenValue(LuaRuntime rt, Tween tw) {
        LuaTable luaTable = new LuaTable();
        luaTable.set("Play", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda3(rt, tw)));
        luaTable.set("Pause", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda4(tw)));
        luaTable.set("Cancel", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda5(tw, rt)));
        luaTable.set("Destroy", LuaTypesKt.fnv(new RobloxServices$$ExternalSyntheticLambda6(tw, rt)));
        luaTable.set("Instance", rt.wrap(tw.getInst()));
        luaTable.set("TweenInfo", LuaTypes.INSTANCE.wrap(tw.getInfo()));
        LuaTable luaTable2 = new LuaTable();
        luaTable2.set("__type", "Tween");
        luaTable2.set(LuaValue.INDEX, LuaTypesKt.fn2(new RobloxServices$$ExternalSyntheticLambda7(rt, tw)));
        luaTable.setmetatable(luaTable2);
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs tweenValue$lambda$35(LuaRuntime luaRuntime, Tween tween, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        luaRuntime.playTween(tween);
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs tweenValue$lambda$36(Tween tween, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (tween.getState() == 2) {
            tween.setState(3);
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs tweenValue$lambda$37(Tween tween, LuaRuntime luaRuntime, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        tween.setState(5);
        luaRuntime.getTweens().remove(tween);
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs tweenValue$lambda$38(Tween tween, LuaRuntime luaRuntime, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        tween.setState(5);
        luaRuntime.getTweens().remove(tween);
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue tweenValue$lambda$39(LuaRuntime luaRuntime, Tween tween, LuaValue luaValue, LuaValue k) {
        Intrinsics.checkNotNullParameter(luaValue, "<unused var>");
        Intrinsics.checkNotNullParameter(k, "k");
        String str = k.tojstring();
        if (Intrinsics.areEqual(str, "Completed")) {
            return luaRuntime.getApi().signal(tween, "Completed");
        }
        if (Intrinsics.areEqual(str, "PlaybackState")) {
            return LuaTypes.INSTANCE.wrap(new EnumItemV("PlaybackState", (String) CollectionsKt.listOf((Object[]) new String[]{"Begin", "Delayed", "Playing", "Paused", "Completed", "Cancelled"}).get(tween.getState()), tween.getState()));
        }
        LuaValue NIL = LuaValue.NIL;
        Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
        return NIL;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:1028:0x188d, code lost:
    
        if (r37.equals("IsRunning") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1029:0x18a1, code lost:
    
        r0 = org.luaj.vm2.LuaValue.valueOf(r35.getIsPlay());
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1030:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1032:0x189f, code lost:
    
        if (r37.equals("IsRunMode") != false) goto L880;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1034:0x18bf, code lost:
    
        if (r37.equals("FinishRecording") != false) goto L883;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1036:0x18d9, code lost:
    
        if (r37.equals("CreateCollisionGroup") != false) goto L886;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1038:0x18ee, code lost:
    
        if (r37.equals("GetUserId") != false) goto L889;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1040:0x190c, code lost:
    
        if (r37.equals("PromptProductPurchase") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1042:0x191d, code lost:
    
        if (r37.equals("PromptGamePassPurchase") != false) goto L895;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1052:0x1991, code lost:
    
        if (r37.equals("Activate") != false) goto L904;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1054:0x19cd, code lost:
    
        if (r37.equals("GetPlaySessionId") != false) goto L915;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1060:0x1a0a, code lost:
    
        if (r37.equals("SetSetting") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1085:0x1aa8, code lost:
    
        if (r37.equals("ReleaseFocus") != false) goto L943;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1130:0x1c23, code lost:
    
        if (r37.equals("BindAction") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1131:0x1dcc, code lost:
    
        r4 = r38.arg(4).toboolean();
     */
    /* JADX WARN: Code restructure failed: missing block: B:1132:0x1dd6, code lost:
    
        if (r15 == null) goto L1026;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1133:0x1dd8, code lost:
    
        r5 = r12.checkjstring();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "checkjstring(...)");
        r6 = r38.arg(3).checkfunction();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "checkfunction(...)");
        r15.bindAction(r5, r6, r4);
        r5 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1134:0x1df3, code lost:
    
        r0 = org.luaj.vm2.LuaValue.NONE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:1135:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1149:0x1c89, code lost:
    
        if (r37.equals("OpenScript") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1160:0x1ce6, code lost:
    
        if (r37.equals("InputHoldEnd") != false) goto L1002;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1174:0x1d64, code lost:
    
        if (r37.equals("IsMouseButtonPressed") != false) goto L1014;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1184:0x1dca, code lost:
    
        if (r37.equals("BindActionAtPriority") != false) goto L1023;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1186:0x1e0e, code lost:
    
        if (r37.equals("TweenSize") == false) goto L1029;
     */
    /* JADX WARN: Code restructure failed: missing block: B:1188:0x1fc3, code lost:
    
        if (r37.equals("SetPartCollisionGroup") != false) goto L1100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:181:0x0404, code lost:
    
        if (r37.equals("CreateToolbar") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:197:0x04a6, code lost:
    
        if (r37.equals("CreateDockWidgetPluginGui") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x04b5, code lost:
    
        if (r37.equals("FilterStringAsync") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:200:0x11a2, code lost:
    
        r0 = r12.tojstring();
        r4 = new org.luaj.vm2.LuaTable();
        r5 = kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new java.lang.String[]{"GetNonChatStringForBroadcastAsync", "GetNonChatStringForUserAsync", "GetChatForUserAsync"}).iterator();
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x11cc, code lost:
    
        if (r5.hasNext() == false) goto L1119;
     */
    /* JADX WARN: Code restructure failed: missing block: B:203:0x11ce, code lost:
    
        r4.set((java.lang.String) r5.next(), com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(new com.exampletest.mobilestudiotest.lua.RobloxServices$$ExternalSyntheticLambda25(r0)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:206:0x11e9, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r37, "FilterStringForBroadcast") == false) goto L650;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x11eb, code lost:
    
        r5 = org.luaj.vm2.LuaValue.valueOf(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x11f5, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:209:?, code lost:
    
        return r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x11f2, code lost:
    
        r5 = r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:227:0x0508, code lost:
    
        if (r14 != false) goto L191;
     */
    /* JADX WARN: Code restructure failed: missing block: B:234:0x0521, code lost:
    
        if (r37.equals("SetRBXEvent") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x089d, code lost:
    
        r14 = "NONE";
     */
    /* JADX WARN: Code restructure failed: missing block: B:292:0x05d0, code lost:
    
        if (r37.equals("RequestAsync") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:294:0x05df, code lost:
    
        if (r37.equals("ScreenPointToRay") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:295:0x15cd, code lost:
    
        r0 = r2.guiUnit();
        r4 = r2.getView();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r12);
        r5 = com.exampletest.mobilestudiotest.lua.LuaTypesKt.num(r12) * r0;
        r6 = r38.arg(3);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, "arg(...)");
        r4 = r4.screenRay(r5, com.exampletest.mobilestudiotest.lua.LuaTypesKt.num(r6) * r0);
        r5 = r4.component1();
        r4 = r4.component2();
        r6 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE;
        r13 = r38.arg(4);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r13, "arg(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:296:?, code lost:
    
        return r6.wrap(new com.exampletest.mobilestudiotest.model.Ray(r5, r4.times(com.exampletest.mobilestudiotest.lua.LuaTypesKt.optNum(r13, 1.0f))));
     */
    /* JADX WARN: Code restructure failed: missing block: B:298:0x05ee, code lost:
    
        if (r37.equals("ReportStats") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:306:0x0626, code lost:
    
        if (r37.equals("GetObjects") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:307:0x0b3b, code lost:
    
        r0 = org.luaj.vm2.LuaValue.NONE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "NONE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:308:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:321:0x06a3, code lost:
    
        if (r37.equals("GetKeysPressed") != false) goto L244;
     */
    /* JADX WARN: Code restructure failed: missing block: B:323:0x06bb, code lost:
    
        if (r37.equals("CreateButton") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:434:0x07b4, code lost:
    
        if (r37.equals("SelectRibbonTool") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:472:0x089b, code lost:
    
        if (r37.equals("ReportCounter") != false) goto L322;
     */
    /* JADX WARN: Code restructure failed: missing block: B:474:0x08ac, code lost:
    
        if (r37.equals("GetMoonDirection") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:476:?, code lost:
    
        return com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE.wrap(new com.exampletest.mobilestudiotest.model.Vector3(0.4f, 0.8f, 0.3f).getUnit());
     */
    /* JADX WARN: Code restructure failed: missing block: B:482:0x08d3, code lost:
    
        if (r37.equals("TeleportToPlaceInstance") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:483:0x1785, code lost:
    
        com.exampletest.mobilestudiotest.core.OutputLog.INSTANCE.warn("Teleporting is not supported in Studio");
        r0 = org.luaj.vm2.LuaValue.NONE;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:484:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:486:0x08e2, code lost:
    
        if (r37.equals("IsFriendsWith") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:487:0x0a01, code lost:
    
        r13 = "valueOf(...)";
     */
    /* JADX WARN: Code restructure failed: missing block: B:488:0x1599, code lost:
    
        r0 = org.luaj.vm2.LuaValue.valueOf(kotlin.jvm.internal.Intrinsics.areEqual(r37, "HasAppearanceLoaded"));
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:489:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:491:0x08f1, code lost:
    
        if (r37.equals("GetSessionId") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:492:0x0aa9, code lost:
    
        r13 = "valueOf(...)";
     */
    /* JADX WARN: Code restructure failed: missing block: B:493:0x19cf, code lost:
    
        r0 = org.luaj.vm2.LuaValue.valueOf("00000000-0000-0000-0000-000000000000");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:494:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:511:0x0945, code lost:
    
        if (r37.equals("GetSetting") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:513:0x0954, code lost:
    
        if (r37.equals("CreatePluginAction") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:532:0x09e1, code lost:
    
        if (r37.equals("IsKeyDown") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:533:0x1d66, code lost:
    
        r0 = org.luaj.vm2.LuaValue.FALSE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, "FALSE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:534:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:536:0x09f0, code lost:
    
        if (r37.equals("CreatePluginMenu") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:538:0x09ff, code lost:
    
        if (r37.equals("HasAppearanceLoaded") != false) goto L377;
     */
    /* JADX WARN: Code restructure failed: missing block: B:576:0x0aa7, code lost:
    
        if (r37.equals("GetClientId") != false) goto L401;
     */
    /* JADX WARN: Code restructure failed: missing block: B:578:0x0ab7, code lost:
    
        if (r37.equals("GetOrderedDataStore") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:580:0x104d, code lost:
    
        if (r12.isnil() == false) goto L578;
     */
    /* JADX WARN: Code restructure failed: missing block: B:581:0x104f, code lost:
    
        r0 = "global";
     */
    /* JADX WARN: Code restructure failed: missing block: B:582:0x1056, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:583:?, code lost:
    
        return dataStore(r35, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:584:0x1052, code lost:
    
        r0 = r12.tojstring();
     */
    /* JADX WARN: Code restructure failed: missing block: B:594:0x0b33, code lost:
    
        if (r37.equals("SetPlaceId") == false) goto L414;
     */
    /* JADX WARN: Code restructure failed: missing block: B:596:0x0b55, code lost:
    
        if (r37.equals("SetPosition") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:670:0x0d80, code lost:
    
        if (r37.equals("Emit") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:747:0x0f83, code lost:
    
        if (r37.equals("Deactivate") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:749:0x199d, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r9.getClassName(), "Plugin") == false) goto L907;
     */
    /* JADX WARN: Code restructure failed: missing block: B:750:0x199f, code lost:
    
        r0 = org.luaj.vm2.LuaValue.NONE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:751:0x19b6, code lost:
    
        kotlin.jvm.internal.Intrinsics.checkNotNull(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:752:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:754:0x19a8, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r37, "Activate") == false) goto L910;
     */
    /* JADX WARN: Code restructure failed: missing block: B:755:0x19aa, code lost:
    
        r0 = "Activated";
     */
    /* JADX WARN: Code restructure failed: missing block: B:756:0x19af, code lost:
    
        r35.fire(r9, r0, new org.luaj.vm2.LuaValue[0]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:757:0x19ad, code lost:
    
        r0 = "Deactivated";
     */
    /* JADX WARN: Code restructure failed: missing block: B:759:0x0f94, code lost:
    
        if (r37.equals("ReportInfluxSeries") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:765:0x0fd0, code lost:
    
        if (r37.equals("GetGlobalDataStore") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:782:0x1036, code lost:
    
        if (r37.equals("IsServer") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:783:0x1272, code lost:
    
        r0 = org.luaj.vm2.LuaValue.TRUE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:784:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:786:0x1047, code lost:
    
        if (r37.equals("GetDataStore") != false) goto L575;
     */
    /* JADX WARN: Code restructure failed: missing block: B:788:0x1070, code lost:
    
        if (r37.equals("FireLogEvent") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:790:0x1081, code lost:
    
        if (r37.equals("PostAsync") != false) goto L585;
     */
    /* JADX WARN: Code restructure failed: missing block: B:849:0x11a0, code lost:
    
        if (r37.equals("FilterStringForBroadcast") != false) goto L643;
     */
    /* JADX WARN: Code restructure failed: missing block: B:851:0x120c, code lost:
    
        if (r37.equals("SendEventDeferred") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:853:0x121d, code lost:
    
        if (r37.equals("ResetWaypoints") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:855:0x122e, code lost:
    
        if (r37.equals("GetSunDirection") != false) goto L660;
     */
    /* JADX WARN: Code restructure failed: missing block: B:857:0x125d, code lost:
    
        if (r37.equals("TweenPosition") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:859:0x1270, code lost:
    
        if (r37.equals("IsClient") != false) goto L666;
     */
    /* JADX WARN: Code restructure failed: missing block: B:891:0x135f, code lost:
    
        if (r37.equals("GetCanUndo") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:892:0x1374, code lost:
    
        r0 = org.luaj.vm2.LuaValue.TRUE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:893:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:895:0x1372, code lost:
    
        if (r37.equals("GetCanRedo") != false) goto L701;
     */
    /* JADX WARN: Code restructure failed: missing block: B:897:0x138e, code lost:
    
        if (r37.equals("WorldToViewportPoint") != false) goto L704;
     */
    /* JADX WARN: Code restructure failed: missing block: B:913:0x14de, code lost:
    
        if (r37.equals("UserOwnsGamePassAsync") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:915:0x14ef, code lost:
    
        if (r37.equals("SetDescription") != false) goto L746;
     */
    /* JADX WARN: Code restructure failed: missing block: B:921:0x1523, code lost:
    
        if (r37.equals("PromptImportFile") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:937:0x1585, code lost:
    
        if (r37.equals("SetEnabled") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:939:0x1597, code lost:
    
        if (r37.equals("IsInGroup") != false) goto L770;
     */
    /* JADX WARN: Code restructure failed: missing block: B:941:0x15ba, code lost:
    
        if (r37.equals("GetStudioUserId") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:942:0x18f0, code lost:
    
        r0 = org.luaj.vm2.LuaValue.valueOf(0);
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r13);
     */
    /* JADX WARN: Code restructure failed: missing block: B:943:?, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:945:0x15cb, code lost:
    
        if (r37.equals("ViewportPointToRay") != false) goto L776;
     */
    /* JADX WARN: Code restructure failed: missing block: B:947:0x162a, code lost:
    
        if (r37.equals("CollisionGroupSetCollidable") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:948:0x18db, code lost:
    
        r5 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:954:0x1664, code lost:
    
        if (r37.equals("TeleportAsync") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:956:0x1675, code lost:
    
        if (r37.equals("InputHoldBegin") != false) goto L788;
     */
    /* JADX WARN: Code restructure failed: missing block: B:958:0x1687, code lost:
    
        if (r37.equals("UserHasBadgeAsync") != false) goto L791;
     */
    /* JADX WARN: Code restructure failed: missing block: B:960:0x16a3, code lost:
    
        if (r37.equals("addItem") != false) goto L794;
     */
    /* JADX WARN: Code restructure failed: missing block: B:962:0x1716, code lost:
    
        if (r37.equals("TrackEvent") != false) goto L808;
     */
    /* JADX WARN: Code restructure failed: missing block: B:968:0x1761, code lost:
    
        if (r37.equals("IsActivated") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:970:0x1772, code lost:
    
        if (r37.equals("GetSelectedRibbonTool") == false) goto L991;
     */
    /* JADX WARN: Code restructure failed: missing block: B:972:0x1783, code lost:
    
        if (r37.equals("Teleport") != false) goto L820;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:40:0x0107. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v111 */
    /* JADX WARN: Type inference failed for: r14v113 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.luaj.vm2.Varargs call(com.exampletest.mobilestudiotest.lua.InstanceApi r34, com.exampletest.mobilestudiotest.lua.LuaRuntime r35, com.exampletest.mobilestudiotest.model.Instance r36, java.lang.String r37, org.luaj.vm2.Varargs r38) {
        /*
            Method dump skipped, instructions count: 8924
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.RobloxServices.call(com.exampletest.mobilestudiotest.lua.InstanceApi, com.exampletest.mobilestudiotest.lua.LuaRuntime, com.exampletest.mobilestudiotest.model.Instance, java.lang.String, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }
}
