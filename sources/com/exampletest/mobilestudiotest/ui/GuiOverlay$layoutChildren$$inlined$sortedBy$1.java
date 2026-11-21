package com.exampletest.mobilestudiotest.ui;

import com.exampletest.mobilestudiotest.ui.GuiOverlay;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GuiOverlay$layoutChildren$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Object obj = ((GuiOverlay.Node) t).getInst().get("ZIndex");
        Number number = obj instanceof Number ? (Number) obj : null;
        Integer valueOf = Integer.valueOf(number != null ? number.intValue() : 1);
        Object obj2 = ((GuiOverlay.Node) t2).getInst().get("ZIndex");
        Number number2 = obj2 instanceof Number ? (Number) obj2 : null;
        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(number2 != null ? number2.intValue() : 1));
    }
}
