package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Caching.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* renamed from: kotlinx.serialization.internal.ClassValueParametrizedCache$get-gIAlu-s$$inlined$getOrSet$1, reason: invalid class name */
/* loaded from: classes10.dex */
public final class ClassValueParametrizedCache$getgIAlus$$inlined$getOrSet$1<T> implements Function0<T> {
    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        return (T) new ParametrizedCacheEntry();
    }
}
