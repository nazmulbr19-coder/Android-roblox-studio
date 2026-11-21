package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.R;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;

/* loaded from: classes.dex */
public class AlertDialogLayout extends LinearLayoutCompat {
    public AlertDialogLayout(Context context) {
        super(context);
    }

    public AlertDialogLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void forceUniformWidth(int i, int i2) {
        int i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), BasicMeasure.EXACTLY);
        int i4 = 0;
        while (i4 < i) {
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                if (layoutParams.width == -1) {
                    int i5 = layoutParams.height;
                    layoutParams.height = childAt.getMeasuredHeight();
                    i3 = i2;
                    measureChildWithMargins(childAt, makeMeasureSpec, 0, i3, 0);
                    layoutParams.height = i5;
                } else {
                    i3 = i2;
                }
            } else {
                i3 = i2;
            }
            i4++;
            i2 = i3;
        }
    }

    private static int resolveMinimumHeight(View view) {
        int minimumHeight = ViewCompat.getMinimumHeight(view);
        if (minimumHeight > 0) {
            return minimumHeight;
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 1) {
                return resolveMinimumHeight(viewGroup.getChildAt(0));
            }
        }
        return 0;
    }

    private void setChildFrame(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    private boolean tryOnMeasure(int i, int i2) {
        View view = null;
        View view2 = null;
        View view3 = null;
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int id = childAt.getId();
                if (id == R.id.topPanel) {
                    view = childAt;
                } else if (id == R.id.buttonPanel) {
                    view2 = childAt;
                } else {
                    if ((id != R.id.contentPanel && id != R.id.customPanel) || view3 != null) {
                        return false;
                    }
                    view3 = childAt;
                }
            }
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int i4 = 0;
        int paddingTop = getPaddingTop() + getPaddingBottom();
        if (view != null) {
            view.measure(i, 0);
            paddingTop += view.getMeasuredHeight();
            i4 = View.combineMeasuredStates(0, view.getMeasuredState());
        }
        int i5 = 0;
        int i6 = 0;
        if (view2 != null) {
            view2.measure(i, 0);
            i5 = resolveMinimumHeight(view2);
            i6 = view2.getMeasuredHeight() - i5;
            paddingTop += i5;
            i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
        }
        int i7 = 0;
        if (view3 != null) {
            view3.measure(i, mode == 0 ? 0 : View.MeasureSpec.makeMeasureSpec(Math.max(0, size - paddingTop), mode));
            i7 = view3.getMeasuredHeight();
            paddingTop += i7;
            i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
        }
        int i8 = size - paddingTop;
        if (view2 != null) {
            int i9 = paddingTop - i5;
            int min = Math.min(i8, i6);
            if (min > 0) {
                i8 -= min;
                i5 += min;
            }
            view2.measure(i, View.MeasureSpec.makeMeasureSpec(i5, BasicMeasure.EXACTLY));
            paddingTop = i9 + view2.getMeasuredHeight();
            i4 = View.combineMeasuredStates(i4, view2.getMeasuredState());
            i8 = i8;
        }
        if (view3 != null && i8 > 0) {
            int i10 = i8;
            view3.measure(i, View.MeasureSpec.makeMeasureSpec(i7 + i10, mode));
            paddingTop = (paddingTop - i7) + view3.getMeasuredHeight();
            i4 = View.combineMeasuredStates(i4, view3.getMeasuredState());
            i8 -= i10;
        }
        int i11 = 0;
        int i12 = 0;
        while (i12 < childCount) {
            View childAt2 = getChildAt(i12);
            int i13 = i12;
            View view4 = view2;
            if (childAt2.getVisibility() != 8) {
                i11 = Math.max(i11, childAt2.getMeasuredWidth());
            }
            i12 = i13 + 1;
            view2 = view4;
        }
        setMeasuredDimension(View.resolveSizeAndState(i11 + getPaddingLeft() + getPaddingRight(), i, i4), View.resolveSizeAndState(paddingTop, i2, 0));
        if (mode2 == 1073741824) {
            return true;
        }
        forceUniformWidth(childCount, i2);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int paddingTop;
        int i5;
        int i6;
        int i7;
        int i8;
        AlertDialogLayout alertDialogLayout = this;
        int paddingLeft = alertDialogLayout.getPaddingLeft();
        int i9 = i3 - i;
        int paddingRight = i9 - alertDialogLayout.getPaddingRight();
        int paddingRight2 = (i9 - paddingLeft) - alertDialogLayout.getPaddingRight();
        int measuredHeight = alertDialogLayout.getMeasuredHeight();
        int childCount = alertDialogLayout.getChildCount();
        int gravity = alertDialogLayout.getGravity();
        int i10 = gravity & 112;
        int i11 = gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
        switch (i10) {
            case 16:
                paddingTop = alertDialogLayout.getPaddingTop() + (((i4 - i2) - measuredHeight) / 2);
                break;
            case 80:
                paddingTop = ((alertDialogLayout.getPaddingTop() + i4) - i2) - measuredHeight;
                break;
            default:
                paddingTop = alertDialogLayout.getPaddingTop();
                break;
        }
        Drawable dividerDrawable = alertDialogLayout.getDividerDrawable();
        int intrinsicHeight = dividerDrawable == null ? 0 : dividerDrawable.getIntrinsicHeight();
        int i12 = 0;
        while (i12 < childCount) {
            int i13 = paddingTop;
            View childAt = alertDialogLayout.getChildAt(i12);
            if (childAt == null || childAt.getVisibility() == 8) {
                i5 = i12;
                i6 = paddingLeft;
                i7 = i9;
            } else {
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight2 = childAt.getMeasuredHeight();
                i6 = paddingLeft;
                LinearLayoutCompat.LayoutParams layoutParams = (LinearLayoutCompat.LayoutParams) childAt.getLayoutParams();
                int i14 = layoutParams.gravity;
                if (i14 < 0) {
                    i14 = i11;
                }
                i7 = i9;
                switch (GravityCompat.getAbsoluteGravity(i14, alertDialogLayout.getLayoutDirection()) & 7) {
                    case 1:
                        i8 = ((i6 + ((paddingRight2 - measuredWidth) / 2)) + layoutParams.leftMargin) - layoutParams.rightMargin;
                        break;
                    case 5:
                        i8 = (paddingRight - measuredWidth) - layoutParams.rightMargin;
                        break;
                    default:
                        i8 = i6 + layoutParams.leftMargin;
                        break;
                }
                int i15 = layoutParams.topMargin + (alertDialogLayout.hasDividerBeforeChildAt(i12) ? i13 + intrinsicHeight : i13);
                i5 = i12;
                alertDialogLayout.setChildFrame(childAt, i8, i15, measuredWidth, measuredHeight2);
                i13 = i15 + layoutParams.bottomMargin + measuredHeight2;
            }
            paddingTop = i13;
            i12 = i5 + 1;
            alertDialogLayout = this;
            paddingLeft = i6;
            i9 = i7;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.appcompat.widget.LinearLayoutCompat, android.view.View
    public void onMeasure(int i, int i2) {
        if (tryOnMeasure(i, i2)) {
            return;
        }
        super.onMeasure(i, i2);
    }
}
