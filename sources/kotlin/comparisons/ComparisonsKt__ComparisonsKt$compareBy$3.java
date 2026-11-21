package kotlin.comparisons;

import java.util.Comparator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: Comparisons.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
/* loaded from: classes.dex */
public final class ComparisonsKt__ComparisonsKt$compareBy$3<T> implements Comparator {
    final /* synthetic */ Comparator<? super K> $comparator;
    final /* synthetic */ Function1<T, K> $selector;

    /* JADX WARN: Multi-variable type inference failed */
    public ComparisonsKt__ComparisonsKt$compareBy$3(Comparator<? super K> comparator, Function1<? super T, ? extends K> function1) {
        this.$comparator = comparator;
        this.$selector = function1;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Comparator<? super K> comparator = this.$comparator;
        Function1<T, K> function1 = this.$selector;
        return comparator.compare(function1.invoke(t), function1.invoke(t2));
    }
}
