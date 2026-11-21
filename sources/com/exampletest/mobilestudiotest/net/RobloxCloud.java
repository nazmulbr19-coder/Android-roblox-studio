package com.exampletest.mobilestudiotest.net;

import android.content.Context;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.exampletest.mobilestudiotest.net.Accounts;
import com.exampletest.mobilestudiotest.net.Http;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RobloxCloud.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0015\bÆ\u0002\u0018\u00002\u00020\u0001:\u0007efghijkB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\b\u001a\n \t*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u001c\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002J8\u0010\u000f\u001a\u00020\u00102\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u00052\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u0005J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002J%\u0010\u0018\u001a\u00020\u0005*\u00020\u00172\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001a\"\u00020\u0005H\u0002¢\u0006\u0002\u0010\u001bJ%\u0010\u001c\u001a\u00020\u001d*\u00020\u00172\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u001a\"\u00020\u0005H\u0002¢\u0006\u0002\u0010\u001eJB\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u00052\u0006\u0010#\u001a\u00020\u001d2\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u001d2\b\b\u0002\u0010&\u001a\u00020'J\u001c\u0010(\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*J\u0012\u0010+\u001a\u0004\u0018\u00010\u00052\u0006\u0010,\u001a\u00020\u0017H\u0002J\u000e\u0010-\u001a\u00020*2\u0006\u0010\r\u001a\u00020\u000eJ\u0010\u0010.\u001a\u0004\u0018\u00010*2\u0006\u0010\r\u001a\u00020\u000eJD\u0010/\u001a\u00020\u00072\u0006\u00100\u001a\u0002012\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u001d2\"\u00102\u001a\u001e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020!03j\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020!`4H\u0002J\u001c\u00105\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*J\u001c\u00106\u001a\b\u0012\u0004\u0012\u0002070 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*J\u0016\u00108\u001a\n\u0012\u0004\u0012\u000207\u0018\u00010 2\u0006\u0010\r\u001a\u00020\u000eJ\u0016\u00109\u001a\u00020:2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*J$\u0010;\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010<\u001a\u0002072\u0006\u0010=\u001a\u00020>J\u001c\u0010?\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010<\u001a\u000207J\"\u0010@\u001a\b\u0012\u0004\u0012\u00020\u001d0A2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001d0 J&\u0010C\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010)\u001a\u00020*2\b\b\u0002\u0010D\u001a\u00020>J6\u0010E\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020G0F2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u001d2\b\b\u0002\u0010I\u001a\u00020\u0005J\u0018\u0010K\u001a\u0004\u0018\u00010L2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\u001dJ\u001e\u0010N\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010M\u001a\u00020\u001d2\u0006\u0010\n\u001a\u00020LJ\"\u0010P\u001a\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010Q\u001a\b\u0012\u0004\u0012\u00020!0 J\u001c\u0010R\u001a\b\u0012\u0004\u0012\u00020G0 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010S\u001a\u00020!J\u000e\u0010T\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020\u001dJ\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020W0 2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u001dJ'\u0010X\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010U\u001a\u00020\u001d2\n\b\u0002\u0010Y\u001a\u0004\u0018\u00010'¢\u0006\u0002\u0010ZJ.\u0010[\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\\\u001a\u00020\u001d2\u0006\u0010U\u001a\u00020\u001d2\u0006\u0010]\u001a\u00020\u00142\u0006\u0010[\u001a\u00020>J \u0010^\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\f2\f\u0010B\u001a\b\u0012\u0004\u0012\u00020\u001d0 J \u0010_\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00050\f2\f\u0010`\u001a\b\u0012\u0004\u0012\u00020\u001d0 J\u0010\u0010a\u001a\u0004\u0018\u00010\u00052\u0006\u0010b\u001a\u00020\u001dJ\u0010\u0010c\u001a\u0004\u0018\u00010*2\u0006\u0010H\u001a\u00020\u0005J\u000e\u0010d\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010J\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020'0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u001dX\u0086T¢\u0006\u0002\n\u0000¨\u0006l"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxCloud;", "", "<init>", "()V", "csrf", "", "resetSession", "", "enc", "kotlin.jvm.PlatformType", "s", "cookieHeader", "", "ctx", "Landroid/content/Context;", "authed", "Lcom/exampletest/mobilestudiotest/net/Http$Response;", "url", "method", "body", "", "contentType", "json", "Lorg/json/JSONObject;", "str", "keys", "", "(Lorg/json/JSONObject;[Ljava/lang/String;)Ljava/lang/String;", "long", "", "(Lorg/json/JSONObject;[Ljava/lang/String;)J", "searchUniverses", "", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;", "creatorType", "targetId", "owner", "groupId", "pages", "", "sharedGames", "user", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$User;", "nextCursor", "j", "currentUser", "cachedUser", "parseUniverses", "arr", "Lorg/json/JSONArray;", "out", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "userGames", "groups", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Group;", "studioGroups", "allGroups", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$GroupList;", "editableGroupGames", "group", "trusted", "", "groupGames", "editable", "", "universeIds", "games", "includeGroups", "createGame", "Lkotlin/Pair;", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;", "name", "description", "avatarTypeNames", "avatarSettings", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$AvatarSettings;", "universeId", "setAvatarSettings", "BASEPLATE_TEMPLATE_PLACE", "filterEditable", "list", "places", "game", "universeOf", "placeId", "versions", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Version;", "downloadPlace", "version", "(Landroid/content/Context;JLjava/lang/Integer;)[B", "publish", "universeId0", "bytes", "gameIcons", "groupIcons", "groupIds", "headshot", "userId", "userByName", "logout", "User", "Game", "Group", "Place", "Version", "GroupList", "AvatarSettings", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RobloxCloud {
    public static final long BASEPLATE_TEMPLATE_PLACE = 95206881;
    public static final RobloxCloud INSTANCE = new RobloxCloud();
    private static final Map<String, Integer> avatarTypeNames = MapsKt.mapOf(TuplesKt.to("MorphToR6", 0), TuplesKt.to("MorphToR15", 1), TuplesKt.to("PlayerChoice", 2));
    private static volatile String csrf;

    /* compiled from: RobloxCloud.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0007\n\u0002\b\f\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxCloud$AvatarSettings;", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "", "collision", "min", "", "", "", "max", "<init>", "(ILjava/lang/Integer;Ljava/util/Map;Ljava/util/Map;)V", "getType", "()I", "getCollision", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getMin", "()Ljava/util/Map;", "getMax", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class AvatarSettings {
        private final Integer collision;
        private final Map<String, Float> max;
        private final Map<String, Float> min;
        private final int type;

        public AvatarSettings(int i, Integer num, Map<String, Float> min, Map<String, Float> max) {
            Intrinsics.checkNotNullParameter(min, "min");
            Intrinsics.checkNotNullParameter(max, "max");
            this.type = i;
            this.collision = num;
            this.min = min;
            this.max = max;
        }

        public final Integer getCollision() {
            return this.collision;
        }

        public final Map<String, Float> getMax() {
            return this.max;
        }

        public final Map<String, Float> getMin() {
            return this.min;
        }

        public final int getType() {
            return this.type;
        }
    }

    /* compiled from: RobloxCloud.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Game;", "", "universeId", "", "name", "", "rootPlaceId", "updated", "owner", "groupId", "<init>", "(JLjava/lang/String;JLjava/lang/String;Ljava/lang/String;J)V", "getUniverseId", "()J", "getName", "()Ljava/lang/String;", "getRootPlaceId", "getUpdated", "getOwner", "getGroupId", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Game {
        private final long groupId;
        private final String name;
        private final String owner;
        private final long rootPlaceId;
        private final long universeId;
        private final String updated;

        public Game(long j, String name, long j2, String updated, String owner, long j3) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(updated, "updated");
            Intrinsics.checkNotNullParameter(owner, "owner");
            this.universeId = j;
            this.name = name;
            this.rootPlaceId = j2;
            this.updated = updated;
            this.owner = owner;
            this.groupId = j3;
        }

        public /* synthetic */ Game(long j, String str, long j2, String str2, String str3, long j3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, j2, str2, str3, (i & 32) != 0 ? 0L : j3);
        }

        public final long getGroupId() {
            return this.groupId;
        }

        public final String getName() {
            return this.name;
        }

        public final String getOwner() {
            return this.owner;
        }

        public final long getRootPlaceId() {
            return this.rootPlaceId;
        }

        public final long getUniverseId() {
            return this.universeId;
        }

        public final String getUpdated() {
            return this.updated;
        }
    }

    /* compiled from: RobloxCloud.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Group;", "", "id", "", "name", "", "role", "rank", "", "<init>", "(JLjava/lang/String;Ljava/lang/String;I)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getRole", "getRank", "()I", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Group {
        private final long id;
        private final String name;
        private final int rank;
        private final String role;

        public Group(long j, String name, String role, int i) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(role, "role");
            this.id = j;
            this.name = name;
            this.role = role;
            this.rank = i;
        }

        public final long getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final int getRank() {
            return this.rank;
        }

        public final String getRole() {
            return this.role;
        }
    }

    /* compiled from: RobloxCloud.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\t\n\u0002\b\u0007\u0018\u00002\u00020\u0001B#\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0004\b\b\u0010\tR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxCloud$GroupList;", "", "groups", "", "Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Group;", "studioListed", "", "", "<init>", "(Ljava/util/List;Ljava/util/Set;)V", "getGroups", "()Ljava/util/List;", "getStudioListed", "()Ljava/util/Set;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class GroupList {
        private final List<Group> groups;
        private final Set<Long> studioListed;

        public GroupList(List<Group> groups, Set<Long> studioListed) {
            Intrinsics.checkNotNullParameter(groups, "groups");
            Intrinsics.checkNotNullParameter(studioListed, "studioListed");
            this.groups = groups;
            this.studioListed = studioListed;
        }

        public final List<Group> getGroups() {
            return this.groups;
        }

        public final Set<Long> getStudioListed() {
            return this.studioListed;
        }
    }

    /* compiled from: RobloxCloud.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Place;", "", "id", "", "name", "", "universeId", "<init>", "(JLjava/lang/String;J)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getUniverseId", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Place {
        private final long id;
        private final String name;
        private final long universeId;

        public Place(long j, String name, long j2) {
            Intrinsics.checkNotNullParameter(name, "name");
            this.id = j;
            this.name = name;
            this.universeId = j2;
        }

        public final long getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final long getUniverseId() {
            return this.universeId;
        }
    }

    /* compiled from: RobloxCloud.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxCloud$User;", "", "id", "", "name", "", "displayName", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getDisplayName", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class User {
        private final String displayName;
        private final long id;
        private final String name;

        public User(long j, String name, String displayName) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(displayName, "displayName");
            this.id = j;
            this.name = name;
            this.displayName = displayName;
        }

        public final String getDisplayName() {
            return this.displayName;
        }

        public final long getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: RobloxCloud.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxCloud$Version;", "", "number", "", "created", "", "published", "", "<init>", "(ILjava/lang/String;Z)V", "getNumber", "()I", "getCreated", "()Ljava/lang/String;", "getPublished", "()Z", "setPublished", "(Z)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Version {
        private final String created;
        private final int number;
        private boolean published;

        public Version(int i, String created, boolean z) {
            Intrinsics.checkNotNullParameter(created, "created");
            this.number = i;
            this.created = created;
            this.published = z;
        }

        public final String getCreated() {
            return this.created;
        }

        public final int getNumber() {
            return this.number;
        }

        public final boolean getPublished() {
            return this.published;
        }

        public final void setPublished(boolean z) {
            this.published = z;
        }
    }

    private RobloxCloud() {
    }

    public static /* synthetic */ Http.Response authed$default(RobloxCloud robloxCloud, Context context, String str, String str2, byte[] bArr, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = "GET";
        }
        return robloxCloud.authed(context, str, str2, (i & 8) != 0 ? null : bArr, (i & 16) != 0 ? null : str3);
    }

    private static final Map<String, Float> avatarSettings$scales(JSONObject jSONObject) {
        if (jSONObject == null) {
            return MapsKt.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (String str : CollectionsKt.listOf((Object[]) new String[]{"height", "width", "head", "bodyType", "proportion"})) {
            if (jSONObject.has(str)) {
                hashMap.put(str, Float.valueOf((float) jSONObject.optDouble(str)));
            }
        }
        return hashMap;
    }

    private final Map<String, String> cookieHeader(Context ctx) {
        String cookie = RobloxApi.INSTANCE.cookie(ctx);
        if (cookie.length() == 0) {
            throw new AuthRequiredException("Sign in to your Roblox account first (tap the account button at the top right).");
        }
        return MapsKt.mapOf(TuplesKt.to("Cookie", ".ROBLOSECURITY=" + cookie));
    }

    public static /* synthetic */ Pair createGame$default(RobloxCloud robloxCloud, Context context, String str, long j, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            j = 0;
        }
        long j2 = j;
        if ((i & 8) != 0) {
            str2 = "";
        }
        return robloxCloud.createGame(context, str, j2, str2);
    }

    private static final long createGame$find(JSONObject jSONObject, String... strArr) {
        for (String str : strArr) {
            long optLong = jSONObject.optLong(str);
            if (optLong != 0) {
                return optLong;
            }
        }
        return 0L;
    }

    public static /* synthetic */ byte[] downloadPlace$default(RobloxCloud robloxCloud, Context context, long j, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return robloxCloud.downloadPlace(context, j, num);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence editable$lambda$19(long j) {
        return "ids=" + j;
    }

    private final String enc(String s) {
        return URLEncoder.encode(s, "UTF-8");
    }

    public static /* synthetic */ List games$default(RobloxCloud robloxCloud, Context context, User user, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = true;
        }
        return robloxCloud.games(context, user, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final GroupList games$lambda$20(Context context, User user) {
        try {
            return INSTANCE.allGroups(context, user);
        } catch (AuthRequiredException e) {
            throw e;
        } catch (Exception e2) {
            return new GroupList(CollectionsKt.emptyList(), SetsKt.emptySet());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List games$lambda$21(Context context, User user) {
        try {
            return INSTANCE.sharedGames(context, user);
        } catch (Exception e) {
            return CollectionsKt.emptyList();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List games$lambda$24$lambda$23(Context context, Group group, GroupList groupList) {
        try {
            RobloxCloud robloxCloud = INSTANCE;
            Intrinsics.checkNotNull(groupList);
            return robloxCloud.editableGroupGames(context, group, groupList.getStudioListed().contains(Long.valueOf(group.getId())));
        } catch (Exception e) {
            return CollectionsKt.emptyList();
        }
    }

    private final JSONObject json(Context ctx, String url) {
        Long longOrNull;
        Http.Response authed$default = authed$default(this, ctx, url, null, null, null, 28, null);
        int i = 0;
        while (true) {
            if ((authed$default.getCode() != 429 && authed$default.getCode() != 503) || i >= 4) {
                break;
            }
            String header = authed$default.header("retry-after");
            try {
                Thread.sleep((header == null || (longOrNull = StringsKt.toLongOrNull(header)) == null) ? 600 << i : RangesKt.coerceIn(longOrNull.longValue(), 1L, 8L) * 1000);
                i++;
                authed$default = authed$default(this, ctx, url, null, null, null, 28, null);
            } catch (InterruptedException e) {
            }
        }
        if (authed$default.getOk()) {
            return new JSONObject(authed$default.getText());
        }
        throw new HttpException(authed$default.getCode(), Http.INSTANCE.describe(authed$default.getCode(), authed$default.getBody()));
    }

    /* renamed from: long, reason: not valid java name */
    private final long m316long(JSONObject jSONObject, String... strArr) {
        for (String str : strArr) {
            Long valueOf = Long.valueOf(jSONObject.optLong(str));
            if (!(valueOf.longValue() != 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                return valueOf.longValue();
            }
        }
        return 0L;
    }

    private final String nextCursor(JSONObject j) {
        String optString = j.optString("nextPageCursor");
        Intrinsics.checkNotNull(optString);
        if ((optString.length() > 0) && !Intrinsics.areEqual(optString, "null")) {
            return optString;
        }
        return null;
    }

    private final void parseUniverses(JSONArray arr, String owner, long groupId, LinkedHashMap<Long, Game> out) {
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = arr.getJSONObject(i);
            long optLong = jSONObject.optLong("id");
            long j = 0;
            if (optLong != 0 && !jSONObject.optBoolean("isArchived")) {
                Long valueOf = Long.valueOf(jSONObject.optLong("rootPlaceId"));
                if (!(valueOf.longValue() != 0)) {
                    valueOf = null;
                }
                if (valueOf != null) {
                    j = valueOf.longValue();
                } else {
                    JSONObject optJSONObject = jSONObject.optJSONObject("rootPlace");
                    Long valueOf2 = optJSONObject != null ? Long.valueOf(optJSONObject.optLong("id")) : null;
                    if (valueOf2 != null) {
                        j = valueOf2.longValue();
                    }
                }
                long j2 = j;
                Long valueOf3 = Long.valueOf(optLong);
                String optString = jSONObject.optString("name");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                String optString2 = jSONObject.optString("updated", jSONObject.optString("updatedAt"));
                Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                out.put(valueOf3, new Game(optLong, optString, j2, optString2, owner, groupId));
            }
        }
    }

    private static final String publish$version(Http.Response response) {
        int i;
        try {
            i = new JSONObject(response.getText()).optInt("versionNumber");
        } catch (Exception e) {
            i = 0;
        }
        return i > 0 ? "version " + i : "done";
    }

    public static /* synthetic */ List searchUniverses$default(RobloxCloud robloxCloud, Context context, String str, long j, String str2, long j2, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str2 = "";
        }
        return robloxCloud.searchUniverses(context, str, j, str2, (i2 & 16) != 0 ? 0L : j2, (i2 & 32) != 0 ? 10 : i);
    }

    private static final JSONObject setAvatarSettings$scales$30(Map<String, Float> map) {
        JSONObject jSONObject = new JSONObject();
        Iterator<Map.Entry<String, Float>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            jSONObject.put(it.next().getKey(), r4.getValue().floatValue());
        }
        if (jSONObject.has("width")) {
            jSONObject.put("depth", jSONObject.getDouble("width"));
        }
        return jSONObject;
    }

    private final String str(JSONObject jSONObject, String... strArr) {
        for (String str : strArr) {
            String optString = jSONObject.optString(str);
            Intrinsics.checkNotNull(optString);
            if (!((optString.length() > 0) && !Intrinsics.areEqual(optString, "null"))) {
                optString = null;
            }
            if (optString != null) {
                return optString;
            }
        }
        return "";
    }

    private static final void studioGroups$read(Context context, Ref.BooleanRef booleanRef, LinkedHashMap<Long, Group> linkedHashMap, String str) {
        try {
            try {
                JSONObject json = INSTANCE.json(context, str);
                JSONArray optJSONArray = json.optJSONArray("data");
                if (optJSONArray == null) {
                    optJSONArray = json.optJSONArray("groups");
                    if (optJSONArray == null) {
                        return;
                    }
                }
                try {
                    booleanRef.element = true;
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            long m316long = INSTANCE.m316long(optJSONObject, "id", "Id", "groupId");
                            if (m316long != 0 && !linkedHashMap.containsKey(Long.valueOf(m316long))) {
                                linkedHashMap.put(Long.valueOf(m316long), new Group(m316long, INSTANCE.str(optJSONObject, "name", "Name"), "", 0));
                            }
                        }
                    }
                } catch (AuthRequiredException e) {
                } catch (Exception e2) {
                }
            } catch (AuthRequiredException e3) {
            } catch (Exception e4) {
            }
        } catch (AuthRequiredException e5) {
            throw e5;
        } catch (Exception e6) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0026, code lost:
    
        if (r4 != null) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void versions$read$37(android.content.Context r21, long r22, java.util.LinkedHashMap<java.lang.Integer, com.exampletest.mobilestudiotest.net.RobloxCloud.Version> r24, java.lang.String r25, boolean r26) {
        /*
            r0 = r26
            r1 = 0
            r2 = 0
        L4:
            r3 = 6
            if (r2 >= r3) goto Le2
            com.exampletest.mobilestudiotest.net.RobloxCloud r3 = com.exampletest.mobilestudiotest.net.RobloxCloud.INSTANCE
            if (r1 == 0) goto L29
            r4 = r1
            r5 = 0
            com.exampletest.mobilestudiotest.net.RobloxCloud r6 = com.exampletest.mobilestudiotest.net.RobloxCloud.INSTANCE
            java.lang.String r6 = r6.enc(r4)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "&cursor="
            java.lang.StringBuilder r7 = r7.append(r8)
            java.lang.StringBuilder r6 = r7.append(r6)
            java.lang.String r4 = r6.toString()
            if (r4 == 0) goto L29
            goto L2b
        L29:
            java.lang.String r4 = ""
        L2b:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "https://develop.roblox.com/v1/assets/"
            java.lang.StringBuilder r5 = r5.append(r6)
            r6 = r22
            java.lang.StringBuilder r5 = r5.append(r6)
            java.lang.String r8 = "/"
            java.lang.StringBuilder r5 = r5.append(r8)
            r8 = r25
            java.lang.StringBuilder r5 = r5.append(r8)
            java.lang.String r9 = "?limit=100&sortOrder=Desc"
            java.lang.StringBuilder r5 = r5.append(r9)
            java.lang.StringBuilder r4 = r5.append(r4)
            java.lang.String r4 = r4.toString()
            r5 = r21
            org.json.JSONObject r3 = r3.json(r5, r4)
            java.lang.String r4 = "data"
            org.json.JSONArray r4 = r3.optJSONArray(r4)
            if (r4 != 0) goto L69
            org.json.JSONArray r4 = new org.json.JSONArray
            r4.<init>()
        L69:
            r9 = 0
            int r10 = r4.length()
        L6e:
            if (r9 >= r10) goto Ld0
            org.json.JSONObject r11 = r4.getJSONObject(r9)
            java.lang.String r12 = "versionNumber"
            int r12 = r11.optInt(r12)
            java.lang.String r13 = "assetVersionNumber"
            int r12 = r11.optInt(r13, r12)
            if (r12 <= 0) goto Lc1
            r13 = r24
            java.util.Map r13 = (java.util.Map) r13
            java.lang.Integer r14 = java.lang.Integer.valueOf(r12)
            r15 = 0
            java.lang.Object r16 = r13.get(r14)
            if (r16 != 0) goto Laf
            r17 = 0
            r18 = r1
            com.exampletest.mobilestudiotest.net.RobloxCloud$Version r1 = new com.exampletest.mobilestudiotest.net.RobloxCloud$Version
            r19 = r2
            java.lang.String r2 = "created"
            java.lang.String r2 = r11.optString(r2)
            r20 = r4
            java.lang.String r4 = "optString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            r1.<init>(r12, r2, r0)
            r13.put(r14, r1)
            goto Lb7
        Laf:
            r18 = r1
            r19 = r2
            r20 = r4
            r1 = r16
        Lb7:
            com.exampletest.mobilestudiotest.net.RobloxCloud$Version r1 = (com.exampletest.mobilestudiotest.net.RobloxCloud.Version) r1
            if (r0 == 0) goto Lc7
            r2 = 1
            r1.setPublished(r2)
            goto Lc7
        Lc1:
            r18 = r1
            r19 = r2
            r20 = r4
        Lc7:
            int r9 = r9 + 1
            r1 = r18
            r2 = r19
            r4 = r20
            goto L6e
        Ld0:
            r18 = r1
            r19 = r2
            r20 = r4
            com.exampletest.mobilestudiotest.net.RobloxCloud r1 = com.exampletest.mobilestudiotest.net.RobloxCloud.INSTANCE
            java.lang.String r1 = r1.nextCursor(r3)
            if (r1 == 0) goto Lec
            int r2 = r19 + 1
            goto L4
        Le2:
            r5 = r21
            r6 = r22
            r8 = r25
            r18 = r1
            r19 = r2
        Lec:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxCloud.versions$read$37(android.content.Context, long, java.util.LinkedHashMap, java.lang.String, boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:53:0x015d, code lost:
    
        if (r7 != null) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.exampletest.mobilestudiotest.net.RobloxCloud.GroupList allGroups(android.content.Context r25, com.exampletest.mobilestudiotest.net.RobloxCloud.User r26) {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxCloud.allGroups(android.content.Context, com.exampletest.mobilestudiotest.net.RobloxCloud$User):com.exampletest.mobilestudiotest.net.RobloxCloud$GroupList");
    }

    public final Http.Response authed(Context ctx, String url, String method, byte[] body, String contentType) {
        Map emptyMap;
        String header;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(method, "method");
        Map<String, String> cookieHeader = cookieHeader(ctx);
        Http http = Http.INSTANCE;
        String str = csrf;
        if (str == null || (emptyMap = MapsKt.mapOf(TuplesKt.to("X-CSRF-TOKEN", str))) == null) {
            emptyMap = MapsKt.emptyMap();
        }
        Http.Response call$default = Http.call$default(http, url, method, MapsKt.plus(cookieHeader, emptyMap), body, contentType, 0, 32, null);
        if (call$default.getCode() == 403 && (header = call$default.header("x-csrf-token")) != null && !Intrinsics.areEqual(header, csrf)) {
            csrf = header;
            call$default = Http.call$default(Http.INSTANCE, url, method, MapsKt.plus(cookieHeader, TuplesKt.to("X-CSRF-TOKEN", header)), body, contentType, 0, 32, null);
        }
        if (call$default.getCode() != 401) {
            return call$default;
        }
        throw new AuthRequiredException("Your Roblox sign-in has expired. Sign in again (account button, top right).");
    }

    public final AvatarSettings avatarSettings(Context ctx, long universeId) {
        int i;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        JSONObject json = json(ctx, "https://develop.roblox.com/v1/universes/" + universeId + "/configuration");
        Integer num = avatarTypeNames.get(json.optString("universeAvatarType"));
        Integer num2 = null;
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        String optString = json.optString("universeCollisionType");
        if (!Intrinsics.areEqual(optString, "OuterBox")) {
            i = Intrinsics.areEqual(optString, "InnerBox") ? 1 : 0;
            return new AvatarSettings(intValue, num2, avatarSettings$scales(json.optJSONObject("universeAvatarMinScales")), avatarSettings$scales(json.optJSONObject("universeAvatarMaxScales")));
        }
        num2 = Integer.valueOf(i);
        return new AvatarSettings(intValue, num2, avatarSettings$scales(json.optJSONObject("universeAvatarMinScales")), avatarSettings$scales(json.optJSONObject("universeAvatarMaxScales")));
    }

    public final User cachedUser(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if ((RobloxApi.INSTANCE.cookie(ctx).length() == 0) || RobloxApi.INSTANCE.userId(ctx) == 0) {
            return null;
        }
        return new User(RobloxApi.INSTANCE.userId(ctx), RobloxApi.INSTANCE.userName(ctx), RobloxApi.INSTANCE.displayName(ctx));
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00fc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Pair<com.exampletest.mobilestudiotest.net.RobloxCloud.Game, com.exampletest.mobilestudiotest.net.RobloxCloud.Place> createGame(android.content.Context r27, java.lang.String r28, long r29, java.lang.String r31) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxCloud.createGame(android.content.Context, java.lang.String, long, java.lang.String):kotlin.Pair");
    }

    public final User currentUser(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        JSONObject json = json(ctx, "https://users.roblox.com/v1/users/authenticated");
        long j = json.getLong("id");
        String optString = json.optString("name");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        String optString2 = json.optString("displayName");
        Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
        User user = new User(j, optString, optString2);
        RobloxApi.INSTANCE.setUser(ctx, user.getId(), user.getName(), user.getDisplayName());
        Accounts.INSTANCE.upsert(ctx, new Accounts.Account(user.getId(), user.getName(), user.getDisplayName(), RobloxApi.INSTANCE.cookie(ctx)));
        return user;
    }

    public final byte[] downloadPlace(Context ctx, long placeId, Integer version) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return RobloxApi.INSTANCE.downloadAsset(ctx, placeId, version);
    }

    public final Set<Long> editable(Context ctx, List<Long> universeIds) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(universeIds, "universeIds");
        HashSet hashSet = new HashSet();
        boolean z = false;
        for (List list : CollectionsKt.chunked(CollectionsKt.distinct(universeIds), 50)) {
            if (!list.isEmpty()) {
                JSONArray optJSONArray = json(ctx, "https://develop.roblox.com/v1/universes/multiget/permissions?" + CollectionsKt.joinToString$default(list, "&", null, null, 0, null, new RobloxCloud$$ExternalSyntheticLambda0(), 30, null)).optJSONArray("data");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        if (jSONObject.has("canManage") || jSONObject.has("canCloudEdit")) {
                            z = true;
                        }
                        if (jSONObject.optBoolean("canManage") || jSONObject.optBoolean("canCloudEdit")) {
                            hashSet.add(Long.valueOf(jSONObject.optLong("universeId")));
                        }
                    }
                }
            }
        }
        if (z) {
            return hashSet;
        }
        throw new IOException("Unrecognized permissions response");
    }

    public final List<Game> editableGroupGames(Context ctx, Group group, boolean trusted) {
        Context context;
        List<Game> list;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(group, "group");
        try {
            context = ctx;
            try {
                list = searchUniverses(context, "Group", group.getId(), group.getName(), group.getId(), 6);
            } catch (AuthRequiredException e) {
                throw e;
            } catch (Exception e2) {
                list = null;
                if (list != null) {
                }
            }
        } catch (AuthRequiredException e3) {
            throw e3;
        } catch (Exception e4) {
            context = ctx;
        }
        return (list != null || list.isEmpty()) ? filterEditable(context, groupGames(context, group)) : trusted ? list : filterEditable(context, list);
    }

    public final List<Game> filterEditable(Context ctx, List<Game> list) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(list, "list");
        if (list.isEmpty()) {
            return list;
        }
        try {
            List<Game> list2 = list;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(((Game) it.next()).getUniverseId()));
            }
            Set<Long> editable = editable(ctx, arrayList);
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list) {
                if (editable.contains(Long.valueOf(((Game) obj).getUniverseId()))) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        } catch (AuthRequiredException e) {
            throw e;
        } catch (Exception e2) {
            return list;
        }
    }

    public final Map<Long, String> gameIcons(List<Long> universeIds) {
        Intrinsics.checkNotNullParameter(universeIds, "universeIds");
        if (universeIds.isEmpty()) {
            return MapsKt.emptyMap();
        }
        HashMap hashMap = new HashMap();
        Iterator it = CollectionsKt.chunked(universeIds, 50).iterator();
        while (it.hasNext()) {
            try {
                JSONArray optJSONArray = Http.json$default(Http.INSTANCE, "https://thumbnails.roblox.com/v1/games/icons?universeIds=" + CollectionsKt.joinToString$default((List) it.next(), ",", null, null, 0, null, null, 62, null) + "&returnPolicy=PlaceHolder&size=150x150&format=Png&isCircular=false", null, 2, null).optJSONArray("data");
                if (optJSONArray != null) {
                    int length = optJSONArray.length();
                    for (int i = 0; i < length; i++) {
                        JSONObject jSONObject = optJSONArray.getJSONObject(i);
                        String optString = jSONObject.optString("imageUrl");
                        Intrinsics.checkNotNull(optString);
                        if (optString.length() > 0) {
                            hashMap.put(Long.valueOf(jSONObject.optLong("targetId")), optString);
                        }
                    }
                }
            } catch (Exception e) {
            }
        }
        return hashMap;
    }

    public final List<Game> games(Context ctx, User user, boolean includeGroups) {
        Future submit;
        GroupList groupList;
        List emptyList;
        List emptyList2;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(user, "user");
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(4);
        if (includeGroups) {
            try {
                submit = newFixedThreadPool.submit(new RobloxCloud$$ExternalSyntheticLambda1(ctx, user));
            } finally {
                newFixedThreadPool.shutdown();
            }
        } else {
            submit = null;
        }
        Future future = submit;
        Future submit2 = newFixedThreadPool.submit(new RobloxCloud$$ExternalSyntheticLambda2(ctx, user));
        ArrayList arrayList = new ArrayList(userGames(ctx, user));
        if (future != null) {
            try {
                groupList = (GroupList) future.get();
            } catch (ExecutionException e) {
                Throwable cause = e.getCause();
                AuthRequiredException authRequiredException = cause instanceof AuthRequiredException ? (AuthRequiredException) cause : null;
                if (authRequiredException != null) {
                    throw authRequiredException;
                }
                groupList = null;
            }
        } else {
            groupList = null;
        }
        GroupList groupList2 = groupList;
        List<Group> groups = groupList2 != null ? groupList2.getGroups() : null;
        if (groups == null) {
            groups = CollectionsKt.emptyList();
        }
        List<Group> list = groups;
        boolean z = false;
        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList2.add(newFixedThreadPool.submit(new RobloxCloud$$ExternalSyntheticLambda3(ctx, (Group) it.next(), groupList2)));
            z = z;
        }
        ArrayList arrayList3 = arrayList2;
        try {
            emptyList = (List) submit2.get();
        } catch (Exception e2) {
            emptyList = CollectionsKt.emptyList();
        }
        arrayList.addAll(emptyList);
        Iterator it2 = arrayList3.iterator();
        while (it2.hasNext()) {
            try {
                emptyList2 = (List) ((Future) it2.next()).get();
            } catch (Exception e3) {
                emptyList2 = CollectionsKt.emptyList();
            }
            arrayList.addAll(emptyList2);
        }
        HashSet hashSet = new HashSet();
        ArrayList arrayList4 = new ArrayList();
        for (Object obj : arrayList) {
            if (hashSet.add(Long.valueOf(((Game) obj).getUniverseId()))) {
                arrayList4.add(obj);
            }
        }
        return arrayList4;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x003a, code lost:
    
        if (r6 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.exampletest.mobilestudiotest.net.RobloxCloud.Game> groupGames(android.content.Context r12, com.exampletest.mobilestudiotest.net.RobloxCloud.Group r13) {
        /*
            r11 = this;
            java.lang.String r1 = "data"
            java.lang.String r0 = "ctx"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "group"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            r7 = r0
            r0 = 0
            r2 = 0
            r8 = r2
        L16:
            r2 = 6
            if (r8 >= r2) goto Lc5
            long r2 = r13.getId()     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            if (r0 == 0) goto L3c
            r4 = r0
            r5 = 0
            com.exampletest.mobilestudiotest.net.RobloxCloud r6 = com.exampletest.mobilestudiotest.net.RobloxCloud.INSTANCE     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.String r6 = r6.enc(r4)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            r9.<init>()     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.String r10 = "&cursor="
            java.lang.StringBuilder r9 = r9.append(r10)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.StringBuilder r6 = r9.append(r6)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            if (r6 != 0) goto L3e
        L3c:
            java.lang.String r6 = ""
        L3e:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            r4.<init>()     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.String r5 = "https://develop.roblox.com/v1/groups/"
            java.lang.StringBuilder r4 = r4.append(r5)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.StringBuilder r2 = r4.append(r2)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.String r3 = "/universes?isArchived=false&limit=50&sortOrder=Desc"
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.StringBuilder r2 = r2.append(r6)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            org.json.JSONObject r2 = r11.json(r12, r2)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            r9 = r2
            org.json.JSONArray r2 = r9.optJSONArray(r1)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            if (r2 != 0) goto L6b
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            r2.<init>()     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
        L6b:
            r3 = r2
            java.lang.String r4 = r13.getName()     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            long r5 = r13.getId()     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            r2 = r11
            r2.parseUniverses(r3, r4, r5, r7)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            java.lang.String r2 = r11.nextCursor(r9)     // Catch: java.lang.Exception -> L82 com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc3
            if (r2 == 0) goto Lc5
            r0 = r2
            int r8 = r8 + 1
            goto L16
        L82:
            r0 = move-exception
            r8 = r0
            long r2 = r13.getId()     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            r0.<init>()     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            java.lang.String r4 = "https://games.roblox.com/v2/groups/"
            java.lang.StringBuilder r0 = r0.append(r4)     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            java.lang.String r2 = "/gamesV2?accessFilter=1&limit=50&sortOrder=Desc"
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            org.json.JSONObject r0 = r11.json(r12, r0)     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            org.json.JSONArray r1 = r0.optJSONArray(r1)     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            if (r1 != 0) goto Lb1
            org.json.JSONArray r1 = new org.json.JSONArray     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            r1.<init>()     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
        Lb1:
            r3 = r1
            java.lang.String r4 = r13.getName()     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            long r5 = r13.getId()     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            r2 = r11
            r2.parseUniverses(r3, r4, r5, r7)     // Catch: java.lang.Exception -> Lbf com.exampletest.mobilestudiotest.net.AuthRequiredException -> Lc1
            goto Lc5
        Lbf:
            r0 = move-exception
            goto Lc5
        Lc1:
            r0 = move-exception
            throw r0
        Lc3:
            r0 = move-exception
            throw r0
        Lc5:
            java.util.Collection r0 = r7.values()
            java.lang.String r1 = "<get-values>(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.List r0 = kotlin.collections.CollectionsKt.toList(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxCloud.groupGames(android.content.Context, com.exampletest.mobilestudiotest.net.RobloxCloud$Group):java.util.List");
    }

    public final Map<Long, String> groupIcons(List<Long> groupIds) {
        JSONArray optJSONArray;
        Intrinsics.checkNotNullParameter(groupIds, "groupIds");
        if (groupIds.isEmpty()) {
            return MapsKt.emptyMap();
        }
        HashMap hashMap = new HashMap();
        try {
            optJSONArray = Http.json$default(Http.INSTANCE, "https://thumbnails.roblox.com/v1/groups/icons?groupIds=" + CollectionsKt.joinToString$default(groupIds, ",", null, null, 0, null, null, 62, null) + "&size=150x150&format=Png&isCircular=false", null, 2, null).optJSONArray("data");
        } catch (Exception e) {
        }
        if (optJSONArray == null) {
            return hashMap;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = optJSONArray.getJSONObject(i);
            String optString = jSONObject.optString("imageUrl");
            Intrinsics.checkNotNull(optString);
            if (optString.length() > 0) {
                hashMap.put(Long.valueOf(jSONObject.optLong("targetId")), optString);
            }
        }
        return hashMap;
    }

    public final List<Group> groups(Context ctx, User user) {
        String str;
        Group group;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(user, "user");
        JSONObject json = json(ctx, "https://groups.roblox.com/v1/users/" + user.getId() + "/groups/roles?includeLocked=true");
        JSONArray optJSONArray = json.optJSONArray("data");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        IntRange until = RangesKt.until(0, optJSONArray.length());
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            JSONObject jSONObject = optJSONArray.getJSONObject(((IntIterator) it).nextInt());
            JSONObject jSONObject2 = json;
            JSONObject optJSONObject = jSONObject.optJSONObject("group");
            if (optJSONObject == null) {
                group = null;
            } else {
                JSONObject optJSONObject2 = jSONObject.optJSONObject("role");
                long optLong = optJSONObject.optLong("id");
                String optString = optJSONObject.optString("name");
                Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                if (optJSONObject2 == null || (str = optJSONObject2.optString("name")) == null) {
                    str = "";
                }
                group = new Group(optLong, optString, str, optJSONObject2 != null ? optJSONObject2.optInt("rank") : 0);
            }
            if (group != null) {
                arrayList.add(group);
            }
            json = jSONObject2;
        }
        return CollectionsKt.sortedWith(arrayList, new RobloxCloud$groups$$inlined$sortedByDescending$1());
    }

    public final String headshot(long userId) {
        String optString;
        try {
            JSONArray optJSONArray = Http.json$default(Http.INSTANCE, "https://thumbnails.roblox.com/v1/users/avatar-headshot?userIds=" + userId + "&size=150x150&format=Png&isCircular=true", null, 2, null).optJSONArray("data");
            if (optJSONArray == null) {
                return null;
            }
            JSONObject optJSONObject = optJSONArray.optJSONObject(0);
            if (optJSONObject == null || (optString = optJSONObject.optString("imageUrl")) == null) {
                return null;
            }
            if (optString.length() > 0) {
                return optString;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 2 */
    public final void logout(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        try {
            authed$default(this, ctx, "https://auth.roblox.com/v2/logout", "POST", null, null, 24, null);
        } catch (Exception e) {
        }
        csrf = null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x003d, code lost:
    
        if (r10 == null) goto L9;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.exampletest.mobilestudiotest.net.RobloxCloud.Place> places(android.content.Context r18, com.exampletest.mobilestudiotest.net.RobloxCloud.Game r19) {
        /*
            r17 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            java.lang.String r0 = "ctx"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "game"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            r4 = r0
            r0 = 0
            r5 = 0
        L19:
            r6 = 5
            if (r5 >= r6) goto La9
            long r6 = r3.getUniverseId()     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            if (r0 == 0) goto L3f
            r8 = r0
            r9 = 0
            com.exampletest.mobilestudiotest.net.RobloxCloud r10 = com.exampletest.mobilestudiotest.net.RobloxCloud.INSTANCE     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.String r10 = r10.enc(r8)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            r11.<init>()     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.String r12 = "&cursor="
            java.lang.StringBuilder r11 = r11.append(r12)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.StringBuilder r10 = r11.append(r10)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.String r10 = r10.toString()     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            if (r10 != 0) goto L41
        L3f:
            java.lang.String r10 = ""
        L41:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            r8.<init>()     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.String r9 = "https://develop.roblox.com/v1/universes/"
            java.lang.StringBuilder r8 = r8.append(r9)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.StringBuilder r6 = r8.append(r6)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.String r7 = "/places?isUniverseCreation=false&limit=100&sortOrder=Asc"
            java.lang.StringBuilder r6 = r6.append(r7)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.StringBuilder r6 = r6.append(r10)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.String r6 = r6.toString()     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            org.json.JSONObject r6 = r1.json(r2, r6)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.String r7 = "data"
            org.json.JSONArray r7 = r6.optJSONArray(r7)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            if (r7 != 0) goto L6f
            org.json.JSONArray r7 = new org.json.JSONArray     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            r7.<init>()     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
        L6f:
            r8 = 0
            int r9 = r7.length()     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
        L74:
            if (r8 >= r9) goto L9a
            org.json.JSONObject r10 = r7.getJSONObject(r8)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            com.exampletest.mobilestudiotest.net.RobloxCloud$Place r11 = new com.exampletest.mobilestudiotest.net.RobloxCloud$Place     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.String r12 = "id"
            long r12 = r10.getLong(r12)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.String r14 = "name"
            java.lang.String r14 = r10.optString(r14)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            java.lang.String r15 = "optString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r14, r15)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            long r15 = r3.getUniverseId()     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            r11.<init>(r12, r14, r15)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            r4.add(r11)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            int r8 = r8 + 1
            goto L74
        L9a:
            java.lang.String r8 = r1.nextCursor(r6)     // Catch: java.lang.Exception -> La5 com.exampletest.mobilestudiotest.net.AuthRequiredException -> La7
            if (r8 == 0) goto La9
            r0 = r8
            int r5 = r5 + 1
            goto L19
        La5:
            r0 = move-exception
            goto La9
        La7:
            r0 = move-exception
            throw r0
        La9:
            boolean r0 = r4.isEmpty()
            if (r0 == 0) goto Lcd
            long r5 = r3.getRootPlaceId()
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 == 0) goto Lcd
            com.exampletest.mobilestudiotest.net.RobloxCloud$Place r5 = new com.exampletest.mobilestudiotest.net.RobloxCloud$Place
            long r6 = r3.getRootPlaceId()
            java.lang.String r8 = r3.getName()
            long r9 = r3.getUniverseId()
            r5.<init>(r6, r8, r9)
            r4.add(r5)
        Lcd:
            r0 = r4
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            r5 = 0
            com.exampletest.mobilestudiotest.net.RobloxCloud$places$$inlined$sortedBy$1 r6 = new com.exampletest.mobilestudiotest.net.RobloxCloud$places$$inlined$sortedBy$1
            r6.<init>(r3)
            java.util.Comparator r6 = (java.util.Comparator) r6
            java.util.List r0 = kotlin.collections.CollectionsKt.sortedWith(r0, r6)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxCloud.places(android.content.Context, com.exampletest.mobilestudiotest.net.RobloxCloud$Game):java.util.List");
    }

    /* JADX WARN: Removed duplicated region for block: B:63:0x0221 A[LOOP:0: B:53:0x01e4->B:63:0x0221, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0225 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String publish(android.content.Context r30, long r31, long r33, byte[] r35, boolean r36) {
        /*
            Method dump skipped, instructions count: 602
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxCloud.publish(android.content.Context, long, long, byte[], boolean):java.lang.String");
    }

    public final void resetSession() {
        csrf = null;
    }

    public final List<Game> searchUniverses(Context ctx, String creatorType, long targetId, String owner, long groupId, int pages) {
        LinkedHashMap linkedHashMap;
        String str;
        LinkedHashMap linkedHashMap2;
        long m316long;
        Context ctx2 = ctx;
        String creatorType2 = creatorType;
        Intrinsics.checkNotNullParameter(ctx2, "ctx");
        String str2 = "creatorType";
        Intrinsics.checkNotNullParameter(creatorType2, "creatorType");
        Intrinsics.checkNotNullParameter(owner, "owner");
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        int i = 0;
        while (true) {
            if (i >= pages) {
                linkedHashMap = linkedHashMap3;
                break;
            }
            JSONObject json = json(ctx2, "https://apis.roblox.com/universes/v1/search?isTemplates=false&isArchived=false&creatorTargetId=" + targetId + "&searchKey=&sortOrder=Desc&search=&creatorType=" + creatorType2 + "&pageSize=50&sortParam=LastUpdated&surface=StudioStartPage&PageIndex=" + i);
            JSONArray optJSONArray = json.optJSONArray("data");
            if (optJSONArray == null && (optJSONArray = json.optJSONArray("Data")) == null) {
                optJSONArray = new JSONArray();
            }
            int i2 = 0;
            int length = optJSONArray.length();
            while (i2 < length) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i2);
                if (optJSONObject == null) {
                    str = str2;
                    linkedHashMap2 = linkedHashMap3;
                } else {
                    long m316long2 = m316long(optJSONObject, "id", "Id", "universeId");
                    if (m316long2 == 0 || optJSONObject.optBoolean("isArchived")) {
                        str = str2;
                        linkedHashMap2 = linkedHashMap3;
                    } else if (optJSONObject.optBoolean("IsArchived")) {
                        str = str2;
                        linkedHashMap2 = linkedHashMap3;
                    } else {
                        if (groupId != 0) {
                            m316long = groupId;
                            str = str2;
                        } else {
                            str = str2;
                            m316long = StringsKt.equals(str(optJSONObject, str2, "CreatorType"), "Group", true) ? m316long(optJSONObject, "creatorTargetId", "CreatorTargetId") : 0L;
                        }
                        LinkedHashMap linkedHashMap4 = linkedHashMap3;
                        Long valueOf = Long.valueOf(m316long2);
                        linkedHashMap2 = linkedHashMap3;
                        String str3 = str(optJSONObject, "name", "Name");
                        long m316long3 = m316long(optJSONObject, "rootPlaceId", "RootPlaceId");
                        String str4 = str(optJSONObject, "updated", "Updated");
                        String str5 = str(optJSONObject, "creatorName", "CreatorName");
                        if (str5.length() == 0) {
                            str5 = owner;
                        }
                        linkedHashMap4.put(valueOf, new Game(m316long2, str3, m316long3, str4, str5, m316long));
                    }
                }
                i2++;
                linkedHashMap3 = linkedHashMap2;
                str2 = str;
            }
            String str6 = str2;
            linkedHashMap = linkedHashMap3;
            if (optJSONArray.length() < 50) {
                break;
            }
            i++;
            ctx2 = ctx;
            creatorType2 = creatorType;
            linkedHashMap3 = linkedHashMap;
            str2 = str6;
        }
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt.toList(values);
    }

    public final void setAvatarSettings(Context ctx, long universeId, AvatarSettings s) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(s, "s");
        JSONObject jSONObject = new JSONObject();
        for (Object obj : avatarTypeNames.entrySet()) {
            if (((Number) ((Map.Entry) obj).getValue()).intValue() == s.getType()) {
                JSONObject put = jSONObject.put("universeAvatarType", ((Map.Entry) obj).getKey());
                Integer collision = s.getCollision();
                if (collision != null) {
                    put.put("universeCollisionType", collision.intValue() == 1 ? "InnerBox" : "OuterBox");
                }
                if (!s.getMin().isEmpty()) {
                    put.put("universeAvatarMinScales", setAvatarSettings$scales$30(s.getMin()));
                }
                if (!s.getMax().isEmpty()) {
                    put.put("universeAvatarMaxScales", setAvatarSettings$scales$30(s.getMax()));
                }
                String jSONObject2 = put.toString();
                Intrinsics.checkNotNullExpressionValue(jSONObject2, "toString(...)");
                byte[] bytes = jSONObject2.getBytes(Charsets.UTF_8);
                Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
                Http.Response authed = authed(ctx, "https://develop.roblox.com/v2/universes/" + universeId + "/configuration", "PATCH", bytes, "application/json");
                if (!authed.getOk()) {
                    throw new HttpException(authed.getCode(), Http.INSTANCE.describe(authed.getCode(), authed.getBody()));
                }
                return;
            }
        }
        throw new NoSuchElementException("Collection contains no element matching the predicate.");
    }

    public final List<Game> sharedGames(Context ctx, User user) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(user, "user");
        return searchUniverses$default(this, ctx, "Team", user.getId(), null, 0L, 0, 56, null);
    }

    public final List<Group> studioGroups(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        studioGroups$read(ctx, booleanRef, linkedHashMap, "https://apis.roblox.com/creator-home-api/v1/groups?surface=StudioStartPage");
        studioGroups$read(ctx, booleanRef, linkedHashMap, "https://develop.roblox.com/v1/user/groups/canmanage");
        if (!booleanRef.element) {
            return null;
        }
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt.toList(values);
    }

    public final long universeOf(long placeId) {
        try {
            return Http.json$default(Http.INSTANCE, "https://apis.roblox.com/universes/v1/places/" + placeId + "/universe", null, 2, null).optLong("universeId");
        } catch (Exception e) {
            return 0L;
        }
    }

    public final User userByName(String name) {
        JSONObject optJSONObject;
        Intrinsics.checkNotNullParameter(name, "name");
        String jSONObject = new JSONObject().put("usernames", new JSONArray().put(StringsKt.trim((CharSequence) name).toString())).put("excludeBannedUsers", true).toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject, "toString(...)");
        Http http = Http.INSTANCE;
        Map emptyMap = MapsKt.emptyMap();
        byte[] bytes = jSONObject.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        Http.Response call$default = Http.call$default(http, "https://users.roblox.com/v1/usernames/users", "POST", emptyMap, bytes, "application/json", 0, 32, null);
        if (!call$default.getOk()) {
            throw new HttpException(call$default.getCode(), Http.INSTANCE.describe(call$default.getCode(), call$default.getBody()));
        }
        JSONArray optJSONArray = new JSONObject(call$default.getText()).optJSONArray("data");
        if (optJSONArray == null || (optJSONObject = optJSONArray.optJSONObject(0)) == null) {
            return null;
        }
        long optLong = optJSONObject.optLong("id");
        String optString = optJSONObject.optString("name");
        Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
        String optString2 = optJSONObject.optString("displayName");
        Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
        return new User(optLong, optString, optString2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0083, code lost:
    
        if (r4 == null) goto L30;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x011f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00db A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d4  */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 3 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.exampletest.mobilestudiotest.net.RobloxCloud.Game> userGames(android.content.Context r16, com.exampletest.mobilestudiotest.net.RobloxCloud.User r17) {
        /*
            Method dump skipped, instructions count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxCloud.userGames(android.content.Context, com.exampletest.mobilestudiotest.net.RobloxCloud$User):java.util.List");
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public final List<Version> versions(Context ctx, long placeId) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Exception exc = null;
        try {
            versions$read$37(ctx, placeId, linkedHashMap, "saved-versions", false);
        } catch (AuthRequiredException e) {
            throw e;
        } catch (Exception e2) {
            exc = e2;
        }
        try {
            versions$read$37(ctx, placeId, linkedHashMap, "published-versions", true);
        } catch (AuthRequiredException e3) {
            throw e3;
        } catch (Exception e4) {
            if (linkedHashMap.isEmpty()) {
                exc = exc == null ? e4 : exc;
            }
        }
        if (linkedHashMap.isEmpty() && exc != null) {
            throw exc;
        }
        Collection values = linkedHashMap.values();
        Intrinsics.checkNotNullExpressionValue(values, "<get-values>(...)");
        return CollectionsKt.sortedWith(values, new RobloxCloud$versions$$inlined$sortedByDescending$1());
    }
}
