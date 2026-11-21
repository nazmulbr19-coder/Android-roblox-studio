package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Splitter.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007\u0012\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u001bH\u0014J\u0010\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u001eH\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0015\u001a\u00020\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/Splitter;", "Landroid/view/View;", "ctx", "Landroid/content/Context;", "vertical", "", "onDrag", "Lkotlin/Function1;", "", "", "onEnd", "Lkotlin/Function0;", "<init>", "(Landroid/content/Context;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getVertical", "()Z", "paint", "Landroid/graphics/Paint;", "dragging", "last", "d", "thickness", "", "getThickness", "()I", "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", "e", "Landroid/view/MotionEvent;", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Splitter extends View {
    private final float d;
    private boolean dragging;
    private float last;
    private final Function1<Float, Unit> onDrag;
    private final Function0<Unit> onEnd;
    private final Paint paint;
    private final boolean vertical;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Splitter(Context ctx, boolean z, Function1<? super Float, Unit> onDrag, Function0<Unit> onEnd) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        Intrinsics.checkNotNullParameter(onDrag, "onDrag");
        Intrinsics.checkNotNullParameter(onEnd, "onEnd");
        this.vertical = z;
        this.onDrag = onDrag;
        this.onEnd = onEnd;
        this.paint = new Paint();
        this.d = getResources().getDisplayMetrics().density;
        setBackgroundColor(Ui.INSTANCE.getBORDER());
    }

    public /* synthetic */ Splitter(Context context, boolean z, Function1 function1, Function0 function0, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, z, function1, (i & 8) != 0 ? new Splitter$$ExternalSyntheticLambda0() : function0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit _init_$lambda$0() {
        return Unit.INSTANCE;
    }

    public final int getThickness() {
        return (int) (this.d * 12.0f);
    }

    public final boolean getVertical() {
        return this.vertical;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        this.paint.setColor(this.dragging ? Ui.INSTANCE.getACCENT() : -10855846);
        if (this.dragging) {
            canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.paint);
            return;
        }
        float width = getWidth() / 2.0f;
        float height = getHeight() / 2.0f;
        for (int i = -2; i < 3; i++) {
            if (this.vertical) {
                canvas.drawCircle(width, (i * 5.0f * this.d) + height, this.d * 1.3f, this.paint);
            } else {
                canvas.drawCircle((i * 5.0f * this.d) + width, height, this.d * 1.3f, this.paint);
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0053, code lost:
    
        return true;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            java.lang.String r0 = "e"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            boolean r0 = r5.vertical
            if (r0 == 0) goto Le
            float r0 = r6.getRawX()
            goto L12
        Le:
            float r0 = r6.getRawY()
        L12:
            int r1 = r6.getActionMasked()
            r2 = 0
            r3 = 1
            switch(r1) {
                case 0: goto L43;
                case 1: goto L38;
                case 2: goto L1c;
                case 3: goto L38;
                default: goto L1b;
            }
        L1b:
            goto L53
        L1c:
            boolean r1 = r5.dragging
            if (r1 == 0) goto L53
            float r1 = r5.last
            float r1 = r0 - r1
            r5.last = r0
            r4 = 0
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 != 0) goto L2c
            r2 = r3
        L2c:
            if (r2 != 0) goto L53
            kotlin.jvm.functions.Function1<java.lang.Float, kotlin.Unit> r2 = r5.onDrag
            java.lang.Float r4 = java.lang.Float.valueOf(r1)
            r2.invoke(r4)
            goto L53
        L38:
            r5.dragging = r2
            r5.invalidate()
            kotlin.jvm.functions.Function0<kotlin.Unit> r1 = r5.onEnd
            r1.invoke()
            goto L53
        L43:
            r5.dragging = r3
            r5.last = r0
            android.view.ViewParent r1 = r5.getParent()
            if (r1 == 0) goto L50
            r1.requestDisallowInterceptTouchEvent(r3)
        L50:
            r5.invalidate()
        L53:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.exampletest.mobilestudiotest.ui.Splitter.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
