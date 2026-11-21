package com.exampletest.mobilestudiotest.ui;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.exampletest.mobilestudiotest.core.Theme;
import com.exampletest.mobilestudiotest.model.Instance;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Ui.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0002vwB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u00106\u001a\u0002072\u0006\u00108\u001a\u00020-J\u000e\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020\u0005J\u001e\u0010>\u001a\u00020\u00052\u0006\u0010?\u001a\u00020\u00052\u0006\u0010@\u001a\u00020\u00052\u0006\u00108\u001a\u00020<J\u000e\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020DJ\u0016\u0010F\u001a\u00020\u00052\u0006\u0010E\u001a\u00020D2\u0006\u0010G\u001a\u00020<J\u0016\u0010F\u001a\u00020\u00052\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020<J6\u0010J\u001a\u00020K2\u0006\u0010E\u001a\u00020D2\b\b\u0002\u0010L\u001a\u00020M2\b\b\u0002\u0010N\u001a\u00020<2\b\b\u0002\u0010O\u001a\u00020\u00052\b\b\u0002\u0010P\u001a\u00020)J \u0010Q\u001a\u00020R2\u0006\u0010E\u001a\u00020D2\u0006\u0010S\u001a\u00020\u00052\b\b\u0002\u0010T\u001a\u00020<J4\u0010U\u001a\u00020K2\u0006\u0010E\u001a\u00020D2\u0006\u0010V\u001a\u00020M2\b\b\u0002\u0010S\u001a\u00020\u00052\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u0002070XJ>\u0010Y\u001a\u00020K2\u0006\u0010E\u001a\u00020D2\b\u0010Z\u001a\u0004\u0018\u00010[2\u0006\u0010V\u001a\u00020M2\b\b\u0002\u0010S\u001a\u00020\u00052\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u0002070XJ2\u0010\\\u001a\u00020]2\u0006\u0010E\u001a\u00020D2\u0006\u0010Z\u001a\u00020[2\u0006\u0010V\u001a\u00020M2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u0002070XJ6\u0010^\u001a\u00020_2\u0006\u0010E\u001a\u00020D2\b\b\u0002\u0010\u0004\u001a\u00020M2\b\b\u0002\u0010`\u001a\u00020M2\b\b\u0002\u0010a\u001a\u00020)2\b\b\u0002\u0010b\u001a\u00020)J\"\u0010c\u001a\u00020]2\u0006\u0010E\u001a\u00020D2\u0006\u0010d\u001a\u00020M2\n\b\u0002\u0010Z\u001a\u0004\u0018\u00010[J*\u0010e\u001a\u00020K2\u0006\u0010E\u001a\u00020D2\u0006\u0010f\u001a\u00020M2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u0002070XJ4\u0010g\u001a\u00020h2\u0006\u0010E\u001a\u00020D2\u0006\u0010Z\u001a\u00020[2\b\b\u0002\u0010N\u001a\u00020<2\u0012\u0010W\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u0002070XJ \u0010i\u001a\u00020j2\u0006\u0010k\u001a\u00020\u00052\u0006\u0010l\u001a\u00020\u00052\b\b\u0002\u0010m\u001a\u00020<J\u0018\u0010p\u001a\u00020H2\u0006\u0010E\u001a\u00020D2\b\b\u0002\u0010q\u001a\u00020)J\u0016\u0010Z\u001a\u00020[2\u0006\u0010E\u001a\u00020D2\u0006\u0010r\u001a\u00020sJ\u0016\u0010t\u001a\u00020[2\u0006\u0010E\u001a\u00020D2\u0006\u0010u\u001a\u00020MR\u001e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u001e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u001e\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\bR\u001e\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u001e\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\bR\u001e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\bR\u001e\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\bR\u001e\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\bR\u001e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\bR\u001e\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\bR\u001e\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010\bR\u001e\u0010!\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\bR\u001e\u0010#\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\bR\u001e\u0010%\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\bR\u001e\u0010'\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\bR\u001e\u0010*\u001a\u00020)2\u0006\u0010\u0004\u001a\u00020)@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,R\u001e\u0010.\u001a\u00020-2\u0006\u0010\u0004\u001a\u00020-@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u0011\u00109\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\b:\u0010\bR\u0011\u0010A\u001a\u00020\u00058F¢\u0006\u0006\u001a\u0004\bB\u0010\bR\u000e\u0010n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010o\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006x"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Ui;", "", "<init>", "()V", "value", "", "BG", "getBG", "()I", "PANEL", "getPANEL", "HEADER", "getHEADER", "TOPBAR", "getTOPBAR", "RIBBON", "getRIBBON", "BORDER", "getBORDER", "TEXT", "getTEXT", "DIM", "getDIM", "ACCENT", "getACCENT", "SELECT", "getSELECT", "HOVER", "getHOVER", "INPUT", "getINPUT", "ROW_ALT", "getROW_ALT", "EDITOR_BG", "getEDITOR_BG", "EDITOR_GUTTER", "getEDITOR_GUTTER", "EDITOR_TEXT", "getEDITOR_TEXT", "CARD", "getCARD", "", "LIGHT", "getLIGHT", "()Z", "Lcom/exampletest/mobilestudiotest/core/Theme;", "theme", "getTheme", "()Lcom/exampletest/mobilestudiotest/core/Theme;", "WARN", "ERROR", "INFO", "PLAY", "STOP", "applyTheme", "", "t", "SELECT_TEXT", "getSELECT_TEXT", "luminance", "", "c", "blend", "a", "b", "dialogTheme", "getDialogTheme", "popupContext", "Landroid/content/Context;", "ctx", "dp", "v", "Landroid/view/View;", "d", "text", "Landroid/widget/TextView;", "s", "", "size", TypedValues.Custom.S_COLOR, "bold", "rippleBg", "Landroid/graphics/drawable/RippleDrawable;", "base", "radius", "button", "label", "onClick", "Lkotlin/Function1;", "iconTextButton", "icon", "Landroid/graphics/drawable/Drawable;", "toolButton", "Landroid/widget/LinearLayout;", "input", "Landroid/widget/EditText;", "hint", "numeric", "multiLine", "header", "title", "smallIconButton", "glyph", "iconButton", "Landroid/widget/ImageView;", "lp", "Landroid/widget/LinearLayout$LayoutParams;", "w", "h", "weight", "MATCH", "WRAP", "divider", "vertical", "i", "Lcom/exampletest/mobilestudiotest/model/Instance;", "iconFor", "cls", "CheckBoxDrawable", "ArrowDrawable", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Ui {
    public static final int ERROR = -43691;
    public static final int INFO = -9652481;
    private static boolean LIGHT = false;
    public static final int MATCH = -1;
    public static final int PLAY = -13726889;
    public static final int STOP = -4179669;
    public static final int WARN = -23296;
    public static final int WRAP = -2;
    public static final Ui INSTANCE = new Ui();
    private static int BG = -13750738;
    private static int PANEL = -13750738;
    private static int HEADER = -13290187;
    private static int TOPBAR = -14342875;
    private static int RIBBON = -13290187;
    private static int BORDER = -15066598;
    private static int TEXT = -3355444;
    private static int DIM = -7434610;
    private static int ACCENT = -16033105;
    private static int SELECT = -16033105;
    private static int HOVER = -12434878;
    private static int INPUT = -14342875;
    private static int ROW_ALT = -13421773;
    private static int EDITOR_BG = -14803426;
    private static int EDITOR_GUTTER = -14342874;
    private static int EDITOR_TEXT = -2039584;
    private static int CARD = -13092808;
    private static Theme theme = Theme.INSTANCE.getDARK();

    /* compiled from: Ui.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0012\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0005H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Ui$ArrowDrawable;", "Landroid/graphics/drawable/Drawable;", "expanded", "", TypedValues.Custom.S_COLOR, "", "<init>", "(ZI)V", "p", "Landroid/graphics/Paint;", "draw", "", "c", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "getOpacity", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class ArrowDrawable extends Drawable {
        private final int color;
        private final boolean expanded;
        private final Paint p;

        public ArrowDrawable(boolean z, int i) {
            this.expanded = z;
            this.color = i;
            Paint paint = new Paint(1);
            paint.setStyle(Paint.Style.FILL);
            this.p = paint;
        }

        public /* synthetic */ ArrowDrawable(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i2 & 2) != 0 ? Ui.INSTANCE.getDIM() : i);
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas c) {
            Intrinsics.checkNotNullParameter(c, "c");
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            float min = Math.min(bounds.width(), bounds.height()) * 0.36f;
            float exactCenterX = bounds.exactCenterX();
            float exactCenterY = bounds.exactCenterY();
            this.p.setColor(this.color);
            Path path = new Path();
            if (this.expanded) {
                path.moveTo(exactCenterX - min, exactCenterY - (min * 0.5f));
                path.lineTo(exactCenterX + min, exactCenterY - (0.5f * min));
                path.lineTo(exactCenterX, (0.6f * min) + exactCenterY);
            } else {
                path.moveTo(exactCenterX - (min * 0.5f), exactCenterY - min);
                path.lineTo((0.6f * min) + exactCenterX, exactCenterY);
                path.lineTo(exactCenterX - (0.5f * min), exactCenterY + min);
            }
            path.close();
            c.drawPath(path, this.p);
        }

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Deprecated in Java")
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter cf) {
        }
    }

    /* compiled from: Ui.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0012\u0010\u0011\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0010H\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Ui$CheckBoxDrawable;", "Landroid/graphics/drawable/Drawable;", "checked", "", "density", "", "<init>", "(ZF)V", "p", "Landroid/graphics/Paint;", "draw", "", "c", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "getOpacity", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class CheckBoxDrawable extends Drawable {
        private final boolean checked;
        private final float density;
        private final Paint p = new Paint(1);

        public CheckBoxDrawable(boolean z, float f) {
            this.checked = z;
            this.density = f;
        }

        @Override // android.graphics.drawable.Drawable
        public void draw(Canvas c) {
            Intrinsics.checkNotNullParameter(c, "c");
            Rect bounds = getBounds();
            Intrinsics.checkNotNullExpressionValue(bounds, "getBounds(...)");
            float min = Math.min(bounds.width(), bounds.height());
            float f = bounds.left;
            float height = bounds.top + ((bounds.height() - min) / 2.0f);
            this.p.setStyle(Paint.Style.FILL);
            this.p.setColor(this.checked ? Ui.INSTANCE.getACCENT() : Ui.INSTANCE.getINPUT());
            c.drawRoundRect(f, height, f + min, height + min, this.density * 2.0f, this.density * 2.0f, this.p);
            this.p.setStyle(Paint.Style.STROKE);
            this.p.setStrokeWidth(this.density * 1.0f);
            this.p.setColor(this.checked ? Ui.INSTANCE.getACCENT() : -7697782);
            c.drawRoundRect(f, height, f + min, height + min, this.density * 2.0f, this.density * 2.0f, this.p);
            if (this.checked) {
                this.p.setColor(-1);
                this.p.setStrokeWidth(this.density * 1.8f);
                this.p.setStrokeCap(Paint.Cap.ROUND);
                Path path = new Path();
                path.moveTo((0.22f * min) + f, (0.52f * min) + height);
                path.lineTo((0.42f * min) + f, (0.72f * min) + height);
                path.lineTo((0.78f * min) + f, (0.3f * min) + height);
                c.drawPath(path, this.p);
            }
        }

        @Override // android.graphics.drawable.Drawable
        @Deprecated(message = "Deprecated in Java")
        public int getOpacity() {
            return -3;
        }

        @Override // android.graphics.drawable.Drawable
        public void setAlpha(int alpha) {
        }

        @Override // android.graphics.drawable.Drawable
        public void setColorFilter(ColorFilter cf) {
        }
    }

    private Ui() {
    }

    private static final int blend$ch(int i, float f, int i2, int i3) {
        return (((int) ((((i >> i3) & 255) * (1.0f - f)) + (((i2 >> i3) & 255) * f))) & 255) << i3;
    }

    public static /* synthetic */ TextView button$default(Ui ui, Context context, String str, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            i = HOVER;
        }
        return ui.button(context, str, i, function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void button$lambda$4$lambda$3(Function1 function1, View view) {
        function1.invoke(view);
    }

    public static /* synthetic */ View divider$default(Ui ui, Context context, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return ui.divider(context, z);
    }

    public static /* synthetic */ LinearLayout header$default(Ui ui, Context context, String str, Drawable drawable, int i, Object obj) {
        if ((i & 4) != 0) {
            drawable = null;
        }
        return ui.header(context, str, drawable);
    }

    public static /* synthetic */ ImageView iconButton$default(Ui ui, Context context, Drawable drawable, float f, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            f = 30.0f;
        }
        return ui.iconButton(context, drawable, f, function1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void iconButton$lambda$21$lambda$20(Function1 function1, View view) {
        function1.invoke(view);
    }

    public static /* synthetic */ TextView iconTextButton$default(Ui ui, Context context, Drawable drawable, String str, int i, Function1 function1, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            i = HOVER;
        }
        return ui.iconTextButton(context, drawable, str, i, function1);
    }

    public static /* synthetic */ EditText input$default(Ui ui, Context context, String str, String str2, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = "";
        }
        if ((i & 4) != 0) {
            str2 = "";
        }
        if ((i & 8) != 0) {
            z = false;
        }
        if ((i & 16) != 0) {
            z2 = false;
        }
        return ui.input(context, str, str2, z, z2);
    }

    public static /* synthetic */ LinearLayout.LayoutParams lp$default(Ui ui, int i, int i2, float f, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            f = 0.0f;
        }
        return ui.lp(i, i2, f);
    }

    public static /* synthetic */ RippleDrawable rippleBg$default(Ui ui, Context context, int i, float f, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            f = 4.0f;
        }
        return ui.rippleBg(context, i, f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void smallIconButton$lambda$19$lambda$18(Function1 function1, View view) {
        function1.invoke(view);
    }

    public static /* synthetic */ TextView text$default(Ui ui, Context context, String str, float f, int i, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str = "";
        }
        String str2 = str;
        if ((i2 & 4) != 0) {
            f = 13.0f;
        }
        float f2 = f;
        if ((i2 & 8) != 0) {
            i = TEXT;
        }
        int i3 = i;
        if ((i2 & 16) != 0) {
            z = false;
        }
        return ui.text(context, str2, f2, i3, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void toolButton$lambda$12$lambda$11(Function1 function1, View view) {
        function1.invoke(view);
    }

    public final void applyTheme(Theme t) {
        Intrinsics.checkNotNullParameter(t, "t");
        theme = t;
        LIGHT = t.getLight();
        BG = t.getBg();
        PANEL = t.getPanel();
        HEADER = t.getHeader();
        TOPBAR = t.getTopbar();
        RIBBON = t.getRibbon();
        BORDER = t.getBorder();
        TEXT = t.getText();
        DIM = t.getDim();
        ACCENT = t.getAccent();
        SELECT = t.getSelect();
        HOVER = t.getHover();
        INPUT = t.getInput();
        ROW_ALT = t.getRowAlt();
        EDITOR_BG = t.getEditorBg();
        EDITOR_GUTTER = t.getEditorGutter();
        EDITOR_TEXT = t.getEditorText();
        CARD = blend(t.getPanel(), t.getLight() ? ViewCompat.MEASURED_STATE_MASK : -1, 0.06f);
    }

    public final int blend(int a, int b, float t) {
        return blend$ch(a, t, b, 16) | ViewCompat.MEASURED_STATE_MASK | blend$ch(a, t, b, 8) | blend$ch(a, t, b, 0);
    }

    public final TextView button(Context ctx, String label, int base, Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        TextView text$default = text$default(this, ctx, label, 13.0f, 0, false, 24, null);
        text$default.setGravity(17);
        int dp = INSTANCE.dp(ctx, 10.0f);
        text$default.setPadding(dp, INSTANCE.dp(ctx, 6.0f), dp, INSTANCE.dp(ctx, 6.0f));
        text$default.setBackground(rippleBg$default(INSTANCE, ctx, base, 0.0f, 4, null));
        text$default.setClickable(true);
        text$default.setOnClickListener(new Ui$$ExternalSyntheticLambda1(onClick));
        return text$default;
    }

    public final View divider(Context ctx, boolean vertical) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        View view = new View(ctx);
        Ui ui = INSTANCE;
        view.setBackgroundColor(BORDER);
        int dp = INSTANCE.dp(ctx, 1.0f);
        view.setLayoutParams(vertical ? new LinearLayout.LayoutParams(dp, -1) : new LinearLayout.LayoutParams(-1, dp));
        return view;
    }

    public final int dp(Context ctx, float v) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return (int) TypedValue.applyDimension(1, v, ctx.getResources().getDisplayMetrics());
    }

    public final int dp(View v, float d) {
        Intrinsics.checkNotNullParameter(v, "v");
        Context context = v.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
        return dp(context, d);
    }

    public final int getACCENT() {
        return ACCENT;
    }

    public final int getBG() {
        return BG;
    }

    public final int getBORDER() {
        return BORDER;
    }

    public final int getCARD() {
        return CARD;
    }

    public final int getDIM() {
        return DIM;
    }

    public final int getDialogTheme() {
        return LIGHT ? R.style.Theme.Material.Light.Dialog.Alert : R.style.Theme.Material.Dialog.Alert;
    }

    public final int getEDITOR_BG() {
        return EDITOR_BG;
    }

    public final int getEDITOR_GUTTER() {
        return EDITOR_GUTTER;
    }

    public final int getEDITOR_TEXT() {
        return EDITOR_TEXT;
    }

    public final int getHEADER() {
        return HEADER;
    }

    public final int getHOVER() {
        return HOVER;
    }

    public final int getINPUT() {
        return INPUT;
    }

    public final boolean getLIGHT() {
        return LIGHT;
    }

    public final int getPANEL() {
        return PANEL;
    }

    public final int getRIBBON() {
        return RIBBON;
    }

    public final int getROW_ALT() {
        return ROW_ALT;
    }

    public final int getSELECT() {
        return SELECT;
    }

    public final int getSELECT_TEXT() {
        return luminance(SELECT) > 0.55f ? -15658735 : -1;
    }

    public final int getTEXT() {
        return TEXT;
    }

    public final int getTOPBAR() {
        return TOPBAR;
    }

    public final Theme getTheme() {
        return theme;
    }

    public final LinearLayout header(Context ctx, String title, Drawable icon) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(title, "title");
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        Ui ui = INSTANCE;
        linearLayout.setBackgroundColor(HEADER);
        linearLayout.setPadding(INSTANCE.dp(ctx, 8.0f), INSTANCE.dp(ctx, 3.0f), INSTANCE.dp(ctx, 4.0f), INSTANCE.dp(ctx, 3.0f));
        if (icon != null) {
            ImageView imageView = new ImageView(ctx);
            imageView.setImageDrawable(icon);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(INSTANCE.dp(ctx, 16.0f), INSTANCE.dp(ctx, 16.0f));
            layoutParams.rightMargin = INSTANCE.dp(ctx, 6.0f);
            Unit unit = Unit.INSTANCE;
            linearLayout.addView(imageView, layoutParams);
        }
        Ui ui2 = INSTANCE;
        Ui ui3 = INSTANCE;
        linearLayout.addView(ui2.text(ctx, title, 12.0f, TEXT, true), new LinearLayout.LayoutParams(0, -2, 1.0f));
        return linearLayout;
    }

    public final Drawable icon(Context ctx, Instance i) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(i, "i");
        return Icons.INSTANCE.instance(ctx, i.getClassName());
    }

    public final ImageView iconButton(Context ctx, Drawable icon, float size, Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        ImageView imageView = new ImageView(ctx);
        imageView.setImageDrawable(icon);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        int dp = INSTANCE.dp(ctx, (size - 18.0f) / 2.0f);
        imageView.setPadding(dp, dp, dp, dp);
        imageView.setBackground(rippleBg$default(INSTANCE, ctx, 0, 0.0f, 4, null));
        imageView.setClickable(true);
        imageView.setOnClickListener(new Ui$$ExternalSyntheticLambda0(onClick));
        imageView.setLayoutParams(new LinearLayout.LayoutParams(INSTANCE.dp(ctx, size), INSTANCE.dp(ctx, size)));
        return imageView;
    }

    public final Drawable iconFor(Context ctx, String cls) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(cls, "cls");
        return Icons.INSTANCE.instance(ctx, cls);
    }

    public final TextView iconTextButton(Context ctx, Drawable icon, String label, int base, Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        TextView button = button(ctx, label, base, onClick);
        if (icon != null) {
            int dp = INSTANCE.dp(ctx, 18.0f);
            icon.setBounds(0, 0, dp, dp);
            button.setCompoundDrawables(icon, null, null, null);
            button.setCompoundDrawablePadding(INSTANCE.dp(ctx, 6.0f));
        }
        return button;
    }

    public final EditText input(Context ctx, String value, String hint, boolean numeric, boolean multiLine) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(hint, "hint");
        EditText editText = new EditText(ctx);
        editText.setText(value);
        editText.setHint(hint);
        Ui ui = INSTANCE;
        editText.setTextColor(TEXT);
        Ui ui2 = INSTANCE;
        editText.setHintTextColor(DIM);
        editText.setTextSize(2, 14.0f);
        GradientDrawable gradientDrawable = new GradientDrawable();
        Ui ui3 = INSTANCE;
        gradientDrawable.setColor(INPUT);
        int dp = INSTANCE.dp(ctx, 1.0f);
        Ui ui4 = INSTANCE;
        gradientDrawable.setStroke(dp, LIGHT ? -3881788 : -11908534);
        gradientDrawable.setCornerRadius(INSTANCE.dp(ctx, 3.0f));
        editText.setBackground(gradientDrawable);
        int dp2 = INSTANCE.dp(ctx, 8.0f);
        editText.setPadding(dp2, dp2, dp2, dp2);
        editText.setInputType(numeric ? 12290 : multiLine ? 655361 : 524289);
        if (!multiLine) {
            editText.setSingleLine(true);
        }
        return editText;
    }

    public final LinearLayout.LayoutParams lp(int w, int h, float weight) {
        return new LinearLayout.LayoutParams(w, h, weight);
    }

    public final float luminance(int c) {
        return (((((c >> 16) & 255) * 0.299f) + (((c >> 8) & 255) * 0.587f)) + ((c & 255) * 0.114f)) / 255.0f;
    }

    public final Context popupContext(Context ctx) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        return new ContextThemeWrapper(ctx, LIGHT ? R.style.Theme.Material.Light : R.style.Theme.Material);
    }

    public final RippleDrawable rippleBg(Context ctx, int base, float radius) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(base);
        gradientDrawable.setCornerRadius(INSTANCE.dp(ctx, radius));
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(-1);
        gradientDrawable2.setCornerRadius(INSTANCE.dp(ctx, radius));
        return new RippleDrawable(ColorStateList.valueOf(LIGHT ? 570425344 : 872415231), gradientDrawable, gradientDrawable2);
    }

    public final TextView smallIconButton(Context ctx, String glyph, Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(glyph, "glyph");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        TextView text$default = text$default(this, ctx, glyph, 13.0f, 0, false, 24, null);
        text$default.setGravity(17);
        int dp = INSTANCE.dp(ctx, 6.0f);
        text$default.setPadding(dp, INSTANCE.dp(ctx, 3.0f), dp, INSTANCE.dp(ctx, 3.0f));
        text$default.setBackground(rippleBg$default(INSTANCE, ctx, 0, 0.0f, 4, null));
        text$default.setClickable(true);
        text$default.setOnClickListener(new Ui$$ExternalSyntheticLambda3(onClick));
        return text$default;
    }

    public final TextView text(Context ctx, String s, float size, int color, boolean bold) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(s, "s");
        TextView textView = new TextView(ctx);
        textView.setText(s);
        textView.setTextColor(color);
        textView.setTextSize(2, size);
        if (bold) {
            textView.setTypeface(textView.getTypeface(), 1);
        }
        textView.setSingleLine(true);
        return textView;
    }

    public final LinearLayout toolButton(Context ctx, Drawable icon, String label, Function1<? super View, Unit> onClick) {
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(icon, "icon");
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(1);
        linearLayout.setGravity(17);
        int dp = INSTANCE.dp(ctx, 6.0f);
        linearLayout.setPadding(dp, INSTANCE.dp(ctx, 4.0f), dp, INSTANCE.dp(ctx, 3.0f));
        linearLayout.setMinimumWidth(INSTANCE.dp(ctx, 54.0f));
        ImageView imageView = new ImageView(ctx);
        imageView.setImageDrawable(icon);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(INSTANCE.dp(ctx, 26.0f), INSTANCE.dp(ctx, 26.0f)));
        Ui ui = INSTANCE;
        Ui ui2 = INSTANCE;
        TextView text$default = text$default(ui, ctx, label, 11.0f, TEXT, false, 16, null);
        text$default.setGravity(17);
        text$default.setPadding(0, INSTANCE.dp(ctx, 2.0f), 0, 0);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 1;
        Unit unit = Unit.INSTANCE;
        linearLayout.addView(text$default, layoutParams);
        StateListDrawable stateListDrawable = new StateListDrawable();
        int[] iArr = {R.attr.state_selected};
        GradientDrawable gradientDrawable = new GradientDrawable();
        Ui ui3 = INSTANCE;
        gradientDrawable.setColor(SELECT);
        gradientDrawable.setCornerRadius(INSTANCE.dp(ctx, 3.0f));
        Unit unit2 = Unit.INSTANCE;
        stateListDrawable.addState(iArr, gradientDrawable);
        stateListDrawable.addState(new int[0], new ColorDrawable(0));
        linearLayout.setBackground(stateListDrawable);
        linearLayout.setForeground(rippleBg$default(INSTANCE, ctx, 0, 0.0f, 4, null));
        linearLayout.setClickable(true);
        linearLayout.setOnClickListener(new Ui$$ExternalSyntheticLambda2(onClick));
        return linearLayout;
    }
}
