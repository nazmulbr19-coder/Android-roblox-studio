package kotlinx.coroutines.selects;

import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: Runnable.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes10.dex */
public final class OnTimeout$register$$inlined$Runnable$1 implements Runnable {
    final /* synthetic */ SelectInstance $select$inlined;
    final /* synthetic */ OnTimeout this$0;

    public OnTimeout$register$$inlined$Runnable$1(SelectInstance selectInstance, OnTimeout onTimeout) {
        this.$select$inlined = selectInstance;
        this.this$0 = onTimeout;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.$select$inlined.trySelect(this.this$0, Unit.INSTANCE);
    }
}
