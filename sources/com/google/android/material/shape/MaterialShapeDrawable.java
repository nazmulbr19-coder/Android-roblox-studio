package com.google.android.material.shape;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.dynamicanimation.animation.FloatPropertyCompat;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.math.MathUtils;
import com.google.android.material.shadow.ShadowRenderer;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeAppearancePathProvider;
import com.google.android.material.shape.ShapePath;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.BitSet;

/* loaded from: classes.dex */
public class MaterialShapeDrawable extends Drawable implements TintAwareDrawable, Shapeable {
    private static final SpringAnimatedCornerSizeProperty[] CORNER_SIZES_IN_PX;
    public static final int SHADOW_COMPAT_MODE_ALWAYS = 2;
    public static final int SHADOW_COMPAT_MODE_DEFAULT = 0;
    public static final int SHADOW_COMPAT_MODE_NEVER = 1;
    private static final float SHADOW_OFFSET_MULTIPLIER = 0.25f;
    private static final float SHADOW_RADIUS_MULTIPLIER = 0.75f;
    private final BitSet containsIncompatibleShadowOp;
    private final ShapePath.ShadowCompatOperation[] cornerShadowOperation;
    SpringAnimation[] cornerSpringAnimations;
    private SpringForce cornerSpringForce;
    private MaterialShapeDrawableState drawableState;
    private final ShapePath.ShadowCompatOperation[] edgeShadowOperation;
    private final Paint fillPaint;
    private final RectF insetRectF;
    private boolean isRoundRectCornerMorph;
    private final Matrix matrix;
    private OnCornerSizeChangeListener onCornerSizeChangeListener;
    private final Path path;
    private final RectF pathBounds;
    private boolean pathDirty;
    private final Path pathInsetByStroke;
    private final ShapeAppearancePathProvider pathProvider;
    private final ShapeAppearancePathProvider.PathListener pathShadowListener;
    private final RectF rectF;
    private int resolvedTintColor;
    private final Region scratchRegion;
    private boolean shadowBitmapDrawingEnable;
    private final ShadowRenderer shadowRenderer;
    private float[] springAnimatedCornerSizes;
    private float[] springAnimatedStrokeCornerSizes;
    private final ShapeAppearanceModel.CornerSizeUnaryOperator strokeInsetCornerSizeUnaryOperator;
    private final Paint strokePaint;
    private boolean strokePathDirty;
    private ShapeAppearanceModel strokeShapeAppearanceModel;
    private PorterDuffColorFilter strokeTintFilter;
    private PorterDuffColorFilter tintFilter;
    private final Region transparentRegion;
    private static final String TAG = MaterialShapeDrawable.class.getSimpleName();
    static final ShapeAppearanceModel DEFAULT_INTERPOLATION_START_SHAPE_APPEARANCE_MODEL = ShapeAppearanceModel.builder().setAllCorners(0, 0.0f).build();
    private static final Paint clearPaint = new Paint(1);

    /* renamed from: com.google.android.material.shape.MaterialShapeDrawable$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements ShapeAppearanceModel.CornerSizeUnaryOperator {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.shape.ShapeAppearanceModel.CornerSizeUnaryOperator
        public CornerSize apply(CornerSize cornerSize) {
            return cornerSize instanceof RelativeCornerSize ? cornerSize : new AdjustedCornerSize(-MaterialShapeDrawable.access$000(MaterialShapeDrawable.this), cornerSize);
        }
    }

    /* renamed from: com.google.android.material.shape.MaterialShapeDrawable$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements ShapeAppearancePathProvider.PathListener {
        AnonymousClass2() {
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
        public void onCornerPathCreated(ShapePath shapePath, Matrix matrix, int i) {
            MaterialShapeDrawable.access$100(MaterialShapeDrawable.this).set(i, shapePath.containsIncompatibleShadowOp());
            MaterialShapeDrawable.access$200(MaterialShapeDrawable.this)[i] = shapePath.createShadowCompatOperation(matrix);
        }

        @Override // com.google.android.material.shape.ShapeAppearancePathProvider.PathListener
        public void onEdgePathCreated(ShapePath shapePath, Matrix matrix, int i) {
            MaterialShapeDrawable.access$100(MaterialShapeDrawable.this).set(i + 4, shapePath.containsIncompatibleShadowOp());
            MaterialShapeDrawable.access$300(MaterialShapeDrawable.this)[i] = shapePath.createShadowCompatOperation(matrix);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface CompatibilityShadowMode {
    }

    /* loaded from: classes.dex */
    protected static class MaterialShapeDrawableState extends Drawable.ConstantState {
        int alpha;
        ColorFilter colorFilter;
        float elevation;
        ElevationOverlayProvider elevationOverlayProvider;
        ColorStateList fillColor;
        float interpolation;
        Rect padding;
        Paint.Style paintStyle;
        float parentAbsoluteElevation;
        float scale;
        int shadowCompatMode;
        int shadowCompatOffset;
        int shadowCompatRadius;
        int shadowCompatRotation;
        ShapeAppearance shapeAppearance;
        ColorStateList strokeColor;
        ColorStateList strokeTintList;
        float strokeWidth;
        ColorStateList tintList;
        PorterDuff.Mode tintMode;
        float translationZ;
        boolean useTintColorForShadow;

        public MaterialShapeDrawableState(MaterialShapeDrawableState materialShapeDrawableState) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearance = materialShapeDrawableState.shapeAppearance;
            this.elevationOverlayProvider = materialShapeDrawableState.elevationOverlayProvider;
            this.strokeWidth = materialShapeDrawableState.strokeWidth;
            this.colorFilter = materialShapeDrawableState.colorFilter;
            this.fillColor = materialShapeDrawableState.fillColor;
            this.strokeColor = materialShapeDrawableState.strokeColor;
            this.tintMode = materialShapeDrawableState.tintMode;
            this.tintList = materialShapeDrawableState.tintList;
            this.alpha = materialShapeDrawableState.alpha;
            this.scale = materialShapeDrawableState.scale;
            this.shadowCompatOffset = materialShapeDrawableState.shadowCompatOffset;
            this.shadowCompatMode = materialShapeDrawableState.shadowCompatMode;
            this.useTintColorForShadow = materialShapeDrawableState.useTintColorForShadow;
            this.interpolation = materialShapeDrawableState.interpolation;
            this.parentAbsoluteElevation = materialShapeDrawableState.parentAbsoluteElevation;
            this.elevation = materialShapeDrawableState.elevation;
            this.translationZ = materialShapeDrawableState.translationZ;
            this.shadowCompatRadius = materialShapeDrawableState.shadowCompatRadius;
            this.shadowCompatRotation = materialShapeDrawableState.shadowCompatRotation;
            this.strokeTintList = materialShapeDrawableState.strokeTintList;
            this.paintStyle = materialShapeDrawableState.paintStyle;
            if (materialShapeDrawableState.padding != null) {
                this.padding = new Rect(materialShapeDrawableState.padding);
            }
        }

        public MaterialShapeDrawableState(ShapeAppearance shapeAppearance, ElevationOverlayProvider elevationOverlayProvider) {
            this.fillColor = null;
            this.strokeColor = null;
            this.strokeTintList = null;
            this.tintList = null;
            this.tintMode = PorterDuff.Mode.SRC_IN;
            this.padding = null;
            this.scale = 1.0f;
            this.interpolation = 1.0f;
            this.alpha = 255;
            this.parentAbsoluteElevation = 0.0f;
            this.elevation = 0.0f;
            this.translationZ = 0.0f;
            this.shadowCompatMode = 0;
            this.shadowCompatRadius = 0;
            this.shadowCompatOffset = 0;
            this.shadowCompatRotation = 0;
            this.useTintColorForShadow = false;
            this.paintStyle = Paint.Style.FILL_AND_STROKE;
            this.shapeAppearance = shapeAppearance;
            this.elevationOverlayProvider = elevationOverlayProvider;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public int getChangingConfigurations() {
            return 0;
        }

        @Override // android.graphics.drawable.Drawable.ConstantState
        public Drawable newDrawable() {
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(this);
            MaterialShapeDrawable.access$602(materialShapeDrawable, true);
            MaterialShapeDrawable.access$702(materialShapeDrawable, true);
            return materialShapeDrawable;
        }
    }

    /* loaded from: classes.dex */
    public interface OnCornerSizeChangeListener {
        void onCornerSizeChange(float f);
    }

    /* loaded from: classes.dex */
    private static class SpringAnimatedCornerSizeProperty extends FloatPropertyCompat<MaterialShapeDrawable> {
        private final int index;

        SpringAnimatedCornerSizeProperty(int i) {
            super("cornerSizeAtIndex" + i);
            this.index = i;
        }

        /* renamed from: getValue, reason: avoid collision after fix types in other method */
        public float getValue2(MaterialShapeDrawable materialShapeDrawable) {
            if (MaterialShapeDrawable.access$400(materialShapeDrawable) != null) {
                return MaterialShapeDrawable.access$400(materialShapeDrawable)[this.index];
            }
            return 0.0f;
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ float getValue(MaterialShapeDrawable materialShapeDrawable) {
            return getValue2(materialShapeDrawable);
        }

        /* renamed from: setValue, reason: avoid collision after fix types in other method */
        public void setValue2(MaterialShapeDrawable materialShapeDrawable, float f) {
            if (MaterialShapeDrawable.access$400(materialShapeDrawable) == null || MaterialShapeDrawable.access$400(materialShapeDrawable)[this.index] == f) {
                return;
            }
            MaterialShapeDrawable.access$400(materialShapeDrawable)[this.index] = f;
            if (MaterialShapeDrawable.access$500(materialShapeDrawable) != null) {
                MaterialShapeDrawable.access$500(materialShapeDrawable).onCornerSizeChange(materialShapeDrawable.getCornerSizeDiffX());
            }
            materialShapeDrawable.invalidateSelf();
        }

        @Override // androidx.dynamicanimation.animation.FloatPropertyCompat
        public /* bridge */ /* synthetic */ void setValue(MaterialShapeDrawable materialShapeDrawable, float f) {
            setValue2(materialShapeDrawable, f);
        }
    }

    static {
        clearPaint.setColor(-1);
        clearPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        CORNER_SIZES_IN_PX = new SpringAnimatedCornerSizeProperty[4];
        for (int i = 0; i < CORNER_SIZES_IN_PX.length; i++) {
            CORNER_SIZES_IN_PX[i] = new SpringAnimatedCornerSizeProperty(i);
        }
    }

    public MaterialShapeDrawable() {
        this(new ShapeAppearanceModel());
    }

    public MaterialShapeDrawable(Context context, AttributeSet attributeSet, int i, int i2) {
        this(ShapeAppearanceModel.builder(context, attributeSet, i, i2).build());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MaterialShapeDrawable(MaterialShapeDrawableState materialShapeDrawableState) {
        this.strokeInsetCornerSizeUnaryOperator = new AnonymousClass1();
        this.cornerShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.edgeShadowOperation = new ShapePath.ShadowCompatOperation[4];
        this.containsIncompatibleShadowOp = new BitSet(8);
        this.matrix = new Matrix();
        this.path = new Path();
        this.pathInsetByStroke = new Path();
        this.rectF = new RectF();
        this.insetRectF = new RectF();
        this.transparentRegion = new Region();
        this.scratchRegion = new Region();
        this.fillPaint = new Paint(1);
        this.strokePaint = new Paint(1);
        this.shadowRenderer = new ShadowRenderer();
        this.pathProvider = ShapeAppearancePathProvider.getInstanceOrCreate();
        this.pathBounds = new RectF();
        this.shadowBitmapDrawingEnable = true;
        this.isRoundRectCornerMorph = true;
        this.cornerSpringAnimations = new SpringAnimation[4];
        this.drawableState = materialShapeDrawableState;
        this.strokePaint.setStyle(Paint.Style.STROKE);
        this.fillPaint.setStyle(Paint.Style.FILL);
        updateTintFilter();
        updateColorsForState(getState());
        this.pathShadowListener = new AnonymousClass2();
    }

    public MaterialShapeDrawable(ShapeAppearance shapeAppearance) {
        this(new MaterialShapeDrawableState(shapeAppearance, null));
    }

    public MaterialShapeDrawable(ShapeAppearanceModel shapeAppearanceModel) {
        this(new MaterialShapeDrawableState(shapeAppearanceModel, null));
    }

    @Deprecated
    public MaterialShapeDrawable(ShapePathModel shapePathModel) {
        this((ShapeAppearanceModel) shapePathModel);
    }

    static /* synthetic */ float access$000(MaterialShapeDrawable materialShapeDrawable) {
        return materialShapeDrawable.getStrokeInsetLength();
    }

    static /* synthetic */ BitSet access$100(MaterialShapeDrawable materialShapeDrawable) {
        return materialShapeDrawable.containsIncompatibleShadowOp;
    }

    static /* synthetic */ ShapePath.ShadowCompatOperation[] access$200(MaterialShapeDrawable materialShapeDrawable) {
        return materialShapeDrawable.cornerShadowOperation;
    }

    static /* synthetic */ ShapePath.ShadowCompatOperation[] access$300(MaterialShapeDrawable materialShapeDrawable) {
        return materialShapeDrawable.edgeShadowOperation;
    }

    static /* synthetic */ float[] access$400(MaterialShapeDrawable materialShapeDrawable) {
        return materialShapeDrawable.springAnimatedCornerSizes;
    }

    static /* synthetic */ OnCornerSizeChangeListener access$500(MaterialShapeDrawable materialShapeDrawable) {
        return materialShapeDrawable.onCornerSizeChangeListener;
    }

    static /* synthetic */ boolean access$602(MaterialShapeDrawable materialShapeDrawable, boolean z) {
        materialShapeDrawable.pathDirty = z;
        return z;
    }

    static /* synthetic */ boolean access$702(MaterialShapeDrawable materialShapeDrawable, boolean z) {
        materialShapeDrawable.strokePathDirty = z;
        return z;
    }

    private PorterDuffColorFilter calculatePaintColorTintFilter(Paint paint, boolean z) {
        if (!z) {
            return null;
        }
        int color = paint.getColor();
        int compositeElevationOverlayIfNeeded = compositeElevationOverlayIfNeeded(color);
        this.resolvedTintColor = compositeElevationOverlayIfNeeded;
        if (compositeElevationOverlayIfNeeded != color) {
            return new PorterDuffColorFilter(compositeElevationOverlayIfNeeded, PorterDuff.Mode.SRC_IN);
        }
        return null;
    }

    private void calculatePath(RectF rectF, Path path) {
        calculatePathForSize(rectF, path);
        if (this.drawableState.scale != 1.0f) {
            this.matrix.reset();
            this.matrix.setScale(this.drawableState.scale, this.drawableState.scale, rectF.width() / 2.0f, rectF.height() / 2.0f);
            path.transform(this.matrix);
        }
        path.computeBounds(this.pathBounds, true);
    }

    private float calculateRoundRectCornerSize(RectF rectF, ShapeAppearanceModel shapeAppearanceModel, float[] fArr) {
        if (fArr == null) {
            if (shapeAppearanceModel.isRoundRect(rectF)) {
                return shapeAppearanceModel.getTopLeftCornerSize().getCornerSize(rectF);
            }
            return -1.0f;
        }
        if (this.isRoundRectCornerMorph) {
            return fArr[0];
        }
        return -1.0f;
    }

    private void calculateStrokePath() {
        this.pathProvider.calculatePath(this.strokeShapeAppearanceModel, this.springAnimatedStrokeCornerSizes, this.drawableState.interpolation, getBoundsInsetByStroke(), null, this.pathInsetByStroke);
    }

    private PorterDuffColorFilter calculateTintColorTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, boolean z) {
        int colorForState = colorStateList.getColorForState(getState(), 0);
        if (z) {
            colorForState = compositeElevationOverlayIfNeeded(colorForState);
        }
        this.resolvedTintColor = colorForState;
        return new PorterDuffColorFilter(colorForState, mode);
    }

    private PorterDuffColorFilter calculateTintFilter(ColorStateList colorStateList, PorterDuff.Mode mode, Paint paint, boolean z) {
        return (colorStateList == null || mode == null) ? calculatePaintColorTintFilter(paint, z) : calculateTintColorTintFilter(colorStateList, mode, z);
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context context) {
        return createWithElevationOverlay(context, 0.0f);
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context context, float f) {
        return createWithElevationOverlay(context, f, null);
    }

    public static MaterialShapeDrawable createWithElevationOverlay(Context context, float f, ColorStateList colorStateList) {
        if (colorStateList == null) {
            colorStateList = ColorStateList.valueOf(MaterialColors.getColor(context, R.attr.colorSurface, MaterialShapeDrawable.class.getSimpleName()));
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable();
        materialShapeDrawable.initializeElevationOverlay(context);
        materialShapeDrawable.setFillColor(colorStateList);
        materialShapeDrawable.setElevation(f);
        return materialShapeDrawable;
    }

    private void drawCompatShadow(Canvas canvas) {
        if (this.containsIncompatibleShadowOp.cardinality() > 0) {
            Log.w(TAG, "Compatibility shadow requested but can't be drawn for all operations in this shape.");
        }
        if (this.drawableState.shadowCompatOffset != 0) {
            canvas.drawPath(this.path, this.shadowRenderer.getShadowPaint());
        }
        for (int i = 0; i < 4; i++) {
            this.cornerShadowOperation[i].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
            this.edgeShadowOperation[i].draw(this.shadowRenderer, this.drawableState.shadowCompatRadius, canvas);
        }
        if (this.shadowBitmapDrawingEnable) {
            int shadowOffsetX = getShadowOffsetX();
            int shadowOffsetY = getShadowOffsetY();
            canvas.translate(-shadowOffsetX, -shadowOffsetY);
            canvas.drawPath(this.path, clearPaint);
            canvas.translate(shadowOffsetX, shadowOffsetY);
        }
    }

    private void drawFillShape(Canvas canvas) {
        drawShape(canvas, this.fillPaint, this.path, this.drawableState.shapeAppearance.getDefaultShape(), this.springAnimatedCornerSizes, getBoundsAsRectF());
    }

    private void drawShape(Canvas canvas, Paint paint, Path path, ShapeAppearanceModel shapeAppearanceModel, float[] fArr, RectF rectF) {
        float calculateRoundRectCornerSize = calculateRoundRectCornerSize(rectF, shapeAppearanceModel, fArr);
        if (calculateRoundRectCornerSize < 0.0f) {
            canvas.drawPath(path, paint);
        } else {
            float f = calculateRoundRectCornerSize * this.drawableState.interpolation;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    private RectF getBoundsInsetByStroke() {
        this.insetRectF.set(getBoundsAsRectF());
        float strokeInsetLength = getStrokeInsetLength();
        this.insetRectF.inset(strokeInsetLength, strokeInsetLength);
        return this.insetRectF;
    }

    private float getStrokeInsetLength() {
        if (hasStroke()) {
            return this.strokePaint.getStrokeWidth() / 2.0f;
        }
        return 0.0f;
    }

    private boolean hasCompatShadow() {
        return this.drawableState.shadowCompatMode != 1 && this.drawableState.shadowCompatRadius > 0 && (this.drawableState.shadowCompatMode == 2 || requiresCompatShadow());
    }

    private boolean hasFill() {
        return this.drawableState.paintStyle == Paint.Style.FILL_AND_STROKE || this.drawableState.paintStyle == Paint.Style.FILL;
    }

    private boolean hasStroke() {
        return (this.drawableState.paintStyle == Paint.Style.FILL_AND_STROKE || this.drawableState.paintStyle == Paint.Style.STROKE) && this.strokePaint.getStrokeWidth() > 0.0f;
    }

    private void invalidateSelfIgnoreShape() {
        super.invalidateSelf();
    }

    private boolean isCornerSpringAnimationRunning() {
        for (SpringAnimation springAnimation : this.cornerSpringAnimations) {
            if (springAnimation != null && springAnimation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    private void maybeDrawCompatShadow(Canvas canvas) {
        if (hasCompatShadow()) {
            canvas.save();
            prepareCanvasForShadow(canvas);
            if (!this.shadowBitmapDrawingEnable) {
                drawCompatShadow(canvas);
                canvas.restore();
                return;
            }
            Rect bounds = getBounds();
            int width = (int) (this.pathBounds.width() - bounds.width());
            int height = (int) (this.pathBounds.height() - bounds.height());
            if (width < 0 || height < 0) {
                throw new IllegalStateException("Invalid shadow bounds. Check that the treatments result in a valid path. extra width: " + width + " extra height: " + height + " path bounds: " + this.pathBounds);
            }
            Bitmap createBitmap = Bitmap.createBitmap(((int) this.pathBounds.width()) + (this.drawableState.shadowCompatRadius * 2) + width, ((int) this.pathBounds.height()) + (this.drawableState.shadowCompatRadius * 2) + height, Bitmap.Config.ARGB_8888);
            Canvas canvas2 = new Canvas(createBitmap);
            float f = (bounds.left - this.drawableState.shadowCompatRadius) - width;
            float f2 = (bounds.top - this.drawableState.shadowCompatRadius) - height;
            canvas2.translate(-f, -f2);
            drawCompatShadow(canvas2);
            canvas.drawBitmap(createBitmap, f, f2, (Paint) null);
            createBitmap.recycle();
            canvas.restore();
        }
    }

    private static int modulateAlpha(int i, int i2) {
        return (i * ((i2 >>> 7) + i2)) >>> 8;
    }

    private void prepareCanvasForShadow(Canvas canvas) {
        canvas.translate(getShadowOffsetX(), getShadowOffsetY());
    }

    private void setStateListShapeAppearanceModel(StateListShapeAppearanceModel stateListShapeAppearanceModel) {
        if (this.drawableState.shapeAppearance != stateListShapeAppearanceModel) {
            this.drawableState.shapeAppearance = stateListShapeAppearanceModel;
            updateShape(getState(), true);
            invalidateSelf();
        }
    }

    private boolean shouldCalculatePath() {
        return hasCompatShadow() || !isRoundRect();
    }

    private boolean updateColorsForState(int[] iArr) {
        int color;
        int colorForState;
        int color2;
        int colorForState2;
        boolean z = false;
        if (this.drawableState.fillColor != null && color2 != (colorForState2 = this.drawableState.fillColor.getColorForState(iArr, (color2 = this.fillPaint.getColor())))) {
            this.fillPaint.setColor(colorForState2);
            z = true;
        }
        if (this.drawableState.strokeColor == null || color == (colorForState = this.drawableState.strokeColor.getColorForState(iArr, (color = this.strokePaint.getColor())))) {
            return z;
        }
        this.strokePaint.setColor(colorForState);
        return true;
    }

    private void updateShape(int[] iArr) {
        updateShape(iArr, false);
    }

    private void updateShape(int[] iArr, boolean z) {
        RectF boundsAsRectF = getBoundsAsRectF();
        if (!this.drawableState.shapeAppearance.isStateful() || boundsAsRectF.isEmpty()) {
            return;
        }
        boolean z2 = false;
        boolean z3 = z | (this.cornerSpringForce == null);
        if (this.springAnimatedCornerSizes == null) {
            this.springAnimatedCornerSizes = new float[4];
        }
        ShapeAppearanceModel shapeForState = this.drawableState.shapeAppearance.getShapeForState(iArr);
        if (MathUtils.areAllElementsEqual(this.springAnimatedCornerSizes) && shapeForState.isRoundRect(getBoundsAsRectF())) {
            z2 = true;
        }
        this.isRoundRectCornerMorph = z2;
        if (!this.isRoundRectCornerMorph) {
            this.pathDirty = true;
            this.strokePathDirty = true;
        }
        for (int i = 0; i < 4; i++) {
            float cornerSize = this.pathProvider.getCornerSizeForIndex(i, shapeForState).getCornerSize(boundsAsRectF);
            if (z3) {
                this.springAnimatedCornerSizes[i] = cornerSize;
            }
            if (this.cornerSpringAnimations[i] != null) {
                this.cornerSpringAnimations[i].animateToFinalPosition(cornerSize);
                if (z3) {
                    this.cornerSpringAnimations[i].skipToEnd();
                }
            }
        }
        if (z3) {
            invalidateSelf();
        }
    }

    private void updateStrokeShapeAppearanceModels() {
        this.strokeShapeAppearanceModel = getShapeAppearanceModel().withTransformedCornerSizes(this.strokeInsetCornerSizeUnaryOperator);
        if (this.springAnimatedCornerSizes == null) {
            this.springAnimatedStrokeCornerSizes = null;
            return;
        }
        if (this.springAnimatedStrokeCornerSizes == null) {
            this.springAnimatedStrokeCornerSizes = new float[this.springAnimatedCornerSizes.length];
        }
        float strokeInsetLength = getStrokeInsetLength();
        for (int i = 0; i < this.springAnimatedCornerSizes.length; i++) {
            this.springAnimatedStrokeCornerSizes[i] = Math.max(0.0f, this.springAnimatedCornerSizes[i] - strokeInsetLength);
        }
    }

    private boolean updateTintFilter() {
        PorterDuffColorFilter porterDuffColorFilter = this.tintFilter;
        PorterDuffColorFilter porterDuffColorFilter2 = this.strokeTintFilter;
        this.tintFilter = calculateTintFilter(this.drawableState.tintList, this.drawableState.tintMode, this.fillPaint, true);
        this.strokeTintFilter = calculateTintFilter(this.drawableState.strokeTintList, this.drawableState.tintMode, this.strokePaint, false);
        if (this.drawableState.useTintColorForShadow) {
            this.shadowRenderer.setShadowColor(this.drawableState.tintList.getColorForState(getState(), 0));
        }
        return (ObjectsCompat.equals(porterDuffColorFilter, this.tintFilter) && ObjectsCompat.equals(porterDuffColorFilter2, this.strokeTintFilter)) ? false : true;
    }

    private void updateZ() {
        float z = getZ();
        this.drawableState.shadowCompatRadius = (int) Math.ceil(0.75f * z);
        this.drawableState.shadowCompatOffset = (int) Math.ceil(SHADOW_OFFSET_MULTIPLIER * z);
        updateTintFilter();
        if (shouldCalculatePath()) {
            invalidateSelf();
        } else {
            invalidateSelfIgnoreShape();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void calculatePathForSize(RectF rectF, Path path) {
        this.pathProvider.calculatePath(this.drawableState.shapeAppearance.getDefaultShape(), this.springAnimatedCornerSizes, this.drawableState.interpolation, rectF, this.pathShadowListener, path);
    }

    public float calculateRoundRectCornerSize() {
        float calculateRoundRectCornerSize = calculateRoundRectCornerSize(getBoundsAsRectF(), this.drawableState.shapeAppearance.getDefaultShape(), this.springAnimatedCornerSizes);
        return calculateRoundRectCornerSize >= 0.0f ? this.drawableState.interpolation * calculateRoundRectCornerSize : calculateRoundRectCornerSize;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int compositeElevationOverlayIfNeeded(int i) {
        return this.drawableState.elevationOverlayProvider != null ? this.drawableState.elevationOverlayProvider.compositeOverlayIfNeeded(i, getZ() + getParentAbsoluteElevation()) : i;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.fillPaint.setColorFilter(this.tintFilter);
        int alpha = this.fillPaint.getAlpha();
        this.fillPaint.setAlpha(modulateAlpha(alpha, this.drawableState.alpha));
        this.strokePaint.setColorFilter(this.strokeTintFilter);
        this.strokePaint.setStrokeWidth(this.drawableState.strokeWidth);
        int alpha2 = this.strokePaint.getAlpha();
        this.strokePaint.setAlpha(modulateAlpha(alpha2, this.drawableState.alpha));
        boolean shouldCalculatePath = shouldCalculatePath();
        if (hasFill()) {
            if (this.pathDirty) {
                if (shouldCalculatePath) {
                    calculatePath(getBoundsAsRectF(), this.path);
                }
                this.pathDirty = false;
            }
            maybeDrawCompatShadow(canvas);
            drawFillShape(canvas);
        }
        if (hasStroke()) {
            if (this.strokePathDirty) {
                updateStrokeShapeAppearanceModels();
                if (shouldCalculatePath) {
                    calculateStrokePath();
                }
                this.strokePathDirty = false;
            }
            drawStrokeShape(canvas);
        }
        this.fillPaint.setAlpha(alpha);
        this.strokePaint.setAlpha(alpha2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawShape(Canvas canvas, Paint paint, Path path, RectF rectF) {
        drawShape(canvas, paint, path, this.drawableState.shapeAppearance.getDefaultShape(), this.springAnimatedCornerSizes, rectF);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void drawStrokeShape(Canvas canvas) {
        drawShape(canvas, this.strokePaint, this.pathInsetByStroke, this.strokeShapeAppearanceModel, this.springAnimatedStrokeCornerSizes, getBoundsInsetByStroke());
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.drawableState.alpha;
    }

    public float getBottomLeftCornerResolvedSize() {
        return this.springAnimatedCornerSizes != null ? this.springAnimatedCornerSizes[2] : this.drawableState.shapeAppearance.getDefaultShape().getBottomLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getBottomRightCornerResolvedSize() {
        return this.springAnimatedCornerSizes != null ? this.springAnimatedCornerSizes[1] : this.drawableState.shapeAppearance.getDefaultShape().getBottomRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public RectF getBoundsAsRectF() {
        this.rectF.set(getBounds());
        return this.rectF;
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable.ConstantState getConstantState() {
        return this.drawableState;
    }

    public float getCornerSizeDiffX() {
        if (this.springAnimatedCornerSizes != null) {
            return (((this.springAnimatedCornerSizes[3] + this.springAnimatedCornerSizes[2]) - this.springAnimatedCornerSizes[1]) - this.springAnimatedCornerSizes[0]) / 2.0f;
        }
        RectF boundsAsRectF = getBoundsAsRectF();
        return (((this.pathProvider.getCornerSizeForIndex(3, getShapeAppearanceModel()).getCornerSize(boundsAsRectF) + this.pathProvider.getCornerSizeForIndex(2, getShapeAppearanceModel()).getCornerSize(boundsAsRectF)) - this.pathProvider.getCornerSizeForIndex(1, getShapeAppearanceModel()).getCornerSize(boundsAsRectF)) - this.pathProvider.getCornerSizeForIndex(0, getShapeAppearanceModel()).getCornerSize(boundsAsRectF)) / 2.0f;
    }

    public SpringForce getCornerSpringForce() {
        return this.cornerSpringForce;
    }

    public float getElevation() {
        return this.drawableState.elevation;
    }

    public ColorStateList getFillColor() {
        return this.drawableState.fillColor;
    }

    public float getInterpolation() {
        return this.drawableState.interpolation;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        if (this.drawableState.shadowCompatMode == 2) {
            return;
        }
        RectF boundsAsRectF = getBoundsAsRectF();
        if (boundsAsRectF.isEmpty()) {
            return;
        }
        float calculateRoundRectCornerSize = calculateRoundRectCornerSize(boundsAsRectF, this.drawableState.shapeAppearance.getDefaultShape(), this.springAnimatedCornerSizes);
        if (calculateRoundRectCornerSize >= 0.0f) {
            outline.setRoundRect(getBounds(), this.drawableState.interpolation * calculateRoundRectCornerSize);
            return;
        }
        if (this.pathDirty) {
            calculatePath(boundsAsRectF, this.path);
            this.pathDirty = false;
        }
        DrawableUtils.setOutlineToPath(outline, this.path);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        if (this.drawableState.padding == null) {
            return super.getPadding(rect);
        }
        rect.set(this.drawableState.padding);
        return true;
    }

    public Paint.Style getPaintStyle() {
        return this.drawableState.paintStyle;
    }

    public float getParentAbsoluteElevation() {
        return this.drawableState.parentAbsoluteElevation;
    }

    public Path getPath() {
        return this.path;
    }

    @Deprecated
    public void getPathForSize(int i, int i2, Path path) {
        calculatePathForSize(new RectF(0.0f, 0.0f, i, i2), path);
    }

    public int getResolvedTintColor() {
        return this.resolvedTintColor;
    }

    public float getScale() {
        return this.drawableState.scale;
    }

    public int getShadowCompatRotation() {
        return this.drawableState.shadowCompatRotation;
    }

    public int getShadowCompatibilityMode() {
        return this.drawableState.shadowCompatMode;
    }

    @Deprecated
    public int getShadowElevation() {
        return (int) getElevation();
    }

    public int getShadowOffsetX() {
        return (int) (this.drawableState.shadowCompatOffset * Math.sin(Math.toRadians(this.drawableState.shadowCompatRotation)));
    }

    public int getShadowOffsetY() {
        return (int) (this.drawableState.shadowCompatOffset * Math.cos(Math.toRadians(this.drawableState.shadowCompatRotation)));
    }

    public int getShadowRadius() {
        return this.drawableState.shadowCompatRadius;
    }

    public int getShadowVerticalOffset() {
        return this.drawableState.shadowCompatOffset;
    }

    @Override // com.google.android.material.shape.Shapeable
    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.drawableState.shapeAppearance.getDefaultShape();
    }

    @Deprecated
    public ShapePathModel getShapedViewModel() {
        ShapeAppearanceModel shapeAppearanceModel = getShapeAppearanceModel();
        if (shapeAppearanceModel instanceof ShapePathModel) {
            return (ShapePathModel) shapeAppearanceModel;
        }
        return null;
    }

    public StateListShapeAppearanceModel getStateListShapeAppearanceModel() {
        if (this.drawableState.shapeAppearance instanceof StateListShapeAppearanceModel) {
            return (StateListShapeAppearanceModel) this.drawableState.shapeAppearance;
        }
        return null;
    }

    public ColorStateList getStrokeColor() {
        return this.drawableState.strokeColor;
    }

    public ColorStateList getStrokeTintList() {
        return this.drawableState.strokeTintList;
    }

    public float getStrokeWidth() {
        return this.drawableState.strokeWidth;
    }

    public ColorStateList getTintList() {
        return this.drawableState.tintList;
    }

    public float getTopLeftCornerResolvedSize() {
        return this.springAnimatedCornerSizes != null ? this.springAnimatedCornerSizes[3] : this.drawableState.shapeAppearance.getDefaultShape().getTopLeftCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTopRightCornerResolvedSize() {
        return this.springAnimatedCornerSizes != null ? this.springAnimatedCornerSizes[0] : this.drawableState.shapeAppearance.getDefaultShape().getTopRightCornerSize().getCornerSize(getBoundsAsRectF());
    }

    public float getTranslationZ() {
        return this.drawableState.translationZ;
    }

    @Override // android.graphics.drawable.Drawable
    public Region getTransparentRegion() {
        this.transparentRegion.set(getBounds());
        calculatePath(getBoundsAsRectF(), this.path);
        this.scratchRegion.setPath(this.path, this.transparentRegion);
        this.transparentRegion.op(this.scratchRegion, Region.Op.DIFFERENCE);
        return this.transparentRegion;
    }

    public float getZ() {
        return getElevation() + getTranslationZ();
    }

    public void initializeElevationOverlay(Context context) {
        this.drawableState.elevationOverlayProvider = new ElevationOverlayProvider(context);
        updateZ();
    }

    @Override // android.graphics.drawable.Drawable
    public void invalidateSelf() {
        this.pathDirty = true;
        this.strokePathDirty = true;
        super.invalidateSelf();
    }

    public boolean isElevationOverlayEnabled() {
        return this.drawableState.elevationOverlayProvider != null && this.drawableState.elevationOverlayProvider.isThemeElevationOverlayEnabled();
    }

    public boolean isElevationOverlayInitialized() {
        return this.drawableState.elevationOverlayProvider != null;
    }

    public boolean isPointInTransparentRegion(int i, int i2) {
        return getTransparentRegion().contains(i, i2);
    }

    public boolean isRoundRect() {
        return this.drawableState.shapeAppearance.getShapeForState(getState()).isRoundRect(getBoundsAsRectF()) && (this.springAnimatedCornerSizes == null || this.isRoundRectCornerMorph);
    }

    @Deprecated
    public boolean isShadowEnabled() {
        return this.drawableState.shadowCompatMode == 0 || this.drawableState.shadowCompatMode == 2;
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return super.isStateful() || (this.drawableState.tintList != null && this.drawableState.tintList.isStateful()) || ((this.drawableState.strokeTintList != null && this.drawableState.strokeTintList.isStateful()) || ((this.drawableState.strokeColor != null && this.drawableState.strokeColor.isStateful()) || ((this.drawableState.fillColor != null && this.drawableState.fillColor.isStateful()) || this.drawableState.shapeAppearance.isStateful())));
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.drawableState = new MaterialShapeDrawableState(this.drawableState);
        return this;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.pathDirty = true;
        this.strokePathDirty = true;
        super.onBoundsChange(rect);
        if (!this.drawableState.shapeAppearance.isStateful() || rect.isEmpty()) {
            return;
        }
        updateShape(getState(), !isCornerSpringAnimationRunning());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.graphics.drawable.Drawable, com.google.android.material.internal.TextDrawableHelper.TextDrawableDelegate
    public boolean onStateChange(int[] iArr) {
        if (this.drawableState.shapeAppearance.isStateful()) {
            updateShape(iArr);
        }
        boolean z = updateColorsForState(iArr) || updateTintFilter();
        if (z) {
            invalidateSelf();
        }
        return z;
    }

    public boolean requiresCompatShadow() {
        return (isRoundRect() || this.path.isConvex() || Build.VERSION.SDK_INT >= 29) ? false : true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (this.drawableState.alpha != i) {
            this.drawableState.alpha = i;
            invalidateSelfIgnoreShape();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.drawableState.colorFilter = colorFilter;
        invalidateSelfIgnoreShape();
    }

    public void setCornerSize(float f) {
        setShapeAppearanceModel(this.drawableState.shapeAppearance.withCornerSize(f));
    }

    public void setCornerSize(CornerSize cornerSize) {
        setShapeAppearanceModel(this.drawableState.shapeAppearance.withCornerSize(cornerSize));
    }

    public void setCornerSpringForce(SpringForce springForce) {
        if (this.cornerSpringForce != springForce) {
            this.cornerSpringForce = springForce;
            for (int i = 0; i < this.cornerSpringAnimations.length; i++) {
                if (this.cornerSpringAnimations[i] == null) {
                    this.cornerSpringAnimations[i] = new SpringAnimation(this, CORNER_SIZES_IN_PX[i]);
                }
                this.cornerSpringAnimations[i].setSpring(new SpringForce().setDampingRatio(springForce.getDampingRatio()).setStiffness(springForce.getStiffness()));
            }
            updateShape(getState(), true);
            invalidateSelf();
        }
    }

    public void setEdgeIntersectionCheckEnable(boolean z) {
        this.pathProvider.setEdgeIntersectionCheckEnable(z);
    }

    public void setElevation(float f) {
        if (this.drawableState.elevation != f) {
            this.drawableState.elevation = f;
            updateZ();
        }
    }

    public void setFillColor(ColorStateList colorStateList) {
        if (this.drawableState.fillColor != colorStateList) {
            this.drawableState.fillColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setInterpolation(float f) {
        if (this.drawableState.interpolation != f) {
            this.drawableState.interpolation = f;
            this.pathDirty = true;
            this.strokePathDirty = true;
            invalidateSelf();
        }
    }

    public void setOnCornerSizeChangeListener(OnCornerSizeChangeListener onCornerSizeChangeListener) {
        this.onCornerSizeChangeListener = onCornerSizeChangeListener;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        if (this.drawableState.padding == null) {
            this.drawableState.padding = new Rect();
        }
        this.drawableState.padding.set(i, i2, i3, i4);
        invalidateSelf();
    }

    public void setPaintStyle(Paint.Style style) {
        this.drawableState.paintStyle = style;
        invalidateSelfIgnoreShape();
    }

    public void setParentAbsoluteElevation(float f) {
        if (this.drawableState.parentAbsoluteElevation != f) {
            this.drawableState.parentAbsoluteElevation = f;
            updateZ();
        }
    }

    public void setScale(float f) {
        if (this.drawableState.scale != f) {
            this.drawableState.scale = f;
            invalidateSelf();
        }
    }

    public void setShadowBitmapDrawingEnable(boolean z) {
        this.shadowBitmapDrawingEnable = z;
    }

    public void setShadowColor(int i) {
        this.shadowRenderer.setShadowColor(i);
        this.drawableState.useTintColorForShadow = false;
        invalidateSelfIgnoreShape();
    }

    public void setShadowCompatRotation(int i) {
        if (this.drawableState.shadowCompatRotation != i) {
            this.drawableState.shadowCompatRotation = i;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShadowCompatibilityMode(int i) {
        if (this.drawableState.shadowCompatMode != i) {
            this.drawableState.shadowCompatMode = i;
            invalidateSelfIgnoreShape();
        }
    }

    @Deprecated
    public void setShadowElevation(int i) {
        setElevation(i);
    }

    @Deprecated
    public void setShadowEnabled(boolean z) {
        setShadowCompatibilityMode(!z ? 1 : 0);
    }

    @Deprecated
    public void setShadowRadius(int i) {
        this.drawableState.shadowCompatRadius = i;
    }

    public void setShadowVerticalOffset(int i) {
        if (this.drawableState.shadowCompatOffset != i) {
            this.drawableState.shadowCompatOffset = i;
            invalidateSelfIgnoreShape();
        }
    }

    public void setShapeAppearance(ShapeAppearance shapeAppearance) {
        if (shapeAppearance instanceof ShapeAppearanceModel) {
            setShapeAppearanceModel((ShapeAppearanceModel) shapeAppearance);
        } else {
            setStateListShapeAppearanceModel((StateListShapeAppearanceModel) shapeAppearance);
        }
    }

    @Override // com.google.android.material.shape.Shapeable
    public void setShapeAppearanceModel(ShapeAppearanceModel shapeAppearanceModel) {
        this.drawableState.shapeAppearance = shapeAppearanceModel;
        this.springAnimatedCornerSizes = null;
        this.springAnimatedStrokeCornerSizes = null;
        invalidateSelf();
    }

    @Deprecated
    public void setShapedViewModel(ShapePathModel shapePathModel) {
        setShapeAppearanceModel(shapePathModel);
    }

    public void setStroke(float f, int i) {
        setStrokeWidth(f);
        setStrokeColor(ColorStateList.valueOf(i));
    }

    public void setStroke(float f, ColorStateList colorStateList) {
        setStrokeWidth(f);
        setStrokeColor(colorStateList);
    }

    public void setStrokeColor(ColorStateList colorStateList) {
        if (this.drawableState.strokeColor != colorStateList) {
            this.drawableState.strokeColor = colorStateList;
            onStateChange(getState());
        }
    }

    public void setStrokeTint(int i) {
        setStrokeTint(ColorStateList.valueOf(i));
    }

    public void setStrokeTint(ColorStateList colorStateList) {
        this.drawableState.strokeTintList = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    public void setStrokeWidth(float f) {
        this.drawableState.strokeWidth = f;
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTint(int i) {
        setTintList(ColorStateList.valueOf(i));
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintList(ColorStateList colorStateList) {
        this.drawableState.tintList = colorStateList;
        updateTintFilter();
        invalidateSelfIgnoreShape();
    }

    @Override // android.graphics.drawable.Drawable, androidx.core.graphics.drawable.TintAwareDrawable
    public void setTintMode(PorterDuff.Mode mode) {
        if (this.drawableState.tintMode != mode) {
            this.drawableState.tintMode = mode;
            updateTintFilter();
            invalidateSelfIgnoreShape();
        }
    }

    public void setTranslationZ(float f) {
        if (this.drawableState.translationZ != f) {
            this.drawableState.translationZ = f;
            updateZ();
        }
    }

    public void setUseTintColorForShadow(boolean z) {
        if (this.drawableState.useTintColorForShadow != z) {
            this.drawableState.useTintColorForShadow = z;
            invalidateSelf();
        }
    }

    public void setZ(float f) {
        setTranslationZ(f - getElevation());
    }
}
