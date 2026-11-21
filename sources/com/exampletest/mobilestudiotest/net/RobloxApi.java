package com.exampletest.mobilestudiotest.net;

import android.content.Context;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.io.ByteArrayInputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.zip.GZIPInputStream;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;
import kotlinx.coroutines.scheduling.WorkQueueKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: RobloxApi.kt */
@Metadata(d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\r\bÆ\u0002\u0018\u00002\u00020\u0001:\bHIJKLMNOB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0002J2\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u0012\u0010\u0014\u001a\u00020\u00072\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002J\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\u0006\u0010\u0006\u001a\u00020\u0007J\u0018\u0010\u0019\u001a\n \u001a*\u0004\u0018\u00010\u00050\u00052\u0006\u0010\u001b\u001a\u00020\u0005H\u0002J.\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\n2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00182\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0018J*\u0010 \u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050!2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00070\u00182\b\b\u0002\u0010\"\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&J\u000e\u0010'\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&J\u001e\u0010(\u001a\u00020)2\u0006\u0010%\u001a\u00020&2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010'\u001a\u00020\u0005J\u0016\u0010*\u001a\u00020)2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010+\u001a\u00020,2\u0006\u0010%\u001a\u00020&J\u0016\u0010-\u001a\u00020)2\u0006\u0010%\u001a\u00020&2\u0006\u0010.\u001a\u00020\u0005J\u000e\u0010/\u001a\u00020,2\u0006\u0010%\u001a\u00020&J\u000e\u00100\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&J\u000e\u00101\u001a\u00020\u00052\u0006\u0010%\u001a\u00020&J\u000e\u00102\u001a\u00020\u00072\u0006\u0010%\u001a\u00020&J(\u00103\u001a\u00020)2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u00104\u001a\u00020\u00052\b\b\u0002\u00101\u001a\u00020\u0005J,\u00105\u001a\u0002062\b\u0010%\u001a\u0004\u0018\u00010&2\u0006\u0010\u0015\u001a\u0002072\b\u00108\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u00109\u001a\u00020\u0013J\u0018\u0010:\u001a\u0002062\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J<\u0010;\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u00020=0\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u00050<2\u0006\u0010%\u001a\u00020&2\u0006\u00102\u001a\u00020\u00072\u0006\u0010>\u001a\u00020\u00132\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005J\u0015\u0010?\u001a\u0004\u0018\u00010\u00072\u0006\u0010@\u001a\u00020\u0005¢\u0006\u0002\u0010AJ'\u0010B\u001a\u00020C2\u0006\u0010%\u001a\u00020&2\u0006\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010D\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010EJ\u000e\u0010F\u001a\u00020C2\u0006\u0010G\u001a\u00020CR\u000e\u0010#\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxApi;", "", "<init>", "()V", "storeUrl", "", "id", "", "v2Category", "c", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;", "searchPriced", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$Page;", "keyword", "category", "price", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$Price;", "cursor", "num", "", "cents", "q", "Lorg/json/JSONObject;", "previewImages", "", "enc", "kotlin.jvm.PlatformType", "s", "search", "details", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;", "ids", "thumbnailUrls", "", "size", "PREFS", "apiKey", "ctx", "Landroid/content/Context;", "cookie", "setCredentials", "", "setCookie", "isGuest", "", "setApiKey", "key", "hasCredentials", "userName", "displayName", "userId", "setUser", "name", "searchAudio", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioPage;", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioQuery;", "pageToken", "pageSize", "searchAudioLegacy", "inventory", "Lkotlin/Pair;", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$InvItem;", "assetType", "parseAssetId", "text", "(Ljava/lang/String;)Ljava/lang/Long;", "downloadAsset", "", "version", "(Landroid/content/Context;JLjava/lang/Integer;)[B", "ungzip", "b", "Item", "Page", "Price", "Category", "AudioQuery", "AudioItem", "AudioPage", "InvItem", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class RobloxApi {
    public static final RobloxApi INSTANCE = new RobloxApi();
    private static final String PREFS = "roblox_auth";

    /* compiled from: RobloxApi.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\r\u0012\u0006\u0010\u000e\u001a\u00020\u0005¢\u0006\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioItem;", "", "id", "", "name", "", "artist", "title", "seconds", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "creator", "verified", "", "album", "<init>", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getArtist", "getTitle", "getSeconds", "()I", "getType", "getCreator", "getVerified", "()Z", "getAlbum", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class AudioItem {
        private final String album;
        private final String artist;
        private final String creator;
        private final long id;
        private final String name;
        private final int seconds;
        private final String title;
        private final String type;
        private final boolean verified;

        public AudioItem(long j, String name, String artist, String title, int i, String type, String creator, boolean z, String album) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(artist, "artist");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(type, "type");
            Intrinsics.checkNotNullParameter(creator, "creator");
            Intrinsics.checkNotNullParameter(album, "album");
            this.id = j;
            this.name = name;
            this.artist = artist;
            this.title = title;
            this.seconds = i;
            this.type = type;
            this.creator = creator;
            this.verified = z;
            this.album = album;
        }

        public final String getAlbum() {
            return this.album;
        }

        public final String getArtist() {
            return this.artist;
        }

        public final String getCreator() {
            return this.creator;
        }

        public final long getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }

        public final int getSeconds() {
            return this.seconds;
        }

        public final String getTitle() {
            return this.title;
        }

        public final String getType() {
            return this.type;
        }

        public final boolean getVerified() {
            return this.verified;
        }
    }

    /* compiled from: RobloxApi.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001f\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioPage;", "", "items", "", "Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioItem;", "nextToken", "", "<init>", "(Ljava/util/List;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getNextToken", "()Ljava/lang/String;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class AudioPage {
        private final List<AudioItem> items;
        private final String nextToken;

        public AudioPage(List<AudioItem> items, String str) {
            Intrinsics.checkNotNullParameter(items, "items");
            this.items = items;
            this.nextToken = str;
        }

        public final List<AudioItem> getItems() {
            return this.items;
        }

        public final String getNextToken() {
            return this.nextToken;
        }
    }

    /* compiled from: RobloxApi.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0011\u0018\u00002\u00020\u0001BQ\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxApi$AudioQuery;", "", "keyword", "", ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "sort", "minSeconds", "", "maxSeconds", "chart", "artist", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getKeyword", "()Ljava/lang/String;", "getType", "getSort", "getMinSeconds", "()I", "getMaxSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getChart", "getArtist", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class AudioQuery {
        private final String artist;
        private final String chart;
        private final String keyword;
        private final Integer maxSeconds;
        private final int minSeconds;
        private final String sort;
        private final String type;

        public AudioQuery() {
            this(null, null, null, 0, null, null, null, WorkQueueKt.MASK, null);
        }

        public AudioQuery(String keyword, String str, String sort, int i, Integer num, String chart, String artist) {
            Intrinsics.checkNotNullParameter(keyword, "keyword");
            Intrinsics.checkNotNullParameter(sort, "sort");
            Intrinsics.checkNotNullParameter(chart, "chart");
            Intrinsics.checkNotNullParameter(artist, "artist");
            this.keyword = keyword;
            this.type = str;
            this.sort = sort;
            this.minSeconds = i;
            this.maxSeconds = num;
            this.chart = chart;
            this.artist = artist;
        }

        public /* synthetic */ AudioQuery(String str, String str2, String str3, int i, Integer num, String str4, String str5, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? null : str2, (i2 & 4) != 0 ? "Relevance" : str3, (i2 & 8) != 0 ? 0 : i, (i2 & 16) != 0 ? null : num, (i2 & 32) != 0 ? "None" : str4, (i2 & 64) != 0 ? "" : str5);
        }

        public final String getArtist() {
            return this.artist;
        }

        public final String getChart() {
            return this.chart;
        }

        public final String getKeyword() {
            return this.keyword;
        }

        public final Integer getMaxSeconds() {
            return this.maxSeconds;
        }

        public final int getMinSeconds() {
            return this.minSeconds;
        }

        public final String getSort() {
            return this.sort;
        }

        public final String getType() {
            return this.type;
        }
    }

    /* compiled from: RobloxApi.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0019\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxApi$Category;", "", "id", "", "label", "", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "getId", "()I", "getLabel", "()Ljava/lang/String;", "MODELS", "DECALS", "AUDIO", "MESHES", "PLUGINS", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public enum Category {
        MODELS(10, "Models"),
        DECALS(13, "Decals"),
        AUDIO(3, "Audio"),
        MESHES(40, "Meshes"),
        PLUGINS(38, "Plugins");

        private final int id;
        private final String label;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        Category(int i, String str) {
            this.id = i;
            this.label = str;
        }

        public static EnumEntries<Category> getEntries() {
            return $ENTRIES;
        }

        public final int getId() {
            return this.id;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* compiled from: RobloxApi.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxApi$InvItem;", "", "id", "", "name", "", "created", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getCreated", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class InvItem {
        private final String created;
        private final long id;
        private final String name;

        public InvItem(long j, String name, String created) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(created, "created");
            this.id = j;
            this.name = name;
            this.created = created;
        }

        public final String getCreated() {
            return this.created;
        }

        public final long getId() {
            return this.id;
        }

        public final String getName() {
            return this.name;
        }
    }

    /* compiled from: RobloxApi.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b.\u0018\u00002\u00020\u0001B½\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\u0006\u0010\r\u001a\u00020\b\u0012\u0006\u0010\u000e\u001a\u00020\b\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u000b\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0018\u001a\u00020\b\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u0005¢\u0006\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\f\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010%R\u0011\u0010\r\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\"R\u0011\u0010\u000e\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\"R\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001dR\u0011\u0010\u0010\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b*\u0010%R\u0011\u0010\u0011\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010%R\u0011\u0010\u0012\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010%R\u0011\u0010\u0013\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010%R\u0011\u0010\u0014\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b.\u0010%R\u0011\u0010\u0015\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\u001fR\u0011\u0010\u0016\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b0\u0010\u001fR\u0011\u0010\u0017\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u001dR\u0011\u0010\u0018\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b2\u0010\"R\u0011\u0010\u0019\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b3\u0010\u001fR\u0011\u00104\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b4\u0010\"R\u0011\u00105\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b6\u0010\u001fR\u0011\u00107\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b8\u0010%¨\u00069"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxApi$Item;", "", "id", "", "name", "", "creator", "verified", "", "description", "upVotes", "", "downVotes", "hasScripts", "endorsed", "priceCents", "scriptCount", "meshParts", "triangles", "animations", "sounds", "created", "updated", "creatorId", "creatorIsGroup", "category", "<init>", "(JLjava/lang/String;Ljava/lang/String;ZLjava/lang/String;IIZZJIIIIILjava/lang/String;Ljava/lang/String;JZLjava/lang/String;)V", "getId", "()J", "getName", "()Ljava/lang/String;", "getCreator", "getVerified", "()Z", "getDescription", "getUpVotes", "()I", "getDownVotes", "getHasScripts", "getEndorsed", "getPriceCents", "getScriptCount", "getMeshParts", "getTriangles", "getAnimations", "getSounds", "getCreated", "getUpdated", "getCreatorId", "getCreatorIsGroup", "getCategory", "isPaid", "priceText", "getPriceText", "likePercent", "getLikePercent", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Item {
        private final int animations;
        private final String category;
        private final String created;
        private final String creator;
        private final long creatorId;
        private final boolean creatorIsGroup;
        private final String description;
        private final int downVotes;
        private final boolean endorsed;
        private final boolean hasScripts;
        private final long id;
        private final int meshParts;
        private final String name;
        private final long priceCents;
        private final int scriptCount;
        private final int sounds;
        private final int triangles;
        private final int upVotes;
        private final String updated;
        private final boolean verified;

        public Item(long j, String name, String creator, boolean z, String description, int i, int i2, boolean z2, boolean z3, long j2, int i3, int i4, int i5, int i6, int i7, String created, String updated, long j3, boolean z4, String category) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(creator, "creator");
            Intrinsics.checkNotNullParameter(description, "description");
            Intrinsics.checkNotNullParameter(created, "created");
            Intrinsics.checkNotNullParameter(updated, "updated");
            Intrinsics.checkNotNullParameter(category, "category");
            this.id = j;
            this.name = name;
            this.creator = creator;
            this.verified = z;
            this.description = description;
            this.upVotes = i;
            this.downVotes = i2;
            this.hasScripts = z2;
            this.endorsed = z3;
            this.priceCents = j2;
            this.scriptCount = i3;
            this.meshParts = i4;
            this.triangles = i5;
            this.animations = i6;
            this.sounds = i7;
            this.created = created;
            this.updated = updated;
            this.creatorId = j3;
            this.creatorIsGroup = z4;
            this.category = category;
        }

        public /* synthetic */ Item(long j, String str, String str2, boolean z, String str3, int i, int i2, boolean z2, boolean z3, long j2, int i3, int i4, int i5, int i6, int i7, String str4, String str5, long j3, boolean z4, String str6, int i8, DefaultConstructorMarker defaultConstructorMarker) {
            this(j, str, str2, z, str3, i, i2, z2, z3, (i8 & 512) != 0 ? 0L : j2, (i8 & 1024) != 0 ? 0 : i3, (i8 & 2048) != 0 ? 0 : i4, (i8 & 4096) != 0 ? 0 : i5, (i8 & 8192) != 0 ? 0 : i6, (i8 & 16384) != 0 ? 0 : i7, (32768 & i8) != 0 ? "" : str4, (65536 & i8) != 0 ? "" : str5, (131072 & i8) != 0 ? 0L : j3, (262144 & i8) != 0 ? false : z4, (i8 & 524288) != 0 ? "" : str6);
        }

        public final int getAnimations() {
            return this.animations;
        }

        public final String getCategory() {
            return this.category;
        }

        public final String getCreated() {
            return this.created;
        }

        public final String getCreator() {
            return this.creator;
        }

        public final long getCreatorId() {
            return this.creatorId;
        }

        public final boolean getCreatorIsGroup() {
            return this.creatorIsGroup;
        }

        public final String getDescription() {
            return this.description;
        }

        public final int getDownVotes() {
            return this.downVotes;
        }

        public final boolean getEndorsed() {
            return this.endorsed;
        }

        public final boolean getHasScripts() {
            return this.hasScripts;
        }

        public final long getId() {
            return this.id;
        }

        public final int getLikePercent() {
            if (this.upVotes + this.downVotes > 0) {
                return (this.upVotes * 100) / (this.upVotes + this.downVotes);
            }
            return -1;
        }

        public final int getMeshParts() {
            return this.meshParts;
        }

        public final String getName() {
            return this.name;
        }

        public final long getPriceCents() {
            return this.priceCents;
        }

        public final String getPriceText() {
            if (this.priceCents <= 0) {
                return "Free";
            }
            String format = String.format("%d.%02d", Arrays.copyOf(new Object[]{Long.valueOf(this.priceCents / 100), Long.valueOf(this.priceCents % 100)}, 2));
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            return "$" + format;
        }

        public final int getScriptCount() {
            return this.scriptCount;
        }

        public final int getSounds() {
            return this.sounds;
        }

        public final int getTriangles() {
            return this.triangles;
        }

        public final int getUpVotes() {
            return this.upVotes;
        }

        public final String getUpdated() {
            return this.updated;
        }

        public final boolean getVerified() {
            return this.verified;
        }

        public final boolean isPaid() {
            return this.priceCents > 0;
        }
    }

    /* compiled from: RobloxApi.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u00002\u00020\u0001B'\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxApi$Page;", "", "ids", "", "", "nextCursor", "", "total", "", "<init>", "(Ljava/util/List;Ljava/lang/String;I)V", "getIds", "()Ljava/util/List;", "getNextCursor", "()Ljava/lang/String;", "getTotal", "()I", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Page {
        private final List<Long> ids;
        private final String nextCursor;
        private final int total;

        public Page(List<Long> ids, String str, int i) {
            Intrinsics.checkNotNullParameter(ids, "ids");
            this.ids = ids;
            this.nextCursor = str;
            this.total = i;
        }

        public final List<Long> getIds() {
            return this.ids;
        }

        public final String getNextCursor() {
            return this.nextCursor;
        }

        public final int getTotal() {
            return this.total;
        }
    }

    /* compiled from: RobloxApi.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/RobloxApi$Price;", "", "label", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "ANY", "FREE", "PAID", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public enum Price {
        ANY("Any price"),
        FREE("Free"),
        PAID("Paid");

        private final String label;
        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        Price(String str) {
            this.label = str;
        }

        public static EnumEntries<Price> getEntries() {
            return $ENTRIES;
        }

        public final String getLabel() {
            return this.label;
        }
    }

    /* compiled from: RobloxApi.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Category.values().length];
            try {
                iArr[Category.MODELS.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[Category.DECALS.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[Category.AUDIO.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[Category.MESHES.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr[Category.PLUGINS.ordinal()] = 5;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private RobloxApi() {
    }

    private final long cents(JSONObject q) {
        if (q == null) {
            return 0L;
        }
        long optLong = q.optLong("significand");
        int optInt = q.optInt("exponent");
        if (optLong == 0) {
            return 0L;
        }
        return Math.round(optLong * Math.pow(10.0d, optInt + 2));
    }

    public static /* synthetic */ byte[] downloadAsset$default(RobloxApi robloxApi, Context context, long j, Integer num, int i, Object obj) {
        if ((i & 4) != 0) {
            num = null;
        }
        return robloxApi.downloadAsset(context, j, num);
    }

    private final String enc(String s) {
        return URLEncoder.encode(s, "UTF-8");
    }

    public static /* synthetic */ Page search$default(RobloxApi robloxApi, String str, Category category, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            category = Category.MODELS;
        }
        if ((i2 & 4) != 0) {
            str2 = null;
        }
        if ((i2 & 8) != 0) {
            i = 30;
        }
        return robloxApi.search(str, category, str2, i);
    }

    public static /* synthetic */ AudioPage searchAudio$default(RobloxApi robloxApi, Context context, AudioQuery audioQuery, String str, int i, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = 30;
        }
        return robloxApi.searchAudio(context, audioQuery, str, i);
    }

    public static /* synthetic */ Page searchPriced$default(RobloxApi robloxApi, String str, Category category, Price price, String str2, int i, int i2, Object obj) {
        if ((i2 & 16) != 0) {
            i = 30;
        }
        return robloxApi.searchPriced(str, category, price, str2, i);
    }

    public static /* synthetic */ void setUser$default(RobloxApi robloxApi, Context context, long j, String str, String str2, int i, Object obj) {
        if ((i & 8) != 0) {
            str2 = "";
        }
        robloxApi.setUser(context, j, str, str2);
    }

    public static /* synthetic */ Map thumbnailUrls$default(RobloxApi robloxApi, List list, String str, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "150x150";
        }
        return robloxApi.thumbnailUrls(list, str);
    }

    private final String v2Category(Category c) {
        switch (WhenMappings.$EnumSwitchMapping$0[c.ordinal()]) {
            case 1:
                return "Model";
            case 2:
                return "Decal";
            case 3:
                return "Audio";
            case 4:
                return "MeshPart";
            case 5:
                return "Plugin";
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final String apiKey(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String string = ctx.getSharedPreferences(PREFS, 0).getString("apiKey", "");
        return string != null ? string : "";
    }

    public final String cookie(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String string = ctx.getSharedPreferences(PREFS, 0).getString("cookie", "");
        return string != null ? string : "";
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x010e  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x015c  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x017e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x018b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0187  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0117  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.util.List<com.exampletest.mobilestudiotest.net.RobloxApi.Item> details(java.util.List<java.lang.Long> r47) {
        /*
            Method dump skipped, instructions count: 574
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxApi.details(java.util.List):java.util.List");
    }

    public final String displayName(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String string = ctx.getSharedPreferences(PREFS, 0).getString("displayName", "");
        return string != null ? string : "";
    }

    /* JADX WARN: Code restructure failed: missing block: B:4:0x0038, code lost:
    
        if (r0 != null) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:91:0x016d A[Catch: Exception -> 0x01ac, TryCatch #1 {Exception -> 0x01ac, blocks: (B:82:0x014d, B:84:0x0153, B:85:0x015a, B:87:0x0162, B:91:0x016d, B:93:0x0182), top: B:81:0x014d }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0182 A[Catch: Exception -> 0x01ac, TRY_LEAVE, TryCatch #1 {Exception -> 0x01ac, blocks: (B:82:0x014d, B:84:0x0153, B:85:0x015a, B:87:0x0162, B:91:0x016d, B:93:0x0182), top: B:81:0x014d }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final byte[] downloadAsset(android.content.Context r26, long r27, java.lang.Integer r29) {
        /*
            Method dump skipped, instructions count: 679
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxApi.downloadAsset(android.content.Context, long, java.lang.Integer):byte[]");
    }

    public final boolean hasCredentials(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (apiKey(ctx).length() > 0) {
            return true;
        }
        return cookie(ctx).length() > 0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:9:0x005a, code lost:
    
        if (r2 != null) goto L15;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final kotlin.Pair<java.util.List<com.exampletest.mobilestudiotest.net.RobloxApi.InvItem>, java.lang.String> inventory(android.content.Context r19, long r20, int r22, java.lang.String r23) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxApi.inventory(android.content.Context, long, int, java.lang.String):kotlin.Pair");
    }

    public final boolean isGuest(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return cookie(ctx).length() == 0;
    }

    public final Long parseAssetId(String text) {
        List<String> groupValues;
        String str;
        Intrinsics.checkNotNullParameter(text, "text");
        String obj = StringsKt.trim((CharSequence) text).toString();
        Long longOrNull = StringsKt.toLongOrNull(obj);
        if (longOrNull != null) {
            return Long.valueOf(longOrNull.longValue());
        }
        MatchResult find$default = Regex.find$default(new Regex("(?:[?&]id=|/asset/|/library/|/catalog/|/store/asset/|/plugins/|/models/|rbxassetid://)(\\d+)", RegexOption.IGNORE_CASE), obj, 0, 2, null);
        if (find$default == null || (groupValues = find$default.getGroupValues()) == null || (str = groupValues.get(1)) == null) {
            return null;
        }
        return StringsKt.toLongOrNull(str);
    }

    public final List<Long> previewImages(long id) {
        JSONArray jSONArray;
        JSONObject optJSONObject;
        try {
            JSONObject optJSONObject2 = Http.json$default(Http.INSTANCE, "https://apis.roblox.com/toolbox-service/v2/assets/" + id, null, 2, null).optJSONObject("asset");
            if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("previewAssets")) == null || (jSONArray = optJSONObject.optJSONArray("imagePreviewAssets")) == null) {
                jSONArray = new JSONArray();
            }
            IntRange until = RangesKt.until(0, jSONArray.length());
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
            Iterator<Integer> it = until.iterator();
            while (it.hasNext()) {
                arrayList.add(Long.valueOf(jSONArray.optLong(((IntIterator) it).nextInt())));
            }
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((Number) obj).longValue() != 0) {
                    arrayList2.add(obj);
                }
            }
            return arrayList2;
        } catch (Exception e) {
            return CollectionsKt.emptyList();
        }
    }

    public final Page search(String keyword, Category category, String cursor, int num) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Intrinsics.checkNotNullParameter(category, "category");
        StringBuilder sb = new StringBuilder("https://apis.roblox.com/toolbox-service/v1/marketplace/" + category.getId() + "?num=" + num + "&includeOnlyVerifiedCreators=false");
        if (!StringsKt.isBlank(keyword)) {
            sb.append("&keyword=").append(enc(StringsKt.trim((CharSequence) keyword).toString()));
        }
        if (cursor != null) {
            sb.append("&cursor=").append(enc(cursor));
        }
        Http http = Http.INSTANCE;
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "toString(...)");
        JSONObject json$default = Http.json$default(http, sb2, null, 2, null);
        JSONArray optJSONArray = json$default.optJSONArray("data");
        if (optJSONArray == null) {
            optJSONArray = new JSONArray();
        }
        IntRange until = RangesKt.until(0, optJSONArray.length());
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            arrayList.add(Long.valueOf(optJSONArray.getJSONObject(((IntIterator) it).nextInt()).getLong("id")));
        }
        ArrayList arrayList2 = arrayList;
        String optString = json$default.optString("nextPageCursor");
        Intrinsics.checkNotNull(optString);
        return new Page(arrayList2, (optString.length() > 0) && !Intrinsics.areEqual(optString, "null") ? optString : null, json$default.optInt("totalResults"));
    }

    /* JADX WARN: Removed duplicated region for block: B:79:0x0256  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.exampletest.mobilestudiotest.net.RobloxApi.AudioPage searchAudio(android.content.Context r30, com.exampletest.mobilestudiotest.net.RobloxApi.AudioQuery r31, java.lang.String r32, int r33) {
        /*
            Method dump skipped, instructions count: 698
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxApi.searchAudio(android.content.Context, com.exampletest.mobilestudiotest.net.RobloxApi$AudioQuery, java.lang.String, int):com.exampletest.mobilestudiotest.net.RobloxApi$AudioPage");
    }

    public final AudioPage searchAudioLegacy(String keyword, String cursor) {
        Intrinsics.checkNotNullParameter(keyword, "keyword");
        Page search$default = search$default(this, keyword, Category.AUDIO, cursor, 0, 8, null);
        List chunked = CollectionsKt.chunked(search$default.getIds(), 30);
        ArrayList arrayList = new ArrayList();
        Iterator it = chunked.iterator();
        while (it.hasNext()) {
            CollectionsKt.addAll(arrayList, INSTANCE.details((List) it.next()));
        }
        ArrayList<Item> arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        for (Item item : arrayList2) {
            arrayList3.add(new AudioItem(item.getId(), item.getName(), item.getCreator(), item.getName(), 0, "", item.getCreator(), item.getVerified(), ""));
        }
        return new AudioPage(arrayList3, search$default.getNextCursor());
    }

    /* JADX WARN: Code restructure failed: missing block: B:28:0x0103, code lost:
    
        if ((r0.longValue() != 0) != false) goto L32;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.exampletest.mobilestudiotest.net.RobloxApi.Page searchPriced(java.lang.String r30, com.exampletest.mobilestudiotest.net.RobloxApi.Category r31, com.exampletest.mobilestudiotest.net.RobloxApi.Price r32, java.lang.String r33, int r34) {
        /*
            Method dump skipped, instructions count: 336
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.net.RobloxApi.searchPriced(java.lang.String, com.exampletest.mobilestudiotest.net.RobloxApi$Category, com.exampletest.mobilestudiotest.net.RobloxApi$Price, java.lang.String, int):com.exampletest.mobilestudiotest.net.RobloxApi$Page");
    }

    public final void setApiKey(Context ctx, String key) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(key, "key");
        ctx.getSharedPreferences(PREFS, 0).edit().putString("apiKey", StringsKt.trim((CharSequence) key).toString()).apply();
    }

    public final void setCookie(Context ctx, String cookie) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        ctx.getSharedPreferences(PREFS, 0).edit().putString("cookie", StringsKt.trim((CharSequence) StringsKt.removePrefix(StringsKt.trim((CharSequence) cookie).toString(), (CharSequence) ".ROBLOSECURITY=")).toString()).apply();
    }

    public final void setCredentials(Context ctx, String apiKey, String cookie) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(apiKey, "apiKey");
        Intrinsics.checkNotNullParameter(cookie, "cookie");
        ctx.getSharedPreferences(PREFS, 0).edit().putString("apiKey", StringsKt.trim((CharSequence) apiKey).toString()).putString("cookie", StringsKt.trim((CharSequence) StringsKt.removePrefix(StringsKt.trim((CharSequence) cookie).toString(), (CharSequence) ".ROBLOSECURITY=")).toString()).apply();
    }

    public final void setUser(Context ctx, long id, String name, String displayName) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        ctx.getSharedPreferences(PREFS, 0).edit().putLong("userId", id).putString("userName", name).putString("displayName", displayName).apply();
    }

    public final String storeUrl(long id) {
        return "https://create.roblox.com/store/asset/" + id;
    }

    public final Map<Long, String> thumbnailUrls(List<Long> ids, String size) {
        Intrinsics.checkNotNullParameter(ids, "ids");
        Intrinsics.checkNotNullParameter(size, "size");
        JSONObject json$default = Http.json$default(Http.INSTANCE, "https://thumbnails.roblox.com/v1/assets?assetIds=" + CollectionsKt.joinToString$default(ids, ",", null, null, 0, null, null, 62, null) + "&size=" + size + "&format=Png&isCircular=false", null, 2, null);
        HashMap hashMap = new HashMap();
        JSONArray optJSONArray = json$default.optJSONArray("data");
        if (optJSONArray == null) {
            return hashMap;
        }
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObject = optJSONArray.getJSONObject(i);
            long optLong = jSONObject.optLong("targetId");
            String optString = jSONObject.optString("state");
            if (Intrinsics.areEqual(optString, "Completed")) {
                hashMap.put(Long.valueOf(optLong), jSONObject.optString("imageUrl"));
            } else if (Intrinsics.areEqual(optString, "Pending")) {
                hashMap.put(Long.valueOf(optLong), "");
            }
        }
        return hashMap;
    }

    public final byte[] ungzip(byte[] b) {
        Intrinsics.checkNotNullParameter(b, "b");
        if (b.length <= 2 || b[0] != 31 || b[1] != -117) {
            return b;
        }
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(b));
        try {
            byte[] readBytes = ByteStreamsKt.readBytes(gZIPInputStream);
            CloseableKt.closeFinally(gZIPInputStream, null);
            return readBytes;
        } finally {
        }
    }

    public final long userId(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return ctx.getSharedPreferences(PREFS, 0).getLong("userId", 0L);
    }

    public final String userName(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        String string = ctx.getSharedPreferences(PREFS, 0).getString("userName", "");
        return string != null ? string : "";
    }
}
