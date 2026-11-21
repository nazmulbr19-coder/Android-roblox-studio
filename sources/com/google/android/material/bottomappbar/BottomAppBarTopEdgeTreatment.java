package com.google.android.material.bottomappbar;

import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.ShapePath;

/* loaded from: classes.dex */
public class BottomAppBarTopEdgeTreatment extends EdgeTreatment implements Cloneable {
    private static final int ANGLE_LEFT = 180;
    private static final int ANGLE_UP = 270;
    private static final int ARC_HALF = 180;
    private static final int ARC_QUARTER = 90;
    private static final float ROUNDED_CORNER_FAB_OFFSET = 1.75f;
    private float cradleVerticalOffset;
    private float fabCornerSize = -1.0f;
    private float fabDiameter;
    private float fabMargin;
    private float horizontalOffset;
    private float roundedCornerRadius;

    public BottomAppBarTopEdgeTreatment(float f, float f2, float f3) {
        this.fabMargin = f;
        this.roundedCornerRadius = f2;
        setCradleVerticalOffset(f3);
        this.horizontalOffset = 0.0f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getCradleVerticalOffset() {
        return this.cradleVerticalOffset;
    }

    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        float f4;
        float f5;
        if (this.fabDiameter == 0.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f6 = ((this.fabMargin * 2.0f) + this.fabDiameter) / 2.0f;
        float f7 = f3 * this.roundedCornerRadius;
        float f8 = f2 + this.horizontalOffset;
        float f9 = (this.cradleVerticalOffset * f3) + ((1.0f - f3) * f6);
        if (f9 / f6 >= 1.0f) {
            shapePath.lineTo(f, 0.0f);
            return;
        }
        float f10 = this.fabCornerSize * f3;
        boolean z = this.fabCornerSize == -1.0f || Math.abs((this.fabCornerSize * 2.0f) - this.fabDiameter) < 0.1f;
        if (z) {
            f4 = f9;
            f5 = 0.0f;
        } else {
            f4 = 0.0f;
            f5 = 1.75f;
        }
        float f11 = f6 + f7;
        float f12 = f4 + f7;
        float sqrt = (float) Math.sqrt((f11 * f11) - (f12 * f12));
        float f13 = f8 - sqrt;
        float f14 = f8 + sqrt;
        float degrees = (float) Math.toDegrees(Math.atan(sqrt / f12));
        float f15 = (90.0f - degrees) + f5;
        shapePath.lineTo(f13, 0.0f);
        shapePath.addArc(f13 - f7, 0.0f, f13 + f7, f7 * 2.0f, 270.0f, degrees);
        if (z) {
            shapePath.addArc(f8 - f6, (-f6) - f4, f8 + f6, f6 - f4, 180.0f - f15, (f15 * 2.0f) - 180.0f);
        } else {
            shapePath.addArc(f8 - f6, -(f10 + this.fabMargin), (f8 - f6) + this.fabMargin + (f10 * 2.0f), this.fabMargin + f10, 180.0f - f15, ((f15 * 2.0f) - 180.0f) / 2.0f);
            shapePath.lineTo((f8 + f6) - (f10 + (this.fabMargin / 2.0f)), f10 + this.fabMargin);
            shapePath.addArc((f8 + f6) - ((f10 * 2.0f) + this.fabMargin), -(f10 + this.fabMargin), f8 + f6, this.fabMargin + f10, 90.0f, f15 - 90.0f);
        }
        shapePath.addArc(f14 - f7, 0.0f, f14 + f7, f7 * 2.0f, 270.0f - degrees, degrees);
        shapePath.lineTo(f, 0.0f);
    }

    public float getFabCornerRadius() {
        return this.fabCornerSize;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFabCradleMargin() {
        return this.fabMargin;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFabCradleRoundedCornerRadius() {
        return this.roundedCornerRadius;
    }

    public float getFabDiameter() {
        return this.fabDiameter;
    }

    public float getHorizontalOffset() {
        return this.horizontalOffset;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setCradleVerticalOffset(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException("cradleVerticalOffset must be positive.");
        }
        this.cradleVerticalOffset = f;
    }

    public void setFabCornerSize(float f) {
        this.fabCornerSize = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFabCradleMargin(float f) {
        this.fabMargin = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFabCradleRoundedCornerRadius(float f) {
        this.roundedCornerRadius = f;
    }

    public void setFabDiameter(float f) {
        this.fabDiameter = f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setHorizontalOffset(float f) {
        this.horizontalOffset = f;
    }
}
