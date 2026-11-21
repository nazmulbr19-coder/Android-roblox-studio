package androidx.core.app;

/* loaded from: classes.dex */
public class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync = new Object();

    private AppLocalesStorageHelper() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x003e, code lost:
    
        if (r1 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x004c, code lost:
    
        r1.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x004a, code lost:
    
        if (r1 == null) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static void persistLocales(android.content.Context r6, java.lang.String r7) {
        /*
            java.lang.Object r0 = androidx.core.app.AppLocalesStorageHelper.sAppLocaleStorageSync
            monitor-enter(r0)
            java.lang.String r1 = ""
            boolean r1 = r7.equals(r1)     // Catch: java.lang.Throwable -> L74
            if (r1 == 0) goto L12
            java.lang.String r1 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r6.deleteFile(r1)     // Catch: java.lang.Throwable -> L74
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L74
            return
        L12:
            java.lang.String r1 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r2 = 0
            java.io.FileOutputStream r1 = r6.openFileOutput(r1, r2)     // Catch: java.io.FileNotFoundException -> L5e java.lang.Throwable -> L74
            org.xmlpull.v1.XmlSerializer r2 = android.util.Xml.newSerializer()     // Catch: java.lang.Throwable -> L74
            r3 = 0
            r2.setOutput(r1, r3)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L54
            java.lang.String r4 = "UTF-8"
            r5 = 1
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L54
            r2.startDocument(r4, r5)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L54
            java.lang.String r4 = "locales"
            r2.startTag(r3, r4)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L54
            java.lang.String r4 = "application_locales"
            r2.attribute(r3, r4, r7)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L54
            java.lang.String r4 = "locales"
            r2.endTag(r3, r4)     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L54
            r2.endDocument()     // Catch: java.lang.Exception -> L41 java.lang.Throwable -> L54
            if (r1 == 0) goto L52
            goto L4c
        L41:
            r3 = move-exception
            java.lang.String r4 = "AppLocalesStorageHelper"
            java.lang.String r5 = "Storing App Locales : Failed to persist app-locales in storage "
            android.util.Log.w(r4, r5, r3)     // Catch: java.lang.Throwable -> L54
            if (r1 == 0) goto L52
        L4c:
            r1.close()     // Catch: java.io.IOException -> L50 java.lang.Throwable -> L74
        L4f:
            goto L52
        L50:
            r3 = move-exception
            goto L4f
        L52:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L74
            return
        L54:
            r3 = move-exception
            if (r1 == 0) goto L5c
            r1.close()     // Catch: java.io.IOException -> L5b java.lang.Throwable -> L74
            goto L5c
        L5b:
            r4 = move-exception
        L5c:
            throw r3     // Catch: java.lang.Throwable -> L74
        L5e:
            r1 = move-exception
            java.lang.String r2 = "AppLocalesStorageHelper"
            java.lang.String r3 = "Storing App Locales : FileNotFoundException: Cannot open file %s for writing "
            java.lang.String r4 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.lang.Object[] r4 = new java.lang.Object[]{r4}     // Catch: java.lang.Throwable -> L74
            java.lang.String r3 = java.lang.String.format(r3, r4)     // Catch: java.lang.Throwable -> L74
            android.util.Log.w(r2, r3)     // Catch: java.lang.Throwable -> L74
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L74
            return
        L72:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L74
            throw r1
        L74:
            r1 = move-exception
            goto L72
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.AppLocalesStorageHelper.persistLocales(android.content.Context, java.lang.String):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0046, code lost:
    
        if (r2 != null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        r2.close();
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x0043, code lost:
    
        r1 = r3.getAttributeValue(null, androidx.core.app.AppLocalesStorageHelper.LOCALE_RECORD_ATTRIBUTE_TAG);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0054, code lost:
    
        if (r2 == null) goto L33;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x006b: IF  (r2 I:??[int, boolean, OBJECT, ARRAY, byte, short, char]) == (0 ??[int, boolean, OBJECT, ARRAY, byte, short, char])  -> B:57:0x0073, block:B:56:0x006b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String readLocales(android.content.Context r9) {
        /*
            java.lang.Object r0 = androidx.core.app.AppLocalesStorageHelper.sAppLocaleStorageSync
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r9.openFileInput(r2)     // Catch: java.io.FileNotFoundException -> L74 java.lang.Throwable -> L79
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b java.lang.Throwable -> L6a
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b java.lang.Throwable -> L6a
            int r4 = r3.getDepth()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b java.lang.Throwable -> L6a
        L19:
            int r5 = r3.next()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b java.lang.Throwable -> L6a
            r6 = r5
            r7 = 1
            if (r5 == r7) goto L46
            r5 = 3
            if (r6 != r5) goto L2a
            int r7 = r3.getDepth()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b java.lang.Throwable -> L6a
            if (r7 <= r4) goto L46
        L2a:
            if (r6 == r5) goto L19
            r5 = 4
            if (r6 != r5) goto L30
            goto L19
        L30:
            java.lang.String r5 = r3.getName()     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b java.lang.Throwable -> L6a
            java.lang.String r7 = "locales"
            boolean r7 = r5.equals(r7)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b java.lang.Throwable -> L6a
            if (r7 == 0) goto L45
            java.lang.String r7 = "application_locales"
            r8 = 0
            java.lang.String r7 = r3.getAttributeValue(r8, r7)     // Catch: java.io.IOException -> L49 org.xmlpull.v1.XmlPullParserException -> L4b java.lang.Throwable -> L6a
            r1 = r7
            goto L46
        L45:
            goto L19
        L46:
            if (r2 == 0) goto L5c
            goto L56
        L49:
            r3 = move-exception
            goto L4c
        L4b:
            r3 = move-exception
        L4c:
            java.lang.String r4 = "AppLocalesStorageHelper"
            java.lang.String r5 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r4, r5)     // Catch: java.lang.Throwable -> L6a
            if (r2 == 0) goto L5c
        L56:
            r2.close()     // Catch: java.io.IOException -> L5a java.lang.Throwable -> L79
        L59:
            goto L5c
        L5a:
            r3 = move-exception
            goto L59
        L5c:
            boolean r3 = r1.isEmpty()     // Catch: java.lang.Throwable -> L79
            if (r3 != 0) goto L63
            goto L68
        L63:
            java.lang.String r3 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r9.deleteFile(r3)     // Catch: java.lang.Throwable -> L79
        L68:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
            return r1
        L6a:
            r3 = move-exception
            if (r2 == 0) goto L72
            r2.close()     // Catch: java.io.IOException -> L71 java.lang.Throwable -> L79
            goto L72
        L71:
            r4 = move-exception
        L72:
            throw r3     // Catch: java.lang.Throwable -> L79
        L74:
            r2 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
            return r1
        L77:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L79
            throw r1
        L79:
            r1 = move-exception
            goto L77
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.AppLocalesStorageHelper.readLocales(android.content.Context):java.lang.String");
    }
}
