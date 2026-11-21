package kotlinx.coroutines.flow;

import java.util.Collection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX WARN: Incorrect field signature: TC; */
/* compiled from: Collection.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
final class FlowKt__CollectionKt$toCollection$2<T> implements FlowCollector {
    final /* synthetic */ Collection $destination;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Incorrect types in method signature: (TC;)V */
    public FlowKt__CollectionKt$toCollection$2(Collection collection) {
        this.$destination = collection;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        this.$destination.add(t);
        return Unit.INSTANCE;
    }
}
