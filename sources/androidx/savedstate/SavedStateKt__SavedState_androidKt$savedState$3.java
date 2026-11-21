package androidx.savedstate;

import android.os.Bundle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SavedState.android.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: classes.dex */
public final class SavedStateKt__SavedState_androidKt$savedState$3 implements Function1<SavedStateWriter, Unit> {
    public static final SavedStateKt__SavedState_androidKt$savedState$3 INSTANCE = new SavedStateKt__SavedState_androidKt$savedState$3();

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SavedStateWriter savedStateWriter) {
        m181invokexApjlu4(savedStateWriter.getSource());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-xApjlu4, reason: not valid java name */
    public final void m181invokexApjlu4(Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "<this>");
    }
}
