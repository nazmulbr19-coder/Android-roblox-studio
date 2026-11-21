package com.google.android.material.timepicker;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;

/* loaded from: classes.dex */
class TimePickerView extends ConstraintLayout implements TimePickerControls {
    static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private final ClockFaceView clockFace;
    private final ClockHandView clockHandView;
    private final Chip hourView;
    private final Chip minuteView;
    private OnDoubleTapListener onDoubleTapListener;
    private OnPeriodChangeListener onPeriodChangeListener;
    private OnSelectionChange onSelectionChangeListener;
    private final View.OnClickListener selectionListener;
    private final MaterialButtonToggleGroup toggle;

    /* renamed from: com.google.android.material.timepicker.TimePickerView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements View.OnClickListener {
        AnonymousClass1() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TimePickerView.access$000(TimePickerView.this) != null) {
                TimePickerView.access$000(TimePickerView.this).onSelectionChanged(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends GestureDetector.SimpleOnGestureListener {
        AnonymousClass2() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            OnDoubleTapListener access$100 = TimePickerView.access$100(TimePickerView.this);
            if (access$100 == null) {
                return false;
            }
            access$100.onDoubleTap();
            return true;
        }
    }

    /* renamed from: com.google.android.material.timepicker.TimePickerView$3, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass3 implements View.OnTouchListener {
        final /* synthetic */ GestureDetector val$gestureDetector;

        AnonymousClass3(GestureDetector gestureDetector) {
            this.val$gestureDetector = gestureDetector;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (((Checkable) view).isChecked()) {
                return this.val$gestureDetector.onTouchEvent(motionEvent);
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    interface OnDoubleTapListener {
        void onDoubleTap();
    }

    /* loaded from: classes.dex */
    interface OnPeriodChangeListener {
        void onPeriodChange(int i);
    }

    /* loaded from: classes.dex */
    interface OnSelectionChange {
        void onSelectionChanged(int i);
    }

    public TimePickerView(Context context) {
        this(context, null);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.selectionListener = new AnonymousClass1();
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.clockFace = (ClockFaceView) findViewById(R.id.material_clock_face);
        this.toggle = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.toggle.addOnButtonCheckedListener(new TimePickerView$$ExternalSyntheticLambda0(this));
        this.minuteView = (Chip) findViewById(R.id.material_minute_tv);
        this.hourView = (Chip) findViewById(R.id.material_hour_tv);
        this.clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.clockFace.setOnEnterKeyPressedListener(new TimePickerView$$ExternalSyntheticLambda1(this));
        setupDoubleTap();
        setUpDisplay();
    }

    static /* synthetic */ OnSelectionChange access$000(TimePickerView timePickerView) {
        return timePickerView.onSelectionChangeListener;
    }

    static /* synthetic */ OnDoubleTapListener access$100(TimePickerView timePickerView) {
        return timePickerView.onDoubleTapListener;
    }

    private void setUpDisplay() {
        this.minuteView.setTag(R.id.selection_type, 12);
        this.hourView.setTag(R.id.selection_type, 10);
        this.minuteView.setOnClickListener(this.selectionListener);
        this.hourView.setOnClickListener(this.selectionListener);
        this.minuteView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
        this.hourView.setAccessibilityClassName(GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME);
    }

    private void setupDoubleTap() {
        AnonymousClass3 anonymousClass3 = new AnonymousClass3(new GestureDetector(getContext(), new AnonymousClass2()));
        this.minuteView.setOnTouchListener(anonymousClass3);
        this.hourView.setOnTouchListener(anonymousClass3);
    }

    private void updateSelection(Chip chip, boolean z) {
        chip.setChecked(z);
        chip.setAccessibilityLiveRegion(z ? 2 : 0);
    }

    public void addOnRotateListener(ClockHandView.OnRotateListener onRotateListener) {
        this.clockHandView.addOnRotateListener(onRotateListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int getCurrentLevel() {
        return this.clockFace.getCurrentLevel();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-material-timepicker-TimePickerView, reason: not valid java name */
    public /* synthetic */ void m451x9f44237d(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z) {
        if (z && this.onPeriodChangeListener != null) {
            this.onPeriodChangeListener.onPeriodChange(i == R.id.material_clock_period_pm_button ? 1 : 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$1$com-google-android-material-timepicker-TimePickerView, reason: not valid java name */
    public /* synthetic */ void m452xc89878be() {
        if (!this.hourView.isChecked() || this.onSelectionChangeListener == null) {
            return;
        }
        this.onSelectionChangeListener.onSelectionChanged(12);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            this.hourView.sendAccessibilityEvent(8);
        }
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setActiveSelection(int i) {
        updateSelection(this.minuteView, i == 12);
        updateSelection(this.hourView, i == 10);
    }

    public void setAnimateOnTouchUp(boolean z) {
        this.clockHandView.setAnimateOnTouchUp(z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCurrentLevel(int i) {
        this.clockFace.setCurrentLevel(i);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setHandRotation(float f) {
        this.clockHandView.setHandRotation(f);
    }

    public void setHandRotation(float f, boolean z) {
        this.clockHandView.setHandRotation(f, z);
    }

    public void setHourClickDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.minuteView, accessibilityDelegateCompat);
    }

    public void setMinuteHourDelegate(AccessibilityDelegateCompat accessibilityDelegateCompat) {
        ViewCompat.setAccessibilityDelegate(this.hourView, accessibilityDelegateCompat);
    }

    public void setOnActionUpListener(ClockHandView.OnActionUpListener onActionUpListener) {
        this.clockHandView.setOnActionUpListener(onActionUpListener);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnDoubleTapListener(OnDoubleTapListener onDoubleTapListener) {
        this.onDoubleTapListener = onDoubleTapListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnPeriodChangeListener(OnPeriodChangeListener onPeriodChangeListener) {
        this.onPeriodChangeListener = onPeriodChangeListener;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setOnSelectionChangeListener(OnSelectionChange onSelectionChange) {
        this.onSelectionChangeListener = onSelectionChange;
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void setValues(String[] strArr, int i) {
        this.clockFace.setValues(strArr, i);
    }

    public void showToggle() {
        this.toggle.setVisibility(0);
    }

    @Override // com.google.android.material.timepicker.TimePickerControls
    public void updateTime(int i, int i2, int i3) {
        this.toggle.check(i == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i3));
        String format2 = String.format(locale, TimeModel.ZERO_LEADING_NUMBER_FORMAT, Integer.valueOf(i2));
        if (!TextUtils.equals(this.minuteView.getText(), format)) {
            this.minuteView.setText(format);
        }
        if (TextUtils.equals(this.hourView.getText(), format2)) {
            return;
        }
        this.hourView.setText(format2);
    }
}
