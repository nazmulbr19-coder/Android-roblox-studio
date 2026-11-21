package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Caching.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class ClassValueReferences$getOrSet$2<T> implements Function0<T> {
    final /* synthetic */ Function0<T> $factory;

    /* JADX WARN: Multi-variable type inference failed */
    public ClassValueReferences$getOrSet$2(Function0<? extends T> function0) {
        this.$factory = function0;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        return this.$factory.invoke();
    }
}
