package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;

/* compiled from: Count.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
final class FlowKt__CountKt$count$2<T> implements FlowCollector {
    final /* synthetic */ Ref.IntRef $i;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__CountKt$count$2(Ref.IntRef intRef) {
        this.$i = intRef;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        this.$i.element++;
        int i = this.$i.element;
        return Unit.INSTANCE;
    }
}
