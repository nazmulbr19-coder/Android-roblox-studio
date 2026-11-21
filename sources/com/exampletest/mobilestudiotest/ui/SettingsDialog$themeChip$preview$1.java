package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.exampletest.mobilestudiotest.core.Theme;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SettingsDialog.kt */
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/exampletest/mobilestudiotest/ui/SettingsDialog$themeChip$preview$1", "Landroid/view/View;", "onDraw", "", "c", "Landroid/graphics/Canvas;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsDialog$themeChip$preview$1 extends View {
    final /* synthetic */ Theme $t;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsDialog$themeChip$preview$1(Context context, Theme theme) {
        super(context);
        this.$t = theme;
    }

    @Override // android.view.View
    protected void onDraw(Canvas c) {
        Intrinsics.checkNotNullParameter(c, "c");
        Paint paint = new Paint(1);
        float width = getWidth();
        float height = getHeight();
        float f = getResources().getDisplayMetrics().density * 4.0f;
        paint.setColor(this.$t.getBg());
        c.drawRoundRect(0.0f, 0.0f, width, height, f, f, paint);
        paint.setColor(this.$t.getTopbar());
        c.drawRect(0.0f, 0.0f, width, height * 0.18f, paint);
        paint.setColor(this.$t.getPanel());
        c.drawRect(0.68f * width, height * 0.18f, width, height, paint);
        paint.setColor(this.$t.getSelect());
        c.drawRect(width * 0.7f, 0.36f * height, 0.98f * width, 0.48f * height, paint);
        paint.setColor(this.$t.getText());
        c.drawRect(width * 0.72f, 0.58f * height, 0.94f * width, 0.62f * height, paint);
        c.drawRect(width * 0.72f, height * 0.7f, 0.88f * width, 0.74f * height, paint);
        paint.setColor(this.$t.getAccent());
        c.drawRect(0.06f * width, 0.05f * height, 0.2f * width, 0.13f * height, paint);
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(this.$t.getBorder());
        paint.setStrokeWidth(1.0f);
        c.drawRoundRect(0.5f, 0.5f, width - 0.5f, height - 0.5f, f, f, paint);
    }
}
