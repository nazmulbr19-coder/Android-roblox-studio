package com.exampletest.mobilestudiotest.render;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.Triple;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SceneRenderer$drawParts$$inlined$sortBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((TexBind) ((Triple) t).getThird()).getColor()), Integer.valueOf(((TexBind) ((Triple) t2).getThird()).getColor()));
    }
}
