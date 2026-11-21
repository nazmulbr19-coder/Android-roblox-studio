package com.google.android.material.textfield;

import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;

/* loaded from: classes.dex */
class CutoutDrawable extends MaterialShapeDrawable {
    CutoutDrawableState drawableState;

    /* loaded from: classes.dex */
    private static final class CutoutDrawableState extends MaterialShapeDrawable.MaterialShapeDrawableState {
        private final RectF cutoutBounds;

        private CutoutDrawableState(ShapeAppearanceModel shapeAppearanceModel, RectF rectF) {
            super(shapeAppearanceModel, null);
            this.cutoutBounds = rectF;
        }

        /* synthetic */ CutoutDrawableState(ShapeAppearanceModel shapeAppearanceModel, RectF rectF, AnonymousClass1 anonymousClass1) {
            this(shapeAppearanceModel, rectF);
        }

        private CutoutDrawableState(CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState);
            this.cutoutBounds = cutoutDrawableState.cutoutBounds;
        }

        /* synthetic */ CutoutDrawableState(CutoutDrawableState cutoutDrawableState, AnonymousClass1 anonymousClass1) {
            this(cutoutDrawableState);
        }

        static /* synthetic */ RectF access$200(CutoutDrawableState cutoutDrawableState) {
            return cutoutDrawableState.cutoutBounds;
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable.MaterialShapeDrawableState, android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            CutoutDrawable access$400 = CutoutDrawable.access$400(this);
            access$400.invalidateSelf();
            return access$400;
        }
    }

    /* loaded from: classes.dex */
    private static class ImplApi18 extends CutoutDrawable {
        ImplApi18(CutoutDrawableState cutoutDrawableState) {
            super(cutoutDrawableState, null);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.android.material.shape.MaterialShapeDrawable
        public void drawStrokeShape(Canvas canvas) {
            if (CutoutDrawableState.access$200(this.drawableState).isEmpty()) {
                super.drawStrokeShape(canvas);
                return;
            }
            canvas.save();
            if (Build.VERSION.SDK_INT >= 26) {
                canvas.clipOutRect(CutoutDrawableState.access$200(this.drawableState));
            } else {
                canvas.clipRect(CutoutDrawableState.access$200(this.drawableState), Region.Op.DIFFERENCE);
            }
            super.drawStrokeShape(canvas);
            canvas.restore();
        }
    }

    private CutoutDrawable(CutoutDrawableState cutoutDrawableState) {
        super(cutoutDrawableState);
        this.drawableState = cutoutDrawableState;
    }

    /* synthetic */ CutoutDrawable(CutoutDrawableState cutoutDrawableState, AnonymousClass1 anonymousClass1) {
        this(cutoutDrawableState);
    }

    static /* synthetic */ CutoutDrawable access$400(CutoutDrawableState cutoutDrawableState) {
        return create(cutoutDrawableState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static CutoutDrawable create(ShapeAppearanceModel shapeAppearanceModel) {
        return create(new CutoutDrawableState(shapeAppearanceModel != null ? shapeAppearanceModel : new ShapeAppearanceModel(), new RectF(), null));
    }

    private static CutoutDrawable create(CutoutDrawableState cutoutDrawableState) {
        return new ImplApi18(cutoutDrawableState);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasCutout() {
        return !CutoutDrawableState.access$200(this.drawableState).isEmpty();
    }

    @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.drawableState = new CutoutDrawableState(this.drawableState, (AnonymousClass1) null);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void removeCutout() {
        setCutout(0.0f, 0.0f, 0.0f, 0.0f);
    }

    void setCutout(float f, float f2, float f3, float f4) {
        if (f == CutoutDrawableState.access$200(this.drawableState).left && f2 == CutoutDrawableState.access$200(this.drawableState).top && f3 == CutoutDrawableState.access$200(this.drawableState).right && f4 == CutoutDrawableState.access$200(this.drawableState).bottom) {
            return;
        }
        CutoutDrawableState.access$200(this.drawableState).set(f, f2, f3, f4);
        invalidateSelf();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCutout(RectF rectF) {
        setCutout(rectF.left, rectF.top, rectF.right, rectF.bottom);
    }
}
