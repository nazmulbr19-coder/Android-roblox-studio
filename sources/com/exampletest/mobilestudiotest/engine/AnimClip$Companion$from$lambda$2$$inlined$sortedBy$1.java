package com.exampletest.mobilestudiotest.engine;

import com.exampletest.mobilestudiotest.engine.AnimClip;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class AnimClip$Companion$from$lambda$2$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Float.valueOf(((AnimClip.Key) t).getT()), Float.valueOf(((AnimClip.Key) t2).getT()));
    }
}
