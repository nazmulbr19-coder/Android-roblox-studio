package com.exampletest.mobilestudiotest.ui;

import java.util.Comparator;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PropertiesPanel$rebuild$lambda$9$$inlined$sortedBy$1<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        String lowerCase = ((String) ((Map.Entry) t).getKey()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String lowerCase2 = ((String) ((Map.Entry) t2).getKey()).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
    }
}
