package com.exampletest.mobilestudiotest.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* compiled from: ImageLoader.kt */
@Metadata(d1 = {"\u0000m\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0007*\u0001\u0007\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001dJ\u0017\u0010\"\u001a\u0004\u0018\u00010\u00102\b\u0010#\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010$J\u0017\u0010%\u001a\u0004\u0018\u00010\u00102\u0006\u0010#\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010$J\u0012\u0010'\u001a\u0004\u0018\u00010\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u000bJ\u0012\u0010(\u001a\u0004\u0018\u00010)2\b\u0010#\u001a\u0004\u0018\u00010\u000bJ\u0010\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u000bJ\u0010\u0010,\u001a\u0004\u0018\u00010)2\u0006\u0010+\u001a\u00020\u000bJ\u0012\u0010-\u001a\u0004\u0018\u00010\u00052\u0006\u0010+\u001a\u00020\u000bH\u0002J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000bH\u0002J\b\u0010/\u001a\u00020\u0018H\u0002J\u0018\u00100\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\u000bH\u0002J\u0018\u00107\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000b2\u0006\u00108\u001a\u00020)H\u0002J\u0010\u00109\u001a\u00020\u00182\u0006\u0010+\u001a\u00020\u000bH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\bRN\u0010\t\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u000b0\u000b\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0011\u001a\n \f*\u0004\u0018\u00010\u00120\u0012X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\u0013\u001aB\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r \f* \u0012\f\u0012\n \f*\u0004\u0018\u00010\u00100\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\r0\r\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010\u0015\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00180\u00170\u0016¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020 0\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u000b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00104\u001a\u0002032\u0006\u00102\u001a\u000203@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b5\u00106¨\u0006:"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/ImageLoader;", "", "<init>", "()V", "cacheDir", "Ljava/io/File;", "mem", "com/exampletest/mobilestudiotest/net/ImageLoader$mem$1", "Lcom/exampletest/mobilestudiotest/net/ImageLoader$mem$1;", "pending", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "kotlin.jvm.PlatformType", "", "failed", "Ljava/util/concurrent/ConcurrentHashMap;", "", "pool", "Ljava/util/concurrent/ExecutorService;", "idQueue", "batchScheduled", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "init", "ctx", "Landroid/content/Context;", "idRx", "", "Lkotlin/text/Regex;", "idMemo", "assetId", "content", "(Ljava/lang/String;)Ljava/lang/Long;", "parseId", "keyMemo", "keyFor", "get", "Landroid/graphics/Bitmap;", "getKey", "key", "peekKey", "diskFile", "loadFromDisk", "scheduleBatch", "fetchUrl", "url", "value", "", "epoch", "getEpoch", "()I", "done", "b", "fail", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ImageLoader {
    private static volatile boolean batchScheduled;
    private static File cacheDir;
    private static volatile int epoch;
    public static final ImageLoader INSTANCE = new ImageLoader();
    private static final ImageLoader$mem$1 mem = new ImageLoader$mem$1((int) Math.min(41943040L, Runtime.getRuntime().maxMemory() / 10));
    private static final ConcurrentHashMap.KeySetView<String, Boolean> pending = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap<String, Long> failed = new ConcurrentHashMap<>();
    private static final ExecutorService pool = Executors.newFixedThreadPool(4);
    private static final ConcurrentHashMap.KeySetView<Long, Boolean> idQueue = ConcurrentHashMap.newKeySet();
    private static final CopyOnWriteArrayList<Function1<String, Unit>> listeners = new CopyOnWriteArrayList<>();
    private static final List<Regex> idRx = CollectionsKt.listOf((Object[]) new Regex[]{new Regex("rbxassetid://(\\d+)", RegexOption.IGNORE_CASE), new Regex("[?&]id=(\\d+)", RegexOption.IGNORE_CASE), new Regex("^\\s*(\\d+)\\s*$"), new Regex("rbxthumb://.*id=(\\d+)", RegexOption.IGNORE_CASE)});
    private static final ConcurrentHashMap<String, Long> idMemo = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Long, String> keyMemo = new ConcurrentHashMap<>();

    private ImageLoader() {
    }

    private final File diskFile(String key) {
        File file = cacheDir;
        if (file == null) {
            return null;
        }
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-1");
        byte[] bytes = key.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
        byte[] digest = messageDigest.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "digest(...)");
        return new File(file, ArraysKt.joinToString$default(digest, (CharSequence) "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) new ImageLoader$$ExternalSyntheticLambda2(), 30, (Object) null) + ".png");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence diskFile$lambda$7(byte b) {
        String format = String.format("%02x", Arrays.copyOf(new Object[]{Byte.valueOf(b)}, 1));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    private final void done(String key, Bitmap b) {
        mem.put(key, b);
        epoch++;
        pending.remove(key);
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((Function1) it.next()).invoke(key);
        }
    }

    private final void fail(String key) {
        pending.remove(key);
        failed.put(key, Long.valueOf(System.currentTimeMillis()));
    }

    private final void fetchUrl(String key, String url) {
        String str;
        try {
            String host = new URL(url).getHost();
            Intrinsics.checkNotNullExpressionValue(host, "getHost(...)");
            str = host.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, "toLowerCase(...)");
        } catch (Exception e) {
            str = "";
        }
        try {
            try {
                if (!WebPermissions.INSTANCE.isRobloxHost(str)) {
                    throw new IOException("not a Roblox image");
                }
                byte[] bArr = Http.get$default(Http.INSTANCE, url, null, 8388608, 2, null);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (decodeByteArray == null) {
                    throw new Exception("bad image");
                }
                File diskFile = diskFile(key);
                if (diskFile != null) {
                    try {
                        FilesKt.writeBytes(diskFile, bArr);
                    } catch (Exception e2) {
                    }
                }
                done(key, decodeByteArray);
            } catch (Exception e3) {
                fail(key);
            }
        } catch (Exception e4) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void getKey$lambda$6(String str) {
        INSTANCE.loadFromDisk(str);
    }

    private final void loadFromDisk(String key) {
        Bitmap bitmap;
        File diskFile = diskFile(key);
        if (diskFile != null && diskFile.isFile()) {
            try {
                bitmap = BitmapFactory.decodeFile(diskFile.getPath());
            } catch (Throwable th) {
                bitmap = null;
            }
            if (bitmap != null) {
                done(key, bitmap);
                return;
            }
        }
        if (StringsKt.startsWith$default(key, "url:", false, 2, (Object) null)) {
            fetchUrl(key, StringsKt.removePrefix(key, (CharSequence) "url:"));
        } else if (!StringsKt.startsWith$default(key, "asset:", false, 2, (Object) null)) {
            fail(key);
        } else {
            idQueue.add(Long.valueOf(Long.parseLong(StringsKt.removePrefix(key, (CharSequence) "asset:"))));
            scheduleBatch();
        }
    }

    private final Long parseId(String content) {
        if (StringsKt.startsWith(content, "rbxasset://", true) && !StringsKt.startsWith(content, "rbxassetid://", true)) {
            return null;
        }
        Iterator<Regex> it = idRx.iterator();
        while (it.hasNext()) {
            MatchResult find$default = Regex.find$default(it.next(), content, 0, 2, null);
            if (find$default != null) {
                return StringsKt.toLongOrNull(find$default.getGroupValues().get(1));
            }
        }
        return null;
    }

    private final void scheduleBatch() {
        if (batchScheduled) {
            return;
        }
        batchScheduled = true;
        pool.execute(new ImageLoader$$ExternalSyntheticLambda3());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void scheduleBatch$lambda$9() {
        Thread.sleep(80L);
        ImageLoader imageLoader = INSTANCE;
        batchScheduled = false;
        ConcurrentHashMap.KeySetView<Long, Boolean> idQueue2 = idQueue;
        Intrinsics.checkNotNullExpressionValue(idQueue2, "idQueue");
        List<Long> take = CollectionsKt.take(CollectionsKt.toList(idQueue2), 100);
        idQueue.removeAll(CollectionsKt.toSet(take));
        ConcurrentHashMap.KeySetView<Long, Boolean> idQueue3 = idQueue;
        Intrinsics.checkNotNullExpressionValue(idQueue3, "idQueue");
        if (!idQueue3.isEmpty()) {
            INSTANCE.scheduleBatch();
        }
        if (take.isEmpty()) {
            return;
        }
        try {
            Map<Long, String> thumbnailUrls = RobloxApi.INSTANCE.thumbnailUrls(take, "420x420");
            for (Long l : take) {
                String str = thumbnailUrls.get(l);
                if (str == null) {
                    INSTANCE.fail("asset:" + l);
                } else if (str.length() == 0) {
                    pending.remove("asset:" + l);
                    failed.put("asset:" + l, Long.valueOf(System.currentTimeMillis() - 55000));
                } else {
                    pool.execute(new ImageLoader$$ExternalSyntheticLambda1(l, str));
                }
            }
        } catch (Exception e) {
            Iterator<Long> it = take.iterator();
            while (it.hasNext()) {
                INSTANCE.fail("asset:" + it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void scheduleBatch$lambda$9$lambda$8(Long l, String str) {
        INSTANCE.fetchUrl("asset:" + l, str);
    }

    public final Long assetId(String content) {
        String str = content;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        Long l = idMemo.get(content);
        if (l != null) {
            long longValue = l.longValue();
            if (longValue >= 0) {
                return Long.valueOf(longValue);
            }
            return null;
        }
        Long parseId = parseId(content);
        if (idMemo.size() > 50000) {
            idMemo.clear();
        }
        idMemo.put(content, Long.valueOf(parseId != null ? parseId.longValue() : -1L));
        return parseId;
    }

    public final Bitmap get(String content) {
        String keyFor = keyFor(content);
        if (keyFor == null) {
            return null;
        }
        return getKey(keyFor);
    }

    public final int getEpoch() {
        return epoch;
    }

    public final Bitmap getKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        Bitmap bitmap = mem.get(key);
        if (bitmap != null) {
            return bitmap;
        }
        Long l = failed.get(key);
        if ((l != null && System.currentTimeMillis() - l.longValue() < 60000) || !pending.add(key)) {
            return null;
        }
        pool.execute(new ImageLoader$$ExternalSyntheticLambda0(key));
        return null;
    }

    public final CopyOnWriteArrayList<Function1<String, Unit>> getListeners() {
        return listeners;
    }

    public final void init(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (cacheDir == null) {
            File file = new File(ctx.getCacheDir(), "img");
            file.mkdirs();
            cacheDir = file;
        }
    }

    public final String keyFor(String content) {
        String putIfAbsent;
        String str = content;
        if (str == null || StringsKt.isBlank(str)) {
            return null;
        }
        Long assetId = assetId(content);
        if (assetId == null) {
            if (StringsKt.startsWith(content, "http://", true) || StringsKt.startsWith(content, "https://", true)) {
                return "url:" + content;
            }
            return null;
        }
        long longValue = assetId.longValue();
        ConcurrentHashMap<Long, String> concurrentHashMap = keyMemo;
        Long valueOf = Long.valueOf(longValue);
        String str2 = concurrentHashMap.get(valueOf);
        if (str2 == null && (putIfAbsent = concurrentHashMap.putIfAbsent(valueOf, (str2 = "asset:" + longValue))) != null) {
            str2 = putIfAbsent;
        }
        return str2;
    }

    public final Bitmap peekKey(String key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return mem.get(key);
    }
}
