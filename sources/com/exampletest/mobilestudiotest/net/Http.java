package com.exampletest.mobilestudiotest.net;

import androidx.core.app.NotificationCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RobloxApi.kt */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u001dB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0002JP\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0015JP\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00120\u00172\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0015J.\u0010\u0018\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u00052\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00102\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u0016\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u0012J$\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\r\u001a\u00020\u00052\u0014\b\u0002\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/Http;", "", "<init>", "()V", "UA", "", "authHeaders", "", "isRoblox", "", "u", NotificationCompat.CATEGORY_CALL, "Lcom/exampletest/mobilestudiotest/net/Http$Response;", "url", "method", "headers", "", "body", "", "contentType", "maxBytes", "", "request", "Lkotlin/Pair;", "get", "describe", "code", "json", "Lorg/json/JSONObject;", "Response", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class Http {
    private static final String UA = "MobileStudio/1.0 (Android)";
    public static final Http INSTANCE = new Http();
    private static final Set<String> authHeaders = SetsKt.setOf((Object[]) new String[]{"cookie", "x-api-key", "x-csrf-token"});

    /* compiled from: RobloxApi.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\"\u0010\u0006\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0012\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/Http$Response;", "", "code", "", "body", "", "headers", "", "", "", "<init>", "(I[BLjava/util/Map;)V", "getCode", "()I", "getBody", "()[B", "header", "name", "text", "getText", "()Ljava/lang/String;", "ok", "", "getOk", "()Z", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Response {
        private final byte[] body;
        private final int code;
        private final Map<String, List<String>> headers;

        /* JADX WARN: Multi-variable type inference failed */
        public Response(int i, byte[] body, Map<String, ? extends List<String>> headers) {
            Intrinsics.checkNotNullParameter(body, "body");
            Intrinsics.checkNotNullParameter(headers, "headers");
            this.code = i;
            this.body = body;
            this.headers = headers;
        }

        public final byte[] getBody() {
            return this.body;
        }

        public final int getCode() {
            return this.code;
        }

        public final boolean getOk() {
            int i = this.code;
            return 200 <= i && i < 300;
        }

        public final String getText() {
            return new String(this.body, Charsets.UTF_8);
        }

        public final String header(String name) {
            Object obj;
            List list;
            Intrinsics.checkNotNullParameter(name, "name");
            Iterator<T> it = this.headers.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                String str = (String) ((Map.Entry) obj).getKey();
                boolean z = false;
                if (str != null && StringsKt.equals(str, name, true)) {
                    z = true;
                }
                if (z) {
                    break;
                }
            }
            Map.Entry entry = (Map.Entry) obj;
            if (entry == null || (list = (List) entry.getValue()) == null) {
                return null;
            }
            return (String) CollectionsKt.firstOrNull(list);
        }
    }

    private Http() {
    }

    public static /* synthetic */ Response call$default(Http http, String str, String str2, Map map, byte[] bArr, String str3, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "GET";
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        return http.call(str, str4, map, (i2 & 8) != 0 ? null : bArr, (i2 & 16) != 0 ? null : str3, (i2 & 32) != 0 ? 67108864 : i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ byte[] get$default(Http http, String str, Map map, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        if ((i2 & 4) != 0) {
            i = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        }
        return http.get(str, map, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final boolean isRoblox(java.lang.String r9) {
        /*
            r8 = this;
            r0 = 0
            java.net.URL r1 = new java.net.URL     // Catch: java.lang.Exception -> L42
            r1.<init>(r9)     // Catch: java.lang.Exception -> L42
            java.lang.String r2 = r1.getProtocol()     // Catch: java.lang.Exception -> L42
            java.lang.String r3 = "https"
            r4 = 1
            boolean r2 = kotlin.text.StringsKt.equals(r2, r3, r4)     // Catch: java.lang.Exception -> L42
            if (r2 == 0) goto L43
            java.lang.String r2 = r1.getHost()     // Catch: java.lang.Exception -> L42
            java.lang.String r3 = "getHost(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch: java.lang.Exception -> L42
            java.util.Locale r3 = java.util.Locale.ROOT     // Catch: java.lang.Exception -> L42
            java.lang.String r2 = r2.toLowerCase(r3)     // Catch: java.lang.Exception -> L42
            java.lang.String r3 = "toLowerCase(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch: java.lang.Exception -> L42
            r3 = 0
            java.lang.String r5 = "roblox.com"
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r5)     // Catch: java.lang.Exception -> L42
            if (r5 != 0) goto L3d
            java.lang.String r5 = ".roblox.com"
            r6 = 2
            r7 = 0
            boolean r5 = kotlin.text.StringsKt.endsWith$default(r2, r5, r0, r6, r7)     // Catch: java.lang.Exception -> L42
            if (r5 != 0) goto L3d
            r2 = r0
            goto L3e
        L3d:
            r2 = r4
        L3e:
            if (r2 == 0) goto L43
            r0 = r4
            goto L43
        L42:
            r1 = move-exception
        L43:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.Http.isRoblox(java.lang.String):boolean");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ JSONObject json$default(Http http, String str, Map map, int i, Object obj) {
        if ((i & 2) != 0) {
            map = MapsKt.emptyMap();
        }
        return http.json(str, map);
    }

    public static /* synthetic */ Pair request$default(Http http, String str, String str2, Map map, String str3, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "GET";
        }
        String str4 = str2;
        if ((i2 & 4) != 0) {
            map = MapsKt.emptyMap();
        }
        Map map2 = map;
        if ((i2 & 8) != 0) {
            str3 = null;
        }
        String str5 = str3;
        if ((i2 & 16) != 0) {
            i = AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL;
        }
        return http.request(str, str4, map2, str5, i);
    }

    /* JADX WARN: Code restructure failed: missing block: B:100:0x0260, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0265, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0266, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x01fc, code lost:
    
        r0 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x01cc, code lost:
    
        r0 = r11.getInputStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x01c5, code lost:
    
        if (r15 < 400) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x01c7, code lost:
    
        r0 = r11.getErrorStream();
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x01d0, code lost:
    
        r1 = r0;
        r0 = r11.getHeaderFields();
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x01d5, code lost:
    
        if (r0 != null) goto L72;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x01d7, code lost:
    
        r0 = kotlin.collections.MapsKt.emptyMap();
     */
    /* JADX WARN: Code restructure failed: missing block: B:64:0x01db, code lost:
    
        r2 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x01dc, code lost:
    
        if (r1 != null) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x01de, code lost:
    
        r11.disconnect();
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x01e9, code lost:
    
        return new com.exampletest.mobilestudiotest.net.Http.Response(r15, new byte[0], r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01f2, code lost:
    
        if (kotlin.text.StringsKt.equals("gzip", r11.getContentEncoding(), true) == false) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01f4, code lost:
    
        r0 = new java.util.zip.GZIPInputStream(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x01fd, code lost:
    
        r7 = r0;
        r0 = new java.io.ByteArrayOutputStream();
        r13 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0207, code lost:
    
        r0 = r13;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x020f, code lost:
    
        r1 = new byte[16384];
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0211, code lost:
    
        r19 = r0.read(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0218, code lost:
    
        if (r19 < 0) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x021a, code lost:
    
        r19 = r0;
        r0.write(r1, 0, r19);
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x0226, code lost:
    
        r20 = r1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x022a, code lost:
    
        if (r0.size() > r27) goto L130;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x022c, code lost:
    
        r0 = r19;
        r1 = r20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x023c, code lost:
    
        throw new java.io.IOException("Response too large");
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x023d, code lost:
    
        r0 = kotlin.Unit.INSTANCE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0248, code lost:
    
        kotlin.io.CloseableKt.closeFinally(r13, null);
        r11.disconnect();
        r3 = r0.toByteArray();
        kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, "toByteArray(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x025d, code lost:
    
        return new com.exampletest.mobilestudiotest.net.Http.Response(r15, r3, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x025e, code lost:
    
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:93:0x0263, code lost:
    
        r3 = r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x026b, code lost:
    
        throw r3;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x026c, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x026d, code lost:
    
        kotlin.io.CloseableKt.closeFinally(r13, r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:0x0270, code lost:
    
        throw r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.exampletest.mobilestudiotest.net.Http.Response call(java.lang.String r22, java.lang.String r23, java.util.Map<java.lang.String, java.lang.String> r24, byte[] r25, java.lang.String r26, int r27) {
        /*
            Method dump skipped, instructions count: 625
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.Http.call(java.lang.String, java.lang.String, java.util.Map, byte[], java.lang.String, int):com.exampletest.mobilestudiotest.net.Http$Response");
    }

    public final String describe(int code, byte[] body) {
        String str;
        String take;
        JSONObject optJSONObject;
        String optString;
        Intrinsics.checkNotNullParameter(body, "body");
        String obj = StringsKt.trim((CharSequence) new String(body, Charsets.UTF_8)).toString();
        if (code == 400) {
            str = "bad request";
        } else if (code == 401) {
            str = "not signed in / not authorized";
        } else if (code == 403) {
            str = "permission denied";
        } else if (code == 404) {
            str = "not found";
        } else if (code == 409) {
            str = "conflict";
        } else if (code == 413) {
            str = "file too large";
        } else if (code == 429) {
            str = "too many requests, try again in a minute";
        } else {
            str = 500 <= code && code < 600 ? "Roblox server error" : "";
        }
        if (StringsKt.startsWith$default(obj, "<", false, 2, (Object) null)) {
            take = "";
        } else if (StringsKt.startsWith$default(obj, "{", false, 2, (Object) null)) {
            try {
                JSONObject jSONObject = new JSONObject(obj);
                String optString2 = jSONObject.optString("message");
                if (optString2.length() == 0) {
                    JSONArray optJSONArray = jSONObject.optJSONArray("errors");
                    optString2 = (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null || (optString = optJSONObject.optString("message")) == null) ? "" : optString;
                }
                String str2 = optString2;
                if (str2.length() == 0) {
                    str2 = jSONObject.optString("error");
                }
                take = str2;
            } catch (Exception e) {
                take = StringsKt.take(obj, 160);
            }
        } else {
            take = StringsKt.take(obj, 160);
        }
        String str3 = str.length() > 0 ? " (" + str + ")" : "";
        Intrinsics.checkNotNull(take);
        return "HTTP " + code + str3 + (take.length() > 0 ? ": " + take : "");
    }

    public final byte[] get(String url, Map<String, String> headers, int maxBytes) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Pair request$default = request$default(this, url, null, headers, null, maxBytes, 10, null);
        int intValue = ((Number) request$default.component1()).intValue();
        byte[] bArr = (byte[]) request$default.component2();
        boolean z = false;
        if (200 <= intValue && intValue < 300) {
            z = true;
        }
        if (z) {
            return bArr;
        }
        throw new HttpException(intValue, describe(intValue, bArr));
    }

    public final JSONObject json(String url, Map<String, String> headers) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        return new JSONObject(new String(get$default(this, url, headers, 0, 4, null), Charsets.UTF_8));
    }

    public final Pair<Integer, byte[]> request(String url, String method, Map<String, String> headers, String body, int maxBytes) {
        byte[] bArr;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if (body != null) {
            byte[] bytes = body.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            bArr = bytes;
        } else {
            bArr = null;
        }
        Response call = call(url, method, headers, bArr, body != null ? "application/json" : null, maxBytes);
        return TuplesKt.to(Integer.valueOf(call.getCode()), call.getBody());
    }
}
