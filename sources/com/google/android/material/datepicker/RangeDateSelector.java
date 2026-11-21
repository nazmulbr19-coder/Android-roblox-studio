package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.core.util.Pair;
import androidx.core.util.Preconditions;
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
public class RangeDateSelector implements DateSelector<Pair<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new AnonymousClass3();
    private CharSequence error;
    private String invalidRangeStartError;
    private SimpleDateFormat textInputFormat;
    private final String invalidRangeEndError = " ";
    private Long selectedStartItem = null;
    private Long selectedEndItem = null;
    private Long proposedTextStart = null;
    private Long proposedTextEnd = null;

    /* renamed from: com.google.android.material.datepicker.RangeDateSelector$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends DateFormatTextWatcher {
        final /* synthetic */ TextInputLayout val$endTextInput;
        final /* synthetic */ OnSelectionChangedListener val$listener;
        final /* synthetic */ TextInputLayout val$startTextInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.val$startTextInput = textInputLayout2;
            this.val$endTextInput = textInputLayout3;
            this.val$listener = onSelectionChangedListener;
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void onInvalidDate() {
            RangeDateSelector.access$002(RangeDateSelector.this, null);
            RangeDateSelector.access$100(RangeDateSelector.this, this.val$startTextInput, this.val$endTextInput, this.val$listener);
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void onValidDate(Long l) {
            RangeDateSelector.access$002(RangeDateSelector.this, l);
            RangeDateSelector.access$100(RangeDateSelector.this, this.val$startTextInput, this.val$endTextInput, this.val$listener);
        }
    }

    /* renamed from: com.google.android.material.datepicker.RangeDateSelector$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends DateFormatTextWatcher {
        final /* synthetic */ TextInputLayout val$endTextInput;
        final /* synthetic */ OnSelectionChangedListener val$listener;
        final /* synthetic */ TextInputLayout val$startTextInput;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints, TextInputLayout textInputLayout2, TextInputLayout textInputLayout3, OnSelectionChangedListener onSelectionChangedListener) {
            super(str, dateFormat, textInputLayout, calendarConstraints);
            this.val$startTextInput = textInputLayout2;
            this.val$endTextInput = textInputLayout3;
            this.val$listener = onSelectionChangedListener;
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void onInvalidDate() {
            RangeDateSelector.access$202(RangeDateSelector.this, null);
            RangeDateSelector.access$100(RangeDateSelector.this, this.val$startTextInput, this.val$endTextInput, this.val$listener);
        }

        @Override // com.google.android.material.datepicker.DateFormatTextWatcher
        void onValidDate(Long l) {
            RangeDateSelector.access$202(RangeDateSelector.this, l);
            RangeDateSelector.access$100(RangeDateSelector.this, this.val$startTextInput, this.val$endTextInput, this.val$listener);
        }
    }

    /* renamed from: com.google.android.material.datepicker.RangeDateSelector$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements Parcelable.Creator<RangeDateSelector> {
        AnonymousClass3() {
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            RangeDateSelector.access$302(rangeDateSelector, (Long) parcel.readValue(Long.class.getClassLoader()));
            RangeDateSelector.access$402(rangeDateSelector, (Long) parcel.readValue(Long.class.getClassLoader()));
            return rangeDateSelector;
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RangeDateSelector createFromParcel(Parcel parcel) {
            return createFromParcel(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RangeDateSelector[] newArray(int i) {
            return new RangeDateSelector[i];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ RangeDateSelector[] newArray(int i) {
            return newArray(i);
        }
    }

    static /* synthetic */ Long access$002(RangeDateSelector rangeDateSelector, Long l) {
        rangeDateSelector.proposedTextStart = l;
        return l;
    }

    static /* synthetic */ void access$100(RangeDateSelector rangeDateSelector, TextInputLayout textInputLayout, TextInputLayout textInputLayout2, OnSelectionChangedListener onSelectionChangedListener) {
        rangeDateSelector.updateIfValidTextProposal(textInputLayout, textInputLayout2, onSelectionChangedListener);
    }

    static /* synthetic */ Long access$202(RangeDateSelector rangeDateSelector, Long l) {
        rangeDateSelector.proposedTextEnd = l;
        return l;
    }

    static /* synthetic */ Long access$302(RangeDateSelector rangeDateSelector, Long l) {
        rangeDateSelector.selectedStartItem = l;
        return l;
    }

    static /* synthetic */ Long access$402(RangeDateSelector rangeDateSelector, Long l) {
        rangeDateSelector.selectedEndItem = l;
        return l;
    }

    private void clearInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.invalidRangeStartError.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError(null);
        }
        if (textInputLayout2.getError() == null || !" ".contentEquals(textInputLayout2.getError())) {
            return;
        }
        textInputLayout2.setError(null);
    }

    private boolean isValidRange(long j, long j2) {
        return j <= j2;
    }

    private void setInvalidRange(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.invalidRangeStartError);
        textInputLayout2.setError(" ");
    }

    private void updateError(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (!TextUtils.isEmpty(textInputLayout.getError())) {
            this.error = textInputLayout.getError();
        } else if (TextUtils.isEmpty(textInputLayout2.getError())) {
            this.error = null;
        } else {
            this.error = textInputLayout2.getError();
        }
    }

    private void updateIfValidTextProposal(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        if (this.proposedTextStart == null || this.proposedTextEnd == null) {
            clearInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        } else if (isValidRange(this.proposedTextStart.longValue(), this.proposedTextEnd.longValue())) {
            this.selectedStartItem = this.proposedTextStart;
            this.selectedEndItem = this.proposedTextEnd;
            onSelectionChangedListener.onSelectionChanged(getSelection());
        } else {
            setInvalidRange(textInputLayout, textInputLayout2);
            onSelectionChangedListener.onIncompleteSelectionChanged();
        }
        updateError(textInputLayout, textInputLayout2);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultThemeResId(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return MaterialAttributes.resolveOrThrow(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, MaterialDatePicker.class.getCanonicalName());
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public int getDefaultTitleResId() {
        return R.string.mtrl_picker_range_header_title;
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
        if (this.selectedStartItem != null) {
            arrayList.add(this.selectedStartItem);
        }
        if (this.selectedEndItem != null) {
            arrayList.add(this.selectedEndItem);
        }
        return arrayList;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public Collection<Pair<Long, Long>> getSelectedRanges() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new Pair(this.selectedStartItem, this.selectedEndItem));
        return arrayList;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.google.android.material.datepicker.DateSelector
    public Pair<Long, Long> getSelection() {
        return new Pair<>(this.selectedStartItem, this.selectedEndItem);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ Pair<Long, Long> getSelection() {
        return getSelection();
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionContentDescription(Context context) {
        Resources resources = context.getResources();
        Pair<String, String> dateRangeString = DateStrings.getDateRangeString(this.selectedStartItem, this.selectedEndItem);
        return resources.getString(R.string.mtrl_picker_announce_current_range_selection, dateRangeString.first == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : dateRangeString.first, dateRangeString.second == null ? resources.getString(R.string.mtrl_picker_announce_current_selection_none) : dateRangeString.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public String getSelectionDisplayString(Context context) {
        Resources resources = context.getResources();
        if (this.selectedStartItem == null && this.selectedEndItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        if (this.selectedEndItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, DateStrings.getDateString(this.selectedStartItem.longValue()));
        }
        if (this.selectedStartItem == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, DateStrings.getDateString(this.selectedEndItem.longValue()));
        }
        Pair<String, String> dateRangeString = DateStrings.getDateRangeString(this.selectedStartItem, this.selectedEndItem);
        return resources.getString(R.string.mtrl_picker_range_header_selected, dateRangeString.first, dateRangeString.second);
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public boolean isSelectionComplete() {
        return (this.selectedStartItem == null || this.selectedEndItem == null || !isValidRange(this.selectedStartItem.longValue(), this.selectedEndItem.longValue())) ? false : true;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public View onCreateTextInputView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, OnSelectionChangedListener<Pair<Long, Long>> onSelectionChangedListener) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        Integer colorOrNull = MaterialColors.getColorOrNull(inflate.getContext(), R.attr.colorOnSurfaceVariant);
        if (colorOrNull != null) {
            editText.setHintTextColor(colorOrNull.intValue());
            editText2.setHintTextColor(colorOrNull.intValue());
        }
        if (ManufacturerUtils.isDateInputKeyboardMissingSeparatorCharacters()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.invalidRangeStartError = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        boolean z = this.textInputFormat != null;
        SimpleDateFormat defaultTextInputFormat = z ? this.textInputFormat : UtcDates.getDefaultTextInputFormat();
        if (this.selectedStartItem != null) {
            editText.setText(defaultTextInputFormat.format(this.selectedStartItem));
            this.proposedTextStart = this.selectedStartItem;
            Editable text = editText.getText();
            if (text != null) {
                editText.setSelection(text.length());
            }
        }
        if (this.selectedEndItem != null) {
            editText2.setText(defaultTextInputFormat.format(this.selectedEndItem));
            this.proposedTextEnd = this.selectedEndItem;
        }
        String pattern = z ? defaultTextInputFormat.toPattern() : UtcDates.getDefaultTextInputHint(inflate.getResources(), defaultTextInputFormat);
        SpannableString verbatimTextInputHint = UtcDates.getVerbatimTextInputHint(pattern);
        textInputLayout.setPlaceholderText(verbatimTextInputHint);
        textInputLayout2.setPlaceholderText(verbatimTextInputHint);
        editText.addTextChangedListener(new AnonymousClass1(pattern, defaultTextInputFormat, textInputLayout, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener));
        editText2.addTextChangedListener(new AnonymousClass2(pattern, defaultTextInputFormat, textInputLayout2, calendarConstraints, textInputLayout, textInputLayout2, onSelectionChangedListener));
        if (!DateSelector.isTouchExplorationEnabled(inflate.getContext())) {
            DateSelector.showKeyboardWithAutoHideBehavior(editText, editText2);
        }
        return inflate;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public void select(long j) {
        if (this.selectedStartItem == null) {
            this.selectedStartItem = Long.valueOf(j);
        } else if (this.selectedEndItem == null && isValidRange(this.selectedStartItem.longValue(), j)) {
            this.selectedEndItem = Long.valueOf(j);
        } else {
            this.selectedEndItem = null;
            this.selectedStartItem = Long.valueOf(j);
        }
    }

    /* renamed from: setSelection, reason: avoid collision after fix types in other method */
    public void setSelection2(Pair<Long, Long> pair) {
        if (pair.first != null && pair.second != null) {
            Preconditions.checkArgument(isValidRange(pair.first.longValue(), pair.second.longValue()));
        }
        this.selectedStartItem = pair.first == null ? null : Long.valueOf(UtcDates.canonicalYearMonthDay(pair.first.longValue()));
        this.selectedEndItem = pair.second != null ? Long.valueOf(UtcDates.canonicalYearMonthDay(pair.second.longValue())) : null;
    }

    @Override // com.google.android.material.datepicker.DateSelector
    public /* bridge */ /* synthetic */ void setSelection(Pair<Long, Long> pair) {
        setSelection2(pair);
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
        parcel.writeValue(this.selectedStartItem);
        parcel.writeValue(this.selectedEndItem);
    }
}
