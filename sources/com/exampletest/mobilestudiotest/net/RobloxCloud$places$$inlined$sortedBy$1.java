package com.exampletest.mobilestudiotest.net;

import com.exampletest.mobilestudiotest.net.RobloxCloud;
import java.util.Comparator;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RobloxCloud$places$$inlined$sortedBy$1<T> implements Comparator {
    final /* synthetic */ RobloxCloud.Game $game$inlined;

    public RobloxCloud$places$$inlined$sortedBy$1(RobloxCloud.Game game) {
        this.$game$inlined = game;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return ComparisonsKt.compareValues(Integer.valueOf(((RobloxCloud.Place) t).getId() == this.$game$inlined.getRootPlaceId() ? 0 : 1), Integer.valueOf(((RobloxCloud.Place) t2).getId() != this.$game$inlined.getRootPlaceId() ? 1 : 0));
    }
}
