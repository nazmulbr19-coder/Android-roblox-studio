package com.exampletest.mobilestudiotest.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/NumberSequence;", "", "keys", "", "Lcom/exampletest/mobilestudiotest/model/NumberKey;", "<init>", "(Ljava/util/List;)V", "getKeys", "()Ljava/util/List;", "toString", "", "component1", "copy", "equals", "", "other", "hashCode", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NumberSequence {
    private final List<NumberKey> keys;

    public NumberSequence(List<NumberKey> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.keys = keys;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ NumberSequence copy$default(NumberSequence numberSequence, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = numberSequence.keys;
        }
        return numberSequence.copy(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence toString$lambda$0(NumberKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DataTypesKt.fmtNum(it.getTime()) + " " + DataTypesKt.fmtNum(it.getValue()) + " " + DataTypesKt.fmtNum(it.getEnvelope());
    }

    public final List<NumberKey> component1() {
        return this.keys;
    }

    public final NumberSequence copy(List<NumberKey> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        return new NumberSequence(keys);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof NumberSequence) && Intrinsics.areEqual(this.keys, ((NumberSequence) other).keys);
    }

    public final List<NumberKey> getKeys() {
        return this.keys;
    }

    public int hashCode() {
        return this.keys.hashCode();
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.keys, " ", null, null, 0, null, new NumberSequence$$ExternalSyntheticLambda0(), 30, null);
    }
}
