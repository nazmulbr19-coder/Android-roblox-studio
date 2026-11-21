package com.google.android.material.floatingtoolbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

/* loaded from: classes.dex */
public class FloatingToolbarLayout extends FrameLayout {
    private int bottomMarginWindowInset;
    private int leftMarginWindowInset;
    private boolean marginBottomSystemWindowInsets;
    private boolean marginLeftSystemWindowInsets;
    private boolean marginRightSystemWindowInsets;
    private boolean marginTopSystemWindowInsets;
    private Rect originalMargins;
    private int rightMarginWindowInset;
    private int topMarginWindowInset;
    private static final String TAG = FloatingToolbarLayout.class.getSimpleName();
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_FloatingToolbar;

    /* renamed from: com.google.android.material.floatingtoolbar.FloatingToolbarLayout$1, reason: invalid class name */
    /* loaded from: classes.dex */
    class AnonymousClass1 implements OnApplyWindowInsetsListener {
        AnonymousClass1() {
        }

        @Override // androidx.core.view.OnApplyWindowInsetsListener
        public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
            if (!FloatingToolbarLayout.access$000(FloatingToolbarLayout.this) && !FloatingToolbarLayout.access$100(FloatingToolbarLayout.this) && !FloatingToolbarLayout.access$200(FloatingToolbarLayout.this) && !FloatingToolbarLayout.access$300(FloatingToolbarLayout.this)) {
                return windowInsetsCompat;
            }
            Insets insets = windowInsetsCompat.getInsets(WindowInsetsCompat.Type.systemBars() | WindowInsetsCompat.Type.displayCutout() | WindowInsetsCompat.Type.ime());
            FloatingToolbarLayout.access$402(FloatingToolbarLayout.this, insets.bottom);
            FloatingToolbarLayout.access$502(FloatingToolbarLayout.this, insets.top);
            FloatingToolbarLayout.access$602(FloatingToolbarLayout.this, insets.right);
            FloatingToolbarLayout.access$702(FloatingToolbarLayout.this, insets.left);
            FloatingToolbarLayout.access$800(FloatingToolbarLayout.this);
            return windowInsetsCompat;
        }
    }

    public FloatingToolbarLayout(Context context) {
        this(context, null);
    }

    public FloatingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.floatingToolbarStyle);
    }

    public FloatingToolbarLayout(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, DEF_STYLE_RES);
    }

    public FloatingToolbarLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, i2), attributeSet, i);
        Context context2 = getContext();
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.FloatingToolbar, i, i2, new int[0]);
        if (obtainTintedStyledAttributes.hasValue(R.styleable.FloatingToolbar_backgroundTint)) {
            int color = obtainTintedStyledAttributes.getColor(R.styleable.FloatingToolbar_backgroundTint, 0);
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(context2, attributeSet, i, i2).build());
            materialShapeDrawable.setFillColor(ColorStateList.valueOf(color));
            setBackground(materialShapeDrawable);
        }
        this.marginLeftSystemWindowInsets = obtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginLeftSystemWindowInsets, true);
        this.marginTopSystemWindowInsets = obtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginTopSystemWindowInsets, false);
        this.marginRightSystemWindowInsets = obtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginRightSystemWindowInsets, true);
        this.marginBottomSystemWindowInsets = obtainTintedStyledAttributes.getBoolean(R.styleable.FloatingToolbar_marginBottomSystemWindowInsets, true);
        ViewCompat.setOnApplyWindowInsetsListener(this, new AnonymousClass1());
        obtainTintedStyledAttributes.recycle();
    }

    static /* synthetic */ boolean access$000(FloatingToolbarLayout floatingToolbarLayout) {
        return floatingToolbarLayout.marginLeftSystemWindowInsets;
    }

    static /* synthetic */ boolean access$100(FloatingToolbarLayout floatingToolbarLayout) {
        return floatingToolbarLayout.marginRightSystemWindowInsets;
    }

    static /* synthetic */ boolean access$200(FloatingToolbarLayout floatingToolbarLayout) {
        return floatingToolbarLayout.marginTopSystemWindowInsets;
    }

    static /* synthetic */ boolean access$300(FloatingToolbarLayout floatingToolbarLayout) {
        return floatingToolbarLayout.marginBottomSystemWindowInsets;
    }

    static /* synthetic */ int access$402(FloatingToolbarLayout floatingToolbarLayout, int i) {
        floatingToolbarLayout.bottomMarginWindowInset = i;
        return i;
    }

    static /* synthetic */ int access$502(FloatingToolbarLayout floatingToolbarLayout, int i) {
        floatingToolbarLayout.topMarginWindowInset = i;
        return i;
    }

    static /* synthetic */ int access$602(FloatingToolbarLayout floatingToolbarLayout, int i) {
        floatingToolbarLayout.rightMarginWindowInset = i;
        return i;
    }

    static /* synthetic */ int access$702(FloatingToolbarLayout floatingToolbarLayout, int i) {
        floatingToolbarLayout.leftMarginWindowInset = i;
        return i;
    }

    static /* synthetic */ void access$800(FloatingToolbarLayout floatingToolbarLayout) {
        floatingToolbarLayout.updateMargins();
    }

    private void updateMargins() {
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.originalMargins == null) {
            Log.w(TAG, "Unable to update margins because original view margins are not set");
            return;
        }
        int i = this.originalMargins.left + (this.marginLeftSystemWindowInsets ? this.leftMarginWindowInset : 0);
        int i2 = this.originalMargins.right + (this.marginRightSystemWindowInsets ? this.rightMarginWindowInset : 0);
        int i3 = this.originalMargins.top + (this.marginTopSystemWindowInsets ? this.topMarginWindowInset : 0);
        int i4 = this.originalMargins.bottom + (this.marginBottomSystemWindowInsets ? this.bottomMarginWindowInset : 0);
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        if ((marginLayoutParams.bottomMargin == i4 && marginLayoutParams.leftMargin == i && marginLayoutParams.rightMargin == i2 && marginLayoutParams.topMargin == i3) ? false : true) {
            marginLayoutParams.bottomMargin = i4;
            marginLayoutParams.leftMargin = i;
            marginLayoutParams.rightMargin = i2;
            marginLayoutParams.topMargin = i3;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setLayoutParams(ViewGroup.LayoutParams layoutParams) {
        super.setLayoutParams(layoutParams);
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            this.originalMargins = null;
            return;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        this.originalMargins = new Rect(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, marginLayoutParams.bottomMargin);
        updateMargins();
    }
}
