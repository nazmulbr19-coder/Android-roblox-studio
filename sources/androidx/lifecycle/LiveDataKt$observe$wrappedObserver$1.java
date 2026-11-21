package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: LiveData.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: classes.dex */
public final class LiveDataKt$observe$wrappedObserver$1<T> implements Observer {
    final /* synthetic */ Function1<T, Unit> $onChanged;

    /* JADX WARN: Multi-variable type inference failed */
    public LiveDataKt$observe$wrappedObserver$1(Function1<? super T, Unit> function1) {
        this.$onChanged = function1;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(T t) {
        this.$onChanged.invoke(t);
    }
}
