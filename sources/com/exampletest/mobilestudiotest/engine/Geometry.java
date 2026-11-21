package com.exampletest.mobilestudiotest.engine;

import androidx.core.text.util.LocalePreferences;
import com.exampletest.mobilestudiotest.engine.CollisionMeshes;
import com.exampletest.mobilestudiotest.model.CFrame;
import com.exampletest.mobilestudiotest.model.EnumValue;
import com.exampletest.mobilestudiotest.model.Instance;
import com.exampletest.mobilestudiotest.model.PartData;
import com.exampletest.mobilestudiotest.model.Vector3;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: Geometry.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0013\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J*\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00050\b0\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002J,\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011JB\u0010\u0012\u001a\u0004\u0018\u00010\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u00072\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u00052\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00180\u0017J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tJ\"\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tJ\u001a\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\u001f\u001a\u00020\u0011J\"\u0010 \u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0007J4\u0010\"\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0005\u0018\u00010\b2\u0006\u0010\n\u001a\u00020#2\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011J\u001a\u0010&\u001a\u00020#2\u0006\u0010\u0010\u001a\u00020\u00112\n\b\u0002\u0010'\u001a\u0004\u0018\u00010\u001bJ\u0016\u0010(\u001a\u00020#2\u0006\u0010)\u001a\u00020\t2\u0006\u0010*\u001a\u00020\tJ\u0018\u0010+\u001a\u0004\u0018\u00010\t2\u0006\u0010,\u001a\u00020#2\u0006\u0010-\u001a\u00020#J0\u0010.\u001a\u00020\u00182\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u00101\u001a\u00020\t2\u0006\u00102\u001a\u00020\t2\b\b\u0002\u00103\u001a\u00020\u0005J\u000e\u00104\u001a\u00020\u00052\u0006\u00105\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/Geometry;", "", "<init>", "()V", "H", "", "planes", "", "Lkotlin/Pair;", "Lcom/exampletest/mobilestudiotest/model/Vector3;", "shape", "", "s", "rayPart", "o", "d", "part", "Lcom/exampletest/mobilestudiotest/model/Instance;", "raycast", "Lcom/exampletest/mobilestudiotest/engine/RayHit;", "parts", "maxDist", "filter", "Lkotlin/Function1;", "", "corners", "cf", "Lcom/exampletest/mobilestudiotest/model/CFrame;", "size", "worldAabb", "partAabb", "p", "boundsOf", "ROUND_AXES", "contact", "Lcom/exampletest/mobilestudiotest/engine/ConvexShape;", "lo", "hi", "shapeOf", "cfOverride", "aabbShape", "center", "half", LocalePreferences.FirstDayOfWeek.SATURDAY, "a", "b", "aabbOverlap", "a0", "a1", "b0", "b1", "pad", "maxOf3", "v", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class Geometry {
    private static final List<Vector3> ROUND_AXES;
    public static final Geometry INSTANCE = new Geometry();
    private static final float H = 0.5f;

    static {
        List listOf = CollectionsKt.listOf((Object[]) new Vector3[]{new Vector3(1.0f, 0.0f, 0.0f), new Vector3(0.0f, 1.0f, 0.0f), new Vector3(0.0f, 0.0f, 1.0f), new Vector3(1.0f, 1.0f, 0.0f), new Vector3(1.0f, -1.0f, 0.0f), new Vector3(1.0f, 0.0f, 1.0f), new Vector3(1.0f, 0.0f, -1.0f), new Vector3(0.0f, 1.0f, 1.0f), new Vector3(0.0f, 1.0f, -1.0f), new Vector3(1.0f, 1.0f, 1.0f), new Vector3(1.0f, 1.0f, -1.0f), new Vector3(1.0f, -1.0f, 1.0f), new Vector3(-1.0f, 1.0f, 1.0f)});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listOf, 10));
        Iterator it = listOf.iterator();
        while (it.hasNext()) {
            arrayList.add(((Vector3) it.next()).getUnit());
        }
        ROUND_AXES = arrayList;
    }

    private Geometry() {
    }

    public static /* synthetic */ boolean aabbOverlap$default(Geometry geometry, Vector3 vector3, Vector3 vector32, Vector3 vector33, Vector3 vector34, float f, int i, Object obj) {
        if ((i & 16) != 0) {
            f = 0.0f;
        }
        return geometry.aabbOverlap(vector3, vector32, vector33, vector34, f);
    }

    private final List<Pair<Vector3, Float>> planes(int shape, Vector3 s) {
        float x = s.getX() * H;
        float y = s.getY() * H;
        float z = s.getZ() * H;
        return shape == 3 ? CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Vector3.INSTANCE.getX(), Float.valueOf(x)), TuplesKt.to(Vector3.INSTANCE.getX().unaryMinus(), Float.valueOf(x)), TuplesKt.to(Vector3.INSTANCE.getY().unaryMinus(), Float.valueOf(y)), TuplesKt.to(Vector3.INSTANCE.getZ(), Float.valueOf(z)), TuplesKt.to(new Vector3(0.0f, s.getZ(), -s.getY()).getUnit(), Float.valueOf(0.0f))}) : CollectionsKt.listOf((Object[]) new Pair[]{TuplesKt.to(Vector3.INSTANCE.getX(), Float.valueOf(x)), TuplesKt.to(Vector3.INSTANCE.getX().unaryMinus(), Float.valueOf(x)), TuplesKt.to(Vector3.INSTANCE.getY(), Float.valueOf(y)), TuplesKt.to(Vector3.INSTANCE.getY().unaryMinus(), Float.valueOf(y)), TuplesKt.to(Vector3.INSTANCE.getZ(), Float.valueOf(z)), TuplesKt.to(Vector3.INSTANCE.getZ().unaryMinus(), Float.valueOf(z))});
    }

    public static /* synthetic */ ConvexShape shapeOf$default(Geometry geometry, Instance instance, CFrame cFrame, int i, Object obj) {
        if ((i & 2) != 0) {
            cFrame = null;
        }
        return geometry.shapeOf(instance, cFrame);
    }

    public final boolean aabbOverlap(Vector3 a0, Vector3 a1, Vector3 b0, Vector3 b1, float pad) {
        Intrinsics.checkNotNullParameter(a0, "a0");
        Intrinsics.checkNotNullParameter(a1, "a1");
        Intrinsics.checkNotNullParameter(b0, "b0");
        Intrinsics.checkNotNullParameter(b1, "b1");
        return a0.getX() <= b1.getX() + pad && a1.getX() >= b0.getX() - pad && a0.getY() <= b1.getY() + pad && a1.getY() >= b0.getY() - pad && a0.getZ() <= b1.getZ() + pad && a1.getZ() >= b0.getZ() - pad;
    }

    public final ConvexShape aabbShape(Vector3 center, Vector3 half) {
        Intrinsics.checkNotNullParameter(center, "center");
        Intrinsics.checkNotNullParameter(half, "half");
        ArrayList arrayList = new ArrayList(8);
        for (int i = 0; i < 8; i++) {
            int i2 = i;
            arrayList.add(center.plus(new Vector3((i2 & 1) != 0 ? half.getX() : -half.getX(), (i2 & 2) != 0 ? half.getY() : -half.getY(), (i2 & 4) != 0 ? half.getZ() : -half.getZ())));
        }
        List listOf = CollectionsKt.listOf((Object[]) new Vector3[]{Vector3.INSTANCE.getX(), Vector3.INSTANCE.getY(), Vector3.INSTANCE.getZ()});
        return new ConvexShape(arrayList, listOf, listOf);
    }

    public final Pair<Vector3, Vector3> boundsOf(List<? extends Instance> parts) {
        Intrinsics.checkNotNullParameter(parts, "parts");
        if (parts.isEmpty()) {
            return null;
        }
        Vector3 vector3 = new Vector3(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);
        Vector3 unaryMinus = vector3.unaryMinus();
        Iterator<? extends Instance> it = parts.iterator();
        while (it.hasNext()) {
            Pair<Vector3, Vector3> partAabb = partAabb(it.next());
            Vector3 component1 = partAabb.component1();
            Vector3 component2 = partAabb.component2();
            vector3 = vector3.min(component1);
            unaryMinus = unaryMinus.max(component2);
        }
        return TuplesKt.to(vector3, unaryMinus);
    }

    public final Pair<Vector3, Float> contact(ConvexShape shape, Vector3 lo, Vector3 hi, Instance part) {
        CollisionMeshes.Mesh forPart$default;
        Intrinsics.checkNotNullParameter(shape, "shape");
        Intrinsics.checkNotNullParameter(lo, "lo");
        Intrinsics.checkNotNullParameter(hi, "hi");
        Intrinsics.checkNotNullParameter(part, "part");
        if (CollisionMeshes.INSTANCE.hasGeometry(part) && (forPart$default = CollisionMeshes.forPart$default(CollisionMeshes.INSTANCE, part, false, 2, null)) != null) {
            return CollisionMeshes.INSTANCE.push(forPart$default, shape, lo, hi);
        }
        Vector3 sat = sat(shape, shapeOf$default(this, part, null, 2, null));
        if (sat == null) {
            return null;
        }
        return TuplesKt.to(sat, Float.valueOf(partAabb(part).getSecond().getY()));
    }

    public final List<Vector3> corners(CFrame cf, Vector3 size) {
        Intrinsics.checkNotNullParameter(cf, "cf");
        Intrinsics.checkNotNullParameter(size, "size");
        Vector3 times = size.times(H);
        ArrayList arrayList = new ArrayList(8);
        for (int i = 0; i < 8; i++) {
            int i2 = i;
            arrayList.add(cf.times(new Vector3((i2 & 1) != 0 ? times.getX() : -times.getX(), (i2 & 2) != 0 ? times.getY() : -times.getY(), (i2 & 4) != 0 ? times.getZ() : -times.getZ())));
        }
        return arrayList;
    }

    public final float maxOf3(Vector3 v) {
        Intrinsics.checkNotNullParameter(v, "v");
        return Math.max(v.getX(), Math.max(v.getY(), v.getZ()));
    }

    public final Pair<Vector3, Vector3> partAabb(Instance p) {
        Intrinsics.checkNotNullParameter(p, "p");
        return worldAabb(PartData.INSTANCE.cframe(p), PartData.INSTANCE.size(p));
    }

    public final Pair<Float, Vector3> rayPart(Vector3 o, Vector3 d, Instance part) {
        Pair<Float, Vector3> pair;
        CollisionMeshes.Mesh forPart$default;
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(d, "d");
        Intrinsics.checkNotNullParameter(part, "part");
        if (CollisionMeshes.INSTANCE.hasGeometry(part) && (forPart$default = CollisionMeshes.forPart$default(CollisionMeshes.INSTANCE, part, false, 2, null)) != null) {
            return CollisionMeshes.INSTANCE.ray(forPart$default, o, d, 1000000.0f);
        }
        CFrame cframe = PartData.INSTANCE.cframe(part);
        Vector3 size = PartData.INSTANCE.size(part);
        int shape = PartData.INSTANCE.shape(part);
        Vector3 pointToObject = cframe.pointToObject(o);
        Vector3 vectorToObject = cframe.vectorToObject(d);
        if (shape == 0) {
            float min = Math.min(size.getX(), Math.min(size.getY(), size.getZ())) * H;
            float dot = pointToObject.dot(vectorToObject);
            float dot2 = (dot * dot) - (pointToObject.dot(pointToObject) - (min * min));
            if (dot2 < 0.0f) {
                return null;
            }
            float sqrt = (float) Math.sqrt(dot2);
            float f = (-dot) - sqrt;
            if (f < 0.0f) {
                pair = null;
                f = (-dot) + sqrt;
            } else {
                pair = null;
            }
            return f < 0.0f ? pair : TuplesKt.to(Float.valueOf(f), cframe.vectorToWorld(pointToObject.plus(vectorToObject.times(f)).getUnit()));
        }
        float f2 = -3.4028235E38f;
        float f3 = Float.MAX_VALUE;
        Vector3 y = Vector3.INSTANCE.getY();
        for (Pair<Vector3, Float> pair2 : planes(shape, size)) {
            Vector3 component1 = pair2.component1();
            float floatValue = pair2.component2().floatValue();
            float dot3 = component1.dot(vectorToObject);
            float dot4 = floatValue - component1.dot(pointToObject);
            if (Math.abs(dot3) >= 1.0E-8f) {
                float f4 = dot4 / dot3;
                if (dot3 < 0.0f) {
                    if (f4 > f2) {
                        f2 = f4;
                        y = component1;
                    }
                } else if (f4 < f3) {
                    f3 = f4;
                }
                if (f2 > f3) {
                    return null;
                }
            } else if (dot4 < 0.0f) {
                return null;
            }
        }
        if (f3 < 0.0f) {
            return null;
        }
        return TuplesKt.to(Float.valueOf(f2 >= 0.0f ? f2 : 0.0f), cframe.vectorToWorld(y));
    }

    public final RayHit raycast(List<? extends Instance> parts, Vector3 o, Vector3 d, float maxDist, Function1<? super Instance, Boolean> filter) {
        Pair<Float, Vector3> rayPart;
        Intrinsics.checkNotNullParameter(parts, "parts");
        Intrinsics.checkNotNullParameter(o, "o");
        Intrinsics.checkNotNullParameter(d, "d");
        Intrinsics.checkNotNullParameter(filter, "filter");
        RayHit rayHit = null;
        for (Instance instance : parts) {
            if (filter.invoke(instance).booleanValue() && (rayPart = rayPart(o, d, instance)) != null && rayPart.getFirst().floatValue() <= maxDist && (rayHit == null || rayPart.getFirst().floatValue() < rayHit.getT())) {
                rayHit = new RayHit(instance, rayPart.getFirst().floatValue(), o.plus(d.times(rayPart.getFirst().floatValue())), rayPart.getSecond());
            }
        }
        return rayHit;
    }

    public final Vector3 sat(ConvexShape a, ConvexShape b) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        ArrayList arrayList = new ArrayList(a.getNormals().size() + b.getNormals().size() + 16);
        arrayList.addAll(a.getNormals());
        arrayList.addAll(b.getNormals());
        for (Vector3 vector3 : a.getEdges()) {
            Iterator<Vector3> it = b.getEdges().iterator();
            while (it.hasNext()) {
                Vector3 cross = vector3.cross(it.next());
                if (cross.getMagnitude() > 1.0E-4f) {
                    arrayList.add(cross.getUnit());
                }
            }
        }
        float f = Float.MAX_VALUE;
        Vector3 y = Vector3.INSTANCE.getY();
        Iterator it2 = arrayList.iterator();
        Intrinsics.checkNotNullExpressionValue(it2, "iterator(...)");
        while (it2.hasNext()) {
            Object next = it2.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Vector3 vector32 = (Vector3) next;
            Pair<Float, Float> project = a.project(vector32);
            float floatValue = project.component1().floatValue();
            float floatValue2 = project.component2().floatValue();
            Pair<Float, Float> project2 = b.project(vector32);
            float min = Math.min(floatValue2 - project2.component1().floatValue(), project2.component2().floatValue() - floatValue);
            if (min <= 0.0f) {
                return null;
            }
            if (min < f) {
                f = min;
                y = vector32;
            }
        }
        if (a.getCenter().minus(b.getCenter()).dot(y) < 0.0f) {
            y = y.unaryMinus();
        }
        return y.times(f);
    }

    public final ConvexShape shapeOf(Instance part, CFrame cfOverride) {
        Vector3 vector3;
        char c;
        Intrinsics.checkNotNullParameter(part, "part");
        CFrame cframe = cfOverride == null ? PartData.INSTANCE.cframe(part) : cfOverride;
        Vector3 size = PartData.INSTANCE.size(part);
        Vector3 times = size.times(H);
        int i = 0;
        List listOf = CollectionsKt.listOf((Object[]) new Vector3[]{cframe.getRightVector(), cframe.getUpVector(), cframe.getBackVector()});
        Object obj = part.get("shape");
        if (obj == null) {
            obj = part.get("Shape");
        }
        EnumValue enumValue = obj instanceof EnumValue ? (EnumValue) obj : null;
        Integer valueOf = enumValue != null ? Integer.valueOf(enumValue.getValue()) : null;
        if (valueOf != null && valueOf.intValue() == 0) {
            Vector3 position = cframe.getPosition();
            float min = Math.min(size.getX(), Math.min(size.getY(), size.getZ())) * H;
            List<Vector3> list = ROUND_AXES;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(cframe.vectorToWorld((Vector3) it.next()));
            }
            return new SphereShape(position, min, arrayList);
        }
        if (valueOf == null) {
            vector3 = times;
            c = 1;
        } else {
            if (valueOf.intValue() == 2) {
                float min2 = Math.min(size.getY(), size.getZ()) * H;
                char c2 = '\f';
                IntRange until = RangesKt.until(0, 12);
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
                Iterator<Integer> it2 = until.iterator();
                while (it2.hasNext()) {
                    double nextInt = (((IntIterator) it2).nextInt() * 6.283185307179586d) / 12.0d;
                    arrayList2.add(new Vector3(0.0f, (float) (min2 * Math.cos(nextInt)), (float) (min2 * Math.sin(nextInt))));
                    i = i;
                    c2 = c2;
                    until = until;
                }
                int i2 = i;
                ArrayList arrayList3 = arrayList2;
                ArrayList<Vector3> arrayList4 = arrayList3;
                ArrayList arrayList5 = new ArrayList();
                for (Vector3 vector32 : arrayList4) {
                    Vector3 vector33 = times;
                    Vector3[] vector3Arr = new Vector3[2];
                    vector3Arr[i2] = cframe.times(new Vector3(-vector33.getX(), vector32.getY(), vector32.getZ()));
                    vector3Arr[1] = cframe.times(new Vector3(vector33.getX(), vector32.getY(), vector32.getZ()));
                    CollectionsKt.addAll(arrayList5, CollectionsKt.listOf((Object[]) vector3Arr));
                    times = vector33;
                    min2 = min2;
                    arrayList4 = arrayList4;
                }
                ArrayList arrayList6 = arrayList5;
                IntRange until2 = RangesKt.until(i2, 6);
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(until2, 10));
                IntRange intRange = until2;
                boolean z = false;
                for (Iterator<Integer> it3 = intRange.iterator(); it3.hasNext(); it3 = it3) {
                    double nextInt2 = ((((IntIterator) it3).nextInt() + 0.5d) * 6.283185307179586d) / 12.0d;
                    arrayList7.add(cframe.vectorToWorld(new Vector3(0.0f, (float) Math.cos(nextInt2), (float) Math.sin(nextInt2))));
                    intRange = intRange;
                    z = z;
                }
                ArrayList arrayList8 = arrayList7;
                IntRange until3 = RangesKt.until(0, 6);
                ArrayList arrayList9 = new ArrayList(CollectionsKt.collectionSizeOrDefault(until3, 10));
                Iterator<Integer> it4 = until3.iterator();
                while (it4.hasNext()) {
                    int nextInt3 = ((IntIterator) it4).nextInt();
                    arrayList9.add(cframe.vectorToWorld(((Vector3) arrayList3.get((nextInt3 + 1) % 12)).minus((Vector3) arrayList3.get(nextInt3))).getUnit());
                    until3 = until3;
                    arrayList3 = arrayList3;
                }
                return new ConvexShape(arrayList6, CollectionsKt.plus((Collection) CollectionsKt.listOf(cframe.getRightVector()), (Iterable) arrayList8), CollectionsKt.plus((Collection) CollectionsKt.listOf(cframe.getRightVector()), (Iterable) arrayList9));
            }
            vector3 = times;
            c = 1;
        }
        if (PartData.INSTANCE.shape(part) != 3) {
            return new ConvexShape(corners(cframe, size), listOf, listOf);
        }
        Vector3[] vector3Arr2 = new Vector3[6];
        vector3Arr2[0] = new Vector3(-vector3.getX(), -vector3.getY(), -vector3.getZ());
        vector3Arr2[c] = new Vector3(vector3.getX(), -vector3.getY(), -vector3.getZ());
        vector3Arr2[2] = new Vector3(-vector3.getX(), -vector3.getY(), vector3.getZ());
        vector3Arr2[3] = new Vector3(vector3.getX(), -vector3.getY(), vector3.getZ());
        vector3Arr2[4] = new Vector3(-vector3.getX(), vector3.getY(), vector3.getZ());
        vector3Arr2[5] = new Vector3(vector3.getX(), vector3.getY(), vector3.getZ());
        List listOf2 = CollectionsKt.listOf((Object[]) vector3Arr2);
        Vector3 vectorToWorld = cframe.vectorToWorld(new Vector3(0.0f, size.getZ(), -size.getY()).getUnit());
        Vector3 vectorToWorld2 = cframe.vectorToWorld(new Vector3(0.0f, size.getY(), size.getZ()).getUnit());
        List list2 = listOf2;
        ArrayList arrayList10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator it5 = list2.iterator();
        while (it5.hasNext()) {
            arrayList10.add(cframe.times((Vector3) it5.next()));
        }
        return new ConvexShape(arrayList10, CollectionsKt.plus((Collection<? extends Vector3>) listOf, vectorToWorld), CollectionsKt.plus((Collection<? extends Vector3>) listOf, vectorToWorld2));
    }

    public final Pair<Vector3, Vector3> worldAabb(CFrame cf, Vector3 size) {
        Intrinsics.checkNotNullParameter(cf, "cf");
        Intrinsics.checkNotNullParameter(size, "size");
        Vector3 times = size.times(H);
        Vector3 vector3 = new Vector3((Math.abs(cf.getR00()) * times.getX()) + (Math.abs(cf.getR01()) * times.getY()) + (Math.abs(cf.getR02()) * times.getZ()), (Math.abs(cf.getR10()) * times.getX()) + (Math.abs(cf.getR11()) * times.getY()) + (Math.abs(cf.getR12()) * times.getZ()), (Math.abs(cf.getR20()) * times.getX()) + (Math.abs(cf.getR21()) * times.getY()) + (Math.abs(cf.getR22()) * times.getZ()));
        Vector3 position = cf.getPosition();
        return TuplesKt.to(position.minus(vector3), position.plus(vector3));
    }
}
