package com.exampletest.mobilestudiotest.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/UDim;", "", "scale", "", TypedValues.CycleType.S_WAVE_OFFSET, "", "<init>", "(FI)V", "getScale", "()F", "getOffset", "()I", "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class UDim {
    private final int offset;
    private final float scale;

    public UDim(float f, int i) {
        this.scale = f;
        this.offset = i;
    }

    public static /* synthetic */ UDim copy$default(UDim uDim, float f, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f = uDim.scale;
        }
        if ((i2 & 2) != 0) {
            i = uDim.offset;
        }
        return uDim.copy(f, i);
    }

    /* renamed from: component1, reason: from getter */
    public final float getScale() {
        return this.scale;
    }

    /* renamed from: component2, reason: from getter */
    public final int getOffset() {
        return this.offset;
    }

    public final UDim copy(float scale, int offset) {
        return new UDim(scale, offset);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UDim)) {
            return false;
        }
        UDim uDim = (UDim) other;
        return Float.compare(this.scale, uDim.scale) == 0 && this.offset == uDim.offset;
    }

    public final int getOffset() {
        return this.offset;
    }

    public final float getScale() {
        return this.scale;
    }

    public int hashCode() {
        return (Float.hashCode(this.scale) * 31) + Integer.hashCode(this.offset);
    }

    public String toString() {
        return DataTypesKt.fmtNum(this.scale) + ", " + this.offset;
    }
}
