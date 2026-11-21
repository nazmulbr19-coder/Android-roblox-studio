package kotlin.concurrent;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: Thread.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"kotlin/concurrent/ThreadsKt$thread$thread$1", "Ljava/lang/Thread;", "run", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ThreadsKt$thread$thread$1 extends Thread {
    final /* synthetic */ Function0<Unit> $block;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ThreadsKt$thread$thread$1(Function0<Unit> function0) {
        this.$block = function0;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        this.$block.invoke();
    }
}
