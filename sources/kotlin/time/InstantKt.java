package kotlin.time;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Typography;
import kotlin.time.InstantParseResult;

/* compiled from: Instant.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\f\n\u0002\u0010\u0015\n\u0002\b\u0006\u001a\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0003\u001a\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0002H\u0003\u001a'\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a'\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001bH\u0082\b\u001a\u0010\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\u0015H\u0000\u001a\u0014\u0010'\u001a\u00020\u0015*\u00020\u00152\u0006\u0010%\u001a\u00020\u0001H\u0002\u001a\u0014\u0010-\u001a\u00020\u0012*\u00020\u00102\u0006\u0010.\u001a\u00020\u0015H\u0002\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0000\u0010\u0005\"\u001f\u0010\u0006\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\u0004\u001a\u0004\b\u0006\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0016\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001e\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u001f\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010!\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\"\u001a\u00020\u0015X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010#\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010$\u001a\u00020\u0015X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010(\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010*\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010+\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010,\u001a\u00020)X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006/"}, d2 = {"isDistantPast", "", "Lkotlin/time/Instant;", "isDistantPast$annotations", "(Lkotlin/time/Instant;)V", "(Lkotlin/time/Instant;)Z", "isDistantFuture", "isDistantFuture$annotations", "DISTANT_PAST_SECONDS", "", "DISTANT_FUTURE_SECONDS", "MIN_SECOND", "MAX_SECOND", "parseIso", "Lkotlin/time/InstantParseResult;", "isoString", "", "formatIso", "", "instant", "DAYS_PER_CYCLE", "", "DAYS_0000_TO_1970", "safeAddOrElse", "a", "b", "action", "Lkotlin/Function0;", "", "safeMultiplyOrElse", "SECONDS_PER_HOUR", "SECONDS_PER_MINUTE", "HOURS_PER_DAY", "SECONDS_PER_DAY", "NANOS_PER_SECOND", "NANOS_PER_MILLI", "MILLIS_PER_SECOND", "isLeapYear", "year", "monthLength", "POWERS_OF_TEN", "", "asciiDigitPositionsInIsoStringAfterYear", "colonsInIsoOffsetString", "asciiDigitsInIsoOffsetString", "truncateForErrorMessage", "maxLength", "kotlin-stdlib"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class InstantKt {
    private static final int DAYS_0000_TO_1970 = 719528;
    private static final int DAYS_PER_CYCLE = 146097;
    private static final long DISTANT_FUTURE_SECONDS = 3093527980800L;
    private static final long DISTANT_PAST_SECONDS = -3217862419201L;
    private static final int HOURS_PER_DAY = 24;
    private static final long MAX_SECOND = 31556889864403199L;
    private static final int MILLIS_PER_SECOND = 1000;
    private static final long MIN_SECOND = -31557014167219200L;
    private static final int NANOS_PER_MILLI = 1000000;
    private static final int SECONDS_PER_DAY = 86400;
    private static final int SECONDS_PER_HOUR = 3600;
    private static final int SECONDS_PER_MINUTE = 60;
    public static final int NANOS_PER_SECOND = 1000000000;
    private static final int[] POWERS_OF_TEN = {1, 10, 100, 1000, 10000, 100000, 1000000, 10000000, 100000000, NANOS_PER_SECOND};
    private static final int[] asciiDigitPositionsInIsoStringAfterYear = {1, 2, 4, 5, 7, 8, 10, 11, 13, 14};
    private static final int[] colonsInIsoOffsetString = {3, 6};
    private static final int[] asciiDigitsInIsoOffsetString = {1, 2, 4, 5, 7, 8};

    public static final /* synthetic */ String access$formatIso(Instant instant) {
        return formatIso(instant);
    }

    public static final /* synthetic */ InstantParseResult access$parseIso(CharSequence charSequence) {
        return parseIso(charSequence);
    }

    public static final /* synthetic */ String access$truncateForErrorMessage(CharSequence charSequence, int i) {
        return truncateForErrorMessage(charSequence, i);
    }

    private static final String formatIso(Instant instant) {
        StringBuilder sb = new StringBuilder();
        UnboundLocalDateTime fromInstant = UnboundLocalDateTime.INSTANCE.fromInstant(instant);
        int year = fromInstant.getYear();
        if (Math.abs(year) < 1000) {
            StringBuilder sb2 = new StringBuilder();
            if (year >= 0) {
                Intrinsics.checkNotNullExpressionValue(sb2.append(year + 10000).deleteCharAt(0), "deleteCharAt(...)");
            } else {
                Intrinsics.checkNotNullExpressionValue(sb2.append(year - 10000).deleteCharAt(1), "deleteCharAt(...)");
            }
            sb.append((CharSequence) sb2);
        } else {
            if (year >= 10000) {
                sb.append('+');
            }
            sb.append(year);
        }
        sb.append('-');
        formatIso$lambda$13$appendTwoDigits(sb, sb, fromInstant.getMonth());
        sb.append('-');
        formatIso$lambda$13$appendTwoDigits(sb, sb, fromInstant.getDay());
        sb.append('T');
        formatIso$lambda$13$appendTwoDigits(sb, sb, fromInstant.getHour());
        sb.append(':');
        formatIso$lambda$13$appendTwoDigits(sb, sb, fromInstant.getMinute());
        sb.append(':');
        formatIso$lambda$13$appendTwoDigits(sb, sb, fromInstant.getSecond());
        if (fromInstant.getNanosecond() != 0) {
            sb.append('.');
            int i = 0;
            while (fromInstant.getNanosecond() % POWERS_OF_TEN[i + 1] == 0) {
                i++;
            }
            int i2 = i - (i % 3);
            String valueOf = String.valueOf(POWERS_OF_TEN[9 - i2] + (fromInstant.getNanosecond() / POWERS_OF_TEN[i2]));
            Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
            String substring = valueOf.substring(1);
            Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
            sb.append(substring);
        }
        sb.append('Z');
        return sb.toString();
    }

    private static final void formatIso$lambda$13$appendTwoDigits(Appendable appendable, StringBuilder sb, int i) {
        if (i < 10) {
            appendable.append('0');
        }
        sb.append(i);
    }

    private static final boolean isDistantFuture(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.compareTo2(Instant.INSTANCE.getDISTANT_FUTURE()) >= 0;
    }

    public static /* synthetic */ void isDistantFuture$annotations(Instant instant) {
    }

    private static final boolean isDistantPast(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return instant.compareTo2(Instant.INSTANCE.getDISTANT_PAST()) <= 0;
    }

    public static /* synthetic */ void isDistantPast$annotations(Instant instant) {
    }

    public static final boolean isLeapYear(int i) {
        return (i & 3) == 0 && (i % 100 != 0 || i % 400 == 0);
    }

    private static final int monthLength(int i, boolean z) {
        switch (i) {
            case 2:
                return z ? 29 : 28;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            default:
                return 31;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:174:0x034e  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03a2 A[LOOP:4: B:173:0x034c->B:182:0x03a2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x0372 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:191:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x03bd  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x03b9  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0074  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final kotlin.time.InstantParseResult parseIso(java.lang.CharSequence r34) {
        /*
            Method dump skipped, instructions count: 1500
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.InstantKt.parseIso(java.lang.CharSequence):kotlin.time.InstantParseResult");
    }

    private static final InstantParseResult.Failure parseIso$expect(CharSequence charSequence, String str, int i, Function1<? super Character, Boolean> function1) {
        char charAt = charSequence.charAt(i);
        if (function1.invoke(Character.valueOf(charAt)).booleanValue()) {
            return null;
        }
        return parseIso$parseFailure(charSequence, "Expected " + str + ", but got '" + charAt + "' at position " + i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean parseIso$lambda$0(char c) {
        return c == '-';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean parseIso$lambda$10(char c) {
        return '0' <= c && c < ':';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean parseIso$lambda$2(char c) {
        return c == '-';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean parseIso$lambda$4(char c) {
        return c == 'T' || c == 't';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean parseIso$lambda$6(char c) {
        return c == ':';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean parseIso$lambda$8(char c) {
        return c == ':';
    }

    private static final InstantParseResult.Failure parseIso$parseFailure(CharSequence charSequence, String str) {
        return new InstantParseResult.Failure(str + " when parsing an Instant from \"" + truncateForErrorMessage(charSequence, 64) + Typography.quote, charSequence);
    }

    private static final int parseIso$twoDigitNumber(CharSequence charSequence, int i) {
        return ((charSequence.charAt(i) - '0') * 10) + (charSequence.charAt(i + 1) - '0');
    }

    private static final long safeAddOrElse(long j, long j2, Function0 function0) {
        long j3 = j + j2;
        if ((j ^ j3) >= 0 || (j ^ j2) < 0) {
            return j3;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    private static final long safeMultiplyOrElse(long j, long j2, Function0 function0) {
        if (j2 == 1) {
            return j;
        }
        if (j == 1) {
            return j2;
        }
        if (j == 0 || j2 == 0) {
            return 0L;
        }
        long j3 = j * j2;
        if (j3 / j2 == j && ((j != Long.MIN_VALUE || j2 != -1) && (j2 != Long.MIN_VALUE || j != -1))) {
            return j3;
        }
        function0.invoke();
        throw new KotlinNothingValueException();
    }

    private static final String truncateForErrorMessage(CharSequence charSequence, int i) {
        return charSequence.length() <= i ? charSequence.toString() : charSequence.subSequence(0, i).toString() + "...";
    }
}
