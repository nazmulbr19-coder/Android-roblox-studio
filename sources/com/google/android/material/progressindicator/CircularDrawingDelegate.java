package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.Pair;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;
import java.util.ArrayList;

/* loaded from: classes.dex */
final class CircularDrawingDelegate extends DrawingDelegate<CircularProgressIndicatorSpec> {
    private static final float QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH = 0.5522848f;
    private static final float ROUND_CAP_RAMP_DOWN_THRESHHOLD = 0.01f;
    private float adjustedRadius;
    private float adjustedWavelength;
    private final RectF arcBounds;
    private float cachedAmplitude;
    private float cachedRadius;
    private int cachedWavelength;
    private float displayedAmplitude;
    private float displayedCornerRadius;
    private float displayedTrackThickness;
    private boolean drawingDeterminateIndicator;
    private final Pair<DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint> endPoints;
    private float totalTrackLengthFraction;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CircularDrawingDelegate(CircularProgressIndicatorSpec circularProgressIndicatorSpec) {
        super(circularProgressIndicatorSpec);
        this.arcBounds = new RectF();
        this.endPoints = new Pair<>(new DrawingDelegate.PathPoint(), new DrawingDelegate.PathPoint());
    }

    private void appendCubicPerHalfCycle(Path path, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint2) {
        float f = (this.adjustedWavelength / 2.0f) * 0.48f;
        DrawingDelegate.PathPoint pathPoint3 = new DrawingDelegate.PathPoint(this, pathPoint);
        DrawingDelegate.PathPoint pathPoint4 = new DrawingDelegate.PathPoint(this, pathPoint2);
        pathPoint3.moveAlong(f);
        pathPoint4.moveAlong(-f);
        path.cubicTo(pathPoint3.posVec[0], pathPoint3.posVec[1], pathPoint4.posVec[0], pathPoint4.posVec[1], pathPoint2.posVec[0], pathPoint2.posVec[1]);
    }

    private void calculateDisplayedPath(PathMeasure pathMeasure, Path path, Pair<DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint> pair, float f, float f2, float f3, float f4) {
        float f5;
        float f6 = this.displayedAmplitude * f3;
        int i = this.drawingDeterminateIndicator ? ((CircularProgressIndicatorSpec) this.spec).wavelengthDeterminate : ((CircularProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
        if (this.adjustedRadius != this.cachedRadius || (pathMeasure == this.activePathMeasure && (f6 != this.cachedAmplitude || i != this.cachedWavelength))) {
            this.cachedAmplitude = f6;
            this.cachedWavelength = i;
            this.cachedRadius = this.adjustedRadius;
            invalidateCachedPaths();
        }
        path.rewind();
        float clamp = MathUtils.clamp(f2, 0.0f, 1.0f);
        float f7 = 0.0f;
        if (((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            float f8 = f4 / ((float) ((this.adjustedRadius * 6.283185307179586d) / this.adjustedWavelength));
            f5 = f + f8;
            f7 = 0.0f - (360.0f * f8);
        } else {
            f5 = f;
        }
        float f9 = f5 % 1.0f;
        float length = (pathMeasure.getLength() * f9) / 2.0f;
        float length2 = ((f9 + clamp) * pathMeasure.getLength()) / 2.0f;
        pathMeasure.getSegment(length, length2, path, true);
        DrawingDelegate.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
        pathPoint.reset();
        pathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
        DrawingDelegate.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair.second;
        pathPoint2.reset();
        pathMeasure.getPosTan(length2, pathPoint2.posVec, pathPoint2.tanVec);
        this.transform.reset();
        this.transform.setRotate(f7);
        pathPoint.rotate(f7);
        pathPoint2.rotate(f7);
        path.transform(this.transform);
    }

    private void createWavyPath(PathMeasure pathMeasure, Path path, float f) {
        path.rewind();
        float length = pathMeasure.getLength();
        int max = Math.max(3, (int) ((length / (this.drawingDeterminateIndicator ? ((CircularProgressIndicatorSpec) this.spec).wavelengthDeterminate : ((CircularProgressIndicatorSpec) this.spec).wavelengthIndeterminate)) / 2.0f)) * 2;
        this.adjustedWavelength = length / max;
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < max; i++) {
            DrawingDelegate.PathPoint pathPoint = new DrawingDelegate.PathPoint();
            pathMeasure.getPosTan(this.adjustedWavelength * i, pathPoint.posVec, pathPoint.tanVec);
            DrawingDelegate.PathPoint pathPoint2 = new DrawingDelegate.PathPoint();
            pathMeasure.getPosTan((this.adjustedWavelength * i) + (this.adjustedWavelength / 2.0f), pathPoint2.posVec, pathPoint2.tanVec);
            arrayList.add(pathPoint);
            pathPoint2.moveAcross(f * 2.0f);
            arrayList.add(pathPoint2);
        }
        arrayList.add((DrawingDelegate.PathPoint) arrayList.get(0));
        DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint3 = (DrawingDelegate.PathPoint) arrayList.get(0);
        path.moveTo(pathPoint3.posVec[0], pathPoint3.posVec[1]);
        for (int i2 = 1; i2 < arrayList.size(); i2++) {
            DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint4 = (DrawingDelegate.PathPoint) arrayList.get(i2);
            appendCubicPerHalfCycle(path, pathPoint3, pathPoint4);
            pathPoint3 = pathPoint4;
        }
    }

    private void drawArc(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3, float f3, float f4, boolean z) {
        float f5;
        Paint paint2;
        CircularDrawingDelegate circularDrawingDelegate;
        Canvas canvas2;
        float f6;
        float f7;
        float f8 = f2 >= f ? f2 - f : (f2 + 1.0f) - f;
        float f9 = f % 1.0f;
        float f10 = f9 < 0.0f ? f9 + 1.0f : f9;
        if (this.totalTrackLengthFraction < 1.0f && f10 + f8 > 1.0f) {
            drawArc(canvas, paint, f10, 1.0f, i, i2, 0, f3, f4, z);
            drawArc(canvas, paint, 1.0f, f10 + f8, i, 0, i3, f3, f4, z);
            return;
        }
        float f11 = f10;
        float degrees = (float) Math.toDegrees(this.displayedCornerRadius / this.adjustedRadius);
        float f12 = f8 - 0.99f;
        if (f12 >= 0.0f) {
            float f13 = ((f12 * degrees) / 180.0f) / ROUND_CAP_RAMP_DOWN_THRESHHOLD;
            f8 += f13;
            if (!z) {
                f11 -= f13 / 2.0f;
            }
        }
        float lerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, f11);
        float lerp2 = com.google.android.material.math.MathUtils.lerp(0.0f, this.totalTrackLengthFraction, f8);
        float degrees2 = (float) Math.toDegrees(i2 / this.adjustedRadius);
        float degrees3 = ((lerp2 * 360.0f) - degrees2) - ((float) Math.toDegrees(i3 / this.adjustedRadius));
        float f14 = (lerp * 360.0f) + degrees2;
        if (degrees3 <= 0.0f) {
            return;
        }
        boolean z2 = ((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator) && z && f3 > 0.0f;
        paint.setAntiAlias(true);
        paint.setColor(i);
        paint.setStrokeWidth(this.displayedTrackThickness);
        float f15 = this.displayedCornerRadius * 2.0f;
        if (degrees3 < degrees * 2.0f) {
            float f16 = degrees3 / (degrees * 2.0f);
            float f17 = f14 + (degrees * f16);
            DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint = new DrawingDelegate.PathPoint();
            if (z2) {
                float length = ((f17 / 360.0f) * this.activePathMeasure.getLength()) / 2.0f;
                float f18 = this.displayedAmplitude * f3;
                f6 = f15;
                if (this.adjustedRadius != this.cachedRadius || f18 != this.cachedAmplitude) {
                    this.cachedAmplitude = f18;
                    this.cachedRadius = this.adjustedRadius;
                    invalidateCachedPaths();
                }
                f7 = f16;
                this.activePathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
            } else {
                pathPoint.rotate(f17 + 90.0f);
                pathPoint.moveAcross(-this.adjustedRadius);
                f6 = f15;
                f7 = f16;
            }
            paint.setStyle(Paint.Style.FILL);
            drawRoundedBlock(canvas, paint, pathPoint, f6, this.displayedTrackThickness, f7);
            return;
        }
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(((CircularProgressIndicatorSpec) this.spec).useStrokeCap() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
        float f19 = f14 + degrees;
        float f20 = degrees3 - (degrees * 2.0f);
        ((DrawingDelegate.PathPoint) this.endPoints.first).reset();
        ((DrawingDelegate.PathPoint) this.endPoints.second).reset();
        if (z2) {
            f5 = 0.0f;
            paint2 = paint;
            circularDrawingDelegate = this;
            circularDrawingDelegate.calculateDisplayedPath(this.activePathMeasure, this.displayedActivePath, this.endPoints, f19 / 360.0f, f20 / 360.0f, f3, f4);
            canvas2 = canvas;
            canvas2.drawPath(circularDrawingDelegate.displayedActivePath, paint2);
        } else {
            ((DrawingDelegate.PathPoint) this.endPoints.first).rotate(f19 + 90.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.first).moveAcross(-this.adjustedRadius);
            ((DrawingDelegate.PathPoint) this.endPoints.second).rotate(f19 + f20 + 90.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.second).moveAcross(-this.adjustedRadius);
            f5 = 0.0f;
            this.arcBounds.set(-this.adjustedRadius, -this.adjustedRadius, this.adjustedRadius, this.adjustedRadius);
            canvas.drawArc(this.arcBounds, f19, f20, false, paint);
            paint2 = paint;
            canvas2 = canvas;
            circularDrawingDelegate = this;
        }
        if (((CircularProgressIndicatorSpec) circularDrawingDelegate.spec).useStrokeCap() || circularDrawingDelegate.displayedCornerRadius <= f5) {
            return;
        }
        paint2.setStyle(Paint.Style.FILL);
        circularDrawingDelegate.drawRoundedBlock(canvas2, paint2, (DrawingDelegate.PathPoint) circularDrawingDelegate.endPoints.first, f15, circularDrawingDelegate.displayedTrackThickness);
        circularDrawingDelegate.drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) circularDrawingDelegate.endPoints.second, f15, circularDrawingDelegate.displayedTrackThickness);
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, float f, float f2) {
        drawRoundedBlock(canvas, paint, pathPoint, f, f2, 1.0f);
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, DrawingDelegate<CircularProgressIndicatorSpec>.PathPoint pathPoint, float f, float f2, float f3) {
        float min = Math.min(f2, this.displayedTrackThickness);
        float min2 = Math.min(f / 2.0f, (this.displayedCornerRadius * min) / this.displayedTrackThickness);
        RectF rectF = new RectF((-f) / 2.0f, (-min) / 2.0f, f / 2.0f, min / 2.0f);
        canvas.save();
        canvas.translate(pathPoint.posVec[0], pathPoint.posVec[1]);
        canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
        canvas.scale(f3, f3);
        canvas.drawRoundRect(rectF, min2, min2, paint);
        canvas.restore();
    }

    private int getSize() {
        return ((CircularProgressIndicatorSpec) this.spec).indicatorSize + (((CircularProgressIndicatorSpec) this.spec).indicatorInset * 2);
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void adjustCanvas(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        float width = rect.width() / getPreferredWidth();
        float height = rect.height() / getPreferredHeight();
        float f2 = (((CircularProgressIndicatorSpec) this.spec).indicatorSize / 2.0f) + ((CircularProgressIndicatorSpec) this.spec).indicatorInset;
        canvas.translate(rect.left + (f2 * width), rect.top + (f2 * height));
        canvas.rotate(-90.0f);
        canvas.scale(width, height);
        if (((CircularProgressIndicatorSpec) this.spec).indicatorDirection != 0) {
            canvas.scale(1.0f, -1.0f);
            if (Build.VERSION.SDK_INT == 29) {
                canvas.rotate(0.1f);
            }
        }
        canvas.clipRect(-f2, -f2, f2, f2);
        this.displayedTrackThickness = ((CircularProgressIndicatorSpec) this.spec).trackThickness * f;
        this.displayedCornerRadius = Math.min(((CircularProgressIndicatorSpec) this.spec).trackThickness / 2, ((CircularProgressIndicatorSpec) this.spec).getTrackCornerRadiusInPx()) * f;
        this.displayedAmplitude = ((CircularProgressIndicatorSpec) this.spec).waveAmplitude * f;
        this.adjustedRadius = (((CircularProgressIndicatorSpec) this.spec).indicatorSize - ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
        if (z || z2) {
            float f3 = ((1.0f - f) * ((CircularProgressIndicatorSpec) this.spec).trackThickness) / 2.0f;
            if ((z && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z2 && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                this.adjustedRadius += f3;
            } else if ((z && ((CircularProgressIndicatorSpec) this.spec).showAnimationBehavior == 1) || (z2 && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 2)) {
                this.adjustedRadius -= f3;
            }
        }
        if (z2 && ((CircularProgressIndicatorSpec) this.spec).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(Canvas canvas, Paint paint, int i, int i2) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(Canvas canvas, Paint paint, DrawingDelegate.ActiveIndicator activeIndicator, int i) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i);
        canvas.save();
        canvas.rotate(activeIndicator.rotationDegree);
        this.drawingDeterminateIndicator = activeIndicator.isDeterminate;
        drawArc(canvas, paint, activeIndicator.startFraction, activeIndicator.endFraction, compositeARGBWithAlpha, activeIndicator.gapSize, activeIndicator.gapSize, activeIndicator.amplitudeFraction, activeIndicator.phaseFraction, true);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i, i2);
        this.drawingDeterminateIndicator = false;
        drawArc(canvas, paint, f, f2, compositeARGBWithAlpha, i3, i3, 0.0f, 0.0f, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return getSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return getSize();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void invalidateCachedPaths() {
        this.cachedActivePath.rewind();
        this.cachedActivePath.moveTo(1.0f, 0.0f);
        for (int i = 0; i < 2; i++) {
            this.cachedActivePath.cubicTo(1.0f, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, 1.0f, 0.0f, 1.0f);
            this.cachedActivePath.cubicTo(-0.5522848f, 1.0f, -1.0f, QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, -1.0f, 0.0f);
            this.cachedActivePath.cubicTo(-1.0f, -0.5522848f, -0.5522848f, -1.0f, 0.0f, -1.0f);
            this.cachedActivePath.cubicTo(QUARTER_CIRCLE_CONTROL_HANDLE_LENGTH, -1.0f, 1.0f, -0.5522848f, 1.0f, 0.0f);
        }
        this.transform.reset();
        this.transform.setScale(this.adjustedRadius, this.adjustedRadius);
        this.cachedActivePath.transform(this.transform);
        if (((CircularProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            this.activePathMeasure.setPath(this.cachedActivePath, false);
            createWavyPath(this.activePathMeasure, this.cachedActivePath, this.cachedAmplitude);
        }
        this.activePathMeasure.setPath(this.cachedActivePath, false);
    }
}
