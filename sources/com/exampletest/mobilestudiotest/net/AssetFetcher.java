package com.exampletest.mobilestudiotest.net;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.exampletest.mobilestudiotest.format.RbxFile;
import com.exampletest.mobilestudiotest.model.Instance;
import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AssetFetcher.kt */
@Metadata(d1 = {"\u0000i\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001$\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0005J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u001c\u001a\u00020\rH\u0002J\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\u001f\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\rJ\u0010\u0010 \u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\rJ\u0010\u0010!\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010\"\u001a\u00020\u001e2\u0006\u0010\u001c\u001a\u00020\rJ\u0010\u0010-\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\u000e2\u0006\u0010\u001c\u001a\u00020\rJ\u0010\u0010/\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\rJ\u001a\u00100\u001a\u0004\u0018\u00010.2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u00101\u001a\u00020)H\u0002J\u0017\u00102\u001a\u0004\u0018\u00010\r2\b\u00103\u001a\u0004\u0018\u00010\u0001¢\u0006\u0002\u00104R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\u000b\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\r0\r\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\r0\r\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00120\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00160\u00150\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0010\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0004\n\u0002\u0010%RN\u0010&\u001aB\u0012\f\u0012\n \n*\u0004\u0018\u00010\r0\r\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e \n* \u0012\f\u0012\n \n*\u0004\u0018\u00010\r0\r\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\f0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020)2\u0006\u0010(\u001a\u00020)@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006\u0004"}, d2 = {"Lcom/exampletest/mobilestudiotest/net/AssetFetcher;", "", "<init>", "()V", "app", "Landroid/content/Context;", "dir", "Ljava/io/File;", "pool", "Ljava/util/concurrent/ExecutorService;", "kotlin.jvm.PlatformType", "pending", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "", "", "failed", "Ljava/util/concurrent/ConcurrentHashMap;", "errors", "", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function1;", "", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "init", "ctx", "file", "id", "request", "", "isCached", "cacheFile", "lastError", "load", "bitmaps", "com/exampletest/mobilestudiotest/net/AssetFetcher$bitmaps$1", "Lcom/exampletest/mobilestudiotest/net/AssetFetcher$bitmaps$1;", "imagePending", "imageFailed", "value", "", "imageEpoch", "getImageEpoch", "()I", "image", "Landroid/graphics/Bitmap;", "imageBlocking", "loadImage", "depth", "idOf", "content", "(Ljava/lang/Object;)Ljava/lang/Long;"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class AssetFetcher {
    private static Context app;
    private static File dir;
    private static volatile int imageEpoch;
    public static final AssetFetcher INSTANCE = new AssetFetcher();
    private static final ExecutorService pool = Executors.newFixedThreadPool(3);
    private static final ConcurrentHashMap.KeySetView<Long, Boolean> pending = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap<Long, Long> failed = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Long, String> errors = new ConcurrentHashMap<>();
    private static final CopyOnWriteArrayList<Function1<Long, Unit>> listeners = new CopyOnWriteArrayList<>();
    private static final AssetFetcher$bitmaps$1 bitmaps = new AssetFetcher$bitmaps$1((int) Math.min(50331648L, Runtime.getRuntime().maxMemory() / 8));
    private static final ConcurrentHashMap.KeySetView<Long, Boolean> imagePending = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap<Long, Long> imageFailed = new ConcurrentHashMap<>();

    private AssetFetcher() {
    }

    private final File file(long id) {
        File file = dir;
        if (file != null) {
            return new File(file, id + ".bin");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void image$lambda$9(long j) {
        try {
            try {
                Bitmap loadImage = INSTANCE.loadImage(j, 0);
                if (loadImage != null) {
                    bitmaps.put(Long.valueOf(j), loadImage);
                    AssetFetcher assetFetcher = INSTANCE;
                    int i = imageEpoch;
                    AssetFetcher assetFetcher2 = INSTANCE;
                    imageEpoch = i + 1;
                    AssetFetcher assetFetcher3 = INSTANCE;
                    Iterator<T> it = listeners.iterator();
                    while (it.hasNext()) {
                        ((Function1) it.next()).invoke(Long.valueOf(j));
                    }
                } else {
                    imageFailed.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
                }
            } catch (Exception e) {
                imageFailed.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
            }
        } finally {
            imagePending.remove(Long.valueOf(j));
        }
    }

    private final Bitmap loadImage(long id, int depth) {
        byte[] load = load(id);
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(load, 0, load.length);
        if (decodeByteArray != null) {
            return decodeByteArray;
        }
        if (depth > 1) {
            return null;
        }
        try {
            for (Instance instance : RbxFile.INSTANCE.read(load).getRoots()) {
                for (Instance instance2 : CollectionsKt.plus((Collection) CollectionsKt.listOf(instance), (Iterable) Instance.descendants$default(instance, null, 1, null))) {
                    for (String str : CollectionsKt.listOf((Object[]) new String[]{"ShirtTemplate", "PantsTemplate", "Graphic", "Texture", "TextureId", "Image", "ColorMap"})) {
                        ImageLoader imageLoader = ImageLoader.INSTANCE;
                        Object obj = instance2.get(str);
                        Long assetId = imageLoader.assetId(obj != null ? obj.toString() : null);
                        if (assetId != null) {
                            long longValue = assetId.longValue();
                            if (longValue != id) {
                                return loadImage(longValue, depth + 1);
                            }
                        }
                    }
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void request$lambda$5(long j) {
        try {
            try {
                INSTANCE.load(j);
                AssetFetcher assetFetcher = INSTANCE;
                Iterator<T> it = listeners.iterator();
                while (it.hasNext()) {
                    ((Function1) it.next()).invoke(Long.valueOf(j));
                }
            } catch (Exception e) {
                failed.put(Long.valueOf(j), Long.valueOf(System.currentTimeMillis()));
                ConcurrentHashMap<Long, String> concurrentHashMap = errors;
                Long valueOf = Long.valueOf(j);
                String message = e.getMessage();
                if (message == null) {
                    message = e.toString();
                }
                concurrentHashMap.put(valueOf, message);
            }
        } finally {
            pending.remove(Long.valueOf(j));
        }
    }

    public final String cacheFile(long id) {
        File file = file(id);
        if (file == null) {
            return null;
        }
        if (!file.isFile()) {
            file = null;
        }
        if (file != null) {
            return file.getPath();
        }
        return null;
    }

    public final int getImageEpoch() {
        return imageEpoch;
    }

    public final CopyOnWriteArrayList<Function1<Long, Unit>> getListeners() {
        return listeners;
    }

    public final Long idOf(Object content) {
        return ImageLoader.INSTANCE.assetId(content != null ? content.toString() : null);
    }

    public final Bitmap image(long id) {
        Bitmap bitmap = bitmaps.get(Long.valueOf(id));
        if (bitmap != null) {
            return bitmap;
        }
        Long l = imageFailed.get(Long.valueOf(id));
        if ((l != null && System.currentTimeMillis() - l.longValue() < 90000) || !imagePending.add(Long.valueOf(id))) {
            return null;
        }
        pool.execute(new AssetFetcher$$ExternalSyntheticLambda1(id));
        return null;
    }

    public final Bitmap imageBlocking(long id) {
        Bitmap bitmap = bitmaps.get(Long.valueOf(id));
        if (bitmap != null) {
            return bitmap;
        }
        try {
            Bitmap loadImage = loadImage(id, 0);
            if (loadImage == null) {
                return null;
            }
            bitmaps.put(Long.valueOf(id), loadImage);
            AssetFetcher assetFetcher = INSTANCE;
            int i = imageEpoch;
            AssetFetcher assetFetcher2 = INSTANCE;
            imageEpoch = i + 1;
            return loadImage;
        } catch (Exception e) {
            return null;
        }
    }

    public final boolean imageFailed(long id) {
        return imageFailed.containsKey(Long.valueOf(id)) && bitmaps.get(Long.valueOf(id)) == null;
    }

    public final void init(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (app == null) {
            app = ctx.getApplicationContext();
            File file = new File(ctx.getCacheDir(), "assets");
            file.mkdirs();
            dir = file;
        }
    }

    public final boolean isCached(long id) {
        File file = file(id);
        return file != null && file.isFile();
    }

    public final String lastError(long id) {
        return errors.get(Long.valueOf(id));
    }

    public final byte[] load(long id) {
        File file = file(id);
        if (file != null && file.isFile()) {
            return FilesKt.readBytes(file);
        }
        Context context = app;
        if (context == null) {
            throw new IllegalStateException("AssetFetcher.init not called");
        }
        byte[] downloadAsset$default = RobloxApi.downloadAsset$default(RobloxApi.INSTANCE, context, id, null, 4, null);
        if (file != null) {
            try {
                File file2 = new File(file.getPath() + ".tmp");
                FilesKt.writeBytes(file2, downloadAsset$default);
                file2.renameTo(file);
            } catch (Exception e) {
            }
        }
        failed.remove(Long.valueOf(id));
        errors.remove(Long.valueOf(id));
        return downloadAsset$default;
    }

    public final byte[] request(long id) {
        File file = file(id);
        if (file != null) {
            if (!file.isFile()) {
                file = null;
            }
            if (file != null) {
                try {
                    return FilesKt.readBytes(file);
                } catch (Exception e) {
                    return null;
                }
            }
        }
        Long l = failed.get(Long.valueOf(id));
        if ((l != null && System.currentTimeMillis() - l.longValue() < 90000) || !pending.add(Long.valueOf(id))) {
            return null;
        }
        pool.execute(new AssetFetcher$$ExternalSyntheticLambda0(id));
        return null;
    }
}
