package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Cubic.kt */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0016\u0018\u0000 ?2\u00020\u0001:\u0001?B7\b\u0010\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0007\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\bB\u0011\b\u0000\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ!\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\n2\b\b\u0002\u0010#\u001a\u00020$H\u0000¢\u0006\u0002\b%J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rH\u0086\u0002J\u0011\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0086\u0002J\u0013\u0010)\u001a\u00020$2\b\u0010*\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010+\u001a\u00020(H\u0016J\u0011\u0010,\u001a\u00020\u00002\u0006\u0010-\u001a\u00020\u0000H\u0086\u0002J!\u0010.\u001a\u00060\u0003j\u0002`\u00042\u0006\u0010/\u001a\u00020\rH\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b0\u00101J\u0006\u00102\u001a\u00020\u0000J\u001a\u00103\u001a\u000e\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\u0000042\u0006\u0010/\u001a\u00020\rJ\u0011\u00105\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\rH\u0086\u0002J\u0011\u00105\u001a\u00020\u00002\u0006\u0010'\u001a\u00020(H\u0086\u0002J\b\u00106\u001a\u000207H\u0016J\u000e\u00108\u001a\u00020\u00002\u0006\u00109\u001a\u00020:J\u0010\u0010;\u001a\u00020$2\u0006\u0010<\u001a\u00020\rH\u0002J\r\u0010=\u001a\u00020$H\u0000¢\u0006\u0002\b>R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u0014\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\u0016\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\u0018\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u000fR\u0011\u0010\u001a\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u000fR\u0011\u0010\u001c\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u000fR\u0014\u0010\t\u001a\u00020\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u000b\n\u0002\b!\n\u0005\b¡\u001e0\u0001¨\u0006@"}, d2 = {"Landroidx/graphics/shapes/Cubic;", "", "anchor0", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "control0", "control1", "anchor1", "(JJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "points", "", "([F)V", "anchor0X", "", "getAnchor0X", "()F", "anchor0Y", "getAnchor0Y", "anchor1X", "getAnchor1X", "anchor1Y", "getAnchor1Y", "control0X", "getControl0X", "control0Y", "getControl0Y", "control1X", "getControl1X", "control1Y", "getControl1Y", "getPoints$graphics_shapes_release", "()[F", "calculateBounds", "", "bounds", "approximate", "", "calculateBounds$graphics_shapes_release", "div", "x", "", "equals", "other", "hashCode", "plus", "o", "pointOnCurve", "t", "pointOnCurve-OOQOV4g$graphics_shapes_release", "(F)J", "reverse", "split", "Lkotlin/Pair;", "times", "toString", "", "transformed", "f", "Landroidx/graphics/shapes/PointTransformer;", "zeroIsh", "value", "zeroLength", "zeroLength$graphics_shapes_release", "Companion", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public class Cubic {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final float[] points;

    /* compiled from: Cubic.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J8\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007J(\u0010\f\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0007¨\u0006\r"}, d2 = {"Landroidx/graphics/shapes/Cubic$Companion;", "", "()V", "circularArc", "Landroidx/graphics/shapes/Cubic;", "centerX", "", "centerY", "x0", "y0", "x1", "y1", "straightLine", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* loaded from: classes.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Cubic circularArc(float centerX, float centerY, float x0, float y0, float x1, float y1) {
            long directionVector = Utils.directionVector(x0 - centerX, y0 - centerY);
            long directionVector2 = Utils.directionVector(x1 - centerX, y1 - centerY);
            long m175rotate90DnnuFBc = Utils.m175rotate90DnnuFBc(directionVector);
            long m175rotate90DnnuFBc2 = Utils.m175rotate90DnnuFBc(directionVector2);
            boolean z = PointKt.m149dotProduct5P9i7ZU(m175rotate90DnnuFBc, x1 - centerX, y1 - centerY) >= 0.0f;
            float m150dotProductybeJwSQ = PointKt.m150dotProductybeJwSQ(directionVector, directionVector2);
            if (m150dotProductybeJwSQ > 0.999f) {
                return straightLine(x0, y0, x1, y1);
            }
            float distance = ((((Utils.distance(x0 - centerX, y0 - centerY) * 4.0f) / 3.0f) * (((float) Math.sqrt(2.0f * (1.0f - m150dotProductybeJwSQ))) - ((float) Math.sqrt(1.0f - (m150dotProductybeJwSQ * m150dotProductybeJwSQ))))) / (1.0f - m150dotProductybeJwSQ)) * (z ? 1.0f : -1.0f);
            return CubicKt.Cubic(x0, y0, (PointKt.m154getXDnnuFBc(m175rotate90DnnuFBc) * distance) + x0, (PointKt.m155getYDnnuFBc(m175rotate90DnnuFBc) * distance) + y0, x1 - (PointKt.m154getXDnnuFBc(m175rotate90DnnuFBc2) * distance), y1 - (PointKt.m155getYDnnuFBc(m175rotate90DnnuFBc2) * distance), x1, y1);
        }

        @JvmStatic
        public final Cubic straightLine(float x0, float y0, float x1, float y1) {
            return CubicKt.Cubic(x0, y0, Utils.interpolate(x0, x1, 0.33333334f), Utils.interpolate(y0, y1, 0.33333334f), Utils.interpolate(x0, x1, 0.6666667f), Utils.interpolate(y0, y1, 0.6666667f), x1, y1);
        }
    }

    public Cubic() {
        this(null, 1, null);
    }

    private Cubic(long j, long j2, long j3, long j4) {
        this(new float[]{PointKt.m154getXDnnuFBc(j), PointKt.m155getYDnnuFBc(j), PointKt.m154getXDnnuFBc(j2), PointKt.m155getYDnnuFBc(j2), PointKt.m154getXDnnuFBc(j3), PointKt.m155getYDnnuFBc(j3), PointKt.m154getXDnnuFBc(j4), PointKt.m155getYDnnuFBc(j4)});
    }

    public /* synthetic */ Cubic(long j, long j2, long j3, long j4, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4);
    }

    public Cubic(float[] points) {
        Intrinsics.checkNotNullParameter(points, "points");
        this.points = points;
        if (!(this.points.length == 8)) {
            throw new IllegalArgumentException("Points array size should be 8".toString());
        }
    }

    public /* synthetic */ Cubic(float[] fArr, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? new float[8] : fArr);
    }

    public static /* synthetic */ void calculateBounds$graphics_shapes_release$default(Cubic cubic, float[] fArr, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: calculateBounds");
        }
        if ((i & 1) != 0) {
            fArr = new float[4];
        }
        if ((i & 2) != 0) {
            z = false;
        }
        cubic.calculateBounds$graphics_shapes_release(fArr, z);
    }

    @JvmStatic
    public static final Cubic circularArc(float f, float f2, float f3, float f4, float f5, float f6) {
        return INSTANCE.circularArc(f, f2, f3, f4, f5, f6);
    }

    @JvmStatic
    public static final Cubic straightLine(float f, float f2, float f3, float f4) {
        return INSTANCE.straightLine(f, f2, f3, f4);
    }

    private final boolean zeroIsh(float value) {
        return Math.abs(value) < 1.0E-4f;
    }

    public final void calculateBounds$graphics_shapes_release(float[] bounds, boolean approximate) {
        char c;
        char c2;
        char c3;
        char c4;
        float f;
        float f2;
        float f3;
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        if (zeroLength$graphics_shapes_release()) {
            bounds[0] = getAnchor0X();
            bounds[1] = getAnchor0Y();
            bounds[2] = getAnchor0X();
            bounds[3] = getAnchor0Y();
            return;
        }
        float min = Math.min(getAnchor0X(), getAnchor1X());
        float min2 = Math.min(getAnchor0Y(), getAnchor1Y());
        float max = Math.max(getAnchor0X(), getAnchor1X());
        float max2 = Math.max(getAnchor0Y(), getAnchor1Y());
        if (approximate) {
            bounds[0] = Math.min(min, Math.min(getControl0X(), getControl1X()));
            bounds[1] = Math.min(min2, Math.min(getControl0Y(), getControl1Y()));
            bounds[2] = Math.max(max, Math.max(getControl0X(), getControl1X()));
            bounds[3] = Math.max(max2, Math.max(getControl0Y(), getControl1Y()));
            return;
        }
        float control0X = (((-getAnchor0X()) + (getControl0X() * 3.0f)) - (getControl1X() * 3.0f)) + getAnchor1X();
        float anchor0X = ((getAnchor0X() * 2.0f) - (getControl0X() * 4.0f)) + (getControl1X() * 2.0f);
        float control0X2 = (-getAnchor0X()) + getControl0X();
        if (zeroIsh(control0X)) {
            if (anchor0X == 0.0f) {
                c = 3;
                c2 = 2;
                c3 = 1;
                c4 = 0;
                f = 3.0f;
                f2 = 2.0f;
            } else {
                c = 3;
                float f4 = (2.0f * control0X2) / ((-2.0f) * anchor0X);
                if (0.0f <= f4 && f4 <= 1.0f) {
                    float m154getXDnnuFBc = PointKt.m154getXDnnuFBc(m142pointOnCurveOOQOV4g$graphics_shapes_release(f4));
                    if (m154getXDnnuFBc < min) {
                        min = m154getXDnnuFBc;
                    }
                    if (m154getXDnnuFBc > max) {
                        max = m154getXDnnuFBc;
                    }
                    c2 = 2;
                    c3 = 1;
                    c4 = 0;
                    f = 3.0f;
                    f2 = 2.0f;
                } else {
                    c2 = 2;
                    c3 = 1;
                    c4 = 0;
                    f = 3.0f;
                    f2 = 2.0f;
                }
            }
        } else {
            c = 3;
            float f5 = (anchor0X * anchor0X) - ((4.0f * control0X) * control0X2);
            if (f5 >= 0.0f) {
                c2 = 2;
                c3 = 1;
                c4 = 0;
                float sqrt = ((-anchor0X) + ((float) Math.sqrt(f5))) / (2.0f * control0X);
                if (0.0f <= sqrt && sqrt <= 1.0f) {
                    float m154getXDnnuFBc2 = PointKt.m154getXDnnuFBc(m142pointOnCurveOOQOV4g$graphics_shapes_release(sqrt));
                    if (m154getXDnnuFBc2 < min) {
                        min = m154getXDnnuFBc2;
                    }
                    if (m154getXDnnuFBc2 > max) {
                        max = m154getXDnnuFBc2;
                    }
                }
                f = 3.0f;
                f2 = 2.0f;
                float sqrt2 = ((-anchor0X) - ((float) Math.sqrt(f5))) / (2.0f * control0X);
                if (0.0f <= sqrt2 && sqrt2 <= 1.0f) {
                    float m154getXDnnuFBc3 = PointKt.m154getXDnnuFBc(m142pointOnCurveOOQOV4g$graphics_shapes_release(sqrt2));
                    if (m154getXDnnuFBc3 < min) {
                        min = m154getXDnnuFBc3;
                    }
                    if (m154getXDnnuFBc3 > max) {
                        max = m154getXDnnuFBc3;
                    }
                }
            } else {
                c2 = 2;
                c3 = 1;
                c4 = 0;
                f = 3.0f;
                f2 = 2.0f;
            }
        }
        float control0Y = (((-getAnchor0Y()) + (f * getControl0Y())) - (f * getControl1Y())) + getAnchor1Y();
        float anchor0Y = ((f2 * getAnchor0Y()) - (getControl0Y() * 4.0f)) + (getControl1Y() * f2);
        float control0Y2 = (-getAnchor0Y()) + getControl0Y();
        if (zeroIsh(control0Y)) {
            if ((anchor0Y == 0.0f ? c3 : c4) == 0) {
                float f6 = (f2 * control0Y2) / ((-2.0f) * anchor0Y);
                if (((0.0f > f6 || f6 > 1.0f) ? c4 : c3) != 0) {
                    float m155getYDnnuFBc = PointKt.m155getYDnnuFBc(m142pointOnCurveOOQOV4g$graphics_shapes_release(f6));
                    if (m155getYDnnuFBc < min2) {
                        min2 = m155getYDnnuFBc;
                    }
                    if (m155getYDnnuFBc > max2) {
                        max2 = m155getYDnnuFBc;
                    }
                    f3 = min;
                } else {
                    f3 = min;
                }
            } else {
                f3 = min;
            }
        } else {
            float f7 = (anchor0Y * anchor0Y) - ((4.0f * control0Y) * control0Y2);
            if (f7 >= 0.0f) {
                f3 = min;
                float sqrt3 = ((-anchor0Y) + ((float) Math.sqrt(f7))) / (f2 * control0Y);
                if (((0.0f > sqrt3 || sqrt3 > 1.0f) ? c4 : c3) != 0) {
                    float m155getYDnnuFBc2 = PointKt.m155getYDnnuFBc(m142pointOnCurveOOQOV4g$graphics_shapes_release(sqrt3));
                    if (m155getYDnnuFBc2 < min2) {
                        min2 = m155getYDnnuFBc2;
                    }
                    if (m155getYDnnuFBc2 > max2) {
                        max2 = m155getYDnnuFBc2;
                    }
                }
                float sqrt4 = ((-anchor0Y) - ((float) Math.sqrt(f7))) / (f2 * control0Y);
                if (((0.0f > sqrt4 || sqrt4 > 1.0f) ? c4 : c3) != 0) {
                    float m155getYDnnuFBc3 = PointKt.m155getYDnnuFBc(m142pointOnCurveOOQOV4g$graphics_shapes_release(sqrt4));
                    if (m155getYDnnuFBc3 < min2) {
                        min2 = m155getYDnnuFBc3;
                    }
                    if (m155getYDnnuFBc3 > max2) {
                        max2 = m155getYDnnuFBc3;
                    }
                }
            } else {
                f3 = min;
            }
        }
        bounds[c4] = f3;
        bounds[c3] = min2;
        bounds[c2] = max;
        bounds[c] = max2;
    }

    public final Cubic div(float x) {
        return times(1.0f / x);
    }

    public final Cubic div(int x) {
        return div(x);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof Cubic) {
            return Arrays.equals(this.points, ((Cubic) other).points);
        }
        return false;
    }

    public final float getAnchor0X() {
        return this.points[0];
    }

    public final float getAnchor0Y() {
        return this.points[1];
    }

    public final float getAnchor1X() {
        return this.points[6];
    }

    public final float getAnchor1Y() {
        return this.points[7];
    }

    public final float getControl0X() {
        return this.points[2];
    }

    public final float getControl0Y() {
        return this.points[3];
    }

    public final float getControl1X() {
        return this.points[4];
    }

    public final float getControl1Y() {
        return this.points[5];
    }

    /* renamed from: getPoints$graphics_shapes_release, reason: from getter */
    public final float[] getPoints() {
        return this.points;
    }

    public int hashCode() {
        return Arrays.hashCode(this.points);
    }

    public final Cubic plus(Cubic o) {
        Intrinsics.checkNotNullParameter(o, "o");
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] + o.points[i];
        }
        return new Cubic(fArr);
    }

    /* renamed from: pointOnCurve-OOQOV4g$graphics_shapes_release, reason: not valid java name */
    public final long m142pointOnCurveOOQOV4g$graphics_shapes_release(float t) {
        float f = 1.0f - t;
        return FloatFloatPair.m12constructorimpl((getAnchor0X() * f * f * f) + (getControl0X() * 3.0f * t * f * f) + (getControl1X() * 3.0f * t * t * f) + (getAnchor1X() * t * t * t), (getAnchor0Y() * f * f * f) + (getControl0Y() * 3.0f * t * f * f) + (getControl1Y() * 3.0f * t * t * f) + (getAnchor1Y() * t * t * t));
    }

    public final Cubic reverse() {
        return CubicKt.Cubic(getAnchor1X(), getAnchor1Y(), getControl1X(), getControl1Y(), getControl0X(), getControl0Y(), getAnchor0X(), getAnchor0Y());
    }

    public final Pair<Cubic, Cubic> split(float t) {
        float f = 1.0f - t;
        long m142pointOnCurveOOQOV4g$graphics_shapes_release = m142pointOnCurveOOQOV4g$graphics_shapes_release(t);
        return TuplesKt.to(CubicKt.Cubic(getAnchor0X(), getAnchor0Y(), (getAnchor0X() * f) + (getControl0X() * t), (getAnchor0Y() * f) + (getControl0Y() * t), (getAnchor0X() * f * f) + (getControl0X() * 2.0f * f * t) + (getControl1X() * t * t), (getAnchor0Y() * f * f) + (getControl0Y() * 2.0f * f * t) + (getControl1Y() * t * t), PointKt.m154getXDnnuFBc(m142pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m155getYDnnuFBc(m142pointOnCurveOOQOV4g$graphics_shapes_release)), CubicKt.Cubic(PointKt.m154getXDnnuFBc(m142pointOnCurveOOQOV4g$graphics_shapes_release), PointKt.m155getYDnnuFBc(m142pointOnCurveOOQOV4g$graphics_shapes_release), (getControl0X() * f * f) + (getControl1X() * 2.0f * f * t) + (getAnchor1X() * t * t), (getControl0Y() * f * f) + (getControl1Y() * 2.0f * f * t) + (getAnchor1Y() * t * t), (getControl1X() * f) + (getAnchor1X() * t), (getControl1Y() * f) + (getAnchor1Y() * t), getAnchor1X(), getAnchor1Y()));
    }

    public final Cubic times(float x) {
        float[] fArr = new float[8];
        for (int i = 0; i < 8; i++) {
            fArr[i] = this.points[i] * x;
        }
        return new Cubic(fArr);
    }

    public final Cubic times(int x) {
        return times(x);
    }

    public String toString() {
        return "anchor0: (" + getAnchor0X() + ", " + getAnchor0Y() + ") control0: (" + getControl0X() + ", " + getControl0Y() + "), control1: (" + getControl1X() + ", " + getControl1Y() + "), anchor1: (" + getAnchor1X() + ", " + getAnchor1Y() + ')';
    }

    public final Cubic transformed(PointTransformer f) {
        Intrinsics.checkNotNullParameter(f, "f");
        MutableCubic mutableCubic = new MutableCubic();
        ArraysKt.copyInto$default(this.points, mutableCubic.getPoints(), 0, 0, 0, 14, (Object) null);
        mutableCubic.transform(f);
        return mutableCubic;
    }

    public final boolean zeroLength$graphics_shapes_release() {
        return Math.abs(getAnchor0X() - getAnchor1X()) < 1.0E-4f && Math.abs(getAnchor0Y() - getAnchor1Y()) < 1.0E-4f;
    }
}
