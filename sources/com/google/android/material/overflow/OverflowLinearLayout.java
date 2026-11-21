package com.google.android.material.overflow;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.appcompat.widget.PopupMenu;
import androidx.appcompat.widget.TintTypedArray;
import androidx.appcompat.widget.TooltipCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonGroup;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/* loaded from: classes.dex */
public class OverflowLinearLayout extends LinearLayout {
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_OverflowLinearLayout;
    private final MaterialButton overflowButton;
    private boolean overflowButtonAdded;
    private final Set<View> overflowViews;

    /* loaded from: classes.dex */
    public static class LayoutParams extends LinearLayout.LayoutParams {
        public Drawable overflowIcon;
        public CharSequence overflowText;

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.overflowIcon = null;
            this.overflowText = null;
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
            this.overflowIcon = null;
            this.overflowText = null;
        }

        public LayoutParams(int i, int i2, float f, Drawable drawable, CharSequence charSequence) {
            super(i, i2, f);
            this.overflowIcon = null;
            this.overflowText = null;
            this.overflowIcon = drawable;
            this.overflowText = charSequence;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.overflowIcon = null;
            this.overflowText = null;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OverflowLinearLayout_Layout);
            this.overflowIcon = obtainStyledAttributes.getDrawable(R.styleable.OverflowLinearLayout_Layout_layout_overflowIcon);
            this.overflowText = obtainStyledAttributes.getText(R.styleable.OverflowLinearLayout_Layout_layout_overflowText);
            obtainStyledAttributes.recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.overflowIcon = null;
            this.overflowText = null;
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.overflowIcon = null;
            this.overflowText = null;
        }

        public LayoutParams(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.overflowIcon = null;
            this.overflowText = null;
        }

        public LayoutParams(LayoutParams layoutParams) {
            super((LinearLayout.LayoutParams) layoutParams);
            this.overflowIcon = null;
            this.overflowText = null;
            this.overflowText = layoutParams.overflowText;
            this.overflowIcon = layoutParams.overflowIcon;
        }
    }

    public OverflowLinearLayout(Context context) {
        this(context, null);
    }

    public OverflowLinearLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.overflowLinearLayoutStyle);
    }

    public OverflowLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.overflowButtonAdded = false;
        this.overflowViews = new LinkedHashSet();
        Context context2 = getContext();
        TintTypedArray obtainTintedStyledAttributes = ThemeEnforcement.obtainTintedStyledAttributes(context2, attributeSet, R.styleable.OverflowLinearLayout, i, DEF_STYLE_RES, new int[0]);
        Drawable drawable = obtainTintedStyledAttributes.getDrawable(R.styleable.OverflowLinearLayout_overflowButtonIcon);
        obtainTintedStyledAttributes.recycle();
        this.overflowButton = (MaterialButton) LayoutInflater.from(context2).inflate(R.layout.m3_overflow_linear_layout_overflow_button, (ViewGroup) this, false);
        TooltipCompat.setTooltipText(this.overflowButton, getResources().getString(R.string.m3_overflow_linear_layout_button_tooltip_text));
        setOverflowButtonIcon(drawable);
        if (this.overflowButton.getContentDescription() == null) {
            this.overflowButton.setContentDescription(context2.getString(R.string.m3_overflow_linear_layout_button_content_description));
        }
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(this, R.attr.overflowLinearLayoutPopupMenuStyle);
        int i2 = Build.VERSION.SDK_INT;
        this.overflowButton.setOnClickListener(new OverflowLinearLayout$$ExternalSyntheticLambda1(this, new PopupMenu(getContext(), this.overflowButton, 17, 0, resolveOrThrow), context2.getResources().getDimensionPixelOffset(R.dimen.m3_overflow_item_icon_horizontal_padding)));
    }

    private int getChildSize(boolean z, View view, int i, int i2) {
        measureChild(view, i, i2);
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        int measuredWidth = z ? view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin : view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        if (measuredWidth == 0) {
            return z ? view.getMinimumWidth() + layoutParams.leftMargin + layoutParams.rightMargin : view.getMinimumHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
        }
        return measuredWidth;
    }

    private int getOverflowButtonSize(boolean z, View view, int i, int i2) {
        measureChild(view, i, i2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
        return z ? view.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin : view.getMeasuredHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    private void handleOverflowButtonClick(PopupMenu popupMenu, int i) {
        int i2;
        popupMenu.getMenu().clear();
        popupMenu.setForceShowIcon(true);
        for (View view : this.overflowViews) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            MenuItem add = popupMenu.getMenu().add(MaterialButtonGroup.OverflowUtils.getMenuItemText(view, layoutParams.overflowText));
            Drawable drawable = layoutParams.overflowIcon;
            if (drawable != null) {
                i2 = i;
                add.setIcon(new InsetDrawable(drawable, i2, 0, i, 0));
            } else {
                i2 = i;
            }
            if (view instanceof MaterialButton) {
                MaterialButton materialButton = (MaterialButton) view;
                add.setCheckable(materialButton.isCheckable());
                add.setChecked(materialButton.isChecked());
            }
            add.setEnabled(view.isEnabled());
            add.setOnMenuItemClickListener(new OverflowLinearLayout$$ExternalSyntheticLambda0(view, add));
            i = i2;
        }
        popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$handleOverflowButtonClick$1(View view, MenuItem menuItem, MenuItem menuItem2) {
        view.performClick();
        if (menuItem.isCheckable()) {
            menuItem.setChecked(!menuItem.isChecked());
        }
        return true;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return generateDefaultLayoutParams();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LayoutParams generateDefaultLayoutParams() {
        return getOrientation() == 0 ? new LayoutParams(-2, -2) : new LayoutParams(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateLayoutParams(attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateLayoutParams(attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected /* bridge */ /* synthetic */ LinearLayout.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return generateLayoutParams(layoutParams);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams ? new LayoutParams(layoutParams) : layoutParams instanceof LinearLayout.LayoutParams ? new LayoutParams((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public Drawable getOverflowButtonIcon() {
        return this.overflowButton.getIcon();
    }

    public Set<View> getOverflowedViews() {
        return this.overflowViews;
    }

    public boolean isOverflowed() {
        return !this.overflowViews.isEmpty();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-material-overflow-OverflowLinearLayout, reason: not valid java name */
    public /* synthetic */ void m391xc4d03947(PopupMenu popupMenu, int i, View view) {
        handleOverflowButtonClick(popupMenu, i);
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = 0;
        boolean z = getOrientation() == 0;
        int childCount = this.overflowButtonAdded ? getChildCount() - 1 : getChildCount();
        int size = z ? View.MeasureSpec.getSize(i) : View.MeasureSpec.getSize(i2);
        int i4 = 0;
        int overflowButtonSize = getOverflowButtonSize(z, this.overflowButton, i, i2);
        this.overflowButton.setVisibility(8);
        this.overflowViews.clear();
        boolean z2 = false;
        int i5 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = getChildAt(i5);
            childAt.setVisibility(i3);
            int childSize = getChildSize(z, childAt, i, i2);
            if (i4 + childSize + overflowButtonSize > size) {
                this.overflowViews.add(childAt);
            }
            if (i4 + childSize > size) {
                z2 = true;
                for (int i6 = i5 + 1; i6 < childCount; i6++) {
                    this.overflowViews.add(getChildAt(i6));
                }
            } else {
                i4 += childSize;
                i5++;
                i3 = 0;
            }
        }
        if (z2) {
            Iterator<View> it = this.overflowViews.iterator();
            while (it.hasNext()) {
                it.next().setVisibility(8);
            }
            if (!this.overflowButtonAdded) {
                addView(this.overflowButton);
                this.overflowButtonAdded = true;
            }
            this.overflowButton.setVisibility(0);
        } else {
            this.overflowButton.setVisibility(8);
            this.overflowViews.clear();
        }
        super.onMeasure(i, i2);
    }

    public void setOverflowButtonIcon(Drawable drawable) {
        this.overflowButton.setIcon(drawable);
    }

    public void setOverflowButtonIconResource(int i) {
        this.overflowButton.setIconResource(i);
    }
}
