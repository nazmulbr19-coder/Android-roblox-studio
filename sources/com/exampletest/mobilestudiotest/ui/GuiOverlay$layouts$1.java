package com.exampletest.mobilestudiotest.ui;

import android.text.StaticLayout;
import com.exampletest.mobilestudiotest.ui.GuiOverlay;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;

/* compiled from: GuiOverlay.kt */
@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u00002\u001e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001j\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003`\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0014¨\u0006\t"}, d2 = {"com/exampletest/mobilestudiotest/ui/GuiOverlay$layouts$1", "Ljava/util/LinkedHashMap;", "Lcom/exampletest/mobilestudiotest/ui/GuiOverlay$TKey;", "Landroid/text/StaticLayout;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GuiOverlay$layouts$1 extends LinkedHashMap<GuiOverlay.TKey, StaticLayout> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public GuiOverlay$layouts$1() {
        super(256, 0.75f, true);
    }

    public /* bridge */ boolean containsKey(GuiOverlay.TKey tKey) {
        return super.containsKey((Object) tKey);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof GuiOverlay.TKey) {
            return containsKey((GuiOverlay.TKey) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsValue(StaticLayout staticLayout) {
        return super.containsValue((Object) staticLayout);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof StaticLayout) {
            return containsValue((StaticLayout) obj);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<GuiOverlay.TKey, StaticLayout>> entrySet() {
        return getEntries();
    }

    public /* bridge */ StaticLayout get(GuiOverlay.TKey tKey) {
        return (StaticLayout) super.get((Object) tKey);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ StaticLayout get(Object obj) {
        if (obj instanceof GuiOverlay.TKey) {
            return get((GuiOverlay.TKey) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof GuiOverlay.TKey) {
            return get((GuiOverlay.TKey) obj);
        }
        return null;
    }

    public /* bridge */ Set<Map.Entry<GuiOverlay.TKey, StaticLayout>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<GuiOverlay.TKey> getKeys() {
        return super.keySet();
    }

    public /* bridge */ StaticLayout getOrDefault(GuiOverlay.TKey tKey, StaticLayout staticLayout) {
        return (StaticLayout) super.getOrDefault((Object) tKey, (GuiOverlay.TKey) staticLayout);
    }

    public final /* bridge */ StaticLayout getOrDefault(Object obj, StaticLayout staticLayout) {
        return !(obj instanceof GuiOverlay.TKey) ? staticLayout : getOrDefault((GuiOverlay.TKey) obj, staticLayout);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof GuiOverlay.TKey) ? obj2 : getOrDefault((GuiOverlay.TKey) obj, (StaticLayout) obj2);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<StaticLayout> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<GuiOverlay.TKey> keySet() {
        return getKeys();
    }

    public /* bridge */ StaticLayout remove(GuiOverlay.TKey tKey) {
        return (StaticLayout) super.remove((Object) tKey);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ StaticLayout remove(Object obj) {
        if (obj instanceof GuiOverlay.TKey) {
            return remove((GuiOverlay.TKey) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof GuiOverlay.TKey) {
            return remove((GuiOverlay.TKey) obj);
        }
        return null;
    }

    public /* bridge */ boolean remove(GuiOverlay.TKey tKey, StaticLayout staticLayout) {
        return super.remove((Object) tKey, (Object) staticLayout);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof GuiOverlay.TKey) && (obj2 instanceof StaticLayout)) {
            return remove((GuiOverlay.TKey) obj, (StaticLayout) obj2);
        }
        return false;
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<GuiOverlay.TKey, StaticLayout> eldest) {
        return size() > 500;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<StaticLayout> values() {
        return getValues();
    }
}
