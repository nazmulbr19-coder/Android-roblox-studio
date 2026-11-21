package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import androidx.appcompat.widget.PopupMenu;
import androidx.core.view.GravityCompat;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialAttributes;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearance;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.StateListCornerSize;
import com.google.android.material.shape.StateListShapeAppearanceModel;
import com.google.android.material.shape.StateListSizeChange;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* loaded from: classes.dex */
public class MaterialButtonGroup extends LinearLayout {
    private static final String LOG_TAG = "MButtonGroup";
    public static final int OVERFLOW_MODE_MENU = 1;
    public static final int OVERFLOW_MODE_NONE = 0;
    public static final int OVERFLOW_MODE_WRAP = 2;
    private boolean buttonOverflowInitialized;
    private StateListSizeChange buttonSizeChange;
    private final Map<Button, MenuItem> buttonToMenuItemMapping;
    private Integer[] childOrder;
    private final Comparator<MaterialButton> childOrderComparator;
    private boolean childShapesDirty;
    private StateListShapeAppearanceModel groupStateListShapeAppearance;
    StateListCornerSize innerCornerSize;
    private final List<ShapeAppearance> originalChildShapeAppearanceModels;
    private MaterialButton overflowButton;
    private final List<Button> overflowButtonsList;
    private final int overflowMenuItemIconPadding;
    private int overflowMode;
    private PopupMenu popupMenu;
    private final Map<Integer, Button> popupMenuItemToButtonMapping;
    private final PressedStateTracker pressedStateTracker;
    private final List<Integer> rowButtonFirstIndices;
    private int spacing;
    private final List<Button> tempOverflowButtonsList;
    private static final int DEF_STYLE_RES = R.style.Widget_Material3_MaterialButtonGroup;
    public static final Object OVERFLOW_BUTTON_TAG = new Object();

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
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialButtonGroup_Layout);
            this.overflowIcon = obtainStyledAttributes.getDrawable(R.styleable.MaterialButtonGroup_Layout_layout_overflowIcon);
            this.overflowText = obtainStyledAttributes.getText(R.styleable.MaterialButtonGroup_Layout_layout_overflowText);
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

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes.dex */
    public @interface OverflowMode {
    }

    /* loaded from: classes.dex */
    public static class OverflowUtils {
        private OverflowUtils() {
        }

        public static CharSequence getMenuItemText(View view, CharSequence charSequence) {
            return !TextUtils.isEmpty(charSequence) ? charSequence : (!(view instanceof MaterialButton) || TextUtils.isEmpty(((MaterialButton) view).getText())) ? view.getContentDescription() : ((MaterialButton) view).getText();
        }
    }

    /* loaded from: classes.dex */
    private class PressedStateTracker implements MaterialButton.OnPressedChangeListener {
        private PressedStateTracker() {
        }

        /* synthetic */ PressedStateTracker(MaterialButtonGroup materialButtonGroup, AnonymousClass1 anonymousClass1) {
            this();
        }

        @Override // com.google.android.material.button.MaterialButton.OnPressedChangeListener
        public void onPressedChanged(MaterialButton materialButton, boolean z) {
            MaterialButtonGroup.this.invalidate();
        }
    }

    public MaterialButtonGroup(Context context) {
        this(context, null);
    }

    public MaterialButtonGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.materialButtonGroupStyle);
    }

    public MaterialButtonGroup(Context context, AttributeSet attributeSet, int i) {
        super(MaterialThemeOverlay.wrap(context, attributeSet, i, DEF_STYLE_RES), attributeSet, i);
        this.overflowMode = 0;
        this.originalChildShapeAppearanceModels = new ArrayList();
        this.pressedStateTracker = new PressedStateTracker(this, null);
        this.childOrderComparator = new MaterialButtonGroup$$ExternalSyntheticLambda1(this);
        this.childShapesDirty = true;
        this.popupMenuItemToButtonMapping = new HashMap();
        this.buttonToMenuItemMapping = new HashMap();
        this.tempOverflowButtonsList = new ArrayList();
        this.overflowButtonsList = new ArrayList();
        this.rowButtonFirstIndices = new ArrayList();
        Context context2 = getContext();
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.MaterialButtonGroup, i, DEF_STYLE_RES, new int[0]);
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialButtonGroup_buttonSizeChange)) {
            this.buttonSizeChange = StateListSizeChange.create(context2, obtainStyledAttributes, R.styleable.MaterialButtonGroup_buttonSizeChange);
        }
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialButtonGroup_shapeAppearance)) {
            this.groupStateListShapeAppearance = StateListShapeAppearanceModel.create(context2, obtainStyledAttributes, R.styleable.MaterialButtonGroup_shapeAppearance);
            if (this.groupStateListShapeAppearance == null) {
                this.groupStateListShapeAppearance = new StateListShapeAppearanceModel.Builder(ShapeAppearanceModel.builder(context2, obtainStyledAttributes.getResourceId(R.styleable.MaterialButtonGroup_shapeAppearance, 0), obtainStyledAttributes.getResourceId(R.styleable.MaterialButtonGroup_shapeAppearanceOverlay, 0)).build()).build();
            }
        }
        if (obtainStyledAttributes.hasValue(R.styleable.MaterialButtonGroup_innerCornerSize)) {
            this.innerCornerSize = StateListCornerSize.create(context2, obtainStyledAttributes, R.styleable.MaterialButtonGroup_innerCornerSize, new AbsoluteCornerSize(0.0f));
        }
        this.spacing = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialButtonGroup_android_spacing, 0);
        setChildrenDrawingOrderEnabled(true);
        setEnabled(obtainStyledAttributes.getBoolean(R.styleable.MaterialButtonGroup_android_enabled, true));
        setOverflowMode(obtainStyledAttributes.getInt(R.styleable.MaterialButtonGroup_overflowMode, 0));
        this.overflowMenuItemIconPadding = getResources().getDimensionPixelOffset(R.dimen.m3_btn_group_overflow_item_icon_horizontal_padding);
        if (isOverflowMenuSupported()) {
            initializeButtonOverflow(context2, obtainStyledAttributes);
        }
        obtainStyledAttributes.recycle();
    }

    private MenuItem addMenuItemForButton(Menu menu, Button button) {
        if (!(button.getLayoutParams() instanceof LayoutParams)) {
            return null;
        }
        LayoutParams layoutParams = (LayoutParams) button.getLayoutParams();
        CharSequence menuItemText = OverflowUtils.getMenuItemText(button, layoutParams.overflowText);
        Drawable drawable = layoutParams.overflowIcon;
        MenuItem add = menu.add(menuItemText);
        if (drawable != null) {
            add.setIcon(new InsetDrawable(drawable, this.overflowMenuItemIconPadding, 0, this.overflowMenuItemIconPadding, 0));
        }
        add.setOnMenuItemClickListener(new MaterialButtonGroup$$ExternalSyntheticLambda2(button));
        return add;
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i = firstVisibleChildIndex + 1; i < getChildCount(); i++) {
            int i2 = 0;
            View childAt = getChildAt(i);
            View childAt2 = getChildAt(i - 1);
            if ((childAt instanceof MaterialButton) && (childAt2 instanceof MaterialButton)) {
                MaterialButton materialButton = (MaterialButton) childAt;
                MaterialButton materialButton2 = (MaterialButton) childAt2;
                if (this.spacing <= 0) {
                    i2 = Math.min(materialButton.getStrokeWidth(), materialButton2.getStrokeWidth());
                    materialButton.setShouldDrawSurfaceColorStroke(true);
                    materialButton2.setShouldDrawSurfaceColorStroke(true);
                } else {
                    materialButton.setShouldDrawSurfaceColorStroke(false);
                    materialButton2.setShouldDrawSurfaceColorStroke(false);
                }
            }
            LinearLayout.LayoutParams buildLayoutParams = buildLayoutParams(childAt);
            if (getOrientation() == 0) {
                buildLayoutParams.setMarginEnd(0);
                buildLayoutParams.setMarginStart(this.spacing - i2);
                buildLayoutParams.topMargin = 0;
            } else {
                buildLayoutParams.bottomMargin = 0;
                buildLayoutParams.topMargin = this.spacing - i2;
                buildLayoutParams.setMarginStart(0);
            }
            childAt.setLayoutParams(buildLayoutParams);
        }
        resetChildMargins(firstVisibleChildIndex);
    }

    private void adjustChildSizeChange() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        if (firstVisibleChildIndex == -1 || this.buttonSizeChange == null) {
            return;
        }
        if (this.overflowMode != 2) {
            adjustChildSizeChangeInRange(firstVisibleChildIndex, lastVisibleChildIndex);
            return;
        }
        int i = 0;
        while (i < this.rowButtonFirstIndices.size()) {
            adjustChildSizeChangeInRange(this.rowButtonFirstIndices.get(i).intValue(), (i == this.rowButtonFirstIndices.size() + (-1) ? getChildCount() : this.rowButtonFirstIndices.get(i + 1).intValue()) - 1);
            i++;
        }
    }

    private void adjustChildSizeChangeInRange(int i, int i2) {
        if (i == i2) {
            getChildButton(i).setWidthChangeDirection(MaterialButton.WidthChangeDirection.NONE);
            return;
        }
        int i3 = Integer.MAX_VALUE;
        int i4 = i;
        while (i4 <= i2) {
            if (isChildVisible(i4)) {
                getChildButton(i4).setWidthChangeDirection(i4 == i ? MaterialButton.WidthChangeDirection.END : i4 == i2 ? MaterialButton.WidthChangeDirection.START : MaterialButton.WidthChangeDirection.BOTH);
                int buttonAllowedWidthIncrease = getButtonAllowedWidthIncrease(i4);
                i3 = Math.min(i3, (i4 == i || i4 == i2) ? buttonAllowedWidthIncrease : buttonAllowedWidthIncrease / 2);
            }
            i4++;
        }
        for (int i5 = i; i5 <= i2; i5++) {
            if (isChildVisible(i5)) {
                MaterialButton childButton = getChildButton(i5);
                childButton.setSizeChange(this.buttonSizeChange);
                childButton.setWidthChangeMax(i3 * 2);
            }
        }
    }

    private int getButtonAllowedWidthIncrease(int i) {
        if (!isChildVisible(i) || this.buttonSizeChange == null) {
            return 0;
        }
        int max = Math.max(0, this.buttonSizeChange.getMaxWidthChange(getChildButton(i).getWidth()));
        MaterialButton prevVisibleChildButton = getPrevVisibleChildButton(i, true);
        int allowedWidthDecrease = prevVisibleChildButton == null ? 0 : prevVisibleChildButton.getAllowedWidthDecrease();
        MaterialButton nextVisibleChildButton = getNextVisibleChildButton(i, true);
        return Math.min(max, allowedWidthDecrease + (nextVisibleChildButton != null ? nextVisibleChildButton.getAllowedWidthDecrease() : 0));
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (isChildVisible(i)) {
                return i;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (isChildVisible(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private MaterialButton getNextVisibleChildButton(int i) {
        return getNextVisibleChildButton(i, false);
    }

    private MaterialButton getNextVisibleChildButton(int i, boolean z) {
        int childCount = getChildCount();
        int i2 = -1;
        int i3 = i + 1;
        while (true) {
            if (i3 >= childCount) {
                break;
            }
            if (isChildVisible(i3)) {
                i2 = i3;
                break;
            }
            i3++;
        }
        if (z && !this.rowButtonFirstIndices.isEmpty()) {
            int i4 = 0;
            while (i4 < this.rowButtonFirstIndices.size()) {
                int intValue = this.rowButtonFirstIndices.get(i4).intValue();
                int intValue2 = i4 == this.rowButtonFirstIndices.size() + (-1) ? childCount - 1 : this.rowButtonFirstIndices.get(i4 + 1).intValue() - 1;
                if (i >= intValue && i <= intValue2 && (i2 < intValue || i2 > intValue2)) {
                    return null;
                }
                i4++;
            }
        }
        if (i2 != -1) {
            return getChildButton(i2);
        }
        return null;
    }

    private StateListShapeAppearanceModel.Builder getOriginalStateListShapeBuilder(boolean z, boolean z2, int i) {
        Object obj = (this.groupStateListShapeAppearance == null || !(z || z2)) ? (ShapeAppearance) this.originalChildShapeAppearanceModels.get(i) : this.groupStateListShapeAppearance;
        return !(obj instanceof StateListShapeAppearanceModel) ? new StateListShapeAppearanceModel.Builder((ShapeAppearanceModel) this.originalChildShapeAppearanceModels.get(i)) : ((StateListShapeAppearanceModel) obj).toBuilder();
    }

    private MaterialButton getPrevVisibleChildButton(int i) {
        return getPrevVisibleChildButton(i, false);
    }

    private MaterialButton getPrevVisibleChildButton(int i, boolean z) {
        int childCount = getChildCount();
        int i2 = -1;
        int i3 = i - 1;
        while (true) {
            if (i3 < 0) {
                break;
            }
            if (isChildVisible(i3)) {
                i2 = i3;
                break;
            }
            i3--;
        }
        if (z && !this.rowButtonFirstIndices.isEmpty()) {
            int i4 = 0;
            while (i4 < this.rowButtonFirstIndices.size()) {
                int intValue = this.rowButtonFirstIndices.get(i4).intValue();
                int intValue2 = i4 == this.rowButtonFirstIndices.size() + (-1) ? childCount : this.rowButtonFirstIndices.get(i4 + 1).intValue();
                if (i >= intValue && i < intValue2 && (i2 < intValue || i2 >= intValue2)) {
                    return null;
                }
                i4++;
            }
        }
        if (i2 != -1) {
            return getChildButton(i2);
        }
        return null;
    }

    private boolean isChildVisible(int i) {
        return getChildAt(i).getVisibility() != 8;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ boolean lambda$addMenuItemForButton$2(Button button, MenuItem menuItem) {
        button.performClick();
        return true;
    }

    private void maybeUpdateOverflowMenu(int i, int i2) {
        if (this.buttonOverflowInitialized) {
            if (this.overflowMode != 1) {
                this.overflowButton.setVisibility(8);
                return;
            }
            boolean z = getOrientation() == 0;
            this.tempOverflowButtonsList.clear();
            int size = z ? View.MeasureSpec.getSize(i) : View.MeasureSpec.getSize(i2);
            int measureAndGetChildButtonSize = measureAndGetChildButtonSize(z, this.overflowButton, i, i2);
            int i3 = 0;
            boolean z2 = false;
            int i4 = 0;
            while (true) {
                if (i4 >= getChildCount() - 1) {
                    break;
                }
                MaterialButton childButton = getChildButton(i4);
                int measureAndGetChildButtonSize2 = measureAndGetChildButtonSize(z, childButton, i, i2);
                if (i3 + measureAndGetChildButtonSize2 + measureAndGetChildButtonSize > size) {
                    this.tempOverflowButtonsList.add(childButton);
                }
                if (i3 + measureAndGetChildButtonSize2 > size) {
                    z2 = true;
                    for (int i5 = i4 + 1; i5 < getChildCount() - 1; i5++) {
                        this.tempOverflowButtonsList.add(getChildButton(i5));
                    }
                } else {
                    i3 += measureAndGetChildButtonSize2;
                    i4++;
                }
            }
            if (z2) {
                this.overflowButton.setVisibility(0);
            } else {
                this.overflowButton.setVisibility(8);
                this.tempOverflowButtonsList.clear();
            }
            maybeUpdateOverflowMenuItemsAndChildVisibility();
        }
    }

    private void maybeUpdateOverflowMenuItemsAndChildVisibility() {
        if (this.tempOverflowButtonsList.equals(this.overflowButtonsList)) {
            return;
        }
        for (int i = 0; i < getChildCount() - 1; i++) {
            MaterialButton childButton = getChildButton(i);
            if (this.buttonToMenuItemMapping.containsKey(childButton)) {
                childButton.setVisibility(0);
            }
        }
        this.overflowButtonsList.clear();
        this.overflowButtonsList.addAll(this.tempOverflowButtonsList);
        Menu menu = this.popupMenu.getMenu();
        this.popupMenuItemToButtonMapping.clear();
        this.buttonToMenuItemMapping.clear();
        menu.clear();
        for (Button button : this.overflowButtonsList) {
            MenuItem addMenuItemForButton = addMenuItemForButton(menu, button);
            if (addMenuItemForButton != null) {
                this.popupMenuItemToButtonMapping.put(Integer.valueOf(addMenuItemForButton.getItemId()), button);
                this.buttonToMenuItemMapping.put(button, addMenuItemForButton);
                button.setVisibility(8);
            }
        }
        updateOverflowMenuItemsState();
    }

    private int maybeWrapButtons(int i, int i2) {
        int i3;
        MaterialButtonGroup materialButtonGroup = this;
        materialButtonGroup.rowButtonFirstIndices.clear();
        int size = View.MeasureSpec.getSize(i);
        ArrayList arrayList = new ArrayList();
        int i4 = 0;
        int i5 = 0;
        ArrayList arrayList2 = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        while (i7 < materialButtonGroup.getChildCount()) {
            if (materialButtonGroup.isChildVisible(i7)) {
                MaterialButton childButton = materialButtonGroup.getChildButton(i7);
                materialButtonGroup.measureChild(childButton, i, i2);
                int measuredWidth = childButton.getMeasuredWidth();
                int measuredHeight = childButton.getMeasuredHeight();
                if (measuredWidth > 0) {
                    LinearLayout.LayoutParams buildLayoutParams = materialButtonGroup.buildLayoutParams(childButton);
                    if (i4 + measuredWidth + (arrayList.isEmpty() ? 0 : materialButtonGroup.spacing) > size || arrayList.isEmpty()) {
                        if (!arrayList.isEmpty()) {
                            arrayList2.add(Integer.valueOf(i4));
                        }
                        i6 += (materialButtonGroup.rowButtonFirstIndices.isEmpty() ? 0 : materialButtonGroup.spacing) + i5;
                        i3 = size;
                        materialButtonGroup.rowButtonFirstIndices.add(Integer.valueOf(i7));
                        buildLayoutParams.setMarginStart(-i4);
                        arrayList.clear();
                        i4 = 0;
                        i5 = 0;
                    } else {
                        i3 = size;
                    }
                    i4 += measuredWidth + (i4 != 0 ? materialButtonGroup.spacing : 0);
                    int max = Math.max(i5, measuredHeight);
                    arrayList.add(Integer.valueOf(i7));
                    buildLayoutParams.topMargin += i6;
                    childButton.setLayoutParams(buildLayoutParams);
                    i5 = max;
                    i7++;
                    size = i3;
                }
            }
            i3 = size;
            i7++;
            size = i3;
        }
        arrayList2.add(Integer.valueOf(i4));
        int i8 = 0;
        int intValue = ((Integer) Collections.max(arrayList2)).intValue();
        int i9 = 0;
        while (i9 < materialButtonGroup.rowButtonFirstIndices.size()) {
            int intValue2 = materialButtonGroup.rowButtonFirstIndices.get(i9).intValue();
            int intValue3 = ((Integer) arrayList2.get(i9)).intValue();
            MaterialButton childButton2 = materialButtonGroup.getChildButton(intValue2);
            LinearLayout.LayoutParams buildLayoutParams2 = materialButtonGroup.buildLayoutParams(childButton2);
            int i10 = buildLayoutParams2.gravity & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
            int absoluteGravity = Gravity.getAbsoluteGravity(i10, materialButtonGroup.getLayoutDirection());
            int i11 = intValue - intValue3;
            if (i10 != 8388611) {
                if (absoluteGravity == 1) {
                    i11 /= 2;
                }
                buildLayoutParams2.setMarginStart((buildLayoutParams2.getMarginStart() + i11) - i8);
                childButton2.setLayoutParams(buildLayoutParams2);
                i8 = i11;
            }
            i9++;
            materialButtonGroup = this;
        }
        return i6 + i5 + getPaddingTop() + getPaddingBottom();
    }

    private int measureAndGetChildButtonSize(boolean z, Button button, int i, int i2) {
        int i3;
        int i4;
        measureChild(button, i, i2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button.getLayoutParams();
        int measuredWidth = z ? button.getMeasuredWidth() : button.getMeasuredHeight();
        if (z) {
            i3 = layoutParams.leftMargin;
            i4 = layoutParams.rightMargin;
        } else {
            i3 = layoutParams.topMargin;
            i4 = layoutParams.bottomMargin;
        }
        int i5 = i3 + i4;
        if (measuredWidth == 0) {
            measuredWidth = z ? button.getMinimumWidth() : button.getMinimumHeight();
        }
        return measuredWidth + i5;
    }

    private void recoverAllChildrenLayoutParams() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildButton(i).recoverOriginalLayoutParams();
        }
    }

    private void resetChildMargins(int i) {
        if (getChildCount() == 0 || i == -1) {
            return;
        }
        LinearLayout.LayoutParams buildLayoutParams = buildLayoutParams(getChildButton(i));
        if (getOrientation() == 1) {
            buildLayoutParams.topMargin = 0;
            buildLayoutParams.bottomMargin = 0;
        } else {
            buildLayoutParams.setMarginEnd(0);
            buildLayoutParams.setMarginStart(0);
            buildLayoutParams.leftMargin = 0;
            buildLayoutParams.rightMargin = 0;
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            materialButton.setId(View.generateViewId());
        }
    }

    private void updateChildOrder() {
        TreeMap treeMap = new TreeMap(this.childOrderComparator);
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            treeMap.put(getChildButton(i), Integer.valueOf(i));
        }
        this.childOrder = (Integer[]) treeMap.values().toArray(new Integer[0]);
    }

    private void updateOverflowMenuItemsState() {
        for (Map.Entry<Button, MenuItem> entry : this.buttonToMenuItemMapping.entrySet()) {
            Button key = entry.getKey();
            MenuItem value = entry.getValue();
            if (entry.getKey() instanceof MaterialButton) {
                MaterialButton materialButton = (MaterialButton) key;
                value.setCheckable(materialButton.isCheckable());
                value.setChecked(materialButton.isChecked());
            }
            value.setEnabled(key.isEnabled());
        }
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e(LOG_TAG, "Child views must be of type MaterialButton.");
            return;
        }
        recoverAllChildrenLayoutParams();
        this.childShapesDirty = true;
        int indexOfChild = indexOfChild(this.overflowButton);
        if (indexOfChild < 0 || i != -1) {
            super.addView(view, i, layoutParams);
        } else {
            super.addView(view, indexOfChild, layoutParams);
        }
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        materialButton.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        this.originalChildShapeAppearanceModels.add(materialButton.getShapeAppearance());
        materialButton.setEnabled(isEnabled());
    }

    LinearLayout.LayoutParams buildLayoutParams(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        return layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LayoutParams(layoutParams.width, layoutParams.height);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        updateChildOrder();
        super.dispatchDraw(canvas);
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
        return new LayoutParams(-2, -2);
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
        return layoutParams instanceof LinearLayout.LayoutParams ? new LayoutParams((LinearLayout.LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public StateListSizeChange getButtonSizeChange() {
        return this.buttonSizeChange;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public MaterialButton getChildButton(int i) {
        return (MaterialButton) getChildAt(i);
    }

    @Override // android.view.ViewGroup
    protected int getChildDrawingOrder(int i, int i2) {
        if (this.childOrder != null && i2 < this.childOrder.length) {
            return this.childOrder[i2].intValue();
        }
        Log.w(LOG_TAG, "Child order wasn't updated");
        return i2;
    }

    public ShapeAppearanceModel getChildOriginalShapeAppearanceModel(int i) {
        return this.originalChildShapeAppearanceModels.get(i).getDefaultShape();
    }

    public CornerSize getInnerCornerSize() {
        return this.innerCornerSize.getDefaultCornerSize();
    }

    public StateListCornerSize getInnerCornerSizeStateList() {
        return this.innerCornerSize;
    }

    public Drawable getOverflowButtonIcon() {
        return this.overflowButton.getIcon();
    }

    public int getOverflowMode() {
        return this.overflowMode;
    }

    public ShapeAppearanceModel getShapeAppearance() {
        if (this.groupStateListShapeAppearance == null) {
            return null;
        }
        return this.groupStateListShapeAppearance.getDefaultShape(true);
    }

    public int getSpacing() {
        return this.spacing;
    }

    public StateListShapeAppearanceModel getStateListShapeAppearance() {
        return this.groupStateListShapeAppearance;
    }

    void initializeButtonOverflow(Context context, TypedArray typedArray) {
        Drawable drawable = typedArray.getDrawable(R.styleable.MaterialButtonGroup_overflowButtonIcon);
        this.overflowButton = (MaterialButton) LayoutInflater.from(context).inflate(R.layout.m3_button_group_overflow_button, (ViewGroup) this, false);
        this.overflowButton.setTag(OVERFLOW_BUTTON_TAG);
        setOverflowButtonIcon(drawable);
        if (this.overflowButton.getContentDescription() == null) {
            this.overflowButton.setContentDescription(getResources().getString(R.string.mtrl_button_overflow_icon_content_description));
        }
        this.overflowButton.setVisibility(8);
        int resolveOrThrow = MaterialAttributes.resolveOrThrow(this, R.attr.materialButtonGroupPopupMenuStyle);
        int i = Build.VERSION.SDK_INT;
        this.popupMenu = new PopupMenu(getContext(), this.overflowButton, 17, 0, resolveOrThrow);
        this.popupMenu.setForceShowIcon(true);
        this.overflowButton.setOnClickListener(new MaterialButtonGroup$$ExternalSyntheticLambda0(this));
        addView(this.overflowButton);
        this.buttonOverflowInitialized = true;
    }

    boolean isOverflowMenuSupported() {
        return true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$initializeButtonOverflow$1$com-google-android-material-button-MaterialButtonGroup, reason: not valid java name */
    public /* synthetic */ void m328x38fdbfa1(View view) {
        updateOverflowMenuItemsState();
        this.popupMenu.show();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: lambda$new$0$com-google-android-material-button-MaterialButtonGroup, reason: not valid java name */
    public /* synthetic */ int m329xa7af0300(MaterialButton materialButton, MaterialButton materialButton2) {
        int compareTo = Boolean.valueOf(materialButton.isChecked()).compareTo(Boolean.valueOf(materialButton2.isChecked()));
        if (compareTo != 0) {
            return compareTo;
        }
        int compareTo2 = Boolean.valueOf(materialButton.isPressed()).compareTo(Boolean.valueOf(materialButton2.isPressed()));
        return compareTo2 != 0 ? compareTo2 : Integer.compare(indexOfChild(materialButton), indexOfChild(materialButton2));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void onButtonWidthChanged(MaterialButton materialButton, int i) {
        int indexOfChild = indexOfChild(materialButton);
        if (indexOfChild < 0) {
            return;
        }
        MaterialButton prevVisibleChildButton = getPrevVisibleChildButton(indexOfChild, true);
        MaterialButton nextVisibleChildButton = getNextVisibleChildButton(indexOfChild, true);
        if (prevVisibleChildButton == null && nextVisibleChildButton == null) {
            return;
        }
        if (prevVisibleChildButton == null) {
            nextVisibleChildButton.setDisplayedWidthDecrease(i);
        }
        if (nextVisibleChildButton == null) {
            prevVisibleChildButton.setDisplayedWidthDecrease(i);
        }
        if (prevVisibleChildButton == null || nextVisibleChildButton == null) {
            return;
        }
        prevVisibleChildButton.setDisplayedWidthDecrease(i / 2);
        nextVisibleChildButton.setDisplayedWidthDecrease((i + 1) / 2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (z) {
            recoverAllChildrenLayoutParams();
            adjustChildSizeChange();
        }
    }

    @Override // android.widget.LinearLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        adjustChildMarginsAndUpdateLayout();
        int i3 = 0;
        if (this.overflowMode == 2) {
            if (getOrientation() == 1) {
                throw new IllegalArgumentException("The wrap overflow mode is not compatible to the vertical orientation.");
            }
            if (View.MeasureSpec.getMode(i) == Integer.MIN_VALUE) {
                throw new IllegalArgumentException("The wrap overflow mode is not compatible with wrap_content layout width.");
            }
            i3 = maybeWrapButtons(i, i2);
        }
        maybeUpdateOverflowMenu(i, i2);
        updateChildShapes();
        super.onMeasure(i, i2);
        if (this.overflowMode != 2 || i3 == getMeasuredHeight()) {
            return;
        }
        setMeasuredDimension(getMeasuredWidth(), i3);
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            ((MaterialButton) view).setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.originalChildShapeAppearanceModels.remove(indexOfChild);
        }
        this.childShapesDirty = true;
        updateChildShapes();
        recoverAllChildrenLayoutParams();
        adjustChildMarginsAndUpdateLayout();
    }

    public void setButtonSizeChange(StateListSizeChange stateListSizeChange) {
        if (this.buttonSizeChange != stateListSizeChange) {
            this.buttonSizeChange = stateListSizeChange;
            adjustChildSizeChange();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public void setEnabled(boolean z) {
        super.setEnabled(z);
        for (int i = 0; i < getChildCount(); i++) {
            getChildButton(i).setEnabled(z);
        }
    }

    public void setInnerCornerSize(CornerSize cornerSize) {
        this.innerCornerSize = StateListCornerSize.create(cornerSize);
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    public void setInnerCornerSizeStateList(StateListCornerSize stateListCornerSize) {
        this.innerCornerSize = stateListCornerSize;
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (getOrientation() != i) {
            this.childShapesDirty = true;
        }
        super.setOrientation(i);
    }

    public void setOverflowButtonIcon(Drawable drawable) {
        this.overflowButton.setIcon(drawable);
    }

    public void setOverflowButtonIconResource(int i) {
        this.overflowButton.setIconResource(i);
    }

    public void setOverflowMode(int i) {
        if (this.overflowMode != i) {
            this.overflowMode = i;
            requestLayout();
            invalidate();
        }
    }

    public void setShapeAppearance(ShapeAppearanceModel shapeAppearanceModel) {
        this.groupStateListShapeAppearance = new StateListShapeAppearanceModel.Builder(shapeAppearanceModel).build();
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    public void setSpacing(int i) {
        this.spacing = i;
        invalidate();
        requestLayout();
    }

    public void setStateListShapeAppearance(StateListShapeAppearanceModel stateListShapeAppearanceModel) {
        this.groupStateListShapeAppearance = stateListShapeAppearanceModel;
        this.childShapesDirty = true;
        updateChildShapes();
        invalidate();
    }

    void updateChildShapes() {
        int i;
        if (!(this.innerCornerSize == null && this.groupStateListShapeAppearance == null) && this.childShapesDirty) {
            this.childShapesDirty = false;
            int childCount = getChildCount();
            int firstVisibleChildIndex = getFirstVisibleChildIndex();
            int lastVisibleChildIndex = getLastVisibleChildIndex();
            int i2 = 0;
            while (i2 < childCount) {
                MaterialButton childButton = getChildButton(i2);
                if (childButton.getVisibility() != 8) {
                    boolean z = i2 == firstVisibleChildIndex;
                    boolean z2 = i2 == lastVisibleChildIndex;
                    StateListShapeAppearanceModel.Builder originalStateListShapeBuilder = getOriginalStateListShapeBuilder(z, z2, i2);
                    boolean z3 = getOrientation() == 0;
                    boolean isLayoutRtl = ViewUtils.isLayoutRtl(this);
                    if (z3) {
                        i = z ? 0 | 5 : 0;
                        if (z2) {
                            i |= 10;
                        }
                        if (isLayoutRtl) {
                            i = StateListShapeAppearanceModel.swapCornerPositionRtl(i);
                        }
                    } else {
                        i = z ? 0 | 3 : 0;
                        if (z2) {
                            i |= 12;
                        }
                    }
                    StateListShapeAppearanceModel build = originalStateListShapeBuilder.setCornerSizeOverride(this.innerCornerSize, ~i).build();
                    childButton.setShapeAppearance(build.isStateful() ? build : build.getDefaultShape(true));
                }
                i2++;
            }
        }
    }
}
