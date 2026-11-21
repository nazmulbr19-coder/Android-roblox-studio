package com.exampletest.mobilestudiotest.lua;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.exampletest.mobilestudiotest.core.OutputLog;
import com.exampletest.mobilestudiotest.model.ClassDb;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.InstanceFactory;
import com.google.android.material.card.MaterialCardViewHelper;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaBoolean;
import org.luaj.vm2.LuaClosure;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaFunction;
import org.luaj.vm2.LuaInteger;
import org.luaj.vm2.LuaNumber;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaThread;
import org.luaj.vm2.LuaUserdata;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.UpValue;
import org.luaj.vm2.Upvaldesc;
import org.luaj.vm2.Varargs;

/* compiled from: RobloxGlobals.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f¨\u0006\r"}, d2 = {"Lcom/exampletest/mobilestudiotest/lua/RobloxGlobals;", "", "<init>", "()V", "resolveRequirePath", "Lcom/exampletest/mobilestudiotest/model/Instance;", "caller", "path", "", "install", "", "rt", "Lcom/exampletest/mobilestudiotest/lua/LuaRuntime;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class RobloxGlobals {
    public static final RobloxGlobals INSTANCE = new RobloxGlobals();

    private RobloxGlobals() {
    }

    private static final UpValue install$envSlot(LuaValue luaValue) {
        Upvaldesc[] upvaldescArr;
        LuaClosure luaClosure = luaValue instanceof LuaClosure ? (LuaClosure) luaValue : null;
        if (luaClosure == null || (upvaldescArr = luaClosure.p.upvalues) == null) {
            return null;
        }
        int length = upvaldescArr.length;
        for (int i = 0; i < length; i++) {
            LuaString luaString = upvaldescArr[i].name;
            if (Intrinsics.areEqual(luaString != null ? luaString.tojstring() : null, "_ENV")) {
                UpValue[] upValues = luaClosure.upValues;
                Intrinsics.checkNotNullExpressionValue(upValues, "upValues");
                return (UpValue) ArraysKt.getOrNull(upValues, i);
            }
        }
        return null;
    }

    private static final LuaValue install$funcAt(LuaRuntime luaRuntime, int i) {
        try {
            LuaValue luaValue = luaRuntime.getDebugGetinfo().call(LuaValue.valueOf(i), LuaValue.valueOf("f")).get("func");
            Intrinsics.checkNotNull(luaValue);
            return luaValue;
        } catch (Exception e) {
            LuaValue luaValue2 = LuaValue.NIL;
            Intrinsics.checkNotNull(luaValue2);
            return luaValue2;
        }
    }

    private static final String install$joinArgs(Globals globals, Varargs varargs) {
        StringBuilder sb = new StringBuilder();
        LuaValue luaValue = globals.get("tostring");
        int i = 1;
        int narg = varargs.narg();
        if (1 <= narg) {
            while (true) {
                if (i > 1) {
                    sb.append(' ');
                }
                sb.append(luaValue.call(varargs.arg(i)).tojstring());
                if (i == narg) {
                    break;
                }
                i++;
            }
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        return sb2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$10(LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaFunction checkfunction = a.arg(1).checkfunction();
        Intrinsics.checkNotNullExpressionValue(checkfunction, "checkfunction(...)");
        luaRuntime.delay(0.0d, luaRuntime.newThread(checkfunction));
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$11(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaNumber valueOf = LuaValue.valueOf(System.currentTimeMillis() / 1000.0d);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$12(LuaRuntime luaRuntime, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaNumber valueOf = LuaValue.valueOf(luaRuntime.getTime());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$13(long j, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaNumber valueOf = LuaValue.valueOf((System.nanoTime() - j) / 1.0E9d);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$14(LuaValue v) {
        Intrinsics.checkNotNullParameter(v, "v");
        LuaString valueOf = LuaValue.valueOf(LuaTypes.INSTANCE.typeOf(v));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x006f, code lost:
    
        if (((r1 == null || (r1 = r1.get(org.luaj.vm2.LuaValue.CALL)) == null || !r1.isfunction()) ? false : true) != false) goto L28;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final org.luaj.vm2.Varargs install$lambda$15(org.luaj.vm2.Globals r7, org.luaj.vm2.Varargs r8) {
        /*
            java.lang.String r0 = "a"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            org.luaj.vm2.LuaValue r0 = r8.arg1()
            boolean r1 = r0.isfunction()
            if (r1 == 0) goto L11
            goto L71
        L11:
            boolean r1 = r0.istable()
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L51
            org.luaj.vm2.LuaValue r1 = r0.getmetatable()
            if (r1 == 0) goto L26
            java.lang.String r4 = "__iter"
            org.luaj.vm2.LuaValue r4 = r1.get(r4)
            goto L27
        L26:
            r4 = 0
        L27:
            if (r4 == 0) goto L37
            boolean r5 = r4.isfunction()
            if (r5 == 0) goto L37
            r2 = r0
            org.luaj.vm2.Varargs r2 = (org.luaj.vm2.Varargs) r2
            org.luaj.vm2.Varargs r2 = r4.invoke(r2)
            goto L4d
        L37:
            r5 = 3
            org.luaj.vm2.LuaValue[] r5 = new org.luaj.vm2.LuaValue[r5]
            java.lang.String r6 = "next"
            org.luaj.vm2.LuaValue r6 = r7.get(r6)
            r5[r3] = r6
            r5[r2] = r0
            r2 = 2
            org.luaj.vm2.LuaValue r3 = org.luaj.vm2.LuaValue.NIL
            r5[r2] = r3
            org.luaj.vm2.Varargs r2 = org.luaj.vm2.LuaValue.varargsOf(r5)
        L4d:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            goto L72
        L51:
            boolean r1 = r0.isuserdata()
            if (r1 == 0) goto L73
            org.luaj.vm2.LuaValue r1 = r0.getmetatable()
            if (r1 == 0) goto L6e
            org.luaj.vm2.LuaString r4 = org.luaj.vm2.LuaValue.CALL
            org.luaj.vm2.LuaValue r4 = (org.luaj.vm2.LuaValue) r4
            org.luaj.vm2.LuaValue r1 = r1.get(r4)
            if (r1 == 0) goto L6e
            boolean r1 = r1.isfunction()
            if (r1 != r2) goto L6e
            goto L6f
        L6e:
            r2 = r3
        L6f:
            if (r2 == 0) goto L73
        L71:
            r2 = r8
        L72:
            return r2
        L73:
            org.luaj.vm2.LuaError r1 = new org.luaj.vm2.LuaError
            com.exampletest.mobilestudiotest.lua.LuaTypes r2 = com.exampletest.mobilestudiotest.lua.LuaTypes.INSTANCE
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            java.lang.String r2 = r2.typeOf(r0)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "attempt to iterate over a "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r2 = r3.append(r2)
            java.lang.String r3 = " value"
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.RobloxGlobals.install$lambda$15(org.luaj.vm2.Globals, org.luaj.vm2.Varargs):org.luaj.vm2.Varargs");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$16(LuaRuntime luaRuntime, LuaValue m) {
        LuaValue luaValue;
        Intrinsics.checkNotNullParameter(m, "m");
        Object obj = m.isuserdata() ? m.touserdata() : null;
        if (!(obj instanceof Instance)) {
            obj = null;
        }
        Instance instance = (Instance) obj;
        if (instance == null) {
            if (m.isnumber()) {
                throw new LuaError("require(assetId) is not supported offline");
            }
            if (!m.isstring()) {
                throw new LuaError("Attempted to call require with invalid argument(s).");
            }
            UpValue install$envSlot = install$envSlot(install$funcAt(luaRuntime, 1));
            LuaValue value = install$envSlot != null ? install$envSlot.getValue() : null;
            LuaTable luaTable = value instanceof LuaTable ? (LuaTable) value : null;
            if (luaTable != null && (luaValue = luaTable.get("script")) != null) {
                Object obj2 = luaValue.isuserdata() ? luaValue.touserdata() : null;
                Instance instance2 = (Instance) (obj2 instanceof Instance ? obj2 : null);
                if (instance2 != null) {
                    RobloxGlobals robloxGlobals = INSTANCE;
                    String str = m.tojstring();
                    Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
                    instance = robloxGlobals.resolveRequirePath(instance2, str);
                }
            }
            throw new LuaError("require(\"" + m.tojstring() + "\") needs to be called from a script");
        }
        return luaRuntime.require(instance);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$19(LuaRuntime luaRuntime, Globals globals, Varargs a) {
        LuaValue install$funcAt;
        LuaValue value;
        LuaValue value2;
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg1 = a.arg1();
        if (arg1.isfunction()) {
            install$funcAt = arg1;
        } else if (arg1.isnil()) {
            install$funcAt = install$funcAt(luaRuntime, 1);
        } else {
            if (!arg1.isnumber()) {
                throw new LuaError("bad argument #1 to 'getfenv' (number expected)");
            }
            if (arg1.toint() == 0) {
                LuaTable loadingModuleEnv = luaRuntime.loadingModuleEnv();
                if (loadingModuleEnv != null) {
                    return loadingModuleEnv;
                }
                LuaValue luaValue = null;
                for (int i = 1; i < 251; i++) {
                    LuaValue install$funcAt2 = install$funcAt(luaRuntime, i);
                    if (install$funcAt2.isnil()) {
                        break;
                    }
                    UpValue install$envSlot = install$envSlot(install$funcAt2);
                    if (install$envSlot != null && (value = install$envSlot.getValue()) != null) {
                        luaValue = value;
                    }
                }
                return luaValue != null ? luaValue : globals;
            }
            install$funcAt = install$funcAt(luaRuntime, arg1.toint());
        }
        Intrinsics.checkNotNull(install$funcAt);
        UpValue install$envSlot2 = install$envSlot(install$funcAt);
        return (install$envSlot2 == null || (value2 = install$envSlot2.getValue()) == null) ? globals : value2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$20(LuaRuntime luaRuntime, Varargs a) {
        LuaValue install$funcAt;
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg1 = a.arg1();
        LuaTable checktable = a.arg(2).checktable();
        if (arg1.isfunction()) {
            install$funcAt = arg1;
        } else {
            install$funcAt = install$funcAt(luaRuntime, arg1.isnil() ? 1 : arg1.checkint());
        }
        Intrinsics.checkNotNull(install$funcAt);
        UpValue install$envSlot = install$envSlot(install$funcAt);
        if (install$envSlot == null) {
            throw new LuaError("'setfenv' cannot change environment of given object");
        }
        install$envSlot.setValue(checktable);
        return install$funcAt;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$21(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg1 = a.arg1();
        return new LuaUserdata(new Object(), arg1.isuserdata() ? arg1.getmetatable() : arg1.toboolean() ? new LuaTable() : null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$22(Globals globals, LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaSandbox luaSandbox = LuaSandbox.INSTANCE;
        LuaValue arg1 = a.arg1();
        Intrinsics.checkNotNullExpressionValue(arg1, "arg1(...)");
        if (luaSandbox.isBytecode(arg1)) {
            Varargs varargsOf = LuaValue.varargsOf(LuaValue.NIL, LuaValue.valueOf("bytecode is not allowed"));
            Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
            return varargsOf;
        }
        String checkjstring = a.arg1().checkjstring();
        String optjstring = a.arg(2).optjstring("loadstring");
        try {
            UpValue install$envSlot = install$envSlot(install$funcAt(luaRuntime, 1));
            LuaValue value = install$envSlot != null ? install$envSlot.getValue() : null;
            Globals globals2 = value instanceof LuaTable ? (LuaTable) value : null;
            if (globals2 == null) {
                globals2 = globals;
            }
            Globals globals3 = luaRuntime.getGlobals();
            LuauTranspiler luauTranspiler = LuauTranspiler.INSTANCE;
            Intrinsics.checkNotNull(checkjstring);
            LuaValue load = globals3.load(LuauTranspiler.transpile$default(luauTranspiler, checkjstring, false, 2, null), "=" + optjstring, globals2);
            Intrinsics.checkNotNull(load);
            return load;
        } catch (LuaError e) {
            LuaValue luaValue = LuaValue.NIL;
            String message = e.getMessage();
            if (message == null) {
                message = "syntax error";
            }
            Varargs varargsOf2 = LuaValue.varargsOf(luaValue, LuaValue.valueOf(luaRuntime.cleanError(message)));
            Intrinsics.checkNotNull(varargsOf2);
            return varargsOf2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$23(LuaTable luaTable, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$26(LuaRuntime luaRuntime, Instance instance, Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return luaRuntime.wrap(instance);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$27(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaString valueOf = LuaValue.valueOf("0.600.0");
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$28(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        OutputLog.INSTANCE.print("Current identity is 2");
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$29(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaNumber valueOf = LuaValue.valueOf((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1024.0d);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$31(LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        Varargs varargsOf = LuaValue.varargsOf(luaRuntime.yieldFor(a.arg(1).optdouble(0.0d)).arg1(), LuaValue.NONE);
        Intrinsics.checkNotNullExpressionValue(varargsOf, "let(...)");
        return varargsOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$32(LuaRuntime luaRuntime, Varargs a) {
        LuaThread newThread;
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        if (arg.isthread()) {
            Intrinsics.checkNotNull(arg, "null cannot be cast to non-null type org.luaj.vm2.LuaThread");
            newThread = (LuaThread) arg;
        } else {
            LuaFunction checkfunction = arg.checkfunction();
            Intrinsics.checkNotNullExpressionValue(checkfunction, "checkfunction(...)");
            newThread = luaRuntime.newThread(checkfunction);
        }
        Varargs subargs = a.subargs(2);
        Intrinsics.checkNotNullExpressionValue(subargs, "subargs(...)");
        luaRuntime.resume(newThread, subargs);
        return newThread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$33(LuaRuntime luaRuntime, Varargs a) {
        LuaThread newThread;
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        if (arg.isthread()) {
            Intrinsics.checkNotNull(arg, "null cannot be cast to non-null type org.luaj.vm2.LuaThread");
            newThread = (LuaThread) arg;
        } else {
            LuaFunction checkfunction = arg.checkfunction();
            Intrinsics.checkNotNullExpressionValue(checkfunction, "checkfunction(...)");
            newThread = luaRuntime.newThread(checkfunction);
        }
        Varargs subargs = a.subargs(2);
        Intrinsics.checkNotNullExpressionValue(subargs, "subargs(...)");
        luaRuntime.defer(newThread, subargs);
        return newThread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$35(LuaRuntime luaRuntime, Varargs a) {
        LuaThread newThread;
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(2);
        if (arg.isthread()) {
            Intrinsics.checkNotNull(arg, "null cannot be cast to non-null type org.luaj.vm2.LuaThread");
            newThread = (LuaThread) arg;
        } else {
            LuaFunction checkfunction = arg.checkfunction();
            Intrinsics.checkNotNullExpressionValue(checkfunction, "checkfunction(...)");
            newThread = luaRuntime.newThread(checkfunction);
        }
        luaRuntime.after(a.arg(1).optdouble(0.0d), new RobloxGlobals$$ExternalSyntheticLambda0(luaRuntime, newThread, a.subargs(3)));
        return newThread;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit install$lambda$35$lambda$34(LuaRuntime luaRuntime, LuaThread luaThread, Varargs varargs) {
        Intrinsics.checkNotNull(varargs);
        luaRuntime.resume(luaThread, varargs);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$37(LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue arg = a.arg(1);
        LuaThread luaThread = arg instanceof LuaThread ? (LuaThread) arg : null;
        if (luaThread != null) {
            luaRuntime.cancel(luaThread);
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$38(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$39(Varargs it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$41(LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        String checkjstring = a.arg(1).checkjstring();
        ClassDb classDb = ClassDb.INSTANCE;
        Intrinsics.checkNotNull(checkjstring);
        if (classDb.isServiceName(checkjstring) || SetsKt.setOf((Object[]) new String[]{"DataModel", "Player", "PlayerGui"}).contains(checkjstring)) {
            throw new LuaError("Unable to create an Instance of type \"" + checkjstring + "\"");
        }
        Instance create = InstanceFactory.INSTANCE.create(checkjstring);
        LuaValue arg = a.arg(2);
        Intrinsics.checkNotNullExpressionValue(arg, "arg(...)");
        Object obj = arg.isuserdata() ? arg.touserdata() : null;
        if (!(obj instanceof Instance)) {
            obj = null;
        }
        Instance instance = (Instance) obj;
        if (instance != null) {
            Instance.setParent$default(create, instance, 0, 2, null);
        }
        return luaRuntime.wrap(create);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$44(LuaRuntime luaRuntime, LuaValue v) {
        Intrinsics.checkNotNullParameter(v, "v");
        Object obj = v.isuserdata() ? v.touserdata() : null;
        Instance instance = (Instance) (obj instanceof Instance ? obj : null);
        if (instance == null) {
            throw new LuaError("Instance expected, got " + LuaTypes.INSTANCE.typeOf(v));
        }
        Instance cloneTree = instance.cloneTree();
        Iterator it = CollectionsKt.toList(cloneTree.getChildren()).iterator();
        while (it.hasNext()) {
            ((Instance) it.next()).destroy();
        }
        return luaRuntime.wrap(cloneTree);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$48$lambda$47(Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        LuaTable luaTable = new LuaTable();
        luaTable.set("FilterDescendantsInstances", new LuaTable());
        luaTable.set("FilterType", LuaTypes.INSTANCE.wrap(new EnumItemV("RaycastFilterType", "Exclude", 0)));
        luaTable.set("IgnoreWater", LuaValue.FALSE);
        luaTable.set("CollisionGroup", "Default");
        luaTable.set("RespectCanCollide", LuaValue.FALSE);
        luaTable.set("AddToFilter", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda1()));
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$48$lambda$47$lambda$46$lambda$45(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaValue luaValue = a.arg(1).get("FilterDescendantsInstances");
        LuaValue arg = a.arg(2);
        if (arg.istable()) {
            int i = 1;
            int length = arg.length();
            if (1 <= length) {
                while (true) {
                    luaValue.set(luaValue.length() + 1, arg.get(i));
                    if (i == length) {
                        break;
                    }
                    i++;
                }
            }
        } else {
            luaValue.set(luaValue.length() + 1, arg);
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$5$lambda$2(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaInteger valueOf = LuaValue.valueOf(Integer.numberOfLeadingZeros((int) a.arg(1).checklong()));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$5$lambda$3(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaInteger valueOf = LuaValue.valueOf(Integer.numberOfTrailingZeros((int) a.arg(1).checklong()));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$5$lambda$4(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaNumber valueOf = LuaValue.valueOf(Integer.reverseBytes((int) a.arg(1).checklong()) & 4294967295L);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$51$lambda$50(Varargs varargs) {
        Intrinsics.checkNotNullParameter(varargs, "<unused var>");
        LuaTable luaTable = new LuaTable();
        luaTable.set("FilterDescendantsInstances", new LuaTable());
        luaTable.set("FilterType", LuaTypes.INSTANCE.wrap(new EnumItemV("RaycastFilterType", "Exclude", 0)));
        luaTable.set("MaxParts", 0);
        luaTable.set("CollisionGroup", "Default");
        luaTable.set("RespectCanCollide", LuaValue.FALSE);
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$54$lambda$53(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTable luaTable = new LuaTable();
        luaTable.set("InitialDockState", a.arg(1));
        luaTable.set("InitialEnabled", LuaValue.valueOf(a.arg(2).optboolean(false)));
        luaTable.set("FloatingXSize", LuaValue.valueOf(a.arg(4).optint(MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION)));
        luaTable.set("FloatingYSize", LuaValue.valueOf(a.arg(5).optint(MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION)));
        luaTable.set("MinWidth", LuaValue.valueOf(a.arg(6).optint(150)));
        luaTable.set("MinHeight", LuaValue.valueOf(a.arg(7).optint(150)));
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$55(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        double checkdouble = a.arg(1).checkdouble();
        double checkdouble2 = a.arg(2).checkdouble();
        double checkdouble3 = a.arg(3).checkdouble();
        if (checkdouble2 > checkdouble3) {
            throw new LuaError("max must be greater than or equal to min");
        }
        LuaNumber valueOf = LuaValue.valueOf(RangesKt.coerceIn(checkdouble, checkdouble2, checkdouble3));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$56(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        double checkdouble = a.checkdouble();
        LuaInteger valueOf = LuaValue.valueOf(checkdouble > 0.0d ? 1 : checkdouble < 0.0d ? -1 : 0);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$57(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        double checkdouble = a.checkdouble();
        LuaNumber valueOf = LuaValue.valueOf(checkdouble >= 0.0d ? Math.floor(0.5d + checkdouble) : -Math.floor((-checkdouble) + 0.5d));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$58(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaNumber valueOf = LuaValue.valueOf(Noise.INSTANCE.perlin(a.arg(1).optdouble(0.0d), a.arg(2).optdouble(0.0d), a.arg(3).optdouble(0.0d)));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$59(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        double checkdouble = a.arg(1).checkdouble();
        LuaNumber valueOf = LuaValue.valueOf(((a.arg(2).checkdouble() - checkdouble) * a.arg(3).checkdouble()) + checkdouble);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$6(Globals globals, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        OutputLog.INSTANCE.print(install$joinArgs(globals, a));
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$60(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        double checkdouble = a.arg(1).checkdouble();
        double checkdouble2 = a.arg(2).checkdouble();
        double checkdouble3 = a.arg(3).checkdouble();
        double checkdouble4 = a.arg(4).checkdouble();
        LuaNumber valueOf = LuaValue.valueOf((((checkdouble - checkdouble2) * (a.arg(5).checkdouble() - checkdouble4)) / (checkdouble3 - checkdouble2)) + checkdouble4);
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$63(Varargs a) {
        ArrayList split$default;
        Intrinsics.checkNotNullParameter(a, "a");
        String checkjstring = a.arg(1).checkjstring();
        String optjstring = a.arg(2).optjstring(",");
        LuaTable luaTable = new LuaTable();
        Intrinsics.checkNotNull(optjstring);
        boolean z = optjstring.length() == 0;
        Intrinsics.checkNotNull(checkjstring);
        if (z) {
            String str = checkjstring;
            ArrayList arrayList = new ArrayList(str.length());
            for (int i = 0; i < str.length(); i++) {
                arrayList.add(String.valueOf(str.charAt(i)));
            }
            split$default = arrayList;
        } else {
            split$default = StringsKt.split$default((CharSequence) checkjstring, new String[]{optjstring}, false, 0, 6, (Object) null);
        }
        Iterator it = split$default.iterator();
        while (it.hasNext()) {
            luaTable.insert(0, LuaValue.valueOf((String) it.next()));
        }
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$64(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTable checktable = a.arg(1).checktable();
        LuaValue arg = a.arg(2);
        int optint = a.arg(3).optint(1);
        LuaInteger NIL = LuaValue.NIL;
        Intrinsics.checkNotNullExpressionValue(NIL, "NIL");
        int i = optint;
        int length = checktable.length();
        if (i <= length) {
            while (true) {
                if (!checktable.get(i).eq_b(arg)) {
                    if (i == length) {
                        break;
                    }
                    i++;
                } else {
                    LuaInteger valueOf = LuaValue.valueOf(i);
                    Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
                    NIL = valueOf;
                    break;
                }
            }
        }
        return NIL;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$66(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTable checktable = a.checktable();
        ArrayList arrayList = new ArrayList();
        LuaValue luaValue = LuaValue.NIL;
        while (true) {
            luaValue = checktable.next(luaValue).arg1();
            if (luaValue.isnil()) {
                break;
            }
            arrayList.add(luaValue);
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            checktable.set((LuaValue) it.next(), LuaValue.NIL);
        }
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$67(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTable luaTable = new LuaTable();
        int checkint = a.arg(1).checkint();
        LuaValue arg = a.arg(2);
        if (!arg.isnil()) {
            int i = 1;
            if (1 <= checkint) {
                while (true) {
                    luaTable.set(i, arg);
                    if (i == checkint) {
                        break;
                    }
                    i++;
                }
            }
        }
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$68(LuaValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$69(LuaValue it) {
        Intrinsics.checkNotNullParameter(it, "it");
        LuaBoolean FALSE = LuaValue.FALSE;
        Intrinsics.checkNotNullExpressionValue(FALSE, "FALSE");
        return FALSE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$7(Globals globals, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        OutputLog.INSTANCE.warn(install$joinArgs(globals, a));
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$70(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTable checktable = a.checktable();
        LuaTable luaTable = new LuaTable();
        LuaValue luaValue = LuaValue.NIL;
        while (true) {
            Varargs next = checktable.next(luaValue);
            luaValue = next.arg1();
            if (luaValue.isnil()) {
                return luaTable;
            }
            luaTable.set(luaValue, next.arg(2));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$71(Varargs a) {
        LuaTable luaTable;
        Intrinsics.checkNotNullParameter(a, "a");
        LuaTable checktable = a.arg(1).checktable();
        int checkint = a.arg(2).checkint();
        int checkint2 = a.arg(3).checkint();
        int checkint3 = a.arg(4).checkint();
        if (a.arg(5).istable()) {
            LuaValue arg = a.arg(5);
            Intrinsics.checkNotNull(arg, "null cannot be cast to non-null type org.luaj.vm2.LuaTable");
            luaTable = (LuaTable) arg;
        } else {
            luaTable = checktable;
        }
        if (checkint3 > checkint) {
            int i = checkint2;
            if (checkint <= i) {
                while (true) {
                    luaTable.set((checkint3 + i) - checkint, checktable.get(i));
                    if (i == checkint) {
                        break;
                    }
                    i--;
                }
            }
        } else {
            int i2 = checkint;
            if (i2 <= checkint2) {
                while (true) {
                    luaTable.set((checkint3 + i2) - checkint, checktable.get(i2));
                    if (i2 == checkint2) {
                        break;
                    }
                    i2++;
                }
            }
        }
        Intrinsics.checkNotNull(luaTable);
        return luaTable;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$72(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaInteger valueOf = LuaValue.valueOf(a.length());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$73(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int narg = a.narg();
        if (1 <= narg) {
            while (true) {
                sb.appendCodePoint(a.arg(i).checkint());
                if (i == narg) {
                    break;
                }
                i++;
            }
        }
        LuaString valueOf = LuaValue.valueOf(sb.toString());
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final LuaValue install$lambda$74(LuaValue a) {
        Intrinsics.checkNotNullParameter(a, "a");
        byte[] m_bytes = a.checkstring().m_bytes;
        Intrinsics.checkNotNullExpressionValue(m_bytes, "m_bytes");
        String str = new String(m_bytes, a.checkstring().m_offset, a.checkstring().m_length, Charsets.UTF_8);
        LuaInteger valueOf = LuaValue.valueOf(str.codePointCount(0, str.length()));
        Intrinsics.checkNotNullExpressionValue(valueOf, "valueOf(...)");
        return valueOf;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$8(LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        return luaRuntime.yieldFor(RangesKt.coerceAtLeast(a.arg(1).optdouble(0.03d), 0.029d));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Varargs install$lambda$9(LuaRuntime luaRuntime, Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaFunction checkfunction = a.arg(2).checkfunction();
        Intrinsics.checkNotNullExpressionValue(checkfunction, "checkfunction(...)");
        luaRuntime.delay(a.arg(1).optdouble(0.0d), luaRuntime.newThread(checkfunction));
        LuaValue NONE = LuaValue.NONE;
        Intrinsics.checkNotNullExpressionValue(NONE, "NONE");
        return NONE;
    }

    public final void install(LuaRuntime rt) {
        Intrinsics.checkNotNullParameter(rt, "rt");
        Globals globals = rt.getGlobals();
        long nanoTime = System.nanoTime();
        LuaValue luaValue = globals.get("bit32");
        if (!luaValue.istable()) {
            luaValue = null;
        }
        if (luaValue != null) {
            luaValue.set("countlz", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda2()));
            luaValue.set("countrz", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda13()));
            luaValue.set("byteswap", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda24()));
        }
        globals.set("print", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda35(globals)));
        globals.set("warn", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda46(globals)));
        globals.set("wait", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda49(rt)));
        globals.set("Wait", globals.get("wait"));
        globals.set("delay", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda50(rt)));
        globals.set("spawn", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda51(rt)));
        globals.set("tick", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda52()));
        globals.set("time", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda53(rt)));
        globals.set("elapsedTime", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda3(nanoTime)));
        globals.set("typeof", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda4()));
        globals.set("game", rt.wrap(rt.getDm()));
        globals.set("Game", rt.wrap(rt.getDm()));
        globals.set("workspace", rt.wrap(rt.getDm().getWorkspace()));
        globals.set("Workspace", rt.wrap(rt.getDm().getWorkspace()));
        globals.set("shared", rt.getSharedTable());
        globals.set("__iter", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda5(globals)));
        globals.set("unpack", globals.get("table").get("unpack"));
        globals.set("ypcall", globals.get("pcall"));
        globals.set("require", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda6(rt)));
        globals.set("getfenv", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda7(rt, globals)));
        globals.set("setfenv", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda8(rt)));
        globals.set("newproxy", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda9()));
        globals.set("loadstring", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda10(globals, rt)));
        globals.set("settings", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda11(StudioSettings.INSTANCE.create(rt))));
        Instance create = InstanceFactory.INSTANCE.create("UserSettings");
        Instance create2 = InstanceFactory.INSTANCE.create("UserGameSettings");
        create2.setName("GameSettings");
        create2.set("ControlMode", new EnumValue(0), false);
        create2.set("ComputerMovementMode", new EnumValue(0), false);
        create2.set("TouchMovementMode", new EnumValue(0), false);
        create2.set("MasterVolume", Float.valueOf(1.0f), false);
        create2.set("SavedQualityLevel", new EnumValue(0), false);
        create2.set("RotationType", new EnumValue(0), false);
        create2.attachRaw(create);
        globals.set("UserSettings", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda12(rt, create)));
        globals.set("version", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda14()));
        globals.set("printidentity", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda15()));
        globals.set("gcinfo", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda16()));
        LuaTable luaTable = new LuaTable();
        luaTable.set("wait", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda17(rt)));
        luaTable.set("spawn", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda18(rt)));
        luaTable.set("defer", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda19(rt)));
        luaTable.set("delay", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda20(rt)));
        luaTable.set("cancel", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda21(rt)));
        luaTable.set("synchronize", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda22()));
        luaTable.set("desynchronize", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda23()));
        globals.set("task", luaTable);
        LuaTable luaTable2 = new LuaTable();
        luaTable2.set("new", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda25(rt)));
        luaTable2.set("fromExisting", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda26(rt)));
        globals.set("Instance", luaTable2);
        LuaTable luaTable3 = new LuaTable();
        luaTable3.set("new", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda27()));
        Unit unit = Unit.INSTANCE;
        globals.set("RaycastParams", luaTable3);
        LuaTable luaTable4 = new LuaTable();
        luaTable4.set("new", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda28()));
        Unit unit2 = Unit.INSTANCE;
        globals.set("OverlapParams", luaTable4);
        LuaTable luaTable5 = new LuaTable();
        luaTable5.set("new", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda29()));
        Unit unit3 = Unit.INSTANCE;
        globals.set("DockWidgetPluginGuiInfo", luaTable5);
        LuaValue luaValue2 = globals.get(AccessibilityNodeInfoCompat.MathInfoCompat.MATH_TAG_MATH);
        luaValue2.set("clamp", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda30()));
        luaValue2.set("sign", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda31()));
        luaValue2.set("round", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda32()));
        luaValue2.set("noise", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda33()));
        luaValue2.set("lerp", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda34()));
        luaValue2.set("map", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda36()));
        globals.get(TypedValues.Custom.S_STRING).set("split", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda37()));
        LuaValue luaValue3 = globals.get("table");
        luaValue3.set("find", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda38()));
        luaValue3.set("clear", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda39()));
        luaValue3.set("create", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda40()));
        luaValue3.set("freeze", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda41()));
        luaValue3.set("isfrozen", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda42()));
        luaValue3.set("clone", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda43()));
        luaValue3.set("move", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda44()));
        luaValue3.set("getn", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda45()));
        LuaTable luaTable6 = new LuaTable();
        luaTable6.set("char", LuaTypesKt.fnv(new RobloxGlobals$$ExternalSyntheticLambda47()));
        luaTable6.set("len", LuaTypesKt.fn1(new RobloxGlobals$$ExternalSyntheticLambda48()));
        luaTable6.set("charpattern", "[\u0000-\u007fÂ-ý][\u0080-¿]*");
        globals.set("utf8", luaTable6);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:18:0x006f. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0138 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0139  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.exampletest.mobilestudiotest.model.Instance resolveRequirePath(com.exampletest.mobilestudiotest.model.Instance r14, java.lang.String r15) {
        /*
            Method dump skipped, instructions count: 414
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.lua.RobloxGlobals.resolveRequirePath(com.exampletest.mobilestudiotest.model.Instance, java.lang.String):com.exampletest.mobilestudiotest.model.Instance");
    }
}
