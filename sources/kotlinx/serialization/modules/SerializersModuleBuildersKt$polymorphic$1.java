package kotlinx.serialization.modules;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [Base] */
/* compiled from: SerializersModuleBuilders.kt */
@Metadata(k = 3, mv = {2, 0, 0}, xi = 176)
/* loaded from: classes10.dex */
public final class SerializersModuleBuildersKt$polymorphic$1<Base> implements Function1<PolymorphicModuleBuilder<? super Base>, Unit> {
    public static final SerializersModuleBuildersKt$polymorphic$1 INSTANCE = new SerializersModuleBuildersKt$polymorphic$1();

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((PolymorphicModuleBuilder) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(PolymorphicModuleBuilder<? super Base> polymorphicModuleBuilder) {
        Intrinsics.checkNotNullParameter(polymorphicModuleBuilder, "<this>");
    }
}
