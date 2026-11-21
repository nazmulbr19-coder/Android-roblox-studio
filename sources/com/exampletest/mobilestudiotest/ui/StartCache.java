package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.content.SharedPreferences;
import com.exampletest.mobilestudiotest.net.RobloxCloud;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: StartScreen.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\f\u001a\n \u000e*\u0004\u0018\u00010\r0\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u0010J\u0018\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\u00140\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J(\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001a2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0007J.\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00062\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00160\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u0007J<\u0010\u001f\u001a(\u0012\u0004\u0012\u00020!\u0012\u001c\u0012\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001a0 0\u001a\u0018\u00010 2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0006J>\u0010#\u001a\u00020\u00122\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u00062\u0006\u0010$\u001a\u00020!2\u001e\u0010\u001e\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001a0 0\u001aR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001d\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006%"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/StartCache;", "", "<init>", "()V", "icons", "", "", "", "getIcons", "()Ljava/util/Map;", "groupIcons", "getGroupIcons", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "ctx", "Landroid/content/Context;", "forget", "", "gameJson", "Lorg/json/JSONObject;", "g", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;", "gameOf", "o", "games", "", "uid", "kind", "putGames", "list", "groups", "Lkotlin/Pair;", "", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Group;", "putGroups", "inGroups", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StartCache {
    public static final StartCache INSTANCE = new StartCache();
    private static final Map<Long, String> icons = new ConcurrentHashMap();
    private static final Map<Long, String> groupIcons = new ConcurrentHashMap();

    private StartCache() {
    }

    private final JSONObject gameJson(RobloxCloud.Game g) {
        return new JSONObject().put("u", g.getUniverseId()).put("n", g.getName()).put("r", g.getRootPlaceId()).put("t", g.getUpdated()).put("o", g.getOwner()).put("g", g.getGroupId());
    }

    private final RobloxCloud.Game gameOf(JSONObject o) {
        long optLong = o.optLong("u");
        String optString = o.optString("n");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        long optLong2 = o.optLong("r");
        String optString2 = o.optString("t");
        Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
        String optString3 = o.optString("o");
        Intrinsics.checkNotNullExpressionValue(optString3, "optString(...)");
        return new RobloxCloud.Game(optLong, optString, optLong2, optString2, optString3, o.optLong("g"));
    }

    public static /* synthetic */ List games$default(StartCache startCache, Context context, long j, String str, int i, Object obj) {
        if ((i & 4) != 0) {
            str = "games";
        }
        return startCache.games(context, j, str);
    }

    private final SharedPreferences prefs(Context ctx) {
        return ctx.getSharedPreferences("start_cache", 0);
    }

    public static /* synthetic */ void putGames$default(StartCache startCache, Context context, long j, List list, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "games";
        }
        startCache.putGames(context, j, list, str);
    }

    public final void forget(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        prefs(ctx).edit().clear().apply();
    }

    public final List<RobloxCloud.Game> games(Context ctx, long uid, String kind) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(kind, "kind");
        try {
        } catch (Exception e) {
        }
        try {
            String string = prefs(ctx).getString(kind + "_" + uid, null);
            if (string == null) {
                return null;
            }
            JSONArray jSONArray = new JSONArray(string);
            IntRange until = RangesKt.until(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                StartCache startCache = INSTANCE;
                JSONObject jSONObject = jSONArray.getJSONObject(nextInt);
                Intrinsics.checkNotNullExpressionValue(jSONObject, "getJSONObject(...)");
                arrayList.add(startCache.gameOf(jSONObject));
                jSONArray = jSONArray;
            }
            return arrayList;
        } catch (Exception e2) {
            return null;
        }
    }

    public final Map<Long, String> getGroupIcons() {
        return groupIcons;
    }

    public final Map<Long, String> getIcons() {
        return icons;
    }

    public final Pair<Integer, List<Pair<RobloxCloud.Group, List<RobloxCloud.Game>>>> groups(Context ctx, long uid) {
        String str = "optString(...)";
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            try {
                String string = prefs(ctx).getString("groups_" + uid, null);
                if (string == null) {
                    return null;
                }
                JSONObject jSONObject = new JSONObject(string);
                JSONArray jSONArray = jSONObject.getJSONArray("list");
                Integer valueOf = Integer.valueOf(jSONObject.optInt("in"));
                IntRange until = RangesKt.until(0, jSONArray.length());
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it = until.iterator();
                while (it.hasNext()) {
                    JSONObject jSONObject2 = jSONArray.getJSONObject(((IntIterator) it).nextInt());
                    JSONArray jSONArray2 = jSONObject2.getJSONArray("games");
                    long optLong = jSONObject2.optLong("id");
                    String optString = jSONObject2.optString("name");
                    Intrinsics.checkNotNullExpressionValue(optString, str);
                    String optString2 = jSONObject2.optString("role");
                    Intrinsics.checkNotNullExpressionValue(optString2, str);
                    String str2 = str;
                    RobloxCloud.Group group = new RobloxCloud.Group(optLong, optString, optString2, jSONObject2.optInt("rank"));
                    IntRange until2 = RangesKt.until(0, jSONArray2.length());
                    JSONObject jSONObject3 = jSONObject;
                    JSONArray jSONArray3 = jSONArray;
                    ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(until2, 10));
                    IntRange intRange = until2;
                    Iterator<Integer> it2 = intRange.iterator();
                    while (it2.hasNext()) {
                        int nextInt = ((IntIterator) it2).nextInt();
                        StartCache startCache = INSTANCE;
                        IntRange intRange2 = intRange;
                        JSONObject jSONObject4 = jSONArray2.getJSONObject(nextInt);
                        Intrinsics.checkNotNullExpressionValue(jSONObject4, "getJSONObject(...)");
                        arrayList2.add(startCache.gameOf(jSONObject4));
                        intRange = intRange2;
                        until2 = until2;
                    }
                    arrayList.add(TuplesKt.to(group, arrayList2));
                    jSONArray = jSONArray3;
                    jSONObject = jSONObject3;
                    str = str2;
                }
                return TuplesKt.to(valueOf, arrayList);
            } catch (Exception e) {
                return null;
            }
        } catch (Exception e2) {
        }
    }

    public final void putGames(Context ctx, long uid, List<RobloxCloud.Game> list, String kind) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(kind, "kind");
        JSONArray jSONArray = new JSONArray();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            jSONArray.put(INSTANCE.gameJson((RobloxCloud.Game) it.next()));
        }
        prefs(ctx).edit().putString(kind + "_" + uid, jSONArray.toString()).apply();
    }

    public final void putGroups(Context ctx, long uid, int inGroups, List<? extends Pair<RobloxCloud.Group, ? extends List<RobloxCloud.Game>>> list) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(list, "list");
        JSONArray jSONArray = new JSONArray();
        for (Pair<RobloxCloud.Group, ? extends List<RobloxCloud.Game>> pair : list) {
            RobloxCloud.Group component1 = pair.component1();
            List<RobloxCloud.Game> component2 = pair.component2();
            JSONObject put = new JSONObject().put("id", component1.getId()).put("name", component1.getName()).put("role", component1.getRole()).put("rank", component1.getRank());
            JSONArray jSONArray2 = new JSONArray();
            Iterator<T> it = component2.iterator();
            while (it.hasNext()) {
                jSONArray2.put(INSTANCE.gameJson((RobloxCloud.Game) it.next()));
            }
            Unit unit = Unit.INSTANCE;
            jSONArray.put(put.put("games", jSONArray2));
        }
        prefs(ctx).edit().putString("groups_" + uid, new JSONObject().put("in", inGroups).put("list", jSONArray).toString()).apply();
    }
}
