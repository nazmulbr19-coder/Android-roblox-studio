package com.google.android.material.loadingindicator;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import androidx.graphics.shapes.Morph;
import androidx.graphics.shapes.RoundedPolygon;
import androidx.graphics.shapes.Shapes_androidKt;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.math.MathUtils;
import com.google.android.material.shape.MaterialShapes;

/* loaded from: classes.dex */
class LoadingIndicatorDrawingDelegate {
    final Path indicatorPath = new Path();
    final Matrix indicatorPathTransform = new Matrix();
    LoadingIndicatorSpec specs;
    private static final RoundedPolygon[] INDETERMINATE_SHAPES = {MaterialShapes.normalize(MaterialShapes.SOFT_BURST, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.COOKIE_9, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.PENTAGON, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.PILL, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.SUNNY, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.COOKIE_4, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f)), MaterialShapes.normalize(MaterialShapes.OVAL, true, new RectF(-1.0f, -1.0f, 1.0f, 1.0f))};
    private static final Morph[] INDETERMINATE_MORPH_SEQUENCE = new Morph[INDETERMINATE_SHAPES.length];

    /* loaded from: classes.dex */
    protected static class IndicatorState {
        int color;
        float morphFraction;
        float rotationDegree;
    }

    static {
        for (int i = 0; i < INDETERMINATE_SHAPES.length; i++) {
            INDETERMINATE_MORPH_SEQUENCE[i] = new Morph(INDETERMINATE_SHAPES[i], INDETERMINATE_SHAPES[(i + 1) % INDETERMINATE_SHAPES.length]);
        }
    }

    public LoadingIndicatorDrawingDelegate(LoadingIndicatorSpec loadingIndicatorSpec) {
        this.specs = loadingIndicatorSpec;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void adjustCanvas(Canvas canvas, Rect rect) {
        canvas.translate(rect.centerX(), rect.centerY());
        if (this.specs.scaleToFit) {
            float min = Math.min(rect.width() / getPreferredWidth(), rect.height() / getPreferredHeight());
            canvas.scale(min, min);
        }
        canvas.clipRect((-getPreferredWidth()) / 2.0f, (-getPreferredHeight()) / 2.0f, getPreferredWidth() / 2.0f, getPreferredHeight() / 2.0f);
        canvas.rotate(-90.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawContainer(Canvas canvas, Paint paint, int i, int i2) {
        float min = Math.min(this.specs.containerWidth, this.specs.containerHeight) / 2.0f;
        paint.setColor(MaterialColors.compositeARGBWithAlpha(i, i2));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawRoundRect(new RectF((-this.specs.containerWidth) / 2.0f, (-this.specs.containerHeight) / 2.0f, this.specs.containerWidth / 2.0f, this.specs.containerHeight / 2.0f), min, min, paint);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void drawIndicator(Canvas canvas, Paint paint, IndicatorState indicatorState, int i) {
        paint.setColor(MaterialColors.compositeARGBWithAlpha(indicatorState.color, i));
        paint.setStyle(Paint.Style.FILL);
        canvas.save();
        canvas.rotate(indicatorState.rotationDegree);
        this.indicatorPath.rewind();
        int floor = (int) Math.floor(indicatorState.morphFraction);
        Shapes_androidKt.toPath(INDETERMINATE_MORPH_SEQUENCE[MathUtils.floorMod(floor, INDETERMINATE_MORPH_SEQUENCE.length)], indicatorState.morphFraction - floor, this.indicatorPath);
        this.indicatorPathTransform.setScale(this.specs.indicatorSize / 2.0f, this.specs.indicatorSize / 2.0f);
        this.indicatorPath.transform(this.indicatorPathTransform);
        canvas.drawPath(this.indicatorPath, paint);
        canvas.restore();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPreferredHeight() {
        return Math.max(this.specs.containerWidth, this.specs.indicatorSize);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPreferredWidth() {
        return Math.max(this.specs.containerHeight, this.specs.indicatorSize);
    }
}
