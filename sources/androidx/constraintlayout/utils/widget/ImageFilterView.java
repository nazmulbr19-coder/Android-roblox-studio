package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.R;

/* loaded from: classes.dex */
public class ImageFilterView extends AppCompatImageView {
    private Drawable mAltDrawable;
    private float mCrossfade;
    private Drawable mDrawable;
    private ImageMatrix mImageMatrix;
    LayerDrawable mLayer;
    Drawable[] mLayers;
    private boolean mOverlay;
    float mPanX;
    float mPanY;
    private Path mPath;
    RectF mRect;
    float mRotate;
    private float mRound;
    private float mRoundPercent;
    ViewOutlineProvider mViewOutlineProvider;
    float mZoom;

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterView$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 extends ViewOutlineProvider {
        AnonymousClass1() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), (Math.min(r4, r5) * ImageFilterView.access$000(ImageFilterView.this)) / 2.0f);
        }
    }

    /* renamed from: androidx.constraintlayout.utils.widget.ImageFilterView$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 extends ViewOutlineProvider {
        AnonymousClass2() {
        }

        @Override // android.view.ViewOutlineProvider
        public void getOutline(View view, Outline outline) {
            outline.setRoundRect(0, 0, ImageFilterView.this.getWidth(), ImageFilterView.this.getHeight(), ImageFilterView.access$100(ImageFilterView.this));
        }
    }

    /* loaded from: classes.dex */
    static class ImageMatrix {
        float[] mMatrix = new float[20];
        ColorMatrix mColorMatrix = new ColorMatrix();
        ColorMatrix mTmpColorMatrix = new ColorMatrix();
        float mBrightness = 1.0f;
        float mSaturation = 1.0f;
        float mContrast = 1.0f;
        float mWarmth = 1.0f;

        private void brightness(float f) {
            this.mMatrix[0] = f;
            this.mMatrix[1] = 0.0f;
            this.mMatrix[2] = 0.0f;
            this.mMatrix[3] = 0.0f;
            this.mMatrix[4] = 0.0f;
            this.mMatrix[5] = 0.0f;
            this.mMatrix[6] = f;
            this.mMatrix[7] = 0.0f;
            this.mMatrix[8] = 0.0f;
            this.mMatrix[9] = 0.0f;
            this.mMatrix[10] = 0.0f;
            this.mMatrix[11] = 0.0f;
            this.mMatrix[12] = f;
            this.mMatrix[13] = 0.0f;
            this.mMatrix[14] = 0.0f;
            this.mMatrix[15] = 0.0f;
            this.mMatrix[16] = 0.0f;
            this.mMatrix[17] = 0.0f;
            this.mMatrix[18] = 1.0f;
            this.mMatrix[19] = 0.0f;
        }

        private void saturation(float f) {
            float f2 = 1.0f - f;
            float f3 = 0.2999f * f2;
            float f4 = 0.587f * f2;
            float f5 = 0.114f * f2;
            this.mMatrix[0] = f3 + f;
            this.mMatrix[1] = f4;
            this.mMatrix[2] = f5;
            this.mMatrix[3] = 0.0f;
            this.mMatrix[4] = 0.0f;
            this.mMatrix[5] = f3;
            this.mMatrix[6] = f4 + f;
            this.mMatrix[7] = f5;
            this.mMatrix[8] = 0.0f;
            this.mMatrix[9] = 0.0f;
            this.mMatrix[10] = f3;
            this.mMatrix[11] = f4;
            this.mMatrix[12] = f5 + f;
            this.mMatrix[13] = 0.0f;
            this.mMatrix[14] = 0.0f;
            this.mMatrix[15] = 0.0f;
            this.mMatrix[16] = 0.0f;
            this.mMatrix[17] = 0.0f;
            this.mMatrix[18] = 1.0f;
            this.mMatrix[19] = 0.0f;
        }

        private void warmth(float f) {
            float f2;
            float f3;
            float f4;
            float log;
            float f5;
            float f6;
            float f7;
            float f8;
            float log2;
            float f9;
            float f10 = (5000.0f / (f <= 0.0f ? 0.01f : f)) / 100.0f;
            if (f10 > 66.0f) {
                float f11 = f10 - 60.0f;
                f2 = 60.0f;
                f3 = 329.69873f;
                f5 = ((float) Math.pow(f11, -0.13320475816726685d)) * 329.69873f;
                f4 = 288.12216f;
                log = ((float) Math.pow(f11, 0.07551485300064087d)) * 288.12216f;
            } else {
                f2 = 60.0f;
                f3 = 329.69873f;
                f4 = 288.12216f;
                log = (((float) Math.log(f10)) * 99.4708f) - 161.11957f;
                f5 = 255.0f;
            }
            if (f10 >= 66.0f) {
                f6 = 100.0f;
                f7 = 255.0f;
            } else if (f10 > 19.0f) {
                f6 = 100.0f;
                f7 = (((float) Math.log(f10 - 10.0f)) * 138.51773f) - 305.0448f;
            } else {
                f6 = 100.0f;
                f7 = 0.0f;
            }
            float min = Math.min(255.0f, Math.max(f5, 0.0f));
            float min2 = Math.min(255.0f, Math.max(log, 0.0f));
            float min3 = Math.min(255.0f, Math.max(f7, 0.0f));
            float f12 = 5000.0f / f6;
            if (f12 > 66.0f) {
                float f13 = f4;
                float f14 = f12 - f2;
                f9 = ((float) Math.pow(f14, -0.13320475816726685d)) * f3;
                f8 = min;
                log2 = ((float) Math.pow(f14, 0.07551485300064087d)) * f13;
            } else {
                f8 = min;
                log2 = (((float) Math.log(f12)) * 99.4708f) - 161.11957f;
                f9 = 255.0f;
            }
            float log3 = f12 < 66.0f ? f12 > 19.0f ? (((float) Math.log(f12 - 10.0f)) * 138.51773f) - 305.0448f : 0.0f : 255.0f;
            float min4 = Math.min(255.0f, Math.max(f9, 0.0f));
            float min5 = Math.min(255.0f, Math.max(log2, 0.0f));
            float min6 = Math.min(255.0f, Math.max(log3, 0.0f));
            this.mMatrix[0] = f8 / min4;
            this.mMatrix[1] = 0.0f;
            this.mMatrix[2] = 0.0f;
            this.mMatrix[3] = 0.0f;
            this.mMatrix[4] = 0.0f;
            this.mMatrix[5] = 0.0f;
            this.mMatrix[6] = min2 / min5;
            this.mMatrix[7] = 0.0f;
            this.mMatrix[8] = 0.0f;
            this.mMatrix[9] = 0.0f;
            this.mMatrix[10] = 0.0f;
            this.mMatrix[11] = 0.0f;
            this.mMatrix[12] = min3 / min6;
            this.mMatrix[13] = 0.0f;
            this.mMatrix[14] = 0.0f;
            this.mMatrix[15] = 0.0f;
            this.mMatrix[16] = 0.0f;
            this.mMatrix[17] = 0.0f;
            this.mMatrix[18] = 1.0f;
            this.mMatrix[19] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void updateMatrix(ImageView imageView) {
            this.mColorMatrix.reset();
            boolean z = false;
            if (this.mSaturation != 1.0f) {
                saturation(this.mSaturation);
                this.mColorMatrix.set(this.mMatrix);
                z = true;
            }
            if (this.mContrast != 1.0f) {
                this.mTmpColorMatrix.setScale(this.mContrast, this.mContrast, this.mContrast, 1.0f);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z = true;
            }
            if (this.mWarmth != 1.0f) {
                warmth(this.mWarmth);
                this.mTmpColorMatrix.set(this.mMatrix);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z = true;
            }
            if (this.mBrightness != 1.0f) {
                brightness(this.mBrightness);
                this.mTmpColorMatrix.set(this.mMatrix);
                this.mColorMatrix.postConcat(this.mTmpColorMatrix);
                z = true;
            }
            if (z) {
                imageView.setColorFilter(new ColorMatrixColorFilter(this.mColorMatrix));
            } else {
                imageView.clearColorFilter();
            }
        }
    }

    public ImageFilterView(Context context) {
        super(context);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, null);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, attributeSet);
    }

    public ImageFilterView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mImageMatrix = new ImageMatrix();
        this.mOverlay = true;
        this.mAltDrawable = null;
        this.mDrawable = null;
        this.mCrossfade = 0.0f;
        this.mRoundPercent = 0.0f;
        this.mRound = Float.NaN;
        this.mLayers = new Drawable[2];
        this.mPanX = Float.NaN;
        this.mPanY = Float.NaN;
        this.mZoom = Float.NaN;
        this.mRotate = Float.NaN;
        init(context, attributeSet);
    }

    static /* synthetic */ float access$000(ImageFilterView imageFilterView) {
        return imageFilterView.mRoundPercent;
    }

    static /* synthetic */ float access$100(ImageFilterView imageFilterView) {
        return imageFilterView.mRound;
    }

    private void init(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ImageFilterView);
            int indexCount = obtainStyledAttributes.getIndexCount();
            this.mAltDrawable = obtainStyledAttributes.getDrawable(R.styleable.ImageFilterView_altSrc);
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.ImageFilterView_crossfade) {
                    this.mCrossfade = obtainStyledAttributes.getFloat(index, 0.0f);
                } else if (index == R.styleable.ImageFilterView_warmth) {
                    setWarmth(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_saturation) {
                    setSaturation(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_contrast) {
                    setContrast(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_brightness) {
                    setBrightness(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_round) {
                    int i2 = Build.VERSION.SDK_INT;
                    setRound(obtainStyledAttributes.getDimension(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_roundPercent) {
                    int i3 = Build.VERSION.SDK_INT;
                    setRoundPercent(obtainStyledAttributes.getFloat(index, 0.0f));
                } else if (index == R.styleable.ImageFilterView_overlay) {
                    setOverlay(obtainStyledAttributes.getBoolean(index, this.mOverlay));
                } else if (index == R.styleable.ImageFilterView_imagePanX) {
                    setImagePanX(obtainStyledAttributes.getFloat(index, this.mPanX));
                } else if (index == R.styleable.ImageFilterView_imagePanY) {
                    setImagePanY(obtainStyledAttributes.getFloat(index, this.mPanY));
                } else if (index == R.styleable.ImageFilterView_imageRotate) {
                    setImageRotate(obtainStyledAttributes.getFloat(index, this.mRotate));
                } else if (index == R.styleable.ImageFilterView_imageZoom) {
                    setImageZoom(obtainStyledAttributes.getFloat(index, this.mZoom));
                }
            }
            obtainStyledAttributes.recycle();
            this.mDrawable = getDrawable();
            if (this.mAltDrawable == null || this.mDrawable == null) {
                this.mDrawable = getDrawable();
                if (this.mDrawable != null) {
                    Drawable[] drawableArr = this.mLayers;
                    Drawable mutate = this.mDrawable.mutate();
                    this.mDrawable = mutate;
                    drawableArr[0] = mutate;
                    return;
                }
                return;
            }
            Drawable[] drawableArr2 = this.mLayers;
            Drawable mutate2 = getDrawable().mutate();
            this.mDrawable = mutate2;
            drawableArr2[0] = mutate2;
            this.mLayers[1] = this.mAltDrawable.mutate();
            this.mLayer = new LayerDrawable(this.mLayers);
            this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            super.setImageDrawable(this.mLayer);
        }
    }

    private void setMatrix() {
        if (Float.isNaN(this.mPanX) && Float.isNaN(this.mPanY) && Float.isNaN(this.mZoom) && Float.isNaN(this.mRotate)) {
            return;
        }
        float f = Float.isNaN(this.mPanX) ? 0.0f : this.mPanX;
        float f2 = Float.isNaN(this.mPanY) ? 0.0f : this.mPanY;
        float f3 = Float.isNaN(this.mZoom) ? 1.0f : this.mZoom;
        float f4 = Float.isNaN(this.mRotate) ? 0.0f : this.mRotate;
        Matrix matrix = new Matrix();
        matrix.reset();
        float intrinsicWidth = getDrawable().getIntrinsicWidth();
        float intrinsicHeight = getDrawable().getIntrinsicHeight();
        float width = getWidth();
        float height = getHeight();
        float f5 = (intrinsicWidth * height < intrinsicHeight * width ? width / intrinsicWidth : height / intrinsicHeight) * f3;
        matrix.postScale(f5, f5);
        matrix.postTranslate(((((width - (f5 * intrinsicWidth)) * f) + width) - (f5 * intrinsicWidth)) * 0.5f, ((((height - (f5 * intrinsicHeight)) * f2) + height) - (f5 * intrinsicHeight)) * 0.5f);
        matrix.postRotate(f4, width / 2.0f, height / 2.0f);
        setImageMatrix(matrix);
        setScaleType(ImageView.ScaleType.MATRIX);
    }

    private void setOverlay(boolean z) {
        this.mOverlay = z;
    }

    private void updateViewMatrix() {
        if (Float.isNaN(this.mPanX) && Float.isNaN(this.mPanY) && Float.isNaN(this.mZoom) && Float.isNaN(this.mRotate)) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            setMatrix();
        }
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        int i = Build.VERSION.SDK_INT;
        super.draw(canvas);
        if (0 != 0) {
            canvas.restore();
        }
    }

    public float getBrightness() {
        return this.mImageMatrix.mBrightness;
    }

    public float getContrast() {
        return this.mImageMatrix.mContrast;
    }

    public float getCrossfade() {
        return this.mCrossfade;
    }

    public float getImagePanX() {
        return this.mPanX;
    }

    public float getImagePanY() {
        return this.mPanY;
    }

    public float getImageRotate() {
        return this.mRotate;
    }

    public float getImageZoom() {
        return this.mZoom;
    }

    public float getRound() {
        return this.mRound;
    }

    public float getRoundPercent() {
        return this.mRoundPercent;
    }

    public float getSaturation() {
        return this.mImageMatrix.mSaturation;
    }

    public float getWarmth() {
        return this.mImageMatrix.mWarmth;
    }

    @Override // android.view.View
    public void layout(int i, int i2, int i3, int i4) {
        super.layout(i, i2, i3, i4);
        setMatrix();
    }

    public void setAltImageDrawable(Drawable drawable) {
        this.mAltDrawable = drawable.mutate();
        this.mLayers[0] = this.mDrawable;
        this.mLayers[1] = this.mAltDrawable;
        this.mLayer = new LayerDrawable(this.mLayers);
        super.setImageDrawable(this.mLayer);
        setCrossfade(this.mCrossfade);
    }

    public void setAltImageResource(int i) {
        this.mAltDrawable = AppCompatResources.getDrawable(getContext(), i);
        setAltImageDrawable(this.mAltDrawable);
    }

    public void setBrightness(float f) {
        this.mImageMatrix.mBrightness = f;
        this.mImageMatrix.updateMatrix(this);
    }

    public void setContrast(float f) {
        this.mImageMatrix.mContrast = f;
        this.mImageMatrix.updateMatrix(this);
    }

    public void setCrossfade(float f) {
        this.mCrossfade = f;
        if (this.mLayers != null) {
            if (!this.mOverlay) {
                this.mLayer.getDrawable(0).setAlpha((int) ((1.0f - this.mCrossfade) * 255.0f));
            }
            this.mLayer.getDrawable(1).setAlpha((int) (this.mCrossfade * 255.0f));
            super.setImageDrawable(this.mLayer);
        }
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (this.mAltDrawable == null || drawable == null) {
            super.setImageDrawable(drawable);
            return;
        }
        this.mDrawable = drawable.mutate();
        this.mLayers[0] = this.mDrawable;
        this.mLayers[1] = this.mAltDrawable;
        this.mLayer = new LayerDrawable(this.mLayers);
        super.setImageDrawable(this.mLayer);
        setCrossfade(this.mCrossfade);
    }

    public void setImagePanX(float f) {
        this.mPanX = f;
        updateViewMatrix();
    }

    public void setImagePanY(float f) {
        this.mPanY = f;
        updateViewMatrix();
    }

    @Override // androidx.appcompat.widget.AppCompatImageView, android.widget.ImageView
    public void setImageResource(int i) {
        if (this.mAltDrawable == null) {
            super.setImageResource(i);
            return;
        }
        this.mDrawable = AppCompatResources.getDrawable(getContext(), i).mutate();
        this.mLayers[0] = this.mDrawable;
        this.mLayers[1] = this.mAltDrawable;
        this.mLayer = new LayerDrawable(this.mLayers);
        super.setImageDrawable(this.mLayer);
        setCrossfade(this.mCrossfade);
    }

    public void setImageRotate(float f) {
        this.mRotate = f;
        updateViewMatrix();
    }

    public void setImageZoom(float f) {
        this.mZoom = f;
        updateViewMatrix();
    }

    public void setRound(float f) {
        if (Float.isNaN(f)) {
            this.mRound = f;
            float f2 = this.mRoundPercent;
            this.mRoundPercent = -1.0f;
            setRoundPercent(f2);
            return;
        }
        boolean z = this.mRound != f;
        this.mRound = f;
        if (this.mRound != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            int i = Build.VERSION.SDK_INT;
            if (this.mViewOutlineProvider == null) {
                this.mViewOutlineProvider = new AnonymousClass2();
                setOutlineProvider(this.mViewOutlineProvider);
            }
            setClipToOutline(true);
            this.mRect.set(0.0f, 0.0f, getWidth(), getHeight());
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, this.mRound, this.mRound, Path.Direction.CW);
        } else {
            int i2 = Build.VERSION.SDK_INT;
            setClipToOutline(false);
        }
        if (z) {
            int i3 = Build.VERSION.SDK_INT;
            invalidateOutline();
        }
    }

    public void setRoundPercent(float f) {
        boolean z = this.mRoundPercent != f;
        this.mRoundPercent = f;
        if (this.mRoundPercent != 0.0f) {
            if (this.mPath == null) {
                this.mPath = new Path();
            }
            if (this.mRect == null) {
                this.mRect = new RectF();
            }
            int i = Build.VERSION.SDK_INT;
            if (this.mViewOutlineProvider == null) {
                this.mViewOutlineProvider = new AnonymousClass1();
                setOutlineProvider(this.mViewOutlineProvider);
            }
            setClipToOutline(true);
            int width = getWidth();
            int height = getHeight();
            float min = (Math.min(width, height) * this.mRoundPercent) / 2.0f;
            this.mRect.set(0.0f, 0.0f, width, height);
            this.mPath.reset();
            this.mPath.addRoundRect(this.mRect, min, min, Path.Direction.CW);
        } else {
            int i2 = Build.VERSION.SDK_INT;
            setClipToOutline(false);
        }
        if (z) {
            int i3 = Build.VERSION.SDK_INT;
            invalidateOutline();
        }
    }

    public void setSaturation(float f) {
        this.mImageMatrix.mSaturation = f;
        this.mImageMatrix.updateMatrix(this);
    }

    public void setWarmth(float f) {
        this.mImageMatrix.mWarmth = f;
        this.mImageMatrix.updateMatrix(this);
    }
}
