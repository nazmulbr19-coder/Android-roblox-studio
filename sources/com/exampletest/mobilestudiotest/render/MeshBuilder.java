package com.exampletest.mobilestudiotest.render;

import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Meshes.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0003H\u0002J\u001e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0003J&\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0003J6\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u0003J\u0006\u0010\u001a\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R!\u0010\u0006\u001a\u0012\u0012\u0004\u0012\u00020\b0\u0007j\b\u0012\u0004\u0012\u00020\b`\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001c"}, d2 = {"Lcom/exampletest/mobilestudiotest/render/MeshBuilder;", "", "center", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "data", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getData", "()Ljava/util/ArrayList;", "put", "", "p", "n", "tri", "a", "b", "c", "quad", "d", "smoothTri", "na", "nb", "nc", "upload", "Lcom/exampletest/mobilestudiotest/render/Mesh;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes8.dex */
public final class MeshBuilder {
    private final Vector3 center;
    private final ArrayList<Float> data;

    public MeshBuilder() {
        this(null, 1, null);
    }

    public MeshBuilder(Vector3 center) {
        Intrinsics.checkNotNullParameter(center, "center");
        this.center = center;
        this.data = new ArrayList<>();
    }

    public /* synthetic */ MeshBuilder(Vector3 vector3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? Vector3.INSTANCE.getZERO() : vector3);
    }

    private final void put(Vector3 p, Vector3 n) {
        this.data.add(Float.valueOf(p.getX()));
        this.data.add(Float.valueOf(p.getY()));
        this.data.add(Float.valueOf(p.getZ()));
        this.data.add(Float.valueOf(n.getX()));
        this.data.add(Float.valueOf(n.getY()));
        this.data.add(Float.valueOf(n.getZ()));
    }

    public final ArrayList<Float> getData() {
        return this.data;
    }

    public final void quad(Vector3 a, Vector3 b, Vector3 c, Vector3 d) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(d, "d");
        tri(a, b, c);
        tri(a, c, d);
    }

    public final void smoothTri(Vector3 a, Vector3 na, Vector3 b, Vector3 nb, Vector3 c, Vector3 nc) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(na, "na");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(nb, "nb");
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(nc, "nc");
        float dot = b.minus(a).cross(c.minus(a)).dot(a.plus(b).plus(c).div(3.0f).minus(this.center));
        put(a, na);
        if (dot < 0.0f) {
            put(c, nc);
            put(b, nb);
        } else {
            put(b, nb);
            put(c, nc);
        }
    }

    public final void tri(Vector3 a, Vector3 b, Vector3 c) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Intrinsics.checkNotNullParameter(c, "c");
        Vector3 unit = b.minus(a).cross(c.minus(a)).getUnit();
        if (unit.dot(a.plus(b).plus(c).div(3.0f).minus(this.center)) < 0.0f) {
            put(a, unit.unaryMinus());
            put(c, unit.unaryMinus());
            put(b, unit.unaryMinus());
        } else {
            put(a, unit);
            put(b, unit);
            put(c, unit);
        }
    }

    public final Mesh upload() {
        float[] floatArray = CollectionsKt.toFloatArray(this.data);
        return Meshes.INSTANCE.upload(floatArray, 6, 4, floatArray);
    }
}
