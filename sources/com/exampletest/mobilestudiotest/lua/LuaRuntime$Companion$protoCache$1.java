package com.exampletest.mobilestudiotest.lua;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import org.luaj.vm2.Prototype;

/* compiled from: LuaRuntime.kt */
@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010'\n\u0000*\u0001\u0000\b\n\u0018\u000026\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u00030\u0001j\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003`\u0005J*\u0010\u0006\u001a\u00020\u00072 \u0010\b\u001a\u001c\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00040\u0003\u0018\u00010\tH\u0014¨\u0006\n"}, d2 = {"com/exampletest/mobilestudiotest/lua/LuaRuntime$Companion$protoCache$1", "Ljava/util/LinkedHashMap;", "", "Lkotlin/Pair;", "Lorg/luaj/vm2/Prototype;", "Lkotlin/collections/LinkedHashMap;", "removeEldestEntry", "", "eldest", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class LuaRuntime$Companion$protoCache$1 extends LinkedHashMap<String, Pair<? extends String, ? extends Prototype>> {
    /* JADX INFO: Access modifiers changed from: package-private */
    public LuaRuntime$Companion$protoCache$1() {
        super(256, 0.75f, true);
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey((Object) str);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Pair) {
            return containsValue((Pair<String, ? extends Prototype>) obj);
        }
        return false;
    }

    public /* bridge */ boolean containsValue(Pair<String, ? extends Prototype> pair) {
        return super.containsValue((Object) pair);
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<Map.Entry<String, Pair<String, Prototype>>> entrySet() {
        return getEntries();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Pair<String, Prototype> get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public /* bridge */ Pair<String, Prototype> get(String str) {
        return (Pair) super.get((Object) str);
    }

    public /* bridge */ Set<Map.Entry<String, Pair<String, Prototype>>> getEntries() {
        return super.entrySet();
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, (Pair<String, ? extends Prototype>) obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* bridge */ Pair<String, Prototype> getOrDefault(Object obj, Pair<String, ? extends Prototype> pair) {
        return !(obj instanceof String) ? pair : getOrDefault((String) obj, pair);
    }

    public /* bridge */ Pair<String, Prototype> getOrDefault(String str, Pair<String, ? extends Prototype> pair) {
        return (Pair) super.getOrDefault((Object) str, (String) pair);
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public /* bridge */ Collection<Pair<String, Prototype>> getValues() {
        return super.values();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Pair<String, Prototype> remove(Object obj) {
        if (obj instanceof String) {
            return remove((String) obj);
        }
        return null;
    }

    public /* bridge */ Pair<String, Prototype> remove(String str) {
        return (Pair) super.remove((Object) str);
    }

    @Override // java.util.HashMap, java.util.Map
    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if ((obj instanceof String) && (obj2 instanceof Pair)) {
            return remove((String) obj, (Pair<String, ? extends Prototype>) obj2);
        }
        return false;
    }

    public /* bridge */ boolean remove(String str, Pair<String, ? extends Prototype> pair) {
        return super.remove((Object) str, (Object) pair);
    }

    @Override // java.util.LinkedHashMap
    protected boolean removeEldestEntry(Map.Entry<String, Pair<? extends String, ? extends Prototype>> eldest) {
        return size() > 3000;
    }

    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final /* bridge */ Collection<Pair<String, Prototype>> values() {
        return getValues();
    }
}
