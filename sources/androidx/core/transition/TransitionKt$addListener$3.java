package androidx.core.transition;

import android.transition.Transition;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Transition.kt */
@Metadata(k = 3, mv = {2, 1, 0}, xi = 176)
/* loaded from: classes.dex */
public final class TransitionKt$addListener$3 implements Function1<Transition, Unit> {
    public static final TransitionKt$addListener$3 INSTANCE = new TransitionKt$addListener$3();

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Transition transition) {
        invoke2(transition);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Transition it) {
        Intrinsics.checkNotNullParameter(it, "it");
    }
}
