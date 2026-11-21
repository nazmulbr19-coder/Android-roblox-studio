package com.exampletest.mobilestudiotest.core;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.exampletest.mobilestudiotest.core.Studio;
import com.exampletest.mobilestudiotest.engine.Csg;
import com.exampletest.mobilestudiotest.engine.Geometry;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.Color3;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.InstanceFactory;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import com.exampletest.mobilestudiotest.render.UnionMeshes;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: SolidModeling.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002./B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0006J\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u0011\u001a\u00020\u0006J\u000e\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0006J$\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00142\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0002J\u001e\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u0010H\u0002J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0011\u001a\u00020\u0006J&\u0010\u001a\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00062\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00102\u0006\u0010\u001b\u001a\u00020\u000bH\u0002J\u0018\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0018\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0006H\u0002J\u0016\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\bJ\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0002J\u0018\u0010%\u001a\u00020\"2\u0006\u0010&\u001a\u00020\u00062\u0006\u0010'\u001a\u00020\u0006H\u0002J\u000e\u0010(\u001a\u00020)2\u0006\u0010#\u001a\u00020$J\u0018\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010#\u001a\u00020$2\u0006\u0010,\u001a\u00020\rJ\u0010\u0010-\u001a\u0004\u0018\u00010+2\u0006\u0010#\u001a\u00020$RN\u0010\u0004\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\b0\b\u0018\u00010\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000RN\u0010\n\u001aB\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000b0\u000b \u0007* \u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u000b0\u000b\u0018\u00010\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/SolidModeling;", "", "<init>", "()V", "cache", "", "Lcom/exampletest/mobilestudiotest/model/Instance;", "kotlin.jvm.PlatformType", "Lcom/exampletest/mobilestudiotest/core/SolidModeling$Result;", "", "failed", "", "isOperation", "", "i", "sources", "", "op", "canSeparate", TypedValues.Custom.S_REFERENCE, "Lkotlin/Pair;", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "srcs", "signature", "result", "compute", "sig", "scaledPolys", "Lcom/exampletest/mobilestudiotest/engine/Csg$Polygon;", "storedPolys", "scaleOf", "r", "notify", "", "studio", "Lcom/exampletest/mobilestudiotest/core/Studio;", "copyPartProps", TypedValues.TransitionType.S_FROM, TypedValues.TransitionType.S_TO, "negate", "", "combine", "", "intersect", "separate", "Style", "Result", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class SolidModeling {
    public static final SolidModeling INSTANCE = new SolidModeling();
    private static final Map<Instance, Result> cache = Collections.synchronizedMap(new WeakHashMap());
    private static final Map<Instance, Long> failed = Collections.synchronizedMap(new WeakHashMap());

    /* compiled from: SolidModeling.kt */
    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\u0018\u00002\u00020\u0001BO\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u000e¢\u0006\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001a¨\u0006\u001c"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/SolidModeling$Result;", "", "polys", "", "Lcom/exampletest/mobilestudiotest/engine/Csg$Polygon;", "tris", "", "", "", "styles", "Lcom/exampletest/mobilestudiotest/core/SolidModeling$Style;", "sig", "", "initialSize", "Lcom/exampletest/mobilestudiotest/model/Vector3;", TypedValues.CycleType.S_WAVE_OFFSET, "<init>", "(Ljava/util/List;Ljava/util/Map;Ljava/util/List;JLcom/exampletest/mobilestudiotest/model/Vector3;Lcom/exampletest/mobilestudiotest/model/Vector3;)V", "getPolys", "()Ljava/util/List;", "getTris", "()Ljava/util/Map;", "getStyles", "getSig", "()J", "getInitialSize", "()Lcom/exampletest/mobilestudiotest/model/Vector3;", "getOffset", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Result {
        private final Vector3 initialSize;
        private final Vector3 offset;
        private final List<Csg.Polygon> polys;
        private final long sig;
        private final List<Style> styles;
        private final Map<Integer, float[]> tris;

        public Result(List<Csg.Polygon> polys, Map<Integer, float[]> tris, List<Style> styles, long j, Vector3 initialSize, Vector3 offset) {
            Intrinsics.checkNotNullParameter(polys, "polys");
            Intrinsics.checkNotNullParameter(tris, "tris");
            Intrinsics.checkNotNullParameter(styles, "styles");
            Intrinsics.checkNotNullParameter(initialSize, "initialSize");
            Intrinsics.checkNotNullParameter(offset, "offset");
            this.polys = polys;
            this.tris = tris;
            this.styles = styles;
            this.sig = j;
            this.initialSize = initialSize;
            this.offset = offset;
        }

        public final Vector3 getInitialSize() {
            return this.initialSize;
        }

        public final Vector3 getOffset() {
            return this.offset;
        }

        public final List<Csg.Polygon> getPolys() {
            return this.polys;
        }

        public final long getSig() {
            return this.sig;
        }

        public final List<Style> getStyles() {
            return this.styles;
        }

        public final Map<Integer, float[]> getTris() {
            return this.tris;
        }
    }

    /* compiled from: SolidModeling.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/exampletest/mobilestudiotest/core/SolidModeling$Style;", "", TypedValues.Custom.S_COLOR, "Lcom/exampletest/mobilestudiotest/model/Color3;", "transparency", "", "<init>", "(Lcom/exampletest/mobilestudiotest/model/Color3;F)V", "getColor", "()Lcom/exampletest/mobilestudiotest/model/Color3;", "getTransparency", "()F", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Style {
        private final Color3 color;
        private final float transparency;

        public Style(Color3 color, float f) {
            Intrinsics.checkNotNullParameter(color, "color");
            this.color = color;
            this.transparency = f;
        }

        public final Color3 getColor() {
            return this.color;
        }

        public final float getTransparency() {
            return this.transparency;
        }
    }

    private SolidModeling() {
    }

    private final Result compute(Instance op, List<? extends Instance> srcs, long sig) {
        ArrayList arrayList;
        List<Csg.Polygon> list;
        Pair<CFrame, Vector3> reference = reference(srcs);
        if (reference == null) {
            throw new IllegalStateException("no parts");
        }
        CFrame component1 = reference.component1();
        Vector3 component2 = reference.component2();
        ArrayList arrayList2 = new ArrayList();
        boolean areEqual = Intrinsics.areEqual(op.get("UsePartColor"), (Object) true);
        ArrayList arrayList3 = new ArrayList();
        for (Object obj : srcs) {
            if (!Intrinsics.areEqual(((Instance) obj).getClassName(), "NegateOperation")) {
                arrayList3.add(obj);
            }
        }
        ArrayList arrayList4 = arrayList3;
        ArrayList arrayList5 = new ArrayList();
        for (Object obj2 : srcs) {
            if (Intrinsics.areEqual(((Instance) obj2).getClassName(), "NegateOperation")) {
                arrayList5.add(obj2);
            }
        }
        ArrayList arrayList6 = arrayList5;
        List<Csg.Polygon> emptyList = arrayList4.isEmpty() ? CollectionsKt.emptyList() : compute$polysOf(arrayList2, areEqual, op, component1, (Instance) arrayList4.get(0));
        for (Instance instance : CollectionsKt.drop(arrayList4, 1)) {
            emptyList = Intrinsics.areEqual(op.getClassName(), "IntersectOperation") ? Csg.INSTANCE.intersect(emptyList, compute$polysOf(arrayList2, areEqual, op, component1, instance)) : Csg.INSTANCE.union(emptyList, compute$polysOf(arrayList2, areEqual, op, component1, instance));
        }
        Iterator it = arrayList6.iterator();
        while (it.hasNext()) {
            emptyList = Csg.INSTANCE.subtract(emptyList, compute$polysOf(arrayList2, areEqual, op, component1, (Instance) it.next()));
        }
        Vector3 vector3 = new Vector3(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
        Vector3 unaryMinus = vector3.unaryMinus();
        Iterator<Csg.Polygon> it2 = emptyList.iterator();
        while (it2.hasNext()) {
            for (Csg.Vertex vertex : it2.next().getVertices()) {
                vector3 = vector3.min(vertex.getPos());
                unaryMinus = unaryMinus.max(vertex.getPos());
            }
        }
        if (emptyList.isEmpty()) {
            vector3 = component2.unaryMinus().div(2.0f);
            unaryMinus = component2.div(2.0f);
        }
        Vector3 div = vector3.plus(unaryMinus).div(2.0f);
        if (div.getMagnitude() < 1.0E-5f) {
            arrayList = arrayList2;
            list = emptyList;
        } else {
            List<Csg.Polygon> list2 = emptyList;
            ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            for (Csg.Polygon polygon : list2) {
                List<Csg.Vertex> vertices = polygon.getVertices();
                ArrayList arrayList8 = arrayList6;
                Vector3 vector32 = component2;
                ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(vertices, 10));
                List<Csg.Vertex> list3 = vertices;
                for (Csg.Vertex vertex2 : list3) {
                    arrayList9.add(new Csg.Vertex(vertex2.getPos().minus(div), vertex2.getNormal()));
                    list3 = list3;
                    component1 = component1;
                }
                arrayList7.add(new Csg.Polygon(arrayList9, polygon.getShared(), new Csg.Plane(polygon.getPlane().getNormal(), polygon.getPlane().getW() - polygon.getPlane().getNormal().dot(div))));
                component2 = vector32;
                arrayList6 = arrayList8;
                arrayList2 = arrayList2;
                component1 = component1;
            }
            arrayList = arrayList2;
            list = arrayList7;
        }
        return new Result(list, Csg.INSTANCE.toTriangles(list), arrayList, sig, unaryMinus.minus(vector3).max(new Vector3(0.01f, 0.01f, 0.01f)), div);
    }

    private static final List<Csg.Polygon> compute$polysOf(ArrayList<Style> arrayList, boolean z, Instance instance, CFrame cFrame, Instance instance2) {
        int size = arrayList.size();
        PartData partData = PartData.INSTANCE;
        arrayList.add(new Style(z ? partData.color(instance) : partData.color(instance2), PartData.INSTANCE.transparency(instance2)));
        return Csg.INSTANCE.partPolygons(instance2, size, cFrame, new SolidModeling$$ExternalSyntheticLambda0());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final List compute$polysOf$lambda$4(Instance inner) {
        Intrinsics.checkNotNullParameter(inner, "inner");
        return INSTANCE.scaledPolys(inner);
    }

    private final void copyPartProps(Instance from, Instance to) {
        for (Map.Entry<String, Object> entry : from.getProps().entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (!Intrinsics.areEqual(key, "Name")) {
                to.getProps().put(key, value);
                Integer num = from.getPropTypes().get(key);
                if (num != null) {
                    to.getPropTypes().put(key, Integer.valueOf(num.intValue()));
                }
            }
        }
        to.getProps().put("Name", from.getName());
    }

    private final void notify(Studio studio) {
        studio.getMain().post(new SolidModeling$$ExternalSyntheticLambda1(studio));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void notify$lambda$19(Studio studio) {
        for (Studio.Listener listener : studio.getListeners()) {
            listener.onSelectionChanged();
            listener.onTreeChanged();
        }
    }

    private final Pair<CFrame, Vector3> reference(List<? extends Instance> srcs) {
        Pair<Vector3, Vector3> boundsOf = Geometry.INSTANCE.boundsOf(srcs);
        if (boundsOf == null) {
            return null;
        }
        Vector3 component1 = boundsOf.component1();
        Vector3 component2 = boundsOf.component2();
        return TuplesKt.to(CFrame.INSTANCE.at(component1.plus(component2).div(2.0f)), component2.minus(component1));
    }

    private static final float scaleOf$k$17(float f, float f2) {
        if (f2 > 1.0E-5f) {
            return f / f2;
        }
        return 1.0f;
    }

    private final List<Csg.Polygon> scaledPolys(Instance op) {
        Result result = result(op);
        if (result == null) {
            return storedPolys(op);
        }
        Vector3 scaleOf = scaleOf(op, result);
        if (Math.abs(scaleOf.getX() - 1.0f) < 1.0E-4f && Math.abs(scaleOf.getY() - 1.0f) < 1.0E-4f && Math.abs(scaleOf.getZ() - 1.0f) < 1.0E-4f) {
            return result.getPolys();
        }
        List<Csg.Polygon> polys = result.getPolys();
        ArrayList arrayList = new ArrayList();
        for (Csg.Polygon polygon : polys) {
            Result result2 = result;
            List<Csg.Vertex> vertices = polygon.getVertices();
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(vertices, 10));
            List<Csg.Vertex> list = vertices;
            for (Csg.Vertex vertex : list) {
                arrayList2.add(new Csg.Vertex(vertex.getPos().times(scaleOf), vertex.getNormal().div(scaleOf).getUnit()));
                vertices = vertices;
                list = list;
                polys = polys;
            }
            List<Csg.Polygon> list2 = polys;
            ArrayList arrayList3 = arrayList2;
            Vector3 vector3 = scaleOf;
            Csg.Plane from = Csg.Plane.INSTANCE.from(((Csg.Vertex) arrayList3.get(0)).getPos(), ((Csg.Vertex) arrayList3.get(1)).getPos(), ((Csg.Vertex) arrayList3.get(2)).getPos());
            Csg.Polygon polygon2 = from != null ? new Csg.Polygon(arrayList3, polygon.getShared(), from) : null;
            if (polygon2 != null) {
                arrayList.add(polygon2);
            }
            scaleOf = vector3;
            result = result2;
            polys = list2;
        }
        return arrayList;
    }

    private final long signature(Instance op, List<? extends Instance> srcs) {
        long hashCode = (op.getClassName().hashCode() * 31) + Boolean.hashCode(Intrinsics.areEqual(op.get("UsePartColor"), (Object) true));
        for (Instance instance : srcs) {
            hashCode = (((((((((hashCode * 31) + instance.getClassName().hashCode()) * 31) + PartData.INSTANCE.cframe(instance).hashCode()) * 31) + PartData.INSTANCE.size(instance).hashCode()) * 31) + PartData.INSTANCE.shape(instance)) * 31) + PartData.INSTANCE.color(instance).hashCode();
            if (isOperation(instance)) {
                long j = hashCode * 31;
                Result result = result(instance);
                hashCode = j + (result != null ? result.getSig() : 0L);
            }
        }
        return Intrinsics.areEqual(op.get("UsePartColor"), (Object) true) ? (31 * hashCode) + PartData.INSTANCE.color(op).hashCode() : hashCode;
    }

    private final List<Csg.Polygon> storedPolys(Instance op) {
        UnionMeshes.Data data;
        Vector3 vector3;
        Csg.Polygon polygon;
        if (!UnionMeshes.INSTANCE.isStored(op) || (data = UnionMeshes.INSTANCE.get(op)) == null) {
            return null;
        }
        Vector3 size = PartData.INSTANCE.size(op);
        Vector3 vector32 = new Vector3(storedPolys$k(size.getX(), data.getSize().getX()), storedPolys$k(size.getY(), data.getSize().getY()), storedPolys$k(size.getZ(), data.getSize().getZ()));
        List<float[]> triangles = data.getTriangles();
        ArrayList arrayList = new ArrayList();
        for (float[] fArr : triangles) {
            UnionMeshes.Data data2 = data;
            IntRange intRange = new IntRange(0, 2);
            Vector3 vector33 = size;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
            IntRange intRange2 = intRange;
            Iterator<Integer> it = intRange2.iterator();
            while (it.hasNext()) {
                int nextInt = ((IntIterator) it).nextInt();
                arrayList2.add(new Vector3(fArr[nextInt * 3], fArr[(nextInt * 3) + 1], fArr[(nextInt * 3) + 2]).minus(data2.getCenter()));
                triangles = triangles;
                intRange = intRange;
                intRange2 = intRange2;
            }
            List<float[]> list = triangles;
            ArrayList arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                arrayList4.add(((Vector3) it2.next()).times(vector32));
                arrayList3 = arrayList3;
            }
            ArrayList arrayList5 = arrayList4;
            Csg.Plane from = Csg.Plane.INSTANCE.from((Vector3) arrayList5.get(0), (Vector3) arrayList5.get(1), (Vector3) arrayList5.get(2));
            if (from != null) {
                ArrayList arrayList6 = arrayList5;
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList6, 10));
                ArrayList arrayList8 = arrayList6;
                Iterator it3 = arrayList8.iterator();
                while (it3.hasNext()) {
                    arrayList7.add(new Csg.Vertex((Vector3) it3.next(), from.getNormal()));
                    arrayList8 = arrayList8;
                    arrayList6 = arrayList6;
                    vector32 = vector32;
                }
                vector3 = vector32;
                polygon = new Csg.Polygon(arrayList7, 0, from);
            } else {
                vector3 = vector32;
                polygon = null;
            }
            if (polygon != null) {
                arrayList.add(polygon);
            }
            data = data2;
            size = vector33;
            vector32 = vector3;
            triangles = list;
        }
        return arrayList;
    }

    private static final float storedPolys$k(float f, float f2) {
        if (f2 > 1.0E-4f) {
            return f / f2;
        }
        return 1.0f;
    }

    public final boolean canSeparate(Instance op) {
        Intrinsics.checkNotNullParameter(op, "op");
        return isOperation(op) && !sources(op).isEmpty();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00d4 A[Catch: all -> 0x03fd, TryCatch #1 {all -> 0x03fd, blocks: (B:5:0x000e, B:6:0x0020, B:8:0x0028, B:79:0x0036, B:81:0x003e, B:86:0x0066, B:89:0x0048, B:90:0x004c, B:92:0x0052, B:11:0x006a, B:18:0x0070, B:20:0x0078, B:23:0x0085, B:24:0x0099, B:26:0x009f, B:28:0x00b5, B:30:0x00bb, B:36:0x00d4, B:45:0x00db, B:46:0x00e9, B:48:0x00ef, B:50:0x00ff, B:54:0x0137, B:58:0x010c, B:59:0x0110, B:61:0x0116, B:104:0x0147, B:106:0x0150, B:108:0x0158, B:114:0x018d, B:119:0x0163, B:120:0x0167, B:122:0x016d, B:129:0x01a8, B:131:0x01b0, B:138:0x01e2, B:143:0x01f1, B:144:0x0205, B:146:0x020b, B:150:0x021f, B:152:0x0228, B:153:0x0230, B:156:0x0239, B:159:0x0245, B:161:0x027a, B:164:0x02be, B:167:0x02dd, B:168:0x0346, B:170:0x034c, B:172:0x035a, B:175:0x0365, B:176:0x0374, B:178:0x037a, B:180:0x0384, B:182:0x038c, B:183:0x03a5, B:192:0x0289, B:193:0x028d, B:195:0x0293, B:213:0x01bb, B:214:0x01bf, B:216:0x01c5), top: B:4:0x000e }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String combine(com.exampletest.mobilestudiotest.core.Studio r23, boolean r24) {
        /*
            Method dump skipped, instructions count: 1026
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.core.SolidModeling.combine(com.exampletest.mobilestudiotest.core.Studio, boolean):java.lang.String");
    }

    public final boolean isOperation(Instance i) {
        Intrinsics.checkNotNullParameter(i, "i");
        return i.isA("PartOperation") && !Intrinsics.areEqual(i.getClassName(), "NegateOperation");
    }

    public final int negate(Studio studio) {
        boolean z;
        Instance create;
        Intrinsics.checkNotNullParameter(studio, "studio");
        ArrayList arrayList = new ArrayList();
        int i = 0;
        synchronized (studio.getLock()) {
            ArrayList<Instance> selection = studio.getSelection();
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = selection.iterator();
            while (true) {
                z = false;
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Instance instance = (Instance) next;
                if ((!instance.isA("BasePart") || INSTANCE.isOperation(instance) || instance.getParent() == null) ? false : true) {
                    arrayList2.add(next);
                }
            }
            ArrayList<Instance> arrayList3 = arrayList2;
            if (arrayList3.isEmpty()) {
                return 0;
            }
            studio.getUndo().begin("Negate");
            for (Instance instance2 : arrayList3) {
                Instance parent = instance2.getParent();
                if (parent != null) {
                    int i2 = 0;
                    Iterator<Instance> it2 = parent.getChildren().iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            i2 = -1;
                        } else if (!(it2.next() == instance2 ? true : z)) {
                            i2++;
                        }
                    }
                    if (Intrinsics.areEqual(instance2.getClassName(), "NegateOperation")) {
                        Object obj = instance2.getAttributes().get("__cls");
                        String str = obj instanceof String ? (String) obj : null;
                        if (str == null) {
                            switch (PartData.INSTANCE.shape(instance2)) {
                                case 3:
                                    str = "WedgePart";
                                    break;
                                case 4:
                                    str = "CornerWedgePart";
                                    break;
                                default:
                                    str = "Part";
                                    break;
                            }
                        }
                        create = InstanceFactory.INSTANCE.create(str);
                        INSTANCE.copyPartProps(instance2, create);
                        if (!Intrinsics.areEqual(str, "Part")) {
                            create.getProps().remove("shape");
                        }
                    } else {
                        create = InstanceFactory.INSTANCE.create("NegateOperation");
                        INSTANCE.copyPartProps(instance2, create);
                        create.getAttributes().put("__cls", instance2.getClassName());
                        create.getProps().put("shape", new EnumValue(PartData.INSTANCE.shape(instance2)));
                        create.getPropTypes().put("shape", 18);
                    }
                    Iterator it3 = CollectionsKt.toList(instance2.getChildren()).iterator();
                    while (it3.hasNext()) {
                        studio.reparent((Instance) it3.next(), create);
                    }
                    studio.reparent(instance2, null);
                    studio.reparent(create, parent);
                    parent.getChildren().remove(create);
                    parent.getChildren().add(RangesKt.coerceIn(i2, 0, parent.getChildren().size()), create);
                    arrayList.add(create);
                    i++;
                    z = false;
                }
            }
            studio.getUndo().commit();
            studio.getSelection().clear();
            studio.getSelection().addAll(arrayList);
            notify(studio);
            return i;
        }
    }

    public final Result result(Instance op) {
        Intrinsics.checkNotNullParameter(op, "op");
        if (!isOperation(op)) {
            return null;
        }
        List<Instance> sources = sources(op);
        if (sources.isEmpty()) {
            return null;
        }
        long signature = signature(op, sources);
        Result result = cache.get(op);
        if (result != null && result.getSig() == signature) {
            return result;
        }
        Long l = failed.get(op);
        if (l != null && l.longValue() == signature) {
            return null;
        }
        try {
            Result compute = compute(op, sources, signature);
            Map<Instance, Result> cache2 = cache;
            Intrinsics.checkNotNullExpressionValue(cache2, "cache");
            cache2.put(op, compute);
            return compute;
        } catch (Exception e) {
            Map<Instance, Long> failed2 = failed;
            Intrinsics.checkNotNullExpressionValue(failed2, "failed");
            failed2.put(op, Long.valueOf(signature));
            OutputLog outputLog = OutputLog.INSTANCE;
            String name = op.getName();
            String message = e.getMessage();
            outputLog.warn("Couldn't build " + name + ": " + (message != null ? message : e));
            return null;
        }
    }

    public final Vector3 scaleOf(Instance op, Result r) {
        Intrinsics.checkNotNullParameter(op, "op");
        Intrinsics.checkNotNullParameter(r, "r");
        Vector3 size = PartData.INSTANCE.size(op);
        return new Vector3(scaleOf$k$17(size.getX(), r.getInitialSize().getX()), scaleOf$k$17(size.getY(), r.getInitialSize().getY()), scaleOf$k$17(size.getZ(), r.getInitialSize().getZ()));
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0028 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String separate(com.exampletest.mobilestudiotest.core.Studio r34) {
        /*
            Method dump skipped, instructions count: 849
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.core.SolidModeling.separate(com.exampletest.mobilestudiotest.core.Studio):java.lang.String");
    }

    public final List<Instance> sources(Instance op) {
        Intrinsics.checkNotNullParameter(op, "op");
        ArrayList<Instance> children = op.getChildren();
        ArrayList arrayList = new ArrayList();
        for (Object obj : children) {
            if (((Instance) obj).isA("BasePart")) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}
