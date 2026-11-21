package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new AnonymousClass2();
    private CharSequence error;
    private Long selectedItem;
    private SimpleDateFormat textInputFormat;

    /* renamed from: com.google.android.material.datepicker.SingleDateSelector$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends DateFormatTextWatcher {
        final /* synthetic */ TextInputLayout val$dateTextInput;
        final /* synthetic */ OnSelectionChangedListener val$listener;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, OnSelectionChangedListener onSelectionChangedListener, TextInputLayout textInputLayout2) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.val$listener = onSelectionChangedListener;
            this.val$dateTextInput = textInputLayout2;
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void onInvalidDate() {
            SingleDateSelector.access$102(SingleDateSelector.this, this.val$dateTextInput.getError());
            this.val$listener.onIncompleteSelectionChanged();
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void onValidDate(Long l) {
            if (l == null) {
                SingleDateSelector.access$000(SingleDateSelector.this);
            } else {
                SingleDateSelector.this.select(l.longValue());
            }
            SingleDateSelector.access$102(SingleDateSelector.this, null);
            this.val$listener.onSelectionChanged(SingleDateSelector.this.getSelection());
        }
    }

    /* renamed from: com.google.android.material.datepicker.SingleDateSelector$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Parcelable.Creator<SingleDateSelector> {
        AnonymousClass2() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            SingleDateSelector.access$202(singleDateSelector, (Long) parcel.readValue(Long.class.getClassLoader()));
            return singleDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SingleDateSelector createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SingleDateSelector[] newArray(int i) {
            return new SingleDateSelector[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ SingleDateSelector[] newArray(int i) {
            return newArray(i);
        }
    }

    static /* synthetic */ void access$000(SingleDateSelector singleDateSelector) {
        singleDateSelector.clearSelection();
    }

    static /* synthetic */ CharSequence access$102(SingleDateSelector singleDateSelector, CharSequence charSequence) {
        singleDateSelector.error = charSequence;
        return charSequence;
    }

    static /* synthetic */ Long access$202(SingleDateSelector singleDateSelector, Long l) {
        singleDateSelector.selectedItem = l;
        return l;
    }

    private void clearSelection() {
        this.selectedItem = null;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context context) {
        return MaterialAttributes.resolveOrThrow(context, R.attr.materialCalendarTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_date_header_title;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getError() {
        if (TextUtils.isEmpty(this.error)) {
            return null;
        }
        return this.error.toString();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Long> getSelectedDays() {
        ArrayList arrayList = new ArrayList();
        if (this.selectedItem != null) {
            arrayList.add(this.selectedItem);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        return new ArrayList();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Long getSelection() {
        return this.selectedItem;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ Long getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionContentDescription(Context context) {
        Resources resources = context.getResources();
        return resources.getString(R.string.mtrl_picker_announce_current_selection, this.selectedItem == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : DateStrings.getYearMonthDay(this.selectedItem.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        if (this.selectedItem == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        return resources.getString(R.string.mtrl_picker_date_header_selected, DateStrings.getYearMonthDay(this.selectedItem.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        return this.selectedItem != null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener<Long> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        Integer colorOrNull = MaterialColors.getColorOrNull(inflate.getContext(), R.attr.colorOnSurfaceVariant);
        if (colorOrNull != null) {
            editText.setHintTextColor(colorOrNull.intValue());
        }
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
        }
        boolean z = this.textInputFormat != null;
        SimpleDateFormat defaultTextInputFormat = z ? this.textInputFormat : UtcDates.getDefaultTextInputFormat();
        String pattern = z ? defaultTextInputFormat.toPattern() : UtcDates.getDefaultTextInputHint(inflate.getResources(), defaultTextInputFormat);
        textInputLayout.setPlaceholderText(UtcDates.getVerbatimTextInputHint(pattern));
        if (this.selectedItem != null) {
            editText.setText(defaultTextInputFormat.format(this.selectedItem));
            Editable text = editText.getText();
            if (text != null) {
                editText.setSelection(text.length());
            }
        }
        editText.addTextChangedListener(new AnonymousClass1(pattern, defaultTextInputFormat, textInputLayout, calendarConstraints, onSelectionChangedListener, textInputLayout));
        if (!DateSelector.isTouchExplorationEnabled(inflate.getContext())) {
            DateSelector.showKeyboardWithAutoHideBehavior(editText);
        }
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j) {
        this.selectedItem = Long.valueOf(j);
    }

    /* renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(Long l) {
        this.selectedItem = l == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(l.longValue()));
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(Long l) {
        setSelection2(l);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void setTextInputFormat(SimpleDateFormat simpleDateFormat) {
        if (simpleDateFormat != null) {
            simpleDateFormat = (SimpleDateFormat) UtcDates.getNormalizedFormat(simpleDateFormat);
        }
        this.textInputFormat = simpleDateFormat;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.selectedItem);
    }
}
