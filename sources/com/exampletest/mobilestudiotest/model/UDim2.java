package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016J\u0016\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J1\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\r¨\u0006\u001e"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/UDim2;", "", "xs", "", "xo", "", "ys", "yo", "<init>", "(FIFI)V", "getXs", "()F", "getXo", "()I", "getYs", "getYo", "toString", "", "lerp", "o", "t", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UDim2 {
    private final int xo;
    private final float xs;
    private final int yo;
    private final float ys;

    public UDim2(float f, int i, float f2, int i2) {
        this.xs = f;
        this.xo = i;
        this.ys = f2;
        this.yo = i2;
    }

    public static /* synthetic */ UDim2 copy$default(UDim2 uDim2, float f, int i, float f2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            f = uDim2.xs;
        }
        if ((i3 & 2) != 0) {
            i = uDim2.xo;
        }
        if ((i3 & 4) != 0) {
            f2 = uDim2.ys;
        }
        if ((i3 & 8) != 0) {
            i2 = uDim2.yo;
        }
        return uDim2.copy(f, i, f2, i2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getXs() {
        return this.xs;
    }

    /* renamed from: component2, reason: from getter */
    public final int getXo() {
        return this.xo;
    }

    /* renamed from: component3, reason: from getter */
    public final float getYs() {
        return this.ys;
    }

    /* renamed from: component4, reason: from getter */
    public final int getYo() {
        return this.yo;
    }

    public final UDim2 copy(float xs, int xo, float ys, int yo) {
        return new UDim2(xs, xo, ys, yo);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UDim2)) {
            return false;
        }
        UDim2 uDim2 = (UDim2) other;
        return Float.compare(this.xs, uDim2.xs) == 0 && this.xo == uDim2.xo && Float.compare(this.ys, uDim2.ys) == 0 && this.yo == uDim2.yo;
    }

    public final int getXo() {
        return this.xo;
    }

    public final float getXs() {
        return this.xs;
    }

    public final int getYo() {
        return this.yo;
    }

    public final float getYs() {
        return this.ys;
    }

    public int hashCode() {
        return (((((Float.hashCode(this.xs) * 31) + Integer.hashCode(this.xo)) * 31) + Float.hashCode(this.ys)) * 31) + Integer.hashCode(this.yo);
    }

    public final UDim2 lerp(UDim2 o, float t) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new UDim2(this.xs + ((o.xs - this.xs) * t), MathKt.roundToInt(this.xo + ((o.xo - this.xo) * t)), this.ys + ((o.ys - this.ys) * t), MathKt.roundToInt(this.yo + ((o.yo - this.yo) * t)));
    }

    public String toString() {
        return "{" + DataTypesKt.fmtNum(this.xs) + ", " + this.xo + "}, {" + DataTypesKt.fmtNum(this.ys) + ", " + this.yo + "}";
    }
}
