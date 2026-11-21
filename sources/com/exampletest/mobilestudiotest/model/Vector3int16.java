package com.exampletest.mobilestudiotest.model;

import kotlin.Metadata;

/* compiled from: DataTypes.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J'\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/exampletest/mobilestudiotest/model/Vector3int16;", "", "x", "", "y", "z", "<init>", "(III)V", "getX", "()I", "getY", "getZ", "toString", "", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final /* data */ class Vector3int16 {
    private final int x;
    private final int y;
    private final int z;

    public Vector3int16(int i, int i2, int i3) {
        this.x = i;
        this.y = i2;
        this.z = i3;
    }

    public static /* synthetic */ Vector3int16 copy$default(Vector3int16 vector3int16, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            i = vector3int16.x;
        }
        if ((i4 & 2) != 0) {
            i2 = vector3int16.y;
        }
        if ((i4 & 4) != 0) {
            i3 = vector3int16.z;
        }
        return vector3int16.copy(i, i2, i3);
    }

    /* renamed from: component1, reason: from getter */
    public final int getX() {
        return this.x;
    }

    /* renamed from: component2, reason: from getter */
    public final int getY() {
        return this.y;
    }

    /* renamed from: component3, reason: from getter */
    public final int getZ() {
        return this.z;
    }

    public final Vector3int16 copy(int x, int y, int z) {
        return new Vector3int16(x, y, z);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Vector3int16)) {
            return false;
        }
        Vector3int16 vector3int16 = (Vector3int16) other;
        return this.x == vector3int16.x && this.y == vector3int16.y && this.z == vector3int16.z;
    }

    public final int getX() {
        return this.x;
    }

    public final int getY() {
        return this.y;
    }

    public final int getZ() {
        return this.z;
    }

    public int hashCode() {
        return (((Integer.hashCode(this.x) * 31) + Integer.hashCode(this.y)) * 31) + Integer.hashCode(this.z);
    }

    public String toString() {
        return this.x + ", " + this.y + ", " + this.z;
    }
}
