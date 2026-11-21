package com.exampletest.mobilestudiotest.render;

import com.exampletest.mobilestudiotest.model.Instance;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SceneRenderer$drawClothing$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        String className = ((Instance) t).getClassName();
        int i = 1;
        Integer valueOf = Integer.valueOf(Intrinsics.areEqual(className, "Pants") ? 0 : Intrinsics.areEqual(className, "Shirt") ? 1 : 2);
        String className2 = ((Instance) t2).getClassName();
        if (Intrinsics.areEqual(className2, "Pants")) {
            i = 0;
        } else if (!Intrinsics.areEqual(className2, "Shirt")) {
            i = 2;
        }
        return ComparisonsKt.compareValues(valueOf, Integer.valueOf(i));
    }
}
