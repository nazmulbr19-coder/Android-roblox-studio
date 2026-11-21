package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* compiled from: TimeSources.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0014J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0086\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000e\u0010\fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "<init>", "()V", "reading", "", "read", "plusAssign", "", TypedValues.TransitionType.S_DURATION, "Lkotlin/time/Duration;", "plusAssign-LRDsOJo", "(J)V", "overflow", "overflow-LRDsOJo", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
        markNow();
    }

    /* renamed from: overflow-LRDsOJo, reason: not valid java name */
    private final void m1904overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + DurationUnitKt.shortName(getUnit()) + " is advanced by " + ((Object) Duration.m1836toStringimpl(duration)) + '.');
    }

    /* renamed from: plusAssign-LRDsOJo, reason: not valid java name */
    public final void m1905plusAssignLRDsOJo(long duration) {
        long m1835toLongimpl = Duration.m1835toLongimpl(duration, getUnit());
        if (!(((m1835toLongimpl - 1) | 1) == Long.MAX_VALUE)) {
            long j = this.reading + m1835toLongimpl;
            if ((this.reading ^ m1835toLongimpl) >= 0 && (this.reading ^ j) < 0) {
                m1904overflowLRDsOJo(duration);
            }
            this.reading = j;
            return;
        }
        long m1799divUwyO8pc = Duration.m1799divUwyO8pc(duration, 2);
        if (((Duration.m1835toLongimpl(m1799divUwyO8pc, getUnit()) - 1) | 1) == Long.MAX_VALUE) {
            m1904overflowLRDsOJo(duration);
            return;
        }
        long j2 = this.reading;
        try {
            m1905plusAssignLRDsOJo(m1799divUwyO8pc);
            m1905plusAssignLRDsOJo(Duration.m1824minusLRDsOJo(duration, m1799divUwyO8pc));
        } catch (IllegalStateException e) {
            this.reading = j2;
            throw e;
        }
    }

    @Override // kotlin.time.AbstractLongTimeSource
    /* renamed from: read, reason: from getter */
    protected long getReading() {
        return this.reading;
    }
}
