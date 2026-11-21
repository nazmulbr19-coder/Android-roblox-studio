package com.exampletest.mobilestudiotest.ui;

import com.exampletest.mobilestudiotest.net.RobloxApi;
import java.util.Comparator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ToolboxPanel$robloxInventory$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        String lowerCase = ((RobloxApi.InvItem) t).getName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = ((RobloxApi.InvItem) t2).getName().toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
    }
}
