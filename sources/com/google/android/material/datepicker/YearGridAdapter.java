package com.google.android.material.datepicker;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import com.google.android.material.focus.FocusRingDrawable;
import com.google.android.material.timepicker.TimeModel;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* loaded from: classes.dex */
class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final MaterialCalendar<?> materialCalendar;

    /* renamed from: com.google.android.material.datepicker.YearGridAdapter$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements View.OnClickListener {
        final /* synthetic */ int val$year;

        AnonymousClass1(int i) {
            this.val$year = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            YearGridAdapter.access$000(YearGridAdapter.this).setCurrentMonth(YearGridAdapter.access$000(YearGridAdapter.this).getCalendarConstraints().clamp(Month.create(this.val$year, YearGridAdapter.access$000(YearGridAdapter.this).getCurrentMonth().month)));
            YearGridAdapter.access$000(YearGridAdapter.this).setSelector(MaterialCalendar.CalendarSelector.DAY);
            YearGridAdapter.access$000(YearGridAdapter.this).sendAccessibilityFocusEventToMonthDropdown();
        }
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;

        ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.materialCalendar = materialCalendar;
    }

    static /* synthetic */ MaterialCalendar access$000(YearGridAdapter yearGridAdapter) {
        return yearGridAdapter.materialCalendar;
    }

    private View.OnClickListener createYearClickListener(int i) {
        return new AnonymousClass1(i);
    }

    private void ensureFocusRingForeground(TextView textView, CalendarItemStyle calendarItemStyle) {
        if (textView.getForeground() instanceof FocusRingDrawable) {
            return;
        }
        Drawable wrap = FocusRingDrawable.wrap(textView.getContext(), textView.getForeground());
        if (wrap instanceof FocusRingDrawable) {
            FocusRingDrawable focusRingDrawable = (FocusRingDrawable) wrap;
            focusRingDrawable.setFocusRingShapeAppearance(calendarItemStyle.getItemShapeAppearanceModel());
            focusRingDrawable.setFocusRingInset(calendarItemStyle.getTopInset());
            textView.setForeground(focusRingDrawable);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.materialCalendar.getCalendarConstraints().getYearSpan();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPositionForYear(int i) {
        return i - this.materialCalendar.getCalendarConstraints().getStart().year;
    }

    int getYearForPosition(int i) {
        return this.materialCalendar.getCalendarConstraints().getStart().year + i;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        onBindViewHolder2(viewHolder, i);
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(ViewHolder viewHolder, int i) {
        int yearForPosition = getYearForPosition(i);
        viewHolder.textView.setText(String.format(Locale.getDefault(), TimeModel.NUMBER_FORMAT, Integer.valueOf(yearForPosition)));
        viewHolder.textView.setContentDescription(DateStrings.getYearContentDescription(viewHolder.textView.getContext(), yearForPosition));
        CalendarStyle calendarStyle = this.materialCalendar.getCalendarStyle();
        Calendar todayCalendar = UtcDates.getTodayCalendar();
        CalendarItemStyle calendarItemStyle = todayCalendar.get(1) == yearForPosition ? calendarStyle.todayYear : calendarStyle.year;
        Iterator<Long> it = this.materialCalendar.getDateSelector().getSelectedDays().iterator();
        while (it.hasNext()) {
            todayCalendar.setTimeInMillis(it.next().longValue());
            if (todayCalendar.get(1) == yearForPosition) {
                calendarItemStyle = calendarStyle.selectedYear;
            }
        }
        calendarItemStyle.styleItem(viewHolder.textView);
        ensureFocusRingForeground(viewHolder.textView, calendarItemStyle);
        viewHolder.textView.setSelected(calendarItemStyle == calendarStyle.selectedYear);
        viewHolder.textView.setOnClickListener(createYearClickListener(yearForPosition));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder2(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: onCreateViewHolder, reason: avoid collision after fix types in other method */
    public ViewHolder onCreateViewHolder2(ViewGroup viewGroup, int i) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
