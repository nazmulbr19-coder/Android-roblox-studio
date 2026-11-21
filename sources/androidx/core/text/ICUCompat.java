package androidx.core.text;

import android.icu.util.ULocale;
import android.os.Build;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes.dex */
public final class ICUCompat {
    private static final String TAG = "ICUCompat";
    private static Method sAddLikelySubtagsMethod;

    /* loaded from: classes.dex */
    static class Api24Impl {
        private Api24Impl() {
        }

        static ULocale addLikelySubtags(Object obj) {
            return ULocale.addLikelySubtags((ULocale) obj);
        }

        static ULocale forLocale(Locale locale) {
            return ULocale.forLocale(locale);
        }

        static String getScript(Object obj) {
            return ((ULocale) obj).getScript();
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
    }

    private ICUCompat() {
    }

    public static String maximizeAndGetScript(Locale locale) {
        int i = Build.VERSION.SDK_INT;
        return Api24Impl.getScript(Api24Impl.addLikelySubtags(Api24Impl.forLocale(locale)));
    }
}
