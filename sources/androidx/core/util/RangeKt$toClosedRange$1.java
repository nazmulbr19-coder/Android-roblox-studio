package androidx.core.util;

import android.util.Range;
import kotlin.Metadata;
import kotlin.ranges.ClosedRange;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Range.kt */
@Metadata(d1 = {"\u0000\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001R\u001c\u0010\u0002\u001a\n \u0003*\u0004\u0018\u00018\u00008\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\u0006\u001a\n \u0003*\u0004\u0018\u00018\u00008\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, d2 = {"androidx/core/util/RangeKt$toClosedRange$1", "Lkotlin/ranges/ClosedRange;", "endInclusive", "kotlin.jvm.PlatformType", "getEndInclusive", "()Ljava/lang/Comparable;", "start", "getStart", "core"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RangeKt$toClosedRange$1<T> implements ClosedRange<T> {
    final /* synthetic */ Range<T> $this_toClosedRange;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RangeKt$toClosedRange$1(Range<T> range) {
        this.$this_toClosedRange = range;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Z */
    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ boolean contains(Comparable comparable) {
        return ClosedRange.DefaultImpls.contains(this, comparable);
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // kotlin.ranges.ClosedRange
    public Comparable getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    /* JADX WARN: Incorrect return type in method signature: ()TT; */
    @Override // kotlin.ranges.ClosedRange
    public Comparable getStart() {
        return this.$this_toClosedRange.getLower();
    }

    @Override // kotlin.ranges.ClosedRange
    public /* bridge */ boolean isEmpty() {
        return ClosedRange.DefaultImpls.isEmpty(this);
    }
}
