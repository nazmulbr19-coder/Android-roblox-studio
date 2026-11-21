package com.google.android.material.shape;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.google.android.material.shadow.ShadowRenderer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class ShapePath {
    protected static final float ANGLE_LEFT = 180.0f;
    private static final float ANGLE_UP = 270.0f;
    private boolean containsIncompatibleShadowOp;

    @Deprecated
    public float currentShadowAngle;

    @Deprecated
    public float endShadowAngle;

    @Deprecated
    public float endX;

    @Deprecated
    public float endY;
    private final List<PathOperation> operations = new ArrayList();
    private final List<ShadowCompatOperation> shadowCompatOperations = new ArrayList();

    @Deprecated
    public float startX;

    @Deprecated
    public float startY;

    /* renamed from: com.google.android.material.shape.ShapePath$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ShadowCompatOperation {
        final /* synthetic */ List val$operations;
        final /* synthetic */ Matrix val$transformCopy;

        AnonymousClass1(List list, Matrix matrix) {
            this.val$operations = list;
            this.val$transformCopy = matrix;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            Iterator it = this.val$operations.iterator();
            while (it.hasNext()) {
                ((ShadowCompatOperation) it.next()).draw(this.val$transformCopy, shadowRenderer, i, canvas);
            }
        }
    }

    /* loaded from: classes.dex */
    static class ArcShadowOperation extends ShadowCompatOperation {
        private final PathArcOperation operation;

        public ArcShadowOperation(PathArcOperation pathArcOperation) {
            this.operation = pathArcOperation;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            shadowRenderer.drawCornerShadow(canvas, matrix, new RectF(PathArcOperation.access$1000(this.operation), PathArcOperation.access$1100(this.operation), PathArcOperation.access$1200(this.operation), PathArcOperation.access$1300(this.operation)), i, PathArcOperation.access$800(this.operation), PathArcOperation.access$900(this.operation));
        }
    }

    /* loaded from: classes.dex */
    static class InnerCornerShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation1;
        private final PathLineOperation operation2;
        private final float startX;
        private final float startY;

        public InnerCornerShadowOperation(PathLineOperation pathLineOperation, PathLineOperation pathLineOperation2, float f, float f2) {
            this.operation1 = pathLineOperation;
            this.operation2 = pathLineOperation2;
            this.startX = f;
            this.startY = f2;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            int i2;
            float sweepAngle = getSweepAngle();
            if (sweepAngle > 0.0f) {
                return;
            }
            double hypot = Math.hypot(PathLineOperation.access$000(this.operation1) - this.startX, PathLineOperation.access$100(this.operation1) - this.startY);
            double hypot2 = Math.hypot(PathLineOperation.access$000(this.operation2) - PathLineOperation.access$000(this.operation1), PathLineOperation.access$100(this.operation2) - PathLineOperation.access$100(this.operation1));
            float min = (float) Math.min(i, Math.min(hypot, hypot2));
            double tan = min * Math.tan(Math.toRadians((-sweepAngle) / 2.0f));
            if (hypot > tan) {
                RectF rectF = new RectF(0.0f, 0.0f, (float) (hypot - tan), 0.0f);
                this.renderMatrix.set(matrix);
                this.renderMatrix.preTranslate(this.startX, this.startY);
                this.renderMatrix.preRotate(getStartAngle());
                i2 = i;
                shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF, i2);
            } else {
                i2 = i;
            }
            RectF rectF2 = new RectF(0.0f, 0.0f, min * 2.0f, min * 2.0f);
            this.renderMatrix.set(matrix);
            this.renderMatrix.preTranslate(PathLineOperation.access$000(this.operation1), PathLineOperation.access$100(this.operation1));
            this.renderMatrix.preRotate(getStartAngle());
            this.renderMatrix.preTranslate((float) ((-tan) - min), (-2.0f) * min);
            shadowRenderer.drawInnerCornerShadow(canvas, this.renderMatrix, rectF2, (int) min, 450.0f, sweepAngle, new float[]{(float) (min + tan), min * 2.0f});
            if (hypot2 > tan) {
                RectF rectF3 = new RectF(0.0f, 0.0f, (float) (hypot2 - tan), 0.0f);
                this.renderMatrix.set(matrix);
                this.renderMatrix.preTranslate(PathLineOperation.access$000(this.operation1), PathLineOperation.access$100(this.operation1));
                this.renderMatrix.preRotate(getEndAngle());
                this.renderMatrix.preTranslate((float) tan, 0.0f);
                shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF3, i2);
            }
        }

        float getEndAngle() {
            return (float) Math.toDegrees(Math.atan((PathLineOperation.access$100(this.operation2) - PathLineOperation.access$100(this.operation1)) / (PathLineOperation.access$000(this.operation2) - PathLineOperation.access$000(this.operation1))));
        }

        float getStartAngle() {
            return (float) Math.toDegrees(Math.atan((PathLineOperation.access$100(this.operation1) - this.startY) / (PathLineOperation.access$000(this.operation1) - this.startX)));
        }

        float getSweepAngle() {
            float endAngle = ((getEndAngle() - getStartAngle()) + 360.0f) % 360.0f;
            return endAngle <= ShapePath.ANGLE_LEFT ? endAngle : endAngle - 360.0f;
        }
    }

    /* loaded from: classes.dex */
    static class LineShadowOperation extends ShadowCompatOperation {
        private final PathLineOperation operation;
        private final float startX;
        private final float startY;

        public LineShadowOperation(PathLineOperation pathLineOperation, float f, float f2) {
            this.operation = pathLineOperation;
            this.startX = f;
            this.startY = f2;
        }

        @Override // com.google.android.material.shape.ShapePath.ShadowCompatOperation
        public void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            RectF rectF = new RectF(0.0f, 0.0f, (float) Math.hypot(PathLineOperation.access$100(this.operation) - this.startY, PathLineOperation.access$000(this.operation) - this.startX), 0.0f);
            this.renderMatrix.set(matrix);
            this.renderMatrix.preTranslate(this.startX, this.startY);
            this.renderMatrix.preRotate(getAngle());
            shadowRenderer.drawEdgeShadow(canvas, this.renderMatrix, rectF, i);
        }

        float getAngle() {
            return (float) Math.toDegrees(Math.atan((PathLineOperation.access$100(this.operation) - this.startY) / (PathLineOperation.access$000(this.operation) - this.startX)));
        }
    }

    /* loaded from: classes.dex */
    public static class PathArcOperation extends PathOperation {
        private static final RectF rectF = new RectF();

        @Deprecated
        public float bottom;

        @Deprecated
        public float left;

        @Deprecated
        public float right;

        @Deprecated
        public float startAngle;

        @Deprecated
        public float sweepAngle;

        @Deprecated
        public float top;

        public PathArcOperation(float f, float f2, float f3, float f4) {
            setLeft(f);
            setTop(f2);
            setRight(f3);
            setBottom(f4);
        }

        static /* synthetic */ float access$1000(PathArcOperation pathArcOperation) {
            return pathArcOperation.getLeft();
        }

        static /* synthetic */ float access$1100(PathArcOperation pathArcOperation) {
            return pathArcOperation.getTop();
        }

        static /* synthetic */ float access$1200(PathArcOperation pathArcOperation) {
            return pathArcOperation.getRight();
        }

        static /* synthetic */ float access$1300(PathArcOperation pathArcOperation) {
            return pathArcOperation.getBottom();
        }

        static /* synthetic */ void access$600(PathArcOperation pathArcOperation, float f) {
            pathArcOperation.setStartAngle(f);
        }

        static /* synthetic */ void access$700(PathArcOperation pathArcOperation, float f) {
            pathArcOperation.setSweepAngle(f);
        }

        static /* synthetic */ float access$800(PathArcOperation pathArcOperation) {
            return pathArcOperation.getStartAngle();
        }

        static /* synthetic */ float access$900(PathArcOperation pathArcOperation) {
            return pathArcOperation.getSweepAngle();
        }

        private float getBottom() {
            return this.bottom;
        }

        private float getLeft() {
            return this.left;
        }

        private float getRight() {
            return this.right;
        }

        private float getStartAngle() {
            return this.startAngle;
        }

        private float getSweepAngle() {
            return this.sweepAngle;
        }

        private float getTop() {
            return this.top;
        }

        private void setBottom(float f) {
            this.bottom = f;
        }

        private void setLeft(float f) {
            this.left = f;
        }

        private void setRight(float f) {
            this.right = f;
        }

        private void setStartAngle(float f) {
            this.startAngle = f;
        }

        private void setSweepAngle(float f) {
            this.sweepAngle = f;
        }

        private void setTop(float f) {
            this.top = f;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            rectF.set(getLeft(), getTop(), getRight(), getBottom());
            path.arcTo(rectF, getStartAngle(), getSweepAngle(), false);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static class PathCubicOperation extends PathOperation {
        private float controlX1;
        private float controlX2;
        private float controlY1;
        private float controlY2;
        private float endX;
        private float endY;

        public PathCubicOperation(float f, float f2, float f3, float f4, float f5, float f6) {
            setControlX1(f);
            setControlY1(f2);
            setControlX2(f3);
            setControlY2(f4);
            setEndX(f5);
            setEndY(f6);
        }

        private float getControlX1() {
            return this.controlX1;
        }

        private float getControlX2() {
            return this.controlX2;
        }

        private float getControlY1() {
            return this.controlY1;
        }

        private float getControlY2() {
            return this.controlY1;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX1(float f) {
            this.controlX1 = f;
        }

        private void setControlX2(float f) {
            this.controlX2 = f;
        }

        private void setControlY1(float f) {
            this.controlY1 = f;
        }

        private void setControlY2(float f) {
            this.controlY2 = f;
        }

        private void setEndX(float f) {
            this.endX = f;
        }

        private void setEndY(float f) {
            this.endY = f;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.cubicTo(this.controlX1, this.controlY1, this.controlX2, this.controlY2, this.endX, this.endY);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static class PathLineOperation extends PathOperation {
        private float x;
        private float y;

        static /* synthetic */ float access$000(PathLineOperation pathLineOperation) {
            return pathLineOperation.x;
        }

        static /* synthetic */ float access$002(PathLineOperation pathLineOperation, float f) {
            pathLineOperation.x = f;
            return f;
        }

        static /* synthetic */ float access$100(PathLineOperation pathLineOperation) {
            return pathLineOperation.y;
        }

        static /* synthetic */ float access$102(PathLineOperation pathLineOperation, float f) {
            pathLineOperation.y = f;
            return f;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.lineTo(this.x, this.y);
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    public static abstract class PathOperation {
        protected final Matrix matrix = new Matrix();

        public abstract void applyToPath(Matrix matrix, Path path);
    }

    /* loaded from: classes.dex */
    public static class PathQuadOperation extends PathOperation {

        @Deprecated
        public float controlX;

        @Deprecated
        public float controlY;

        @Deprecated
        public float endX;

        @Deprecated
        public float endY;

        static /* synthetic */ void access$200(PathQuadOperation pathQuadOperation, float f) {
            pathQuadOperation.setControlX(f);
        }

        static /* synthetic */ void access$300(PathQuadOperation pathQuadOperation, float f) {
            pathQuadOperation.setControlY(f);
        }

        static /* synthetic */ void access$400(PathQuadOperation pathQuadOperation, float f) {
            pathQuadOperation.setEndX(f);
        }

        static /* synthetic */ void access$500(PathQuadOperation pathQuadOperation, float f) {
            pathQuadOperation.setEndY(f);
        }

        private float getControlX() {
            return this.controlX;
        }

        private float getControlY() {
            return this.controlY;
        }

        private float getEndX() {
            return this.endX;
        }

        private float getEndY() {
            return this.endY;
        }

        private void setControlX(float f) {
            this.controlX = f;
        }

        private void setControlY(float f) {
            this.controlY = f;
        }

        private void setEndX(float f) {
            this.endX = f;
        }

        private void setEndY(float f) {
            this.endY = f;
        }

        @Override // com.google.android.material.shape.ShapePath.PathOperation
        public void applyToPath(Matrix matrix, Path path) {
            Matrix matrix2 = this.matrix;
            matrix.invert(matrix2);
            path.transform(matrix2);
            path.quadTo(getControlX(), getControlY(), getEndX(), getEndY());
            path.transform(matrix);
        }
    }

    /* loaded from: classes.dex */
    static abstract class ShadowCompatOperation {
        static final Matrix IDENTITY_MATRIX = new Matrix();
        final Matrix renderMatrix = new Matrix();

        ShadowCompatOperation() {
        }

        public abstract void draw(Matrix matrix, ShadowRenderer shadowRenderer, int i, Canvas canvas);

        public final void draw(ShadowRenderer shadowRenderer, int i, Canvas canvas) {
            draw(IDENTITY_MATRIX, shadowRenderer, i, canvas);
        }
    }

    public ShapePath() {
        reset(0.0f, 0.0f);
    }

    public ShapePath(float f, float f2) {
        reset(f, f2);
    }

    private void addConnectingShadowIfNecessary(float f) {
        if (getCurrentShadowAngle() == f) {
            return;
        }
        float currentShadowAngle = ((f - getCurrentShadowAngle()) + 360.0f) % 360.0f;
        if (currentShadowAngle > ANGLE_LEFT) {
            return;
        }
        PathArcOperation pathArcOperation = new PathArcOperation(getEndX(), getEndY(), getEndX(), getEndY());
        PathArcOperation.access$600(pathArcOperation, getCurrentShadowAngle());
        PathArcOperation.access$700(pathArcOperation, currentShadowAngle);
        this.shadowCompatOperations.add(new ArcShadowOperation(pathArcOperation));
        setCurrentShadowAngle(f);
    }

    private void addShadowCompatOperation(ShadowCompatOperation shadowCompatOperation, float f, float f2) {
        addConnectingShadowIfNecessary(f);
        this.shadowCompatOperations.add(shadowCompatOperation);
        setCurrentShadowAngle(f2);
    }

    private float getCurrentShadowAngle() {
        return this.currentShadowAngle;
    }

    private float getEndShadowAngle() {
        return this.endShadowAngle;
    }

    private void setCurrentShadowAngle(float f) {
        this.currentShadowAngle = f;
    }

    private void setEndShadowAngle(float f) {
        this.endShadowAngle = f;
    }

    private void setEndX(float f) {
        this.endX = f;
    }

    private void setEndY(float f) {
        this.endY = f;
    }

    private void setStartX(float f) {
        this.startX = f;
    }

    private void setStartY(float f) {
        this.startY = f;
    }

    public void addArc(float f, float f2, float f3, float f4, float f5, float f6) {
        PathArcOperation pathArcOperation = new PathArcOperation(f, f2, f3, f4);
        PathArcOperation.access$600(pathArcOperation, f5);
        PathArcOperation.access$700(pathArcOperation, f6);
        this.operations.add(pathArcOperation);
        ArcShadowOperation arcShadowOperation = new ArcShadowOperation(pathArcOperation);
        float f7 = f5 + f6;
        boolean z = f6 < 0.0f;
        addShadowCompatOperation(arcShadowOperation, z ? (f5 + ANGLE_LEFT) % 360.0f : f5, z ? (ANGLE_LEFT + f7) % 360.0f : f7);
        setEndX(((f + f3) * 0.5f) + (((f3 - f) / 2.0f) * ((float) Math.cos(Math.toRadians(f5 + f6)))));
        setEndY(((f2 + f4) * 0.5f) + (((f4 - f2) / 2.0f) * ((float) Math.sin(Math.toRadians(f5 + f6)))));
    }

    public void applyToPath(Matrix matrix, Path path) {
        int size = this.operations.size();
        for (int i = 0; i < size; i++) {
            this.operations.get(i).applyToPath(matrix, path);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean containsIncompatibleShadowOp() {
        return this.containsIncompatibleShadowOp;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ShadowCompatOperation createShadowCompatOperation(Matrix matrix) {
        addConnectingShadowIfNecessary(getEndShadowAngle());
        return new AnonymousClass1(new ArrayList(this.shadowCompatOperations), new Matrix(matrix));
    }

    public void cubicToPoint(float f, float f2, float f3, float f4, float f5, float f6) {
        this.operations.add(new PathCubicOperation(f, f2, f3, f4, f5, f6));
        this.containsIncompatibleShadowOp = true;
        setEndX(f5);
        setEndY(f6);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getEndX() {
        return this.endX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getEndY() {
        return this.endY;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getStartX() {
        return this.startX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getStartY() {
        return this.startY;
    }

    public void lineTo(float f, float f2) {
        PathLineOperation pathLineOperation = new PathLineOperation();
        PathLineOperation.access$002(pathLineOperation, f);
        PathLineOperation.access$102(pathLineOperation, f2);
        this.operations.add(pathLineOperation);
        LineShadowOperation lineShadowOperation = new LineShadowOperation(pathLineOperation, getEndX(), getEndY());
        addShadowCompatOperation(lineShadowOperation, lineShadowOperation.getAngle() + ANGLE_UP, lineShadowOperation.getAngle() + ANGLE_UP);
        setEndX(f);
        setEndY(f2);
    }

    public void lineTo(float f, float f2, float f3, float f4) {
        if ((Math.abs(f - getEndX()) < 0.001f && Math.abs(f2 - getEndY()) < 0.001f) || (Math.abs(f - f3) < 0.001f && Math.abs(f2 - f4) < 0.001f)) {
            lineTo(f3, f4);
            return;
        }
        PathLineOperation pathLineOperation = new PathLineOperation();
        PathLineOperation.access$002(pathLineOperation, f);
        PathLineOperation.access$102(pathLineOperation, f2);
        this.operations.add(pathLineOperation);
        PathLineOperation pathLineOperation2 = new PathLineOperation();
        PathLineOperation.access$002(pathLineOperation2, f3);
        PathLineOperation.access$102(pathLineOperation2, f4);
        this.operations.add(pathLineOperation2);
        InnerCornerShadowOperation innerCornerShadowOperation = new InnerCornerShadowOperation(pathLineOperation, pathLineOperation2, getEndX(), getEndY());
        if (innerCornerShadowOperation.getSweepAngle() > 0.0f) {
            lineTo(f, f2);
            lineTo(f3, f4);
        } else {
            addShadowCompatOperation(innerCornerShadowOperation, innerCornerShadowOperation.getStartAngle() + ANGLE_UP, innerCornerShadowOperation.getEndAngle() + ANGLE_UP);
            setEndX(f3);
            setEndY(f4);
        }
    }

    public void quadToPoint(float f, float f2, float f3, float f4) {
        PathQuadOperation pathQuadOperation = new PathQuadOperation();
        PathQuadOperation.access$200(pathQuadOperation, f);
        PathQuadOperation.access$300(pathQuadOperation, f2);
        PathQuadOperation.access$400(pathQuadOperation, f3);
        PathQuadOperation.access$500(pathQuadOperation, f4);
        this.operations.add(pathQuadOperation);
        this.containsIncompatibleShadowOp = true;
        setEndX(f3);
        setEndY(f4);
    }

    public void reset(float f, float f2) {
        reset(f, f2, ANGLE_UP, 0.0f);
    }

    public void reset(float f, float f2, float f3, float f4) {
        setStartX(f);
        setStartY(f2);
        setEndX(f);
        setEndY(f2);
        setCurrentShadowAngle(f3);
        setEndShadowAngle((f3 + f4) % 360.0f);
        this.operations.clear();
        this.shadowCompatOperations.clear();
        this.containsIncompatibleShadowOp = false;
    }
}
