package kotlin.text;

import kotlin.Metadata;
import kotlin.collections.CharIterator;

/* compiled from: Strings.kt */
@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\t\u0010\u0006\u001a\u00020\u0007H\u0096\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"kotlin/text/StringsKt__StringsKt$iterator$1", "Lkotlin/collections/CharIterator;", "index", "", "nextChar", "", "hasNext", "", "kotlin-stdlib"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes.dex */
public final class StringsKt__StringsKt$iterator$1 extends CharIterator {
    final /* synthetic */ CharSequence $this_iterator;
    private int index;

    /* JADX INFO: Access modifiers changed from: package-private */
    public StringsKt__StringsKt$iterator$1(CharSequence charSequence) {
        this.$this_iterator = charSequence;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.$this_iterator.length();
    }

    @Override // kotlin.collections.CharIterator
    public char nextChar() {
        CharSequence charSequence = this.$this_iterator;
        int i = this.index;
        this.index = i + 1;
        return charSequence.charAt(i);
    }
}
