package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import androidx.collection.MutableFloatList;
import androidx.graphics.shapes.Feature;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: RoundedPolygon.kt */
@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a@\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007\u001aL\u0010\u0000\u001a\u00020\u00012\b\b\u0001\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\n2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\bH\u0007\u001a\u0019\u0010\u000f\u001a\u00060\u0010j\u0002`\u00112\u0006\u0010\u0003\u001a\u00020\u0004H\u0002¢\u0006\u0002\u0010\u0012\u001a(\u0010\u0013\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002¨\u0006\u0014"}, d2 = {"RoundedPolygon", "Landroidx/graphics/shapes/RoundedPolygon;", "source", "vertices", "", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "perVertexRounding", "", "centerX", "", "centerY", "numVertices", "", "radius", "calculateCenter", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "([F)J", "verticesFromNumVerts", "graphics-shapes_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RoundedPolygonKt {
    public static final RoundedPolygon RoundedPolygon(int i) {
        return RoundedPolygon$default(i, 0.0f, 0.0f, 0.0f, null, null, 62, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f) {
        return RoundedPolygon$default(i, f, 0.0f, 0.0f, null, null, 60, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2) {
        return RoundedPolygon$default(i, f, f2, 0.0f, null, null, 56, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2, float f3) {
        return RoundedPolygon$default(i, f, f2, f3, null, null, 48, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2, float f3, CornerRounding rounding) {
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(i, f, f2, f3, rounding, null, 32, null);
    }

    public static final RoundedPolygon RoundedPolygon(int i, float f, float f2, float f3, CornerRounding rounding, List<CornerRounding> list) {
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon(verticesFromNumVerts(i, f, f2, f3), rounding, list, f2, f3);
    }

    public static final RoundedPolygon RoundedPolygon(RoundedPolygon source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return new RoundedPolygon(source.getFeatures$graphics_shapes_release(), source.getCenterX(), source.getCenterY());
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        return RoundedPolygon$default(vertices, null, null, 0.0f, 0.0f, 30, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, null, 0.0f, 0.0f, 28, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, 0.0f, 0.0f, 24, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] vertices, CornerRounding rounding, List<CornerRounding> list, float f) {
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        return RoundedPolygon$default(vertices, rounding, list, f, 0.0f, 16, null);
    }

    public static final RoundedPolygon RoundedPolygon(float[] fArr, CornerRounding rounding, List<CornerRounding> list, float f, float f2) {
        long calculateCenter;
        CornerRounding cornerRounding;
        float[] vertices = fArr;
        Intrinsics.checkNotNullParameter(vertices, "vertices");
        Intrinsics.checkNotNullParameter(rounding, "rounding");
        if (vertices.length < 6) {
            throw new IllegalArgumentException("Polygons must have at least 3 vertices");
        }
        int i = 2;
        int i2 = 1;
        if (vertices.length % 2 == 1) {
            throw new IllegalArgumentException("The vertices array should have even size");
        }
        if (list != null && list.size() * 2 != vertices.length) {
            throw new IllegalArgumentException("perVertexRounding list should be either null or the same size as the number of vertices (vertices.size / 2)");
        }
        ArrayList arrayList = new ArrayList();
        int length = vertices.length / 2;
        ArrayList arrayList2 = new ArrayList();
        int i3 = 0;
        while (i3 < length) {
            if (list == null || (cornerRounding = list.get(i3)) == null) {
                cornerRounding = rounding;
            }
            CornerRounding cornerRounding2 = cornerRounding;
            int i4 = (((i3 + length) - i2) % length) * 2;
            int i5 = ((i3 + 1) % length) * 2;
            arrayList2.add(new RoundedCorner(FloatFloatPair.m12constructorimpl(vertices[i4], vertices[i4 + 1]), FloatFloatPair.m12constructorimpl(vertices[i3 * 2], vertices[(i3 * 2) + i2]), FloatFloatPair.m12constructorimpl(vertices[i5], vertices[i5 + 1]), cornerRounding2, null));
            i3++;
            i2 = i2;
        }
        int i6 = i2;
        IntRange until = RangesKt.until(0, length);
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            float expectedRoundCut = ((RoundedCorner) arrayList2.get(nextInt)).getExpectedRoundCut() + ((RoundedCorner) arrayList2.get((nextInt + 1) % length)).getExpectedRoundCut();
            int i7 = i;
            float expectedCut = ((RoundedCorner) arrayList2.get(nextInt)).getExpectedCut() + ((RoundedCorner) arrayList2.get((nextInt + 1) % length)).getExpectedCut();
            float distance = Utils.distance(vertices[nextInt * 2] - vertices[((nextInt + 1) % length) * 2], vertices[(nextInt * 2) + 1] - vertices[(((nextInt + 1) % length) * 2) + 1]);
            arrayList3.add(expectedRoundCut > distance ? TuplesKt.to(Float.valueOf(distance / expectedRoundCut), Float.valueOf(0.0f)) : expectedCut > distance ? TuplesKt.to(Float.valueOf(1.0f), Float.valueOf((distance - expectedRoundCut) / (expectedCut - expectedRoundCut))) : TuplesKt.to(Float.valueOf(1.0f), Float.valueOf(1.0f)));
            vertices = fArr;
            i = i7;
        }
        int i8 = i;
        ArrayList arrayList4 = arrayList3;
        int i9 = 0;
        while (i9 < length) {
            int i10 = i8;
            MutableFloatList mutableFloatList = new MutableFloatList(i10);
            for (int i11 = 0; i11 < i10; i11++) {
                Pair pair = (Pair) arrayList4.get((((i9 + length) - 1) + i11) % length);
                mutableFloatList.add((((RoundedCorner) arrayList2.get(i9)).getExpectedRoundCut() * ((Number) pair.component1()).floatValue()) + ((((RoundedCorner) arrayList2.get(i9)).getExpectedCut() - ((RoundedCorner) arrayList2.get(i9)).getExpectedRoundCut()) * ((Number) pair.component2()).floatValue()));
            }
            arrayList.add(((RoundedCorner) arrayList2.get(i9)).getCubics(mutableFloatList.get(0), mutableFloatList.get(i6)));
            i9++;
            i8 = i10;
            i6 = 1;
        }
        ArrayList arrayList5 = new ArrayList();
        int i12 = 0;
        while (i12 < length) {
            int i13 = ((i12 + length) - 1) % length;
            int i14 = (i12 + 1) % length;
            long m12constructorimpl = FloatFloatPair.m12constructorimpl(fArr[i12 * 2], fArr[(i12 * 2) + 1]);
            int i15 = length;
            arrayList5.add(new Feature.Corner((List) arrayList.get(i12), m12constructorimpl, ((RoundedCorner) arrayList2.get(i12)).getCenter(), PointKt.m145clockwiseybeJwSQ(PointKt.m157minusybeJwSQ(m12constructorimpl, FloatFloatPair.m12constructorimpl(fArr[i13 * 2], fArr[(i13 * 2) + 1])), PointKt.m157minusybeJwSQ(FloatFloatPair.m12constructorimpl(fArr[i14 * 2], fArr[(i14 * 2) + 1]), m12constructorimpl)), null));
            arrayList5.add(new Feature.Edge(CollectionsKt.listOf(Cubic.INSTANCE.straightLine(((Cubic) CollectionsKt.last((List) arrayList.get(i12))).getAnchor1X(), ((Cubic) CollectionsKt.last((List) arrayList.get(i12))).getAnchor1Y(), ((Cubic) CollectionsKt.first((List) arrayList.get((i12 + 1) % i15))).getAnchor0X(), ((Cubic) CollectionsKt.first((List) arrayList.get((i12 + 1) % i15))).getAnchor0Y()))));
            i12++;
            arrayList4 = arrayList4;
            length = i15;
        }
        if (!(f == Float.MIN_VALUE)) {
            if (!(f2 == Float.MIN_VALUE)) {
                calculateCenter = FloatFloatPair.m12constructorimpl(f, f2);
                return new RoundedPolygon(arrayList5, Float.intBitsToFloat((int) (calculateCenter >> 32)), Float.intBitsToFloat((int) (calculateCenter & 4294967295L)));
            }
        }
        calculateCenter = calculateCenter(fArr);
        return new RoundedPolygon(arrayList5, Float.intBitsToFloat((int) (calculateCenter >> 32)), Float.intBitsToFloat((int) (calculateCenter & 4294967295L)));
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(int i, float f, float f2, float f3, CornerRounding cornerRounding, List list, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            f = 1.0f;
        }
        if ((i2 & 4) != 0) {
            f2 = 0.0f;
        }
        if ((i2 & 8) != 0) {
            f3 = 0.0f;
        }
        if ((i2 & 16) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        return RoundedPolygon(i, f, f2, f3, cornerRounding, (i2 & 32) != 0 ? null : list);
    }

    public static /* synthetic */ RoundedPolygon RoundedPolygon$default(float[] fArr, CornerRounding cornerRounding, List list, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            cornerRounding = CornerRounding.Unrounded;
        }
        if ((i & 4) != 0) {
            list = null;
        }
        if ((i & 8) != 0) {
            f = Float.MIN_VALUE;
        }
        if ((i & 16) != 0) {
            f2 = Float.MIN_VALUE;
        }
        return RoundedPolygon(fArr, cornerRounding, (List<CornerRounding>) list, f, f2);
    }

    private static final long calculateCenter(float[] fArr) {
        float f = 0.0f;
        float f2 = 0.0f;
        int i = 0;
        while (i < fArr.length) {
            int i2 = i + 1;
            f += fArr[i];
            i = i2 + 1;
            f2 += fArr[i2];
        }
        return FloatFloatPair.m12constructorimpl((f / fArr.length) / 2.0f, (f2 / fArr.length) / 2.0f);
    }

    private static final float[] verticesFromNumVerts(int i, float f, float f2, float f3) {
        float[] fArr = new float[i * 2];
        int i2 = 0;
        int i3 = 0;
        while (i3 < i) {
            float f4 = f;
            long m158plusybeJwSQ = PointKt.m158plusybeJwSQ(Utils.m174radialToCartesianL6JJ3z0$default(f4, (Utils.getFloatPi() / i) * 2.0f * i3, 0L, 4, null), FloatFloatPair.m12constructorimpl(f2, f3));
            int i4 = i2 + 1;
            fArr[i2] = PointKt.m154getXDnnuFBc(m158plusybeJwSQ);
            i2 = i4 + 1;
            fArr[i4] = PointKt.m155getYDnnuFBc(m158plusybeJwSQ);
            i3++;
            f = f4;
        }
        return fArr;
    }
}
