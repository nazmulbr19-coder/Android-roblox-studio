package com.exampletest.mobilestudiotest.lua;

import com.exampletest.mobilestudiotest.lua.LuaRuntime;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuaRuntime$step$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Double.valueOf(((LuaRuntime.Waiting) t).getAt()), Double.valueOf(((LuaRuntime.Waiting) t2).getAt()));
    }
}
