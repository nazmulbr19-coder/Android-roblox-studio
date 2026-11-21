package androidx.core.view.insets;

import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.graphics.Insets;

/* loaded from: classes.dex */
public abstract class Protection {
    private static final long DEFAULT_DURATION_IN = 333;
    private static final long DEFAULT_DURATION_OUT = 166;
    private final int mSide;
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_IN = new PathInterpolator(0.0f, 0.0f, 0.0f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_MOVE_OUT = new PathInterpolator(0.6f, 0.0f, 1.0f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_IN = new PathInterpolator(0.0f, 0.0f, 0.2f, 1.0f);
    private static final Interpolator DEFAULT_INTERPOLATOR_FADE_OUT = new PathInterpolator(0.4f, 0.0f, 1.0f, 1.0f);
    private final Attributes mAttributes = new Attributes();
    private Insets mInsets = Insets.NONE;
    private Insets mInsetsIgnoringVisibility = Insets.NONE;
    private float mSystemAlpha = 1.0f;
    private float mUserAlpha = 1.0f;
    private float mSystemInsetAmount = 1.0f;
    private float mUserInsetAmount = 1.0f;
    private Object mController = null;
    private ValueAnimator mUserAlphaAnimator = null;
    private ValueAnimator mUserInsetAmountAnimator = null;

    /* loaded from: classes.dex */
    static class Attributes {
        private static final int UNSPECIFIED = -1;
        private Callback mCallback;
        private int mWidth = -1;
        private int mHeight = -1;
        private Insets mMargin = Insets.NONE;
        private boolean mVisible = false;
        private Drawable mDrawable = null;
        private float mTranslationX = 0.0f;
        private float mTranslationY = 0.0f;
        private float mAlpha = 1.0f;

        /* loaded from: classes.dex */
        interface Callback {
            default void onAlphaChanged(float f) {
            }

            default void onDrawableChanged(Drawable drawable) {
            }

            default void onHeightChanged(int i) {
            }

            default void onMarginChanged(Insets insets) {
            }

            default void onTranslationXChanged(float f) {
            }

            default void onTranslationYChanged(float f) {
            }

            default void onVisibilityChanged(boolean z) {
            }

            default void onWidthChanged(int i) {
            }
        }

        /* renamed from: -$$Nest$fgetmHeight, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m107$$Nest$fgetmHeight(Attributes attributes) {
            return attributes.mHeight;
        }

        /* renamed from: -$$Nest$fgetmWidth, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m108$$Nest$fgetmWidth(Attributes attributes) {
            return attributes.mWidth;
        }

        /* renamed from: -$$Nest$msetAlpha, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m109$$Nest$msetAlpha(Attributes attributes, float f) {
            attributes.setAlpha(f);
        }

        /* renamed from: -$$Nest$msetDrawable, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m110$$Nest$msetDrawable(Attributes attributes, Drawable drawable) {
            attributes.setDrawable(drawable);
        }

        /* renamed from: -$$Nest$msetHeight, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m111$$Nest$msetHeight(Attributes attributes, int i) {
            attributes.setHeight(i);
        }

        /* renamed from: -$$Nest$msetMargin, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m112$$Nest$msetMargin(Attributes attributes, Insets insets) {
            attributes.setMargin(insets);
        }

        /* renamed from: -$$Nest$msetTranslationX, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m113$$Nest$msetTranslationX(Attributes attributes, float f) {
            attributes.setTranslationX(f);
        }

        /* renamed from: -$$Nest$msetTranslationY, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m114$$Nest$msetTranslationY(Attributes attributes, float f) {
            attributes.setTranslationY(f);
        }

        /* renamed from: -$$Nest$msetVisible, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m115$$Nest$msetVisible(Attributes attributes, boolean z) {
            attributes.setVisible(z);
        }

        /* renamed from: -$$Nest$msetWidth, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m116$$Nest$msetWidth(Attributes attributes, int i) {
            attributes.setWidth(i);
        }

        Attributes() {
        }

        private void setAlpha(float f) {
            if (this.mAlpha != f) {
                this.mAlpha = f;
                if (this.mCallback != null) {
                    this.mCallback.onAlphaChanged(f);
                }
            }
        }

        private void setDrawable(Drawable drawable) {
            this.mDrawable = drawable;
            if (this.mCallback != null) {
                this.mCallback.onDrawableChanged(drawable);
            }
        }

        private void setHeight(int i) {
            if (this.mHeight != i) {
                this.mHeight = i;
                if (this.mCallback != null) {
                    this.mCallback.onHeightChanged(i);
                }
            }
        }

        private void setMargin(Insets insets) {
            if (this.mMargin.equals(insets)) {
                return;
            }
            this.mMargin = insets;
            if (this.mCallback != null) {
                this.mCallback.onMarginChanged(insets);
            }
        }

        private void setTranslationX(float f) {
            if (this.mTranslationX != f) {
                this.mTranslationX = f;
                if (this.mCallback != null) {
                    this.mCallback.onTranslationXChanged(f);
                }
            }
        }

        private void setTranslationY(float f) {
            if (this.mTranslationY != f) {
                this.mTranslationY = f;
                if (this.mCallback != null) {
                    this.mCallback.onTranslationYChanged(f);
                }
            }
        }

        private void setVisible(boolean z) {
            if (this.mVisible != z) {
                this.mVisible = z;
                if (this.mCallback != null) {
                    this.mCallback.onVisibilityChanged(z);
                }
            }
        }

        private void setWidth(int i) {
            if (this.mWidth != i) {
                this.mWidth = i;
                if (this.mCallback != null) {
                    this.mCallback.onWidthChanged(i);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float getAlpha() {
            return this.mAlpha;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Drawable getDrawable() {
            return this.mDrawable;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getHeight() {
            return this.mHeight;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public Insets getMargin() {
            return this.mMargin;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float getTranslationX() {
            return this.mTranslationX;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public float getTranslationY() {
            return this.mTranslationY;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getWidth() {
            return this.mWidth;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public boolean isVisible() {
            return this.mVisible;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public void setCallback(Callback callback) {
            if (this.mCallback != null && callback != null) {
                throw new IllegalStateException("Trying to overwrite the existing callback. Did you send one protection to multiple ProtectionLayouts?");
            }
            this.mCallback = callback;
        }
    }

    public Protection(int i) {
        switch (i) {
            case 1:
            case 2:
            case 4:
            case 8:
                this.mSide = i;
                return;
            default:
                throw new IllegalArgumentException("Unexpected side: " + i);
        }
    }

    private void cancelUserAlphaAnimation() {
        if (this.mUserAlphaAnimator != null) {
            this.mUserAlphaAnimator.cancel();
            this.mUserAlphaAnimator = null;
        }
    }

    private void cancelUserInsetsAmountAnimation() {
        if (this.mUserInsetAmountAnimator != null) {
            this.mUserInsetAmountAnimator.cancel();
            this.mUserInsetAmountAnimator = null;
        }
    }

    private void setAlphaInternal(float f) {
        this.mUserAlpha = f;
        updateAlpha();
    }

    private void setInsetAmountInternal(float f) {
        this.mUserInsetAmount = f;
        updateInsetAmount();
    }

    private void updateAlpha() {
        Attributes.m109$$Nest$msetAlpha(this.mAttributes, this.mSystemAlpha * this.mUserAlpha);
    }

    private void updateInsetAmount() {
        float f = this.mUserInsetAmount * this.mSystemInsetAmount;
        switch (this.mSide) {
            case 1:
                Attributes.m113$$Nest$msetTranslationX(this.mAttributes, (-(1.0f - f)) * Attributes.m108$$Nest$fgetmWidth(this.mAttributes));
                return;
            case 2:
                Attributes.m114$$Nest$msetTranslationY(this.mAttributes, (-(1.0f - f)) * Attributes.m107$$Nest$fgetmHeight(this.mAttributes));
                return;
            case 4:
                Attributes.m113$$Nest$msetTranslationX(this.mAttributes, (1.0f - f) * Attributes.m108$$Nest$fgetmWidth(this.mAttributes));
                return;
            case 8:
                Attributes.m114$$Nest$msetTranslationY(this.mAttributes, (1.0f - f) * Attributes.m107$$Nest$fgetmHeight(this.mAttributes));
                return;
            default:
                return;
        }
    }

    public void animateAlpha(float f) {
        cancelUserAlphaAnimation();
        if (f == this.mUserAlpha) {
            return;
        }
        this.mUserAlphaAnimator = ValueAnimator.ofFloat(this.mUserAlpha, f);
        if (this.mUserAlpha < f) {
            this.mUserAlphaAnimator.setDuration(DEFAULT_DURATION_IN);
            this.mUserAlphaAnimator.setInterpolator(DEFAULT_INTERPOLATOR_FADE_IN);
        } else {
            this.mUserAlphaAnimator.setDuration(DEFAULT_DURATION_OUT);
            this.mUserAlphaAnimator.setInterpolator(DEFAULT_INTERPOLATOR_FADE_OUT);
        }
        this.mUserAlphaAnimator.addUpdateListener(new Protection$$ExternalSyntheticLambda1(this));
        this.mUserAlphaAnimator.start();
    }

    public void animateInsetsAmount(float f) {
        cancelUserInsetsAmountAnimation();
        if (f == this.mUserInsetAmount) {
            return;
        }
        this.mUserInsetAmountAnimator = ValueAnimator.ofFloat(this.mUserInsetAmount, f);
        if (this.mUserInsetAmount < f) {
            this.mUserInsetAmountAnimator.setDuration(DEFAULT_DURATION_IN);
            this.mUserInsetAmountAnimator.setInterpolator(DEFAULT_INTERPOLATOR_MOVE_IN);
        } else {
            this.mUserInsetAmountAnimator.setDuration(DEFAULT_DURATION_OUT);
            this.mUserInsetAmountAnimator.setInterpolator(DEFAULT_INTERPOLATOR_MOVE_OUT);
        }
        this.mUserInsetAmountAnimator.addUpdateListener(new Protection$$ExternalSyntheticLambda0(this));
        this.mUserInsetAmountAnimator.start();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void dispatchColorHint(int i) {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Insets dispatchInsets(Insets insets, Insets insets2, Insets insets3) {
        this.mInsets = insets;
        this.mInsetsIgnoringVisibility = insets2;
        Attributes.m112$$Nest$msetMargin(this.mAttributes, insets3);
        return updateLayout();
    }

    public float getAlpha() {
        return this.mUserAlpha;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Attributes getAttributes() {
        return this.mAttributes;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object getController() {
        return this.mController;
    }

    public float getInsetAmount() {
        return this.mUserInsetAmount;
    }

    public int getSide() {
        return this.mSide;
    }

    int getThickness(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$animateAlpha$0$androidx-core-view-insets-Protection, reason: not valid java name */
    public /* synthetic */ void m105lambda$animateAlpha$0$androidxcoreviewinsetsProtection(ValueAnimator valueAnimator) {
        setAlphaInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$animateInsetsAmount$1$androidx-core-view-insets-Protection, reason: not valid java name */
    public /* synthetic */ void m106x124db077(ValueAnimator valueAnimator) {
        setAlphaInternal(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean occupiesCorners() {
        return false;
    }

    public void setAlpha(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Alpha must in a range of [0, 1]. Got: " + f);
        }
        cancelUserAlphaAnimation();
        setAlphaInternal(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setController(Object obj) {
        this.mController = obj;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDrawable(Drawable drawable) {
        Attributes.m110$$Nest$msetDrawable(this.mAttributes, drawable);
    }

    public void setInsetAmount(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException("Inset amount must in a range of [0, 1]. Got: " + f);
        }
        cancelUserInsetsAmountAnimation();
        setInsetAmountInternal(f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSystemAlpha(float f) {
        this.mSystemAlpha = f;
        updateAlpha();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSystemInsetAmount(float f) {
        this.mSystemInsetAmount = f;
        updateInsetAmount();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setSystemVisible(boolean z) {
        Attributes.m115$$Nest$msetVisible(this.mAttributes, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Insets updateLayout() {
        int i;
        Insets insets = Insets.NONE;
        switch (this.mSide) {
            case 1:
                i = this.mInsets.left;
                Attributes.m116$$Nest$msetWidth(this.mAttributes, getThickness(this.mInsetsIgnoringVisibility.left));
                if (occupiesCorners()) {
                    insets = Insets.of(getThickness(i), 0, 0, 0);
                    break;
                }
                break;
            case 2:
                i = this.mInsets.top;
                Attributes.m111$$Nest$msetHeight(this.mAttributes, getThickness(this.mInsetsIgnoringVisibility.top));
                if (occupiesCorners()) {
                    insets = Insets.of(0, getThickness(i), 0, 0);
                    break;
                }
                break;
            case 4:
                i = this.mInsets.right;
                Attributes.m116$$Nest$msetWidth(this.mAttributes, getThickness(this.mInsetsIgnoringVisibility.right));
                if (occupiesCorners()) {
                    insets = Insets.of(0, 0, getThickness(i), 0);
                    break;
                }
                break;
            case 8:
                i = this.mInsets.bottom;
                Attributes.m111$$Nest$msetHeight(this.mAttributes, getThickness(this.mInsetsIgnoringVisibility.bottom));
                if (occupiesCorners()) {
                    insets = Insets.of(0, 0, 0, getThickness(i));
                    break;
                }
                break;
            default:
                i = 0;
                break;
        }
        setSystemVisible(i > 0);
        setSystemAlpha(i > 0 ? 1.0f : 0.0f);
        setSystemInsetAmount(i <= 0 ? 0.0f : 1.0f);
        return insets;
    }
}
