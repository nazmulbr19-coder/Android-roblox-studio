package com.exampletest.mobilestudiotest.render;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RbxMesh.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rJ\u000e\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/MeshData;", "", "verts", "", "min", "max", "<init>", "([F[F[F)V", "getVerts", "()[F", "getMin", "getMax", "triangles", "", "getTriangles", "()I", "size", "", "i", "center", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MeshData {
    private final float[] max;
    private final float[] min;
    private final float[] verts;

    public MeshData(float[] verts, float[] min, float[] max) {
        Intrinsics.checkNotNullParameter(verts, "verts");
        Intrinsics.checkNotNullParameter(min, "min");
        Intrinsics.checkNotNullParameter(max, "max");
        this.verts = verts;
        this.min = min;
        this.max = max;
    }

    public final float center(int i) {
        return (this.max[i] + this.min[i]) / 2.0f;
    }

    public final float[] getMax() {
        return this.max;
    }

    public final float[] getMin() {
        return this.min;
    }

    public final int getTriangles() {
        return this.verts.length / 24;
    }

    public final float[] getVerts() {
        return this.verts;
    }

    public final float size(int i) {
        return this.max[i] - this.min[i];
    }
}
