package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.Pair;
import androidx.core.math.MathUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.progressindicator.DrawingDelegate;

/* loaded from: classes.dex */
final class LinearDrawingDelegate extends DrawingDelegate<LinearProgressIndicatorSpec> {
    private float adjustedWavelength;
    private int cachedWavelength;
    private float displayedAmplitude;
    private float displayedCornerRadius;
    private float displayedInnerCornerRadius;
    private float displayedTrackThickness;
    private boolean drawingDeterminateIndicator;
    Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> endPoints;
    private float totalTrackLengthFraction;
    private float trackLength;

    /* JADX INFO: Access modifiers changed from: package-private */
    public LinearDrawingDelegate(LinearProgressIndicatorSpec linearProgressIndicatorSpec) {
        super(linearProgressIndicatorSpec);
        this.trackLength = 300.0f;
        this.endPoints = new Pair<>(new DrawingDelegate.PathPoint(), new DrawingDelegate.PathPoint());
    }

    private void calculateDisplayedPath(PathMeasure pathMeasure, Path path, Pair<DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint> pair, float f, float f2, float f3, float f4) {
        float f5;
        float f6;
        int i = this.drawingDeterminateIndicator ? ((LinearProgressIndicatorSpec) this.spec).wavelengthDeterminate : ((LinearProgressIndicatorSpec) this.spec).wavelengthIndeterminate;
        if (pathMeasure == this.activePathMeasure && i != this.cachedWavelength) {
            this.cachedWavelength = i;
            invalidateCachedPaths();
        }
        path.rewind();
        float f7 = (-this.trackLength) / 2.0f;
        boolean hasWavyEffect = ((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator);
        if (hasWavyEffect) {
            float f8 = this.trackLength / this.adjustedWavelength;
            float f9 = f4 / f8;
            float f10 = f8 / (f8 + 1.0f);
            f5 = (f + f9) * f10;
            f6 = (f2 + f9) * f10;
            f7 -= this.adjustedWavelength * f4;
        } else {
            f5 = f;
            f6 = f2;
        }
        float length = pathMeasure.getLength() * f5;
        float length2 = pathMeasure.getLength() * f6;
        pathMeasure.getSegment(length, length2, path, true);
        DrawingDelegate.PathPoint pathPoint = (DrawingDelegate.PathPoint) pair.first;
        pathPoint.reset();
        pathMeasure.getPosTan(length, pathPoint.posVec, pathPoint.tanVec);
        DrawingDelegate.PathPoint pathPoint2 = (DrawingDelegate.PathPoint) pair.second;
        pathPoint2.reset();
        pathMeasure.getPosTan(length2, pathPoint2.posVec, pathPoint2.tanVec);
        this.transform.reset();
        this.transform.setTranslate(f7, 0.0f);
        pathPoint.translate(f7, 0.0f);
        pathPoint2.translate(f7, 0.0f);
        if (hasWavyEffect) {
            float f11 = this.displayedAmplitude * f3;
            this.transform.postScale(1.0f, f11);
            pathPoint.scale(1.0f, f11);
            pathPoint2.scale(1.0f, f11);
        }
        path.transform(this.transform);
    }

    private void drawLine(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3, float f3, float f4, boolean z) {
        float f5;
        float f6;
        LinearDrawingDelegate linearDrawingDelegate;
        float f7;
        Paint paint2;
        Canvas canvas2;
        float clamp = MathUtils.clamp(f, 0.0f, 1.0f);
        float clamp2 = MathUtils.clamp(f2, 0.0f, 1.0f);
        float lerp = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, clamp);
        float lerp2 = com.google.android.material.math.MathUtils.lerp(1.0f - this.totalTrackLengthFraction, 1.0f, clamp2);
        int clamp3 = (int) ((i2 * MathUtils.clamp(lerp, 0.0f, 0.01f)) / 0.01f);
        int clamp4 = (int) ((i3 * (1.0f - MathUtils.clamp(lerp2, 0.99f, 1.0f))) / 0.01f);
        int i4 = (int) ((this.trackLength * lerp) + clamp3);
        int i5 = (int) ((this.trackLength * lerp2) - clamp4);
        float f8 = this.displayedCornerRadius;
        float f9 = this.displayedCornerRadius;
        if (this.displayedCornerRadius != this.displayedInnerCornerRadius) {
            float max = Math.max(this.displayedCornerRadius, this.displayedInnerCornerRadius) / this.trackLength;
            float lerp3 = com.google.android.material.math.MathUtils.lerp(this.displayedCornerRadius, this.displayedInnerCornerRadius, MathUtils.clamp(i4 / this.trackLength, 0.0f, max) / max);
            float lerp4 = com.google.android.material.math.MathUtils.lerp(this.displayedCornerRadius, this.displayedInnerCornerRadius, MathUtils.clamp((this.trackLength - i5) / this.trackLength, 0.0f, max) / max);
            f5 = lerp3;
            f6 = lerp4;
        } else {
            f5 = f8;
            f6 = f9;
        }
        float f10 = (-this.trackLength) / 2.0f;
        boolean z2 = ((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator) && z && f3 > 0.0f;
        if (i4 <= i5) {
            float f11 = i4 + f5;
            float f12 = i5 - f6;
            float f13 = f5 * 2.0f;
            float f14 = 2.0f * f6;
            paint.setColor(i);
            paint.setAntiAlias(true);
            paint.setStrokeWidth(this.displayedTrackThickness);
            ((DrawingDelegate.PathPoint) this.endPoints.first).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.second).reset();
            ((DrawingDelegate.PathPoint) this.endPoints.first).translate(f11 + f10, 0.0f);
            ((DrawingDelegate.PathPoint) this.endPoints.second).translate(f12 + f10, 0.0f);
            if (i4 == 0 && f12 + f6 < f11 + f5) {
                drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.first, f13, this.displayedTrackThickness, f5, (DrawingDelegate.PathPoint) this.endPoints.second, f14, this.displayedTrackThickness, f6, true);
                return;
            }
            float f15 = f6;
            if (f11 - f5 > f12 - f15) {
                drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) this.endPoints.second, f14, this.displayedTrackThickness, f15, (DrawingDelegate.PathPoint) this.endPoints.first, f13, this.displayedTrackThickness, f5, false);
                return;
            }
            float f16 = f5;
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeCap(((LinearProgressIndicatorSpec) this.spec).useStrokeCap() ? Paint.Cap.ROUND : Paint.Cap.BUTT);
            if (z2) {
                linearDrawingDelegate = this;
                f7 = 0.0f;
                paint2 = paint;
                linearDrawingDelegate.calculateDisplayedPath(this.activePathMeasure, this.displayedActivePath, this.endPoints, f11 / this.trackLength, f12 / this.trackLength, f3, f4);
                canvas2 = canvas;
                canvas2.drawPath(linearDrawingDelegate.displayedActivePath, paint2);
            } else {
                canvas.drawLine(((DrawingDelegate.PathPoint) this.endPoints.first).posVec[0], ((DrawingDelegate.PathPoint) this.endPoints.first).posVec[1], ((DrawingDelegate.PathPoint) this.endPoints.second).posVec[0], ((DrawingDelegate.PathPoint) this.endPoints.second).posVec[1], paint);
                canvas2 = canvas;
                linearDrawingDelegate = this;
                f7 = 0.0f;
                paint2 = paint;
            }
            if (((LinearProgressIndicatorSpec) linearDrawingDelegate.spec).useStrokeCap()) {
                return;
            }
            if (f11 > f7 && f16 > f7) {
                linearDrawingDelegate.drawRoundedBlock(canvas2, paint2, (DrawingDelegate.PathPoint) linearDrawingDelegate.endPoints.first, f13, linearDrawingDelegate.displayedTrackThickness, f16);
            }
            if (f12 >= linearDrawingDelegate.trackLength || f15 <= f7) {
                return;
            }
            linearDrawingDelegate.drawRoundedBlock(canvas, paint, (DrawingDelegate.PathPoint) linearDrawingDelegate.endPoints.second, f14, linearDrawingDelegate.displayedTrackThickness, f15);
        }
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint, float f, float f2, float f3) {
        drawRoundedBlock(canvas, paint, pathPoint, f, f2, f3, null, 0.0f, 0.0f, 0.0f, false);
    }

    private void drawRoundedBlock(Canvas canvas, Paint paint, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint, float f, float f2, float f3, DrawingDelegate<LinearProgressIndicatorSpec>.PathPoint pathPoint2, float f4, float f5, float f6, boolean z) {
        float f7;
        char c;
        char c2;
        float f8;
        float f9;
        float min = Math.min(f2, this.displayedTrackThickness);
        RectF rectF = new RectF((-f) / 2.0f, (-min) / 2.0f, f / 2.0f, min / 2.0f);
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        if (pathPoint2 != null) {
            float min2 = Math.min(f5, this.displayedTrackThickness);
            float min3 = Math.min(f4 / 2.0f, (f6 * min2) / this.displayedTrackThickness);
            RectF rectF2 = new RectF();
            if (z) {
                c2 = 1;
                f7 = 2.0f;
                float f10 = (pathPoint2.posVec[0] - min3) - (pathPoint.posVec[0] - f3);
                if (f10 > 0.0f) {
                    pathPoint2.translate((-f10) / 2.0f, 0.0f);
                    f9 = f4 + f10;
                } else {
                    f9 = f4;
                }
                c = 0;
                rectF2.set(0.0f, (-min) / 2.0f, f / 2.0f, min / 2.0f);
                f8 = f9;
            } else {
                f7 = 2.0f;
                c = 0;
                c2 = 1;
                float f11 = (pathPoint2.posVec[0] + min3) - (pathPoint.posVec[0] + f3);
                if (f11 < 0.0f) {
                    pathPoint2.translate((-f11) / 2.0f, 0.0f);
                    f8 = f4 - f11;
                } else {
                    f8 = f4;
                }
                rectF2.set((-f) / 2.0f, (-min) / 2.0f, 0.0f, min / 2.0f);
            }
            RectF rectF3 = new RectF((-f8) / f7, (-min2) / f7, f8 / f7, min2 / f7);
            canvas.translate(pathPoint2.posVec[c], pathPoint2.posVec[c2]);
            canvas.rotate(vectorToCanvasRotation(pathPoint2.tanVec));
            Path path = new Path();
            path.addRoundRect(rectF3, min3, min3, Path.Direction.CCW);
            canvas.clipPath(path);
            canvas.rotate(-vectorToCanvasRotation(pathPoint2.tanVec));
            canvas.translate(-pathPoint2.posVec[c], -pathPoint2.posVec[c2]);
            canvas.translate(pathPoint.posVec[c], pathPoint.posVec[c2]);
            canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
            canvas.drawRect(rectF2, paint);
            canvas.drawRoundRect(rectF, f3, f3, paint);
        } else {
            canvas.translate(pathPoint.posVec[0], pathPoint.posVec[1]);
            canvas.rotate(vectorToCanvasRotation(pathPoint.tanVec));
            canvas.drawRoundRect(rectF, f3, f3, paint);
        }
        canvas.restore();
    }

    @Override // com.google.android.material.progressindicator.DrawingDelegate
    void adjustCanvas(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        if (this.trackLength != rect.width()) {
            this.trackLength = rect.width();
            invalidateCachedPaths();
        }
        float preferredHeight = getPreferredHeight();
        canvas.translate(rect.left + (rect.width() / 2.0f), rect.top + (rect.height() / 2.0f) + Math.max(0.0f, (rect.height() - preferredHeight) / 2.0f));
        if (((LinearProgressIndicatorSpec) this.spec).drawHorizontallyInverse) {
            canvas.scale(-1.0f, 1.0f);
        }
        float f2 = this.trackLength / 2.0f;
        float f3 = preferredHeight / 2.0f;
        canvas.clipRect(-f2, -f3, f2, f3);
        this.displayedTrackThickness = ((LinearProgressIndicatorSpec) this.spec).trackThickness * f;
        this.displayedCornerRadius = Math.min(((LinearProgressIndicatorSpec) this.spec).trackThickness / 2, ((LinearProgressIndicatorSpec) this.spec).getTrackCornerRadiusInPx()) * f;
        this.displayedAmplitude = ((LinearProgressIndicatorSpec) this.spec).waveAmplitude * f;
        this.displayedInnerCornerRadius = Math.min(((LinearProgressIndicatorSpec) this.spec).trackThickness / 2.0f, ((LinearProgressIndicatorSpec) this.spec).getTrackInnerCornerRadiusInPx()) * f;
        if (z || z2) {
            if ((z && ((LinearProgressIndicatorSpec) this.spec).showAnimationBehavior == 2) || (z2 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 1)) {
                canvas.scale(1.0f, -1.0f);
            }
            if (z || (z2 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior != 3)) {
                canvas.translate(0.0f, (((LinearProgressIndicatorSpec) this.spec).trackThickness * (1.0f - f)) / 2.0f);
            }
        }
        if (z2 && ((LinearProgressIndicatorSpec) this.spec).hideAnimationBehavior == 3) {
            this.totalTrackLengthFraction = f;
        } else {
            this.totalTrackLengthFraction = 1.0f;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void drawStopIndicator(Canvas canvas, Paint paint, int i, int i2) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i, i2);
        this.drawingDeterminateIndicator = false;
        int actualTrackStopIndicatorSize = ((LinearProgressIndicatorSpec) this.spec).getActualTrackStopIndicatorSize();
        if (actualTrackStopIndicatorSize <= 0 || compositeARGBWithAlpha == 0) {
            return;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(compositeARGBWithAlpha);
        drawRoundedBlock(canvas, paint, new DrawingDelegate.PathPoint(new float[]{(this.trackLength / 2.0f) - (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorPadding != null ? ((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorPadding.floatValue() + (((LinearProgressIndicatorSpec) this.spec).trackStopIndicatorSize / 2.0f) : this.displayedTrackThickness / 2.0f), 0.0f}, new float[]{1.0f, 0.0f}), actualTrackStopIndicatorSize, actualTrackStopIndicatorSize, (this.displayedCornerRadius * actualTrackStopIndicatorSize) / this.displayedTrackThickness);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillIndicator(Canvas canvas, Paint paint, DrawingDelegate.ActiveIndicator activeIndicator, int i) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(activeIndicator.color, i);
        this.drawingDeterminateIndicator = activeIndicator.isDeterminate;
        drawLine(canvas, paint, activeIndicator.startFraction, activeIndicator.endFraction, compositeARGBWithAlpha, activeIndicator.gapSize, activeIndicator.gapSize, activeIndicator.amplitudeFraction, activeIndicator.phaseFraction, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void fillTrack(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3) {
        int compositeARGBWithAlpha = MaterialColors.compositeARGBWithAlpha(i, i2);
        this.drawingDeterminateIndicator = false;
        drawLine(canvas, paint, f, f2, compositeARGBWithAlpha, i3, i3, 0.0f, 0.0f, false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredHeight() {
        return ((LinearProgressIndicatorSpec) this.spec).trackThickness + (((LinearProgressIndicatorSpec) this.spec).waveAmplitude * 2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public int getPreferredWidth() {
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.material.progressindicator.DrawingDelegate
    public void invalidateCachedPaths() {
        this.cachedActivePath.rewind();
        if (((LinearProgressIndicatorSpec) this.spec).hasWavyEffect(this.drawingDeterminateIndicator)) {
            int i = (int) (this.trackLength / (this.drawingDeterminateIndicator ? ((LinearProgressIndicatorSpec) this.spec).wavelengthDeterminate : ((LinearProgressIndicatorSpec) this.spec).wavelengthIndeterminate));
            this.adjustedWavelength = this.trackLength / i;
            for (int i2 = 0; i2 <= i; i2++) {
                this.cachedActivePath.cubicTo((i2 * 2) + 0.48f, 0.0f, ((i2 * 2) + 1) - 0.48f, 1.0f, (i2 * 2) + 1, 1.0f);
                this.cachedActivePath.cubicTo((i2 * 2) + 1 + 0.48f, 1.0f, ((i2 * 2) + 2) - 0.48f, 0.0f, (i2 * 2) + 2, 0.0f);
            }
            this.transform.reset();
            this.transform.setScale(this.adjustedWavelength / 2.0f, -2.0f);
            this.transform.postTranslate(0.0f, 1.0f);
            this.cachedActivePath.transform(this.transform);
        } else {
            this.cachedActivePath.lineTo(this.trackLength, 0.0f);
        }
        this.activePathMeasure.setPath(this.cachedActivePath, false);
    }
}
