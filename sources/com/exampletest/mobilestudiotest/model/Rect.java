package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u001a"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Rect;", "", "minX", "", "minY", "maxX", "maxY", "<init>", "(FFFF)V", "getMinX", "()F", "getMinY", "getMaxX", "getMaxY", "toString", "", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Rect {
    private final float maxX;
    private final float maxY;
    private final float minX;
    private final float minY;

    public Rect(float f, float f2, float f3, float f4) {
        this.minX = f;
        this.minY = f2;
        this.maxX = f3;
        this.maxY = f4;
    }

    public static /* synthetic */ Rect copy$default(Rect rect, float f, float f2, float f3, float f4, int i, Object obj) {
        if ((i & 1) != 0) {
            f = rect.minX;
        }
        if ((i & 2) != 0) {
            f2 = rect.minY;
        }
        if ((i & 4) != 0) {
            f3 = rect.maxX;
        }
        if ((i & 8) != 0) {
            f4 = rect.maxY;
        }
        return rect.copy(f, f2, f3, f4);
    }

    /* renamed from: component1, reason: from getter */
    public final float getMinX() {
        return this.minX;
    }

    /* renamed from: component2, reason: from getter */
    public final float getMinY() {
        return this.minY;
    }

    /* renamed from: component3, reason: from getter */
    public final float getMaxX() {
        return this.maxX;
    }

    /* renamed from: component4, reason: from getter */
    public final float getMaxY() {
        return this.maxY;
    }

    public final Rect copy(float minX, float minY, float maxX, float maxY) {
        return new Rect(minX, minY, maxX, maxY);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Rect)) {
            return false;
        }
        Rect rect = (Rect) other;
        return Float.compare(this.minX, rect.minX) == 0 && Float.compare(this.minY, rect.minY) == 0 && Float.compare(this.maxX, rect.maxX) == 0 && Float.compare(this.maxY, rect.maxY) == 0;
    }

    public final float getMaxX() {
        return this.maxX;
    }

    public final float getMaxY() {
        return this.maxY;
    }

    public final float getMinX() {
        return this.minX;
    }

    public final float getMinY() {
        return this.minY;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.minX) * 31) + Float.hashCode(this.minY)) * 31) + Float.hashCode(this.maxX)) * 31) + Float.hashCode(this.maxY);
    }

    public String toString() {
        return DataTypesKt.fmtNum(this.minX) + ", " + DataTypesKt.fmtNum(this.minY) + ", " + DataTypesKt.fmtNum(this.maxX) + ", " + DataTypesKt.fmtNum(this.maxY);
    }
}
