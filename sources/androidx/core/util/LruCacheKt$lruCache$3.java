package androidx.core.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* compiled from: LruCache.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes.dex */
public final class LruCacheKt$lruCache$3<K, V> implements Function4<Boolean, K, V, V, Unit> {
    public static final LruCacheKt$lruCache$3 INSTANCE = new LruCacheKt$lruCache$3();

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function4
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Object obj, Object obj2, Object obj3) {
        invoke(bool.booleanValue(), (boolean) obj, obj2, obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(boolean z, K k, V v, V v2) {
        Intrinsics.checkNotNullParameter(k, "<unused var>");
        Intrinsics.checkNotNullParameter(v, "<unused var>");
    }
}
