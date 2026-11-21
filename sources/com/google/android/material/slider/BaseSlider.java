package com.google.android.material.slider;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewOverlay;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.SeekBar;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.focus.FocusRingDrawable;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.slider.BaseOnChangeListener;
import com.google.android.material.slider.BaseOnSliderTouchListener;
import com.google.android.material.slider.BaseSlider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import com.google.android.material.tooltip.TooltipDrawable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.math.BigDecimal;
import java.math.MathContext;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
abstract class BaseSlider<S extends BaseSlider<S, L, T>, L extends BaseOnChangeListener<S>, T extends BaseOnSliderTouchListener<S>> extends View {
    private static final int DEFAULT_LABEL_ANIMATION_ENTER_DURATION = 83;
    private static final int DEFAULT_LABEL_ANIMATION_EXIT_DURATION = 117;
    private static final String EXCEPTION_ILLEGAL_CONTINUOUS_MODE_TICK_COUNT = "The continuousModeTickCount(%s) must be greater than or equal to 0";
    private static final String EXCEPTION_ILLEGAL_DISCRETE_VALUE = "Value(%s) must be equal to valueFrom(%s) plus a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION = "minSeparation(%s) must be greater or equal to 0";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE = "minSeparation(%s) must be greater or equal and a multiple of stepSize(%s) when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT = "minSeparation(%s) cannot be set as a dimension when using stepSize(%s)";
    private static final String EXCEPTION_ILLEGAL_STEP_SIZE = "The stepSize(%s) must be 0, or a factor of the valueFrom(%s)-valueTo(%s) range";
    private static final String EXCEPTION_ILLEGAL_VALUE = "Slider value(%s) must be greater or equal to valueFrom(%s), and lower or equal to valueTo(%s)";
    private static final String EXCEPTION_ILLEGAL_VALUE_FROM = "valueFrom(%s) must be smaller than valueTo(%s)";
    private static final int HALO_ALPHA = 63;
    private static final float LEFT_LABEL_PIVOT_X = 1.2f;
    private static final float LEFT_LABEL_PIVOT_Y = 0.5f;
    private static final int MAX_TIMEOUT_TOOLTIP_WITH_ACCESSIBILITY = 120000;
    private static final int MIN_TIMEOUT_TOOLTIP_WITH_ACCESSIBILITY = 10000;
    private static final float RIGHT_LABEL_PIVOT_X = -0.2f;
    private static final float RIGHT_LABEL_PIVOT_Y = 0.5f;
    private static final double THRESHOLD = 1.0E-4d;
    private static final float THUMB_WIDTH_PRESSED_RATIO = 0.5f;
    private static final int TIMEOUT_SEND_ACCESSIBILITY_EVENT = 200;
    private static final float TOP_LABEL_PIVOT_X = 0.5f;
    private static final float TOP_LABEL_PIVOT_Y = 1.2f;
    private static final float TOUCH_SLOP_RATIO = 0.8f;
    private static final int TRACK_CORNER_SIZE_UNSET = -1;
    static final int UNIT_PX = 0;
    static final int UNIT_VALUE = 1;
    private static final String WARNING_FLOATING_POINT_ERROR = "Floating point value used for %s(%s). Using floats can have rounding errors which may result in incorrect values. Instead, consider using integers with a custom LabelFormatter to display the value correctly.";
    private static final String WARNING_PARSE_ERROR = "Error parsing value(%s), valueFrom(%s), and valueTo(%s) into a float.";
    private BaseSlider<S, L, T>.AccessibilityEventSender accessibilityEventSender;
    private final AccessibilityHelper accessibilityHelper;
    private final AccessibilityManager accessibilityManager;
    private int accessibilityMinTouchTargetSize;
    private int activeThumbIdx;
    private final Paint activeTicksPaint;
    private final Paint activeTrackPaint;
    private final RectF activeTrackRect;
    private boolean centered;
    private final List<L> changeListeners;
    private int continuousModeTickCount;
    private final RectF cornerRect;
    private Drawable customThumbDrawable;
    private List<Drawable> customThumbDrawablesForValues;
    private final List<MaterialShapeDrawable> defaultThumbDrawables;
    private int defaultThumbHeight;
    private int defaultThumbRadius;
    private int defaultThumbTrackGapSize;
    private int defaultThumbWidth;
    private int defaultTickActiveRadius;
    private int defaultTickInactiveRadius;
    private int defaultTrackThickness;
    private boolean dirtyConfig;
    List<Rect> exclusionRects;
    private int focusedThumbIdx;
    private boolean forceDrawCompatHalo;
    private LabelFormatter formatter;
    private ColorStateList haloColor;
    private final Paint haloPaint;
    private int haloRadius;
    private final Rect iconRect;
    private final RectF iconRectF;
    private final Paint inactiveTicksPaint;
    private final RectF inactiveTrackLeftRect;
    private final Paint inactiveTrackPaint;
    private final RectF inactiveTrackRightRect;
    private boolean isLongPress;
    private int labelBehavior;
    private int labelPadding;
    private final Rect labelRect;
    private int labelStyle;
    private final List<TooltipDrawable> labels;
    private boolean labelsAreAnimatedIn;
    private ValueAnimator labelsInAnimator;
    private ValueAnimator labelsOutAnimator;
    private MotionEvent lastEvent;
    private int minTickSpacing;
    private int minTouchTargetSize;
    private int minTrackSidePadding;
    private int minWidgetThickness;
    private final ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener;
    private final ViewTreeObserver.OnScrollChangedListener onScrollChangedListener;
    private List<Float> previousDownTouchEventValues;
    private final Runnable resetActiveThumbIndex;
    private final Matrix rotationMatrix;
    private final int scaledTouchSlop;
    private int separationUnit;
    private float stepSize;
    private final Paint stopIndicatorPaint;
    private boolean thisAndAncestorsVisible;
    private float thumbElevation;
    private int thumbHeight;
    private final int thumbHeightDecreaseFocusRing;
    private boolean thumbIsPressed;
    private final Paint thumbPaint;
    private ColorStateList thumbStrokeColor;
    private float thumbStrokeWidth;
    private ColorStateList thumbTintList;
    private int thumbTrackGapSize;
    private int thumbWidth;
    private int tickActiveRadius;
    private ColorStateList tickColorActive;
    private ColorStateList tickColorInactive;
    private int tickInactiveRadius;
    private int tickVisibilityMode;
    private float[] ticksCoordinates;
    private final int tooltipTimeoutMillis;
    private float touchDownAxis1;
    private float touchDownAxis2;
    private final List<T> touchListeners;
    private float touchPosition;
    private ColorStateList trackColorActive;
    private ColorStateList trackColorInactive;
    private int trackCornerSize;
    private ColorStateList trackIconActiveColor;
    private Drawable trackIconActiveEnd;
    private boolean trackIconActiveEndMutated;
    private Drawable trackIconActiveStart;
    private boolean trackIconActiveStartMutated;
    private ColorStateList trackIconInactiveColor;
    private Drawable trackIconInactiveEnd;
    private boolean trackIconInactiveEndMutated;
    private Drawable trackIconInactiveStart;
    private boolean trackIconInactiveStartMutated;
    private int trackIconPadding;
    private int trackIconSize;
    private int trackInsideCornerSize;
    private final Path trackPath;
    private int trackSidePadding;
    private int trackStopIndicatorSize;
    private int trackThickness;
    private int trackWidth;
    private float valueFrom;
    private float valueTo;
    private ArrayList<Float> values;
    private final Rect viewRect;
    private int widgetOrientation;
    private int widgetThickness;
    private static final String TAG = BaseSlider.class.getSimpleName();
    static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_Slider;
    private static final int LABEL_ANIMATION_ENTER_DURATION_ATTR = R.attr.motionDurationMedium4;
    private static final int LABEL_ANIMATION_EXIT_DURATION_ATTR = R.attr.motionDurationShort3;
    private static final int LABEL_ANIMATION_ENTER_EASING_ATTR = R.attr.motionEasingEmphasizedInterpolator;
    private static final int LABEL_ANIMATION_EXIT_EASING_ATTR = R.attr.motionEasingEmphasizedAccelerateInterpolator;

    /* renamed from: com.google.android.material.slider.BaseSlider$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends AnimatorListenerAdapter {
        AnonymousClass1() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            ViewOverlay access$000 = BaseSlider.access$000(BaseSlider.this);
            if (access$000 == null) {
                return;
            }
            Iterator it = BaseSlider.access$100(BaseSlider.this).iterator();
            while (it.hasNext()) {
                access$000.remove((TooltipDrawable) it.next());
            }
        }
    }

    /* loaded from: classes.dex */
    private class AccessibilityEventSender implements Runnable {
        int virtualViewId;

        private AccessibilityEventSender() {
            this.virtualViewId = -1;
        }

        /* synthetic */ AccessibilityEventSender(BaseSlider baseSlider, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // java.lang.Runnable
        public void run() {
            BaseSlider.access$300(BaseSlider.this).sendEventForVirtualView(this.virtualViewId, 4);
        }

        void setVirtualViewId(int i) {
            this.virtualViewId = i;
        }
    }

    /* loaded from: classes.dex */
    public static class AccessibilityHelper extends ExploreByTouchHelper {
        private final BaseSlider<?, ?, ?> slider;
        final Rect virtualViewBounds;

        AccessibilityHelper(BaseSlider<?, ?, ?> baseSlider) {
            super(baseSlider);
            this.virtualViewBounds = new Rect();
            this.slider = baseSlider;
        }

        private String startOrEndDescription(int i) {
            return i == this.slider.getValues().size() + (-1) ? this.slider.getContext().getString(R.string.material_slider_range_end) : i == 0 ? this.slider.getContext().getString(R.string.material_slider_range_start) : "";
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected int getVirtualViewAt(float f, float f2) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                this.slider.updateBoundsForVirtualViewId(i, this.virtualViewBounds);
                if (this.virtualViewBounds.contains((int) f, (int) f2)) {
                    return i;
                }
            }
            return -1;
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void getVisibleVirtualViews(List<Integer> list) {
            for (int i = 0; i < this.slider.getValues().size(); i++) {
                list.add(Integer.valueOf(i));
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected boolean onPerformActionForVirtualView(int i, int i2, Bundle bundle) {
            if (!this.slider.isEnabled()) {
                return false;
            }
            switch (i2) {
                case 4096:
                case 8192:
                    float access$900 = BaseSlider.access$900(this.slider, 20);
                    if (i2 == 8192) {
                        access$900 = -access$900;
                    }
                    if (this.slider.isRtl()) {
                        access$900 = -access$900;
                    }
                    if (!BaseSlider.access$700(this.slider, i, MathUtils.clamp(this.slider.getValues().get(i).floatValue() + access$900, this.slider.getValueFrom(), this.slider.getValueTo()))) {
                        return false;
                    }
                    this.slider.setActiveThumbIndex(i);
                    this.slider.scheduleTooltipTimeout();
                    BaseSlider.access$800(this.slider);
                    this.slider.postInvalidate();
                    return true;
                case android.R.id.accessibilityActionSetProgress:
                    if (bundle == null || !bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE)) {
                        return false;
                    }
                    if (!BaseSlider.access$700(this.slider, i, bundle.getFloat(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_PROGRESS_VALUE))) {
                        return false;
                    }
                    BaseSlider.access$800(this.slider);
                    this.slider.postInvalidate();
                    return true;
                default:
                    return false;
            }
        }

        @Override // androidx.customview.widget.ExploreByTouchHelper
        protected void onPopulateNodeForVirtualView(int i, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            accessibilityNodeInfoCompat.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SET_PROGRESS);
            List<Float> values = this.slider.getValues();
            float floatValue = values.get(i).floatValue();
            float valueFrom = this.slider.getValueFrom();
            float valueTo = this.slider.getValueTo();
            if (this.slider.isEnabled()) {
                if (floatValue > valueFrom) {
                    accessibilityNodeInfoCompat.addAction(8192);
                }
                if (floatValue < valueTo) {
                    accessibilityNodeInfoCompat.addAction(4096);
                }
            }
            NumberFormat numberInstance = NumberFormat.getNumberInstance();
            numberInstance.setMaximumFractionDigits(2);
            try {
                valueFrom = numberInstance.parse(numberInstance.format(valueFrom)).floatValue();
                valueTo = numberInstance.parse(numberInstance.format(valueTo)).floatValue();
                floatValue = numberInstance.parse(numberInstance.format(floatValue)).floatValue();
            } catch (ParseException e) {
                Log.w(BaseSlider.access$500(), String.format(BaseSlider.WARNING_PARSE_ERROR, Float.valueOf(floatValue), Float.valueOf(valueFrom), Float.valueOf(valueTo)));
            }
            accessibilityNodeInfoCompat.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, valueFrom, valueTo, floatValue));
            accessibilityNodeInfoCompat.setClassName(SeekBar.class.getName());
            StringBuilder sb = new StringBuilder();
            if (this.slider.getContentDescription() != null) {
                sb.append(this.slider.getContentDescription()).append(",");
            }
            String access$600 = BaseSlider.access$600(this.slider, floatValue);
            String string = this.slider.getContext().getString(R.string.material_slider_value);
            if (values.size() > 1) {
                string = startOrEndDescription(i);
            }
            CharSequence stateDescription = ViewCompat.getStateDescription(this.slider);
            if (TextUtils.isEmpty(stateDescription)) {
                sb.append(String.format(Locale.getDefault(), "%s, %s", string, access$600));
            } else {
                accessibilityNodeInfoCompat.setStateDescription(stateDescription);
            }
            accessibilityNodeInfoCompat.setContentDescription(sb.toString());
            this.slider.updateBoundsForVirtualViewId(i, this.virtualViewBounds);
            accessibilityNodeInfoCompat.setBoundsInParent(this.virtualViewBounds);
        }
    }

    /* loaded from: classes.dex */
    private enum FullCornerDirection {
        BOTH,
        LEFT,
        RIGHT,
        NONE
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface Orientation {
    }

    /* loaded from: classes.dex */
    static class SliderState extends View.BaseSavedState {
        public static final Parcelable.Creator<SliderState> CREATOR = new AnonymousClass1();
        boolean hasFocus;
        float stepSize;
        float valueFrom;
        float valueTo;
        ArrayList<Float> values;

        /* renamed from: com.google.android.material.slider.BaseSlider$SliderState$1, reason: invalid class name */
        /* loaded from: classes.dex */
        class AnonymousClass1 implements Parcelable.Creator<SliderState> {
            AnonymousClass1() {
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SliderState createFromParcel(Parcel parcel) {
                return new SliderState(parcel, null);
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SliderState createFromParcel(Parcel parcel) {
                return createFromParcel(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public SliderState[] newArray(int i) {
                return new SliderState[i];
            }

            @Override // android.os.Parcelable.Creator
            public /* bridge */ /* synthetic */ SliderState[] newArray(int i) {
                return newArray(i);
            }
        }

        private SliderState(Parcel parcel) {
            super(parcel);
            this.valueFrom = parcel.readFloat();
            this.valueTo = parcel.readFloat();
            this.values = new ArrayList<>();
            parcel.readList(this.values, Float.class.getClassLoader());
            this.stepSize = parcel.readFloat();
            this.hasFocus = parcel.createBooleanArray()[0];
        }

        /* synthetic */ SliderState(Parcel parcel, AnonymousClass1 anonymousClass1) {
            this(parcel);
        }

        SliderState(Parcelable parcelable) {
            super(parcelable);
        }

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeFloat(this.valueFrom);
            parcel.writeFloat(this.valueTo);
            parcel.writeList(this.values);
            parcel.writeFloat(this.stepSize);
            parcel.writeBooleanArray(new boolean[]{this.hasFocus});
        }
    }

    public static /* synthetic */ void $r8$lambda$WXiNVeXFM7RTh57Z9Tr5jBbN9l4(BaseSlider baseSlider) {
        baseSlider.updateLabels();
    }

    /* renamed from: $r8$lambda$wmOcrqvwfn0H-XDxTA4SeazLUmI, reason: not valid java name */
    public static /* synthetic */ void m421$r8$lambda$wmOcrqvwfn0HXDxTA4SeazLUmI(BaseSlider baseSlider) {
        baseSlider.updateLabels();
    }

    public BaseSlider(Context context) {
        this(context, null);
    }

    public BaseSlider(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sliderStyle);
    }

    public BaseSlider(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.labels = new ArrayList();
        this.changeListeners = new ArrayList();
        this.touchListeners = new ArrayList();
        this.labelsAreAnimatedIn = false;
        this.defaultThumbWidth = -1;
        this.defaultThumbTrackGapSize = -1;
        this.defaultThumbHeight = -1;
        this.centered = false;
        this.trackIconActiveStartMutated = false;
        this.trackIconActiveEndMutated = false;
        this.trackIconInactiveStartMutated = false;
        this.trackIconInactiveEndMutated = false;
        this.viewRect = new Rect();
        this.exclusionRects = new ArrayList();
        this.previousDownTouchEventValues = new ArrayList();
        this.thumbIsPressed = false;
        this.values = new ArrayList<>();
        this.activeThumbIdx = -1;
        this.focusedThumbIdx = -1;
        this.stepSize = 0.0f;
        this.continuousModeTickCount = 0;
        this.isLongPress = false;
        this.trackPath = new Path();
        this.activeTrackRect = new RectF();
        this.inactiveTrackLeftRect = new RectF();
        this.inactiveTrackRightRect = new RectF();
        this.cornerRect = new RectF();
        this.labelRect = new Rect();
        this.iconRectF = new RectF();
        this.iconRect = new Rect();
        this.rotationMatrix = new Matrix();
        this.defaultThumbDrawables = new ArrayList();
        this.customThumbDrawablesForValues = Collections.emptyList();
        this.separationUnit = 0;
        this.onScrollChangedListener = new BaseSlider$$ExternalSyntheticLambda1(this);
        this.onGlobalLayoutListener = new BaseSlider$$ExternalSyntheticLambda2(this);
        this.resetActiveThumbIndex = new BaseSlider$$ExternalSyntheticLambda3(this);
        Context context2 = getContext();
        this.thisAndAncestorsVisible = isShown();
        this.inactiveTrackPaint = new Paint();
        this.activeTrackPaint = new Paint();
        this.thumbPaint = new Paint(1);
        this.thumbPaint.setStyle(Paint.Style.FILL);
        this.thumbPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        this.haloPaint = new Paint(1);
        this.haloPaint.setStyle(Paint.Style.FILL);
        this.inactiveTicksPaint = new Paint();
        this.inactiveTicksPaint.setStyle(Paint.Style.STROKE);
        this.inactiveTicksPaint.setStrokeCap(Paint.Cap.ROUND);
        this.activeTicksPaint = new Paint();
        this.activeTicksPaint.setStyle(Paint.Style.STROKE);
        this.activeTicksPaint.setStrokeCap(Paint.Cap.ROUND);
        this.stopIndicatorPaint = new Paint();
        this.stopIndicatorPaint.setStyle(Paint.Style.FILL);
        this.stopIndicatorPaint.setStrokeCap(Paint.Cap.ROUND);
        this.thumbHeightDecreaseFocusRing = context2.getResources().getDimensionPixelSize(R.dimen.m3_slider_focus_ring_thumb_height_decrease);
        loadResources(context2.getResources());
        processAttributes(context2, attributeSet, i);
        setFocusable(true);
        setClickable(true);
        this.scaledTouchSlop = ViewConfiguration.get(context2).getScaledTouchSlop();
        this.accessibilityHelper = new AccessibilityHelper(this);
        ViewCompat.setAccessibilityDelegate(this, this.accessibilityHelper);
        this.accessibilityManager = (AccessibilityManager) getContext().getSystemService("accessibility");
        if (Build.VERSION.SDK_INT >= 29) {
            this.tooltipTimeoutMillis = this.accessibilityManager.getRecommendedTimeoutMillis(MIN_TIMEOUT_TOOLTIP_WITH_ACCESSIBILITY, 6);
        } else {
            this.tooltipTimeoutMillis = MAX_TIMEOUT_TOOLTIP_WITH_ACCESSIBILITY;
        }
    }

    static /* synthetic */ ViewOverlay access$000(BaseSlider baseSlider) {
        return baseSlider.getContentViewOverlay();
    }

    static /* synthetic */ List access$100(BaseSlider baseSlider) {
        return baseSlider.labels;
    }

    static /* synthetic */ AccessibilityHelper access$300(BaseSlider baseSlider) {
        return baseSlider.accessibilityHelper;
    }

    static /* synthetic */ String access$500() {
        return TAG;
    }

    static /* synthetic */ String access$600(BaseSlider baseSlider, float f) {
        return baseSlider.formatValue(f);
    }

    static /* synthetic */ boolean access$700(BaseSlider baseSlider, int i, float f) {
        return baseSlider.snapThumbToValue(i, f);
    }

    static /* synthetic */ void access$800(BaseSlider baseSlider) {
        baseSlider.updateHaloHotspot();
    }

    static /* synthetic */ float access$900(BaseSlider baseSlider, int i) {
        return baseSlider.calculateStepIncrement(i);
    }

    private void adjustCustomThumbDrawableBounds(int i, Drawable drawable) {
        int intrinsicWidth = drawable.getIntrinsicWidth();
        int intrinsicHeight = drawable.getIntrinsicHeight();
        if (intrinsicWidth == -1 && intrinsicHeight == -1) {
            drawable.setBounds(0, 0, i, this.thumbHeight);
        } else {
            float max = Math.max(i, this.thumbHeight) / Math.max(intrinsicWidth, intrinsicHeight);
            drawable.setBounds(0, 0, (int) (intrinsicWidth * max), (int) (intrinsicHeight * max));
        }
    }

    private void adjustCustomThumbDrawableBounds(Drawable drawable) {
        adjustCustomThumbDrawableBounds(this.thumbWidth, drawable);
    }

    private void attachLabelToContentView(TooltipDrawable tooltipDrawable) {
        tooltipDrawable.setRelativeToView(ViewUtils.getContentView(this));
    }

    private void calculateBoundsAndDrawTrackIcon(Canvas canvas, RectF rectF, Drawable drawable, boolean z) {
        if (drawable != null) {
            calculateTrackIconBounds(rectF, this.iconRectF, this.trackIconSize, this.trackIconPadding, z);
            if (this.iconRectF.isEmpty()) {
                return;
            }
            drawTrackIcon(canvas, this.iconRectF, drawable);
        }
    }

    private float calculateEndTrackCornerSize(float f) {
        if (this.values.isEmpty() || !hasGapBetweenThumbAndTrack()) {
            return f;
        }
        float valueToX = valueToX(this.values.get((isRtl() || isVertical()) ? 0 : this.values.size() - 1).floatValue()) - this.trackSidePadding;
        return valueToX > ((float) this.trackWidth) - f ? Math.max(this.trackWidth - valueToX, this.trackInsideCornerSize) : f;
    }

    private Float calculateIncrementForKey(int i) {
        float calculateStepIncrement = this.isLongPress ? calculateStepIncrement(20) : calculateStepIncrement();
        switch (i) {
            case 21:
                return Float.valueOf(isRtl() ? calculateStepIncrement : -calculateStepIncrement);
            case 22:
                return Float.valueOf(isRtl() ? -calculateStepIncrement : calculateStepIncrement);
            case 69:
                return Float.valueOf(-calculateStepIncrement);
            case 70:
            case 81:
                return Float.valueOf(calculateStepIncrement);
            default:
                return null;
        }
    }

    private void calculateLabelBounds(TooltipDrawable tooltipDrawable, float f) {
        int normalizeValue;
        int intrinsicWidth;
        int calculateTrackCenter;
        int intrinsicHeight;
        if (isVertical()) {
            normalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicHeight() / 2);
            intrinsicWidth = tooltipDrawable.getIntrinsicHeight() + normalizeValue;
            if (isRtl()) {
                calculateTrackCenter = calculateTrackCenter() - (this.labelPadding + (this.thumbHeight / 2));
                intrinsicHeight = calculateTrackCenter - tooltipDrawable.getIntrinsicWidth();
            } else {
                intrinsicHeight = this.labelPadding + (this.thumbHeight / 2) + calculateTrackCenter();
                calculateTrackCenter = tooltipDrawable.getIntrinsicWidth() + intrinsicHeight;
            }
        } else {
            normalizeValue = (this.trackSidePadding + ((int) (normalizeValue(f) * this.trackWidth))) - (tooltipDrawable.getIntrinsicWidth() / 2);
            intrinsicWidth = tooltipDrawable.getIntrinsicWidth() + normalizeValue;
            calculateTrackCenter = calculateTrackCenter() - (this.labelPadding + (this.thumbHeight / 2));
            intrinsicHeight = calculateTrackCenter - tooltipDrawable.getIntrinsicHeight();
        }
        this.labelRect.set(normalizeValue, intrinsicHeight, intrinsicWidth, calculateTrackCenter);
    }

    private float calculateStartTrackCornerSize(float f) {
        if (this.values.isEmpty() || !hasGapBetweenThumbAndTrack()) {
            return f;
        }
        float valueToX = valueToX(this.values.get((isRtl() || isVertical()) ? this.values.size() - 1 : 0).floatValue()) - this.trackSidePadding;
        return valueToX < f ? Math.max(valueToX, this.trackInsideCornerSize) : f;
    }

    private float calculateStepIncrement() {
        if (this.stepSize == 0.0f) {
            return 1.0f;
        }
        return this.stepSize;
    }

    private float calculateStepIncrement(int i) {
        float calculateStepIncrement = calculateStepIncrement();
        return (this.valueTo - this.valueFrom) / calculateStepIncrement <= ((float) i) ? calculateStepIncrement : Math.round(r1 / i) * calculateStepIncrement;
    }

    private int calculateThumbTrackGapSize(int i) {
        if (!this.thumbIsPressed || i != this.activeThumbIdx || this.customThumbDrawable != null || !this.customThumbDrawablesForValues.isEmpty()) {
            return this.thumbTrackGapSize;
        }
        return this.thumbTrackGapSize - ((this.thumbWidth - Math.round(this.thumbWidth * 0.5f)) / 2);
    }

    private int calculateTrackCenter() {
        int i = this.widgetThickness / 2;
        int i2 = 0;
        if ((this.labelBehavior == 1 || shouldAlwaysShowLabel()) && !this.labels.isEmpty()) {
            i2 = this.labels.get(0).getIntrinsicHeight();
        }
        return i + i2;
    }

    private void calculateTrackIconBounds(RectF rectF, RectF rectF2, int i, int i2, boolean z) {
        if (rectF.right - rectF.left < (i2 * 2) + i) {
            rectF2.setEmpty();
            return;
        }
        float f = (isRtl() || isVertical()) ^ z ? rectF.left + i2 : (rectF.right - i2) - i;
        float calculateTrackCenter = calculateTrackCenter() - (i / 2.0f);
        rectF2.set(f, calculateTrackCenter, i + f, i + calculateTrackCenter);
    }

    private int convertToTickVisibilityMode(boolean z) {
        return z ? 0 : 2;
    }

    private ValueAnimator createLabelAnimator(boolean z) {
        int resolveThemeDuration;
        TimeInterpolator resolveThemeInterpolator;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(getAnimatorCurrentValueOrDefault(z ? this.labelsOutAnimator : this.labelsInAnimator, z ? 0.0f : 1.0f), z ? 1.0f : 0.0f);
        if (z) {
            resolveThemeDuration = MotionUtils.resolveThemeDuration(getContext(), LABEL_ANIMATION_ENTER_DURATION_ATTR, DEFAULT_LABEL_ANIMATION_ENTER_DURATION);
            resolveThemeInterpolator = MotionUtils.resolveThemeInterpolator(getContext(), LABEL_ANIMATION_ENTER_EASING_ATTR, AnimationUtils.DECELERATE_INTERPOLATOR);
        } else {
            resolveThemeDuration = MotionUtils.resolveThemeDuration(getContext(), LABEL_ANIMATION_EXIT_DURATION_ATTR, DEFAULT_LABEL_ANIMATION_EXIT_DURATION);
            resolveThemeInterpolator = MotionUtils.resolveThemeInterpolator(getContext(), LABEL_ANIMATION_EXIT_EASING_ATTR, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        }
        ofFloat.setDuration(resolveThemeDuration);
        ofFloat.setInterpolator(resolveThemeInterpolator);
        ofFloat.addUpdateListener(new BaseSlider$$ExternalSyntheticLambda0(this));
        return ofFloat;
    }

    private void createLabelPool() {
        if (this.labels.size() > this.values.size()) {
            List<TooltipDrawable> subList = this.labels.subList(this.values.size(), this.labels.size());
            for (TooltipDrawable tooltipDrawable : subList) {
                if (isAttachedToWindow()) {
                    detachLabelFromContentView(tooltipDrawable);
                }
            }
            subList.clear();
        }
        while (true) {
            if (this.labels.size() >= this.values.size()) {
                break;
            }
            TooltipDrawable createFromAttributes = TooltipDrawable.createFromAttributes(getContext(), null, 0, this.labelStyle);
            this.labels.add(createFromAttributes);
            if (isAttachedToWindow()) {
                attachLabelToContentView(createFromAttributes);
            }
        }
        int i = this.labels.size() != 1 ? 1 : 0;
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setStrokeWidth(i);
        }
    }

    private MaterialShapeDrawable createNewDefaultThumb() {
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.setShadowCompatibilityMode(2);
        materialShapeDrawable.setFillColor(getThumbTintList());
        materialShapeDrawable.setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, this.thumbWidth / 2.0f).build());
        materialShapeDrawable.setBounds(0, 0, this.thumbWidth, this.thumbHeight);
        materialShapeDrawable.setElevation(getThumbElevation());
        materialShapeDrawable.setStrokeWidth(getThumbStrokeWidth());
        materialShapeDrawable.setStrokeTint(getThumbStrokeColor());
        materialShapeDrawable.setState(getDrawableState());
        return materialShapeDrawable;
    }

    private void detachLabelFromContentView(TooltipDrawable tooltipDrawable) {
        ViewGroup contentView = ViewUtils.getContentView(this);
        if (contentView == null) {
            return;
        }
        contentView.getOverlay().remove(tooltipDrawable);
        tooltipDrawable.detachView(contentView);
    }

    private float dimenToValue(float f) {
        if (f == 0.0f) {
            return 0.0f;
        }
        return (((f - this.trackSidePadding) / this.trackWidth) * (this.valueFrom - this.valueTo)) + this.valueFrom;
    }

    private void dispatchOnChangedFromUser(int i) {
        Iterator<L> it = this.changeListeners.iterator();
        while (it.hasNext()) {
            it.next().onValueChange(this, this.values.get(i).floatValue(), true);
        }
        if (this.accessibilityManager == null || !this.accessibilityManager.isEnabled()) {
            return;
        }
        scheduleAccessibilityEventSender(i);
        this.accessibilityHelper.invalidateVirtualView(i);
    }

    private void dispatchOnChangedProgrammatically() {
        for (L l : this.changeListeners) {
            Iterator<Float> it = this.values.iterator();
            while (it.hasNext()) {
                l.onValueChange(this, it.next().floatValue(), false);
            }
        }
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:29:0x0099. Please report as an issue. */
    private void drawActiveTracks(Canvas canvas, int i, int i2) {
        FullCornerDirection fullCornerDirection;
        float f;
        float f2;
        BaseSlider<S, L, T> baseSlider = this;
        float[] activeRange = baseSlider.getActiveRange();
        float f3 = baseSlider.trackSidePadding + (activeRange[1] * i);
        float f4 = baseSlider.trackSidePadding + (activeRange[0] * i);
        if (f4 >= f3) {
            baseSlider.activeTrackRect.setEmpty();
            return;
        }
        FullCornerDirection fullCornerDirection2 = FullCornerDirection.NONE;
        if (baseSlider.values.size() != 1 || baseSlider.isCentered()) {
            fullCornerDirection = fullCornerDirection2;
        } else {
            fullCornerDirection = (baseSlider.isRtl() || baseSlider.isVertical()) ? FullCornerDirection.RIGHT : FullCornerDirection.LEFT;
        }
        int i3 = 0;
        while (i3 < baseSlider.values.size()) {
            if (baseSlider.values.size() > 1) {
                if (i3 > 0) {
                    f4 = baseSlider.valueToX(baseSlider.values.get(i3 - 1).floatValue());
                }
                f3 = baseSlider.valueToX(baseSlider.values.get(i3).floatValue());
                if (baseSlider.isRtl() || baseSlider.isVertical()) {
                    float f5 = f4;
                    f4 = f3;
                    f3 = f5;
                }
            }
            int trackCornerSize = baseSlider.getTrackCornerSize();
            switch (fullCornerDirection.ordinal()) {
                case 1:
                    f = f3 - baseSlider.calculateThumbTrackGapSize(i3);
                    f2 = f4 - trackCornerSize;
                    break;
                case 2:
                    f = f3 + trackCornerSize;
                    f2 = f4 + baseSlider.calculateThumbTrackGapSize(i3);
                    break;
                case 3:
                    if (i3 <= 0) {
                        if (activeRange[1] != 0.5f) {
                            if (activeRange[0] == 0.5f) {
                                f = f3 - baseSlider.calculateThumbTrackGapSize(i3);
                                f2 = f4;
                                break;
                            }
                        } else {
                            f = f3;
                            f2 = f4 + baseSlider.calculateThumbTrackGapSize(i3);
                            break;
                        }
                    } else {
                        f = f3 - baseSlider.calculateThumbTrackGapSize(i3);
                        f2 = f4 + baseSlider.calculateThumbTrackGapSize(i3 - 1);
                        break;
                    }
                default:
                    f = f3;
                    f2 = f4;
                    break;
            }
            if (f2 >= f) {
                baseSlider.activeTrackRect.setEmpty();
            } else {
                baseSlider.activeTrackRect.set(f2, i2 - (baseSlider.trackThickness / 2.0f), f, i2 + (baseSlider.trackThickness / 2.0f));
                baseSlider.updateTrack(canvas, baseSlider.activeTrackPaint, baseSlider.activeTrackRect, trackCornerSize, fullCornerDirection);
            }
            i3++;
            baseSlider = this;
            f3 = f;
            f4 = f2;
        }
    }

    private void drawInactiveTrackSection(float f, float f2, float f3, float f4, Canvas canvas, RectF rectF, FullCornerDirection fullCornerDirection, int i) {
        if (f2 - f > getTrackCornerSize() - i) {
            rectF.set(f, f3, f2, f4);
        } else {
            rectF.setEmpty();
        }
        updateTrack(canvas, this.inactiveTrackPaint, rectF, getTrackCornerSize(), fullCornerDirection);
    }

    private void drawInactiveTracks(Canvas canvas, int i, int i2) {
        int calculateThumbTrackGapSize;
        int calculateThumbTrackGapSize2;
        float[] activeRange = getActiveRange();
        float f = i2 - (this.trackThickness / 2.0f);
        float f2 = (this.trackThickness / 2.0f) + i2;
        int i3 = 0;
        if (isCentered() && activeRange[0] == 0.5f) {
            calculateThumbTrackGapSize = this.thumbTrackGapSize;
        } else {
            calculateThumbTrackGapSize = calculateThumbTrackGapSize((isRtl() || isVertical()) ? this.values.size() - 1 : 0);
        }
        drawInactiveTrackSection(this.trackSidePadding - getTrackCornerSize(), (this.trackSidePadding + (activeRange[0] * i)) - calculateThumbTrackGapSize, f, f2, canvas, this.inactiveTrackLeftRect, FullCornerDirection.LEFT, calculateThumbTrackGapSize);
        if (isCentered() && activeRange[1] == 0.5f) {
            calculateThumbTrackGapSize2 = this.thumbTrackGapSize;
        } else {
            if (!isRtl() && !isVertical()) {
                i3 = this.values.size() - 1;
            }
            calculateThumbTrackGapSize2 = calculateThumbTrackGapSize(i3);
        }
        drawInactiveTrackSection(this.trackSidePadding + (activeRange[1] * i) + calculateThumbTrackGapSize2, this.trackSidePadding + i + getTrackCornerSize(), f, f2, canvas, this.inactiveTrackRightRect, FullCornerDirection.RIGHT, calculateThumbTrackGapSize2);
    }

    private void drawStopIndicator(Canvas canvas, float f, float f2) {
        for (int i = 0; i < this.values.size(); i++) {
            float valueToX = valueToX(this.values.get(i).floatValue());
            float calculateThumbTrackGapSize = calculateThumbTrackGapSize(i) + (this.thumbWidth / 2.0f);
            if (f >= valueToX - calculateThumbTrackGapSize && f <= valueToX + calculateThumbTrackGapSize) {
                return;
            }
        }
        if (isVertical()) {
            canvas.drawPoint(f2, f, this.stopIndicatorPaint);
        } else {
            canvas.drawPoint(f, f2, this.stopIndicatorPaint);
        }
    }

    private void drawThumbDrawable(Canvas canvas, int i, int i2, float f, Drawable drawable) {
        canvas.save();
        if (isVertical()) {
            canvas.concat(this.rotationMatrix);
        }
        canvas.translate((this.trackSidePadding + ((int) (normalizeValue(f) * i))) - (drawable.getBounds().width() / 2.0f), i2 - (drawable.getBounds().height() / 2.0f));
        drawable.draw(canvas);
        canvas.restore();
    }

    private void drawThumbs(Canvas canvas, int i, int i2) {
        Canvas canvas2;
        int i3;
        int i4;
        int i5 = 0;
        while (i5 < this.values.size()) {
            float floatValue = this.values.get(i5).floatValue();
            if (this.customThumbDrawable != null) {
                canvas2 = canvas;
                i3 = i;
                i4 = i2;
                drawThumbDrawable(canvas2, i3, i4, floatValue, this.customThumbDrawable);
            } else {
                canvas2 = canvas;
                i3 = i;
                i4 = i2;
                if (i5 < this.customThumbDrawablesForValues.size()) {
                    drawThumbDrawable(canvas2, i3, i4, floatValue, this.customThumbDrawablesForValues.get(i5));
                } else {
                    if (!isEnabled()) {
                        canvas2.drawCircle(this.trackSidePadding + (normalizeValue(floatValue) * i3), i4, getThumbRadius(), this.thumbPaint);
                    }
                    drawThumbDrawable(canvas2, i3, i4, floatValue, this.defaultThumbDrawables.get(i5));
                }
            }
            i5++;
            canvas = canvas2;
            i = i3;
            i2 = i4;
        }
    }

    private void drawTicks(int i, int i2, Canvas canvas, Paint paint) {
        for (int i3 = i; i3 < i2; i3 += 2) {
            float f = isVertical() ? this.ticksCoordinates[i3 + 1] : this.ticksCoordinates[i3];
            if (!isOverlappingThumb(f) && (!isCentered() || !isOverlappingCenterGap(f))) {
                canvas.drawPoint(this.ticksCoordinates[i3], this.ticksCoordinates[i3 + 1], paint);
            }
        }
    }

    private void drawTrackIcon(Canvas canvas, RectF rectF, Drawable drawable) {
        if (isVertical()) {
            this.rotationMatrix.mapRect(rectF);
        }
        rectF.round(this.iconRect);
        drawable.setBounds(this.iconRect);
        drawable.draw(canvas);
    }

    private void drawTrackIcons(Canvas canvas, RectF rectF, RectF rectF2) {
        if (hasTrackIcons()) {
            if (this.values.size() > 1) {
                Log.w(TAG, "Track icons can only be used when only 1 thumb is present.");
            }
            calculateBoundsAndDrawTrackIcon(canvas, rectF, this.trackIconActiveStart, true);
            calculateBoundsAndDrawTrackIcon(canvas, rectF2, this.trackIconInactiveStart, true);
            calculateBoundsAndDrawTrackIcon(canvas, rectF, this.trackIconActiveEnd, false);
            calculateBoundsAndDrawTrackIcon(canvas, rectF2, this.trackIconInactiveEnd, false);
        }
    }

    private void ensureLabelsAdded(boolean z) {
        if (!this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = true;
            this.labelsInAnimator = createLabelAnimator(true);
            this.labelsOutAnimator = null;
            this.labelsInAnimator.start();
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        if (z) {
            for (int i = 0; i < this.values.size() && it.hasNext(); i++) {
                if (i != this.focusedThumbIdx) {
                    setValueForLabel(it.next(), this.values.get(i).floatValue());
                }
            }
        }
        if (!it.hasNext()) {
            throw new IllegalStateException(String.format("Not enough labels(%d) to display all the values(%d)", Integer.valueOf(this.labels.size()), Integer.valueOf(this.values.size())));
        }
        setValueForLabel(it.next(), this.values.get(this.focusedThumbIdx).floatValue());
    }

    private void ensureLabelsRemoved() {
        if (this.labelsAreAnimatedIn) {
            this.labelsAreAnimatedIn = false;
            this.labelsOutAnimator = createLabelAnimator(false);
            this.labelsInAnimator = null;
            this.labelsOutAnimator.addListener(new AnonymousClass1());
            this.labelsOutAnimator.start();
        }
    }

    private void focusThumbOnFocusGained(int i) {
        switch (i) {
            case 1:
                moveFocus(Integer.MAX_VALUE);
                return;
            case 2:
                moveFocus(Integer.MIN_VALUE);
                return;
            case 17:
                moveFocusInAbsoluteDirection(Integer.MAX_VALUE);
                return;
            case 66:
                moveFocusInAbsoluteDirection(Integer.MIN_VALUE);
                return;
            default:
                return;
        }
    }

    private String formatValue(float f) {
        if (hasLabelFormatter()) {
            return this.formatter.getFormattedValue(f);
        }
        return String.format(((float) ((int) f)) == f ? "%.0f" : "%.2f", Float.valueOf(f));
    }

    private float[] getActiveRange() {
        float floatValue = this.values.get(0).floatValue();
        float floatValue2 = this.values.get(this.values.size() - 1).floatValue();
        float normalizeValue = normalizeValue(this.values.size() == 1 ? this.valueFrom : floatValue);
        float normalizeValue2 = normalizeValue(floatValue2);
        if (isCentered()) {
            normalizeValue = Math.min(0.5f, normalizeValue2);
            normalizeValue2 = Math.max(0.5f, normalizeValue2);
        }
        return (isCentered() || !(isRtl() || isVertical())) ? new float[]{normalizeValue, normalizeValue2} : new float[]{normalizeValue2, normalizeValue};
    }

    private static float getAnimatorCurrentValueOrDefault(ValueAnimator valueAnimator, float f) {
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return f;
        }
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        valueAnimator.cancel();
        return floatValue;
    }

    private RippleDrawable getBackgroundRipple() {
        Drawable background = getBackground();
        if (background instanceof DrawableWrapper) {
            background = ((DrawableWrapper) background).getDrawable();
        }
        if (background instanceof RippleDrawable) {
            return (RippleDrawable) background;
        }
        return null;
    }

    private float getClampedValue(int i, float f) {
        float minSeparation = getMinSeparation();
        float dimenToValue = this.separationUnit == 0 ? dimenToValue(minSeparation) : minSeparation;
        if (isRtl() || isVertical()) {
            dimenToValue = -dimenToValue;
        }
        return MathUtils.clamp(f, i + (-1) < 0 ? this.valueFrom : this.values.get(i - 1).floatValue() + dimenToValue, i + 1 >= this.values.size() ? this.valueTo : this.values.get(i + 1).floatValue() - dimenToValue);
    }

    private int getColorForState(ColorStateList colorStateList) {
        return colorStateList.getColorForState(getDrawableState(), colorStateList.getDefaultColor());
    }

    private ViewOverlay getContentViewOverlay() {
        ViewGroup contentView = ViewUtils.getContentView(this);
        if (contentView == null) {
            return null;
        }
        return contentView.getOverlay();
    }

    private float[] getCornerRadii(float f, float f2) {
        return isVertical() ? new float[]{f, f, f, f, f2, f2, f2, f2} : new float[]{f, f, f2, f2, f2, f2, f, f};
    }

    private int getDesiredTickCount() {
        return (int) (((this.valueTo - this.valueFrom) / this.stepSize) + 1.0f);
    }

    private FocusRingDrawable getFocusRing() {
        return FocusRingDrawable.find(getBackground());
    }

    private int getMaxTickCount() {
        return (this.trackWidth / this.minTickSpacing) + 1;
    }

    private float getValueOfTouchPosition() {
        double snapPosition = snapPosition(this.touchPosition);
        if (isRtl() || isVertical()) {
            snapPosition = 1.0d - snapPosition;
        }
        return (float) (((this.valueTo - this.valueFrom) * snapPosition) + this.valueFrom);
    }

    private float getValueOfTouchPositionAbsolute() {
        float f = this.touchPosition;
        if (isRtl() || isVertical()) {
            f = 1.0f - f;
        }
        return ((this.valueTo - this.valueFrom) * f) + this.valueFrom;
    }

    private boolean hasGapBetweenThumbAndTrack() {
        return this.thumbTrackGapSize > 0;
    }

    private boolean hasTrackIcons() {
        return (this.trackIconActiveStart == null && this.trackIconActiveEnd == null && this.trackIconInactiveStart == null && this.trackIconInactiveEnd == null) ? false : true;
    }

    private Drawable initializeCustomThumbDrawable(Drawable drawable) {
        Drawable newDrawable = drawable.mutate().getConstantState().newDrawable();
        adjustCustomThumbDrawableBounds(newDrawable);
        return newDrawable;
    }

    private void invalidateTrack() {
        this.inactiveTrackPaint.setStrokeWidth(this.trackThickness);
        this.activeTrackPaint.setStrokeWidth(this.trackThickness);
    }

    private boolean isFocusRingEnabled() {
        FocusRingDrawable focusRing = getFocusRing();
        return focusRing != null && focusRing.isFocusRingEnabled();
    }

    private boolean isInHorizontalScrollingContainer() {
        ViewParent parent = getParent();
        while (true) {
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollHorizontally(1) || viewGroup.canScrollHorizontally(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private boolean isInVerticalScrollingContainer() {
        ViewParent parent = getParent();
        while (true) {
            if (!(parent instanceof ViewGroup)) {
                return false;
            }
            ViewGroup viewGroup = (ViewGroup) parent;
            if ((viewGroup.canScrollVertically(1) || viewGroup.canScrollVertically(-1)) && viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = parent.getParent();
        }
    }

    private static boolean isMouseEvent(MotionEvent motionEvent) {
        return motionEvent.getToolType(0) == 3;
    }

    private boolean isMultipleOfStepSize(double d) {
        double doubleValue = new BigDecimal(Double.toString(d)).divide(new BigDecimal(Float.toString(this.stepSize)), MathContext.DECIMAL64).doubleValue();
        return Math.abs(((double) Math.round(doubleValue)) - doubleValue) < THRESHOLD;
    }

    private boolean isOverlappingCenterGap(float f) {
        float f2 = (this.trackWidth + (this.trackSidePadding * 2)) / 2.0f;
        return f >= f2 - ((float) this.thumbTrackGapSize) && f <= ((float) this.thumbTrackGapSize) + f2;
    }

    private boolean isOverlappingThumb(float f) {
        for (int i = 0; i < this.values.size(); i++) {
            float valueToX = valueToX(this.values.get(i).floatValue());
            float calculateThumbTrackGapSize = calculateThumbTrackGapSize(i) + (this.thumbWidth / 2.0f);
            if (f >= valueToX - calculateThumbTrackGapSize && f <= valueToX + calculateThumbTrackGapSize) {
                return true;
            }
        }
        return false;
    }

    private boolean isPotentialHorizontalScroll(MotionEvent motionEvent) {
        return !isMouseEvent(motionEvent) && isInHorizontalScrollingContainer();
    }

    private boolean isPotentialVerticalScroll(MotionEvent motionEvent) {
        return !isMouseEvent(motionEvent) && isInVerticalScrollingContainer();
    }

    private boolean isSliderVisibleOnScreen() {
        Rect rect = new Rect();
        ViewUtils.getContentView(this).getHitRect(rect);
        return getLocalVisibleRect(rect) && isThisAndAncestorsVisible();
    }

    private boolean isThisAndAncestorsVisible() {
        int i = Build.VERSION.SDK_INT;
        return this.thisAndAncestorsVisible;
    }

    private void loadResources(Resources resources) {
        this.minWidgetThickness = resources.getDimensionPixelSize(R.dimen.mtrl_slider_widget_height);
        this.minTrackSidePadding = resources.getDimensionPixelOffset(R.dimen.mtrl_slider_track_side_padding);
        this.trackSidePadding = this.minTrackSidePadding;
        this.defaultThumbRadius = resources.getDimensionPixelSize(R.dimen.mtrl_slider_thumb_radius);
        this.defaultTrackThickness = resources.getDimensionPixelSize(R.dimen.mtrl_slider_track_height);
        this.defaultTickActiveRadius = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.defaultTickInactiveRadius = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_radius);
        this.minTickSpacing = resources.getDimensionPixelSize(R.dimen.mtrl_slider_tick_min_spacing);
        this.labelPadding = resources.getDimensionPixelSize(R.dimen.mtrl_slider_label_padding);
        this.trackIconPadding = resources.getDimensionPixelOffset(R.dimen.m3_slider_track_icon_padding);
        this.accessibilityMinTouchTargetSize = resources.getDimensionPixelSize(R.dimen.mtrl_min_touch_target_size);
    }

    private void maybeDrawCompatHalo(Canvas canvas, int i, int i2) {
        Canvas canvas2;
        if (shouldDrawCompatHalo()) {
            float[] fArr = {this.trackSidePadding + (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * i), i2};
            if (isVertical()) {
                this.rotationMatrix.mapPoints(fArr);
            }
            if (Build.VERSION.SDK_INT < 28) {
                canvas2 = canvas;
                canvas2.clipRect(fArr[0] - this.haloRadius, fArr[1] - this.haloRadius, fArr[0] + this.haloRadius, fArr[1] + this.haloRadius, Region.Op.UNION);
            } else {
                canvas2 = canvas;
            }
            canvas2.drawCircle(fArr[0], fArr[1], this.haloRadius, this.haloPaint);
        }
    }

    private void maybeDrawStopIndicator(Canvas canvas, int i) {
        if (this.trackStopIndicatorSize <= 0 || this.values.isEmpty()) {
            return;
        }
        if (this.values.get(this.values.size() - 1).floatValue() < this.valueTo) {
            drawStopIndicator(canvas, valueToX(this.valueTo), i);
        }
        if (isCentered() || (this.values.size() > 1 && this.values.get(0).floatValue() > this.valueFrom)) {
            drawStopIndicator(canvas, valueToX(this.valueFrom), i);
        }
    }

    private void maybeDrawTicks(Canvas canvas) {
        if (this.ticksCoordinates == null || this.ticksCoordinates.length == 0) {
            return;
        }
        float[] activeRange = getActiveRange();
        int ceil = (int) Math.ceil(activeRange[0] * ((this.ticksCoordinates.length / 2.0f) - 1.0f));
        int floor = (int) Math.floor(activeRange[1] * ((this.ticksCoordinates.length / 2.0f) - 1.0f));
        if (ceil > 0) {
            drawTicks(0, ceil * 2, canvas, this.inactiveTicksPaint);
        }
        if (ceil <= floor) {
            drawTicks(ceil * 2, (floor + 1) * 2, canvas, this.activeTicksPaint);
        }
        if ((floor + 1) * 2 < this.ticksCoordinates.length) {
            drawTicks((floor + 1) * 2, this.ticksCoordinates.length, canvas, this.inactiveTicksPaint);
        }
    }

    private boolean maybeIncreaseTrackSidePadding() {
        int max = this.minTrackSidePadding + Math.max(Math.max(Math.max((this.thumbWidth / 2) - this.defaultThumbRadius, 0), Math.max((this.trackThickness - this.defaultTrackThickness) / 2, 0)), Math.max(Math.max(this.tickActiveRadius - this.defaultTickActiveRadius, 0), Math.max(this.tickInactiveRadius - this.defaultTickInactiveRadius, 0)));
        if (this.trackSidePadding == max) {
            return false;
        }
        this.trackSidePadding = max;
        if (!isLaidOut()) {
            return true;
        }
        updateTrackWidth(isVertical() ? getHeight() : getWidth());
        return true;
    }

    private boolean maybeIncreaseWidgetThickness() {
        int paddingLeft = isVertical() ? getPaddingLeft() + getPaddingRight() : getPaddingTop() + getPaddingBottom();
        int max = Math.max(this.minWidgetThickness, Math.max(this.trackThickness + paddingLeft, this.thumbHeight + paddingLeft));
        if (max == this.widgetThickness) {
            return false;
        }
        this.widgetThickness = max;
        return true;
    }

    private boolean moveFocus(int i) {
        int i2 = this.focusedThumbIdx;
        this.focusedThumbIdx = (int) MathUtils.clamp(i2 + i, 0L, this.values.size() - 1);
        if (this.focusedThumbIdx == i2) {
            return false;
        }
        this.activeThumbIdx = this.focusedThumbIdx;
        updateThumbWidthWhenPressed();
        updateHaloHotspot();
        postInvalidate();
        return true;
    }

    private boolean moveFocusInAbsoluteDirection(int i) {
        if (isRtl() || isVertical()) {
            i = i == Integer.MIN_VALUE ? Integer.MAX_VALUE : -i;
        }
        return moveFocus(i);
    }

    private float normalizeValue(float f) {
        float f2 = (f - this.valueFrom) / (this.valueTo - this.valueFrom);
        return (isRtl() || isVertical()) ? 1.0f - f2 : f2;
    }

    private void onStartTrackingTouch() {
        Iterator<T> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStartTrackingTouch(this);
        }
    }

    private void onStopTrackingTouch() {
        Iterator<T> it = this.touchListeners.iterator();
        while (it.hasNext()) {
            it.next().onStopTrackingTouch(this);
        }
    }

    private void positionLabel(TooltipDrawable tooltipDrawable, float f) {
        calculateLabelBounds(tooltipDrawable, f);
        if (isVertical()) {
            RectF rectF = new RectF(this.labelRect);
            this.rotationMatrix.mapRect(rectF);
            rectF.round(this.labelRect);
        }
        DescendantOffsetUtils.offsetDescendantRect(ViewUtils.getContentView(this), this, this.labelRect);
        tooltipDrawable.setBounds(this.labelRect);
    }

    private void processAttributes(Context context, AttributeSet attributeSet, int i) {
        boolean z;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context, attributeSet, R.styleable.Slider, i, DEF_STYLE_RES, new int[0]);
        setOrientation(obtainStyledAttributes.getInt(R.styleable.Slider_android_orientation, 0));
        this.labelStyle = obtainStyledAttributes.getResourceId(R.styleable.Slider_labelStyle, R.style.Widget_MaterialComponents_Tooltip);
        this.valueFrom = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueFrom, 0.0f);
        this.valueTo = obtainStyledAttributes.getFloat(R.styleable.Slider_android_valueTo, 1.0f);
        setCentered(obtainStyledAttributes.getBoolean(R.styleable.Slider_centered, false));
        this.stepSize = obtainStyledAttributes.getFloat(R.styleable.Slider_android_stepSize, 0.0f);
        this.continuousModeTickCount = obtainStyledAttributes.getInt(R.styleable.Slider_continuousModeTickCount, 0);
        this.minTouchTargetSize = (int) Math.ceil(obtainStyledAttributes.getDimension(R.styleable.Slider_minTouchTargetSize, MaterialAttributes.resolveMinimumAccessibleTouchTarget(context)));
        boolean hasValue = obtainStyledAttributes.hasValue(R.styleable.Slider_trackColor);
        int i2 = hasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorInactive;
        int i3 = hasValue ? R.styleable.Slider_trackColor : R.styleable.Slider_trackColorActive;
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, obtainStyledAttributes, i2);
        setTrackInactiveTintList(colorStateList != null ? colorStateList : AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_track_color));
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i3);
        setTrackActiveTintList(colorStateList2 != null ? colorStateList2 : AppCompatResources.getColorStateList(context, R.color.material_slider_active_track_color));
        ColorStateList colorStateList3 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_thumbColor);
        setThumbTintList(colorStateList3 != null ? colorStateList3 : AppCompatResources.getColorStateList(context, R.color.material_slider_thumb_color));
        if (obtainStyledAttributes.hasValue(R.styleable.Slider_thumbStrokeColor)) {
            setThumbStrokeColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_thumbStrokeColor));
        }
        setThumbStrokeWidth(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbStrokeWidth, 0.0f));
        ColorStateList colorStateList4 = MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_haloColor);
        setHaloTintList(colorStateList4 != null ? colorStateList4 : AppCompatResources.getColorStateList(context, R.color.material_slider_halo_color));
        this.tickVisibilityMode = obtainStyledAttributes.hasValue(R.styleable.Slider_tickVisibilityMode) ? obtainStyledAttributes.getInt(R.styleable.Slider_tickVisibilityMode, -1) : convertToTickVisibilityMode(obtainStyledAttributes.getBoolean(R.styleable.Slider_tickVisible, true));
        boolean hasValue2 = obtainStyledAttributes.hasValue(R.styleable.Slider_tickColor);
        int i4 = hasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorInactive;
        int i5 = hasValue2 ? R.styleable.Slider_tickColor : R.styleable.Slider_tickColorActive;
        ColorStateList colorStateList5 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i4);
        setTickInactiveTintList(colorStateList5 != null ? colorStateList5 : AppCompatResources.getColorStateList(context, R.color.material_slider_inactive_tick_marks_color));
        ColorStateList colorStateList6 = MaterialResources.getColorStateList(context, obtainStyledAttributes, i5);
        setTickActiveTintList(colorStateList6 != null ? colorStateList6 : AppCompatResources.getColorStateList(context, R.color.material_slider_active_tick_marks_color));
        setThumbTrackGapSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbTrackGapSize, 0));
        setTrackStopIndicatorSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackStopIndicatorSize, 0));
        setTrackCornerSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackCornerSize, -1));
        setTrackInsideCornerSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackInsideCornerSize, 0));
        setTrackIconActiveStart(MaterialResources.getDrawable(context, obtainStyledAttributes, R.styleable.Slider_trackIconActiveStart));
        setTrackIconActiveEnd(MaterialResources.getDrawable(context, obtainStyledAttributes, R.styleable.Slider_trackIconActiveEnd));
        setTrackIconActiveColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_trackIconActiveColor));
        setTrackIconInactiveStart(MaterialResources.getDrawable(context, obtainStyledAttributes, R.styleable.Slider_trackIconInactiveStart));
        setTrackIconInactiveEnd(MaterialResources.getDrawable(context, obtainStyledAttributes, R.styleable.Slider_trackIconInactiveEnd));
        setTrackIconInactiveColor(MaterialResources.getColorStateList(context, obtainStyledAttributes, R.styleable.Slider_trackIconInactiveColor));
        setTrackIconSize(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackIconSize, 0));
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbRadius, 0);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbWidth, dimensionPixelSize * 2);
        int dimensionPixelSize3 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_thumbHeight, dimensionPixelSize * 2);
        setThumbWidth(dimensionPixelSize2);
        setThumbHeight(dimensionPixelSize3);
        setHaloRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_haloRadius, 0));
        setThumbElevation(obtainStyledAttributes.getDimension(R.styleable.Slider_thumbElevation, 0.0f));
        setTrackHeight(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_trackHeight, 0));
        setTickActiveRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_tickRadiusActive, this.trackStopIndicatorSize / 2));
        setTickInactiveRadius(obtainStyledAttributes.getDimensionPixelSize(R.styleable.Slider_tickRadiusInactive, this.trackStopIndicatorSize / 2));
        setLabelBehavior(obtainStyledAttributes.getInt(R.styleable.Slider_labelBehavior, 0));
        if (obtainStyledAttributes.getBoolean(R.styleable.Slider_android_enabled, true)) {
            z = false;
        } else {
            z = false;
            setEnabled(false);
        }
        Float[] fArr = new Float[1];
        fArr[z ? 1 : 0] = Float.valueOf(this.valueFrom);
        setValues(fArr);
        obtainStyledAttributes.recycle();
    }

    private void resetThumbWidth() {
        if (!hasGapBetweenThumbAndTrack() || this.defaultThumbWidth == -1 || this.defaultThumbTrackGapSize == -1) {
            return;
        }
        setThumbSize(this.defaultThumbWidth, this.defaultThumbHeight, Integer.valueOf(this.activeThumbIdx));
    }

    private void scheduleAccessibilityEventSender(int i) {
        if (this.accessibilityEventSender == null) {
            this.accessibilityEventSender = new AccessibilityEventSender(this, null);
        } else {
            removeCallbacks(this.accessibilityEventSender);
        }
        this.accessibilityEventSender.setVirtualViewId(i);
        postDelayed(this.accessibilityEventSender, 200L);
    }

    private void setThumbSize(int i, int i2, Integer num) {
        for (int i3 = 0; i3 < this.defaultThumbDrawables.size(); i3++) {
            if (num == null || i3 == num.intValue()) {
                this.defaultThumbDrawables.get(i3).setShapeAppearanceModel(ShapeAppearanceModel.builder().setAllCorners(0, i / 2.0f).build());
                this.defaultThumbDrawables.get(i3).setBounds(0, 0, i, i2 >= 0 ? i2 : this.thumbHeight);
            }
        }
        updateWidgetLayout(false);
    }

    private void setValueForLabel(TooltipDrawable tooltipDrawable, float f) {
        tooltipDrawable.setText(formatValue(f));
        positionLabel(tooltipDrawable, f);
        ViewOverlay contentViewOverlay = getContentViewOverlay();
        if (contentViewOverlay == null) {
            return;
        }
        contentViewOverlay.add(tooltipDrawable);
    }

    private void setValuesInternal(ArrayList<Float> arrayList) {
        if (arrayList.isEmpty()) {
            throw new IllegalArgumentException("At least one value must be set");
        }
        Collections.sort(arrayList);
        if (this.values.size() == arrayList.size() && this.values.equals(arrayList)) {
            return;
        }
        this.values = arrayList;
        this.dirtyConfig = true;
        updateDefaultThumbDrawables();
        this.focusedThumbIdx = 0;
        updateHaloHotspot();
        createLabelPool();
        dispatchOnChangedProgrammatically();
        postInvalidate();
    }

    private boolean shouldAlwaysShowLabel() {
        return this.labelBehavior == 3;
    }

    private boolean shouldDrawCompatHalo() {
        return this.forceDrawCompatHalo || getBackgroundRipple() == null;
    }

    private boolean snapActiveThumbToValue(float f) {
        return snapThumbToValue(this.activeThumbIdx, f);
    }

    private double snapPosition(float f) {
        if (this.stepSize <= 0.0f) {
            return f;
        }
        return Math.round(r0 * f) / ((int) ((this.valueTo - this.valueFrom) / this.stepSize));
    }

    private void snapThumbToPreviousDownTouchEventValue() {
        if (this.activeThumbIdx == -1 || this.previousDownTouchEventValues.isEmpty()) {
            return;
        }
        for (int i = 0; i < this.values.size(); i++) {
            if (i == this.activeThumbIdx) {
                snapThumbToValue(i, this.previousDownTouchEventValues.get(i).floatValue());
                return;
            }
        }
    }

    private boolean snapThumbToValue(int i, float f) {
        this.focusedThumbIdx = i;
        if (Math.abs(f - this.values.get(i).floatValue()) < THRESHOLD) {
            return false;
        }
        this.values.set(i, Float.valueOf(getClampedValue(i, f)));
        dispatchOnChangedFromUser(i);
        return true;
    }

    private boolean snapTouchPosition() {
        return snapActiveThumbToValue(getValueOfTouchPosition());
    }

    private void updateDefaultThumbDrawables() {
        if (this.defaultThumbDrawables.size() != this.values.size()) {
            this.defaultThumbDrawables.clear();
            for (int i = 0; i < this.values.size(); i++) {
                this.defaultThumbDrawables.add(createNewDefaultThumb());
            }
        }
    }

    private void updateFocusRingBounds(float f, float f2) {
        float f3;
        float f4;
        float f5;
        float f6;
        FocusRingDrawable focusRing = getFocusRing();
        if (focusRing != null) {
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.m3_slider_focus_ring_padding);
            float f7 = (this.thumbWidth / 2.0f) + (dimensionPixelOffset * 2.0f);
            float f8 = (this.thumbHeight / 2.0f) + dimensionPixelOffset;
            if (isVertical()) {
                f3 = f2 - f8;
                f4 = f2 + f8;
                f5 = f - f7;
                f6 = f + f7;
            } else {
                f3 = f - f7;
                f4 = f + f7;
                f5 = f2 - f8;
                f6 = f2 + f8;
            }
            focusRing.mutate();
            focusRing.setFocusRingBounds((int) f3, (int) f5, (int) f4, (int) f6);
        }
    }

    private void updateHaloHotspot() {
        RippleDrawable backgroundRipple;
        float normalizeValue = (normalizeValue(this.values.get(this.focusedThumbIdx).floatValue()) * this.trackWidth) + this.trackSidePadding;
        int calculateTrackCenter = calculateTrackCenter();
        if (!shouldDrawCompatHalo() && getMeasuredWidth() > 0 && (backgroundRipple = getBackgroundRipple()) != null) {
            float[] fArr = {normalizeValue - this.haloRadius, calculateTrackCenter - this.haloRadius, this.haloRadius + normalizeValue, this.haloRadius + calculateTrackCenter};
            if (isVertical()) {
                this.rotationMatrix.mapPoints(fArr);
            }
            backgroundRipple.setHotspotBounds((int) fArr[0], (int) fArr[1], (int) fArr[2], (int) fArr[3]);
        }
        updateFocusRingBounds(normalizeValue, calculateTrackCenter);
    }

    private void updateLabelPivots() {
        float f;
        float f2;
        boolean isVertical = isVertical();
        boolean isRtl = isRtl();
        if (isVertical && isRtl) {
            f = RIGHT_LABEL_PIVOT_X;
            f2 = 0.5f;
        } else if (isVertical) {
            f = 1.2f;
            f2 = 0.5f;
        } else {
            f = 0.5f;
            f2 = 1.2f;
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setPivots(f, f2);
        }
    }

    private void updateLabels() {
        updateLabelPivots();
        switch (this.labelBehavior) {
            case 0:
            case 1:
                if (this.activeThumbIdx == -1 || !isEnabled()) {
                    ensureLabelsRemoved();
                    return;
                } else {
                    ensureLabelsAdded(false);
                    return;
                }
            case 2:
                ensureLabelsRemoved();
                return;
            case 3:
                if (isEnabled() && isSliderVisibleOnScreen()) {
                    ensureLabelsAdded(true);
                    return;
                } else {
                    ensureLabelsRemoved();
                    return;
                }
            default:
                throw new IllegalArgumentException("Unexpected labelBehavior: " + this.labelBehavior);
        }
    }

    private void updateRotationMatrix() {
        float calculateTrackCenter = calculateTrackCenter();
        this.rotationMatrix.reset();
        this.rotationMatrix.setRotate(90.0f, calculateTrackCenter, calculateTrackCenter);
    }

    private void updateThumbWidthWhenPressed() {
        if (hasGapBetweenThumbAndTrack() && this.customThumbDrawable == null && this.customThumbDrawablesForValues.isEmpty()) {
            this.defaultThumbWidth = this.thumbWidth;
            this.defaultThumbHeight = this.thumbHeight;
            this.defaultThumbTrackGapSize = this.thumbTrackGapSize;
            setThumbSize(Math.round(this.thumbWidth * 0.5f), isFocusRingEnabled() ? this.thumbHeight - this.thumbHeightDecreaseFocusRing : -1, Integer.valueOf(this.activeThumbIdx));
        }
    }

    private void updateTicksCoordinates() {
        int min;
        validateConfigurationIfDirty();
        if (this.stepSize <= 0.0f) {
            updateTicksCoordinates(this.continuousModeTickCount);
            return;
        }
        switch (this.tickVisibilityMode) {
            case 0:
                min = Math.min(getDesiredTickCount(), getMaxTickCount());
                break;
            case 1:
                int desiredTickCount = getDesiredTickCount();
                min = desiredTickCount <= getMaxTickCount() ? desiredTickCount : 0;
                break;
            case 2:
                min = 0;
                break;
            default:
                throw new IllegalStateException("Unexpected tickVisibilityMode: " + this.tickVisibilityMode);
        }
        updateTicksCoordinates(min);
    }

    private void updateTicksCoordinates(int i) {
        if (i == 0) {
            this.ticksCoordinates = null;
            return;
        }
        if (this.ticksCoordinates == null || this.ticksCoordinates.length != i * 2) {
            this.ticksCoordinates = new float[i * 2];
        }
        float f = this.trackWidth / (i - 1);
        float calculateTrackCenter = calculateTrackCenter();
        for (int i2 = 0; i2 < i * 2; i2 += 2) {
            this.ticksCoordinates[i2] = this.trackSidePadding + ((i2 / 2.0f) * f);
            this.ticksCoordinates[i2 + 1] = calculateTrackCenter;
        }
        if (isVertical()) {
            this.rotationMatrix.mapPoints(this.ticksCoordinates);
        }
    }

    private void updateTrack(Canvas canvas, Paint paint, RectF rectF, float f, FullCornerDirection fullCornerDirection) {
        if (rectF.isEmpty()) {
            return;
        }
        float calculateStartTrackCornerSize = calculateStartTrackCornerSize(f);
        float calculateEndTrackCornerSize = calculateEndTrackCornerSize(f);
        switch (fullCornerDirection) {
            case LEFT:
                calculateEndTrackCornerSize = this.trackInsideCornerSize;
                break;
            case RIGHT:
                calculateStartTrackCornerSize = this.trackInsideCornerSize;
                break;
            case NONE:
                calculateStartTrackCornerSize = this.trackInsideCornerSize;
                calculateEndTrackCornerSize = this.trackInsideCornerSize;
                break;
        }
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeCap(Paint.Cap.BUTT);
        if (hasGapBetweenThumbAndTrack()) {
            paint.setAntiAlias(true);
        }
        RectF rectF2 = new RectF(rectF);
        if (isVertical()) {
            this.rotationMatrix.mapRect(rectF2);
        }
        this.trackPath.reset();
        if (rectF.width() >= calculateStartTrackCornerSize + calculateEndTrackCornerSize) {
            this.trackPath.addRoundRect(rectF2, getCornerRadii(calculateStartTrackCornerSize, calculateEndTrackCornerSize), Path.Direction.CW);
            canvas.drawPath(this.trackPath, paint);
            return;
        }
        float min = Math.min(calculateStartTrackCornerSize, calculateEndTrackCornerSize);
        float max = Math.max(calculateStartTrackCornerSize, calculateEndTrackCornerSize);
        canvas.save();
        this.trackPath.addRoundRect(rectF2, min, min, Path.Direction.CW);
        canvas.clipPath(this.trackPath);
        switch (fullCornerDirection.ordinal()) {
            case 1:
                this.cornerRect.set(rectF.left, rectF.top, rectF.left + (2.0f * max), rectF.bottom);
                break;
            case 2:
                this.cornerRect.set(rectF.right - (2.0f * max), rectF.top, rectF.right, rectF.bottom);
                break;
            default:
                this.cornerRect.set(rectF.centerX() - max, rectF.top, rectF.centerX() + max, rectF.bottom);
                break;
        }
        if (isVertical()) {
            this.rotationMatrix.mapRect(this.cornerRect);
        }
        canvas.drawRoundRect(this.cornerRect, max, max, paint);
        canvas.restore();
    }

    private void updateTrackIconActiveEnd() {
        if (this.trackIconActiveEnd != null) {
            if (!this.trackIconActiveEndMutated && this.trackIconActiveColor != null) {
                this.trackIconActiveEnd = DrawableCompat.wrap(this.trackIconActiveEnd).mutate();
                this.trackIconActiveEndMutated = true;
            }
            if (this.trackIconActiveEndMutated) {
                this.trackIconActiveEnd.setTintList(this.trackIconActiveColor);
            }
        }
    }

    private void updateTrackIconActiveStart() {
        if (this.trackIconActiveStart != null) {
            if (!this.trackIconActiveStartMutated && this.trackIconActiveColor != null) {
                this.trackIconActiveStart = DrawableCompat.wrap(this.trackIconActiveStart).mutate();
                this.trackIconActiveStartMutated = true;
            }
            if (this.trackIconActiveStartMutated) {
                this.trackIconActiveStart.setTintList(this.trackIconActiveColor);
            }
        }
    }

    private void updateTrackIconInactiveEnd() {
        if (this.trackIconInactiveEnd != null) {
            if (!this.trackIconInactiveEndMutated && this.trackIconInactiveColor != null) {
                this.trackIconInactiveEnd = DrawableCompat.wrap(this.trackIconInactiveEnd).mutate();
                this.trackIconInactiveEndMutated = true;
            }
            if (this.trackIconInactiveEndMutated) {
                this.trackIconInactiveEnd.setTintList(this.trackIconInactiveColor);
            }
        }
    }

    private void updateTrackIconInactiveStart() {
        if (this.trackIconInactiveStart != null) {
            if (!this.trackIconInactiveStartMutated && this.trackIconInactiveColor != null) {
                this.trackIconInactiveStart = DrawableCompat.wrap(this.trackIconInactiveStart).mutate();
                this.trackIconInactiveStartMutated = true;
            }
            if (this.trackIconInactiveStartMutated) {
                this.trackIconInactiveStart.setTintList(this.trackIconInactiveColor);
            }
        }
    }

    private void updateTrackWidth(int i) {
        this.trackWidth = Math.max(i - (this.trackSidePadding * 2), 0);
        updateTicksCoordinates();
    }

    private void updateWidgetLayout(boolean z) {
        boolean maybeIncreaseWidgetThickness = maybeIncreaseWidgetThickness();
        boolean maybeIncreaseTrackSidePadding = maybeIncreaseTrackSidePadding();
        if (isVertical()) {
            updateRotationMatrix();
        }
        if (maybeIncreaseWidgetThickness || z) {
            requestLayout();
        } else if (maybeIncreaseTrackSidePadding) {
            postInvalidate();
        }
    }

    private void validateConfigurationIfDirty() {
        if (this.dirtyConfig) {
            validateValues();
            validateStepSize();
            validateMinSeparation();
            warnAboutFloatingPointError();
            this.dirtyConfig = false;
        }
    }

    private void validateMinSeparation() {
        float minSeparation = getMinSeparation();
        if (minSeparation < 0.0f) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION, Float.valueOf(minSeparation)));
        }
        if (this.stepSize <= 0.0f || minSeparation <= 0.0f) {
            return;
        }
        if (this.separationUnit != 1) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE_UNIT, Float.valueOf(minSeparation), Float.valueOf(this.stepSize)));
        }
        if (minSeparation < this.stepSize || !isMultipleOfStepSize(minSeparation)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_MIN_SEPARATION_STEP_SIZE, Float.valueOf(minSeparation), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)));
        }
    }

    private void validateStepSize() {
        if (this.stepSize > 0.0f && !valueLandsOnTick(this.valueTo)) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.valueOf(this.stepSize), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
        }
    }

    private void validateValues() {
        if (this.valueFrom >= this.valueTo) {
            throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE_FROM, Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
        }
        Iterator<Float> it = this.values.iterator();
        while (it.hasNext()) {
            Float next = it.next();
            if (next.floatValue() < this.valueFrom || next.floatValue() > this.valueTo) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_VALUE, next, Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
            }
            if (this.stepSize > 0.0f && !valueLandsOnTick(next.floatValue())) {
                throw new IllegalStateException(String.format(EXCEPTION_ILLEGAL_DISCRETE_VALUE, next, Float.valueOf(this.valueFrom), Float.valueOf(this.stepSize), Float.valueOf(this.stepSize)));
            }
        }
    }

    private boolean valueLandsOnTick(float f) {
        return isMultipleOfStepSize(new BigDecimal(Float.toString(f)).subtract(new BigDecimal(Float.toString(this.valueFrom)), MathContext.DECIMAL64).doubleValue());
    }

    private float valueToX(float f) {
        return (normalizeValue(f) * this.trackWidth) + this.trackSidePadding;
    }

    private void warnAboutFloatingPointError() {
        if (this.stepSize == 0.0f) {
            return;
        }
        if (((int) this.stepSize) != this.stepSize) {
            Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, "stepSize", Float.valueOf(this.stepSize)));
        }
        if (((int) this.valueFrom) != this.valueFrom) {
            Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, "valueFrom", Float.valueOf(this.valueFrom)));
        }
        if (((int) this.valueTo) != this.valueTo) {
            Log.w(TAG, String.format(WARNING_FLOATING_POINT_ERROR, "valueTo", Float.valueOf(this.valueTo)));
        }
    }

    public void addOnChangeListener(L l) {
        this.changeListeners.add(l);
    }

    public void addOnSliderTouchListener(T t) {
        this.touchListeners.add(t);
    }

    public void clearOnChangeListeners() {
        this.changeListeners.clear();
    }

    public void clearOnSliderTouchListeners() {
        this.touchListeners.clear();
    }

    @Override // android.view.View
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        return this.accessibilityHelper.dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // android.view.View
    protected void drawableStateChanged() {
        super.drawableStateChanged();
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        this.stopIndicatorPaint.setColor(getColorForState(this.tickColorInactive));
        for (TooltipDrawable tooltipDrawable : this.labels) {
            if (tooltipDrawable.isStateful()) {
                tooltipDrawable.setState(getDrawableState());
            }
        }
        for (int i = 0; i < this.defaultThumbDrawables.size(); i++) {
            if (this.defaultThumbDrawables.get(i).isStateful()) {
                this.defaultThumbDrawables.get(i).setState(getDrawableState());
            }
        }
        this.haloPaint.setColor(getColorForState(this.haloColor));
        this.haloPaint.setAlpha(63);
    }

    void forceDrawCompatHalo(boolean z) {
        this.forceDrawCompatHalo = z;
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return SeekBar.class.getName();
    }

    final int getAccessibilityFocusedVirtualViewId() {
        return this.accessibilityHelper.getAccessibilityFocusedVirtualViewId();
    }

    public int getActiveThumbIndex() {
        return this.activeThumbIdx;
    }

    public int getContinuousModeTickCount() {
        return this.continuousModeTickCount;
    }

    public int getFocusedThumbIndex() {
        return this.focusedThumbIdx;
    }

    public int getHaloRadius() {
        return this.haloRadius;
    }

    public ColorStateList getHaloTintList() {
        return this.haloColor;
    }

    public int getLabelBehavior() {
        return this.labelBehavior;
    }

    protected float getMinSeparation() {
        return 0.0f;
    }

    public float getStepSize() {
        return this.stepSize;
    }

    public float getThumbElevation() {
        return this.thumbElevation;
    }

    public int getThumbHeight() {
        return this.thumbHeight;
    }

    public int getThumbRadius() {
        return this.thumbWidth / 2;
    }

    public ColorStateList getThumbStrokeColor() {
        return this.thumbStrokeColor;
    }

    public float getThumbStrokeWidth() {
        return this.thumbStrokeWidth;
    }

    public ColorStateList getThumbTintList() {
        return this.thumbTintList;
    }

    public int getThumbTrackGapSize() {
        return this.thumbTrackGapSize;
    }

    public int getThumbWidth() {
        return this.thumbWidth;
    }

    public int getTickActiveRadius() {
        return this.tickActiveRadius;
    }

    public ColorStateList getTickActiveTintList() {
        return this.tickColorActive;
    }

    public int getTickInactiveRadius() {
        return this.tickInactiveRadius;
    }

    public ColorStateList getTickInactiveTintList() {
        return this.tickColorInactive;
    }

    public ColorStateList getTickTintList() {
        if (this.tickColorInactive.equals(this.tickColorActive)) {
            return this.tickColorActive;
        }
        throw new IllegalStateException("The inactive and active ticks are different colors. Use the getTickColorInactive() and getTickColorActive() methods instead.");
    }

    public int getTickVisibilityMode() {
        return this.tickVisibilityMode;
    }

    public ColorStateList getTrackActiveTintList() {
        return this.trackColorActive;
    }

    public int getTrackCornerSize() {
        return this.trackCornerSize == -1 ? this.trackThickness / 2 : this.trackCornerSize;
    }

    public int getTrackHeight() {
        return this.trackThickness;
    }

    public ColorStateList getTrackIconActiveColor() {
        return this.trackIconActiveColor;
    }

    public Drawable getTrackIconActiveEnd() {
        return this.trackIconActiveEnd;
    }

    public Drawable getTrackIconActiveStart() {
        return this.trackIconActiveStart;
    }

    public ColorStateList getTrackIconInactiveColor() {
        return this.trackIconInactiveColor;
    }

    public Drawable getTrackIconInactiveEnd() {
        return this.trackIconInactiveEnd;
    }

    public Drawable getTrackIconInactiveStart() {
        return this.trackIconInactiveStart;
    }

    public int getTrackIconSize() {
        return this.trackIconSize;
    }

    public ColorStateList getTrackInactiveTintList() {
        return this.trackColorInactive;
    }

    public int getTrackInsideCornerSize() {
        return this.trackInsideCornerSize;
    }

    public int getTrackSidePadding() {
        return this.trackSidePadding;
    }

    public int getTrackStopIndicatorSize() {
        return this.trackStopIndicatorSize;
    }

    public ColorStateList getTrackTintList() {
        if (this.trackColorInactive.equals(this.trackColorActive)) {
            return this.trackColorActive;
        }
        throw new IllegalStateException("The inactive and active parts of the track are different colors. Use the getInactiveTrackColor() and getActiveTrackColor() methods instead.");
    }

    public int getTrackWidth() {
        return this.trackWidth;
    }

    public float getValueFrom() {
        return this.valueFrom;
    }

    public float getValueTo() {
        return this.valueTo;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<Float> getValues() {
        return new ArrayList(this.values);
    }

    public boolean hasLabelFormatter() {
        return this.formatter != null;
    }

    public boolean isCentered() {
        return this.centered;
    }

    final boolean isRtl() {
        return getLayoutDirection() == 1;
    }

    public boolean isTickVisible() {
        switch (this.tickVisibilityMode) {
            case 0:
                return true;
            case 1:
                return getDesiredTickCount() <= getMaxTickCount();
            case 2:
                return false;
            default:
                throw new IllegalStateException("Unexpected tickVisibilityMode: " + this.tickVisibilityMode);
        }
    }

    public boolean isVertical() {
        return this.widgetOrientation == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$createLabelAnimator$1$com-google-android-material-slider-BaseSlider, reason: not valid java name */
    public /* synthetic */ void m422x2eeddb89(ValueAnimator valueAnimator) {
        float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            it.next().setRevealFraction(floatValue);
        }
        postInvalidateOnAnimation();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-material-slider-BaseSlider, reason: not valid java name */
    public /* synthetic */ void m423lambda$new$0$comgoogleandroidmaterialsliderBaseSlider() {
        setActiveThumbIndex(-1);
        invalidate();
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.thisAndAncestorsVisible = isShown();
        getViewTreeObserver().addOnScrollChangedListener(this.onScrollChangedListener);
        getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            attachLabelToContentView(it.next());
        }
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        if (this.accessibilityEventSender != null) {
            removeCallbacks(this.accessibilityEventSender);
        }
        this.labelsAreAnimatedIn = false;
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            detachLabelFromContentView(it.next());
        }
        getViewTreeObserver().removeOnScrollChangedListener(this.onScrollChangedListener);
        getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.dirtyConfig) {
            validateConfigurationIfDirty();
            updateTicksCoordinates();
        }
        super.onDraw(canvas);
        int calculateTrackCenter = calculateTrackCenter();
        drawInactiveTracks(canvas, this.trackWidth, calculateTrackCenter);
        drawActiveTracks(canvas, this.trackWidth, calculateTrackCenter);
        if (isRtl() || isVertical()) {
            drawTrackIcons(canvas, this.activeTrackRect, this.inactiveTrackLeftRect);
        } else {
            drawTrackIcons(canvas, this.activeTrackRect, this.inactiveTrackRightRect);
        }
        maybeDrawTicks(canvas);
        maybeDrawStopIndicator(canvas, calculateTrackCenter);
        if ((this.thumbIsPressed || isFocused()) && isEnabled()) {
            maybeDrawCompatHalo(canvas, this.trackWidth, calculateTrackCenter);
        }
        updateLabels();
        drawThumbs(canvas, this.trackWidth, calculateTrackCenter);
    }

    @Override // android.view.View
    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z) {
            resetThumbWidth();
            this.activeThumbIdx = -1;
            this.accessibilityHelper.clearKeyboardFocusForVirtualView(this.focusedThumbIdx);
        } else {
            if (this.activeThumbIdx == -1) {
                focusThumbOnFocusGained(i);
                this.activeThumbIdx = this.focusedThumbIdx;
            }
            resetThumbWidth();
            updateThumbWidthWhenPressed();
            this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setVisibleToUser(false);
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (!isEnabled()) {
            return super.onKeyDown(i, keyEvent);
        }
        this.activeThumbIdx = this.focusedThumbIdx;
        this.isLongPress |= keyEvent.isLongPress();
        Float calculateIncrementForKey = calculateIncrementForKey(i);
        if (calculateIncrementForKey != null) {
            if (snapActiveThumbToValue(this.values.get(this.activeThumbIdx).floatValue() + calculateIncrementForKey.floatValue())) {
                updateHaloHotspot();
                postInvalidate();
            }
            return true;
        }
        if (i != 61) {
            return super.onKeyDown(i, keyEvent);
        }
        resetThumbWidth();
        if (keyEvent.hasNoModifiers()) {
            return moveFocus(1);
        }
        if (keyEvent.isShiftPressed()) {
            return moveFocus(-1);
        }
        return false;
    }

    @Override // android.view.View, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        this.isLongPress = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.viewRect.left = 0;
        this.viewRect.top = 0;
        this.viewRect.right = i3 - i;
        this.viewRect.bottom = i4 - i2;
        if (!this.exclusionRects.contains(this.viewRect)) {
            this.exclusionRects.add(this.viewRect);
        }
        ViewCompat.setSystemGestureExclusionRects(this, this.exclusionRects);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.widgetThickness + ((this.labelBehavior == 1 || shouldAlwaysShowLabel()) ? this.labels.get(0).getIntrinsicHeight() : 0), BasicMeasure.EXACTLY);
        if (isVertical()) {
            super.onMeasure(makeMeasureSpec, i2);
        } else {
            super.onMeasure(i, makeMeasureSpec);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable parcelable) {
        SliderState sliderState = (SliderState) parcelable;
        super.onRestoreInstanceState(sliderState.getSuperState());
        this.valueFrom = sliderState.valueFrom;
        this.valueTo = sliderState.valueTo;
        setValuesInternal(sliderState.values);
        this.stepSize = sliderState.stepSize;
        if (sliderState.hasFocus) {
            requestFocus();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SliderState sliderState = new SliderState(super.onSaveInstanceState());
        sliderState.valueFrom = this.valueFrom;
        sliderState.valueTo = this.valueTo;
        sliderState.values = new ArrayList<>(this.values);
        sliderState.stepSize = this.stepSize;
        sliderState.hasFocus = hasFocus();
        return sliderState;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        updateTrackWidth(isVertical() ? i2 : i);
        updateHaloHotspot();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled()) {
            return false;
        }
        float y = isVertical() ? motionEvent.getY() : motionEvent.getX();
        float x = isVertical() ? motionEvent.getX() : motionEvent.getY();
        this.touchPosition = (y - this.trackSidePadding) / this.trackWidth;
        this.touchPosition = Math.max(0.0f, this.touchPosition);
        this.touchPosition = Math.min(1.0f, this.touchPosition);
        switch (motionEvent.getActionMasked()) {
            case 0:
                this.touchDownAxis1 = y;
                this.touchDownAxis2 = x;
                this.previousDownTouchEventValues.clear();
                this.previousDownTouchEventValues = getValues();
                if ((isVertical() || !isPotentialVerticalScroll(motionEvent)) && (!isVertical() || !isPotentialHorizontalScroll(motionEvent))) {
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (pickActiveThumb()) {
                        requestFocus();
                        this.thumbIsPressed = true;
                        updateThumbWidthWhenPressed();
                        onStartTrackingTouch();
                        snapTouchPosition();
                        updateHaloHotspot();
                        invalidate();
                        break;
                    }
                }
                break;
            case 1:
                this.thumbIsPressed = false;
                if (this.lastEvent != null && this.lastEvent.getActionMasked() == 0 && Math.abs(this.lastEvent.getX() - motionEvent.getX()) <= this.scaledTouchSlop && Math.abs(this.lastEvent.getY() - motionEvent.getY()) <= this.scaledTouchSlop && pickActiveThumb()) {
                    onStartTrackingTouch();
                }
                if (this.activeThumbIdx != -1) {
                    snapTouchPosition();
                    updateHaloHotspot();
                    resetThumbWidth();
                    this.activeThumbIdx = -1;
                    onStopTrackingTouch();
                }
                invalidate();
                break;
            case 2:
                if (!this.thumbIsPressed) {
                    if (!isVertical() && isPotentialVerticalScroll(motionEvent) && Math.abs(y - this.touchDownAxis1) < this.scaledTouchSlop) {
                        return false;
                    }
                    if (isVertical() && isPotentialHorizontalScroll(motionEvent) && Math.abs(x - this.touchDownAxis2) < this.scaledTouchSlop * TOUCH_SLOP_RATIO) {
                        return false;
                    }
                    getParent().requestDisallowInterceptTouchEvent(true);
                    if (pickActiveThumb()) {
                        this.thumbIsPressed = true;
                        updateThumbWidthWhenPressed();
                        onStartTrackingTouch();
                    }
                }
                snapTouchPosition();
                updateHaloHotspot();
                invalidate();
                break;
            case 3:
                this.thumbIsPressed = false;
                snapThumbToPreviousDownTouchEventValue();
                updateHaloHotspot();
                resetThumbWidth();
                this.activeThumbIdx = -1;
                onStopTrackingTouch();
                invalidate();
                break;
        }
        setPressed(this.thumbIsPressed);
        this.lastEvent = MotionEvent.obtain(motionEvent);
        return true;
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean z) {
        super.onVisibilityAggregated(z);
        this.thisAndAncestorsVisible = z;
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        ViewOverlay contentViewOverlay;
        super.onVisibilityChanged(view, i);
        if (i == 0 || (contentViewOverlay = getContentViewOverlay()) == null) {
            return;
        }
        Iterator<TooltipDrawable> it = this.labels.iterator();
        while (it.hasNext()) {
            contentViewOverlay.remove(it.next());
        }
    }

    protected boolean pickActiveThumb() {
        if (this.activeThumbIdx != -1) {
            return true;
        }
        float valueOfTouchPositionAbsolute = getValueOfTouchPositionAbsolute();
        float valueToX = valueToX(valueOfTouchPositionAbsolute);
        this.activeThumbIdx = 0;
        float abs = Math.abs(this.values.get(this.activeThumbIdx).floatValue() - valueOfTouchPositionAbsolute);
        for (int i = 1; i < this.values.size(); i++) {
            float abs2 = Math.abs(this.values.get(i).floatValue() - valueOfTouchPositionAbsolute);
            float valueToX2 = valueToX(this.values.get(i).floatValue());
            if (Float.compare(abs2, abs) > 0) {
                break;
            }
            boolean z = isRtl() || isVertical() ? valueToX2 - valueToX > 0.0f : valueToX2 - valueToX < 0.0f;
            if (Float.compare(abs2, abs) < 0) {
                abs = abs2;
                this.activeThumbIdx = i;
            } else if (Float.compare(abs2, abs) != 0) {
                continue;
            } else {
                if (Math.abs(valueToX2 - valueToX) < this.scaledTouchSlop) {
                    this.activeThumbIdx = -1;
                    return false;
                }
                if (z) {
                    abs = abs2;
                    this.activeThumbIdx = i;
                }
            }
        }
        return this.activeThumbIdx != -1;
    }

    public void removeOnChangeListener(L l) {
        this.changeListeners.remove(l);
    }

    public void removeOnSliderTouchListener(T t) {
        this.touchListeners.remove(t);
    }

    public void scheduleTooltipTimeout() {
        removeCallbacks(this.resetActiveThumbIndex);
        postDelayed(this.resetActiveThumbIndex, this.tooltipTimeoutMillis);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setActiveThumbIndex(int i) {
        this.activeThumbIdx = i;
    }

    public void setCentered(boolean z) {
        if (this.centered == z) {
            return;
        }
        this.centered = z;
        if (z) {
            setValues(Float.valueOf((this.valueFrom + this.valueTo) / 2.0f));
        } else {
            setValues(Float.valueOf(this.valueFrom));
        }
        updateWidgetLayout(true);
    }

    public void setContinuousModeTickCount(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_CONTINUOUS_MODE_TICK_COUNT, Integer.valueOf(i)));
        }
        if (this.continuousModeTickCount != i) {
            this.continuousModeTickCount = i;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawable(int i) {
        setCustomThumbDrawable(getResources().getDrawable(i));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawable(Drawable drawable) {
        this.customThumbDrawable = initializeCustomThumbDrawable(drawable);
        this.customThumbDrawablesForValues.clear();
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(int... iArr) {
        Drawable[] drawableArr = new Drawable[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            drawableArr[i] = getResources().getDrawable(iArr[i]);
        }
        setCustomThumbDrawablesForValues(drawableArr);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCustomThumbDrawablesForValues(Drawable... drawableArr) {
        this.customThumbDrawable = null;
        this.customThumbDrawablesForValues = new ArrayList();
        for (Drawable drawable : drawableArr) {
            this.customThumbDrawablesForValues.add(initializeCustomThumbDrawable(drawable));
        }
        postInvalidate();
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        setLayerType(z ? 0 : 2, null);
    }

    public void setFocusedThumbIndex(int i) {
        if (i < 0 || i >= this.values.size()) {
            throw new IllegalArgumentException("index out of range");
        }
        this.focusedThumbIdx = i;
        this.accessibilityHelper.requestKeyboardFocusForVirtualView(this.focusedThumbIdx);
        postInvalidate();
    }

    public void setHaloRadius(int i) {
        if (i == this.haloRadius) {
            return;
        }
        this.haloRadius = i;
        RippleDrawable backgroundRipple = getBackgroundRipple();
        if (shouldDrawCompatHalo() || backgroundRipple == null) {
            postInvalidate();
        } else {
            DrawableUtils.setRippleDrawableRadius(backgroundRipple, this.haloRadius);
        }
    }

    public void setHaloRadiusResource(int i) {
        setHaloRadius(getResources().getDimensionPixelSize(i));
    }

    public void setHaloTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.haloColor)) {
            return;
        }
        this.haloColor = colorStateList;
        RippleDrawable backgroundRipple = getBackgroundRipple();
        if (!shouldDrawCompatHalo() && backgroundRipple != null) {
            backgroundRipple.setColor(colorStateList);
            return;
        }
        this.haloPaint.setColor(getColorForState(colorStateList));
        this.haloPaint.setAlpha(63);
        invalidate();
    }

    public void setLabelBehavior(int i) {
        if (this.labelBehavior != i) {
            this.labelBehavior = i;
            updateWidgetLayout(true);
        }
    }

    public void setLabelFormatter(LabelFormatter labelFormatter) {
        this.formatter = labelFormatter;
    }

    public void setOrientation(int i) {
        if (this.widgetOrientation == i) {
            return;
        }
        this.widgetOrientation = i;
        updateWidgetLayout(true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void setSeparationUnit(int i) {
        this.separationUnit = i;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setStepSize(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException(String.format(EXCEPTION_ILLEGAL_STEP_SIZE, Float.valueOf(f), Float.valueOf(this.valueFrom), Float.valueOf(this.valueTo)));
        }
        if (this.stepSize != f) {
            this.stepSize = f;
            this.dirtyConfig = true;
            postInvalidate();
        }
    }

    public void setThumbElevation(float f) {
        if (f == this.thumbElevation) {
            return;
        }
        this.thumbElevation = f;
        for (int i = 0; i < this.defaultThumbDrawables.size(); i++) {
            this.defaultThumbDrawables.get(i).setElevation(this.thumbElevation);
        }
    }

    public void setThumbElevationResource(int i) {
        setThumbElevation(getResources().getDimension(i));
    }

    public void setThumbHeight(int i) {
        if (i == this.thumbHeight) {
            return;
        }
        this.thumbHeight = i;
        for (int i2 = 0; i2 < this.defaultThumbDrawables.size(); i2++) {
            this.defaultThumbDrawables.get(i2).setBounds(0, 0, this.thumbWidth, this.thumbHeight);
        }
        if (this.customThumbDrawable != null) {
            adjustCustomThumbDrawableBounds(this.customThumbDrawable);
        }
        Iterator<Drawable> it = this.customThumbDrawablesForValues.iterator();
        while (it.hasNext()) {
            adjustCustomThumbDrawableBounds(it.next());
        }
        updateWidgetLayout(false);
    }

    public void setThumbHeightResource(int i) {
        setThumbHeight(getResources().getDimensionPixelSize(i));
    }

    public void setThumbRadius(int i) {
        setThumbWidth(i * 2);
        setThumbHeight(i * 2);
    }

    public void setThumbRadiusResource(int i) {
        setThumbRadius(getResources().getDimensionPixelSize(i));
    }

    public void setThumbStrokeColor(ColorStateList colorStateList) {
        if (colorStateList == this.thumbStrokeColor) {
            return;
        }
        this.thumbStrokeColor = colorStateList;
        for (int i = 0; i < this.defaultThumbDrawables.size(); i++) {
            this.defaultThumbDrawables.get(i).setStrokeColor(colorStateList);
        }
        postInvalidate();
    }

    public void setThumbStrokeColorResource(int i) {
        if (i != 0) {
            setThumbStrokeColor(AppCompatResources.getColorStateList(getContext(), i));
        }
    }

    public void setThumbStrokeWidth(float f) {
        if (f == this.thumbStrokeWidth) {
            return;
        }
        this.thumbStrokeWidth = f;
        for (int i = 0; i < this.defaultThumbDrawables.size(); i++) {
            this.defaultThumbDrawables.get(i).setStrokeWidth(f);
        }
        postInvalidate();
    }

    public void setThumbStrokeWidthResource(int i) {
        if (i != 0) {
            setThumbStrokeWidth(getResources().getDimension(i));
        }
    }

    public void setThumbTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.thumbTintList)) {
            return;
        }
        this.thumbTintList = colorStateList;
        for (int i = 0; i < this.defaultThumbDrawables.size(); i++) {
            this.defaultThumbDrawables.get(i).setFillColor(this.thumbTintList);
        }
        invalidate();
    }

    public void setThumbTrackGapSize(int i) {
        if (this.thumbTrackGapSize == i) {
            return;
        }
        this.thumbTrackGapSize = i;
        invalidate();
    }

    public void setThumbWidth(int i) {
        if (i == this.thumbWidth) {
            return;
        }
        this.thumbWidth = i;
        if (this.customThumbDrawable != null) {
            adjustCustomThumbDrawableBounds(i, this.customThumbDrawable);
        }
        for (int i2 = 0; i2 < this.customThumbDrawablesForValues.size(); i2++) {
            adjustCustomThumbDrawableBounds(i, this.customThumbDrawablesForValues.get(i2));
        }
        setThumbSize(i, -1, null);
    }

    public void setThumbWidthResource(int i) {
        setThumbWidth(getResources().getDimensionPixelSize(i));
    }

    public void setTickActiveRadius(int i) {
        if (this.tickActiveRadius != i) {
            this.tickActiveRadius = i;
            this.activeTicksPaint.setStrokeWidth(i * 2);
            updateWidgetLayout(false);
        }
    }

    public void setTickActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorActive)) {
            return;
        }
        this.tickColorActive = colorStateList;
        this.activeTicksPaint.setColor(getColorForState(this.tickColorActive));
        invalidate();
    }

    public void setTickInactiveRadius(int i) {
        if (this.tickInactiveRadius != i) {
            this.tickInactiveRadius = i;
            this.inactiveTicksPaint.setStrokeWidth(i * 2);
            updateWidgetLayout(false);
        }
    }

    public void setTickInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.tickColorInactive)) {
            return;
        }
        this.tickColorInactive = colorStateList;
        this.inactiveTicksPaint.setColor(getColorForState(this.tickColorInactive));
        invalidate();
    }

    public void setTickTintList(ColorStateList colorStateList) {
        setTickInactiveTintList(colorStateList);
        setTickActiveTintList(colorStateList);
    }

    public void setTickVisibilityMode(int i) {
        if (this.tickVisibilityMode != i) {
            this.tickVisibilityMode = i;
            postInvalidate();
        }
    }

    @Deprecated
    public void setTickVisible(boolean z) {
        setTickVisibilityMode(convertToTickVisibilityMode(z));
    }

    public void setTrackActiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorActive)) {
            return;
        }
        this.trackColorActive = colorStateList;
        this.activeTrackPaint.setColor(getColorForState(this.trackColorActive));
        invalidate();
    }

    public void setTrackCornerSize(int i) {
        if (this.trackCornerSize == i) {
            return;
        }
        this.trackCornerSize = i;
        invalidate();
    }

    public void setTrackHeight(int i) {
        if (this.trackThickness != i) {
            this.trackThickness = i;
            invalidateTrack();
            updateWidgetLayout(false);
        }
    }

    public void setTrackIconActiveColor(ColorStateList colorStateList) {
        if (colorStateList == this.trackIconActiveColor) {
            return;
        }
        this.trackIconActiveColor = colorStateList;
        updateTrackIconActiveStart();
        updateTrackIconActiveEnd();
        invalidate();
    }

    public void setTrackIconActiveEnd(int i) {
        setTrackIconActiveEnd(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconActiveEnd(Drawable drawable) {
        if (drawable == this.trackIconActiveEnd) {
            return;
        }
        this.trackIconActiveEnd = drawable;
        this.trackIconActiveEndMutated = false;
        updateTrackIconActiveEnd();
        invalidate();
    }

    public void setTrackIconActiveStart(int i) {
        setTrackIconActiveStart(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconActiveStart(Drawable drawable) {
        if (drawable == this.trackIconActiveStart) {
            return;
        }
        this.trackIconActiveStart = drawable;
        this.trackIconActiveStartMutated = false;
        updateTrackIconActiveStart();
        invalidate();
    }

    public void setTrackIconInactiveColor(ColorStateList colorStateList) {
        if (colorStateList == this.trackIconInactiveColor) {
            return;
        }
        this.trackIconInactiveColor = colorStateList;
        updateTrackIconInactiveStart();
        updateTrackIconInactiveEnd();
        invalidate();
    }

    public void setTrackIconInactiveEnd(int i) {
        setTrackIconInactiveEnd(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconInactiveEnd(Drawable drawable) {
        if (drawable == this.trackIconInactiveEnd) {
            return;
        }
        this.trackIconInactiveEnd = drawable;
        this.trackIconInactiveEndMutated = false;
        updateTrackIconInactiveEnd();
        invalidate();
    }

    public void setTrackIconInactiveStart(int i) {
        setTrackIconInactiveStart(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setTrackIconInactiveStart(Drawable drawable) {
        if (drawable == this.trackIconInactiveStart) {
            return;
        }
        this.trackIconInactiveStart = drawable;
        this.trackIconInactiveStartMutated = false;
        updateTrackIconInactiveStart();
        invalidate();
    }

    public void setTrackIconSize(int i) {
        if (this.trackIconSize == i) {
            return;
        }
        this.trackIconSize = i;
        invalidate();
    }

    public void setTrackInactiveTintList(ColorStateList colorStateList) {
        if (colorStateList.equals(this.trackColorInactive)) {
            return;
        }
        this.trackColorInactive = colorStateList;
        this.inactiveTrackPaint.setColor(getColorForState(this.trackColorInactive));
        invalidate();
    }

    public void setTrackInsideCornerSize(int i) {
        if (this.trackInsideCornerSize == i) {
            return;
        }
        this.trackInsideCornerSize = i;
        invalidate();
    }

    public void setTrackStopIndicatorSize(int i) {
        if (this.trackStopIndicatorSize == i) {
            return;
        }
        this.trackStopIndicatorSize = i;
        this.stopIndicatorPaint.setStrokeWidth(i);
        invalidate();
    }

    public void setTrackTintList(ColorStateList colorStateList) {
        setTrackInactiveTintList(colorStateList);
        setTrackActiveTintList(colorStateList);
    }

    public void setValueFrom(float f) {
        this.valueFrom = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    public void setValueTo(float f) {
        this.valueTo = f;
        this.dirtyConfig = true;
        postInvalidate();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(List<Float> list) {
        setValuesInternal(new ArrayList<>(list));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setValues(Float... fArr) {
        ArrayList<Float> arrayList = new ArrayList<>();
        Collections.addAll(arrayList, fArr);
        setValuesInternal(arrayList);
    }

    void updateBoundsForVirtualViewId(int i, Rect rect) {
        int normalizeValue = this.trackSidePadding + ((int) (normalizeValue(getValues().get(i).floatValue()) * this.trackWidth));
        int calculateTrackCenter = calculateTrackCenter();
        int max = Math.max(this.minTouchTargetSize, this.accessibilityMinTouchTargetSize);
        int max2 = Math.max(this.thumbWidth / 2, max / 2);
        int max3 = Math.max(this.thumbHeight / 2, max / 2);
        RectF rectF = new RectF(normalizeValue - max2, calculateTrackCenter - max3, normalizeValue + max2, calculateTrackCenter + max3);
        if (isVertical()) {
            this.rotationMatrix.mapRect(rectF);
        }
        rect.set((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }
}
