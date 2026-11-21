package kotlin.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.time.ComparableTimeMark;
import kotlin.time.TimeSource;

/* compiled from: TimeSources.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001:\u0001\u0012B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH$J\b\u0010\u000f\u001a\u00020\tH\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0013"}, d2 = {"Lkotlin/time/AbstractLongTimeSource;", "Lkotlin/time/TimeSource$WithComparableMarks;", "unit", "Lkotlin/time/DurationUnit;", "<init>", "(Lkotlin/time/DurationUnit;)V", "getUnit", "()Lkotlin/time/DurationUnit;", "read", "", "zero", "getZero", "()J", "zero$delegate", "Lkotlin/Lazy;", "adjustedRead", "markNow", "Lkotlin/time/ComparableTimeMark;", "LongTimeMark", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public abstract class AbstractLongTimeSource implements TimeSource.WithComparableMarks {
    private final DurationUnit unit;

    /* renamed from: zero$delegate, reason: from kotlin metadata */
    private final Lazy zero;

    /* compiled from: TimeSources.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0007H\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u0014\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0018H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\n¨\u0006\u001d"}, d2 = {"Lkotlin/time/AbstractLongTimeSource$LongTimeMark;", "Lkotlin/time/ComparableTimeMark;", "startedAt", "", "timeSource", "Lkotlin/time/AbstractLongTimeSource;", TypedValues.CycleType.S_WAVE_OFFSET, "Lkotlin/time/Duration;", "<init>", "(JLkotlin/time/AbstractLongTimeSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "elapsedNow", "elapsedNow-UwyO8pc", "()J", "plus", TypedValues.TransitionType.S_DURATION, "plus-LRDsOJo", "(J)Lkotlin/time/ComparableTimeMark;", "minus", "other", "minus-UwyO8pc", "(Lkotlin/time/ComparableTimeMark;)J", "equals", "", "", "hashCode", "", "toString", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes.dex */
    private static final class LongTimeMark implements ComparableTimeMark {
        private final long offset;
        private final long startedAt;
        private final AbstractLongTimeSource timeSource;

        private LongTimeMark(long j, AbstractLongTimeSource timeSource, long j2) {
            Intrinsics.checkNotNullParameter(timeSource, "timeSource");
            this.startedAt = j;
            this.timeSource = timeSource;
            this.offset = j2;
        }

        public /* synthetic */ LongTimeMark(long j, AbstractLongTimeSource abstractLongTimeSource, long j2, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, abstractLongTimeSource, j2);
        }

        @Override // java.lang.Comparable
        public /* bridge */ /* synthetic */ int compareTo(ComparableTimeMark comparableTimeMark) {
            return compareTo2(comparableTimeMark);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* renamed from: compareTo, reason: avoid collision after fix types in other method */
        public int compareTo2(ComparableTimeMark comparableTimeMark) {
            return ComparableTimeMark.DefaultImpls.compareTo(this, comparableTimeMark);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: elapsedNow-UwyO8pc */
        public long mo1786elapsedNowUwyO8pc() {
            return Duration.m1824minusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(AbstractLongTimeSource.access$adjustedRead(this.timeSource), this.startedAt, this.timeSource.getUnit()), this.offset);
        }

        @Override // kotlin.time.ComparableTimeMark
        public boolean equals(Object other) {
            return (other instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) other).timeSource) && Duration.m1801equalsimpl0(mo1788minusUwyO8pc((ComparableTimeMark) other), Duration.INSTANCE.m1887getZEROUwyO8pc());
        }

        @Override // kotlin.time.TimeMark
        public boolean hasNotPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasNotPassedNow(this);
        }

        @Override // kotlin.time.TimeMark
        public boolean hasPassedNow() {
            return ComparableTimeMark.DefaultImpls.hasPassedNow(this);
        }

        @Override // kotlin.time.ComparableTimeMark
        public int hashCode() {
            return (Duration.m1817hashCodeimpl(this.offset) * 37) + Long.hashCode(this.startedAt);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* renamed from: minus-LRDsOJo */
        public ComparableTimeMark mo1787minusLRDsOJo(long j) {
            return ComparableTimeMark.DefaultImpls.m1791minusLRDsOJo(this, j);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: minus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo1787minusLRDsOJo(long j) {
            return mo1787minusLRDsOJo(j);
        }

        @Override // kotlin.time.ComparableTimeMark
        /* renamed from: minus-UwyO8pc */
        public long mo1788minusUwyO8pc(ComparableTimeMark other) {
            Intrinsics.checkNotNullParameter(other, "other");
            if ((other instanceof LongTimeMark) && Intrinsics.areEqual(this.timeSource, ((LongTimeMark) other).timeSource)) {
                return Duration.m1825plusLRDsOJo(LongSaturatedMathKt.saturatingOriginsDiff(this.startedAt, ((LongTimeMark) other).startedAt, this.timeSource.getUnit()), Duration.m1824minusLRDsOJo(this.offset, ((LongTimeMark) other).offset));
            }
            throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + this + " and " + other);
        }

        @Override // kotlin.time.ComparableTimeMark, kotlin.time.TimeMark
        /* renamed from: plus-LRDsOJo */
        public ComparableTimeMark mo1789plusLRDsOJo(long duration) {
            DurationUnit unit = this.timeSource.getUnit();
            if (Duration.m1821isInfiniteimpl(duration)) {
                return new LongTimeMark(LongSaturatedMathKt.m1898saturatingAddNuflL3o(this.startedAt, unit, duration), this.timeSource, Duration.INSTANCE.m1887getZEROUwyO8pc(), null);
            }
            long m1839truncateToUwyO8pc$kotlin_stdlib = Duration.m1839truncateToUwyO8pc$kotlin_stdlib(duration, unit);
            long m1825plusLRDsOJo = Duration.m1825plusLRDsOJo(Duration.m1824minusLRDsOJo(duration, m1839truncateToUwyO8pc$kotlin_stdlib), this.offset);
            long m1898saturatingAddNuflL3o = LongSaturatedMathKt.m1898saturatingAddNuflL3o(this.startedAt, unit, m1839truncateToUwyO8pc$kotlin_stdlib);
            long m1839truncateToUwyO8pc$kotlin_stdlib2 = Duration.m1839truncateToUwyO8pc$kotlin_stdlib(m1825plusLRDsOJo, unit);
            long m1898saturatingAddNuflL3o2 = LongSaturatedMathKt.m1898saturatingAddNuflL3o(m1898saturatingAddNuflL3o, unit, m1839truncateToUwyO8pc$kotlin_stdlib2);
            long m1824minusLRDsOJo = Duration.m1824minusLRDsOJo(m1825plusLRDsOJo, m1839truncateToUwyO8pc$kotlin_stdlib2);
            long m1809getInWholeNanosecondsimpl = Duration.m1809getInWholeNanosecondsimpl(m1824minusLRDsOJo);
            if (m1898saturatingAddNuflL3o2 != 0 && m1809getInWholeNanosecondsimpl != 0 && (m1898saturatingAddNuflL3o2 ^ m1809getInWholeNanosecondsimpl) < 0) {
                long duration2 = DurationKt.toDuration(MathKt.getSign(m1809getInWholeNanosecondsimpl), unit);
                m1898saturatingAddNuflL3o2 = LongSaturatedMathKt.m1898saturatingAddNuflL3o(m1898saturatingAddNuflL3o2, unit, duration2);
                m1824minusLRDsOJo = Duration.m1824minusLRDsOJo(m1824minusLRDsOJo, duration2);
            }
            long j = m1898saturatingAddNuflL3o2;
            return new LongTimeMark(j, this.timeSource, (((j - 1) | 1) > Long.MAX_VALUE ? 1 : (((j - 1) | 1) == Long.MAX_VALUE ? 0 : -1)) == 0 ? Duration.INSTANCE.m1887getZEROUwyO8pc() : m1824minusLRDsOJo, null);
        }

        @Override // kotlin.time.TimeMark
        /* renamed from: plus-LRDsOJo */
        public /* bridge */ /* synthetic */ TimeMark mo1789plusLRDsOJo(long j) {
            return mo1789plusLRDsOJo(j);
        }

        public String toString() {
            return "LongTimeMark(" + this.startedAt + DurationUnitKt.shortName(this.timeSource.getUnit()) + " + " + ((Object) Duration.m1836toStringimpl(this.offset)) + ", " + this.timeSource + ')';
        }
    }

    public AbstractLongTimeSource(DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        this.unit = unit;
        this.zero = LazyKt.lazy(new AbstractLongTimeSource$$ExternalSyntheticLambda0(this));
    }

    public static final /* synthetic */ long access$adjustedRead(AbstractLongTimeSource abstractLongTimeSource) {
        return abstractLongTimeSource.adjustedRead();
    }

    private final long adjustedRead() {
        return read() - getZero();
    }

    private final long getZero() {
        return ((Number) this.zero.getValue()).longValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final long zero_delegate$lambda$0(AbstractLongTimeSource abstractLongTimeSource) {
        return abstractLongTimeSource.read();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final DurationUnit getUnit() {
        return this.unit;
    }

    @Override // kotlin.time.TimeSource.WithComparableMarks, kotlin.time.TimeSource
    public ComparableTimeMark markNow() {
        return new LongTimeMark(adjustedRead(), this, Duration.INSTANCE.m1887getZEROUwyO8pc(), null);
    }

    @Override // kotlin.time.TimeSource
    public /* bridge */ /* synthetic */ TimeMark markNow() {
        return markNow();
    }

    protected abstract long read();
}
