package kotlin.time;

import kotlin.Metadata;

/* compiled from: Clocks.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"kotlin/time/ClocksKt$asClock$1", "Lkotlin/time/Clock;", "startMark", "Lkotlin/time/TimeMark;", "now", "Lkotlin/time/Instant;", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ClocksKt$asClock$1 implements Clock {
    final /* synthetic */ Instant $origin;
    private final TimeMark startMark;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ClocksKt$asClock$1(TimeSource timeSource, Instant instant) {
        this.$origin = instant;
        this.startMark = timeSource.markNow();
    }

    @Override // kotlin.time.Clock
    public Instant now() {
        return this.$origin.m1896plusLRDsOJo(this.startMark.mo1786elapsedNowUwyO8pc());
    }
}
