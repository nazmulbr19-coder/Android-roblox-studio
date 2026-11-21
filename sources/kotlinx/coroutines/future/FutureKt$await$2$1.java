package kotlinx.coroutines.future;

import java.util.concurrent.CompletableFuture;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: Future.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
final class FutureKt$await$2$1 implements Function1<Throwable, Unit> {
    final /* synthetic */ ContinuationHandler<T> $consumer;
    final /* synthetic */ CompletableFuture<T> $future;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FutureKt$await$2$1(CompletableFuture<T> completableFuture, ContinuationHandler<T> continuationHandler) {
        this.$future = completableFuture;
        this.$consumer = continuationHandler;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
        invoke2(th);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Throwable th) {
        this.$future.cancel(false);
        this.$consumer.cont = null;
    }
}
