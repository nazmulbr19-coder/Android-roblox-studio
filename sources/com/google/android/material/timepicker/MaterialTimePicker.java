package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.TooltipCompat;
import androidx.fragment.app.DialogFragment;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class MaterialTimePicker extends DialogFragment implements TimePickerView.OnDoubleTapListener {
    public static final int INPUT_MODE_CLOCK = 0;
    static final String INPUT_MODE_EXTRA = "TIME_PICKER_INPUT_MODE";
    public static final int INPUT_MODE_KEYBOARD = 1;
    static final String NEGATIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT";
    static final String NEGATIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_NEGATIVE_BUTTON_TEXT_RES";
    static final String OVERRIDE_THEME_RES_ID = "TIME_PICKER_OVERRIDE_THEME_RES_ID";
    static final String POSITIVE_BUTTON_TEXT_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT";
    static final String POSITIVE_BUTTON_TEXT_RES_EXTRA = "TIME_PICKER_POSITIVE_BUTTON_TEXT_RES";
    static final String TIME_MODEL_EXTRA = "TIME_PICKER_TIME_MODEL";
    static final String TITLE_RES_EXTRA = "TIME_PICKER_TITLE_RES";
    static final String TITLE_TEXT_EXTRA = "TIME_PICKER_TITLE_TEXT";
    private TimePickerPresenter activePresenter;
    private Button cancelButton;
    private int clockIcon;
    private int keyboardIcon;
    private MaterialButton modeButton;
    private CharSequence negativeButtonText;
    private Button okButton;
    private CharSequence positiveButtonText;
    private ViewStub textInputStub;
    private TimeModel time;
    private TimePickerClockPresenter timePickerClockPresenter;
    private TimePickerTextInputPresenter timePickerTextInputPresenter;
    private TimePickerView timePickerView;
    private CharSequence titleText;
    private final Set<View.OnClickListener> positiveButtonListeners = new LinkedHashSet();
    private final Set<View.OnClickListener> negativeButtonListeners = new LinkedHashSet();
    private final Set<DialogInterface.OnCancelListener> cancelListeners = new LinkedHashSet();
    private final Set<DialogInterface.OnDismissListener> dismissListeners = new LinkedHashSet();
    private int titleResId = 0;
    private int positiveButtonTextResId = 0;
    private int negativeButtonTextResId = 0;
    private int inputMode = 0;
    private int overrideThemeResId = 0;

    /* loaded from: classes.dex */
    public static final class Builder {
        private Integer inputMode;
        private CharSequence negativeButtonText;
        private CharSequence positiveButtonText;
        private CharSequence titleText;
        private TimeModel time = new TimeModel();
        private int titleTextResId = 0;
        private int positiveButtonTextResId = 0;
        private int negativeButtonTextResId = 0;
        private int overrideThemeResId = 0;

        static /* synthetic */ TimeModel access$000(Builder builder) {
            return builder.time;
        }

        static /* synthetic */ Integer access$100(Builder builder) {
            return builder.inputMode;
        }

        static /* synthetic */ int access$200(Builder builder) {
            return builder.titleTextResId;
        }

        static /* synthetic */ CharSequence access$300(Builder builder) {
            return builder.titleText;
        }

        static /* synthetic */ int access$400(Builder builder) {
            return builder.positiveButtonTextResId;
        }

        static /* synthetic */ CharSequence access$500(Builder builder) {
            return builder.positiveButtonText;
        }

        static /* synthetic */ int access$600(Builder builder) {
            return builder.negativeButtonTextResId;
        }

        static /* synthetic */ CharSequence access$700(Builder builder) {
            return builder.negativeButtonText;
        }

        static /* synthetic */ int access$800(Builder builder) {
            return builder.overrideThemeResId;
        }

        public MaterialTimePicker build() {
            return MaterialTimePicker.access$900(this);
        }

        public Builder setHour(int i) {
            this.time.setHourOfDay(i);
            return this;
        }

        public Builder setInputMode(int i) {
            this.inputMode = Integer.valueOf(i);
            return this;
        }

        public Builder setMinute(int i) {
            this.time.setMinute(i);
            return this;
        }

        public Builder setNegativeButtonText(int i) {
            this.negativeButtonTextResId = i;
            return this;
        }

        public Builder setNegativeButtonText(CharSequence charSequence) {
            this.negativeButtonText = charSequence;
            return this;
        }

        public Builder setPositiveButtonText(int i) {
            this.positiveButtonTextResId = i;
            return this;
        }

        public Builder setPositiveButtonText(CharSequence charSequence) {
            this.positiveButtonText = charSequence;
            return this;
        }

        public Builder setTheme(int i) {
            this.overrideThemeResId = i;
            return this;
        }

        public Builder setTimeFormat(int i) {
            int i2 = this.time.hour;
            int i3 = this.time.minute;
            this.time = new TimeModel(i);
            this.time.setMinute(i3);
            this.time.setHourOfDay(i2);
            return this;
        }

        public Builder setTitleText(int i) {
            this.titleTextResId = i;
            return this;
        }

        public Builder setTitleText(CharSequence charSequence) {
            this.titleText = charSequence;
            return this;
        }
    }

    /* loaded from: classes.dex */
    private static final class ModeButtonData {
        final int contentDescriptionResId;
        final int iconResId;
        final int tooltipTextResId;

        ModeButtonData(int i, int i2, int i3) {
            this.iconResId = i;
            this.contentDescriptionResId = i2;
            this.tooltipTextResId = i3;
        }
    }

    static /* synthetic */ MaterialTimePicker access$900(Builder builder) {
        return newInstance(builder);
    }

    private ModeButtonData getModeButtonData(int i) {
        switch (i) {
            case 0:
                return new ModeButtonData(this.keyboardIcon, R.string.material_timepicker_text_input_mode_description, R.string.material_timepicker_text_input_mode_tooltip);
            case 1:
                return new ModeButtonData(this.clockIcon, R.string.material_timepicker_clock_mode_description, R.string.material_timepicker_clock_mode_tooltip);
            default:
                throw new IllegalArgumentException("no button data for mode: " + i);
        }
    }

    private int getThemeResId() {
        if (this.overrideThemeResId != 0) {
            return this.overrideThemeResId;
        }
        TypedValue resolve = MaterialAttributes.resolve(requireContext(), R.attr.materialTimePickerTheme);
        if (resolve == null) {
            return 0;
        }
        return resolve.data;
    }

    private TimePickerPresenter initializeOrRetrieveActivePresenterForMode(int i, TimePickerView timePickerView, ViewStub viewStub) {
        if (i == 0) {
            this.timePickerClockPresenter = this.timePickerClockPresenter == null ? new TimePickerClockPresenter(timePickerView, this.time) : this.timePickerClockPresenter;
            return this.timePickerClockPresenter;
        }
        if (this.timePickerTextInputPresenter == null) {
            this.timePickerTextInputPresenter = new TimePickerTextInputPresenter((LinearLayout) viewStub.inflate(), this.time);
        }
        this.timePickerTextInputPresenter.clearError();
        this.timePickerTextInputPresenter.clearCheck();
        return this.timePickerTextInputPresenter;
    }

    private static MaterialTimePicker newInstance(Builder builder) {
        MaterialTimePicker materialTimePicker = new MaterialTimePicker();
        Bundle bundle = new Bundle();
        bundle.putParcelable(TIME_MODEL_EXTRA, Builder.access$000(builder));
        if (Builder.access$100(builder) != null) {
            bundle.putInt(INPUT_MODE_EXTRA, Builder.access$100(builder).intValue());
        }
        bundle.putInt(TITLE_RES_EXTRA, Builder.access$200(builder));
        if (Builder.access$300(builder) != null) {
            bundle.putCharSequence(TITLE_TEXT_EXTRA, Builder.access$300(builder));
        }
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, Builder.access$400(builder));
        if (Builder.access$500(builder) != null) {
            bundle.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, Builder.access$500(builder));
        }
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, Builder.access$600(builder));
        if (Builder.access$700(builder) != null) {
            bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, Builder.access$700(builder));
        }
        bundle.putInt(OVERRIDE_THEME_RES_ID, Builder.access$800(builder));
        materialTimePicker.setArguments(bundle);
        return materialTimePicker;
    }

    private void restoreState(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        this.time = (TimeModel) bundle.getParcelable(TIME_MODEL_EXTRA);
        if (this.time == null) {
            this.time = new TimeModel();
        }
        int i = 1;
        if (!getResources().getBoolean(R.bool.timepicker_force_input_mode_keyboard) && this.time.format != 1) {
            i = 0;
        }
        this.inputMode = bundle.getInt(INPUT_MODE_EXTRA, i);
        this.titleResId = bundle.getInt(TITLE_RES_EXTRA, 0);
        this.titleText = bundle.getCharSequence(TITLE_TEXT_EXTRA);
        this.positiveButtonTextResId = bundle.getInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.positiveButtonText = bundle.getCharSequence(POSITIVE_BUTTON_TEXT_EXTRA);
        this.negativeButtonTextResId = bundle.getInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, 0);
        this.negativeButtonText = bundle.getCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA);
        this.overrideThemeResId = bundle.getInt(OVERRIDE_THEME_RES_ID, 0);
    }

    private void updateCancelButtonVisibility() {
        if (this.cancelButton != null) {
            this.cancelButton.setVisibility(isCancelable() ? 0 : 8);
        }
    }

    private void updateInputMode(MaterialButton materialButton) {
        if (materialButton == null || this.timePickerView == null || this.textInputStub == null) {
            return;
        }
        if (this.activePresenter != null) {
            this.activePresenter.hide();
        }
        this.activePresenter = initializeOrRetrieveActivePresenterForMode(this.inputMode, this.timePickerView, this.textInputStub);
        this.activePresenter.show();
        this.activePresenter.invalidate();
        ModeButtonData modeButtonData = getModeButtonData(this.inputMode);
        materialButton.setIconResource(modeButtonData.iconResId);
        materialButton.setContentDescription(getResources().getString(modeButtonData.contentDescriptionResId));
        TooltipCompat.setTooltipText(materialButton, getResources().getString(modeButtonData.tooltipTextResId));
        materialButton.sendAccessibilityEvent(4);
    }

    public boolean addOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.add(onCancelListener);
    }

    public boolean addOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.add(onDismissListener);
    }

    public boolean addOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.add(onClickListener);
    }

    public boolean addOnPositiveButtonClickListener(View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.add(onClickListener);
    }

    public void clearOnCancelListeners() {
        this.cancelListeners.clear();
    }

    public void clearOnDismissListeners() {
        this.dismissListeners.clear();
    }

    public void clearOnNegativeButtonClickListeners() {
        this.negativeButtonListeners.clear();
    }

    public void clearOnPositiveButtonClickListeners() {
        this.positiveButtonListeners.clear();
    }

    public int getHour() {
        return this.time.hour % 24;
    }

    public int getInputMode() {
        return this.inputMode;
    }

    public int getMinute() {
        return this.time.minute;
    }

    TimePickerClockPresenter getTimePickerClockPresenter() {
        return this.timePickerClockPresenter;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$0$com-google-android-material-timepicker-MaterialTimePicker, reason: not valid java name */
    public /* synthetic */ void m445x6d8f60b9(ViewGroup viewGroup, View view) {
        if (this.activePresenter instanceof TimePickerTextInputPresenter) {
            TimePickerTextInputPresenter timePickerTextInputPresenter = (TimePickerTextInputPresenter) this.activePresenter;
            if (timePickerTextInputPresenter.hasError()) {
                timePickerTextInputPresenter.vibrateAndMaybeBeep(viewGroup);
                timePickerTextInputPresenter.accessibilityFocusOnError();
                return;
            }
        }
        Iterator<View.OnClickListener> it = this.positiveButtonListeners.iterator();
        while (it.hasNext()) {
            it.next().onClick(view);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$1$com-google-android-material-timepicker-MaterialTimePicker, reason: not valid java name */
    public /* synthetic */ void m446x7e452d7a(View view) {
        Iterator<View.OnClickListener> it = this.negativeButtonListeners.iterator();
        while (it.hasNext()) {
            it.next().onClick(view);
        }
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onCreateView$2$com-google-android-material-timepicker-MaterialTimePicker, reason: not valid java name */
    public /* synthetic */ void m447x8efafa3b(View view) {
        this.inputMode = this.inputMode == 0 ? 1 : 0;
        updateInputMode(this.modeButton);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$onViewCreated$3$com-google-android-material-timepicker-MaterialTimePicker, reason: not valid java name */
    public /* synthetic */ void m448xde954046() {
        if (this.activePresenter instanceof TimePickerTextInputPresenter) {
            ((TimePickerTextInputPresenter) this.activePresenter).resetChecked();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnCancelListener> it = this.cancelListeners.iterator();
        while (it.hasNext()) {
            it.next().onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        restoreState(bundle == null ? getArguments() : bundle);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), getThemeResId());
        Context context = dialog.getContext();
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(context, null, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.MaterialTimePicker, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        this.clockIcon = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.keyboardIcon = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        int color = obtainStyledAttributes.getColor(R.styleable.MaterialTimePicker_backgroundTint, 0);
        obtainStyledAttributes.recycle();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(materialShapeDrawable);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        materialShapeDrawable.setElevation(window.getDecorView().getElevation());
        return dialog;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        this.timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.timePickerView.setOnDoubleTapListener(this);
        this.textInputStub = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.modeButton = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        this.okButton = (Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button);
        this.cancelButton = (Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        if (this.titleResId != 0) {
            textView.setText(this.titleResId);
        } else if (!TextUtils.isEmpty(this.titleText)) {
            textView.setText(this.titleText);
        }
        updateInputMode(this.modeButton);
        this.okButton.setOnClickListener(new MaterialTimePicker$$ExternalSyntheticLambda0(this, viewGroup2));
        if (this.positiveButtonTextResId != 0) {
            this.okButton.setText(this.positiveButtonTextResId);
        } else if (!TextUtils.isEmpty(this.positiveButtonText)) {
            this.okButton.setText(this.positiveButtonText);
        }
        this.cancelButton.setOnClickListener(new MaterialTimePicker$$ExternalSyntheticLambda1(this));
        if (this.negativeButtonTextResId != 0) {
            this.cancelButton.setText(this.negativeButtonTextResId);
        } else if (!TextUtils.isEmpty(this.negativeButtonText)) {
            this.cancelButton.setText(this.negativeButtonText);
        }
        updateCancelButtonVisibility();
        this.modeButton.setOnClickListener(new MaterialTimePicker$$ExternalSyntheticLambda2(this));
        return viewGroup2;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        this.activePresenter = null;
        this.timePickerClockPresenter = null;
        this.timePickerTextInputPresenter = null;
        if (this.timePickerView != null) {
            this.timePickerView.setOnDoubleTapListener(null);
            this.timePickerView = null;
        }
    }

    @Override // androidx.fragment.app.DialogFragment, android.content.DialogInterface.OnDismissListener
    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator<DialogInterface.OnDismissListener> it = this.dismissListeners.iterator();
        while (it.hasNext()) {
            it.next().onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    @Override // com.google.android.material.timepicker.TimePickerView.OnDoubleTapListener
    public void onDoubleTap() {
        this.inputMode = 1;
        updateInputMode(this.modeButton);
        this.timePickerTextInputPresenter.resetChecked();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable(TIME_MODEL_EXTRA, this.time);
        bundle.putInt(INPUT_MODE_EXTRA, this.inputMode);
        bundle.putInt(TITLE_RES_EXTRA, this.titleResId);
        bundle.putCharSequence(TITLE_TEXT_EXTRA, this.titleText);
        bundle.putInt(POSITIVE_BUTTON_TEXT_RES_EXTRA, this.positiveButtonTextResId);
        bundle.putCharSequence(POSITIVE_BUTTON_TEXT_EXTRA, this.positiveButtonText);
        bundle.putInt(NEGATIVE_BUTTON_TEXT_RES_EXTRA, this.negativeButtonTextResId);
        bundle.putCharSequence(NEGATIVE_BUTTON_TEXT_EXTRA, this.negativeButtonText);
        bundle.putInt(OVERRIDE_THEME_RES_ID, this.overrideThemeResId);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (this.activePresenter instanceof TimePickerTextInputPresenter) {
            view.postDelayed(new MaterialTimePicker$$ExternalSyntheticLambda3(this), 100L);
        }
    }

    public boolean removeOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
        return this.cancelListeners.remove(onCancelListener);
    }

    public boolean removeOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
        return this.dismissListeners.remove(onDismissListener);
    }

    public boolean removeOnNegativeButtonClickListener(View.OnClickListener onClickListener) {
        return this.negativeButtonListeners.remove(onClickListener);
    }

    public boolean removeOnPositiveButtonClickListener(View.OnClickListener onClickListener) {
        return this.positiveButtonListeners.remove(onClickListener);
    }

    void setActivePresenter(TimePickerPresenter timePickerPresenter) {
        this.activePresenter = timePickerPresenter;
    }

    @Override // androidx.fragment.app.DialogFragment
    public void setCancelable(boolean z) {
        super.setCancelable(z);
        updateCancelButtonVisibility();
    }

    public void setHour(int i) {
        this.time.setHourOfDay(i);
        if (this.activePresenter != null) {
            this.activePresenter.invalidate();
        }
    }

    public void setMinute(int i) {
        this.time.setMinute(i);
        if (this.activePresenter != null) {
            this.activePresenter.invalidate();
        }
    }
}
