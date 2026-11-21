package com.exampletest.mobilestudiotest.render;

import com.exampletest.mobilestudiotest.render.SceneRenderer;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class SceneRenderer$drawParts$$inlined$sortByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Float.valueOf(((SceneRenderer.Draw) t2).getDist()), Float.valueOf(((SceneRenderer.Draw) t).getDist()));
    }
}
