package com.exampletest.mobilestudiotest.ui;

import com.exampletest.mobilestudiotest.ui.DockLayout;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DockLayout$rebuild$fill$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((DockLayout.Panel) t).getOrder()), Integer.valueOf(((DockLayout.Panel) t2).getOrder()));
    }
}
