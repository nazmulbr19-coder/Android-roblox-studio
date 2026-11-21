package kotlin.jdk7;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* compiled from: AutoCloseableJVM.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 176)
/* loaded from: classes.dex */
public final class AutoCloseableKt$AutoCloseable$1 implements AutoCloseable {
    final /* synthetic */ Function0<Unit> $closeAction;

    public AutoCloseableKt$AutoCloseable$1(Function0<Unit> function0) {
        this.$closeAction = function0;
    }

    @Override // java.lang.AutoCloseable
    public final void close() {
        this.$closeAction.invoke();
    }
}
