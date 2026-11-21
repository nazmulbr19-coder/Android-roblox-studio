package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: DockLayout.kt */
@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001:\u0005ijklmB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0002J\u0010\u00108\u001a\u00020\u000b2\u0006\u00109\u001a\u00020\u000bH\u0002J\u0010\u0010:\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u000bH\u0002J\u000e\u0010<\u001a\u0002032\u0006\u0010\f\u001a\u00020=J8\u0010>\u001a\u0002032\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@2\u0006\u0010B\u001a\u00020=2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u000b2\b\b\u0002\u0010F\u001a\u00020 J\u0014\u0010G\u001a\b\u0018\u00010\u000fR\u00020\u00002\u0006\u0010?\u001a\u00020@J\u000e\u0010H\u001a\u00020 2\u0006\u0010?\u001a\u00020@J\u0016\u0010I\u001a\u0002032\u0006\u0010?\u001a\u00020@2\u0006\u0010J\u001a\u00020 J\u000e\u0010K\u001a\u0002032\u0006\u0010?\u001a\u00020@J\u0006\u0010L\u001a\u000203J\u0006\u0010M\u001a\u000203J\u0006\u0010N\u001a\u000203J\u0010\u0010O\u001a\u0002032\u0006\u0010\f\u001a\u00020=H\u0002J\u0006\u0010P\u001a\u000203J\b\u0010Q\u001a\u000203H\u0002J8\u0010R\u001a\u0002032\u0006\u0010S\u001a\u00020\u00122\n\u0010T\u001a\u00060\u000fR\u00020\u00002\n\u0010U\u001a\u00060\u000fR\u00020\u00002\u0006\u0010V\u001a\u00020\t2\u0006\u0010W\u001a\u00020 H\u0002J\u0016\u0010X\u001a\u0004\u0018\u00010Y2\n\u0010Z\u001a\u00060\u000fR\u00020\u0000H\u0002J\u0014\u0010[\u001a\u0002032\n\u0010Z\u001a\u00060\u000fR\u00020\u0000H\u0002J$\u0010\\\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0]2\u0006\u0010^\u001a\u00020\t2\u0006\u0010_\u001a\u00020\tH\u0002J\u0010\u0010`\u001a\u00020a2\u0006\u0010\f\u001a\u00020=H\u0002J\u0014\u0010b\u001a\u0002032\n\u0010Z\u001a\u00060\u000fR\u00020\u0000H\u0002J$\u0010c\u001a\u00020d2\n\u0010Z\u001a\u00060\u000fR\u00020\u00002\u0006\u0010e\u001a\u00020\t2\u0006\u0010f\u001a\u00020\tH\u0002J\u001c\u0010g\u001a\u0002032\n\u0010Z\u001a\u00060\u000fR\u00020\u00002\u0006\u0010h\u001a\u00020dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u001a\u0012\b\u0012\u00060\u000fR\u00020\u00000\u000ej\f\u0012\b\u0012\u00060\u000fR\u00020\u0000`\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0019\u001a\u00060\u001aR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010#\"\u0004\b(\u0010%R\u001a\u0010)\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010#\"\u0004\b+\u0010%R$\u0010,\u001a\u00020 2\u0006\u0010\f\u001a\u00020 @FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R\"\u00101\u001a\n\u0012\u0004\u0012\u000203\u0018\u000102X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107¨\u0006n"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/DockLayout;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "prefs", "Landroid/content/SharedPreferences;", "<init>", "(Landroid/content/Context;Landroid/content/SharedPreferences;)V", "d", "", "dp", "", "v", "panels", "Ljava/util/ArrayList;", "Lcom/exampletest/mobilestudiotest/ui/DockLayout$Panel;", "Lkotlin/collections/ArrayList;", "main", "Landroid/widget/LinearLayout;", "leftCol", "rightCol", "centerCol", "bottomRow", "centerHost", "floatLayer", "overlay", "Lcom/exampletest/mobilestudiotest/ui/DockLayout$DropOverlay;", "leftSplit", "Lcom/exampletest/mobilestudiotest/ui/Splitter;", "rightSplit", "bottomSplit", "phone", "", "leftW", "getLeftW", "()I", "setLeftW", "(I)V", "rightW", "getRightW", "setRightW", "bottomH", "getBottomH", "setBottomH", "allHidden", "getAllHidden", "()Z", "setAllHidden", "(Z)V", "onChanged", "Lkotlin/Function0;", "", "getOnChanged", "()Lkotlin/jvm/functions/Function0;", "setOnChanged", "(Lkotlin/jvm/functions/Function0;)V", "clampW", "w", "clampH", "h", "setCenter", "Landroid/view/View;", "addPanel", "id", "", "title", "view", "zone", "Lcom/exampletest/mobilestudiotest/ui/DockLayout$Zone;", "order", "visible", "panel", "isShown", "setShown", "show", "toggle", "load", "save", "reset", "detach", "rebuild", "clampFloats", "resizePair", "col", "a", "b", "delta", "horizontal", "headerOf", "Landroid/view/ViewGroup;", "p", "decorateHeader", "local", "Lkotlin/Pair;", "rawX", "rawY", "rectIn", "Landroid/graphics/RectF;", "toggleFloat", TypedValues.AttributesType.S_TARGET, "Lcom/exampletest/mobilestudiotest/ui/DockLayout$Target;", "x", "y", "drop", "t", "Zone", "Panel", "Target", "FloatFrame", "DropOverlay", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class DockLayout extends FrameLayout {
    private boolean allHidden;
    private int bottomH;
    private final LinearLayout bottomRow;
    private final Splitter bottomSplit;
    private final LinearLayout centerCol;
    private final FrameLayout centerHost;
    private final float d;
    private final FrameLayout floatLayer;
    private final LinearLayout leftCol;
    private final Splitter leftSplit;
    private int leftW;
    private final LinearLayout main;
    private Function0<Unit> onChanged;
    private final DropOverlay overlay;
    private final ArrayList<Panel> panels;
    private final boolean phone;
    private final SharedPreferences prefs;
    private final LinearLayout rightCol;
    private final Splitter rightSplit;
    private int rightW;

    /* compiled from: DockLayout.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\u000e\u001a\u00020\u000f2\n\u0010\u0010\u001a\u00060\fR\u00020\rJ\"\u0010\u0011\u001a\u00020\n2\n\u0010\u0010\u001a\u00060\fR\u00020\r2\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0010\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0014R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0018\u00010\fR\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/DockLayout$DropOverlay;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/DockLayout;Landroid/content/Context;)V", "fill", "Landroid/graphics/Paint;", "line", "current", "Lcom/exampletest/mobilestudiotest/ui/DockLayout$Target;", "dragged", "Lcom/exampletest/mobilestudiotest/ui/DockLayout$Panel;", "Lcom/exampletest/mobilestudiotest/ui/DockLayout;", "begin", "", "p", "update", "x", "", "y", "end", "onDraw", "c", "Landroid/graphics/Canvas;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    private final class DropOverlay extends View {
        private Target current;
        private Panel dragged;
        private final Paint fill;
        private final Paint line;
        final /* synthetic */ DockLayout this$0;

        /* compiled from: DockLayout.kt */
        @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
        /* loaded from: classes5.dex */
        public static final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Zone.values().length];
                try {
                    iArr[Zone.LEFT.ordinal()] = 1;
                } catch (NoSuchFieldError e) {
                }
                try {
                    iArr[Zone.RIGHT.ordinal()] = 2;
                } catch (NoSuchFieldError e2) {
                }
                try {
                    iArr[Zone.BOTTOM.ordinal()] = 3;
                } catch (NoSuchFieldError e3) {
                }
                try {
                    iArr[Zone.FLOAT.ordinal()] = 4;
                } catch (NoSuchFieldError e4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DropOverlay(DockLayout dockLayout, Context ctx) {
            super(ctx);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            this.this$0 = dockLayout;
            this.fill = new Paint(1);
            Paint paint = new Paint(1);
            paint.setStyle(Paint.Style.STROKE);
            this.line = paint;
        }

        public final void begin(Panel p) {
            Intrinsics.checkNotNullParameter(p, "p");
            this.dragged = p;
            setVisibility(0);
            invalidate();
        }

        public final void end() {
            setVisibility(8);
            this.current = null;
            this.dragged = null;
        }

        @Override // android.view.View
        protected void onDraw(Canvas c) {
            String str;
            Intrinsics.checkNotNullParameter(c, "c");
            float width = getWidth();
            float height = getHeight();
            float access$getD$p = DockLayout.access$getD$p(this.this$0) * 44.0f;
            this.fill.setColor(574327787);
            c.drawRect(0.0f, 0.0f, access$getD$p, height, this.fill);
            c.drawRect(width - access$getD$p, 0.0f, width, height, this.fill);
            c.drawRect(access$getD$p, height - access$getD$p, width - access$getD$p, height, this.fill);
            Target target = this.current;
            if (target == null) {
                return;
            }
            this.fill.setColor(1429965803);
            this.line.setColor(IconPainter.BLUE);
            this.line.setStrokeWidth(DockLayout.access$getD$p(this.this$0) * 2.0f);
            c.drawRect(target.getPreview(), this.fill);
            c.drawRect(target.getPreview(), this.line);
            switch (WhenMappings.$EnumSwitchMapping$0[target.getZone().ordinal()]) {
                case 1:
                    str = "Dock left";
                    break;
                case 2:
                    str = "Dock right";
                    break;
                case 3:
                    str = "Dock bottom";
                    break;
                case 4:
                    str = "Float";
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            String str2 = str;
            this.fill.setColor(-1);
            this.fill.setTextSize(DockLayout.access$getD$p(this.this$0) * 13.0f);
            this.fill.setTextAlign(Paint.Align.CENTER);
            this.fill.setFakeBoldText(true);
            this.fill.getTextBounds(str2, 0, str2.length(), new Rect());
            float centerX = target.getPreview().centerX();
            float centerY = target.getPreview().centerY();
            Paint paint = new Paint();
            paint.setColor(-870359120);
            c.drawRoundRect((centerX - (r2.width() / 2.0f)) - (DockLayout.access$getD$p(this.this$0) * 10.0f), centerY - (DockLayout.access$getD$p(this.this$0) * 14.0f), (DockLayout.access$getD$p(this.this$0) * 10.0f) + (r2.width() / 2.0f) + centerX, centerY + (DockLayout.access$getD$p(this.this$0) * 10.0f), DockLayout.access$getD$p(this.this$0) * 6.0f, DockLayout.access$getD$p(this.this$0) * 6.0f, paint);
            c.drawText(str2, centerX, centerY + (DockLayout.access$getD$p(this.this$0) * 2.0f), this.fill);
            this.fill.setFakeBoldText(false);
        }

        public final Target update(Panel p, float x, float y) {
            Intrinsics.checkNotNullParameter(p, "p");
            Target access$target = DockLayout.access$target(this.this$0, p, x, y);
            this.current = access$target;
            invalidate();
            return access$target;
        }
    }

    /* compiled from: DockLayout.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0087\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\u0010\u0004\u001a\u00060\u0005R\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0006\u0010\u000b\u001a\u00020\fR\u0012\u0010\u0004\u001a\u00060\u0005R\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/DockLayout$FloatFrame;", "Landroid/widget/FrameLayout;", "ctx", "Landroid/content/Context;", "p", "Lcom/exampletest/mobilestudiotest/ui/DockLayout$Panel;", "Lcom/exampletest/mobilestudiotest/ui/DockLayout;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/DockLayout;Landroid/content/Context;Lcom/exampletest/mobilestudiotest/ui/DockLayout$Panel;)V", "grip", "Landroid/view/View;", "attach", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class FloatFrame extends FrameLayout {
        private final View grip;
        private final Panel p;
        final /* synthetic */ DockLayout this$0;

        /* compiled from: DockLayout.kt */
        @Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016J\u0012\u0010\u000b\u001a\u00020\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\u0016J\b\u0010\u000e\u001a\u00020\nH\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"com/exampletest/mobilestudiotest/ui/DockLayout$FloatFrame$2", "Landroid/graphics/drawable/Drawable;", "pt", "Landroid/graphics/Paint;", "draw", "", "c", "Landroid/graphics/Canvas;", "setAlpha", "alpha", "", "setColorFilter", "cf", "Landroid/graphics/ColorFilter;", "getOpacity", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.exampletest.mobilestudiotest.ui.DockLayout$FloatFrame$2, reason: invalid class name */
        /* loaded from: classes5.dex */
        public static final class AnonymousClass2 extends Drawable {
            private final Paint pt;
            final /* synthetic */ DockLayout this$0;

            AnonymousClass2(DockLayout dockLayout) {
                this.this$0 = dockLayout;
                Paint paint = new Paint(1);
                paint.setStrokeWidth(DockLayout.access$getD$p(dockLayout) * 1.5f);
                this.pt = paint;
            }

            @Override // android.graphics.drawable.Drawable
            public void draw(Canvas c) {
                Intrinsics.checkNotNullParameter(c, "c");
                Intrinsics.checkNotNullExpressionValue(getBounds(), "getBounds(...)");
                this.pt.setColor(Ui.INSTANCE.getDIM());
                for (int i = 1; i < 4; i++) {
                    c.drawLine(r0.right - ((i * 5.0f) * DockLayout.access$getD$p(this.this$0)), r0.bottom - (DockLayout.access$getD$p(this.this$0) * 2.0f), r0.right - (DockLayout.access$getD$p(this.this$0) * 2.0f), r0.bottom - ((i * 5.0f) * DockLayout.access$getD$p(this.this$0)), this.pt);
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

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public FloatFrame(DockLayout dockLayout, Context ctx, Panel p) {
            super(ctx);
            Intrinsics.checkNotNullParameter(ctx, "ctx");
            Intrinsics.checkNotNullParameter(p, "p");
            this.this$0 = dockLayout;
            this.p = p;
            this.grip = new View(ctx);
            GradientDrawable gradientDrawable = new GradientDrawable();
            DockLayout dockLayout2 = this.this$0;
            gradientDrawable.setColor(Ui.INSTANCE.getPANEL());
            gradientDrawable.setStroke(DockLayout.access$dp(dockLayout2, 1.0f), Ui.INSTANCE.getACCENT());
            setBackground(gradientDrawable);
            setElevation(DockLayout.access$getD$p(this.this$0) * 12.0f);
            setPadding(DockLayout.access$dp(this.this$0, 1.0f), DockLayout.access$dp(this.this$0, 1.0f), DockLayout.access$dp(this.this$0, 1.0f), DockLayout.access$dp(this.this$0, 1.0f));
            this.grip.setBackground(new AnonymousClass2(this.this$0));
            this.grip.setOnTouchListener(new DockLayout$FloatFrame$$ExternalSyntheticLambda0(this, new Ref.FloatRef(), new Ref.FloatRef(), new Ref.IntRef(), new Ref.IntRef(), this.this$0));
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x007a, code lost:
        
            return true;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public static final boolean _init_$lambda$1(com.exampletest.mobilestudiotest.ui.DockLayout.FloatFrame r4, kotlin.jvm.internal.Ref.FloatRef r5, kotlin.jvm.internal.Ref.FloatRef r6, kotlin.jvm.internal.Ref.IntRef r7, kotlin.jvm.internal.Ref.IntRef r8, com.exampletest.mobilestudiotest.ui.DockLayout r9, android.view.View r10, android.view.MotionEvent r11) {
            /*
                android.view.ViewGroup$LayoutParams r10 = r4.getLayoutParams()
                java.lang.String r0 = "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams"
                kotlin.jvm.internal.Intrinsics.checkNotNull(r10, r0)
                android.widget.FrameLayout$LayoutParams r10 = (android.widget.FrameLayout.LayoutParams) r10
                int r0 = r11.getActionMasked()
                r1 = 1
                switch(r0) {
                    case 0: goto L5d;
                    case 1: goto L4b;
                    case 2: goto L14;
                    case 3: goto L4b;
                    default: goto L13;
                }
            L13:
                goto L7a
            L14:
                int r0 = r7.element
                float r0 = (float) r0
                float r2 = r11.getRawX()
                float r3 = r5.element
                float r2 = r2 - r3
                float r0 = r0 + r2
                int r0 = (int) r0
                r2 = 1127481344(0x43340000, float:180.0)
                int r2 = com.exampletest.mobilestudiotest.ui.DockLayout.access$dp(r9, r2)
                int r0 = kotlin.ranges.RangesKt.coerceAtLeast(r0, r2)
                r10.width = r0
                int r0 = r8.element
                float r0 = (float) r0
                float r2 = r11.getRawY()
                float r3 = r6.element
                float r2 = r2 - r3
                float r0 = r0 + r2
                int r0 = (int) r0
                r2 = 1124859904(0x430c0000, float:140.0)
                int r2 = com.exampletest.mobilestudiotest.ui.DockLayout.access$dp(r9, r2)
                int r0 = kotlin.ranges.RangesKt.coerceAtLeast(r0, r2)
                r10.height = r0
                r0 = r10
                android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
                r4.setLayoutParams(r0)
                goto L7a
            L4b:
                com.exampletest.mobilestudiotest.ui.DockLayout$Panel r0 = r4.p
                int r2 = r10.width
                r0.setFw(r2)
                com.exampletest.mobilestudiotest.ui.DockLayout$Panel r0 = r4.p
                int r2 = r10.height
                r0.setFh(r2)
                r9.save()
                goto L7a
            L5d:
                float r0 = r11.getRawX()
                r5.element = r0
                float r0 = r11.getRawY()
                r6.element = r0
                int r0 = r10.width
                r7.element = r0
                int r0 = r10.height
                r8.element = r0
                android.view.ViewParent r0 = r4.getParent()
                if (r0 == 0) goto L7a
                r0.requestDisallowInterceptTouchEvent(r1)
            L7a:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.DockLayout.FloatFrame._init_$lambda$1(com.exampletest.mobilestudiotest.ui.DockLayout$FloatFrame, kotlin.jvm.internal.Ref$FloatRef, kotlin.jvm.internal.Ref$FloatRef, kotlin.jvm.internal.Ref$IntRef, kotlin.jvm.internal.Ref$IntRef, com.exampletest.mobilestudiotest.ui.DockLayout, android.view.View, android.view.MotionEvent):boolean");
        }

        public final void attach() {
            removeAllViews();
            addView(this.p.getView(), new FrameLayout.LayoutParams(-1, -1));
            addView(this.grip, new FrameLayout.LayoutParams(DockLayout.access$dp(this.this$0, 22.0f), DockLayout.access$dp(this.this$0, 22.0f), 8388693));
        }
    }

    /* compiled from: DockLayout.kt */
    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\u0007\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0004\u0018\u00002\u00020\u0001B7\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0017\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0019\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0017\"\u0004\b.\u0010!R\u001a\u0010/\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0017\"\u0004\b1\u0010!R\u001a\u00102\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0017\"\u0004\b4\u0010!R\u001a\u00105\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\u0017\"\u0004\b7\u0010!R \u00108\u001a\b\u0018\u000109R\u00020:X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>¨\u0006?"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/DockLayout$Panel;", "", "id", "", "title", "view", "Landroid/view/View;", "defZone", "Lcom/exampletest/mobilestudiotest/ui/DockLayout$Zone;", "defOrder", "", "defVisible", "", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/DockLayout;Ljava/lang/String;Ljava/lang/String;Landroid/view/View;Lcom/exampletest/mobilestudiotest/ui/DockLayout$Zone;IZ)V", "getId", "()Ljava/lang/String;", "getTitle", "getView", "()Landroid/view/View;", "getDefZone", "()Lcom/exampletest/mobilestudiotest/ui/DockLayout$Zone;", "getDefOrder", "()I", "getDefVisible", "()Z", "zone", "getZone", "setZone", "(Lcom/exampletest/mobilestudiotest/ui/DockLayout$Zone;)V", "order", "getOrder", "setOrder", "(I)V", "weight", "", "getWeight", "()F", "setWeight", "(F)V", "visible", "getVisible", "setVisible", "(Z)V", "fx", "getFx", "setFx", "fy", "getFy", "setFy", "fw", "getFw", "setFw", "fh", "getFh", "setFh", TypedValues.AttributesType.S_FRAME, "Lcom/exampletest/mobilestudiotest/ui/DockLayout$FloatFrame;", "Lcom/exampletest/mobilestudiotest/ui/DockLayout;", "getFrame", "()Lcom/exampletest/mobilestudiotest/ui/DockLayout$FloatFrame;", "setFrame", "(Lcom/exampletest/mobilestudiotest/ui/DockLayout$FloatFrame;)V", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public final class Panel {
        private final int defOrder;
        private final boolean defVisible;
        private final Zone defZone;
        private int fh;
        private FloatFrame frame;
        private int fw;
        private int fx;
        private int fy;
        private final String id;
        private int order;
        final /* synthetic */ DockLayout this$0;
        private final String title;
        private final View view;
        private boolean visible;
        private float weight;
        private Zone zone;

        public Panel(DockLayout dockLayout, String id, String title, View view, Zone defZone, int i, boolean z) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(title, "title");
            Intrinsics.checkNotNullParameter(view, "view");
            Intrinsics.checkNotNullParameter(defZone, "defZone");
            this.this$0 = dockLayout;
            this.id = id;
            this.title = title;
            this.view = view;
            this.defZone = defZone;
            this.defOrder = i;
            this.defVisible = z;
            this.zone = this.defZone;
            this.order = this.defOrder;
            this.weight = 1.0f;
            this.visible = this.defVisible;
            this.fx = -1;
            this.fy = -1;
        }

        public final int getDefOrder() {
            return this.defOrder;
        }

        public final boolean getDefVisible() {
            return this.defVisible;
        }

        public final Zone getDefZone() {
            return this.defZone;
        }

        public final int getFh() {
            return this.fh;
        }

        public final FloatFrame getFrame() {
            return this.frame;
        }

        public final int getFw() {
            return this.fw;
        }

        public final int getFx() {
            return this.fx;
        }

        public final int getFy() {
            return this.fy;
        }

        public final String getId() {
            return this.id;
        }

        public final int getOrder() {
            return this.order;
        }

        public final String getTitle() {
            return this.title;
        }

        public final View getView() {
            return this.view;
        }

        public final boolean getVisible() {
            return this.visible;
        }

        public final float getWeight() {
            return this.weight;
        }

        public final Zone getZone() {
            return this.zone;
        }

        public final void setFh(int i) {
            this.fh = i;
        }

        public final void setFrame(FloatFrame floatFrame) {
            this.frame = floatFrame;
        }

        public final void setFw(int i) {
            this.fw = i;
        }

        public final void setFx(int i) {
            this.fx = i;
        }

        public final void setFy(int i) {
            this.fy = i;
        }

        public final void setOrder(int i) {
            this.order = i;
        }

        public final void setVisible(boolean z) {
            this.visible = z;
        }

        public final void setWeight(float f) {
            this.weight = f;
        }

        public final void setZone(Zone zone) {
            Intrinsics.checkNotNullParameter(zone, "<set-?>");
            this.zone = zone;
        }
    }

    /* compiled from: DockLayout.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/DockLayout$Target;", "", "zone", "Lcom/exampletest/mobilestudiotest/ui/DockLayout$Zone;", "index", "", "preview", "Landroid/graphics/RectF;", "<init>", "(Lcom/exampletest/mobilestudiotest/ui/DockLayout$Zone;ILandroid/graphics/RectF;)V", "getZone", "()Lcom/exampletest/mobilestudiotest/ui/DockLayout$Zone;", "getIndex", "()I", "getPreview", "()Landroid/graphics/RectF;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public static final class Target {
        private final int index;
        private final RectF preview;
        private final Zone zone;

        public Target(Zone zone, int i, RectF preview) {
            Intrinsics.checkNotNullParameter(zone, "zone");
            Intrinsics.checkNotNullParameter(preview, "preview");
            this.zone = zone;
            this.index = i;
            this.preview = preview;
        }

        public final int getIndex() {
            return this.index;
        }

        public final RectF getPreview() {
            return this.preview;
        }

        public final Zone getZone() {
            return this.zone;
        }
    }

    /* compiled from: DockLayout.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/DockLayout$Zone;", "", "<init>", "(Ljava/lang/String;I)V", "LEFT", "RIGHT", "BOTTOM", "FLOAT", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: classes5.dex */
    public enum Zone {
        LEFT,
        RIGHT,
        BOTTOM,
        FLOAT;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Zone> getEntries() {
            return $ENTRIES;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DockLayout(Context ctx, SharedPreferences prefs) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        this.prefs = prefs;
        this.d = getResources().getDisplayMetrics().density;
        this.panels = new ArrayList<>();
        LinearLayout linearLayout = new LinearLayout(ctx);
        linearLayout.setOrientation(0);
        this.main = linearLayout;
        LinearLayout linearLayout2 = new LinearLayout(ctx);
        linearLayout2.setOrientation(1);
        this.leftCol = linearLayout2;
        LinearLayout linearLayout3 = new LinearLayout(ctx);
        linearLayout3.setOrientation(1);
        this.rightCol = linearLayout3;
        LinearLayout linearLayout4 = new LinearLayout(ctx);
        linearLayout4.setOrientation(1);
        this.centerCol = linearLayout4;
        LinearLayout linearLayout5 = new LinearLayout(ctx);
        linearLayout5.setOrientation(0);
        this.bottomRow = linearLayout5;
        this.centerHost = new FrameLayout(ctx);
        this.floatLayer = new FrameLayout(ctx);
        this.overlay = new DropOverlay(this, ctx);
        this.phone = getResources().getConfiguration().smallestScreenWidthDp < 600;
        this.leftW = dp(this.phone ? 220.0f : 270.0f);
        this.rightW = dp(this.phone ? 250.0f : 320.0f);
        this.bottomH = dp(this.phone ? 140.0f : 190.0f);
        setBackgroundColor(Ui.INSTANCE.getBORDER());
        this.leftSplit = new Splitter(ctx, true, new DockLayout$$ExternalSyntheticLambda1(this), new DockLayout$$ExternalSyntheticLambda2(this));
        this.rightSplit = new Splitter(ctx, true, new DockLayout$$ExternalSyntheticLambda3(this), new DockLayout$$ExternalSyntheticLambda4(this));
        this.bottomSplit = new Splitter(ctx, false, new DockLayout$$ExternalSyntheticLambda5(this), new DockLayout$$ExternalSyntheticLambda6(this));
        this.main.addView(this.leftCol, new LinearLayout.LayoutParams(this.leftW, -1));
        this.main.addView(this.leftSplit, new LinearLayout.LayoutParams(this.leftSplit.getThickness(), -1));
        this.main.addView(this.centerCol, new LinearLayout.LayoutParams(0, -1, 1.0f));
        this.main.addView(this.rightSplit, new LinearLayout.LayoutParams(this.rightSplit.getThickness(), -1));
        this.main.addView(this.rightCol, new LinearLayout.LayoutParams(this.rightW, -1));
        this.centerCol.addView(this.centerHost, new LinearLayout.LayoutParams(-1, 0, 1.0f));
        this.centerCol.addView(this.bottomSplit, new LinearLayout.LayoutParams(-1, this.bottomSplit.getThickness()));
        this.centerCol.addView(this.bottomRow, new LinearLayout.LayoutParams(-1, this.bottomH));
        addView(this.main, new FrameLayout.LayoutParams(-1, -1));
        addView(this.floatLayer, new FrameLayout.LayoutParams(-1, -1));
        addView(this.overlay, new FrameLayout.LayoutParams(-1, -1));
        this.overlay.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$10(DockLayout dockLayout) {
        dockLayout.save();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$5(DockLayout dockLayout, float f) {
        dockLayout.leftW = dockLayout.clampW(dockLayout.leftW + ((int) f));
        dockLayout.leftCol.setLayoutParams(new LinearLayout.LayoutParams(dockLayout.leftW, -1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$6(DockLayout dockLayout) {
        dockLayout.save();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$7(DockLayout dockLayout, float f) {
        dockLayout.rightW = dockLayout.clampW(dockLayout.rightW - ((int) f));
        dockLayout.rightCol.setLayoutParams(new LinearLayout.LayoutParams(dockLayout.rightW, -1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$8(DockLayout dockLayout) {
        dockLayout.save();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$9(DockLayout dockLayout, float f) {
        dockLayout.bottomH = dockLayout.clampH(dockLayout.bottomH - ((int) f));
        dockLayout.bottomRow.setLayoutParams(new LinearLayout.LayoutParams(-1, dockLayout.bottomH));
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ int access$dp(DockLayout dockLayout, float f) {
        return dockLayout.dp(f);
    }

    public static final /* synthetic */ float access$getD$p(DockLayout dockLayout) {
        return dockLayout.d;
    }

    public static final /* synthetic */ Target access$target(DockLayout dockLayout, Panel panel, float f, float f2) {
        return dockLayout.target(panel, f, f2);
    }

    public static /* synthetic */ void addPanel$default(DockLayout dockLayout, String str, String str2, View view, Zone zone, int i, boolean z, int i2, Object obj) {
        if ((i2 & 32) != 0) {
            z = true;
        }
        dockLayout.addPanel(str, str2, view, zone, i, z);
    }

    private final void clampFloats() {
        Iterator<Panel> it = this.panels.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Panel next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Panel panel = next;
            FloatFrame frame = panel.getFrame();
            if (frame != null && frame.getParent() == this.floatLayer) {
                ViewGroup.LayoutParams layoutParams = frame.getLayoutParams();
                Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                int coerceAtMost = RangesKt.coerceAtMost(layoutParams2.width, RangesKt.coerceAtLeast(getWidth(), dp(160.0f)));
                int coerceAtMost2 = RangesKt.coerceAtMost(layoutParams2.height, RangesKt.coerceAtLeast(getHeight(), dp(120.0f)));
                int coerceIn = RangesKt.coerceIn(layoutParams2.leftMargin, 0, RangesKt.coerceAtLeast(getWidth() - dp(60.0f), 0));
                int coerceIn2 = RangesKt.coerceIn(layoutParams2.topMargin, 0, RangesKt.coerceAtLeast(getHeight() - dp(30.0f), 0));
                if (coerceAtMost != layoutParams2.width || coerceAtMost2 != layoutParams2.height || coerceIn != layoutParams2.leftMargin || coerceIn2 != layoutParams2.topMargin) {
                    layoutParams2.width = coerceAtMost;
                    layoutParams2.height = coerceAtMost2;
                    layoutParams2.leftMargin = coerceIn;
                    layoutParams2.topMargin = coerceIn2;
                    frame.setLayoutParams(layoutParams2);
                    panel.setFx(coerceIn);
                    panel.setFy(coerceIn2);
                    panel.setFw(coerceAtMost);
                    panel.setFh(coerceAtMost2);
                }
            }
        }
    }

    private final int clampH(int h) {
        return RangesKt.coerceIn(h, dp(60.0f), (int) (getResources().getDisplayMetrics().heightPixels * 0.7f));
    }

    private final int clampW(int w) {
        return RangesKt.coerceIn(w, dp(140.0f), (int) (getResources().getDisplayMetrics().widthPixels * 0.6f));
    }

    private final void decorateHeader(Panel p) {
        ViewGroup headerOf = headerOf(p);
        if (headerOf == null) {
            return;
        }
        Context context = getContext();
        ImageView imageView = new ImageView(context);
        Icons icons = Icons.INSTANCE;
        Intrinsics.checkNotNull(context);
        imageView.setImageDrawable(icons.ui(context, "Grip", "⋮"));
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(dp(12.0f), dp(18.0f));
        layoutParams.rightMargin = dp(2.0f);
        Unit unit = Unit.INSTANCE;
        headerOf.addView(imageView, 0, layoutParams);
        headerOf.addView(Ui.INSTANCE.iconButton(context, Icons.INSTANCE.ui(context, "Float", "F"), 26.0f, new DockLayout$$ExternalSyntheticLambda7(this, p)));
        headerOf.addView(Ui.INSTANCE.iconButton(context, Icons.INSTANCE.ui(context, "CloseWidget", "x"), 26.0f, new DockLayout$$ExternalSyntheticLambda8(this, p)));
        headerOf.setOnTouchListener(new DockLayout$$ExternalSyntheticLambda9(new Ref.FloatRef(), new Ref.FloatRef(), new Ref.BooleanRef(), new Ref.IntRef(), p, new Ref.IntRef(), headerOf, this, new Ref.LongRef()));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit decorateHeader$lambda$34(DockLayout dockLayout, Panel panel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        dockLayout.toggleFloat(panel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit decorateHeader$lambda$35(DockLayout dockLayout, Panel panel, View it) {
        Intrinsics.checkNotNullParameter(it, "it");
        dockLayout.setShown(panel.getId(), false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final boolean decorateHeader$lambda$36(Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.BooleanRef booleanRef, Ref.IntRef intRef, Panel panel, Ref.IntRef intRef2, ViewGroup viewGroup, DockLayout dockLayout, Ref.LongRef longRef, View view, MotionEvent motionEvent) {
        switch (motionEvent.getActionMasked()) {
            case 0:
                floatRef.element = motionEvent.getRawX();
                floatRef2.element = motionEvent.getRawY();
                booleanRef.element = false;
                intRef.element = panel.getFx();
                intRef2.element = panel.getFy();
                ViewParent parent = viewGroup.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 1:
            case 3:
                if (booleanRef.element) {
                    Pair<Float, Float> local = dockLayout.local(motionEvent.getRawX(), motionEvent.getRawY());
                    Target update = dockLayout.overlay.update(panel, local.component1().floatValue(), local.component2().floatValue());
                    dockLayout.overlay.end();
                    if (motionEvent.getActionMasked() == 1) {
                        dockLayout.drop(panel, update);
                    }
                } else if (motionEvent.getActionMasked() == 1) {
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longRef.element < 320) {
                        dockLayout.toggleFloat(panel);
                        longRef.element = 0L;
                    } else {
                        longRef.element = currentTimeMillis;
                    }
                }
                return true;
            case 2:
                if (!booleanRef.element && ((float) Math.hypot(motionEvent.getRawX() - floatRef.element, motionEvent.getRawY() - floatRef2.element)) > dockLayout.d * 10.0f) {
                    booleanRef.element = true;
                    dockLayout.overlay.begin(panel);
                }
                if (booleanRef.element) {
                    if (panel.getZone() == Zone.FLOAT) {
                        FloatFrame frame = panel.getFrame();
                        if ((frame != null ? frame.getParent() : null) == dockLayout.floatLayer) {
                            FloatFrame frame2 = panel.getFrame();
                            Intrinsics.checkNotNull(frame2);
                            ViewGroup.LayoutParams layoutParams = frame2.getLayoutParams();
                            Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
                            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                            layoutParams2.leftMargin = (int) (intRef.element + (motionEvent.getRawX() - floatRef.element));
                            layoutParams2.topMargin = RangesKt.coerceAtLeast((int) (intRef2.element + (motionEvent.getRawY() - floatRef2.element)), 0);
                            frame2.setLayoutParams(layoutParams2);
                        }
                    }
                    Pair<Float, Float> local2 = dockLayout.local(motionEvent.getRawX(), motionEvent.getRawY());
                    dockLayout.overlay.update(panel, local2.component1().floatValue(), local2.component2().floatValue());
                }
                return true;
            default:
                return false;
        }
    }

    private final void detach(View v) {
        ViewParent parent = v.getParent();
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(v);
        }
    }

    private final int dp(float v) {
        return (int) (this.d * v);
    }

    private final void drop(Panel p, Target t) {
        float f;
        if (t.getZone() != Zone.FLOAT) {
            ArrayList<Panel> arrayList = this.panels;
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Panel panel = (Panel) next;
                if (panel.getZone() == t.getZone() && panel.getVisible() && panel != p) {
                    arrayList2.add(next);
                }
            }
            List mutableList = CollectionsKt.toMutableList((Collection) CollectionsKt.sortedWith(arrayList2, new DockLayout$drop$$inlined$sortedBy$1()));
            mutableList.add(RangesKt.coerceIn(t.getIndex(), 0, mutableList.size()), p);
            int i = 0;
            for (Object obj : mutableList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ((Panel) obj).setOrder(i);
                i = i2;
            }
            if (mutableList.size() > 1) {
                ArrayList arrayList3 = new ArrayList();
                for (Object obj2 : mutableList) {
                    if (((Panel) obj2) != p) {
                        arrayList3.add(obj2);
                    }
                }
                ArrayList arrayList4 = arrayList3;
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList4, 10));
                Iterator it2 = arrayList4.iterator();
                while (it2.hasNext()) {
                    arrayList5.add(Float.valueOf(((Panel) it2.next()).getWeight()));
                }
                f = (float) CollectionsKt.averageOfFloat(arrayList5);
            } else {
                f = 1.0f;
            }
            p.setWeight(f);
            p.setZone(t.getZone());
        } else if (p.getZone() != Zone.FLOAT) {
            p.setZone(Zone.FLOAT);
            p.setFw((int) t.getPreview().width());
            p.setFh((int) t.getPreview().height());
            p.setFx((int) t.getPreview().left);
            p.setFy(RangesKt.coerceAtLeast((int) t.getPreview().top, 0));
        } else {
            FloatFrame frame = p.getFrame();
            ViewGroup.LayoutParams layoutParams = frame != null ? frame.getLayoutParams() : null;
            FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
            if (layoutParams2 != null) {
                p.setFx(layoutParams2.leftMargin);
                p.setFy(layoutParams2.topMargin);
            }
        }
        rebuild();
        save();
        Function0<Unit> function0 = this.onChanged;
        if (function0 != null) {
            function0.invoke();
        }
    }

    private final ViewGroup headerOf(Panel p) {
        View view = p.getView();
        ViewGroup viewGroup = view instanceof ViewGroup ? (ViewGroup) view : null;
        View childAt = viewGroup != null ? viewGroup.getChildAt(0) : null;
        if (childAt instanceof ViewGroup) {
            return (ViewGroup) childAt;
        }
        return null;
    }

    private final Pair<Float, Float> local(float rawX, float rawY) {
        getLocationOnScreen(new int[2]);
        return TuplesKt.to(Float.valueOf(rawX - r0[0]), Float.valueOf(rawY - r0[1]));
    }

    private static final void rebuild$fill(List<Panel> list, DockLayout dockLayout, LinearLayout linearLayout, Zone zone, boolean z) {
        LinearLayout linearLayout2;
        boolean z2;
        List list2;
        List list3;
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (((Panel) obj).getZone() == zone) {
                arrayList.add(obj);
            }
        }
        List sortedWith = CollectionsKt.sortedWith(arrayList, new DockLayout$rebuild$fill$$inlined$sortedBy$1());
        List list4 = sortedWith;
        int i = 0;
        for (Object obj2 : list4) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Panel panel = (Panel) obj2;
            int i3 = i;
            if (i3 > 0) {
                Panel panel2 = (Panel) sortedWith.get(i3 - 1);
                Context context = dockLayout.getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                list2 = sortedWith;
                list3 = list4;
                linearLayout2 = linearLayout;
                z2 = z;
                Splitter splitter = new Splitter(context, z2, new DockLayout$$ExternalSyntheticLambda10(dockLayout, linearLayout2, panel2, panel, z2), new DockLayout$$ExternalSyntheticLambda11(dockLayout));
                linearLayout2.addView(splitter, z2 ? new LinearLayout.LayoutParams(splitter.getThickness(), -1) : new LinearLayout.LayoutParams(-1, splitter.getThickness()));
            } else {
                linearLayout2 = linearLayout;
                z2 = z;
                list2 = sortedWith;
                list3 = list4;
            }
            linearLayout2.addView(panel.getView(), z2 ? new LinearLayout.LayoutParams(0, -1, panel.getWeight()) : new LinearLayout.LayoutParams(-1, 0, panel.getWeight()));
            i = i2;
            sortedWith = list2;
            list4 = list3;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rebuild$fill$lambda$25$lambda$23(DockLayout dockLayout, LinearLayout linearLayout, Panel panel, Panel panel2, boolean z, float f) {
        dockLayout.resizePair(linearLayout, panel, panel2, f, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit rebuild$fill$lambda$25$lambda$24(DockLayout dockLayout) {
        dockLayout.save();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final void rebuild$lambda$29(DockLayout dockLayout) {
        dockLayout.clampFloats();
    }

    private final RectF rectIn(View v) {
        v.getLocationOnScreen(new int[2]);
        getLocationOnScreen(new int[2]);
        return new RectF(r1[0] - r0[0], r1[1] - r0[1], (r1[0] - r0[0]) + v.getWidth(), (r1[1] - r0[1]) + v.getHeight());
    }

    private final void resizePair(LinearLayout col, Panel a, Panel b, float delta, boolean horizontal) {
        View view = a.getView();
        int width = horizontal ? view.getWidth() : view.getHeight();
        View view2 = b.getView();
        int width2 = width + (horizontal ? view2.getWidth() : view2.getHeight());
        if (width2 <= 0) {
            return;
        }
        float coerceIn = RangesKt.coerceIn(width + delta, dp(60.0f), width2 - r3);
        float weight = a.getWeight() + b.getWeight();
        a.setWeight((weight * coerceIn) / width2);
        b.setWeight(weight - a.getWeight());
        ViewGroup.LayoutParams layoutParams = a.getView().getLayoutParams();
        LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.weight = a.getWeight();
            a.getView().setLayoutParams(layoutParams2);
        }
        ViewGroup.LayoutParams layoutParams3 = b.getView().getLayoutParams();
        LinearLayout.LayoutParams layoutParams4 = layoutParams3 instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.weight = b.getWeight();
            b.getView().setLayoutParams(layoutParams4);
        }
        col.requestLayout();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x004d A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0028 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final com.exampletest.mobilestudiotest.ui.DockLayout.Target target(com.exampletest.mobilestudiotest.ui.DockLayout.Panel r26, float r27, float r28) {
        /*
            Method dump skipped, instructions count: 487
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.DockLayout.target(com.exampletest.mobilestudiotest.ui.DockLayout$Panel, float, float):com.exampletest.mobilestudiotest.ui.DockLayout$Target");
    }

    private static final Target target$colTarget(List<Panel> list, DockLayout dockLayout, float f, float f2, Zone zone, LinearLayout linearLayout, RectF rectF, boolean z, RectF rectF2) {
        boolean z2;
        RectF rectF3;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((Panel) next).getZone() == zone) {
                arrayList.add(next);
            }
        }
        List sortedWith = CollectionsKt.sortedWith(arrayList, new DockLayout$target$colTarget$$inlined$sortedBy$1());
        if (sortedWith.isEmpty() || rectF == null) {
            return new Target(zone, 0, rectF2);
        }
        Iterator it2 = sortedWith.iterator();
        int i = 0;
        while (it2.hasNext()) {
            int i2 = i;
            i++;
            RectF rectIn = dockLayout.rectIn(((Panel) it2.next()).getView());
            if (!z ? f2 < rectIn.top || f2 > rectIn.bottom : f < rectIn.left || f > rectIn.right) {
                if (!z ? f2 >= rectIn.centerY() : f >= rectIn.centerX()) {
                    z2 = false;
                }
                if (z) {
                    rectF3 = z2 ? new RectF(rectIn.left, rectIn.top, rectIn.centerX(), rectIn.bottom) : new RectF(rectIn.centerX(), rectIn.top, rectIn.right, rectIn.bottom);
                } else {
                    float f3 = rectIn.left;
                    rectF3 = z2 ? new RectF(f3, rectIn.top, rectIn.right, rectIn.centerY()) : new RectF(f3, rectIn.centerY(), rectIn.right, rectIn.bottom);
                }
                return new Target(zone, z2 ? i2 : i2 + 1, rectF3);
            }
        }
        RectF rectIn2 = dockLayout.rectIn(((Panel) CollectionsKt.last(sortedWith)).getView());
        return new Target(zone, sortedWith.size(), z ? new RectF(rectIn2.centerX(), rectIn2.top, rectIn2.right, rectIn2.bottom) : new RectF(rectIn2.left, rectIn2.centerY(), rectIn2.right, rectIn2.bottom));
    }

    private final void toggleFloat(Panel p) {
        Integer num = null;
        if (p.getZone() == Zone.FLOAT) {
            p.setZone(p.getDefZone() == Zone.FLOAT ? Zone.RIGHT : p.getDefZone());
            ArrayList<Panel> arrayList = this.panels;
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = arrayList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                Panel panel = (Panel) next;
                if (panel.getZone() == p.getZone() && panel != p) {
                    r8 = 1;
                }
                if (r8 != 0) {
                    arrayList2.add(next);
                }
            }
            Iterator it2 = arrayList2.iterator();
            if (it2.hasNext()) {
                Integer valueOf = Integer.valueOf(((Panel) it2.next()).getOrder() + 1);
                loop1: while (true) {
                    num = valueOf;
                    while (it2.hasNext()) {
                        valueOf = Integer.valueOf(((Panel) it2.next()).getOrder() + 1);
                        if (num.compareTo(valueOf) < 0) {
                            break;
                        }
                    }
                }
            }
            Integer num2 = num;
            p.setOrder(num2 != null ? num2.intValue() : 0);
        } else {
            RectF rectIn = p.getView().isShown() ? rectIn(p.getView()) : null;
            p.setZone(Zone.FLOAT);
            p.setFw(RangesKt.coerceIn(rectIn != null ? (int) rectIn.width() : dp(300.0f), dp(220.0f), dp(420.0f)));
            p.setFh(RangesKt.coerceIn(rectIn != null ? (int) rectIn.height() : dp(360.0f), dp(200.0f), dp(480.0f)));
            p.setFx(((int) (rectIn != null ? rectIn.left : 0.0f)) + dp(24.0f));
            p.setFy(((int) (rectIn != null ? rectIn.top : 0.0f)) + dp(24.0f));
        }
        rebuild();
        save();
        Function0<Unit> function0 = this.onChanged;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void addPanel(String id, String title, View view, Zone zone, int order, boolean visible) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(zone, "zone");
        Panel panel = new Panel(this, id, title, view, zone, order, visible);
        this.panels.add(panel);
        decorateHeader(panel);
    }

    public final boolean getAllHidden() {
        return this.allHidden;
    }

    public final int getBottomH() {
        return this.bottomH;
    }

    public final int getLeftW() {
        return this.leftW;
    }

    public final Function0<Unit> getOnChanged() {
        return this.onChanged;
    }

    public final int getRightW() {
        return this.rightW;
    }

    public final boolean isShown(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        if (this.allHidden) {
            return false;
        }
        Panel panel = panel(id);
        return panel != null && panel.getVisible();
    }

    public final void load() {
        Zone defZone;
        String string = this.prefs.getString("dock_v1", null);
        if (string == null) {
            Integer valueOf = Integer.valueOf(this.prefs.getInt("toolboxW", -1));
            if (!(valueOf.intValue() > 0)) {
                valueOf = null;
            }
            if (valueOf != null) {
                this.leftW = clampW(valueOf.intValue());
            }
            Integer valueOf2 = Integer.valueOf(this.prefs.getInt("rightW", -1));
            if (!(valueOf2.intValue() > 0)) {
                valueOf2 = null;
            }
            if (valueOf2 != null) {
                this.rightW = clampW(valueOf2.intValue());
            }
            Integer valueOf3 = Integer.valueOf(this.prefs.getInt("outputH", -1));
            Integer num = valueOf3.intValue() > 0 ? valueOf3 : null;
            if (num != null) {
                this.bottomH = clampH(num.intValue());
            }
        }
        if (string != null) {
            try {
                JSONObject jSONObject = new JSONObject(string);
                this.leftW = jSONObject.optInt("leftW", this.leftW);
                this.rightW = jSONObject.optInt("rightW", this.rightW);
                this.bottomH = jSONObject.optInt("bottomH", this.bottomH);
                JSONArray optJSONArray = jSONObject.optJSONArray("panels");
                if (optJSONArray == null) {
                    optJSONArray = new JSONArray();
                }
                int length = optJSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                    String optString = jSONObject2.optString("id");
                    Intrinsics.checkNotNullExpressionValue(optString, "optString(...)");
                    Panel panel = panel(optString);
                    if (panel != null) {
                        try {
                            String optString2 = jSONObject2.optString("zone");
                            Intrinsics.checkNotNullExpressionValue(optString2, "optString(...)");
                            defZone = Zone.valueOf(optString2);
                        } catch (Exception e) {
                            defZone = panel.getDefZone();
                        }
                        panel.setZone(defZone);
                        panel.setOrder(jSONObject2.optInt("order", panel.getOrder()));
                        panel.setWeight(RangesKt.coerceIn((float) jSONObject2.optDouble("weight", 1.0d), 0.05f, 20.0f));
                        panel.setVisible(jSONObject2.optBoolean("visible", panel.getVisible()));
                        panel.setFx(jSONObject2.optInt("fx", -1));
                        panel.setFy(jSONObject2.optInt("fy", -1));
                        panel.setFw(jSONObject2.optInt("fw", 0));
                        panel.setFh(jSONObject2.optInt("fh", 0));
                    }
                }
            } catch (Exception e2) {
            }
        }
        rebuild();
    }

    public final Panel panel(String id) {
        Object obj;
        Intrinsics.checkNotNullParameter(id, "id");
        Iterator<T> it = this.panels.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (Intrinsics.areEqual(((Panel) obj).getId(), id)) {
                break;
            }
        }
        return (Panel) obj;
    }

    public final void rebuild() {
        List list;
        Iterator<Panel> it = this.panels.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Panel next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            detach(next.getView());
        }
        this.leftCol.removeAllViews();
        this.rightCol.removeAllViews();
        this.bottomRow.removeAllViews();
        this.floatLayer.removeAllViews();
        if (this.allHidden) {
            list = CollectionsKt.emptyList();
        } else {
            ArrayList<Panel> arrayList = this.panels;
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : arrayList) {
                if (((Panel) obj).getVisible()) {
                    arrayList2.add(obj);
                }
            }
            list = arrayList2;
        }
        rebuild$fill(list, this, this.leftCol, Zone.LEFT, false);
        rebuild$fill(list, this, this.rightCol, Zone.RIGHT, false);
        rebuild$fill(list, this, this.bottomRow, Zone.BOTTOM, true);
        boolean z = this.leftCol.getChildCount() > 0;
        boolean z2 = this.rightCol.getChildCount() > 0;
        boolean z3 = this.bottomRow.getChildCount() > 0;
        this.leftCol.setVisibility(z ? 0 : 8);
        this.leftSplit.setVisibility(this.leftCol.getVisibility());
        this.rightCol.setVisibility(z2 ? 0 : 8);
        this.rightSplit.setVisibility(this.rightCol.getVisibility());
        this.bottomRow.setVisibility(z3 ? 0 : 8);
        this.bottomSplit.setVisibility(this.bottomRow.getVisibility());
        this.leftCol.setLayoutParams(new LinearLayout.LayoutParams(this.leftW, -1));
        this.rightCol.setLayoutParams(new LinearLayout.LayoutParams(this.rightW, -1));
        this.bottomRow.setLayoutParams(new LinearLayout.LayoutParams(-1, this.bottomH));
        ArrayList<Panel> arrayList3 = new ArrayList();
        for (Object obj2 : list) {
            if (((Panel) obj2).getZone() == Zone.FLOAT) {
                arrayList3.add(obj2);
            }
        }
        for (Panel panel : arrayList3) {
            FloatFrame frame = panel.getFrame();
            if (frame == null) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "getContext(...)");
                frame = new FloatFrame(this, context, panel);
                panel.setFrame(frame);
            }
            frame.attach();
            if (panel.getFw() <= 0) {
                panel.setFw(dp(300.0f));
                panel.setFh(dp(360.0f));
            }
            if (panel.getFx() < 0) {
                panel.setFx((getWidth() - panel.getFw()) / 2);
                panel.setFy(dp(40.0f));
            }
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(panel.getFw(), panel.getFh());
            layoutParams.leftMargin = panel.getFx();
            layoutParams.topMargin = panel.getFy();
            Unit unit = Unit.INSTANCE;
            this.floatLayer.addView(frame, layoutParams);
        }
        post(new DockLayout$$ExternalSyntheticLambda0(this));
    }

    public final void reset() {
        this.prefs.edit().remove("dock_v1").apply();
        this.leftW = dp(this.phone ? 220.0f : 270.0f);
        this.rightW = dp(this.phone ? 250.0f : 320.0f);
        this.bottomH = dp(this.phone ? 140.0f : 190.0f);
        Iterator<Panel> it = this.panels.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Panel next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Panel panel = next;
            panel.setZone(panel.getDefZone());
            panel.setOrder(panel.getDefOrder());
            panel.setWeight(1.0f);
            panel.setVisible(panel.getDefVisible());
            panel.setFx(-1);
            panel.setFy(-1);
            panel.setFw(0);
            panel.setFh(0);
        }
        setAllHidden(false);
        rebuild();
        Function0<Unit> function0 = this.onChanged;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void save() {
        JSONArray jSONArray = new JSONArray();
        Iterator<Panel> it = this.panels.iterator();
        Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
        while (it.hasNext()) {
            Panel next = it.next();
            Intrinsics.checkNotNullExpressionValue(next, "next(...)");
            Panel panel = next;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", panel.getId());
            jSONObject.put("zone", panel.getZone().name());
            jSONObject.put("order", panel.getOrder());
            jSONObject.put("weight", panel.getWeight());
            jSONObject.put("visible", panel.getVisible());
            jSONObject.put("fx", panel.getFx());
            jSONObject.put("fy", panel.getFy());
            jSONObject.put("fw", panel.getFw());
            jSONObject.put("fh", panel.getFh());
            jSONArray.put(jSONObject);
        }
        SharedPreferences.Editor edit = this.prefs.edit();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("leftW", this.leftW);
        jSONObject2.put("rightW", this.rightW);
        jSONObject2.put("bottomH", this.bottomH);
        jSONObject2.put("panels", jSONArray);
        Unit unit = Unit.INSTANCE;
        edit.putString("dock_v1", jSONObject2.toString()).apply();
    }

    public final void setAllHidden(boolean z) {
        this.allHidden = z;
        rebuild();
        Function0<Unit> function0 = this.onChanged;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void setBottomH(int i) {
        this.bottomH = i;
    }

    public final void setCenter(View v) {
        Intrinsics.checkNotNullParameter(v, "v");
        this.centerHost.addView(v, new FrameLayout.LayoutParams(-1, -1));
    }

    public final void setLeftW(int i) {
        this.leftW = i;
    }

    public final void setOnChanged(Function0<Unit> function0) {
        this.onChanged = function0;
    }

    public final void setRightW(int i) {
        this.rightW = i;
    }

    public final void setShown(String id, boolean show) {
        Intrinsics.checkNotNullParameter(id, "id");
        Panel panel = panel(id);
        if (panel == null) {
            return;
        }
        if (this.allHidden && show) {
            setAllHidden(false);
        }
        panel.setVisible(show);
        rebuild();
        save();
        Function0<Unit> function0 = this.onChanged;
        if (function0 != null) {
            function0.invoke();
        }
    }

    public final void toggle(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        Panel panel = panel(id);
        boolean z = true;
        if ((panel != null && panel.getVisible()) && !this.allHidden) {
            z = false;
        }
        setShown(id, z);
    }
}
