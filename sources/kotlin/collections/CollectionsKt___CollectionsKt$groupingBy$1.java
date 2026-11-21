package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T, K] */
/* compiled from: _Collections.kt */
@Metadata(d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010(\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0016J\u0015\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"kotlin/collections/CollectionsKt___CollectionsKt$groupingBy$1", "Lkotlin/collections/Grouping;", "sourceIterator", "", "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 176)
/* loaded from: classes.dex */
public final class CollectionsKt___CollectionsKt$groupingBy$1<K, T> implements Grouping<T, K> {
    final /* synthetic */ Function1<T, K> $keySelector;
    final /* synthetic */ Iterable<T> $this_groupingBy;

    /* JADX WARN: Multi-variable type inference failed */
    public CollectionsKt___CollectionsKt$groupingBy$1(Iterable<? extends T> iterable, Function1<? super T, ? extends K> function1) {
        this.$this_groupingBy = iterable;
        this.$keySelector = function1;
    }

    @Override // kotlin.collections.Grouping
    public K keyOf(T element) {
        return this.$keySelector.invoke(element);
    }

    @Override // kotlin.collections.Grouping
    public Iterator<T> sourceIterator() {
        return this.$this_groupingBy.iterator();
    }
}
