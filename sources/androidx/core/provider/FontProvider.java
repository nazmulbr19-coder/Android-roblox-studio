package androidx.core.provider;

import android.content.ContentProviderClient;
import android.content.ContentUris;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.Signature;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Build;
import android.os.CancellationSignal;
import android.os.RemoteException;
import android.util.Log;
import androidx.collection.LruCache;
import androidx.core.app.NotificationCompat$Metric$$ExternalSyntheticBackport0;
import androidx.core.content.res.FontResourcesParserCompat;
import androidx.core.graphics.TypefaceCompat;
import androidx.core.provider.FontsContractCompat;
import androidx.tracing.Trace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

/* loaded from: classes.dex */
class FontProvider {
    private static final String VARIABLE_FONT_QUERY_PARAM = "VF";
    private static final LruCache<ProviderCacheKey, ProviderInfo> sProviderCache = new LruCache<>(2);
    private static final Comparator<byte[]> sByteArrayComparator = new FontProvider$$ExternalSyntheticLambda1();

    /* loaded from: classes.dex */
    private interface ContentQueryWrapper {
        static ContentQueryWrapper make(Context context, Uri uri) {
            int i = Build.VERSION.SDK_INT;
            return new ContentQueryWrapperApi24Impl(context, uri);
        }

        void close();

        Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal);
    }

    /* loaded from: classes.dex */
    private static class ContentQueryWrapperApi16Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi16Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            if (this.mClient != null) {
                this.mClient.release();
            }
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            RemoteException remoteException;
            if (this.mClient == null) {
                return null;
            }
            try {
                try {
                    return this.mClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
                } catch (RemoteException e) {
                    remoteException = e;
                    Log.w("FontsProvider", "Unable to query the content provider", remoteException);
                    return null;
                }
            } catch (RemoteException e2) {
                remoteException = e2;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class ContentQueryWrapperApi24Impl implements ContentQueryWrapper {
        private final ContentProviderClient mClient;

        ContentQueryWrapperApi24Impl(Context context, Uri uri) {
            this.mClient = context.getContentResolver().acquireUnstableContentProviderClient(uri);
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public void close() {
            if (this.mClient != null) {
                this.mClient.close();
            }
        }

        @Override // androidx.core.provider.FontProvider.ContentQueryWrapper
        public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2, CancellationSignal cancellationSignal) {
            RemoteException remoteException;
            if (this.mClient == null) {
                return null;
            }
            try {
                try {
                    return this.mClient.query(uri, strArr, str, strArr2, str2, cancellationSignal);
                } catch (RemoteException e) {
                    remoteException = e;
                    Log.w("FontsProvider", "Unable to query the content provider", remoteException);
                    return null;
                }
            } catch (RemoteException e2) {
                remoteException = e2;
            }
        }
    }

    /* loaded from: classes.dex */
    private static class ProviderCacheKey {
        String mAuthority;
        List<List<byte[]>> mCertificates;
        String mPackageName;

        ProviderCacheKey(String str, String str2, List<List<byte[]>> list) {
            this.mAuthority = str;
            this.mPackageName = str2;
            this.mCertificates = list;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ProviderCacheKey)) {
                return false;
            }
            ProviderCacheKey providerCacheKey = (ProviderCacheKey) obj;
            return Objects.equals(this.mAuthority, providerCacheKey.mAuthority) && Objects.equals(this.mPackageName, providerCacheKey.mPackageName) && Objects.equals(this.mCertificates, providerCacheKey.mCertificates);
        }

        public int hashCode() {
            return Objects.hash(this.mAuthority, this.mPackageName, this.mCertificates);
        }
    }

    private FontProvider() {
    }

    static void clearProviderCache() {
        sProviderCache.evictAll();
    }

    private static List<byte[]> convertToByteArrayList(Signature[] signatureArr) {
        ArrayList arrayList = new ArrayList();
        for (Signature signature : signatureArr) {
            arrayList.add(signature.toByteArray());
        }
        return arrayList;
    }

    private static boolean equalsByteArrayList(List<byte[]> list, List<byte[]> list2) {
        if (list.size() != list2.size()) {
            return false;
        }
        for (int i = 0; i < list.size(); i++) {
            if (!Arrays.equals(list.get(i), list2.get(i))) {
                return false;
            }
        }
        return true;
    }

    private static List<List<byte[]>> getCertificates(FontRequest fontRequest, Resources resources) {
        return fontRequest.getCertificates() != null ? fontRequest.getCertificates() : FontResourcesParserCompat.readCerts(resources, fontRequest.getCertificatesArrayResId());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static FontsContractCompat.FontFamilyResult getFontFamilyResult(Context context, List<FontRequest> list, CancellationSignal cancellationSignal) throws PackageManager.NameNotFoundException {
        String systemFont;
        Typeface systemFontFamily;
        Trace.beginSection("FontProvider.getFontFamilyResult");
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                FontRequest fontRequest = list.get(i);
                if (Build.VERSION.SDK_INT < 31 || (systemFontFamily = TypefaceCompat.getSystemFontFamily((systemFont = fontRequest.getSystemFont()))) == null || TypefaceCompat.guessPrimaryFont(systemFontFamily) == null) {
                    ProviderInfo provider = getProvider(context.getPackageManager(), fontRequest, context.getResources());
                    if (provider == null) {
                        return FontsContractCompat.FontFamilyResult.create(1, (FontsContractCompat.FontInfo[]) null);
                    }
                    arrayList.add(query(context, fontRequest, provider.authority, cancellationSignal));
                } else {
                    arrayList.add(new FontsContractCompat.FontInfo[]{new FontsContractCompat.FontInfo(systemFont, fontRequest.getVariationSettings())});
                }
            }
            return FontsContractCompat.FontFamilyResult.create(0, arrayList);
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ProviderInfo getProvider(PackageManager packageManager, FontRequest fontRequest, Resources resources) throws PackageManager.NameNotFoundException {
        Trace.beginSection("FontProvider.getProvider");
        try {
            List<List<byte[]>> certificates = getCertificates(fontRequest, resources);
            ProviderCacheKey providerCacheKey = new ProviderCacheKey(fontRequest.getProviderAuthority(), fontRequest.getProviderPackage(), certificates);
            ProviderInfo providerInfo = sProviderCache.get(providerCacheKey);
            if (providerInfo != null) {
                return providerInfo;
            }
            String providerAuthority = fontRequest.getProviderAuthority();
            ProviderInfo resolveContentProvider = packageManager.resolveContentProvider(providerAuthority, 0);
            if (resolveContentProvider == null) {
                throw new PackageManager.NameNotFoundException("No package found for authority: " + providerAuthority);
            }
            if (!resolveContentProvider.packageName.equals(fontRequest.getProviderPackage())) {
                throw new PackageManager.NameNotFoundException("Found content provider " + providerAuthority + ", but package was not " + fontRequest.getProviderPackage());
            }
            List<byte[]> convertToByteArrayList = convertToByteArrayList(packageManager.getPackageInfo(resolveContentProvider.packageName, 64).signatures);
            Collections.sort(convertToByteArrayList, sByteArrayComparator);
            for (int i = 0; i < certificates.size(); i++) {
                ArrayList arrayList = new ArrayList(certificates.get(i));
                Collections.sort(arrayList, sByteArrayComparator);
                if (equalsByteArrayList(convertToByteArrayList, arrayList)) {
                    sProviderCache.put(providerCacheKey, resolveContentProvider);
                    return resolveContentProvider;
                }
            }
            Trace.endSection();
            return null;
        } finally {
            Trace.endSection();
        }
    }

    protected static String[] getSelectionArgs(FontRequest fontRequest) {
        String variationSettings = fontRequest.getVariationSettings();
        return (variationSettings == null || NotificationCompat$Metric$$ExternalSyntheticBackport0.m(variationSettings)) ? new String[]{fontRequest.getQuery()} : new String[]{fontRequest.getQuery(), VARIABLE_FONT_QUERY_PARAM};
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ int lambda$static$0(byte[] bArr, byte[] bArr2) {
        if (bArr.length != bArr2.length) {
            return bArr.length - bArr2.length;
        }
        for (int i = 0; i < bArr.length; i++) {
            if (bArr[i] != bArr2[i]) {
                return bArr[i] - bArr2[i];
            }
        }
        return 0;
    }

    static FontsContractCompat.FontInfo[] query(Context context, FontRequest fontRequest, String str, CancellationSignal cancellationSignal) {
        ContentQueryWrapper contentQueryWrapper;
        Trace.beginSection("FontProvider.query");
        try {
            ArrayList arrayList = new ArrayList();
            Uri build = new Uri.Builder().scheme("content").authority(str).build();
            Uri build2 = new Uri.Builder().scheme("content").authority(str).appendPath("file").build();
            Cursor cursor = null;
            ContentQueryWrapper make = ContentQueryWrapper.make(context, build);
            try {
                String[] strArr = {"_id", FontsContractCompat.Columns.FILE_ID, FontsContractCompat.Columns.TTC_INDEX, FontsContractCompat.Columns.VARIATION_SETTINGS, FontsContractCompat.Columns.WEIGHT, FontsContractCompat.Columns.ITALIC, FontsContractCompat.Columns.RESULT_CODE};
                Trace.beginSection("ContentQueryWrapper.query");
                contentQueryWrapper = make;
                try {
                    try {
                        Cursor query = contentQueryWrapper.query(build, strArr, "query = ?", getSelectionArgs(fontRequest), null, cancellationSignal);
                        Trace.endSection();
                        if (query != null && query.getCount() > 0) {
                            int columnIndex = query.getColumnIndex(FontsContractCompat.Columns.RESULT_CODE);
                            arrayList = new ArrayList();
                            int columnIndex2 = query.getColumnIndex("_id");
                            int columnIndex3 = query.getColumnIndex(FontsContractCompat.Columns.FILE_ID);
                            int columnIndex4 = query.getColumnIndex(FontsContractCompat.Columns.TTC_INDEX);
                            int columnIndex5 = query.getColumnIndex(FontsContractCompat.Columns.WEIGHT);
                            int columnIndex6 = query.getColumnIndex(FontsContractCompat.Columns.ITALIC);
                            while (query.moveToNext()) {
                                int i = columnIndex != -1 ? query.getInt(columnIndex) : 0;
                                arrayList.add(new FontsContractCompat.FontInfo(columnIndex3 == -1 ? ContentUris.withAppendedId(build, query.getLong(columnIndex2)) : ContentUris.withAppendedId(build2, query.getLong(columnIndex3)), columnIndex4 != -1 ? query.getInt(columnIndex4) : 0, columnIndex5 != -1 ? query.getInt(columnIndex5) : 400, columnIndex6 != -1 && query.getInt(columnIndex6) == 1, fontRequest.getVariationSettings(), i));
                            }
                        }
                        if (query != null) {
                            query.close();
                        }
                        contentQueryWrapper.close();
                        return (FontsContractCompat.FontInfo[]) arrayList.toArray(new FontsContractCompat.FontInfo[0]);
                    } finally {
                    }
                } catch (Throwable th) {
                    th = th;
                    if (0 != 0) {
                        cursor.close();
                    }
                    contentQueryWrapper.close();
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                contentQueryWrapper = make;
            }
        } finally {
        }
    }
}
