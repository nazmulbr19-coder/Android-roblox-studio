package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

/* JADX INFO: Add missing generic type declarations: [R] */
/* compiled from: DebugProbesImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class DebugProbesImpl$dumpCoroutinesInfoImpl$3<R> implements Function1<DebugProbesImpl.CoroutineOwner<?>, R> {
    final /* synthetic */ Function2<DebugProbesImpl.CoroutineOwner<?>, CoroutineContext, R> $create;

    /* JADX WARN: Multi-variable type inference failed */
    public DebugProbesImpl$dumpCoroutinesInfoImpl$3(Function2<? super DebugProbesImpl.CoroutineOwner<?>, ? super CoroutineContext, ? extends R> function2) {
        this.$create = function2;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Object invoke(DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        return invoke2(coroutineOwner);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final R invoke2(DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        CoroutineContext context;
        if (DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, coroutineOwner) || (context = coroutineOwner.info.getContext()) == null) {
            return null;
        }
        return this.$create.invoke(coroutineOwner, context);
    }
}
