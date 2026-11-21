package com.exampletest.mobilestudiotest.engine;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: Csg.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0014\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001:\u0004*+,-B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J(\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J(\u0010\f\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J2\u0010\r\u001a\u0004\u0018\u00010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u0007H\u0002JF\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\b\u0002\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\f\u0012\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00070\u0019J\u0018\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u000fH\u0002JF\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\b0\u001f2\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000f0\u00072\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\"\u001a\u00020\u000f2\b\b\u0002\u0010#\u001a\u00020$H\u0002J \u0010%\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010!\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J \u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020(0'2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006."}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Csg;", "", "<init>", "()V", "EPS", "", "union", "", "Lcom/exampletest/mobilestudiotest/engine/Csg$Polygon;", "a", "b", "subtract", "intersect", "poly", "pts", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "shared", "", "smooth", "partPolygons", "p", "Lcom/exampletest/mobilestudiotest/model/Instance;", "toLocal", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "cache", "Lkotlin/Function1;", "orient", "outward", "addOriented", "", "out", "", "local", "cf", "outwardLocal", "approximate", "", "transform", "toTriangles", "", "", "polys", "Vertex", "Plane", "Polygon", "Node", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class Csg {
    private static final float EPS = 1.0E-4f;
    public static final Csg INSTANCE = new Csg();

    /* compiled from: Csg.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u001c\u001a\u00020\u0000J\u0006\u0010\u001d\u001a\u00020\u001eJ\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u000e\u0010 \u001a\u00020\u001e2\u0006\u0010!\u001a\u00020\u0000J\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u0014\u0010#\u001a\u00020\u001e2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0000X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011R*\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0016j\b\u0012\u0004\u0012\u00020\u0004`\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006$"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Csg$Node;", "", "polys", "", "Lcom/exampletest/mobilestudiotest/engine/Csg$Polygon;", "<init>", "(Ljava/util/List;)V", "plane", "Lcom/exampletest/mobilestudiotest/engine/Csg$Plane;", "getPlane", "()Lcom/exampletest/mobilestudiotest/engine/Csg$Plane;", "setPlane", "(Lcom/exampletest/mobilestudiotest/engine/Csg$Plane;)V", "front", "getFront", "()Lcom/exampletest/mobilestudiotest/engine/Csg$Node;", "setFront", "(Lcom/exampletest/mobilestudiotest/engine/Csg$Node;)V", "back", "getBack", "setBack", "polygons", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPolygons", "()Ljava/util/ArrayList;", "setPolygons", "(Ljava/util/ArrayList;)V", "clone", "invert", "", "clipPolygons", "clipTo", "bsp", "allPolygons", "build", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Node {
        private Node back;
        private Node front;
        private Plane plane;
        private ArrayList<Polygon> polygons;

        public Node() {
            this(null, 1, null);
        }

        public Node(List<Polygon> list) {
            this.polygons = new ArrayList<>();
            if (list != null) {
                build(list);
            }
        }

        public /* synthetic */ Node(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        public final List<Polygon> allPolygons() {
            ArrayList arrayList = new ArrayList(this.polygons);
            Node node = this.front;
            if (node != null) {
                arrayList.addAll(node.allPolygons());
            }
            Node node2 = this.back;
            if (node2 != null) {
                arrayList.addAll(node2.allPolygons());
            }
            return arrayList;
        }

        public final void build(List<Polygon> polys) {
            Intrinsics.checkNotNullParameter(polys, "polys");
            if (polys.isEmpty()) {
                return;
            }
            Node node = this;
            ArrayList arrayList = polys;
            while (!arrayList.isEmpty()) {
                if (node.plane == null) {
                    node.plane = arrayList.get(0).getPlane();
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (Polygon polygon : arrayList) {
                    Plane plane = node.plane;
                    Intrinsics.checkNotNull(plane);
                    plane.split(polygon, node.polygons, node.polygons, arrayList2, arrayList3);
                }
                if (!arrayList3.isEmpty()) {
                    if (node.back == null) {
                        node.back = new Node(null, 1, null);
                    }
                    Node node2 = node.back;
                    Intrinsics.checkNotNull(node2);
                    node2.build(arrayList3);
                }
                if (arrayList2.isEmpty()) {
                    return;
                }
                if (node.front == null) {
                    node.front = new Node(null, 1, null);
                }
                Node node3 = node.front;
                Intrinsics.checkNotNull(node3);
                node = node3;
                arrayList = arrayList2;
            }
        }

        public final List<Polygon> clipPolygons(List<Polygon> polys) {
            ArrayList arrayList;
            ArrayList arrayList2;
            Intrinsics.checkNotNullParameter(polys, "polys");
            Plane plane = this.plane;
            if (plane == null) {
                return new ArrayList(polys);
            }
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            Iterator<Polygon> it = polys.iterator();
            while (it.hasNext()) {
                plane.split(it.next(), arrayList3, arrayList4, arrayList3, arrayList4);
            }
            Node node = this.front;
            if (node == null || (arrayList = node.clipPolygons(arrayList3)) == null) {
                arrayList = arrayList3;
            }
            ArrayList arrayList5 = new ArrayList(arrayList);
            if (this.back != null) {
                Node node2 = this.back;
                Intrinsics.checkNotNull(node2);
                arrayList2 = new ArrayList(node2.clipPolygons(arrayList4));
            } else {
                arrayList2 = new ArrayList();
            }
            arrayList5.addAll(arrayList2);
            return arrayList5;
        }

        public final void clipTo(Node bsp) {
            Intrinsics.checkNotNullParameter(bsp, "bsp");
            this.polygons = new ArrayList<>(bsp.clipPolygons(this.polygons));
            Node node = this.front;
            if (node != null) {
                node.clipTo(bsp);
            }
            Node node2 = this.back;
            if (node2 != null) {
                node2.clipTo(bsp);
            }
        }

        public final Node clone() {
            Node node = new Node(null, 1, null);
            node.plane = this.plane;
            Node node2 = this.front;
            node.front = node2 != null ? node2.clone() : null;
            Node node3 = this.back;
            node.back = node3 != null ? node3.clone() : null;
            node.polygons = new ArrayList<>(this.polygons);
            return node;
        }

        public final Node getBack() {
            return this.back;
        }

        public final Node getFront() {
            return this.front;
        }

        public final Plane getPlane() {
            return this.plane;
        }

        public final ArrayList<Polygon> getPolygons() {
            return this.polygons;
        }

        public final void invert() {
            int size = this.polygons.size();
            for (int i = 0; i < size; i++) {
                this.polygons.set(i, this.polygons.get(i).flipped());
            }
            Plane plane = this.plane;
            this.plane = plane != null ? plane.flipped() : null;
            Node node = this.front;
            if (node != null) {
                node.invert();
            }
            Node node2 = this.back;
            if (node2 != null) {
                node2.invert();
            }
            Node node3 = this.front;
            this.front = this.back;
            this.back = node3;
        }

        public final void setBack(Node node) {
            this.back = node;
        }

        public final void setFront(Node node) {
            this.front = node;
        }

        public final void setPlane(Plane plane) {
            this.plane = plane;
        }

        public final void setPolygons(ArrayList<Polygon> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
            this.polygons = arrayList;
        }
    }

    /* compiled from: Csg.kt */
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0005\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0006\u0010\f\u001a\u00020\u0000JF\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00122\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00100\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Csg$Plane;", "", "normal", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "w", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Vector3;F)V", "getNormal", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getW", "()F", "flipped", "split", "", "p", "Lcom/exampletest/mobilestudiotest/engine/Csg$Polygon;", "coplanarFront", "", "coplanarBack", "front", "back", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Plane {

        /* renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Vector3 normal;
        private final float w;

        /* compiled from: Csg.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007¨\u0006\n"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Csg$Plane$Companion;", "", "<init>", "()V", TypedValues.TransitionType.S_FROM, "Lcom/exampletest/mobilestudiotest/engine/Csg$Plane;", "a", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "b", "c", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes7.dex */
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final Plane from(Vector3 a, Vector3 b, Vector3 c) {
                Intrinsics.checkNotNullParameter(a, "a");
                Intrinsics.checkNotNullParameter(b, "b");
                Intrinsics.checkNotNullParameter(c, "c");
                Vector3 cross = b.minus(a).cross(c.minus(a));
                if (cross.getMagnitude() < 1.0E-9f) {
                    return null;
                }
                Vector3 unit = cross.getUnit();
                return new Plane(unit, unit.dot(a));
            }
        }

        public Plane(Vector3 normal, float f) {
            Intrinsics.checkNotNullParameter(normal, "normal");
            this.normal = normal;
            this.w = f;
        }

        public final Plane flipped() {
            return new Plane(this.normal.unaryMinus(), -this.w);
        }

        public final Vector3 getNormal() {
            return this.normal;
        }

        public final float getW() {
            return this.w;
        }

        public final void split(Polygon p, List<Polygon> coplanarFront, List<Polygon> coplanarBack, List<Polygon> front, List<Polygon> back) {
            int i;
            Plane plane = this;
            Intrinsics.checkNotNullParameter(p, "p");
            Intrinsics.checkNotNullParameter(coplanarFront, "coplanarFront");
            Intrinsics.checkNotNullParameter(coplanarBack, "coplanarBack");
            Intrinsics.checkNotNullParameter(front, "front");
            Intrinsics.checkNotNullParameter(back, "back");
            int i2 = 0;
            int i3 = 1;
            int i4 = 2;
            int i5 = 0;
            int[] iArr = new int[p.getVertices().size()];
            Iterator<T> it = p.getVertices().iterator();
            int i6 = 0;
            while (it.hasNext()) {
                int i7 = i6;
                i6++;
                int i8 = i2;
                float dot = plane.normal.dot(((Vertex) it.next()).getPos()) - plane.w;
                int i9 = dot < -1.0E-4f ? 2 : dot > 1.0E-4f ? 1 : i8;
                i5 |= i9;
                iArr[i7] = i9;
                i2 = i8;
            }
            if (i5 == 0) {
                (plane.normal.dot(p.getPlane().normal) > 0.0f ? coplanarFront : coplanarBack).add(p);
                return;
            }
            if (i5 == 1) {
                front.add(p);
                return;
            }
            if (i5 == 2) {
                back.add(p);
                return;
            }
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            int size = p.getVertices().size();
            int i10 = 0;
            while (i10 < size) {
                int i11 = (i10 + 1) % size;
                int i12 = iArr[i10];
                int i13 = iArr[i11];
                Vertex vertex = p.getVertices().get(i10);
                Vertex vertex2 = p.getVertices().get(i11);
                if (i12 != i4) {
                    arrayList.add(vertex);
                }
                if (i12 != i3) {
                    arrayList2.add(vertex);
                }
                int i14 = i3;
                if ((i12 | i13) == 3) {
                    i = i4;
                    Vertex lerp = vertex.lerp(vertex2, (plane.w - plane.normal.dot(vertex.getPos())) / plane.normal.dot(vertex2.getPos().minus(vertex.getPos())));
                    arrayList.add(lerp);
                    arrayList2.add(lerp);
                } else {
                    i = i4;
                }
                i10++;
                plane = this;
                i3 = i14;
                i4 = i;
            }
            if (arrayList.size() >= 3) {
                front.add(new Polygon(arrayList, p.getShared(), p.getPlane()));
            }
            if (arrayList2.size() >= 3) {
                back.add(new Polygon(arrayList2, p.getShared(), p.getPlane()));
            }
        }
    }

    /* compiled from: Csg.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B%\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u0006\u0010\u0011\u001a\u00020\u0000R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Csg$Polygon;", "", "vertices", "", "Lcom/exampletest/mobilestudiotest/engine/Csg$Vertex;", "shared", "", "plane", "Lcom/exampletest/mobilestudiotest/engine/Csg$Plane;", "<init>", "(Ljava/util/List;ILcom/exampletest/mobilestudiotest/engine/Csg$Plane;)V", "getVertices", "()Ljava/util/List;", "getShared", "()I", "getPlane", "()Lcom/exampletest/mobilestudiotest/engine/Csg$Plane;", "flipped", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Polygon {
        private final Plane plane;
        private final int shared;
        private final List<Vertex> vertices;

        public Polygon(List<Vertex> vertices, int i, Plane plane) {
            Intrinsics.checkNotNullParameter(vertices, "vertices");
            Intrinsics.checkNotNullParameter(plane, "plane");
            this.vertices = vertices;
            this.shared = i;
            this.plane = plane;
        }

        public final Polygon flipped() {
            List reversed = CollectionsKt.reversed(this.vertices);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(reversed, 10));
            Iterator it = reversed.iterator();
            while (it.hasNext()) {
                arrayList.add(((Vertex) it.next()).flipped());
            }
            return new Polygon(arrayList, this.shared, this.plane.flipped());
        }

        public final Plane getPlane() {
            return this.plane;
        }

        public final int getShared() {
            return this.shared;
        }

        public final List<Vertex> getVertices() {
            return this.vertices;
        }
    }

    /* compiled from: Csg.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\n\u001a\u00020\u0000J\u0016\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Csg$Vertex;", "", "pos", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "normal", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getPos", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getNormal", "flipped", "lerp", "o", "t", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Vertex {
        private final Vector3 normal;
        private final Vector3 pos;

        public Vertex(Vector3 pos, Vector3 normal) {
            Intrinsics.checkNotNullParameter(pos, "pos");
            Intrinsics.checkNotNullParameter(normal, "normal");
            this.pos = pos;
            this.normal = normal;
        }

        public final Vertex flipped() {
            return new Vertex(this.pos, this.normal.unaryMinus());
        }

        public final Vector3 getNormal() {
            return this.normal;
        }

        public final Vector3 getPos() {
            return this.pos;
        }

        public final Vertex lerp(Vertex o, float t) {
            Intrinsics.checkNotNullParameter(o, "o");
            return new Vertex(this.pos.lerp(o.pos, t), this.normal.lerp(o.normal, t));
        }
    }

    private Csg() {
    }

    private final void addOriented(List<Polygon> out, List<Vector3> local, CFrame cf, int shared, Vector3 outwardLocal, boolean approximate) {
        List<Vector3> list = local;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(cf.times((Vector3) it.next()));
        }
        Polygon poly$default = poly$default(this, arrayList, shared, null, 4, null);
        if (poly$default == null) {
            return;
        }
        Vector3 vectorToWorld = cf.vectorToWorld(outwardLocal);
        out.add((poly$default.getPlane().getNormal().dot(vectorToWorld) < 0.0f || (approximate && poly$default.getPlane().getNormal().dot(vectorToWorld) < 0.0f)) ? poly$default.flipped() : poly$default);
    }

    static /* synthetic */ void addOriented$default(Csg csg, List list, List list2, CFrame cFrame, int i, Vector3 vector3, boolean z, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            z = false;
        }
        csg.addOriented(list, list2, cFrame, i, vector3, z);
    }

    private final Polygon orient(Polygon p, Vector3 outward) {
        return p.getPlane().getNormal().dot(outward) < 0.0f ? p.flipped() : p;
    }

    private static final void partPolygons$add(int i, CFrame cFrame, ArrayList<Polygon> arrayList, Vector3... vector3Arr) {
        Csg csg = INSTANCE;
        ArrayList arrayList2 = new ArrayList(vector3Arr.length);
        for (Vector3 vector3 : vector3Arr) {
            arrayList2.add(cFrame.times(vector3));
        }
        Polygon poly$default = poly$default(csg, arrayList2, i, null, 4, null);
        if (poly$default != null) {
            arrayList.add(poly$default);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ List partPolygons$default(Csg csg, Instance instance, int i, CFrame cFrame, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            cFrame = null;
        }
        if ((i2 & 8) != 0) {
            function1 = Csg$partPolygons$1.INSTANCE;
        }
        return csg.partPolygons(instance, i, cFrame, function1);
    }

    private static final Vector3 partPolygons$pt(int i, int i2, float f, int i3, int i4) {
        double d = (i3 * 3.141592653589793d) / i;
        double d2 = (i4 * 6.283185307179586d) / i2;
        return new Vector3(((float) (Math.sin(d) * Math.cos(d2))) * f, ((float) Math.cos(d)) * f, ((float) (Math.sin(d) * Math.sin(d2))) * f);
    }

    private final Polygon poly(List<Vector3> pts, int shared, List<Vector3> smooth) {
        Vector3 normal;
        Plane from = Plane.INSTANCE.from(pts.get(0), pts.get(1), pts.get(2));
        if (from == null) {
            return null;
        }
        List<Vector3> list = pts;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
        int i = 0;
        for (Object obj : list) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Vector3 vector3 = (Vector3) obj;
            if (smooth == null || (normal = smooth.get(i)) == null) {
                normal = from.getNormal();
            }
            arrayList.add(new Vertex(vector3, normal));
            i = i2;
        }
        return new Polygon(arrayList, shared, from);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Polygon poly$default(Csg csg, List list, int i, List list2, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            list2 = null;
        }
        return csg.poly(list, i, list2);
    }

    private final Polygon transform(Polygon p, CFrame cf, int shared) {
        List<Vertex> vertices = p.getVertices();
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(vertices, 10));
        for (Vertex vertex : vertices) {
            arrayList.add(new Vertex(cf.times(vertex.getPos()), cf.vectorToWorld(vertex.getNormal()).getUnit()));
        }
        ArrayList arrayList2 = arrayList;
        Plane from = Plane.INSTANCE.from(((Vertex) arrayList2.get(0)).getPos(), ((Vertex) arrayList2.get(1)).getPos(), ((Vertex) arrayList2.get(2)).getPos());
        if (from == null) {
            from = p.getPlane();
        }
        return new Polygon(arrayList2, shared, from);
    }

    public final List<Polygon> intersect(List<Polygon> a, List<Polygon> b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Node node = new Node(a);
        Node node2 = new Node(b);
        node.invert();
        node2.clipTo(node);
        node2.invert();
        node.clipTo(node2);
        node2.clipTo(node);
        node.build(node2.allPolygons());
        node.invert();
        return node.allPolygons();
    }

    public final List<Polygon> partPolygons(Instance p, int shared, CFrame toLocal, Function1<? super Instance, ? extends List<Polygon>> cache) {
        float f;
        int i;
        List listOf;
        CFrame cFrame;
        float f2;
        CFrame times;
        int i2 = shared;
        Intrinsics.checkNotNullParameter(p, "p");
        Intrinsics.checkNotNullParameter(cache, "cache");
        CFrame cframe = PartData.INSTANCE.cframe(p);
        CFrame cFrame2 = (toLocal == null || (times = toLocal.inverse().times(cframe)) == null) ? cframe : times;
        if (p.isA("PartOperation") && !Intrinsics.areEqual(p.getClassName(), "NegateOperation")) {
            List<Polygon> invoke = cache.invoke(p);
            if (invoke == null) {
                return CollectionsKt.emptyList();
            }
            List<Polygon> list = invoke;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(INSTANCE.transform((Polygon) it.next(), cFrame2, i2));
            }
            return arrayList;
        }
        Vector3 size = PartData.INSTANCE.size(p);
        Vector3 times2 = size.times(0.5f);
        ArrayList arrayList2 = new ArrayList();
        switch (PartData.INSTANCE.shape(p)) {
            case 0:
                CFrame cFrame3 = cFrame2;
                int i3 = 3;
                float min = Math.min(size.getX(), Math.min(size.getY(), size.getZ())) * 0.5f;
                int i4 = 10;
                int i5 = 16;
                int i6 = 0;
                while (i6 < i4) {
                    int i7 = 0;
                    while (i7 < i5) {
                        Vector3 partPolygons$pt = partPolygons$pt(i4, i5, min, i6, i7);
                        Vector3 partPolygons$pt2 = partPolygons$pt(i4, i5, min, i6, i7 + 1);
                        Vector3 partPolygons$pt3 = partPolygons$pt(i4, i5, min, i6 + 1, i7 + 1);
                        Vector3 partPolygons$pt4 = partPolygons$pt(i4, i5, min, i6 + 1, i7);
                        if (i6 == 0) {
                            f = min;
                            i = i4;
                            Vector3[] vector3Arr = new Vector3[i3];
                            vector3Arr[0] = partPolygons$pt;
                            vector3Arr[1] = partPolygons$pt3;
                            vector3Arr[2] = partPolygons$pt4;
                            listOf = CollectionsKt.listOf((Object[]) vector3Arr);
                        } else {
                            f = min;
                            i = i4;
                            int i8 = i3;
                            if (i6 == i - 1) {
                                Vector3[] vector3Arr2 = new Vector3[i8];
                                vector3Arr2[0] = partPolygons$pt;
                                vector3Arr2[1] = partPolygons$pt2;
                                vector3Arr2[2] = partPolygons$pt3;
                                listOf = CollectionsKt.listOf((Object[]) vector3Arr2);
                            } else {
                                Vector3[] vector3Arr3 = new Vector3[4];
                                vector3Arr3[0] = partPolygons$pt;
                                vector3Arr3[1] = partPolygons$pt2;
                                vector3Arr3[2] = partPolygons$pt3;
                                vector3Arr3[i8] = partPolygons$pt4;
                                listOf = CollectionsKt.listOf((Object[]) vector3Arr3);
                            }
                        }
                        List list2 = listOf;
                        List list3 = listOf;
                        int i9 = i5;
                        int i10 = i6;
                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                        Iterator it2 = list2.iterator();
                        while (it2.hasNext()) {
                            arrayList3.add(cFrame3.times((Vector3) it2.next()));
                            list2 = list2;
                        }
                        ArrayList arrayList4 = arrayList3;
                        List list4 = list3;
                        int i11 = i7;
                        ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list4, 10));
                        Iterator it3 = list4.iterator();
                        while (it3.hasNext()) {
                            arrayList5.add(cFrame3.vectorToWorld(((Vector3) it3.next()).getUnit()));
                            list4 = list4;
                        }
                        ArrayList arrayList6 = arrayList5;
                        Plane from = Plane.INSTANCE.from((Vector3) arrayList4.get(0), (Vector3) arrayList4.get(1), (Vector3) arrayList4.get(2));
                        if (from == null) {
                            cFrame = cFrame3;
                        } else if (from.getNormal().dot((Vector3) arrayList6.get(0)) < 0.0f) {
                            List reversed = CollectionsKt.reversed(arrayList4);
                            List reversed2 = CollectionsKt.reversed(arrayList6);
                            cFrame = cFrame3;
                            Plane from2 = Plane.INSTANCE.from((Vector3) reversed.get(0), (Vector3) reversed.get(1), (Vector3) reversed.get(2));
                            if (from2 != null) {
                                List list5 = reversed;
                                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list5, 10));
                                List list6 = list5;
                                boolean z = false;
                                int i12 = 0;
                                for (Object obj : list6) {
                                    int i13 = i12 + 1;
                                    if (i12 < 0) {
                                        CollectionsKt.throwIndexOverflow();
                                    }
                                    arrayList7.add(new Vertex((Vector3) obj, (Vector3) reversed2.get(i12)));
                                    i12 = i13;
                                    list6 = list6;
                                    list5 = list5;
                                    z = z;
                                    reversed2 = reversed2;
                                }
                                Boolean.valueOf(arrayList2.add(new Polygon(arrayList7, i2, from2)));
                            }
                        } else {
                            cFrame = cFrame3;
                            ArrayList arrayList8 = arrayList4;
                            boolean z2 = false;
                            ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList8, 10));
                            int i14 = 0;
                            for (Object obj2 : arrayList8) {
                                int i15 = i14 + 1;
                                if (i14 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                arrayList9.add(new Vertex((Vector3) obj2, (Vector3) arrayList6.get(i14)));
                                i14 = i15;
                                arrayList8 = arrayList8;
                                z2 = z2;
                                arrayList6 = arrayList6;
                            }
                            Boolean.valueOf(arrayList2.add(new Polygon(arrayList9, i2, from)));
                        }
                        i7 = i11 + 1;
                        min = f;
                        i4 = i;
                        i5 = i9;
                        i6 = i10;
                        cFrame3 = cFrame;
                        i3 = 3;
                    }
                    i6++;
                    i3 = 3;
                }
                Unit unit = Unit.INSTANCE;
                break;
            case 1:
            default:
                CFrame cFrame4 = cFrame2;
                Vector3[] vector3Arr4 = new Vector3[8];
                for (int i16 = 0; i16 < 8; i16++) {
                    vector3Arr4[i16] = new Vector3((i16 & 1) != 0 ? times2.getX() : -times2.getX(), (i16 & 2) != 0 ? times2.getY() : -times2.getY(), (i16 & 4) != 0 ? times2.getZ() : -times2.getZ());
                }
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector3Arr4[0], vector3Arr4[2], vector3Arr4[3], vector3Arr4[1]}), cFrame4, i2, Vector3.INSTANCE.getZ().unaryMinus(), false, 32, null);
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector3Arr4[4], vector3Arr4[5], vector3Arr4[7], vector3Arr4[6]}), cFrame4, shared, Vector3.INSTANCE.getZ(), false, 32, null);
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector3Arr4[0], vector3Arr4[1], vector3Arr4[5], vector3Arr4[4]}), cFrame4, shared, Vector3.INSTANCE.getY().unaryMinus(), false, 32, null);
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector3Arr4[2], vector3Arr4[6], vector3Arr4[7], vector3Arr4[3]}), cFrame4, shared, Vector3.INSTANCE.getY(), false, 32, null);
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector3Arr4[0], vector3Arr4[4], vector3Arr4[6], vector3Arr4[2]}), cFrame4, shared, Vector3.INSTANCE.getX().unaryMinus(), false, 32, null);
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector3Arr4[1], vector3Arr4[3], vector3Arr4[7], vector3Arr4[5]}), cFrame4, shared, Vector3.INSTANCE.getX(), false, 32, null);
                Unit unit2 = Unit.INSTANCE;
                break;
            case 2:
                CFrame cFrame5 = cFrame2;
                int i17 = 1;
                float min2 = Math.min(size.getY(), size.getZ()) * 0.5f;
                IntRange until = RangesKt.until(0, 20);
                int i18 = 2;
                ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                IntRange intRange = until;
                Iterator<Integer> it4 = intRange.iterator();
                while (it4.hasNext()) {
                    IntRange intRange2 = intRange;
                    double nextInt = (((IntIterator) it4).nextInt() * 6.283185307179586d) / 20;
                    arrayList10.add(new Vector3(0.0f, (float) (min2 * Math.cos(nextInt)), (float) (min2 * Math.sin(nextInt))));
                    until = until;
                    i17 = i17;
                    intRange = intRange2;
                }
                int i19 = i17;
                ArrayList arrayList11 = arrayList10;
                int i20 = 0;
                while (i20 < 20) {
                    Vector3 vector3 = (Vector3) arrayList11.get(i20);
                    Vector3 vector32 = (Vector3) arrayList11.get((i20 + 1) % 20);
                    Vector3[] vector3Arr5 = new Vector3[4];
                    ArrayList arrayList12 = arrayList11;
                    int i21 = i20;
                    vector3Arr5[0] = new Vector3(-times2.getX(), vector3.getY(), vector3.getZ());
                    vector3Arr5[i19] = new Vector3(times2.getX(), vector3.getY(), vector3.getZ());
                    vector3Arr5[i18] = new Vector3(times2.getX(), vector32.getY(), vector32.getZ());
                    vector3Arr5[3] = new Vector3(-times2.getX(), vector32.getY(), vector32.getZ());
                    List listOf2 = CollectionsKt.listOf((Object[]) vector3Arr5);
                    Vector3[] vector3Arr6 = new Vector3[4];
                    vector3Arr6[0] = new Vector3(0.0f, vector3.getY(), vector3.getZ()).getUnit();
                    vector3Arr6[i19] = new Vector3(0.0f, vector3.getY(), vector3.getZ()).getUnit();
                    vector3Arr6[i18] = new Vector3(0.0f, vector32.getY(), vector32.getZ()).getUnit();
                    vector3Arr6[3] = new Vector3(0.0f, vector32.getY(), vector32.getZ()).getUnit();
                    List listOf3 = CollectionsKt.listOf((Object[]) vector3Arr6);
                    List list7 = listOf2;
                    ArrayList arrayList13 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list7, 10));
                    Iterator it5 = list7.iterator();
                    while (it5.hasNext()) {
                        arrayList13.add(cFrame5.times((Vector3) it5.next()));
                        list7 = list7;
                    }
                    ArrayList arrayList14 = arrayList13;
                    List list8 = listOf3;
                    ArrayList arrayList15 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list8, 10));
                    Iterator it6 = list8.iterator();
                    while (it6.hasNext()) {
                        arrayList15.add(cFrame5.vectorToWorld((Vector3) it6.next()));
                        list8 = list8;
                    }
                    ArrayList arrayList16 = arrayList15;
                    Plane from3 = Plane.INSTANCE.from((Vector3) arrayList14.get(0), (Vector3) arrayList14.get(i19), (Vector3) arrayList14.get(i18));
                    if (from3 == null) {
                        f2 = min2;
                    } else if (from3.getNormal().dot((Vector3) arrayList16.get(0)) < 0.0f) {
                        List reversed3 = CollectionsKt.reversed(arrayList14);
                        List reversed4 = CollectionsKt.reversed(arrayList16);
                        f2 = min2;
                        Plane from4 = Plane.INSTANCE.from((Vector3) reversed3.get(0), (Vector3) reversed3.get(1), (Vector3) reversed3.get(2));
                        if (from4 != null) {
                            List list9 = reversed3;
                            ArrayList arrayList17 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list9, 10));
                            List list10 = list9;
                            int i22 = 0;
                            for (Object obj3 : list10) {
                                int i23 = i22 + 1;
                                if (i22 < 0) {
                                    CollectionsKt.throwIndexOverflow();
                                }
                                arrayList17.add(new Vertex((Vector3) obj3, (Vector3) reversed4.get(i22)));
                                i22 = i23;
                                list9 = list9;
                                reversed3 = reversed3;
                                list10 = list10;
                                reversed4 = reversed4;
                            }
                            arrayList2.add(new Polygon(arrayList17, i2, from4));
                        }
                    } else {
                        f2 = min2;
                        ArrayList arrayList18 = arrayList14;
                        boolean z3 = false;
                        ArrayList arrayList19 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList18, 10));
                        int i24 = 0;
                        for (Object obj4 : arrayList18) {
                            int i25 = i24 + 1;
                            if (i24 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            arrayList19.add(new Vertex((Vector3) obj4, (Vector3) arrayList16.get(i24)));
                            i24 = i25;
                            arrayList18 = arrayList18;
                            z3 = z3;
                            arrayList16 = arrayList16;
                        }
                        arrayList2.add(new Polygon(arrayList19, i2, from3));
                    }
                    i20 = i21 + 1;
                    arrayList11 = arrayList12;
                    min2 = f2;
                    i18 = 2;
                    i19 = 1;
                }
                ArrayList arrayList20 = arrayList11;
                ArrayList arrayList21 = arrayList20;
                boolean z4 = false;
                ArrayList arrayList22 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList21, 10));
                ArrayList<Vector3> arrayList23 = arrayList21;
                boolean z5 = false;
                for (Vector3 vector33 : arrayList23) {
                    arrayList22.add(new Vector3(times2.getX(), vector33.getY(), vector33.getZ()));
                    arrayList21 = arrayList21;
                    z4 = z4;
                    arrayList23 = arrayList23;
                    z5 = z5;
                }
                ArrayList arrayList24 = arrayList22;
                ArrayList arrayList25 = arrayList20;
                boolean z6 = false;
                ArrayList arrayList26 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList25, 10));
                ArrayList<Vector3> arrayList27 = arrayList25;
                for (Vector3 vector34 : arrayList27) {
                    arrayList26.add(new Vector3(-times2.getX(), vector34.getY(), vector34.getZ()));
                    arrayList24 = arrayList24;
                    arrayList25 = arrayList25;
                    z6 = z6;
                    arrayList27 = arrayList27;
                }
                ArrayList arrayList28 = arrayList24;
                List reversed5 = CollectionsKt.reversed(arrayList26);
                ArrayList arrayList29 = arrayList28;
                ArrayList arrayList30 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList29, 10));
                Iterator it7 = arrayList29.iterator();
                while (it7.hasNext()) {
                    arrayList30.add(cFrame5.times((Vector3) it7.next()));
                    reversed5 = reversed5;
                }
                List list11 = reversed5;
                Polygon poly$default = poly$default(this, arrayList30, shared, null, 4, null);
                if (poly$default != null) {
                    Boolean.valueOf(arrayList2.add(INSTANCE.orient(poly$default, cFrame5.vectorToWorld(Vector3.INSTANCE.getX()))));
                }
                List list12 = list11;
                ArrayList arrayList31 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list12, 10));
                Iterator it8 = list12.iterator();
                while (it8.hasNext()) {
                    arrayList31.add(cFrame5.times((Vector3) it8.next()));
                }
                Polygon poly$default2 = poly$default(this, arrayList31, shared, null, 4, null);
                if (poly$default2 != null) {
                    Boolean.valueOf(arrayList2.add(INSTANCE.orient(poly$default2, cFrame5.vectorToWorld(Vector3.INSTANCE.getX().unaryMinus()))));
                    break;
                } else {
                    break;
                }
            case 3:
                Vector3 vector35 = new Vector3(-times2.getX(), -times2.getY(), -times2.getZ());
                Vector3 vector36 = new Vector3(times2.getX(), -times2.getY(), -times2.getZ());
                Vector3 vector37 = new Vector3(-times2.getX(), -times2.getY(), times2.getZ());
                Vector3 vector38 = new Vector3(times2.getX(), -times2.getY(), times2.getZ());
                Vector3 vector39 = new Vector3(-times2.getX(), times2.getY(), times2.getZ());
                Vector3 vector310 = new Vector3(times2.getX(), times2.getY(), times2.getZ());
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector35, vector36, vector38, vector37}), cFrame2, shared, new Vector3(0.0f, -1.0f, 0.0f), false, 32, null);
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector37, vector38, vector310, vector39}), cFrame2, shared, Vector3.INSTANCE.getZ(), false, 32, null);
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector35, vector36, vector310, vector39}), cFrame2, shared, new Vector3(0.0f, size.getZ(), -size.getY()).getUnit(), false, 32, null);
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector35, vector37, vector39}), cFrame2, shared, Vector3.INSTANCE.getX().unaryMinus(), false, 32, null);
                addOriented$default(this, arrayList2, CollectionsKt.listOf((Object[]) new Vector3[]{vector36, vector38, vector310}), cFrame2, shared, Vector3.INSTANCE.getX(), false, 32, null);
                Unit unit3 = Unit.INSTANCE;
                break;
            case 4:
                Vector3 vector311 = new Vector3(times2.getX(), times2.getY(), -times2.getZ());
                Vector3 vector312 = new Vector3(-times2.getX(), -times2.getY(), -times2.getZ());
                Vector3 vector313 = new Vector3(times2.getX(), -times2.getY(), -times2.getZ());
                Vector3 vector314 = new Vector3(times2.getX(), -times2.getY(), times2.getZ());
                Vector3 vector315 = new Vector3(-times2.getX(), -times2.getY(), times2.getZ());
                Vector3 vector316 = new Vector3(times2.getX() * 0.4f, (-times2.getY()) * 0.5f, (-times2.getZ()) * 0.4f);
                for (List<Vector3> list13 : CollectionsKt.listOf((Object[]) new List[]{CollectionsKt.listOf((Object[]) new Vector3[]{vector312, vector313, vector314, vector315}), CollectionsKt.listOf((Object[]) new Vector3[]{vector313, vector314, vector311}), CollectionsKt.listOf((Object[]) new Vector3[]{vector312, vector313, vector311}), CollectionsKt.listOf((Object[]) new Vector3[]{vector312, vector315, vector311}), CollectionsKt.listOf((Object[]) new Vector3[]{vector315, vector314, vector311})})) {
                    List<Vector3> list14 = list13;
                    Vector3 zero = Vector3.INSTANCE.getZERO();
                    Iterator<T> it9 = list14.iterator();
                    while (it9.hasNext()) {
                        zero = zero.plus((Vector3) it9.next());
                        list14 = list14;
                    }
                    addOriented(arrayList2, list13, cFrame2, i2, zero.div(list13.size()).minus(vector316).getUnit(), true);
                    i2 = shared;
                    vector316 = vector316;
                }
                Unit unit4 = Unit.INSTANCE;
                break;
        }
        return arrayList2;
    }

    public final List<Polygon> subtract(List<Polygon> a, List<Polygon> b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Node node = new Node(a);
        Node node2 = new Node(b);
        node.invert();
        node.clipTo(node2);
        node2.clipTo(node);
        node2.invert();
        node2.clipTo(node);
        node2.invert();
        node.build(node2.allPolygons());
        node.invert();
        return node.allPolygons();
    }

    public final Map<Integer, float[]> toTriangles(List<Polygon> polys) {
        Object obj;
        Intrinsics.checkNotNullParameter(polys, "polys");
        HashMap hashMap = new HashMap();
        for (Polygon polygon : polys) {
            HashMap hashMap2 = hashMap;
            Integer valueOf = Integer.valueOf(polygon.getShared());
            Object obj2 = hashMap2.get(valueOf);
            if (obj2 == null) {
                obj = new ArrayList();
                hashMap2.put(valueOf, obj);
            } else {
                obj = obj2;
            }
            ArrayList arrayList = (ArrayList) obj;
            List<Vertex> vertices = polygon.getVertices();
            Vector3 normal = polygon.getPlane().getNormal();
            double d = 0.0d;
            while (vertices.iterator().hasNext()) {
                d += ((Vertex) r7.next()).getNormal().dot(normal);
            }
            double abs = Math.abs((d / vertices.size()) - 1.0d);
            int i = 0;
            boolean z = abs < 0.001d;
            int i2 = 1;
            int size = vertices.size() - 1;
            while (i2 < size) {
                Vertex[] vertexArr = new Vertex[3];
                vertexArr[i] = vertices.get(i);
                vertexArr[1] = vertices.get(i2);
                vertexArr[2] = vertices.get(i2 + 1);
                for (Vertex vertex : CollectionsKt.listOf((Object[]) vertexArr)) {
                    Vector3 normal2 = z ? normal : vertex.getNormal();
                    arrayList.add(Float.valueOf(vertex.getPos().getX()));
                    arrayList.add(Float.valueOf(vertex.getPos().getY()));
                    arrayList.add(Float.valueOf(vertex.getPos().getZ()));
                    arrayList.add(Float.valueOf(normal2.getX()));
                    arrayList.add(Float.valueOf(normal2.getY()));
                    arrayList.add(Float.valueOf(normal2.getZ()));
                    Vector3 abs2 = normal.abs();
                    if (abs2.getY() >= abs2.getX() && abs2.getY() >= abs2.getZ()) {
                        arrayList.add(Float.valueOf(vertex.getPos().getX()));
                        arrayList.add(Float.valueOf(vertex.getPos().getZ()));
                    } else if (abs2.getX() >= abs2.getZ()) {
                        arrayList.add(Float.valueOf(vertex.getPos().getZ()));
                        arrayList.add(Float.valueOf(vertex.getPos().getY()));
                    } else {
                        arrayList.add(Float.valueOf(vertex.getPos().getX()));
                        arrayList.add(Float.valueOf(vertex.getPos().getY()));
                    }
                }
                i2++;
                i = 0;
            }
        }
        HashMap hashMap3 = hashMap;
        LinkedHashMap linkedHashMap = new LinkedHashMap(MapsKt.mapCapacity(hashMap3.size()));
        for (Object obj3 : hashMap3.entrySet()) {
            linkedHashMap.put(((Map.Entry) obj3).getKey(), CollectionsKt.toFloatArray((Collection) ((Map.Entry) obj3).getValue()));
        }
        return linkedHashMap;
    }

    public final List<Polygon> union(List<Polygon> a, List<Polygon> b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        Node node = new Node(a);
        Node node2 = new Node(b);
        node.clipTo(node2);
        node2.clipTo(node);
        node2.invert();
        node2.clipTo(node);
        node2.invert();
        node.build(node2.allPolygons());
        return node.allPolygons();
    }
}
