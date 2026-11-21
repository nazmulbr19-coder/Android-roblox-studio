package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/NumberRange;", "", "min", "", "max", "<init>", "(FF)V", "getMin", "()F", "getMax", "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class NumberRange {
    private final float max;
    private final float min;

    public NumberRange(float f, float f2) {
        this.min = f;
        this.max = f2;
    }

    public static /* synthetic */ NumberRange copy$default(NumberRange numberRange, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = numberRange.min;
        }
        if ((i & 2) != 0) {
            f2 = numberRange.max;
        }
        return numberRange.copy(f, f2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getMin() {
        return this.min;
    }

    /* renamed from: component2, reason: from getter */
    public final float getMax() {
        return this.max;
    }

    public final NumberRange copy(float min, float max) {
        return new NumberRange(min, max);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof NumberRange)) {
            return false;
        }
        NumberRange numberRange = (NumberRange) other;
        return Float.compare(this.min, numberRange.min) == 0 && Float.compare(this.max, numberRange.max) == 0;
    }

    public final float getMax() {
        return this.max;
    }

    public final float getMin() {
        return this.min;
    }

    public int hashCode() {
        return (Float.hashCode(this.min) * 31) + Float.hashCode(this.max);
    }

    public String toString() {
        return DataTypesKt.fmtNum(this.min) + " " + DataTypesKt.fmtNum(this.max);
    }
}
