package kotlin;

import androidx.collection.MutableFloatFloatMap$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.ULongRange;
import kotlin.ranges.URangesKt;

/* compiled from: ULong.kt */
@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b2\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0010\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 {2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001{B\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u000f\u0010\u0010J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u0012\u0010\u0013J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b\u0017\u0010\u0018J\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\u001b\u0010\u001cJ\u0018\u0010\u0016\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001d\u0010\u001eJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b \u0010\u0018J\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b!\u0010\u001aJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b\"\u0010\u001cJ\u0018\u0010\u001f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b#\u0010\u001eJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b%\u0010\u0018J\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b&\u0010\u001aJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b'\u0010\u001cJ\u0018\u0010$\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b(\u0010\u001eJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b*\u0010\u0018J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b+\u0010\u001aJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b,\u0010\u001cJ\u0018\u0010)\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b-\u0010\u001eJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\n¢\u0006\u0004\b/\u0010\u0018J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\n¢\u0006\u0004\b0\u0010\u001aJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\n¢\u0006\u0004\b1\u0010\u001cJ\u0018\u0010.\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b2\u0010\u001eJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b4\u0010\u0018J\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b5\u0010\u001aJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b6\u0010\u001cJ\u0018\u00103\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b7\u0010\u001eJ\u0018\u00108\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\b9\u0010:J\u0018\u00108\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\b;\u0010<J\u0018\u00108\u001a\u00020\u00112\u0006\u0010\n\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\b=\u0010\u0013J\u0018\u00108\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b>\u0010\u001eJ\u0010\u0010?\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b@\u0010\u0005J\u0010\u0010A\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bB\u0010\u0005J\u0018\u0010C\u001a\u00020D2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bE\u0010FJ\u0018\u0010G\u001a\u00020D2\u0006\u0010\n\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bH\u0010FJ\u0018\u0010I\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\tH\u0087\f¢\u0006\u0004\bK\u0010\u001cJ\u0018\u0010L\u001a\u00020\u00002\u0006\u0010J\u001a\u00020\tH\u0087\f¢\u0006\u0004\bM\u0010\u001cJ\u0018\u0010N\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bO\u0010\u001eJ\u0018\u0010P\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bQ\u0010\u001eJ\u0018\u0010R\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bS\u0010\u001eJ\u0010\u0010T\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bU\u0010\u0005J\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020[H\u0087\b¢\u0006\u0004\b\\\u0010]J\u0010\u0010^\u001a\u00020\tH\u0087\b¢\u0006\u0004\b_\u0010`J\u0010\u0010a\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\bb\u0010\u0005J\u0010\u0010c\u001a\u00020\u000bH\u0087\b¢\u0006\u0004\bd\u0010YJ\u0010\u0010e\u001a\u00020\u000eH\u0087\b¢\u0006\u0004\bf\u0010]J\u0010\u0010g\u001a\u00020\u0011H\u0087\b¢\u0006\u0004\bh\u0010`J\u0010\u0010i\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bj\u0010\u0005J\u0010\u0010k\u001a\u00020lH\u0087\b¢\u0006\u0004\bm\u0010nJ\u0010\u0010o\u001a\u00020pH\u0087\b¢\u0006\u0004\bq\u0010rJ\u000f\u0010s\u001a\u00020tH\u0016¢\u0006\u0004\bu\u0010vJ\u0013\u0010w\u001a\u00020x2\b\u0010\n\u001a\u0004\u0018\u00010yHÖ\u0003J\t\u0010z\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006|"}, d2 = {"Lkotlin/ULong;", "", "data", "", "constructor-impl", "(J)J", "getData$annotations", "()V", "compareTo", "", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(JB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(JS)I", "Lkotlin/UInt;", "compareTo-WZ4Q5Ns", "(JI)I", "compareTo-VKZWuLQ", "(JJ)I", "plus", "plus-7apg3OU", "(JB)J", "plus-xj2QHRw", "(JS)J", "plus-WZ4Q5Ns", "(JI)J", "plus-VKZWuLQ", "(JJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(JB)B", "mod-xj2QHRw", "(JS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-s-VKNKU", "dec", "dec-s-VKNKU", "rangeTo", "Lkotlin/ranges/ULongRange;", "rangeTo-VKZWuLQ", "(JJ)Lkotlin/ranges/ULongRange;", "rangeUntil", "rangeUntil-VKZWuLQ", "shl", "bitCount", "shl-s-VKNKU", "shr", "shr-s-VKNKU", "and", "and-VKZWuLQ", "or", "or-VKZWuLQ", "xor", "xor-VKZWuLQ", "inv", "inv-s-VKNKU", "toByte", "", "toByte-impl", "(J)B", "toShort", "", "toShort-impl", "(J)S", "toInt", "toInt-impl", "(J)I", "toLong", "toLong-impl", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(J)F", "toDouble", "", "toDouble-impl", "(J)D", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class ULong implements Comparable<ULong> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long MAX_VALUE = -1;
    public static final long MIN_VALUE = 0;
    public static final int SIZE_BITS = 64;
    public static final int SIZE_BYTES = 8;
    private final long data;

    /* compiled from: ULong.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/ULong$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/ULong;", "J", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ ULong(long j) {
        this.data = j;
    }

    /* renamed from: and-VKZWuLQ, reason: not valid java name */
    private static final long m624andVKZWuLQ(long j, long j2) {
        return m631constructorimpl(j & j2);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ ULong m625boximpl(long j) {
        return new ULong(j);
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m626compareTo7apg3OU(long j, byte b) {
        return MutableFloatFloatMap$$ExternalSyntheticBackport0.m(j, m631constructorimpl(b & 255));
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private int m627compareToVKZWuLQ(long j) {
        return UnsignedKt.ulongCompare(getData(), j);
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static int m628compareToVKZWuLQ(long j, long j2) {
        return UnsignedKt.ulongCompare(j, j2);
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static final int m629compareToWZ4Q5Ns(long j, int i) {
        return MutableFloatFloatMap$$ExternalSyntheticBackport0.m(j, m631constructorimpl(i & 4294967295L));
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m630compareToxj2QHRw(long j, short s) {
        return MutableFloatFloatMap$$ExternalSyntheticBackport0.m(j, m631constructorimpl(s & 65535));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m631constructorimpl(long j) {
        return j;
    }

    /* renamed from: dec-s-VKNKU, reason: not valid java name */
    private static final long m632decsVKNKU(long j) {
        return m631constructorimpl((-1) + j);
    }

    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final long m633div7apg3OU(long j, byte b) {
        return UByte$$ExternalSyntheticBackport3.m(j, m631constructorimpl(b & 255));
    }

    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m634divVKZWuLQ(long j, long j2) {
        return UnsignedKt.m810ulongDivideeb3DHEI(j, j2);
    }

    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final long m635divWZ4Q5Ns(long j, int i) {
        return UByte$$ExternalSyntheticBackport3.m(j, m631constructorimpl(i & 4294967295L));
    }

    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final long m636divxj2QHRw(long j, short s) {
        return UByte$$ExternalSyntheticBackport3.m(j, m631constructorimpl(s & 65535));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m637equalsimpl(long j, Object obj) {
        return (obj instanceof ULong) && j == ((ULong) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m638equalsimpl0(long j, long j2) {
        return j == j2;
    }

    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final long m639floorDiv7apg3OU(long j, byte b) {
        return UByte$$ExternalSyntheticBackport3.m(j, m631constructorimpl(b & 255));
    }

    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m640floorDivVKZWuLQ(long j, long j2) {
        return UByte$$ExternalSyntheticBackport3.m(j, j2);
    }

    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final long m641floorDivWZ4Q5Ns(long j, int i) {
        return UByte$$ExternalSyntheticBackport3.m(j, m631constructorimpl(i & 4294967295L));
    }

    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final long m642floorDivxj2QHRw(long j, short s) {
        return UByte$$ExternalSyntheticBackport3.m(j, m631constructorimpl(s & 65535));
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m643hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: inc-s-VKNKU, reason: not valid java name */
    private static final long m644incsVKNKU(long j) {
        return m631constructorimpl(1 + j);
    }

    /* renamed from: inv-s-VKNKU, reason: not valid java name */
    private static final long m645invsVKNKU(long j) {
        return m631constructorimpl(~j);
    }

    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final long m646minus7apg3OU(long j, byte b) {
        return m631constructorimpl(j - m631constructorimpl(b & 255));
    }

    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m647minusVKZWuLQ(long j, long j2) {
        return m631constructorimpl(j - j2);
    }

    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final long m648minusWZ4Q5Ns(long j, int i) {
        return m631constructorimpl(j - m631constructorimpl(i & 4294967295L));
    }

    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final long m649minusxj2QHRw(long j, short s) {
        return m631constructorimpl(j - m631constructorimpl(s & 65535));
    }

    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m650mod7apg3OU(long j, byte b) {
        return UByte.m475constructorimpl((byte) UByte$$ExternalSyntheticBackport2.m(j, m631constructorimpl(b & 255)));
    }

    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m651modVKZWuLQ(long j, long j2) {
        return UByte$$ExternalSyntheticBackport2.m(j, j2);
    }

    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m652modWZ4Q5Ns(long j, int i) {
        return UInt.m552constructorimpl((int) UByte$$ExternalSyntheticBackport2.m(j, m631constructorimpl(i & 4294967295L)));
    }

    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m653modxj2QHRw(long j, short s) {
        return UShort.m738constructorimpl((short) UByte$$ExternalSyntheticBackport2.m(j, m631constructorimpl(s & 65535)));
    }

    /* renamed from: or-VKZWuLQ, reason: not valid java name */
    private static final long m654orVKZWuLQ(long j, long j2) {
        return m631constructorimpl(j | j2);
    }

    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final long m655plus7apg3OU(long j, byte b) {
        return m631constructorimpl(m631constructorimpl(b & 255) + j);
    }

    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m656plusVKZWuLQ(long j, long j2) {
        return m631constructorimpl(j + j2);
    }

    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final long m657plusWZ4Q5Ns(long j, int i) {
        return m631constructorimpl(m631constructorimpl(i & 4294967295L) + j);
    }

    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final long m658plusxj2QHRw(long j, short s) {
        return m631constructorimpl(m631constructorimpl(s & 65535) + j);
    }

    /* renamed from: rangeTo-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m659rangeToVKZWuLQ(long j, long j2) {
        return new ULongRange(j, j2, null);
    }

    /* renamed from: rangeUntil-VKZWuLQ, reason: not valid java name */
    private static final ULongRange m660rangeUntilVKZWuLQ(long j, long j2) {
        return URangesKt.m1732untileb3DHEI(j, j2);
    }

    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final long m661rem7apg3OU(long j, byte b) {
        return UByte$$ExternalSyntheticBackport2.m(j, m631constructorimpl(b & 255));
    }

    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m662remVKZWuLQ(long j, long j2) {
        return UnsignedKt.m811ulongRemaindereb3DHEI(j, j2);
    }

    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final long m663remWZ4Q5Ns(long j, int i) {
        return UByte$$ExternalSyntheticBackport2.m(j, m631constructorimpl(i & 4294967295L));
    }

    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final long m664remxj2QHRw(long j, short s) {
        return UByte$$ExternalSyntheticBackport2.m(j, m631constructorimpl(s & 65535));
    }

    /* renamed from: shl-s-VKNKU, reason: not valid java name */
    private static final long m665shlsVKNKU(long j, int i) {
        return m631constructorimpl(j << i);
    }

    /* renamed from: shr-s-VKNKU, reason: not valid java name */
    private static final long m666shrsVKNKU(long j, int i) {
        return m631constructorimpl(j >>> i);
    }

    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final long m667times7apg3OU(long j, byte b) {
        return m631constructorimpl(m631constructorimpl(b & 255) * j);
    }

    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m668timesVKZWuLQ(long j, long j2) {
        return m631constructorimpl(j * j2);
    }

    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final long m669timesWZ4Q5Ns(long j, int i) {
        return m631constructorimpl(m631constructorimpl(i & 4294967295L) * j);
    }

    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final long m670timesxj2QHRw(long j, short s) {
        return m631constructorimpl(m631constructorimpl(s & 65535) * j);
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m671toByteimpl(long j) {
        return (byte) j;
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m672toDoubleimpl(long j) {
        return UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m673toFloatimpl(long j) {
        return (float) UnsignedKt.ulongToDouble(j);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m674toIntimpl(long j) {
        return (int) j;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m675toLongimpl(long j) {
        return j;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m676toShortimpl(long j) {
        return (short) j;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m677toStringimpl(long j) {
        return UnsignedKt.ulongToString(j, 10);
    }

    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m678toUBytew2LRezQ(long j) {
        return UByte.m475constructorimpl((byte) j);
    }

    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m679toUIntpVg5ArA(long j) {
        return UInt.m552constructorimpl((int) j);
    }

    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m680toULongsVKNKU(long j) {
        return j;
    }

    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m681toUShortMh2AYeg(long j) {
        return UShort.m738constructorimpl((short) j);
    }

    /* renamed from: xor-VKZWuLQ, reason: not valid java name */
    private static final long m682xorVKZWuLQ(long j, long j2) {
        return m631constructorimpl(j ^ j2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(ULong uLong) {
        return UnsignedKt.ulongCompare(getData(), uLong.getData());
    }

    public boolean equals(Object other) {
        return m637equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m643hashCodeimpl(this.data);
    }

    public String toString() {
        return m677toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ long getData() {
        return this.data;
    }
}
