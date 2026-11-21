package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u001d\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u0000 ,2\u00020\u0001:\u0001,B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0011\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\u000e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0011\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0086\u0002J\u0011\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0003H\u0086\u0002J\u0011\u0010\u0011\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000H\u0086\u0002J\t\u0010\u0012\u001a\u00020\u0000H\u0086\u0002J\u000e\u0010\u0013\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000J\u0016\u0010\u001a\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0003J\u0006\u0010\u001c\u001a\u00020\u0000J\u000e\u0010\u001d\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0000J\u0011\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020!H\u0086\u0002J\b\u0010\"\u001a\u00020#H\u0016J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J'\u0010'\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010+\u001a\u00020!HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0015\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0016\u0010\tR\u0011\u0010\u0017\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019¨\u0006-"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Vector3;", "", "x", "", "y", "z", "<init>", "(FFF)V", "getX", "()F", "getY", "getZ", "plus", "o", "minus", "times", "s", "div", "unaryMinus", "dot", "cross", "magnitude", "getMagnitude", "unit", "getUnit", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "lerp", "t", "abs", "min", "max", "get", "i", "", "toString", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Vector3 {
    private final float x;
    private final float y;
    private final float z;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Vector3 ZERO = new Vector3(0.0f, 0.0f, 0.0f);
    private static final Vector3 ONE = new Vector3(1.0f, 1.0f, 1.0f);
    private static final Vector3 X = new Vector3(1.0f, 0.0f, 0.0f);
    private static final Vector3 Y = new Vector3(0.0f, 1.0f, 0.0f);
    private static final Vector3 Z = new Vector3(0.0f, 0.0f, 1.0f);

    /* compiled from: DataTypes.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0007R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0007R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Vector3$Companion;", "", "<init>", "()V", "ZERO", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "getZERO", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "ONE", "getONE", "X", "getX", "Y", "getY", "Z", "getZ", "axis", "i", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Vector3 axis(int i) {
            switch (i) {
                case 0:
                    return getX();
                case 1:
                    return getY();
                default:
                    return getZ();
            }
        }

        public final Vector3 getONE() {
            return Vector3.access$getONE$cp();
        }

        public final Vector3 getX() {
            return Vector3.access$getX$cp();
        }

        public final Vector3 getY() {
            return Vector3.access$getY$cp();
        }

        public final Vector3 getZ() {
            return Vector3.access$getZ$cp();
        }

        public final Vector3 getZERO() {
            return Vector3.access$getZERO$cp();
        }
    }

    public Vector3(float f, float f2, float f3) {
        this.x = f;
        this.y = f2;
        this.z = f3;
    }

    public static final /* synthetic */ Vector3 access$getONE$cp() {
        return ONE;
    }

    public static final /* synthetic */ Vector3 access$getX$cp() {
        return X;
    }

    public static final /* synthetic */ Vector3 access$getY$cp() {
        return Y;
    }

    public static final /* synthetic */ Vector3 access$getZ$cp() {
        return Z;
    }

    public static final /* synthetic */ Vector3 access$getZERO$cp() {
        return ZERO;
    }

    public static /* synthetic */ Vector3 copy$default(Vector3 vector3, float f, float f2, float f3, int i, Object obj) {
        if ((i & 1) != 0) {
            f = vector3.x;
        }
        if ((i & 2) != 0) {
            f2 = vector3.y;
        }
        if ((i & 4) != 0) {
            f3 = vector3.z;
        }
        return vector3.copy(f, f2, f3);
    }

    public final Vector3 abs() {
        return new Vector3(Math.abs(this.x), Math.abs(this.y), Math.abs(this.z));
    }

    /* renamed from: component1, reason: from getter */
    public final float getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final float getY() {
        return this.y;
    }

    /* renamed from: component3, reason: from getter */
    public final float getZ() {
        return this.z;
    }

    public final Vector3 copy(float x, float y, float z) {
        return new Vector3(x, y, z);
    }

    public final Vector3 cross(Vector3 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector3((this.y * o.z) - (this.z * o.y), (this.z * o.x) - (this.x * o.z), (this.x * o.y) - (this.y * o.x));
    }

    public final Vector3 div(float s) {
        return new Vector3(this.x / s, this.y / s, this.z / s);
    }

    public final Vector3 div(Vector3 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector3(this.x / o.x, this.y / o.y, this.z / o.z);
    }

    public final float dot(Vector3 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return (this.x * o.x) + (this.y * o.y) + (this.z * o.z);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vector3)) {
            return false;
        }
        Vector3 vector3 = (Vector3) other;
        return Float.compare(this.x, vector3.x) == 0 && Float.compare(this.y, vector3.y) == 0 && Float.compare(this.z, vector3.z) == 0;
    }

    public final float get(int i) {
        switch (i) {
            case 0:
                return this.x;
            case 1:
                return this.y;
            default:
                return this.z;
        }
    }

    public final float getMagnitude() {
        return (float) Math.sqrt((this.x * this.x) + (this.y * this.y) + (this.z * this.z));
    }

    public final Vector3 getUnit() {
        float magnitude = getMagnitude();
        return magnitude < 1.0E-9f ? ZERO : div(magnitude);
    }

    public final float getX() {
        return this.x;
    }

    public final float getY() {
        return this.y;
    }

    public final float getZ() {
        return this.z;
    }

    public int hashCode() {
        return (((Float.hashCode(this.x) * 31) + Float.hashCode(this.y)) * 31) + Float.hashCode(this.z);
    }

    public final Vector3 lerp(Vector3 o, float t) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector3(this.x + ((o.x - this.x) * t), this.y + ((o.y - this.y) * t), this.z + ((o.z - this.z) * t));
    }

    public final Vector3 max(Vector3 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector3(Math.max(this.x, o.x), Math.max(this.y, o.y), Math.max(this.z, o.z));
    }

    public final Vector3 min(Vector3 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector3(Math.min(this.x, o.x), Math.min(this.y, o.y), Math.min(this.z, o.z));
    }

    public final Vector3 minus(Vector3 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector3(this.x - o.x, this.y - o.y, this.z - o.z);
    }

    public final Vector3 plus(Vector3 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector3(this.x + o.x, this.y + o.y, this.z + o.z);
    }

    public final Vector3 times(float s) {
        return new Vector3(this.x * s, this.y * s, this.z * s);
    }

    public final Vector3 times(Vector3 o) {
        Intrinsics.checkNotNullParameter(o, "o");
        return new Vector3(this.x * o.x, this.y * o.y, this.z * o.z);
    }

    public String toString() {
        return DataTypesKt.fmtNum(this.x) + ", " + DataTypesKt.fmtNum(this.y) + ", " + DataTypesKt.fmtNum(this.z);
    }

    public final Vector3 unaryMinus() {
        return new Vector3(-this.x, -this.y, -this.z);
    }
}
