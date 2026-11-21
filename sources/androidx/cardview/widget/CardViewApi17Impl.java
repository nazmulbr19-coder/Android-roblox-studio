package androidx.cardview.widget;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.cardview.widget.RoundRectDrawableWithShadow;

/* loaded from: classes.dex */
class CardViewApi17Impl extends CardViewBaseImpl {

    /* renamed from: androidx.cardview.widget.CardViewApi17Impl$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements RoundRectDrawableWithShadow.RoundRectHelper {
        AnonymousClass1() {
        }

        @Override // androidx.cardview.widget.RoundRectDrawableWithShadow.RoundRectHelper
        public void drawRoundRect(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    CardViewApi17Impl() {
    }

    @Override // androidx.cardview.widget.CardViewBaseImpl, androidx.cardview.widget.CardViewImpl
    public void initStatic() {
        RoundRectDrawableWithShadow.sRoundRectHelper = new AnonymousClass1();
    }
}
