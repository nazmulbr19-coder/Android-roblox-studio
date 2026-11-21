package com.google.android.material.datepicker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.focus.FocusRingDrawable;
import com.google.android.material.internal.ViewUtils;
import java.util.Calendar;

/* loaded from: classes.dex */
final class MaterialCalendarGridView extends GridView {
    private final Calendar dayCompute;
    private final boolean nestedScrollable;
    private MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener;

    /* renamed from: com.google.android.material.datepicker.MaterialCalendarGridView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AccessibilityDelegateCompat {
        AnonymousClass1() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setCollectionInfo(null);
        }
    }

    public MaterialCalendarGridView(Context context) {
        this(context, null);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaterialCalendarGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.dayCompute = UtcDates.getUtcCalendar();
        if (MaterialDatePicker.isFullscreen(getContext())) {
            setNextFocusLeftId(R.id.cancel_button);
            setNextFocusRightId(R.id.confirm_button);
        }
        this.nestedScrollable = MaterialDatePicker.isNestedScrollable(getContext());
        ViewCompat.setAccessibilityDelegate(this, new AnonymousClass1());
    }

    private void ensureFocusRingSelector(MonthAdapter monthAdapter) {
        Drawable selector = getSelector();
        if (selector instanceof FocusRingDrawable) {
            return;
        }
        Drawable wrap = FocusRingDrawable.wrap(getContext(), selector);
        if (wrap instanceof FocusRingDrawable) {
            FocusRingDrawable focusRingDrawable = (FocusRingDrawable) wrap;
            if (monthAdapter.calendarStyle != null) {
                focusRingDrawable.setFocusRingShapeAppearance(monthAdapter.calendarStyle.day.getItemShapeAppearanceModel());
            }
            setDrawSelectorOnTop(true);
            setSelector(focusRingDrawable);
        }
    }

    private void gainFocus(int i, Rect rect) {
        int i2 = -1;
        if (i == 33 || i == 1) {
            i2 = getAdapter().findLastValidDayPosition();
        } else if (i == 130 || i == 2) {
            i2 = getAdapter().findFirstValidDayPosition();
        }
        if (i2 != -1) {
            setSelection(i2);
        } else {
            super.onFocusChanged(true, i, rect);
        }
    }

    private View getChildAtPosition(int i) {
        return getChildAt(i - getFirstVisiblePosition());
    }

    private boolean handleHorizontalNavigation(int i, boolean z) {
        int findNextValidDayPosition = z ? getAdapter().findNextValidDayPosition(i) : getAdapter().findPreviousValidDayPosition(i);
        if (findNextValidDayPosition != -1) {
            setSelection(findNextValidDayPosition);
            return true;
        }
        if (!z && this.onMonthNavigationListener != null) {
            return this.onMonthNavigationListener.onMonthNavigationPrevious();
        }
        if (!z || this.onMonthNavigationListener == null) {
            return true;
        }
        return this.onMonthNavigationListener.onMonthNavigationNext();
    }

    private boolean handleTabNavigation(int i, KeyEvent keyEvent) {
        int findPreviousValidDayPosition = keyEvent.isShiftPressed() ? getAdapter().findPreviousValidDayPosition(i) : getAdapter().findNextValidDayPosition(i);
        if (findPreviousValidDayPosition == -1) {
            return false;
        }
        setSelection(findPreviousValidDayPosition);
        return true;
    }

    private static int horizontalMidPoint(View view) {
        return view.getLeft() + (view.getWidth() / 2);
    }

    private static boolean skipMonth(Long l, Long l2, Long l3, Long l4) {
        return l == null || l2 == null || l3 == null || l4 == null || l3.longValue() > l2.longValue() || l4.longValue() < l.longValue();
    }

    private boolean trySelectNearestValidDayPosition(int i) {
        int findNearestValidDayPositionInRow = getAdapter().findNearestValidDayPositionInRow(i);
        if (findNearestValidDayPositionInRow == -1) {
            return false;
        }
        setSelection(findNearestValidDayPositionInRow);
        return true;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // android.widget.GridView, android.widget.AdapterView
    public /* bridge */ /* synthetic */ ListAdapter getAdapter() {
        return getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    /* renamed from: getAdapter, reason: avoid collision after fix types in other method */
    public /* bridge */ /* synthetic */ ListAdapter getAdapter2() {
        return getAdapter();
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public ListAdapter getAdapter() {
        return (MonthAdapter) super.getAdapter();
    }

    boolean handleVerticalNavigationOnDisabledDay(int i, int i2) {
        MonthAdapter adapter = getAdapter();
        if (trySelectNearestValidDayPosition(i2)) {
            return true;
        }
        if (19 == i) {
            int numColumns = i2 - getNumColumns();
            while (numColumns >= adapter.firstPositionInMonth()) {
                if (trySelectNearestValidDayPosition(numColumns)) {
                    return true;
                }
                numColumns -= getNumColumns();
            }
            return false;
        }
        if (i != 20) {
            return false;
        }
        int numColumns2 = getNumColumns() + i2;
        while (numColumns2 <= adapter.lastPositionInMonth()) {
            if (trySelectNearestValidDayPosition(numColumns2)) {
                return true;
            }
            numColumns2 += getNumColumns();
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onAttachedToWindow$0$com-google-android-material-datepicker-MaterialCalendarGridView, reason: not valid java name */
    public /* synthetic */ void m382x267001b4() {
        ensureFocusRingSelector(getAdapter());
    }

    @Override // android.widget.AbsListView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        getAdapter().notifyDataSetChanged();
        post(new MaterialCalendarGridView$$ExternalSyntheticLambda0(this));
    }

    @Override // android.view.View
    protected final void onDraw(Canvas canvas) {
        int dayToPosition;
        int horizontalMidPoint;
        int i;
        int i2;
        int dayToPosition2;
        int horizontalMidPoint2;
        int i3;
        int width;
        MaterialCalendarGridView materialCalendarGridView = this;
        super.onDraw(canvas);
        MonthAdapter adapter = materialCalendarGridView.getAdapter();
        DateSelector<?> dateSelector = adapter.dateSelector;
        CalendarStyle calendarStyle = adapter.calendarStyle;
        int max = Math.max(adapter.firstPositionInMonth(), materialCalendarGridView.getFirstVisiblePosition());
        int min = Math.min(adapter.lastPositionInMonth(), materialCalendarGridView.getLastVisiblePosition());
        Long item = adapter.getItem(max);
        Long item2 = adapter.getItem(min);
        for (Pair<Long, Long> pair : dateSelector.getSelectedRanges()) {
            if (pair.first == null) {
                materialCalendarGridView = this;
            } else if (pair.second != null) {
                long longValue = pair.first.longValue();
                long longValue2 = pair.second.longValue();
                if (!skipMonth(item, item2, Long.valueOf(longValue), Long.valueOf(longValue2))) {
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(materialCalendarGridView);
                    DateSelector<?> dateSelector2 = dateSelector;
                    if (longValue < item.longValue()) {
                        dayToPosition = max;
                        horizontalMidPoint = adapter.isFirstInRow(dayToPosition) ? 0 : !isLayoutRtl ? materialCalendarGridView.getChildAtPosition(dayToPosition - 1).getRight() : materialCalendarGridView.getChildAtPosition(dayToPosition - 1).getLeft();
                    } else {
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue);
                        dayToPosition = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        horizontalMidPoint = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(dayToPosition));
                    }
                    if (longValue2 > item2.longValue()) {
                        i = horizontalMidPoint;
                        dayToPosition2 = min;
                        horizontalMidPoint2 = adapter.isLastInRow(dayToPosition2) ? materialCalendarGridView.getWidth() : !isLayoutRtl ? materialCalendarGridView.getChildAtPosition(dayToPosition2).getRight() : materialCalendarGridView.getChildAtPosition(dayToPosition2).getLeft();
                        i2 = max;
                    } else {
                        i = horizontalMidPoint;
                        materialCalendarGridView.dayCompute.setTimeInMillis(longValue2);
                        i2 = max;
                        dayToPosition2 = adapter.dayToPosition(materialCalendarGridView.dayCompute.get(5));
                        horizontalMidPoint2 = horizontalMidPoint(materialCalendarGridView.getChildAtPosition(dayToPosition2));
                    }
                    int i4 = min;
                    int itemId = (int) adapter.getItemId(dayToPosition);
                    int itemId2 = (int) adapter.getItemId(dayToPosition2);
                    int i5 = itemId;
                    while (i5 <= itemId2) {
                        MonthAdapter monthAdapter = adapter;
                        int numColumns = i5 * materialCalendarGridView.getNumColumns();
                        int i6 = itemId2;
                        int numColumns2 = (numColumns + materialCalendarGridView.getNumColumns()) - 1;
                        View childAtPosition = materialCalendarGridView.getChildAtPosition(numColumns);
                        int top = childAtPosition.getTop() + calendarStyle.day.getTopInset();
                        int i7 = i5;
                        int bottom = childAtPosition.getBottom() - calendarStyle.day.getBottomInset();
                        if (isLayoutRtl) {
                            i3 = dayToPosition2 > numColumns2 ? 0 : horizontalMidPoint2;
                            width = numColumns > dayToPosition ? getWidth() : i;
                        } else {
                            i3 = numColumns > dayToPosition ? 0 : i;
                            width = dayToPosition2 > numColumns2 ? getWidth() : horizontalMidPoint2;
                        }
                        canvas.drawRect(i3, top, width, bottom, calendarStyle.rangeFill);
                        i5 = i7 + 1;
                        materialCalendarGridView = this;
                        adapter = monthAdapter;
                        itemId2 = i6;
                        dayToPosition2 = dayToPosition2;
                    }
                    materialCalendarGridView = this;
                    dateSelector = dateSelector2;
                    max = i2;
                    min = i4;
                }
            }
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        if (z) {
            gainFocus(i, rect);
        } else {
            super.onFocusChanged(false, i, rect);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        int selectedItemPosition = getSelectedItemPosition();
        if (selectedItemPosition == -1) {
            return super.onKeyDown(i, keyEvent);
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
        switch (i) {
            case 21:
                return handleHorizontalNavigation(selectedItemPosition, isLayoutRtl);
            case 22:
                return handleHorizontalNavigation(selectedItemPosition, !isLayoutRtl);
            case 61:
                return handleTabNavigation(selectedItemPosition, keyEvent);
            default:
                if (!super.onKeyDown(i, keyEvent)) {
                    return false;
                }
                MonthAdapter adapter = getAdapter();
                int selectedItemPosition2 = getSelectedItemPosition();
                if (selectedItemPosition2 == -1 || adapter.isDayPositionValid(selectedItemPosition2)) {
                    return true;
                }
                return handleVerticalNavigationOnDisabledDay(i, selectedItemPosition2);
        }
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.nestedScrollable) {
            super.onMeasure(i, i2);
            return;
        }
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(ViewCompat.MEASURED_SIZE_MASK, Integer.MIN_VALUE));
        getLayoutParams().height = getMeasuredHeight();
    }

    @Override // android.widget.AdapterView
    public /* bridge */ /* synthetic */ void setAdapter(ListAdapter listAdapter) {
        setAdapter2(listAdapter);
    }

    @Override // android.widget.GridView, android.widget.AbsListView
    /* renamed from: setAdapter, reason: avoid collision after fix types in other method */
    public final void setAdapter2(ListAdapter listAdapter) {
        if (!(listAdapter instanceof MonthAdapter)) {
            throw new IllegalArgumentException(String.format("%1$s must have its Adapter set to a %2$s", MaterialCalendarGridView.class.getCanonicalName(), MonthAdapter.class.getCanonicalName()));
        }
        super.setAdapter(listAdapter);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnMonthNavigationListener(MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener) {
        this.onMonthNavigationListener = onMonthNavigationListener;
    }

    @Override // android.widget.GridView, android.widget.AdapterView
    public void setSelection(int i) {
        super.setSelection(Math.max(i, getAdapter().findFirstValidDayPosition()));
    }
}
