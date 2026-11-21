package com.exampletest.mobilestudiotest.ui;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.ViewCompat;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioBrowser.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0003J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0012\u0010\u0013\u001a\u00020\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0012H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/PlayGlyph;", "Landroid/graphics/drawable/Drawable;", "playing", "", "loading", "<init>", "(ZZ)V", "p", "Landroid/graphics/Paint;", "set", "", "play", "load", "draw", "c", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "getOpacity", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class PlayGlyph extends Drawable {
    private boolean loading;
    private final Paint p;
    private boolean playing;

    public PlayGlyph(boolean z, boolean z2) {
        this.playing = z;
        this.loading = z2;
        this.p = new Paint(1);
    }

    public /* synthetic */ PlayGlyph(boolean z, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(z, (i & 2) != 0 ? false : z2);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas c) {
        int accent;
        Intrinsics.checkNotNullParameter(c, "c");
        Rect bounds = getBounds();
        Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
        float min = Math.min(bounds.width(), bounds.height()) / 2.0f;
        float exactCenterX = bounds.exactCenterX();
        float exactCenterY = bounds.exactCenterY();
        this.p.setStyle(Paint.Style.FILL);
        Paint paint = this.p;
        int i = -1;
        if (this.playing || this.loading) {
            accent = Ui.INSTANCE.getACCENT();
        } else {
            accent = Ui.INSTANCE.blend(Ui.INSTANCE.getPANEL(), Ui.INSTANCE.getLIGHT() ? ViewCompat.MEASURED_STATE_MASK : -1, 0.14f);
        }
        paint.setColor(accent);
        c.drawCircle(exactCenterX, exactCenterY, min, this.p);
        Paint paint2 = this.p;
        if (!this.playing && !this.loading && Ui.INSTANCE.getLIGHT()) {
            i = -14540254;
        }
        paint2.setColor(i);
        if (this.loading) {
            this.p.setStyle(Paint.Style.STROKE);
            this.p.setStrokeWidth(0.16f * min);
            c.drawArc(exactCenterX - (min * 0.45f), exactCenterY - (min * 0.45f), (min * 0.45f) + exactCenterX, (0.45f * min) + exactCenterY, 0.0f, 270.0f, false, this.p);
        } else {
            if (this.playing) {
                float f = min * 0.34f;
                float f2 = min * 0.22f;
                c.drawRect(exactCenterX - f, exactCenterY - f, (exactCenterX - f) + f2, exactCenterY + f, this.p);
                c.drawRect((exactCenterX + f) - f2, exactCenterY - f, exactCenterX + f, exactCenterY + f, this.p);
                return;
            }
            float f3 = 0.42f * min;
            Path path = new Path();
            path.moveTo(exactCenterX - (f3 * 0.6f), exactCenterY - f3);
            path.lineTo(exactCenterX + f3, exactCenterY);
            path.lineTo(exactCenterX - (0.6f * f3), exactCenterY + f3);
            path.close();
            c.drawPath(path, this.p);
        }
    }

    @Override // android.graphics.drawable.Drawable
    @Deprecated(message = "Deprecated in Java")
    public int getOpacity() {
        return -3;
    }

    public final void set(boolean play, boolean load) {
        this.playing = play;
        this.loading = load;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int alpha) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter cf) {
    }
}
