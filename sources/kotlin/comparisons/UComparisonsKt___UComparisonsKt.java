package kotlin.comparisons;

import androidx.collection.MutableFloatFloatMap$$ExternalSyntheticBackport0;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.UByte$$ExternalSyntheticBackport4;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: _UComparisons.kt */
@Metadata(d1 = {"\u0000B\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001a\u001f\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\u001f\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b\r\u0010\u000e\u001a(\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a(\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b\u0012\u0010\u0013\u001a(\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b\u0014\u0010\u0015\u001a(\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b\u0016\u0010\u0017\u001a#\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a#\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b\u001d\u0010\u001e\u001a#\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b \u0010!\u001a#\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b#\u0010$\u001a\u001f\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0004\b&\u0010\u0005\u001a\u001f\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0006H\u0007¢\u0006\u0004\b'\u0010\b\u001a\u001f\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0007¢\u0006\u0004\b(\u0010\u000b\u001a\u001f\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0007¢\u0006\u0004\b)\u0010\u000e\u001a(\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0001H\u0087\b¢\u0006\u0004\b*\u0010\u0011\u001a(\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006H\u0087\b¢\u0006\u0004\b+\u0010\u0013\u001a(\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0087\b¢\u0006\u0004\b,\u0010\u0015\u001a(\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\fH\u0087\b¢\u0006\u0004\b-\u0010\u0017\u001a#\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u0018\u001a\u00020\u0019\"\u00020\u0001H\u0007¢\u0006\u0004\b.\u0010\u001b\u001a#\u0010%\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u00062\n\u0010\u0018\u001a\u00020\u001c\"\u00020\u0006H\u0007¢\u0006\u0004\b/\u0010\u001e\u001a#\u0010%\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u0018\u001a\u00020\u001f\"\u00020\tH\u0007¢\u0006\u0004\b0\u0010!\u001a#\u0010%\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u0018\u001a\u00020\"\"\u00020\fH\u0007¢\u0006\u0004\b1\u0010$¨\u00062"}, d2 = {"maxOf", "Lkotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lkotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "c", "maxOf-WZ9TVnA", "(III)I", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", "other", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-J1ME1BU", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes.dex */
public class UComparisonsKt___UComparisonsKt {
    /* renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m1642maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) >= 0 ? s : s2;
    }

    /* renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static final int m1643maxOfJ1ME1BU(int i, int i2) {
        return UByte$$ExternalSyntheticBackport4.m(i, i2) >= 0 ? i : i2;
    }

    /* renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m1644maxOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & UByte.MAX_VALUE, b2 & UByte.MAX_VALUE) >= 0 ? b : b2;
    }

    /* renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m1645maxOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i2 = i;
        int m613getSizeimpl = UIntArray.m613getSizeimpl(other);
        for (int i3 = 0; i3 < m613getSizeimpl; i3++) {
            i2 = UComparisonsKt.m1643maxOfJ1ME1BU(i2, UIntArray.m612getpVg5ArA(other, i3));
        }
        return i2;
    }

    /* renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m1646maxOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long j2 = j;
        int m692getSizeimpl = ULongArray.m692getSizeimpl(other);
        for (int i = 0; i < m692getSizeimpl; i++) {
            j2 = UComparisonsKt.m1651maxOfeb3DHEI(j2, ULongArray.m691getsVKNKU(other, i));
        }
        return j2;
    }

    /* renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m1647maxOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m1642maxOf5PvTz6A(s, UComparisonsKt.m1642maxOf5PvTz6A(s2, s3));
    }

    /* renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m1648maxOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m1643maxOfJ1ME1BU(i, UComparisonsKt.m1643maxOfJ1ME1BU(i2, i3));
    }

    /* renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m1649maxOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte b2 = b;
        int m534getSizeimpl = UByteArray.m534getSizeimpl(other);
        for (int i = 0; i < m534getSizeimpl; i++) {
            b2 = UComparisonsKt.m1644maxOfKr8caGY(b2, UByteArray.m533getw2LRezQ(other, i));
        }
        return b2;
    }

    /* renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m1650maxOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m1644maxOfKr8caGY(b, UComparisonsKt.m1644maxOfKr8caGY(b2, b3));
    }

    /* renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static final long m1651maxOfeb3DHEI(long j, long j2) {
        return MutableFloatFloatMap$$ExternalSyntheticBackport0.m(j, j2) >= 0 ? j : j2;
    }

    /* renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m1652maxOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m1651maxOfeb3DHEI(j, UComparisonsKt.m1651maxOfeb3DHEI(j2, j3));
    }

    /* renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m1653maxOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short s2 = s;
        int m797getSizeimpl = UShortArray.m797getSizeimpl(other);
        for (int i = 0; i < m797getSizeimpl; i++) {
            s2 = UComparisonsKt.m1642maxOf5PvTz6A(s2, UShortArray.m796getMh2AYeg(other, i));
        }
        return s2;
    }

    /* renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m1654minOf5PvTz6A(short s, short s2) {
        return Intrinsics.compare(s & UShort.MAX_VALUE, 65535 & s2) <= 0 ? s : s2;
    }

    /* renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static final int m1655minOfJ1ME1BU(int i, int i2) {
        return UByte$$ExternalSyntheticBackport4.m(i, i2) <= 0 ? i : i2;
    }

    /* renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m1656minOfKr8caGY(byte b, byte b2) {
        return Intrinsics.compare(b & UByte.MAX_VALUE, b2 & UByte.MAX_VALUE) <= 0 ? b : b2;
    }

    /* renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m1657minOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int i2 = i;
        int m613getSizeimpl = UIntArray.m613getSizeimpl(other);
        for (int i3 = 0; i3 < m613getSizeimpl; i3++) {
            i2 = UComparisonsKt.m1655minOfJ1ME1BU(i2, UIntArray.m612getpVg5ArA(other, i3));
        }
        return i2;
    }

    /* renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m1658minOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        long j2 = j;
        int m692getSizeimpl = ULongArray.m692getSizeimpl(other);
        for (int i = 0; i < m692getSizeimpl; i++) {
            j2 = UComparisonsKt.m1663minOfeb3DHEI(j2, ULongArray.m691getsVKNKU(other, i));
        }
        return j2;
    }

    /* renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m1659minOfVKSA0NQ(short s, short s2, short s3) {
        return UComparisonsKt.m1654minOf5PvTz6A(s, UComparisonsKt.m1654minOf5PvTz6A(s2, s3));
    }

    /* renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m1660minOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m1655minOfJ1ME1BU(i, UComparisonsKt.m1655minOfJ1ME1BU(i2, i3));
    }

    /* renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m1661minOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        byte b2 = b;
        int m534getSizeimpl = UByteArray.m534getSizeimpl(other);
        for (int i = 0; i < m534getSizeimpl; i++) {
            b2 = UComparisonsKt.m1656minOfKr8caGY(b2, UByteArray.m533getw2LRezQ(other, i));
        }
        return b2;
    }

    /* renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m1662minOfb33U2AM(byte b, byte b2, byte b3) {
        return UComparisonsKt.m1656minOfKr8caGY(b, UComparisonsKt.m1656minOfKr8caGY(b2, b3));
    }

    /* renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static final long m1663minOfeb3DHEI(long j, long j2) {
        return MutableFloatFloatMap$$ExternalSyntheticBackport0.m(j, j2) <= 0 ? j : j2;
    }

    /* renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m1664minOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m1663minOfeb3DHEI(j, UComparisonsKt.m1663minOfeb3DHEI(j2, j3));
    }

    /* renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m1665minOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        short s2 = s;
        int m797getSizeimpl = UShortArray.m797getSizeimpl(other);
        for (int i = 0; i < m797getSizeimpl; i++) {
            s2 = UComparisonsKt.m1654minOf5PvTz6A(s2, UShortArray.m796getMh2AYeg(other, i));
        }
        return s2;
    }
}
