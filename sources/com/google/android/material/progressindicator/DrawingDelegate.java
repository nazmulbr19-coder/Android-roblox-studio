package com.google.android.material.progressindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.Rect;
import com.google.android.material.progressindicator.BaseProgressIndicatorSpec;
import java.util.Arrays;

/* loaded from: classes.dex */
abstract class DrawingDelegate<S extends BaseProgressIndicatorSpec> {
    static final float WAVE_SMOOTHNESS = 0.48f;
    S spec;
    final Path cachedActivePath = new Path();
    final Path displayedActivePath = new Path();
    final PathMeasure activePathMeasure = new PathMeasure(this.cachedActivePath, false);
    final Matrix transform = new Matrix();

    /* loaded from: classes.dex */
    protected static class ActiveIndicator {
        float amplitudeFraction = 1.0f;
        int color;
        float endFraction;
        int gapSize;
        boolean isDeterminate;
        float phaseFraction;
        float rotationDegree;
        float startFraction;
    }

    /* loaded from: classes.dex */
    protected class PathPoint {
        float[] posVec;
        float[] tanVec;
        final Matrix transform;

        public PathPoint() {
            this.posVec = new float[2];
            this.tanVec = new float[2];
            this.tanVec[0] = 1.0f;
            this.transform = new Matrix();
        }

        public PathPoint(DrawingDelegate drawingDelegate, DrawingDelegate<S>.PathPoint pathPoint) {
            this(pathPoint.posVec, pathPoint.tanVec);
        }

        public PathPoint(float[] fArr, float[] fArr2) {
            this.posVec = new float[2];
            this.tanVec = new float[2];
            System.arraycopy(fArr, 0, this.posVec, 0, 2);
            System.arraycopy(fArr2, 0, this.tanVec, 0, 2);
            this.transform = new Matrix();
        }

        float distance(DrawingDelegate<S>.PathPoint pathPoint) {
            return (float) Math.hypot(pathPoint.posVec[0] - this.posVec[0], pathPoint.posVec[1] - this.posVec[1]);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void moveAcross(float f) {
            float atan2 = (float) (Math.atan2(this.tanVec[1], this.tanVec[0]) + 1.5707963267948966d);
            this.posVec[0] = (float) (this.posVec[0] + (f * Math.cos(atan2)));
            this.posVec[1] = (float) (this.posVec[1] + (f * Math.sin(atan2)));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void moveAlong(float f) {
            float atan2 = (float) Math.atan2(this.tanVec[1], this.tanVec[0]);
            this.posVec[0] = (float) (this.posVec[0] + (f * Math.cos(atan2)));
            this.posVec[1] = (float) (this.posVec[1] + (f * Math.sin(atan2)));
        }

        public void reset() {
            Arrays.fill(this.posVec, 0.0f);
            Arrays.fill(this.tanVec, 0.0f);
            this.tanVec[0] = 1.0f;
            this.transform.reset();
        }

        public void rotate(float f) {
            this.transform.reset();
            this.transform.setRotate(f);
            this.transform.mapPoints(this.posVec);
            this.transform.mapPoints(this.tanVec);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void scale(float f, float f2) {
            float[] fArr = this.posVec;
            fArr[0] = fArr[0] * f;
            float[] fArr2 = this.posVec;
            fArr2[1] = fArr2[1] * f2;
            float[] fArr3 = this.tanVec;
            fArr3[0] = fArr3[0] * f;
            float[] fArr4 = this.tanVec;
            fArr4[1] = fArr4[1] * f2;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void translate(float f, float f2) {
            float[] fArr = this.posVec;
            fArr[0] = fArr[0] + f;
            float[] fArr2 = this.posVec;
            fArr2[1] = fArr2[1] + f2;
        }
    }

    public DrawingDelegate(S s) {
        this.spec = s;
    }

    abstract void adjustCanvas(Canvas canvas, Rect rect, float f, boolean z, boolean z2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void drawStopIndicator(Canvas canvas, Paint paint, int i, int i2);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void fillIndicator(Canvas canvas, Paint paint, ActiveIndicator activeIndicator, int i);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void fillTrack(Canvas canvas, Paint paint, float f, float f2, int i, int i2, int i3);

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getPreferredHeight();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract int getPreferredWidth();

    /* JADX INFO: Access modifiers changed from: package-private */
    public abstract void invalidateCachedPaths();

    /* JADX INFO: Access modifiers changed from: package-private */
    public void validateSpecAndAdjustCanvas(Canvas canvas, Rect rect, float f, boolean z, boolean z2) {
        this.spec.validateSpec();
        adjustCanvas(canvas, rect, f, z, z2);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float vectorToCanvasRotation(float[] fArr) {
        return (float) Math.toDegrees(Math.atan2(fArr[1], fArr[0]));
    }
}
