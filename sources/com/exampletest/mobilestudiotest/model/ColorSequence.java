package com.exampletest.mobilestudiotest.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u000f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/ColorSequence;", "", "keys", "", "Lcom/exampletest/mobilestudiotest/model/ColorKey;", "<init>", "(Ljava/util/List;)V", "getKeys", "()Ljava/util/List;", "toString", "", "component1", "copy", "equals", "", "other", "hashCode", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ColorSequence {
    private final List<ColorKey> keys;

    public ColorSequence(List<ColorKey> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        this.keys = keys;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ColorSequence copy$default(ColorSequence colorSequence, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = colorSequence.keys;
        }
        return colorSequence.copy(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final CharSequence toString$lambda$0(ColorKey it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return DataTypesKt.fmtNum(it.getTime()) + " (" + it.getColor() + ")";
    }

    public final List<ColorKey> component1() {
        return this.keys;
    }

    public final ColorSequence copy(List<ColorKey> keys) {
        Intrinsics.checkNotNullParameter(keys, "keys");
        return new ColorSequence(keys);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof ColorSequence) && Intrinsics.areEqual(this.keys, ((ColorSequence) other).keys);
    }

    public final List<ColorKey> getKeys() {
        return this.keys;
    }

    public int hashCode() {
        return this.keys.hashCode();
    }

    public String toString() {
        return CollectionsKt.joinToString$default(this.keys, " ", null, null, 0, null, new ColorSequence$$ExternalSyntheticLambda0(), 30, null);
    }
}
