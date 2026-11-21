package kotlinx.coroutines.channels;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: Produce.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
final class ProduceKt$awaitClose$4$1 implements Function1<Throwable, Unit> {
    final /* synthetic */ CancellableContinuation<Unit> $cont;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public ProduceKt$awaitClose$4$1(CancellableContinuation<? super Unit> cancellableContinuation) {
        this.$cont = cancellableContinuation;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        CancellableContinuation<Unit> cancellableContinuation = this.$cont;
        Result.Companion companion = Result.INSTANCE;
        cancellableContinuation.resumeWith(Result.m457constructorimpl(Unit.INSTANCE));
    }
}
