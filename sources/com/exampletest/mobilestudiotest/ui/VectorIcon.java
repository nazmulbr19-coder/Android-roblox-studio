package com.exampletest.mobilestudiotest.ui;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BuiltinIcons.kt */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B \u0012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\nH\u0016J\u0012\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0017J\b\u0010\u0016\u001a\u00020\nH\u0016J\b\u0010\u0017\u001a\u00020\nH\u0016R\u001f\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/VectorIcon;", "Landroid/graphics/drawable/Drawable;", "painter", "Lkotlin/Function1;", "Lcom/exampletest/mobilestudiotest/ui/IconPainter;", "", "Lkotlin/ExtensionFunctionType;", "<init>", "(Lkotlin/jvm/functions/Function1;)V", "alphaV", "", "bmpPaint", "Landroid/graphics/Paint;", "draw", "c", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "getOpacity", "getIntrinsicWidth", "getIntrinsicHeight", "Companion", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VectorIcon extends Drawable {
    private static final VectorIcon$Companion$cache$1 cache = new VectorIcon$Companion$cache$1();
    private int alphaV;
    private final Paint bmpPaint;
    private final Function1<IconPainter, Unit> painter;

    /* JADX WARN: Multi-variable type inference failed */
    public VectorIcon(Function1<? super IconPainter, Unit> painter) {
        Intrinsics.checkNotNullParameter(painter, "painter");
        this.painter = painter;
        this.alphaV = 255;
        this.bmpPaint = new Paint(2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas c) {
        Bitmap bitmap;
        Intrinsics.checkNotNullParameter(c, "c");
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        int width = bounds.width();
        int height = bounds.height();
        if (width <= 0 || height <= 0) {
            return;
        }
        String str = System.identityHashCode(this.painter) + ":" + width + ":" + height + ":" + Ui.INSTANCE.getTEXT() + ":" + Ui.INSTANCE.getPANEL() + ":" + Ui.INSTANCE.getDIM();
        synchronized (cache) {
            bitmap = cache.get(str);
        }
        if (bitmap == null) {
            bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            Intrinsics.checkNotNullExpressionValue(bitmap, "createBitmap(...)");
            Canvas canvas = new Canvas(bitmap);
            float min = Math.min(width, height) / 24.0f;
            canvas.translate((width - (min * 24.0f)) / 2.0f, (height - (24.0f * min)) / 2.0f);
            canvas.scale(min, min);
            this.painter.invoke(new IconPainter(canvas));
            synchronized (cache) {
                cache.put(str, bitmap);
            }
        }
        this.bmpPaint.setAlpha(this.alphaV);
        c.drawBitmap(bitmap, bounds.left, bounds.top, this.bmpPaint);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return 48;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return 48;
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
        this.alphaV = alpha;
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }
}
