package com.exampletest.mobilestudiotest.lua;

import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.lib.TwoArgFunction;

/* compiled from: LuaTypes.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0016¨\u0006\u0006"}, d2 = {"com/exampletest/mobilestudiotest/lua/LuaTypesKt$fn2$1", "Lorg/luaj/vm2/lib/TwoArgFunction;", NotificationCompat.CATEGORY_CALL, "Lorg/luaj/vm2/LuaValue;", "a", "b", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuaTypesKt$fn2$1 extends TwoArgFunction {
    final /* synthetic */ Function2<LuaValue, LuaValue, LuaValue> $f;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public LuaTypesKt$fn2$1(Function2<? super LuaValue, ? super LuaValue, ? extends LuaValue> function2) {
        this.$f = function2;
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue a, LuaValue b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        return this.$f.invoke(a, b);
    }
}
