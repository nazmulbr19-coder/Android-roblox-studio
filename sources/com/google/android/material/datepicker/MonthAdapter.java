package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.timepicker.TimeModel;
import java.util.Collection;
import java.util.Iterator;

/* loaded from: classes.dex */
class MonthAdapter extends BaseAdapter {
    private static final int NO_DAY_NUMBER = -1;
    final CalendarConstraints calendarConstraints;
    CalendarStyle calendarStyle;
    final DateSelector<?> dateSelector;
    final DayViewDecorator dayViewDecorator;
    final Month month;
    private Collection<Long> previouslySelectedDates;
    static final int MAXIMUM_WEEKS = UtcDates.getUtcCalendar().getMaximum(4);
    private static final int MAXIMUM_GRID_CELLS = (UtcDates.getUtcCalendar().getMaximum(5) + UtcDates.getUtcCalendar().getMaximum(7)) - 1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        this.month = month;
        this.dateSelector = dateSelector;
        this.calendarConstraints = calendarConstraints;
        this.dayViewDecorator = dayViewDecorator;
        this.previouslySelectedDates = dateSelector.getSelectedDays();
    }

    private String getDayContentDescription(Context context, long j) {
        return DateStrings.getDayContentDescription(context, j, isToday(j), isStartOfRange(j), isEndOfRange(j));
    }

    private void initializeStyles(Context context) {
        if (this.calendarStyle == null) {
            this.calendarStyle = new CalendarStyle(context);
        }
    }

    private boolean isSelected(long j) {
        Iterator<Long> it = this.dateSelector.getSelectedDays().iterator();
        while (it.hasNext()) {
            if (UtcDates.canonicalYearMonthDay(j) == UtcDates.canonicalYearMonthDay(it.next().longValue())) {
                return true;
            }
        }
        return false;
    }

    private boolean isToday(long j) {
        return UtcDates.getTodayCalendar().getTimeInMillis() == j;
    }

    private void updateSelectedState(TextView textView, long j, int i) {
        boolean z;
        CalendarItemStyle calendarItemStyle;
        if (textView == null) {
            return;
        }
        Context context = textView.getContext();
        String dayContentDescription = getDayContentDescription(context, j);
        textView.setContentDescription(dayContentDescription);
        boolean isValid = this.calendarConstraints.getDateValidator().isValid(j);
        if (isValid) {
            textView.setEnabled(true);
            boolean isSelected = isSelected(j);
            textView.setSelected(isSelected);
            if (isSelected) {
                z = isSelected;
                calendarItemStyle = this.calendarStyle.selectedDay;
            } else if (isToday(j)) {
                z = isSelected;
                calendarItemStyle = this.calendarStyle.todayDay;
            } else {
                z = isSelected;
                calendarItemStyle = this.calendarStyle.day;
            }
        } else {
            textView.setEnabled(false);
            z = false;
            calendarItemStyle = this.calendarStyle.invalidDay;
        }
        if (this.dayViewDecorator == null || i == -1) {
            calendarItemStyle.styleItem(textView);
            return;
        }
        int i2 = this.month.year;
        int i3 = this.month.month;
        calendarItemStyle.styleItem(textView, this.dayViewDecorator.getBackgroundColor(context, i2, i3, i, isValid, z), this.dayViewDecorator.getTextColor(context, i2, i3, i, isValid, z));
        textView.setCompoundDrawables(this.dayViewDecorator.getCompoundDrawableLeft(context, i2, i3, i, isValid, z), this.dayViewDecorator.getCompoundDrawableTop(context, i2, i3, i, isValid, z), this.dayViewDecorator.getCompoundDrawableRight(context, i2, i3, i, isValid, z), this.dayViewDecorator.getCompoundDrawableBottom(context, i2, i3, i, isValid, z));
        textView.setContentDescription(this.dayViewDecorator.getContentDescription(context, i2, i3, i, isValid, z, dayContentDescription));
    }

    private void updateSelectedStateForDate(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (Month.create(j).equals(this.month)) {
            int dayOfMonth = this.month.getDayOfMonth(j);
            updateSelectedState((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().dayToPosition(dayOfMonth) - materialCalendarGridView.getFirstVisiblePosition()), j, dayOfMonth);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int dayToPosition(int i) {
        return firstPositionInMonth() + (i - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findFirstValidDayPosition() {
        return findNextValidDayPosition(firstPositionInMonth() - 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findLastValidDayPosition() {
        return findPreviousValidDayPosition(lastPositionInMonth() + 1);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findNearestValidDayPositionInRow(int i) {
        if (isDayPositionValid(i)) {
            return i;
        }
        long itemId = getItemId(i);
        for (int i2 = 1; i2 < this.month.daysInWeek; i2++) {
            int i3 = i + i2;
            if (i3 < getCount() && getItemId(i3) == itemId && isDayPositionValid(i3)) {
                return i3;
            }
            int i4 = i - i2;
            if (i4 >= 0 && getItemId(i4) == itemId && isDayPositionValid(i4)) {
                return i4;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findNextValidDayPosition(int i) {
        for (int i2 = i + 1; i2 <= lastPositionInMonth(); i2++) {
            if (isDayPositionValid(i2)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int findPreviousValidDayPosition(int i) {
        for (int i2 = i - 1; i2 >= firstPositionInMonth(); i2--) {
            if (isDayPositionValid(i2)) {
                return i2;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int firstPositionInMonth() {
        return this.month.daysFromStartOfWeekToFirstOfMonth(this.calendarConstraints.getFirstDayOfWeek());
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return MAXIMUM_GRID_CELLS;
    }

    @Override // android.widget.Adapter
    public Long getItem(int i) {
        if (i < firstPositionInMonth() || i > lastPositionInMonth()) {
            return null;
        }
        return Long.valueOf(this.month.getDay(positionToDay(i)));
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ Object getItem(int i) {
        return getItem(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.month.daysInWeek;
    }

    @Override // android.widget.Adapter
    public /* bridge */ /* synthetic */ View getView(int i, View view, ViewGroup viewGroup) {
        return getView(i, view, viewGroup);
    }

    @Override // android.widget.Adapter
    public TextView getView(int i, View view, ViewGroup viewGroup) {
        initializeStyles(viewGroup.getContext());
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int firstPositionInMonth = i - firstPositionInMonth();
        int i2 = -1;
        if (firstPositionInMonth < 0 || firstPositionInMonth >= this.month.daysInMonth) {
            textView.setVisibility(8);
            textView.setEnabled(false);
        } else {
            i2 = firstPositionInMonth + 1;
            textView.setTag(this.month);
            textView.setText(String.format(textView.getResources().getConfiguration().locale, TimeModel.NUMBER_FORMAT, Integer.valueOf(i2)));
            textView.setVisibility(0);
            textView.setEnabled(true);
        }
        Long item = getItem(i);
        if (item == null) {
            return textView;
        }
        updateSelectedState(textView, item.longValue(), i2);
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isDayPositionValid(int i) {
        Long item = getItem(i);
        return item != null && this.calendarConstraints.getDateValidator().isValid(item.longValue());
    }

    boolean isEndOfRange(long j) {
        for (Pair<Long, Long> pair : this.dateSelector.getSelectedRanges()) {
            if (pair.second != null && pair.second.longValue() == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isFirstInRow(int i) {
        return i % this.month.daysInWeek == 0;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isLastInRow(int i) {
        return (i + 1) % this.month.daysInWeek == 0;
    }

    boolean isStartOfRange(long j) {
        for (Pair<Long, Long> pair : this.dateSelector.getSelectedRanges()) {
            if (pair.first != null && pair.first.longValue() == j) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int lastPositionInMonth() {
        return (firstPositionInMonth() + this.month.daysInMonth) - 1;
    }

    int positionToDay(int i) {
        return (i - firstPositionInMonth()) + 1;
    }

    public void updateSelectedStates(MaterialCalendarGridView materialCalendarGridView) {
        Iterator<Long> it = this.previouslySelectedDates.iterator();
        while (it.hasNext()) {
            updateSelectedStateForDate(materialCalendarGridView, it.next().longValue());
        }
        if (this.dateSelector != null) {
            Iterator<Long> it2 = this.dateSelector.getSelectedDays().iterator();
            while (it2.hasNext()) {
                updateSelectedStateForDate(materialCalendarGridView, it2.next().longValue());
            }
            this.previouslySelectedDates = this.dateSelector.getSelectedDays();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean withinMonth(int i) {
        return i >= firstPositionInMonth() && i <= lastPositionInMonth();
    }
}
