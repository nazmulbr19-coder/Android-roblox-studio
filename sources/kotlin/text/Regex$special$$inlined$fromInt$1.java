package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;

/* compiled from: Regex.kt */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Regex$special$$inlined$fromInt$1 implements Function1<RegexOption, Boolean> {
    final /* synthetic */ int $value;

    public Regex$special$$inlined$fromInt$1(int i) {
        this.$value = i;
    }

    public final Boolean invoke(RegexOption regexOption) {
        return Boolean.valueOf((this.$value & regexOption.getMask()) == regexOption.getValue());
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(RegexOption regexOption) {
        return invoke(regexOption);
    }
}
