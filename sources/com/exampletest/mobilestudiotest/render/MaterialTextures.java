package com.exampletest.mobilestudiotest.render;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: MaterialTextures.kt */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001+B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u000bJ\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\u0006J\u0010\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020\u0007H\u0002J&\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010%2\u0006\u0010!\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u000eH\u0002J\b\u0010'\u001a\u0004\u0018\u00010(J\u0018\u0010*\u001a\u0004\u0018\u00010\u00122\u0006\u0010!\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u000eR\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u001e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e0\rj\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e`\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\u0013\u001aB\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u000e0\u000e \u0015* \u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\u0016\u001aB\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u000e0\u000e \u0015* \u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u00070\u0007\u0012\f\u0012\n \u0015*\u0004\u0018\u00010\u000e0\u000e\u0018\u00010\u00140\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0017\u001a\n \u0015*\u0004\u0018\u00010\u00180\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/MaterialTextures;", "", "<init>", "()V", "names", "", "", "", "doubleTile", "", "app", "Landroid/content/Context;", "available", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "ready", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/exampletest/mobilestudiotest/render/MaterialTextures$MatTex;", "pending", "Ljava/util/concurrent/ConcurrentHashMap$KeySetView;", "kotlin.jvm.PlatformType", "failed", "pool", "Ljava/util/concurrent/ExecutorService;", "value", "epoch", "getEpoch", "()I", "init", "", "ctx", "hasTexture", "material", "exists", "path", "pick", "Lkotlin/Pair;", "modern", "surfaces", "Landroid/graphics/Bitmap;", "surfacesTried", "get", "MatTex"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MaterialTextures {
    private static Context app;
    private static volatile int epoch;
    private static Bitmap surfaces;
    private static boolean surfacesTried;
    public static final MaterialTextures INSTANCE = new MaterialTextures();
    private static final Map<Integer, String> names = MapsKt.mapOf(TuplesKt.to(256, "plastic"), TuplesKt.to(512, "wood"), TuplesKt.to(528, "woodplanks"), TuplesKt.to(784, "marble"), TuplesKt.to(788, "basalt"), TuplesKt.to(800, "slate"), TuplesKt.to(804, "crackedlava"), TuplesKt.to(816, "concrete"), TuplesKt.to(820, "limestone"), TuplesKt.to(832, "granite"), TuplesKt.to(836, "pavement"), TuplesKt.to(848, "brick"), TuplesKt.to(864, "pebble"), TuplesKt.to(880, "cobblestone"), TuplesKt.to(896, "rock"), TuplesKt.to(912, "sandstone"), TuplesKt.to(1040, "corrodedmetal"), TuplesKt.to(1056, "diamondplate"), TuplesKt.to(1072, "foil"), TuplesKt.to(1088, "metal"), TuplesKt.to(1280, "grass"), TuplesKt.to(1284, "leafygrass"), TuplesKt.to(1296, "sand"), TuplesKt.to(1312, "fabric"), TuplesKt.to(1328, "snow"), TuplesKt.to(1344, "mud"), TuplesKt.to(1360, "ground"), TuplesKt.to(1376, "asphalt"), TuplesKt.to(1392, "salt"), TuplesKt.to(1536, "ice"), TuplesKt.to(1552, "glacier"), TuplesKt.to(1568, "glass"), TuplesKt.to(2306, "ceramictiles"), TuplesKt.to(2307, "clayrooftiles"), TuplesKt.to(2308, "roofshingles"), TuplesKt.to(2311, "rubber"));
    private static final Set<String> doubleTile = SetsKt.setOf((Object[]) new String[]{"brick", "cobblestone", "grass", "marble", "woodplanks"});
    private static final HashMap<String, Boolean> available = new HashMap<>();
    private static final ConcurrentHashMap<String, MatTex> ready = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> pending = ConcurrentHashMap.newKeySet();
    private static final ConcurrentHashMap.KeySetView<String, Boolean> failed = ConcurrentHashMap.newKeySet();
    private static final ExecutorService pool = Executors.newSingleThreadExecutor();

    /* compiled from: MaterialTextures.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/MaterialTextures$MatTex;", "", TypedValues.Custom.S_COLOR, "Landroid/graphics/Bitmap;", "normal", "studsPerTile", "", "<init>", "(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;F)V", "getColor", "()Landroid/graphics/Bitmap;", "getNormal", "getStudsPerTile", "()F", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes8.dex */
    public static final class MatTex {
        private final Bitmap color;
        private final Bitmap normal;
        private final float studsPerTile;

        public MatTex(Bitmap bitmap, Bitmap bitmap2, float f) {
            this.color = bitmap;
            this.normal = bitmap2;
            this.studsPerTile = f;
        }

        public final Bitmap getColor() {
            return this.color;
        }

        public final Bitmap getNormal() {
            return this.normal;
        }

        public final float getStudsPerTile() {
            return this.studsPerTile;
        }
    }

    private MaterialTextures() {
    }

    private final boolean exists(String path) {
        Boolean bool;
        synchronized (available) {
            HashMap<String, Boolean> hashMap = available;
            Boolean bool2 = hashMap.get(path);
            if (bool2 == null) {
                Context context = app;
                boolean z = false;
                if (context == null) {
                    return false;
                }
                try {
                    String[] list = context.getAssets().list(StringsKt.substringBeforeLast$default(path, '/', (String) null, 2, (Object) null));
                    if (list != null) {
                        if (ArraysKt.contains(list, StringsKt.substringAfterLast$default(path, '/', (String) null, 2, (Object) null))) {
                            z = true;
                        }
                    }
                } catch (Exception e) {
                }
                bool = Boolean.valueOf(z);
                hashMap.put(path, bool);
            } else {
                bool = bool2;
            }
            return bool.booleanValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void get$lambda$8(String str, Context context, String str2, String str3) {
        Bitmap bitmap;
        InputStream open;
        Bitmap decodeStream;
        try {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                bitmap = null;
                if (Intrinsics.areEqual(str, "plastic")) {
                    decodeStream = null;
                } else {
                    open = context.getAssets().open("materials/" + str2 + "_c.jpg");
                    try {
                        decodeStream = BitmapFactory.decodeStream(open, null, options);
                        CloseableKt.closeFinally(open, null);
                        if (decodeStream == null) {
                            throw new IllegalStateException("bad image");
                        }
                    } finally {
                        try {
                            throw th;
                        } finally {
                        }
                    }
                }
                try {
                    open = context.getAssets().open("materials/" + str2 + "_n.jpg");
                    try {
                        Bitmap decodeStream2 = BitmapFactory.decodeStream(open, null, options);
                        CloseableKt.closeFinally(open, null);
                        bitmap = decodeStream2;
                    } finally {
                    }
                } catch (Exception e) {
                }
            } catch (Exception e2) {
                failed.add(str2);
            }
            if (decodeStream == null && bitmap == null) {
                throw new IllegalStateException("no maps");
            }
            ready.put(str2, new MatTex(decodeStream, bitmap, Intrinsics.areEqual(str, "plastic") ? 4.0f : (Intrinsics.areEqual(str3, "pre2022") && doubleTile.contains(str)) ? 16.0f : 8.0f));
        } finally {
            pending.remove(str2);
            MaterialTextures materialTextures = INSTANCE;
            int i = epoch;
            MaterialTextures materialTextures2 = INSTANCE;
            epoch = i + 1;
        }
    }

    private final Pair<String, String> pick(int material, boolean modern) {
        String str = names.get(Integer.valueOf(material));
        if (str == null) {
            return null;
        }
        if (Intrinsics.areEqual(str, "plastic")) {
            if (modern && exists("materials/modern/plastic_n.jpg")) {
                return TuplesKt.to("modern", str);
            }
            return null;
        }
        String str2 = modern ? "modern" : "pre2022";
        String str3 = modern ? "pre2022" : "modern";
        if (exists("materials/" + str2 + "/" + str + "_c.jpg")) {
            return TuplesKt.to(str2, str);
        }
        if (exists("materials/" + str3 + "/" + str + "_c.jpg")) {
            return TuplesKt.to(str3, str);
        }
        return null;
    }

    public final MatTex get(int material, boolean modern) {
        Context context;
        Pair<String, String> pick = pick(material, modern);
        if (pick == null) {
            return null;
        }
        String component1 = pick.component1();
        String component2 = pick.component2();
        String str = component1 + "/" + component2;
        MatTex matTex = ready.get(str);
        if (matTex != null) {
            return matTex;
        }
        if (failed.contains(str) || !pending.add(str) || (context = app) == null) {
            return null;
        }
        pool.execute(new MaterialTextures$$ExternalSyntheticLambda0(component2, context, str, component1));
        return null;
    }

    public final int getEpoch() {
        return epoch;
    }

    public final boolean hasTexture(int material) {
        return names.containsKey(Integer.valueOf(material));
    }

    public final void init(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (app == null) {
            app = ctx.getApplicationContext();
        }
    }

    public final Bitmap surfaces() {
        if (surfacesTried) {
            return surfaces;
        }
        surfacesTried = true;
        Context context = app;
        Bitmap bitmap = null;
        if (context == null) {
            return null;
        }
        try {
            InputStream open = context.getAssets().open("materials/surfaces.png");
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                options.inScaled = false;
                Unit unit = Unit.INSTANCE;
                Bitmap decodeStream = BitmapFactory.decodeStream(open, null, options);
                CloseableKt.closeFinally(open, null);
                bitmap = decodeStream;
            } finally {
            }
        } catch (Exception e) {
        }
        surfaces = bitmap;
        return surfaces;
    }
}
