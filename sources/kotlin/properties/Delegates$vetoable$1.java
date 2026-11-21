package kotlin.properties;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Delegates.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J)\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"kotlin/properties/Delegates$vetoable$1", "Lkotlin/properties/ObservableProperty;", "beforeChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)Z", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 176)
/* loaded from: classes.dex */
public final class Delegates$vetoable$1<T> extends ObservableProperty<T> {
    final /* synthetic */ Function3<KProperty<?>, T, T, Boolean> $onChange;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Delegates$vetoable$1(T t, Function3<? super KProperty<?>, ? super T, ? super T, Boolean> function3) {
        super(t);
        this.$onChange = function3;
    }

    @Override // kotlin.properties.ObservableProperty
    protected boolean beforeChange(KProperty<?> property, T oldValue, T newValue) {
        Intrinsics.checkNotNullParameter(property, "property");
        return this.$onChange.invoke(property, oldValue, newValue).booleanValue();
    }
}
