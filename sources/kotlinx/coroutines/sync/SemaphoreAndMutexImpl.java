package kotlinx.coroutines.sync;

import androidx.concurrent.futures.AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0;
import com.github.luben.zstd.BuildConfig;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.concurrent.internal.AtomicIntrinsicsKt$$ExternalSyntheticBackportWithForwarding0;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CancellableContinuationKt;
import kotlinx.coroutines.DebugKt;
import kotlinx.coroutines.Waiter;
import kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import kotlinx.coroutines.internal.Segment;
import kotlinx.coroutines.internal.SegmentOrClosed;
import kotlinx.coroutines.selects.SelectInstance;

/* compiled from: Semaphore.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u001bJ\u000e\u0010\u001c\u001a\u00020\u0016H\u0082@¢\u0006\u0002\u0010\u001bJ\u0016\u0010\u001a\u001a\u00020\u00162\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00160\u001eH\u0005Jb\u0010\u001a\u001a\u00020\u0016\"\u0004\b\u0000\u0010\u001f2\u0006\u0010\u001d\u001a\u0002H\u001f2!\u0010 \u001a\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00190!2!\u0010$\u001a\u001d\u0012\u0013\u0012\u0011H\u001f¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160!H\u0083\b¢\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020\u00162\n\u0010'\u001a\u0006\u0012\u0002\b\u00030(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u0004J\b\u0010*\u001a\u00020\u0003H\u0002J\u0006\u0010+\u001a\u00020\u0016J\b\u0010,\u001a\u00020\u0016H\u0002J\u0010\u0010-\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020.H\u0002J\b\u0010/\u001a\u00020\u0019H\u0002J\f\u00100\u001a\u00020\u0019*\u00020\u0001H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004R\t\u0010\n\u001a\u00020\u000bX\u0082\u0004R\u000f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004R\t\u0010\r\u001a\u00020\u000bX\u0082\u0004R\t\u0010\u000e\u001a\u00020\u000fX\u0082\u0004R\u0011\u0010\u0010\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R&\u0010\u0013\u001a\u001a\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00160\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lkotlinx/coroutines/sync/SemaphoreAndMutexImpl;", "", "permits", "", "acquiredPermits", "<init>", "(II)V", "head", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "deqIdx", "Lkotlinx/atomicfu/AtomicLong;", "tail", "enqIdx", "_availablePermits", "Lkotlinx/atomicfu/AtomicInt;", "availablePermits", "getAvailablePermits", "()I", "onCancellationRelease", "Lkotlin/Function3;", "", "", "Lkotlin/coroutines/CoroutineContext;", "tryAcquire", "", "acquire", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "acquireSlowPath", "waiter", "Lkotlinx/coroutines/CancellableContinuation;", "W", "suspend", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onAcquired", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onAcquireRegFunction", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "ignoredParam", "decPermits", BuildConfig.BUILD_TYPE, "coerceAvailablePermitsAtMaximum", "addAcquireToQueue", "Lkotlinx/coroutines/Waiter;", "tryResumeNextFromQueue", "tryResumeAcquire", "kotlinx-coroutines-core"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public class SemaphoreAndMutexImpl {
    private volatile /* synthetic */ int _availablePermits$volatile;
    private volatile /* synthetic */ long deqIdx$volatile;
    private volatile /* synthetic */ long enqIdx$volatile;
    private volatile /* synthetic */ Object head$volatile;
    private final Function3<Throwable, Unit, CoroutineContext, Unit> onCancellationRelease;
    private final int permits;
    private volatile /* synthetic */ Object tail$volatile;
    private static final /* synthetic */ AtomicReferenceFieldUpdater head$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "head$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater deqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "deqIdx$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater tail$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, Object.class, "tail$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater enqIdx$volatile$FU = AtomicLongFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "enqIdx$volatile");
    private static final /* synthetic */ AtomicIntegerFieldUpdater _availablePermits$volatile$FU = AtomicIntegerFieldUpdater.newUpdater(SemaphoreAndMutexImpl.class, "_availablePermits$volatile");

    public SemaphoreAndMutexImpl(int i, int i2) {
        this.permits = i;
        if (!(this.permits > 0)) {
            throw new IllegalArgumentException(("Semaphore should have at least 1 permit, but had " + this.permits).toString());
        }
        if (!(i2 >= 0 && i2 <= this.permits)) {
            throw new IllegalArgumentException(("The number of acquired permits should be in 0.." + this.permits).toString());
        }
        SemaphoreSegment semaphoreSegment = new SemaphoreSegment(0L, null, 2);
        this.head$volatile = semaphoreSegment;
        this.tail$volatile = semaphoreSegment;
        this._availablePermits$volatile = this.permits - i2;
        this.onCancellationRelease = new SemaphoreAndMutexImpl$$ExternalSyntheticLambda2(this);
    }

    public static final /* synthetic */ Object access$acquireSlowPath(SemaphoreAndMutexImpl semaphoreAndMutexImpl, Continuation continuation) {
        return semaphoreAndMutexImpl.acquireSlowPath(continuation);
    }

    public static final /* synthetic */ boolean access$addAcquireToQueue(SemaphoreAndMutexImpl semaphoreAndMutexImpl, Waiter waiter) {
        return semaphoreAndMutexImpl.addAcquireToQueue(waiter);
    }

    private final <W> void acquire(W waiter, Function1<? super W, Boolean> suspend, Function1<? super W, Unit> onAcquired) {
        while (decPermits() <= 0) {
            if (suspend.invoke(waiter).booleanValue()) {
                return;
            }
        }
        onAcquired.invoke(waiter);
    }

    private final Object acquireSlowPath(Continuation<? super Unit> continuation) {
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            if (!access$addAcquireToQueue(this, orCreateCancellableContinuation)) {
                acquire((CancellableContinuation<? super Unit>) orCreateCancellableContinuation);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : Unit.INSTANCE;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private final boolean addAcquireToQueue(Waiter waiter) {
        Object findSegmentInternal;
        long j;
        boolean z;
        boolean z2;
        SemaphoreSegment semaphoreSegment;
        boolean z3;
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) getTail$volatile$FU().get(this);
        long andIncrement = getEnqIdx$volatile$FU().getAndIncrement(this);
        SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 = SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater tail$volatile$FU2 = getTail$volatile$FU();
        long access$getSEGMENT_SIZE$p = andIncrement / SemaphoreKt.access$getSEGMENT_SIZE$p();
        while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment2, access$getSEGMENT_SIZE$p, semaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1);
            if (!SegmentOrClosed.m2017isClosedimpl(findSegmentInternal)) {
                Segment m2015getSegmentimpl = SegmentOrClosed.m2015getSegmentimpl(findSegmentInternal);
                while (true) {
                    Segment segment = (Segment) tail$volatile$FU2.get(this);
                    z = false;
                    z2 = true;
                    semaphoreSegment = semaphoreSegment2;
                    j = andIncrement;
                    if (segment.id >= m2015getSegmentimpl.id) {
                        z3 = true;
                        break;
                    }
                    if (!m2015getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        z3 = false;
                        break;
                    }
                    if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(tail$volatile$FU2, this, segment, m2015getSegmentimpl)) {
                        if (segment.decPointers$kotlinx_coroutines_core()) {
                            segment.remove();
                        }
                        z3 = true;
                    } else {
                        if (m2015getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                            m2015getSegmentimpl.remove();
                        }
                        semaphoreSegment2 = semaphoreSegment;
                        andIncrement = j;
                    }
                }
                if (z3) {
                    break;
                }
                semaphoreSegment2 = semaphoreSegment;
                andIncrement = j;
            } else {
                j = andIncrement;
                z = false;
                z2 = true;
                break;
            }
        }
        SemaphoreSegment semaphoreSegment3 = (SemaphoreSegment) SegmentOrClosed.m2015getSegmentimpl(findSegmentInternal);
        int access$getSEGMENT_SIZE$p2 = (int) (j % SemaphoreKt.access$getSEGMENT_SIZE$p());
        if (AtomicIntrinsicsKt$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment3.getAcquirers(), access$getSEGMENT_SIZE$p2, null, waiter)) {
            waiter.invokeOnCancellation(semaphoreSegment3, access$getSEGMENT_SIZE$p2);
            return z2;
        }
        if (!AtomicIntrinsicsKt$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment3.getAcquirers(), access$getSEGMENT_SIZE$p2, SemaphoreKt.access$getPERMIT$p(), SemaphoreKt.access$getTAKEN$p())) {
            if (DebugKt.getASSERTIONS_ENABLED()) {
                if (!(semaphoreSegment3.getAcquirers().get(access$getSEGMENT_SIZE$p2) == SemaphoreKt.access$getBROKEN$p() ? z2 : z)) {
                    throw new AssertionError();
                }
            }
            return z;
        }
        if (waiter instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            ((CancellableContinuation) waiter).resume((CancellableContinuation) Unit.INSTANCE, (Function3<? super Throwable, ? super CancellableContinuation, ? super CoroutineContext, Unit>) this.onCancellationRelease);
        } else {
            if (!(waiter instanceof SelectInstance)) {
                throw new IllegalStateException(("unexpected: " + waiter).toString());
            }
            ((SelectInstance) waiter).selectInRegistrationPhase(Unit.INSTANCE);
        }
        return z2;
    }

    private final void coerceAvailablePermitsAtMaximum() {
        int i;
        do {
            i = get_availablePermits$volatile$FU().get(this);
            if (i <= this.permits) {
                return;
            }
        } while (!get_availablePermits$volatile$FU().compareAndSet(this, i, this.permits));
    }

    private final int decPermits() {
        int andDecrement;
        do {
            andDecrement = get_availablePermits$volatile$FU().getAndDecrement(this);
        } while (andDecrement > this.permits);
        return andDecrement;
    }

    private final /* synthetic */ long getDeqIdx$volatile() {
        return this.deqIdx$volatile;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater getDeqIdx$volatile$FU() {
        return deqIdx$volatile$FU;
    }

    private final /* synthetic */ long getEnqIdx$volatile() {
        return this.enqIdx$volatile;
    }

    private static final /* synthetic */ AtomicLongFieldUpdater getEnqIdx$volatile$FU() {
        return enqIdx$volatile$FU;
    }

    private final /* synthetic */ Object getHead$volatile() {
        return this.head$volatile;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater getHead$volatile$FU() {
        return head$volatile$FU;
    }

    private final /* synthetic */ Object getTail$volatile() {
        return this.tail$volatile;
    }

    private static final /* synthetic */ AtomicReferenceFieldUpdater getTail$volatile$FU() {
        return tail$volatile$FU;
    }

    private final /* synthetic */ int get_availablePermits$volatile() {
        return this._availablePermits$volatile;
    }

    private static final /* synthetic */ AtomicIntegerFieldUpdater get_availablePermits$volatile$FU() {
        return _availablePermits$volatile$FU;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit onCancellationRelease$lambda$2(SemaphoreAndMutexImpl semaphoreAndMutexImpl, Throwable th, Unit unit, CoroutineContext coroutineContext) {
        semaphoreAndMutexImpl.release();
        return Unit.INSTANCE;
    }

    private final /* synthetic */ void setDeqIdx$volatile(long j) {
        this.deqIdx$volatile = j;
    }

    private final /* synthetic */ void setEnqIdx$volatile(long j) {
        this.enqIdx$volatile = j;
    }

    private final /* synthetic */ void setHead$volatile(Object obj) {
        this.head$volatile = obj;
    }

    private final /* synthetic */ void setTail$volatile(Object obj) {
        this.tail$volatile = obj;
    }

    private final /* synthetic */ void set_availablePermits$volatile(int i) {
        this._availablePermits$volatile = i;
    }

    private final boolean tryResumeAcquire(Object obj) {
        if (!(obj instanceof CancellableContinuation)) {
            if (obj instanceof SelectInstance) {
                return ((SelectInstance) obj).trySelect(this, Unit.INSTANCE);
            }
            throw new IllegalStateException(("unexpected: " + obj).toString());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
        Object tryResume = ((CancellableContinuation) obj).tryResume(Unit.INSTANCE, null, this.onCancellationRelease);
        if (tryResume == null) {
            return false;
        }
        ((CancellableContinuation) obj).completeResume(tryResume);
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r11v1 */
    /* JADX WARN: Type inference failed for: r11v2, types: [int] */
    /* JADX WARN: Type inference failed for: r11v5 */
    private final boolean tryResumeNextFromQueue() {
        Object findSegmentInternal;
        boolean z;
        boolean z2;
        boolean z3;
        SemaphoreSegment semaphoreSegment = (SemaphoreSegment) getHead$volatile$FU().get(this);
        long andIncrement = getDeqIdx$volatile$FU().getAndIncrement(this);
        long access$getSEGMENT_SIZE$p = andIncrement / SemaphoreKt.access$getSEGMENT_SIZE$p();
        SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1 = SemaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1.INSTANCE;
        AtomicReferenceFieldUpdater head$volatile$FU2 = getHead$volatile$FU();
        while (true) {
            findSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(semaphoreSegment, access$getSEGMENT_SIZE$p, semaphoreAndMutexImpl$tryResumeNextFromQueue$createNewSegment$1);
            if (SegmentOrClosed.m2017isClosedimpl(findSegmentInternal)) {
                z = false;
                z2 = true;
                break;
            }
            Segment m2015getSegmentimpl = SegmentOrClosed.m2015getSegmentimpl(findSegmentInternal);
            while (true) {
                Segment segment = (Segment) head$volatile$FU2.get(this);
                z = false;
                z2 = true;
                if (segment.id >= m2015getSegmentimpl.id) {
                    z3 = true;
                    break;
                }
                if (!m2015getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                    z3 = false;
                    break;
                }
                if (AbstractResolvableFuture$SafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0.m(head$volatile$FU2, this, segment, m2015getSegmentimpl)) {
                    if (segment.decPointers$kotlinx_coroutines_core()) {
                        segment.remove();
                    }
                    z3 = true;
                } else if (m2015getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                    m2015getSegmentimpl.remove();
                }
            }
            if (z3) {
                break;
            }
        }
        SemaphoreSegment semaphoreSegment2 = (SemaphoreSegment) SegmentOrClosed.m2015getSegmentimpl(findSegmentInternal);
        semaphoreSegment2.cleanPrev();
        if (semaphoreSegment2.id > access$getSEGMENT_SIZE$p) {
            return z;
        }
        int access$getSEGMENT_SIZE$p2 = (int) (andIncrement % SemaphoreKt.access$getSEGMENT_SIZE$p());
        Object andSet = semaphoreSegment2.getAcquirers().getAndSet(access$getSEGMENT_SIZE$p2, SemaphoreKt.access$getPERMIT$p());
        if (andSet != null) {
            return andSet == SemaphoreKt.access$getCANCELLED$p() ? z : tryResumeAcquire(andSet);
        }
        int access$getMAX_SPIN_CYCLES$p = SemaphoreKt.access$getMAX_SPIN_CYCLES$p();
        for (?? r11 = z; r11 < access$getMAX_SPIN_CYCLES$p; r11++) {
            SemaphoreSegment semaphoreSegment3 = semaphoreSegment;
            if (semaphoreSegment2.getAcquirers().get(access$getSEGMENT_SIZE$p2) == SemaphoreKt.access$getTAKEN$p()) {
                return z2;
            }
            semaphoreSegment = semaphoreSegment3;
        }
        return !AtomicIntrinsicsKt$$ExternalSyntheticBackportWithForwarding0.m(semaphoreSegment2.getAcquirers(), access$getSEGMENT_SIZE$p2, SemaphoreKt.access$getPERMIT$p(), SemaphoreKt.access$getBROKEN$p());
    }

    public final Object acquire(Continuation<? super Unit> continuation) {
        Object acquireSlowPath;
        return (decPermits() <= 0 && (acquireSlowPath = acquireSlowPath(continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? acquireSlowPath : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void acquire(CancellableContinuation<? super Unit> waiter) {
        while (decPermits() <= 0) {
            Intrinsics.checkNotNull(waiter, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (addAcquireToQueue((Waiter) waiter)) {
                return;
            }
        }
        waiter.resume((CancellableContinuation<? super Unit>) Unit.INSTANCE, this.onCancellationRelease);
    }

    public final int getAvailablePermits() {
        return Math.max(get_availablePermits$volatile$FU().get(this), 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void onAcquireRegFunction(SelectInstance<?> select, Object ignoredParam) {
        while (decPermits() <= 0) {
            Intrinsics.checkNotNull(select, "null cannot be cast to non-null type kotlinx.coroutines.Waiter");
            if (addAcquireToQueue((Waiter) select)) {
                return;
            }
        }
        select.selectInRegistrationPhase(Unit.INSTANCE);
    }

    public final void release() {
        do {
            int andIncrement = get_availablePermits$volatile$FU().getAndIncrement(this);
            if (andIncrement >= this.permits) {
                coerceAvailablePermitsAtMaximum();
                throw new IllegalStateException(("The number of released permits cannot be greater than " + this.permits).toString());
            }
            if (andIncrement >= 0) {
                return;
            }
        } while (!tryResumeNextFromQueue());
    }

    public final boolean tryAcquire() {
        while (true) {
            int i = get_availablePermits$volatile$FU().get(this);
            if (i > this.permits) {
                coerceAvailablePermitsAtMaximum();
            } else {
                if (i <= 0) {
                    return false;
                }
                if (get_availablePermits$volatile$FU().compareAndSet(this, i, i - 1)) {
                    return true;
                }
            }
        }
    }
}
