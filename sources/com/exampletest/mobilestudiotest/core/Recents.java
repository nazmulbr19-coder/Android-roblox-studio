package com.exampletest.mobilestudiotest.core;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Recents.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\r2\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/Recents;", "", "<init>", "()V", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "ctx", "Landroid/content/Context;", "list", "", "Lcom/exampletest/mobilestudiotest/core/Recents$Entry;", "add", "", "e", "remove", "Entry", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class Recents {
    public static final Recents INSTANCE = new Recents();

    /* compiled from: Recents.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0017\u001a\u00020\u0003R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0016¨\u0006\u0018"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/Recents$Entry;", "", "name", "", "placeId", "", "universeId", "uri", "time", "userId", "<init>", "(Ljava/lang/String;JJLjava/lang/String;JJ)V", "getName", "()Ljava/lang/String;", "getPlaceId", "()J", "getUniverseId", "getUri", "getTime", "getUserId", "isCloud", "", "()Z", "key", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Entry {
        private final String name;
        private final long placeId;
        private final long time;
        private final long universeId;
        private final String uri;
        private final long userId;

        public Entry(String name, long j, long j2, String str, long j3, long j4) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.name = name;
            this.placeId = j;
            this.universeId = j2;
            this.uri = str;
            this.time = j3;
            this.userId = j4;
        }

        public /* synthetic */ Entry(String str, long j, long j2, String str2, long j3, long j4, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? 0L : j2, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? System.currentTimeMillis() : j3, (i & 32) != 0 ? 0L : j4);
        }

        public final String getName() {
            return this.name;
        }

        public final long getPlaceId() {
            return this.placeId;
        }

        public final long getTime() {
            return this.time;
        }

        public final long getUniverseId() {
            return this.universeId;
        }

        public final String getUri() {
            return this.uri;
        }

        public final long getUserId() {
            return this.userId;
        }

        public final boolean isCloud() {
            return this.placeId != 0;
        }

        public final String key() {
            StringBuilder append;
            if (isCloud()) {
                append = new StringBuilder().append("p:").append(this.placeId);
            } else {
                append = new StringBuilder().append("f:").append(this.uri);
            }
            return append.toString();
        }
    }

    private Recents() {
    }

    private final SharedPreferences prefs(Context ctx) {
        return ctx.getApplicationContext().getSharedPreferences("recents", 0);
    }

    public final void add(Context ctx, Entry e) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(e, "e");
        List<Entry> list = list(ctx);
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.areEqual(((Entry) obj).key(), e.key())) {
                arrayList.add(obj);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        mutableList.add(0, e);
        JSONArray jSONArray = new JSONArray();
        for (Entry entry : CollectionsKt.take(mutableList, 40)) {
            JSONObject put = new JSONObject().put("name", entry.getName()).put("placeId", entry.getPlaceId()).put("universeId", entry.getUniverseId());
            String uri = entry.getUri();
            if (uri == null) {
                uri = "";
            }
            jSONArray.put(put.put("uri", uri).put("time", entry.getTime()).put("userId", entry.getUserId()));
        }
        prefs(ctx).edit().putString("list", jSONArray.toString()).apply();
    }

    public final List<Entry> list(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String string = prefs(ctx).getString("list", null);
        if (string == null) {
            return CollectionsKt.emptyList();
        }
        try {
            JSONArray jSONArray = new JSONArray(string);
            IntRange until = RangesKt.until(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                JSONObject jSONObject = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                String optString = jSONObject.optString("name");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                long optLong = jSONObject.optLong("placeId");
                long optLong2 = jSONObject.optLong("universeId");
                String optString2 = jSONObject.optString("uri");
                if (optString2.length() == 0) {
                    optString2 = null;
                }
                arrayList.add(new Entry(optString, optLong, optLong2, optString2, jSONObject.optLong("time"), jSONObject.optLong("userId")));
            }
            return arrayList;
        } catch (Exception e) {
            return CollectionsKt.emptyList();
        }
    }

    public final void remove(Context ctx, Entry e) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(e, "e");
        List<Entry> list = list(ctx);
        ArrayList<Entry> arrayList = new ArrayList();
        for (Object obj : list) {
            if (!Intrinsics.areEqual(((Entry) obj).key(), e.key())) {
                arrayList.add(obj);
            }
        }
        JSONArray jSONArray = new JSONArray();
        for (Entry entry : arrayList) {
            JSONObject put = new JSONObject().put("name", entry.getName()).put("placeId", entry.getPlaceId()).put("universeId", entry.getUniverseId());
            String uri = entry.getUri();
            if (uri == null) {
                uri = "";
            }
            jSONArray.put(put.put("uri", uri).put("time", entry.getTime()).put("userId", entry.getUserId()));
        }
        prefs(ctx).edit().putString("list", jSONArray.toString()).apply();
    }
}
