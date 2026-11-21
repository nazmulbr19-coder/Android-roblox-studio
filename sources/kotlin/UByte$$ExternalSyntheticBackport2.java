package kotlin;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class UByte$$ExternalSyntheticBackport2 {
    public static /* synthetic */ long m(long j, long j2) {
        if (j2 < 0) {
            if ((j ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j2)) {
                return j;
            }
        } else {
            if (j >= 0) {
                return j % j2;
            }
            j -= (((j >>> 1) / j2) << 1) * j2;
            if ((j ^ Long.MIN_VALUE) < (Long.MIN_VALUE ^ j2)) {
                j2 = 0;
            }
        }
        return j - j2;
    }
}
