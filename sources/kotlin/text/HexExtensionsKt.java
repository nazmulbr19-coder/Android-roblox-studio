package kotlin.text;

import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.UByte;
import kotlin.ULong;
import kotlin.collections.AbstractList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.HexFormat;

/* compiled from: HexExtensions.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0019\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u0005\n\u0002\b\t\n\u0002\u0010\n\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0010\u0001\n\u0000\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010\u000b\u001a\u00020\u0001*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a,\u0010\u0012\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a,\u0010\u0016\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a,\u0010\u0017\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a,\u0010\u0018\u001a\u00020\u0001*\u00020\f2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0004H\u0002\u001a<\u0010\u0019\u001a\u00020\u0010*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002\u001a,\u0010\u0019\u001a\u00020\u0010*\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002\u001a(\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0002\u001a@\u0010 \u001a\u00020\u00102\u0006\u0010!\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0000\u001a\u0010\u0010(\u001a\u00020\u00102\u0006\u0010)\u001a\u00020*H\u0002\u001a\u0016\u0010+\u001a\u00020\f*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010+\u001a\u00020\f*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a&\u0010,\u001a\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a&\u0010-\u001a\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a&\u0010.\u001a\u0004\u0018\u00010\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a$\u0010/\u001a\u00020\f*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0002\u001a\u0014\u00100\u001a\u000201*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0002\u001a@\u00102\u001a\u00020\u00102\u0006\u00103\u001a\u00020\u00102\u0006\u0010%\u001a\u00020\u00102\u0006\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020\u00102\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0010H\u0000\u001a \u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0010H\u0002\u001a \u00108\u001a\u00020*2\u0006\u00104\u001a\u00020*2\u0006\u00105\u001a\u00020*2\u0006\u00107\u001a\u00020\u0010H\u0002\u001a\u001c\u00109\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u0002012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010:\u001a\u000201*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010:\u001a\u000201*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020;2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010<\u001a\u00020;*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010<\u001a\u00020;*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0002\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010=\u001a\u00020\u0010*\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010=\u001a\u00020\u0010*\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a\u0016\u0010\u000b\u001a\u00020\u0001*\u00020*2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a\u0016\u0010>\u001a\u00020**\u00020\u00012\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007\u001a*\u0010>\u001a\u00020**\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0000\u001a$\u0010?\u001a\u00020\u0001*\u00020*2\u0006\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u00012\u0006\u0010C\u001a\u00020\u0010H\u0002\u001a\u001c\u0010D\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0010H\u0002\u001a,\u0010E\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a,\u0010G\u001a\u00020**\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a<\u0010H\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020M2\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a$\u0010N\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010F\u001a\u00020\u0010H\u0002\u001a\u001c\u0010O\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u001c\u0010P\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a\u001c\u0010Q\u001a\u00020**\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002\u001a5\u0010R\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00012\u0006\u0010L\u001a\u00020M2\u0006\u0010T\u001a\u00020\u0001H\u0082\b\u001a\u0015\u0010U\u001a\u00020\u0010*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0082\b\u001a\u0015\u0010V\u001a\u00020**\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0082\b\u001a,\u0010W\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010X\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u0010H\u0002\u001a,\u0010Z\u001a\u00020I*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010S\u001a\u00020\u00012\u0006\u0010T\u001a\u00020\u0001H\u0002\u001a,\u0010[\u001a\u00020I*\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010J\u001a\u00020\u00012\u0006\u0010K\u001a\u00020\u0001H\u0002\u001a\u0014\u0010\\\u001a\u00020]*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0010H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\u00020\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006^"}, d2 = {"LOWER_CASE_HEX_DIGITS", "", "UPPER_CASE_HEX_DIGITS", "BYTE_TO_LOWER_CASE_HEX_DIGITS", "", "getBYTE_TO_LOWER_CASE_HEX_DIGITS", "()[I", "BYTE_TO_UPPER_CASE_HEX_DIGITS", "HEX_DIGITS_TO_DECIMAL", "HEX_DIGITS_TO_LONG_DECIMAL", "", "toHexString", "", "format", "Lkotlin/text/HexFormat;", "startIndex", "", "endIndex", "toHexStringNoLineAndGroupSeparator", "bytesFormat", "Lkotlin/text/HexFormat$BytesHexFormat;", "byteToDigits", "toHexStringShortByteSeparatorNoPrefixAndSuffix", "toHexStringNoLineAndGroupSeparatorSlowPath", "toHexStringSlowPath", "formatByteAt", "index", "bytePrefix", "byteSuffix", "destination", "", "destinationOffset", "formattedStringLength", "numberOfBytes", "byteSeparatorLength", "bytePrefixLength", "byteSuffixLength", "bytesPerLine", "bytesPerGroup", "groupSeparatorLength", "checkFormatLength", "formatLength", "", "hexToByteArray", "hexToByteArrayNoLineAndGroupSeparator", "hexToByteArrayShortByteSeparatorNoPrefixAndSuffix", "hexToByteArrayNoLineAndGroupSeparatorSlowPath", "hexToByteArraySlowPath", "parseByteAt", "", "parsedByteArrayMaxSize", "stringLength", "charsPerSet", "charsPerElement", "elementsPerSet", "elementSeparatorLength", "wholeElementsPerSet", "checkNewLineAt", "hexToByte", "", "hexToShort", "hexToInt", "hexToLong", "toHexStringImpl", "numberFormat", "Lkotlin/text/HexFormat$NumberHexFormat;", "digits", "bits", "toCharArrayIfNotEmpty", "hexToIntImpl", "typeHexLength", "hexToLongImpl", "checkPrefixSuffixNumberOfDigits", "", "prefix", "suffix", "ignoreCase", "", "checkNumberOfDigits", "checkZeroDigits", "parseInt", "parseLong", "checkContainsAt", "part", "partName", "decimalFromHexDigitAt", "longDecimalFromHexDigitAt", "throwInvalidNumberOfDigits", "specifier", "expected", "throwNotContainedAt", "throwInvalidPrefixSuffix", "throwInvalidDigitAt", "", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class HexExtensionsKt {
    private static final int[] BYTE_TO_LOWER_CASE_HEX_DIGITS;
    private static final int[] BYTE_TO_UPPER_CASE_HEX_DIGITS;
    private static final int[] HEX_DIGITS_TO_DECIMAL;
    private static final long[] HEX_DIGITS_TO_LONG_DECIMAL;
    private static final String LOWER_CASE_HEX_DIGITS = "0123456789abcdef";
    private static final String UPPER_CASE_HEX_DIGITS = "0123456789ABCDEF";

    static {
        int[] iArr = new int[256];
        int i = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            iArr[i2] = (LOWER_CASE_HEX_DIGITS.charAt(i2 >> 4) << '\b') | LOWER_CASE_HEX_DIGITS.charAt(i2 & 15);
        }
        BYTE_TO_LOWER_CASE_HEX_DIGITS = iArr;
        int[] iArr2 = new int[256];
        for (int i3 = 0; i3 < 256; i3++) {
            iArr2[i3] = (UPPER_CASE_HEX_DIGITS.charAt(i3 >> 4) << '\b') | UPPER_CASE_HEX_DIGITS.charAt(i3 & 15);
        }
        BYTE_TO_UPPER_CASE_HEX_DIGITS = iArr2;
        int[] iArr3 = new int[256];
        for (int i4 = 0; i4 < 256; i4++) {
            iArr3[i4] = -1;
        }
        int i5 = 0;
        int i6 = 0;
        while (i6 < r7.length()) {
            iArr3[r7.charAt(i6)] = i5;
            i6++;
            i5++;
        }
        int i7 = 0;
        int i8 = 0;
        while (i8 < r7.length()) {
            iArr3[r7.charAt(i8)] = i7;
            i8++;
            i7++;
        }
        HEX_DIGITS_TO_DECIMAL = iArr3;
        long[] jArr = new long[256];
        for (int i9 = 0; i9 < 256; i9++) {
            jArr[i9] = -1;
        }
        int i10 = 0;
        int i11 = 0;
        while (i11 < r4.length()) {
            jArr[r4.charAt(i11)] = i10;
            i11++;
            i10++;
        }
        int i12 = 0;
        while (i < r4.length()) {
            jArr[r4.charAt(i)] = i12;
            i++;
            i12++;
        }
        HEX_DIGITS_TO_LONG_DECIMAL = jArr;
    }

    private static final long charsPerSet(long j, int i, int i2) {
        if (i > 0) {
            return (i * j) + (i2 * (i - 1));
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private static final int checkContainsAt(String str, int i, int i2, String str2, boolean z, String str3) {
        if (str2.length() == 0) {
            return i;
        }
        int length = str2.length();
        for (int i3 = 0; i3 < length; i3++) {
            if (!CharsKt.equals(str2.charAt(i3), str.charAt(i + i3), z)) {
                throwNotContainedAt(str, i, i2, str2, str3);
            }
        }
        return str2.length() + i;
    }

    private static final int checkFormatLength(long j) {
        boolean z = false;
        if (0 <= j && j <= 2147483647L) {
            z = true;
        }
        if (z) {
            return (int) j;
        }
        throw new IllegalArgumentException("The resulting string length is too big: " + ((Object) ULong.m677toStringimpl(ULong.m631constructorimpl(j))));
    }

    private static final int checkNewLineAt(String str, int i, int i2) {
        if (str.charAt(i) == '\r') {
            return (i + 1 >= i2 || str.charAt(i + 1) != '\n') ? i + 1 : i + 2;
        }
        if (str.charAt(i) == '\n') {
            return i + 1;
        }
        throw new NumberFormatException("Expected a new line at index " + i + ", but was " + str.charAt(i));
    }

    private static final void checkNumberOfDigits(String str, int i, int i2, int i3) {
        int i4 = i2 - i;
        if (i4 < 1) {
            throwInvalidNumberOfDigits(str, i, i2, "at least", 1);
        } else if (i4 > i3) {
            checkZeroDigits(str, i, (i + i4) - i3);
        }
    }

    private static final void checkPrefixSuffixNumberOfDigits(String str, int i, int i2, String str2, String str3, boolean z, int i3) {
        int length;
        if ((i2 - i) - str2.length() <= str3.length()) {
            throwInvalidPrefixSuffix(str, i, i2, str2, str3);
        }
        if (str2.length() == 0) {
            length = i;
        } else {
            int length2 = str2.length();
            for (int i4 = 0; i4 < length2; i4++) {
                if (!CharsKt.equals(str2.charAt(i4), str.charAt(i + i4), z)) {
                    throwNotContainedAt(str, i, i2, str2, "prefix");
                }
            }
            length = str2.length() + i;
        }
        int length3 = i2 - str3.length();
        if (!(str3.length() == 0)) {
            int length4 = str3.length();
            for (int i5 = 0; i5 < length4; i5++) {
                if (!CharsKt.equals(str3.charAt(i5), str.charAt(length3 + i5), z)) {
                    throwNotContainedAt(str, length3, i2, str3, "suffix");
                }
            }
            str3.length();
        }
        checkNumberOfDigits(str, length, length3, i3);
    }

    private static final void checkZeroDigits(String str, int i, int i2) {
        for (int i3 = i; i3 < i2; i3++) {
            if (str.charAt(i3) != '0') {
                throw new NumberFormatException("Expected the hexadecimal digit '0' at index " + i3 + ", but was '" + str.charAt(i3) + "'.\nThe result won't fit the type being parsed.");
            }
        }
    }

    private static final int decimalFromHexDigitAt(String str, int i) {
        char charAt = str.charAt(i);
        if ((charAt >>> '\b') == 0 && HEX_DIGITS_TO_DECIMAL[charAt] >= 0) {
            return HEX_DIGITS_TO_DECIMAL[charAt];
        }
        throwInvalidDigitAt(str, i);
        throw new KotlinNothingValueException();
    }

    private static final int formatByteAt(byte[] bArr, int i, String str, String str2, int[] iArr, char[] cArr, int i2) {
        return toCharArrayIfNotEmpty(str2, cArr, formatByteAt(bArr, i, iArr, cArr, toCharArrayIfNotEmpty(str, cArr, i2)));
    }

    private static final int formatByteAt(byte[] bArr, int i, int[] iArr, char[] cArr, int i2) {
        int i3 = iArr[bArr[i] & UByte.MAX_VALUE];
        cArr[i2] = (char) (i3 >> 8);
        cArr[i2 + 1] = (char) (i3 & 255);
        return i2 + 2;
    }

    private static final int formattedStringLength(int i, int i2, int i3, int i4) {
        if (i > 0) {
            return checkFormatLength((i * (((i3 + 2) + i4) + i2)) - i2);
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public static final int formattedStringLength(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        if (!(i > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i8 = (i - 1) / i2;
        int i9 = (i2 - 1) / i3;
        int i10 = i % i2;
        if (i10 == 0) {
            i10 = i2;
        }
        return checkFormatLength(i8 + (((i8 * i9) + ((i10 - 1) / i3)) * i4) + ((((i - 1) - i8) - r6) * i5) + (i * (i6 + 2 + i7)));
    }

    public static final int[] getBYTE_TO_LOWER_CASE_HEX_DIGITS() {
        return BYTE_TO_LOWER_CASE_HEX_DIGITS;
    }

    private static final byte hexToByte(String str, int i, int i2, HexFormat hexFormat) {
        return (byte) hexToIntImpl(str, i, i2, hexFormat, 2);
    }

    public static final byte hexToByte(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByte(str, 0, str.length(), format);
    }

    static /* synthetic */ byte hexToByte$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, i, i2, hexFormat);
    }

    public static /* synthetic */ byte hexToByte$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByte(str, hexFormat);
    }

    private static final byte[] hexToByteArray(String str, int i, int i2, HexFormat hexFormat) {
        byte[] hexToByteArrayNoLineAndGroupSeparator;
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        if (i == i2) {
            return new byte[0];
        }
        HexFormat.BytesHexFormat bytes = hexFormat.getBytes();
        return (!bytes.getNoLineAndGroupSeparator() || (hexToByteArrayNoLineAndGroupSeparator = hexToByteArrayNoLineAndGroupSeparator(str, i, i2, bytes)) == null) ? hexToByteArraySlowPath(str, i, i2, bytes) : hexToByteArrayNoLineAndGroupSeparator;
    }

    public static final byte[] hexToByteArray(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToByteArray(str, 0, str.length(), format);
    }

    static /* synthetic */ byte[] hexToByteArray$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, i, i2, hexFormat);
    }

    public static /* synthetic */ byte[] hexToByteArray$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToByteArray(str, hexFormat);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparator(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        return bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix() ? hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(str, i, i2, bytesHexFormat) : hexToByteArrayNoLineAndGroupSeparatorSlowPath(str, i, i2, bytesHexFormat);
    }

    private static final byte[] hexToByteArrayNoLineAndGroupSeparatorSlowPath(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        int length;
        String str2;
        String str3;
        int i3;
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        int length2 = byteSeparator.length();
        long length3 = bytePrefix.length() + 2 + byteSuffix.length() + length2;
        long j = i2 - i;
        int i4 = (int) ((length2 + j) / length3);
        if ((i4 * length3) - length2 != j) {
            return null;
        }
        boolean ignoreCase = bytesHexFormat.getIgnoreCase();
        byte[] bArr = new byte[i4];
        if (bytePrefix.length() == 0) {
            length = i;
        } else {
            int length4 = bytePrefix.length();
            int i5 = 0;
            while (i5 < length4) {
                int i6 = length4;
                if (!CharsKt.equals(bytePrefix.charAt(i5), str.charAt(i + i5), ignoreCase)) {
                    throwNotContainedAt(str, i, i2, bytePrefix, "byte prefix");
                }
                i5++;
                length4 = i6;
            }
            length = bytePrefix.length() + i;
        }
        String str4 = byteSuffix + byteSeparator + bytePrefix;
        int i7 = 0;
        int i8 = i4 - 1;
        while (i7 < i8) {
            bArr[i7] = parseByteAt(str, length);
            int i9 = length + 2;
            String str5 = str;
            if (str4.length() == 0) {
                str2 = bytePrefix;
                str3 = byteSeparator;
                i3 = i7;
            } else {
                str2 = bytePrefix;
                int length5 = str4.length();
                str3 = byteSeparator;
                int i10 = 0;
                while (i10 < length5) {
                    int i11 = length5;
                    int i12 = i10;
                    int i13 = i7;
                    String str6 = str5;
                    if (!CharsKt.equals(str4.charAt(i10), str6.charAt(i9 + i12), ignoreCase)) {
                        throwNotContainedAt(str6, i9, i2, str4, "byte suffix + byte separator + byte prefix");
                    }
                    i10 = i12 + 1;
                    str5 = str6;
                    length5 = i11;
                    i7 = i13;
                }
                i3 = i7;
                i9 = str4.length() + i9;
            }
            length = i9;
            i7 = i3 + 1;
            byteSeparator = str3;
            bytePrefix = str2;
        }
        bArr[i4 - 1] = parseByteAt(str, length);
        int i14 = length + 2;
        if (!(byteSuffix.length() == 0)) {
            int i15 = 0;
            int length6 = byteSuffix.length();
            while (i15 < length6) {
                int i16 = length;
                if (!CharsKt.equals(byteSuffix.charAt(i15), str.charAt(i14 + i15), ignoreCase)) {
                    throwNotContainedAt(str, i14, i2, byteSuffix, "byte suffix");
                }
                i15++;
                length = i16;
            }
            byteSuffix.length();
        }
        return bArr;
    }

    private static final byte[] hexToByteArrayShortByteSeparatorNoPrefixAndSuffix(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        int i3;
        int length = bytesHexFormat.getByteSeparator().length();
        boolean z = false;
        boolean z2 = true;
        if (!(length <= 1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i4 = i2 - i;
        int i5 = 0;
        if (length == 0) {
            if ((i4 & 1) != 0) {
                return null;
            }
            int i6 = i4 >> 1;
            byte[] bArr = new byte[i6];
            for (int i7 = 0; i7 < i6; i7++) {
                bArr[i7] = parseByteAt(str, i5);
                i5 += 2;
            }
            return bArr;
        }
        if (i4 % 3 != 2) {
            return null;
        }
        int i8 = (i4 / 3) + 1;
        byte[] bArr2 = new byte[i8];
        char charAt = bytesHexFormat.getByteSeparator().charAt(0);
        bArr2[0] = parseByteAt(str, 0);
        int i9 = 0 + 2;
        int i10 = 1;
        while (i10 < i8) {
            if (str.charAt(i9) != charAt) {
                String byteSeparator = bytesHexFormat.getByteSeparator();
                boolean ignoreCase = bytesHexFormat.getIgnoreCase();
                if (byteSeparator.length() == 0 ? z2 : z) {
                    i3 = length;
                } else {
                    int length2 = byteSeparator.length();
                    int i11 = 0;
                    while (i11 < length2) {
                        int i12 = length;
                        int i13 = length2;
                        if (!CharsKt.equals(byteSeparator.charAt(i11), str.charAt(i9 + i11), ignoreCase)) {
                            throwNotContainedAt(str, i9, i2, byteSeparator, "byte separator");
                        }
                        i11++;
                        length = i12;
                        length2 = i13;
                    }
                    i3 = length;
                    byteSeparator.length();
                }
            } else {
                i3 = length;
            }
            bArr2[i10] = parseByteAt(str, i9 + 1);
            i9 += 3;
            i10++;
            length = i3;
            z = false;
            z2 = true;
        }
        return bArr2;
    }

    private static final byte[] hexToByteArraySlowPath(String str, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat) {
        int i3;
        int i4;
        int i5;
        int i6;
        int length;
        int length2;
        String str2;
        int i7;
        int length3;
        int i8;
        String str3 = str;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        boolean ignoreCase = bytesHexFormat.getIgnoreCase();
        int parsedByteArrayMaxSize = parsedByteArrayMaxSize(i2 - i, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        byte[] bArr = new byte[parsedByteArrayMaxSize];
        int i9 = i;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i9 < i2) {
            if (i11 == bytesPerLine) {
                i9 = checkNewLineAt(str3, i9, i2);
                i11 = 0;
                i12 = 0;
                i3 = parsedByteArrayMaxSize;
                i4 = bytesPerLine;
                i5 = bytesPerGroup;
            } else if (i12 == bytesPerGroup) {
                String str4 = str;
                String str5 = "group separator";
                if (groupSeparator.length() == 0) {
                    i3 = parsedByteArrayMaxSize;
                    i4 = bytesPerLine;
                    i5 = bytesPerGroup;
                    length2 = i9;
                } else {
                    int length4 = groupSeparator.length();
                    i3 = parsedByteArrayMaxSize;
                    int i13 = 0;
                    while (i13 < length4) {
                        int i14 = bytesPerLine;
                        int i15 = i13;
                        int i16 = bytesPerGroup;
                        String str6 = str4;
                        if (CharsKt.equals(groupSeparator.charAt(i13), str6.charAt(i9 + i15), ignoreCase)) {
                            str2 = str5;
                        } else {
                            str2 = str5;
                            throwNotContainedAt(str6, i9, i2, groupSeparator, str2);
                        }
                        str5 = str2;
                        i13 = i15 + 1;
                        str4 = str6;
                        bytesPerLine = i14;
                        bytesPerGroup = i16;
                    }
                    i4 = bytesPerLine;
                    i5 = bytesPerGroup;
                    length2 = groupSeparator.length() + i9;
                }
                i9 = length2;
                i12 = 0;
            } else {
                i3 = parsedByteArrayMaxSize;
                i4 = bytesPerLine;
                i5 = bytesPerGroup;
                if (i12 != 0) {
                    if (byteSeparator.length() == 0) {
                        length = i9;
                        i6 = i11;
                    } else {
                        int i17 = 0;
                        int length5 = byteSeparator.length();
                        while (i17 < length5) {
                            int i18 = length5;
                            int i19 = i11;
                            if (!CharsKt.equals(byteSeparator.charAt(i17), str.charAt(i9 + i17), ignoreCase)) {
                                throwNotContainedAt(str, i9, i2, byteSeparator, "byte separator");
                            }
                            i17++;
                            length5 = i18;
                            i11 = i19;
                        }
                        i6 = i11;
                        length = byteSeparator.length() + i9;
                    }
                    i9 = length;
                    i11 = i6;
                }
            }
            int i20 = i11 + 1;
            i12++;
            if (bytePrefix.length() == 0) {
                length3 = i9;
                i7 = i20;
            } else {
                int i21 = 0;
                int length6 = bytePrefix.length();
                while (i21 < length6) {
                    int i22 = length6;
                    int i23 = i20;
                    if (!CharsKt.equals(bytePrefix.charAt(i21), str.charAt(i9 + i21), ignoreCase)) {
                        throwNotContainedAt(str, i9, i2, bytePrefix, "byte prefix");
                    }
                    i21++;
                    length6 = i22;
                    i20 = i23;
                }
                i7 = i20;
                length3 = bytePrefix.length() + i9;
            }
            if (i2 - 2 < length3) {
                throwInvalidNumberOfDigits(str3, length3, i2, "exactly", 2);
            }
            int i24 = i10 + 1;
            bArr[i10] = parseByteAt(str3, length3);
            int i25 = length3 + 2;
            if (byteSuffix.length() == 0) {
                i8 = i24;
            } else {
                int i26 = 0;
                int length7 = byteSuffix.length();
                while (i26 < length7) {
                    int i27 = length7;
                    int i28 = i24;
                    if (!CharsKt.equals(byteSuffix.charAt(i26), str.charAt(i25 + i26), ignoreCase)) {
                        throwNotContainedAt(str, i25, i2, byteSuffix, "byte suffix");
                    }
                    i26++;
                    length7 = i27;
                    i24 = i28;
                }
                i8 = i24;
                i25 = byteSuffix.length() + i25;
            }
            i9 = i25;
            str3 = str;
            i10 = i8;
            i11 = i7;
            bytesPerLine = i4;
            parsedByteArrayMaxSize = i3;
            bytesPerGroup = i5;
        }
        if (i10 == bArr.length) {
            return bArr;
        }
        byte[] copyOf = Arrays.copyOf(bArr, i10);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(...)");
        return copyOf;
    }

    public static final int hexToInt(String str, int i, int i2, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToIntImpl(str, i, i2, format, 8);
    }

    public static final int hexToInt(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToInt(str, 0, str.length(), format);
    }

    public static /* synthetic */ int hexToInt$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, i, i2, hexFormat);
    }

    public static /* synthetic */ int hexToInt$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToInt(str, hexFormat);
    }

    private static final int hexToIntImpl(String str, int i, int i2, HexFormat hexFormat, int i3) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkNumberOfDigits(str, i, i2, i3);
            return parseInt(str, i, i2);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixNumberOfDigits(str, i, i2, prefix, suffix, number.getIgnoreCase(), i3);
        return parseInt(str, i + prefix.length(), i2 - suffix.length());
    }

    public static final long hexToLong(String str, int i, int i2, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLongImpl(str, i, i2, format, 16);
    }

    public static final long hexToLong(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToLong(str, 0, str.length(), format);
    }

    public static /* synthetic */ long hexToLong$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, i, i2, hexFormat);
    }

    public static /* synthetic */ long hexToLong$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToLong(str, hexFormat);
    }

    private static final long hexToLongImpl(String str, int i, int i2, HexFormat hexFormat, int i3) {
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, str.length());
        HexFormat.NumberHexFormat number = hexFormat.getNumber();
        if (number.getIsDigitsOnly()) {
            checkNumberOfDigits(str, i, i2, i3);
            return parseLong(str, i, i2);
        }
        String prefix = number.getPrefix();
        String suffix = number.getSuffix();
        checkPrefixSuffixNumberOfDigits(str, i, i2, prefix, suffix, number.getIgnoreCase(), i3);
        return parseLong(str, i + prefix.length(), i2 - suffix.length());
    }

    private static final short hexToShort(String str, int i, int i2, HexFormat hexFormat) {
        return (short) hexToIntImpl(str, i, i2, hexFormat, 4);
    }

    public static final short hexToShort(String str, HexFormat format) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return hexToShort(str, 0, str.length(), format);
    }

    static /* synthetic */ short hexToShort$default(String str, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, i, i2, hexFormat);
    }

    public static /* synthetic */ short hexToShort$default(String str, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return hexToShort(str, hexFormat);
    }

    private static final long longDecimalFromHexDigitAt(String str, int i) {
        char charAt = str.charAt(i);
        if ((charAt >>> '\b') == 0 && HEX_DIGITS_TO_LONG_DECIMAL[charAt] >= 0) {
            return HEX_DIGITS_TO_LONG_DECIMAL[charAt];
        }
        throwInvalidDigitAt(str, i);
        throw new KotlinNothingValueException();
    }

    private static final byte parseByteAt(String str, int i) {
        char charAt = str.charAt(i);
        if ((charAt >>> '\b') != 0 || HEX_DIGITS_TO_DECIMAL[charAt] < 0) {
            throwInvalidDigitAt(str, i);
            throw new KotlinNothingValueException();
        }
        int i2 = HEX_DIGITS_TO_DECIMAL[charAt];
        int i3 = i + 1;
        char charAt2 = str.charAt(i3);
        if ((charAt2 >>> '\b') != 0 || HEX_DIGITS_TO_DECIMAL[charAt2] < 0) {
            throwInvalidDigitAt(str, i3);
            throw new KotlinNothingValueException();
        }
        return (byte) ((i2 << 4) | HEX_DIGITS_TO_DECIMAL[charAt2]);
    }

    private static final int parseInt(String str, int i, int i2) {
        int i3 = 0;
        for (int i4 = i; i4 < i2; i4++) {
            int i5 = i3 << 4;
            char charAt = str.charAt(i4);
            if ((charAt >>> '\b') != 0 || HEX_DIGITS_TO_DECIMAL[charAt] < 0) {
                throwInvalidDigitAt(str, i4);
                throw new KotlinNothingValueException();
            }
            i3 = i5 | HEX_DIGITS_TO_DECIMAL[charAt];
        }
        return i3;
    }

    private static final long parseLong(String str, int i, int i2) {
        long j = 0;
        for (int i3 = i; i3 < i2; i3++) {
            long j2 = j << 4;
            char charAt = str.charAt(i3);
            if ((charAt >>> '\b') != 0 || HEX_DIGITS_TO_LONG_DECIMAL[charAt] < 0) {
                throwInvalidDigitAt(str, i3);
                throw new KotlinNothingValueException();
            }
            j = j2 | HEX_DIGITS_TO_LONG_DECIMAL[charAt];
        }
        return j;
    }

    public static final int parsedByteArrayMaxSize(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        long j;
        if (!(i > 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long j2 = i6 + 2 + i7;
        long charsPerSet = charsPerSet(j2, i3, i5);
        if (i2 <= i3) {
            j = charsPerSet(j2, i2, i5);
        } else {
            long charsPerSet2 = charsPerSet(charsPerSet, i2 / i3, i4);
            int i8 = i2 % i3;
            if (i8 != 0) {
                charsPerSet2 = charsPerSet2 + i4 + charsPerSet(j2, i8, i5);
            }
            j = charsPerSet2;
        }
        long j3 = i;
        long wholeElementsPerSet = wholeElementsPerSet(j3, j, 1);
        long j4 = j3 - ((j + 1) * wholeElementsPerSet);
        long wholeElementsPerSet2 = wholeElementsPerSet(j4, charsPerSet, i4);
        long j5 = j4 - ((i4 + charsPerSet) * wholeElementsPerSet2);
        long wholeElementsPerSet3 = wholeElementsPerSet(j5, j2, i5);
        return (int) ((i2 * wholeElementsPerSet) + (i3 * wholeElementsPerSet2) + wholeElementsPerSet3 + (j5 - ((((long) i5) + j2) * wholeElementsPerSet3) > 0 ? 1 : 0));
    }

    private static final Void throwInvalidDigitAt(String str, int i) {
        throw new NumberFormatException("Expected a hexadecimal digit at index " + i + ", but was " + str.charAt(i));
    }

    private static final void throwInvalidNumberOfDigits(String str, int i, int i2, String str2, int i3) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str2 + ' ' + i3 + " hexadecimal digits at index " + i + ", but was \"" + substring + "\" of length " + (i2 - i));
    }

    private static final void throwInvalidPrefixSuffix(String str, int i, int i2, String str2, String str3) {
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, i2);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected a hexadecimal number with prefix \"" + str2 + "\" and suffix \"" + str3 + "\", but was " + substring);
    }

    private static final void throwNotContainedAt(String str, int i, int i2, String str2, String str3) {
        int coerceAtMost = RangesKt.coerceAtMost(str2.length() + i, i2);
        Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
        String substring = str.substring(i, coerceAtMost);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        throw new NumberFormatException("Expected " + str3 + " \"" + str2 + "\" at index " + i + ", but was " + substring);
    }

    private static final int toCharArrayIfNotEmpty(String str, char[] cArr, int i) {
        switch (str.length()) {
            case 0:
                break;
            case 1:
                cArr[i] = str.charAt(0);
                break;
            default:
                int length = str.length();
                Intrinsics.checkNotNull(str, "null cannot be cast to non-null type java.lang.String");
                str.getChars(0, length, cArr, i);
                break;
        }
        return str.length() + i;
    }

    public static final String toHexString(byte b, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (!number.getIsDigitsOnlyAndNoPadding()) {
            return toHexStringImpl(b, number, str, 8);
        }
        char[] cArr = {str.charAt((b >> 4) & 15), str.charAt(b & 15)};
        return number.getRemoveLeadingZeros() ? StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(b & UByte.MAX_VALUE) - 24) >> 2, 1), 0, 2, null) : StringsKt.concatToString(cArr);
    }

    public static final String toHexString(int i, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (!number.getIsDigitsOnlyAndNoPadding()) {
            return toHexStringImpl(i, number, str, 32);
        }
        char[] cArr = {str.charAt((i >> 28) & 15), str.charAt((i >> 24) & 15), str.charAt((i >> 20) & 15), str.charAt((i >> 16) & 15), str.charAt((i >> 12) & 15), str.charAt((i >> 8) & 15), str.charAt((i >> 4) & 15), str.charAt(i & 15)};
        return number.getRemoveLeadingZeros() ? StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost(Integer.numberOfLeadingZeros(i) >> 2, 7), 0, 2, null) : StringsKt.concatToString(cArr);
    }

    public static final String toHexString(long j, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (!number.getIsDigitsOnlyAndNoPadding()) {
            return toHexStringImpl(j, number, str, 64);
        }
        char[] cArr = {str.charAt((int) ((j >> 60) & 15)), str.charAt((int) ((j >> 56) & 15)), str.charAt((int) ((j >> 52) & 15)), str.charAt((int) ((j >> 48) & 15)), str.charAt((int) ((j >> 44) & 15)), str.charAt((int) ((j >> 40) & 15)), str.charAt((int) ((j >> 36) & 15)), str.charAt((int) ((j >> 32) & 15)), str.charAt((int) ((j >> 28) & 15)), str.charAt((int) ((j >> 24) & 15)), str.charAt((int) ((j >> 20) & 15)), str.charAt((int) ((j >> 16) & 15)), str.charAt((int) ((j >> 12) & 15)), str.charAt((int) ((j >> 8) & 15)), str.charAt((int) ((j >> 4) & 15)), str.charAt((int) (15 & j))};
        return number.getRemoveLeadingZeros() ? StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost(Long.numberOfLeadingZeros(j) >> 2, 15), 0, 2, null) : StringsKt.concatToString(cArr);
    }

    public static final String toHexString(short s, HexFormat format) {
        Intrinsics.checkNotNullParameter(format, "format");
        String str = format.getUpperCase() ? UPPER_CASE_HEX_DIGITS : LOWER_CASE_HEX_DIGITS;
        HexFormat.NumberHexFormat number = format.getNumber();
        if (!number.getIsDigitsOnlyAndNoPadding()) {
            return toHexStringImpl(s, number, str, 16);
        }
        char[] cArr = {str.charAt((s >> 12) & 15), str.charAt((s >> 8) & 15), str.charAt((s >> 4) & 15), str.charAt(s & 15)};
        return number.getRemoveLeadingZeros() ? StringsKt.concatToString$default(cArr, RangesKt.coerceAtMost((Integer.numberOfLeadingZeros(65535 & s) - 16) >> 2, 3), 0, 2, null) : StringsKt.concatToString(cArr);
    }

    public static final String toHexString(byte[] bArr, int i, int i2, HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        AbstractList.INSTANCE.checkBoundsIndexes$kotlin_stdlib(i, i2, bArr.length);
        if (i == i2) {
            return "";
        }
        int[] iArr = format.getUpperCase() ? BYTE_TO_UPPER_CASE_HEX_DIGITS : BYTE_TO_LOWER_CASE_HEX_DIGITS;
        HexFormat.BytesHexFormat bytes = format.getBytes();
        return bytes.getNoLineAndGroupSeparator() ? toHexStringNoLineAndGroupSeparator(bArr, i, i2, bytes, iArr) : toHexStringSlowPath(bArr, i, i2, bytes, iArr);
    }

    public static final String toHexString(byte[] bArr, HexFormat format) {
        Intrinsics.checkNotNullParameter(bArr, "<this>");
        Intrinsics.checkNotNullParameter(format, "format");
        return toHexString(bArr, 0, bArr.length, format);
    }

    public static /* synthetic */ String toHexString$default(byte b, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(b, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(int i, HexFormat hexFormat, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(i, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(long j, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(j, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(short s, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(s, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, int i, int i2, HexFormat hexFormat, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = bArr.length;
        }
        if ((i3 & 4) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, i, i2, hexFormat);
    }

    public static /* synthetic */ String toHexString$default(byte[] bArr, HexFormat hexFormat, int i, Object obj) {
        if ((i & 1) != 0) {
            hexFormat = HexFormat.INSTANCE.getDefault();
        }
        return toHexString(bArr, hexFormat);
    }

    private static final String toHexStringImpl(long j, HexFormat.NumberHexFormat numberHexFormat, String str, int i) {
        if (!((i & 3) == 0)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        long j2 = j;
        int i2 = i >> 2;
        int minLength = numberHexFormat.getMinLength();
        int coerceAtLeast = RangesKt.coerceAtLeast(minLength - i2, 0);
        String prefix = numberHexFormat.getPrefix();
        String suffix = numberHexFormat.getSuffix();
        boolean removeLeadingZeros = numberHexFormat.getRemoveLeadingZeros();
        char[] cArr = new char[checkFormatLength(prefix.length() + coerceAtLeast + i2 + suffix.length())];
        int charArrayIfNotEmpty = toCharArrayIfNotEmpty(prefix, cArr, 0);
        if (coerceAtLeast > 0) {
            ArraysKt.fill(cArr, str.charAt(0), charArrayIfNotEmpty, charArrayIfNotEmpty + coerceAtLeast);
            charArrayIfNotEmpty += coerceAtLeast;
        }
        int i3 = i;
        int i4 = 0;
        while (i4 < i2) {
            i3 -= 4;
            long j3 = j2;
            int i5 = (int) ((j2 >> i3) & 15);
            removeLeadingZeros = removeLeadingZeros && i5 == 0 && (i3 >> 2) >= minLength;
            if (!removeLeadingZeros) {
                cArr[charArrayIfNotEmpty] = str.charAt(i5);
                charArrayIfNotEmpty++;
            }
            i4++;
            j2 = j3;
        }
        int charArrayIfNotEmpty2 = toCharArrayIfNotEmpty(suffix, cArr, charArrayIfNotEmpty);
        return charArrayIfNotEmpty2 == cArr.length ? StringsKt.concatToString(cArr) : StringsKt.concatToString$default(cArr, 0, charArrayIfNotEmpty2, 1, null);
    }

    private static final String toHexStringNoLineAndGroupSeparator(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        return bytesHexFormat.getShortByteSeparatorNoPrefixAndSuffix() ? toHexStringShortByteSeparatorNoPrefixAndSuffix(bArr, i, i2, bytesHexFormat, iArr) : toHexStringNoLineAndGroupSeparatorSlowPath(bArr, i, i2, bytesHexFormat, iArr);
    }

    private static final String toHexStringNoLineAndGroupSeparatorSlowPath(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        char[] cArr = new char[formattedStringLength(i2 - i, byteSeparator.length(), bytePrefix.length(), byteSuffix.length())];
        int formatByteAt = formatByteAt(bArr, i, bytePrefix, byteSuffix, iArr, cArr, 0);
        for (int i3 = i + 1; i3 < i2; i3++) {
            formatByteAt = formatByteAt(bArr, i3, bytePrefix, byteSuffix, iArr, cArr, toCharArrayIfNotEmpty(byteSeparator, cArr, formatByteAt));
        }
        return StringsKt.concatToString(cArr);
    }

    private static final String toHexStringShortByteSeparatorNoPrefixAndSuffix(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int length = bytesHexFormat.getByteSeparator().length();
        if (!(length <= 1)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int i3 = i2 - i;
        int i4 = 0;
        if (length == 0) {
            char[] cArr = new char[checkFormatLength(i3 * 2)];
            for (int i5 = i; i5 < i2; i5++) {
                i4 = formatByteAt(bArr, i5, iArr, cArr, i4);
            }
            return StringsKt.concatToString(cArr);
        }
        char[] cArr2 = new char[checkFormatLength((i3 * 3) - 1)];
        char charAt = bytesHexFormat.getByteSeparator().charAt(0);
        int formatByteAt = formatByteAt(bArr, i, iArr, cArr2, 0);
        for (int i6 = i + 1; i6 < i2; i6++) {
            cArr2[formatByteAt] = charAt;
            formatByteAt = formatByteAt(bArr, i6, iArr, cArr2, formatByteAt + 1);
        }
        return StringsKt.concatToString(cArr2);
    }

    private static final String toHexStringSlowPath(byte[] bArr, int i, int i2, HexFormat.BytesHexFormat bytesHexFormat, int[] iArr) {
        int i3;
        int i4;
        int bytesPerLine = bytesHexFormat.getBytesPerLine();
        int bytesPerGroup = bytesHexFormat.getBytesPerGroup();
        String bytePrefix = bytesHexFormat.getBytePrefix();
        String byteSuffix = bytesHexFormat.getByteSuffix();
        String byteSeparator = bytesHexFormat.getByteSeparator();
        String groupSeparator = bytesHexFormat.getGroupSeparator();
        int formattedStringLength = formattedStringLength(i2 - i, bytesPerLine, bytesPerGroup, groupSeparator.length(), byteSeparator.length(), bytePrefix.length(), byteSuffix.length());
        String str = byteSuffix;
        char[] cArr = new char[formattedStringLength];
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = i;
        while (true) {
            if (i8 >= i2) {
                break;
            }
            if (i6 == bytesPerLine) {
                cArr[i5] = '\n';
                i4 = 0;
                i5++;
                i3 = 0;
            } else if (i7 == bytesPerGroup) {
                i5 = toCharArrayIfNotEmpty(groupSeparator, cArr, i5);
                i3 = i6;
                i4 = 0;
            } else {
                i3 = i6;
                i4 = i7;
            }
            if (i4 != 0) {
                i5 = toCharArrayIfNotEmpty(byteSeparator, cArr, i5);
            }
            String str2 = bytePrefix;
            int i9 = i8;
            int formatByteAt = formatByteAt(bArr, i9, str2, str, iArr, cArr, i5);
            i7 = i4 + 1;
            i6 = i3 + 1;
            i8 = i9 + 1;
            i5 = formatByteAt;
            bytePrefix = str2;
            str = str;
        }
        if (i5 == formattedStringLength) {
            return StringsKt.concatToString(cArr);
        }
        throw new IllegalStateException("Check failed.");
    }

    private static final long wholeElementsPerSet(long j, long j2, int i) {
        if (j <= 0 || j2 <= 0) {
            return 0L;
        }
        return (i + j) / (i + j2);
    }
}
