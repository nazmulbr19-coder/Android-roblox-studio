package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.debug.internal.DebugProbesImpl;

/* compiled from: DebugProbesImpl.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1 implements Function1<DebugProbesImpl.CoroutineOwner<?>, DebuggerInfo> {
    /* JADX WARN: Type inference failed for: r0v2, types: [java.lang.Object, kotlinx.coroutines.debug.internal.DebuggerInfo] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ DebuggerInfo invoke(DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        return invoke2(coroutineOwner);
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final DebuggerInfo invoke2(DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
        CoroutineContext context;
        if (DebugProbesImpl.access$isFinished(DebugProbesImpl.INSTANCE, coroutineOwner) || (context = coroutineOwner.info.getContext()) == null) {
            return null;
        }
        return new DebuggerInfo(coroutineOwner.info, context);
    }
}
