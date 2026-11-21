package com.exampletest.mobilestudiotest.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.internal.view.SupportMenu;
import androidx.core.location.LocationRequestCompat;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.PointerIconCompat;
import com.exampletest.mobilestudiotest.model.Color3;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\u0006J\u0015\u0010\u0011\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\b¢\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0010R&\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/BrickColors;", "", "<init>", "()V", "table", "", "", "Lkotlin/Pair;", "", "all", "", "getAll", "()Ljava/util/List;", "name", "n", TypedValues.Custom.S_COLOR, "Lcom/exampletest/mobilestudiotest/model/Color3;", "byName", "(Ljava/lang/String;)Ljava/lang/Integer;", "closest", "c", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class BrickColors {
    public static final BrickColors INSTANCE = new BrickColors();
    private static final Map<Integer, Pair<String, Integer>> table = MapsKt.linkedMapOf(TuplesKt.to(1, TuplesKt.to("White", 15922163)), TuplesKt.to(5, TuplesKt.to("Brick yellow", 14140826)), TuplesKt.to(9, TuplesKt.to("Light reddish violet", 15252168)), TuplesKt.to(11, TuplesKt.to("Pastel Blue", 8436699)), TuplesKt.to(18, TuplesKt.to("Nougat", 13405801)), TuplesKt.to(21, TuplesKt.to("Bright red", 12855324)), TuplesKt.to(23, TuplesKt.to("Bright blue", 879020)), TuplesKt.to(24, TuplesKt.to("Bright yellow", 16108848)), TuplesKt.to(26, TuplesKt.to("Black", 1780277)), TuplesKt.to(28, TuplesKt.to("Dark green", 2654023)), TuplesKt.to(37, TuplesKt.to("Bright green", 4953931)), TuplesKt.to(45, TuplesKt.to("Light blue", 11850468)), TuplesKt.to(Integer.valueOf(TypedValues.TYPE_TARGET), TuplesKt.to("Medium red", 14321274)), TuplesKt.to(Integer.valueOf(LocationRequestCompat.QUALITY_BALANCED_POWER_ACCURACY), TuplesKt.to("Medium blue", 7248330)), TuplesKt.to(106, TuplesKt.to("Bright orange", 14320961)), TuplesKt.to(119, TuplesKt.to("Br. yellowish green", 10796359)), TuplesKt.to(125, TuplesKt.to("Light orange", 15382674)), TuplesKt.to(141, TuplesKt.to("Earth green", 2573869)), TuplesKt.to(192, TuplesKt.to("Reddish brown", 6897704)), TuplesKt.to(194, TuplesKt.to("Medium stone grey", 10724005)), TuplesKt.to(199, TuplesKt.to("Dark stone grey", 6512482)), TuplesKt.to(208, TuplesKt.to("Light stone grey", 15066335)), TuplesKt.to(217, TuplesKt.to("Brown", 8150086)), TuplesKt.to(226, TuplesKt.to("Cool yellow", 16640653)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_CONTEXT_MENU), TuplesKt.to("Institutional white", 16316664)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_HAND), TuplesKt.to("Mid gray", 13487565)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_HELP), TuplesKt.to("Really black", 1118481)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_WAIT), TuplesKt.to("Really red", 16711680)), TuplesKt.to(1005, TuplesKt.to("Deep orange", 16756736)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_CELL), TuplesKt.to("Alder", 11829503)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_CROSSHAIR), TuplesKt.to("Dusty Rose", 10701643)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_VERTICAL_TEXT), TuplesKt.to("New Yeller", 16776960)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_ALIAS), TuplesKt.to("Really blue", 255)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_COPY), TuplesKt.to("Navy blue", 8288)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_NO_DROP), TuplesKt.to("Deep blue", 2184377)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_ALL_SCROLL), TuplesKt.to("Cyan", 307180)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_VERTICAL_DOUBLE_ARROW), TuplesKt.to("Magenta", 11141290)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_TOP_RIGHT_DIAGONAL_DOUBLE_ARROW), TuplesKt.to("Pink", 16737996)), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_ZOOM_OUT), TuplesKt.to("Toothpaste", Integer.valueOf(SupportMenu.USER_MASK))), TuplesKt.to(Integer.valueOf(PointerIconCompat.TYPE_GRAB), TuplesKt.to("Lime green", Integer.valueOf(MotionEventCompat.ACTION_POINTER_INDEX_MASK))), TuplesKt.to(1022, TuplesKt.to("Grime", 8359524)), TuplesKt.to(1023, TuplesKt.to("Lavender", 9198495)), TuplesKt.to(1031, TuplesKt.to("Royal purple", 6432209)), TuplesKt.to(1032, TuplesKt.to("Hot pink", 16711871)));

    private BrickColors() {
    }

    public final Integer byName(String name) {
        Object obj;
        Intrinsics.checkNotNullParameter(name, "name");
        Iterator<T> it = table.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (StringsKt.equals((String) ((Pair) ((Map.Entry) obj).getValue()).getFirst(), name, true)) {
                break;
            }
        }
        Map.Entry entry = (Map.Entry) obj;
        if (entry != null) {
            return (Integer) entry.getKey();
        }
        return null;
    }

    public final int closest(Color3 c) {
        Intrinsics.checkNotNullParameter(c, "c");
        int i = 194;
        float f = Float.MAX_VALUE;
        for (Map.Entry<Integer, Pair<String, Integer>> entry : table.entrySet()) {
            int intValue = entry.getKey().intValue();
            Color3 fromArgb = Color3.INSTANCE.fromArgb(entry.getValue().getSecond().intValue());
            float r = ((fromArgb.getR() - c.getR()) * (fromArgb.getR() - c.getR())) + ((fromArgb.getG() - c.getG()) * (fromArgb.getG() - c.getG())) + ((fromArgb.getB() - c.getB()) * (fromArgb.getB() - c.getB()));
            if (r < f) {
                f = r;
                i = intValue;
            }
        }
        return i;
    }

    public final Color3 color(int n) {
        Color3.Companion companion = Color3.INSTANCE;
        Pair<String, Integer> pair = table.get(Integer.valueOf(n));
        return companion.fromArgb(pair != null ? pair.getSecond().intValue() : 10724005);
    }

    public final List<Integer> getAll() {
        return CollectionsKt.toList(table.keySet());
    }

    public final String name(int n) {
        String first;
        Pair<String, Integer> pair = table.get(Integer.valueOf(n));
        return (pair == null || (first = pair.getFirst()) == null) ? "Medium stone grey" : first;
    }
}
