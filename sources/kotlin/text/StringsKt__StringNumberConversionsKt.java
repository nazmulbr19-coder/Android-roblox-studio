package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: StringNumberConversions.kt */
@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0002\u001a\u0013\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0003\u001a\u001b\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u0002H\u0007¢\u0006\u0002\u0010\t\u001a\u001b\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\n\u001a\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\u0002H\u0007¢\u0006\u0002\u0010\f\u001a\u001b\u0010\u000b\u001a\u0004\u0018\u00010\u0005*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\r\u001a\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u0002H\u0007¢\u0006\u0002\u0010\u0010\u001a\u001b\u0010\u000e\u001a\u0004\u0018\u00010\u000f*\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0000¨\u0006\u0015"}, d2 = {"toByteOrNull", "", "", "(Ljava/lang/String;)Ljava/lang/Byte;", "radix", "", "(Ljava/lang/String;I)Ljava/lang/Byte;", "toShortOrNull", "", "(Ljava/lang/String;)Ljava/lang/Short;", "(Ljava/lang/String;I)Ljava/lang/Short;", "toIntOrNull", "(Ljava/lang/String;)Ljava/lang/Integer;", "(Ljava/lang/String;I)Ljava/lang/Integer;", "toLongOrNull", "", "(Ljava/lang/String;)Ljava/lang/Long;", "(Ljava/lang/String;I)Ljava/lang/Long;", "numberFormatError", "", "input", "kotlin-stdlib"}, k = 5, mv = {2, 2, 0}, xi = 49, xs = "kotlin/text/StringsKt")
/* loaded from: classes.dex */
public class StringsKt__StringNumberConversionsKt extends StringsKt__StringNumberConversionsJVMKt {
    public static final Void numberFormatError(String input) {
        Intrinsics.checkNotNullParameter(input, "input");
        throw new NumberFormatException("Invalid number format: '" + input + '\'');
    }

    public static final Byte toByteOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.toByteOrNull(str, 10);
    }

    public static final Byte toByteOrNull(String str, int i) {
        int intValue;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = StringsKt.toIntOrNull(str, i);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -128 || intValue > 127) {
            return null;
        }
        return Byte.valueOf((byte) intValue);
    }

    public static final Integer toIntOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.toIntOrNull(str, 10);
    }

    public static final Integer toIntOrNull(String str, int i) {
        int i2;
        boolean z;
        int i3;
        int i4;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i);
        int length = str.length();
        if (length == 0) {
            return null;
        }
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) >= 0) {
            i2 = 0;
            z = false;
            i3 = -2147483647;
        } else {
            if (length == 1) {
                return null;
            }
            i2 = 1;
            switch (charAt) {
                case '+':
                    z = false;
                    i3 = -2147483647;
                    break;
                case ',':
                default:
                    return null;
                case '-':
                    z = true;
                    i3 = Integer.MIN_VALUE;
                    break;
            }
        }
        int i5 = -59652323;
        int i6 = 0;
        for (int i7 = i2; i7 < length; i7++) {
            int digitOf = CharsKt.digitOf(str.charAt(i7), i);
            if (digitOf < 0) {
                return null;
            }
            if ((i6 < i5 && (i5 != -59652323 || i6 < (i5 = i3 / i))) || (i4 = i6 * i) < i3 + digitOf) {
                return null;
            }
            i6 = i4 - digitOf;
        }
        return z ? Integer.valueOf(i6) : Integer.valueOf(-i6);
    }

    public static final Long toLongOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.toLongOrNull(str, 10);
    }

    public static final Long toLongOrNull(String str, int i) {
        int i2;
        boolean z;
        long j;
        int i3;
        boolean z2;
        Intrinsics.checkNotNullParameter(str, "<this>");
        CharsKt.checkRadix(i);
        int length = str.length();
        Long l = null;
        if (length == 0) {
            return null;
        }
        char charAt = str.charAt(0);
        if (Intrinsics.compare((int) charAt, 48) >= 0) {
            i2 = 0;
            z = false;
            j = -9223372036854775807L;
        } else if (length != 1) {
            i2 = 1;
            switch (charAt) {
                case '+':
                    z = false;
                    j = -9223372036854775807L;
                    break;
                case ',':
                default:
                    return null;
                case '-':
                    z = true;
                    j = Long.MIN_VALUE;
                    break;
            }
        } else {
            return null;
        }
        long j2 = -256204778801521550L;
        long j3 = 0;
        int i4 = i2;
        while (i4 < length) {
            Long l2 = l;
            int digitOf = CharsKt.digitOf(str.charAt(i4), i);
            if (digitOf < 0) {
                return l2;
            }
            if (j3 >= j2) {
                i3 = i2;
                z2 = z;
            } else {
                if (j2 != -256204778801521550L) {
                    return l2;
                }
                i3 = i2;
                z2 = z;
                long j4 = j / i;
                if (j3 < j4) {
                    return l2;
                }
                j2 = j4;
            }
            long j5 = j3 * i;
            if (j5 < digitOf + j) {
                return l2;
            }
            j3 = j5 - digitOf;
            i4++;
            l = l2;
            i2 = i3;
            z = z2;
        }
        return z ? Long.valueOf(j3) : Long.valueOf(-j3);
    }

    public static final Short toShortOrNull(String str) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        return StringsKt.toShortOrNull(str, 10);
    }

    public static final Short toShortOrNull(String str, int i) {
        int intValue;
        Intrinsics.checkNotNullParameter(str, "<this>");
        Integer intOrNull = StringsKt.toIntOrNull(str, i);
        if (intOrNull == null || (intValue = intOrNull.intValue()) < -32768 || intValue > 32767) {
            return null;
        }
        return Short.valueOf((short) intValue);
    }
}
