package androidx.graphics.shapes;

import androidx.collection.FloatFloatPair;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: RoundedPolygon.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\b\u0007\b\u0002\u0018\u00002\u00020\u0001B5\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004\u0012\n\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020\u0011H\u0002Jf\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u00112\n\u0010-\u001a\u00060\u0003j\u0002`\u00042\n\u0010.\u001a\u00060\u0003j\u0002`\u00042\n\u0010/\u001a\u00060\u0003j\u0002`\u00042\n\u00100\u001a\u00060\u0003j\u0002`\u00042\n\u00101\u001a\u00060\u0003j\u0002`\u00042\u0006\u00102\u001a\u00020\u0011H\u0002ø\u0001\u0000¢\u0006\u0004\b3\u00104J \u00105\u001a\b\u0012\u0004\u0012\u00020*062\u0006\u00107\u001a\u00020\u00112\b\b\u0002\u00108\u001a\u00020\u0011H\u0007JJ\u00109\u001a\n\u0018\u00010\u0003j\u0004\u0018\u0001`\u00042\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u00042\n\u0010:\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0005\u001a\u00060\u0003j\u0002`\u00042\n\u0010\u0016\u001a\u00060\u0003j\u0002`\u0004H\u0002ø\u0001\u0000¢\u0006\u0004\b;\u0010<R&\u0010\n\u001a\u00060\u0003j\u0002`\u0004X\u0086\u000eø\u0001\u0000ø\u0001\u0001¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0014\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0013R\u001d\u0010\u0016\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0017\u0010\fR\u001d\u0010\u0018\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u0019\u0010\fR\u0011\u0010\u001a\u001a\u00020\u00118F¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0013R\u0011\u0010\u001c\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0013R\u001d\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u001e\u0010\fR\u001d\u0010\u0005\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\u001f\u0010\fR\u001d\u0010\u0006\u001a\u00060\u0003j\u0002`\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b \u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010#\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013R\u0011\u0010%\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0013\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006="}, d2 = {"Landroidx/graphics/shapes/RoundedCorner;", "", "p0", "Landroidx/collection/FloatFloatPair;", "Landroidx/graphics/shapes/Point;", "p1", "p2", "rounding", "Landroidx/graphics/shapes/CornerRounding;", "(JJJLandroidx/graphics/shapes/CornerRounding;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "center", "getCenter-1ufDz9w", "()J", "setCenter-DnnuFBc", "(J)V", "J", "cornerRadius", "", "getCornerRadius", "()F", "cosAngle", "getCosAngle", "d1", "getD1-1ufDz9w", "d2", "getD2-1ufDz9w", "expectedCut", "getExpectedCut", "expectedRoundCut", "getExpectedRoundCut", "getP0-1ufDz9w", "getP1-1ufDz9w", "getP2-1ufDz9w", "getRounding", "()Landroidx/graphics/shapes/CornerRounding;", "sinAngle", "getSinAngle", "smoothing", "getSmoothing", "calculateActualSmoothingValue", "allowedCut", "computeFlankingCurve", "Landroidx/graphics/shapes/Cubic;", "actualRoundCut", "actualSmoothingValues", "corner", "sideStart", "circleSegmentIntersection", "otherCircleSegmentIntersection", "circleCenter", "actualR", "computeFlankingCurve-oAJzIJU", "(FFJJJJJF)Landroidx/graphics/shapes/Cubic;", "getCubics", "", "allowedCut0", "allowedCut1", "lineIntersection", "d0", "lineIntersection-CBFvKDc", "(JJJJ)Landroidx/collection/FloatFloatPair;", "graphics-shapes_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class RoundedCorner {
    private long center;
    private final float cornerRadius;
    private final float cosAngle;
    private final long d1;
    private final long d2;
    private final float expectedRoundCut;
    private final long p0;
    private final long p1;
    private final long p2;
    private final CornerRounding rounding;
    private final float sinAngle;
    private final float smoothing;

    private RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding) {
        this.p0 = j;
        this.p1 = j2;
        this.p2 = j3;
        this.rounding = cornerRounding;
        this.d1 = PointKt.m151getDirectionDnnuFBc(PointKt.m157minusybeJwSQ(this.p0, this.p1));
        this.d2 = PointKt.m151getDirectionDnnuFBc(PointKt.m157minusybeJwSQ(this.p2, this.p1));
        CornerRounding cornerRounding2 = this.rounding;
        this.cornerRadius = cornerRounding2 != null ? cornerRounding2.getRadius() : 0.0f;
        CornerRounding cornerRounding3 = this.rounding;
        this.smoothing = cornerRounding3 != null ? cornerRounding3.getSmoothing() : 0.0f;
        this.cosAngle = PointKt.m150dotProductybeJwSQ(this.d1, this.d2);
        this.sinAngle = (float) Math.sqrt(1.0f - Utils.square(this.cosAngle));
        this.expectedRoundCut = ((double) this.sinAngle) > 0.001d ? (this.cornerRadius * (this.cosAngle + 1.0f)) / this.sinAngle : 0.0f;
        this.center = FloatFloatPair.m12constructorimpl(0.0f, 0.0f);
    }

    public /* synthetic */ RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, (i & 8) != 0 ? null : cornerRounding, null);
    }

    public /* synthetic */ RoundedCorner(long j, long j2, long j3, CornerRounding cornerRounding, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, cornerRounding);
    }

    private final float calculateActualSmoothingValue(float allowedCut) {
        if (allowedCut > getExpectedCut()) {
            return this.smoothing;
        }
        if (allowedCut > this.expectedRoundCut) {
            return (this.smoothing * (allowedCut - this.expectedRoundCut)) / (getExpectedCut() - this.expectedRoundCut);
        }
        return 0.0f;
    }

    /* renamed from: computeFlankingCurve-oAJzIJU, reason: not valid java name */
    private final Cubic m164computeFlankingCurveoAJzIJU(float actualRoundCut, float actualSmoothingValues, long corner, long sideStart, long circleSegmentIntersection, long otherCircleSegmentIntersection, long circleCenter, float actualR) {
        long m151getDirectionDnnuFBc = PointKt.m151getDirectionDnnuFBc(PointKt.m157minusybeJwSQ(sideStart, corner));
        long m158plusybeJwSQ = PointKt.m158plusybeJwSQ(corner, PointKt.m160timesso9K2fw(PointKt.m160timesso9K2fw(m151getDirectionDnnuFBc, actualRoundCut), 1.0f + actualSmoothingValues));
        long m156interpolatedLqxh1s = PointKt.m156interpolatedLqxh1s(circleSegmentIntersection, PointKt.m148divso9K2fw(PointKt.m158plusybeJwSQ(circleSegmentIntersection, otherCircleSegmentIntersection), 2.0f), actualSmoothingValues);
        long m158plusybeJwSQ2 = PointKt.m158plusybeJwSQ(circleCenter, PointKt.m160timesso9K2fw(Utils.directionVector(PointKt.m154getXDnnuFBc(m156interpolatedLqxh1s) - PointKt.m154getXDnnuFBc(circleCenter), PointKt.m155getYDnnuFBc(m156interpolatedLqxh1s) - PointKt.m155getYDnnuFBc(circleCenter)), actualR));
        FloatFloatPair m165lineIntersectionCBFvKDc = m165lineIntersectionCBFvKDc(sideStart, m151getDirectionDnnuFBc, m158plusybeJwSQ2, Utils.m175rotate90DnnuFBc(PointKt.m157minusybeJwSQ(m158plusybeJwSQ2, circleCenter)));
        long packedValue = m165lineIntersectionCBFvKDc != null ? m165lineIntersectionCBFvKDc.getPackedValue() : circleSegmentIntersection;
        return new Cubic(m158plusybeJwSQ, PointKt.m148divso9K2fw(PointKt.m158plusybeJwSQ(m158plusybeJwSQ, PointKt.m160timesso9K2fw(packedValue, 2.0f)), 3.0f), packedValue, m158plusybeJwSQ2, null);
    }

    public static /* synthetic */ List getCubics$default(RoundedCorner roundedCorner, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f2 = f;
        }
        return roundedCorner.getCubics(f, f2);
    }

    /* renamed from: lineIntersection-CBFvKDc, reason: not valid java name */
    private final FloatFloatPair m165lineIntersectionCBFvKDc(long p0, long d0, long p1, long d1) {
        long m175rotate90DnnuFBc = Utils.m175rotate90DnnuFBc(d1);
        float m150dotProductybeJwSQ = PointKt.m150dotProductybeJwSQ(d0, m175rotate90DnnuFBc);
        if (Math.abs(m150dotProductybeJwSQ) < 1.0E-4f) {
            return null;
        }
        float m150dotProductybeJwSQ2 = PointKt.m150dotProductybeJwSQ(PointKt.m157minusybeJwSQ(p1, p0), m175rotate90DnnuFBc);
        if (Math.abs(m150dotProductybeJwSQ) < Math.abs(m150dotProductybeJwSQ2) * 1.0E-4f) {
            return null;
        }
        return FloatFloatPair.m9boximpl(PointKt.m158plusybeJwSQ(p0, PointKt.m160timesso9K2fw(d0, m150dotProductybeJwSQ2 / m150dotProductybeJwSQ)));
    }

    /* renamed from: getCenter-1ufDz9w, reason: not valid java name and from getter */
    public final long getCenter() {
        return this.center;
    }

    public final float getCornerRadius() {
        return this.cornerRadius;
    }

    public final float getCosAngle() {
        return this.cosAngle;
    }

    public final List<Cubic> getCubics(float f) {
        return getCubics$default(this, f, 0.0f, 2, null);
    }

    public final List<Cubic> getCubics(float allowedCut0, float allowedCut1) {
        float min = Math.min(allowedCut0, allowedCut1);
        if (this.expectedRoundCut >= 1.0E-4f && min >= 1.0E-4f && this.cornerRadius >= 1.0E-4f) {
            float min2 = Math.min(min, this.expectedRoundCut);
            float calculateActualSmoothingValue = calculateActualSmoothingValue(allowedCut0);
            float calculateActualSmoothingValue2 = calculateActualSmoothingValue(allowedCut1);
            float f = (this.cornerRadius * min2) / this.expectedRoundCut;
            this.center = PointKt.m158plusybeJwSQ(this.p1, PointKt.m160timesso9K2fw(PointKt.m151getDirectionDnnuFBc(PointKt.m148divso9K2fw(PointKt.m158plusybeJwSQ(this.d1, this.d2), 2.0f)), (float) Math.sqrt(Utils.square(f) + Utils.square(min2))));
            long m158plusybeJwSQ = PointKt.m158plusybeJwSQ(this.p1, PointKt.m160timesso9K2fw(this.d1, min2));
            long m158plusybeJwSQ2 = PointKt.m158plusybeJwSQ(this.p1, PointKt.m160timesso9K2fw(this.d2, min2));
            Cubic m164computeFlankingCurveoAJzIJU = m164computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue, this.p1, this.p0, m158plusybeJwSQ, m158plusybeJwSQ2, this.center, f);
            Cubic reverse = m164computeFlankingCurveoAJzIJU(min2, calculateActualSmoothingValue2, this.p1, this.p2, m158plusybeJwSQ2, m158plusybeJwSQ, this.center, f).reverse();
            return CollectionsKt.listOf((Object[]) new Cubic[]{m164computeFlankingCurveoAJzIJU, Cubic.INSTANCE.circularArc(PointKt.m154getXDnnuFBc(this.center), PointKt.m155getYDnnuFBc(this.center), m164computeFlankingCurveoAJzIJU.getAnchor1X(), m164computeFlankingCurveoAJzIJU.getAnchor1Y(), reverse.getAnchor0X(), reverse.getAnchor0Y()), reverse});
        }
        this.center = this.p1;
        return CollectionsKt.listOf(Cubic.INSTANCE.straightLine(PointKt.m154getXDnnuFBc(this.p1), PointKt.m155getYDnnuFBc(this.p1), PointKt.m154getXDnnuFBc(this.p1), PointKt.m155getYDnnuFBc(this.p1)));
    }

    /* renamed from: getD1-1ufDz9w, reason: not valid java name and from getter */
    public final long getD1() {
        return this.d1;
    }

    /* renamed from: getD2-1ufDz9w, reason: not valid java name and from getter */
    public final long getD2() {
        return this.d2;
    }

    public final float getExpectedCut() {
        return (1.0f + this.smoothing) * this.expectedRoundCut;
    }

    public final float getExpectedRoundCut() {
        return this.expectedRoundCut;
    }

    /* renamed from: getP0-1ufDz9w, reason: not valid java name and from getter */
    public final long getP0() {
        return this.p0;
    }

    /* renamed from: getP1-1ufDz9w, reason: not valid java name and from getter */
    public final long getP1() {
        return this.p1;
    }

    /* renamed from: getP2-1ufDz9w, reason: not valid java name and from getter */
    public final long getP2() {
        return this.p2;
    }

    public final CornerRounding getRounding() {
        return this.rounding;
    }

    public final float getSinAngle() {
        return this.sinAngle;
    }

    public final float getSmoothing() {
        return this.smoothing;
    }

    /* renamed from: setCenter-DnnuFBc, reason: not valid java name */
    public final void m172setCenterDnnuFBc(long j) {
        this.center = j;
    }
}
