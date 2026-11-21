package androidx.lifecycle;

@Deprecated
/* loaded from: classes.dex */
public interface LifecycleRegistryOwner extends LifecycleOwner {
    @Override // androidx.lifecycle.LifecycleOwner
    /* bridge */ /* synthetic */ default Lifecycle getLifecycle() {
        return getLifecycle();
    }

    @Override // androidx.lifecycle.LifecycleOwner
    LifecycleRegistry getLifecycle();
}
