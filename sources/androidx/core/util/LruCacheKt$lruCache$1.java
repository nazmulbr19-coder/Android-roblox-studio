package androidx.core.util;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCache.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$1<K, V> implements Function2<K, V, Integer> {
    public static final LruCacheKt$lruCache$1 INSTANCE = new LruCacheKt$lruCache$1();

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function2
    public final Integer invoke(K k, V v) {
        Intrinsics.checkNotNullParameter(k, "<unused var>");
        Intrinsics.checkNotNullParameter(v, "<unused var>");
        return 1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Integer invoke(Object obj, Object obj2) {
        return invoke((LruCacheKt$lruCache$1<K, V>) obj, obj2);
    }
}
