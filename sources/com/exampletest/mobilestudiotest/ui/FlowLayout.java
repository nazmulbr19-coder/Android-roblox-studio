package com.exampletest.mobilestudiotest.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioBrowser.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0007H\u0014J0\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0007H\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0017"}, d2 = {"Lcom/exampletest/mobilestudiotest/ui/FlowLayout;", "Landroid/view/ViewGroup;", "ctx", "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "gap", "", "getGap", "()I", "setGap", "(I)V", "onMeasure", "", "wSpec", "hSpec", "onLayout", "changed", "", "l", "t", "r", "b", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class FlowLayout extends ViewGroup {
    private int gap;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public FlowLayout(Context ctx) {
        super(ctx);
        Intrinsics.checkNotNullParameter(ctx, "ctx");
        this.gap = Ui.INSTANCE.dp(ctx, 6.0f);
    }

    public final int getGap() {
        return this.gap;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int paddingLeft = ((r - l) - getPaddingLeft()) - getPaddingRight();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                if (i > 0 && childAt.getMeasuredWidth() + i > paddingLeft) {
                    i = 0;
                    i2 += this.gap + i3;
                    i3 = 0;
                }
                childAt.layout(getPaddingLeft() + i, getPaddingTop() + i2, getPaddingLeft() + i + childAt.getMeasuredWidth(), getPaddingTop() + i2 + childAt.getMeasuredHeight());
                i += childAt.getMeasuredWidth() + this.gap;
                i3 = Math.max(i3, childAt.getMeasuredHeight());
            }
        }
    }

    @Override // android.view.View
    protected void onMeasure(int wSpec, int hSpec) {
        int size = View.MeasureSpec.getSize(wSpec);
        if (size == 0) {
            size = Integer.MAX_VALUE;
        }
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                measureChild(childAt, View.MeasureSpec.makeMeasureSpec(paddingLeft, Integer.MIN_VALUE), View.MeasureSpec.makeMeasureSpec(0, 0));
                if (i > 0 && childAt.getMeasuredWidth() + i > paddingLeft) {
                    i = 0;
                    i2 += this.gap + i3;
                    i3 = 0;
                }
                i += childAt.getMeasuredWidth() + this.gap;
                i3 = Math.max(i3, childAt.getMeasuredHeight());
            }
        }
        setMeasuredDimension(View.MeasureSpec.getSize(wSpec), i2 + i3 + getPaddingTop() + getPaddingBottom());
    }

    public final void setGap(int i) {
        this.gap = i;
    }
}
