package com.exampletest.mobilestudiotest.ui;

import com.exampletest.mobilestudiotest.model.Instance;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ExplorerPanel$visibleChildren$$inlined$sortedBy$1<T> implements Comparator {
    final /* synthetic */ List $order$inlined;

    public ExplorerPanel$visibleChildren$$inlined$sortedBy$1(List list) {
        this.$order$inlined = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int indexOf = this.$order$inlined.indexOf(((Instance) t).getClassName());
        if (indexOf < 0) {
            indexOf = 999;
        }
        Integer valueOf = Integer.valueOf(indexOf);
        int indexOf2 = this.$order$inlined.indexOf(((Instance) t2).getClassName());
        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(indexOf2 >= 0 ? indexOf2 : 999));
    }
}
