package com.exampletest.mobilestudiotest.engine;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: ClothingCompositor.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002\u001b\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u001e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u001d"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/ClothingCompositor;", "", "<init>", "()V", "TPL_W", "", "TPL_H", "TORSO_W", "TORSO_H", "LIMB_W", "LIMB_H", "PAD", "", "LEFT", "Lcom/exampletest/mobilestudiotest/engine/ClothingCompositor$Limb;", "getLEFT", "()Lcom/exampletest/mobilestudiotest/engine/ClothingCompositor$Limb;", "RIGHT", "getRIGHT", "drawTorso", "", "c", "Landroid/graphics/Canvas;", "tpl", "Landroid/graphics/Bitmap;", "drawLimb", "l", "Limb", "TplImage", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes7.dex */
public final class ClothingCompositor {
    public static final int LIMB_H = 284;
    public static final int LIMB_W = 264;
    private static final float PAD = 2.0f;
    public static final int TORSO_H = 272;
    public static final int TORSO_W = 388;
    public static final int TPL_H = 559;
    public static final int TPL_W = 585;
    public static final ClothingCompositor INSTANCE = new ClothingCompositor();
    private static final Limb LEFT = new Limb(308.0f, 374.0f, 440.0f, 506.0f, 308.0f, 308.0f);
    private static final Limb RIGHT = new Limb(217.0f, 19.0f, 85.0f, 151.0f, 217.0f, 217.0f);

    /* compiled from: ClothingCompositor.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000f\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003¢\u0006\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\f¨\u0006\u0012"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/ClothingCompositor$Limb;", "", "front", "", "left", "back", "right", "up", "down", "<init>", "(FFFFFF)V", "getFront", "()F", "getLeft", "getBack", "getRight", "getUp", "getDown", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    public static final class Limb {
        private final float back;
        private final float down;
        private final float front;
        private final float left;
        private final float right;
        private final float up;

        public Limb(float f, float f2, float f3, float f4, float f5, float f6) {
            this.front = f;
            this.left = f2;
            this.back = f3;
            this.right = f4;
            this.up = f5;
            this.down = f6;
        }

        public final float getBack() {
            return this.back;
        }

        public final float getDown() {
            return this.down;
        }

        public final float getFront() {
            return this.front;
        }

        public final float getLeft() {
            return this.left;
        }

        public final float getRight() {
            return this.right;
        }

        public final float getUp() {
            return this.up;
        }
    }

    /* compiled from: ClothingCompositor.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J>\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007J.\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0007J\u0086\u0001\u0010\u001e\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00072\u0006\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00020\u00072\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070%R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006)"}, d2 = {"Lcom/exampletest/mobilestudiotest/engine/ClothingCompositor$TplImage;", "", "src", "Landroid/graphics/Bitmap;", "<init>", "(Landroid/graphics/Bitmap;)V", "sx", "", "getSx", "()F", "sy", "getSy", "bmp", "getBmp", "()Landroid/graphics/Bitmap;", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "face", "", "c", "Landroid/graphics/Canvas;", "x", "y", "w", "h", "dx", "dy", "rotatedTop", "cap", "l", "t", "r", "b", "row", "top", "Lkotlin/Pair;", "right", "bottom", "left", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes7.dex */
    private static final class TplImage {
        private final Bitmap bmp;
        private final Paint paint;
        private final float sx;
        private final float sy;

        public TplImage(Bitmap src) {
            Intrinsics.checkNotNullParameter(src, "src");
            this.sx = src.getWidth() / 585.0f;
            this.sy = src.getHeight() / 559.0f;
            this.bmp = src;
            this.paint = new Paint(3);
        }

        private static final void cap$tri(float f, float f2, TplImage tplImage, float f3, Canvas canvas, float f4, float f5, float f6, float f7, float f8, float f9) {
            canvas.drawVertices(Canvas.VertexMode.TRIANGLES, 6, new float[]{f4, f5, f6, f7, f, f2}, 0, new float[]{tplImage.sx * f8, f3, tplImage.sx * f9, f3, tplImage.sx * ((f8 + f9) / ClothingCompositor.PAD), f3}, 0, null, 0, null, 0, 0, tplImage.paint);
        }

        public final void cap(Canvas c, float l, float t, float r, float b, float row, Pair<Float, Float> top, Pair<Float, Float> right, Pair<Float, Float> bottom, Pair<Float, Float> left) {
            Intrinsics.checkNotNullParameter(c, "c");
            Intrinsics.checkNotNullParameter(top, "top");
            Intrinsics.checkNotNullParameter(right, "right");
            Intrinsics.checkNotNullParameter(bottom, "bottom");
            Intrinsics.checkNotNullParameter(left, "left");
            this.paint.setShader(new BitmapShader(this.bmp, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
            float f = (l + r) / ClothingCompositor.PAD;
            float f2 = (t + b) / ClothingCompositor.PAD;
            float f3 = this.sy * row;
            cap$tri(f, f2, this, f3, c, l, t, r, t, top.getFirst().floatValue(), top.getSecond().floatValue());
            cap$tri(f, f2, this, f3, c, r, t, r, b, right.getFirst().floatValue(), right.getSecond().floatValue());
            cap$tri(f, f2, this, f3, c, r, b, l, b, bottom.getSecond().floatValue(), bottom.getFirst().floatValue());
            cap$tri(f, f2, this, f3, c, l, b, l, t, left.getSecond().floatValue(), left.getFirst().floatValue());
            this.paint.setShader(null);
        }

        public final void face(Canvas c, float x, float y, float w, float h, float dx, float dy) {
            Intrinsics.checkNotNullParameter(c, "c");
            int coerceIn = RangesKt.coerceIn((int) (this.sx * x), 0, this.bmp.getWidth() - 1);
            int coerceIn2 = RangesKt.coerceIn((int) (this.sy * y), 0, this.bmp.getHeight() - 1);
            int coerceIn3 = RangesKt.coerceIn((int) (this.sx * w), 1, this.bmp.getWidth() - coerceIn);
            int coerceIn4 = RangesKt.coerceIn((int) (this.sy * h), 1, this.bmp.getHeight() - coerceIn2);
            Bitmap createBitmap = Bitmap.createBitmap(this.bmp, coerceIn, coerceIn2, coerceIn3, coerceIn4);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            BitmapShader bitmapShader = new BitmapShader(createBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setScale(w / coerceIn3, h / coerceIn4);
            matrix.postTranslate(dx, dy);
            bitmapShader.setLocalMatrix(matrix);
            this.paint.setShader(bitmapShader);
            c.drawRect(new RectF(dx - ClothingCompositor.PAD, dy - ClothingCompositor.PAD, dx + w + ClothingCompositor.PAD, dy + h + ClothingCompositor.PAD), this.paint);
            this.paint.setShader(null);
        }

        public final Bitmap getBmp() {
            return this.bmp;
        }

        public final Paint getPaint() {
            return this.paint;
        }

        public final float getSx() {
            return this.sx;
        }

        public final float getSy() {
            return this.sy;
        }

        public final void rotatedTop(Canvas c, float x, float y, float dx, float dy) {
            Intrinsics.checkNotNullParameter(c, "c");
            int coerceIn = RangesKt.coerceIn((int) (this.sx * x), 0, this.bmp.getWidth() - 1);
            int coerceIn2 = RangesKt.coerceIn((int) (this.sy * y), 0, this.bmp.getHeight() - 1);
            int coerceIn3 = RangesKt.coerceIn((int) (this.sx * 64.0f), 1, this.bmp.getWidth() - coerceIn);
            int coerceIn4 = RangesKt.coerceIn((int) (this.sy * 64.0f), 1, this.bmp.getHeight() - coerceIn2);
            Bitmap createBitmap = Bitmap.createBitmap(this.bmp, coerceIn, coerceIn2, coerceIn3, coerceIn4);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(...)");
            BitmapShader bitmapShader = new BitmapShader(createBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            Matrix matrix = new Matrix();
            matrix.setPolyToPoly(new float[]{0.0f, 0.0f, coerceIn3, 0.0f, 0.0f, coerceIn4}, 0, new float[]{dx, dy + 64.0f, dx, dy, dx + 64.0f, dy + 64.0f}, 0, 3);
            bitmapShader.setLocalMatrix(matrix);
            this.paint.setShader(bitmapShader);
            c.drawRect(new RectF(dx - ClothingCompositor.PAD, dy - ClothingCompositor.PAD, dx + 64.0f + ClothingCompositor.PAD, dy + 64.0f + ClothingCompositor.PAD), this.paint);
            this.paint.setShader(null);
        }
    }

    private ClothingCompositor() {
    }

    public final void drawLimb(Canvas c, Bitmap tpl, Limb l) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(tpl, "tpl");
        Intrinsics.checkNotNullParameter(l, "l");
        TplImage tplImage = new TplImage(tpl);
        tplImage.face(c, l.getRight(), 355.0f, 64.0f, 112.0f, PAD, 66.0f);
        tplImage.face(c, l.getFront(), 355.0f, 64.0f, 112.0f, 66.0f, 66.0f);
        tplImage.face(c, l.getLeft(), 355.0f, 64.0f, 112.0f, 130.0f, 66.0f);
        tplImage.face(c, l.getBack(), 355.0f, 64.0f, 112.0f, 194.0f, 66.0f);
        tplImage.face(c, l.getRight(), 467.0f, 64.0f, 16.0f, PAD, 218.0f);
        tplImage.face(c, l.getFront(), 467.0f, 64.0f, 16.0f, 66.0f, 218.0f);
        tplImage.face(c, l.getLeft(), 467.0f, 64.0f, 16.0f, 130.0f, 218.0f);
        tplImage.face(c, l.getBack(), 467.0f, 64.0f, 16.0f, PAD, 238.0f);
        tplImage.face(c, l.getDown(), 485.0f, 64.0f, 64.0f, 198.0f, 218.0f);
        tplImage.rotatedTop(c, l.getUp(), 289.0f, PAD, PAD);
        tplImage.cap(c, PAD, 182.0f, 34.0f, 214.0f, 416.0f, TuplesKt.to(Float.valueOf(l.getBack() + 64.0f), Float.valueOf(l.getBack())), TuplesKt.to(Float.valueOf(l.getLeft() + 64.0f), Float.valueOf(l.getLeft())), TuplesKt.to(Float.valueOf(l.getFront()), Float.valueOf(l.getFront() + 64.0f)), TuplesKt.to(Float.valueOf(l.getRight()), Float.valueOf(l.getRight() + 64.0f)));
        tplImage.cap(c, 38.0f, 182.0f, 70.0f, 214.0f, 467.0f, TuplesKt.to(Float.valueOf(l.getFront()), Float.valueOf(l.getFront() + 64.0f)), TuplesKt.to(Float.valueOf(l.getLeft()), Float.valueOf(l.getLeft() + 64.0f)), TuplesKt.to(Float.valueOf(l.getBack() + 64.0f), Float.valueOf(l.getBack())), TuplesKt.to(Float.valueOf(l.getRight() + 64.0f), Float.valueOf(l.getRight())));
    }

    public final void drawTorso(Canvas c, Bitmap tpl) {
        Intrinsics.checkNotNullParameter(c, "c");
        Intrinsics.checkNotNullParameter(tpl, "tpl");
        TplImage tplImage = new TplImage(tpl);
        tplImage.face(c, 231.0f, 74.0f, 128.0f, 128.0f, PAD, 74.0f);
        tplImage.face(c, 361.0f, 74.0f, 64.0f, 128.0f, 130.0f, 74.0f);
        tplImage.face(c, 427.0f, 74.0f, 128.0f, 128.0f, 194.0f, 74.0f);
        tplImage.face(c, 165.0f, 74.0f, 64.0f, 128.0f, 322.0f, 74.0f);
        tplImage.face(c, 231.0f, 8.0f, 128.0f, 64.0f, PAD, 10.0f);
        tplImage.face(c, 231.0f, 204.0f, 128.0f, 64.0f, PAD, 202.0f);
        Float valueOf = Float.valueOf(555.0f);
        Float valueOf2 = Float.valueOf(427.0f);
        Pair<Float, Float> pair = TuplesKt.to(valueOf, valueOf2);
        Float valueOf3 = Float.valueOf(361.0f);
        Float valueOf4 = Float.valueOf(425.0f);
        Pair<Float, Float> pair2 = TuplesKt.to(valueOf3, valueOf4);
        Float valueOf5 = Float.valueOf(231.0f);
        Float valueOf6 = Float.valueOf(359.0f);
        Pair<Float, Float> pair3 = TuplesKt.to(valueOf5, valueOf6);
        Float valueOf7 = Float.valueOf(229.0f);
        Float valueOf8 = Float.valueOf(165.0f);
        tplImage.cap(c, 134.0f, 206.0f, 198.0f, 238.0f, 170.0f, pair, pair2, pair3, TuplesKt.to(valueOf7, valueOf8));
        tplImage.cap(c, 134.0f, 38.0f, 198.0f, 70.0f, 170.0f, TuplesKt.to(valueOf5, valueOf6), TuplesKt.to(valueOf3, valueOf4), TuplesKt.to(valueOf, valueOf2), TuplesKt.to(valueOf7, valueOf8));
    }

    public final Limb getLEFT() {
        return LEFT;
    }

    public final Limb getRIGHT() {
        return RIGHT;
    }
}
