package com.exampletest.mobilestudiotest.lua;

import androidx.core.app.NotificationCompat;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.Ray;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;

/* compiled from: RobloxGlobals.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005J\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\tH\u0002J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u0007J(\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u000bH\u0002J(\u0010\u0015\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/PluginApi;", "", "<init>", "()V", NotificationCompat.CATEGORY_CALL, "Lorg/luaj/vm2/Varargs;", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "name", "", "a", "pluginId", "i", "pluginMouse", "Lorg/luaj/vm2/LuaTable;", "action", "id", "text", "tip", "menu", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "title", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PluginApi {
    public static final PluginApi INSTANCE = new PluginApi();

    private PluginApi() {
    }

    private final LuaTable action(LuaRuntime rt, String id, String text, String tip) {
        LuaTable luaTable = new LuaTable();
        luaTable.set("ActionId", id);
        luaTable.set("Text", text);
        luaTable.set("StatusTip", tip);
        luaTable.set("Enabled", LuaValue.TRUE);
        luaTable.set("Checked", LuaValue.FALSE);
        String str = text;
        if (str.length() == 0) {
            str = id;
        }
        luaTable.set("Name", str);
        LuaTable luaTable2 = new LuaTable();
        luaTable2.set("__type", "Instance");
        luaTable2.set(LuaValue.INDEX, LuaTypesKt.fn2(new PluginApi$$ExternalSyntheticLambda0(rt, luaTable)));
        luaTable.setmetatable(luaTable2);
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue action$lambda$12(LuaRuntime luaRuntime, LuaTable luaTable, LuaValue luaValue, LuaValue k) {
        Intrinsics.checkNotNullParameter(luaValue, "<unused var>");
        Intrinsics.checkNotNullParameter(k, "k");
        if (Intrinsics.areEqual(k.tojstring(), "Triggered")) {
            return luaRuntime.getApi().signal(luaTable, "Triggered");
        }
        LuaValue NIL = LuaValue.NIL;
        Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
        return NIL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void call$lambda$2$lambda$1(Studio studio, Instance instance) {
        studio.requestOpenScript(instance);
    }

    private final LuaTable menu(LuaRuntime rt, Studio studio, String id, String title) {
        LuaTable luaTable = new LuaTable();
        ArrayList arrayList = new ArrayList();
        luaTable.set("Title", title);
        luaTable.set("Name", id);
        luaTable.set("AddAction", LuaTypesKt.fnv(new PluginApi$$ExternalSyntheticLambda2(arrayList)));
        luaTable.set("AddNewAction", LuaTypesKt.fnv(new PluginApi$$ExternalSyntheticLambda3(rt, arrayList)));
        luaTable.set("AddSeparator", LuaTypesKt.fnv(new PluginApi$$ExternalSyntheticLambda4(arrayList)));
        luaTable.set("AddMenu", LuaTypesKt.fnv(new PluginApi$$ExternalSyntheticLambda5(arrayList)));
        luaTable.set("Clear", LuaTypesKt.fnv(new PluginApi$$ExternalSyntheticLambda6(arrayList)));
        luaTable.set("Destroy", LuaTypesKt.fnv(new PluginApi$$ExternalSyntheticLambda7(arrayList)));
        luaTable.set("ShowAsync", LuaTypesKt.fnv(new PluginApi$$ExternalSyntheticLambda8(rt, arrayList, studio, title)));
        LuaTable luaTable2 = new LuaTable();
        luaTable2.set("__type", "Instance");
        luaTable.setmetatable(luaTable2);
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs menu$lambda$13(ArrayList arrayList, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        arrayList.add(a.arg(2));
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs menu$lambda$14(LuaRuntime luaRuntime, ArrayList arrayList, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        PluginApi pluginApi = INSTANCE;
        String optjstring = a.arg(2).optjstring("");
        Intrinsics.checkNotNullExpressionValue(optjstring, "optjstring(...)");
        String optjstring2 = a.arg(3).optjstring("");
        Intrinsics.checkNotNullExpressionValue(optjstring2, "optjstring(...)");
        LuaTable action = pluginApi.action(luaRuntime, optjstring, optjstring2, "");
        arrayList.add(action);
        return action;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs menu$lambda$15(ArrayList arrayList, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        arrayList.add(LuaValue.NIL);
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs menu$lambda$16(ArrayList arrayList, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        arrayList.add(a.arg(2));
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs menu$lambda$17(ArrayList arrayList, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        arrayList.clear();
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs menu$lambda$18(ArrayList arrayList, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        arrayList.clear();
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs menu$lambda$26(LuaRuntime luaRuntime, ArrayList arrayList, Studio studio, String str, Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        LuaThread currentCoroutine = luaRuntime.currentCoroutine();
        if (currentCoroutine == null) {
            LuaValue NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
            return NIL;
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            LuaValue luaValue = (LuaValue) next;
            if (luaValue.istable() && !luaValue.get("ActionId").isnil()) {
                arrayList2.add(next);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList<LuaValue> arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
        for (LuaValue luaValue2 : arrayList4) {
            String optjstring = luaValue2.get("Text").optjstring("");
            if (optjstring.length() == 0) {
                optjstring = luaValue2.get("ActionId").tojstring();
            }
            arrayList5.add(optjstring);
        }
        studio.getMain().post(new PluginApi$$ExternalSyntheticLambda1(studio, str, arrayList5, luaRuntime, currentCoroutine, arrayList3));
        Varargs yield = luaRuntime.getGlobals().yield(LuaValue.NONE);
        Intrinsics.checkNotNullExpressionValue(yield, "yield(...)");
        return yield;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void menu$lambda$26$lambda$25(Studio studio, String str, List list, LuaRuntime luaRuntime, LuaThread luaThread, List list2) {
        Function3<String, List<String>, Function1<? super Integer, Unit>, Unit> pluginMenuHandler = studio.getPluginMenuHandler();
        if (pluginMenuHandler != null) {
            pluginMenuHandler.invoke(str, list, new PluginApi$$ExternalSyntheticLambda13(studio, list2, luaRuntime, luaThread));
            return;
        }
        synchronized (studio.getLock()) {
            LuaValue NIL = LuaValue.NIL;
            Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
            luaRuntime.resume(luaThread, NIL);
            Unit unit = Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0026 A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:21:0x0009, B:7:0x0017, B:8:0x0020, B:10:0x0026, B:11:0x0030, B:19:0x001e), top: B:20:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x001e A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:21:0x0009, B:7:0x0017, B:8:0x0020, B:10:0x0026, B:11:0x0030, B:19:0x001e), top: B:20:0x0009 }] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017 A[Catch: all -> 0x0040, TryCatch #0 {, blocks: (B:21:0x0009, B:7:0x0017, B:8:0x0020, B:10:0x0026, B:11:0x0030, B:19:0x001e), top: B:20:0x0009 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit menu$lambda$26$lambda$25$lambda$24(com.exampletest.mobilestudiotest.core.Studio r5, java.util.List r6, com.exampletest.mobilestudiotest.lua.LuaRuntime r7, org.luaj.vm2.LuaThread r8, int r9) {
        /*
            java.lang.Object r0 = r5.getLock()
            monitor-enter(r0)
            r1 = 0
            r2 = 0
            if (r9 < 0) goto L14
            r3 = r6
            java.util.Collection r3 = (java.util.Collection) r3     // Catch: java.lang.Throwable -> L40
            int r3 = r3.size()     // Catch: java.lang.Throwable -> L40
            if (r9 >= r3) goto L14
            r3 = 1
            goto L15
        L14:
            r3 = r2
        L15:
            if (r3 == 0) goto L1e
            java.lang.Object r3 = r6.get(r9)     // Catch: java.lang.Throwable -> L40
            org.luaj.vm2.LuaValue r3 = (org.luaj.vm2.LuaValue) r3     // Catch: java.lang.Throwable -> L40
            goto L20
        L1e:
            org.luaj.vm2.LuaValue r3 = org.luaj.vm2.LuaValue.NIL     // Catch: java.lang.Throwable -> L40
        L20:
            boolean r4 = r3.isnil()     // Catch: java.lang.Throwable -> L40
            if (r4 != 0) goto L30
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch: java.lang.Throwable -> L40
            java.lang.String r4 = "Triggered"
            org.luaj.vm2.LuaValue[] r2 = new org.luaj.vm2.LuaValue[r2]     // Catch: java.lang.Throwable -> L40
            r7.fire(r3, r4, r2)     // Catch: java.lang.Throwable -> L40
        L30:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch: java.lang.Throwable -> L40
            r2 = r3
            org.luaj.vm2.Varargs r2 = (org.luaj.vm2.Varargs) r2     // Catch: java.lang.Throwable -> L40
            r7.resume(r8, r2)     // Catch: java.lang.Throwable -> L40
            kotlin.Unit r1 = kotlin.Unit.INSTANCE     // Catch: java.lang.Throwable -> L40
            monitor-exit(r0)
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L40:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.PluginApi.menu$lambda$26$lambda$25$lambda$24(com.exampletest.mobilestudiotest.core.Studio, java.util.List, com.exampletest.mobilestudiotest.lua.LuaRuntime, org.luaj.vm2.LuaThread, int):kotlin.Unit");
    }

    private final String pluginId(Instance i) {
        return i.getName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0029, code lost:
    
        if (r4.equals("Button1Up") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0033, code lost:
    
        if (r4.equals("DragEnter") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x003d, code lost:
    
        if (r4.equals("WheelBackward") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0047, code lost:
    
        if (r4.equals("KeyDown") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0051, code lost:
    
        if (r4.equals("WheelForward") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005b, code lost:
    
        if (r4.equals("KeyUp") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
    
        if (r4.equals("Move") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006d, code lost:
    
        if (r4.equals("Idle") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x008a, code lost:
    
        if (r4.equals("Button2Down") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0093, code lost:
    
        if (r4.equals("Button1Down") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00b0, code lost:
    
        if (r4.equals("Changed") != false) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001f, code lost:
    
        if (r4.equals("Button2Up") != false) goto L48;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.LuaValue pluginMouse$lambda$10(com.exampletest.mobilestudiotest.lua.LuaRuntime r2, org.luaj.vm2.LuaTable r3, org.luaj.vm2.LuaValue r4, org.luaj.vm2.LuaValue r5) {
        /*
            java.lang.String r0 = "<unused var>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r4 = "k"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r4)
            java.lang.String r4 = r5.tojstring()
            if (r4 == 0) goto Lbb
            int r0 = r4.hashCode()
            switch(r0) {
                case -1891370348: goto Laa;
                case -268889839: goto L96;
                case -135444383: goto L8d;
                case -134520862: goto L84;
                case 73783: goto L70;
                case 2274292: goto L67;
                case 2404337: goto L5e;
                case 72391994: goto L55;
                case 136075018: goto L4b;
                case 848725889: goto L41;
                case 1562021950: goto L37;
                case 1668491748: goto L2d;
                case 2015499802: goto L23;
                case 2015500763: goto L19;
                default: goto L17;
            }
        L17:
            goto Lbb
        L19:
            java.lang.String r0 = "Button2Up"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lbb
            goto Lb2
        L23:
            java.lang.String r0 = "Button1Up"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto Lb2
            goto Lbb
        L2d:
            java.lang.String r0 = "DragEnter"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto Lb2
            goto Lbb
        L37:
            java.lang.String r0 = "WheelBackward"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto Lb2
            goto Lbb
        L41:
            java.lang.String r0 = "KeyDown"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto Lb2
            goto Lbb
        L4b:
            java.lang.String r0 = "WheelForward"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto Lb2
            goto Lbb
        L55:
            java.lang.String r0 = "KeyUp"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto Lb2
            goto Lbb
        L5e:
            java.lang.String r0 = "Move"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto Lb2
            goto Lbb
        L67:
            java.lang.String r0 = "Idle"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto Lb2
            goto Lbb
        L70:
            java.lang.String r0 = "IsA"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lbb
            com.exampletest.mobilestudiotest.lua.PluginApi$$ExternalSyntheticLambda9 r0 = new com.exampletest.mobilestudiotest.lua.PluginApi$$ExternalSyntheticLambda9
            r0.<init>()
            org.luaj.vm2.lib.VarArgFunction r0 = com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(r0)
            org.luaj.vm2.LuaValue r0 = (org.luaj.vm2.LuaValue) r0
            goto Lc2
        L84:
            java.lang.String r0 = "Button2Down"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto Lb2
            goto Lbb
        L8d:
            java.lang.String r0 = "Button1Down"
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto Lb2
            goto Lbb
        L96:
            java.lang.String r0 = "GetPropertyChangedSignal"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lbb
            com.exampletest.mobilestudiotest.lua.PluginApi$$ExternalSyntheticLambda10 r0 = new com.exampletest.mobilestudiotest.lua.PluginApi$$ExternalSyntheticLambda10
            r0.<init>(r2, r3)
            org.luaj.vm2.lib.VarArgFunction r0 = com.exampletest.mobilestudiotest.lua.LuaTypesKt.fnv(r0)
            org.luaj.vm2.LuaValue r0 = (org.luaj.vm2.LuaValue) r0
            goto Lc2
        Laa:
            java.lang.String r0 = "Changed"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto Lbb
        Lb2:
            com.exampletest.mobilestudiotest.lua.InstanceApi r0 = r2.getApi()
            org.luaj.vm2.LuaValue r0 = r0.signal(r3, r4)
            goto Lc2
        Lbb:
            org.luaj.vm2.LuaValue r0 = org.luaj.vm2.LuaValue.NIL
            java.lang.String r1 = "NIL"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
        Lc2:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.PluginApi.pluginMouse$lambda$10(com.exampletest.mobilestudiotest.lua.LuaRuntime, org.luaj.vm2.LuaTable, org.luaj.vm2.LuaValue, org.luaj.vm2.LuaValue):org.luaj.vm2.LuaValue");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs pluginMouse$lambda$10$lambda$8(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaBoolean valueOf = LuaValue.valueOf(SetsKt.setOf((Object[]) new String[]{"Mouse", "PluginMouse", "Instance"}).contains(a.arg(2).tojstring()));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs pluginMouse$lambda$10$lambda$9(LuaRuntime luaRuntime, LuaTable luaTable, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return luaRuntime.getApi().signal(luaTable, "Changed:" + a.arg(2).tojstring());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x027e, code lost:
    
        if (r31.equals("Union") != false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x02e1, code lost:
    
        if (r31.equals("StartDrag") == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0309, code lost:
    
        if (r31.equals("CreateDockWidgetPluginGuiAsync") != false) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03d5, code lost:
    
        if (r31.equals("PromptImportFile") != false) goto L116;
     */
    /* JADX WARN: Code restructure failed: missing block: B:178:0x040d, code lost:
    
        if (r31.equals("SaveSelectedToRoblox") != false) goto L122;
     */
    /* JADX WARN: Code restructure failed: missing block: B:207:0x04da, code lost:
    
        if (r31.equals(r4) != false) goto L147;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00e4, code lost:
    
        if (r31.equals("CreateDockWidgetPluginGui") == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x030b, code lost:
    
        r2 = com.exampletest.mobilestudiotest.model.InstanceFactory.INSTANCE.create("DockWidgetPluginGui");
        r5 = r11.optjstring("Widget");
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, "optjstring(...)");
        r2.setName(r5);
        r5 = r32.arg(3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0328, code lost:
    
        if (r5.istable() == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0334, code lost:
    
        if (r5.get("InitialEnabled").toboolean() == false) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0336, code lost:
    
        r6 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x033a, code lost:
    
        r2.set("Enabled", java.lang.Boolean.valueOf(r6), false);
        r2.set("Title", r2.getName(), false);
        r2.set("ZIndexBehavior", new com.exampletest.mobilestudiotest.model.EnumValue(1), false);
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x035a, code lost:
    
        if (r5.istable() == false) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x035c, code lost:
    
        r2.getAttributes().put("__w", java.lang.Integer.valueOf(r5.get("FloatingXSize").optint(com.google.android.material.card.MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION)));
        r2.getAttributes().put("__h", java.lang.Integer.valueOf(r5.get("FloatingYSize").optint(com.google.android.material.card.MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION)));
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0390, code lost:
    
        r10.addPluginWidget(r2, r29);
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:?, code lost:
    
        return r29.wrap(r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x0339, code lost:
    
        r6 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x00fd, code lost:
    
        if (r31.equals("SetReady") == false) goto L199;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x040f, code lost:
    
        r2 = org.luaj.vm2.LuaValue.NONE;
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, "NONE");
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:?, code lost:
    
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x0109, code lost:
    
        if (r31.equals("OpenWikiPage") != false) goto L29;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0116, code lost:
    
        if (r31.equals("CreateQWidgetPluginGui") != false) goto L32;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x004c. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0501  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0572  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x05ae  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0608  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0578  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final org.luaj.vm2.Varargs call(com.exampletest.mobilestudiotest.lua.LuaRuntime r29, com.exampletest.mobilestudiotest.model.Instance r30, java.lang.String r31, org.luaj.vm2.Varargs r32) {
        /*
            Method dump skipped, instructions count: 1760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.PluginApi.call(com.exampletest.mobilestudiotest.lua.LuaRuntime, com.exampletest.mobilestudiotest.model.Instance, java.lang.String, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }

    public final LuaTable pluginMouse(LuaRuntime rt) {
        Intrinsics.checkNotNullParameter(rt, "rt");
        LuaTable luaTable = new LuaTable();
        luaTable.set("Hit", LuaTypes.INSTANCE.wrap(CFrame.INSTANCE.getIDENTITY()));
        luaTable.set("Target", LuaValue.NIL);
        luaTable.set("X", 0);
        luaTable.set("Y", 0);
        luaTable.set("Icon", "");
        luaTable.set("TargetFilter", LuaValue.NIL);
        luaTable.set("Origin", LuaTypes.INSTANCE.wrap(CFrame.INSTANCE.getIDENTITY()));
        luaTable.set("UnitRay", LuaTypes.INSTANCE.wrap(new Ray(Vector3.INSTANCE.getZERO(), new Vector3(0.0f, 0.0f, -1.0f))));
        luaTable.set("ViewSizeX", 0);
        luaTable.set("ViewSizeY", 0);
        luaTable.set("ClassName", "PluginMouse");
        luaTable.set("Name", "Instance");
        LuaTable luaTable2 = new LuaTable();
        luaTable2.set("__type", "Instance");
        luaTable2.set(LuaValue.INDEX, LuaTypesKt.fn2(new PluginApi$$ExternalSyntheticLambda12(rt, luaTable)));
        luaTable.setmetatable(luaTable2);
        return luaTable;
    }
}
