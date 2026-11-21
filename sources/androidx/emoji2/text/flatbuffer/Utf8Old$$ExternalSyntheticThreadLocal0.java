package androidx.emoji2.text.flatbuffer;

import java.util.function.Supplier;

/* compiled from: D8$$SyntheticClass */
/* loaded from: classes.dex */
public final /* synthetic */ class Utf8Old$$ExternalSyntheticThreadLocal0 extends ThreadLocal {
    public final /* synthetic */ Supplier initialValueSupplier;

    public /* synthetic */ Utf8Old$$ExternalSyntheticThreadLocal0(Supplier supplier) {
        this.initialValueSupplier = supplier;
    }

    @Override // java.lang.ThreadLocal
    protected /* synthetic */ Object initialValue() {
        return this.initialValueSupplier.get();
    }
}
