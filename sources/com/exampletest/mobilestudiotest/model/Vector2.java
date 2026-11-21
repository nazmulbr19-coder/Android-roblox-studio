package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\f\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003H\u0086\u0002J\u0011\u0010\r\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0003H\u0086\u0002J\t\u0010\u0010\u001a\u00020\u0000H\u0086\u0002J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0000J\u0016\u0010\u0017\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0003J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0011\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006#"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Vector2;", "", "x", "", "y", "<init>", "(FF)V", "getX", "()F", "getY", "plus", "o", "minus", "times", "s", "div", "unaryMinus", "magnitude", "getMagnitude", "unit", "getUnit", "()Lcom/exampletest/mobilestudiotest/model/Vector2;", "dot", "lerp", "t", "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Vector2 {
    private final float x;
    private final float y;

    public Vector2(float f, float f2) {
        this.x = f;
        this.y = f2;
    }

    public static /* synthetic */ Vector2 copy$default(Vector2 vector2, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = vector2.x;
        }
        if ((i & 2) != 0) {
            f2 = vector2.y;
        }
        return vector2.copy(f, f2);
    }

    /* renamed from: component1, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final float getY() {
        return this.y;
    }

    public final Vector2 copy(float x, float y) {
        return new Vector2(x, y);
    }

    public final Vector2 div(float s) {
        return new Vector2(this.x / s, this.y / s);
    }

    public final float dot(Vector2 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return (this.x * o.x) + (this.y * o.y);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vector2)) {
            return false;
        }
        Vector2 vector2 = (Vector2) other;
        return Float.compare(this.x, vector2.x) == 0 && Float.compare(this.y, vector2.y) == 0;
    }

    public final float getMagnitude() {
        return (float) Math.sqrt((this.x * this.x) + (this.y * this.y));
    }

    public final Vector2 getUnit() {
        float magnitude = getMagnitude();
        return magnitude < 1.0E-9f ? new Vector2(0.0f, 0.0f) : div(magnitude);
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public int hashCode() {
        return (Float.hashCode(this.x) * 31) + Float.hashCode(this.y);
    }

    public final Vector2 lerp(Vector2 o, float t) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector2(this.x + ((o.x - this.x) * t), this.y + ((o.y - this.y) * t));
    }

    public final Vector2 minus(Vector2 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector2(this.x - o.x, this.y - o.y);
    }

    public final Vector2 plus(Vector2 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector2(this.x + o.x, this.y + o.y);
    }

    public final Vector2 times(float s) {
        return new Vector2(this.x * s, this.y * s);
    }

    public final Vector2 times(Vector2 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector2(this.x * o.x, this.y * o.y);
    }

    public String toString() {
        return DataTypesKt.fmtNum(this.x) + ", " + DataTypesKt.fmtNum(this.y);
    }

    public final Vector2 unaryMinus() {
        return new Vector2(-this.x, -this.y);
    }
}
