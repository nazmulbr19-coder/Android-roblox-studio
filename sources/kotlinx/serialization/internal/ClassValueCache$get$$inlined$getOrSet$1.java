package kotlinx.serialization.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KClass;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Caching.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class ClassValueCache$get$$inlined$getOrSet$1<T> implements Function0<T> {
    final /* synthetic */ KClass $key$inlined;
    final /* synthetic */ ClassValueCache this$0;

    public ClassValueCache$get$$inlined$getOrSet$1(ClassValueCache classValueCache, KClass kClass) {
        this.this$0 = classValueCache;
        this.$key$inlined = kClass;
    }

    @Override // kotlin.jvm.functions.Function0
    public final T invoke() {
        return (T) new CacheEntry(this.this$0.getCompute().invoke(this.$key$inlined));
    }
}
