package com.exampletest.mobilestudiotest.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Instance.kt */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u000e\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006J\u0016\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/PropNames;", "", "<init>", "()V", "toDisplay", "", "", "fromDisplay", "display", "n", "serialized", "resolve", "inst", "Lcom/exampletest/mobilestudiotest/model/Instance;", "displayName", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class PropNames {
    private static final Map<String, String> fromDisplay;
    public static final PropNames INSTANCE = new PropNames();
    private static final Map<String, String> toDisplay = MapsKt.mapOf(TuplesKt.to("size", "Size"), TuplesKt.to("Color3uint8", "Color"), TuplesKt.to("shape", "Shape"), TuplesKt.to("formFactorRaw", "FormFactor"), TuplesKt.to("Health_XML", "Health"), TuplesKt.to("MaterialVariantSerialized", "MaterialVariant"), TuplesKt.to("xmlRead_MaxDistance_3", "RollOffMaxDistance"), TuplesKt.to("xmlRead_MinDistance_3", "RollOffMinDistance"), TuplesKt.to("BackgroundColor", "BackgroundBrickColor"), TuplesKt.to("Font_Serialized", "FontFace"), TuplesKt.to("Use2022MaterialsXml", "Use2022Materials"));

    static {
        Set<Map.Entry<String, String>> entrySet = toDisplay.entrySet();
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(entrySet, 10)), 16));
        Iterator<T> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Pair pair = TuplesKt.to(entry.getValue(), entry.getKey());
            linkedHashMap.put(pair.getFirst(), pair.getSecond());
        }
        fromDisplay = linkedHashMap;
    }

    private PropNames() {
    }

    public final String display(String n) {
        Intrinsics.checkNotNullParameter(n, "n");
        String str = toDisplay.get(n);
        return str == null ? n : str;
    }

    public final String resolve(Instance inst, String displayName) {
        String str;
        Intrinsics.checkNotNullParameter(inst, "inst");
        Intrinsics.checkNotNullParameter(displayName, "displayName");
        return (inst.getProps().containsKey(displayName) || (str = fromDisplay.get(displayName)) == null || !inst.getProps().containsKey(str)) ? displayName : str;
    }

    public final String serialized(String n) {
        Intrinsics.checkNotNullParameter(n, "n");
        String str = fromDisplay.get(n);
        return str == null ? n : str;
    }
}
