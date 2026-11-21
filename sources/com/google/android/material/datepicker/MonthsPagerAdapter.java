package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;

/* loaded from: classes.dex */
class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int POSITION_UNSPECIFIED = 0;
    private final CalendarConstraints calendarConstraints;
    private final DateSelector<?> dateSelector;
    private final DayViewDecorator dayViewDecorator;
    private final int itemHeight;
    private int keyboardFocusDirection = 0;
    private final MaterialCalendar.OnDayClickListener onDayClickListener;
    private final MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener;
    private Month visibleMonth;

    /* renamed from: com.google.android.material.datepicker.MonthsPagerAdapter$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements AdapterView.OnItemClickListener {
        final /* synthetic */ MaterialCalendarGridView val$monthGrid;

        AnonymousClass1(MaterialCalendarGridView materialCalendarGridView) {
            this.val$monthGrid = materialCalendarGridView;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            if (this.val$monthGrid.getAdapter().withinMonth(i)) {
                MonthsPagerAdapter.access$000(MonthsPagerAdapter.this).onDayClick(this.val$monthGrid.getAdapter().getItem(i).longValue());
            }
        }
    }

    /* loaded from: classes.dex */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final MaterialCalendarGridView monthGrid;
        final TextView monthTitle;

        ViewHolder(LinearLayout linearLayout, boolean z) {
            super(linearLayout);
            this.monthTitle = (TextView) linearLayout.findViewById(R.id.month_title);
            ViewCompat.setAccessibilityHeading(this.monthTitle, true);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z) {
                return;
            }
            this.monthTitle.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MonthsPagerAdapter(Context context, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator, MaterialCalendar.OnDayClickListener onDayClickListener, MaterialCalendar.OnMonthNavigationListener onMonthNavigationListener) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo2(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.compareTo2(end) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        this.itemHeight = (MonthAdapter.MAXIMUM_WEEKS * MaterialCalendar.getDayHeight(context)) + (MaterialDatePicker.isFullscreen(context) ? MaterialCalendar.getDayHeight(context) : 0);
        this.calendarConstraints = calendarConstraints;
        this.dateSelector = dateSelector;
        this.dayViewDecorator = dayViewDecorator;
        this.onDayClickListener = onDayClickListener;
        this.onMonthNavigationListener = onMonthNavigationListener;
        this.visibleMonth = openAt;
        setHasStableIds(true);
    }

    static /* synthetic */ MaterialCalendar.OnDayClickListener access$000(MonthsPagerAdapter monthsPagerAdapter) {
        return monthsPagerAdapter.onDayClickListener;
    }

    private int getInitialDayPositionForDirection(MonthAdapter monthAdapter, int i) {
        if (i == 1) {
            int findLastValidDayPosition = monthAdapter.findLastValidDayPosition();
            return findLastValidDayPosition == -1 ? monthAdapter.lastPositionInMonth() : findLastValidDayPosition;
        }
        int findFirstValidDayPosition = monthAdapter.findFirstValidDayPosition();
        return findFirstValidDayPosition == -1 ? monthAdapter.firstPositionInMonth() : findFirstValidDayPosition;
    }

    private void setInitialKeyboardFocus(MaterialCalendarGridView materialCalendarGridView) {
        int i = this.keyboardFocusDirection;
        this.keyboardFocusDirection = 0;
        materialCalendarGridView.post(new MonthsPagerAdapter$$ExternalSyntheticLambda0(this, materialCalendarGridView, i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.calendarConstraints.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.calendarConstraints.getStart().monthsLater(i).getStableId();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month getPageMonth(int i) {
        return this.calendarConstraints.getStart().monthsLater(i);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CharSequence getPageTitle(int i) {
        return getPageMonth(i).getLongName();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getPosition(Month month) {
        return this.calendarConstraints.getStart().monthsUntil(month);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: lambda$setInitialKeyboardFocus$0$com-google-android-material-datepicker-MonthsPagerAdapter, reason: not valid java name */
    public /* synthetic */ void m384x7f109e0a(MaterialCalendarGridView materialCalendarGridView, int i) {
        if (!materialCalendarGridView.hasFocus() || i == 0) {
            return;
        }
        materialCalendarGridView.setSelection(getInitialDayPositionForDirection(materialCalendarGridView.getAdapter(), i));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(ViewHolder viewHolder, int i) {
        onBindViewHolder2(viewHolder, i);
    }

    /* renamed from: onBindViewHolder, reason: avoid collision after fix types in other method */
    public void onBindViewHolder2(ViewHolder viewHolder, int i) {
        Month monthsLater = this.calendarConstraints.getStart().monthsLater(i);
        viewHolder.monthTitle.setText(monthsLater.getLongName());
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder.monthGrid.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthsLater.equals(materialCalendarGridView.getAdapter().month)) {
            MonthAdapter monthAdapter = new MonthAdapter(monthsLater, this.dateSelector, this.calendarConstraints, this.dayViewDecorator);
            materialCalendarGridView.setNumColumns(monthsLater.daysInWeek);
            materialCalendarGridView.setAdapter2((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            materialCalendarGridView.getAdapter().updateSelectedStates(materialCalendarGridView);
        }
        materialCalendarGridView.setOnItemClickListener(new AnonymousClass1(materialCalendarGridView));
        materialCalendarGridView.setOnMonthNavigationListener(this.onMonthNavigationListener);
        boolean isFullscreen = MaterialDatePicker.isFullscreen(viewHolder.itemView.getContext());
        if (isFullscreen || monthsLater.equals(this.visibleMonth)) {
            materialCalendarGridView.setFocusable(true);
            materialCalendarGridView.setDescendantFocusability(131072);
        } else {
            materialCalendarGridView.setFocusable(false);
            materialCalendarGridView.setDescendantFocusability(393216);
        }
        if (isFullscreen || !monthsLater.equals(this.visibleMonth)) {
            return;
        }
        setInitialKeyboardFocus(materialCalendarGridView);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder2(viewGroup, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: onCreateViewHolder, reason: avoid collision after fix types in other method */
    public ViewHolder onCreateViewHolder2(ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.itemHeight));
        return new ViewHolder(linearLayout, true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setKeyboardFocusDirection(int i) {
        this.keyboardFocusDirection = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setVisibleMonth(Month month) {
        if (month == null || month.equals(this.visibleMonth)) {
            return;
        }
        int position = getPosition(this.visibleMonth);
        this.visibleMonth = month;
        int position2 = getPosition(this.visibleMonth);
        notifyItemChanged(position);
        notifyItemChanged(position2);
    }
}
