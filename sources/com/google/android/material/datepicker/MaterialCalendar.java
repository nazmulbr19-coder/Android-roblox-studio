package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.widget.GridView;
import android.widget.ListAdapter;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.util.Pair;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class MaterialCalendar<S> extends PickerFragment<S> {
    private static final String CALENDAR_CONSTRAINTS_KEY = "CALENDAR_CONSTRAINTS_KEY";
    private static final String CURRENT_MONTH_KEY = "CURRENT_MONTH_KEY";
    private static final String DAY_VIEW_DECORATOR_KEY = "DAY_VIEW_DECORATOR_KEY";
    private static final String GRID_SELECTOR_KEY = "GRID_SELECTOR_KEY";
    private static final int SMOOTH_SCROLL_MAX = 3;
    private static final String THEME_RES_ID_KEY = "THEME_RES_ID_KEY";
    private AccessibilityManager accessibilityManager;
    private CalendarConstraints calendarConstraints;
    private CalendarSelector calendarSelector;
    private CalendarStyle calendarStyle;
    private Month current;
    private DateSelector<S> dateSelector;
    private View dayFrame;
    private DayViewDecorator dayViewDecorator;
    private boolean isFullscreen;
    private MaterialButton monthDropSelect;
    private View monthNext;
    private View monthPrev;
    private PagerSnapHelper pagerSnapHelper;
    private RecyclerView recyclerView;
    private int themeResId;
    private View yearFrame;
    private RecyclerView yearSelector;
    static final Object MONTHS_VIEW_GROUP_TAG = "MONTHS_VIEW_GROUP_TAG";
    static final Object NAVIGATION_PREV_TAG = "NAVIGATION_PREV_TAG";
    static final Object NAVIGATION_NEXT_TAG = "NAVIGATION_NEXT_TAG";
    static final Object SELECTOR_TOGGLE_TAG = "SELECTOR_TOGGLE_TAG";

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$1, reason: invalid class name */
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

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$10, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass10 implements View.OnClickListener {
        final /* synthetic */ MonthsPagerAdapter val$monthsPagerAdapter;

        AnonymousClass10(MonthsPagerAdapter monthsPagerAdapter) {
            this.val$monthsPagerAdapter = monthsPagerAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findFirstVisibleItemPosition = MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition();
            this.val$monthsPagerAdapter.setKeyboardFocusDirection(2);
            MaterialCalendar.this.setCurrentMonth(this.val$monthsPagerAdapter.getPageMonth(findFirstVisibleItemPosition + 1));
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$11, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass11 implements View.OnClickListener {
        final /* synthetic */ MonthsPagerAdapter val$monthsPagerAdapter;

        AnonymousClass11(MonthsPagerAdapter monthsPagerAdapter) {
            this.val$monthsPagerAdapter = monthsPagerAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int findLastVisibleItemPosition = MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition();
            this.val$monthsPagerAdapter.setKeyboardFocusDirection(1);
            MaterialCalendar.this.setCurrentMonth(this.val$monthsPagerAdapter.getPageMonth(findLastVisibleItemPosition - 1));
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$12, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass12 implements Runnable {
        final /* synthetic */ int val$position;

        AnonymousClass12(int i) {
            this.val$position = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            MaterialCalendar.access$000(MaterialCalendar.this).smoothScrollToPosition(this.val$position);
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends SmoothCalendarLayoutManager {
        final /* synthetic */ int val$orientation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, int i, boolean z, int i2) {
            super(context, i, z);
            this.val$orientation = i2;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.recyclerview.widget.LinearLayoutManager
        public void calculateExtraLayoutSpace(RecyclerView.State state, int[] iArr) {
            if (this.val$orientation == 0) {
                iArr[0] = MaterialCalendar.access$000(MaterialCalendar.this).getWidth();
                iArr[1] = MaterialCalendar.access$000(MaterialCalendar.this).getWidth();
            } else {
                iArr[0] = MaterialCalendar.access$000(MaterialCalendar.this).getHeight();
                iArr[1] = MaterialCalendar.access$000(MaterialCalendar.this).getHeight();
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements OnDayClickListener {
        AnonymousClass3() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.android.material.datepicker.MaterialCalendar.OnDayClickListener
        public void onDayClick(long j) {
            if (MaterialCalendar.access$100(MaterialCalendar.this).getDateValidator().isValid(j)) {
                MaterialCalendar.access$200(MaterialCalendar.this).select(j);
                Iterator<OnSelectionChangedListener<S>> it = MaterialCalendar.this.onSelectionChangedListeners.iterator();
                while (it.hasNext()) {
                    it.next().onSelectionChanged(MaterialCalendar.access$200(MaterialCalendar.this).getSelection());
                }
                MaterialCalendar.access$000(MaterialCalendar.this).getAdapter().notifyDataSetChanged();
                if (MaterialCalendar.access$300(MaterialCalendar.this) != null) {
                    MaterialCalendar.access$300(MaterialCalendar.this).getAdapter().notifyDataSetChanged();
                }
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 implements OnMonthNavigationListener {
        AnonymousClass4() {
        }

        @Override // com.google.android.material.datepicker.MaterialCalendar.OnMonthNavigationListener
        public boolean onMonthNavigationNext() {
            return MaterialCalendar.access$400(MaterialCalendar.this, true);
        }

        @Override // com.google.android.material.datepicker.MaterialCalendar.OnMonthNavigationListener
        public boolean onMonthNavigationPrevious() {
            return MaterialCalendar.access$400(MaterialCalendar.this, false);
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 extends AccessibilityDelegateCompat {
        AnonymousClass5() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setScrollable(false);
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$6, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass6 extends RecyclerView.ItemDecoration {
        private final Calendar startItem = UtcDates.getUtcCalendar();
        private final Calendar endItem = UtcDates.getUtcCalendar();

        AnonymousClass6() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            YearGridAdapter yearGridAdapter;
            GridLayoutManager gridLayoutManager;
            if ((recyclerView.getAdapter() instanceof YearGridAdapter) && (recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
                YearGridAdapter yearGridAdapter2 = (YearGridAdapter) recyclerView.getAdapter();
                GridLayoutManager gridLayoutManager2 = (GridLayoutManager) recyclerView.getLayoutManager();
                for (Pair<Long, Long> pair : MaterialCalendar.access$200(MaterialCalendar.this).getSelectedRanges()) {
                    if (pair.first != null && pair.second != null) {
                        this.startItem.setTimeInMillis(pair.first.longValue());
                        this.endItem.setTimeInMillis(pair.second.longValue());
                        int positionForYear = yearGridAdapter2.getPositionForYear(this.startItem.get(1));
                        int positionForYear2 = yearGridAdapter2.getPositionForYear(this.endItem.get(1));
                        View findViewByPosition = gridLayoutManager2.findViewByPosition(positionForYear);
                        View findViewByPosition2 = gridLayoutManager2.findViewByPosition(positionForYear2);
                        int spanCount = positionForYear / gridLayoutManager2.getSpanCount();
                        int spanCount2 = positionForYear2 / gridLayoutManager2.getSpanCount();
                        int i = spanCount;
                        while (i <= spanCount2) {
                            View findViewByPosition3 = gridLayoutManager2.findViewByPosition(gridLayoutManager2.getSpanCount() * i);
                            if (findViewByPosition3 == null) {
                                yearGridAdapter = yearGridAdapter2;
                                gridLayoutManager = gridLayoutManager2;
                            } else {
                                int top = findViewByPosition3.getTop() + MaterialCalendar.access$500(MaterialCalendar.this).year.getTopInset();
                                yearGridAdapter = yearGridAdapter2;
                                int bottom = findViewByPosition3.getBottom() - MaterialCalendar.access$500(MaterialCalendar.this).year.getBottomInset();
                                gridLayoutManager = gridLayoutManager2;
                                canvas.drawRect((i != spanCount || findViewByPosition == null) ? 0 : findViewByPosition.getLeft() + (findViewByPosition.getWidth() / 2), top, (i != spanCount2 || findViewByPosition2 == null) ? recyclerView.getWidth() : findViewByPosition2.getLeft() + (findViewByPosition2.getWidth() / 2), bottom, MaterialCalendar.access$500(MaterialCalendar.this).rangeFill);
                            }
                            i++;
                            yearGridAdapter2 = yearGridAdapter;
                            gridLayoutManager2 = gridLayoutManager;
                        }
                    }
                }
            }
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$7, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass7 extends AccessibilityDelegateCompat {
        AnonymousClass7() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, MaterialCalendar.access$600(MaterialCalendar.this).getVisibility() == 0 ? MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_year_selection) : MaterialCalendar.this.getString(R.string.mtrl_picker_toggle_to_day_selection)));
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$8, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass8 extends RecyclerView.OnScrollListener {
        final /* synthetic */ MonthsPagerAdapter val$monthsPagerAdapter;

        AnonymousClass8(MonthsPagerAdapter monthsPagerAdapter) {
            this.val$monthsPagerAdapter = monthsPagerAdapter;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            int childAdapterPosition;
            if (i != 0 || MaterialCalendar.access$700(MaterialCalendar.this) == null) {
                return;
            }
            View findSnapView = MaterialCalendar.access$700(MaterialCalendar.this).findSnapView(MaterialCalendar.this.getLayoutManager());
            if (findSnapView != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(findSnapView)) != -1) {
                MaterialCalendar.access$802(MaterialCalendar.this, this.val$monthsPagerAdapter.getPageMonth(childAdapterPosition));
                MaterialCalendar.access$900(MaterialCalendar.this).setText(this.val$monthsPagerAdapter.getPageTitle(childAdapterPosition));
                MaterialCalendar.access$1000(MaterialCalendar.this, childAdapterPosition);
            }
            MaterialCalendar.access$1100(MaterialCalendar.this);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int i, int i2) {
            int findFirstVisibleItemPosition = i < 0 ? MaterialCalendar.this.getLayoutManager().findFirstVisibleItemPosition() : MaterialCalendar.this.getLayoutManager().findLastVisibleItemPosition();
            if (MaterialCalendar.access$700(MaterialCalendar.this) == null) {
                MaterialCalendar.access$802(MaterialCalendar.this, this.val$monthsPagerAdapter.getPageMonth(findFirstVisibleItemPosition));
            }
            MaterialCalendar.access$900(MaterialCalendar.this).setText(this.val$monthsPagerAdapter.getPageTitle(findFirstVisibleItemPosition));
            MaterialCalendar.access$1000(MaterialCalendar.this, findFirstVisibleItemPosition);
        }
    }

    /* renamed from: com.google.android.material.datepicker.MaterialCalendar$9, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass9 implements View.OnClickListener {
        AnonymousClass9() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            MaterialCalendar.this.toggleVisibleSelector();
        }
    }

    /* loaded from: classes.dex */
    enum CalendarSelector {
        DAY,
        YEAR
    }

    /* loaded from: classes.dex */
    interface OnDayClickListener {
        void onDayClick(long j);
    }

    /* loaded from: classes.dex */
    interface OnMonthNavigationListener {
        boolean onMonthNavigationNext();

        boolean onMonthNavigationPrevious();
    }

    static /* synthetic */ RecyclerView access$000(MaterialCalendar materialCalendar) {
        return materialCalendar.recyclerView;
    }

    static /* synthetic */ CalendarConstraints access$100(MaterialCalendar materialCalendar) {
        return materialCalendar.calendarConstraints;
    }

    static /* synthetic */ void access$1000(MaterialCalendar materialCalendar, int i) {
        materialCalendar.updateNavigationButtonsEnabled(i);
    }

    static /* synthetic */ void access$1100(MaterialCalendar materialCalendar) {
        materialCalendar.updateCurrentVisibleMonth();
    }

    static /* synthetic */ DateSelector access$200(MaterialCalendar materialCalendar) {
        return materialCalendar.dateSelector;
    }

    static /* synthetic */ RecyclerView access$300(MaterialCalendar materialCalendar) {
        return materialCalendar.yearSelector;
    }

    static /* synthetic */ boolean access$400(MaterialCalendar materialCalendar, boolean z) {
        return materialCalendar.handleNavigateToMonthForKeyboard(z);
    }

    static /* synthetic */ CalendarStyle access$500(MaterialCalendar materialCalendar) {
        return materialCalendar.calendarStyle;
    }

    static /* synthetic */ View access$600(MaterialCalendar materialCalendar) {
        return materialCalendar.dayFrame;
    }

    static /* synthetic */ PagerSnapHelper access$700(MaterialCalendar materialCalendar) {
        return materialCalendar.pagerSnapHelper;
    }

    static /* synthetic */ Month access$802(MaterialCalendar materialCalendar, Month month) {
        materialCalendar.current = month;
        return month;
    }

    static /* synthetic */ MaterialButton access$900(MaterialCalendar materialCalendar) {
        return materialCalendar.monthDropSelect;
    }

    private void addActionsToMonthNavigation(View view, MonthsPagerAdapter monthsPagerAdapter) {
        this.monthDropSelect = (MaterialButton) view.findViewById(R.id.month_navigation_fragment_toggle);
        this.monthDropSelect.setTag(SELECTOR_TOGGLE_TAG);
        ViewCompat.setAccessibilityDelegate(this.monthDropSelect, new AnonymousClass7());
        this.monthPrev = view.findViewById(R.id.month_navigation_previous);
        this.monthPrev.setTag(NAVIGATION_PREV_TAG);
        TooltipCompat.setTooltipText(this.monthPrev, getString(R.string.mtrl_picker_prev_month_tooltip));
        this.monthNext = view.findViewById(R.id.month_navigation_next);
        this.monthNext.setTag(NAVIGATION_NEXT_TAG);
        TooltipCompat.setTooltipText(this.monthNext, getString(R.string.mtrl_picker_next_month_tooltip));
        this.yearFrame = view.findViewById(R.id.mtrl_calendar_year_selector_frame);
        this.dayFrame = view.findViewById(R.id.mtrl_calendar_day_selector_frame);
        setSelector(CalendarSelector.DAY);
        this.monthDropSelect.setText(this.current.getLongName());
        this.recyclerView.addOnScrollListener(new AnonymousClass8(monthsPagerAdapter));
        this.monthDropSelect.setOnClickListener(new AnonymousClass9());
        this.monthNext.setOnClickListener(new AnonymousClass10(monthsPagerAdapter));
        this.monthPrev.setOnClickListener(new AnonymousClass11(monthsPagerAdapter));
        updateNavigationButtonsEnabled(monthsPagerAdapter.getPosition(this.current));
    }

    private RecyclerView.ItemDecoration createItemDecoration() {
        return new AnonymousClass6();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getDayHeight(Context context) {
        return context.getResources().getDimensionPixelSize(R.dimen.mtrl_calendar_day_height);
    }

    private static int getDialogPickerHeight(Context context) {
        Resources resources = context.getResources();
        return resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding) + resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height) + (MonthAdapter.MAXIMUM_WEEKS * resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height)) + ((MonthAdapter.MAXIMUM_WEEKS - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    private boolean handleNavigateToMonthForKeyboard(boolean z) {
        if (this.isFullscreen) {
            return false;
        }
        if (this.recyclerView.getScrollState() != 0) {
            return true;
        }
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        if (monthsPagerAdapter == null || this.current == null) {
            return false;
        }
        int position = (z ? 1 : -1) + monthsPagerAdapter.getPosition(this.current);
        if (position < 0 || position >= monthsPagerAdapter.getItemCount()) {
            return false;
        }
        monthsPagerAdapter.setKeyboardFocusDirection(z ? 2 : 1);
        setCurrentMonth(monthsPagerAdapter.getPageMonth(position));
        return true;
    }

    public static <T> MaterialCalendar<T> newInstance(DateSelector<T> dateSelector, int i, CalendarConstraints calendarConstraints) {
        return newInstance(dateSelector, i, calendarConstraints, null);
    }

    public static <T> MaterialCalendar<T> newInstance(DateSelector<T> dateSelector, int i, CalendarConstraints calendarConstraints, DayViewDecorator dayViewDecorator) {
        MaterialCalendar<T> materialCalendar = new MaterialCalendar<>();
        Bundle bundle = new Bundle();
        bundle.putInt(THEME_RES_ID_KEY, i);
        bundle.putParcelable(GRID_SELECTOR_KEY, dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, calendarConstraints);
        bundle.putParcelable(DAY_VIEW_DECORATOR_KEY, dayViewDecorator);
        bundle.putParcelable(CURRENT_MONTH_KEY, calendarConstraints.getOpenAt());
        materialCalendar.setArguments(bundle);
        return materialCalendar;
    }

    private void postSmoothRecyclerViewScroll(int i) {
        this.recyclerView.post(new AnonymousClass12(i));
    }

    private void setUpForAccessibility() {
        ViewCompat.setAccessibilityDelegate(this.recyclerView, new AnonymousClass5());
    }

    private void updateAccessibilityPaneTitle(View view) {
        if (view == null) {
            return;
        }
        if (this.calendarSelector == CalendarSelector.YEAR) {
            ViewCompat.setAccessibilityPaneTitle(view, getString(R.string.mtrl_picker_pane_title_year_view));
        } else if (this.calendarSelector == CalendarSelector.DAY) {
            ViewCompat.setAccessibilityPaneTitle(view, getString(R.string.mtrl_picker_pane_title_calendar_view));
        }
    }

    private void updateCurrentVisibleMonth() {
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        if (monthsPagerAdapter == null || this.isFullscreen) {
            return;
        }
        monthsPagerAdapter.setVisibleMonth(this.current);
    }

    private void updateNavigationButtonsEnabled(int i) {
        if (this.monthNext != null) {
            this.monthNext.setEnabled(i + 1 < this.recyclerView.getAdapter().getItemCount());
        }
        if (this.monthPrev != null) {
            this.monthPrev.setEnabled(i + (-1) >= 0);
        }
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public boolean addOnSelectionChangedListener(OnSelectionChangedListener<S> onSelectionChangedListener) {
        return super.addOnSelectionChangedListener(onSelectionChangedListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarConstraints getCalendarConstraints() {
        return this.calendarConstraints;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public CalendarStyle getCalendarStyle() {
        return this.calendarStyle;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month getCurrentMonth() {
        return this.current;
    }

    @Override // com.google.android.material.datepicker.PickerFragment
    public DateSelector<S> getDateSelector() {
        return this.dateSelector;
    }

    LinearLayoutManager getLayoutManager() {
        return (LinearLayoutManager) this.recyclerView.getLayoutManager();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = bundle == null ? getArguments() : bundle;
        this.themeResId = arguments.getInt(THEME_RES_ID_KEY);
        this.dateSelector = (DateSelector) arguments.getParcelable(GRID_SELECTOR_KEY);
        this.calendarConstraints = (CalendarConstraints) arguments.getParcelable(CALENDAR_CONSTRAINTS_KEY);
        this.dayViewDecorator = (DayViewDecorator) arguments.getParcelable(DAY_VIEW_DECORATOR_KEY);
        this.current = (Month) arguments.getParcelable(CURRENT_MONTH_KEY);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.content.Context, com.google.android.material.datepicker.CalendarStyle] */
    /* JADX WARN: Type inference failed for: r0v21, types: [android.content.Context, androidx.recyclerview.widget.RecyclerView$LayoutManager, android.view.ContextThemeWrapper, com.google.android.material.datepicker.MaterialCalendar$2] */
    /* JADX WARN: Type inference failed for: r0v5, types: [android.content.Context, com.google.android.material.datepicker.CalendarConstraints] */
    /* JADX WARN: Type inference failed for: r8v1, types: [android.view.View, com.google.android.material.datepicker.DayViewDecorator] */
    /* JADX WARN: Type inference failed for: r8v5, types: [android.view.View, int] */
    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i;
        int i2;
        ?? calendarStyle = new CalendarStyle(new ContextThemeWrapper(getContext(), this.themeResId));
        this.calendarStyle = calendarStyle;
        LayoutInflater cloneInContext = layoutInflater.cloneInContext(calendarStyle);
        this.accessibilityManager = (AccessibilityManager) requireContext().getSystemService("accessibility");
        ?? r0 = this.calendarConstraints;
        Month start = r0.getStart();
        this.isFullscreen = MaterialDatePicker.isFullscreen(r0);
        if (this.isFullscreen) {
            i = R.layout.mtrl_calendar_vertical;
            i2 = 1;
        } else {
            i = R.layout.mtrl_calendar_horizontal;
            i2 = 0;
        }
        View inflate = cloneInContext.inflate(i, viewGroup, false);
        inflate.setMinimumHeight(getDialogPickerHeight(requireContext()));
        GridView gridView = (GridView) inflate.findViewById(R.id.mtrl_calendar_days_of_week);
        ViewCompat.setAccessibilityDelegate(gridView, new AnonymousClass1());
        int firstDayOfWeek = this.calendarConstraints.getFirstDayOfWeek();
        gridView.setAdapter((ListAdapter) (firstDayOfWeek > 0 ? new DaysOfWeekAdapter(firstDayOfWeek) : new DaysOfWeekAdapter()));
        gridView.setNumColumns(start.daysInWeek);
        gridView.setEnabled(false);
        this.recyclerView = (RecyclerView) inflate.findViewById(R.id.mtrl_calendar_months);
        ?? anonymousClass2 = new AnonymousClass2(getContext(), i2, false, i2);
        this.recyclerView.setLayoutManager(anonymousClass2);
        this.recyclerView.setTag(MONTHS_VIEW_GROUP_TAG);
        DateSelector<S> dateSelector = this.dateSelector;
        CalendarConstraints calendarConstraints = this.calendarConstraints;
        ?? r8 = this.dayViewDecorator;
        MonthsPagerAdapter monthsPagerAdapter = new MonthsPagerAdapter(anonymousClass2, dateSelector, calendarConstraints, r8, new AnonymousClass3(), new AnonymousClass4());
        this.recyclerView.setAdapter(monthsPagerAdapter);
        int integer = anonymousClass2.getResources().getInteger(R.integer.mtrl_calendar_year_selector_span);
        this.yearSelector = (RecyclerView) r8.findViewById(R.id.mtrl_calendar_year_selector_frame);
        RecyclerView recyclerView = r8;
        if (this.yearSelector != null) {
            this.yearSelector.setHasFixedSize(true);
            this.yearSelector.setLayoutManager(new GridLayoutManager((Context) anonymousClass2, integer, 1, false));
            this.yearSelector.setAdapter(new YearGridAdapter(this));
            RecyclerView recyclerView2 = this.yearSelector;
            RecyclerView.ItemDecoration createItemDecoration = createItemDecoration();
            recyclerView2.addItemDecoration(createItemDecoration);
            recyclerView = createItemDecoration;
        }
        RecyclerView recyclerView3 = recyclerView;
        if (!this.isFullscreen) {
            this.pagerSnapHelper = new PagerSnapHelper();
            PagerSnapHelper pagerSnapHelper = this.pagerSnapHelper;
            RecyclerView recyclerView4 = this.recyclerView;
            pagerSnapHelper.attachToRecyclerView(recyclerView4);
            recyclerView3 = recyclerView4;
        }
        if (recyclerView3.findViewById(R.id.month_navigation_fragment_toggle) != null) {
            addActionsToMonthNavigation(recyclerView3, monthsPagerAdapter);
        }
        RecyclerView recyclerView5 = this.recyclerView;
        ?? position = monthsPagerAdapter.getPosition(this.current);
        recyclerView5.scrollToPosition(position);
        setUpForAccessibility();
        updateAccessibilityPaneTitle(position);
        return position;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(THEME_RES_ID_KEY, this.themeResId);
        bundle.putParcelable(GRID_SELECTOR_KEY, this.dateSelector);
        bundle.putParcelable(CALENDAR_CONSTRAINTS_KEY, this.calendarConstraints);
        bundle.putParcelable(DAY_VIEW_DECORATOR_KEY, this.dayViewDecorator);
        bundle.putParcelable(CURRENT_MONTH_KEY, this.current);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void sendAccessibilityFocusEventToMonthDropdown() {
        if (this.monthDropSelect != null) {
            this.monthDropSelect.sendAccessibilityEvent(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCurrentMonth(Month month) {
        MonthsPagerAdapter monthsPagerAdapter = (MonthsPagerAdapter) this.recyclerView.getAdapter();
        int position = monthsPagerAdapter.getPosition(month);
        if (this.accessibilityManager == null || !this.accessibilityManager.isEnabled()) {
            int position2 = position - monthsPagerAdapter.getPosition(this.current);
            boolean z = Math.abs(position2) > 3;
            boolean z2 = position2 > 0;
            this.current = month;
            if (z && z2) {
                this.recyclerView.scrollToPosition(position - 3);
                postSmoothRecyclerViewScroll(position);
            } else if (z) {
                this.recyclerView.scrollToPosition(position + 3);
                postSmoothRecyclerViewScroll(position);
            } else {
                postSmoothRecyclerViewScroll(position);
            }
        } else {
            this.current = month;
            this.recyclerView.scrollToPosition(position);
        }
        updateCurrentVisibleMonth();
        updateNavigationButtonsEnabled(position);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSelector(CalendarSelector calendarSelector) {
        this.calendarSelector = calendarSelector;
        if (calendarSelector == CalendarSelector.YEAR) {
            this.yearSelector.getLayoutManager().scrollToPosition(((YearGridAdapter) this.yearSelector.getAdapter()).getPositionForYear(this.current.year));
            this.yearFrame.setVisibility(0);
            this.dayFrame.setVisibility(8);
            this.monthPrev.setVisibility(8);
            this.monthNext.setVisibility(8);
            return;
        }
        if (calendarSelector == CalendarSelector.DAY) {
            this.yearFrame.setVisibility(8);
            this.dayFrame.setVisibility(0);
            this.monthPrev.setVisibility(0);
            this.monthNext.setVisibility(0);
            setCurrentMonth(this.current);
        }
    }

    void toggleVisibleSelector() {
        if (this.calendarSelector == CalendarSelector.YEAR) {
            setSelector(CalendarSelector.DAY);
        } else if (this.calendarSelector == CalendarSelector.DAY) {
            setSelector(CalendarSelector.YEAR);
        }
        updateAccessibilityPaneTitle(getView());
    }
}
