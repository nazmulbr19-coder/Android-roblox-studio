package kotlinx.coroutines.future;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.ExceptionsKt;
import kotlinx.coroutines.Job;

/* compiled from: Future.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
final class FutureKt$setupCancellation$1 implements Function2 {
    final /* synthetic */ Job $this_setupCancellation;

    /* JADX INFO: Access modifiers changed from: package-private */
    public FutureKt$setupCancellation$1(Job job) {
        this.$this_setupCancellation = job;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(obj, (Throwable) obj2);
        return Unit.INSTANCE;
    }

    public final void invoke(Object obj, Throwable th) {
        Job job = this.$this_setupCancellation;
        if (th != null) {
            r0 = th instanceof CancellationException ? (CancellationException) th : null;
            if (r0 == null) {
                r0 = ExceptionsKt.CancellationException("CompletableFuture was completed exceptionally", th);
            }
        }
        job.cancel(r0);
    }
}
