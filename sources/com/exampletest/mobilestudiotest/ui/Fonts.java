package com.exampletest.mobilestudiotest.ui;

import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Build;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.FontValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.google.android.material.card.MaterialCardViewHelper;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Fonts.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001#B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\bH\u0002J\u0018\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J2\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0018\u0010\u0017\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\b0\u00190\u0018H\u0002J\u001e\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u001b\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\"\u0010\u001c\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00140\u001d2\u0006\u0010\u001e\u001a\u00020\u0012H\u0002J\u000e\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\"R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u001f\u001a\u001e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00160\u0007j\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0016`\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Fonts;", "", "<init>", "()V", "assets", "Landroid/content/res/AssetManager;", "cache", "Ljava/util/HashMap;", "", "Landroid/graphics/Typeface;", "Lkotlin/collections/HashMap;", "init", "", "a", "asset", "name", "system", "weight", "", "italic", "", "weighted", "Lcom/exampletest/mobilestudiotest/ui/Fonts$Face;", "files", "", "Lkotlin/Pair;", "forFamily", "familyRaw", "fromEnum", "Lkotlin/Triple;", "v", "faceCache", "of", "c", "Lcom/exampletest/mobilestudiotest/model/Instance;", "Face", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Fonts {
    private static AssetManager assets;
    public static final Fonts INSTANCE = new Fonts();
    private static final HashMap<String, Typeface> cache = new HashMap<>();
    private static final HashMap<Object, Face> faceCache = new HashMap<>();

    /* compiled from: Fonts.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Fonts$Face;", "", "typeface", "Landroid/graphics/Typeface;", "fakeBold", "", "italic", "<init>", "(Landroid/graphics/Typeface;ZZ)V", "getTypeface", "()Landroid/graphics/Typeface;", "getFakeBold", "()Z", "getItalic", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Face {
        private final boolean fakeBold;
        private final boolean italic;
        private final Typeface typeface;

        public Face(Typeface typeface, boolean z, boolean z2) {
            Intrinsics.checkNotNullParameter(typeface, "typeface");
            this.typeface = typeface;
            this.fakeBold = z;
            this.italic = z2;
        }

        public final boolean getFakeBold() {
            return this.fakeBold;
        }

        public final boolean getItalic() {
            return this.italic;
        }

        public final Typeface getTypeface() {
            return this.typeface;
        }
    }

    private Fonts() {
    }

    private final Typeface asset(String name) {
        Typeface typeface;
        synchronized (cache) {
            Typeface typeface2 = cache.get(name);
            if (typeface2 != null) {
                return typeface2;
            }
            try {
                AssetManager assetManager = assets;
                typeface = assetManager != null ? Typeface.createFromAsset(assetManager, "fonts/" + name + ".ttf") : null;
            } catch (Exception e) {
                typeface = null;
            }
            if (typeface == null) {
                return null;
            }
            cache.put(name, typeface);
            return typeface;
        }
    }

    private static final Face forFamily$one(int i, boolean z, String str) {
        Typeface asset = INSTANCE.asset(str);
        if (asset != null) {
            return new Face(asset, i >= 600, z);
        }
        return new Face(INSTANCE.system(i, z), false, z);
    }

    private final Triple<String, Integer, Boolean> fromEnum(int v) {
        Integer valueOf = Integer.valueOf(TypedValues.TransitionType.TYPE_DURATION);
        switch (v) {
            case 0:
                return new Triple<>("LegacyArial", valueOf, false);
            case 1:
                return new Triple<>("Arial", 400, false);
            case 2:
                return new Triple<>("Arial", valueOf, false);
            case 3:
                return new Triple<>("SourceSansPro", 400, false);
            case 4:
                return new Triple<>("SourceSansPro", valueOf, false);
            case 5:
                return new Triple<>("SourceSansPro", Integer.valueOf(MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION), false);
            case 6:
                return new Triple<>("SourceSansPro", 400, true);
            case 7:
                return new Triple<>("AccanthisADFStd", 400, false);
            case 8:
                return new Triple<>("Merriweather", 400, false);
            case 9:
                return new Triple<>("ComicNeueAngular", valueOf, false);
            case 10:
                return new Triple<>("Inconsolata", 400, false);
            case 11:
                return new Triple<>("HighwayGothic", 400, false);
            case 12:
                return new Triple<>("Zekton", 400, false);
            case 13:
                return new Triple<>("PressStart2P", 400, false);
            case 14:
                return new Triple<>("Guru", 400, false);
            case 15:
                return new Triple<>("Balthazar", 400, false);
            case 16:
                return new Triple<>("SourceSansPro", 600, false);
            case 17:
                return new Triple<>("GothamSSm", 400, false);
            case 18:
                return new Triple<>("GothamSSm", 500, false);
            case 19:
                return new Triple<>("GothamSSm", valueOf, false);
            case 20:
                return new Triple<>("GothamSSm", 900, false);
            case 21:
                return new Triple<>("AmaticSC", 400, false);
            case 22:
                return new Triple<>("Bangers", 400, false);
            case 23:
                return new Triple<>("Creepster", 400, false);
            case 24:
                return new Triple<>("DenkOne", 400, false);
            case 25:
                return new Triple<>("Fondamento", 400, false);
            case 26:
                return new Triple<>("FredokaOne", 400, false);
            case 27:
                return new Triple<>("GrenzeGotisch", 400, false);
            case 28:
                return new Triple<>("IndieFlower", 400, false);
            case 29:
                return new Triple<>("JosefinSans", 400, false);
            case 30:
                return new Triple<>("Jura", 400, false);
            case 31:
                return new Triple<>("Kalam", 400, false);
            case 32:
                return new Triple<>("LuckiestGuy", 400, false);
            case 33:
                return new Triple<>("Merriweather", 400, false);
            case 34:
                return new Triple<>("Michroma", 400, false);
            case 35:
                return new Triple<>("Nunito", 400, false);
            case 36:
                return new Triple<>("Oswald", 400, false);
            case 37:
                return new Triple<>("PatrickHand", 400, false);
            case 38:
                return new Triple<>("PermanentMarker", 400, false);
            case 39:
                return new Triple<>("Roboto", 400, false);
            case 40:
                return new Triple<>("RobotoCondensed", 400, false);
            case 41:
                return new Triple<>("RobotoMono", 400, false);
            case 42:
                return new Triple<>("Sarpanch", 400, false);
            case 43:
                return new Triple<>("SpecialElite", 400, false);
            case 44:
                return new Triple<>("TitilliumWeb", 400, false);
            case 45:
                return new Triple<>("Ubuntu", 400, false);
            case 46:
                return new Triple<>("BuilderSans", 400, false);
            case 47:
                return new Triple<>("BuilderSans", 500, false);
            case 48:
                return new Triple<>("BuilderSans", valueOf, false);
            case 49:
                return new Triple<>("BuilderSans", 800, false);
            case 50:
                return new Triple<>("Arimo", 400, false);
            case 51:
                return new Triple<>("Arimo", valueOf, false);
            default:
                return new Triple<>("SourceSansPro", 400, false);
        }
    }

    private final Typeface system(int weight, boolean italic) {
        if (Build.VERSION.SDK_INT >= 28) {
            Typeface create = Typeface.create(Typeface.SANS_SERIF, RangesKt.coerceIn(weight, 100, 900), italic);
            Intrinsics.checkNotNullExpressionValue(create, "create(...)");
            return create;
        }
        Typeface create2 = Typeface.create(Typeface.SANS_SERIF, (weight >= 600 ? 1 : 0) | (italic ? 2 : 0));
        Intrinsics.checkNotNullExpressionValue(create2, "create(...)");
        return create2;
    }

    private final Face weighted(int weight, boolean italic, List<Pair<Integer, String>> files) {
        Object next;
        Iterator<T> it = files.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                int abs = Math.abs(((Number) ((Pair) next).getFirst()).intValue() - weight);
                do {
                    Object next2 = it.next();
                    int abs2 = Math.abs(((Number) ((Pair) next2).getFirst()).intValue() - weight);
                    if (abs > abs2) {
                        next = next2;
                        abs = abs2;
                    }
                } while (it.hasNext());
            }
        } else {
            next = null;
        }
        Intrinsics.checkNotNull(next);
        Pair pair = (Pair) next;
        Typeface asset = asset((String) pair.getSecond());
        boolean z = false;
        if (asset == null) {
            return new Face(system(weight, italic), false, italic);
        }
        if (weight >= 600 && ((Number) pair.getFirst()).intValue() < 600) {
            z = true;
        }
        return new Face(asset, z, italic);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x01e9, code lost:
    
        if (r0.equals("roboto") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:111:?, code lost:
    
        return new com.exampletest.mobilestudiotest.ui.Fonts.Face(system(r14, r15), false, r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x01f3, code lost:
    
        if (r0.equals("robotocondensed") != false) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:130:0x0266, code lost:
    
        if (r0.equals("sourcesans") != false) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:132:0x02b0, code lost:
    
        if (r0.equals("merriweather") != false) goto L111;
     */
    /* JADX WARN: Code restructure failed: missing block: B:134:0x02c0, code lost:
    
        if (r0.equals("gotham") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:140:0x02da, code lost:
    
        if (r0.equals("montserrat") != false) goto L120;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x0318, code lost:
    
        if (r0.equals("buildersans") != false) goto L123;
     */
    /* JADX WARN: Code restructure failed: missing block: B:144:0x032b, code lost:
    
        if (r0.equals("comicneue") != false) goto L126;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0355, code lost:
    
        if (r0.equals("michroma") != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:155:0x0364, code lost:
    
        if (r0.equals("fondamento") != false) goto L138;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0059, code lost:
    
        if (r0.equals("accanthisadfstd") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:?, code lost:
    
        return forFamily$one(r14, r15, "Merriweather");
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0063, code lost:
    
        if (r0.equals("gothamssm") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:?, code lost:
    
        return weighted(r14, r15, kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.Pair[]{kotlin.TuplesKt.to(400, "Montserrat-Regular"), kotlin.TuplesKt.to(500, "Montserrat-Medium"), kotlin.TuplesKt.to(r10, "Montserrat-Bold"), kotlin.TuplesKt.to(900, "Montserrat-Black")}));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0090, code lost:
    
        if (r0.equals("balthazar") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x009a, code lost:
    
        if (r0.equals("highwaygothic") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:?, code lost:
    
        return weighted(r14, r15, kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.Pair[]{kotlin.TuplesKt.to(400, "RobotoCondensed"), kotlin.TuplesKt.to(r10, "RobotoCondensed-Bold")}));
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x003f, code lost:
    
        if (r0.equals("legacyarial") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00d4, code lost:
    
        if (r0.equals("sourcesanspro") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0268, code lost:
    
        if (r15 == false) goto L108;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:?, code lost:
    
        return forFamily$one(r14, r15, "SourceSans-Italic");
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:?, code lost:
    
        return weighted(r14, false, kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.Pair[]{kotlin.TuplesKt.to(java.lang.Integer.valueOf(com.google.android.material.card.MaterialCardViewHelper.DEFAULT_FADE_ANIM_DURATION), "SourceSans-Light"), kotlin.TuplesKt.to(400, "SourceSans-Regular"), kotlin.TuplesKt.to(600, "SourceSans-Semibold"), kotlin.TuplesKt.to(r10, "SourceSans-Bold")}));
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00de, code lost:
    
        if (r0.equals("comicneueangular") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:?, code lost:
    
        return forFamily$one(r14, r15, "ComicNeue");
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00f8, code lost:
    
        if (r0.equals("arimo") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0102, code lost:
    
        if (r0.equals("arial") != false) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x0108, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, "legacyarial") != false) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x013d, code lost:
    
        if (r0.equals("guru") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:?, code lost:
    
        return forFamily$one(r14, r15, "Fondamento");
     */
    /* JADX WARN: Code restructure failed: missing block: B:7:0x010a, code lost:
    
        r9 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x01ab, code lost:
    
        if (r0.equals("zekton") == false) goto L149;
     */
    /* JADX WARN: Code restructure failed: missing block: B:99:?, code lost:
    
        return forFamily$one(r14, r15, "Michroma");
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:?, code lost:
    
        return weighted(r9, r15, kotlin.collections.CollectionsKt.listOf((java.lang.Object[]) new kotlin.Pair[]{kotlin.TuplesKt.to(400, "Arimo-Regular"), kotlin.TuplesKt.to(r10, "Arimo-Bold")}));
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0036. Please report as an issue. */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.exampletest.mobilestudiotest.ui.Fonts.Face forFamily(java.lang.String r13, int r14, boolean r15) {
        /*
            Method dump skipped, instructions count: 1112
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.Fonts.forFamily(java.lang.String, int, boolean):com.exampletest.mobilestudiotest.ui.Fonts$Face");
    }

    public final void init(AssetManager a) {
        Intrinsics.checkNotNullParameter(a, "a");
        assets = a;
    }

    public final Face of(Instance c) {
        Object obj;
        Face forFamily;
        Intrinsics.checkNotNullParameter(c, "c");
        Object obj2 = c.get("FontFace");
        FontValue fontValue = obj2 instanceof FontValue ? (FontValue) obj2 : null;
        if (fontValue == null) {
            Object obj3 = c.get("Font");
            EnumValue enumValue = obj3 instanceof EnumValue ? (EnumValue) obj3 : null;
            obj = Integer.valueOf(enumValue != null ? enumValue.getValue() : 3);
        } else {
            obj = fontValue;
        }
        synchronized (faceCache) {
            Face face = faceCache.get(obj);
            if (face != null) {
                return face;
            }
            if (fontValue != null) {
                if (fontValue.getFamily().length() > 0) {
                    forFamily = INSTANCE.forFamily(fontValue.getFamily(), fontValue.getWeight(), fontValue.getStyle() == 1);
                    faceCache.put(obj, forFamily);
                    return forFamily;
                }
            }
            Triple<String, Integer, Boolean> fromEnum = INSTANCE.fromEnum(((Integer) obj).intValue());
            forFamily = INSTANCE.forFamily(fromEnum.component1(), fromEnum.component2().intValue(), fromEnum.component3().booleanValue());
            faceCache.put(obj, forFamily);
            return forFamily;
        }
    }
}
