package kotlinx.coroutines;

import java.util.concurrent.locks.LockSupport;
import kotlin.Metadata;

/* compiled from: AbstractTimeSource.kt */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a\u0013\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0001H\u0080\b\u001a\t\u0010\u0005\u001a\u00020\u0006H\u0081\b\u001a\t\u0010\u0007\u001a\u00020\u0006H\u0081\b\u001a\u001e\u0010\b\u001a\u00060\nj\u0002`\t2\n\u0010\u000b\u001a\u00060\nj\u0002`\tH\u0081\b¢\u0006\u0002\u0010\f\u001a\t\u0010\r\u001a\u00020\u0003H\u0081\b\u001a\t\u0010\u000e\u001a\u00020\u0003H\u0081\b\u001a\t\u0010\u000f\u001a\u00020\u0003H\u0081\b\u001a\t\u0010\u0010\u001a\u00020\u0003H\u0081\b\u001a\u0019\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0006H\u0081\b\u001a\u0011\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0081\b\"\u0010\u0010\u0000\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"timeSource", "Lkotlinx/coroutines/AbstractTimeSource;", "mockTimeSource", "", "source", "currentTimeMillis", "", "nanoTime", "wrapTask", "Lkotlinx/coroutines/Runnable;", "Ljava/lang/Runnable;", "block", "(Ljava/lang/Runnable;)Ljava/lang/Runnable;", "trackTask", "unTrackTask", "registerTimeLoopThread", "unregisterTimeLoopThread", "parkNanos", "blocker", "", "nanos", "unpark", "thread", "Ljava/lang/Thread;", "kotlinx-coroutines-core"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class AbstractTimeSourceKt {
    private static AbstractTimeSource timeSource;

    public static final /* synthetic */ AbstractTimeSource access$getTimeSource$p() {
        return timeSource;
    }

    public static final /* synthetic */ void access$setTimeSource$p(AbstractTimeSource abstractTimeSource) {
        timeSource = abstractTimeSource;
    }

    private static final long currentTimeMillis() {
        AbstractTimeSource access$getTimeSource$p = access$getTimeSource$p();
        return access$getTimeSource$p != null ? access$getTimeSource$p.currentTimeMillis() : System.currentTimeMillis();
    }

    public static final void mockTimeSource(AbstractTimeSource abstractTimeSource) {
        access$setTimeSource$p(abstractTimeSource);
    }

    private static final long nanoTime() {
        AbstractTimeSource access$getTimeSource$p = access$getTimeSource$p();
        return access$getTimeSource$p != null ? access$getTimeSource$p.nanoTime() : System.nanoTime();
    }

    private static final void parkNanos(Object obj, long j) {
        AbstractTimeSource access$getTimeSource$p = access$getTimeSource$p();
        if (access$getTimeSource$p != null) {
            access$getTimeSource$p.parkNanos(obj, j);
        } else {
            LockSupport.parkNanos(obj, j);
        }
    }

    private static final void registerTimeLoopThread() {
        AbstractTimeSource access$getTimeSource$p = access$getTimeSource$p();
        if (access$getTimeSource$p != null) {
            access$getTimeSource$p.registerTimeLoopThread();
        }
    }

    private static final void trackTask() {
        AbstractTimeSource access$getTimeSource$p = access$getTimeSource$p();
        if (access$getTimeSource$p != null) {
            access$getTimeSource$p.trackTask();
        }
    }

    private static final void unTrackTask() {
        AbstractTimeSource access$getTimeSource$p = access$getTimeSource$p();
        if (access$getTimeSource$p != null) {
            access$getTimeSource$p.unTrackTask();
        }
    }

    private static final void unpark(Thread thread) {
        AbstractTimeSource access$getTimeSource$p = access$getTimeSource$p();
        if (access$getTimeSource$p != null) {
            access$getTimeSource$p.unpark(thread);
        } else {
            LockSupport.unpark(thread);
        }
    }

    private static final void unregisterTimeLoopThread() {
        AbstractTimeSource access$getTimeSource$p = access$getTimeSource$p();
        if (access$getTimeSource$p != null) {
            access$getTimeSource$p.unregisterTimeLoopThread();
        }
    }

    private static final Runnable wrapTask(Runnable runnable) {
        Runnable wrapTask;
        AbstractTimeSource access$getTimeSource$p = access$getTimeSource$p();
        return (access$getTimeSource$p == null || (wrapTask = access$getTimeSource$p.wrapTask(runnable)) == null) ? runnable : wrapTask;
    }
}
