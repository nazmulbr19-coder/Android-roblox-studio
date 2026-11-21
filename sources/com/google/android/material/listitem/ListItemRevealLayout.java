package com.google.android.material.listitem;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class ListItemRevealLayout extends ViewGroup implements RevealableListItem {
    private static final int UNSET = -1;
    private int intrinsicHeight;
    private int intrinsicWidth;
    private int minChildWidth;
    private int[] originalChildHeights;
    private int[] originalChildWidths;
    private int originalHeightMeasureSpec;
    private int originalWidthMeasureSpec;
    private int primaryActionSwipeMode;
    private int revealedWidth;
    private WeakReference<View> siblingSwipeableView;

    public ListItemRevealLayout(Context context) {
        this(context, null);
    }

    public ListItemRevealLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.listItemRevealLayoutStyle);
    }

    public ListItemRevealLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, R.style.Widget_Material3_ListItemRevealLayout);
    }

    public ListItemRevealLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        this.intrinsicWidth = -1;
        this.intrinsicHeight = -1;
        this.revealedWidth = 0;
        this.originalWidthMeasureSpec = -1;
        this.originalHeightMeasureSpec = -1;
        Context context2 = getContext();
        setClipToPadding(false);
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.ListItemRevealLayout, i, i2, new int[0]);
        this.minChildWidth = obtainTintedStyledAttributes.getDimensionPixelSize(R.styleable.ListItemRevealLayout_minChildWidth, getResources().getDimensionPixelSize(R.dimen.m3_list_reveal_min_child_width));
        this.primaryActionSwipeMode = obtainTintedStyledAttributes.getInt(R.styleable.ListItemRevealLayout_primaryActionSwipeMode, 0);
        obtainTintedStyledAttributes.recycle();
    }

    private int calculateFullRevealableWidth() {
        return (this.siblingSwipeableView == null || this.siblingSwipeableView.get() == null) ? getParent() instanceof View ? ((View) getParent()).getMeasuredWidth() : this.intrinsicWidth : this.siblingSwipeableView.get().getMeasuredWidth();
    }

    private Integer findFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).getVisibility() != 8) {
                return Integer.valueOf(i);
            }
        }
        return null;
    }

    private Integer findLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (getChildAt(childCount).getVisibility() != 8) {
                return Integer.valueOf(childCount);
            }
        }
        return null;
    }

    private View findSiblingSwipeableView() {
        if (!(getParent() instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) getParent();
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof SwipeableListItem) {
                return childAt;
            }
        }
        return null;
    }

    private void measureByGrowingPrimarySwipeAction(int i) {
        Integer findFirstVisibleChildIndex = ListItemUtils.isRightAligned(this) == (getLayoutDirection() == 1) ? findFirstVisibleChildIndex() : findLastVisibleChildIndex();
        if (findFirstVisibleChildIndex != null) {
            int paddingStart = getPaddingStart() + getPaddingEnd();
            float max = Math.max(0.0f, Math.min(1.0f, (this.revealedWidth - this.intrinsicWidth) / (i - this.intrinsicWidth)));
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8 && i2 != findFirstVisibleChildIndex.intValue()) {
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(AnimationUtils.lerp(Math.max(this.originalChildWidths[i2], this.minChildWidth), this.minChildWidth, max), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.originalChildHeights[i2], BasicMeasure.EXACTLY));
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                    paddingStart += marginLayoutParams.leftMargin + marginLayoutParams.rightMargin + this.minChildWidth;
                    if ((childAt instanceof MaterialButton) && ((MaterialButton) childAt).getIcon() != null) {
                        ((MaterialButton) childAt).getIcon().setAlpha(AnimationUtils.lerp(255, 0, max));
                    }
                }
            }
            View childAt2 = getChildAt(findFirstVisibleChildIndex.intValue());
            ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) childAt2.getLayoutParams();
            childAt2.measure(View.MeasureSpec.makeMeasureSpec(AnimationUtils.lerp(this.originalChildWidths[findFirstVisibleChildIndex.intValue()], ((i - paddingStart) - marginLayoutParams2.rightMargin) - marginLayoutParams2.leftMargin, max) + Math.max(this.revealedWidth - i, 0), BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.originalChildHeights[findFirstVisibleChildIndex.intValue()], BasicMeasure.EXACTLY));
            if ((childAt2 instanceof MaterialButton) && ((MaterialButton) childAt2).getIcon() != null) {
                ((MaterialButton) childAt2).getIcon().setAlpha(255);
            }
        }
        setMeasuredDimension(this.revealedWidth, this.intrinsicHeight);
    }

    private void measureByPreservingSwipeActionRatios(int i) {
        int lerp = (int) AnimationUtils.lerp(0.0f, 255.0f, this.intrinsicWidth / 4.0f, this.intrinsicWidth / 2.0f, this.revealedWidth);
        float f = this.revealedWidth / this.intrinsicWidth;
        int i2 = 0;
        int paddingLeft = (int) (getPaddingLeft() * f);
        int paddingRight = (int) (getPaddingRight() * f);
        for (int i3 = 0; i3 < i; i3++) {
            View childAt = getChildAt(i3);
            if (childAt.getVisibility() != 8) {
                int max = Math.max(this.minChildWidth, (int) (this.originalChildWidths[i3] * f));
                childAt.measure(View.MeasureSpec.makeMeasureSpec(max, BasicMeasure.EXACTLY), View.MeasureSpec.makeMeasureSpec(this.originalChildHeights[i3], BasicMeasure.EXACTLY));
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i2 += max + ((int) (marginLayoutParams.leftMargin * f)) + ((int) (marginLayoutParams.rightMargin * f));
                if ((childAt instanceof MaterialButton) && ((MaterialButton) childAt).getIcon() != null) {
                    ((MaterialButton) childAt).getIcon().setAlpha(lerp);
                }
            }
        }
        setMeasuredDimension(Math.max(this.revealedWidth, i2 + paddingLeft + paddingRight), this.intrinsicHeight);
    }

    private void saveOriginalChildSizes(int i) {
        this.originalChildWidths = new int[i];
        this.originalChildHeights = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() != 8) {
                this.originalChildWidths[i2] = childAt.getMeasuredWidth();
                this.originalChildHeights[i2] = childAt.getMeasuredHeight();
                if (((ViewGroup.MarginLayoutParams) childAt.getLayoutParams()).height == -1) {
                    this.originalChildHeights[i2] = this.intrinsicHeight;
                }
            }
        }
    }

    private boolean shouldRemeasureIntrinsicSizes(int i, int i2, int i3) {
        if (i3 == -1) {
            return true;
        }
        if (i == i2) {
            return false;
        }
        int mode = View.MeasureSpec.getMode(i2);
        return (mode == 0 || (mode == 1073741824 && View.MeasureSpec.getSize(i2) == i3)) ? false : true;
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-2, -2);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    @Override // android.view.ViewGroup
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    @Override // com.google.android.material.listitem.RevealableListItem
    public int getIntrinsicWidth() {
        if (this.intrinsicWidth != -1) {
            return this.intrinsicWidth;
        }
        return 0;
    }

    public int getMinChildWidth() {
        return this.minChildWidth;
    }

    @Override // com.google.android.material.listitem.RevealableListItem
    public int getPrimaryActionSwipeMode() {
        return this.primaryActionSwipeMode;
    }

    void measureIntrinsicSize(int i, int i2) {
        int i3;
        int i4;
        int i5 = 0;
        int childCount = getChildCount();
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (i7 < childCount) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() == 8) {
                i3 = i;
                i4 = i2;
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                i3 = i;
                i4 = i2;
                measureChildWithMargins(childAt, i3, i8, i4, 0);
                i8 += childAt.getMeasuredWidth() + marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                i5 = Math.max(i5, childAt.getMeasuredHeight() + marginLayoutParams.topMargin + marginLayoutParams.bottomMargin);
                i6 = combineMeasuredStates(i6, childAt.getMeasuredState());
            }
            i7++;
            i = i3;
            i2 = i4;
        }
        int i9 = i;
        int i10 = i2;
        int max = Math.max(i8 + getPaddingLeft() + getPaddingRight(), getSuggestedMinimumWidth());
        int resolveSizeAndState = 16777215 & resolveSizeAndState(Math.max(i5 + getPaddingTop() + getPaddingBottom(), getSuggestedMinimumHeight()), i10, 0);
        this.intrinsicWidth = resolveSizeAndState(max, i9, 0);
        this.intrinsicHeight = resolveSizeAndState(resolveSizeAndState, i10, i6 << 16);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        float f;
        ListItemRevealLayout listItemRevealLayout = this;
        float f2 = listItemRevealLayout.revealedWidth >= listItemRevealLayout.intrinsicWidth ? 1.0f : listItemRevealLayout.revealedWidth / listItemRevealLayout.intrinsicWidth;
        int paddingLeft = (int) (listItemRevealLayout.getPaddingLeft() * f2);
        int paddingTop = listItemRevealLayout.getPaddingTop();
        int childCount = listItemRevealLayout.getChildCount();
        int i5 = 0;
        int i6 = 1;
        if (listItemRevealLayout.getLayoutDirection() == 1) {
            i5 = childCount - 1;
            i6 = -1;
        }
        int i7 = 0;
        while (i7 < childCount) {
            View childAt = listItemRevealLayout.getChildAt((i6 * i7) + i5);
            if (childAt.getVisibility() == 8) {
                f = f2;
            } else {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) childAt.getLayoutParams();
                int measuredWidth = childAt.getMeasuredWidth();
                int measuredHeight = childAt.getMeasuredHeight();
                int i8 = marginLayoutParams.topMargin + paddingTop;
                int i9 = (int) (marginLayoutParams.leftMargin * f2);
                int i10 = paddingLeft + i9;
                f = f2;
                childAt.layout(i10, i8, i10 + measuredWidth, i8 + measuredHeight);
                paddingLeft += i9 + measuredWidth + ((int) (marginLayoutParams.rightMargin * f2));
            }
            i7++;
            listItemRevealLayout = this;
            f2 = f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int childCount = getChildCount();
        if (shouldRemeasureIntrinsicSizes(this.originalHeightMeasureSpec, i2, this.intrinsicHeight) || shouldRemeasureIntrinsicSizes(this.originalWidthMeasureSpec, i, this.intrinsicWidth)) {
            this.originalHeightMeasureSpec = i2;
            this.originalWidthMeasureSpec = i;
            measureIntrinsicSize(i, i2);
            saveOriginalChildSizes(childCount);
        }
        if (this.siblingSwipeableView == null || this.siblingSwipeableView.get() == null) {
            this.siblingSwipeableView = new WeakReference<>(findSiblingSwipeableView());
        }
        int swipeMaxOvershoot = this.siblingSwipeableView.get() != null ? ((SwipeableListItem) this.siblingSwipeableView.get()).getSwipeMaxOvershoot() : 0;
        int calculateFullRevealableWidth = calculateFullRevealableWidth();
        setVisibility(this.revealedWidth == 0 ? 4 : 0);
        if (this.revealedWidth == 0) {
            setMeasuredDimension(0, this.intrinsicHeight);
            return;
        }
        if (childCount == 0) {
            setMeasuredDimension(this.revealedWidth, this.intrinsicHeight);
        } else if (this.primaryActionSwipeMode == 0 || this.revealedWidth <= this.intrinsicWidth + swipeMaxOvershoot || calculateFullRevealableWidth <= this.intrinsicWidth) {
            measureByPreservingSwipeActionRatios(childCount);
        } else {
            measureByGrowingPrimarySwipeAction(calculateFullRevealableWidth);
        }
    }

    public void resetIntrinsicWidth() {
        this.intrinsicWidth = -1;
        requestLayout();
    }

    public void setMinChildWidth(int i) {
        if (this.minChildWidth == i) {
            return;
        }
        this.minChildWidth = i;
        requestLayout();
    }

    @Override // com.google.android.material.listitem.RevealableListItem
    public void setPrimaryActionSwipeMode(int i) {
        this.primaryActionSwipeMode = i;
    }

    @Override // com.google.android.material.listitem.RevealableListItem
    public void setRevealedWidth(int i) {
        int max = Math.max(0, i);
        if (this.revealedWidth == max) {
            return;
        }
        this.revealedWidth = max;
        requestLayout();
    }
}
