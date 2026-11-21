package com.exampletest.mobilestudiotest.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Axes;", "", "mask", "", "<init>", "(I)V", "getMask", "()I", "toString", "", "component1", "copy", "equals", "", "other", "hashCode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Axes {
    private final int mask;

    public Axes(int i) {
        this.mask = i;
    }

    public static /* synthetic */ Axes copy$default(Axes axes, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = axes.mask;
        }
        return axes.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getMask() {
        return this.mask;
    }

    public final Axes copy(int mask) {
        return new Axes(mask);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Axes) && this.mask == ((Axes) other).mask;
    }

    public final int getMask() {
        return this.mask;
    }

    public int hashCode() {
        return Integer.hashCode(this.mask);
    }

    public String toString() {
        int i = 1;
        List listOf = CollectionsKt.listOf((Object[]) new String[]{"X", "Y", "Z"});
        ArrayList arrayList = new ArrayList();
        int i2 = 0;
        for (Object obj : listOf) {
            int i3 = i2 + 1;
            if (i2 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            int i4 = i;
            if (((this.mask & (i4 << i2)) != 0 ? i4 : 0) != 0) {
                arrayList.add(obj);
            }
            i2 = i3;
            i = i4;
        }
        return CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null);
    }
}
