package com.google.android.material.focus;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableWrapper;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.FloatProperty;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.animation.OvershootInterpolator;
import androidx.core.view.ViewCompat;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearance;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.StateListShapeAppearanceModel;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public class FocusRingDrawable extends DrawableWrapper {
    private static final int ANIMATION_DURATION = 300;
    private static final boolean DEBUG_COLORS = false;
    private static final Drawable EMPTY_DRAWABLE = new ColorDrawable(0);
    private static final int[] FOCUSED_STATE_SET = {R.attr.state_focused, R.attr.state_window_focused};
    private static final TimeInterpolator INTERPOLATOR = new OvershootInterpolator(4.0f);
    private static final FloatProperty<FocusRingDrawable> PROPERTY_INTERPOLATION = new AnonymousClass1("interpolation");
    private ObjectAnimator animator;
    private boolean focused;
    private float interpolation;
    private WeakReference<MaterialShapeDrawable> materialShapeDrawable;
    private final Matrix matrix;
    private boolean mutated;
    private final Paint paint;
    private final ShapeAppearancePathProvider pathProvider;
    private boolean previousStateSetEmpty;
    private float shapeAppearanceCornerSize;
    private final Path shapeAppearancePath;
    private FocusRingState state;
    private final Path tmpPath;
    private final Rect tmpRect;
    private final RectF tmpRectF;

    /* renamed from: com.google.android.material.focus.FocusRingDrawable$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends FloatProperty<FocusRingDrawable> {
        AnonymousClass1(String str) {
            super(str);
        }

        public Float get(FocusRingDrawable focusRingDrawable) {
            return Float.valueOf(FocusRingDrawable.access$000(focusRingDrawable));
        }

        @Override // android.util.Property
        public /* bridge */ /* synthetic */ Float get(Object obj) {
            return get((FocusRingDrawable) obj);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(FocusRingDrawable focusRingDrawable, float f) {
            FocusRingDrawable.access$002(focusRingDrawable, f);
            focusRingDrawable.invalidateSelf();
        }

        @Override // android.util.FloatProperty
        public /* bridge */ /* synthetic */ void setValue(FocusRingDrawable focusRingDrawable, float f) {
            setValue2(focusRingDrawable, f);
        }
    }

    /* renamed from: com.google.android.material.focus.FocusRingDrawable$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends AnimatorListenerAdapter {
        AnonymousClass2() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            super.onAnimationCancel(animator);
            FocusRingDrawable.access$002(FocusRingDrawable.this, 1.0f);
            FocusRingDrawable.this.invalidateSelf();
        }
    }

    /* loaded from: classes.dex */
    private static final class FocusRingState extends Drawable.ConstantState {
        int mChangingConfigurations;
        private Rect ringCustomBounds;
        private boolean ringEnabled;
        private int ringEnabledAttr;
        private boolean ringEnabledInflated;
        private int ringInnerColor;
        private int ringInnerColorAttr;
        private float ringInnerInset;
        private int ringInnerInsetAttr;
        private float ringInnerStrokeWidth;
        private int ringInnerStrokeWidthAttr;
        private float ringInset;
        private int ringInsetAttr;
        private int ringOuterColor;
        private int ringOuterColorAttr;
        private float ringOuterStrokeWidth;
        private int ringOuterStrokeWidthAttr;
        private float ringRadius;
        private int ringRadiusAttr;
        private ShapeAppearance ringShapeAppearance;
        private int ringShapeAppearanceAttr;
        private int ringShapeAppearanceResId;
        private int[] ringStateSet;
        Drawable.ConstantState wrappedState;

        FocusRingState(FocusRingState focusRingState) {
            this.mChangingConfigurations = 0;
            this.ringEnabled = false;
            this.ringEnabledAttr = Integer.MIN_VALUE;
            this.ringEnabledInflated = false;
            this.ringOuterColor = Integer.MIN_VALUE;
            this.ringOuterColorAttr = Integer.MIN_VALUE;
            this.ringInnerColor = Integer.MIN_VALUE;
            this.ringInnerColorAttr = Integer.MIN_VALUE;
            this.ringOuterStrokeWidth = Float.NaN;
            this.ringOuterStrokeWidthAttr = Integer.MIN_VALUE;
            this.ringInnerStrokeWidth = Float.NaN;
            this.ringInnerStrokeWidthAttr = Integer.MIN_VALUE;
            this.ringRadius = Float.NaN;
            this.ringRadiusAttr = Integer.MIN_VALUE;
            this.ringInset = Float.NaN;
            this.ringInsetAttr = Integer.MIN_VALUE;
            this.ringInnerInset = Float.NaN;
            this.ringInnerInsetAttr = Integer.MIN_VALUE;
            this.ringShapeAppearance = null;
            this.ringShapeAppearanceResId = Integer.MIN_VALUE;
            this.ringShapeAppearanceAttr = Integer.MIN_VALUE;
            this.ringCustomBounds = null;
            this.ringStateSet = FocusRingDrawable.access$2300();
            if (focusRingState != null) {
                this.wrappedState = focusRingState.wrappedState;
                this.mChangingConfigurations = focusRingState.mChangingConfigurations;
                this.ringEnabled = focusRingState.ringEnabled;
                this.ringEnabledAttr = focusRingState.ringEnabledAttr;
                this.ringEnabledInflated = focusRingState.ringEnabledInflated;
                this.ringOuterColor = focusRingState.ringOuterColor;
                this.ringOuterColorAttr = focusRingState.ringOuterColorAttr;
                this.ringInnerColor = focusRingState.ringInnerColor;
                this.ringInnerColorAttr = focusRingState.ringInnerColorAttr;
                this.ringOuterStrokeWidth = focusRingState.ringOuterStrokeWidth;
                this.ringOuterStrokeWidthAttr = focusRingState.ringOuterStrokeWidthAttr;
                this.ringInnerStrokeWidth = focusRingState.ringInnerStrokeWidth;
                this.ringInnerStrokeWidthAttr = focusRingState.ringInnerStrokeWidthAttr;
                this.ringRadius = focusRingState.ringRadius;
                this.ringRadiusAttr = focusRingState.ringRadiusAttr;
                this.ringInset = focusRingState.ringInset;
                this.ringInsetAttr = focusRingState.ringInsetAttr;
                this.ringInnerInset = focusRingState.ringInnerInset;
                this.ringInnerInsetAttr = focusRingState.ringInnerInsetAttr;
                this.ringShapeAppearanceResId = focusRingState.ringShapeAppearanceResId;
                this.ringShapeAppearanceAttr = focusRingState.ringShapeAppearanceAttr;
                if (focusRingState.ringShapeAppearance instanceof ShapeAppearanceModel) {
                    this.ringShapeAppearance = ((ShapeAppearanceModel) focusRingState.ringShapeAppearance).toBuilder().build();
                } else if (focusRingState.ringShapeAppearance instanceof StateListShapeAppearanceModel) {
                    this.ringShapeAppearance = ((StateListShapeAppearanceModel) focusRingState.ringShapeAppearance).toBuilder().build();
                } else {
                    this.ringShapeAppearance = focusRingState.ringShapeAppearance;
                }
                if (focusRingState.ringCustomBounds != null) {
                    this.ringCustomBounds = new Rect(focusRingState.ringCustomBounds);
                }
                this.ringStateSet = Arrays.copyOf(focusRingState.ringStateSet, focusRingState.ringStateSet.length);
            }
        }

        static /* synthetic */ int access$100(FocusRingState focusRingState) {
            return focusRingState.ringEnabledAttr;
        }

        static /* synthetic */ int access$1000(FocusRingState focusRingState) {
            return focusRingState.ringInnerStrokeWidthAttr;
        }

        static /* synthetic */ int access$1002(FocusRingState focusRingState, int i) {
            focusRingState.ringInnerStrokeWidthAttr = i;
            return i;
        }

        static /* synthetic */ int access$102(FocusRingState focusRingState, int i) {
            focusRingState.ringEnabledAttr = i;
            return i;
        }

        static /* synthetic */ float access$1100(FocusRingState focusRingState) {
            return focusRingState.ringInnerStrokeWidth;
        }

        static /* synthetic */ float access$1102(FocusRingState focusRingState, float f) {
            focusRingState.ringInnerStrokeWidth = f;
            return f;
        }

        static /* synthetic */ int access$1200(FocusRingState focusRingState) {
            return focusRingState.ringRadiusAttr;
        }

        static /* synthetic */ int access$1202(FocusRingState focusRingState, int i) {
            focusRingState.ringRadiusAttr = i;
            return i;
        }

        static /* synthetic */ float access$1300(FocusRingState focusRingState) {
            return focusRingState.ringRadius;
        }

        static /* synthetic */ float access$1302(FocusRingState focusRingState, float f) {
            focusRingState.ringRadius = f;
            return f;
        }

        static /* synthetic */ int access$1400(FocusRingState focusRingState) {
            return focusRingState.ringInsetAttr;
        }

        static /* synthetic */ int access$1402(FocusRingState focusRingState, int i) {
            focusRingState.ringInsetAttr = i;
            return i;
        }

        static /* synthetic */ float access$1500(FocusRingState focusRingState) {
            return focusRingState.ringInset;
        }

        static /* synthetic */ float access$1502(FocusRingState focusRingState, float f) {
            focusRingState.ringInset = f;
            return f;
        }

        static /* synthetic */ int access$1600(FocusRingState focusRingState) {
            return focusRingState.ringInnerInsetAttr;
        }

        static /* synthetic */ int access$1602(FocusRingState focusRingState, int i) {
            focusRingState.ringInnerInsetAttr = i;
            return i;
        }

        static /* synthetic */ float access$1700(FocusRingState focusRingState) {
            return focusRingState.ringInnerInset;
        }

        static /* synthetic */ float access$1702(FocusRingState focusRingState, float f) {
            focusRingState.ringInnerInset = f;
            return f;
        }

        static /* synthetic */ int access$1800(FocusRingState focusRingState) {
            return focusRingState.ringShapeAppearanceAttr;
        }

        static /* synthetic */ int access$1802(FocusRingState focusRingState, int i) {
            focusRingState.ringShapeAppearanceAttr = i;
            return i;
        }

        static /* synthetic */ int access$1900(FocusRingState focusRingState) {
            return focusRingState.ringShapeAppearanceResId;
        }

        static /* synthetic */ int access$1902(FocusRingState focusRingState, int i) {
            focusRingState.ringShapeAppearanceResId = i;
            return i;
        }

        static /* synthetic */ boolean access$200(FocusRingState focusRingState) {
            return focusRingState.ringEnabled;
        }

        static /* synthetic */ ShapeAppearance access$2000(FocusRingState focusRingState) {
            return focusRingState.ringShapeAppearance;
        }

        static /* synthetic */ ShapeAppearance access$2002(FocusRingState focusRingState, ShapeAppearance shapeAppearance) {
            focusRingState.ringShapeAppearance = shapeAppearance;
            return shapeAppearance;
        }

        static /* synthetic */ boolean access$202(FocusRingState focusRingState, boolean z) {
            focusRingState.ringEnabled = z;
            return z;
        }

        static /* synthetic */ int[] access$2100(FocusRingState focusRingState) {
            return focusRingState.ringStateSet;
        }

        static /* synthetic */ int[] access$2102(FocusRingState focusRingState, int[] iArr) {
            focusRingState.ringStateSet = iArr;
            return iArr;
        }

        static /* synthetic */ Rect access$2200(FocusRingState focusRingState) {
            return focusRingState.ringCustomBounds;
        }

        static /* synthetic */ Rect access$2202(FocusRingState focusRingState, Rect rect) {
            focusRingState.ringCustomBounds = rect;
            return rect;
        }

        static /* synthetic */ boolean access$300(FocusRingState focusRingState) {
            return focusRingState.ringEnabledInflated;
        }

        static /* synthetic */ boolean access$302(FocusRingState focusRingState, boolean z) {
            focusRingState.ringEnabledInflated = z;
            return z;
        }

        static /* synthetic */ int access$400(FocusRingState focusRingState) {
            return focusRingState.ringOuterColorAttr;
        }

        static /* synthetic */ int access$402(FocusRingState focusRingState, int i) {
            focusRingState.ringOuterColorAttr = i;
            return i;
        }

        static /* synthetic */ int access$500(FocusRingState focusRingState) {
            return focusRingState.ringOuterColor;
        }

        static /* synthetic */ int access$502(FocusRingState focusRingState, int i) {
            focusRingState.ringOuterColor = i;
            return i;
        }

        static /* synthetic */ int access$600(FocusRingState focusRingState) {
            return focusRingState.ringInnerColorAttr;
        }

        static /* synthetic */ int access$602(FocusRingState focusRingState, int i) {
            focusRingState.ringInnerColorAttr = i;
            return i;
        }

        static /* synthetic */ int access$700(FocusRingState focusRingState) {
            return focusRingState.ringInnerColor;
        }

        static /* synthetic */ int access$702(FocusRingState focusRingState, int i) {
            focusRingState.ringInnerColor = i;
            return i;
        }

        static /* synthetic */ int access$800(FocusRingState focusRingState) {
            return focusRingState.ringOuterStrokeWidthAttr;
        }

        static /* synthetic */ int access$802(FocusRingState focusRingState, int i) {
            focusRingState.ringOuterStrokeWidthAttr = i;
            return i;
        }

        static /* synthetic */ float access$900(FocusRingState focusRingState) {
            return focusRingState.ringOuterStrokeWidth;
        }

        static /* synthetic */ float access$902(FocusRingState focusRingState, float f) {
            focusRingState.ringOuterStrokeWidth = f;
            return f;
        }

        boolean canConstantState() {
            return this.wrappedState != null;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return this.mChangingConfigurations | (this.wrappedState != null ? this.wrappedState.getChangingConfigurations() : 0);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            return new FocusRingDrawable(this, null, null);
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable(Resources resources) {
            return new FocusRingDrawable(this, resources, null);
        }
    }

    public FocusRingDrawable() {
        super(null);
        this.paint = new Paint(1);
        this.tmpRectF = new RectF();
        this.tmpRect = new Rect();
        this.tmpPath = new Path();
        this.shapeAppearancePath = new Path();
        this.matrix = new Matrix();
        this.pathProvider = ShapeAppearancePathProvider.getInstanceOrCreate();
        this.shapeAppearanceCornerSize = -1.0f;
        this.interpolation = 1.0f;
        this.focused = false;
        this.mutated = false;
        this.state = new FocusRingState(null);
    }

    public FocusRingDrawable(Context context, Drawable drawable) {
        super(drawable);
        this.paint = new Paint(1);
        this.tmpRectF = new RectF();
        this.tmpRect = new Rect();
        this.tmpPath = new Path();
        this.shapeAppearancePath = new Path();
        this.matrix = new Matrix();
        this.pathProvider = ShapeAppearancePathProvider.getInstanceOrCreate();
        this.shapeAppearanceCornerSize = -1.0f;
        this.interpolation = 1.0f;
        this.focused = false;
        this.mutated = false;
        this.state = new FocusRingState(null);
        if (drawable != null) {
            this.state.wrappedState = drawable.getConstantState();
        }
        init(context.getTheme());
    }

    private FocusRingDrawable(FocusRingState focusRingState, Resources resources) {
        super(null);
        this.paint = new Paint(1);
        this.tmpRectF = new RectF();
        this.tmpRect = new Rect();
        this.tmpPath = new Path();
        this.shapeAppearancePath = new Path();
        this.matrix = new Matrix();
        this.pathProvider = ShapeAppearancePathProvider.getInstanceOrCreate();
        this.shapeAppearanceCornerSize = -1.0f;
        this.interpolation = 1.0f;
        this.focused = false;
        this.mutated = false;
        this.state = new FocusRingState(focusRingState);
        if (this.state.wrappedState != null) {
            setDrawable(resources != null ? this.state.wrappedState.newDrawable(resources) : this.state.wrappedState.newDrawable());
        }
        updateLocalState();
    }

    /* synthetic */ FocusRingDrawable(FocusRingState focusRingState, Resources resources, AnonymousClass1 anonymousClass1) {
        this(focusRingState, resources);
    }

    static /* synthetic */ float access$000(FocusRingDrawable focusRingDrawable) {
        return focusRingDrawable.interpolation;
    }

    static /* synthetic */ float access$002(FocusRingDrawable focusRingDrawable, float f) {
        focusRingDrawable.interpolation = f;
        return f;
    }

    static /* synthetic */ int[] access$2300() {
        return FOCUSED_STATE_SET;
    }

    private void calculateBounds(RectF rectF) {
        if (FocusRingState.access$2200(this.state) != null) {
            rectF.set(FocusRingState.access$2200(this.state));
            return;
        }
        if (this.materialShapeDrawable != null && this.materialShapeDrawable.get() != null) {
            rectF.set(this.materialShapeDrawable.get().getBounds());
            return;
        }
        if (!(getDrawable() instanceof RippleDrawable)) {
            rectF.set(getBounds());
            return;
        }
        RippleDrawable rippleDrawable = (RippleDrawable) getDrawable();
        rippleDrawable.getHotspotBounds(this.tmpRect);
        int radius = rippleDrawable.getRadius();
        if (radius > 0) {
            this.tmpRect.inset(Math.max(0, (this.tmpRect.width() / 2) - radius), Math.max(0, (this.tmpRect.height() / 2) - radius));
        }
        rectF.set(this.tmpRect);
    }

    private float calculateInnerInset() {
        return FocusRingState.access$1500(this.state) + FocusRingState.access$1700(this.state) + ((FocusRingState.access$1100(this.state) / 2.0f) * this.interpolation);
    }

    private float calculateInnerRadius(float f) {
        return Math.max(0.0f, f - (FocusRingState.access$900(this.state) / 2.0f));
    }

    private float calculateOuterInset() {
        return FocusRingState.access$1500(this.state) + ((FocusRingState.access$900(this.state) / 2.0f) * this.interpolation);
    }

    private float calculateOuterRadius() {
        int radius;
        if (!Float.isNaN(FocusRingState.access$1300(this.state))) {
            return FocusRingState.access$1300(this.state);
        }
        if (this.shapeAppearanceCornerSize >= 0.0f) {
            return this.shapeAppearanceCornerSize;
        }
        if (this.materialShapeDrawable != null && this.materialShapeDrawable.get() != null) {
            float calculateRoundRectCornerSize = this.materialShapeDrawable.get().calculateRoundRectCornerSize();
            if (calculateRoundRectCornerSize >= 0.0f) {
                return Math.max(0.0f, calculateRoundRectCornerSize - (FocusRingState.access$900(this.state) / 2.0f));
            }
        }
        Drawable drawable = getDrawable();
        if (!(drawable instanceof RippleDrawable) || (radius = ((RippleDrawable) drawable).getRadius()) < 0) {
            return 0.0f;
        }
        return radius;
    }

    private void calculateShapeAppearanceRoundRectOrPath() {
        if (FocusRingState.access$2000(this.state) != null) {
            updateShapeAppearanceCornerSizeOrPath(FocusRingState.access$2000(this.state));
        } else {
            if (updateFocusRingShapeAppearanceFromWrappedDrawable()) {
                return;
            }
            this.shapeAppearanceCornerSize = -1.0f;
            this.shapeAppearancePath.reset();
        }
    }

    private ObjectAnimator createAnimator() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, PROPERTY_INTERPOLATION, 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.setInterpolator(INTERPOLATOR);
        ofFloat.addListener(new AnonymousClass2());
        return ofFloat;
    }

    private void drawPath(Canvas canvas, Path path, float f, float f2, int i) {
        calculateBounds(this.tmpRectF);
        float width = 1.0f - ((f * 2.0f) / this.tmpRectF.width());
        float height = 1.0f - ((2.0f * f) / this.tmpRectF.height());
        this.matrix.reset();
        this.matrix.postScale(width, height, this.tmpRectF.centerX(), this.tmpRectF.centerY());
        path.transform(this.matrix, this.tmpPath);
        this.paint.setStrokeWidth(this.interpolation * f2);
        this.paint.setColor(i);
        canvas.drawPath(this.tmpPath, this.paint);
    }

    private void drawRoundRect(Canvas canvas, float f, float f2, float f3, int i) {
        calculateBounds(this.tmpRectF);
        this.tmpRectF.inset(f2, f2);
        this.paint.setStrokeWidth(this.interpolation * f3);
        this.paint.setColor(i);
        canvas.drawRoundRect(this.tmpRectF, f, f, this.paint);
    }

    public static FocusRingDrawable find(Drawable drawable) {
        if (drawable instanceof FocusRingDrawable) {
            return (FocusRingDrawable) drawable;
        }
        if (drawable instanceof DrawableWrapper) {
            Drawable drawable2 = ((DrawableWrapper) drawable).getDrawable();
            if (drawable2 instanceof FocusRingDrawable) {
                return (FocusRingDrawable) drawable2;
            }
        }
        if (!(drawable instanceof LayerDrawable)) {
            return null;
        }
        LayerDrawable layerDrawable = (LayerDrawable) drawable;
        for (int i = 0; i < layerDrawable.getNumberOfLayers(); i++) {
            Drawable drawable3 = layerDrawable.getDrawable(i);
            if (drawable3 instanceof FocusRingDrawable) {
                return (FocusRingDrawable) drawable3;
            }
        }
        return null;
    }

    public static FocusRingDrawable findAndMutate(Drawable drawable) {
        if (drawable == null || find(drawable) == null) {
            return null;
        }
        drawable.mutate();
        return find(drawable);
    }

    private float[] getCornerRadiiOrNull(GradientDrawable gradientDrawable) {
        try {
            return gradientDrawable.getCornerRadii();
        } catch (NullPointerException e) {
            return null;
        }
    }

    private float getCornerRadius(GradientDrawable gradientDrawable) {
        try {
            return gradientDrawable.getCornerRadius();
        } catch (NullPointerException e) {
            return -1.0f;
        }
    }

    private Path getNonEmptyPath() {
        if (!this.shapeAppearancePath.isEmpty()) {
            return this.shapeAppearancePath;
        }
        if (this.materialShapeDrawable == null || this.materialShapeDrawable.get() == null) {
            return null;
        }
        Path path = this.materialShapeDrawable.get().getPath();
        if (path.isEmpty()) {
            return null;
        }
        return path;
    }

    private int getResIdIfReference(TypedArray typedArray, int i) {
        if (typedArray.getType(i) == 1) {
            return typedArray.getResourceId(i, Integer.MIN_VALUE);
        }
        return Integer.MIN_VALUE;
    }

    private int getValueDataIfAttr(TypedArray typedArray, int i) {
        if (typedArray.getType(i) != 2) {
            return Integer.MIN_VALUE;
        }
        TypedValue typedValue = new TypedValue();
        if (typedArray.getValue(i, typedValue)) {
            return typedValue.data;
        }
        return Integer.MIN_VALUE;
    }

    private void inflateChildDrawable(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = null;
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if (next == 1 || (next == 3 && xmlPullParser.getDepth() <= depth)) {
                break;
            } else if (next == 2) {
                drawable = Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
            }
        }
        if (drawable != null) {
            setDrawable(drawable);
            this.state.wrappedState = drawable.getConstantState();
        } else {
            setDrawable(EMPTY_DRAWABLE);
            this.state.wrappedState = EMPTY_DRAWABLE.getConstantState();
        }
    }

    private void init(Resources.Theme theme) {
        int i = Build.VERSION.SDK_INT;
        TypedArray obtainStyledAttributes = theme.obtainStyledAttributes(com.google.android.material.R.styleable.FocusRingDrawable);
        updateStateFromTypedArrayWithThemeAttrsAndDefaults(obtainStyledAttributes, theme);
        obtainStyledAttributes.recycle();
        updateLocalState();
    }

    public static FocusRingDrawable layer(Context context, LayerDrawable layerDrawable) {
        return layer(context, layerDrawable, null);
    }

    public static FocusRingDrawable layer(Context context, LayerDrawable layerDrawable, MaterialShapeDrawable materialShapeDrawable) {
        if (!shouldUseFocusRing(context)) {
            return null;
        }
        FocusRingDrawable focusRingDrawable = new FocusRingDrawable(context, EMPTY_DRAWABLE);
        if (materialShapeDrawable != null) {
            focusRingDrawable.setFocusRingMaterialShapeDrawable(materialShapeDrawable);
        }
        layerDrawable.addLayer(focusRingDrawable);
        focusRingDrawable.setCallback(layerDrawable);
        return focusRingDrawable;
    }

    private void maybeAnimate(boolean z) {
        if (this.animator != null) {
            this.animator.cancel();
            this.animator = null;
        }
        if (!z) {
            this.interpolation = 1.0f;
            return;
        }
        int i = Build.VERSION.SDK_INT;
        this.animator = createAnimator();
        this.animator.start();
    }

    private int maybeResolveColor(int i, Resources.Theme theme, int i2, TypedArray typedArray, int i3, int i4) {
        if (i != Integer.MIN_VALUE) {
            return i;
        }
        if (i2 != Integer.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (theme.resolveAttribute(i2, typedValue, true)) {
                return typedValue.data;
            }
        }
        return typedArray.getColor(i3, i4);
    }

    private float maybeResolveDimension(float f, Resources.Theme theme, int i, TypedArray typedArray, int i2, int i3) {
        if (!Float.isNaN(f)) {
            return f;
        }
        Resources resources = theme.getResources();
        if (i != Float.MIN_VALUE) {
            TypedValue typedValue = new TypedValue();
            if (theme.resolveAttribute(i, typedValue, true)) {
                return typedValue.getDimension(resources.getDisplayMetrics());
            }
        }
        float dimension = typedArray.getDimension(i2, Float.NaN);
        if (!Float.isNaN(dimension)) {
            return dimension;
        }
        if (i3 != 0) {
            return resources.getDimension(i3);
        }
        return Float.NaN;
    }

    private static boolean shouldUseFocusRing(Context context) {
        int i = Build.VERSION.SDK_INT;
        return MaterialAttributes.resolveBoolean(context.getTheme(), com.google.android.material.R.attr.focusRingsEnabled, false);
    }

    private ShapeAppearance toShapeAppearance(Drawable drawable) {
        if (drawable instanceof ShapeDrawable) {
            return toShapeAppearance((ShapeDrawable) drawable);
        }
        if (drawable instanceof GradientDrawable) {
            return toShapeAppearance((GradientDrawable) drawable);
        }
        return null;
    }

    private ShapeAppearance toShapeAppearance(GradientDrawable gradientDrawable) {
        int i = Build.VERSION.SDK_INT;
        float[] cornerRadiiOrNull = getCornerRadiiOrNull(gradientDrawable);
        if (cornerRadiiOrNull != null) {
            return ShapeAppearanceModel.builder().setTopLeftCornerSize(Math.min(cornerRadiiOrNull[0], cornerRadiiOrNull[1])).setTopRightCornerSize(Math.min(cornerRadiiOrNull[2], cornerRadiiOrNull[3])).setBottomRightCornerSize(Math.min(cornerRadiiOrNull[4], cornerRadiiOrNull[5])).setBottomLeftCornerSize(Math.min(cornerRadiiOrNull[6], cornerRadiiOrNull[7])).build();
        }
        float cornerRadius = getCornerRadius(gradientDrawable);
        if (cornerRadius > 0.0f) {
            return ShapeAppearanceModel.builder().setAllCornerSizes(cornerRadius).build();
        }
        return null;
    }

    private ShapeAppearance toShapeAppearance(ShapeDrawable shapeDrawable) {
        int i = Build.VERSION.SDK_INT;
        Outline outline = new Outline();
        shapeDrawable.getOutline(outline);
        if (outline.getRadius() > 0.0f) {
            return ShapeAppearanceModel.builder().setAllCornerSizes(outline.getRadius()).build();
        }
        return null;
    }

    private void updateLocalState() {
        this.paint.setStyle(Paint.Style.STROKE);
        if (Float.isNaN(FocusRingState.access$900(this.state))) {
            return;
        }
        this.paint.setStrokeWidth(FocusRingState.access$900(this.state));
    }

    private void updateShapeAppearanceCornerSizeOrPath(ShapeAppearance shapeAppearance) {
        calculateBounds(this.tmpRectF);
        ShapeAppearanceModel shapeForState = shapeAppearance.getShapeForState(FOCUSED_STATE_SET);
        if (!shapeForState.isRoundRect(this.tmpRectF)) {
            this.pathProvider.calculatePath(shapeForState, null, 1.0f, this.tmpRectF, null, this.shapeAppearancePath);
            this.shapeAppearanceCornerSize = -1.0f;
        } else {
            float calculateOuterInset = calculateOuterInset();
            this.tmpRectF.inset(calculateOuterInset, calculateOuterInset);
            this.shapeAppearanceCornerSize = shapeForState.getTopLeftCornerSize().getCornerSize(this.tmpRectF);
            this.shapeAppearancePath.reset();
        }
    }

    private void updateStateFromTypedArrayWithThemeAttrsAndDefaults(TypedArray typedArray, Resources.Theme theme) {
        TypedValue resolve;
        if (FocusRingState.access$100(this.state) != Integer.MIN_VALUE && (resolve = MaterialAttributes.resolve(theme, FocusRingState.access$100(this.state))) != null) {
            FocusRingState.access$202(this.state, resolve.data != 0);
            FocusRingState.access$302(this.state, true);
        }
        if (!FocusRingState.access$300(this.state)) {
            FocusRingState.access$202(this.state, MaterialAttributes.resolveBoolean(theme, com.google.android.material.R.attr.focusRingsEnabled, FocusRingState.access$200(this.state)));
        }
        if (FocusRingState.access$200(this.state)) {
            FocusRingState.access$502(this.state, maybeResolveColor(FocusRingState.access$500(this.state), theme, FocusRingState.access$400(this.state), typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsOuterStrokeColor, ViewCompat.MEASURED_STATE_MASK));
            FocusRingState.access$702(this.state, maybeResolveColor(FocusRingState.access$700(this.state), theme, FocusRingState.access$600(this.state), typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeColor, -1));
            FocusRingState.access$902(this.state, maybeResolveDimension(FocusRingState.access$900(this.state), theme, FocusRingState.access$800(this.state), typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsOuterStrokeWidth, com.google.android.material.R.dimen.mtrl_focus_ring_outer_stroke_width));
            FocusRingState.access$1102(this.state, maybeResolveDimension(FocusRingState.access$1100(this.state), theme, FocusRingState.access$1000(this.state), typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeWidth, com.google.android.material.R.dimen.mtrl_focus_ring_inner_stroke_width));
            FocusRingState.access$1302(this.state, maybeResolveDimension(FocusRingState.access$1300(this.state), theme, FocusRingState.access$1200(this.state), typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsRadius, 0));
            FocusRingState.access$1502(this.state, maybeResolveDimension(FocusRingState.access$1500(this.state), theme, FocusRingState.access$1400(this.state), typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInset, 0));
            if (Float.isNaN(FocusRingState.access$1500(this.state))) {
                FocusRingState.access$1502(this.state, 0.0f);
            }
            FocusRingState.access$1702(this.state, maybeResolveDimension(FocusRingState.access$1700(this.state), theme, FocusRingState.access$1600(this.state), typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeInset, com.google.android.material.R.dimen.mtrl_focus_ring_inner_stroke_inset));
            if (FocusRingState.access$1900(this.state) != Integer.MIN_VALUE) {
                FocusRingState.access$2002(this.state, ShapeAppearanceModel.builder(theme, FocusRingState.access$1900(this.state)).build());
                return;
            }
            TypedValue resolve2 = MaterialAttributes.resolve(theme, FocusRingState.access$1800(this.state) != Integer.MIN_VALUE ? FocusRingState.access$1800(this.state) : com.google.android.material.R.attr.focusRingsShapeAppearance);
            if (resolve2 != null) {
                FocusRingState.access$2002(this.state, ShapeAppearanceModel.builder(theme, resolve2.resourceId).build());
            }
        }
    }

    private void updateStateFromTypedArrayWithoutThemeAttrsOrDefaults(TypedArray typedArray) {
        FocusRingState.access$102(this.state, getValueDataIfAttr(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsEnabled));
        if (FocusRingState.access$100(this.state) == Integer.MIN_VALUE && typedArray.hasValue(com.google.android.material.R.styleable.FocusRingDrawable_focusRingsEnabled)) {
            FocusRingState.access$202(this.state, typedArray.getBoolean(com.google.android.material.R.styleable.FocusRingDrawable_focusRingsEnabled, FocusRingState.access$200(this.state)));
            FocusRingState.access$302(this.state, true);
        }
        FocusRingState.access$402(this.state, getValueDataIfAttr(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsOuterStrokeColor));
        if (FocusRingState.access$400(this.state) == Integer.MIN_VALUE) {
            FocusRingState.access$502(this.state, typedArray.getColor(com.google.android.material.R.styleable.FocusRingDrawable_focusRingsOuterStrokeColor, Integer.MIN_VALUE));
        }
        FocusRingState.access$602(this.state, getValueDataIfAttr(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeColor));
        if (FocusRingState.access$600(this.state) == Integer.MIN_VALUE) {
            FocusRingState.access$702(this.state, typedArray.getColor(com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeColor, Integer.MIN_VALUE));
        }
        FocusRingState.access$802(this.state, getValueDataIfAttr(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsOuterStrokeWidth));
        if (FocusRingState.access$800(this.state) == Integer.MIN_VALUE) {
            FocusRingState.access$902(this.state, typedArray.getDimension(com.google.android.material.R.styleable.FocusRingDrawable_focusRingsOuterStrokeWidth, Float.NaN));
        }
        FocusRingState.access$1002(this.state, getValueDataIfAttr(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeWidth));
        if (FocusRingState.access$1000(this.state) == Integer.MIN_VALUE) {
            FocusRingState.access$1102(this.state, typedArray.getDimension(com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeWidth, Float.NaN));
        }
        FocusRingState.access$1002(this.state, getValueDataIfAttr(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeWidth));
        if (FocusRingState.access$1000(this.state) == Integer.MIN_VALUE) {
            FocusRingState.access$1102(this.state, typedArray.getDimension(com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeWidth, Float.NaN));
        }
        FocusRingState.access$1202(this.state, getValueDataIfAttr(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsRadius));
        if (FocusRingState.access$1200(this.state) == Integer.MIN_VALUE) {
            FocusRingState.access$1302(this.state, typedArray.getDimension(com.google.android.material.R.styleable.FocusRingDrawable_focusRingsRadius, Float.NaN));
        }
        FocusRingState.access$1402(this.state, getValueDataIfAttr(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInset));
        if (FocusRingState.access$1400(this.state) == Integer.MIN_VALUE) {
            FocusRingState.access$1502(this.state, typedArray.getDimension(com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInset, Float.NaN));
        }
        FocusRingState.access$1602(this.state, getValueDataIfAttr(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeInset));
        if (FocusRingState.access$1600(this.state) == Integer.MIN_VALUE) {
            FocusRingState.access$1702(this.state, typedArray.getDimension(com.google.android.material.R.styleable.FocusRingDrawable_focusRingsInnerStrokeInset, Float.NaN));
        }
        FocusRingState.access$1802(this.state, getValueDataIfAttr(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsShapeAppearance));
        FocusRingState.access$1902(this.state, getResIdIfReference(typedArray, com.google.android.material.R.styleable.FocusRingDrawable_focusRingsShapeAppearance));
    }

    public static Drawable wrap(Context context, Drawable drawable) {
        return !shouldUseFocusRing(context) ? drawable : new FocusRingDrawable(context, drawable);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        init(theme);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean canApplyTheme() {
        return true;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (FocusRingState.access$200(this.state) && this.focused) {
            float calculateOuterInset = calculateOuterInset();
            float calculateInnerInset = calculateInnerInset();
            Path nonEmptyPath = getNonEmptyPath();
            if (nonEmptyPath != null) {
                drawPath(canvas, nonEmptyPath, calculateInnerInset, FocusRingState.access$1100(this.state), FocusRingState.access$700(this.state));
                drawPath(canvas, nonEmptyPath, calculateOuterInset, FocusRingState.access$900(this.state), FocusRingState.access$500(this.state));
            } else {
                float calculateOuterRadius = calculateOuterRadius();
                drawRoundRect(canvas, calculateInnerRadius(calculateOuterRadius), calculateInnerInset, FocusRingState.access$1100(this.state), FocusRingState.access$700(this.state));
                drawRoundRect(canvas, calculateOuterRadius, calculateOuterInset, FocusRingState.access$900(this.state), FocusRingState.access$500(this.state));
            }
        }
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        if (!this.state.canConstantState()) {
            return null;
        }
        this.state.mChangingConfigurations = getChangingConfigurations();
        return this.state;
    }

    public Rect getFocusRingBounds() {
        return FocusRingState.access$2200(this.state);
    }

    public float getFocusRingInnerInset() {
        return FocusRingState.access$1700(this.state);
    }

    public int getFocusRingInnerStrokeColor() {
        return FocusRingState.access$700(this.state);
    }

    public float getFocusRingInnerStrokeWidth() {
        return FocusRingState.access$1100(this.state);
    }

    public float getFocusRingInset() {
        return FocusRingState.access$1500(this.state);
    }

    public MaterialShapeDrawable getFocusRingMaterialShapeDrawable() {
        if (this.materialShapeDrawable != null) {
            return this.materialShapeDrawable.get();
        }
        return null;
    }

    public int getFocusRingOuterStrokeColor() {
        return FocusRingState.access$500(this.state);
    }

    public float getFocusRingOuterStrokeWidth() {
        return FocusRingState.access$900(this.state);
    }

    public float getFocusRingRadius() {
        return FocusRingState.access$1300(this.state);
    }

    public ShapeAppearance getFocusRingShapeAppearance() {
        return FocusRingState.access$2000(this.state);
    }

    public int[] getFocusRingStateSet() {
        return FocusRingState.access$2100(this.state);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean hasFocusStateSpecified() {
        try {
            if (!super.hasFocusStateSpecified()) {
                if (!FocusRingState.access$200(this.state)) {
                    return false;
                }
            }
            return true;
        } catch (NoSuchMethodError e) {
            return FocusRingState.access$200(this.state);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws IOException, XmlPullParserException {
        inflate(resources, xmlPullParser, attributeSet, null);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        super.inflate(resources, xmlPullParser, attributeSet, theme);
        TypedArray obtainStyledAttributes = theme != null ? theme.obtainStyledAttributes(attributeSet, com.google.android.material.R.styleable.FocusRingDrawable, 0, 0) : resources.obtainAttributes(attributeSet, com.google.android.material.R.styleable.FocusRingDrawable);
        updateStateFromTypedArrayWithoutThemeAttrsOrDefaults(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
        inflateChildDrawable(resources, xmlPullParser, attributeSet, theme);
    }

    public boolean isFocusRingEnabled() {
        return FocusRingState.access$200(this.state);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isProjected() {
        Drawable drawable = getDrawable();
        return drawable != null && drawable.isProjected();
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public boolean isStateful() {
        return super.isStateful() || FocusRingState.access$200(this.state);
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        if (this.animator != null) {
            this.animator.end();
            this.animator = null;
        }
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    public Drawable mutate() {
        if (!this.mutated && super.mutate() == this) {
            this.state = new FocusRingState(this.state);
            Drawable drawable = getDrawable();
            if (drawable != null) {
                this.state.wrappedState = drawable.getConstantState();
            }
            this.mutated = true;
        }
        return this;
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        if (FocusRingState.access$200(this.state)) {
            calculateShapeAppearanceRoundRectOrPath();
        }
    }

    @Override // android.graphics.drawable.DrawableWrapper, android.graphics.drawable.Drawable
    protected boolean onStateChange(int[] iArr) {
        if (!FocusRingState.access$200(this.state)) {
            this.focused = false;
            return super.onStateChange(iArr);
        }
        boolean stateSetMatches = StateSet.stateSetMatches(FocusRingState.access$2100(this.state), iArr);
        boolean z = this.focused != stateSetMatches;
        this.focused = stateSetMatches;
        if (z && iArr.length > 0 && !this.previousStateSetEmpty) {
            maybeAnimate(stateSetMatches);
        }
        this.previousStateSetEmpty = iArr.length == 0;
        return super.onStateChange(iArr) || z;
    }

    public void setFocusRingBounds(int i, int i2, int i3, int i4) {
        if (FocusRingState.access$2200(this.state) == null) {
            FocusRingState.access$2202(this.state, new Rect());
        }
        FocusRingState.access$2200(this.state).set(i, i2, i3, i4);
    }

    public void setFocusRingBounds(Rect rect) {
        FocusRingState.access$2202(this.state, rect);
    }

    public void setFocusRingEnabled(boolean z) {
        FocusRingState.access$202(this.state, z);
    }

    public void setFocusRingInnerInset(float f) {
        FocusRingState.access$1702(this.state, f);
    }

    public void setFocusRingInnerStrokeColor(int i) {
        FocusRingState.access$702(this.state, i);
    }

    public void setFocusRingInnerStrokeWidth(float f) {
        FocusRingState.access$1102(this.state, f);
    }

    public void setFocusRingInset(float f) {
        FocusRingState.access$1502(this.state, f);
    }

    public void setFocusRingMaterialShapeDrawable(MaterialShapeDrawable materialShapeDrawable) {
        this.materialShapeDrawable = new WeakReference<>(materialShapeDrawable);
    }

    public void setFocusRingOuterStrokeColor(int i) {
        FocusRingState.access$502(this.state, i);
    }

    public void setFocusRingOuterStrokeWidth(float f) {
        FocusRingState.access$902(this.state, f);
    }

    public void setFocusRingRadius(float f) {
        FocusRingState.access$1302(this.state, f);
    }

    public void setFocusRingShapeAppearance(ShapeAppearance shapeAppearance) {
        FocusRingState.access$2002(this.state, shapeAppearance);
    }

    public void setFocusRingStateSet(int[] iArr) {
        FocusRingState.access$2102(this.state, iArr);
    }

    public boolean updateFocusRingShapeAppearanceFromWrappedDrawable() {
        ShapeAppearance shapeAppearance = toShapeAppearance(getDrawable());
        if (shapeAppearance == null) {
            return false;
        }
        updateShapeAppearanceCornerSizeOrPath(shapeAppearance);
        return true;
    }
}
