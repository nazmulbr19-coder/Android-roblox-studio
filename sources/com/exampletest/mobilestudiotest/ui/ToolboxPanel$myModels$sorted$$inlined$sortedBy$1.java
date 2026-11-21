package com.exampletest.mobilestudiotest.ui;

import java.io.File;
import java.util.Comparator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ToolboxPanel$myModels$sorted$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        String name = ((File) t).getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        String lowerCase = name.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        String name2 = ((File) t2).getName();
        Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
        String lowerCase2 = name2.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        return ComparisonsKt.compareValues(lowerCase, lowerCase2);
    }
}
