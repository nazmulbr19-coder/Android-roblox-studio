package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\b\u0010\n\u001a\u00020\u000bH\u0016J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Ray;", "", "origin", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "direction", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getOrigin", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getDirection", "toString", "", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Ray {
    private final Vector3 direction;
    private final Vector3 origin;

    public Ray(Vector3 origin, Vector3 direction) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(direction, "direction");
        this.origin = origin;
        this.direction = direction;
    }

    public static /* synthetic */ Ray copy$default(Ray ray, Vector3 vector3, Vector3 vector32, int i, Object obj) {
        if ((i & 1) != 0) {
            vector3 = ray.origin;
        }
        if ((i & 2) != 0) {
            vector32 = ray.direction;
        }
        return ray.copy(vector3, vector32);
    }

    /* renamed from: component1, reason: from getter */
    public final Vector3 getOrigin() {
        return this.origin;
    }

    /* renamed from: component2, reason: from getter */
    public final Vector3 getDirection() {
        return this.direction;
    }

    public final Ray copy(Vector3 origin, Vector3 direction) {
        Intrinsics.checkNotNullParameter(origin, "origin");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return new Ray(origin, direction);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Ray)) {
            return false;
        }
        Ray ray = (Ray) other;
        return Intrinsics.areEqual(this.origin, ray.origin) && Intrinsics.areEqual(this.direction, ray.direction);
    }

    public final Vector3 getDirection() {
        return this.direction;
    }

    public final Vector3 getOrigin() {
        return this.origin;
    }

    public int hashCode() {
        return (this.origin.hashCode() * 31) + this.direction.hashCode();
    }

    public String toString() {
        return "{" + this.origin + "}, {" + this.direction + "}";
    }
}
