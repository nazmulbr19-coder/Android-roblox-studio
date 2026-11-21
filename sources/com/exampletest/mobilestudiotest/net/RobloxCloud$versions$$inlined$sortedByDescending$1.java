package com.exampletest.mobilestudiotest.net;

import com.exampletest.mobilestudiotest.net.RobloxCloud;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RobloxCloud$versions$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((RobloxCloud.Version) t2).getNumber()), Integer.valueOf(((RobloxCloud.Version) t).getNumber()));
    }
}
