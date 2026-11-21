package kotlin.collections;

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

/* compiled from: UArraySorting.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0006\u0010\u0007\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\n\u0010\u000b\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\r\u0010\u000e\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u000f\u0010\u0010\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0012\u0010\u0013\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0014\u0010\u0015\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0017\u0010\u0018\u001a'\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0003¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001e\u0010\u000b\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b\u001f\u0010\u0010\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b \u0010\u0015\u001a'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0001¢\u0006\u0004\b!\u0010\u001a¨\u0006\""}, d2 = {"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class UArraySortingKt {
    /* renamed from: partition--nroSd4, reason: not valid java name */
    private static final int m915partitionnroSd4(long[] jArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        long m691getsVKNKU = ULongArray.m691getsVKNKU(jArr, (i + i2) / 2);
        while (i3 <= i4) {
            while (MutableFloatFloatMap$$ExternalSyntheticBackport0.m(ULongArray.m691getsVKNKU(jArr, i3), m691getsVKNKU) < 0) {
                i3++;
            }
            while (MutableFloatFloatMap$$ExternalSyntheticBackport0.m(ULongArray.m691getsVKNKU(jArr, i4), m691getsVKNKU) > 0) {
                i4--;
            }
            if (i3 <= i4) {
                long m691getsVKNKU2 = ULongArray.m691getsVKNKU(jArr, i3);
                ULongArray.m696setk8EXiF4(jArr, i3, ULongArray.m691getsVKNKU(jArr, i4));
                ULongArray.m696setk8EXiF4(jArr, i4, m691getsVKNKU2);
                i3++;
                i4--;
            }
        }
        return i3;
    }

    /* renamed from: partition-4UcCI2c, reason: not valid java name */
    private static final int m916partition4UcCI2c(byte[] bArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        byte m533getw2LRezQ = UByteArray.m533getw2LRezQ(bArr, (i + i2) / 2);
        while (i3 <= i4) {
            while (Intrinsics.compare(UByteArray.m533getw2LRezQ(bArr, i3) & UByte.MAX_VALUE, m533getw2LRezQ & UByte.MAX_VALUE) < 0) {
                i3++;
            }
            while (Intrinsics.compare(UByteArray.m533getw2LRezQ(bArr, i4) & UByte.MAX_VALUE, m533getw2LRezQ & UByte.MAX_VALUE) > 0) {
                i4--;
            }
            if (i3 <= i4) {
                byte m533getw2LRezQ2 = UByteArray.m533getw2LRezQ(bArr, i3);
                UByteArray.m538setVurrAj0(bArr, i3, UByteArray.m533getw2LRezQ(bArr, i4));
                UByteArray.m538setVurrAj0(bArr, i4, m533getw2LRezQ2);
                i3++;
                i4--;
            }
        }
        return i3;
    }

    /* renamed from: partition-Aa5vz7o, reason: not valid java name */
    private static final int m917partitionAa5vz7o(short[] sArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        short m796getMh2AYeg = UShortArray.m796getMh2AYeg(sArr, (i + i2) / 2);
        while (i3 <= i4) {
            while (Intrinsics.compare(UShortArray.m796getMh2AYeg(sArr, i3) & UShort.MAX_VALUE, m796getMh2AYeg & UShort.MAX_VALUE) < 0) {
                i3++;
            }
            while (Intrinsics.compare(UShortArray.m796getMh2AYeg(sArr, i4) & UShort.MAX_VALUE, m796getMh2AYeg & UShort.MAX_VALUE) > 0) {
                i4--;
            }
            if (i3 <= i4) {
                short m796getMh2AYeg2 = UShortArray.m796getMh2AYeg(sArr, i3);
                UShortArray.m801set01HTLdE(sArr, i3, UShortArray.m796getMh2AYeg(sArr, i4));
                UShortArray.m801set01HTLdE(sArr, i4, m796getMh2AYeg2);
                i3++;
                i4--;
            }
        }
        return i3;
    }

    /* renamed from: partition-oBK06Vg, reason: not valid java name */
    private static final int m918partitionoBK06Vg(int[] iArr, int i, int i2) {
        int i3 = i;
        int i4 = i2;
        int m612getpVg5ArA = UIntArray.m612getpVg5ArA(iArr, (i + i2) / 2);
        while (i3 <= i4) {
            while (UByte$$ExternalSyntheticBackport4.m(UIntArray.m612getpVg5ArA(iArr, i3), m612getpVg5ArA) < 0) {
                i3++;
            }
            while (UByte$$ExternalSyntheticBackport4.m(UIntArray.m612getpVg5ArA(iArr, i4), m612getpVg5ArA) > 0) {
                i4--;
            }
            if (i3 <= i4) {
                int m612getpVg5ArA2 = UIntArray.m612getpVg5ArA(iArr, i3);
                UIntArray.m617setVXSXFK8(iArr, i3, UIntArray.m612getpVg5ArA(iArr, i4));
                UIntArray.m617setVXSXFK8(iArr, i4, m612getpVg5ArA2);
                i3++;
                i4--;
            }
        }
        return i3;
    }

    /* renamed from: quickSort--nroSd4, reason: not valid java name */
    private static final void m919quickSortnroSd4(long[] jArr, int i, int i2) {
        int m915partitionnroSd4 = m915partitionnroSd4(jArr, i, i2);
        if (i < m915partitionnroSd4 - 1) {
            m919quickSortnroSd4(jArr, i, m915partitionnroSd4 - 1);
        }
        if (m915partitionnroSd4 < i2) {
            m919quickSortnroSd4(jArr, m915partitionnroSd4, i2);
        }
    }

    /* renamed from: quickSort-4UcCI2c, reason: not valid java name */
    private static final void m920quickSort4UcCI2c(byte[] bArr, int i, int i2) {
        int m916partition4UcCI2c = m916partition4UcCI2c(bArr, i, i2);
        if (i < m916partition4UcCI2c - 1) {
            m920quickSort4UcCI2c(bArr, i, m916partition4UcCI2c - 1);
        }
        if (m916partition4UcCI2c < i2) {
            m920quickSort4UcCI2c(bArr, m916partition4UcCI2c, i2);
        }
    }

    /* renamed from: quickSort-Aa5vz7o, reason: not valid java name */
    private static final void m921quickSortAa5vz7o(short[] sArr, int i, int i2) {
        int m917partitionAa5vz7o = m917partitionAa5vz7o(sArr, i, i2);
        if (i < m917partitionAa5vz7o - 1) {
            m921quickSortAa5vz7o(sArr, i, m917partitionAa5vz7o - 1);
        }
        if (m917partitionAa5vz7o < i2) {
            m921quickSortAa5vz7o(sArr, m917partitionAa5vz7o, i2);
        }
    }

    /* renamed from: quickSort-oBK06Vg, reason: not valid java name */
    private static final void m922quickSortoBK06Vg(int[] iArr, int i, int i2) {
        int m918partitionoBK06Vg = m918partitionoBK06Vg(iArr, i, i2);
        if (i < m918partitionoBK06Vg - 1) {
            m922quickSortoBK06Vg(iArr, i, m918partitionoBK06Vg - 1);
        }
        if (m918partitionoBK06Vg < i2) {
            m922quickSortoBK06Vg(iArr, m918partitionoBK06Vg, i2);
        }
    }

    /* renamed from: sortArray--nroSd4, reason: not valid java name */
    public static final void m923sortArraynroSd4(long[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m919quickSortnroSd4(array, i, i2 - 1);
    }

    /* renamed from: sortArray-4UcCI2c, reason: not valid java name */
    public static final void m924sortArray4UcCI2c(byte[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m920quickSort4UcCI2c(array, i, i2 - 1);
    }

    /* renamed from: sortArray-Aa5vz7o, reason: not valid java name */
    public static final void m925sortArrayAa5vz7o(short[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m921quickSortAa5vz7o(array, i, i2 - 1);
    }

    /* renamed from: sortArray-oBK06Vg, reason: not valid java name */
    public static final void m926sortArrayoBK06Vg(int[] array, int i, int i2) {
        Intrinsics.checkNotNullParameter(array, "array");
        m922quickSortoBK06Vg(array, i, i2 - 1);
    }
}
