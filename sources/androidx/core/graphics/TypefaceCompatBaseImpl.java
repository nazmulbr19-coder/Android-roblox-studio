package androidx.core.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.util.Log;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.provider.FontsContractCompat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes.dex */
class TypefaceCompatBaseImpl {
    private static final int INVALID_KEY = 0;
    private static final String TAG = "TypefaceCompatBaseImpl";
    private ConcurrentHashMap<Long, FontResourcesParserCompat.FontFamilyFilesResourceEntry> mFontFamilies = new ConcurrentHashMap<>();

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements StyleExtractor<FontsContractCompat.FontInfo> {
        AnonymousClass1() {
        }

        /* renamed from: getWeight, reason: avoid collision after fix types in other method */
        public int getWeight2(FontsContractCompat.FontInfo fontInfo) {
            return fontInfo.getWeight();
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public /* bridge */ /* synthetic */ int getWeight(FontsContractCompat.FontInfo fontInfo) {
            return getWeight2(fontInfo);
        }

        /* renamed from: isItalic, reason: avoid collision after fix types in other method */
        public boolean isItalic2(FontsContractCompat.FontInfo fontInfo) {
            return fontInfo.isItalic();
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public /* bridge */ /* synthetic */ boolean isItalic(FontsContractCompat.FontInfo fontInfo) {
            return isItalic2(fontInfo);
        }
    }

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry> {
        AnonymousClass2() {
        }

        /* renamed from: getWeight, reason: avoid collision after fix types in other method */
        public int getWeight2(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.getWeight();
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public /* bridge */ /* synthetic */ int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return getWeight2(fontFileResourceEntry);
        }

        /* renamed from: isItalic, reason: avoid collision after fix types in other method */
        public boolean isItalic2(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.isItalic();
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public /* bridge */ /* synthetic */ boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return isItalic2(fontFileResourceEntry);
        }
    }

    /* renamed from: androidx.core.graphics.TypefaceCompatBaseImpl$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements StyleExtractor<FontResourcesParserCompat.FontFileResourceEntry> {
        AnonymousClass3() {
        }

        /* renamed from: getWeight, reason: avoid collision after fix types in other method */
        public int getWeight2(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.getWeight();
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public /* bridge */ /* synthetic */ int getWeight(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return getWeight2(fontFileResourceEntry);
        }

        /* renamed from: isItalic, reason: avoid collision after fix types in other method */
        public boolean isItalic2(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return fontFileResourceEntry.isItalic();
        }

        @Override // androidx.core.graphics.TypefaceCompatBaseImpl.StyleExtractor
        public /* bridge */ /* synthetic */ boolean isItalic(FontResourcesParserCompat.FontFileResourceEntry fontFileResourceEntry) {
            return isItalic2(fontFileResourceEntry);
        }
    }

    /* loaded from: classes.dex */
    private interface StyleExtractor<T> {
        int getWeight(T t);

        boolean isItalic(T t);
    }

    private void addFontFamily(Typeface typeface, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry) {
        long uniqueKey = getUniqueKey(typeface);
        if (uniqueKey != 0) {
            this.mFontFamilies.put(Long.valueOf(uniqueKey), fontFamilyFilesResourceEntry);
        }
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i, new AnonymousClass2());
    }

    private FontResourcesParserCompat.FontFileResourceEntry findBestEntry(FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, int i, boolean z) {
        return (FontResourcesParserCompat.FontFileResourceEntry) findBestFont(fontFamilyFilesResourceEntry.getEntries(), i, z, new AnonymousClass3());
    }

    private static <T> T findBestFont(T[] tArr, int i, StyleExtractor<T> styleExtractor) {
        return (T) findBestFont(tArr, (i & 1) == 0 ? 400 : TypedValues.TransitionType.TYPE_DURATION, (i & 2) != 0, styleExtractor);
    }

    private static <T> T findBestFont(T[] tArr, int i, boolean z, StyleExtractor<T> styleExtractor) {
        T t = null;
        int i2 = Integer.MAX_VALUE;
        for (T t2 : tArr) {
            int abs = (Math.abs(styleExtractor.getWeight(t2) - i) * 2) + (styleExtractor.isItalic(t2) == z ? 0 : 1);
            if (t == null || i2 > abs) {
                t = t2;
                i2 = abs;
            }
        }
        return t;
    }

    private static long getUniqueKey(Typeface typeface) {
        if (typeface == null) {
            return 0L;
        }
        try {
            Field declaredField = Typeface.class.getDeclaredField("native_instance");
            declaredField.setAccessible(true);
            return ((Number) declaredField.get(typeface)).longValue();
        } catch (IllegalAccessException e) {
            Log.e(TAG, "Could not retrieve font from family.", e);
            return 0L;
        } catch (NoSuchFieldException e2) {
            Log.e(TAG, "Could not retrieve font from family.", e2);
            return 0L;
        }
    }

    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i) {
        FontResourcesParserCompat.FontFileResourceEntry findBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i);
        if (findBestEntry == null) {
            return null;
        }
        Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, findBestEntry.getResourceId(), findBestEntry.getFileName(), 0, i);
        addFontFamily(createFromResourcesFontFile, fontFamilyFilesResourceEntry);
        return createFromResourcesFontFile;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface createFromFontFamilyFilesResourceEntry(Context context, FontResourcesParserCompat.FontFamilyFilesResourceEntry fontFamilyFilesResourceEntry, Resources resources, int i, boolean z) {
        FontResourcesParserCompat.FontFileResourceEntry findBestEntry = findBestEntry(fontFamilyFilesResourceEntry, i, z);
        if (findBestEntry == null) {
            return null;
        }
        Typeface createFromResourcesFontFile = TypefaceCompat.createFromResourcesFontFile(context, resources, findBestEntry.getResourceId(), findBestEntry.getFileName(), 0, 0);
        addFontFamily(createFromResourcesFontFile, fontFamilyFilesResourceEntry);
        return createFromResourcesFontFile;
    }

    public Typeface createFromFontInfo(Context context, CancellationSignal cancellationSignal, FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        if (fontInfoArr.length < 1) {
            return null;
        }
        InputStream inputStream = null;
        try {
            inputStream = context.getContentResolver().openInputStream(findBestInfo(fontInfoArr, i).getUri());
            return createFromInputStream(context, inputStream);
        } catch (IOException e) {
            return null;
        } finally {
            TypefaceCompatUtil.closeQuietly(inputStream);
        }
    }

    public Typeface createFromFontInfoWithFallback(Context context, CancellationSignal cancellationSignal, List<FontsContractCompat.FontInfo[]> list, int i) {
        throw new IllegalStateException("createFromFontInfoWithFallback must only be called on API 29+");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Typeface createFromInputStream(Context context, InputStream inputStream) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.copyToFile(tempFile, inputStream)) {
                return Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (RuntimeException e) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    public Typeface createFromResourcesFontFile(Context context, Resources resources, int i, String str, int i2) {
        File tempFile = TypefaceCompatUtil.getTempFile(context);
        if (tempFile == null) {
            return null;
        }
        try {
            if (TypefaceCompatUtil.copyToFile(tempFile, resources, i)) {
                return Typeface.createFromFile(tempFile.getPath());
            }
            return null;
        } catch (RuntimeException e) {
            return null;
        } finally {
            tempFile.delete();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Typeface createWeightStyle(Context context, Typeface typeface, int i, boolean z) {
        Typeface typeface2 = null;
        try {
            typeface2 = WeightTypefaceApi14.createWeightStyle(this, context, typeface, i, z);
        } catch (RuntimeException e) {
        }
        return typeface2 == null ? typeface : typeface2;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public FontsContractCompat.FontInfo findBestInfo(FontsContractCompat.FontInfo[] fontInfoArr, int i) {
        return (FontsContractCompat.FontInfo) findBestFont(fontInfoArr, i, new AnonymousClass1());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public FontResourcesParserCompat.FontFamilyFilesResourceEntry getFontFamily(Typeface typeface) {
        long uniqueKey = getUniqueKey(typeface);
        if (uniqueKey == 0) {
            return null;
        }
        return this.mFontFamilies.get(Long.valueOf(uniqueKey));
    }
}
