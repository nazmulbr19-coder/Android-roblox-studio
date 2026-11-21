package com.exampletest.mobilestudiotest.model;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/ColorKey;", "", "time", "", TypedValues.Custom.S_COLOR, "Lcom/exampletest/mobilestudiotest/model/Color3;", "envelope", "<init>", "(FLcom/exampletest/mobilestudiotest/model/Color3;F)V", "getTime", "()F", "getColor", "()Lcom/exampletest/mobilestudiotest/model/Color3;", "getEnvelope", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class ColorKey {
    private final Color3 color;
    private final float envelope;
    private final float time;

    public ColorKey(float f, Color3 color, float f2) {
        Intrinsics.checkNotNullParameter(color, "color");
        this.time = f;
        this.color = color;
        this.envelope = f2;
    }

    public static /* synthetic */ ColorKey copy$default(ColorKey colorKey, float f, Color3 color3, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = colorKey.time;
        }
        if ((i & 2) != 0) {
            color3 = colorKey.color;
        }
        if ((i & 4) != 0) {
            f2 = colorKey.envelope;
        }
        return colorKey.copy(f, color3, f2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getTime() {
        return this.time;
    }

    /* renamed from: component2, reason: from getter */
    public final Color3 getColor() {
        return this.color;
    }

    /* renamed from: component3, reason: from getter */
    public final float getEnvelope() {
        return this.envelope;
    }

    public final ColorKey copy(float time, Color3 color, float envelope) {
        Intrinsics.checkNotNullParameter(color, "color");
        return new ColorKey(time, color, envelope);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ColorKey)) {
            return false;
        }
        ColorKey colorKey = (ColorKey) other;
        return Float.compare(this.time, colorKey.time) == 0 && Intrinsics.areEqual(this.color, colorKey.color) && Float.compare(this.envelope, colorKey.envelope) == 0;
    }

    public final Color3 getColor() {
        return this.color;
    }

    public final float getEnvelope() {
        return this.envelope;
    }

    public final float getTime() {
        return this.time;
    }

    public int hashCode() {
        return (((Float.hashCode(this.time) * 31) + this.color.hashCode()) * 31) + Float.hashCode(this.envelope);
    }

    public String toString() {
        return "ColorKey(time=" + this.time + ", color=" + this.color + ", envelope=" + this.envelope + ")";
    }
}
