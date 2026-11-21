package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.core.util.Preconditions;
import com.google.android.material.datepicker.CalendarConstraints;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class CompositeDateValidator implements CalendarConstraints.DateValidator {
    private static final int COMPARATOR_ALL_ID = 2;
    private static final int COMPARATOR_ANY_ID = 1;
    private final Operator operator;
    private final List<CalendarConstraints.DateValidator> validators;
    private static final Operator ANY_OPERATOR = new AnonymousClass1();
    private static final Operator ALL_OPERATOR = new AnonymousClass2();
    public static final Parcelable.Creator<CompositeDateValidator> CREATOR = new AnonymousClass3();

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Operator {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public int getId() {
            return 1;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public boolean isValid(List<CalendarConstraints.DateValidator> list, long j) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && dateValidator.isValid(j)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Operator {
        AnonymousClass2() {
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public int getId() {
            return 2;
        }

        @Override // com.google.android.material.datepicker.CompositeDateValidator.Operator
        public boolean isValid(List<CalendarConstraints.DateValidator> list, long j) {
            for (CalendarConstraints.DateValidator dateValidator : list) {
                if (dateValidator != null && !dateValidator.isValid(j)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: com.google.android.material.datepicker.CompositeDateValidator$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements Parcelable.Creator<CompositeDateValidator> {
        AnonymousClass3() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompositeDateValidator createFromParcel(Parcel parcel) {
            ArrayList readArrayList = parcel.readArrayList(CalendarConstraints.DateValidator.class.getClassLoader());
            int readInt = parcel.readInt();
            return new CompositeDateValidator((List) Preconditions.checkNotNull(readArrayList), readInt == 2 ? CompositeDateValidator.access$000() : readInt == 1 ? CompositeDateValidator.access$100() : CompositeDateValidator.access$000(), null);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CompositeDateValidator createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CompositeDateValidator[] newArray(int i) {
            return new CompositeDateValidator[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ CompositeDateValidator[] newArray(int i) {
            return newArray(i);
        }
    }

    /* loaded from: classes.dex */
    private interface Operator {
        int getId();

        boolean isValid(List<CalendarConstraints.DateValidator> list, long j);
    }

    private CompositeDateValidator(List<CalendarConstraints.DateValidator> list, Operator operator) {
        this.validators = list;
        this.operator = operator;
    }

    /* synthetic */ CompositeDateValidator(List list, Operator operator, AnonymousClass1 anonymousClass1) {
        this(list, operator);
    }

    static /* synthetic */ Operator access$000() {
        return ALL_OPERATOR;
    }

    static /* synthetic */ Operator access$100() {
        return ANY_OPERATOR;
    }

    public static CalendarConstraints.DateValidator allOf(List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ALL_OPERATOR);
    }

    public static CalendarConstraints.DateValidator anyOf(List<CalendarConstraints.DateValidator> list) {
        return new CompositeDateValidator(list, ANY_OPERATOR);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CompositeDateValidator)) {
            return false;
        }
        CompositeDateValidator compositeDateValidator = (CompositeDateValidator) obj;
        return this.validators.equals(compositeDateValidator.validators) && this.operator.getId() == compositeDateValidator.operator.getId();
    }

    public int hashCode() {
        return this.validators.hashCode();
    }

    @Override // com.google.android.material.datepicker.CalendarConstraints.DateValidator
    public boolean isValid(long j) {
        return this.operator.isValid(this.validators, j);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.validators);
        parcel.writeInt(this.operator.getId());
    }
}
