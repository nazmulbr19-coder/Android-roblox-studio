package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;

/* loaded from: classes.dex */
class ChipTextInputComboView extends FrameLayout implements Checkable {
    private final Chip chip;
    private CharSequence chipText;
    private final EditText editText;
    private final AccessibilityDelegateCompat editTextAccessibilityDelegate;
    private boolean hasError;
    private TextView label;
    private ColorStateList originalChipBackgroundColor;
    private int originalChipStrokeColor;
    private ColorStateList originalChipTextColor;
    private ColorStateList originalEditTextColor;
    private ColorStateList originalEditTextCursorColor;
    private ColorStateList originalLabelColor;
    private final TextInputLayout textInputLayout;
    private TextWatcher watcher;

    /* renamed from: com.google.android.material.timepicker.ChipTextInputComboView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AccessibilityDelegateCompat {
        AnonymousClass1() {
        }

        @Override // androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setText(((EditText) view).getText());
            accessibilityNodeInfoCompat.setHintText(ChipTextInputComboView.access$100(ChipTextInputComboView.this).getText());
            accessibilityNodeInfoCompat.setMaxTextLength(2);
        }
    }

    /* loaded from: classes.dex */
    private class TextFormatter extends TextWatcherAdapter {
        private static final String DEFAULT_TEXT = "00";

        private TextFormatter() {
        }

        /* synthetic */ TextFormatter(ChipTextInputComboView chipTextInputComboView, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.access$202(ChipTextInputComboView.this, ChipTextInputComboView.access$300(ChipTextInputComboView.this, DEFAULT_TEXT));
            } else {
                String access$300 = ChipTextInputComboView.access$300(ChipTextInputComboView.this, editable);
                ChipTextInputComboView.access$202(ChipTextInputComboView.this, TextUtils.isEmpty(access$300) ? ChipTextInputComboView.access$300(ChipTextInputComboView.this, DEFAULT_TEXT) : access$300);
            }
        }
    }

    public ChipTextInputComboView(Context context) {
        this(context, null);
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.chipText = "";
        this.hasError = false;
        LayoutInflater from = LayoutInflater.from(context);
        this.chip = (Chip) from.inflate(R.layout.material_time_chip, (ViewGroup) this, false);
        this.chip.setAccessibilityClassName("android.view.View");
        this.textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, (ViewGroup) this, false);
        this.editText = this.textInputLayout.getEditText();
        this.editText.setVisibility(4);
        this.watcher = new TextFormatter(this, null);
        this.editText.addTextChangedListener(this.watcher);
        updateHintLocales();
        addView(this.chip);
        addView(this.textInputLayout);
        this.label = (TextView) findViewById(R.id.material_label);
        this.editText.setId(View.generateViewId());
        this.label.setLabelFor(this.editText.getId());
        this.editText.setSaveEnabled(false);
        this.editText.setLongClickable(false);
        this.editTextAccessibilityDelegate = new AnonymousClass1();
    }

    static /* synthetic */ TextView access$100(ChipTextInputComboView chipTextInputComboView) {
        return chipTextInputComboView.label;
    }

    static /* synthetic */ CharSequence access$202(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        chipTextInputComboView.chipText = charSequence;
        return charSequence;
    }

    static /* synthetic */ String access$300(ChipTextInputComboView chipTextInputComboView, CharSequence charSequence) {
        return chipTextInputComboView.formatText(charSequence);
    }

    private void applyErrorColors() {
        this.originalChipBackgroundColor = this.chip.getChipBackgroundColor();
        this.originalChipTextColor = this.chip.getTextColors();
        this.originalEditTextColor = this.editText.getTextColors();
        this.originalLabelColor = this.label.getTextColors();
        this.originalChipStrokeColor = this.textInputLayout.getBoxStrokeColor();
        int color = MaterialColors.getColor(this, androidx.appcompat.R.attr.colorError);
        ColorStateList colorStateListOrNull = MaterialColors.getColorStateListOrNull(getContext(), R.attr.colorErrorContainer);
        ColorStateList colorStateListOrNull2 = MaterialColors.getColorStateListOrNull(getContext(), R.attr.colorOnErrorContainer);
        if (colorStateListOrNull == null || colorStateListOrNull2 == null) {
            return;
        }
        this.chip.setChipBackgroundColor(colorStateListOrNull);
        this.chip.setTextColor(colorStateListOrNull2);
        this.editText.setTextColor(colorStateListOrNull2);
        this.textInputLayout.setBoxStrokeColor(color);
        this.label.setTextColor(color);
        if (Build.VERSION.SDK_INT >= 29) {
            this.originalEditTextCursorColor = this.textInputLayout.getCursorColor();
            this.textInputLayout.setCursorColor(colorStateListOrNull2);
        }
    }

    private void clearErrorColors() {
        this.chip.setChipBackgroundColor(this.originalChipBackgroundColor);
        this.chip.setTextColor(this.originalChipTextColor);
        this.editText.setTextColor(this.originalEditTextColor);
        this.textInputLayout.setBoxStrokeColor(this.originalChipStrokeColor);
        this.label.setTextColor(this.originalLabelColor);
        if (Build.VERSION.SDK_INT >= 29) {
            this.textInputLayout.setCursorColor(this.originalEditTextCursorColor);
        }
    }

    private String formatText(CharSequence charSequence) {
        return TimeModel.formatText(getResources(), charSequence);
    }

    private void updateHintLocales() {
        int i = Build.VERSION.SDK_INT;
        this.editText.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
    }

    public void addInputFilter(InputFilter inputFilter) {
        InputFilter[] filters = this.editText.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.editText.setFilters(inputFilterArr);
    }

    CharSequence getChipText() {
        return this.chipText;
    }

    public TextInputLayout getTextInput() {
        return this.textInputLayout;
    }

    public boolean hasError() {
        return this.hasError;
    }

    @Override // android.widget.Checkable
    public boolean isChecked() {
        return this.chip.isChecked();
    }

    @Override // android.view.View
    protected void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        updateHintLocales();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void requestAccessibilityFocus() {
        if (this.editText.getVisibility() == 0) {
            this.editText.sendAccessibilityEvent(8);
        } else {
            this.chip.sendAccessibilityEvent(8);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z) {
        this.chip.setChecked(z);
        if (z) {
            this.chip.setText("");
            this.chip.setImportantForAccessibility(2);
        } else {
            this.chip.setText(this.chipText);
            this.chip.setImportantForAccessibility(1);
        }
        this.editText.setVisibility(z ? 0 : 4);
        if (isChecked()) {
            ViewUtils.requestFocusAndShowKeyboard(this.editText, false);
        }
    }

    public void setChipDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.chip, accessibilityDelegateCompat);
    }

    public void setCursorVisible(boolean z) {
        this.editText.setCursorVisible(z);
    }

    public void setError(boolean z) {
        if (this.hasError == z) {
            return;
        }
        this.hasError = z;
        if (z) {
            applyErrorColors();
        } else {
            clearErrorColors();
        }
    }

    public void setHelperText(CharSequence charSequence) {
        this.label.setText(charSequence);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.chip.setOnClickListener(onClickListener);
    }

    @Override // android.view.View
    public void setTag(int i, Object obj) {
        this.chip.setTag(i, obj);
    }

    public void setText(CharSequence charSequence) {
        String formatText = formatText(charSequence);
        this.chipText = formatText;
        this.chip.setText(formatText);
        if (TextUtils.isEmpty(formatText)) {
            return;
        }
        this.editText.removeTextChangedListener(this.watcher);
        this.editText.setText(formatText);
        ViewCompat.setAccessibilityDelegate(this.editText, this.editTextAccessibilityDelegate);
        this.editText.addTextChangedListener(this.watcher);
    }

    @Override // android.widget.Checkable
    public void toggle() {
        this.chip.toggle();
    }
}
