package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;

/* compiled from: Reduce.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
final class FlowKt__ReduceKt$single$2<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<Object> $result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ReduceKt$single$2(Ref.ObjectRef<Object> objectRef) {
        this.$result = objectRef;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        if (!(this.$result.element == NullSurrogateKt.NULL)) {
            throw new IllegalArgumentException("Flow has more than one element".toString());
        }
        this.$result.element = t;
        return Unit.INSTANCE;
    }
}
