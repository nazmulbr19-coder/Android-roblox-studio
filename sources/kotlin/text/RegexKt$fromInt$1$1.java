package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Regex.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RegexKt$fromInt$1$1<T> implements Function1<T, Boolean> {
    final /* synthetic */ int $value;

    public RegexKt$fromInt$1$1(int i) {
        this.$value = i;
    }

    /* JADX WARN: Incorrect types in method signature: (TT;)Ljava/lang/Boolean; */
    /* JADX WARN: Multi-variable type inference failed */
    public final Boolean invoke(Enum r3) {
        return Boolean.valueOf((this.$value & ((FlagEnum) r3).getMask()) == ((FlagEnum) r3).getValue());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Object obj) {
        return invoke((Enum) obj);
    }
}
