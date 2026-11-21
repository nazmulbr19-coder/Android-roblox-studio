package com.exampletest.mobilestudiotest.lua;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.luaj.vm2.LuaString;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

/* compiled from: LuaSandbox.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¨\u0006\u0005"}, d2 = {"com/exampletest/mobilestudiotest/lua/LuaSandbox$lockDown$1", "Lorg/luaj/vm2/lib/VarArgFunction;", "invoke", "Lorg/luaj/vm2/Varargs;", "a", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuaSandbox$lockDown$1 extends VarArgFunction {
    final /* synthetic */ LuaValue $realLoad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LuaSandbox$lockDown$1(LuaValue luaValue) {
        this.$realLoad = luaValue;
    }

    @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public Varargs invoke(Varargs a) {
        Intrinsics.checkNotNullParameter(a, "a");
        LuaString arg1 = a.arg1();
        if (arg1.isfunction()) {
            StringBuilder sb = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i >= 100000) {
                    break;
                }
                LuaValue call = arg1.call();
                if (call.isnil()) {
                    break;
                }
                if (call.isstring()) {
                    String str = call.tojstring();
                    Intrinsics.checkNotNullExpressionValue(str, "tojstring(...)");
                    if (str.length() == 0) {
                        break;
                    }
                }
                sb.append(call.checkjstring());
                if (sb.length() > 50000000) {
                    Varargs varargsOf = LuaValue.varargsOf(LuaValue.NIL, LuaValue.valueOf("chunk too large"));
                    Intrinsics.checkNotNullExpressionValue(varargsOf, "varargsOf(...)");
                    return varargsOf;
                }
                i = i2;
            }
            arg1 = LuaValue.valueOf(sb.toString());
        }
        LuaSandbox luaSandbox = LuaSandbox.INSTANCE;
        Intrinsics.checkNotNull(arg1);
        if (luaSandbox.isBytecode(arg1)) {
            Varargs varargsOf2 = LuaValue.varargsOf(LuaValue.NIL, LuaValue.valueOf("bytecode is not allowed"));
            Intrinsics.checkNotNullExpressionValue(varargsOf2, "varargsOf(...)");
            return varargsOf2;
        }
        Varargs invoke = this.$realLoad.invoke(LuaValue.varargsOf(new LuaValue[]{arg1, a.arg(2), LuaValue.valueOf("t"), a.arg(4)}));
        Intrinsics.checkNotNullExpressionValue(invoke, "invoke(...)");
        return invoke;
    }
}
