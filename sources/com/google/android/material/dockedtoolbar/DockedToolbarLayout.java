package com.google.android.material.dockedtoolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.TintTypedArray;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.Insets;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes.dex */
public class DockedToolbarLayout extends FrameLayout {
    private Boolean paddingBottomSystemWindowInsets;
    private Boolean paddingTopSystemWindowInsets;
    private static final String TAG = DockedToolbarLayout.class.getSimpleName();
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_DockedToolbar;

    /* renamed from: com.google.android.material.dockedtoolbar.DockedToolbarLayout$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements ViewUtils.OnApplyWindowInsetsListener {
        AnonymousClass1() {
        }

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat, ViewUtils.RelativePadding relativePadding) {
            if (DockedToolbarLayout.access$000(DockedToolbarLayout.this) != null && DockedToolbarLayout.access$100(DockedToolbarLayout.this) != null && !DockedToolbarLayout.access$000(DockedToolbarLayout.this).booleanValue() && !DockedToolbarLayout.access$100(DockedToolbarLayout.this).booleanValue()) {
                return windowInsetsCompat;
            }
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
            int i = insets.bottom;
            int i2 = insets.top;
            int i3 = 0;
            int i4 = 0;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (DockedToolbarLayout.access$200(DockedToolbarLayout.this, layoutParams, 48) && DockedToolbarLayout.access$000(DockedToolbarLayout.this) == null && DockedToolbarLayout.this.getFitsSystemWindows()) {
                i4 = i2;
            }
            if (DockedToolbarLayout.access$200(DockedToolbarLayout.this, layoutParams, 80) && DockedToolbarLayout.access$100(DockedToolbarLayout.this) == null && DockedToolbarLayout.this.getFitsSystemWindows()) {
                i3 = i;
            }
            if (DockedToolbarLayout.access$100(DockedToolbarLayout.this) != null) {
                i3 = DockedToolbarLayout.access$100(DockedToolbarLayout.this).booleanValue() ? i : 0;
            }
            if (DockedToolbarLayout.access$000(DockedToolbarLayout.this) != null) {
                i4 = DockedToolbarLayout.access$000(DockedToolbarLayout.this).booleanValue() ? i2 : 0;
            }
            relativePadding.top += i4;
            relativePadding.bottom += i3;
            relativePadding.applyToView(view);
            return windowInsetsCompat;
        }
    }

    public DockedToolbarLayout(Context context) {
        this(context, null);
    }

    public DockedToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.dockedToolbarStyle);
    }

    public DockedToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, DEF_STYLE_RES);
    }

    public DockedToolbarLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.DockedToolbar, i, i2, new int[0]);
        if (obtainTintedStyledAttributes.hasValue(R.styleable.DockedToolbar_backgroundTint)) {
            int color = obtainTintedStyledAttributes.getColor(R.styleable.DockedToolbar_backgroundTint, 0);
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context2, attributeSet, i, i2).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
            setBackground(materialShapeDrawable);
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.DockedToolbar_paddingTopSystemWindowInsets)) {
            this.paddingTopSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(R.styleable.DockedToolbar_paddingTopSystemWindowInsets, true));
        }
        if (obtainTintedStyledAttributes.hasValue(R.styleable.DockedToolbar_paddingBottomSystemWindowInsets)) {
            this.paddingBottomSystemWindowInsets = Boolean.valueOf(obtainTintedStyledAttributes.getBoolean(R.styleable.DockedToolbar_paddingBottomSystemWindowInsets, true));
        }
        ViewUtils.doOnApplyWindowInsets(this, new AnonymousClass1());
        setImportantForAccessibility(1);
        obtainTintedStyledAttributes.recycle();
    }

    static /* synthetic */ Boolean access$000(DockedToolbarLayout dockedToolbarLayout) {
        return dockedToolbarLayout.paddingTopSystemWindowInsets;
    }

    static /* synthetic */ Boolean access$100(DockedToolbarLayout dockedToolbarLayout) {
        return dockedToolbarLayout.paddingBottomSystemWindowInsets;
    }

    static /* synthetic */ boolean access$200(DockedToolbarLayout dockedToolbarLayout, ViewGroup.LayoutParams layoutParams, int i) {
        return dockedToolbarLayout.hasGravity(layoutParams, i);
    }

    private boolean hasGravity(ViewGroup.LayoutParams layoutParams, int i) {
        return layoutParams instanceof CoordinatorLayout.LayoutParams ? (((CoordinatorLayout.LayoutParams) layoutParams).gravity & i) == i : (layoutParams instanceof FrameLayout.LayoutParams) && (((FrameLayout.LayoutParams) layoutParams).gravity & i) == i;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (View.MeasureSpec.getMode(i2) != 1073741824) {
            int childCount = getChildCount();
            int max = Math.max(getMeasuredHeight(), getSuggestedMinimumHeight() + getPaddingTop() + getPaddingBottom());
            for (int i3 = 0; i3 < childCount; i3++) {
                measureChild(getChildAt(i3), i, View.MeasureSpec.makeMeasureSpec(max, BasicMeasure.EXACTLY));
            }
            setMeasuredDimension(getMeasuredWidth(), max);
        }
    }
}
