package com.exampletest.mobilestudiotest.ui;

import androidx.core.view.ViewCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.StringsKt;

/* compiled from: GuiOverlay.kt */
@Metadata(d1 = {"\u0000'\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006*\u0001\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nJ\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\nH\u0002¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\nH\u0002R\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/RichText;", "", "<init>", "()V", "cache", "com/exampletest/mobilestudiotest/ui/RichText$cache$1", "Lcom/exampletest/mobilestudiotest/ui/RichText$cache$1;", "parse", "", "src", "", "parseColor", "", "v", "(Ljava/lang/String;)Ljava/lang/Integer;", "build", "decode", "s", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RichText {
    public static final RichText INSTANCE = new RichText();
    private static final RichText$cache$1 cache = new RichText$cache$1();

    private RichText() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x00a0, code lost:
    
        if (r11.equals("uppercase") == false) goto L49;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00e8, code lost:
    
        r14 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x00e6, code lost:
    
        if (r11.equals("uc") != false) goto L35;
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:19:0x0095. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.CharSequence build(java.lang.String r19) {
        /*
            Method dump skipped, instructions count: 534
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.RichText.build(java.lang.String):java.lang.CharSequence");
    }

    private final String decode(String s) {
        return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(s, "&lt;", "<", false, 4, (Object) null), "&gt;", ">", false, 4, (Object) null), "&quot;", "\"", false, 4, (Object) null), "&apos;", "'", false, 4, (Object) null), "&amp;", "&", false, 4, (Object) null);
    }

    private final Integer parseColor(String v) {
        String obj = StringsKt.trim((CharSequence) v).toString();
        if (StringsKt.startsWith$default(obj, "#", false, 2, (Object) null)) {
            Long longOrNull = StringsKt.toLongOrNull(StringsKt.removePrefix(obj, (CharSequence) "#"), 16);
            if (longOrNull != null) {
                return Integer.valueOf((int) (4278190080L | longOrNull.longValue()));
            }
            return null;
        }
        MatchResult find$default = Regex.find$default(new Regex("rgb\\(\\s*(\\d+)\\s*,\\s*(\\d+)\\s*,\\s*(\\d+)\\s*\\)"), obj, 0, 2, null);
        if (find$default == null) {
            return null;
        }
        MatchResult.Destructured destructured = find$default.getDestructured();
        return Integer.valueOf((RangesKt.coerceIn(Integer.parseInt(destructured.getMatch().getGroupValues().get(1)), 0, 255) << 16) | ViewCompat.MEASURED_STATE_MASK | (RangesKt.coerceIn(Integer.parseInt(destructured.getMatch().getGroupValues().get(2)), 0, 255) << 8) | RangesKt.coerceIn(Integer.parseInt(destructured.getMatch().getGroupValues().get(3)), 0, 255));
    }

    public final CharSequence parse(String src) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Intrinsics.checkNotNullParameter(src, "src");
        synchronized (cache) {
            RichText$cache$1 richText$cache$1 = cache;
            CharSequence charSequence3 = richText$cache$1.get((Object) src);
            if (charSequence3 == null) {
                charSequence = INSTANCE.build(src);
                richText$cache$1.put(src, charSequence);
            } else {
                charSequence = charSequence3;
            }
            charSequence2 = charSequence;
        }
        return charSequence2;
    }
}
