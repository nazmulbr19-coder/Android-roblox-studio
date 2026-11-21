package com.exampletest.mobilestudiotest.ui;

import com.exampletest.mobilestudiotest.ui.GuiOverlay;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: GuiOverlay.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/exampletest/mobilestudiotest/ui/GuiOverlay$scaledSizes$1", "Ljava/util/LinkedHashMap;", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$SKey;", "", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GuiOverlay$scaledSizes$1 extends LinkedHashMap<GuiOverlay.SKey, Float> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuiOverlay$scaledSizes$1() {
        super(128, 0.75f, true);
    }

    public /* bridge */ boolean containsKey(GuiOverlay.SKey sKey) {
        return super.containsKey((Object) sKey);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof GuiOverlay.SKey) {
            return containsKey((GuiOverlay.SKey) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsValue(Float f) {
        return super.containsValue((Object) f);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Float) {
            return containsValue((Float) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<GuiOverlay.SKey, Float>> entrySet() {
        return getEntries();
    }

    public /* bridge */ Float get(GuiOverlay.SKey sKey) {
        return (Float) super.get((Object) sKey);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Float get(Object obj) {
        if (obj instanceof GuiOverlay.SKey) {
            return get((GuiOverlay.SKey) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof GuiOverlay.SKey) {
            return get((GuiOverlay.SKey) obj);
        }
        return null;
    }

    public /* bridge */ Set<Map.Entry<GuiOverlay.SKey, Float>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<GuiOverlay.SKey> getKeys() {
        return super.keySet();
    }

    public /* bridge */ Float getOrDefault(GuiOverlay.SKey sKey, Float f) {
        return (Float) super.getOrDefault((Object) sKey, (GuiOverlay.SKey) f);
    }

    public final /* bridge */ Float getOrDefault(Object obj, Float f) {
        return !(obj instanceof GuiOverlay.SKey) ? f : getOrDefault((GuiOverlay.SKey) obj, f);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof GuiOverlay.SKey) ? obj2 : getOrDefault((GuiOverlay.SKey) obj, (Float) obj2);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Float> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<GuiOverlay.SKey> keySet() {
        return getKeys();
    }

    public /* bridge */ Float remove(GuiOverlay.SKey sKey) {
        return (Float) super.remove((Object) sKey);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Float remove(Object obj) {
        if (obj instanceof GuiOverlay.SKey) {
            return remove((GuiOverlay.SKey) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof GuiOverlay.SKey) {
            return remove((GuiOverlay.SKey) obj);
        }
        return null;
    }

    public /* bridge */ boolean remove(GuiOverlay.SKey sKey, Float f) {
        return super.remove((Object) sKey, (Object) f);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof GuiOverlay.SKey) && (obj2 instanceof Float)) {
            return remove((GuiOverlay.SKey) obj, (Float) obj2);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<GuiOverlay.SKey, Float> eldest) {
        return size() > 400;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Float> values() {
        return getValues();
    }
}
