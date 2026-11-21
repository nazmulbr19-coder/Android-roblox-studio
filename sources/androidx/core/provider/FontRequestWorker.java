package androidx.core.provider;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.collection.LruCache;
import androidx.collection.SimpleArrayMap;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.core.util.Consumer;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* loaded from: classes.dex */
class FontRequestWorker {
    static final LruCache<String, Typeface> sTypefaceCache = new LruCache<>(16);
    private static final ExecutorService DEFAULT_EXECUTOR_SERVICE = RequestExecutor.createDefaultExecutor("fonts-androidx", 10, 10000);
    static final Object LOCK = new Object();
    static final SimpleArrayMap<String, ArrayList<Consumer<TypefaceResult>>> PENDING_REPLIES = new SimpleArrayMap<>();

    /* renamed from: androidx.core.provider.FontRequestWorker$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Callable<TypefaceResult> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$id;
        final /* synthetic */ FontRequest val$request;
        final /* synthetic */ int val$style;

        AnonymousClass1(String str, Context context, FontRequest fontRequest, int i) {
            this.val$id = str;
            this.val$context = context;
            this.val$request = fontRequest;
            this.val$style = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public TypefaceResult call() {
            return FontRequestWorker.getFontSync(this.val$id, this.val$context, FontRequestWorker$$ExternalSyntheticBackport1.m(this.val$request), this.val$style);
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ TypefaceResult call() throws Exception {
            return call();
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Consumer<TypefaceResult> {
        final /* synthetic */ CallbackWrapper val$callback;

        AnonymousClass2(CallbackWrapper callbackWrapper) {
            this.val$callback = callbackWrapper;
        }

        /* renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(TypefaceResult typefaceResult) {
            if (typefaceResult == null) {
                typefaceResult = new TypefaceResult(-3);
            }
            this.val$callback.onTypefaceResult(typefaceResult);
        }

        @Override // androidx.core.util.Consumer
        public /* bridge */ /* synthetic */ void accept(TypefaceResult typefaceResult) {
            accept2(typefaceResult);
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements Callable<TypefaceResult> {
        final /* synthetic */ Context val$context;
        final /* synthetic */ String val$id;
        final /* synthetic */ List val$requests;
        final /* synthetic */ int val$style;

        AnonymousClass3(String str, Context context, List list, int i) {
            this.val$id = str;
            this.val$context = context;
            this.val$requests = list;
            this.val$style = i;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public TypefaceResult call() {
            try {
                return FontRequestWorker.getFontSync(this.val$id, this.val$context, this.val$requests, this.val$style);
            } catch (Throwable th) {
                return new TypefaceResult(-3);
            }
        }

        @Override // java.util.concurrent.Callable
        public /* bridge */ /* synthetic */ TypefaceResult call() throws Exception {
            return call();
        }
    }

    /* renamed from: androidx.core.provider.FontRequestWorker$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 implements Consumer<TypefaceResult> {
        final /* synthetic */ String val$id;

        AnonymousClass4(String str) {
            this.val$id = str;
        }

        /* renamed from: accept, reason: avoid collision after fix types in other method */
        public void accept2(TypefaceResult typefaceResult) {
            synchronized (FontRequestWorker.LOCK) {
                ArrayList<Consumer<TypefaceResult>> arrayList = FontRequestWorker.PENDING_REPLIES.get(this.val$id);
                if (arrayList == null) {
                    return;
                }
                FontRequestWorker.PENDING_REPLIES.remove(this.val$id);
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.get(i).accept(typefaceResult);
                }
            }
        }

        @Override // androidx.core.util.Consumer
        public /* bridge */ /* synthetic */ void accept(TypefaceResult typefaceResult) {
            accept2(typefaceResult);
        }
    }

    /* loaded from: classes.dex */
    static final class TypefaceResult {
        final int mResult;
        final Typeface mTypeface;

        TypefaceResult(int i) {
            this.mTypeface = null;
            this.mResult = i;
        }

        TypefaceResult(Typeface typeface) {
            this.mTypeface = typeface;
            this.mResult = 0;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isSuccess() {
            return this.mResult == 0;
        }
    }

    private FontRequestWorker() {
    }

    private static String createCacheId(List<FontRequest> list, int i) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < list.size(); i2++) {
            sb.append(list.get(i2).getId()).append("-").append(i);
            if (i2 < list.size() - 1) {
                sb.append(";");
            }
        }
        return sb.toString();
    }

    private static int getFontFamilyResultStatus(FontsContractCompat.FontFamilyResult fontFamilyResult) {
        if (fontFamilyResult.getStatusCode() != 0) {
            switch (fontFamilyResult.getStatusCode()) {
                case 1:
                    return -2;
                default:
                    return -3;
            }
        }
        FontsContractCompat.FontInfo[] fonts = fontFamilyResult.getFonts();
        if (fonts == null || fonts.length == 0) {
            return 1;
        }
        for (FontsContractCompat.FontInfo fontInfo : fonts) {
            int resultCode = fontInfo.getResultCode();
            if (resultCode != 0) {
                if (resultCode >= 0) {
                    return resultCode;
                }
                return -3;
            }
        }
        return 0;
    }

    static TypefaceResult getFontSync(String str, Context context, List<FontRequest> list, int i) {
        Trace.beginSection("getFontSync");
        try {
            Typeface typeface = sTypefaceCache.get(str);
            if (typeface != null) {
                return new TypefaceResult(typeface);
            }
            FontsContractCompat.FontFamilyResult fontFamilyResult = FontProvider.getFontFamilyResult(context, list, null);
            int fontFamilyResultStatus = getFontFamilyResultStatus(fontFamilyResult);
            if (fontFamilyResultStatus != 0) {
                return new TypefaceResult(fontFamilyResultStatus);
            }
            Typeface createFromFontInfo = (!fontFamilyResult.hasFallback() || Build.VERSION.SDK_INT < 29) ? TypefaceCompat.createFromFontInfo(context, null, fontFamilyResult.getFonts(), i) : TypefaceCompat.createFromFontInfoWithFallback(context, null, fontFamilyResult.getFontsWithFallbacks(), i);
            if (createFromFontInfo == null) {
                return new TypefaceResult(-3);
            }
            sTypefaceCache.put(str, createFromFontInfo);
            return new TypefaceResult(createFromFontInfo);
        } catch (PackageManager.NameNotFoundException e) {
            return new TypefaceResult(-1);
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface requestFontAsync(Context context, List<FontRequest> list, int i, Executor executor, CallbackWrapper callbackWrapper) {
        String createCacheId = createCacheId(list, i);
        Typeface typeface = sTypefaceCache.get(createCacheId);
        if (typeface != null) {
            callbackWrapper.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        AnonymousClass2 anonymousClass2 = new AnonymousClass2(callbackWrapper);
        synchronized (LOCK) {
            ArrayList<Consumer<TypefaceResult>> arrayList = PENDING_REPLIES.get(createCacheId);
            if (arrayList != null) {
                arrayList.add(anonymousClass2);
                return null;
            }
            ArrayList<Consumer<TypefaceResult>> arrayList2 = new ArrayList<>();
            arrayList2.add(anonymousClass2);
            PENDING_REPLIES.put(createCacheId, arrayList2);
            RequestExecutor.execute(executor == null ? DEFAULT_EXECUTOR_SERVICE : executor, new AnonymousClass3(createCacheId, context, list, i), new AnonymousClass4(createCacheId));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Typeface requestFontSync(Context context, FontRequest fontRequest, CallbackWrapper callbackWrapper, int i, int i2) {
        String createCacheId = createCacheId(FontRequestWorker$$ExternalSyntheticBackport1.m(fontRequest), i);
        Typeface typeface = sTypefaceCache.get(createCacheId);
        if (typeface != null) {
            callbackWrapper.onTypefaceResult(new TypefaceResult(typeface));
            return typeface;
        }
        if (i2 == -1) {
            TypefaceResult fontSync = getFontSync(createCacheId, context, FontRequestWorker$$ExternalSyntheticBackport1.m(fontRequest), i);
            callbackWrapper.onTypefaceResult(fontSync);
            return fontSync.mTypeface;
        }
        try {
            TypefaceResult typefaceResult = (TypefaceResult) RequestExecutor.submit(DEFAULT_EXECUTOR_SERVICE, new AnonymousClass1(createCacheId, context, fontRequest, i), i2);
            callbackWrapper.onTypefaceResult(typefaceResult);
            return typefaceResult.mTypeface;
        } catch (InterruptedException e) {
            callbackWrapper.onTypefaceResult(new TypefaceResult(-3));
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void resetTypefaceCache() {
        sTypefaceCache.evictAll();
    }
}
