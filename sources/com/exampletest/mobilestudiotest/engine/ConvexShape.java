package com.exampletest.mobilestudiotest.engine;

import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Geometry.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B1\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u0004H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\r\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/ConvexShape;", "", "verts", "", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "normals", "edges", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "getVerts", "()Ljava/util/List;", "getNormals", "getEdges", "center", "getCenter", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "project", "Lkotlin/Pair;", "", "axis", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public class ConvexShape {
    private final Vector3 center;
    private final List<Vector3> edges;
    private final List<Vector3> normals;
    private final List<Vector3> verts;

    public ConvexShape(List<Vector3> verts, List<Vector3> normals, List<Vector3> edges) {
        Intrinsics.checkNotNullParameter(verts, "verts");
        Intrinsics.checkNotNullParameter(normals, "normals");
        Intrinsics.checkNotNullParameter(edges, "edges");
        this.verts = verts;
        this.normals = normals;
        this.edges = edges;
        List<Vector3> list = this.verts;
        Vector3 zero = Vector3.INSTANCE.getZERO();
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            zero = zero.plus((Vector3) it.next());
        }
        this.center = zero.div(this.verts.size());
    }

    public final Vector3 getCenter() {
        return this.center;
    }

    public final List<Vector3> getEdges() {
        return this.edges;
    }

    public final List<Vector3> getNormals() {
        return this.normals;
    }

    public final List<Vector3> getVerts() {
        return this.verts;
    }

    public Pair<Float, Float> project(Vector3 axis) {
        Intrinsics.checkNotNullParameter(axis, "axis");
        float f = Float.MAX_VALUE;
        float f2 = -3.4028235E38f;
        Iterator<Vector3> it = this.verts.iterator();
        while (it.hasNext()) {
            float dot = it.next().dot(axis);
            if (dot < f) {
                f = dot;
            }
            if (dot > f2) {
                f2 = dot;
            }
        }
        return TuplesKt.to(Float.valueOf(f), Float.valueOf(f2));
    }
}
