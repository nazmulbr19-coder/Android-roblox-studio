package com.exampletest.mobilestudiotest.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0010\u001a\u00020\tH\u0016J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/BrickColorV;", "", "number", "", "<init>", "(I)V", "getNumber", "()I", "name", "", "getName", "()Ljava/lang/String;", TypedValues.Custom.S_COLOR, "Lcom/exampletest/mobilestudiotest/model/Color3;", "getColor", "()Lcom/exampletest/mobilestudiotest/model/Color3;", "toString", "component1", "copy", "equals", "", "other", "hashCode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class BrickColorV {
    private final int number;

    public BrickColorV(int i) {
        this.number = i;
    }

    public static /* synthetic */ BrickColorV copy$default(BrickColorV brickColorV, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = brickColorV.number;
        }
        return brickColorV.copy(i);
    }

    /* renamed from: component1, reason: from getter */
    public final int getNumber() {
        return this.number;
    }

    public final BrickColorV copy(int number) {
        return new BrickColorV(number);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof BrickColorV) && this.number == ((BrickColorV) other).number;
    }

    public final Color3 getColor() {
        return BrickColors.INSTANCE.color(this.number);
    }

    public final String getName() {
        return BrickColors.INSTANCE.name(this.number);
    }

    public final int getNumber() {
        return this.number;
    }

    public int hashCode() {
        return Integer.hashCode(this.number);
    }

    public String toString() {
        return getName();
    }
}
