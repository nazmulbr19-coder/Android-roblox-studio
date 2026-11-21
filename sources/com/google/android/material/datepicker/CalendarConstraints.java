package com.google.android.material.datepicker;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.ObjectsCompat;
import java.util.Arrays;
import java.util.Objects;

/* loaded from: classes.dex */
public final class CalendarConstraints implements Parcelable {
    public static final Parcelable.Creator<CalendarConstraints> CREATOR = new AnonymousClass1();
    private final Month end;
    private final int firstDayOfWeek;
    private final int monthSpan;
    private Month openAt;
    private final Month start;
    private final DateValidator validator;
    private final int yearSpan;

    /* renamed from: com.google.android.material.datepicker.CalendarConstraints$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Parcelable.Creator<CalendarConstraints> {
        AnonymousClass1() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CalendarConstraints createFromParcel(Parcel parcel) {
            return new CalendarConstraints((Month) parcel.readParcelable(Month.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), (DateValidator) parcel.readParcelable(DateValidator.class.getClassLoader()), (Month) parcel.readParcelable(Month.class.getClassLoader()), parcel.readInt(), null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarConstraints createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CalendarConstraints[] newArray(int i) {
            return new CalendarConstraints[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CalendarConstraints[] newArray(int i) {
            return newArray(i);
        }
    }

    /* loaded from: classes.dex */
    public static final class Builder {
        private static final String DEEP_COPY_VALIDATOR_KEY = "DEEP_COPY_VALIDATOR_KEY";
        private long end;
        private int firstDayOfWeek;
        private Long openAt;
        private long start;
        private DateValidator validator;
        static final long DEFAULT_START = UtcDates.canonicalYearMonthDay(Month.create(1900, 0).timeInMillis);
        static final long DEFAULT_END = UtcDates.canonicalYearMonthDay(Month.create(2100, 11).timeInMillis);

        public Builder() {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Builder(CalendarConstraints calendarConstraints) {
            this.start = DEFAULT_START;
            this.end = DEFAULT_END;
            this.validator = DateValidatorPointForward.from(Long.MIN_VALUE);
            this.start = CalendarConstraints.access$100(calendarConstraints).timeInMillis;
            this.end = CalendarConstraints.access$200(calendarConstraints).timeInMillis;
            this.openAt = Long.valueOf(CalendarConstraints.access$300(calendarConstraints).timeInMillis);
            this.firstDayOfWeek = CalendarConstraints.access$400(calendarConstraints);
            this.validator = CalendarConstraints.access$500(calendarConstraints);
        }

        public CalendarConstraints build() {
            Bundle bundle = new Bundle();
            bundle.putParcelable(DEEP_COPY_VALIDATOR_KEY, this.validator);
            return new CalendarConstraints(Month.create(this.start), Month.create(this.end), (DateValidator) bundle.getParcelable(DEEP_COPY_VALIDATOR_KEY), this.openAt == null ? null : Month.create(this.openAt.longValue()), this.firstDayOfWeek, null);
        }

        public Builder setEnd(long j) {
            this.end = j;
            return this;
        }

        public Builder setFirstDayOfWeek(int i) {
            this.firstDayOfWeek = i;
            return this;
        }

        public Builder setOpenAt(long j) {
            this.openAt = Long.valueOf(j);
            return this;
        }

        public Builder setStart(long j) {
            this.start = j;
            return this;
        }

        public Builder setValidator(DateValidator dateValidator) {
            Objects.requireNonNull(dateValidator, "validator cannot be null");
            this.validator = dateValidator;
            return this;
        }
    }

    /* loaded from: classes.dex */
    public interface DateValidator extends Parcelable {
        boolean isValid(long j);
    }

    private CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i) {
        Objects.requireNonNull(month, "start cannot be null");
        Objects.requireNonNull(month2, "end cannot be null");
        Objects.requireNonNull(dateValidator, "validator cannot be null");
        this.start = month;
        this.end = month2;
        this.openAt = month3;
        this.firstDayOfWeek = i;
        this.validator = dateValidator;
        if (month3 != null && month.compareTo2(month3) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (month3 != null && month3.compareTo2(month2) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i < 0 || i > UtcDates.getUtcCalendar().getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.monthSpan = month.monthsUntil(month2) + 1;
        this.yearSpan = (month2.year - month.year) + 1;
    }

    /* synthetic */ CalendarConstraints(Month month, Month month2, DateValidator dateValidator, Month month3, int i, AnonymousClass1 anonymousClass1) {
        this(month, month2, dateValidator, month3, i);
    }

    static /* synthetic */ Month access$100(CalendarConstraints calendarConstraints) {
        return calendarConstraints.start;
    }

    static /* synthetic */ Month access$200(CalendarConstraints calendarConstraints) {
        return calendarConstraints.end;
    }

    static /* synthetic */ Month access$300(CalendarConstraints calendarConstraints) {
        return calendarConstraints.openAt;
    }

    static /* synthetic */ int access$400(CalendarConstraints calendarConstraints) {
        return calendarConstraints.firstDayOfWeek;
    }

    static /* synthetic */ DateValidator access$500(CalendarConstraints calendarConstraints) {
        return calendarConstraints.validator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month clamp(Month month) {
        return month.compareTo2(this.start) < 0 ? this.start : month.compareTo2(this.end) > 0 ? this.end : month;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarConstraints)) {
            return false;
        }
        CalendarConstraints calendarConstraints = (CalendarConstraints) obj;
        return this.start.equals(calendarConstraints.start) && this.end.equals(calendarConstraints.end) && ObjectsCompat.equals(this.openAt, calendarConstraints.openAt) && this.firstDayOfWeek == calendarConstraints.firstDayOfWeek && this.validator.equals(calendarConstraints.validator);
    }

    public DateValidator getDateValidator() {
        return this.validator;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month getEnd() {
        return this.end;
    }

    public long getEndMs() {
        return this.end.timeInMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getFirstDayOfWeek() {
        return this.firstDayOfWeek;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getMonthSpan() {
        return this.monthSpan;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month getOpenAt() {
        return this.openAt;
    }

    public Long getOpenAtMs() {
        if (this.openAt == null) {
            return null;
        }
        return Long.valueOf(this.openAt.timeInMillis);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Month getStart() {
        return this.start;
    }

    public long getStartMs() {
        return this.start.timeInMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getYearSpan() {
        return this.yearSpan;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.start, this.end, this.openAt, Integer.valueOf(this.firstDayOfWeek), this.validator});
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean isWithinBounds(long j) {
        return this.start.getDay(1) <= j && j <= this.end.getDay(this.end.daysInMonth);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOpenAt(Month month) {
        this.openAt = month;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.start, 0);
        parcel.writeParcelable(this.end, 0);
        parcel.writeParcelable(this.openAt, 0);
        parcel.writeParcelable(this.validator, 0);
        parcel.writeInt(this.firstDayOfWeek);
    }
}
