package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Ref;

/* compiled from: Reduce.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
final class FlowKt__ReduceKt$lastOrNull$2<T> implements FlowCollector {
    final /* synthetic */ Ref.ObjectRef<T> $result;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FlowKt__ReduceKt$lastOrNull$2(Ref.ObjectRef<T> objectRef) {
        this.$result = objectRef;
    }

    @Override // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(T t, Continuation<? super Unit> continuation) {
        this.$result.element = t;
        return Unit.INSTANCE;
    }
}
