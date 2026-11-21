package com.exampletest.mobilestudiotest.lua;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.luaj.vm2.LuaError;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.OneArgFunction;
import org.luaj.vm2.lib.TwoArgFunction;
import org.luaj.vm2.lib.VarArgFunction;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u001a \u0010\u0005\u001a\u00020\u00062\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007\u001a\u001a\u0010\b\u001a\u00020\t2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\u0003\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\u0004\u001a\u0012\u0010\r\u001a\u00020\f*\u00020\u00042\u0006\u0010\u000e\u001a\u00020\f\u001a\"\u0010\u000f\u001a\u0002H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0012H\u0086\b¢\u0006\u0002\u0010\u0013\u001a\u001c\u0010\u0014\u001a\u0004\u0018\u0001H\u0010\"\u0006\b\u0000\u0010\u0010\u0018\u0001*\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0015¨\u0006\u0016"}, d2 = {"fn1", "Lorg/luaj/vm2/lib/OneArgFunction;", "f", "Lkotlin/Function1;", "Lorg/luaj/vm2/LuaValue;", "fn2", "Lorg/luaj/vm2/lib/TwoArgFunction;", "Lkotlin/Function2;", "fnv", "Lorg/luaj/vm2/lib/VarArgFunction;", "Lorg/luaj/vm2/Varargs;", "num", "", "optNum", "d", "ud", "T", "what", "", "(Lorg/luaj/vm2/LuaValue;Ljava/lang/String;)Ljava/lang/Object;", "udOrNull", "(Lorg/luaj/vm2/LuaValue;)Ljava/lang/Object;", "app"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuaTypesKt {
    public static final OneArgFunction fn1(Function1<? super LuaValue, ? extends LuaValue> f) {
        Intrinsics.checkNotNullParameter(f, "f");
        return new LuaTypesKt$fn1$1(f);
    }

    public static final TwoArgFunction fn2(Function2<? super LuaValue, ? super LuaValue, ? extends LuaValue> f) {
        Intrinsics.checkNotNullParameter(f, "f");
        return new LuaTypesKt$fn2$1(f);
    }

    public static final VarArgFunction fnv(Function1<? super Varargs, ? extends Varargs> f) {
        Intrinsics.checkNotNullParameter(f, "f");
        return new LuaTypesKt$fnv$1(f);
    }

    public static final float num(LuaValue luaValue) {
        Intrinsics.checkNotNullParameter(luaValue, "<this>");
        return (float) luaValue.checkdouble();
    }

    public static final float optNum(LuaValue luaValue, float f) {
        Intrinsics.checkNotNullParameter(luaValue, "<this>");
        return luaValue.isnil() ? f : (float) luaValue.checkdouble();
    }

    public static final /* synthetic */ <T> T ud(LuaValue luaValue, String what) {
        Intrinsics.checkNotNullParameter(luaValue, "<this>");
        Intrinsics.checkNotNullParameter(what, "what");
        T t = luaValue.isuserdata() ? (T) luaValue.touserdata() : null;
        Intrinsics.reifiedOperationMarker(2, "T");
        T t2 = t;
        if (t != null) {
            return t;
        }
        throw new LuaError(what + " expected, got " + LuaTypes.INSTANCE.typeOf(luaValue));
    }

    public static final /* synthetic */ <T> T udOrNull(LuaValue luaValue) {
        Intrinsics.checkNotNullParameter(luaValue, "<this>");
        T t = luaValue.isuserdata() ? (T) luaValue.touserdata() : null;
        Intrinsics.reifiedOperationMarker(2, "T");
        T t2 = t;
        return t;
    }
}
