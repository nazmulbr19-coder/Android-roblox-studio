package com.google.android.material.loadingindicator;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ProgressBar;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.google.android.material.R;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.progressindicator.AnimatorDurationScaleProvider;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class LoadingIndicator extends View implements Drawable.Callback {
    static final int DEF_STYLE_RES = R.style.Widget_Material3_LoadingIndicator;
    static final int MAX_HIDE_DELAY = 1000;
    private final Runnable delayedHide;
    private final Runnable delayedShow;
    private final LoadingIndicatorDrawable drawable;
    private long lastShowStartTime;
    private final int minHideDelay;
    private final int showDelay;
    private final LoadingIndicatorSpec specs;

    /* renamed from: com.google.android.material.loadingindicator.LoadingIndicator$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingIndicator.access$000(LoadingIndicator.this);
        }
    }

    /* renamed from: com.google.android.material.loadingindicator.LoadingIndicator$2, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass2 implements Runnable {
        AnonymousClass2() {
        }

        @Override // java.lang.Runnable
        public void run() {
            LoadingIndicator.access$100(LoadingIndicator.this);
            LoadingIndicator.access$202(LoadingIndicator.this, -1L);
        }
    }

    public LoadingIndicator(Context context) {
        this(context, null);
    }

    public LoadingIndicator(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.loadingIndicatorStyle);
    }

    public LoadingIndicator(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.lastShowStartTime = -1L;
        this.delayedShow = new AnonymousClass1();
        this.delayedHide = new AnonymousClass2();
        Context context2 = getContext();
        this.drawable = LoadingIndicatorDrawable.create(context2, new LoadingIndicatorSpec(context2, attributeSet, i));
        this.drawable.setCallback(this);
        this.specs = this.drawable.getDrawingDelegate().specs;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.LoadingIndicator, i, DEF_STYLE_RES, new int[0]);
        this.showDelay = obtainStyledAttributes.getInt(R.styleable.LoadingIndicator_showDelay, -1);
        this.minHideDelay = Math.min(obtainStyledAttributes.getInt(R.styleable.LoadingIndicator_minHideDelay, -1), 1000);
        obtainStyledAttributes.recycle();
        setAnimatorDurationScaleProvider(new AnimatorDurationScaleProvider());
    }

    static /* synthetic */ void access$000(LoadingIndicator loadingIndicator) {
        loadingIndicator.internalShow();
    }

    static /* synthetic */ void access$100(LoadingIndicator loadingIndicator) {
        loadingIndicator.internalHide();
    }

    static /* synthetic */ long access$202(LoadingIndicator loadingIndicator, long j) {
        loadingIndicator.lastShowStartTime = j;
        return j;
    }

    private void internalHide() {
        getDrawable().setVisible(false, false, true);
        if (getDrawable().isVisible()) {
            return;
        }
        setVisibility(4);
    }

    private void internalShow() {
        if (this.minHideDelay > 0) {
            this.lastShowStartTime = SystemClock.uptimeMillis();
        }
        setVisibility(0);
    }

    @Override // android.view.View
    public CharSequence getAccessibilityClassName() {
        return ProgressBar.class.getName();
    }

    public int getContainerColor() {
        return this.specs.containerColor;
    }

    public int getContainerHeight() {
        return this.specs.containerHeight;
    }

    public int getContainerWidth() {
        return this.specs.containerWidth;
    }

    public LoadingIndicatorDrawable getDrawable() {
        return this.drawable;
    }

    public int[] getIndicatorColor() {
        return this.specs.indicatorColors;
    }

    public int getIndicatorSize() {
        return this.specs.indicatorSize;
    }

    public void hide() {
        if (getVisibility() != 0) {
            removeCallbacks(this.delayedShow);
            return;
        }
        removeCallbacks(this.delayedHide);
        long uptimeMillis = SystemClock.uptimeMillis() - this.lastShowStartTime;
        if (uptimeMillis >= ((long) this.minHideDelay)) {
            this.delayedHide.run();
        } else {
            postDelayed(this.delayedHide, this.minHideDelay - uptimeMillis);
        }
    }

    @Override // android.view.View, android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidate();
    }

    boolean isEffectivelyVisible() {
        View view = this;
        while (view.getVisibility() == 0) {
            Object parent = view.getParent();
            if (parent == null) {
                return getWindowVisibility() == 0;
            }
            if (!(parent instanceof View)) {
                return true;
            }
            view = (View) parent;
        }
        return false;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (visibleToUser()) {
            internalShow();
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int save = canvas.save();
        if (getPaddingLeft() != 0 || getPaddingTop() != 0) {
            canvas.translate(getPaddingLeft(), getPaddingTop());
        }
        if (getPaddingRight() != 0 || getPaddingBottom() != 0) {
            canvas.clipRect(0, 0, getWidth() - (getPaddingLeft() + getPaddingRight()), getHeight() - (getPaddingTop() + getPaddingBottom()));
        }
        this.drawable.draw(canvas);
        canvas.restoreToCount(save);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        LoadingIndicatorDrawingDelegate drawingDelegate = this.drawable.getDrawingDelegate();
        int preferredWidth = drawingDelegate.getPreferredWidth() + getPaddingLeft() + getPaddingRight();
        int preferredHeight = drawingDelegate.getPreferredHeight() + getPaddingTop() + getPaddingBottom();
        if (mode == Integer.MIN_VALUE) {
            i = View.MeasureSpec.makeMeasureSpec(Math.min(size, preferredWidth), BasicMeasure.EXACTLY);
        } else if (mode == 0) {
            i = View.MeasureSpec.makeMeasureSpec(preferredWidth, BasicMeasure.EXACTLY);
        }
        if (mode2 == Integer.MIN_VALUE) {
            i2 = View.MeasureSpec.makeMeasureSpec(Math.min(size2, preferredHeight), BasicMeasure.EXACTLY);
        } else if (mode2 == 0) {
            i2 = View.MeasureSpec.makeMeasureSpec(preferredHeight, BasicMeasure.EXACTLY);
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.drawable.setBounds(0, 0, i, i2);
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        this.drawable.setVisible(visibleToUser(), false, i == 0);
    }

    @Override // android.view.View
    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.drawable.setVisible(visibleToUser(), false, i == 0);
    }

    public void setAnimatorDurationScaleProvider(AnimatorDurationScaleProvider animatorDurationScaleProvider) {
        this.drawable.animatorDurationScaleProvider = animatorDurationScaleProvider;
    }

    public void setContainerColor(int i) {
        if (this.specs.containerColor != i) {
            this.specs.containerColor = i;
            invalidate();
        }
    }

    public void setContainerHeight(int i) {
        if (this.specs.containerHeight != i) {
            this.specs.containerHeight = i;
            requestLayout();
            invalidate();
        }
    }

    public void setContainerWidth(int i) {
        if (this.specs.containerWidth != i) {
            this.specs.containerWidth = i;
            requestLayout();
            invalidate();
        }
    }

    public void setIndicatorColor(int... iArr) {
        if (iArr.length == 0) {
            iArr = new int[]{MaterialColors.getColor(getContext(), androidx.appcompat.R.attr.colorPrimary, -1)};
        }
        if (Arrays.equals(getIndicatorColor(), iArr)) {
            return;
        }
        this.specs.indicatorColors = iArr;
        this.drawable.getAnimatorDelegate().invalidateSpecValues();
        invalidate();
    }

    public void setIndicatorSize(int i) {
        if (this.specs.indicatorSize != i) {
            this.specs.indicatorSize = i;
            requestLayout();
            invalidate();
        }
    }

    public void show() {
        if (this.showDelay <= 0) {
            this.delayedShow.run();
        } else {
            removeCallbacks(this.delayedShow);
            postDelayed(this.delayedShow, this.showDelay);
        }
    }

    boolean visibleToUser() {
        return isAttachedToWindow() && getWindowVisibility() == 0 && isEffectivelyVisible();
    }
}
