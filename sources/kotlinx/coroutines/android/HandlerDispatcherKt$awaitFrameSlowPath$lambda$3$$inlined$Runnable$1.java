package kotlinx.coroutines.android;

import kotlin.Metadata;
import kotlinx.coroutines.CancellableContinuation;

/* compiled from: Runnable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class HandlerDispatcherKt$awaitFrameSlowPath$lambda$3$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ CancellableContinuation $cont$inlined;

    public HandlerDispatcherKt$awaitFrameSlowPath$lambda$3$$inlined$Runnable$1(CancellableContinuation cancellableContinuation) {
        this.$cont$inlined = cancellableContinuation;
    }

    @Override // java.lang.Runnable
    public final void run() {
        HandlerDispatcherKt.access$updateChoreographerAndPostFrameCallback(this.$cont$inlined);
    }
}
