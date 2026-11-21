package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.media.AudioManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;

/* loaded from: classes.dex */
class TimePickerTextInputPresenter implements TimePickerView.OnSelectionChange, TimePickerPresenter {
    private static final int HOURS_MAX_LENGTH = 2;
    private static final int HOURS_MAX_VALUE_12H = 12;
    private static final int HOURS_MAX_VALUE_24H = 23;
    private static final int MINUTES_MAX_LENGTH = 2;
    private static final int MINUTES_MAX_VALUE = 59;
    private final TimePickerTextInputKeyController controller;
    private final EditText hourEditText;
    private final String hourError24hText;
    private final String hourErrorText;
    private final TextView hourLabel;
    private final String hourText;
    private final ChipTextInputComboView hourTextInput;
    private final EditText minuteEditText;
    private final String minuteErrorText;
    private final TextView minuteLabel;
    private final String minuteText;
    private final ChipTextInputComboView minuteTextInput;
    private final TimeModel time;
    private final LinearLayout timePickerView;
    private MaterialButtonToggleGroup toggle;
    private final TextWatcher minuteTextWatcher = new AnonymousClass1();
    private final TextWatcher hourTextWatcher = new AnonymousClass2();

    /* renamed from: com.google.android.material.timepicker.TimePickerTextInputPresenter$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends TextWatcherAdapter {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.access$000(TimePickerTextInputPresenter.this).setMinute(0);
                    TimePickerTextInputPresenter.access$100(TimePickerTextInputPresenter.this);
                } else {
                    if (editable.length() > 2) {
                        editable.delete(2, editable.length());
                        TimePickerTextInputPresenter.this.vibrateAndMaybeBeep(TimePickerTextInputPresenter.access$200(TimePickerTextInputPresenter.this));
                        return;
                    }
                    int parseInt = Integer.parseInt(editable.toString());
                    if (parseInt > 59) {
                        TimePickerTextInputPresenter.access$300(TimePickerTextInputPresenter.this);
                    } else {
                        TimePickerTextInputPresenter.access$100(TimePickerTextInputPresenter.this);
                    }
                    TimePickerTextInputPresenter.access$000(TimePickerTextInputPresenter.this).setMinute(parseInt);
                }
            } catch (NumberFormatException e) {
                TimePickerTextInputPresenter.access$300(TimePickerTextInputPresenter.this);
            }
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerTextInputPresenter$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends TextWatcherAdapter {
        AnonymousClass2() {
        }

        @Override // com.google.android.material.internal.TextWatcherAdapter, android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    TimePickerTextInputPresenter.access$000(TimePickerTextInputPresenter.this).setHour(0);
                    TimePickerTextInputPresenter.access$400(TimePickerTextInputPresenter.this);
                    return;
                }
                if (editable.length() > 2) {
                    editable.delete(2, editable.length());
                    TimePickerTextInputPresenter.this.vibrateAndMaybeBeep(TimePickerTextInputPresenter.access$500(TimePickerTextInputPresenter.this));
                    return;
                }
                int parseInt = Integer.parseInt(editable.toString());
                if ((TimePickerTextInputPresenter.access$000(TimePickerTextInputPresenter.this).format != 0 || parseInt <= 12) && (TimePickerTextInputPresenter.access$000(TimePickerTextInputPresenter.this).format != 1 || parseInt <= 23)) {
                    TimePickerTextInputPresenter.access$400(TimePickerTextInputPresenter.this);
                    TimePickerTextInputPresenter.access$000(TimePickerTextInputPresenter.this).setHour(parseInt);
                }
                TimePickerTextInputPresenter.access$600(TimePickerTextInputPresenter.this);
                TimePickerTextInputPresenter.access$000(TimePickerTextInputPresenter.this).setHour(parseInt);
            } catch (NumberFormatException e) {
                TimePickerTextInputPresenter.access$600(TimePickerTextInputPresenter.this);
            }
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerTextInputPresenter$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 extends ClickActionDelegate {
        final /* synthetic */ Resources val$res;
        final /* synthetic */ TimeModel val$time;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Context context, int i, Resources resources, TimeModel timeModel) {
            super(context, i);
            this.val$res = resources;
            this.val$time = timeModel;
        }

        @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(this.val$res.getString(R.string.material_timepicker_hour) + " " + view.getResources().getString(this.val$time.getHourContentDescriptionResId(), String.valueOf(this.val$time.getHourForDisplay())));
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerTextInputPresenter$4, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass4 extends ClickActionDelegate {
        final /* synthetic */ Resources val$res;
        final /* synthetic */ TimeModel val$time;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(Context context, int i, Resources resources, TimeModel timeModel) {
            super(context, i);
            this.val$res = resources;
            this.val$time = timeModel;
        }

        @Override // com.google.android.material.timepicker.ClickActionDelegate, androidx.core.view.AccessibilityDelegateCompat
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            accessibilityNodeInfoCompat.setContentDescription(this.val$res.getString(R.string.material_timepicker_minute) + " " + view.getResources().getString(R.string.material_minute_suffix, String.valueOf(this.val$time.minute)));
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerTextInputPresenter$5, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass5 extends View.AccessibilityDelegate {
        final /* synthetic */ int val$contentDescriptionResId;
        final /* synthetic */ Resources val$res;

        AnonymousClass5(Resources resources, int i) {
            this.val$res = resources;
            this.val$contentDescriptionResId = i;
        }

        @Override // android.view.View.AccessibilityDelegate
        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfo);
            accessibilityNodeInfo.setText(this.val$res.getString(this.val$contentDescriptionResId));
        }
    }

    public TimePickerTextInputPresenter(LinearLayout linearLayout, TimeModel timeModel) {
        this.timePickerView = linearLayout;
        this.time = timeModel;
        Resources resources = linearLayout.getResources();
        this.minuteTextInput = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.hourTextInput = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.minuteLabel = (TextView) this.minuteTextInput.findViewById(R.id.material_label);
        this.hourLabel = (TextView) this.hourTextInput.findViewById(R.id.material_label);
        this.minuteLabel.setText(resources.getString(R.string.material_timepicker_minute));
        this.minuteLabel.setImportantForAccessibility(2);
        this.hourLabel.setText(resources.getString(R.string.material_timepicker_hour));
        this.hourLabel.setImportantForAccessibility(2);
        this.minuteText = resources.getString(R.string.material_timepicker_minute);
        this.hourText = resources.getString(R.string.material_timepicker_hour);
        this.minuteErrorText = resources.getString(R.string.material_timepicker_minute_error);
        this.hourErrorText = resources.getString(R.string.material_timepicker_hour_error);
        this.hourError24hText = resources.getString(R.string.material_timepicker_hour_error_24h);
        this.minuteTextInput.setTag(R.id.selection_type, 12);
        this.hourTextInput.setTag(R.id.selection_type, 10);
        if (timeModel.format == 0) {
            setupPeriodToggle();
        }
        TimePickerTextInputPresenter$$ExternalSyntheticLambda1 timePickerTextInputPresenter$$ExternalSyntheticLambda1 = new TimePickerTextInputPresenter$$ExternalSyntheticLambda1(this);
        this.hourTextInput.setOnClickListener(timePickerTextInputPresenter$$ExternalSyntheticLambda1);
        this.minuteTextInput.setOnClickListener(timePickerTextInputPresenter$$ExternalSyntheticLambda1);
        this.hourEditText = this.hourTextInput.getTextInput().getEditText();
        this.hourEditText.setAccessibilityDelegate(setTimeUnitAccessibilityLabel(linearLayout.getResources(), R.string.material_timepicker_hour));
        this.minuteEditText = this.minuteTextInput.getTextInput().getEditText();
        this.minuteEditText.setAccessibilityDelegate(setTimeUnitAccessibilityLabel(linearLayout.getResources(), R.string.material_timepicker_minute));
        this.controller = new TimePickerTextInputKeyController(this.hourTextInput, this.minuteTextInput, timeModel);
        this.hourTextInput.setChipDelegate(new AnonymousClass3(linearLayout.getContext(), R.string.material_hour_selection, resources, timeModel));
        this.minuteTextInput.setChipDelegate(new AnonymousClass4(linearLayout.getContext(), R.string.material_minute_selection, resources, timeModel));
        initialize();
    }

    static /* synthetic */ TimeModel access$000(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        return timePickerTextInputPresenter.time;
    }

    static /* synthetic */ void access$100(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        timePickerTextInputPresenter.clearMinuteError();
    }

    static /* synthetic */ EditText access$200(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        return timePickerTextInputPresenter.minuteEditText;
    }

    static /* synthetic */ void access$300(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        timePickerTextInputPresenter.setMinuteError();
    }

    static /* synthetic */ void access$400(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        timePickerTextInputPresenter.clearHourError();
    }

    static /* synthetic */ EditText access$500(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        return timePickerTextInputPresenter.hourEditText;
    }

    static /* synthetic */ void access$600(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        timePickerTextInputPresenter.setHourError();
    }

    private void addTextWatchers() {
        this.hourEditText.addTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.addTextChangedListener(this.minuteTextWatcher);
    }

    private void beep(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            audioManager.playSoundEffect(9);
        }
    }

    private void clearHourError() {
        this.hourTextInput.setError(false);
        this.hourLabel.setText(this.hourText);
    }

    private void clearMinuteError() {
        this.minuteTextInput.setError(false);
        this.minuteLabel.setText(this.minuteText);
    }

    private static boolean isTouchExplorationEnabled(Context context) {
        AccessibilityManager accessibilityManager = (AccessibilityManager) context.getSystemService("accessibility");
        return accessibilityManager != null && accessibilityManager.isTouchExplorationEnabled();
    }

    private void removeTextWatchers() {
        this.hourEditText.removeTextChangedListener(this.hourTextWatcher);
        this.minuteEditText.removeTextChangedListener(this.minuteTextWatcher);
    }

    private void requestAccessibilityFocusAndAnnounce(ChipTextInputComboView chipTextInputComboView, TextView textView) {
        chipTextInputComboView.requestAccessibilityFocus();
        textView.announceForAccessibility(textView.getText());
    }

    private void setHourError() {
        this.hourTextInput.setError(true);
        this.hourLabel.setText(this.time.format == 1 ? this.hourError24hText : this.hourErrorText);
        this.hourLabel.announceForAccessibility(this.hourLabel.getText());
        vibrateAndMaybeBeep(this.hourLabel);
    }

    private void setMinuteError() {
        this.minuteTextInput.setError(true);
        this.minuteLabel.setText(this.minuteErrorText);
        this.minuteLabel.announceForAccessibility(this.minuteLabel.getText());
        vibrateAndMaybeBeep(this.minuteLabel);
    }

    private void setTime(TimeModel timeModel) {
        removeTextWatchers();
        Locale locale = this.timePickerView.getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.minute));
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(timeModel.getHourForDisplay()));
        this.minuteTextInput.setText(format);
        this.hourTextInput.setText(format2);
        addTextWatchers();
        onSelectionChanged(timeModel.selection);
    }

    private View.AccessibilityDelegate setTimeUnitAccessibilityLabel(Resources resources, int i) {
        return new AnonymousClass5(resources, i);
    }

    private void setupPeriodToggle() {
        this.toggle = (MaterialButtonToggleGroup) this.timePickerView.findViewById(R.id.material_clock_period_toggle);
        this.toggle.addOnButtonCheckedListener(new TimePickerTextInputPresenter$$ExternalSyntheticLambda0(this));
        this.toggle.setVisibility(0);
        updateSelection();
    }

    private void updateSelection() {
        if (this.toggle == null) {
            return;
        }
        this.toggle.check(this.time.period == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button);
    }

    private void vibrate(View view) {
        ViewCompat.performHapticFeedback(view, 17);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void accessibilityFocusOnError() {
        if (this.hourTextInput.hasError()) {
            requestAccessibilityFocusAndAnnounce(this.hourTextInput, this.hourLabel);
        } else if (this.minuteTextInput.hasError()) {
            requestAccessibilityFocusAndAnnounce(this.minuteTextInput, this.minuteLabel);
        }
    }

    public void clearCheck() {
        this.minuteTextInput.setChecked(false);
        this.hourTextInput.setChecked(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void clearError() {
        clearMinuteError();
        clearHourError();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean hasError() {
        return this.minuteTextInput.hasError() || this.hourTextInput.hasError();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void hide() {
        View focusedChild = this.timePickerView.getFocusedChild();
        if (focusedChild != null) {
            ViewUtils.hideKeyboard(focusedChild, false);
        }
        this.timePickerView.setVisibility(8);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void initialize() {
        addTextWatchers();
        setTime(this.time);
        this.controller.bind();
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void invalidate() {
        setTime(this.time);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-material-timepicker-TimePickerTextInputPresenter, reason: not valid java name */
    public /* synthetic */ void m449x9cf2bb63(View view) {
        onSelectionChanged(((Integer) view.getTag(R.id.selection_type)).intValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$setupPeriodToggle$1$com-google-android-material-timepicker-TimePickerTextInputPresenter, reason: not valid java name */
    public /* synthetic */ void m450xe359ee16(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        if (z) {
            this.time.setPeriod(i == R.id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnSelectionChange
    public void onSelectionChanged(int i) {
        this.time.selection = i;
        this.minuteTextInput.setChecked(i == 12);
        this.hourTextInput.setChecked(i == 10);
        updateSelection();
    }

    public void resetChecked() {
        this.minuteTextInput.setChecked(this.time.selection == 12);
        this.hourTextInput.setChecked(this.time.selection == 10);
    }

    @Override // com.google.android.material.timepicker.TimePickerPresenter
    public void show() {
        this.timePickerView.setVisibility(0);
        onSelectionChanged(this.time.selection);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void vibrateAndMaybeBeep(View view) {
        vibrate(view);
        if (isTouchExplorationEnabled(view.getContext())) {
            return;
        }
        beep(view.getContext());
    }
}
