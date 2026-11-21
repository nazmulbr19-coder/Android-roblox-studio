package kotlin;

import androidx.collection.MutableFloatFloatMap$$ExternalSyntheticBackport0;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.UIntRange;
import kotlin.ranges.URangesKt;

/* compiled from: UInt.kt */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 x2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001xB\u0011\b\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b\u000b\u0010\fJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u000e\u0010\u000fJ\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0097\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0013\u0010\u0014J\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b\u0016\u0010\fJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u0017\u0010\u000fJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0018\u0010\u0011J\u0018\u0010\u0015\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0019\u0010\u001aJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b\u001c\u0010\fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\u001d\u0010\u000fJ\u0018\u0010\u001b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u001e\u0010\u0011J\u0018\u0010\u001b\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u001f\u0010\u001aJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b!\u0010\fJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b\"\u0010\u000fJ\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b#\u0010\u0011J\u0018\u0010 \u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b$\u0010\u001aJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b&\u0010\fJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b'\u0010\u000fJ\u0018\u0010%\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b(\u0010\u0011J\u0018\u0010%\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b)\u0010\u001aJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\n¢\u0006\u0004\b+\u0010\fJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\n¢\u0006\u0004\b,\u0010\u000fJ\u0018\u0010*\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b-\u0010\u0011J\u0018\u0010*\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b.\u0010\u001aJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0087\b¢\u0006\u0004\b0\u0010\fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\rH\u0087\b¢\u0006\u0004\b1\u0010\u000fJ\u0018\u0010/\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b2\u0010\u0011J\u0018\u0010/\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b3\u0010\u001aJ\u0018\u00104\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\nH\u0087\b¢\u0006\u0004\b5\u00106J\u0018\u00104\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\rH\u0087\b¢\u0006\u0004\b7\u00108J\u0018\u00104\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\b9\u0010\u0011J\u0018\u00104\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\b:\u0010\u001aJ\u0010\u0010;\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b<\u0010\u0005J\u0010\u0010=\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b>\u0010\u0005J\u0018\u0010?\u001a\u00020@2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bA\u0010BJ\u0018\u0010C\u001a\u00020@2\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\bD\u0010BJ\u0018\u0010E\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0003H\u0087\f¢\u0006\u0004\bG\u0010\u0011J\u0018\u0010H\u001a\u00020\u00002\u0006\u0010F\u001a\u00020\u0003H\u0087\f¢\u0006\u0004\bI\u0010\u0011J\u0018\u0010J\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bK\u0010\u0011J\u0018\u0010L\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bM\u0010\u0011J\u0018\u0010N\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\f¢\u0006\u0004\bO\u0010\u0011J\u0010\u0010P\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\bQ\u0010\u0005J\u0010\u0010R\u001a\u00020SH\u0087\b¢\u0006\u0004\bT\u0010UJ\u0010\u0010V\u001a\u00020WH\u0087\b¢\u0006\u0004\bX\u0010YJ\u0010\u0010Z\u001a\u00020\u0003H\u0087\b¢\u0006\u0004\b[\u0010\u0005J\u0010\u0010\\\u001a\u00020]H\u0087\b¢\u0006\u0004\b^\u0010_J\u0010\u0010`\u001a\u00020\nH\u0087\b¢\u0006\u0004\ba\u0010UJ\u0010\u0010b\u001a\u00020\rH\u0087\b¢\u0006\u0004\bc\u0010YJ\u0010\u0010d\u001a\u00020\u0000H\u0087\b¢\u0006\u0004\be\u0010\u0005J\u0010\u0010f\u001a\u00020\u0012H\u0087\b¢\u0006\u0004\bg\u0010_J\u0010\u0010h\u001a\u00020iH\u0087\b¢\u0006\u0004\bj\u0010kJ\u0010\u0010l\u001a\u00020mH\u0087\b¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020qH\u0016¢\u0006\u0004\br\u0010sJ\u0013\u0010t\u001a\u00020u2\b\u0010\t\u001a\u0004\u0018\u00010vHÖ\u0003J\t\u0010w\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006y"}, d2 = {"Lkotlin/UInt;", "", "data", "", "constructor-impl", "(I)I", "getData$annotations", "()V", "compareTo", "other", "Lkotlin/UByte;", "compareTo-7apg3OU", "(IB)I", "Lkotlin/UShort;", "compareTo-xj2QHRw", "(IS)I", "compareTo-WZ4Q5Ns", "(II)I", "Lkotlin/ULong;", "compareTo-VKZWuLQ", "(IJ)I", "plus", "plus-7apg3OU", "plus-xj2QHRw", "plus-WZ4Q5Ns", "plus-VKZWuLQ", "(IJ)J", "minus", "minus-7apg3OU", "minus-xj2QHRw", "minus-WZ4Q5Ns", "minus-VKZWuLQ", "times", "times-7apg3OU", "times-xj2QHRw", "times-WZ4Q5Ns", "times-VKZWuLQ", "div", "div-7apg3OU", "div-xj2QHRw", "div-WZ4Q5Ns", "div-VKZWuLQ", "rem", "rem-7apg3OU", "rem-xj2QHRw", "rem-WZ4Q5Ns", "rem-VKZWuLQ", "floorDiv", "floorDiv-7apg3OU", "floorDiv-xj2QHRw", "floorDiv-WZ4Q5Ns", "floorDiv-VKZWuLQ", "mod", "mod-7apg3OU", "(IB)B", "mod-xj2QHRw", "(IS)S", "mod-WZ4Q5Ns", "mod-VKZWuLQ", "inc", "inc-pVg5ArA", "dec", "dec-pVg5ArA", "rangeTo", "Lkotlin/ranges/UIntRange;", "rangeTo-WZ4Q5Ns", "(II)Lkotlin/ranges/UIntRange;", "rangeUntil", "rangeUntil-WZ4Q5Ns", "shl", "bitCount", "shl-pVg5ArA", "shr", "shr-pVg5ArA", "and", "and-WZ4Q5Ns", "or", "or-WZ4Q5Ns", "xor", "xor-WZ4Q5Ns", "inv", "inv-pVg5ArA", "toByte", "", "toByte-impl", "(I)B", "toShort", "", "toShort-impl", "(I)S", "toInt", "toInt-impl", "toLong", "", "toLong-impl", "(I)J", "toUByte", "toUByte-w2LRezQ", "toUShort", "toUShort-Mh2AYeg", "toUInt", "toUInt-pVg5ArA", "toULong", "toULong-s-VKNKU", "toFloat", "", "toFloat-impl", "(I)F", "toDouble", "", "toDouble-impl", "(I)D", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
public final class UInt implements Comparable<UInt> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MAX_VALUE = -1;
    public static final int MIN_VALUE = 0;
    public static final int SIZE_BITS = 32;
    public static final int SIZE_BYTES = 4;
    private final int data;

    /* compiled from: UInt.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0004\n\u0002\u0010\u0006R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lkotlin/UInt$Companion;", "", "<init>", "()V", "MIN_VALUE", "Lkotlin/UInt;", "I", "MAX_VALUE", "SIZE_BYTES", "", "SIZE_BITS", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    private /* synthetic */ UInt(int i) {
        this.data = i;
    }

    /* renamed from: and-WZ4Q5Ns, reason: not valid java name */
    private static final int m545andWZ4Q5Ns(int i, int i2) {
        return m552constructorimpl(i & i2);
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ UInt m546boximpl(int i) {
        return new UInt(i);
    }

    /* renamed from: compareTo-7apg3OU, reason: not valid java name */
    private static final int m547compareTo7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport4.m(i, m552constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: compareTo-VKZWuLQ, reason: not valid java name */
    private static final int m548compareToVKZWuLQ(int i, long j) {
        return MutableFloatFloatMap$$ExternalSyntheticBackport0.m(ULong.m631constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private int m549compareToWZ4Q5Ns(int i) {
        return UnsignedKt.uintCompare(getData(), i);
    }

    /* renamed from: compareTo-WZ4Q5Ns, reason: not valid java name */
    private static int m550compareToWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.uintCompare(i, i2);
    }

    /* renamed from: compareTo-xj2QHRw, reason: not valid java name */
    private static final int m551compareToxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport4.m(i, m552constructorimpl(65535 & s));
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m552constructorimpl(int i) {
        return i;
    }

    /* renamed from: dec-pVg5ArA, reason: not valid java name */
    private static final int m553decpVg5ArA(int i) {
        return m552constructorimpl(i - 1);
    }

    /* renamed from: div-7apg3OU, reason: not valid java name */
    private static final int m554div7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(i, m552constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: div-VKZWuLQ, reason: not valid java name */
    private static final long m555divVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m631constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: div-WZ4Q5Ns, reason: not valid java name */
    private static final int m556divWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m808uintDivideJ1ME1BU(i, i2);
    }

    /* renamed from: div-xj2QHRw, reason: not valid java name */
    private static final int m557divxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m(i, m552constructorimpl(65535 & s));
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m558equalsimpl(int i, Object obj) {
        return (obj instanceof UInt) && i == ((UInt) obj).getData();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m559equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: floorDiv-7apg3OU, reason: not valid java name */
    private static final int m560floorDiv7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport0.m(i, m552constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: floorDiv-VKZWuLQ, reason: not valid java name */
    private static final long m561floorDivVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport3.m(ULong.m631constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: floorDiv-WZ4Q5Ns, reason: not valid java name */
    private static final int m562floorDivWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport0.m(i, i2);
    }

    /* renamed from: floorDiv-xj2QHRw, reason: not valid java name */
    private static final int m563floorDivxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport0.m(i, m552constructorimpl(65535 & s));
    }

    public static /* synthetic */ void getData$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m564hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: inc-pVg5ArA, reason: not valid java name */
    private static final int m565incpVg5ArA(int i) {
        return m552constructorimpl(i + 1);
    }

    /* renamed from: inv-pVg5ArA, reason: not valid java name */
    private static final int m566invpVg5ArA(int i) {
        return m552constructorimpl(~i);
    }

    /* renamed from: minus-7apg3OU, reason: not valid java name */
    private static final int m567minus7apg3OU(int i, byte b) {
        return m552constructorimpl(i - m552constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: minus-VKZWuLQ, reason: not valid java name */
    private static final long m568minusVKZWuLQ(int i, long j) {
        return ULong.m631constructorimpl(ULong.m631constructorimpl(i & 4294967295L) - j);
    }

    /* renamed from: minus-WZ4Q5Ns, reason: not valid java name */
    private static final int m569minusWZ4Q5Ns(int i, int i2) {
        return m552constructorimpl(i - i2);
    }

    /* renamed from: minus-xj2QHRw, reason: not valid java name */
    private static final int m570minusxj2QHRw(int i, short s) {
        return m552constructorimpl(i - m552constructorimpl(65535 & s));
    }

    /* renamed from: mod-7apg3OU, reason: not valid java name */
    private static final byte m571mod7apg3OU(int i, byte b) {
        return UByte.m475constructorimpl((byte) UByte$$ExternalSyntheticBackport1.m(i, m552constructorimpl(b & UByte.MAX_VALUE)));
    }

    /* renamed from: mod-VKZWuLQ, reason: not valid java name */
    private static final long m572modVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport2.m(ULong.m631constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: mod-WZ4Q5Ns, reason: not valid java name */
    private static final int m573modWZ4Q5Ns(int i, int i2) {
        return UByte$$ExternalSyntheticBackport1.m(i, i2);
    }

    /* renamed from: mod-xj2QHRw, reason: not valid java name */
    private static final short m574modxj2QHRw(int i, short s) {
        return UShort.m738constructorimpl((short) UByte$$ExternalSyntheticBackport1.m(i, m552constructorimpl(65535 & s)));
    }

    /* renamed from: or-WZ4Q5Ns, reason: not valid java name */
    private static final int m575orWZ4Q5Ns(int i, int i2) {
        return m552constructorimpl(i | i2);
    }

    /* renamed from: plus-7apg3OU, reason: not valid java name */
    private static final int m576plus7apg3OU(int i, byte b) {
        return m552constructorimpl(m552constructorimpl(b & UByte.MAX_VALUE) + i);
    }

    /* renamed from: plus-VKZWuLQ, reason: not valid java name */
    private static final long m577plusVKZWuLQ(int i, long j) {
        return ULong.m631constructorimpl(ULong.m631constructorimpl(i & 4294967295L) + j);
    }

    /* renamed from: plus-WZ4Q5Ns, reason: not valid java name */
    private static final int m578plusWZ4Q5Ns(int i, int i2) {
        return m552constructorimpl(i + i2);
    }

    /* renamed from: plus-xj2QHRw, reason: not valid java name */
    private static final int m579plusxj2QHRw(int i, short s) {
        return m552constructorimpl(m552constructorimpl(65535 & s) + i);
    }

    /* renamed from: rangeTo-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m580rangeToWZ4Q5Ns(int i, int i2) {
        return new UIntRange(i, i2, null);
    }

    /* renamed from: rangeUntil-WZ4Q5Ns, reason: not valid java name */
    private static final UIntRange m581rangeUntilWZ4Q5Ns(int i, int i2) {
        return URangesKt.m1730untilJ1ME1BU(i, i2);
    }

    /* renamed from: rem-7apg3OU, reason: not valid java name */
    private static final int m582rem7apg3OU(int i, byte b) {
        return UByte$$ExternalSyntheticBackport1.m(i, m552constructorimpl(b & UByte.MAX_VALUE));
    }

    /* renamed from: rem-VKZWuLQ, reason: not valid java name */
    private static final long m583remVKZWuLQ(int i, long j) {
        return UByte$$ExternalSyntheticBackport2.m(ULong.m631constructorimpl(i & 4294967295L), j);
    }

    /* renamed from: rem-WZ4Q5Ns, reason: not valid java name */
    private static final int m584remWZ4Q5Ns(int i, int i2) {
        return UnsignedKt.m809uintRemainderJ1ME1BU(i, i2);
    }

    /* renamed from: rem-xj2QHRw, reason: not valid java name */
    private static final int m585remxj2QHRw(int i, short s) {
        return UByte$$ExternalSyntheticBackport1.m(i, m552constructorimpl(65535 & s));
    }

    /* renamed from: shl-pVg5ArA, reason: not valid java name */
    private static final int m586shlpVg5ArA(int i, int i2) {
        return m552constructorimpl(i << i2);
    }

    /* renamed from: shr-pVg5ArA, reason: not valid java name */
    private static final int m587shrpVg5ArA(int i, int i2) {
        return m552constructorimpl(i >>> i2);
    }

    /* renamed from: times-7apg3OU, reason: not valid java name */
    private static final int m588times7apg3OU(int i, byte b) {
        return m552constructorimpl(m552constructorimpl(b & UByte.MAX_VALUE) * i);
    }

    /* renamed from: times-VKZWuLQ, reason: not valid java name */
    private static final long m589timesVKZWuLQ(int i, long j) {
        return ULong.m631constructorimpl(ULong.m631constructorimpl(i & 4294967295L) * j);
    }

    /* renamed from: times-WZ4Q5Ns, reason: not valid java name */
    private static final int m590timesWZ4Q5Ns(int i, int i2) {
        return m552constructorimpl(i * i2);
    }

    /* renamed from: times-xj2QHRw, reason: not valid java name */
    private static final int m591timesxj2QHRw(int i, short s) {
        return m552constructorimpl(m552constructorimpl(65535 & s) * i);
    }

    /* renamed from: toByte-impl, reason: not valid java name */
    private static final byte m592toByteimpl(int i) {
        return (byte) i;
    }

    /* renamed from: toDouble-impl, reason: not valid java name */
    private static final double m593toDoubleimpl(int i) {
        return UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toFloat-impl, reason: not valid java name */
    private static final float m594toFloatimpl(int i) {
        return (float) UnsignedKt.uintToDouble(i);
    }

    /* renamed from: toInt-impl, reason: not valid java name */
    private static final int m595toIntimpl(int i) {
        return i;
    }

    /* renamed from: toLong-impl, reason: not valid java name */
    private static final long m596toLongimpl(int i) {
        return i & 4294967295L;
    }

    /* renamed from: toShort-impl, reason: not valid java name */
    private static final short m597toShortimpl(int i) {
        return (short) i;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m598toStringimpl(int i) {
        return String.valueOf(i & 4294967295L);
    }

    /* renamed from: toUByte-w2LRezQ, reason: not valid java name */
    private static final byte m599toUBytew2LRezQ(int i) {
        return UByte.m475constructorimpl((byte) i);
    }

    /* renamed from: toUInt-pVg5ArA, reason: not valid java name */
    private static final int m600toUIntpVg5ArA(int i) {
        return i;
    }

    /* renamed from: toULong-s-VKNKU, reason: not valid java name */
    private static final long m601toULongsVKNKU(int i) {
        return ULong.m631constructorimpl(i & 4294967295L);
    }

    /* renamed from: toUShort-Mh2AYeg, reason: not valid java name */
    private static final short m602toUShortMh2AYeg(int i) {
        return UShort.m738constructorimpl((short) i);
    }

    /* renamed from: xor-WZ4Q5Ns, reason: not valid java name */
    private static final int m603xorWZ4Q5Ns(int i, int i2) {
        return m552constructorimpl(i ^ i2);
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(UInt uInt) {
        return UnsignedKt.uintCompare(getData(), uInt.getData());
    }

    public boolean equals(Object other) {
        return m558equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m564hashCodeimpl(this.data);
    }

    public String toString() {
        return m598toStringimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getData() {
        return this.data;
    }
}
