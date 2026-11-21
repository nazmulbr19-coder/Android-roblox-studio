package androidx.constraintlayout.core.widgets;

import androidx.constraintlayout.core.LinearSystem;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;

/* loaded from: classes.dex */
public class Placeholder extends VirtualLayout {
    @Override // androidx.constraintlayout.core.widgets.ConstraintWidget
    public void addToSolver(LinearSystem linearSystem, boolean z) {
        super.addToSolver(linearSystem, z);
        if (this.mWidgetsCount > 0) {
            ConstraintWidget constraintWidget = this.mWidgets[0];
            constraintWidget.resetAllConstraints();
            constraintWidget.connect(ConstraintAnchor.Type.LEFT, this, ConstraintAnchor.Type.LEFT);
            constraintWidget.connect(ConstraintAnchor.Type.RIGHT, this, ConstraintAnchor.Type.RIGHT);
            constraintWidget.connect(ConstraintAnchor.Type.TOP, this, ConstraintAnchor.Type.TOP);
            constraintWidget.connect(ConstraintAnchor.Type.BOTTOM, this, ConstraintAnchor.Type.BOTTOM);
        }
    }

    @Override // androidx.constraintlayout.core.widgets.VirtualLayout
    public void measure(int i, int i2, int i3, int i4) {
        int paddingLeft = 0 + getPaddingLeft() + getPaddingRight();
        int paddingTop = 0 + getPaddingTop() + getPaddingBottom();
        if (this.mWidgetsCount > 0) {
            paddingLeft += this.mWidgets[0].getWidth();
            paddingTop += this.mWidgets[0].getHeight();
        }
        int max = Math.max(getMinWidth(), paddingLeft);
        int max2 = Math.max(getMinHeight(), paddingTop);
        int i5 = 0;
        int i6 = 0;
        if (i == 1073741824) {
            i5 = i2;
        } else if (i == Integer.MIN_VALUE) {
            i5 = Math.min(max, i2);
        } else if (i == 0) {
            i5 = max;
        }
        if (i3 == 1073741824) {
            i6 = i4;
        } else if (i3 == Integer.MIN_VALUE) {
            i6 = Math.min(max2, i4);
        } else if (i3 == 0) {
            i6 = max2;
        }
        setMeasure(i5, i6);
        setWidth(i5);
        setHeight(i6);
        needsCallbackFromSolver(this.mWidgetsCount > 0);
    }
}
