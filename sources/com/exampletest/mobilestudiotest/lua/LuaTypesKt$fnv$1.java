package com.exampletest.mobilestudiotest.lua;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.luaj.vm2.Varargs;
import org.luaj.vm2.lib.VarArgFunction;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0096\u0002¨\u0006\u0005"}, d2 = {"com/exampletest/mobilestudiotest/lua/LuaTypesKt$fnv$1", "Lorg/luaj/vm2/lib/VarArgFunction;", "invoke", "Lorg/luaj/vm2/Varargs;", "args", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuaTypesKt$fnv$1 extends VarArgFunction {
    final /* synthetic */ Function1<Varargs, Varargs> $f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public LuaTypesKt$fnv$1(Function1<? super Varargs, ? extends Varargs> function1) {
        this.$f = function1;
    }

    @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public Varargs invoke(Varargs args) {
        Intrinsics.checkNotNullParameter(args, "args");
        return this.$f.invoke(args);
    }
}
