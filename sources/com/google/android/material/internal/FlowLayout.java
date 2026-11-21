package com.google.android.material.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.material.R;

/* loaded from: classes.dex */
public class FlowLayout extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private int rowCount;
    private boolean singleLine;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.singleLine = false;
        loadFromAttributes(context, attributeSet);
    }

    private static int getMeasuredDimension(int i, int i2, int i3) {
        switch (i2) {
            case Integer.MIN_VALUE:
                return Math.min(i3, i);
            case BasicMeasure.EXACTLY /* 1073741824 */:
                return i;
            default:
                return i3;
        }
    }

    private void loadFromAttributes(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.FlowLayout, 0, 0);
        this.lineSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_lineSpacing, 0);
        this.itemSpacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.FlowLayout_horizontalItemSpacing, 0);
        obtainStyledAttributes.recycle();
    }

    protected int getItemSpacing() {
        return this.itemSpacing;
    }

    protected int getLineSpacing() {
        return this.lineSpacing;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowIndex(View view) {
        Object tag = view.getTag(R.id.row_index_key);
        if (tag instanceof Integer) {
            return ((Integer) tag).intValue();
        }
        return -1;
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        if (getChildCount() == 0) {
            this.rowCount = 0;
            return;
        }
        int i6 = 1;
        this.rowCount = 1;
        boolean z2 = getLayoutDirection() == 1;
        int paddingRight = z2 ? getPaddingRight() : getPaddingLeft();
        int paddingLeft = z2 ? getPaddingLeft() : getPaddingRight();
        int i7 = paddingRight;
        int paddingTop = getPaddingTop();
        int i8 = paddingTop;
        int i9 = 0;
        while (i9 < getChildCount()) {
            View childAt = getChildAt(i9);
            if (childAt.getVisibility() == 8) {
                childAt.setTag(R.id.row_index_key, -1);
                i5 = i6;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                int i10 = 0;
                int i11 = 0;
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i10 = marginLayoutParams.getMarginStart();
                    i11 = marginLayoutParams.getMarginEnd();
                }
                int measuredWidth = i7 + i10 + childAt.getMeasuredWidth();
                int i12 = (i3 - i) - paddingLeft;
                if (!this.singleLine && measuredWidth > i12) {
                    i7 = paddingRight;
                    measuredWidth = i7 + i10 + childAt.getMeasuredWidth();
                    paddingTop = i8 + this.lineSpacing;
                    this.rowCount += i6;
                }
                i5 = i6;
                childAt.setTag(R.id.row_index_key, Integer.valueOf(this.rowCount - 1));
                int measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                if (z2) {
                    childAt.layout((i3 - i) - measuredWidth, paddingTop, ((i3 - i) - i7) - i10, measuredHeight);
                } else {
                    childAt.layout(i7 + i10, paddingTop, measuredWidth, measuredHeight);
                }
                i7 += i10 + i11 + childAt.getMeasuredWidth() + this.itemSpacing;
                i8 = measuredHeight;
            }
            i9++;
            i6 = i5;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3;
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        int i4 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size : Integer.MAX_VALUE;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i5 = paddingTop;
        int i6 = 0;
        int paddingRight = i4 - getPaddingRight();
        int i7 = 0;
        while (i7 < getChildCount()) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                i3 = i4;
            } else {
                measureChild(childAt, i, i2);
                i3 = i4;
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                int i8 = 0;
                int i9 = 0;
                int i10 = paddingLeft;
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i8 = 0 + marginLayoutParams.leftMargin;
                    i9 = 0 + marginLayoutParams.rightMargin;
                }
                if (i10 + i8 + childAt.getMeasuredWidth() > paddingRight && !isSingleLine()) {
                    int paddingLeft2 = getPaddingLeft();
                    paddingTop = i5 + this.lineSpacing;
                    i10 = paddingLeft2;
                }
                int measuredWidth = i10 + i8 + childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight() + paddingTop;
                if (measuredWidth > i6) {
                    i6 = measuredWidth;
                }
                int measuredWidth2 = i10 + i8 + i9 + childAt.getMeasuredWidth() + this.itemSpacing;
                if (i7 == getChildCount() - 1) {
                    i6 += i9;
                    i5 = measuredHeight;
                    paddingLeft = measuredWidth2;
                } else {
                    i5 = measuredHeight;
                    paddingLeft = measuredWidth2;
                }
            }
            i7++;
            i4 = i3;
        }
        setMeasuredDimension(getMeasuredDimension(size, mode, i6 + getPaddingRight()), getMeasuredDimension(size2, mode2, i5 + getPaddingBottom()));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setItemSpacing(int i) {
        this.itemSpacing = i;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setLineSpacing(int i) {
        this.lineSpacing = i;
    }

    public void setSingleLine(boolean z) {
        this.singleLine = z;
    }
}
