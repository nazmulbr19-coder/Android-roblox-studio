package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.model.ClassDb;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.io.FilesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.MatchResult;
import kotlin.text.Regex;
import kotlin.text.RegexOption;
import kotlin.text.StringsKt;

/* compiled from: Icons.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001:\u00011B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\bH\u0002J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001c\u001a\u00020\bJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\bJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u001a\u001a\u00020\bJ\u0016\u0010\u001f\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\bJ \u0010!\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\b2\b\b\u0002\u0010\"\u001a\u00020\bJ\u001e\u0010%\u001a\u00020 2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bJ\u0018\u0010&\u001a\u00020'2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\tH\u0002J\u0010\u0010)\u001a\u00020\b2\u0006\u0010*\u001a\u00020\bH\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u001c\u001a\u00020\bH\u0002J\u0016\u0010-\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010.\u001a\u00020/J\u000e\u00100\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0013R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R.\u0010\u0006\u001a\"\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0007j\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0014\u001a\u00020\u00158F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\b0$X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Icons;", "", "<init>", "()V", "dir", "Ljava/io/File;", "cache", "Ljava/util/HashMap;", "", "Landroid/graphics/Bitmap;", "Lkotlin/collections/HashMap;", "listeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Lkotlin/Function0;", "", "getListeners", "()Ljava/util/concurrent/CopyOnWriteArrayList;", "init", "ctx", "Landroid/content/Context;", "installed", "", "getInstalled", "()Z", "load", "kind", "name", "instanceBitmap", "cls", "generalBitmap", "uiBitmap", "instance", "Landroid/graphics/drawable/Drawable;", "general", "fallback", "knownClassIcons", "", "ui", "pixelated", "Landroid/graphics/drawable/BitmapDrawable;", "b", "abbrev", "s", "categoryColor", "", "importZip", "input", "Ljava/io/InputStream;", "remove", "Badge", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Icons {
    private static File dir;
    public static final Icons INSTANCE = new Icons();
    private static final HashMap<String, Bitmap> cache = new HashMap<>();
    private static final CopyOnWriteArrayList<Function0<Unit>> listeners = new CopyOnWriteArrayList<>();
    private static final Set<String> knownClassIcons = SetsKt.setOf((Object[]) new String[]{"Script", "LocalScript", "ModuleScript", "Model", "Folder", "Plugin", "Humanoid", "Sound", "Decal"});

    /* compiled from: Icons.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\u0005H\u0016J\u0012\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0005H\u0017J\b\u0010\u0017\u001a\u00020\u0005H\u0016J\b\u0010\u0018\u001a\u00020\u0005H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Icons$Badge;", "Landroid/graphics/drawable/Drawable;", "label", "", TypedValues.Custom.S_COLOR, "", "plain", "", "<init>", "(Ljava/lang/String;IZ)V", "bg", "Landroid/graphics/Paint;", "tp", "draw", "", "c", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "getOpacity", "getIntrinsicWidth", "getIntrinsicHeight", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Badge extends Drawable {
        private final Paint bg;
        private final int color;
        private final String label;
        private final boolean plain;
        private final Paint tp;

        public Badge(String label, int i, boolean z) {
            Intrinsics.checkNotNullParameter(label, "label");
            this.label = label;
            this.color = i;
            this.plain = z;
            this.bg = new Paint(1);
            Paint paint = new Paint(1);
            paint.setTextAlign(Paint.Align.CENTER);
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            this.tp = paint;
        }

        public /* synthetic */ Badge(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, i, (i2 & 4) != 0 ? false : z);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas c) {
            Intrinsics.checkNotNullParameter(c, "c");
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            RectF rectF = new RectF(bounds);
            float min = Math.min(rectF.width(), rectF.height());
            rectF.inset(((rectF.width() - min) / 2.0f) + (min * 0.06f), ((rectF.height() - min) / 2.0f) + (0.06f * min));
            if (!this.plain) {
                this.bg.setColor(this.color);
                c.drawRoundRect(rectF, min * 0.2f, 0.2f * min, this.bg);
            }
            this.tp.setColor(this.plain ? Ui.INSTANCE.getTEXT() : -1);
            this.tp.setTextSize((this.label.length() > 1 ? 0.42f : 0.6f) * min);
            c.drawText(this.label, rectF.centerX(), rectF.centerY() - ((this.tp.descent() + this.tp.ascent()) / 2.0f), this.tp);
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicHeight() {
            return 32;
        }

        @Override // android.graphics.drawable.Drawable
        public int getIntrinsicWidth() {
            return 32;
        }

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Deprecated in Java")
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
            this.bg.setAlpha(alpha);
            this.tp.setAlpha(alpha);
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter cf) {
        }
    }

    private Icons() {
    }

    private final String abbrev(String s) {
        String str = s;
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int length = str.length();
        while (true) {
            if (i >= length) {
                break;
            }
            char charAt = str.charAt(i);
            if (Character.isUpperCase(charAt) || Character.isDigit(charAt)) {
                sb.append(charAt);
            }
            i++;
        }
        String sb2 = sb.toString();
        if (sb2.length() >= 2) {
            return StringsKt.take(sb2, 2);
        }
        if (!(s.length() > 0)) {
            return "?";
        }
        String take = StringsKt.take(s, 2);
        if (!(take.length() > 0)) {
            return take;
        }
        StringBuilder sb3 = new StringBuilder();
        String valueOf = String.valueOf(take.charAt(0));
        Intrinsics.checkNotNull(valueOf, "null cannot be cast to non-null type java.lang.String");
        String upperCase = valueOf.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        StringBuilder append = sb3.append((Object) upperCase);
        String substring = take.substring(1);
        Intrinsics.checkNotNullExpressionValue(substring, "substring(...)");
        return append.append(substring).toString();
    }

    private final int categoryColor(String cls) {
        if (ClassDb.INSTANCE.isA(cls, "LuaSourceContainer")) {
            return -12944427;
        }
        if (ClassDb.INSTANCE.isA(cls, "BasePart")) {
            return -7566196;
        }
        if (ClassDb.INSTANCE.isA(cls, "GuiBase2d") || ClassDb.INSTANCE.isA(cls, "UIBase")) {
            return IconPainter.GUI;
        }
        if (Intrinsics.areEqual(cls, "Model") || Intrinsics.areEqual(cls, "Folder")) {
            return -3562969;
        }
        if (ClassDb.INSTANCE.isA(cls, "ValueBase")) {
            return -7443257;
        }
        return ClassDb.INSTANCE.isServiceName(cls) ? -11637624 : -9737365;
    }

    public static /* synthetic */ Drawable general$default(Icons icons, Context context, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = str;
        }
        return icons.general(context, str, str2);
    }

    private final Bitmap load(String kind, String name) {
        String str = (Ui.INSTANCE.getLIGHT() ? "light/" : "") + kind + "/" + name;
        synchronized (cache) {
            if (cache.containsKey(str)) {
                return cache.get(str);
            }
            File file = dir;
            Bitmap bitmap = null;
            File file2 = file != null ? new File(file, str + ".png") : null;
            if (file2 != null && file2.isFile()) {
                try {
                    bitmap = BitmapFactory.decodeFile(file2.getPath());
                } catch (Throwable th) {
                }
            }
            cache.put(str, bitmap);
            return bitmap;
        }
    }

    private final BitmapDrawable pixelated(Context ctx, Bitmap b) {
        BitmapDrawable bitmapDrawable = new BitmapDrawable(ctx.getResources(), b);
        bitmapDrawable.setFilterBitmap(true);
        return bitmapDrawable;
    }

    public final Drawable general(Context ctx, String name, String fallback) {
        BitmapDrawable pixelated;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        Bitmap generalBitmap = generalBitmap(name);
        if (generalBitmap != null && (pixelated = INSTANCE.pixelated(ctx, generalBitmap)) != null) {
            return pixelated;
        }
        Drawable general = BuiltinIcons.INSTANCE.general(name);
        if (general != null) {
            return general;
        }
        Drawable instance = (ClassDb.INSTANCE.isServiceName(name) || knownClassIcons.contains(name)) ? BuiltinIcons.INSTANCE.instance(name) : null;
        return instance == null ? new Badge(abbrev(fallback), -10851459, false, 4, null) : instance;
    }

    public final Bitmap generalBitmap(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return load("general", name);
    }

    public final boolean getInstalled() {
        File file = dir;
        if (file != null) {
            return new File(file, "general").isDirectory() || new File(file, "instance").isDirectory();
        }
        return false;
    }

    public final CopyOnWriteArrayList<Function0<Unit>> getListeners() {
        return listeners;
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 4 */
    public final int importZip(Context ctx, InputStream input) {
        Throwable th;
        ArrayList arrayList;
        Object obj;
        int i;
        Throwable th2;
        Throwable th3;
        LinkedHashMap linkedHashMap;
        Regex regex;
        Object obj2;
        List list;
        Object obj3;
        ArrayList arrayList2;
        Iterator it;
        Icons$importZip$2$E icons$importZip$2$E;
        ArrayList arrayList3;
        File file;
        Regex regex2;
        Iterator it2;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(input, "input");
        init(ctx);
        File file2 = new File(ctx.getCacheDir(), "iconpack_import.zip");
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        try {
            int i2 = 2;
            int i3 = 0;
            Object obj4 = null;
            ByteStreamsKt.copyTo$default(input, fileOutputStream, 0, 2, null);
            CloseableKt.closeFinally(fileOutputStream, null);
            Regex regex3 = new Regex("(?:^|/)(?:([^/]+)/)?(Dark|Light)/RobloxCustom/(instance|general|ui)/(16x|32x)/200/([^/]+)\\.png$", RegexOption.IGNORE_CASE);
            Regex regex4 = new Regex("(?:^|/)(instance|general|ui)/(16x|32x)/200/([^/]+)\\.png$", RegexOption.IGNORE_CASE);
            int i4 = 0;
            ZipFile zipFile = new ZipFile(file2);
            try {
                ZipFile zipFile2 = zipFile;
                ArrayList arrayList4 = new ArrayList();
                Enumeration<? extends ZipEntry> entries = zipFile2.entries();
                Intrinsics.checkNotNullExpressionValue(entries, "entries(...)");
                Iterator it3 = CollectionsKt.iterator(entries);
                while (it3.hasNext()) {
                    try {
                        ZipEntry zipEntry = (ZipEntry) it3.next();
                        if (zipEntry.isDirectory()) {
                            i2 = 2;
                            i3 = 0;
                            obj4 = null;
                        } else {
                            String name = zipEntry.getName();
                            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                            String replace$default = StringsKt.replace$default(name, '\\', '/', false, 4, (Object) null);
                            MatchResult find$default = Regex.find$default(regex3, replace$default, i3, i2, obj4);
                            if (find$default != null) {
                                String str = find$default.getGroupValues().get(1);
                                String str2 = find$default.getGroupValues().get(i2);
                                String lowerCase = find$default.getGroupValues().get(3).toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                                String lowerCase2 = find$default.getGroupValues().get(4).toLowerCase(Locale.ROOT);
                                Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
                                it2 = it3;
                                String str3 = find$default.getGroupValues().get(5);
                                Intrinsics.checkNotNull(zipEntry);
                                Boolean.valueOf(arrayList4.add(new Icons$importZip$2$E(str, str2, lowerCase, lowerCase2, str3, zipEntry)));
                            } else {
                                it2 = it3;
                                MatchResult find$default2 = Regex.find$default(regex4, replace$default, 0, 2, null);
                                if (find$default2 != null) {
                                    String lowerCase3 = find$default2.getGroupValues().get(1).toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase3, "toLowerCase(...)");
                                    String lowerCase4 = find$default2.getGroupValues().get(2).toLowerCase(Locale.ROOT);
                                    Intrinsics.checkNotNullExpressionValue(lowerCase4, "toLowerCase(...)");
                                    String str4 = find$default2.getGroupValues().get(3);
                                    Intrinsics.checkNotNull(zipEntry);
                                    Boolean.valueOf(arrayList4.add(new Icons$importZip$2$E("", "Dark", lowerCase3, lowerCase4, str4, zipEntry)));
                                }
                            }
                            it3 = it2;
                            i2 = 2;
                            i3 = 0;
                            obj4 = null;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        try {
                            throw th;
                        } catch (Throwable th5) {
                            CloseableKt.closeFinally(zipFile, th);
                            throw th5;
                        }
                    }
                }
                try {
                    if (arrayList4.isEmpty()) {
                        throw new IllegalArgumentException("No Vanilla icons found in this zip. Pick the \"Vanilla 3 for Roblox Studio\" zip from itch.io.");
                    }
                    ArrayList arrayList5 = arrayList4;
                    ArrayList arrayList6 = new ArrayList();
                    for (Object obj5 : arrayList5) {
                        ArrayList arrayList7 = arrayList5;
                        if (StringsKt.equals(((Icons$importZip$2$E) obj5).getTheme(), "Dark", true)) {
                            arrayList6.add(obj5);
                        }
                        arrayList5 = arrayList7;
                    }
                    ArrayList arrayList8 = arrayList6;
                    if (arrayList8.isEmpty()) {
                        arrayList8 = arrayList4;
                    }
                    ArrayList arrayList9 = arrayList8;
                    ArrayList arrayList10 = arrayList9;
                    ArrayList arrayList11 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList10, 10));
                    Iterator it4 = arrayList10.iterator();
                    while (it4.hasNext()) {
                        ArrayList arrayList12 = arrayList10;
                        arrayList11.add(((Icons$importZip$2$E) it4.next()).getPalette());
                        arrayList10 = arrayList12;
                    }
                    List distinct = CollectionsKt.distinct(arrayList11);
                    List list2 = distinct;
                    Iterator it5 = list2.iterator();
                    while (true) {
                        if (!it5.hasNext()) {
                            arrayList = arrayList9;
                            obj = null;
                            break;
                        }
                        obj = it5.next();
                        List list3 = list2;
                        arrayList = arrayList9;
                        if (StringsKt.equals((String) obj, "Colourful", true)) {
                            break;
                        }
                        list2 = list3;
                        arrayList9 = arrayList;
                    }
                    String str5 = (String) obj;
                    if (str5 == null) {
                        str5 = (String) CollectionsKt.first(distinct);
                    }
                    File file3 = new File(ctx.getFilesDir(), "iconpack.new");
                    FilesKt.deleteRecursively(file3);
                    Pair[] pairArr = new Pair[2];
                    ArrayList arrayList13 = new ArrayList();
                    for (Object obj6 : arrayList) {
                        List list4 = distinct;
                        if (Intrinsics.areEqual(((Icons$importZip$2$E) obj6).getPalette(), str5)) {
                            arrayList13.add(obj6);
                        }
                        distinct = list4;
                    }
                    pairArr[0] = TuplesKt.to("", arrayList13);
                    ArrayList arrayList14 = arrayList4;
                    ArrayList arrayList15 = new ArrayList();
                    for (Object obj7 : arrayList14) {
                        try {
                            icons$importZip$2$E = (Icons$importZip$2$E) obj7;
                            arrayList3 = arrayList14;
                            file = file2;
                            regex2 = regex3;
                        } catch (Throwable th6) {
                            th = th6;
                            throw th;
                        }
                        try {
                            if (StringsKt.equals(icons$importZip$2$E.getTheme(), "Light", true) && Intrinsics.areEqual(icons$importZip$2$E.getPalette(), str5)) {
                                arrayList15.add(obj7);
                            }
                            arrayList14 = arrayList3;
                            file2 = file;
                            regex3 = regex2;
                        } catch (Throwable th7) {
                            th = th7;
                            throw th;
                        }
                    }
                    File file4 = file2;
                    try {
                        pairArr[1] = TuplesKt.to("light/", arrayList15);
                        List listOf = CollectionsKt.listOf((Object[]) pairArr);
                        Iterator it6 = listOf.iterator();
                        while (it6.hasNext()) {
                            Pair pair = (Pair) it6.next();
                            String str6 = (String) pair.component1();
                            List list5 = (List) pair.component2();
                            for (String str7 : CollectionsKt.listOf((Object[]) new String[]{"instance", "general", "ui"})) {
                                ArrayList arrayList16 = new ArrayList();
                                for (Object obj8 : list5) {
                                    if (Intrinsics.areEqual(((Icons$importZip$2$E) obj8).getKind(), str7)) {
                                        arrayList2 = arrayList16;
                                        it = it6;
                                        arrayList2.add(obj8);
                                    } else {
                                        arrayList2 = arrayList16;
                                        it = it6;
                                    }
                                    it6 = it;
                                    arrayList16 = arrayList2;
                                }
                                ArrayList arrayList17 = arrayList16;
                                Iterator it7 = it6;
                                ArrayList arrayList18 = arrayList17;
                                if (arrayList18.isEmpty()) {
                                    it6 = it7;
                                    regex4 = regex4;
                                } else {
                                    ArrayList arrayList19 = arrayList18;
                                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                                    for (Object obj9 : arrayList19) {
                                        String name2 = ((Icons$importZip$2$E) obj9).getName();
                                        ArrayList arrayList20 = arrayList19;
                                        List list6 = listOf;
                                        Object obj10 = linkedHashMap2.get(name2);
                                        if (obj10 == null) {
                                            ArrayList arrayList21 = new ArrayList();
                                            list = list5;
                                            linkedHashMap2.put(name2, arrayList21);
                                            obj3 = arrayList21;
                                        } else {
                                            list = list5;
                                            obj3 = obj10;
                                        }
                                        ((List) obj3).add(obj9);
                                        listOf = list6;
                                        arrayList19 = arrayList20;
                                        list5 = list;
                                    }
                                    List list7 = listOf;
                                    List list8 = list5;
                                    boolean z = false;
                                    LinkedHashMap linkedHashMap3 = new LinkedHashMap(MapsKt.mapCapacity(linkedHashMap2.size()));
                                    LinkedHashMap linkedHashMap4 = linkedHashMap2;
                                    for (Object obj11 : linkedHashMap4.entrySet()) {
                                        boolean z2 = z;
                                        Object key = ((Map.Entry) obj11).getKey();
                                        List list9 = (List) ((Map.Entry) obj11).getValue();
                                        Iterator it8 = list9.iterator();
                                        while (true) {
                                            if (!it8.hasNext()) {
                                                linkedHashMap = linkedHashMap4;
                                                regex = regex4;
                                                obj2 = null;
                                                break;
                                            }
                                            obj2 = it8.next();
                                            linkedHashMap = linkedHashMap4;
                                            regex = regex4;
                                            if (Intrinsics.areEqual(((Icons$importZip$2$E) obj2).getRes(), "32x")) {
                                                break;
                                            }
                                            linkedHashMap4 = linkedHashMap;
                                            regex4 = regex;
                                        }
                                        Icons$importZip$2$E icons$importZip$2$E2 = (Icons$importZip$2$E) obj2;
                                        if (icons$importZip$2$E2 == null) {
                                            icons$importZip$2$E2 = (Icons$importZip$2$E) CollectionsKt.first(list9);
                                        }
                                        linkedHashMap3.put(key, icons$importZip$2$E2);
                                        z = z2;
                                        linkedHashMap4 = linkedHashMap;
                                        regex4 = regex;
                                    }
                                    Regex regex5 = regex4;
                                    File file5 = new File(file3, str6 + str7);
                                    file5.mkdirs();
                                    File file6 = file5;
                                    Iterator it9 = linkedHashMap3.entrySet().iterator();
                                    while (it9.hasNext()) {
                                        try {
                                            Map.Entry entry = (Map.Entry) it9.next();
                                            String str8 = (String) entry.getKey();
                                            Iterator it10 = it9;
                                            LinkedHashMap linkedHashMap5 = linkedHashMap3;
                                            InputStream inputStream = zipFile2.getInputStream(((Icons$importZip$2$E) entry.getValue()).getEntry());
                                            try {
                                                InputStream inputStream2 = inputStream;
                                                String str9 = str6;
                                                try {
                                                    try {
                                                        i = i4;
                                                        try {
                                                            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(file6, str8 + ".png"));
                                                            try {
                                                                Intrinsics.checkNotNull(inputStream2);
                                                                File file7 = file6;
                                                                ArrayList arrayList22 = arrayList18;
                                                                try {
                                                                    ByteStreamsKt.copyTo$default(inputStream2, fileOutputStream2, 0, 2, null);
                                                                    try {
                                                                        CloseableKt.closeFinally(fileOutputStream2, null);
                                                                        try {
                                                                            CloseableKt.closeFinally(inputStream, null);
                                                                            if (str9.length() == 0) {
                                                                                i4 = i + 1;
                                                                                it9 = it10;
                                                                                linkedHashMap3 = linkedHashMap5;
                                                                                file6 = file7;
                                                                                str6 = str9;
                                                                                arrayList18 = arrayList22;
                                                                            } else {
                                                                                it9 = it10;
                                                                                linkedHashMap3 = linkedHashMap5;
                                                                                file6 = file7;
                                                                                str6 = str9;
                                                                                arrayList18 = arrayList22;
                                                                                i4 = i;
                                                                            }
                                                                        } catch (Throwable th8) {
                                                                            th = th8;
                                                                            throw th;
                                                                        }
                                                                    } catch (Throwable th9) {
                                                                        th2 = th9;
                                                                        try {
                                                                            throw th2;
                                                                        } finally {
                                                                        }
                                                                    }
                                                                } catch (Throwable th10) {
                                                                    th3 = th10;
                                                                    try {
                                                                        throw th3;
                                                                    } finally {
                                                                    }
                                                                }
                                                            } catch (Throwable th11) {
                                                                th3 = th11;
                                                            }
                                                        } catch (Throwable th12) {
                                                            th2 = th12;
                                                        }
                                                    } catch (Throwable th13) {
                                                        i = i4;
                                                        th2 = th13;
                                                    }
                                                } catch (Throwable th14) {
                                                    i = i4;
                                                    th2 = th14;
                                                }
                                            } catch (Throwable th15) {
                                                i = i4;
                                                th2 = th15;
                                            }
                                        } catch (Throwable th16) {
                                            th = th16;
                                        }
                                    }
                                    it6 = it7;
                                    listOf = list7;
                                    list5 = list8;
                                    regex4 = regex5;
                                }
                            }
                            it6 = it6;
                            regex4 = regex4;
                        }
                        File file8 = new File(ctx.getFilesDir(), "iconpack");
                        FilesKt.deleteRecursively(file8);
                        file3.renameTo(file8);
                        Icons icons = INSTANCE;
                        dir = file8;
                        Unit unit = Unit.INSTANCE;
                        CloseableKt.closeFinally(zipFile, null);
                        file4.delete();
                        synchronized (cache) {
                            cache.clear();
                            Unit unit2 = Unit.INSTANCE;
                        }
                        Iterator<T> it11 = listeners.iterator();
                        while (it11.hasNext()) {
                            ((Function0) it11.next()).invoke();
                        }
                        return i4;
                    } catch (Throwable th17) {
                        th = th17;
                    }
                } catch (Throwable th18) {
                    th = th18;
                }
            } catch (Throwable th19) {
                th = th19;
            }
        } finally {
        }
    }

    public final void init(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        if (dir == null) {
            dir = new File(ctx.getFilesDir(), "iconpack");
        }
    }

    public final Drawable instance(Context ctx, String cls) {
        BitmapDrawable pixelated;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(cls, "cls");
        Bitmap instanceBitmap = instanceBitmap(cls);
        if (instanceBitmap != null && (pixelated = INSTANCE.pixelated(ctx, instanceBitmap)) != null) {
            return pixelated;
        }
        Drawable instance = BuiltinIcons.INSTANCE.instance(cls);
        return instance == null ? new Badge(abbrev(cls), categoryColor(cls), false, 4, null) : instance;
    }

    public final Bitmap instanceBitmap(String cls) {
        Intrinsics.checkNotNullParameter(cls, "cls");
        String str = cls;
        int i = 0;
        while (str != null) {
            int i2 = i + 1;
            if (i < 12) {
                Bitmap load = load("instance", str);
                if (load != null) {
                    return load;
                }
                if (!Intrinsics.areEqual(str, "Instance")) {
                    str = ClassDb.INSTANCE.superclass(str);
                    i = i2;
                }
            }
            return null;
        }
        return null;
    }

    public final void remove(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        FilesKt.deleteRecursively(new File(ctx.getFilesDir(), "iconpack"));
        synchronized (cache) {
            cache.clear();
            Unit unit = Unit.INSTANCE;
        }
        Iterator<T> it = listeners.iterator();
        while (it.hasNext()) {
            ((Function0) it.next()).invoke();
        }
    }

    public final Drawable ui(Context ctx, String name, String fallback) {
        Drawable badge;
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(fallback, "fallback");
        Bitmap uiBitmap = uiBitmap(name);
        if (uiBitmap == null || (badge = INSTANCE.pixelated(ctx, uiBitmap)) == null) {
            Drawable ui = BuiltinIcons.INSTANCE.ui(name);
            if (ui != null) {
                return ui;
            }
            badge = new Badge(fallback, 0, true);
        }
        return badge;
    }

    public final Bitmap uiBitmap(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return load("ui", name);
    }
}
